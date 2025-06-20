package com.itextpdf.text.pdf.hyphenation;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.ClassUtils;

public class HyphenationTree extends TernaryTree implements PatternConsumer {
    private static final long h3 = -7763254239309429432L;
    protected ByteVector d3;
    protected HashMap<String, ArrayList<Object>> e3 = new HashMap<>(23);
    protected TernaryTree f3 = new TernaryTree();
    private transient TernaryTree g3;

    public HyphenationTree() {
        ByteVector byteVector = new ByteVector();
        this.d3 = byteVector;
        byteVector.a(1);
    }

    /* access modifiers changed from: protected */
    public byte[] A(int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + 1;
        byte c2 = this.d3.c(i2);
        while (c2 != 0) {
            stringBuffer.append((char) ((c2 >>> 4) - 1));
            char c3 = (char) (c2 & 15);
            if (c3 == 0) {
                break;
            }
            stringBuffer.append((char) (c3 - 1));
            c2 = this.d3.c(i3);
            i3++;
        }
        int length = stringBuffer.length();
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            bArr[i4] = (byte) stringBuffer.charAt(i4);
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public int B(char[] cArr, int i2, char[] cArr2, int i3) {
        while (true) {
            char c2 = cArr[i2];
            char c3 = cArr2[i3];
            if (c2 == c3) {
                if (c2 == 0) {
                    return 0;
                }
                i2++;
                i3++;
            } else if (c3 == 0) {
                return 0;
            } else {
                return c2 - c3;
            }
        }
    }

    public Hyphenation D(String str, int i2, int i3) {
        char[] charArray = str.toCharArray();
        return E(charArray, 0, charArray.length, i2, i3);
    }

    public Hyphenation E(char[] cArr, int i2, int i3, int i4, int i5) {
        int i6;
        char[] cArr2 = cArr;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        char[] cArr3 = new char[(i8 + 3)];
        char[] cArr4 = new char[2];
        int i10 = i8;
        boolean z = false;
        int i11 = 0;
        for (int i12 = 1; i12 <= i8; i12++) {
            cArr4[0] = cArr2[(i7 + i12) - 1];
            int g2 = this.f3.g(cArr4, 0);
            if (g2 < 0) {
                int i13 = i11 + 1;
                if (i12 == i13) {
                    i11 = i13;
                } else {
                    z = true;
                }
                i10--;
            } else if (z) {
                return null;
            } else {
                cArr3[i12 - i11] = (char) g2;
            }
        }
        if (i10 < i9 + i5) {
            return null;
        }
        int i14 = i10 + 1;
        int[] iArr = new int[i14];
        String str = new String(cArr3, 1, i10);
        if (this.e3.containsKey(str)) {
            ArrayList arrayList = this.e3.get(str);
            int i15 = 0;
            i6 = 0;
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                Object obj = arrayList.get(i16);
                if ((obj instanceof String) && (i15 = i15 + ((String) obj).length()) >= i9 && i15 < i10 - i5) {
                    iArr[i6] = i15 + i11;
                    i6++;
                }
            }
        } else {
            cArr3[0] = ClassUtils.PACKAGE_SEPARATOR_CHAR;
            cArr3[i14] = ClassUtils.PACKAGE_SEPARATOR_CHAR;
            cArr3[i10 + 2] = 0;
            byte[] bArr = new byte[(i10 + 3)];
            for (int i17 = 0; i17 < i14; i17++) {
                K(cArr3, i17, bArr);
            }
            int i18 = 0;
            int i19 = 0;
            while (i19 < i10) {
                int i20 = i19 + 1;
                if ((bArr[i20] & 1) == 1 && i19 >= i9 && i19 <= i10 - i5) {
                    iArr[i18] = i19 + i11;
                    i18++;
                }
                i19 = i20;
            }
            i6 = i18;
        }
        if (i6 <= 0) {
            return null;
        }
        int[] iArr2 = new int[i6];
        System.arraycopy(iArr, 0, iArr2, 0, i6);
        return new Hyphenation(new String(cArr2, i7, i8), iArr2);
    }

