package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.SplitCharacter;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.commons.lang3.StringUtils;

public class PdfChunk {
    private static final char[] p = {' '};
    private static final float q = 0.21256f;
    private static final HashSet<String> r;
    private static final HashSet<String> s;
    private static final String t = "TABSTOP";
    public static final float u = 0.06666667f;
    public static final float v = -0.33333334f;

    /* renamed from: a  reason: collision with root package name */
    protected String f26130a;

    /* renamed from: b  reason: collision with root package name */
    protected String f26131b;

    /* renamed from: c  reason: collision with root package name */
    protected PdfFont f26132c;

    /* renamed from: d  reason: collision with root package name */
    protected BaseFont f26133d;

    /* renamed from: e  reason: collision with root package name */
    protected SplitCharacter f26134e;

    /* renamed from: f  reason: collision with root package name */
    protected HashMap<String, Object> f26135f;

    /* renamed from: g  reason: collision with root package name */
    protected HashMap<String, Object> f26136g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f26137h;

    /* renamed from: i  reason: collision with root package name */
    protected Image f26138i;

    /* renamed from: j  reason: collision with root package name */
    protected float f26139j;

    /* renamed from: k  reason: collision with root package name */
    protected float f26140k;

    /* renamed from: l  reason: collision with root package name */
    protected float f26141l;

    /* renamed from: m  reason: collision with root package name */
    protected boolean f26142m;

    /* renamed from: n  reason: collision with root package name */
    protected float f26143n;
    protected IAccessibleElement o;

