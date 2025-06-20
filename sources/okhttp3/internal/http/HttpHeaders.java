package okhttp3.internal.http;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;

public final class HttpHeaders {

    /* renamed from: a  reason: collision with root package name */
    private static final ByteString f31077a = ByteString.n("\"\\");

    /* renamed from: b  reason: collision with root package name */
    private static final ByteString f31078b = ByteString.n("\t ,=");

    private HttpHeaders() {
    }

    public static long a(Headers headers) {
        return q(headers.d(com.google.common.net.HttpHeaders.f22874b));
    }

    public static long b(Response response) {
        return a(response.p());
    }

    public static boolean c(Response response) {
        if (response.A().g().equals("HEAD")) {
            return false;
        }
        int f2 = response.f();
        return (((f2 >= 100 && f2 < 200) || f2 == 204 || f2 == 304) && b(response) == -1 && !"chunked".equalsIgnoreCase(response.i(com.google.common.net.HttpHeaders.M0))) ? false : true;
    }

    public static boolean d(Headers headers) {
        return r(headers).contains("*");
    }

    public static boolean e(Response response) {
        return d(response.p());
    }

    private static void f(List<Challenge> list, Buffer buffer) {
        String j2;
        int m2;
        while (true) {
            String str = null;
            while (true) {
                if (str == null) {
                    p(buffer);
                    str = j(buffer);
                    if (str == null) {
                        return;
                    }
                }
                boolean p = p(buffer);
                j2 = j(buffer);
                if (j2 != null) {
                    m2 = m(buffer, (byte) 61);
                    boolean p2 = p(buffer);
                    if (p || (!p2 && !buffer.o0())) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        int m3 = m2 + m(buffer, (byte) 61);
                        while (true) {
                            if (j2 == null) {
                                j2 = j(buffer);
                                if (p(buffer)) {
                                    continue;
                                    break;
                                }
                                m3 = m(buffer, (byte) 61);
                            }
                            if (m3 == 0) {
                                continue;
                                break;
                            } else if (m3 <= 1 && !p(buffer)) {
                                String j3 = (buffer.o0() || buffer.y(0) != 34) ? j(buffer) : i(buffer);
                                if (j3 == null || ((String) linkedHashMap.put(j2, j3)) != null) {
                                    return;
                                }
                                if (p(buffer) || buffer.o0()) {
                                    j2 = null;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        list.add(new Challenge(str, (Map<String, String>) linkedHashMap));
                        str = j2;
                    }
                } else if (buffer.o0()) {
                    list.add(new Challenge(str, (Map<String, String>) Collections.emptyMap()));
                    return;
                } else {
                    return;
                }
            }
            list.add(new Challenge(str, (Map<String, String>) Collections.singletonMap((Object) null, j2 + l(ASCIIPropertyListParser.f18654l, m2))));
        }
    }

    public static List<Challenge> g(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < headers.l(); i2++) {
            if (str.equalsIgnoreCase(headers.g(i2))) {
                f(arrayList, new Buffer().W0(headers.n(i2)));
            }
        }
        return arrayList;
    }

    public static int h(String str, int i2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    private static String i(Buffer buffer) {
        if (buffer.readByte() == 34) {
            Buffer buffer2 = new Buffer();
            while (true) {
                long z0 = buffer.z0(f31077a);
                if (z0 == -1) {
                    return null;
                }
                if (buffer.y(z0) == 34) {
                    buffer2.u1(buffer, z0);
                    buffer.readByte();
                    return buffer2.a2();
                } else if (buffer.L0() == z0 + 1) {
                    return null;
                } else {
                    buffer2.u1(buffer, z0);
                    buffer.readByte();
                    buffer2.u1(buffer, 1);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static String j(Buffer buffer) {
        try {
            long z0 = buffer.z0(f31078b);
            if (z0 == -1) {
                z0 = buffer.L0();
            }
            if (z0 != 0) {
                return buffer.B(z0);
            }
            return null;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public static void k(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar != CookieJar.f30847a) {
            List<Cookie> k2 = Cookie.k(httpUrl, headers);
            if (!k2.isEmpty()) {
                cookieJar.a(httpUrl, k2);
            }
        }
    }

    private static String l(char c2, int i2) {
        char[] cArr = new char[i2];
        Arrays.fill(cArr, c2);
        return new String(cArr);
    }

    private static int m(Buffer buffer, byte b2) {
        int i2 = 0;
        while (!buffer.o0() && buffer.y(0) == b2) {
            i2++;
            buffer.readByte();
        }
        return i2;
    }

    public static int n(String str, int i2, String str2) {
        while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            i2++;
        }
        return i2;
    }

    public static int o(String str, int i2) {
        while (i2 < str.length() && ((r0 = str.charAt(i2)) == ' ' || r0 == 9)) {
            i2++;
        }
        return i2;
    }

    private static boolean p(Buffer buffer) {
        boolean z = false;
        while (!buffer.o0()) {
            byte y = buffer.y(0);
            if (y != 44) {
                if (y != 32 && y != 9) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z = true;
            }
        }
        return z;
    }

    private static long q(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static Set<String> r(Headers headers) {
        Set<String> emptySet = Collections.emptySet();
        int l2 = headers.l();
        for (int i2 = 0; i2 < l2; i2++) {
            if (com.google.common.net.HttpHeaders.N0.equalsIgnoreCase(headers.g(i2))) {
                String n2 = headers.n(i2);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : n2.split(",")) {
                    emptySet.add(trim.trim());
                }
            }
        }
        return emptySet;
    }

    private static Set<String> s(Response response) {
        return r(response.p());
    }

    public static Headers t(Headers headers, Headers headers2) {
        Set<String> r = r(headers2);
        if (r.isEmpty()) {
            return new Headers.Builder().h();
        }
        Headers.Builder builder = new Headers.Builder();
        int l2 = headers.l();
        for (int i2 = 0; i2 < l2; i2++) {
            String g2 = headers.g(i2);
            if (r.contains(g2)) {
                builder.b(g2, headers.n(i2));
            }
        }
        return builder.h();
    }

    public static Headers u(Response response) {
        return t(response.t().A().e(), response.p());
    }

    public static boolean v(Response response, Headers headers, Request request) {
        for (String next : s(response)) {
            if (!Util.r(headers.o(next), request.d(next))) {
                return false;
            }
        }
        return true;
    }
}
