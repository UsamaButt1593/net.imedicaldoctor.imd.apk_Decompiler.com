package com.google.common.net;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.CheckForNull;
import kotlin.UShort;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class InetAddresses {

    /* renamed from: a  reason: collision with root package name */
    private static final int f22895a = 4;

    /* renamed from: b  reason: collision with root package name */
    private static final int f22896b = 8;

    /* renamed from: c  reason: collision with root package name */
    private static final char f22897c = '.';

    /* renamed from: d  reason: collision with root package name */
    private static final char f22898d = ':';

    /* renamed from: e  reason: collision with root package name */
    private static final CharMatcher f22899e = CharMatcher.q('.');

    /* renamed from: f  reason: collision with root package name */
    private static final CharMatcher f22900f = CharMatcher.q(':');

    /* renamed from: g  reason: collision with root package name */
    private static final Inet4Address f22901g = ((Inet4Address) g("127.0.0.1"));
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final Inet4Address f22902h = ((Inet4Address) g("0.0.0.0"));

    public static final class TeredoInfo {

        /* renamed from: a  reason: collision with root package name */
        private final Inet4Address f22903a;

        /* renamed from: b  reason: collision with root package name */
        private final Inet4Address f22904b;

        /* renamed from: c  reason: collision with root package name */
        private final int f22905c;

        /* renamed from: d  reason: collision with root package name */
        private final int f22906d;

        public TeredoInfo(@CheckForNull Inet4Address inet4Address, @CheckForNull Inet4Address inet4Address2, int i2, int i3) {
            boolean z = false;
            Preconditions.k(i2 >= 0 && i2 <= 65535, "port '%s' is out of range (0 <= port <= 0xffff)", i2);
            if (i3 >= 0 && i3 <= 65535) {
                z = true;
            }
            Preconditions.k(z, "flags '%s' is out of range (0 <= flags <= 0xffff)", i3);
            this.f22903a = (Inet4Address) MoreObjects.a(inet4Address, InetAddresses.f22902h);
            this.f22904b = (Inet4Address) MoreObjects.a(inet4Address2, InetAddresses.f22902h);
            this.f22905c = i2;
            this.f22906d = i3;
        }

        public Inet4Address a() {
            return this.f22904b;
        }

        public int b() {
            return this.f22906d;
        }

        public int c() {
            return this.f22905c;
        }

        public Inet4Address d() {
            return this.f22903a;
        }
    }

    private InetAddresses() {
    }

    public static boolean A(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r3 = r3[15];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean B(java.net.Inet6Address r3) {
        /*
            boolean r0 = r3.isIPv4CompatibleAddress()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            byte[] r3 = r3.getAddress()
            r0 = 12
            byte r0 = r3[r0]
            r2 = 1
            if (r0 != 0) goto L_0x0028
            r0 = 13
            byte r0 = r3[r0]
            if (r0 != 0) goto L_0x0028
            r0 = 14
            byte r0 = r3[r0]
            if (r0 != 0) goto L_0x0028
            r0 = 15
            byte r3 = r3[r0]
            if (r3 == 0) goto L_0x0027
            if (r3 != r2) goto L_0x0028
        L_0x0027:
            return r1
        L_0x0028:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.net.InetAddresses.B(java.net.Inet6Address):boolean");
    }

    public static boolean C(String str) {
        return z(str) != null;
    }

    public static boolean D(Inet6Address inet6Address) {
        if (G(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        return (address[8] | 3) == 3 && address[9] == 0 && address[10] == 94 && address[11] == -2;
    }

    public static boolean E(String str) {
        byte[] z = z(str);
        if (z == null || z.length != 16) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= 10) {
                for (int i3 = 10; i3 < 12; i3++) {
                    if (z[i3] != -1) {
                        return false;
                    }
                }
                return true;
            } else if (z[i2] != 0) {
                return false;
            } else {
                i2++;
            }
        }
    }

    public static boolean F(InetAddress inetAddress) {
        for (byte b2 : inetAddress.getAddress()) {
            if (b2 != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean G(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        return address[0] == 32 && address[1] == 1 && address[2] == 0 && address[3] == 0;
    }

    public static boolean H(String str) {
        return i(str) != null;
    }

    private static short I(String str, int i2, int i3) {
        int i4 = i3 - i2;
        if (i4 <= 0 || i4 > 4) {
            throw new NumberFormatException();
        }
        int i5 = 0;
        while (i2 < i3) {
            i5 = (i5 << 4) | Character.digit(str.charAt(i2), 16);
            i2++;
        }
        return (short) i5;
    }

    private static byte J(String str, int i2, int i3) {
        int i4 = i3 - i2;
        if (i4 <= 0 || i4 > 3) {
            throw new NumberFormatException();
        } else if (i4 <= 1 || str.charAt(i2) != '0') {
            int i5 = 0;
            while (i2 < i3) {
                int i6 = i5 * 10;
                int digit = Character.digit(str.charAt(i2), 10);
                if (digit >= 0) {
                    i5 = i6 + digit;
                    i2++;
                } else {
                    throw new NumberFormatException();
                }
            }
            if (i5 <= 255) {
                return (byte) i5;
            }
            throw new NumberFormatException();
        } else {
            throw new NumberFormatException();
        }
    }

    @CheckForNull
    private static byte[] K(String str) {
        if (f22899e.i(str) + 1 != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 4) {
            int indexOf = str.indexOf(46, i3);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            try {
                bArr[i2] = J(str, i3, indexOf);
                i3 = indexOf + 1;
                i2++;
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return bArr;
    }

    @CheckForNull
    private static byte[] L(String str) {
        int i2 = f22900f.i(str);
        if (i2 >= 2 && i2 <= 8) {
            int i3 = 1;
            int i4 = i2 + 1;
            int i5 = 8 - i4;
            boolean z = false;
            for (int i6 = 0; i6 < str.length() - 1; i6++) {
                if (str.charAt(i6) == ':' && str.charAt(i6 + 1) == ':') {
                    if (z) {
                        return null;
                    }
                    int i7 = i5 + 1;
                    if (i6 == 0) {
                        i7 = i5 + 2;
                    }
                    if (i6 == str.length() - 2) {
                        i7++;
                    }
                    i5 = i7;
                    z = true;
                }
            }
            if (str.charAt(0) == ':' && str.charAt(1) != ':') {
                return null;
            }
            if (str.charAt(str.length() - 1) == ':' && str.charAt(str.length() - 2) != ':') {
                return null;
            }
            if (z && i5 <= 0) {
                return null;
            }
            if (!z && i4 != 8) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(16);
            try {
                if (str.charAt(0) != ':') {
                    i3 = 0;
                }
                while (i3 < str.length()) {
                    int indexOf = str.indexOf(58, i3);
                    if (indexOf == -1) {
                        indexOf = str.length();
                    }
                    if (str.charAt(i3) == ':') {
                        for (int i8 = 0; i8 < i5; i8++) {
                            allocate.putShort(0);
                        }
                    } else {
                        allocate.putShort(I(str, i3, indexOf));
                    }
                    i3 = indexOf + 1;
                }
                return allocate.array();
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static String M(InetAddress inetAddress) {
        Preconditions.E(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        Preconditions.d(inetAddress instanceof Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = i2 * 2;
            iArr[i2] = Ints.k((byte) 0, (byte) 0, address[i3], address[i3 + 1]);
        }
        d(iArr);
        return x(iArr);
    }

    public static BigInteger N(InetAddress inetAddress) {
        return new BigInteger(1, inetAddress.getAddress());
    }

    public static String O(InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet6Address)) {
            return M(inetAddress);
        }
        return "[" + M(inetAddress) + "]";
    }

    private static InetAddress b(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e2) {
            throw new AssertionError(e2);
        }
    }

    public static int c(InetAddress inetAddress) {
        return ByteStreams.h(q(inetAddress).getAddress()).readInt();
    }

    private static void d(int[] iArr) {
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < iArr.length + 1; i5++) {
            if (i5 >= iArr.length || iArr[i5] != 0) {
                if (i4 >= 0) {
                    int i6 = i5 - i4;
                    if (i6 > i2) {
                        i3 = i4;
                        i2 = i6;
                    }
                    i4 = -1;
                }
            } else if (i4 < 0) {
                i4 = i5;
            }
        }
        if (i2 >= 2) {
            Arrays.fill(iArr, i3, i2 + i3, -1);
        }
    }

    @CheckForNull
    private static String e(String str) {
        int lastIndexOf = str.lastIndexOf(58) + 1;
        String substring = str.substring(0, lastIndexOf);
        byte[] K = K(str.substring(lastIndexOf));
        if (K == null) {
            return null;
        }
        String hexString = Integer.toHexString(((K[0] & 255) << 8) | (K[1] & 255));
        String hexString2 = Integer.toHexString((K[3] & 255) | ((K[2] & 255) << 8));
        return substring + hexString + ":" + hexString2;
    }

    public static InetAddress f(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (length >= 0 && address[length] == 0) {
            address[length] = -1;
            length--;
        }
        Preconditions.u(length >= 0, "Decrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] - 1);
        return b(address);
    }

    @CanIgnoreReturnValue
    public static InetAddress g(String str) {
        byte[] z = z(str);
        if (z != null) {
            return b(z);
        }
        throw j("'%s' is not an IP string literal.", str);
    }

    public static InetAddress h(String str) {
        InetAddress i2 = i(str);
        if (i2 != null) {
            return i2;
        }
        throw j("Not a valid URI IP literal: '%s'", str);
    }

    @CheckForNull
    private static InetAddress i(String str) {
        int i2;
        Preconditions.E(str);
        if (!str.startsWith("[") || !str.endsWith("]")) {
            i2 = 4;
        } else {
            str = str.substring(1, str.length() - 1);
            i2 = 16;
        }
        byte[] z = z(str);
        if (z == null || z.length != i2) {
            return null;
        }
        return b(z);
    }

    private static IllegalArgumentException j(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }

    private static InetAddress k(BigInteger bigInteger, boolean z) {
        Preconditions.e(bigInteger.signum() >= 0, "BigInteger must be greater than or equal to 0");
        int i2 = z ? 16 : 4;
        byte[] byteArray = bigInteger.toByteArray();
        byte[] bArr = new byte[i2];
        int max = Math.max(0, byteArray.length - i2);
        int length = byteArray.length - max;
        int i3 = i2 - length;
        int i4 = 0;
        while (i4 < max) {
            if (byteArray[i4] == 0) {
                i4++;
            } else {
                throw j("BigInteger cannot be converted to InetAddress because it has more than %d bytes: %s", Integer.valueOf(i2), bigInteger);
            }
        }
        System.arraycopy(byteArray, max, bArr, i3, length);
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e2) {
            throw new AssertionError(e2);
        }
    }

    public static Inet4Address l(BigInteger bigInteger) {
        return (Inet4Address) k(bigInteger, false);
    }

    public static Inet6Address m(BigInteger bigInteger) {
        return (Inet6Address) k(bigInteger, true);
    }

    public static Inet4Address n(int i2) {
        return t(Ints.E(i2));
    }

    public static InetAddress o(byte[] bArr) throws UnknownHostException {
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = bArr[(bArr.length - i2) - 1];
        }
        return InetAddress.getByAddress(bArr2);
    }

    public static Inet4Address p(Inet6Address inet6Address) {
        Preconditions.u(A(inet6Address), "Address '%s' is not a 6to4 address.", M(inet6Address));
        return t(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static Inet4Address q(InetAddress inetAddress) {
        boolean z;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i2 = 0;
        while (true) {
            if (i2 >= 15) {
                z = true;
                break;
            } else if (address[i2] != 0) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z && address[15] == 1) {
            return f22901g;
        }
        if (z && address[15] == 0) {
            return f22902h;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        int b2 = Hashing.B().i(w(inet6Address) ? (long) s(inet6Address).hashCode() : ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong()).b() | -536870912;
        if (b2 == -1) {
            b2 = -2;
        }
        return t(Ints.E(b2));
    }

    public static Inet4Address r(Inet6Address inet6Address) {
        Preconditions.u(B(inet6Address), "Address '%s' is not IPv4-compatible.", M(inet6Address));
        return t(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static Inet4Address s(Inet6Address inet6Address) {
        if (B(inet6Address)) {
            return r(inet6Address);
        }
        if (A(inet6Address)) {
            return p(inet6Address);
        }
        if (G(inet6Address)) {
            return v(inet6Address).a();
        }
        throw j("'%s' has no embedded IPv4 address.", M(inet6Address));
    }

    private static Inet4Address t(byte[] bArr) {
        Preconditions.k(bArr.length == 4, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (Inet4Address) b(bArr);
    }

    public static Inet4Address u(Inet6Address inet6Address) {
        Preconditions.u(D(inet6Address), "Address '%s' is not an ISATAP address.", M(inet6Address));
        return t(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static TeredoInfo v(Inet6Address inet6Address) {
        Preconditions.u(G(inet6Address), "Address '%s' is not a Teredo address.", M(inet6Address));
        byte[] address = inet6Address.getAddress();
        Inet4Address t = t(Arrays.copyOfRange(address, 4, 8));
        short readShort = ByteStreams.i(address, 8).readShort() & UShort.Z;
        int i2 = 65535 & (~ByteStreams.i(address, 10).readShort());
        byte[] copyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i3 = 0; i3 < copyOfRange.length; i3++) {
            copyOfRange[i3] = (byte) (~copyOfRange[i3]);
        }
        return new TeredoInfo(t, t(copyOfRange), i2, readShort);
    }

    public static boolean w(Inet6Address inet6Address) {
        return B(inet6Address) || A(inet6Address) || G(inet6Address);
    }

    private static String x(int[] iArr) {
        String str;
        StringBuilder sb = new StringBuilder(39);
        int i2 = 0;
        boolean z = false;
        while (i2 < iArr.length) {
            boolean z2 = iArr[i2] >= 0;
            if (z2) {
                if (z) {
                    sb.append(':');
                }
                str = Integer.toHexString(iArr[i2]);
            } else if (i2 == 0 || z) {
                str = "::";
            } else {
                i2++;
                z = z2;
            }
            sb.append(str);
            i2++;
            z = z2;
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.net.InetAddress y(java.net.InetAddress r6) {
        /*
            byte[] r0 = r6.getAddress()
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
        L_0x0007:
            r3 = 0
            if (r1 < 0) goto L_0x0014
            byte r4 = r0[r1]
            r5 = -1
            if (r4 != r5) goto L_0x0014
            r0[r1] = r3
            int r1 = r1 + -1
            goto L_0x0007
        L_0x0014:
            if (r1 < 0) goto L_0x0017
            r3 = 1
        L_0x0017:
            java.lang.String r4 = "Incrementing %s would wrap."
            com.google.common.base.Preconditions.u(r3, r4, r6)
            byte r6 = r0[r1]
            int r6 = r6 + r2
            byte r6 = (byte) r6
            r0[r1] = r6
            java.net.InetAddress r6 = b(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.net.InetAddresses.y(java.net.InetAddress):java.net.InetAddress");
    }

    @CheckForNull
    private static byte[] z(String str) {
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (i2 >= str.length()) {
                i2 = -1;
                break;
            }
            char charAt = str.charAt(i2);
            if (charAt == '.') {
                z = true;
            } else if (charAt == ':') {
                if (z) {
                    return null;
                }
                z2 = true;
            } else if (charAt == '%') {
                break;
            } else if (Character.digit(charAt, 16) == -1) {
                return null;
            }
            i2++;
        }
        if (z2) {
            if (z && (str = e(str)) == null) {
                return null;
            }
            if (i2 != -1) {
                str = str.substring(0, i2);
            }
            return L(str);
        } else if (!z || i2 != -1) {
            return null;
        } else {
            return K(str);
        }
    }
}