    static {
        HashSet<String> hashSet = new HashSet<>();
        r = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        s = hashSet2;
        hashSet.add(Chunk.w3);
        hashSet.add(Chunk.j3);
        hashSet.add(Chunk.q3);
        hashSet.add(Chunk.r3);
        hashSet.add(Chunk.s3);
        hashSet.add(Chunk.t3);
        hashSet.add(Chunk.x3);
        hashSet.add(Chunk.v3);
        hashSet.add(Chunk.m3);
        hashSet.add(Chunk.y3);
        hashSet.add(Chunk.l3);
        hashSet.add(Chunk.i3);
        hashSet.add(Chunk.f3);
        hashSet.add(Chunk.g3);
        hashSet.add(Chunk.h3);
        hashSet.add(Chunk.B3);
        hashSet.add(Chunk.C3);
        hashSet.add(Chunk.u3);
        hashSet2.add(Chunk.k3);
        hashSet2.add(Chunk.o3);
        hashSet2.add(Chunk.p3);
        hashSet2.add(Chunk.n3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    PdfChunk(com.itextpdf.text.Chunk r17, com.itextpdf.text.pdf.PdfAction r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            r2 = 5
            r3 = 3
            r4 = 1
            r5 = 2
            r16.<init>()
            java.lang.String r6 = ""
            r0.f26130a = r6
            java.lang.String r7 = "Cp1252"
            r0.f26131b = r7
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r0.f26135f = r7
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r0.f26136g = r7
            r7 = 1065353216(0x3f800000, float:1.0)
            r0.f26139j = r7
            r7 = 0
            r0.f26142m = r7
            r8 = 0
            r0.f26143n = r8
            r8 = 0
            r0.o = r8
            java.lang.String r9 = r17.j()
            r0.f26130a = r9
            com.itextpdf.text.Font r9 = r17.k()
            float r10 = r9.m()
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 != 0) goto L_0x0044
            r10 = 1094713344(0x41400000, float:12.0)
        L_0x0044:
            com.itextpdf.text.pdf.BaseFont r11 = r9.c()
            r0.f26133d = r11
            int r11 = r9.n()
            r12 = -1
            if (r11 != r12) goto L_0x0052
            r11 = 0
        L_0x0052:
            com.itextpdf.text.pdf.BaseFont r12 = r0.f26133d
            if (r12 != 0) goto L_0x005d
            com.itextpdf.text.pdf.BaseFont r11 = r9.e(r7)
            r0.f26133d = r11
            goto L_0x008c
        L_0x005d:
            r12 = r11 & 1
            if (r12 == 0) goto L_0x007d
            java.util.HashMap<java.lang.String, java.lang.Object> r12 = r0.f26135f
            java.lang.Integer r13 = java.lang.Integer.valueOf(r5)
            java.lang.Float r14 = new java.lang.Float
            r15 = 1106247680(0x41f00000, float:30.0)
            float r15 = r10 / r15
            r14.<init>(r15)
            java.lang.Object[] r15 = new java.lang.Object[r3]
            r15[r7] = r13
            r15[r4] = r14
            r15[r5] = r8
            java.lang.String r13 = "TEXTRENDERMODE"
            r12.put(r13, r15)
        L_0x007d:
            r11 = r11 & r5
            if (r11 == 0) goto L_0x008c
            java.util.HashMap<java.lang.String, java.lang.Object> r11 = r0.f26135f
            float[] r12 = new float[r5]
            r12 = {0, 1046063444} // fill-array
            java.lang.String r13 = "SKEW"
            r11.put(r13, r12)
        L_0x008c:
            com.itextpdf.text.pdf.PdfFont r11 = new com.itextpdf.text.pdf.PdfFont
            com.itextpdf.text.pdf.BaseFont r12 = r0.f26133d
            r11.<init>(r12, r10)
            r0.f26132c = r11
            java.util.HashMap r10 = r17.h()
            if (r10 == 0) goto L_0x00e7
            java.util.Set r11 = r10.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x00a3:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x00d2
            java.lang.Object r12 = r11.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r13 = r12.getKey()
            java.lang.String r13 = (java.lang.String) r13
            java.util.HashSet<java.lang.String> r14 = r
            boolean r14 = r14.contains(r13)
            if (r14 == 0) goto L_0x00c7
            java.util.HashMap<java.lang.String, java.lang.Object> r14 = r0.f26135f
        L_0x00bf:
            java.lang.Object r12 = r12.getValue()
            r14.put(r13, r12)
            goto L_0x00a3
        L_0x00c7:
            java.util.HashSet<java.lang.String> r14 = s
            boolean r14 = r14.contains(r13)
            if (r14 == 0) goto L_0x00a3
            java.util.HashMap<java.lang.String, java.lang.Object> r14 = r0.f26136g
            goto L_0x00bf
        L_0x00d2:
            java.lang.String r11 = "GENERICTAG"
            java.lang.Object r10 = r10.get(r11)
            boolean r6 = r6.equals(r10)
            if (r6 == 0) goto L_0x00e7
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r0.f26135f
            java.lang.String r10 = r17.j()
            r6.put(r11, r10)
        L_0x00e7:
            boolean r6 = r9.u()
            java.lang.String r10 = "UNDERLINE"
            if (r6 == 0) goto L_0x010b
            float[] r6 = new float[r2]
            r6 = {0, 1032358025, 0, -1096111445, 0} // fill-array
            java.lang.Object[] r11 = new java.lang.Object[r5]
            r11[r7] = r8
            r11[r4] = r6
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r0.f26135f
            java.lang.Object r6 = r6.get(r10)
            java.lang.Object[][] r6 = (java.lang.Object[][]) r6
            java.lang.Object[][] r6 = com.itextpdf.text.Utilities.a(r6, r11)
            java.util.HashMap<java.lang.String, java.lang.Object> r11 = r0.f26135f
            r11.put(r10, r6)
        L_0x010b:
            boolean r6 = r9.s()
            if (r6 == 0) goto L_0x012d
            float[] r2 = new float[r2]
            r2 = {0, 1032358025, 0, 1051372203, 0} // fill-array
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r6[r7] = r8
            r6[r4] = r2
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.f26135f
            java.lang.Object r2 = r2.get(r10)
            java.lang.Object[][] r2 = (java.lang.Object[][]) r2
            java.lang.Object[][] r2 = com.itextpdf.text.Utilities.a(r2, r6)
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r0.f26135f
            r6.put(r10, r2)
        L_0x012d:
            if (r1 == 0) goto L_0x0136
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.f26135f
            java.lang.String r6 = "ACTION"
            r2.put(r6, r1)
        L_0x0136:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.f26136g
            java.lang.String r2 = "COLOR"
            com.itextpdf.text.BaseColor r6 = r9.i()
            r1.put(r2, r6)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.f26136g
            com.itextpdf.text.pdf.PdfFont r2 = r0.f26132c
            com.itextpdf.text.pdf.BaseFont r2 = r2.c()
            java.lang.String r2 = r2.G()
            java.lang.String r6 = "ENCODING"
            r1.put(r6, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.f26135f
            java.lang.String r2 = "LINEHEIGHT"
            java.lang.Object r1 = r1.get(r2)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r1 == 0) goto L_0x0166
            r0.f26142m = r4
            float r1 = r1.floatValue()
            r0.f26143n = r1
        L_0x0166:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.f26135f
            java.lang.String r2 = "IMAGE"
            java.lang.Object r1 = r1.get(r2)
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            java.lang.String r2 = "HSCALE"
            if (r1 != 0) goto L_0x0177
            r0.f26138i = r8
            goto L_0x01a0
        L_0x0177:
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r0.f26135f
            r6.remove(r2)
            r6 = r1[r7]
            com.itextpdf.text.Image r6 = (com.itextpdf.text.Image) r6
            r0.f26138i = r6
            r4 = r1[r4]
            java.lang.Float r4 = (java.lang.Float) r4
            float r4 = r4.floatValue()
            r0.f26140k = r4
            r4 = r1[r5]
            java.lang.Float r4 = (java.lang.Float) r4
            float r4 = r4.floatValue()
            r0.f26141l = r4
            r1 = r1[r3]
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0.f26142m = r1
        L_0x01a0:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.f26135f
            java.lang.Object r1 = r1.get(r2)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r1 == 0) goto L_0x01b3
            com.itextpdf.text.pdf.PdfFont r2 = r0.f26132c
            float r1 = r1.floatValue()
            r2.f(r1)
        L_0x01b3:
            com.itextpdf.text.pdf.PdfFont r1 = r0.f26132c
            com.itextpdf.text.pdf.BaseFont r1 = r1.c()
            java.lang.String r1 = r1.G()
            r0.f26131b = r1
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.f26136g
            java.lang.String r2 = "SPLITCHARACTER"
            java.lang.Object r1 = r1.get(r2)
            com.itextpdf.text.SplitCharacter r1 = (com.itextpdf.text.SplitCharacter) r1
            r0.f26134e = r1
            if (r1 != 0) goto L_0x01d1
            com.itextpdf.text.SplitCharacter r1 = com.itextpdf.text.pdf.DefaultSplitCharacter.f26030b
            r0.f26134e = r1
        L_0x01d1:
            r1 = r17
            r0.o = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfChunk.<init>(com.itextpdf.text.Chunk, com.itextpdf.text.pdf.PdfAction):void");
    }

