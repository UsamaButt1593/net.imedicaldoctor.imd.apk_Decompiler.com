package com.airbnb.lottie.parser.moshi;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.itextpdf.text.pdf.PdfBoolean;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

final class JsonUtf8Reader extends JsonReader {
    private static final int A3 = 14;
    private static final int B3 = 15;
    private static final int C3 = 16;
    private static final int D3 = 17;
    private static final int E3 = 18;
    private static final int F3 = 0;
    private static final int G3 = 1;
    private static final int H3 = 2;
    private static final int I3 = 3;
    private static final int J3 = 4;
    private static final int K3 = 5;
    private static final int L3 = 6;
    private static final int M3 = 7;
    private static final long g3 = -922337203685477580L;
    private static final ByteString h3 = ByteString.n("'\\");
    private static final ByteString i3 = ByteString.n("\"\\");
    private static final ByteString j3 = ByteString.n("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString k3 = ByteString.n("\n\r");
    private static final ByteString l3 = ByteString.n("*/");
    private static final int m3 = 0;
    private static final int n3 = 1;
    private static final int o3 = 2;
    private static final int p3 = 3;
    private static final int q3 = 4;
    private static final int r3 = 5;
    private static final int s3 = 6;
    private static final int t3 = 7;
    private static final int u3 = 8;
    private static final int v3 = 9;
    private static final int w3 = 10;
    private static final int x3 = 11;
    private static final int y3 = 12;
    private static final int z3 = 13;
    private final BufferedSource a3;
    private final Buffer b3;
    private int c3 = 0;
    private long d3;
    private int e3;
    @Nullable
    private String f3;

    JsonUtf8Reader(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.a3 = bufferedSource;
            this.b3 = bufferedSource.m();
            t(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private void A() throws IOException {
        if (!this.X2) {
            throw y("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int C() throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            int[] r1 = r0.X
            int r2 = r0.s
            int r3 = r2 + -1
            r3 = r1[r3]
            r5 = 34
            r6 = 8
            r7 = 0
            r9 = 3
            r10 = 93
            r11 = 7
            r12 = 59
            r13 = 44
            r14 = 4
            r15 = 2
            r4 = 1
            if (r3 != r4) goto L_0x0022
            int r2 = r2 - r4
            r1[r2] = r15
            goto L_0x009a
        L_0x0022:
            if (r3 != r15) goto L_0x003d
            int r1 = r0.I(r4)
            okio.Buffer r2 = r0.b3
            r2.readByte()
            if (r1 == r13) goto L_0x009a
            if (r1 == r12) goto L_0x0094
            if (r1 != r10) goto L_0x0036
            r0.c3 = r14
            return r14
        L_0x0036:
            java.lang.String r1 = "Unterminated array"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r1 = r0.y(r1)
            throw r1
        L_0x003d:
            r15 = 5
            if (r3 == r9) goto L_0x0121
            if (r3 != r15) goto L_0x0044
            goto L_0x0121
        L_0x0044:
            if (r3 != r14) goto L_0x007e
            int r2 = r2 - r4
            r1[r2] = r15
            int r1 = r0.I(r4)
            okio.Buffer r2 = r0.b3
            r2.readByte()
            r2 = 58
            if (r1 == r2) goto L_0x009a
            r2 = 61
            if (r1 != r2) goto L_0x0077
            r16.A()
            okio.BufferedSource r1 = r0.a3
            r14 = 1
            boolean r1 = r1.request(r14)
            if (r1 == 0) goto L_0x009a
            okio.Buffer r1 = r0.b3
            byte r1 = r1.y(r7)
            r2 = 62
            if (r1 != r2) goto L_0x009a
            okio.Buffer r1 = r0.b3
            r1.readByte()
            goto L_0x009a
        L_0x0077:
            java.lang.String r1 = "Expected ':'"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r1 = r0.y(r1)
            throw r1
        L_0x007e:
            r14 = 6
            if (r3 != r14) goto L_0x0085
            int r2 = r2 - r4
            r1[r2] = r11
            goto L_0x009a
        L_0x0085:
            if (r3 != r11) goto L_0x0098
            r1 = 0
            int r1 = r0.I(r1)
            r2 = -1
            if (r1 != r2) goto L_0x0094
            r1 = 18
        L_0x0091:
            r0.c3 = r1
            return r1
        L_0x0094:
            r16.A()
            goto L_0x009a
        L_0x0098:
            if (r3 == r6) goto L_0x0119
        L_0x009a:
            int r1 = r0.I(r4)
            if (r1 == r5) goto L_0x0110
            r2 = 39
            if (r1 == r2) goto L_0x0105
            if (r1 == r13) goto L_0x00f2
            if (r1 == r12) goto L_0x00f2
            r2 = 91
            if (r1 == r2) goto L_0x00ea
            if (r1 == r10) goto L_0x00e1
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x00d9
            int r1 = r16.N()
            if (r1 == 0) goto L_0x00b9
            return r1
        L_0x00b9:
            int r1 = r16.O()
            if (r1 == 0) goto L_0x00c0
            return r1
        L_0x00c0:
            okio.Buffer r1 = r0.b3
            byte r1 = r1.y(r7)
            boolean r1 = r0.H(r1)
            if (r1 == 0) goto L_0x00d2
            r16.A()
            r1 = 10
            goto L_0x0091
        L_0x00d2:
            java.lang.String r1 = "Expected value"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r1 = r0.y(r1)
            throw r1
        L_0x00d9:
            okio.Buffer r1 = r0.b3
            r1.readByte()
            r0.c3 = r4
            return r4
        L_0x00e1:
            if (r3 != r4) goto L_0x00f2
            okio.Buffer r1 = r0.b3
            r1.readByte()
            r1 = 4
            goto L_0x0091
        L_0x00ea:
            okio.Buffer r1 = r0.b3
            r1.readByte()
            r0.c3 = r9
            return r9
        L_0x00f2:
            if (r3 == r4) goto L_0x00ff
            r1 = 2
            if (r3 != r1) goto L_0x00f8
            goto L_0x00ff
        L_0x00f8:
            java.lang.String r1 = "Unexpected value"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r1 = r0.y(r1)
            throw r1
        L_0x00ff:
            r16.A()
            r0.c3 = r11
            return r11
        L_0x0105:
            r16.A()
            okio.Buffer r1 = r0.b3
            r1.readByte()
            r0.c3 = r6
            return r6
        L_0x0110:
            okio.Buffer r1 = r0.b3
            r1.readByte()
            r1 = 9
            goto L_0x0091
        L_0x0119:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "JsonReader is closed"
            r1.<init>(r2)
            throw r1
        L_0x0121:
            int r2 = r2 - r4
            r6 = 4
            r1[r2] = r6
            r1 = 125(0x7d, float:1.75E-43)
            if (r3 != r15) goto L_0x0145
            int r2 = r0.I(r4)
            okio.Buffer r6 = r0.b3
            r6.readByte()
            if (r2 == r13) goto L_0x0145
            if (r2 == r12) goto L_0x0142
            if (r2 != r1) goto L_0x013b
        L_0x0138:
            r1 = 2
            goto L_0x0091
        L_0x013b:
            java.lang.String r1 = "Unterminated object"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r1 = r0.y(r1)
            throw r1
        L_0x0142:
            r16.A()
        L_0x0145:
            int r2 = r0.I(r4)
            if (r2 == r5) goto L_0x017f
            r4 = 39
            if (r2 == r4) goto L_0x0173
            java.lang.String r4 = "Expected name"
            if (r2 == r1) goto L_0x0166
            r16.A()
            char r1 = (char) r2
            boolean r1 = r0.H(r1)
            if (r1 == 0) goto L_0x0161
            r1 = 14
            goto L_0x0091
        L_0x0161:
            com.airbnb.lottie.parser.moshi.JsonEncodingException r1 = r0.y(r4)
            throw r1
        L_0x0166:
            if (r3 == r15) goto L_0x016e
            okio.Buffer r1 = r0.b3
            r1.readByte()
            goto L_0x0138
        L_0x016e:
            com.airbnb.lottie.parser.moshi.JsonEncodingException r1 = r0.y(r4)
            throw r1
        L_0x0173:
            okio.Buffer r1 = r0.b3
            r1.readByte()
            r16.A()
            r1 = 12
            goto L_0x0091
        L_0x017f:
            okio.Buffer r1 = r0.b3
            r1.readByte()
            r1 = 13
            goto L_0x0091
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonUtf8Reader.C():int");
    }

    private int F(String str, JsonReader.Options options) {
        int length = options.f17327a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(options.f17327a[i2])) {
                this.c3 = 0;
                this.Y[this.s - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    private int G(String str, JsonReader.Options options) {
        int length = options.f17327a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(options.f17327a[i2])) {
                this.c3 = 0;
                int[] iArr = this.Z;
                int i4 = this.s - 1;
                iArr[i4] = iArr[i4] + 1;
                return i2;
            }
        }
        return -1;
    }

    private boolean H(int i2) throws IOException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (!(i2 == 47 || i2 == 61)) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        A();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r6.b3.skip((long) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r2 != 47) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        if (r6.a3.request(2) != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        A();
        r3 = r6.b3.y(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r3 == 42) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (r3 == 47) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        r6.b3.readByte();
        r6.b3.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        S();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        r6.b3.readByte();
        r6.b3.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
        if (R() == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
        throw y("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r2 != 35) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0076, code lost:
        A();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int I(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            r1 = 0
        L_0x0002:
            okio.BufferedSource r2 = r6.a3
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L_0x007d
            okio.Buffer r2 = r6.b3
            long r4 = (long) r1
            byte r2 = r2.y(r4)
            r4 = 10
            if (r2 == r4) goto L_0x007b
            r4 = 32
            if (r2 == r4) goto L_0x007b
            r4 = 13
            if (r2 == r4) goto L_0x007b
            r4 = 9
            if (r2 != r4) goto L_0x0025
            goto L_0x007b
        L_0x0025:
            okio.Buffer r3 = r6.b3
            long r4 = (long) r1
            r3.skip(r4)
            r1 = 47
            if (r2 != r1) goto L_0x0072
            okio.BufferedSource r3 = r6.a3
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L_0x003a
            return r2
        L_0x003a:
            r6.A()
            okio.Buffer r3 = r6.b3
            r4 = 1
            byte r3 = r3.y(r4)
            r4 = 42
            if (r3 == r4) goto L_0x005a
            if (r3 == r1) goto L_0x004c
            return r2
        L_0x004c:
            okio.Buffer r1 = r6.b3
            r1.readByte()
            okio.Buffer r1 = r6.b3
            r1.readByte()
        L_0x0056:
            r6.S()
            goto L_0x0001
        L_0x005a:
            okio.Buffer r1 = r6.b3
            r1.readByte()
            okio.Buffer r1 = r6.b3
            r1.readByte()
            boolean r1 = r6.R()
            if (r1 == 0) goto L_0x006b
            goto L_0x0001
        L_0x006b:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r7 = r6.y(r7)
            throw r7
        L_0x0072:
            r1 = 35
            if (r2 != r1) goto L_0x007a
            r6.A()
            goto L_0x0056
        L_0x007a:
            return r2
        L_0x007b:
            r1 = r3
            goto L_0x0002
        L_0x007d:
            if (r7 != 0) goto L_0x0081
            r7 = -1
            return r7
        L_0x0081:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonUtf8Reader.I(boolean):int");
    }

    private String J(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long z0 = this.a3.z0(byteString);
            if (z0 == -1) {
                throw y("Unterminated string");
            } else if (this.b3.y(z0) == 92) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.b3.B(z0));
                this.b3.readByte();
                sb.append(P());
            } else {
                String B = this.b3.B(z0);
                if (sb == null) {
                    this.b3.readByte();
                    return B;
                }
                sb.append(B);
                this.b3.readByte();
                return sb.toString();
            }
        }
    }

    private String L() throws IOException {
        long z0 = this.a3.z0(j3);
        return z0 != -1 ? this.b3.B(z0) : this.b3.a2();
    }

    private int N() throws IOException {
        int i2;
        String str;
        String str2;
        byte y = this.b3.y(0);
        if (y == 116 || y == 84) {
            str2 = PdfBoolean.l3;
            str = "TRUE";
            i2 = 5;
        } else if (y == 102 || y == 70) {
            str2 = "false";
            str = "FALSE";
            i2 = 6;
        } else if (y != 110 && y != 78) {
            return 0;
        } else {
            str2 = "null";
            str = "NULL";
            i2 = 7;
        }
        int length = str2.length();
        int i4 = 1;
        while (i4 < length) {
            int i5 = i4 + 1;
            if (!this.a3.request((long) i5)) {
                return 0;
            }
            byte y2 = this.b3.y((long) i4);
            if (y2 != str2.charAt(i4) && y2 != str.charAt(i4)) {
                return 0;
            }
            i4 = i5;
        }
        if (this.a3.request((long) (length + 1)) && H(this.b3.y((long) length))) {
            return 0;
        }
        this.b3.skip((long) length);
        this.c3 = i2;
        return i2;
    }

    private int O() throws IOException {
        int i2;
        byte y;
        boolean z = true;
        long j2 = 0;
        int i4 = 0;
        char c2 = 0;
        boolean z2 = true;
        boolean z4 = false;
        while (true) {
            int i5 = i4 + 1;
            if (!this.a3.request((long) i5)) {
                break;
            }
            y = this.b3.y((long) i4);
            if (y != 43) {
                if (y != 69 && y != 101) {
                    if (y != 45) {
                        if (y != 46) {
                            if (y >= 48 && y <= 57) {
                                if (c2 == z || c2 == 0) {
                                    j2 = (long) (-(y - 48));
                                    c2 = 2;
                                } else if (c2 == 2) {
                                    if (j2 == 0) {
                                        return 0;
                                    }
                                    long j4 = (10 * j2) - ((long) (y - 48));
                                    int i6 = (j2 > -922337203685477580L ? 1 : (j2 == -922337203685477580L ? 0 : -1));
                                    z2 &= i6 > 0 || (i6 == 0 && j4 < j2);
                                    j2 = j4;
                                } else if (c2 == 3) {
                                    c2 = 4;
                                } else if (c2 == 5 || c2 == 6) {
                                    c2 = 7;
                                }
                            }
                        } else if (c2 != 2) {
                            return 0;
                        } else {
                            c2 = 3;
                        }
                    } else if (c2 == 0) {
                        c2 = 1;
                        z4 = true;
                    } else if (c2 != 5) {
                        return 0;
                    }
                    i4 = i5;
                    z = true;
                } else if (c2 != 2 && c2 != 4) {
                    return 0;
                } else {
                    c2 = 5;
                    i4 = i5;
                    z = true;
                }
            } else if (c2 != 5) {
                return 0;
            }
            c2 = 6;
            i4 = i5;
            z = true;
        }
        if (H(y)) {
            return 0;
        }
        if (c2 == 2 && z2 && ((j2 != Long.MIN_VALUE || z4) && (j2 != 0 || !z4))) {
            if (!z4) {
                j2 = -j2;
            }
            this.d3 = j2;
            this.b3.skip((long) i4);
            i2 = 16;
        } else if (c2 != 2 && c2 != 4 && c2 != 7) {
            return 0;
        } else {
            this.e3 = i4;
            i2 = 17;
        }
        this.c3 = i2;
        return i2;
    }

    private char P() throws IOException {
        int i2;
        if (this.a3.request(1)) {
            byte readByte = this.b3.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return 8;
            }
            if (readByte == 102) {
                return 12;
            }
            if (readByte == 110) {
                return 10;
            }
            if (readByte == 114) {
                return 13;
            }
            if (readByte == 116) {
                return 9;
            }
            if (readByte != 117) {
                if (this.X2) {
                    return (char) readByte;
                }
                throw y("Invalid escape sequence: \\" + ((char) readByte));
            } else if (this.a3.request(4)) {
                char c2 = 0;
                for (int i4 = 0; i4 < 4; i4++) {
                    byte y = this.b3.y((long) i4);
                    char c4 = (char) (c2 << 4);
                    if (y >= 48 && y <= 57) {
                        i2 = y - 48;
                    } else if (y >= 97 && y <= 102) {
                        i2 = y - 87;
                    } else if (y < 65 || y > 70) {
                        throw y("\\u" + this.b3.B(4));
                    } else {
                        i2 = y - 55;
                    }
                    c2 = (char) (c4 + i2);
                }
                this.b3.skip(4);
                return c2;
            } else {
                throw new EOFException("Unterminated escape sequence at path " + getPath());
            }
        } else {
            throw y("Unterminated escape sequence");
        }
    }

    private void Q(ByteString byteString) throws IOException {
        while (true) {
            long z0 = this.a3.z0(byteString);
            if (z0 == -1) {
                throw y("Unterminated string");
            } else if (this.b3.y(z0) == 92) {
                this.b3.skip(z0 + 1);
                P();
            } else {
                this.b3.skip(z0 + 1);
                return;
            }
        }
    }

    private boolean R() throws IOException {
        BufferedSource bufferedSource = this.a3;
        ByteString byteString = l3;
        long l0 = bufferedSource.l0(byteString);
        boolean z = l0 != -1;
        Buffer buffer = this.b3;
        buffer.skip(z ? l0 + ((long) byteString.m0()) : buffer.L0());
        return z;
    }

    private void S() throws IOException {
        long z0 = this.a3.z0(k3);
        Buffer buffer = this.b3;
        buffer.skip(z0 != -1 ? z0 + 1 : buffer.L0());
    }

    private void T() throws IOException {
        long z0 = this.a3.z0(j3);
        Buffer buffer = this.b3;
        if (z0 == -1) {
            z0 = buffer.L0();
        }
        buffer.skip(z0);
    }

    public void c() throws IOException {
        int i2 = this.c3;
        if (i2 == 0) {
            i2 = C();
        }
        if (i2 == 3) {
            t(1);
            this.Z[this.s - 1] = 0;
            this.c3 = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + s() + " at path " + getPath());
    }

    public void close() throws IOException {
        this.c3 = 0;
        this.X[0] = 8;
        this.s = 1;
        this.b3.d();
        this.a3.close();
    }

    public void d() throws IOException {
        int i2 = this.c3;
        if (i2 == 0) {
            i2 = C();
        }
        if (i2 == 1) {
            t(3);
            this.c3 = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + s() + " at path " + getPath());
    }

    public void e() throws IOException {
        int i2 = this.c3;
        if (i2 == 0) {
            i2 = C();
        }
        if (i2 == 4) {
            int i4 = this.s;
            this.s = i4 - 1;
            int[] iArr = this.Z;
            int i5 = i4 - 2;
            iArr[i5] = iArr[i5] + 1;
            this.c3 = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + s() + " at path " + getPath());
    }

    public void f() throws IOException {
        int i2 = this.c3;
        if (i2 == 0) {
            i2 = C();
        }
        if (i2 == 2) {
            int i4 = this.s;
            int i5 = i4 - 1;
            this.s = i5;
            this.Y[i5] = null;
            int[] iArr = this.Z;
            int i6 = i4 - 2;
            iArr[i6] = iArr[i6] + 1;
            this.c3 = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + s() + " at path " + getPath());
    }

    public boolean h() throws IOException {
        int i2 = this.c3;
        if (i2 == 0) {
            i2 = C();
        }
        return (i2 == 2 || i2 == 4 || i2 == 18) ? false : true;
    }

    public boolean i() throws IOException {
        int i2 = this.c3;
        if (i2 == 0) {
            i2 = C();
        }
        if (i2 == 5) {
            this.c3 = 0;
            int[] iArr = this.Z;
            int i4 = this.s - 1;
            iArr[i4] = iArr[i4] + 1;
            return true;
        } else if (i2 == 6) {
            this.c3 = 0;
            int[] iArr2 = this.Z;
            int i5 = this.s - 1;
            iArr2[i5] = iArr2[i5] + 1;
            return false;
        } else {
            throw new JsonDataException("Expected a boolean but was " + s() + " at path " + getPath());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double k() throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.c3
            if (r0 != 0) goto L_0x0008
            int r0 = r8.C()
        L_0x0008:
            r1 = 16
            r2 = 0
            if (r0 != r1) goto L_0x001f
            r8.c3 = r2
            int[] r0 = r8.Z
            int r1 = r8.s
            int r1 = r1 + -1
            r2 = r0[r1]
            int r2 = r2 + 1
            r0[r1] = r2
            long r0 = r8.d3
            double r0 = (double) r0
            return r0
        L_0x001f:
            r1 = 17
            java.lang.String r3 = "Expected a double but was "
            r4 = 11
            java.lang.String r5 = " at path "
            if (r0 != r1) goto L_0x0035
            okio.Buffer r0 = r8.b3
            int r1 = r8.e3
            long r6 = (long) r1
            java.lang.String r0 = r0.B(r6)
        L_0x0032:
            r8.f3 = r0
            goto L_0x0052
        L_0x0035:
            r1 = 9
            if (r0 != r1) goto L_0x0040
            okio.ByteString r0 = i3
        L_0x003b:
            java.lang.String r0 = r8.J(r0)
            goto L_0x0032
        L_0x0040:
            r1 = 8
            if (r0 != r1) goto L_0x0047
            okio.ByteString r0 = h3
            goto L_0x003b
        L_0x0047:
            r1 = 10
            if (r0 != r1) goto L_0x0050
            java.lang.String r0 = r8.L()
            goto L_0x0032
        L_0x0050:
            if (r0 != r4) goto L_0x00bf
        L_0x0052:
            r8.c3 = r4
            java.lang.String r0 = r8.f3     // Catch:{ NumberFormatException -> 0x009e }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x009e }
            boolean r3 = r8.X2
            if (r3 != 0) goto L_0x008c
            boolean r3 = java.lang.Double.isNaN(r0)
            if (r3 != 0) goto L_0x006b
            boolean r3 = java.lang.Double.isInfinite(r0)
            if (r3 != 0) goto L_0x006b
            goto L_0x008c
        L_0x006b:
            com.airbnb.lottie.parser.moshi.JsonEncodingException r2 = new com.airbnb.lottie.parser.moshi.JsonEncodingException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "JSON forbids NaN and infinities: "
            r3.append(r4)
            r3.append(r0)
            r3.append(r5)
            java.lang.String r0 = r8.getPath()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x008c:
            r3 = 0
            r8.f3 = r3
            r8.c3 = r2
            int[] r2 = r8.Z
            int r3 = r8.s
            int r3 = r3 + -1
            r4 = r2[r3]
            int r4 = r4 + 1
            r2[r3] = r4
            return r0
        L_0x009e:
            com.airbnb.lottie.parser.moshi.JsonDataException r0 = new com.airbnb.lottie.parser.moshi.JsonDataException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            java.lang.String r2 = r8.f3
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = r8.getPath()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00bf:
            com.airbnb.lottie.parser.moshi.JsonDataException r0 = new com.airbnb.lottie.parser.moshi.JsonDataException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            com.airbnb.lottie.parser.moshi.JsonReader$Token r2 = r8.s()
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = r8.getPath()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonUtf8Reader.k():double");
    }

    public int n() throws IOException {
        int i2 = this.c3;
        if (i2 == 0) {
            i2 = C();
        }
        if (i2 == 16) {
            long j2 = this.d3;
            int i4 = (int) j2;
            if (j2 == ((long) i4)) {
                this.c3 = 0;
                int[] iArr = this.Z;
                int i5 = this.s - 1;
                iArr[i5] = iArr[i5] + 1;
                return i4;
            }
            throw new JsonDataException("Expected an int but was " + this.d3 + " at path " + getPath());
        }
        if (i2 == 17) {
            this.f3 = this.b3.B((long) this.e3);
        } else if (i2 == 9 || i2 == 8) {
            String J = J(i2 == 9 ? i3 : h3);
            this.f3 = J;
            try {
                int parseInt = Integer.parseInt(J);
                this.c3 = 0;
                int[] iArr2 = this.Z;
                int i6 = this.s - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i2 != 11) {
            throw new JsonDataException("Expected an int but was " + s() + " at path " + getPath());
        }
        this.c3 = 11;
        try {
            double parseDouble = Double.parseDouble(this.f3);
            int i7 = (int) parseDouble;
            if (((double) i7) == parseDouble) {
                this.f3 = null;
                this.c3 = 0;
                int[] iArr3 = this.Z;
                int i8 = this.s - 1;
                iArr3[i8] = iArr3[i8] + 1;
                return i7;
            }
            throw new JsonDataException("Expected an int but was " + this.f3 + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f3 + " at path " + getPath());
        }
    }

    public String p() throws IOException {
        String str;
        ByteString byteString;
        int i2 = this.c3;
        if (i2 == 0) {
            i2 = C();
        }
        if (i2 == 14) {
            str = L();
        } else {
            if (i2 == 13) {
                byteString = i3;
            } else if (i2 == 12) {
                byteString = h3;
            } else if (i2 == 15) {
                str = this.f3;
            } else {
                throw new JsonDataException("Expected a name but was " + s() + " at path " + getPath());
            }
            str = J(byteString);
        }
        this.c3 = 0;
        this.Y[this.s - 1] = str;
        return str;
    }

    public String q() throws IOException {
        String str;
        ByteString byteString;
        int i2 = this.c3;
        if (i2 == 0) {
            i2 = C();
        }
        if (i2 == 10) {
            str = L();
        } else {
            if (i2 == 9) {
                byteString = i3;
            } else if (i2 == 8) {
                byteString = h3;
            } else if (i2 == 11) {
                str = this.f3;
                this.f3 = null;
            } else if (i2 == 16) {
                str = Long.toString(this.d3);
            } else if (i2 == 17) {
                str = this.b3.B((long) this.e3);
            } else {
                throw new JsonDataException("Expected a string but was " + s() + " at path " + getPath());
            }
            str = J(byteString);
        }
        this.c3 = 0;
        int[] iArr = this.Z;
        int i4 = this.s - 1;
        iArr[i4] = iArr[i4] + 1;
        return str;
    }

    public JsonReader.Token s() throws IOException {
        int i2 = this.c3;
        if (i2 == 0) {
            i2 = C();
        }
        switch (i2) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonReader(" + this.a3 + ")";
    }

    public int u(JsonReader.Options options) throws IOException {
        int i2 = this.c3;
        if (i2 == 0) {
            i2 = C();
        }
        if (i2 < 12 || i2 > 15) {
            return -1;
        }
        if (i2 == 15) {
            return F(this.f3, options);
        }
        int S2 = this.a3.S2(options.f17328b);
        if (S2 != -1) {
            this.c3 = 0;
            this.Y[this.s - 1] = options.f17327a[S2];
            return S2;
        }
        String str = this.Y[this.s - 1];
        String p = p();
        int F = F(p, options);
        if (F == -1) {
            this.c3 = 15;
            this.f3 = p;
            this.Y[this.s - 1] = str;
        }
        return F;
    }

    public void v() throws IOException {
        ByteString byteString;
        if (!this.Y2) {
            int i2 = this.c3;
            if (i2 == 0) {
                i2 = C();
            }
            if (i2 == 14) {
                T();
            } else {
                if (i2 == 13) {
                    byteString = i3;
                } else if (i2 == 12) {
                    byteString = h3;
                } else if (i2 != 15) {
                    throw new JsonDataException("Expected a name but was " + s() + " at path " + getPath());
                }
                Q(byteString);
            }
            this.c3 = 0;
            this.Y[this.s - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + s() + " at " + getPath());
    }

    public void w() throws IOException {
        ByteString byteString;
        if (!this.Y2) {
            int i2 = 0;
            do {
                int i4 = this.c3;
                if (i4 == 0) {
                    i4 = C();
                }
                if (i4 == 3) {
                    t(1);
                } else if (i4 == 1) {
                    t(3);
                } else {
                    if (i4 == 4) {
                        i2--;
                        if (i2 < 0) {
                            throw new JsonDataException("Expected a value but was " + s() + " at path " + getPath());
                        }
                    } else if (i4 == 2) {
                        i2--;
                        if (i2 < 0) {
                            throw new JsonDataException("Expected a value but was " + s() + " at path " + getPath());
                        }
                    } else if (i4 == 14 || i4 == 10) {
                        T();
                        this.c3 = 0;
                    } else {
                        if (i4 == 9 || i4 == 13) {
                            byteString = i3;
                        } else if (i4 == 8 || i4 == 12) {
                            byteString = h3;
                        } else {
                            if (i4 == 17) {
                                this.b3.skip((long) this.e3);
                            } else if (i4 == 18) {
                                throw new JsonDataException("Expected a value but was " + s() + " at path " + getPath());
                            }
                            this.c3 = 0;
                        }
                        Q(byteString);
                        this.c3 = 0;
                    }
                    this.s--;
                    this.c3 = 0;
                }
                i2++;
                this.c3 = 0;
            } while (i2 != 0);
            int[] iArr = this.Z;
            int i5 = this.s;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
            this.Y[i5 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + s() + " at " + getPath());
    }
}
