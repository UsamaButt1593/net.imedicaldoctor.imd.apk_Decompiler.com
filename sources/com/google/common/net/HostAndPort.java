package com.google.common.net;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible
@Immutable
@ElementTypesAreNonnullByDefault
public final class HostAndPort implements Serializable {
    private static final long X2 = 0;
    private static final int Z = -1;
    private final int X;
    private final boolean Y;
    private final String s;

    private HostAndPort(String str, int i2, boolean z) {
        this.s = str;
        this.X = i2;
        this.Y = z;
    }

    public static HostAndPort a(String str) {
        HostAndPort c2 = c(str);
        Preconditions.u(!c2.h(), "Host has a port: %s", str);
        return c2;
    }

    public static HostAndPort b(String str, int i2) {
        Preconditions.k(i(i2), "Port out of range: %s", i2);
        HostAndPort c2 = c(str);
        Preconditions.u(!c2.h(), "Host has a port: %s", str);
        return new HostAndPort(c2.s, i2, c2.Y);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.common.net.HostAndPort c(java.lang.String r8) {
        /*
            com.google.common.base.Preconditions.E(r8)
            java.lang.String r0 = "["
            boolean r0 = r8.startsWith(r0)
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0019
            java.lang.String[] r0 = e(r8)
            r4 = r0[r3]
            r0 = r0[r2]
        L_0x0016:
            r5 = r4
            r4 = 0
            goto L_0x003c
        L_0x0019:
            r0 = 58
            int r4 = r8.indexOf(r0)
            if (r4 < 0) goto L_0x0032
            int r5 = r4 + 1
            int r0 = r8.indexOf(r0, r5)
            if (r0 != r1) goto L_0x0032
            java.lang.String r4 = r8.substring(r3, r4)
            java.lang.String r0 = r8.substring(r5)
            goto L_0x0016
        L_0x0032:
            if (r4 < 0) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x0036:
            r0 = 0
        L_0x0037:
            r4 = 0
            r5 = r8
            r7 = r4
            r4 = r0
            r0 = r7
        L_0x003c:
            boolean r6 = com.google.common.base.Strings.d(r0)
            if (r6 != 0) goto L_0x0080
            java.lang.String r1 = "+"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x0055
            com.google.common.base.CharMatcher r1 = com.google.common.base.CharMatcher.f()
            boolean r1 = r1.C(r0)
            if (r1 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r2 = 0
        L_0x0056:
            java.lang.String r1 = "Unparseable port number: %s"
            com.google.common.base.Preconditions.u(r2, r1, r8)
            int r1 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0069 }
            boolean r0 = i(r1)
            java.lang.String r2 = "Port number out of range: %s"
            com.google.common.base.Preconditions.u(r0, r2, r8)
            goto L_0x0080
        L_0x0069:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unparseable port number: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L_0x0080:
            com.google.common.net.HostAndPort r8 = new com.google.common.net.HostAndPort
            r8.<init>(r5, r1, r4)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.net.HostAndPort.c(java.lang.String):com.google.common.net.HostAndPort");
    }

    private static String[] e(String str) {
        String substring;
        boolean z = false;
        Preconditions.u(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", str);
        int indexOf = str.indexOf(58);
        int lastIndexOf = str.lastIndexOf(93);
        Preconditions.u(indexOf > -1 && lastIndexOf > indexOf, "Invalid bracketed host/port: %s", str);
        String substring2 = str.substring(1, lastIndexOf);
        int i2 = lastIndexOf + 1;
        if (i2 == str.length()) {
            substring = "";
        } else {
            if (str.charAt(i2) == ':') {
                z = true;
            }
            Preconditions.u(z, "Only a colon may follow a close bracket: %s", str);
            int i3 = lastIndexOf + 2;
            for (int i4 = i3; i4 < str.length(); i4++) {
                Preconditions.u(Character.isDigit(str.charAt(i4)), "Port must be numeric: %s", str);
            }
            substring = str.substring(i3);
        }
        return new String[]{substring2, substring};
    }

    private static boolean i(int i2) {
        return i2 >= 0 && i2 <= 65535;
    }

    public String d() {
        return this.s;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hostAndPort = (HostAndPort) obj;
        return Objects.a(this.s, hostAndPort.s) && this.X == hostAndPort.X;
    }

    public int f() {
        Preconditions.g0(h());
        return this.X;
    }

    public int g(int i2) {
        return h() ? this.X : i2;
    }

    public boolean h() {
        return this.X >= 0;
    }

    public int hashCode() {
        return Objects.b(this.s, Integer.valueOf(this.X));
    }

    @CanIgnoreReturnValue
    public HostAndPort j() {
        Preconditions.u(!this.Y, "Possible bracketless IPv6 literal: %s", this.s);
        return this;
    }

    public HostAndPort k(int i2) {
        Preconditions.d(i(i2));
        return h() ? this : new HostAndPort(this.s, i2, this.Y);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.s.length() + 8);
        if (this.s.indexOf(58) >= 0) {
            sb.append('[');
            sb.append(this.s);
            sb.append(']');
        } else {
            sb.append(this.s);
        }
        if (h()) {
            sb.append(ASCIIPropertyListParser.A);
            sb.append(this.X);
        }
        return sb.toString();
    }
}