    public static boolean G(int i2) {
        return (i2 >= 8203 && i2 <= 8207) || (i2 >= 8234 && i2 <= 8238);
    }

    static TabStop p(PdfChunk pdfChunk, float f2) {
        Object[] objArr = (Object[]) pdfChunk.f26135f.get(Chunk.g3);
        if (objArr == null) {
            return null;
        }
        Float f3 = (Float) objArr[0];
        return Float.isNaN(f3.floatValue()) ? TabSettings.c(f2, (TabSettings) pdfChunk.f26135f.get(Chunk.h3)) : TabStop.f(f2, f3.floatValue());
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return v(Chunk.f3);
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        return this.f26131b.equals("UnicodeBigUnmarked") || this.f26131b.equals(BaseFont.a4);
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        return !this.f26135f.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        return v(Chunk.g3);
    }

    /* access modifiers changed from: package-private */
    public int E() {
        return this.f26130a.length();
    }

    /* access modifiers changed from: package-private */
    public int F() {
        if (!BaseFont.a4.equals(this.f26131b)) {
            return this.f26130a.length();
        }
        int length = this.f26130a.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (Utilities.l(this.f26130a.charAt(i2))) {
                i2++;
            }
            i3++;
            i2++;
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public void H(float f2) {
        this.f26140k = f2;
    }

    /* access modifiers changed from: package-private */
    public void I(float f2) {
        this.f26141l = f2;
    }

    public void J(float f2) {
        this.f26139j = f2;
    }

    /* access modifiers changed from: package-private */
    public void K(TabStop tabStop) {
        this.f26135f.put(t, tabStop);
    }

    /* access modifiers changed from: package-private */
    public void L(String str) {
        this.f26130a = str;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0145, code lost:
        if (r7 != 13) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0147, code lost:
        r3 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0149, code lost:
        if (r3 >= r6) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x014d, code lost:
        if (r13[r3] != 10) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x014f, code lost:
        r15 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0151, code lost:
        r15 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0152, code lost:
        r2 = r0.f26130a.substring(r15 + r10);
        r3 = r0.f26130a.substring(0, r10);
        r0.f26130a = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0166, code lost:
        if (r3.length() >= 1) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0168, code lost:
        r0.f26130a = org.apache.commons.lang3.StringUtils.SPACE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0171, code lost:
        return new com.itextpdf.text.pdf.PdfChunk(r2, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfChunk M(float r27) {
        /*
            r26 = this;
            r0 = r26
            r1 = 1
            r2 = 0
            r0.f26137h = r2
            com.itextpdf.text.Image r3 = r0.f26138i
            java.lang.String r4 = ""
            r5 = 0
            if (r3 == 0) goto L_0x002f
            float r1 = r3.p1()
            int r1 = (r1 > r27 ? 1 : (r1 == r27 ? 0 : -1))
            if (r1 <= 0) goto L_0x002e
            com.itextpdf.text.pdf.PdfChunk r1 = new com.itextpdf.text.pdf.PdfChunk
            java.lang.String r2 = "￼"
            r1.<init>((java.lang.String) r2, (com.itextpdf.text.pdf.PdfChunk) r0)
            r0.f26130a = r4
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r0.f26135f = r2
            r0.f26138i = r5
            com.itextpdf.text.pdf.PdfFont r2 = com.itextpdf.text.pdf.PdfFont.b()
            r0.f26132c = r2
            return r1
        L_0x002e:
            return r5
        L_0x002f:
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r0.f26136g
            java.lang.String r6 = "HYPHENATION"
            java.lang.Object r3 = r3.get(r6)
            com.itextpdf.text.pdf.HyphenationEvent r3 = (com.itextpdf.text.pdf.HyphenationEvent) r3
            java.lang.String r6 = r0.f26130a
            int r6 = r6.length()
            java.lang.String r7 = r0.f26130a
            char[] r13 = r7.toCharArray()
            com.itextpdf.text.pdf.PdfFont r7 = r0.f26132c
            com.itextpdf.text.pdf.BaseFont r14 = r7.c()
            int r7 = r14.K()
            r15 = 2
            r8 = 0
            r9 = -1
            r12 = 10
            r11 = 32
            if (r7 != r15) goto L_0x00de
            int r7 = r14.V(r11)
            if (r7 == r11) goto L_0x00de
            r7 = 0
            r10 = 0
            r15 = -1
        L_0x0061:
            if (r10 >= r6) goto L_0x00da
            char r5 = r13[r10]
            int r11 = r14.V(r5)
            char r11 = (char) r11
            if (r11 != r12) goto L_0x008e
            r0.f26137h = r1
            java.lang.String r3 = r0.f26130a
            int r4 = r10 + 1
            java.lang.String r3 = r3.substring(r4)
            java.lang.String r4 = r0.f26130a
            java.lang.String r2 = r4.substring(r2, r10)
            r0.f26130a = r2
            int r2 = r2.length()
            if (r2 >= r1) goto L_0x0088
            java.lang.String r1 = "\u0001"
            r0.f26130a = r1
        L_0x0088:
            com.itextpdf.text.pdf.PdfChunk r1 = new com.itextpdf.text.pdf.PdfChunk
            r1.<init>((java.lang.String) r3, (com.itextpdf.text.pdf.PdfChunk) r0)
            return r1
        L_0x008e:
            float r5 = r0.f(r5)
            float r5 = r5 + r8
            r8 = 32
            if (r11 != r8) goto L_0x009e
            int r7 = r10 + 1
            r16 = r5
            r17 = r7
            goto L_0x00a2
        L_0x009e:
            r16 = r7
            r17 = r9
        L_0x00a2:
            int r7 = (r5 > r27 ? 1 : (r5 == r27 ? 0 : -1))
            if (r7 <= 0) goto L_0x00ac
            r7 = r16
            r9 = r17
            goto L_0x0174
        L_0x00ac:
            com.itextpdf.text.SplitCharacter r7 = r0.f26134e
            r9 = 0
            com.itextpdf.text.pdf.PdfChunk[] r11 = new com.itextpdf.text.pdf.PdfChunk[r1]
            r11[r2] = r0
            r18 = 32
            r8 = r9
            r9 = r10
            r19 = r10
            r10 = r6
            r18 = r11
            r2 = 32
            r11 = r13
            r2 = 10
            r12 = r18
            boolean r7 = r7.a(r8, r9, r10, r11, r12)
            if (r7 == 0) goto L_0x00cc
            int r10 = r19 + 1
            r15 = r10
        L_0x00cc:
            int r10 = r19 + 1
            r8 = r5
            r7 = r16
            r9 = r17
            r2 = 0
            r5 = 0
            r11 = 32
            r12 = 10
            goto L_0x0061
        L_0x00da:
            r19 = r10
            goto L_0x0174
        L_0x00de:
            r2 = 10
            r5 = 0
            r10 = 0
            r14 = -1
        L_0x00e3:
            if (r10 >= r6) goto L_0x0172
            char r7 = r13[r10]
            r11 = 13
            if (r7 == r11) goto L_0x0143
            if (r7 != r2) goto L_0x00ee
            goto L_0x0143
        L_0x00ee:
            boolean r11 = com.itextpdf.text.Utilities.o(r13, r10)
            if (r11 == 0) goto L_0x0107
            char r12 = r13[r10]
            int r16 = r10 + 1
            char r15 = r13[r16]
            int r12 = com.itextpdf.text.Utilities.e(r12, r15)
            float r12 = r0.f(r12)
        L_0x0102:
            float r8 = r8 + r12
            r15 = r8
            r12 = 32
            goto L_0x010c
        L_0x0107:
            float r12 = r0.f(r7)
            goto L_0x0102
        L_0x010c:
            if (r7 != r12) goto L_0x0114
            int r5 = r10 + 1
            r16 = r5
            r5 = r15
            goto L_0x0116
        L_0x0114:
            r16 = r9
        L_0x0116:
            if (r11 == 0) goto L_0x0119
            int r10 = r10 + r1
        L_0x0119:
            r18 = r10
            int r7 = (r15 > r27 ? 1 : (r15 == r27 ? 0 : -1))
            if (r7 <= 0) goto L_0x0126
            r7 = r5
            r15 = r14
            r9 = r16
            r10 = r18
            goto L_0x0174
        L_0x0126:
            com.itextpdf.text.SplitCharacter r7 = r0.f26134e
            r8 = 0
            r19 = 0
            r9 = r18
            r10 = r6
            r11 = r13
            r20 = 32
            r12 = r19
            boolean r7 = r7.a(r8, r9, r10, r11, r12)
            if (r7 == 0) goto L_0x013c
            int r7 = r18 + 1
            r14 = r7
        L_0x013c:
            int r10 = r18 + 1
            r8 = r15
            r9 = r16
            r15 = 2
            goto L_0x00e3
        L_0x0143:
            r0.f26137h = r1
            if (r7 != r11) goto L_0x0151
            int r3 = r10 + 1
            if (r3 >= r6) goto L_0x0151
            char r3 = r13[r3]
            if (r3 != r2) goto L_0x0151
            r15 = 2
            goto L_0x0152
        L_0x0151:
            r15 = 1
        L_0x0152:
            java.lang.String r2 = r0.f26130a
            int r15 = r15 + r10
            java.lang.String r2 = r2.substring(r15)
            java.lang.String r3 = r0.f26130a
            r4 = 0
            java.lang.String r3 = r3.substring(r4, r10)
            r0.f26130a = r3
            int r3 = r3.length()
            if (r3 >= r1) goto L_0x016c
            java.lang.String r1 = " "
            r0.f26130a = r1
        L_0x016c:
            com.itextpdf.text.pdf.PdfChunk r1 = new com.itextpdf.text.pdf.PdfChunk
            r1.<init>((java.lang.String) r2, (com.itextpdf.text.pdf.PdfChunk) r0)
            return r1
        L_0x0172:
            r7 = r5
            r15 = r14
        L_0x0174:
            if (r10 != r6) goto L_0x0178
            r1 = 0
            return r1
        L_0x0178:
            if (r15 >= 0) goto L_0x0184
            java.lang.String r1 = r0.f26130a
            r0.f26130a = r4
            com.itextpdf.text.pdf.PdfChunk r2 = new com.itextpdf.text.pdf.PdfChunk
            r2.<init>((java.lang.String) r1, (com.itextpdf.text.pdf.PdfChunk) r0)
            return r2
        L_0x0184:
            if (r9 <= r15) goto L_0x019b
            com.itextpdf.text.SplitCharacter r1 = r0.f26134e
            char[] r24 = p
            r25 = 0
            r21 = 0
            r22 = 0
            r23 = 1
            r20 = r1
            boolean r1 = r20.a(r21, r22, r23, r24, r25)
            if (r1 == 0) goto L_0x019b
            r15 = r9
        L_0x019b:
            if (r3 == 0) goto L_0x0202
            if (r9 < 0) goto L_0x0202
            if (r9 >= r10) goto L_0x0202
            java.lang.String r1 = r0.f26130a
            int r1 = r0.t(r1, r9)
            if (r1 <= r9) goto L_0x0202
            java.lang.String r2 = r0.f26130a
            java.lang.String r2 = r2.substring(r9, r1)
            com.itextpdf.text.pdf.PdfFont r4 = r0.f26132c
            com.itextpdf.text.pdf.BaseFont r4 = r4.c()
            com.itextpdf.text.pdf.PdfFont r5 = r0.f26132c
            float r5 = r5.g()
            float r6 = r27 - r7
            java.lang.String r2 = r3.c(r2, r4, r5, r6)
            java.lang.String r3 = r3.b()
            int r4 = r2.length()
            if (r4 <= 0) goto L_0x0202
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = r0.f26130a
            java.lang.String r1 = r3.substring(r1)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r0.f26130a
            r5 = 0
            java.lang.String r4 = r4.substring(r5, r9)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r2 = r0.N(r2)
            r0.f26130a = r2
            com.itextpdf.text.pdf.PdfChunk r2 = new com.itextpdf.text.pdf.PdfChunk
            r2.<init>((java.lang.String) r1, (com.itextpdf.text.pdf.PdfChunk) r0)
            return r2
        L_0x0202:
            java.lang.String r1 = r0.f26130a
            java.lang.String r1 = r1.substring(r15)
            java.lang.String r2 = r0.f26130a
            r3 = 0
            java.lang.String r2 = r2.substring(r3, r15)
            java.lang.String r2 = r0.N(r2)
            r0.f26130a = r2
            com.itextpdf.text.pdf.PdfChunk r2 = new com.itextpdf.text.pdf.PdfChunk
            r2.<init>((java.lang.String) r1, (com.itextpdf.text.pdf.PdfChunk) r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfChunk.M(float):com.itextpdf.text.pdf.PdfChunk");
    }

    /* access modifiers changed from: package-private */
    public String N(String str) {
        BaseFont c2 = this.f26132c.c();
        if (c2.K() != 2 || c2.V(32) == 32) {
            while (true) {
                if (!str.endsWith(StringUtils.SPACE) && !str.endsWith("\t")) {
                    break;
                }
                str = str.substring(0, str.length() - 1);
            }
        } else {
            while (str.endsWith("\u0001")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    public float O() {
        BaseFont c2 = this.f26132c.c();
        if (c2.K() != 2 || c2.V(32) == 32) {
            if (this.f26130a.length() <= 1 || !this.f26130a.startsWith(StringUtils.SPACE)) {
                return 0.0f;
            }
            this.f26130a = this.f26130a.substring(1);
            return this.f26132c.i(32);
        } else if (this.f26130a.length() <= 1 || !this.f26130a.startsWith("\u0001")) {
            return 0.0f;
        } else {
            this.f26130a = this.f26130a.substring(1);
            return this.f26132c.i(1);
        }
    }

    public float P() {
        BaseFont c2 = this.f26132c.c();
        if (c2.K() != 2 || c2.V(32) == 32) {
            if (this.f26130a.length() <= 1 || !this.f26130a.endsWith(StringUtils.SPACE)) {
                return 0.0f;
            }
            String str = this.f26130a;
            this.f26130a = str.substring(0, str.length() - 1);
            return this.f26132c.i(32);
        } else if (this.f26130a.length() <= 1 || !this.f26130a.endsWith("\u0001")) {
            return 0.0f;
        } else {
            String str2 = this.f26130a;
            this.f26130a = str2.substring(0, str2.length() - 1);
            return this.f26132c.i(1);
        }
    }

    /* access modifiers changed from: package-private */
    public PdfChunk Q(float f2) {
        Image image = this.f26138i;
        if (image == null) {
            int i2 = 1;
            if (f2 < this.f26132c.h()) {
                String substring = this.f26130a.substring(1);
                this.f26130a = this.f26130a.substring(0, 1);
                return new PdfChunk(substring, this);
            }
            int length = this.f26130a.length();
            float f3 = 0.0f;
            int i3 = 0;
            boolean z = false;
            while (i3 < length) {
                z = Utilities.n(this.f26130a, i3);
                String str = this.f26130a;
                f3 += f(z ? Utilities.f(str, i3) : str.charAt(i3));
                if (f3 > f2) {
                    break;
                }
                if (z) {
                    i3++;
                }
                i3++;
            }
            if (i3 == length) {
                return null;
            }
            if (i3 != 0) {
                i2 = i3;
            } else if (z) {
                i2 = 2;
            }
            String substring2 = this.f26130a.substring(i2);
            this.f26130a = this.f26130a.substring(0, i2);
            return new PdfChunk(substring2, this);
        } else if (image.p1() <= f2) {
            return null;
        } else {
            if (this.f26138i.I1()) {
                J(f2 / this.f26138i.a0());
                return null;
            }
            PdfChunk pdfChunk = new PdfChunk("", this);
            this.f26130a = "";
            this.f26135f.remove(Chunk.v3);
            this.f26138i = null;
            this.f26132c = PdfFont.b();
            return pdfChunk;
        }
    }

    /* access modifiers changed from: package-private */
    public float R() {
        return S(this.f26130a);
    }

    /* access modifiers changed from: package-private */
    public float S(String str) {
        if (v(Chunk.f3)) {
            return 0.0f;
        }
        if (y()) {
            return m();
        }
        float j2 = this.f26132c.j(str);
        if (v(Chunk.B3)) {
            j2 += ((float) str.length()) * ((Float) e(Chunk.B3)).floatValue();
        }
        if (!v(Chunk.C3)) {
            return j2;
        }
        int i2 = 0;
        int i3 = -1;
        while (true) {
            i3 = str.indexOf(32, i3 + 1);
            if (i3 < 0) {
                return j2 + (((float) i2) * ((Float) e(Chunk.C3)).floatValue());
            }
            i2++;
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public void a(float f2) {
        Object[] objArr = (Object[]) this.f26135f.get(Chunk.g3);
        if (objArr != null) {
            this.f26135f.put(Chunk.g3, new Object[]{objArr[0], objArr[1], objArr[2], new Float(f2)});
        }
    }

    public boolean b() {
        return this.f26142m;
    }

    /* access modifiers changed from: package-private */
    public BaseColor c() {
        return (BaseColor) this.f26136g.get(Chunk.z3);
    }

    /* access modifiers changed from: package-private */
    public PdfFont d() {
        return this.f26132c;
    }

    /* access modifiers changed from: package-private */
    public Object e(String str) {
        return (this.f26135f.containsKey(str) ? this.f26135f : this.f26136g).get(str);
    }

    /* access modifiers changed from: package-private */
    public float f(int i2) {
        if (G(i2)) {
            return 0.0f;
        }
        if (v(Chunk.B3)) {
            return this.f26132c.i(i2) + (((Float) e(Chunk.B3)).floatValue() * this.f26132c.e());
        }
        return y() ? m() : this.f26132c.i(i2);
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return this.f26131b;
    }

    /* access modifiers changed from: package-private */
    public Image h() {
        return this.f26138i;
    }

    /* access modifiers changed from: package-private */
    public float i() {
        return this.f26138i.o1() * this.f26139j;
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.f26140k;
    }

    /* access modifiers changed from: package-private */
    public float k() {
        return this.f26141l;
    }

    public float l() {
        return this.f26139j;
    }

    /* access modifiers changed from: package-private */
    public float m() {
        return this.f26138i.p1() * this.f26139j;
    }

    public float n() {
        return this.f26143n;
    }

    /* access modifiers changed from: package-private */
    public TabStop o() {
        return (TabStop) this.f26135f.get(t);
    }

    public float q() {
        Float f2 = (Float) e(Chunk.k3);
        if (f2 != null) {
            return f2.floatValue();
        }
        return 0.0f;
    }

    public int r(int i2) {
        return this.f26133d.V(i2);
    }

    public float s(float f2, float f3) {
        Image image = this.f26138i;
        if (image != null) {
            return image.p1() + f2;
        }
        int i2 = 0;
        int i3 = -1;
        while (true) {
            i3 = this.f26130a.indexOf(32, i3 + 1);
            if (i3 < 0) {
                return this.f26132c.j(this.f26130a) + (((float) this.f26130a.length()) * f2) + (((float) i2) * f3);
            }
            i2++;
        }
    }

    /* access modifiers changed from: protected */
    public int t(String str, int i2) {
        int length = str.length();
        while (i2 < length && Character.isLetter(str.charAt(i2))) {
            i2++;
        }
        return i2;
    }

    public String toString() {
        return this.f26130a;
    }

    /* access modifiers changed from: package-private */
    public float u() {
        return y() ? i() : this.f26132c.g();
    }

    /* access modifiers changed from: package-private */
    public boolean v(String str) {
        if (this.f26135f.containsKey(str)) {
            return true;
        }
        return this.f26136g.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public boolean w(int i2, int i3, int i4, char[] cArr, PdfChunk[] pdfChunkArr) {
        return this.f26134e.a(i2, i3, i4, cArr, pdfChunkArr);
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        if (v(Chunk.f3)) {
            return !((Boolean) ((Object[]) e(Chunk.f3))[1]).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean y() {
        return this.f26138i != null;
    }

    public boolean z() {
        return this.f26137h;
    }

    PdfChunk(Chunk chunk, PdfAction pdfAction, TabSettings tabSettings) {
        this(chunk, pdfAction);
        if (tabSettings != null && this.f26135f.get(Chunk.h3) == null) {
            this.f26135f.put(Chunk.h3, tabSettings);
        }
    }

    PdfChunk(String str, PdfChunk pdfChunk) {
        this.f26130a = "";
        this.f26131b = "Cp1252";
        this.f26135f = new HashMap<>();
        this.f26136g = new HashMap<>();
        this.f26139j = 1.0f;
        this.f26142m = false;
        this.f26143n = 0.0f;
        this.o = null;
        this.f26130a = str;
        this.f26132c = pdfChunk.f26132c;
        HashMap<String, Object> hashMap = pdfChunk.f26135f;
        this.f26135f = hashMap;
        this.f26136g = pdfChunk.f26136g;
        this.f26133d = pdfChunk.f26133d;
        this.f26142m = pdfChunk.f26142m;
        this.f26143n = pdfChunk.f26143n;
        Object[] objArr = (Object[]) hashMap.get(Chunk.v3);
        if (objArr == null) {
            this.f26138i = null;
        } else {
            this.f26138i = (Image) objArr[0];
            this.f26140k = ((Float) objArr[1]).floatValue();
            this.f26141l = ((Float) objArr[2]).floatValue();
            this.f26142m = ((Boolean) objArr[3]).booleanValue();
        }
        this.f26131b = this.f26132c.c().G();
        SplitCharacter splitCharacter = (SplitCharacter) this.f26136g.get(Chunk.o3);
        this.f26134e = splitCharacter;
        if (splitCharacter == null) {
            this.f26134e = DefaultSplitCharacter.f26030b;
        }
        this.o = pdfChunk.o;
    }
}