    public void F(InputStream inputStream) {
        SimplePatternParser simplePatternParser = new SimplePatternParser();
        this.g3 = new TernaryTree();
        simplePatternParser.k(inputStream, this);
        y();
        this.d3.g();
        this.f3.y();
        this.g3 = null;
    }

    /* access modifiers changed from: protected */
    public int J(String str) {
        int length = str.length();
        int i2 = (length & 1) == 1 ? (length >> 1) + 2 : (length >> 1) + 1;
        int a2 = this.d3.a(i2);
        byte[] d2 = this.d3.d();
        for (int i3 = 0; i3 < length; i3++) {
            byte charAt = (byte) ((str.charAt(i3) - '/') & 15);
            int i4 = (i3 >> 1) + a2;
            if ((i3 & 1) == 1) {
                d2[i4] = (byte) (charAt | d2[i4]);
            } else {
                d2[i4] = (byte) (charAt << 4);
            }
        }
        d2[(i2 - 1) + a2] = 0;
        return a2;
    }

    /* access modifiers changed from: protected */
    public void K(char[] cArr, int i2, byte[] bArr) {
        char c2;
        char c3 = cArr[i2];
        char c4 = this.Y2;
        int i3 = i2;
        while (c4 > 0) {
            char[] cArr2 = this.Z;
            if (c4 < cArr2.length) {
                char c5 = cArr2[c4];
                int i4 = 0;
                if (c5 != 65535) {
                    int i5 = c3 - c5;
                    if (i5 == 0) {
                        if (c3 != 0) {
                            i3++;
                            c3 = cArr[i3];
                            c4 = this.Y[c4];
                            char c6 = c4;
                            while (true) {
                                if (c6 <= 0) {
                                    break;
                                }
                                char[] cArr3 = this.Z;
                                if (c6 >= cArr3.length || (c2 = cArr3[c6]) == 65535) {
                                    break;
                                } else if (c2 == 0) {
                                    byte[] A = A(this.Y[c6]);
                                    int length = A.length;
                                    int i6 = i2;
                                    while (i4 < length) {
                                        byte b2 = A[i4];
                                        if (i6 < bArr.length && b2 > bArr[i6]) {
                                            bArr[i6] = b2;
                                        }
                                        i6++;
                                        i4++;
                                    }
                                } else {
                                    c6 = this.s[c6];
                                }
                            }
                        } else {
                            return;
                        }
                    } else {
                        c4 = i5 < 0 ? this.s[c4] : this.X[c4];
                    }
                } else if (B(cArr, i3, this.X2.e(), this.s[c4]) == 0) {
                    byte[] A2 = A(this.Y[c4]);
                    int length2 = A2.length;
                    while (i4 < length2) {
                        byte b3 = A2[i4];
                        if (i2 < bArr.length && b3 > bArr[i2]) {
                            bArr[i2] = b3;
                        }
                        i2++;
                        i4++;
                    }
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public String L(int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + 1;
        byte c2 = this.d3.c(i2);
        while (c2 != 0) {
            stringBuffer.append((char) ((c2 >>> 4) + 47));
            char c3 = (char) (c2 & 15);
            if (c3 == 0) {
                break;
            }
            stringBuffer.append((char) (c3 + '/'));
            c2 = this.d3.c(i3);
            i3++;
        }
        return stringBuffer.toString();
    }

    public void b(String str, String str2) {
        int e2 = this.g3.e(str2);
        if (e2 <= 0) {
            e2 = J(str2);
            this.g3.l(str2, (char) e2);
        }
        l(str, (char) e2);
    }

    public void c(String str, ArrayList<Object> arrayList) {
        this.e3.put(str, arrayList);
    }

    public void f(String str) {
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            char[] cArr = new char[2];
            cArr[1] = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                cArr[0] = str.charAt(i2);
                this.f3.m(cArr, 0, charAt);
            }
        }
    }

    public void q() {
        PrintStream printStream = System.out;
        printStream.println("Value space size = " + Integer.toString(this.d3.e()));
        super.q();
    }

    public String z(String str) {
        int e2 = super.e(str);
        return e2 >= 0 ? L(e2) : "";
    }
}
