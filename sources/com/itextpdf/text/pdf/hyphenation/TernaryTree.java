package com.itextpdf.text.pdf.hyphenation;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Stack;
import kotlin.jvm.internal.CharCompanionObject;

public class TernaryTree implements Cloneable, Serializable {
    private static final long b3 = 5313366505322983510L;
    protected static final int c3 = 2048;
    protected char[] X;
    protected CharVector X2;
    protected char[] Y;
    protected char Y2;
    protected char[] Z;
    protected char Z2;
    protected int a3;
    protected char[] s;

    public class Iterator implements Enumeration<String> {

        /* renamed from: a  reason: collision with root package name */
        int f26855a = -1;

        /* renamed from: b  reason: collision with root package name */
        String f26856b;

        /* renamed from: c  reason: collision with root package name */
        Stack<Item> f26857c = new Stack<>();

        /* renamed from: d  reason: collision with root package name */
        StringBuffer f26858d = new StringBuffer();

        private class Item implements Cloneable {
            char X;
            char s;

            public Item() {
                this.s = 0;
                this.X = 0;
            }

            /* renamed from: a */
            public Item clone() {
                return new Item(this.s, this.X);
            }

            public Item(char c2, char c3) {
                this.s = c2;
                this.X = c3;
            }
        }

        public Iterator() {
            c();
        }

        /* JADX WARNING: type inference failed for: r4v1, types: [int] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int d() {
            /*
                r8 = this;
                int r0 = r8.f26855a
                r1 = -1
                if (r0 != r1) goto L_0x0006
                return r1
            L_0x0006:
                r0 = 0
                r2 = 0
            L_0x0008:
                int r3 = r8.f26855a
                r4 = 65535(0xffff, float:9.1834E-41)
                if (r3 == 0) goto L_0x0037
                com.itextpdf.text.pdf.hyphenation.TernaryTree r5 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                char[] r5 = r5.Z
                char r5 = r5[r3]
                r6 = 1
                if (r5 != r4) goto L_0x001a
            L_0x0018:
                r2 = 1
                goto L_0x0037
            L_0x001a:
                java.util.Stack<com.itextpdf.text.pdf.hyphenation.TernaryTree$Iterator$Item> r5 = r8.f26857c
                com.itextpdf.text.pdf.hyphenation.TernaryTree$Iterator$Item r7 = new com.itextpdf.text.pdf.hyphenation.TernaryTree$Iterator$Item
                char r3 = (char) r3
                r7.<init>(r3, r0)
                r5.push(r7)
                com.itextpdf.text.pdf.hyphenation.TernaryTree r3 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                char[] r5 = r3.Z
                int r7 = r8.f26855a
                char r5 = r5[r7]
                if (r5 != 0) goto L_0x0030
                goto L_0x0018
            L_0x0030:
                char[] r3 = r3.s
                char r3 = r3[r7]
                r8.f26855a = r3
                goto L_0x0008
            L_0x0037:
                if (r2 == 0) goto L_0x0072
                java.lang.StringBuffer r1 = new java.lang.StringBuffer
                java.lang.StringBuffer r2 = r8.f26858d
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                com.itextpdf.text.pdf.hyphenation.TernaryTree r2 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                char[] r3 = r2.Z
                int r5 = r8.f26855a
                char r3 = r3[r5]
                if (r3 != r4) goto L_0x006b
                char[] r2 = r2.s
                char r2 = r2[r5]
            L_0x0052:
                com.itextpdf.text.pdf.hyphenation.TernaryTree r3 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                com.itextpdf.text.pdf.hyphenation.CharVector r3 = r3.X2
                char r3 = r3.d(r2)
                if (r3 == 0) goto L_0x006b
                com.itextpdf.text.pdf.hyphenation.TernaryTree r3 = com.itextpdf.text.pdf.hyphenation.TernaryTree.this
                com.itextpdf.text.pdf.hyphenation.CharVector r3 = r3.X2
                int r4 = r2 + 1
                char r2 = r3.d(r2)
                r1.append(r2)
                r2 = r4
                goto L_0x0052
            L_0x006b:
                java.lang.String r1 = r1.toString()
                r8.f26856b = r1
                return r0
            L_0x0072:
                int r3 = r8.e()
                r8.f26855a = r3
                if (r3 != r1) goto L_0x0008
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator.d():int");
        }

        private int e() {
            new Item();
            if (this.f26857c.empty()) {
                return -1;
            }
            int i2 = this.f26855a;
            if (i2 != 0) {
                TernaryTree ternaryTree = TernaryTree.this;
                if (ternaryTree.Z[i2] == 0) {
                    return ternaryTree.s[i2];
                }
            }
            boolean z = true;
            char c2 = 0;
            while (z) {
                Item pop = this.f26857c.pop();
                char c3 = (char) (pop.X + 1);
                pop.X = c3;
                if (c3 == 1) {
                    TernaryTree ternaryTree2 = TernaryTree.this;
                    char[] cArr = ternaryTree2.Z;
                    char c4 = pop.s;
                    if (cArr[c4] != 0) {
                        c2 = ternaryTree2.Y[c4];
                        this.f26857c.push(pop.clone());
                        this.f26858d.append(TernaryTree.this.Z[pop.s]);
                    } else {
                        pop.X = (char) (c3 + 1);
                        this.f26857c.push(pop.clone());
                        c2 = TernaryTree.this.X[pop.s];
                    }
                } else if (c3 == 2) {
                    c2 = TernaryTree.this.X[pop.s];
                    this.f26857c.push(pop.clone());
                    if (this.f26858d.length() > 0) {
                        StringBuffer stringBuffer = this.f26858d;
                        stringBuffer.setLength(stringBuffer.length() - 1);
                    }
                } else if (this.f26857c.empty()) {
                    return -1;
                } else {
                    z = true;
                }
                z = false;
            }
            return c2;
        }

        public char a() {
            int i2 = this.f26855a;
            if (i2 >= 0) {
                return TernaryTree.this.Y[i2];
            }
            return 0;
        }

        /* renamed from: b */
        public String nextElement() {
            String str = this.f26856b;
            this.f26855a = e();
            d();
            return str;
        }

