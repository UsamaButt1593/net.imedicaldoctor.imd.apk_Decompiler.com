package okhttp3.internal.tls;

import androidx.media3.extractor.ts.PsExtractor;
import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser {

    /* renamed from: a  reason: collision with root package name */
    private final String f31269a;

    /* renamed from: b  reason: collision with root package name */
    private final int f31270b;

    /* renamed from: c  reason: collision with root package name */
    private int f31271c;

    /* renamed from: d  reason: collision with root package name */
    private int f31272d;

    /* renamed from: e  reason: collision with root package name */
    private int f31273e;

    /* renamed from: f  reason: collision with root package name */
    private int f31274f;

    /* renamed from: g  reason: collision with root package name */
    private char[] f31275g;

    DistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f31269a = name;
        this.f31270b = name.length();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        r2 = r8.f31272d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        return new java.lang.String(r1, r2, r8.f31273e - r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f31271c
            r8.f31272d = r0
            r8.f31273e = r0
        L_0x0006:
            int r0 = r8.f31271c
            int r1 = r8.f31270b
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f31275g
            int r2 = r8.f31272d
            int r3 = r8.f31273e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0019:
            char[] r1 = r8.f31275g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L_0x0058
            if (r2 == r5) goto L_0x004d
            r5 = 92
            if (r2 == r5) goto L_0x003e
            if (r2 == r4) goto L_0x004d
            if (r2 == r3) goto L_0x004d
            int r3 = r8.f31273e
            int r4 = r3 + 1
            r8.f31273e = r4
            r1[r3] = r2
        L_0x0039:
            int r0 = r0 + 1
            r8.f31271c = r0
            goto L_0x0006
        L_0x003e:
            int r0 = r8.f31273e
            int r2 = r0 + 1
            r8.f31273e = r2
            char r2 = r8.d()
            r1[r0] = r2
            int r0 = r8.f31271c
            goto L_0x0039
        L_0x004d:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f31272d
            int r3 = r8.f31273e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0058:
            int r2 = r8.f31273e
            r8.f31274f = r2
            int r0 = r0 + 1
            r8.f31271c = r0
            int r0 = r2 + 1
            r8.f31273e = r0
            r1[r2] = r6
        L_0x0066:
            int r0 = r8.f31271c
            int r1 = r8.f31270b
            if (r0 >= r1) goto L_0x007f
            char[] r2 = r8.f31275g
            char r7 = r2[r0]
            if (r7 != r6) goto L_0x007f
            int r1 = r8.f31273e
            int r7 = r1 + 1
            r8.f31273e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f31271c = r0
            goto L_0x0066
        L_0x007f:
            if (r0 == r1) goto L_0x008b
            char[] r1 = r8.f31275g
            char r0 = r1[r0]
            if (r0 == r3) goto L_0x008b
            if (r0 == r4) goto L_0x008b
            if (r0 != r5) goto L_0x0006
        L_0x008b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f31275g
            int r2 = r8.f31272d
            int r3 = r8.f31274f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.tls.DistinguishedNameParser.a():java.lang.String");
    }

    private int c(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.f31270b) {
            char[] cArr = this.f31275g;
            char c2 = cArr[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f31269a);
            } else {
                i3 = c2 - '7';
            }
            char c3 = cArr[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f31269a);
            } else {
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        throw new IllegalStateException("Malformed DN: " + this.f31269a);
    }

    private char d() {
        int i2 = this.f31271c + 1;
        this.f31271c = i2;
        if (i2 != this.f31270b) {
            char c2 = this.f31275g[i2];
            if (c2 == ' ' || c2 == '%' || c2 == '\\' || c2 == '_' || c2 == '\"' || c2 == '#') {
                return c2;
            }
            switch (c2) {
                case '*':
                case '+':
                case ',':
                    return c2;
                default:
                    switch (c2) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            return c2;
                        default:
                            return e();
                    }
            }
        } else {
            throw new IllegalStateException("Unexpected end of DN: " + this.f31269a);
        }
    }

    private char e() {
        int i2;
        int i3;
        int c2 = c(this.f31271c);
        this.f31271c++;
        if (c2 < 128) {
            return (char) c2;
        }
        if (c2 < 192 || c2 > 247) {
            return '?';
        }
        if (c2 <= 223) {
            i3 = c2 & 31;
            i2 = 1;
        } else if (c2 <= 239) {
            i3 = c2 & 15;
            i2 = 2;
        } else {
            i3 = c2 & 7;
            i2 = 3;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.f31271c;
            int i6 = i5 + 1;
            this.f31271c = i6;
            if (i6 == this.f31270b || this.f31275g[i6] != '\\') {
                return '?';
            }
            int i7 = i5 + 2;
            this.f31271c = i7;
            int c3 = c(i7);
            this.f31271c++;
            if ((c3 & PsExtractor.x) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (c3 & 63);
        }
        return (char) i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        r1 = r6.f31275g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String f() {
        /*
            r6 = this;
            int r0 = r6.f31271c
            int r1 = r0 + 4
            int r2 = r6.f31270b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L_0x0090
            r6.f31272d = r0
        L_0x000c:
            int r0 = r0 + 1
            r6.f31271c = r0
            int r0 = r6.f31271c
            int r1 = r6.f31270b
            if (r0 == r1) goto L_0x004c
            char[] r1 = r6.f31275g
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L_0x004c
            r4 = 44
            if (r2 == r4) goto L_0x004c
            r4 = 59
            if (r2 != r4) goto L_0x0027
            goto L_0x004c
        L_0x0027:
            r4 = 32
            if (r2 != r4) goto L_0x003e
            r6.f31273e = r0
        L_0x002d:
            int r0 = r0 + 1
            r6.f31271c = r0
            int r0 = r6.f31271c
            int r1 = r6.f31270b
            if (r0 >= r1) goto L_0x004e
            char[] r1 = r6.f31275g
            char r1 = r1[r0]
            if (r1 != r4) goto L_0x004e
            goto L_0x002d
        L_0x003e:
            r4 = 65
            if (r2 < r4) goto L_0x000c
            r4 = 70
            if (r2 > r4) goto L_0x000c
            int r2 = r2 + 32
            char r2 = (char) r2
            r1[r0] = r2
            goto L_0x000c
        L_0x004c:
            r6.f31273e = r0
        L_0x004e:
            int r0 = r6.f31273e
            int r1 = r6.f31272d
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L_0x0079
            r2 = r0 & 1
            if (r2 == 0) goto L_0x0079
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            int r1 = r1 + 1
            r4 = 0
        L_0x0061:
            if (r4 >= r2) goto L_0x006f
            int r5 = r6.c(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L_0x0061
        L_0x006f:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f31275g
            int r3 = r6.f31272d
            r1.<init>(r2, r3, r0)
            return r1
        L_0x0079:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f31269a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0090:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r6.f31269a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.tls.DistinguishedNameParser.f():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String g() {
        /*
            r6 = this;
        L_0x0000:
            int r0 = r6.f31271c
            int r1 = r6.f31270b
            r2 = 32
            if (r0 >= r1) goto L_0x0013
            char[] r3 = r6.f31275g
            char r3 = r3[r0]
            if (r3 != r2) goto L_0x0013
            int r0 = r0 + 1
            r6.f31271c = r0
            goto L_0x0000
        L_0x0013:
            if (r0 != r1) goto L_0x0017
            r0 = 0
            return r0
        L_0x0017:
            r6.f31272d = r0
        L_0x0019:
            int r0 = r0 + 1
            r6.f31271c = r0
            int r0 = r6.f31271c
            int r1 = r6.f31270b
            r3 = 61
            if (r0 >= r1) goto L_0x002e
            char[] r4 = r6.f31275g
            char r4 = r4[r0]
            if (r4 == r3) goto L_0x002e
            if (r4 == r2) goto L_0x002e
            goto L_0x0019
        L_0x002e:
            java.lang.String r4 = "Unexpected end of DN: "
            if (r0 >= r1) goto L_0x00cb
            r6.f31273e = r0
            char[] r1 = r6.f31275g
            char r0 = r1[r0]
            if (r0 != r2) goto L_0x006d
        L_0x003a:
            int r0 = r6.f31271c
            int r1 = r6.f31270b
            if (r0 >= r1) goto L_0x004d
            char[] r5 = r6.f31275g
            char r5 = r5[r0]
            if (r5 == r3) goto L_0x004d
            if (r5 != r2) goto L_0x004d
            int r0 = r0 + 1
            r6.f31271c = r0
            goto L_0x003a
        L_0x004d:
            char[] r5 = r6.f31275g
            char r5 = r5[r0]
            if (r5 != r3) goto L_0x0056
            if (r0 == r1) goto L_0x0056
            goto L_0x006d
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r6.f31269a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x006d:
            int r0 = r6.f31271c
        L_0x006f:
            int r0 = r0 + 1
            r6.f31271c = r0
            int r0 = r6.f31271c
            int r1 = r6.f31270b
            if (r0 >= r1) goto L_0x0080
            char[] r1 = r6.f31275g
            char r1 = r1[r0]
            if (r1 != r2) goto L_0x0080
            goto L_0x006f
        L_0x0080:
            int r0 = r6.f31273e
            int r1 = r6.f31272d
            int r2 = r0 - r1
            r3 = 4
            if (r2 <= r3) goto L_0x00c0
            char[] r2 = r6.f31275g
            int r4 = r1 + 3
            char r4 = r2[r4]
            r5 = 46
            if (r4 != r5) goto L_0x00c0
            char r4 = r2[r1]
            r5 = 79
            if (r4 == r5) goto L_0x009d
            r5 = 111(0x6f, float:1.56E-43)
            if (r4 != r5) goto L_0x00c0
        L_0x009d:
            int r4 = r1 + 1
            char r4 = r2[r4]
            r5 = 73
            if (r4 == r5) goto L_0x00ad
            int r4 = r1 + 1
            char r4 = r2[r4]
            r5 = 105(0x69, float:1.47E-43)
            if (r4 != r5) goto L_0x00c0
        L_0x00ad:
            int r4 = r1 + 2
            char r4 = r2[r4]
            r5 = 68
            if (r4 == r5) goto L_0x00bd
            int r4 = r1 + 2
            char r2 = r2[r4]
            r4 = 100
            if (r2 != r4) goto L_0x00c0
        L_0x00bd:
            int r1 = r1 + r3
            r6.f31272d = r1
        L_0x00c0:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f31275g
            int r3 = r6.f31272d
            int r0 = r0 - r3
            r1.<init>(r2, r3, r0)
            return r1
        L_0x00cb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r6.f31269a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.tls.DistinguishedNameParser.g():java.lang.String");
    }

    private String h() {
        int i2 = this.f31271c + 1;
        this.f31271c = i2;
        this.f31272d = i2;
        while (true) {
            this.f31273e = i2;
            int i3 = this.f31271c;
            if (i3 != this.f31270b) {
                char[] cArr = this.f31275g;
                char c2 = cArr[i3];
                if (c2 == '\"') {
                    do {
                        this.f31271c = i3 + 1;
                        i3 = this.f31271c;
                        if (i3 >= this.f31270b || this.f31275g[i3] != ' ') {
                            char[] cArr2 = this.f31275g;
                            int i4 = this.f31272d;
                        }
                        this.f31271c = i3 + 1;
                        i3 = this.f31271c;
                        break;
                    } while (this.f31275g[i3] != ' ');
                    char[] cArr22 = this.f31275g;
                    int i42 = this.f31272d;
                    return new String(cArr22, i42, this.f31273e - i42);
                }
                if (c2 == '\\') {
                    cArr[this.f31273e] = d();
                } else {
                    cArr[this.f31273e] = c2;
                }
                this.f31271c++;
                i2 = this.f31273e + 1;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f31269a);
            }
        }
    }

    public String b(String str) {
        this.f31271c = 0;
        this.f31272d = 0;
        this.f31273e = 0;
        this.f31274f = 0;
        this.f31275g = this.f31269a.toCharArray();
        String g2 = g();
        if (g2 == null) {
            return null;
        }
        do {
            int i2 = this.f31271c;
            if (i2 == this.f31270b) {
                return null;
            }
            char c2 = this.f31275g[i2];
            String a2 = c2 != '\"' ? c2 != '#' ? (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a() : f() : h();
            if (str.equalsIgnoreCase(g2)) {
                return a2;
            }
            int i3 = this.f31271c;
            if (i3 >= this.f31270b) {
                return null;
            }
            char c3 = this.f31275g[i3];
            if (c3 == ',' || c3 == ';' || c3 == '+') {
                this.f31271c = i3 + 1;
                g2 = g();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f31269a);
            }
        } while (g2 != null);
        throw new IllegalStateException("Malformed DN: " + this.f31269a);
    }
}
