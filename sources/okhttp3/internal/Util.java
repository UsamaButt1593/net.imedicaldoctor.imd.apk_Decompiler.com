package okhttp3.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class Util {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f30970a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f30971b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final ResponseBody f30972c;

    /* renamed from: d  reason: collision with root package name */
    public static final RequestBody f30973d;

    /* renamed from: e  reason: collision with root package name */
    private static final ByteString f30974e = ByteString.k("efbbbf");

    /* renamed from: f  reason: collision with root package name */
    private static final ByteString f30975f = ByteString.k("feff");

    /* renamed from: g  reason: collision with root package name */
    private static final ByteString f30976g = ByteString.k("fffe");

    /* renamed from: h  reason: collision with root package name */
    private static final ByteString f30977h = ByteString.k("0000ffff");

    /* renamed from: i  reason: collision with root package name */
    private static final ByteString f30978i = ByteString.k("ffff0000");

    /* renamed from: j  reason: collision with root package name */
    public static final Charset f30979j = Charset.forName("UTF-8");

    /* renamed from: k  reason: collision with root package name */
    public static final Charset f30980k = Charset.forName("ISO-8859-1");

    /* renamed from: l  reason: collision with root package name */
    private static final Charset f30981l = Charset.forName("UTF-16BE");

    /* renamed from: m  reason: collision with root package name */
    private static final Charset f30982m = Charset.forName("UTF-16LE");

    /* renamed from: n  reason: collision with root package name */
    private static final Charset f30983n = Charset.forName("UTF-32BE");
    private static final Charset o = Charset.forName("UTF-32LE");
    public static final TimeZone p = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> q = new Comparator<String>() {
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    private static final Method r;
    private static final Pattern s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        Class<Throwable> cls = Throwable.class;
        byte[] bArr = new byte[0];
        f30970a = bArr;
        Method method = null;
        f30972c = ResponseBody.p((MediaType) null, bArr);
        f30973d = RequestBody.f((MediaType) null, bArr);
        try {
            method = cls.getDeclaredMethod("addSuppressed", new Class[]{cls});
        } catch (Exception unused) {
        }
        r = method;
    }

    private Util() {
    }

    public static String[] A(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean B(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean C(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String compare : strArr2) {
                    if (comparator.compare(str, compare) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static X509TrustManager D() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw b("No System TLS", e2);
        }
    }

    public static boolean E(Source source, int i2, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long d2 = source.j().f() ? source.j().d() - nanoTime : Long.MAX_VALUE;
        source.j().e(Math.min(d2, timeUnit.toNanos((long) i2)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.n2(buffer, PlaybackStateCompat.s3) != -1) {
                buffer.d();
            }
            int i3 = (d2 > Long.MAX_VALUE ? 1 : (d2 == Long.MAX_VALUE ? 0 : -1));
            Timeout j2 = source.j();
            if (i3 == 0) {
                j2.a();
                return true;
            }
            j2.e(nanoTime + d2);
            return true;
        } catch (InterruptedIOException unused) {
            int i4 = (d2 > Long.MAX_VALUE ? 1 : (d2 == Long.MAX_VALUE ? 0 : -1));
            Timeout j3 = source.j();
            if (i4 == 0) {
                j3.a();
                return false;
            }
            j3.e(nanoTime + d2);
            return false;
        } catch (Throwable th) {
            int i5 = (d2 > Long.MAX_VALUE ? 1 : (d2 == Long.MAX_VALUE ? 0 : -1));
            Timeout j4 = source.j();
            if (i5 == 0) {
                j4.a();
            } else {
                j4.e(nanoTime + d2);
            }
            throw th;
        }
    }

    public static int F(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int G(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char charAt = str.charAt(i4);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static ThreadFactory H(final String str, final boolean z) {
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static Headers I(List<Header> list) {
        Headers.Builder builder = new Headers.Builder();
        for (Header next : list) {
            Internal.f30969a.b(builder, next.f31127a.I0(), next.f31128b.I0());
        }
        return builder.h();
    }

    public static String J(String str, int i2, int i3) {
        int F = F(str, i2, i3);
        return str.substring(F, G(str, F, i3));
    }

    public static boolean K(String str) {
        return s.matcher(str).matches();
    }

    public static void a(Throwable th, Throwable th2) {
        Method method = r;
        if (method != null) {
            try {
                method.invoke(th, new Object[]{th2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static AssertionError b(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static Charset c(BufferedSource bufferedSource, Charset charset) throws IOException {
        ByteString byteString = f30974e;
        if (bufferedSource.b1(0, byteString)) {
            bufferedSource.skip((long) byteString.m0());
            return f30979j;
        }
        ByteString byteString2 = f30975f;
        if (bufferedSource.b1(0, byteString2)) {
            bufferedSource.skip((long) byteString2.m0());
            return f30981l;
        }
        ByteString byteString3 = f30976g;
        if (bufferedSource.b1(0, byteString3)) {
            bufferedSource.skip((long) byteString3.m0());
            return f30982m;
        }
        ByteString byteString4 = f30977h;
        if (bufferedSource.b1(0, byteString4)) {
            bufferedSource.skip((long) byteString4.m0());
            return f30983n;
        }
        ByteString byteString5 = f30978i;
        if (!bufferedSource.b1(0, byteString5)) {
            return charset;
        }
        bufferedSource.skip((long) byteString5.m0());
        return o;
    }

    public static String d(String str) {
        if (str.contains(":")) {
            InetAddress n2 = (!str.startsWith("[") || !str.endsWith("]")) ? n(str, 0, str.length()) : n(str, 1, str.length() - 1);
            if (n2 == null) {
                return null;
            }
            byte[] address = n2.getAddress();
            if (address.length == 16) {
                return z(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !k(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static int e(String str, long j2, TimeUnit timeUnit) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j2);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            } else if (millis != 0 || i2 <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(str + " too small.");
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public static void f(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void h(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void i(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!B(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static String[] j(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[(length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    private static boolean k(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int l(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return c2 - 'W';
        }
        if (c2 < 'A' || c2 > 'F') {
            return -1;
        }
        return c2 - '7';
    }

    private static boolean m(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char charAt = str.charAt(i6);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i6++;
                }
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    @Nullable
    private static InetAddress n(String str, int i2, int i3) {
        byte[] bArr = new byte[16];
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i2 >= i3) {
                break;
            } else if (i4 == 16) {
                return null;
            } else {
                int i7 = i2 + 2;
                if (i7 > i3 || !str.regionMatches(i2, "::", 0, 2)) {
                    if (i4 != 0) {
                        if (str.regionMatches(i2, ":", 0, 1)) {
                            i2++;
                        } else if (!str.regionMatches(i2, ".", 0, 1) || !m(str, i6, i3, bArr, i4 - 2)) {
                            return null;
                        } else {
                            i4 += 2;
                        }
                    }
                    i6 = i2;
                } else if (i5 != -1) {
                    return null;
                } else {
                    i4 += 2;
                    i5 = i4;
                    if (i7 == i3) {
                        break;
                    }
                    i6 = i7;
                }
                i2 = i6;
                int i8 = 0;
                while (i2 < i3) {
                    int l2 = l(str.charAt(i2));
                    if (l2 == -1) {
                        break;
                    }
                    i8 = (i8 << 4) + l2;
                    i2++;
                }
                int i9 = i2 - i6;
                if (i9 == 0 || i9 > 4) {
                    return null;
                }
                int i10 = i4 + 1;
                bArr[i4] = (byte) ((i8 >>> 8) & 255);
                i4 += 2;
                bArr[i10] = (byte) (i8 & 255);
            }
        }
        if (i4 != 16) {
            if (i5 == -1) {
                return null;
            }
            int i11 = i4 - i5;
            System.arraycopy(bArr, i5, bArr, 16 - i11, i11);
            Arrays.fill(bArr, i5, (16 - i4) + i5, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static int o(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int p(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static boolean q(Source source, int i2, TimeUnit timeUnit) {
        try {
            return E(source, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean r(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static String s(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String t(HttpUrl httpUrl, boolean z) {
        String str;
        if (httpUrl.p().contains(":")) {
            str = "[" + httpUrl.p() + "]";
        } else {
            str = httpUrl.p();
        }
        if (!z && httpUrl.E() == HttpUrl.e(httpUrl.P())) {
            return str;
        }
        return str + ":" + httpUrl.E();
    }

    public static <T> List<T> u(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> v(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> w(Map<K, V> map) {
        return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static int x(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static int y(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    private static String z(byte[] bArr) {
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i2 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        Buffer buffer = new Buffer();
        while (i3 < bArr.length) {
            if (i3 == i2) {
                buffer.writeByte(58);
                i3 += i5;
                if (i3 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i3 > 0) {
                    buffer.writeByte(58);
                }
                buffer.z1((long) (((bArr[i3] & 255) << 8) | (bArr[i3 + 1] & 255)));
                i3 += 2;
            }
        }
        return buffer.a2();
    }
}
