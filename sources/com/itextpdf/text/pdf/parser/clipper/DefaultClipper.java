package com.itextpdf.text.pdf.parser.clipper;

import com.itextpdf.text.pdf.parser.clipper.Clipper;
import com.itextpdf.text.pdf.parser.clipper.ClipperBase;
import com.itextpdf.text.pdf.parser.clipper.Edge;
import com.itextpdf.text.pdf.parser.clipper.Path;
import com.itextpdf.text.pdf.parser.clipper.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

public class DefaultClipper extends ClipperBase {
    private static final Logger C = Logger.getLogger(DefaultClipper.class.getName());
    private final boolean A;
    private final boolean B;

    /* renamed from: m  reason: collision with root package name */
    protected final List<Path.OutRec> f27099m;

    /* renamed from: n  reason: collision with root package name */
    private Clipper.ClipType f27100n;
    private ClipperBase.Scanbeam o;
    private Path.Maxima p;
    private Edge q;
    private Edge r;
    private final List<IntersectNode> s;
    private final Comparator<IntersectNode> t;
    private Clipper.PolyFillType u;
    private Clipper.PolyFillType v;
    private final List<Path.Join> w;
    private final List<Path.Join> x;
    private boolean y;
    public Clipper.ZFillCallback z;

    /* renamed from: com.itextpdf.text.pdf.parser.clipper.DefaultClipper$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27101a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f27102b;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|5|6|7|8|(2:9|10)|11|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                com.itextpdf.text.pdf.parser.clipper.Clipper$ClipType[] r0 = com.itextpdf.text.pdf.parser.clipper.Clipper.ClipType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27102b = r0
                r1 = 1
                com.itextpdf.text.pdf.parser.clipper.Clipper$ClipType r2 = com.itextpdf.text.pdf.parser.clipper.Clipper.ClipType.INTERSECTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f27102b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.parser.clipper.Clipper$ClipType r3 = com.itextpdf.text.pdf.parser.clipper.Clipper.ClipType.UNION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f27102b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.pdf.parser.clipper.Clipper$ClipType r3 = com.itextpdf.text.pdf.parser.clipper.Clipper.ClipType.DIFFERENCE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = f27102b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.itextpdf.text.pdf.parser.clipper.Clipper$ClipType r3 = com.itextpdf.text.pdf.parser.clipper.Clipper.ClipType.XOR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.itextpdf.text.pdf.parser.clipper.Clipper$PolyFillType[] r2 = com.itextpdf.text.pdf.parser.clipper.Clipper.PolyFillType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f27101a = r2
                com.itextpdf.text.pdf.parser.clipper.Clipper$PolyFillType r3 = com.itextpdf.text.pdf.parser.clipper.Clipper.PolyFillType.POSITIVE     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f27101a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.itextpdf.text.pdf.parser.clipper.Clipper$PolyFillType r2 = com.itextpdf.text.pdf.parser.clipper.Clipper.PolyFillType.NEGATIVE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.DefaultClipper.AnonymousClass2.<clinit>():void");
        }
    }

    private class IntersectNode {

        /* renamed from: a  reason: collision with root package name */
        Edge f27103a;

        /* renamed from: b  reason: collision with root package name */
        Edge f27104b;

        /* renamed from: c  reason: collision with root package name */
        private Point.LongPoint f27105c;

        private IntersectNode() {
        }

        public Point.LongPoint a() {
            return this.f27105c;
        }