        public void c() {
            this.f26857c.removeAllElements();
            this.f26858d.setLength(0);
            this.f26855a = TernaryTree.this.Y2;
            d();
        }

        public boolean hasMoreElements() {
            return this.f26855a != -1;
        }
    }

    TernaryTree() {
        h();
    }

    private void d(CharVector charVector, TernaryTree ternaryTree, char c2) {
        if (c2 != 0) {
            if (this.Z[c2] == 65535) {
                int g2 = ternaryTree.g(this.X2.e(), this.s[c2]);
                if (g2 < 0) {
                    g2 = charVector.a(x(this.X2.e(), this.s[c2]) + 1);
                    v(charVector.e(), g2, this.X2.e(), this.s[c2]);
                    ternaryTree.m(charVector.e(), g2, (char) g2);
                }
                this.s[c2] = (char) g2;
                return;
            }
            d(charVector, ternaryTree, this.s[c2]);
            if (this.Z[c2] != 0) {
                d(charVector, ternaryTree, this.Y[c2]);
            }
            d(charVector, ternaryTree, this.X[c2]);
        }
    }

    private char i(char c2, char[] cArr, int i2, char c4) {
        int x = x(cArr, i2);
        if (c2 == 0) {
            char c5 = this.Z2;
            this.Z2 = (char) (c5 + 1);
            this.Y[c5] = c4;
            this.a3++;
            this.X[c5] = 0;
            if (x > 0) {
                this.Z[c5] = CharCompanionObject.f28914c;
                this.s[c5] = (char) this.X2.a(x + 1);
                v(this.X2.e(), this.s[c5], cArr, i2);
            } else {
                this.Z[c5] = 0;
                this.s[c5] = 0;
            }
            return c5;
        }
        char[] cArr2 = this.Z;
        if (cArr2[c2] == 65535) {
            char c6 = this.Z2;
            this.Z2 = (char) (c6 + 1);
            char[] cArr3 = this.s;
            cArr3[c6] = cArr3[c2];
            char[] cArr4 = this.Y;
            cArr4[c6] = cArr4[c2];
            cArr3[c2] = 0;
            if (x > 0) {
                cArr2[c2] = this.X2.d(cArr3[c6]);
                this.Y[c2] = c6;
                char[] cArr5 = this.s;
                char c7 = (char) (cArr5[c6] + 1);
                cArr5[c6] = c7;
                if (this.X2.d(c7) == 0) {
                    this.s[c6] = 0;
                    this.Z[c6] = 0;
                    this.X[c6] = 0;
                } else {
                    this.Z[c6] = CharCompanionObject.f28914c;
                }
            } else {
                cArr2[c6] = CharCompanionObject.f28914c;
                this.X[c2] = c6;
                cArr2[c2] = 0;
                cArr4[c2] = c4;
                this.a3++;
                return c2;
            }
        }
        char c8 = cArr[i2];
        char c9 = this.Z[c2];
        if (c8 < c9) {
            char[] cArr6 = this.s;
            cArr6[c2] = i(cArr6[c2], cArr, i2, c4);
        } else if (c8 != c9) {
            char[] cArr7 = this.X;
            cArr7[c2] = i(cArr7[c2], cArr, i2, c4);
        } else if (c8 != 0) {
            char[] cArr8 = this.Y;
            cArr8[c2] = i(cArr8[c2], cArr, i2 + 1, c4);
        } else {
            this.Y[c2] = c4;
        }
        return c2;
    }

