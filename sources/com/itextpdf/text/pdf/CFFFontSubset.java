package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.CFFFont;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public class CFFFontSubset extends CFFFont {
    static final String[] H = {"RESERVED_0", "hstem", "RESERVED_2", "vstem", "vmoveto", "rlineto", "hlineto", "vlineto", "rrcurveto", "RESERVED_9", "callsubr", "return", "escape", "RESERVED_13", "endchar", "RESERVED_15", "RESERVED_16", "RESERVED_17", "hstemhm", "hintmask", "cntrmask", "rmoveto", "hmoveto", "vstemhm", "rcurveline", "rlinecurve", "vvcurveto", "hhcurveto", "shortint", "callgsubr", "vhcurveto", "hvcurveto"};
    static final String[] I = {"RESERVED_0", "RESERVED_1", "RESERVED_2", "and", "or", "not", "RESERVED_6", "RESERVED_7", "RESERVED_8", "abs", "add", "sub", "div", "RESERVED_13", "neg", "eq", "RESERVED_16", "RESERVED_17", "drop", "RESERVED_19", "put", "get", "ifelse", "random", "mul", "RESERVED_25", "sqrt", "dup", "exch", "index", "roll", "RESERVED_31", "RESERVED_32", "RESERVED_33", "hflex", "flex", "hflex1", "flex1", "RESERVED_REST"};
    static final byte J = 14;
    static final byte K = 11;
    byte[][] A;
    byte[] B;
    byte[] C;
    byte[] D;
    int E;
    LinkedList<CFFFont.Item> F;
    int G;
    HashMap<Integer, int[]> r;
    ArrayList<Integer> s;
    HashSet<Integer> t = new HashSet<>();
    HashMap<Integer, int[]>[] u;
    ArrayList<Integer>[] v;
    HashMap<Integer, int[]> w = new HashMap<>();
    ArrayList<Integer> x = new ArrayList<>();
    HashMap<Integer, int[]> y = new HashMap<>();
    ArrayList<Integer> z = new ArrayList<>();

    public CFFFontSubset(RandomAccessFileOrArray randomAccessFileOrArray, HashMap<Integer, int[]> hashMap) {
        super(randomAccessFileOrArray);
        int i2 = 0;
        this.E = 0;
        this.G = 0;
        this.r = hashMap;
        this.s = new ArrayList<>(hashMap.keySet());
        while (true) {
            CFFFont.Font[] fontArr = this.o;
            if (i2 < fontArr.length) {
                p(fontArr[i2].f25989g);
                this.o[i2].o = d();
                p(this.f25974i);
                this.o[i2].p = d() + CFFFont.q.length;
                CFFFont.Font font = this.o[i2];
                font.r = h(font.f25989g);
                if (this.o[i2].f25993k >= 0) {
                    b0(i2);
                    r(i2);
                }
                if (this.o[i2].f25985c) {
                    U(i2);
                }
                CFFFont.Font font2 = this.o[i2];
                font2.q = E(font2.f25991i, font2.o);
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public int A(int i2, int i3) {
        p(i2);
        char d2 = d();
        if (this.o[i3].w == 1) {
            return 0;
        }
        if (d2 < 1240) {
            return 107;
        }
        return d2 < 33900 ? 1131 : 32768;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.Integer} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int B(int r9, int r10, int r11, int r12, int[] r13) {
        /*
            r8 = this;
        L_0x0000:
            r8.p(r9)
        L_0x0003:
            int r9 = r8.l()
            if (r9 >= r10) goto L_0x0090
            r8.T()
            int r9 = r8.l()
            int r0 = r8.f25969d
            if (r0 <= 0) goto L_0x001b
            java.lang.Object[] r1 = r8.f25968c
            int r2 = r0 + -1
            r1 = r1[r2]
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            r8.O()
            java.lang.String r2 = r8.f25967b
            java.lang.String r3 = "callsubr"
            if (r2 != r3) goto L_0x003c
            if (r0 <= 0) goto L_0x0003
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r0 = r1.intValue()
            int r0 = r0 + r11
            r2 = r13[r0]
            int r0 = r0 + 1
            r3 = r13[r0]
            r1 = r8
            r4 = r11
            r5 = r12
            r6 = r13
            r1.B(r2, r3, r4, r5, r6)
            goto L_0x0000
        L_0x003c:
            java.lang.String r3 = "callgsubr"
            if (r2 != r3) goto L_0x0059
            if (r0 <= 0) goto L_0x0003
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r0 = r1.intValue()
            int r0 = r0 + r12
            int[] r1 = r8.f25979n
            r3 = r1[r0]
            int r0 = r0 + 1
            r4 = r1[r0]
            r2 = r8
            r5 = r11
            r6 = r12
            r7 = r13
            r2.B(r3, r4, r5, r6, r7)
            goto L_0x0000
        L_0x0059:
            java.lang.String r9 = "hstem"
            if (r2 == r9) goto L_0x0087
            java.lang.String r9 = "vstem"
            if (r2 == r9) goto L_0x0087
            java.lang.String r9 = "hstemhm"
            if (r2 == r9) goto L_0x0087
            java.lang.String r9 = "vstemhm"
            if (r2 != r9) goto L_0x006a
            goto L_0x0087
        L_0x006a:
            java.lang.String r9 = "hintmask"
            if (r2 == r9) goto L_0x0072
            java.lang.String r9 = "cntrmask"
            if (r2 != r9) goto L_0x0003
        L_0x0072:
            int r9 = r8.G
            int r0 = r9 / 8
            int r9 = r9 % 8
            if (r9 != 0) goto L_0x007c
            if (r0 != 0) goto L_0x007e
        L_0x007c:
            int r0 = r0 + 1
        L_0x007e:
            r9 = 0
        L_0x007f:
            if (r9 >= r0) goto L_0x0003
            r8.e()
            int r9 = r9 + 1
            goto L_0x007f
        L_0x0087:
            int r9 = r8.G
            int r0 = r0 / 2
            int r9 = r9 + r0
            r8.G = r9
            goto L_0x0003
        L_0x0090:
            int r9 = r8.G
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.CFFFontSubset.B(int, int, int, int, int[]):int");
    }

    /* access modifiers changed from: package-private */
    public int C(int i2, int i3) {
        p(i2);
        int i4 = 0;
        while (l() < i2 + i3) {
            int l2 = l();
            f();
            int l3 = l();
            if (this.f25967b == "Subrs") {
                i4 = (l3 - l2) - 1;
            }
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public void D() {
        p(0);
        e();
        e();
        char e2 = e();
        e();
        this.f25966a = e2;
        this.F.addLast(new CFFFont.RangeItem(this.f25970e, 0, e2));
    }

    /* access modifiers changed from: package-private */
    public int E(int i2, int i3) {
        int F2;
        p(i2);
        char e2 = e();
        if (e2 == 0) {
            return (i3 * 2) + 1;
        }
        if (e2 == 1) {
            F2 = F(i3, 1) * 3;
        } else if (e2 != 2) {
            return 0;
        } else {
            F2 = F(i3, 2) * 4;
        }
        return F2 + 1;
    }

    /* access modifiers changed from: package-private */
    public int F(int i2, int i3) {
        int i4 = 0;
        int i5 = 1;
        while (i5 < i2) {
            i4++;
            d();
            i5 += (i3 == 1 ? e() : d()) + 1;
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public void G(CFFFont.OffsetItem offsetItem, int i2) {
        this.F.addLast(new CFFFont.MarkerItem(offsetItem));
        this.F.addLast(new CFFFont.UInt8Item(2));
        this.F.addLast(new CFFFont.UInt16Item(1));
        this.F.addLast(new CFFFont.UInt16Item((char) (i2 - 1)));
    }

    /* access modifiers changed from: protected */
    public void H(CFFFont.OffsetItem offsetItem, CFFFont.OffsetItem offsetItem2, int i2) {
        this.F.addLast(new CFFFont.MarkerItem(offsetItem));
        u(1, 1, 1);
        CFFFont.IndexOffsetItem indexOffsetItem = new CFFFont.IndexOffsetItem(1);
        this.F.addLast(indexOffsetItem);
        CFFFont.IndexBaseItem indexBaseItem = new CFFFont.IndexBaseItem();
        this.F.addLast(indexBaseItem);
        CFFFont.Font font = this.o[i2];
        int i3 = font.f25987e;
        int C2 = C(font.f25986d, i3);
        if (C2 != 0) {
            i3 += 5 - C2;
        }
        this.F.addLast(new CFFFont.DictNumberItem(i3));
        this.F.addLast(offsetItem2);
        this.F.addLast(new CFFFont.UInt8Item(18));
        this.F.addLast(new CFFFont.IndexMarkerItem(indexOffsetItem, indexBaseItem));
    }

    /* access modifiers changed from: protected */
    public void I(CFFFont.OffsetItem offsetItem, int i2) {
        this.F.addLast(new CFFFont.MarkerItem(offsetItem));
        this.F.addLast(new CFFFont.UInt8Item(3));
        this.F.addLast(new CFFFont.UInt16Item(1));
        this.F.addLast(new CFFFont.UInt16Item(0));
        this.F.addLast(new CFFFont.UInt8Item(0));
        this.F.addLast(new CFFFont.UInt16Item((char) i2));
    }

    /* access modifiers changed from: protected */
    public void J(CFFFont.OffsetItem offsetItem, CFFFont.OffsetItem offsetItem2, CFFFont.OffsetItem offsetItem3, CFFFont.OffsetItem offsetItem4) {
        this.F.addLast(offsetItem);
        this.F.addLast(new CFFFont.UInt8Item(12));
        this.F.addLast(new CFFFont.UInt8Item('$'));
        this.F.addLast(offsetItem2);
        this.F.addLast(new CFFFont.UInt8Item(12));
        this.F.addLast(new CFFFont.UInt8Item('%'));
        this.F.addLast(offsetItem3);
        this.F.addLast(new CFFFont.UInt8Item(15));
        this.F.addLast(offsetItem4);
        this.F.addLast(new CFFFont.UInt8Item(17));
    }

    /* access modifiers changed from: protected */
    public void K(int i2) {
        String str = this.o[i2].f25983a + "-OneRange";
        if (str.length() > 127) {
            str = str.substring(0, WorkQueueKt.f29430c);
        }
        String str2 = "AdobeIdentity" + str;
        int[] iArr = this.f25978m;
        int i3 = iArr[iArr.length - 1];
        int i4 = iArr[0];
        int i5 = i3 - i4;
        int i6 = i4 - 1;
        int i7 = str2.length() + i5 <= 255 ? 1 : str2.length() + i5 <= 65535 ? 2 : str2.length() + i5 <= 16777215 ? 3 : 4;
        this.F.addLast(new CFFFont.UInt16Item((char) (this.f25978m.length + 2)));
        this.F.addLast(new CFFFont.UInt8Item((char) i7));
        for (int i8 : this.f25978m) {
            this.F.addLast(new CFFFont.IndexOffsetItem(i7, i8 - i6));
        }
        int[] iArr2 = this.f25978m;
        int i9 = iArr2[iArr2.length - 1] - i6;
        this.F.addLast(new CFFFont.IndexOffsetItem(i7, i9 + 5));
        int i10 = i9 + 13;
        this.F.addLast(new CFFFont.IndexOffsetItem(i7, i10));
        this.F.addLast(new CFFFont.IndexOffsetItem(i7, i10 + str.length()));
        this.F.addLast(new CFFFont.RangeItem(this.f25970e, this.f25978m[0], i5));
        this.F.addLast(new CFFFont.StringItem(str2));
    }

    /* access modifiers changed from: package-private */
    public void L(int i2, CFFFont.OffsetItem offsetItem) {
        p(this.o[i2].f25986d);
        while (true) {
            int l2 = l();
            CFFFont.Font font = this.o[i2];
            if (l2 < font.f25986d + font.f25987e) {
                int l3 = l();
                f();
                int l4 = l();
                if (this.f25967b == "Subrs") {
                    this.F.addLast(offsetItem);
                    this.F.addLast(new CFFFont.UInt8Item(19));
                } else {
                    this.F.addLast(new CFFFont.RangeItem(this.f25970e, l3, l4 - l3));
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void M(int i2, CFFFont.IndexBaseItem indexBaseItem, CFFFont.OffsetItem offsetItem) {
        this.F.addLast(new CFFFont.SubrMarkerItem(offsetItem, indexBaseItem));
        byte[] bArr = this.B;
        if (bArr != null) {
            this.F.addLast(new CFFFont.RangeItem(new RandomAccessFileOrArray(bArr), 0, this.B.length));
        }
    }

    /* access modifiers changed from: protected */
    public void N() {
        for (int i2 = 0; i2 < this.f25969d; i2++) {
            this.f25968c[i2] = null;
        }
        this.f25969d = 0;
    }

    /* access modifiers changed from: protected */
    public void O() {
        int Z = Z();
        if (Z >= 2) {
            N();
        } else if (Z == 1) {
            R();
        } else {
            int i2 = Z * -1;
            for (int i3 = 0; i3 < i2; i3++) {
                P();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void P() {
        int i2 = this.f25969d;
        if (i2 > 0) {
            this.f25968c[i2 - 1] = null;
            this.f25969d = i2 - 1;
        }
    }

    public byte[] Q(String str) throws IOException {
        try {
            this.f25970e.g();
            int i2 = 0;
            while (true) {
                CFFFont.Font[] fontArr = this.o;
                if (i2 >= fontArr.length) {
                    break;
                } else if (str.equals(fontArr[i2].f25983a)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == this.o.length) {
                try {
                    this.f25970e.close();
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                int i3 = this.f25975j;
                if (i3 >= 0) {
                    this.E = A(i3, i2);
                }
                v(i2);
                y(i2);
                byte[] w2 = w(i2);
                try {
                    this.f25970e.close();
                } catch (Exception unused2) {
                }
                return w2;
            }
        } catch (Throwable th) {
            try {
                this.f25970e.close();
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void R() {
        this.f25969d++;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.lang.Integer} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void S(int r13, int r14, int r15, int r16, java.util.HashMap<java.lang.Integer, int[]> r17, java.util.ArrayList<java.lang.Integer> r18, int[] r19) {
        /*
            r12 = this;
            r6 = r12
            r7 = r17
            r12.N()
            r8 = 0
            r6.G = r8
            r12.p(r13)
        L_0x000c:
            int r0 = r12.l()
            r9 = r14
            if (r0 >= r9) goto L_0x00ea
            r12.T()
            int r10 = r12.l()
            int r0 = r6.f25969d
            r1 = 0
            if (r0 <= 0) goto L_0x0026
            java.lang.Object[] r2 = r6.f25968c
            int r3 = r0 + -1
            r2 = r2[r3]
            goto L_0x0027
        L_0x0026:
            r2 = r1
        L_0x0027:
            r12.O()
            java.lang.String r3 = r6.f25967b
            java.lang.String r4 = "callsubr"
            if (r3 != r4) goto L_0x006d
            if (r0 <= 0) goto L_0x006a
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r0 = r2.intValue()
            int r0 = r0 + r16
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r2 = r7.containsKey(r2)
            if (r2 != 0) goto L_0x0055
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7.put(r2, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r11 = r18
            r11.add(r1)
            goto L_0x0057
        L_0x0055:
            r11 = r18
        L_0x0057:
            r1 = r19[r0]
            int r0 = r0 + 1
            r2 = r19[r0]
            r0 = r12
            r3 = r16
            r4 = r15
            r5 = r19
            r0.B(r1, r2, r3, r4, r5)
        L_0x0066:
            r12.p(r10)
            goto L_0x000c
        L_0x006a:
            r11 = r18
            goto L_0x000c
        L_0x006d:
            r11 = r18
            java.lang.String r4 = "callgsubr"
            if (r3 != r4) goto L_0x00ae
            if (r0 <= 0) goto L_0x000c
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r0 = r2.intValue()
            int r0 = r0 + r15
            java.util.HashMap<java.lang.Integer, int[]> r2 = r6.w
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            boolean r2 = r2.containsKey(r3)
            if (r2 != 0) goto L_0x009a
            java.util.HashMap<java.lang.Integer, int[]> r2 = r6.w
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r2.put(r3, r1)
            java.util.ArrayList<java.lang.Integer> r1 = r6.x
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r1.add(r2)
        L_0x009a:
            int[] r1 = r6.f25979n
            r2 = r1[r0]
            int r0 = r0 + 1
            r3 = r1[r0]
            r0 = r12
            r1 = r2
            r2 = r3
            r3 = r16
            r4 = r15
            r5 = r19
            r0.B(r1, r2, r3, r4, r5)
            goto L_0x0066
        L_0x00ae:
            java.lang.String r1 = "hstem"
            if (r3 == r1) goto L_0x00e1
            java.lang.String r1 = "vstem"
            if (r3 == r1) goto L_0x00e1
            java.lang.String r1 = "hstemhm"
            if (r3 == r1) goto L_0x00e1
            java.lang.String r1 = "vstemhm"
            if (r3 != r1) goto L_0x00bf
            goto L_0x00e1
        L_0x00bf:
            java.lang.String r1 = "hintmask"
            if (r3 == r1) goto L_0x00c7
            java.lang.String r1 = "cntrmask"
            if (r3 != r1) goto L_0x000c
        L_0x00c7:
            int r1 = r6.G
            int r0 = r0 / 2
            int r1 = r1 + r0
            r6.G = r1
            int r0 = r1 / 8
            int r1 = r1 % 8
            if (r1 != 0) goto L_0x00d6
            if (r0 != 0) goto L_0x00d8
        L_0x00d6:
            int r0 = r0 + 1
        L_0x00d8:
            r1 = 0
        L_0x00d9:
            if (r1 >= r0) goto L_0x000c
            r12.e()
            int r1 = r1 + 1
            goto L_0x00d9
        L_0x00e1:
            int r1 = r6.G
            int r0 = r0 / 2
            int r1 = r1 + r0
            r6.G = r1
            goto L_0x000c
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.CFFFontSubset.S(int, int, int, int, java.util.HashMap, java.util.ArrayList, int[]):void");
    }

    /* access modifiers changed from: protected */
    public void T() {
        String str;
        this.f25967b = null;
        boolean z2 = false;
        while (!z2) {
            char e2 = e();
            if (e2 == 28) {
                this.f25968c[this.f25969d] = Integer.valueOf((e() << 8) | e());
            } else if (e2 >= ' ' && e2 <= 246) {
                this.f25968c[this.f25969d] = Integer.valueOf(e2 - 139);
            } else if (e2 >= 247 && e2 <= 250) {
                this.f25968c[this.f25969d] = Integer.valueOf(((e2 - 247) * 256) + e() + 108);
            } else if (e2 >= 251 && e2 <= 254) {
                this.f25968c[this.f25969d] = Integer.valueOf((((-(e2 - 251)) * 256) - e()) - 108);
            } else if (e2 == 255) {
                this.f25968c[this.f25969d] = Integer.valueOf((e() << 24) | (e() << 16) | (e() << 8) | e());
            } else if (e2 <= 31 && e2 != 28) {
                if (e2 == 12) {
                    int e3 = e();
                    String[] strArr = I;
                    if (e3 > strArr.length - 1) {
                        e3 = strArr.length - 1;
                    }
                    str = strArr[e3];
                } else {
                    str = H[e2];
                }
                this.f25967b = str;
                z2 = true;
            }
            this.f25969d++;
        }
    }

    /* access modifiers changed from: protected */
    public void U(int i2) {
        p(this.o[i2].f25992j);
        this.o[i2].x = d();
        this.o[i2].y = e();
        CFFFont.Font font = this.o[i2];
        int i3 = font.y;
        if (i3 < 4) {
            font.y = i3 + 1;
        }
        font.z = h(font.f25992j);
    }

    /* access modifiers changed from: package-private */
    public void V(int i2) {
        CFFFont.Font font = this.o[i2];
        CFFFont.DictOffsetItem[] dictOffsetItemArr = new CFFFont.DictOffsetItem[(font.z.length - 1)];
        int[] iArr = font.f25994l;
        CFFFont.IndexBaseItem[] indexBaseItemArr = new CFFFont.IndexBaseItem[iArr.length];
        CFFFont.DictOffsetItem[] dictOffsetItemArr2 = new CFFFont.DictOffsetItem[iArr.length];
        W(i2, dictOffsetItemArr);
        X(i2, dictOffsetItemArr, indexBaseItemArr, dictOffsetItemArr2);
        Y(i2, indexBaseItemArr, dictOffsetItemArr2);
    }

    /* access modifiers changed from: package-private */
    public void W(int i2, CFFFont.OffsetItem[] offsetItemArr) {
        int i3;
        CFFFont.Font font = this.o[i2];
        u(font.x, font.y, 1);
        CFFFont.IndexOffsetItem[] indexOffsetItemArr = new CFFFont.IndexOffsetItem[(this.o[i2].z.length - 1)];
        int i4 = 0;
        while (true) {
            CFFFont.Font font2 = this.o[i2];
            if (i4 >= font2.z.length - 1) {
                break;
            }
            CFFFont.IndexOffsetItem indexOffsetItem = new CFFFont.IndexOffsetItem(font2.y);
            indexOffsetItemArr[i4] = indexOffsetItem;
            this.F.addLast(indexOffsetItem);
            i4++;
        }
        CFFFont.IndexBaseItem indexBaseItem = new CFFFont.IndexBaseItem();
        this.F.addLast(indexBaseItem);
        int i5 = 0;
        while (true) {
            int[] iArr = this.o[i2].z;
            if (i5 < iArr.length - 1) {
                p(iArr[i5]);
                while (true) {
                    i3 = i5 + 1;
                    if (l() >= this.o[i2].z[i3]) {
                        break;
                    }
                    int l2 = l();
                    f();
                    int l3 = l();
                    if (this.f25967b == "Private") {
                        int intValue = ((Integer) this.f25968c[0]).intValue();
                        CFFFont.Font font3 = this.o[i2];
                        int C2 = C(font3.f25994l[i5], font3.f25995m[i5]);
                        if (C2 != 0) {
                            intValue += 5 - C2;
                        }
                        this.F.addLast(new CFFFont.DictNumberItem(intValue));
                        CFFFont.DictOffsetItem dictOffsetItem = new CFFFont.DictOffsetItem();
                        offsetItemArr[i5] = dictOffsetItem;
                        this.F.addLast(dictOffsetItem);
                        this.F.addLast(new CFFFont.UInt8Item(18));
                        p(l3);
                    } else {
                        this.F.addLast(new CFFFont.RangeItem(this.f25970e, l2, l3 - l2));
                    }
                }
                this.F.addLast(new CFFFont.IndexMarkerItem(indexOffsetItemArr[i5], indexBaseItem));
                i5 = i3;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void X(int i2, CFFFont.OffsetItem[] offsetItemArr, CFFFont.IndexBaseItem[] indexBaseItemArr, CFFFont.OffsetItem[] offsetItemArr2) {
        for (int i3 = 0; i3 < this.o[i2].f25994l.length; i3++) {
            this.F.addLast(new CFFFont.MarkerItem(offsetItemArr[i3]));
            CFFFont.IndexBaseItem indexBaseItem = new CFFFont.IndexBaseItem();
            indexBaseItemArr[i3] = indexBaseItem;
            this.F.addLast(indexBaseItem);
            p(this.o[i2].f25994l[i3]);
            while (true) {
                int l2 = l();
                CFFFont.Font font = this.o[i2];
                if (l2 >= font.f25994l[i3] + font.f25995m[i3]) {
                    break;
                }
                int l3 = l();
                f();
                int l4 = l();
                if (this.f25967b == "Subrs") {
                    CFFFont.DictOffsetItem dictOffsetItem = new CFFFont.DictOffsetItem();
                    offsetItemArr2[i3] = dictOffsetItem;
                    this.F.addLast(dictOffsetItem);
                    this.F.addLast(new CFFFont.UInt8Item(19));
                } else {
                    this.F.addLast(new CFFFont.RangeItem(this.f25970e, l3, l4 - l3));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(int i2, CFFFont.IndexBaseItem[] indexBaseItemArr, CFFFont.OffsetItem[] offsetItemArr) {
        int i3 = 0;
        while (true) {
            CFFFont.Font font = this.o[i2];
            if (i3 < font.f25995m.length) {
                CFFFont.OffsetItem offsetItem = offsetItemArr[i3];
                if (offsetItem != null && font.A[i3] >= 0) {
                    this.F.addLast(new CFFFont.SubrMarkerItem(offsetItem, indexBaseItemArr[i3]));
                    byte[] bArr = this.A[i3];
                    if (bArr != null) {
                        this.F.addLast(new CFFFont.RangeItem(new RandomAccessFileOrArray(bArr), 0, this.A[i3].length));
                    }
                }
                i3++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public int Z() {
        String str = this.f25967b;
        if (str == "ifelse") {
            return -3;
        }
        if (str == "roll" || str == "put") {
            return -2;
        }
        if (str == "callsubr" || str == "callgsubr" || str == "add" || str == "sub" || str == "div" || str == "mul" || str == "drop" || str == "and" || str == "or" || str == "eq") {
            return -1;
        }
        if (str == "abs" || str == "neg" || str == "sqrt" || str == "exch" || str == "index" || str == "get" || str == "not" || str == "return") {
            return 0;
        }
        return (str == "random" || str == "dup") ? 1 : 2;
    }

    /* access modifiers changed from: protected */
    public int a0(int i2) {
        p(i2);
        char d2 = d();
        if (d2 == 0) {
            return 2;
        }
        char e2 = e();
        p(i2 + 3 + (d2 * e2));
        return ((d2 + 1) * e2) + 3 + (k(e2) - 1);
    }

    /* access modifiers changed from: protected */
    public void b0(int i2) {
        CFFFont.Font font = this.o[i2];
        int i3 = font.o;
        int[] iArr = new int[i3];
        p(font.f25993k);
        this.o[i2].v = e();
        int i4 = this.o[i2].v;
        if (i4 == 0) {
            for (int i5 = 0; i5 < i3; i5++) {
                iArr[i5] = e();
            }
            CFFFont.Font font2 = this.o[i2];
            font2.u = font2.o + 1;
        } else if (i4 == 3) {
            char d2 = d();
            char d3 = d();
            int i6 = 0;
            int i7 = 0;
            while (i6 < d2) {
                int e2 = e();
                char d4 = d();
                int i8 = d4 - d3;
                for (int i9 = 0; i9 < i8; i9++) {
                    iArr[i7] = e2;
                    i7++;
                }
                i6++;
                d3 = d4;
            }
            this.o[i2].u = (d2 * 3) + 5;
        }
        this.o[i2].t = iArr;
    }

    /* access modifiers changed from: protected */
    public byte[] q(int[] iArr, byte[] bArr) {
        int[] iArr2 = iArr;
        byte[] bArr2 = bArr;
        char length = (char) (iArr2.length - 1);
        int i2 = iArr2[iArr2.length - 1];
        byte b2 = i2 <= 255 ? 1 : i2 <= 65535 ? 2 : i2 <= 16777215 ? (byte) 3 : 4;
        byte[] bArr3 = new byte[(((length + 1) * b2) + 3 + bArr2.length)];
        int i3 = 0;
        bArr3[0] = (byte) ((length >>> 8) & 255);
        bArr3[1] = (byte) (length & 255);
        bArr3[2] = b2;
        int i4 = 3;
        for (int i5 : iArr2) {
            int i6 = (i5 - iArr2[0]) + 1;
            if (b2 != 1) {
                if (b2 != 2) {
                    if (b2 != 3) {
                        if (b2 != 4) {
                        } else {
                            bArr3[i4] = (byte) ((i6 >>> 24) & 255);
                            i4++;
                        }
                    }
                    bArr3[i4] = (byte) ((i6 >>> 16) & 255);
                    i4++;
                }
                bArr3[i4] = (byte) ((i6 >>> 8) & 255);
                i4++;
            }
            bArr3[i4] = (byte) (i6 & 255);
            i4++;
        }
        int length2 = bArr2.length;
        while (i3 < length2) {
            bArr3[i4] = bArr2[i3];
            i3++;
            i4++;
        }
        return bArr3;
    }

    /* access modifiers changed from: protected */
    public void r(int i2) {
        int[] iArr = this.o[i2].t;
        for (int i3 = 0; i3 < this.s.size(); i3++) {
            this.t.add(Integer.valueOf(iArr[this.s.get(i3).intValue()]));
        }
    }

    /* access modifiers changed from: protected */
    public void s(int i2, int i3) {
        CFFFont.Font font;
        CFFFont.Font font2 = this.o[i2];
        font2.A[i3] = -1;
        p(font2.f25994l[i3]);
        while (true) {
            int l2 = l();
            font = this.o[i2];
            if (l2 >= font.f25994l[i3] + font.f25995m[i3]) {
                break;
            }
            f();
            if (this.f25967b == "Subrs") {
                this.o[i2].A[i3] = ((Integer) this.f25968c[0]).intValue() + this.o[i2].f25994l[i3];
            }
        }
        int i4 = font.A[i3];
        if (i4 >= 0) {
            font.B[i3] = h(i4);
        }
    }

    /* access modifiers changed from: protected */
    public void t(int i2) {
        int i3;
        int i4;
        int i5 = this.o[i2].f25988f;
        if (i5 >= 0) {
            i4 = A(i5, i2);
            i3 = this.z.size();
        } else {
            i4 = 0;
            i3 = 0;
        }
        for (int i6 = 0; i6 < this.x.size(); i6++) {
            int intValue = this.x.get(i6).intValue();
            int[] iArr = this.f25979n;
            if (intValue < iArr.length - 1 && intValue >= 0) {
                int i7 = iArr[intValue];
                int i8 = iArr[intValue + 1];
                CFFFont.Font font = this.o[i2];
                if (font.f25985c) {
                    S(i7, i8, this.E, 0, this.w, this.x, (int[]) null);
                } else {
                    S(i7, i8, this.E, i4, this.y, this.z, font.C);
                    if (i3 < this.z.size()) {
                        while (i3 < this.z.size()) {
                            int intValue2 = this.z.get(i3).intValue();
                            int[] iArr2 = this.o[i2].C;
                            if (intValue2 < iArr2.length - 1 && intValue2 >= 0) {
                                S(iArr2[intValue2], iArr2[intValue2 + 1], this.E, i4, this.y, this.z, iArr2);
                            }
                            i3++;
                        }
                        i3 = this.z.size();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void u(int i2, int i3, int i4) {
        LinkedList<CFFFont.Item> linkedList;
        Object uInt8Item;
        this.F.addLast(new CFFFont.UInt16Item((char) i2));
        this.F.addLast(new CFFFont.UInt8Item((char) i3));
        if (i3 == 1) {
            linkedList = this.F;
            uInt8Item = new CFFFont.UInt8Item((char) i4);
        } else if (i3 == 2) {
            linkedList = this.F;
            uInt8Item = new CFFFont.UInt16Item((char) i4);
        } else if (i3 == 3) {
            linkedList = this.F;
            uInt8Item = new CFFFont.UInt24Item((char) i4);
        } else if (i3 == 4) {
            linkedList = this.F;
            uInt8Item = new CFFFont.UInt32Item((char) i4);
        } else {
            return;
        }
        linkedList.addLast(uInt8Item);
    }

    /* access modifiers changed from: protected */
    public void v(int i2) throws IOException {
        this.D = x(this.o[i2].r, this.r, (byte) 14);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x021c A[LOOP:1: B:38:0x0216->B:40:0x021c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0232 A[LOOP:2: B:42:0x022c->B:44:0x0232, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x024c A[LOOP:3: B:46:0x0246->B:48:0x024c, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] w(int r14) {
        /*
            r13 = this;
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r13.F = r0
            r13.D()
            r0 = 1
            r13.u(r0, r0, r0)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r1 = r13.F
            com.itextpdf.text.pdf.CFFFont$UInt8Item r2 = new com.itextpdf.text.pdf.CFFFont$UInt8Item
            com.itextpdf.text.pdf.CFFFont$Font[] r3 = r13.o
            r3 = r3[r14]
            java.lang.String r3 = r3.f25983a
            int r3 = r3.length()
            int r3 = r3 + r0
            char r3 = (char) r3
            r2.<init>(r3)
            r1.addLast(r2)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r1 = r13.F
            com.itextpdf.text.pdf.CFFFont$StringItem r2 = new com.itextpdf.text.pdf.CFFFont$StringItem
            com.itextpdf.text.pdf.CFFFont$Font[] r3 = r13.o
            r3 = r3[r14]
            java.lang.String r3 = r3.f25983a
            r2.<init>(r3)
            r1.addLast(r2)
            r1 = 2
            r13.u(r0, r1, r0)
            com.itextpdf.text.pdf.CFFFont$IndexOffsetItem r2 = new com.itextpdf.text.pdf.CFFFont$IndexOffsetItem
            r2.<init>(r1)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r1 = r13.F
            r1.addLast(r2)
            com.itextpdf.text.pdf.CFFFont$IndexBaseItem r1 = new com.itextpdf.text.pdf.CFFFont$IndexBaseItem
            r1.<init>()
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r3 = r13.F
            r3.addLast(r1)
            com.itextpdf.text.pdf.CFFFont$DictOffsetItem r3 = new com.itextpdf.text.pdf.CFFFont$DictOffsetItem
            r3.<init>()
            com.itextpdf.text.pdf.CFFFont$DictOffsetItem r4 = new com.itextpdf.text.pdf.CFFFont$DictOffsetItem
            r4.<init>()
            com.itextpdf.text.pdf.CFFFont$DictOffsetItem r5 = new com.itextpdf.text.pdf.CFFFont$DictOffsetItem
            r5.<init>()
            com.itextpdf.text.pdf.CFFFont$DictOffsetItem r6 = new com.itextpdf.text.pdf.CFFFont$DictOffsetItem
            r6.<init>()
            com.itextpdf.text.pdf.CFFFont$DictOffsetItem r7 = new com.itextpdf.text.pdf.CFFFont$DictOffsetItem
            r7.<init>()
            com.itextpdf.text.pdf.CFFFont$Font[] r8 = r13.o
            r8 = r8[r14]
            boolean r9 = r8.f25985c
            r10 = 0
            if (r9 != 0) goto L_0x00d3
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r9 = r13.F
            com.itextpdf.text.pdf.CFFFont$DictNumberItem r11 = new com.itextpdf.text.pdf.CFFFont$DictNumberItem
            int r8 = r8.p
            r11.<init>(r8)
            r9.addLast(r11)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r8 = r13.F
            com.itextpdf.text.pdf.CFFFont$DictNumberItem r9 = new com.itextpdf.text.pdf.CFFFont$DictNumberItem
            com.itextpdf.text.pdf.CFFFont$Font[] r11 = r13.o
            r11 = r11[r14]
            int r11 = r11.p
            int r11 = r11 + r0
            r9.<init>(r11)
            r8.addLast(r9)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            com.itextpdf.text.pdf.CFFFont$DictNumberItem r8 = new com.itextpdf.text.pdf.CFFFont$DictNumberItem
            r8.<init>(r10)
            r0.addLast(r8)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            com.itextpdf.text.pdf.CFFFont$UInt8Item r8 = new com.itextpdf.text.pdf.CFFFont$UInt8Item
            r9 = 12
            r8.<init>(r9)
            r0.addLast(r8)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            com.itextpdf.text.pdf.CFFFont$UInt8Item r8 = new com.itextpdf.text.pdf.CFFFont$UInt8Item
            r11 = 30
            r8.<init>(r11)
            r0.addLast(r8)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            com.itextpdf.text.pdf.CFFFont$DictNumberItem r8 = new com.itextpdf.text.pdf.CFFFont$DictNumberItem
            com.itextpdf.text.pdf.CFFFont$Font[] r11 = r13.o
            r11 = r11[r14]
            int r11 = r11.o
            r8.<init>(r11)
            r0.addLast(r8)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            com.itextpdf.text.pdf.CFFFont$UInt8Item r8 = new com.itextpdf.text.pdf.CFFFont$UInt8Item
            r8.<init>(r9)
            r0.addLast(r8)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            com.itextpdf.text.pdf.CFFFont$UInt8Item r8 = new com.itextpdf.text.pdf.CFFFont$UInt8Item
            r9 = 34
            r8.<init>(r9)
            r0.addLast(r8)
        L_0x00d3:
            int[] r0 = r13.f25977l
            r0 = r0[r14]
            r13.p(r0)
        L_0x00da:
            int r0 = r13.l()
            int[] r8 = r13.f25977l
            int r9 = r14 + 1
            r8 = r8[r9]
            if (r0 >= r8) goto L_0x011a
            int r0 = r13.l()
            r13.f()
            int r8 = r13.l()
            java.lang.String r9 = r13.f25967b
            java.lang.String r11 = "Encoding"
            if (r9 == r11) goto L_0x00da
            java.lang.String r11 = "Private"
            if (r9 == r11) goto L_0x00da
            java.lang.String r11 = "FDSelect"
            if (r9 == r11) goto L_0x00da
            java.lang.String r11 = "FDArray"
            if (r9 == r11) goto L_0x00da
            java.lang.String r11 = "charset"
            if (r9 == r11) goto L_0x00da
            java.lang.String r11 = "CharStrings"
            if (r9 != r11) goto L_0x010c
            goto L_0x00da
        L_0x010c:
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r9 = r13.F
            com.itextpdf.text.pdf.CFFFont$RangeItem r11 = new com.itextpdf.text.pdf.CFFFont$RangeItem
            com.itextpdf.text.pdf.RandomAccessFileOrArray r12 = r13.f25970e
            int r8 = r8 - r0
            r11.<init>(r12, r0, r8)
            r9.add(r11)
            goto L_0x00da
        L_0x011a:
            r13.J(r5, r6, r3, r4)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            com.itextpdf.text.pdf.CFFFont$IndexMarkerItem r8 = new com.itextpdf.text.pdf.CFFFont$IndexMarkerItem
            r8.<init>(r2, r1)
            r0.addLast(r8)
            com.itextpdf.text.pdf.CFFFont$Font[] r0 = r13.o
            r0 = r0[r14]
            boolean r0 = r0.f25985c
            if (r0 == 0) goto L_0x013b
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            int r1 = r13.f25974i
            com.itextpdf.text.pdf.CFFFont$RangeItem r1 = r13.g(r1)
            r0.addLast(r1)
            goto L_0x013e
        L_0x013b:
            r13.K(r14)
        L_0x013e:
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            com.itextpdf.text.pdf.CFFFont$RangeItem r1 = new com.itextpdf.text.pdf.CFFFont$RangeItem
            com.itextpdf.text.pdf.RandomAccessFileOrArray r2 = new com.itextpdf.text.pdf.RandomAccessFileOrArray
            byte[] r8 = r13.C
            r2.<init>((byte[]) r8)
            byte[] r8 = r13.C
            int r8 = r8.length
            r1.<init>(r2, r10, r8)
            r0.addLast(r1)
            com.itextpdf.text.pdf.CFFFont$Font[] r0 = r13.o
            r0 = r0[r14]
            boolean r1 = r0.f25985c
            if (r1 == 0) goto L_0x01b8
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            com.itextpdf.text.pdf.CFFFont$MarkerItem r1 = new com.itextpdf.text.pdf.CFFFont$MarkerItem
            r1.<init>(r6)
            r0.addLast(r1)
            com.itextpdf.text.pdf.CFFFont$Font[] r0 = r13.o
            r0 = r0[r14]
            int r1 = r0.f25993k
            if (r1 < 0) goto L_0x017b
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r2 = r13.F
            com.itextpdf.text.pdf.CFFFont$RangeItem r6 = new com.itextpdf.text.pdf.CFFFont$RangeItem
            com.itextpdf.text.pdf.RandomAccessFileOrArray r8 = r13.f25970e
            int r0 = r0.u
            r6.<init>(r8, r1, r0)
            r2.addLast(r6)
            goto L_0x0180
        L_0x017b:
            int r0 = r0.o
            r13.I(r6, r0)
        L_0x0180:
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            com.itextpdf.text.pdf.CFFFont$MarkerItem r1 = new com.itextpdf.text.pdf.CFFFont$MarkerItem
            r1.<init>(r3)
            r0.addLast(r1)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            com.itextpdf.text.pdf.CFFFont$RangeItem r1 = new com.itextpdf.text.pdf.CFFFont$RangeItem
            com.itextpdf.text.pdf.RandomAccessFileOrArray r2 = r13.f25970e
            com.itextpdf.text.pdf.CFFFont$Font[] r3 = r13.o
            r3 = r3[r14]
            int r6 = r3.f25991i
            int r3 = r3.q
            r1.<init>(r2, r6, r3)
            r0.addLast(r1)
            com.itextpdf.text.pdf.CFFFont$Font[] r0 = r13.o
            r0 = r0[r14]
            int r0 = r0.f25992j
            if (r0 < 0) goto L_0x01b4
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            com.itextpdf.text.pdf.CFFFont$MarkerItem r1 = new com.itextpdf.text.pdf.CFFFont$MarkerItem
            r1.<init>(r5)
            r0.addLast(r1)
            r13.V(r14)
            goto L_0x01c7
        L_0x01b4:
            r13.H(r5, r7, r14)
            goto L_0x01c7
        L_0x01b8:
            int r0 = r0.o
            r13.I(r6, r0)
            com.itextpdf.text.pdf.CFFFont$Font[] r0 = r13.o
            r0 = r0[r14]
            int r0 = r0.o
            r13.G(r3, r0)
            goto L_0x01b4
        L_0x01c7:
            com.itextpdf.text.pdf.CFFFont$Font[] r0 = r13.o
            r0 = r0[r14]
            int r0 = r0.f25986d
            if (r0 < 0) goto L_0x01ee
            com.itextpdf.text.pdf.CFFFont$IndexBaseItem r0 = new com.itextpdf.text.pdf.CFFFont$IndexBaseItem
            r0.<init>()
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r1 = r13.F
            r1.addLast(r0)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r1 = r13.F
            com.itextpdf.text.pdf.CFFFont$MarkerItem r2 = new com.itextpdf.text.pdf.CFFFont$MarkerItem
            r2.<init>(r7)
            r1.addLast(r2)
            com.itextpdf.text.pdf.CFFFont$DictOffsetItem r1 = new com.itextpdf.text.pdf.CFFFont$DictOffsetItem
            r1.<init>()
            r13.L(r14, r1)
            r13.M(r14, r0, r1)
        L_0x01ee:
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r14 = r13.F
            com.itextpdf.text.pdf.CFFFont$MarkerItem r0 = new com.itextpdf.text.pdf.CFFFont$MarkerItem
            r0.<init>(r4)
            r14.addLast(r0)
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r14 = r13.F
            com.itextpdf.text.pdf.CFFFont$RangeItem r0 = new com.itextpdf.text.pdf.CFFFont$RangeItem
            com.itextpdf.text.pdf.RandomAccessFileOrArray r1 = new com.itextpdf.text.pdf.RandomAccessFileOrArray
            byte[] r2 = r13.D
            r1.<init>((byte[]) r2)
            byte[] r2 = r13.D
            int r2 = r2.length
            r0.<init>(r1, r10, r2)
            r14.addLast(r0)
            int[] r14 = new int[]{r10}
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            java.util.Iterator r0 = r0.iterator()
        L_0x0216:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0226
            java.lang.Object r1 = r0.next()
            com.itextpdf.text.pdf.CFFFont$Item r1 = (com.itextpdf.text.pdf.CFFFont.Item) r1
            r1.b(r14)
            goto L_0x0216
        L_0x0226:
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            java.util.Iterator r0 = r0.iterator()
        L_0x022c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x023c
            java.lang.Object r1 = r0.next()
            com.itextpdf.text.pdf.CFFFont$Item r1 = (com.itextpdf.text.pdf.CFFFont.Item) r1
            r1.c()
            goto L_0x022c
        L_0x023c:
            r14 = r14[r10]
            byte[] r14 = new byte[r14]
            java.util.LinkedList<com.itextpdf.text.pdf.CFFFont$Item> r0 = r13.F
            java.util.Iterator r0 = r0.iterator()
        L_0x0246:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0256
            java.lang.Object r1 = r0.next()
            com.itextpdf.text.pdf.CFFFont$Item r1 = (com.itextpdf.text.pdf.CFFFont.Item) r1
            r1.a(r14)
            goto L_0x0246
        L_0x0256:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.CFFFontSubset.w(int):byte[]");
    }

    /* access modifiers changed from: protected */
    public byte[] x(int[] iArr, HashMap<Integer, int[]> hashMap, byte b2) throws IOException {
        int[] iArr2 = new int[iArr.length];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            iArr2[i5] = i3;
            if (hashMap.containsKey(Integer.valueOf(i5))) {
                i3 += iArr[i5 + 1] - iArr[i5];
            } else {
                i4++;
            }
        }
        byte[] bArr = new byte[(i3 + i4)];
        int i6 = 0;
        while (i2 < iArr.length - 1) {
            int i7 = iArr2[i2];
            int i8 = i2 + 1;
            int i9 = iArr2[i8];
            int i10 = i7 + i6;
            iArr2[i2] = i10;
            if (i7 != i9) {
                this.f25970e.r((long) iArr[i2]);
                this.f25970e.readFully(bArr, i10, i9 - i7);
            } else {
                bArr[i10] = b2;
                i6++;
            }
            i2 = i8;
        }
        int length = iArr.length - 1;
        iArr2[length] = iArr2[length] + i6;
        return q(iArr2, bArr);
    }

    /* access modifiers changed from: protected */
    public void y(int i2) throws IOException {
        CFFFont.Font font = this.o[i2];
        if (font.f25985c) {
            int[] iArr = font.f25994l;
            this.u = new HashMap[iArr.length];
            this.v = new ArrayList[iArr.length];
            this.A = new byte[iArr.length][];
            font.A = new int[iArr.length];
            font.B = new int[iArr.length][];
            ArrayList arrayList = new ArrayList(this.t);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                int intValue = ((Integer) arrayList.get(i3)).intValue();
                this.u[intValue] = new HashMap<>();
                this.v[intValue] = new ArrayList<>();
                s(i2, intValue);
                CFFFont.Font font2 = this.o[i2];
                int i4 = font2.A[intValue];
                if (i4 >= 0) {
                    z(i2, intValue, i4, font2.B[intValue], this.u[intValue], this.v[intValue]);
                    this.A[intValue] = x(this.o[i2].B[intValue], this.u[intValue], (byte) 11);
                }
            }
        } else {
            int i5 = font.f25988f;
            if (i5 >= 0) {
                font.C = h(i5);
                CFFFont.Font font3 = this.o[i2];
                z(i2, -1, font3.f25988f, font3.C, this.y, this.z);
            }
        }
        t(i2);
        CFFFont.Font font4 = this.o[i2];
        if (font4.f25988f >= 0) {
            this.B = x(font4.C, this.y, (byte) 11);
        }
        this.C = x(this.f25979n, this.w, (byte) 11);
    }

    /* access modifiers changed from: protected */
    public void z(int i2, int i3, int i4, int[] iArr, HashMap<Integer, int[]> hashMap, ArrayList<Integer> arrayList) {
        int i5 = i2;
        int i6 = i3;
        int[] iArr2 = iArr;
        int A2 = A(i4, i5);
        for (int i7 = 0; i7 < this.s.size(); i7++) {
            int intValue = this.s.get(i7).intValue();
            int[] iArr3 = this.o[i5].r;
            int i8 = iArr3[intValue];
            int i9 = iArr3[intValue + 1];
            if (i6 >= 0) {
                N();
                this.G = 0;
                if (this.o[i5].t[intValue] == i6) {
                    S(i8, i9, this.E, A2, hashMap, arrayList, iArr);
                }
            } else {
                S(i8, i9, this.E, A2, hashMap, arrayList, iArr);
            }
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            int intValue2 = arrayList.get(i10).intValue();
            if (intValue2 < iArr2.length - 1 && intValue2 >= 0) {
                S(iArr2[intValue2], iArr2[intValue2 + 1], this.E, A2, hashMap, arrayList, iArr);
            }
        }
    }
}