        public void b(Point.LongPoint longPoint) {
            this.f27105c = longPoint;
        }
    }

    public DefaultClipper() {
        this(0);
    }

    private void A(Edge edge, Edge edge2) {
        Logger logger = C;
        logger.entering(DefaultClipper.class.getName(), "appendPolygon");
        Path.OutRec outRec = this.f27099m.get(edge.f27117k);
        Path.OutRec outRec2 = this.f27099m.get(edge2.f27117k);
        logger.finest("" + edge.f27117k);
        logger.finest("" + edge2.f27117k);
        Path.OutRec c2 = b0(outRec, outRec2) ? outRec2 : b0(outRec2, outRec) ? outRec : Path.OutPt.c(outRec, outRec2);
        Path.OutPt c3 = outRec.c();
        Path.OutPt outPt = c3.f27136d;
        Path.OutPt c4 = outRec2.c();
        Path.OutPt outPt2 = c4.f27136d;
        logger.finest("p1_lft.getPointCount() = " + c3.d());
        logger.finest("p1_rt.getPointCount() = " + outPt.d());
        logger.finest("p2_lft.getPointCount() = " + c4.d());
        logger.finest("p2_rt.getPointCount() = " + outPt2.d());
        Edge.Side side = edge.f27113g;
        Edge.Side side2 = Edge.Side.LEFT;
        if (side != side2) {
            Edge.Side side3 = edge2.f27113g;
            side2 = Edge.Side.RIGHT;
            if (side3 == side2) {
                c4.g();
                outPt.f27135c = outPt2;
                outPt2.f27136d = outPt;
                c4.f27135c = c3;
                c3.f27136d = c4;
            } else {
                outPt.f27135c = c4;
                c4.f27136d = outPt;
                c3.f27136d = outPt2;
                outPt2.f27135c = c3;
            }
        } else if (edge2.f27113g == side2) {
            c4.g();
            c4.f27135c = c3;
            c3.f27136d = c4;
            outPt.f27135c = outPt2;
            outPt2.f27136d = outPt;
            outRec.d(outPt2);
        } else {
            outPt2.f27135c = c3;
            c3.f27136d = outPt2;
            c4.f27136d = outPt;
            outPt.f27135c = c4;
            outRec.d(c4);
        }
        outRec.f27142f = null;
        if (c2.equals(outRec2)) {
            Path.OutRec outRec3 = outRec2.f27140d;
            if (outRec3 != outRec) {
                outRec.f27140d = outRec3;
            }
            outRec.f27138b = outRec2.f27138b;
        }
        outRec2.d((Path.OutPt) null);
        outRec2.f27142f = null;
        outRec2.f27140d = outRec;
        int i2 = edge.f27117k;
        int i3 = edge2.f27117k;
        edge.f27117k = -1;
        edge2.f27117k = -1;
        Edge edge3 = this.q;
        while (true) {
            if (edge3 == null) {
                break;
            } else if (edge3.f27117k == i3) {
                edge3.f27117k = i2;
                edge3.f27113g = side2;
                break;
            } else {
                edge3 = edge3.o;
            }
        }
        outRec2.f27137a = outRec.f27137a;
    }

    private void A0(Path.OutRec outRec) {
        Path.OutPt c2 = outRec.c();
        do {
            c2.f27133a = outRec.f27137a;
            c2 = c2.f27136d;
        } while (c2 != outRec.c());
    }

    private void B(long j2) {
        Edge edge;
        boolean z2;
        Edge edge2 = this.q;
        if (edge2 != null) {
            this.r = edge2;
            while (edge2 != null) {
                edge2.r = edge2.p;
                edge2.q = edge2.o;
                edge2.d().f(Long.valueOf(Edge.v(edge2, j2)));
                edge2 = edge2.o;
            }
            for (boolean z3 = true; z3 && (edge = this.r) != null; z3 = z2) {
                z2 = false;
                while (true) {
                    Edge edge3 = edge.q;
                    if (edge3 == null) {
                        break;
                    }
                    Point.LongPoint[] longPointArr = new Point.LongPoint[1];
                    if (edge.d().m() > edge3.d().m()) {
                        a0(edge, edge3, longPointArr);
                        IntersectNode intersectNode = new IntersectNode();
                        intersectNode.f27103a = edge;
                        intersectNode.f27104b = edge3;
                        intersectNode.b(longPointArr[0]);
                        this.s.add(intersectNode);
                        y0(edge, edge3);
                        z2 = true;
                    } else {
                        edge = edge3;
                    }
                }
                Edge edge4 = edge.r;
                if (edge4 == null) {
                    break;
                }
                edge4.q = null;
            }
            this.r = null;
        }
    }

    private void B0(Edge edge) {
        Edge edge2;
        int i2;
        C.entering(DefaultClipper.class.getName(), "updateWindingCount");
        Edge edge3 = edge.p;
        while (edge3 != null && (edge3.f27112f != edge.f27112f || edge3.f27114h == 0)) {
            edge3 = edge3.p;
        }
        if (edge3 == null) {
            int i3 = edge.f27114h;
            if (i3 == 0) {
                i3 = 1;
            }
            edge.f27115i = i3;
            edge.f27116j = 0;
            edge2 = this.q;
        } else {
            if (edge.f27114h != 0 || this.f27100n == Clipper.ClipType.UNION) {
                if (edge.k(this.u, this.v)) {
                    i2 = edge.f27114h;
                    if (i2 == 0) {
                        int i4 = 1;
                        for (Edge edge4 = edge3.p; edge4 != null; edge4 = edge4.p) {
                            if (edge4.f27112f == edge3.f27112f && edge4.f27114h != 0) {
                                i4 ^= 1;
                            }
                        }
                        i2 = i4 ^ 1;
                    }
                } else {
                    i2 = edge3.f27115i;
                    int i5 = edge3.f27114h;
                    if (i2 * i5 >= 0) {
                        int i6 = edge.f27114h;
                        if (i6 == 0) {
                            i2 = i2 < 0 ? i2 - 1 : i2 + 1;
                        } else if (i5 * i6 >= 0) {
                            i2 += i6;
                        }
                    } else if (Math.abs(i2) > 1) {
                        int i7 = edge3.f27114h;
                        int i8 = edge.f27114h;
                        i2 = i7 * i8 < 0 ? edge3.f27115i : edge3.f27115i + i8;
                    } else {
                        i2 = edge.f27114h;
                        if (i2 == 0) {
                            i2 = 1;
                        }
                    }
                }
                edge.f27115i = i2;
            } else {
                edge.f27115i = 1;
            }
            edge.f27116j = edge3.f27116j;
            edge2 = edge3.o;
        }
        if (edge.j(this.u, this.v)) {
            while (edge2 != edge) {
                if (edge2.f27114h != 0) {
                    edge.f27116j = edge.f27116j == 0 ? 1 : 0;
                }
                edge2 = edge2.o;
            }
            return;
        }
        while (edge2 != edge) {
            edge.f27116j += edge2.f27114h;
            edge2 = edge2.o;
        }
    }

    private void C(Paths paths) {
        paths.clear();
        for (int i2 = 0; i2 < this.f27099m.size(); i2++) {
            Path.OutRec outRec = this.f27099m.get(i2);
            if (outRec.c() != null) {
                Path.OutPt outPt = outRec.c().f27136d;
                int d2 = outPt.d();
                Logger logger = C;
                logger.finest("cnt = " + d2);
                if (d2 >= 2) {
                    Path path = new Path(d2);
                    for (int i3 = 0; i3 < d2; i3++) {
                        path.add(outPt.e());
                        outPt = outPt.f27136d;
                    }
                    paths.add(path);
                }
            }
        }
    }

    private void D(PolyTree polyTree) {
        PolyNode polyNode;
        polyTree.r();
        for (int i2 = 0; i2 < this.f27099m.size(); i2++) {
            Path.OutRec outRec = this.f27099m.get(i2);
            int d2 = outRec.c() != null ? outRec.c().d() : 0;
            boolean z2 = outRec.f27139c;
            if ((!z2 || d2 >= 2) && (z2 || d2 >= 3)) {
                outRec.b();
                PolyNode polyNode2 = new PolyNode();
                polyTree.s().add(polyNode2);
                outRec.f27143g = polyNode2;
                Path.OutPt outPt = outRec.c().f27136d;
                for (int i3 = 0; i3 < d2; i3++) {
                    polyNode2.j().add(outPt.e());
                    outPt = outPt.f27136d;
                }
            }
        }
        for (int i4 = 0; i4 < this.f27099m.size(); i4++) {
            Path.OutRec outRec2 = this.f27099m.get(i4);
            PolyNode polyNode3 = outRec2.f27143g;
            if (polyNode3 != null) {
                if (outRec2.f27139c) {
                    polyNode3.p(true);
                    polyTree.a(outRec2.f27143g);
                } else {
                    Path.OutRec outRec3 = outRec2.f27140d;
                    if (outRec3 == null || (polyNode = outRec3.f27143g) == null) {
                        polyTree.a(polyNode3);
                    } else {
                        polyNode.a(polyNode3);
                    }
                }
            }
        }
    }

    private void E() {
        Edge edge = this.q;
        this.r = edge;
        while (edge != null) {
            edge.r = edge.p;
            Edge edge2 = edge.o;
            edge.q = edge2;
            edge = edge2;
        }
    }

    private Path.OutRec F() {
        Path.OutRec outRec = new Path.OutRec();
        outRec.f27137a = -1;
        outRec.f27138b = false;
        outRec.f27139c = false;
        outRec.f27140d = null;
        outRec.d((Path.OutPt) null);
        outRec.f27142f = null;
        outRec.f27143g = null;
        this.f27099m.add(outRec);
        outRec.f27137a = this.f27099m.size() - 1;
        return outRec;
    }

    private void G(Edge edge) {
        Logger logger = C;
        Class<DefaultClipper> cls = DefaultClipper.class;
        logger.entering(cls.getName(), "deleteFromAEL");
        Edge edge2 = edge.p;
        Edge edge3 = edge.o;
        if (edge2 != null || edge3 != null || edge == this.q) {
            if (edge2 != null) {
                edge2.o = edge3;
            } else {
                this.q = edge3;
            }
            if (edge3 != null) {
                edge3.p = edge2;
            }
            edge.o = null;
            edge.p = null;
            logger.exiting(cls.getName(), "deleteFromAEL");
        }
    }

    private void H(Edge edge) {
        C.entering(DefaultClipper.class.getName(), "deleteFromSEL");
        Edge edge2 = edge.r;
        Edge edge3 = edge.q;
        if (edge2 != null || edge3 != null || edge.equals(this.r)) {
            if (edge2 != null) {
                edge2.q = edge3;
            } else {
                this.r = edge3;
            }
            if (edge3 != null) {
                edge3.r = edge2;
            }
            edge.q = null;
            edge.r = null;
        }
    }

    private boolean I(long j2, long j3, long j4, long j5) {
        if (j2 > j3) {
            long j6 = j2;
            j2 = j3;
            j3 = j6;
        }
        if (j4 <= j5) {
            long j7 = j4;
            j4 = j5;
            j5 = j7;
        }
        return j2 < j4 && j5 < j3;
    }

    private void J(Edge edge) {
        Edge f2 = edge.f();
        if (f2 == null) {
            if (edge.f27117k >= 0) {
                z(edge, edge.h());
            }
            G(edge);
            return;
        }
        while (true) {
            Edge edge2 = edge.o;
            if (edge2 == null || edge2 == f2) {
                int i2 = edge.f27117k;
            } else {
                Point.LongPoint longPoint = new Point.LongPoint(edge.h());
                Z(edge, edge2, longPoint);
                edge.r(longPoint);
                x0(edge, edge2);
            }
        }
        int i22 = edge.f27117k;
        if (!(i22 == -1 && f2.f27117k == -1)) {
            if (i22 < 0 || f2.f27117k < 0) {
                if (edge.f27114h == 0) {
                    if (i22 >= 0) {
                        z(edge, edge.h());
                        edge.f27117k = -1;
                    }
                    G(edge);
                    if (f2.f27117k >= 0) {
                        z(f2, edge.h());
                        f2.f27117k = -1;
                    }
                    G(f2);
                }
                throw new IllegalStateException("DoMaxima error");
            } else if (i22 >= 0) {
                x(edge, f2, edge.h());
            }
        }
        G(edge);
        G(f2);
    }

    private void K() {
        int i2 = 0;
        while (i2 < this.f27099m.size()) {
            int i3 = i2 + 1;
            Path.OutRec outRec = this.f27099m.get(i2);
            Path.OutPt c2 = outRec.c();
            if (c2 == null || outRec.f27139c) {
                i2 = i3;
            } else {
                do {
                    Path.OutPt outPt = c2.f27135c;
                    while (outPt != outRec.c()) {
                        if (c2.e().equals(outPt.e()) && !outPt.f27135c.equals(c2) && !outPt.f27136d.equals(c2)) {
                            Path.OutPt outPt2 = c2.f27136d;
                            Path.OutPt outPt3 = outPt.f27136d;
                            c2.f27136d = outPt3;
                            outPt3.f27135c = c2;
                            outPt.f27136d = outPt2;
                            outPt2.f27135c = outPt;
                            outRec.d(c2);
                            Path.OutRec F = F();
                            F.d(outPt);
                            A0(F);
                            if (k0(F.c(), outRec.c())) {
                                F.f27138b = !outRec.f27138b;
                                F.f27140d = outRec;
                                if (this.y) {
                                    P(F, outRec);
                                }
                            } else if (k0(outRec.c(), F.c())) {
                                boolean z2 = outRec.f27138b;
                                F.f27138b = z2;
                                outRec.f27138b = !z2;
                                F.f27140d = outRec.f27140d;
                                outRec.f27140d = F;
                                if (this.y) {
                                    P(outRec, F);
                                }
                            } else {
                                F.f27138b = outRec.f27138b;
                                F.f27140d = outRec.f27140d;
                                if (this.y) {
                                    O(outRec, F);
                                }
                            }
                            outPt = c2;
                        }
                        outPt = outPt.f27135c;
                    }
                    c2 = c2.f27135c;
                } while (c2 != outRec.c());
                i2 = i3;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (r0 >= r10.f27099m.size()) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0047, code lost:
        r2 = r10.f27099m.get(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r2.f27141e == null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        if (r2.f27139c == false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        r4 = r2.f27138b ^ r10.A;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0065, code lost:
        if (r2.a() <= 0.0d) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
        if (r4 != r3) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006b, code lost:
        r2.c().g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0075, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0078, code lost:
        d0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0081, code lost:
        if (r1 >= r10.f27099m.size()) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0083, code lost:
        r0 = r10.f27099m.get(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008f, code lost:
        if (r0.c() != null) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0094, code lost:
        if (r0.f27139c == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0096, code lost:
        S(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009a, code lost:
        R(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009d, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a2, code lost:
        if (r10.B == false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a4, code lost:
        K();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a7, code lost:
        r10.w.clear();
        r10.x.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b1, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean N() {
        /*
            r10 = this;
            r10.q()     // Catch:{ all -> 0x0073 }
            com.itextpdf.text.pdf.parser.clipper.ClipperBase$LocalMinima r0 = r10.f27071e     // Catch:{ all -> 0x0073 }
            r1 = 0
            if (r0 != 0) goto L_0x0013
        L_0x0008:
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$Join> r0 = r10.w
            r0.clear()
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$Join> r0 = r10.x
            r0.clear()
            return r1
        L_0x0013:
            long r2 = r10.l0()     // Catch:{ all -> 0x0073 }
        L_0x0017:
            r10.X(r2)     // Catch:{ all -> 0x0073 }
            r10.o0()     // Catch:{ all -> 0x0073 }
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$Join> r0 = r10.x     // Catch:{ all -> 0x0073 }
            r0.clear()     // Catch:{ all -> 0x0073 }
            com.itextpdf.text.pdf.parser.clipper.ClipperBase$Scanbeam r0 = r10.o     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x0027
            goto L_0x003d
        L_0x0027:
            long r2 = r10.l0()     // Catch:{ all -> 0x0073 }
            boolean r0 = r10.q0(r2)     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x0032
            goto L_0x0008
        L_0x0032:
            r10.m0(r2)     // Catch:{ all -> 0x0073 }
            com.itextpdf.text.pdf.parser.clipper.ClipperBase$Scanbeam r0 = r10.o     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x0017
            com.itextpdf.text.pdf.parser.clipper.ClipperBase$LocalMinima r0 = r10.f27071e     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x0017
        L_0x003d:
            r0 = 0
        L_0x003e:
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$OutRec> r2 = r10.f27099m     // Catch:{ all -> 0x0073 }
            int r2 = r2.size()     // Catch:{ all -> 0x0073 }
            r3 = 1
            if (r0 >= r2) goto L_0x0078
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$OutRec> r2 = r10.f27099m     // Catch:{ all -> 0x0073 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0073 }
            com.itextpdf.text.pdf.parser.clipper.Path$OutRec r2 = (com.itextpdf.text.pdf.parser.clipper.Path.OutRec) r2     // Catch:{ all -> 0x0073 }
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r4 = r2.f27141e     // Catch:{ all -> 0x0073 }
            if (r4 == 0) goto L_0x0075
            boolean r4 = r2.f27139c     // Catch:{ all -> 0x0073 }
            if (r4 == 0) goto L_0x0058
            goto L_0x0075
        L_0x0058:
            boolean r4 = r2.f27138b     // Catch:{ all -> 0x0073 }
            boolean r5 = r10.A     // Catch:{ all -> 0x0073 }
            r4 = r4 ^ r5
            double r5 = r2.a()     // Catch:{ all -> 0x0073 }
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r3 = 0
        L_0x0069:
            if (r4 != r3) goto L_0x0075
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r2 = r2.c()     // Catch:{ all -> 0x0073 }
            r2.g()     // Catch:{ all -> 0x0073 }
            goto L_0x0075
        L_0x0073:
            r0 = move-exception
            goto L_0x00b2
        L_0x0075:
            int r0 = r0 + 1
            goto L_0x003e
        L_0x0078:
            r10.d0()     // Catch:{ all -> 0x0073 }
        L_0x007b:
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$OutRec> r0 = r10.f27099m     // Catch:{ all -> 0x0073 }
            int r0 = r0.size()     // Catch:{ all -> 0x0073 }
            if (r1 >= r0) goto L_0x00a0
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$OutRec> r0 = r10.f27099m     // Catch:{ all -> 0x0073 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0073 }
            com.itextpdf.text.pdf.parser.clipper.Path$OutRec r0 = (com.itextpdf.text.pdf.parser.clipper.Path.OutRec) r0     // Catch:{ all -> 0x0073 }
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r2 = r0.c()     // Catch:{ all -> 0x0073 }
            if (r2 != 0) goto L_0x0092
            goto L_0x009d
        L_0x0092:
            boolean r2 = r0.f27139c     // Catch:{ all -> 0x0073 }
            if (r2 == 0) goto L_0x009a
            r10.S(r0)     // Catch:{ all -> 0x0073 }
            goto L_0x009d
        L_0x009a:
            r10.R(r0)     // Catch:{ all -> 0x0073 }
        L_0x009d:
            int r1 = r1 + 1
            goto L_0x007b
        L_0x00a0:
            boolean r0 = r10.B     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x00a7
            r10.K()     // Catch:{ all -> 0x0073 }
        L_0x00a7:
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$Join> r0 = r10.w
            r0.clear()
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$Join> r0 = r10.x
            r0.clear()
            return r3
        L_0x00b2:
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$Join> r1 = r10.w
            r1.clear()
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$Join> r1 = r10.x
            r1.clear()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.DefaultClipper.N():boolean");
    }

    private void O(Path.OutRec outRec, Path.OutRec outRec2) {
        Path.OutRec outRec3;
        for (int i2 = 0; i2 < this.f27099m.size(); i2++) {
            Path.OutRec outRec4 = this.f27099m.get(i2);
            if (outRec4.c() != null && (outRec3 = outRec4.f27140d) != null && ClipperBase.l(outRec3).equals(outRec) && k0(outRec4.c(), outRec2.c())) {
                outRec4.f27140d = outRec2;
            }
        }
    }

    private void P(Path.OutRec outRec, Path.OutRec outRec2) {
        for (Path.OutRec next : this.f27099m) {
            if (next.f27140d == outRec) {
                next.f27140d = outRec2;
            }
        }
    }

    private boolean Q() {
        Collections.sort(this.s, this.t);
        E();
        int size = this.s.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!r(this.s.get(i2))) {
                int i3 = i2 + 1;
                while (i3 < size && !r(this.s.get(i3))) {
                    i3++;
                }
                if (i3 == size) {
                    return false;
                }
                List<IntersectNode> list = this.s;
                list.set(i2, list.get(i3));
                this.s.set(i3, this.s.get(i2));
            }
            y0(this.s.get(i2).f27103a, this.s.get(i2).f27104b);
        }
        return true;
    }

    private void R(Path.OutRec outRec) {
        outRec.f27142f = null;
        Path.OutPt c2 = outRec.c();
        boolean z2 = this.f27075i || this.B;
        loop0:
        while (true) {
            Path.OutPt outPt = null;
            while (true) {
                Path.OutPt outPt2 = c2.f27136d;
                if (outPt2 == c2 || outPt2 == c2.f27135c) {
                    outRec.d((Path.OutPt) null);
                } else if (c2.e().equals(c2.f27135c.e()) || c2.e().equals(c2.f27136d.e()) || (Point.j(c2.f27136d.e(), c2.e(), c2.f27135c.e(), this.f27073g) && (!z2 || !Point.d(c2.f27136d.e(), c2.e(), c2.f27135c.e())))) {
                    Path.OutPt outPt3 = c2.f27136d;
                    outPt3.f27135c = c2.f27135c;
                    c2.f27135c.f27136d = outPt3;
                    c2 = c2.f27136d;
                } else if (c2 == outPt) {
                    outRec.d(c2);
                    return;
                } else {
                    if (outPt == null) {
                        outPt = c2;
                    }
                    c2 = c2.f27135c;
                }
            }
            Path.OutPt outPt32 = c2.f27136d;
            outPt32.f27135c = c2.f27135c;
            c2.f27135c.f27136d = outPt32;
            c2 = c2.f27136d;
        }
        outRec.d((Path.OutPt) null);
    }

    private void S(Path.OutRec outRec) {
        Path.OutPt outPt = outRec.f27141e;
        Path.OutPt outPt2 = outPt.f27136d;
        while (outPt != outPt2) {
            outPt = outPt.f27135c;
            if (outPt.f27134b.equals(outPt.f27136d.f27134b)) {
                if (outPt == outPt2) {
                    outPt2 = outPt.f27136d;
                }
                Path.OutPt outPt3 = outPt.f27136d;
                outPt3.f27135c = outPt.f27135c;
                outPt.f27135c.f27136d = outPt3;
                outPt = outPt3;
            }
        }
        if (outPt == outPt.f27136d) {
            outRec.f27141e = null;
        }
    }

    private static void T(Edge edge, Clipper.Direction[] directionArr, long[] jArr, long[] jArr2) {
        if (edge.c().m() < edge.h().m()) {
            jArr[0] = edge.c().m();
            jArr2[0] = edge.h().m();
            directionArr[0] = Clipper.Direction.LEFT_TO_RIGHT;
            return;
        }
        jArr[0] = edge.h().m();
        jArr2[0] = edge.c().m();
        directionArr[0] = Clipper.Direction.RIGHT_TO_LEFT;
    }

    private Path.OutRec U(int i2) {
        List<Path.OutRec> list = this.f27099m;
        while (true) {
            Path.OutRec outRec = list.get(i2);
            if (outRec == this.f27099m.get(outRec.f27137a)) {
                return outRec;
            }
            list = this.f27099m;
            i2 = outRec.f27137a;
        }
    }

    private static boolean V(long j2, long j3, long j4, long j5, long[] jArr, long[] jArr2) {
        if (j2 < j3) {
            if (j4 < j5) {
                jArr[0] = Math.max(j2, j4);
                jArr2[0] = Math.min(j3, j5);
            } else {
                jArr[0] = Math.max(j2, j5);
                jArr2[0] = Math.min(j3, j4);
            }
        } else if (j4 < j5) {
            jArr[0] = Math.max(j3, j4);
            jArr2[0] = Math.min(j2, j5);
        } else {
            jArr[0] = Math.max(j3, j5);
            jArr2[0] = Math.min(j2, j4);
        }
        return jArr[0] < jArr2[0];
    }

    private void W(Edge edge, Edge edge2) {
        Logger logger = C;
        logger.entering(DefaultClipper.class.getName(), "insertEdgeIntoAEL");
        Edge edge3 = this.q;
        if (edge3 == null) {
            edge.p = null;
            edge.o = null;
            logger.finest("Edge " + edge.f27117k + " -> " + null);
        } else if (edge2 != null || !Edge.a(edge3, edge)) {
            logger.finest("activeEdges unchanged");
            if (edge2 == null) {
                edge2 = this.q;
            }
            while (true) {
                Edge edge4 = edge2.o;
                if (edge4 == null || Edge.a(edge4, edge)) {
                    edge.o = edge2.o;
                    Edge edge5 = edge2.o;
                } else {
                    edge2 = edge2.o;
                }
            }
            edge.o = edge2.o;
            Edge edge52 = edge2.o;
            if (edge52 != null) {
                edge52.p = edge;
            }
            edge.p = edge2;
            edge2.o = edge;
            return;
        } else {
            edge.p = null;
            edge.o = this.q;
            logger.finest("Edge " + edge.f27117k + " -> " + edge.o.f27117k);
            this.q.p = edge;
        }
        this.q = edge;
    }

    private void X(long j2) {
        Edge edge;
        C.entering(DefaultClipper.class.getName(), "insertLocalMinimaIntoAEL");
        while (true) {
            ClipperBase.LocalMinima localMinima = this.f27071e;
            if (localMinima != null && localMinima.f27076a == j2) {
                Edge edge2 = localMinima.f27077b;
                Edge edge3 = localMinima.f27078c;
                m();
                Path.OutPt outPt = null;
                if (edge2 == null) {
                    W(edge3, (Edge) null);
                    B0(edge3);
                    if (edge3.i(this.u, this.v, this.f27100n)) {
                        outPt = z(edge3, edge3.c());
                    }
                } else {
                    W(edge2, (Edge) null);
                    if (edge3 == null) {
                        B0(edge2);
                        if (edge2.i(this.u, this.v, this.f27100n)) {
                            outPt = z(edge2, edge2.c());
                        }
                    } else {
                        W(edge3, edge2);
                        B0(edge2);
                        edge3.f27115i = edge2.f27115i;
                        edge3.f27116j = edge2.f27116j;
                        if (edge2.i(this.u, this.v, this.f27100n)) {
                            outPt = y(edge2, edge3, edge2.c());
                        }
                    }
                    Y(edge2.h().n());
                }
                Path.OutPt outPt2 = outPt;
                if (edge3 != null) {
                    if (edge3.l()) {
                        u(edge3);
                    } else {
                        Y(edge3.h().n());
                    }
                }
                if (!(edge2 == null || edge3 == null)) {
                    if (outPt2 != null && edge3.l() && this.x.size() > 0 && edge3.f27114h != 0) {
                        for (int i2 = 0; i2 < this.x.size(); i2++) {
                            Path.Join join = this.x.get(i2);
                            if (I(join.f27127a.e().m(), join.a().m(), edge3.c().m(), edge3.h().m())) {
                                w(join.f27127a, outPt2, join.a());
                            }
                        }
                    }
                    if (edge2.f27117k >= 0 && (edge = edge2.p) != null && edge.d().m() == edge2.c().m()) {
                        Edge edge4 = edge2.p;
                        if (edge4.f27117k >= 0 && Edge.s(edge4, edge2, this.f27073g) && edge2.f27114h != 0) {
                            Edge edge5 = edge2.p;
                            if (edge5.f27114h != 0) {
                                w(outPt2, z(edge5, edge2.c()), edge2.h());
                            }
                        }
                    }
                    if (edge2.o != edge3) {
                        if (edge3.f27117k >= 0) {
                            Edge edge6 = edge3.p;
                            if (edge6.f27117k >= 0 && Edge.s(edge6, edge3, this.f27073g) && edge3.f27114h != 0) {
                                Edge edge7 = edge3.p;
                                if (edge7.f27114h != 0) {
                                    w(outPt2, z(edge7, edge3.c()), edge3.h());
                                }
                            }
                        }
                        Edge edge8 = edge2.o;
                        if (edge8 != null) {
                            while (edge8 != edge3) {
                                Z(edge3, edge8, edge2.d());
                                edge8 = edge8.o;
                            }
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    private void Y(long j2) {
        ClipperBase.Scanbeam scanbeam = this.o;
        if (scanbeam == null) {
            ClipperBase.Scanbeam scanbeam2 = new ClipperBase.Scanbeam();
            this.o = scanbeam2;
            scanbeam2.f27082b = null;
            scanbeam2.f27081a = j2;
        } else if (j2 > scanbeam.f27081a) {
            ClipperBase.Scanbeam scanbeam3 = new ClipperBase.Scanbeam();
            scanbeam3.f27081a = j2;
            scanbeam3.f27082b = this.o;
            this.o = scanbeam3;
        } else {
            while (true) {
                ClipperBase.Scanbeam scanbeam4 = scanbeam.f27082b;
                if (scanbeam4 != null && j2 <= scanbeam4.f27081a) {
                    scanbeam = scanbeam4;
                }
            }
            if (j2 != scanbeam.f27081a) {
                ClipperBase.Scanbeam scanbeam5 = new ClipperBase.Scanbeam();
                scanbeam5.f27081a = j2;
                scanbeam5.f27082b = scanbeam.f27082b;
                scanbeam.f27082b = scanbeam5;
            }
        }
    }

    private void Z(Edge edge, Edge edge2, Point.LongPoint longPoint) {
        Clipper.PolyFillType polyFillType;
        Clipper.PolyFillType polyFillType2;
        Clipper.PolyFillType polyFillType3;
        Clipper.PolyFillType polyFillType4;
        int i2;
        C.entering(DefaultClipper.class.getName(), "insersectEdges");
        int i3 = 0;
        boolean z2 = edge.f27117k >= 0;
        boolean z3 = edge2.f27117k >= 0;
        s0(longPoint, edge, edge2);
        int i4 = edge.f27114h;
        if (i4 != 0 && edge2.f27114h != 0) {
            if (edge.f27112f == edge2.f27112f) {
                if (edge.k(this.u, this.v)) {
                    i2 = edge.f27115i;
                    edge.f27115i = edge2.f27115i;
                } else {
                    int i5 = edge.f27115i;
                    int i6 = edge2.f27114h;
                    edge.f27115i = i5 + i6 == 0 ? -i5 : i5 + i6;
                    int i7 = edge2.f27115i;
                    int i8 = edge.f27114h;
                    i2 = i7 - i8 == 0 ? -i7 : i7 - i8;
                }
                edge2.f27115i = i2;
            } else {
                edge.f27116j = !edge2.k(this.u, this.v) ? edge.f27116j + edge2.f27114h : edge.f27116j == 0 ? 1 : 0;
                if (!edge.k(this.u, this.v)) {
                    i3 = edge2.f27116j - edge.f27114h;
                } else if (edge2.f27116j == 0) {
                    i3 = 1;
                }
                edge2.f27116j = i3;
            }
            Clipper.PolyType polyType = edge.f27112f;
            Clipper.PolyType polyType2 = Clipper.PolyType.SUBJECT;
            if (polyType == polyType2) {
                polyFillType2 = this.v;
                polyFillType = this.u;
            } else {
                polyFillType2 = this.u;
                polyFillType = this.v;
            }
            if (edge2.f27112f == polyType2) {
                polyFillType4 = this.v;
                polyFillType3 = this.u;
            } else {
                polyFillType4 = this.u;
                polyFillType3 = this.v;
            }
            int[] iArr = AnonymousClass2.f27101a;
            int i9 = iArr[polyFillType2.ordinal()];
            int abs = i9 != 1 ? i9 != 2 ? Math.abs(edge.f27115i) : -edge.f27115i : edge.f27115i;
            int i10 = iArr[polyFillType4.ordinal()];
            int abs2 = i10 != 1 ? i10 != 2 ? Math.abs(edge2.f27115i) : -edge2.f27115i : edge2.f27115i;
            if (!z2 || !z3) {
                if (z2) {
                    if (abs2 == 0 || abs2 == 1) {
                        z(edge, longPoint);
                        Edge.u(edge, edge2);
                        Edge.t(edge, edge2);
                    }
                    return;
                } else if (z3) {
                    if (!(abs == 0 || abs == 1)) {
                        return;
                    }
                } else if (abs != 0 && abs != 1) {
                    return;
                } else {
                    if (abs2 == 0 || abs2 == 1) {
                        int i11 = iArr[polyFillType.ordinal()];
                        int abs3 = i11 != 1 ? i11 != 2 ? Math.abs(edge.f27116j) : -edge.f27116j : edge.f27116j;
                        int i12 = iArr[polyFillType3.ordinal()];
                        int abs4 = i12 != 1 ? i12 != 2 ? Math.abs(edge2.f27116j) : -edge2.f27116j : edge2.f27116j;
                        if (edge.f27112f == edge2.f27112f) {
                            if (abs == 1 && abs2 == 1) {
                                int i13 = AnonymousClass2.f27102b[this.f27100n.ordinal()];
                                if (i13 != 1) {
                                    if (i13 != 2) {
                                        if (i13 == 3) {
                                            Clipper.PolyType polyType3 = edge.f27112f;
                                            if ((polyType3 != Clipper.PolyType.CLIP || abs3 <= 0 || abs4 <= 0) && (polyType3 != polyType2 || abs3 > 0 || abs4 > 0)) {
                                                return;
                                            }
                                        } else if (i13 != 4) {
                                            return;
                                        }
                                    } else if (abs3 > 0 || abs4 > 0) {
                                        return;
                                    }
                                } else if (abs3 <= 0 || abs4 <= 0) {
                                    return;
                                }
                            } else {
                                Edge.u(edge, edge2);
                                return;
                            }
                        }
                        y(edge, edge2, longPoint);
                        return;
                    }
                    return;
                }
            } else if ((abs == 0 || abs == 1) && ((abs2 == 0 || abs2 == 1) && (edge.f27112f == edge2.f27112f || this.f27100n == Clipper.ClipType.XOR))) {
                z(edge, longPoint);
            } else {
                x(edge, edge2, longPoint);
                return;
            }
            z(edge2, longPoint);
            Edge.u(edge, edge2);
            Edge.t(edge, edge2);
        } else if (i4 != 0 || edge2.f27114h != 0) {
            Clipper.PolyType polyType4 = edge.f27112f;
            Clipper.PolyType polyType5 = edge2.f27112f;
            if (polyType4 == polyType5 && i4 != edge2.f27114h && this.f27100n == Clipper.ClipType.UNION) {
                if (i4 == 0) {
                    if (z3) {
                        z(edge, longPoint);
                        if (!z2) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (z2) {
                    z(edge2, longPoint);
                    if (!z3) {
                        return;
                    }
                    edge2.f27117k = -1;
                    return;
                } else {
                    return;
                }
            } else if (polyType4 == polyType5) {
                return;
            } else {
                if (i4 == 0 && Math.abs(edge2.f27115i) == 1 && (this.f27100n != Clipper.ClipType.UNION || edge2.f27116j == 0)) {
                    z(edge, longPoint);
                    if (!z2) {
                        return;
                    }
                } else if (edge2.f27114h != 0 || Math.abs(edge.f27115i) != 1) {
                    return;
                } else {
                    if (this.f27100n != Clipper.ClipType.UNION || edge.f27116j == 0) {
                        z(edge2, longPoint);
                        if (!z3) {
                            return;
                        }
                        edge2.f27117k = -1;
                        return;
                    }
                    return;
                }
            }
            edge.f27117k = -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a0(com.itextpdf.text.pdf.parser.clipper.Edge r12, com.itextpdf.text.pdf.parser.clipper.Edge r13, com.itextpdf.text.pdf.parser.clipper.Point.LongPoint[] r14) {
        /*
            r11 = this;
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = new com.itextpdf.text.pdf.parser.clipper.Point$LongPoint
            r0.<init>()
            r1 = 0
            r14[r1] = r0
            double r1 = r12.f27111e
            double r3 = r13.f27111e
            int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r14 != 0) goto L_0x002f
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r13 = r12.d()
            long r13 = r13.n()
            java.lang.Long r13 = java.lang.Long.valueOf(r13)
            r0.g(r13)
            long r13 = r0.n()
            long r12 = com.itextpdf.text.pdf.parser.clipper.Edge.v(r12, r13)
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            r0.f(r12)
            return
        L_0x002f:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r12.e()
            long r1 = r14.m()
            r3 = 0
            int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r14 != 0) goto L_0x0087
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r12.c()
            long r1 = r14.m()
            java.lang.Long r14 = java.lang.Long.valueOf(r1)
            r0.f(r14)
            boolean r14 = r13.l()
            if (r14 == 0) goto L_0x0063
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r13.c()
        L_0x0056:
            long r1 = r14.n()
        L_0x005a:
            java.lang.Long r14 = java.lang.Long.valueOf(r1)
            r0.g(r14)
            goto L_0x0135
        L_0x0063:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r13.c()
            long r1 = r14.n()
            double r1 = (double) r1
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r13.c()
            long r3 = r14.m()
            double r3 = (double) r3
            double r5 = r13.f27111e
            double r3 = r3 / r5
            double r1 = r1 - r3
            long r3 = r0.m()
            double r3 = (double) r3
            double r5 = r13.f27111e
        L_0x0080:
            double r3 = r3 / r5
            double r3 = r3 + r1
            long r1 = java.lang.Math.round(r3)
            goto L_0x005a
        L_0x0087:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r13.e()
            long r1 = r14.m()
            int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r14 != 0) goto L_0x00cb
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r13.c()
            long r1 = r14.m()
            java.lang.Long r14 = java.lang.Long.valueOf(r1)
            r0.f(r14)
            boolean r14 = r12.l()
            if (r14 == 0) goto L_0x00ad
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r12.c()
            goto L_0x0056
        L_0x00ad:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r12.c()
            long r1 = r14.n()
            double r1 = (double) r1
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r12.c()
            long r3 = r14.m()
            double r3 = (double) r3
            double r5 = r12.f27111e
            double r3 = r3 / r5
            double r1 = r1 - r3
            long r3 = r0.m()
            double r3 = (double) r3
            double r5 = r12.f27111e
            goto L_0x0080
        L_0x00cb:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r12.c()
            long r1 = r14.m()
            double r1 = (double) r1
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r12.c()
            long r3 = r14.n()
            double r3 = (double) r3
            double r5 = r12.f27111e
            double r3 = r3 * r5
            double r1 = r1 - r3
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r13.c()
            long r3 = r14.m()
            double r3 = (double) r3
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r13.c()
            long r5 = r14.n()
            double r5 = (double) r5
            double r7 = r13.f27111e
            double r5 = r5 * r7
            double r3 = r3 - r5
            double r5 = r3 - r1
            double r9 = r12.f27111e
            double r9 = r9 - r7
            double r5 = r5 / r9
            long r7 = java.lang.Math.round(r5)
            java.lang.Long r14 = java.lang.Long.valueOf(r7)
            r0.g(r14)
            double r7 = r12.f27111e
            double r7 = java.lang.Math.abs(r7)
            double r9 = r13.f27111e
            double r9 = java.lang.Math.abs(r9)
            int r14 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r14 >= 0) goto L_0x012b
            double r3 = r12.f27111e
            double r3 = r3 * r5
            double r3 = r3 + r1
            long r1 = java.lang.Math.round(r3)
        L_0x0123:
            java.lang.Long r14 = java.lang.Long.valueOf(r1)
            r0.f(r14)
            goto L_0x0135
        L_0x012b:
            double r1 = r13.f27111e
            double r1 = r1 * r5
            double r1 = r1 + r3
            long r1 = java.lang.Math.round(r1)
            goto L_0x0123
        L_0x0135:
            long r1 = r0.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r12.h()
            long r3 = r14.n()
            int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r14 < 0) goto L_0x0155
            long r1 = r0.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r13.h()
            long r3 = r14.n()
            int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r14 >= 0) goto L_0x01a3
        L_0x0155:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r12.h()
            long r1 = r14.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r13.h()
            long r3 = r14.n()
            int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r14 <= 0) goto L_0x0179
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r12.h()
        L_0x016d:
            long r1 = r14.n()
            java.lang.Long r14 = java.lang.Long.valueOf(r1)
            r0.g(r14)
            goto L_0x017e
        L_0x0179:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r13.h()
            goto L_0x016d
        L_0x017e:
            double r1 = r12.f27111e
            double r1 = java.lang.Math.abs(r1)
            double r3 = r13.f27111e
            double r3 = java.lang.Math.abs(r3)
            int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            long r1 = r0.n()
            if (r14 >= 0) goto L_0x019e
            long r1 = com.itextpdf.text.pdf.parser.clipper.Edge.v(r12, r1)
        L_0x0196:
            java.lang.Long r14 = java.lang.Long.valueOf(r1)
            r0.f(r14)
            goto L_0x01a3
        L_0x019e:
            long r1 = com.itextpdf.text.pdf.parser.clipper.Edge.v(r13, r1)
            goto L_0x0196
        L_0x01a3:
            long r1 = r0.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r12.d()
            long r3 = r14.n()
            int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r14 <= 0) goto L_0x01eb
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r12.d()
            long r1 = r14.n()
            java.lang.Long r14 = java.lang.Long.valueOf(r1)
            r0.g(r14)
            double r1 = r12.f27111e
            double r1 = java.lang.Math.abs(r1)
            double r3 = r13.f27111e
            double r3 = java.lang.Math.abs(r3)
            int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r14 <= 0) goto L_0x01e2
            long r1 = r0.n()
            long r12 = com.itextpdf.text.pdf.parser.clipper.Edge.v(r13, r1)
        L_0x01da:
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            r0.f(r12)
            goto L_0x01eb
        L_0x01e2:
            long r13 = r0.n()
            long r12 = com.itextpdf.text.pdf.parser.clipper.Edge.v(r12, r13)
            goto L_0x01da
        L_0x01eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.DefaultClipper.a0(com.itextpdf.text.pdf.parser.clipper.Edge, com.itextpdf.text.pdf.parser.clipper.Edge, com.itextpdf.text.pdf.parser.clipper.Point$LongPoint[]):void");
    }

    private static boolean b0(Path.OutRec outRec, Path.OutRec outRec2) {
        do {
            outRec = outRec.f27140d;
            if (outRec == outRec2) {
                return true;
            }
        } while (outRec != null);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
        if ((r0 > 0) == (r13 > r6)) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c2, code lost:
        if ((r4 > 0) == (r13 > r6)) goto L_0x00c4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ce A[LOOP:0: B:1:0x001b->B:57:0x00ce, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00cd A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int c0(com.itextpdf.text.pdf.parser.clipper.Point.LongPoint r23, com.itextpdf.text.pdf.parser.clipper.Path.OutPt r24) {
        /*
            long r0 = r23.m()
            long r2 = r23.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r24.e()
            long r4 = r4.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r24.e()
            long r6 = r6.n()
            r9 = r24
            r10 = 0
        L_0x001b:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r9 = r9.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r11 = r9.e()
            long r11 = r11.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r13 = r9.e()
            long r13 = r13.n()
            r16 = 1
            int r17 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r17 != 0) goto L_0x004b
            int r18 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r18 == 0) goto L_0x0049
            int r19 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r19 != 0) goto L_0x004b
            if (r18 <= 0) goto L_0x003f
            r8 = 1
            goto L_0x0040
        L_0x003f:
            r8 = 0
        L_0x0040:
            int r18 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r18 >= 0) goto L_0x0046
            r15 = 1
            goto L_0x0047
        L_0x0046:
            r15 = 0
        L_0x0047:
            if (r8 != r15) goto L_0x004b
        L_0x0049:
            r0 = -1
            return r0
        L_0x004b:
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x0051
            r8 = 1
            goto L_0x0052
        L_0x0051:
            r8 = 0
        L_0x0052:
            if (r17 >= 0) goto L_0x0056
            r15 = 1
            goto L_0x0057
        L_0x0056:
            r15 = 0
        L_0x0057:
            if (r8 == r15) goto L_0x00c7
            r19 = 0
            int r8 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r8 < 0) goto L_0x0098
            int r8 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r8 <= 0) goto L_0x006c
            int r10 = 1 - r10
            r21 = r0
            r1 = r9
            r0 = r24
            goto L_0x00cb
        L_0x006c:
            long r4 = r4 - r0
            double r4 = (double) r4
            r15 = r9
            long r8 = r13 - r2
            double r8 = (double) r8
            double r4 = r4 * r8
            long r8 = r11 - r0
            double r8 = (double) r8
            r21 = r0
            long r0 = r6 - r2
            double r0 = (double) r0
            double r8 = r8 * r0
            double r4 = r4 - r8
            int r0 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r0 != 0) goto L_0x0085
            r1 = -1
            return r1
        L_0x0085:
            if (r0 <= 0) goto L_0x0089
            r0 = 1
            goto L_0x008a
        L_0x0089:
            r0 = 0
        L_0x008a:
            int r1 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0090
            r1 = 1
            goto L_0x0091
        L_0x0090:
            r1 = 0
        L_0x0091:
            if (r0 != r1) goto L_0x0094
            goto L_0x00c4
        L_0x0094:
            r0 = r24
            r1 = r15
            goto L_0x00cb
        L_0x0098:
            r21 = r0
            r15 = r9
            int r0 = (r11 > r21 ? 1 : (r11 == r21 ? 0 : -1))
            if (r0 <= 0) goto L_0x0094
            long r4 = r4 - r21
            double r0 = (double) r4
            long r4 = r13 - r2
            double r4 = (double) r4
            double r0 = r0 * r4
            long r4 = r11 - r21
            double r4 = (double) r4
            long r8 = r6 - r2
            double r8 = (double) r8
            double r4 = r4 * r8
            double r0 = r0 - r4
            int r4 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r4 != 0) goto L_0x00b6
            r0 = -1
            return r0
        L_0x00b6:
            if (r4 <= 0) goto L_0x00ba
            r0 = 1
            goto L_0x00bb
        L_0x00ba:
            r0 = 0
        L_0x00bb:
            int r1 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c1
            r1 = 1
            goto L_0x00c2
        L_0x00c1:
            r1 = 0
        L_0x00c2:
            if (r0 != r1) goto L_0x0094
        L_0x00c4:
            int r10 = 1 - r10
            goto L_0x0094
        L_0x00c7:
            r21 = r0
            r15 = r9
            goto L_0x0094
        L_0x00cb:
            if (r0 != r1) goto L_0x00ce
            return r10
        L_0x00ce:
            r9 = r1
            r4 = r11
            r6 = r13
            r0 = r21
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.DefaultClipper.c0(com.itextpdf.text.pdf.parser.clipper.Point$LongPoint, com.itextpdf.text.pdf.parser.clipper.Path$OutPt):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0148 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d0() {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$Join> r2 = r11.w
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x014c
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$Join> r2 = r11.w
            java.lang.Object r2 = r2.get(r1)
            com.itextpdf.text.pdf.parser.clipper.Path$Join r2 = (com.itextpdf.text.pdf.parser.clipper.Path.Join) r2
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r2.f27127a
            int r3 = r3.f27133a
            com.itextpdf.text.pdf.parser.clipper.Path$OutRec r3 = r11.U(r3)
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r4 = r2.f27128b
            int r4 = r4.f27133a
            com.itextpdf.text.pdf.parser.clipper.Path$OutRec r4 = r11.U(r4)
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r5 = r3.c()
            if (r5 == 0) goto L_0x0148
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r5 = r4.c()
            if (r5 != 0) goto L_0x0030
            goto L_0x0148
        L_0x0030:
            boolean r5 = r3.f27139c
            if (r5 != 0) goto L_0x0148
            boolean r5 = r4.f27139c
            if (r5 == 0) goto L_0x003a
            goto L_0x0148
        L_0x003a:
            if (r3 != r4) goto L_0x003d
            goto L_0x004b
        L_0x003d:
            boolean r5 = b0(r3, r4)
            if (r5 == 0) goto L_0x0045
            r5 = r4
            goto L_0x0051
        L_0x0045:
            boolean r5 = b0(r4, r3)
            if (r5 == 0) goto L_0x004d
        L_0x004b:
            r5 = r3
            goto L_0x0051
        L_0x004d:
            com.itextpdf.text.pdf.parser.clipper.Path$OutRec r5 = com.itextpdf.text.pdf.parser.clipper.Path.OutPt.c(r3, r4)
        L_0x0051:
            boolean r6 = r11.f0(r2, r3, r4)
            if (r6 != 0) goto L_0x0059
            goto L_0x0148
        L_0x0059:
            r6 = 0
            if (r3 != r4) goto L_0x012c
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r4 = r2.f27127a
            r3.d(r4)
            r3.f27142f = r6
            com.itextpdf.text.pdf.parser.clipper.Path$OutRec r4 = r11.F()
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r5 = r2.f27128b
            r4.d(r5)
            r11.A0(r4)
            boolean r5 = r11.y
            r6 = 1
            if (r5 == 0) goto L_0x00ac
            r5 = 0
        L_0x0075:
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$OutRec> r7 = r11.f27099m
            int r7 = r7.size()
            int r7 = r7 - r6
            if (r5 >= r7) goto L_0x00ac
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$OutRec> r7 = r11.f27099m
            java.lang.Object r7 = r7.get(r5)
            com.itextpdf.text.pdf.parser.clipper.Path$OutRec r7 = (com.itextpdf.text.pdf.parser.clipper.Path.OutRec) r7
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r8 = r7.c()
            if (r8 == 0) goto L_0x00a9
            com.itextpdf.text.pdf.parser.clipper.Path$OutRec r8 = r7.f27140d
            com.itextpdf.text.pdf.parser.clipper.Path$OutRec r8 = com.itextpdf.text.pdf.parser.clipper.ClipperBase.l(r8)
            if (r8 != r3) goto L_0x00a9
            boolean r8 = r7.f27138b
            boolean r9 = r3.f27138b
            if (r8 != r9) goto L_0x009b
            goto L_0x00a9
        L_0x009b:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r8 = r7.c()
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r9 = r2.f27128b
            boolean r8 = k0(r8, r9)
            if (r8 == 0) goto L_0x00a9
            r7.f27140d = r4
        L_0x00a9:
            int r5 = r5 + 1
            goto L_0x0075
        L_0x00ac:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r2 = r4.c()
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r5 = r3.c()
            boolean r2 = k0(r2, r5)
            r7 = 0
            if (r2 == 0) goto L_0x00e3
            boolean r2 = r3.f27138b
            r2 = r2 ^ r6
            r4.f27138b = r2
            r4.f27140d = r3
            boolean r2 = r11.y
            if (r2 == 0) goto L_0x00ca
            r11.P(r4, r3)
        L_0x00ca:
            boolean r2 = r4.f27138b
            boolean r3 = r11.A
            r2 = r2 ^ r3
            double r9 = r4.a()
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x00d8
            goto L_0x00d9
        L_0x00d8:
            r6 = 0
        L_0x00d9:
            if (r2 != r6) goto L_0x0148
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r2 = r4.c()
        L_0x00df:
            r2.g()
            goto L_0x0148
        L_0x00e3:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r2 = r3.c()
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r5 = r4.c()
            boolean r2 = k0(r2, r5)
            if (r2 == 0) goto L_0x011c
            boolean r2 = r3.f27138b
            r4.f27138b = r2
            r2 = r2 ^ 1
            r3.f27138b = r2
            com.itextpdf.text.pdf.parser.clipper.Path$OutRec r2 = r3.f27140d
            r4.f27140d = r2
            r3.f27140d = r4
            boolean r2 = r11.y
            if (r2 == 0) goto L_0x0106
            r11.P(r3, r4)
        L_0x0106:
            boolean r2 = r3.f27138b
            boolean r4 = r11.A
            r2 = r2 ^ r4
            double r4 = r3.a()
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0114
            goto L_0x0115
        L_0x0114:
            r6 = 0
        L_0x0115:
            if (r2 != r6) goto L_0x0148
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r2 = r3.c()
            goto L_0x00df
        L_0x011c:
            boolean r2 = r3.f27138b
            r4.f27138b = r2
            com.itextpdf.text.pdf.parser.clipper.Path$OutRec r2 = r3.f27140d
            r4.f27140d = r2
            boolean r2 = r11.y
            if (r2 == 0) goto L_0x0148
            r11.O(r3, r4)
            goto L_0x0148
        L_0x012c:
            r4.d(r6)
            r4.f27142f = r6
            int r2 = r3.f27137a
            r4.f27137a = r2
            boolean r2 = r5.f27138b
            r3.f27138b = r2
            if (r5 != r4) goto L_0x013f
            com.itextpdf.text.pdf.parser.clipper.Path$OutRec r2 = r4.f27140d
            r3.f27140d = r2
        L_0x013f:
            r4.f27140d = r3
            boolean r2 = r11.y
            if (r2 == 0) goto L_0x0148
            r11.P(r4, r3)
        L_0x0148:
            int r1 = r1 + 1
            goto L_0x0002
        L_0x014c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.DefaultClipper.d0():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0113 A[LOOP:2: B:44:0x0113->B:50:0x014d, LOOP_START, PHI: r9 
      PHI: (r9v9 com.itextpdf.text.pdf.parser.clipper.Path$OutPt) = (r9v0 com.itextpdf.text.pdf.parser.clipper.Path$OutPt), (r9v14 com.itextpdf.text.pdf.parser.clipper.Path$OutPt) binds: [B:43:0x0111, B:50:0x014d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0181 A[LOOP:3: B:59:0x0181->B:65:0x01bb, LOOP_START, PHI: r9 
      PHI: (r9v2 com.itextpdf.text.pdf.parser.clipper.Path$OutPt) = (r9v0 com.itextpdf.text.pdf.parser.clipper.Path$OutPt), (r9v6 com.itextpdf.text.pdf.parser.clipper.Path$OutPt) binds: [B:43:0x0111, B:65:0x01bb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean e0(com.itextpdf.text.pdf.parser.clipper.Path.OutPt r7, com.itextpdf.text.pdf.parser.clipper.Path.OutPt r8, com.itextpdf.text.pdf.parser.clipper.Path.OutPt r9, com.itextpdf.text.pdf.parser.clipper.Path.OutPt r10, com.itextpdf.text.pdf.parser.clipper.Point.LongPoint r11, boolean r12) {
        /*
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r7.e()
            long r0 = r0.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r8 = r8.e()
            long r2 = r8.m()
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x0017
            com.itextpdf.text.pdf.parser.clipper.Clipper$Direction r8 = com.itextpdf.text.pdf.parser.clipper.Clipper.Direction.RIGHT_TO_LEFT
            goto L_0x0019
        L_0x0017:
            com.itextpdf.text.pdf.parser.clipper.Clipper$Direction r8 = com.itextpdf.text.pdf.parser.clipper.Clipper.Direction.LEFT_TO_RIGHT
        L_0x0019:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r9.e()
            long r0 = r0.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r10 = r10.e()
            long r2 = r10.m()
            int r10 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r10 <= 0) goto L_0x0030
            com.itextpdf.text.pdf.parser.clipper.Clipper$Direction r10 = com.itextpdf.text.pdf.parser.clipper.Clipper.Direction.RIGHT_TO_LEFT
            goto L_0x0032
        L_0x0030:
            com.itextpdf.text.pdf.parser.clipper.Clipper$Direction r10 = com.itextpdf.text.pdf.parser.clipper.Clipper.Direction.LEFT_TO_RIGHT
        L_0x0032:
            r0 = 0
            if (r8 != r10) goto L_0x0036
            return r0
        L_0x0036:
            com.itextpdf.text.pdf.parser.clipper.Clipper$Direction r1 = com.itextpdf.text.pdf.parser.clipper.Clipper.Direction.LEFT_TO_RIGHT
            if (r8 != r1) goto L_0x00a8
        L_0x003a:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r1 = r7.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r1.e()
            long r1 = r1.m()
            long r3 = r11.m()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0077
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r1 = r7.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r1.e()
            long r1 = r1.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = r7.e()
            long r3 = r3.m()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0077
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r1 = r7.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r1.e()
            long r1 = r1.n()
            long r3 = r11.n()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0077
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r7 = r7.f27135c
            goto L_0x003a
        L_0x0077:
            if (r12 == 0) goto L_0x008b
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r7.e()
            long r1 = r1.m()
            long r3 = r11.m()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x008b
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r7 = r7.f27135c
        L_0x008b:
            r1 = r12 ^ 1
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r1 = r7.a(r1)
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = r1.e()
            boolean r2 = r2.equals(r11)
            if (r2 != 0) goto L_0x010f
            r1.h(r11)
            r7 = r12 ^ 1
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r7 = r1.a(r7)
        L_0x00a4:
            r6 = r1
            r1 = r7
            r7 = r6
            goto L_0x010f
        L_0x00a8:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r1 = r7.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r1.e()
            long r1 = r1.m()
            long r3 = r11.m()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x00e5
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r1 = r7.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r1.e()
            long r1 = r1.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = r7.e()
            long r3 = r3.m()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x00e5
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r1 = r7.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r1.e()
            long r1 = r1.n()
            long r3 = r11.n()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x00e5
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r7 = r7.f27135c
            goto L_0x00a8
        L_0x00e5:
            if (r12 != 0) goto L_0x00f9
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r7.e()
            long r1 = r1.m()
            long r3 = r11.m()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00f9
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r7 = r7.f27135c
        L_0x00f9:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r1 = r7.a(r12)
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = r1.e()
            boolean r2 = r2.equals(r11)
            if (r2 != 0) goto L_0x010f
            r1.h(r11)
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r7 = r1.a(r12)
            goto L_0x00a4
        L_0x010f:
            com.itextpdf.text.pdf.parser.clipper.Clipper$Direction r2 = com.itextpdf.text.pdf.parser.clipper.Clipper.Direction.LEFT_TO_RIGHT
            if (r10 != r2) goto L_0x0181
        L_0x0113:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r10 = r9.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r10 = r10.e()
            long r2 = r10.m()
            long r4 = r11.m()
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 > 0) goto L_0x0150
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r10 = r9.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r10 = r10.e()
            long r2 = r10.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r10 = r9.e()
            long r4 = r10.m()
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 < 0) goto L_0x0150
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r10 = r9.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r10 = r10.e()
            long r2 = r10.n()
            long r4 = r11.n()
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x0150
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r9 = r9.f27135c
            goto L_0x0113
        L_0x0150:
            if (r12 == 0) goto L_0x0164
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r10 = r9.e()
            long r2 = r10.m()
            long r4 = r11.m()
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0164
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r9 = r9.f27135c
        L_0x0164:
            r10 = r12 ^ 1
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r10 = r9.a(r10)
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = r10.e()
            boolean r2 = r2.equals(r11)
            if (r2 != 0) goto L_0x01e8
            r10.h(r11)
            r9 = r12 ^ 1
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r9 = r10.a(r9)
        L_0x017d:
            r6 = r10
            r10 = r9
            r9 = r6
            goto L_0x01e8
        L_0x0181:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r10 = r9.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r10 = r10.e()
            long r2 = r10.m()
            long r4 = r11.m()
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 < 0) goto L_0x01be
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r10 = r9.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r10 = r10.e()
            long r2 = r10.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r10 = r9.e()
            long r4 = r10.m()
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 > 0) goto L_0x01be
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r10 = r9.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r10 = r10.e()
            long r2 = r10.n()
            long r4 = r11.n()
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x01be
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r9 = r9.f27135c
            goto L_0x0181
        L_0x01be:
            if (r12 != 0) goto L_0x01d2
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r10 = r9.e()
            long r2 = r10.m()
            long r4 = r11.m()
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x01d2
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r9 = r9.f27135c
        L_0x01d2:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r10 = r9.a(r12)
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = r10.e()
            boolean r2 = r2.equals(r11)
            if (r2 != 0) goto L_0x01e8
            r10.h(r11)
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r9 = r10.a(r12)
            goto L_0x017d
        L_0x01e8:
            com.itextpdf.text.pdf.parser.clipper.Clipper$Direction r11 = com.itextpdf.text.pdf.parser.clipper.Clipper.Direction.LEFT_TO_RIGHT
            r2 = 1
            if (r8 != r11) goto L_0x01ee
            r0 = 1
        L_0x01ee:
            if (r0 != r12) goto L_0x01f9
            r7.f27136d = r9
            r9.f27135c = r7
            r1.f27135c = r10
            r10.f27136d = r1
            goto L_0x0201
        L_0x01f9:
            r7.f27135c = r9
            r9.f27136d = r7
            r1.f27136d = r10
            r10.f27135c = r1
        L_0x0201:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.DefaultClipper.e0(com.itextpdf.text.pdf.parser.clipper.Path$OutPt, com.itextpdf.text.pdf.parser.clipper.Path$OutPt, com.itextpdf.text.pdf.parser.clipper.Path$OutPt, com.itextpdf.text.pdf.parser.clipper.Path$OutPt, com.itextpdf.text.pdf.parser.clipper.Point$LongPoint, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:144:0x036b, code lost:
        if (r7 != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a5, code lost:
        if (r2 != false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bc, code lost:
        r2 = r4.a(true);
        r3 = r5.a(false);
        r4.f27135c = r5;
        r5.f27136d = r4;
        r2.f27136d = r3;
        r3.f27135c = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01bf, code lost:
        if (r2.e().m() > r12.e().m()) goto L_0x01c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01fb, code lost:
        if (r13.e().m() > r14.e().m()) goto L_0x01c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0231, code lost:
        if (r12.e().m() > r2.e().m()) goto L_0x01c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x024f, code lost:
        if (r14.e().m() > r13.e().m()) goto L_0x01c3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean f0(com.itextpdf.text.pdf.parser.clipper.Path.Join r26, com.itextpdf.text.pdf.parser.clipper.Path.OutRec r27, com.itextpdf.text.pdf.parser.clipper.Path.OutRec r28) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            r3 = r28
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r4 = r1.f27127a
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r5 = r1.f27128b
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r4.e()
            long r6 = r6.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r8 = r26.a()
            long r8 = r8.n()
            r10 = 1
            r11 = 0
            int r12 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r12 != 0) goto L_0x0024
            r6 = 1
            goto L_0x0025
        L_0x0024:
            r6 = 0
        L_0x0025:
            if (r6 == 0) goto L_0x00cd
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r7 = r26.a()
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r8 = r1.f27127a
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r8 = r8.e()
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x00cd
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r7 = r26.a()
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r8 = r1.f27128b
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r8 = r8.e()
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x00cd
            if (r2 == r3) goto L_0x004a
            return r11
        L_0x004a:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r2 = r1.f27127a
        L_0x004c:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r2 = r2.f27135c
            if (r2 == r4) goto L_0x005f
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = r2.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r26.a()
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x005f
            goto L_0x004c
        L_0x005f:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = r2.e()
            long r2 = r2.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r26.a()
            long r6 = r6.n()
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0075
            r2 = 1
            goto L_0x0076
        L_0x0075:
            r2 = 0
        L_0x0076:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r1.f27128b
        L_0x0078:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r3.f27135c
            if (r3 == r5) goto L_0x008b
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r3.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r7 = r26.a()
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x008b
            goto L_0x0078
        L_0x008b:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = r3.e()
            long r6 = r3.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = r26.a()
            long r8 = r3.n()
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a1
            r3 = 1
            goto L_0x00a2
        L_0x00a1:
            r3 = 0
        L_0x00a2:
            if (r2 != r3) goto L_0x00a5
            return r11
        L_0x00a5:
            if (r2 == 0) goto L_0x00bc
        L_0x00a7:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r2 = r4.a(r11)
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r5.a(r10)
            r4.f27136d = r5
            r5.f27135c = r4
            r2.f27135c = r3
            r3.f27136d = r2
        L_0x00b7:
            r1.f27127a = r4
            r1.f27128b = r2
            return r10
        L_0x00bc:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r2 = r4.a(r10)
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r5.a(r11)
            r4.f27135c = r5
            r5.f27136d = r4
            r2.f27136d = r3
            r3.f27135c = r2
            goto L_0x00b7
        L_0x00cd:
            if (r6 == 0) goto L_0x025e
            r2 = r4
        L_0x00d0:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r2.f27136d
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = r3.e()
            long r6 = r3.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = r2.e()
            long r8 = r3.n()
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x00ee
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r2.f27136d
            if (r3 == r4) goto L_0x00ee
            if (r3 == r5) goto L_0x00ee
            r2 = r3
            goto L_0x00d0
        L_0x00ee:
            r12 = r4
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r12.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = r3.e()
            long r3 = r3.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r12.e()
            long r6 = r6.n()
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x010c
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r4 = r12.f27135c
            if (r4 == r2) goto L_0x010c
            if (r4 == r5) goto L_0x010c
            goto L_0x00ee
        L_0x010c:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r12.f27135c
            if (r3 == r2) goto L_0x025d
            if (r3 != r5) goto L_0x0114
            goto L_0x025d
        L_0x0114:
            r13 = r5
        L_0x0115:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r13.f27136d
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = r3.e()
            long r3 = r3.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r13.e()
            long r6 = r6.n()
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0133
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r13.f27136d
            if (r3 == r5) goto L_0x0133
            if (r3 == r12) goto L_0x0133
            r13 = r3
            goto L_0x0115
        L_0x0133:
            r14 = r5
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r14.f27135c
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = r3.e()
            long r3 = r3.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r5 = r14.e()
            long r5 = r5.n()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0151
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r5 = r14.f27135c
            if (r5 == r13) goto L_0x0151
            if (r5 == r2) goto L_0x0151
            goto L_0x0133
        L_0x0151:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r14.f27135c
            if (r3 == r13) goto L_0x025d
            if (r3 != r2) goto L_0x0159
            goto L_0x025d
        L_0x0159:
            long[] r3 = new long[r10]
            long[] r4 = new long[r10]
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r5 = r2.e()
            long r15 = r5.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r5 = r12.e()
            long r17 = r5.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r5 = r13.e()
            long r19 = r5.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r5 = r14.e()
            long r21 = r5.m()
            r23 = r3
            r24 = r4
            boolean r5 = V(r15, r17, r19, r21, r23, r24)
            if (r5 != 0) goto L_0x0188
            return r11
        L_0x0188:
            r5 = r3[r11]
            r3 = r4[r11]
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r7 = r2.e()
            long r7 = r7.m()
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 < 0) goto L_0x01c8
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r7 = r2.e()
            long r7 = r7.m()
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 > 0) goto L_0x01c8
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = new com.itextpdf.text.pdf.parser.clipper.Point$LongPoint
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r2.e()
            r3.<init>(r4)
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r2.e()
            long r4 = r4.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r12.e()
            long r6 = r6.m()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x01c2
            goto L_0x01c3
        L_0x01c2:
            r10 = 0
        L_0x01c3:
            r15 = r3
            r16 = r10
            goto L_0x0253
        L_0x01c8:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r7 = r13.e()
            long r7 = r7.m()
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 < 0) goto L_0x01fe
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r7 = r13.e()
            long r7 = r7.m()
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 > 0) goto L_0x01fe
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = new com.itextpdf.text.pdf.parser.clipper.Point$LongPoint
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r13.e()
            r3.<init>(r4)
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r13.e()
            long r4 = r4.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r14.e()
            long r6 = r6.m()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x01c2
            goto L_0x01c3
        L_0x01fe:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r7 = r12.e()
            long r7 = r7.m()
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 < 0) goto L_0x0234
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r5 = r12.e()
            long r5 = r5.m()
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 > 0) goto L_0x0234
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = new com.itextpdf.text.pdf.parser.clipper.Point$LongPoint
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r12.e()
            r3.<init>(r4)
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r12.e()
            long r4 = r4.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r2.e()
            long r6 = r6.m()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x01c2
            goto L_0x01c3
        L_0x0234:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = new com.itextpdf.text.pdf.parser.clipper.Point$LongPoint
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r14.e()
            r3.<init>(r4)
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r14.e()
            long r4 = r4.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r13.e()
            long r6 = r6.m()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x01c2
            goto L_0x01c3
        L_0x0253:
            r1.f27127a = r2
            r1.f27128b = r13
            r11 = r2
            boolean r1 = e0(r11, r12, r13, r14, r15, r16)
            return r1
        L_0x025d:
            return r11
        L_0x025e:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r6 = r4.f27135c
        L_0x0260:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r7 = r6.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r8 = r4.e()
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0273
            if (r6 == r4) goto L_0x0273
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r6 = r6.f27135c
            goto L_0x0260
        L_0x0273:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r7 = r6.e()
            long r7 = r7.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r9 = r4.e()
            long r12 = r9.n()
            int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r9 > 0) goto L_0x029e
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r7 = r4.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r8 = r6.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r9 = r26.a()
            boolean r12 = r0.f27073g
            boolean r7 = com.itextpdf.text.pdf.parser.clipper.Point.j(r7, r8, r9, r12)
            if (r7 != 0) goto L_0x029c
            goto L_0x029e
        L_0x029c:
            r7 = 0
            goto L_0x029f
        L_0x029e:
            r7 = 1
        L_0x029f:
            if (r7 == 0) goto L_0x02df
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r6 = r4.f27136d
        L_0x02a3:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r8 = r6.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r9 = r4.e()
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x02b6
            if (r6 == r4) goto L_0x02b6
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r6 = r6.f27136d
            goto L_0x02a3
        L_0x02b6:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r8 = r6.e()
            long r8 = r8.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r12 = r4.e()
            long r12 = r12.n()
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 > 0) goto L_0x02de
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r8 = r4.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r9 = r6.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r12 = r26.a()
            boolean r13 = r0.f27073g
            boolean r8 = com.itextpdf.text.pdf.parser.clipper.Point.j(r8, r9, r12, r13)
            if (r8 != 0) goto L_0x02df
        L_0x02de:
            return r11
        L_0x02df:
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r8 = r5.f27135c
        L_0x02e1:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r9 = r8.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r12 = r5.e()
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x02f4
            if (r8 == r5) goto L_0x02f4
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r8 = r8.f27135c
            goto L_0x02e1
        L_0x02f4:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r9 = r8.e()
            long r12 = r9.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r9 = r5.e()
            long r14 = r9.n()
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 > 0) goto L_0x031f
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r9 = r5.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r12 = r8.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r13 = r26.a()
            boolean r14 = r0.f27073g
            boolean r9 = com.itextpdf.text.pdf.parser.clipper.Point.j(r9, r12, r13, r14)
            if (r9 != 0) goto L_0x031d
            goto L_0x031f
        L_0x031d:
            r9 = 0
            goto L_0x0320
        L_0x031f:
            r9 = 1
        L_0x0320:
            if (r9 == 0) goto L_0x0360
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r8 = r5.f27136d
        L_0x0324:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r12 = r8.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r13 = r5.e()
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x0337
            if (r8 == r5) goto L_0x0337
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r8 = r8.f27136d
            goto L_0x0324
        L_0x0337:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r12 = r8.e()
            long r12 = r12.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r5.e()
            long r14 = r14.n()
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 > 0) goto L_0x035f
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r12 = r5.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r13 = r8.e()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r14 = r26.a()
            boolean r15 = r0.f27073g
            boolean r12 = com.itextpdf.text.pdf.parser.clipper.Point.j(r12, r13, r14, r15)
            if (r12 != 0) goto L_0x0360
        L_0x035f:
            return r11
        L_0x0360:
            if (r6 == r4) goto L_0x036f
            if (r8 == r5) goto L_0x036f
            if (r6 == r8) goto L_0x036f
            if (r2 != r3) goto L_0x036b
            if (r7 != r9) goto L_0x036b
            goto L_0x036f
        L_0x036b:
            if (r7 == 0) goto L_0x00bc
            goto L_0x00a7
        L_0x036f:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.DefaultClipper.f0(com.itextpdf.text.pdf.parser.clipper.Path$Join, com.itextpdf.text.pdf.parser.clipper.Path$OutRec, com.itextpdf.text.pdf.parser.clipper.Path$OutRec):boolean");
    }

    private static Paths g0(Path path, Path path2, boolean z2, boolean z3) {
        Path path3 = path2;
        int size = path.size();
        int size2 = path2.size();
        Paths paths = new Paths(size2);
        int i2 = 0;
        if (z2) {
            while (i2 < size2) {
                Path path4 = new Path(size);
                Iterator it2 = path.iterator();
                while (it2.hasNext()) {
                    Point.LongPoint longPoint = (Point.LongPoint) it2.next();
                    long m2 = ((Point.LongPoint) path3.get(i2)).m() + longPoint.m();
                    long n2 = ((Point.LongPoint) path3.get(i2)).n() + longPoint.n();
                    Point.LongPoint longPoint2 = r9;
                    Point.LongPoint longPoint3 = new Point.LongPoint(m2, n2, 0);
                    path4.add(longPoint2);
                }
                paths.add(path4);
                i2++;
            }
        } else {
            while (i2 < size2) {
                Path path5 = new Path(size);
                Iterator it3 = path.iterator();
                while (it3.hasNext()) {
                    Point.LongPoint longPoint4 = (Point.LongPoint) it3.next();
                    long m3 = ((Point.LongPoint) path3.get(i2)).m() - longPoint4.m();
                    long n3 = ((Point.LongPoint) path3.get(i2)).n() - longPoint4.n();
                    Point.LongPoint longPoint5 = r9;
                    Point.LongPoint longPoint6 = new Point.LongPoint(m3, n3, 0);
                    path5.add(longPoint5);
                }
                paths.add(path5);
                i2++;
            }
        }
        Paths paths2 = new Paths((size2 + (z3 ? 1 : 0)) * (size + 1));
        for (int i3 = 0; i3 < (size2 - 1) + z3; i3++) {
            int i4 = 0;
            while (i4 < size) {
                Path path6 = new Path(4);
                int i5 = i3 % size2;
                int i6 = i4 % size;
                path6.add(((Path) paths.get(i5)).get(i6));
                int i7 = (i3 + 1) % size2;
                path6.add(((Path) paths.get(i7)).get(i6));
                i4++;
                int i8 = i4 % size;
                path6.add(((Path) paths.get(i7)).get(i8));
                path6.add(((Path) paths.get(i5)).get(i8));
                if (!path6.n()) {
                    Collections.reverse(path6);
                }
                paths2.add(path6);
            }
        }
        return paths2;
    }

    public static Paths h0(Path path, Path path2) {
        Paths g0 = g0(path, path2, false, true);
        DefaultClipper defaultClipper = new DefaultClipper();
        defaultClipper.c(g0, Clipper.PolyType.SUBJECT, true);
        Clipper.ClipType clipType = Clipper.ClipType.UNION;
        Clipper.PolyFillType polyFillType = Clipper.PolyFillType.NON_ZERO;
        defaultClipper.b(clipType, g0, polyFillType, polyFillType);
        return g0;
    }

    public static Paths i0(Path path, Path path2, boolean z2) {
        Paths g0 = g0(path, path2, true, z2);
        DefaultClipper defaultClipper = new DefaultClipper();
        defaultClipper.c(g0, Clipper.PolyType.SUBJECT, true);
        Clipper.ClipType clipType = Clipper.ClipType.UNION;
        Clipper.PolyFillType polyFillType = Clipper.PolyFillType.NON_ZERO;
        defaultClipper.b(clipType, g0, polyFillType, polyFillType);
        return g0;
    }

    public static Paths j0(Path path, Paths paths, boolean z2) {
        Paths paths2 = new Paths();
        DefaultClipper defaultClipper = new DefaultClipper();
        for (int i2 = 0; i2 < paths.size(); i2++) {
            defaultClipper.c(g0(path, (Path) paths.get(i2), true, z2), Clipper.PolyType.SUBJECT, true);
            if (z2) {
                defaultClipper.a(((Path) paths.get(i2)).b((Point.LongPoint) path.get(0)), Clipper.PolyType.CLIP, true);
            }
        }
        Clipper.ClipType clipType = Clipper.ClipType.UNION;
        Clipper.PolyFillType polyFillType = Clipper.PolyFillType.NON_ZERO;
        defaultClipper.b(clipType, paths2, polyFillType, polyFillType);
        return paths2;
    }

    private static boolean k0(Path.OutPt outPt, Path.OutPt outPt2) {
        Path.OutPt outPt3 = outPt;
        do {
            int c0 = c0(outPt3.e(), outPt2);
            if (c0 >= 0) {
                return c0 > 0;
            }
            outPt3 = outPt3.f27135c;
        } while (outPt3 != outPt);
        return true;
    }

    private long l0() {
        C.entering(DefaultClipper.class.getName(), "popBeam");
        ClipperBase.Scanbeam scanbeam = this.o;
        long j2 = scanbeam.f27081a;
        this.o = scanbeam.f27082b;
        return j2;
    }

    private void m0(long j2) {
        Path.OutPt z2;
        long j3 = j2;
        Class<DefaultClipper> cls = DefaultClipper.class;
        C.entering(cls.getName(), "processEdgesAtTopOfScanbeam");
        loop0:
        while (true) {
            Edge edge = this.q;
            while (true) {
                if (edge == null) {
                    break loop0;
                }
                double d2 = (double) j3;
                boolean n2 = edge.n(d2);
                if (n2) {
                    Edge f2 = edge.f();
                    n2 = f2 == null || !f2.l();
                }
                if (n2) {
                    if (this.B) {
                        t(edge.h().m());
                    }
                    Edge edge2 = edge.p;
                    J(edge);
                    if (edge2 != null) {
                        edge = edge2.o;
                    }
                } else {
                    if (!edge.m(d2) || !edge.f27120n.l()) {
                        edge.d().f(Long.valueOf(Edge.v(edge, j3)));
                        edge.d().g(Long.valueOf(j2));
                    } else {
                        Edge[] edgeArr = {edge};
                        z0(edgeArr);
                        edge = edgeArr[0];
                        if (edge.f27117k >= 0) {
                            z(edge, edge.c());
                        }
                        u(edge);
                    }
                    if (this.B) {
                        Edge edge3 = edge.p;
                        if (edge.f27117k >= 0 && edge.f27114h != 0 && edge3 != null && edge3.f27117k >= 0 && edge3.d().m() == edge.d().m() && edge3.f27114h != 0) {
                            Point.LongPoint longPoint = new Point.LongPoint(edge.d());
                            s0(longPoint, edge3, edge);
                            w(z(edge3, longPoint), z(edge, longPoint), longPoint);
                        }
                    }
                    edge = edge.o;
                }
            }
        }
        o0();
        this.p = null;
        Edge edge4 = this.q;
        while (edge4 != null) {
            if (edge4.m((double) j3)) {
                Path.OutPt z3 = edge4.f27117k >= 0 ? z(edge4, edge4.h()) : null;
                Edge[] edgeArr2 = {edge4};
                z0(edgeArr2);
                edge4 = edgeArr2[0];
                Edge edge5 = edge4.p;
                Edge edge6 = edge4.o;
                if (edge5 != null && edge5.d().m() == edge4.c().m() && edge5.d().n() == edge4.c().n() && z3 != null && edge5.f27117k >= 0 && edge5.d().n() > edge5.h().n() && Edge.s(edge4, edge5, this.f27073g) && edge4.f27114h != 0 && edge5.f27114h != 0) {
                    z2 = z(edge5, edge4.c());
                } else if (edge6 != null && edge6.d().m() == edge4.c().m() && edge6.d().n() == edge4.c().n() && z3 != null && edge6.f27117k >= 0 && edge6.d().n() > edge6.h().n() && Edge.s(edge4, edge6, this.f27073g) && edge4.f27114h != 0 && edge6.f27114h != 0) {
                    z2 = z(edge6, edge4.c());
                }
                w(z3, z2, edge4.h());
            }
            edge4 = edge4.o;
        }
        C.exiting(cls.getName(), "processEdgesAtTopOfScanbeam");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        if (r1.f27130a >= r7.c().m()) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0099, code lost:
        if (r1.f27130a <= r7.h().m()) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void n0(com.itextpdf.text.pdf.parser.clipper.Edge r27) {
        /*
            r26 = this;
            r9 = r26
            r0 = r27
            java.util.logging.Logger r1 = C
            java.lang.Class<com.itextpdf.text.pdf.parser.clipper.DefaultClipper> r2 = com.itextpdf.text.pdf.parser.clipper.DefaultClipper.class
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = "isHorizontal"
            r1.entering(r2, r3)
            r10 = 1
            com.itextpdf.text.pdf.parser.clipper.Clipper$Direction[] r11 = new com.itextpdf.text.pdf.parser.clipper.Clipper.Direction[r10]
            long[] r12 = new long[r10]
            long[] r13 = new long[r10]
            int r1 = r0.f27117k
            r14 = 0
            if (r1 < 0) goto L_0x002b
            java.util.List<com.itextpdf.text.pdf.parser.clipper.Path$OutRec> r2 = r9.f27099m
            java.lang.Object r1 = r2.get(r1)
            com.itextpdf.text.pdf.parser.clipper.Path$OutRec r1 = (com.itextpdf.text.pdf.parser.clipper.Path.OutRec) r1
            boolean r1 = r1.f27139c
            if (r1 == 0) goto L_0x002b
            r15 = 1
            goto L_0x002c
        L_0x002b:
            r15 = 0
        L_0x002c:
            T(r0, r11, r12, r13)
            r7 = r0
        L_0x0030:
            com.itextpdf.text.pdf.parser.clipper.Edge r1 = r7.f27120n
            if (r1 == 0) goto L_0x003d
            boolean r1 = r1.l()
            if (r1 == 0) goto L_0x003d
            com.itextpdf.text.pdf.parser.clipper.Edge r7 = r7.f27120n
            goto L_0x0030
        L_0x003d:
            com.itextpdf.text.pdf.parser.clipper.Edge r1 = r7.f27120n
            r2 = 0
            if (r1 != 0) goto L_0x0048
            com.itextpdf.text.pdf.parser.clipper.Edge r1 = r7.f()
            r8 = r1
            goto L_0x0049
        L_0x0048:
            r8 = r2
        L_0x0049:
            com.itextpdf.text.pdf.parser.clipper.Path$Maxima r1 = r9.p
            if (r1 == 0) goto L_0x009c
            r3 = r11[r14]
            com.itextpdf.text.pdf.parser.clipper.Clipper$Direction r4 = com.itextpdf.text.pdf.parser.clipper.Clipper.Direction.LEFT_TO_RIGHT
            if (r3 != r4) goto L_0x0078
        L_0x0053:
            if (r1 == 0) goto L_0x0066
            long r3 = r1.f27130a
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r5 = r27.c()
            long r5 = r5.m()
            int r16 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r16 > 0) goto L_0x0066
            com.itextpdf.text.pdf.parser.clipper.Path$Maxima r1 = r1.f27131b
            goto L_0x0053
        L_0x0066:
            if (r1 == 0) goto L_0x009c
            long r3 = r1.f27130a
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r5 = r7.c()
            long r5 = r5.m()
            int r16 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r16 < 0) goto L_0x009c
        L_0x0076:
            r1 = r2
            goto L_0x009c
        L_0x0078:
            com.itextpdf.text.pdf.parser.clipper.Path$Maxima r3 = r1.f27131b
            if (r3 == 0) goto L_0x008d
            long r3 = r3.f27130a
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r5 = r27.c()
            long r5 = r5.m()
            int r16 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r16 >= 0) goto L_0x008d
            com.itextpdf.text.pdf.parser.clipper.Path$Maxima r1 = r1.f27131b
            goto L_0x0078
        L_0x008d:
            long r3 = r1.f27130a
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r5 = r7.h()
            long r5 = r5.m()
            int r16 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r16 > 0) goto L_0x009c
            goto L_0x0076
        L_0x009c:
            r5 = r0
        L_0x009d:
            if (r5 != r7) goto L_0x00a2
            r16 = 1
            goto L_0x00a4
        L_0x00a2:
            r16 = 0
        L_0x00a4:
            r0 = r11[r14]
            com.itextpdf.text.pdf.parser.clipper.Edge r0 = r5.g(r0)
            r6 = r0
        L_0x00ab:
            if (r6 == 0) goto L_0x026a
            if (r1 == 0) goto L_0x0117
            r0 = r11[r14]
            com.itextpdf.text.pdf.parser.clipper.Clipper$Direction r3 = com.itextpdf.text.pdf.parser.clipper.Clipper.Direction.LEFT_TO_RIGHT
            if (r0 != r3) goto L_0x00ea
        L_0x00b5:
            if (r1 == 0) goto L_0x0117
            long r3 = r1.f27130a
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r6.d()
            long r17 = r0.m()
            int r0 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r0 >= 0) goto L_0x0117
            int r0 = r5.f27117k
            if (r0 < 0) goto L_0x00e0
            if (r15 != 0) goto L_0x00e0
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = new com.itextpdf.text.pdf.parser.clipper.Point$LongPoint
            long r3 = r1.f27130a
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r17 = r5.c()
            r19 = r11
            long r10 = r17.n()
            r0.<init>((long) r3, (long) r10)
            r9.z(r5, r0)
            goto L_0x00e2
        L_0x00e0:
            r19 = r11
        L_0x00e2:
            com.itextpdf.text.pdf.parser.clipper.Path$Maxima r1 = r1.f27131b
            r11 = r19
            r10 = 1
            goto L_0x00b5
        L_0x00e8:
            r10 = r1
            goto L_0x011a
        L_0x00ea:
            r19 = r11
        L_0x00ec:
            if (r1 == 0) goto L_0x00e8
            long r3 = r1.f27130a
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r6.d()
            long r10 = r0.m()
            int r0 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x00e8
            int r0 = r5.f27117k
            if (r0 < 0) goto L_0x0114
            if (r15 != 0) goto L_0x0114
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = new com.itextpdf.text.pdf.parser.clipper.Point$LongPoint
            long r3 = r1.f27130a
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r10 = r5.c()
            long r10 = r10.n()
            r0.<init>((long) r3, (long) r10)
            r9.z(r5, r0)
        L_0x0114:
            com.itextpdf.text.pdf.parser.clipper.Path$Maxima r1 = r1.f27132c
            goto L_0x00ec
        L_0x0117:
            r19 = r11
            goto L_0x00e8
        L_0x011a:
            r0 = r19[r14]
            com.itextpdf.text.pdf.parser.clipper.Clipper$Direction r1 = com.itextpdf.text.pdf.parser.clipper.Clipper.Direction.LEFT_TO_RIGHT
            if (r0 != r1) goto L_0x012e
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r6.d()
            long r0 = r0.m()
            r3 = r13[r14]
            int r11 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r11 > 0) goto L_0x0163
        L_0x012e:
            r0 = r19[r14]
            com.itextpdf.text.pdf.parser.clipper.Clipper$Direction r1 = com.itextpdf.text.pdf.parser.clipper.Clipper.Direction.RIGHT_TO_LEFT
            if (r0 != r1) goto L_0x0143
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r6.d()
            long r0 = r0.m()
            r3 = r12[r14]
            int r11 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x0143
            goto L_0x0163
        L_0x0143:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r6.d()
            long r0 = r0.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = r5.h()
            long r3 = r3.m()
            int r11 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r11 != 0) goto L_0x016d
            com.itextpdf.text.pdf.parser.clipper.Edge r0 = r5.f27120n
            if (r0 == 0) goto L_0x016d
            double r3 = r6.f27111e
            double r0 = r0.f27111e
            int r11 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r11 >= 0) goto L_0x016d
        L_0x0163:
            r11 = r5
            r21 = r7
            r1 = r10
            r22 = r15
            r0 = 0
        L_0x016a:
            r15 = r8
            goto L_0x0274
        L_0x016d:
            int r0 = r5.f27117k
            if (r0 < 0) goto L_0x01f5
            if (r15 != 0) goto L_0x01f5
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r6.d()
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r11 = r9.z(r5, r0)
            com.itextpdf.text.pdf.parser.clipper.Edge r0 = r9.r
            r3 = r0
        L_0x017e:
            if (r3 == 0) goto L_0x01e2
            int r0 = r3.f27117k
            if (r0 < 0) goto L_0x01c9
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r5.c()
            long r1 = r0.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r5.h()
            long r20 = r0.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r3.c()
            long r22 = r0.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r3.h()
            long r24 = r0.m()
            r0 = r26
            r14 = r3
            r3 = r20
            r27 = r5
            r20 = r10
            r10 = r6
            r5 = r22
            r21 = r7
            r22 = r15
            r15 = r8
            r7 = r24
            boolean r0 = r0.I(r1, r3, r5, r7)
            if (r0 == 0) goto L_0x01d4
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r0 = r9.s(r14)
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r14.h()
            r9.w(r0, r11, r1)
            goto L_0x01d4
        L_0x01c9:
            r14 = r3
            r27 = r5
            r21 = r7
            r20 = r10
            r22 = r15
            r10 = r6
            r15 = r8
        L_0x01d4:
            com.itextpdf.text.pdf.parser.clipper.Edge r3 = r14.q
            r5 = r27
            r6 = r10
            r8 = r15
            r10 = r20
            r7 = r21
            r15 = r22
            r14 = 0
            goto L_0x017e
        L_0x01e2:
            r27 = r5
            r21 = r7
            r20 = r10
            r22 = r15
            r10 = r6
            r15 = r8
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r27.c()
            r9.v(r11, r0)
            r2 = r11
            goto L_0x01ff
        L_0x01f5:
            r27 = r5
            r21 = r7
            r20 = r10
            r22 = r15
            r10 = r6
            r15 = r8
        L_0x01ff:
            if (r10 != r15) goto L_0x0217
            if (r16 == 0) goto L_0x0217
            r11 = r27
            int r0 = r11.f27117k
            if (r0 < 0) goto L_0x0210
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r11.h()
            r9.x(r11, r15, r0)
        L_0x0210:
            r9.G(r11)
            r9.G(r15)
            return
        L_0x0217:
            r11 = r27
            r0 = 0
            r1 = r19[r0]
            com.itextpdf.text.pdf.parser.clipper.Clipper$Direction r0 = com.itextpdf.text.pdf.parser.clipper.Clipper.Direction.LEFT_TO_RIGHT
            if (r1 != r0) goto L_0x023a
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = new com.itextpdf.text.pdf.parser.clipper.Point$LongPoint
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r10.d()
            long r3 = r1.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r11.d()
            long r5 = r1.n()
            r0.<init>((long) r3, (long) r5)
            r9.Z(r11, r10, r0)
        L_0x0238:
            r0 = 0
            goto L_0x0253
        L_0x023a:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = new com.itextpdf.text.pdf.parser.clipper.Point$LongPoint
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r10.d()
            long r3 = r1.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r11.d()
            long r5 = r1.n()
            r0.<init>((long) r3, (long) r5)
            r9.Z(r10, r11, r0)
            goto L_0x0238
        L_0x0253:
            r1 = r19[r0]
            com.itextpdf.text.pdf.parser.clipper.Edge r6 = r10.g(r1)
            r9.x0(r11, r10)
            r5 = r11
            r8 = r15
            r11 = r19
            r1 = r20
            r7 = r21
            r15 = r22
            r10 = 1
            r14 = 0
            goto L_0x00ab
        L_0x026a:
            r21 = r7
            r19 = r11
            r22 = r15
            r0 = 0
            r11 = r5
            goto L_0x016a
        L_0x0274:
            com.itextpdf.text.pdf.parser.clipper.Edge r3 = r11.f27120n
            if (r3 == 0) goto L_0x02a3
            boolean r3 = r3.l()
            if (r3 != 0) goto L_0x027f
            goto L_0x02a3
        L_0x027f:
            r3 = 1
            com.itextpdf.text.pdf.parser.clipper.Edge[] r4 = new com.itextpdf.text.pdf.parser.clipper.Edge[r3]
            r4[r0] = r11
            r9.z0(r4)
            r5 = r4[r0]
            int r0 = r5.f27117k
            if (r0 < 0) goto L_0x0294
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r5.c()
            r9.z(r5, r0)
        L_0x0294:
            r0 = r19
            T(r5, r0, r12, r13)
            r11 = r0
            r8 = r15
            r7 = r21
            r15 = r22
            r10 = 1
            r14 = 0
            goto L_0x009d
        L_0x02a3:
            int r0 = r11.f27117k
            if (r0 < 0) goto L_0x02f3
            if (r2 != 0) goto L_0x02f3
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r10 = r9.s(r11)
            com.itextpdf.text.pdf.parser.clipper.Edge r0 = r9.r
            r12 = r0
        L_0x02b0:
            if (r12 == 0) goto L_0x02ec
            int r0 = r12.f27117k
            if (r0 < 0) goto L_0x02e9
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r11.c()
            long r1 = r0.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r11.h()
            long r3 = r0.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r12.c()
            long r5 = r0.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r12.h()
            long r7 = r0.m()
            r0 = r26
            boolean r0 = r0.I(r1, r3, r5, r7)
            if (r0 == 0) goto L_0x02e9
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r0 = r9.s(r12)
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r12.h()
            r9.w(r0, r10, r1)
        L_0x02e9:
            com.itextpdf.text.pdf.parser.clipper.Edge r12 = r12.q
            goto L_0x02b0
        L_0x02ec:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r11.h()
            r9.v(r10, r0)
        L_0x02f3:
            com.itextpdf.text.pdf.parser.clipper.Edge r0 = r11.f27120n
            if (r0 == 0) goto L_0x03d6
            int r0 = r11.f27117k
            if (r0 < 0) goto L_0x03cc
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r11.h()
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r0 = r9.z(r11, r0)
            r1 = 1
            com.itextpdf.text.pdf.parser.clipper.Edge[] r1 = new com.itextpdf.text.pdf.parser.clipper.Edge[r1]
            r2 = 0
            r1[r2] = r11
            r9.z0(r1)
            r1 = r1[r2]
            int r2 = r1.f27114h
            if (r2 != 0) goto L_0x0313
            return
        L_0x0313:
            com.itextpdf.text.pdf.parser.clipper.Edge r2 = r1.p
            com.itextpdf.text.pdf.parser.clipper.Edge r3 = r1.o
            if (r2 == 0) goto L_0x0375
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r2.d()
            long r4 = r4.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r1.c()
            long r6 = r6.m()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0375
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r2.d()
            long r4 = r4.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r1.c()
            long r6 = r6.n()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0375
            int r4 = r2.f27114h
            if (r4 == 0) goto L_0x0375
            int r4 = r2.f27117k
            if (r4 < 0) goto L_0x0375
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r2.d()
            long r4 = r4.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r2.h()
            long r6 = r6.n()
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0375
            boolean r4 = r9.f27073g
            boolean r4 = com.itextpdf.text.pdf.parser.clipper.Edge.s(r1, r2, r4)
            if (r4 == 0) goto L_0x0375
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r3 = r1.c()
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r2 = r9.z(r2, r3)
        L_0x036d:
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r1.h()
            r9.w(r0, r2, r1)
            goto L_0x03e4
        L_0x0375:
            if (r3 == 0) goto L_0x03e4
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = r3.d()
            long r4 = r2.m()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = r1.c()
            long r6 = r2.m()
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x03e4
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = r3.d()
            long r4 = r2.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = r1.c()
            long r6 = r2.n()
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x03e4
            int r2 = r3.f27114h
            if (r2 == 0) goto L_0x03e4
            int r2 = r3.f27117k
            if (r2 < 0) goto L_0x03e4
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = r3.d()
            long r4 = r2.n()
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = r3.h()
            long r6 = r2.n()
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x03e4
            boolean r2 = r9.f27073g
            boolean r2 = com.itextpdf.text.pdf.parser.clipper.Edge.s(r1, r3, r2)
            if (r2 == 0) goto L_0x03e4
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r2 = r1.c()
            com.itextpdf.text.pdf.parser.clipper.Path$OutPt r2 = r9.z(r3, r2)
            goto L_0x036d
        L_0x03cc:
            r0 = 1
            com.itextpdf.text.pdf.parser.clipper.Edge[] r0 = new com.itextpdf.text.pdf.parser.clipper.Edge[r0]
            r1 = 0
            r0[r1] = r11
            r9.z0(r0)
            goto L_0x03e4
        L_0x03d6:
            int r0 = r11.f27117k
            if (r0 < 0) goto L_0x03e1
            com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r0 = r11.h()
            r9.z(r11, r0)
        L_0x03e1:
            r9.G(r11)
        L_0x03e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.DefaultClipper.n0(com.itextpdf.text.pdf.parser.clipper.Edge):void");
    }

    private void o0() {
        C.entering(DefaultClipper.class.getName(), "processHorizontals");
        while (true) {
            Edge edge = this.r;
            if (edge != null) {
                H(edge);
                n0(edge);
            } else {
                return;
            }
        }
    }

    private void p0() {
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            IntersectNode intersectNode = this.s.get(i2);
            Z(intersectNode.f27103a, intersectNode.f27104b, intersectNode.a());
            x0(intersectNode.f27103a, intersectNode.f27104b);
        }
        this.s.clear();
    }

    private boolean q0(long j2) {
        C.entering(DefaultClipper.class.getName(), "processIntersections");
        if (this.q == null) {
            return true;
        }
        try {
            B(j2);
            if (this.s.size() == 0) {
                return true;
            }
            if (this.s.size() != 1) {
                if (!Q()) {
                    return false;
                }
            }
            p0();
            this.r = null;
            return true;
        } catch (Exception e2) {
            this.r = null;
            this.s.clear();
            throw new IllegalStateException("ProcessIntersections error", e2);
        }
    }

    private boolean r(IntersectNode intersectNode) {
        Edge edge = intersectNode.f27103a;
        Edge edge2 = edge.q;
        Edge edge3 = intersectNode.f27104b;
        return edge2 == edge3 || edge.r == edge3;
    }

    private void r0(Edge edge, Path.OutRec outRec) {
        boolean z2 = false;
        for (Edge edge2 = edge.p; edge2 != null; edge2 = edge2.p) {
            int i2 = edge2.f27117k;
            if (i2 >= 0 && edge2.f27114h != 0) {
                z2 = !z2;
                if (outRec.f27140d == null) {
                    outRec.f27140d = this.f27099m.get(i2);
                }
            }
        }
        if (z2) {
            outRec.f27138b = true;
        }
    }

    private Path.OutPt s(Edge edge) {
        Path.OutRec outRec = this.f27099m.get(edge.f27117k);
        return edge.f27113g == Edge.Side.LEFT ? outRec.f27141e : outRec.f27141e.f27136d;
    }

    private void s0(Point.LongPoint longPoint, Edge edge, Edge edge2) {
        Point.LongPoint h2;
        if (longPoint.o() == 0 && this.z != null) {
            if (longPoint.equals(edge.c())) {
                h2 = edge.c();
            } else if (longPoint.equals(edge.h())) {
                h2 = edge.h();
            } else if (longPoint.equals(edge2.c())) {
                h2 = edge2.c();
            } else if (longPoint.equals(edge2.h())) {
                h2 = edge2.h();
            } else {
                this.z.a(edge.c(), edge.h(), edge2.c(), edge2.h(), longPoint);
                return;
            }
            longPoint.h(Long.valueOf(h2.o()));
        }
    }

    private void t(long j2) {
        Path.Maxima maxima;
        Path.Maxima maxima2 = new Path.Maxima();
        maxima2.f27130a = j2;
        Path.Maxima maxima3 = this.p;
        if (maxima3 == null) {
            this.p = maxima2;
            maxima2.f27131b = null;
            maxima2.f27132c = null;
        } else if (j2 < maxima3.f27130a) {
            maxima2.f27131b = maxima3;
            maxima2.f27132c = null;
            this.p = maxima2;
        } else {
            while (true) {
                maxima = maxima3.f27131b;
                if (maxima != null && j2 >= maxima.f27130a) {
                    maxima3 = maxima;
                }
            }
            if (j2 != maxima3.f27130a) {
                maxima2.f27131b = maxima;
                maxima2.f27132c = maxima3;
                Path.Maxima maxima4 = maxima3.f27131b;
                if (maxima4 != null) {
                    maxima4.f27132c = maxima2;
                }
                maxima3.f27131b = maxima2;
            }
        }
    }

    public static Paths t0(Path path) {
        return u0(path, Clipper.PolyFillType.EVEN_ODD);
    }

    private void u(Edge edge) {
        C.entering(DefaultClipper.class.getName(), "addEdgeToSEL");
        Edge edge2 = this.r;
        if (edge2 == null) {
            this.r = edge;
            edge.r = null;
            edge.q = null;
            return;
        }
        edge.q = edge2;
        edge.r = null;
        edge2.r = edge;
        this.r = edge;
    }

    public static Paths u0(Path path, Clipper.PolyFillType polyFillType) {
        Paths paths = new Paths();
        DefaultClipper defaultClipper = new DefaultClipper(2);
        defaultClipper.a(path, Clipper.PolyType.SUBJECT, true);
        defaultClipper.b(Clipper.ClipType.UNION, paths, polyFillType, polyFillType);
        return paths;
    }

    private void v(Path.OutPt outPt, Point.LongPoint longPoint) {
        Path.Join join = new Path.Join();
        join.f27127a = outPt;
        join.b(longPoint);
        this.x.add(join);
    }

    public static Paths v0(Paths paths) {
        return w0(paths, Clipper.PolyFillType.EVEN_ODD);
    }

    private void w(Path.OutPt outPt, Path.OutPt outPt2, Point.LongPoint longPoint) {
        C.entering(DefaultClipper.class.getName(), "addJoin");
        Path.Join join = new Path.Join();
        join.f27127a = outPt;
        join.f27128b = outPt2;
        join.b(longPoint);
        this.w.add(join);
    }

    public static Paths w0(Paths paths, Clipper.PolyFillType polyFillType) {
        Paths paths2 = new Paths();
        DefaultClipper defaultClipper = new DefaultClipper(2);
        defaultClipper.c(paths, Clipper.PolyType.SUBJECT, true);
        defaultClipper.b(Clipper.ClipType.UNION, paths2, polyFillType, polyFillType);
        return paths2;
    }

    private void x(Edge edge, Edge edge2, Point.LongPoint longPoint) {
        z(edge, longPoint);
        if (edge2.f27114h == 0) {
            z(edge2, longPoint);
        }
        int i2 = edge.f27117k;
        int i3 = edge2.f27117k;
        if (i2 == i3) {
            edge.f27117k = -1;
            edge2.f27117k = -1;
        } else if (i2 < i3) {
            A(edge, edge2);
        } else {
            A(edge2, edge);
        }
    }

    private void x0(Edge edge, Edge edge2) {
        Edge edge3;
        Logger logger = C;
        Class<DefaultClipper> cls = DefaultClipper.class;
        logger.entering(cls.getName(), "swapPositionsInAEL");
        Edge edge4 = edge.o;
        Edge edge5 = edge.p;
        if (edge4 != edge5 && (edge3 = edge2.o) != edge2.p) {
            if (edge4 == edge2) {
                if (edge3 != null) {
                    edge3.p = edge;
                }
                Edge edge6 = edge.p;
                if (edge6 != null) {
                    edge6.o = edge2;
                }
                edge2.p = edge6;
                edge2.o = edge;
                edge.p = edge2;
                edge.o = edge3;
            } else if (edge3 == edge) {
                if (edge4 != null) {
                    edge4.p = edge2;
                }
                Edge edge7 = edge2.p;
                if (edge7 != null) {
                    edge7.o = edge;
                }
                edge.p = edge7;
                edge.o = edge2;
                edge2.p = edge;
                edge2.o = edge4;
            } else {
                edge.o = edge3;
                if (edge3 != null) {
                    edge3.p = edge;
                }
                Edge edge8 = edge2.p;
                edge.p = edge8;
                if (edge8 != null) {
                    edge8.o = edge;
                }
                edge2.o = edge4;
                if (edge4 != null) {
                    edge4.p = edge2;
                }
                edge2.p = edge5;
                if (edge5 != null) {
                    edge5.o = edge2;
                }
            }
            if (edge.p == null) {
                this.q = edge;
            } else if (edge2.p == null) {
                this.q = edge2;
            }
            logger.exiting(cls.getName(), "swapPositionsInAEL");
        }
    }

    private Path.OutPt y(Edge edge, Edge edge2, Point.LongPoint longPoint) {
        Edge edge3;
        Path.OutPt outPt;
        C.entering(DefaultClipper.class.getName(), "addLocalMinPoly");
        if (edge2.l() || edge.f27111e > edge2.f27111e) {
            outPt = z(edge, longPoint);
            edge2.f27117k = edge.f27117k;
            edge.f27113g = Edge.Side.LEFT;
            edge2.f27113g = Edge.Side.RIGHT;
            edge3 = edge.p;
            if (edge3 == edge2) {
                edge3 = edge2.p;
            }
        } else {
            outPt = z(edge2, longPoint);
            edge.f27117k = edge2.f27117k;
            edge.f27113g = Edge.Side.RIGHT;
            edge2.f27113g = Edge.Side.LEFT;
            edge3 = edge2.p;
            if (edge3 == edge) {
                edge3 = edge.p;
            }
            edge = edge2;
        }
        if (edge3 != null && edge3.f27117k >= 0 && Edge.v(edge3, longPoint.n()) == Edge.v(edge, longPoint.n()) && Edge.s(edge, edge3, this.f27073g) && edge.f27114h != 0 && edge3.f27114h != 0) {
            w(outPt, z(edge3, longPoint), edge.h());
        }
        return outPt;
    }

    private void y0(Edge edge, Edge edge2) {
        Edge edge3 = edge.q;
        if (edge3 != null || edge.r != null) {
            Edge edge4 = edge2.q;
            if (edge4 != null || edge2.r != null) {
                if (edge3 == edge2) {
                    if (edge4 != null) {
                        edge4.r = edge;
                    }
                    Edge edge5 = edge.r;
                    if (edge5 != null) {
                        edge5.q = edge2;
                    }
                    edge2.r = edge5;
                    edge2.q = edge;
                    edge.r = edge2;
                    edge.q = edge4;
                } else if (edge4 == edge) {
                    if (edge3 != null) {
                        edge3.r = edge2;
                    }
                    Edge edge6 = edge2.r;
                    if (edge6 != null) {
                        edge6.q = edge;
                    }
                    edge.r = edge6;
                    edge.q = edge2;
                    edge2.r = edge;
                    edge2.q = edge3;
                } else {
                    Edge edge7 = edge.r;
                    edge.q = edge4;
                    if (edge4 != null) {
                        edge4.r = edge;
                    }
                    Edge edge8 = edge2.r;
                    edge.r = edge8;
                    if (edge8 != null) {
                        edge8.q = edge;
                    }
                    edge2.q = edge3;
                    if (edge3 != null) {
                        edge3.r = edge2;
                    }
                    edge2.r = edge7;
                    if (edge7 != null) {
                        edge7.q = edge2;
                    }
                }
                if (edge.r == null) {
                    this.r = edge;
                } else if (edge2.r == null) {
                    this.r = edge2;
                }
            }
        }
    }

    private Path.OutPt z(Edge edge, Point.LongPoint longPoint) {
        Logger logger = C;
        logger.entering(DefaultClipper.class.getName(), "addOutPt");
        int i2 = edge.f27117k;
        boolean z2 = false;
        if (i2 < 0) {
            Path.OutRec F = F();
            if (edge.f27114h == 0) {
                z2 = true;
            }
            F.f27139c = z2;
            Path.OutPt outPt = new Path.OutPt();
            F.f27141e = outPt;
            outPt.f27133a = F.f27137a;
            outPt.f27134b = longPoint;
            outPt.f27135c = outPt;
            outPt.f27136d = outPt;
            if (!F.f27139c) {
                r0(edge, F);
            }
            edge.f27117k = F.f27137a;
            return outPt;
        }
        Path.OutRec outRec = this.f27099m.get(i2);
        Path.OutPt c2 = outRec.c();
        if (edge.f27113g == Edge.Side.LEFT) {
            z2 = true;
        }
        logger.finest("op=" + c2.d());
        logger.finest(z2 + StringUtils.SPACE + longPoint + StringUtils.SPACE + c2.e());
        if (z2 && longPoint.equals(c2.e())) {
            return c2;
        }
        if (!z2 && longPoint.equals(c2.f27136d.e())) {
            return c2.f27136d;
        }
        Path.OutPt outPt2 = new Path.OutPt();
        outPt2.f27133a = outRec.f27137a;
        outPt2.h(new Point.LongPoint(longPoint));
        outPt2.f27135c = c2;
        Path.OutPt outPt3 = c2.f27136d;
        outPt2.f27136d = outPt3;
        outPt3.f27135c = outPt2;
        c2.f27136d = outPt2;
        if (z2) {
            outRec.d(outPt2);
        }
        return outPt2;
    }

    private void z0(Edge[] edgeArr) {
        Edge edge = edgeArr[0];
        Edge edge2 = edge.f27120n;
        if (edge2 != null) {
            Edge edge3 = edge.p;
            Edge edge4 = edge.o;
            edge2.f27117k = edge.f27117k;
            if (edge3 != null) {
                edge3.o = edge2;
            } else {
                this.q = edge2;
            }
            if (edge4 != null) {
                edge4.p = edge2;
            }
            edge2.f27113g = edge.f27113g;
            edge2.f27114h = edge.f27114h;
            edge2.f27115i = edge.f27115i;
            edge2.f27116j = edge.f27116j;
            edgeArr[0] = edge2;
            edge2.q(edge2.c());
            edge2.p = edge3;
            edge2.o = edge4;
            if (!edge2.l()) {
                Y(edge2.h().n());
                return;
            }
            return;
        }
        throw new IllegalStateException("UpdateEdgeIntoAEL: invalid call");
    }

    public boolean L(Clipper.ClipType clipType, Paths paths, Clipper.PolyFillType polyFillType) {
        return b(clipType, paths, polyFillType, polyFillType);
    }

    public boolean M(Clipper.ClipType clipType, PolyTree polyTree, Clipper.PolyFillType polyFillType) {
        return e(clipType, polyTree, polyFillType, polyFillType);
    }

    public boolean b(Clipper.ClipType clipType, Paths paths, Clipper.PolyFillType polyFillType, Clipper.PolyFillType polyFillType2) {
        boolean N;
        synchronized (this) {
            try {
                if (!this.f27074h) {
                    paths.clear();
                    this.v = polyFillType;
                    this.u = polyFillType2;
                    this.f27100n = clipType;
                    this.y = false;
                    N = N();
                    if (N) {
                        C(paths);
                    }
                    this.f27099m.clear();
                } else {
                    throw new IllegalStateException("Error: PolyTree struct is needed for open path clipping.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return N;
    }

    public boolean d(Clipper.ClipType clipType, Paths paths) {
        return L(clipType, paths, Clipper.PolyFillType.EVEN_ODD);
    }

    public boolean e(Clipper.ClipType clipType, PolyTree polyTree, Clipper.PolyFillType polyFillType, Clipper.PolyFillType polyFillType2) {
        boolean N;
        synchronized (this) {
            try {
                this.v = polyFillType;
                this.u = polyFillType2;
                this.f27100n = clipType;
                this.y = true;
                N = N();
                if (N) {
                    D(polyTree);
                }
                this.f27099m.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        return N;
    }

    public boolean f(Clipper.ClipType clipType, PolyTree polyTree) {
        return M(clipType, polyTree, Clipper.PolyFillType.EVEN_ODD);
    }

    /* access modifiers changed from: protected */
    public void q() {
        super.q();
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        for (ClipperBase.LocalMinima localMinima = this.f27070d; localMinima != null; localMinima = localMinima.f27079d) {
            Y(localMinima.f27076a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultClipper(int i2) {
        super((i2 & 4) != 0);
        boolean z2 = false;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = new ArrayList();
        this.t = new Comparator<IntersectNode>() {
            /* renamed from: a */
            public int compare(IntersectNode intersectNode, IntersectNode intersectNode2) {
                int i2 = ((intersectNode2.a().n() - intersectNode.a().n()) > 0 ? 1 : ((intersectNode2.a().n() - intersectNode.a().n()) == 0 ? 0 : -1));
                if (i2 > 0) {
                    return 1;
                }
                return i2 < 0 ? -1 : 0;
            }
        };
        this.y = false;
        this.f27099m = new ArrayList();
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.A = (i2 & 1) != 0;
        this.B = (i2 & 2) != 0 ? true : z2;
        this.z = null;
    }
}