    private void r(int i2) {
        char[] cArr = this.s;
        int length = i2 < cArr.length ? i2 : cArr.length;
        char[] cArr2 = new char[i2];
        System.arraycopy(cArr, 0, cArr2, 0, length);
        this.s = cArr2;
        char[] cArr3 = new char[i2];
        System.arraycopy(this.X, 0, cArr3, 0, length);
        this.X = cArr3;
        char[] cArr4 = new char[i2];
        System.arraycopy(this.Y, 0, cArr4, 0, length);
        this.Y = cArr4;
        char[] cArr5 = new char[i2];
        System.arraycopy(this.Z, 0, cArr5, 0, length);
        this.Z = cArr5;
    }

    public static int t(String str, char[] cArr, int i2) {
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            char c2 = cArr[i2 + i3];
            int i4 = charAt - c2;
            if (i4 != 0 || c2 == 0) {
                return i4;
            }
            i3++;
        }
        char c4 = cArr[i2 + i3];
        if (c4 != 0) {
            return -c4;
        }
        return 0;
    }

    public static int u(char[] cArr, int i2, char[] cArr2, int i3) {
        while (true) {
            char c2 = cArr[i2];
            char c4 = cArr2[i3];
            if (c2 != c4) {
                return c2 - c4;
            }
            if (c2 == 0) {
                return 0;
            }
            i2++;
            i3++;
        }
    }

    public static void v(char[] cArr, int i2, char[] cArr2, int i3) {
        while (true) {
            char c2 = cArr2[i3];
            if (c2 != 0) {
                i3++;
                cArr[i2] = c2;
                i2++;
            } else {
                cArr[i2] = 0;
                return;
            }
        }
    }

    public static int w(char[] cArr) {
        return x(cArr, 0);
    }

    public static int x(char[] cArr, int i2) {
        int i3 = 0;
        while (i2 < cArr.length && cArr[i2] != 0) {
            i3++;
            i2++;
        }
        return i3;
    }

    public void a() {
        int i2 = this.a3;
        String[] strArr = new String[i2];
        char[] cArr = new char[i2];
        Iterator iterator = new Iterator();
        int i3 = 0;
        while (iterator.hasMoreElements()) {
            cArr[i3] = iterator.a();
            strArr[i3] = iterator.nextElement();
            i3++;
        }
        h();
        n(strArr, cArr, 0, i2);
    }

    public Object clone() {
        TernaryTree ternaryTree = new TernaryTree();
        ternaryTree.s = (char[]) this.s.clone();
        ternaryTree.X = (char[]) this.X.clone();
        ternaryTree.Y = (char[]) this.Y.clone();
        ternaryTree.Z = (char[]) this.Z.clone();
        ternaryTree.X2 = (CharVector) this.X2.clone();
        ternaryTree.Y2 = this.Y2;
        ternaryTree.Z2 = this.Z2;
        ternaryTree.a3 = this.a3;
        return ternaryTree;
    }

    public int e(String str) {
        int length = str.length();
        char[] cArr = new char[(length + 1)];
        str.getChars(0, length, cArr, 0);
        cArr[length] = 0;
        return g(cArr, 0);
    }

    public int g(char[] cArr, int i2) {
        char c2 = this.Y2;
        while (c2 != 0) {
            char c4 = this.Z[c2];
            if (c4 != 65535) {
                char c5 = cArr[i2];
                int i3 = c5 - c4;
                if (i3 != 0) {
                    c2 = i3 < 0 ? this.s[c2] : this.X[c2];
                } else if (c5 == 0) {
                    return this.Y[c2];
                } else {
                    i2++;
                    c2 = this.Y[c2];
                }
            } else if (u(cArr, i2, this.X2.e(), this.s[c2]) == 0) {
                return this.Y[c2];
            } else {
                return -1;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void h() {
        this.Y2 = 0;
        this.Z2 = 1;
        this.a3 = 0;
        this.s = new char[2048];
        this.X = new char[2048];
        this.Y = new char[2048];
        this.Z = new char[2048];
        this.X2 = new CharVector();
    }

    public void l(String str, char c2) {
        int length = str.length();
        int i2 = length + 1;
        int i3 = this.Z2 + i2;
        char[] cArr = this.Y;
        if (i3 > cArr.length) {
            r(cArr.length + 2048);
        }
        char[] cArr2 = new char[i2];
        str.getChars(0, length, cArr2, 0);
        cArr2[length] = 0;
        this.Y2 = i(this.Y2, cArr2, 0, c2);
    }

    public void m(char[] cArr, int i2, char c2) {
        int w = this.Z2 + w(cArr) + 1;
        char[] cArr2 = this.Y;
        if (w > cArr2.length) {
            r(cArr2.length + 2048);
        }
        this.Y2 = i(this.Y2, cArr, i2, c2);
    }

    /* access modifiers changed from: protected */
    public void n(String[] strArr, char[] cArr, int i2, int i3) {
        if (i3 >= 1) {
            int i4 = i3 >> 1;
            int i5 = i4 + i2;
            l(strArr[i5], cArr[i5]);
            n(strArr, cArr, i2, i4);
            n(strArr, cArr, i5 + 1, (i3 - i4) - 1);
        }
    }

    public Enumeration<String> o() {
        return new Iterator();
    }

    public boolean p(String str) {
        return e(str) >= 0;
    }

    public void q() {
        PrintStream printStream = System.out;
        printStream.println("Number of keys = " + Integer.toString(this.a3));
        printStream.println("Node count = " + Integer.toString(this.Z2));
        printStream.println("Key Array length = " + Integer.toString(this.X2.f()));
    }

    public int s() {
        return this.a3;
    }

    public void y() {
        a();
        r(this.Z2);
        CharVector charVector = new CharVector();
        charVector.a(1);
        d(charVector, new TernaryTree(), this.Y2);
        this.X2 = charVector;
        charVector.h();
    }
}
