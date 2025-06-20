package com.itextpdf.text.pdf.parser.clipper;

import com.itextpdf.text.pdf.parser.clipper.Clipper;
import com.itextpdf.text.pdf.parser.clipper.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ClipperOffset {
    private static final double o = 6.283185307179586d;
    private static final double p = 0.25d;
    private static final double q = 1.0E-20d;

    /* renamed from: a  reason: collision with root package name */
    private Paths f27084a;

    /* renamed from: b  reason: collision with root package name */
    private Path f27085b;

    /* renamed from: c  reason: collision with root package name */
    private Path f27086c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Point.DoublePoint> f27087d;

    /* renamed from: e  reason: collision with root package name */
    private double f27088e;

    /* renamed from: f  reason: collision with root package name */
    private double f27089f;

    /* renamed from: g  reason: collision with root package name */
    private double f27090g;

    /* renamed from: h  reason: collision with root package name */
    private double f27091h;

    /* renamed from: i  reason: collision with root package name */
    private double f27092i;

    /* renamed from: j  reason: collision with root package name */
    private double f27093j;

    /* renamed from: k  reason: collision with root package name */
    private Point.LongPoint f27094k;

    /* renamed from: l  reason: collision with root package name */
    private final PolyNode f27095l;

    /* renamed from: m  reason: collision with root package name */
    private final double f27096m;

    /* renamed from: n  reason: collision with root package name */
    private final double f27097n;

    /* renamed from: com.itextpdf.text.pdf.parser.clipper.ClipperOffset$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27098a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.itextpdf.text.pdf.parser.clipper.Clipper$JoinType[] r0 = com.itextpdf.text.pdf.parser.clipper.Clipper.JoinType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27098a = r0
                com.itextpdf.text.pdf.parser.clipper.Clipper$JoinType r1 = com.itextpdf.text.pdf.parser.clipper.Clipper.JoinType.MITER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27098a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.parser.clipper.Clipper$JoinType r1 = com.itextpdf.text.pdf.parser.clipper.Clipper.JoinType.BEVEL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27098a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.pdf.parser.clipper.Clipper$JoinType r1 = com.itextpdf.text.pdf.parser.clipper.Clipper.JoinType.ROUND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.ClipperOffset.AnonymousClass1.<clinit>():void");
        }
    }

    public ClipperOffset() {
        this(2.0d, p);
    }

    private void d(int i2, int i3, double d2) {
        double d3 = this.f27088e / d2;
        this.f27086c.add(new Point.LongPoint(Math.round(((double) ((Point.LongPoint) this.f27085b.get(i2)).m()) + ((this.f27087d.get(i3).l() + this.f27087d.get(i2).l()) * d3)), Math.round(((double) ((Point.LongPoint) this.f27085b.get(i2)).n()) + ((this.f27087d.get(i3).m() + this.f27087d.get(i2).m()) * d3))));
    }

    private void e(double d2) {
        double d3;
        int i2;
        int i3;
        double d4;
        double d5;
        int i4;
        List<Point.DoublePoint> list;
        Point.DoublePoint c2;
        double d6 = d2;
        this.f27084a = new Paths();
        this.f27088e = d6;
        int i5 = 0;
        if (k(d2)) {
            while (i5 < this.f27095l.b()) {
                PolyNode polyNode = this.f27095l.c().get(i5);
                if (polyNode.e() == Clipper.EndType.CLOSED_POLYGON) {
                    this.f27084a.add(polyNode.j());
                }
                i5++;
            }
            return;
        }
        double d7 = this.f27097n;
        if (d7 > 2.0d) {
            this.f27092i = 2.0d / (d7 * d7);
        } else {
            this.f27092i = 0.5d;
        }
        double d8 = this.f27096m;
        double d9 = p;
        double d10 = 0.0d;
        if (d8 > 0.0d) {
            d9 = d8 > Math.abs(d2) * p ? p * Math.abs(d2) : this.f27096m;
        }
        double acos = 3.141592653589793d / Math.acos(1.0d - (d9 / Math.abs(d2)));
        double d11 = o / acos;
        this.f27090g = Math.sin(d11);
        this.f27091h = Math.cos(d11);
        this.f27093j = acos / o;
        int i6 = (d6 > 0.0d ? 1 : (d6 == 0.0d ? 0 : -1));
        if (i6 < 0) {
            this.f27090g = -this.f27090g;
        }
        int i7 = 0;
        while (i7 < this.f27095l.b()) {
            PolyNode polyNode2 = this.f27095l.c().get(i7);
            Path j2 = polyNode2.j();
            this.f27085b = j2;
            int size = j2.size();
            if (size == 0 || (i6 <= 0 && (size < 3 || polyNode2.e() != Clipper.EndType.CLOSED_POLYGON))) {
                i2 = i6;
                i3 = i7;
                d5 = d10;
                d3 = acos;
            } else {
                this.f27086c = new Path();
                int i8 = 1;
                if (size != 1) {
                    i2 = i6;
                    i3 = i7;
                    d3 = acos;
                    this.f27087d.clear();
                    int i9 = 0;
                    while (true) {
                        i4 = size - 1;
                        if (i9 >= i4) {
                            break;
                        }
                        i9++;
                        this.f27087d.add(Point.c((Point.LongPoint) this.f27085b.get(i9), (Point.LongPoint) this.f27085b.get(i9)));
                    }
                    Clipper.EndType e2 = polyNode2.e();
                    Clipper.EndType endType = Clipper.EndType.CLOSED_LINE;
                    if (e2 == endType || polyNode2.e() == Clipper.EndType.CLOSED_POLYGON) {
                        list = this.f27087d;
                        c2 = Point.c((Point.LongPoint) this.f27085b.get(i4), (Point.LongPoint) this.f27085b.get(0));
                    } else {
                        list = this.f27087d;
                        c2 = new Point.DoublePoint(this.f27087d.get(size - 2));
                    }
                    list.add(c2);
                    if (polyNode2.e() == Clipper.EndType.CLOSED_POLYGON) {
                        int[] iArr = {i4};
                        for (int i10 = 0; i10 < size; i10++) {
                            l(i10, iArr, polyNode2.f());
                        }
                    } else if (polyNode2.e() == endType) {
                        int[] iArr2 = {i4};
                        for (int i11 = 0; i11 < size; i11++) {
                            l(i11, iArr2, polyNode2.f());
                        }
                        this.f27084a.add(this.f27086c);
                        this.f27086c = new Path();
                        Point.DoublePoint doublePoint = this.f27087d.get(i4);
                        for (int i12 = i4; i12 > 0; i12--) {
                            int i13 = i12 - 1;
                            this.f27087d.set(i12, new Point.DoublePoint(-this.f27087d.get(i13).l(), -this.f27087d.get(i13).m()));
                        }
                        this.f27087d.set(0, new Point.DoublePoint(-doublePoint.l(), -doublePoint.m(), 0.0d));
                        iArr2[0] = 0;
                        while (i4 >= 0) {
                            l(i4, iArr2, polyNode2.f());
                            i4--;
                        }
                    } else {
                        int[] iArr3 = new int[1];
                        for (int i14 = 1; i14 < i4; i14++) {
                            l(i14, iArr3, polyNode2.f());
                        }
                        if (polyNode2.e() == Clipper.EndType.OPEN_BUTT) {
                            this.f27086c.add(new Point.LongPoint(Math.round(((double) ((Point.LongPoint) this.f27085b.get(i4)).m()) + (this.f27087d.get(i4).l() * d6)), Math.round(((double) ((Point.LongPoint) this.f27085b.get(i4)).n()) + (this.f27087d.get(i4).m() * d6)), 0));
                            this.f27086c.add(new Point.LongPoint(Math.round(((double) ((Point.LongPoint) this.f27085b.get(i4)).m()) - (this.f27087d.get(i4).l() * d6)), Math.round(((double) ((Point.LongPoint) this.f27085b.get(i4)).n()) - (this.f27087d.get(i4).m() * d6)), 0));
                        } else {
                            iArr3[0] = size - 2;
                            this.f27089f = 0.0d;
                            this.f27087d.set(i4, new Point.DoublePoint(-this.f27087d.get(i4).l(), -this.f27087d.get(i4).m()));
                            if (polyNode2.e() == Clipper.EndType.OPEN_SQUARE) {
                                g(i4, iArr3[0], true);
                            } else {
                                f(i4, iArr3[0]);
                            }
                        }
                        for (int i15 = i4; i15 > 0; i15--) {
                            int i16 = i15 - 1;
                            this.f27087d.set(i15, new Point.DoublePoint(-this.f27087d.get(i16).l(), -this.f27087d.get(i16).m()));
                        }
                        this.f27087d.set(0, new Point.DoublePoint(-this.f27087d.get(1).l(), -this.f27087d.get(1).m()));
                        iArr3[0] = i4;
                        for (int i17 = size - 2; i17 > 0; i17--) {
                            l(i17, iArr3, polyNode2.f());
                        }
                        if (polyNode2.e() == Clipper.EndType.OPEN_BUTT) {
                            this.f27086c.add(new Point.LongPoint(Math.round(((double) ((Point.LongPoint) this.f27085b.get(0)).m()) - (this.f27087d.get(0).l() * d6)), Math.round(((double) ((Point.LongPoint) this.f27085b.get(0)).n()) - (this.f27087d.get(0).m() * d6))));
                            this.f27086c.add(new Point.LongPoint(Math.round(((double) ((Point.LongPoint) this.f27085b.get(0)).m()) + (this.f27087d.get(0).l() * d6)), Math.round(((double) ((Point.LongPoint) this.f27085b.get(0)).n()) + (this.f27087d.get(0).m() * d6))));
                            d4 = 0.0d;
                        } else {
                            iArr3[0] = 1;
                            d4 = 0.0d;
                            this.f27089f = 0.0d;
                            if (polyNode2.e() == Clipper.EndType.OPEN_SQUARE) {
                                g(0, 1, true);
                            } else {
                                f(0, 1);
                            }
                        }
                        this.f27084a.add(this.f27086c);
                        d10 = d4;
                        i7 = i3 + 1;
                        i6 = i2;
                        acos = d3;
                        i5 = 0;
                    }
                } else if (polyNode2.f() == Clipper.JoinType.ROUND) {
                    double d12 = d10;
                    double d13 = 1.0d;
                    while (((double) i8) <= acos) {
                        int i18 = i6;
                        double d14 = acos;
                        this.f27086c.add(new Point.LongPoint(Math.round(((double) ((Point.LongPoint) this.f27085b.get(i5)).m()) + (d13 * d6)), Math.round(((double) ((Point.LongPoint) this.f27085b.get(0)).n()) + (d12 * d6))));
                        double d15 = this.f27091h;
                        double d16 = this.f27090g;
                        d12 = (d12 * d15) + (d13 * d16);
                        i8++;
                        d13 = (d13 * d15) - (d16 * d12);
                        i7 = i7;
                        i6 = i18;
                        acos = d14;
                        i5 = 0;
                    }
                    i2 = i6;
                    i3 = i7;
                    d3 = acos;
                } else {
                    i2 = i6;
                    i3 = i7;
                    d3 = acos;
                    double d17 = -1.0d;
                    double d18 = -1.0d;
                    for (int i19 = 0; i19 < 4; i19++) {
                        this.f27086c.add(new Point.LongPoint(Math.round(((double) ((Point.LongPoint) this.f27085b.get(0)).m()) + (d17 * d6)), Math.round(((double) ((Point.LongPoint) this.f27085b.get(0)).n()) + (d18 * d6))));
                        if (d17 < 0.0d) {
                            d17 = 1.0d;
                        } else if (d18 < 0.0d) {
                            d18 = 1.0d;
                        } else {
                            d17 = -1.0d;
                        }
                    }
                }
                this.f27084a.add(this.f27086c);
                d5 = 0.0d;
            }
            d10 = d4;
            i7 = i3 + 1;
            i6 = i2;
            acos = d3;
            i5 = 0;
        }
    }

    private void f(int i2, int i3) {
        int max = Math.max((int) Math.round(this.f27093j * Math.abs(Math.atan2(this.f27089f, (this.f27087d.get(i3).l() * this.f27087d.get(i2).l()) + (this.f27087d.get(i3).m() * this.f27087d.get(i2).m())))), 1);
        double l2 = this.f27087d.get(i3).l();
        double m2 = this.f27087d.get(i3).m();
        int i4 = 0;
        while (i4 < max) {
            this.f27086c.add(new Point.LongPoint(Math.round(((double) ((Point.LongPoint) this.f27085b.get(i2)).m()) + (this.f27088e * l2)), Math.round(((double) ((Point.LongPoint) this.f27085b.get(i2)).n()) + (this.f27088e * m2))));
            double d2 = this.f27091h;
            double d3 = this.f27090g;
            m2 = (m2 * d2) + (l2 * d3);
            i4++;
            l2 = (l2 * d2) - (d3 * m2);
        }
        this.f27086c.add(new Point.LongPoint(Math.round(((double) ((Point.LongPoint) this.f27085b.get(i2)).m()) + (this.f27087d.get(i2).l() * this.f27088e)), Math.round(((double) ((Point.LongPoint) this.f27085b.get(i2)).n()) + (this.f27087d.get(i2).m() * this.f27088e))));
    }

    private void g(int i2, int i3, boolean z) {
        int i4 = i2;
        int i5 = i3;
        double l2 = this.f27087d.get(i5).l();
        double m2 = this.f27087d.get(i5).m();
        double l3 = this.f27087d.get(i4).l();
        double m3 = this.f27087d.get(i4).m();
        double m4 = (double) ((Point.LongPoint) this.f27085b.get(i4)).m();
        double n2 = (double) ((Point.LongPoint) this.f27085b.get(i4)).n();
        double d2 = l3;
        double tan = Math.tan(Math.atan2(this.f27089f, (l2 * l3) + (m2 * m3)) / 4.0d);
        double d3 = m3;
        double d4 = 0.0d;
        this.f27086c.add(new Point.LongPoint(Math.round((this.f27088e * (l2 - (z ? m2 * tan : 0.0d))) + m4), Math.round((this.f27088e * (m2 + (z ? l2 * tan : 0.0d))) + n2), 0));
        Path path = this.f27086c;
        long round = Math.round(m4 + (this.f27088e * (d2 + (z ? d3 * tan : 0.0d))));
        double d5 = this.f27088e;
        if (z) {
            d4 = d2 * tan;
        }
        path.add(new Point.LongPoint(round, Math.round(n2 + (d5 * (d3 - d4))), 0));
    }

    private void j() {
        int i2 = 0;
        if (this.f27094k.m() < 0 || this.f27095l.f27154f.get((int) this.f27094k.m()).j().n()) {
            while (i2 < this.f27095l.b()) {
                PolyNode polyNode = this.f27095l.f27154f.get(i2);
                if (polyNode.e() == Clipper.EndType.CLOSED_LINE && !polyNode.j().n()) {
                    Collections.reverse(polyNode.j());
                }
                i2++;
            }
            return;
        }
        while (i2 < this.f27095l.b()) {
            PolyNode polyNode2 = this.f27095l.f27154f.get(i2);
            if (polyNode2.e() == Clipper.EndType.CLOSED_POLYGON || (polyNode2.e() == Clipper.EndType.CLOSED_LINE && polyNode2.j().n())) {
                Collections.reverse(polyNode2.j());
            }
            i2++;
        }
    }

    private static boolean k(double d2) {
        return d2 > -1.0E-20d && d2 < q;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00b0, code lost:
        if (r8 < -1.0d) goto L_0x00a9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l(int r26, int[] r27, com.itextpdf.text.pdf.parser.clipper.Clipper.JoinType r28) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = 0
            r3 = r27[r2]
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Point$DoublePoint> r4 = r0.f27087d
            java.lang.Object r4 = r4.get(r3)
            com.itextpdf.text.pdf.parser.clipper.Point$DoublePoint r4 = (com.itextpdf.text.pdf.parser.clipper.Point.DoublePoint) r4
            double r4 = r4.l()
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Point$DoublePoint> r6 = r0.f27087d
            java.lang.Object r6 = r6.get(r3)
            com.itextpdf.text.pdf.parser.clipper.Point$DoublePoint r6 = (com.itextpdf.text.pdf.parser.clipper.Point.DoublePoint) r6
            double r6 = r6.m()
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Point$DoublePoint> r8 = r0.f27087d
            java.lang.Object r8 = r8.get(r1)
            com.itextpdf.text.pdf.parser.clipper.Point$DoublePoint r8 = (com.itextpdf.text.pdf.parser.clipper.Point.DoublePoint) r8
            double r8 = r8.m()
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Point$DoublePoint> r10 = r0.f27087d
            java.lang.Object r10 = r10.get(r1)
            com.itextpdf.text.pdf.parser.clipper.Point$DoublePoint r10 = (com.itextpdf.text.pdf.parser.clipper.Point.DoublePoint) r10
            double r10 = r10.l()
            com.itextpdf.text.pdf.parser.clipper.Path r12 = r0.f27085b
            java.lang.Object r12 = r12.get(r1)
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r12 = (com.itextpdf.text.pdf.parser.clipper.Point.LongPoint) r12
            long r12 = r12.m()
            com.itextpdf.text.pdf.parser.clipper.Path r14 = r0.f27085b
            java.lang.Object r14 = r14.get(r1)
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = (com.itextpdf.text.pdf.parser.clipper.Point.LongPoint) r14
            long r14 = r14.n()
            double r16 = r4 * r8
            double r18 = r10 * r6
            r21 = r3
            double r2 = r16 - r18
            r0.f27089f = r2
            r16 = r14
            double r14 = r0.f27088e
            double r2 = r2 * r14
            double r2 = java.lang.Math.abs(r2)
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r22 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r22 >= 0) goto L_0x009f
            double r2 = r4 * r10
            double r22 = r8 * r6
            double r2 = r2 + r22
            r18 = 0
            int r22 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r22 <= 0) goto L_0x009a
            com.itextpdf.text.pdf.parser.clipper.Path r1 = r0.f27086c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = new com.itextpdf.text.pdf.parser.clipper.Point$LongPoint
            double r8 = (double) r12
            double r10 = r0.f27088e
            double r4 = r4 * r10
            double r8 = r8 + r4
            long r19 = java.lang.Math.round(r8)
            r3 = r16
            double r3 = (double) r3
            double r8 = r0.f27088e
            double r6 = r6 * r8
            double r3 = r3 + r6
            long r21 = java.lang.Math.round(r3)
            r23 = 0
            r18 = r2
            r18.<init>(r19, r21, r23)
            r1.add(r2)
            return
        L_0x009a:
            r2 = r16
            r16 = r8
            goto L_0x00b3
        L_0x009f:
            r2 = r16
            r16 = r8
            double r8 = r0.f27089f
            int r22 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r22 <= 0) goto L_0x00ac
        L_0x00a9:
            r0.f27089f = r14
            goto L_0x00b3
        L_0x00ac:
            r14 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r24 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r24 >= 0) goto L_0x00b3
            goto L_0x00a9
        L_0x00b3:
            double r8 = r0.f27089f
            double r14 = r0.f27088e
            double r8 = r8 * r14
            r14 = 0
            int r18 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r18 >= 0) goto L_0x0106
            com.itextpdf.text.pdf.parser.clipper.Path r8 = r0.f27086c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r9 = new com.itextpdf.text.pdf.parser.clipper.Point$LongPoint
            double r12 = (double) r12
            double r14 = r0.f27088e
            double r4 = r4 * r14
            double r4 = r4 + r12
            long r4 = java.lang.Math.round(r4)
            double r2 = (double) r2
            double r14 = r0.f27088e
            double r6 = r6 * r14
            double r6 = r6 + r2
            long r6 = java.lang.Math.round(r6)
            r9.<init>((long) r4, (long) r6)
            r8.add(r9)
            com.itextpdf.text.pdf.parser.clipper.Path r4 = r0.f27086c
            com.itextpdf.text.pdf.parser.clipper.Path r5 = r0.f27085b
            java.lang.Object r5 = r5.get(r1)
            r4.add(r5)
            com.itextpdf.text.pdf.parser.clipper.Path r4 = r0.f27086c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r5 = new com.itextpdf.text.pdf.parser.clipper.Point$LongPoint
            double r6 = r0.f27088e
            double r10 = r10 * r6
            double r12 = r12 + r10
            long r6 = java.lang.Math.round(r12)
            double r8 = r0.f27088e
            double r8 = r8 * r16
            double r2 = r2 + r8
            long r2 = java.lang.Math.round(r2)
            r5.<init>((long) r6, (long) r2)
            r4.add(r5)
        L_0x0104:
            r3 = 0
            goto L_0x0139
        L_0x0106:
            int[] r2 = com.itextpdf.text.pdf.parser.clipper.ClipperOffset.AnonymousClass1.f27098a
            int r3 = r28.ordinal()
            r2 = r2[r3]
            r3 = 1
            if (r2 == r3) goto L_0x0125
            r3 = 2
            if (r2 == r3) goto L_0x011e
            r3 = 3
            if (r2 == r3) goto L_0x0118
            goto L_0x0104
        L_0x0118:
            r2 = r21
            r0.f(r1, r2)
            goto L_0x0104
        L_0x011e:
            r2 = r21
            r3 = 0
        L_0x0121:
            r0.g(r1, r2, r3)
            goto L_0x0139
        L_0x0125:
            r2 = r21
            r3 = 0
            double r10 = r10 * r4
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r10 = r10 + r4
            double r8 = r16 * r6
            double r10 = r10 + r8
            double r4 = r0.f27092i
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0121
            r0.d(r1, r2, r10)
        L_0x0139:
            r27[r3] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.ClipperOffset.l(int, int[], com.itextpdf.text.pdf.parser.clipper.Clipper$JoinType):void");
    }

    public void a(Path path, Clipper.JoinType joinType, Clipper.EndType endType) {
        Point.LongPoint longPoint;
        int size = path.size() - 1;
        if (size >= 0) {
            PolyNode polyNode = new PolyNode();
            polyNode.o(joinType);
            polyNode.n(endType);
            int i2 = 0;
            if (endType == Clipper.EndType.CLOSED_LINE || endType == Clipper.EndType.CLOSED_POLYGON) {
                while (size > 0 && path.get(0) == path.get(size)) {
                    size--;
                }
            }
            polyNode.j().add(path.get(0));
            int i3 = 0;
            for (int i4 = 1; i4 <= size; i4++) {
                if (polyNode.j().get(i2) != path.get(i4)) {
                    i2++;
                    polyNode.j().add(path.get(i4));
                    if (((Point.LongPoint) path.get(i4)).n() > ((Point.LongPoint) polyNode.j().get(i3)).n() || (((Point.LongPoint) path.get(i4)).n() == ((Point.LongPoint) polyNode.j().get(i3)).n() && ((Point.LongPoint) path.get(i4)).m() < ((Point.LongPoint) polyNode.j().get(i3)).m())) {
                        i3 = i2;
                    }
                }
            }
            Clipper.EndType endType2 = Clipper.EndType.CLOSED_POLYGON;
            if (endType != endType2 || i2 >= 2) {
                this.f27095l.a(polyNode);
                if (endType == endType2) {
                    if (this.f27094k.m() < 0) {
                        longPoint = new Point.LongPoint((long) (this.f27095l.b() - 1), (long) i3);
                    } else {
                        Point.LongPoint longPoint2 = (Point.LongPoint) this.f27095l.c().get((int) this.f27094k.m()).j().get((int) this.f27094k.n());
                        if (((Point.LongPoint) polyNode.j().get(i3)).n() > longPoint2.n() || (((Point.LongPoint) polyNode.j().get(i3)).n() == longPoint2.n() && ((Point.LongPoint) polyNode.j().get(i3)).m() < longPoint2.m())) {
                            longPoint = new Point.LongPoint((long) (this.f27095l.b() - 1), (long) i3);
                        } else {
                            return;
                        }
                    }
                    this.f27094k = longPoint;
                }
            }
        }
    }

    public void b(Paths paths, Clipper.JoinType joinType, Clipper.EndType endType) {
        Iterator it2 = paths.iterator();
        while (it2.hasNext()) {
            a((Path) it2.next(), joinType, endType);
        }
    }

    public void c() {
        this.f27095l.c().clear();
        this.f27094k.f(-1L);
    }

    public void h(Paths paths, double d2) {
        Paths paths2 = paths;
        double d3 = d2;
        paths.clear();
        j();
        e(d3);
        DefaultClipper defaultClipper = new DefaultClipper(1);
        Paths paths3 = this.f27084a;
        Clipper.PolyType polyType = Clipper.PolyType.SUBJECT;
        defaultClipper.c(paths3, polyType, true);
        if (d3 > 0.0d) {
            Clipper.ClipType clipType = Clipper.ClipType.UNION;
            Clipper.PolyFillType polyFillType = Clipper.PolyFillType.POSITIVE;
            defaultClipper.b(clipType, paths2, polyFillType, polyFillType);
            return;
        }
        LongRect h2 = this.f27084a.h();
        Path path = new Path(4);
        path.add(new Point.LongPoint(h2.f27123a - 10, h2.f27126d + 10, 0));
        path.add(new Point.LongPoint(h2.f27125c + 10, h2.f27126d + 10, 0));
        path.add(new Point.LongPoint(h2.f27125c + 10, h2.f27124b - 10, 0));
        path.add(new Point.LongPoint(h2.f27123a - 10, h2.f27124b - 10, 0));
        defaultClipper.a(path, polyType, true);
        Clipper.ClipType clipType2 = Clipper.ClipType.UNION;
        Clipper.PolyFillType polyFillType2 = Clipper.PolyFillType.NEGATIVE;
        defaultClipper.b(clipType2, paths2, polyFillType2, polyFillType2);
        if (paths.size() > 0) {
            paths2.remove(0);
        }
    }

    public void i(PolyTree polyTree, double d2) {
        PolyTree polyTree2 = polyTree;
        double d3 = d2;
        polyTree.r();
        j();
        e(d3);
        DefaultClipper defaultClipper = new DefaultClipper(1);
        Paths paths = this.f27084a;
        Clipper.PolyType polyType = Clipper.PolyType.SUBJECT;
        defaultClipper.c(paths, polyType, true);
        if (d3 > 0.0d) {
            Clipper.ClipType clipType = Clipper.ClipType.UNION;
            Clipper.PolyFillType polyFillType = Clipper.PolyFillType.POSITIVE;
            defaultClipper.e(clipType, polyTree2, polyFillType, polyFillType);
            return;
        }
        LongRect h2 = this.f27084a.h();
        Path path = new Path(4);
        path.add(new Point.LongPoint(h2.f27123a - 10, h2.f27126d + 10, 0));
        path.add(new Point.LongPoint(h2.f27125c + 10, h2.f27126d + 10, 0));
        path.add(new Point.LongPoint(h2.f27125c + 10, h2.f27124b - 10, 0));
        path.add(new Point.LongPoint(h2.f27123a - 10, h2.f27124b - 10, 0));
        defaultClipper.a(path, polyType, true);
        Clipper.ClipType clipType2 = Clipper.ClipType.UNION;
        Clipper.PolyFillType polyFillType2 = Clipper.PolyFillType.NEGATIVE;
        defaultClipper.e(clipType2, polyTree2, polyFillType2, polyFillType2);
        if (polyTree.b() != 1 || polyTree.c().get(0).b() <= 0) {
            polyTree.r();
            return;
        }
        PolyNode polyNode = polyTree.c().get(0);
        polyTree.c().set(0, polyNode.c().get(0));
        polyTree.c().get(0).q(polyTree2);
        for (int i2 = 1; i2 < polyNode.b(); i2++) {
            polyTree2.a(polyNode.c().get(i2));
        }
    }

    public ClipperOffset(double d2) {
        this(d2, p);
    }

    public ClipperOffset(double d2, double d3) {
        this.f27097n = d2;
        this.f27096m = d3;
        Point.LongPoint longPoint = new Point.LongPoint();
        this.f27094k = longPoint;
        longPoint.f(-1L);
        this.f27095l = new PolyNode();
        this.f27087d = new ArrayList();
    }
}
