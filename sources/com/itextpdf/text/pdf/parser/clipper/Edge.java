package com.itextpdf.text.pdf.parser.clipper;

import com.itextpdf.text.pdf.parser.clipper.Clipper;
import com.itextpdf.text.pdf.parser.clipper.Point;
import java.math.BigInteger;
import java.util.logging.Logger;

class Edge {
    protected static final int s = -2;
    protected static final int t = -1;
    protected static final double u = -3.4E38d;
    private static final Logger v = Logger.getLogger(Edge.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final Point.LongPoint f27107a = new Point.LongPoint();

    /* renamed from: b  reason: collision with root package name */
    private final Point.LongPoint f27108b = new Point.LongPoint();

    /* renamed from: c  reason: collision with root package name */
    private final Point.LongPoint f27109c = new Point.LongPoint();

    /* renamed from: d  reason: collision with root package name */
    private final Point.LongPoint f27110d = new Point.LongPoint();

    /* renamed from: e  reason: collision with root package name */
    double f27111e;

    /* renamed from: f  reason: collision with root package name */
    Clipper.PolyType f27112f;

    /* renamed from: g  reason: collision with root package name */
    Side f27113g;

    /* renamed from: h  reason: collision with root package name */
    int f27114h;

    /* renamed from: i  reason: collision with root package name */
    int f27115i;

    /* renamed from: j  reason: collision with root package name */
    int f27116j;

    /* renamed from: k  reason: collision with root package name */
    int f27117k;

    /* renamed from: l  reason: collision with root package name */
    Edge f27118l;

    /* renamed from: m  reason: collision with root package name */
    Edge f27119m;

    /* renamed from: n  reason: collision with root package name */
    Edge f27120n;
    Edge o;
    Edge p;
    Edge q;
    Edge r;

    /* renamed from: com.itextpdf.text.pdf.parser.clipper.Edge$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27121a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f27122b;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        static {
            /*
                com.itextpdf.text.pdf.parser.clipper.Clipper$ClipType[] r0 = com.itextpdf.text.pdf.parser.clipper.Clipper.ClipType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27122b = r0
                r1 = 1
                com.itextpdf.text.pdf.parser.clipper.Clipper$ClipType r2 = com.itextpdf.text.pdf.parser.clipper.Clipper.ClipType.INTERSECTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f27122b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.parser.clipper.Clipper$ClipType r3 = com.itextpdf.text.pdf.parser.clipper.Clipper.ClipType.UNION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f27122b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.pdf.parser.clipper.Clipper$ClipType r4 = com.itextpdf.text.pdf.parser.clipper.Clipper.ClipType.DIFFERENCE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f27122b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.itextpdf.text.pdf.parser.clipper.Clipper$ClipType r4 = com.itextpdf.text.pdf.parser.clipper.Clipper.ClipType.XOR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.itextpdf.text.pdf.parser.clipper.Clipper$PolyFillType[] r3 = com.itextpdf.text.pdf.parser.clipper.Clipper.PolyFillType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f27121a = r3
                com.itextpdf.text.pdf.parser.clipper.Clipper$PolyFillType r4 = com.itextpdf.text.pdf.parser.clipper.Clipper.PolyFillType.EVEN_ODD     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f27121a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.itextpdf.text.pdf.parser.clipper.Clipper$PolyFillType r3 = com.itextpdf.text.pdf.parser.clipper.Clipper.PolyFillType.NON_ZERO     // Catch:{ NoSuchFieldError -> 0x004e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f27121a     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.itextpdf.text.pdf.parser.clipper.Clipper$PolyFillType r1 = com.itextpdf.text.pdf.parser.clipper.Clipper.PolyFillType.POSITIVE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.Edge.AnonymousClass1.<clinit>():void");
        }
    }

    enum Side {
        LEFT,
        RIGHT
    }

    static boolean a(Edge edge, Edge edge2) {
        return edge2.f27108b.m() == edge.f27108b.m() ? edge2.f27109c.n() > edge.f27109c.n() ? edge2.f27109c.m() < v(edge, edge2.f27109c.n()) : edge.f27109c.m() > v(edge2, edge.f27109c.n()) : edge2.f27108b.m() < edge.f27108b.m();
    }

    static boolean s(Edge edge, Edge edge2, boolean z) {
        if (z) {
            return BigInteger.valueOf(edge.e().n()).multiply(BigInteger.valueOf(edge2.e().m())).equals(BigInteger.valueOf(edge.e().m()).multiply(BigInteger.valueOf(edge2.e().n())));
        }
        return edge.e().n() * edge2.e().m() == edge.e().m() * edge2.e().n();
    }

    static void t(Edge edge, Edge edge2) {
        int i2 = edge.f27117k;
        edge.f27117k = edge2.f27117k;
        edge2.f27117k = i2;
    }

    static void u(Edge edge, Edge edge2) {
        Side side = edge.f27113g;
        edge.f27113g = edge2.f27113g;
        edge2.f27113g = side;
    }

    static long v(Edge edge, long j2) {
        return j2 == edge.h().n() ? edge.h().m() : edge.c().m() + Math.round(edge.f27111e * ((double) (j2 - edge.c().n())));
    }

    public Edge b() {
        Edge edge = this;
        while (true) {
            if (!edge.f27107a.equals(edge.f27119m.f27107a) || edge.f27108b.equals(edge.f27109c)) {
                edge = edge.f27118l;
            } else if (edge.f27111e != u && edge.f27119m.f27111e != u) {
                return edge;
            } else {
                while (true) {
                    Edge edge2 = edge.f27119m;
                    if (edge2.f27111e != u) {
                        break;
                    }
                    edge = edge2;
                }
                Edge edge3 = edge;
                while (edge3.f27111e == u) {
                    edge3 = edge3.f27118l;
                }
                if (edge3.f27109c.n() != edge3.f27119m.f27107a.n()) {
                    return edge.f27119m.f27107a.m() < edge3.f27107a.m() ? edge : edge3;
                }
                edge = edge3;
            }
        }
    }

    public Point.LongPoint c() {
        return this.f27107a;
    }

    public Point.LongPoint d() {
        return this.f27108b;
    }

    public Point.LongPoint e() {
        return this.f27110d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        if (r0.f27120n == null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0024, code lost:
        if (r0.f27120n == null) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.parser.clipper.Edge f() {
        /*
            r4 = this;
            com.itextpdf.text.pdf.parser.clipper.Edge r0 = r4.f27118l
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r0.f27109c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r4.f27109c
            boolean r0 = r0.equals(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0014
            com.itextpdf.text.pdf.parser.clipper.Edge r0 = r4.f27118l
            com.itextpdf.text.pdf.parser.clipper.Edge r2 = r0.f27120n
            if (r2 != 0) goto L_0x0014
            goto L_0x0028
        L_0x0014:
            com.itextpdf.text.pdf.parser.clipper.Edge r0 = r4.f27119m
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r0.f27109c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = r4.f27109c
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0027
            com.itextpdf.text.pdf.parser.clipper.Edge r0 = r4.f27119m
            com.itextpdf.text.pdf.parser.clipper.Edge r2 = r0.f27120n
            if (r2 != 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r0 = r1
        L_0x0028:
            if (r0 == 0) goto L_0x003c
            int r2 = r0.f27117k
            r3 = -2
            if (r2 == r3) goto L_0x003b
            com.itextpdf.text.pdf.parser.clipper.Edge r2 = r0.o
            com.itextpdf.text.pdf.parser.clipper.Edge r3 = r0.p
            if (r2 != r3) goto L_0x003c
            boolean r2 = r0.l()
            if (r2 != 0) goto L_0x003c
        L_0x003b:
            return r1
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.Edge.f():com.itextpdf.text.pdf.parser.clipper.Edge");
    }

    public Edge g(Clipper.Direction direction) {
        return direction == Clipper.Direction.LEFT_TO_RIGHT ? this.o : this.p;
    }

    public Point.LongPoint h() {
        return this.f27109c;
    }

    public boolean i(Clipper.PolyFillType polyFillType, Clipper.PolyFillType polyFillType2, Clipper.ClipType clipType) {
        v.entering(Edge.class.getName(), "isContributing");
        Clipper.PolyType polyType = this.f27112f;
        Clipper.PolyType polyType2 = Clipper.PolyType.SUBJECT;
        if (polyType == polyType2) {
            Clipper.PolyFillType polyFillType3 = polyFillType2;
            polyFillType2 = polyFillType;
            polyFillType = polyFillType3;
        }
        int[] iArr = AnonymousClass1.f27121a;
        int i2 = iArr[polyFillType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (this.f27115i != -1) {
                        return false;
                    }
                } else if (this.f27115i != 1) {
                    return false;
                }
            } else if (Math.abs(this.f27115i) != 1) {
                return false;
            }
        } else if (this.f27114h == 0 && this.f27115i != 1) {
            return false;
        }
        int i3 = AnonymousClass1.f27122b[clipType.ordinal()];
        if (i3 == 1) {
            int i4 = iArr[polyFillType2.ordinal()];
            return (i4 == 1 || i4 == 2) ? this.f27116j != 0 : i4 != 3 ? this.f27116j < 0 : this.f27116j > 0;
        } else if (i3 == 2) {
            int i5 = iArr[polyFillType2.ordinal()];
            return (i5 == 1 || i5 == 2) ? this.f27116j == 0 : i5 != 3 ? this.f27116j >= 0 : this.f27116j <= 0;
        } else if (i3 != 3) {
            if (i3 != 4 || this.f27114h != 0) {
                return true;
            }
            int i6 = iArr[polyFillType2.ordinal()];
            return (i6 == 1 || i6 == 2) ? this.f27116j == 0 : i6 != 3 ? this.f27116j >= 0 : this.f27116j <= 0;
        } else if (this.f27112f == polyType2) {
            int i7 = iArr[polyFillType2.ordinal()];
            return (i7 == 1 || i7 == 2) ? this.f27116j == 0 : i7 != 3 ? this.f27116j >= 0 : this.f27116j <= 0;
        } else {
            int i8 = iArr[polyFillType2.ordinal()];
            return (i8 == 1 || i8 == 2) ? this.f27116j != 0 : i8 != 3 ? this.f27116j < 0 : this.f27116j > 0;
        }
    }

    public boolean j(Clipper.PolyFillType polyFillType, Clipper.PolyFillType polyFillType2) {
        return this.f27112f == Clipper.PolyType.SUBJECT ? polyFillType == Clipper.PolyFillType.EVEN_ODD : polyFillType2 == Clipper.PolyFillType.EVEN_ODD;
    }

    public boolean k(Clipper.PolyFillType polyFillType, Clipper.PolyFillType polyFillType2) {
        return this.f27112f == Clipper.PolyType.SUBJECT ? polyFillType2 == Clipper.PolyFillType.EVEN_ODD : polyFillType == Clipper.PolyFillType.EVEN_ODD;
    }

    public boolean l() {
        return this.f27110d.n() == 0;
    }

    public boolean m(double d2) {
        return ((double) this.f27109c.n()) == d2 && this.f27120n != null;
    }

    public boolean n(double d2) {
        return ((double) this.f27109c.n()) == d2 && this.f27120n == null;
    }

    public void o() {
        long m2 = this.f27109c.m();
        this.f27109c.f(Long.valueOf(this.f27107a.m()));
        this.f27107a.f(Long.valueOf(m2));
        long o2 = this.f27109c.o();
        this.f27109c.h(Long.valueOf(this.f27107a.o()));
        this.f27107a.h(Long.valueOf(o2));
    }

    public void p(Point.LongPoint longPoint) {
        this.f27107a.e(longPoint);
    }

    public void q(Point.LongPoint longPoint) {
        this.f27108b.e(longPoint);
    }

    public void r(Point.LongPoint longPoint) {
        this.f27109c.e(longPoint);
    }

    public String toString() {
        return "TEdge [Bot=" + this.f27107a + ", Curr=" + this.f27108b + ", Top=" + this.f27109c + ", Delta=" + this.f27110d + ", Dx=" + this.f27111e + ", PolyTyp=" + this.f27112f + ", Side=" + this.f27113g + ", WindDelta=" + this.f27114h + ", WindCnt=" + this.f27115i + ", WindCnt2=" + this.f27116j + ", OutIdx=" + this.f27117k + ", Next=" + this.f27118l + ", Prev=" + this.f27119m + ", NextInLML=" + this.f27120n + ", NextInAEL=" + this.o + ", PrevInAEL=" + this.p + ", NextInSEL=" + this.q + ", PrevInSEL=" + this.r + "]";
    }

    public void w() {
        this.f27110d.f(Long.valueOf(this.f27109c.m() - this.f27107a.m()));
        this.f27110d.g(Long.valueOf(this.f27109c.n() - this.f27107a.n()));
        this.f27111e = this.f27110d.n() == 0 ? u : ((double) this.f27110d.m()) / ((double) this.f27110d.n());
    }
}
