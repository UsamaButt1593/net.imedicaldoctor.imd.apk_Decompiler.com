package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class TrueTypeFontSubSet {
    static final int A = 1;
    static final int B = 8;
    static final int C = 32;
    static final int D = 64;
    static final int E = 128;
    static final String[] s = {"cvt ", "fpgm", "glyf", "head", "hhea", "hmtx", "loca", "maxp", "prep"};
    static final String[] t = {"cmap", "cvt ", "fpgm", "glyf", "head", "hhea", "hmtx", "loca", "maxp", "prep"};
    static final String[] u = {"OS/2", "cmap", "cvt ", "fpgm", "glyf", "head", "hhea", "hmtx", "loca", "maxp", "name, prep"};
    static final int[] v = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4};
    static final int w = 0;
    static final int x = 1;
    static final int y = 2;
    static final int z = 51;

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, int[]> f26449a;

    /* renamed from: b  reason: collision with root package name */
    protected RandomAccessFileOrArray f26450b;

    /* renamed from: c  reason: collision with root package name */
    protected String f26451c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f26452d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f26453e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f26454f;

    /* renamed from: g  reason: collision with root package name */
    protected int[] f26455g;

    /* renamed from: h  reason: collision with root package name */
    protected HashSet<Integer> f26456h;

    /* renamed from: i  reason: collision with root package name */
    protected ArrayList<Integer> f26457i;

    /* renamed from: j  reason: collision with root package name */
    protected int f26458j;

    /* renamed from: k  reason: collision with root package name */
    protected int[] f26459k;

    /* renamed from: l  reason: collision with root package name */
    protected byte[] f26460l;

    /* renamed from: m  reason: collision with root package name */
    protected byte[] f26461m;

    /* renamed from: n  reason: collision with root package name */
    protected int f26462n;
    protected int o;
    protected byte[] p;
    protected int q;
    protected int r;

    TrueTypeFontSubSet(String str, RandomAccessFileOrArray randomAccessFileOrArray, HashSet<Integer> hashSet, int i2, boolean z2, boolean z3) {
        this.f26451c = str;
        this.f26450b = randomAccessFileOrArray;
        this.f26456h = hashSet;
        this.f26452d = z2;
        this.f26453e = z3;
        this.r = i2;
        this.f26457i = new ArrayList<>(hashSet);
    }

    /* access modifiers changed from: protected */
    public void a() throws IOException {
        int i2;
        int[] iArr;
        String[] strArr = this.f26453e ? u : this.f26452d ? t : s;
        int i3 = 0;
        int i4 = 2;
        for (String str : strArr) {
            if (!str.equals("glyf") && !str.equals("loca") && (iArr = this.f26449a.get(str)) != null) {
                i4++;
                i3 += (iArr[2] + 3) & -4;
            }
        }
        int i5 = (i4 * 16) + 12;
        this.p = new byte[(i3 + this.f26460l.length + this.f26461m.length + i5)];
        this.q = 0;
        k(65536);
        l(i4);
        int i6 = v[i4];
        int i7 = 1 << i6;
        l(i7 * 16);
        l(i6);
        l((i4 - i7) * 16);
        for (String str2 : strArr) {
            int[] iArr2 = this.f26449a.get(str2);
            if (iArr2 != null) {
                m(str2);
                if (str2.equals("glyf")) {
                    k(b(this.f26461m));
                    i2 = this.f26462n;
                } else if (str2.equals("loca")) {
                    k(b(this.f26460l));
                    i2 = this.o;
                } else {
                    k(iArr2[0]);
                    i2 = iArr2[2];
                }
                k(i5);
                k(i2);
                i5 += (i2 + 3) & -4;
            }
        }
        for (String str3 : strArr) {
            int[] iArr3 = this.f26449a.get(str3);
            if (iArr3 != null) {
                if (str3.equals("glyf")) {
                    byte[] bArr = this.f26461m;
                    System.arraycopy(bArr, 0, this.p, this.q, bArr.length);
                    this.q += this.f26461m.length;
                    this.f26461m = null;
                } else if (str3.equals("loca")) {
                    byte[] bArr2 = this.f26460l;
                    System.arraycopy(bArr2, 0, this.p, this.q, bArr2.length);
                    this.q += this.f26460l.length;
                    this.f26460l = null;
                } else {
                    this.f26450b.r((long) iArr3[1]);
                    this.f26450b.readFully(this.p, this.q, iArr3[2]);
                    this.q += (iArr3[2] + 3) & -4;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public int b(byte[] bArr) {
        int length = bArr.length / 4;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            i5 += bArr[i6] & 255;
            i4 += bArr[i6 + 1] & 255;
            int i8 = i6 + 3;
            i3 += bArr[i6 + 2] & 255;
            i6 += 4;
            i2 += bArr[i8] & 255;
        }
        return i2 + (i3 << 8) + (i4 << 16) + (i5 << 24);
    }

    /* access modifiers changed from: protected */
    public void c(int i2) throws IOException {
        int[] iArr = this.f26455g;
        int i3 = iArr[i2];
        if (i3 != iArr[i2 + 1]) {
            this.f26450b.r((long) (this.f26458j + i3));
            if (this.f26450b.readShort() < 0) {
                RandomAccessFileOrArray randomAccessFileOrArray = this.f26450b;
                int i4 = 8;
                while (true) {
                    randomAccessFileOrArray.skipBytes(i4);
                    int readUnsignedShort = this.f26450b.readUnsignedShort();
                    Integer valueOf = Integer.valueOf(this.f26450b.readUnsignedShort());
                    if (!this.f26456h.contains(valueOf)) {
                        this.f26456h.add(valueOf);
                        this.f26457i.add(valueOf);
                    }
                    if ((readUnsignedShort & 32) != 0) {
                        i4 = (readUnsignedShort & 1) != 0 ? 4 : 2;
                        if ((readUnsignedShort & 8) != 0) {
                            i4 += 2;
                        } else if ((readUnsignedShort & 64) != 0) {
                            i4 += 4;
                        }
                        if ((readUnsignedShort & 128) != 0) {
                            i4 += 8;
                        }
                        randomAccessFileOrArray = this.f26450b;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d() throws IOException {
        this.f26459k = new int[this.f26455g.length];
        int size = this.f26457i.size();
        int[] iArr = new int[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = this.f26457i.get(i3).intValue();
        }
        Arrays.sort(iArr);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            int i6 = iArr[i5];
            int[] iArr2 = this.f26455g;
            i4 += iArr2[i6 + 1] - iArr2[i6];
        }
        this.f26462n = i4;
        this.f26461m = new byte[((i4 + 3) & -4)];
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int[] iArr3 = this.f26459k;
            if (i2 < iArr3.length) {
                iArr3[i2] = i7;
                if (i8 < size && iArr[i8] == i2) {
                    i8++;
                    iArr3[i2] = i7;
                    int[] iArr4 = this.f26455g;
                    int i9 = iArr4[i2];
                    int i10 = iArr4[i2 + 1] - i9;
                    if (i10 > 0) {
                        this.f26450b.r((long) (this.f26458j + i9));
                        this.f26450b.readFully(this.f26461m, i7, i10);
                        i7 += i10;
                    }
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void e() throws IOException, DocumentException {
        this.f26449a = new HashMap<>();
        this.f26450b.r((long) this.r);
        if (this.f26450b.readInt() == 65536) {
            int readUnsignedShort = this.f26450b.readUnsignedShort();
            this.f26450b.skipBytes(6);
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                this.f26449a.put(j(4), new int[]{this.f26450b.readInt(), this.f26450b.readInt(), this.f26450b.readInt()});
            }
            return;
        }
        throw new DocumentException(MessageLocalization.b("1.is.not.a.true.type.file", this.f26451c));
    }

    /* access modifiers changed from: protected */
    public void f() throws IOException, DocumentException {
        int[] iArr = this.f26449a.get("glyf");
        if (iArr != null) {
            if (!this.f26456h.contains(0)) {
                this.f26456h.add(0);
                this.f26457i.add(0);
            }
            this.f26458j = iArr[1];
            for (int i2 = 0; i2 < this.f26457i.size(); i2++) {
                c(this.f26457i.get(i2).intValue());
            }
            return;
        }
        throw new DocumentException(MessageLocalization.b("table.1.does.not.exist.in.2", "glyf", this.f26451c));
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.o = this.f26454f ? this.f26459k.length * 2 : this.f26459k.length * 4;
        byte[] bArr = new byte[((this.o + 3) & -4)];
        this.f26460l = bArr;
        this.p = bArr;
        int i2 = 0;
        this.q = 0;
        while (true) {
            int[] iArr = this.f26459k;
            if (i2 < iArr.length) {
                if (this.f26454f) {
                    l(iArr[i2] / 2);
                } else {
                    k(iArr[i2]);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] h() throws IOException, DocumentException {
        try {
            this.f26450b.g();
            e();
            i();
            f();
            d();
            g();
            a();
            return this.p;
        } finally {
            try {
                this.f26450b.close();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void i() throws IOException, DocumentException {
        int i2 = 0;
        int[] iArr = this.f26449a.get("head");
        if (iArr != null) {
            this.f26450b.r((long) (iArr[1] + 51));
            this.f26454f = this.f26450b.readUnsignedShort() == 0;
            int[] iArr2 = this.f26449a.get("loca");
            if (iArr2 != null) {
                this.f26450b.r((long) iArr2[1]);
                if (this.f26454f) {
                    int i3 = iArr2[2] / 2;
                    this.f26455g = new int[i3];
                    while (i2 < i3) {
                        this.f26455g[i2] = this.f26450b.readUnsignedShort() * 2;
                        i2++;
                    }
                    return;
                }
                int i4 = iArr2[2] / 4;
                this.f26455g = new int[i4];
                while (i2 < i4) {
                    this.f26455g[i2] = this.f26450b.readInt();
                    i2++;
                }
                return;
            }
            throw new DocumentException(MessageLocalization.b("table.1.does.not.exist.in.2", "loca", this.f26451c));
        }
        throw new DocumentException(MessageLocalization.b("table.1.does.not.exist.in.2", "head", this.f26451c));
    }

    /* access modifiers changed from: protected */
    public String j(int i2) throws IOException {
        byte[] bArr = new byte[i2];
        this.f26450b.readFully(bArr);
        try {
            return new String(bArr, "Cp1252");
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void k(int i2) {
        byte[] bArr = this.p;
        int i3 = this.q;
        int i4 = i3 + 1;
        this.q = i4;
        bArr[i3] = (byte) (i2 >> 24);
        int i5 = i3 + 2;
        this.q = i5;
        bArr[i4] = (byte) (i2 >> 16);
        int i6 = i3 + 3;
        this.q = i6;
        bArr[i5] = (byte) (i2 >> 8);
        this.q = i3 + 4;
        bArr[i6] = (byte) i2;
    }

    /* access modifiers changed from: protected */
    public void l(int i2) {
        byte[] bArr = this.p;
        int i3 = this.q;
        int i4 = i3 + 1;
        this.q = i4;
        bArr[i3] = (byte) (i2 >> 8);
        this.q = i3 + 2;
        bArr[i4] = (byte) i2;
    }

    /* access modifiers changed from: protected */
    public void m(String str) {
        byte[] c2 = PdfEncodings.c(str, "Cp1252");
        System.arraycopy(c2, 0, this.p, this.q, c2.length);
        this.q += c2.length;
    }
}
