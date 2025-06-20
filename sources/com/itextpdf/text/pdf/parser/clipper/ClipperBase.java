package com.itextpdf.text.pdf.parser.clipper;

import com.itextpdf.text.pdf.parser.clipper.Clipper;
import com.itextpdf.text.pdf.parser.clipper.Edge;
import com.itextpdf.text.pdf.parser.clipper.Path;
import com.itextpdf.text.pdf.parser.clipper.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class ClipperBase implements Clipper {

    /* renamed from: j  reason: collision with root package name */
    private static final long f27067j = 1073741823;

    /* renamed from: k  reason: collision with root package name */
    private static final long f27068k = 4611686018427387903L;

    /* renamed from: l  reason: collision with root package name */
    private static final Logger f27069l = Logger.getLogger(Clipper.class.getName());

    /* renamed from: d  reason: collision with root package name */
    protected LocalMinima f27070d = null;

    /* renamed from: e  reason: collision with root package name */
    protected LocalMinima f27071e = null;

    /* renamed from: f  reason: collision with root package name */
    private final List<List<Edge>> f27072f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    protected boolean f27073g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f27074h = false;

    /* renamed from: i  reason: collision with root package name */
    protected final boolean f27075i;

    protected class LocalMinima {

        /* renamed from: a  reason: collision with root package name */
        long f27076a;

        /* renamed from: b  reason: collision with root package name */
        Edge f27077b;

        /* renamed from: c  reason: collision with root package name */
        Edge f27078c;

        /* renamed from: d  reason: collision with root package name */
        LocalMinima f27079d;

        protected LocalMinima() {
        }
    }

    protected class Scanbeam {

        /* renamed from: a  reason: collision with root package name */
        long f27081a;

        /* renamed from: b  reason: collision with root package name */
        Scanbeam f27082b;

        protected Scanbeam() {
        }
    }

    protected ClipperBase(boolean z) {
        this.f27075i = z;
    }

    private void g() {
        while (true) {
            LocalMinima localMinima = this.f27070d;
            if (localMinima != null) {
                this.f27070d = localMinima.f27079d;
            } else {
                this.f27071e = null;
                return;
            }
        }
    }

    private static void h(Edge edge, Edge edge2, Edge edge3, Point.LongPoint longPoint) {
        edge.f27118l = edge2;
        edge.f27119m = edge3;
        edge.q(new Point.LongPoint(longPoint));
        edge.f27117k = -1;
    }

    private static void i(Edge edge, Clipper.PolyType polyType) {
        Point.LongPoint longPoint;
        int i2 = (edge.d().n() > edge.f27118l.d().n() ? 1 : (edge.d().n() == edge.f27118l.d().n() ? 0 : -1));
        Point.LongPoint d2 = edge.d();
        if (i2 >= 0) {
            edge.p(longPoint);
            edge.r(new Point.LongPoint(edge.f27118l.d()));
        } else {
            longPoint = new Point.LongPoint(d2);
            edge.r(longPoint);
            edge.p(new Point.LongPoint(edge.f27118l.d()));
        }
        edge.w();
        edge.f27112f = polyType;
    }

    private void j(LocalMinima localMinima) {
        LocalMinima localMinima2;
        LocalMinima localMinima3 = this.f27070d;
        if (localMinima3 != null) {
            if (localMinima.f27076a >= localMinima3.f27076a) {
                localMinima.f27079d = localMinima3;
            } else {
                while (true) {
                    localMinima2 = localMinima3.f27079d;
                    if (localMinima2 == null || localMinima.f27076a >= localMinima2.f27076a) {
                        localMinima.f27079d = localMinima2;
                        localMinima3.f27079d = localMinima;
                    } else {
                        localMinima3 = localMinima2;
                    }
                }
                localMinima.f27079d = localMinima2;
                localMinima3.f27079d = localMinima;
                return;
            }
        }
        this.f27070d = localMinima;
    }

    protected static Path.OutRec l(Path.OutRec outRec) {
        while (outRec != null && outRec.c() == null) {
            outRec = outRec.f27140d;
        }
        return outRec;
    }

    private Edge n(Edge edge, boolean z) {
        Edge edge2;
        Edge edge3;
        if (edge.f27117k == -2) {
            Edge edge4 = edge;
            if (z) {
                while (edge4.h().n() == edge4.f27118l.c().n()) {
                    edge4 = edge4.f27118l;
                }
                while (edge4 != edge && edge4.f27111e == -3.4E38d) {
                    edge4 = edge4.f27119m;
                }
            } else {
                while (edge4.h().n() == edge4.f27119m.c().n()) {
                    edge4 = edge4.f27119m;
                }
                while (edge4 != edge && edge4.f27111e == -3.4E38d) {
                    edge4 = edge4.f27118l;
                }
            }
            if (edge4 == edge) {
                return z ? edge4.f27118l : edge4.f27119m;
            }
            Edge edge5 = z ? edge.f27118l : edge.f27119m;
            LocalMinima localMinima = new LocalMinima();
            localMinima.f27079d = null;
            localMinima.f27076a = edge5.c().n();
            localMinima.f27077b = null;
            localMinima.f27078c = edge5;
            edge5.f27114h = 0;
            Edge n2 = n(edge5, z);
            j(localMinima);
            return n2;
        }
        if (edge.f27111e == -3.4E38d) {
            Edge edge6 = z ? edge.f27119m : edge.f27118l;
            if (edge6.f27111e != -3.4E38d ? edge6.c().m() != edge.c().m() : !(edge6.c().m() == edge.c().m() || edge6.h().m() == edge.c().m())) {
                edge.o();
            }
        }
        if (z) {
            Edge edge7 = edge;
            while (edge7.h().n() == edge7.f27118l.c().n()) {
                Edge edge8 = edge7.f27118l;
                if (edge8.f27117k == -2) {
                    break;
                }
                edge7 = edge8;
            }
            if (edge7.f27111e == -3.4E38d && edge7.f27118l.f27117k != -2) {
                Edge edge9 = edge7;
                while (true) {
                    edge3 = edge9.f27119m;
                    if (edge3.f27111e != -3.4E38d) {
                        break;
                    }
                    edge9 = edge3;
                }
                if (edge3.h().m() > edge7.f27118l.h().m()) {
                    edge7 = edge9.f27119m;
                }
            }
            Edge edge10 = edge;
            while (edge10 != edge7) {
                edge10.f27120n = edge10.f27118l;
                if (!(edge10.f27111e != -3.4E38d || edge10 == edge || edge10.c().m() == edge10.f27119m.h().m())) {
                    edge10.o();
                }
                edge10 = edge10.f27118l;
            }
            if (!(edge10.f27111e != -3.4E38d || edge10 == edge || edge10.c().m() == edge10.f27119m.h().m())) {
                edge10.o();
            }
            return edge7.f27118l;
        }
        Edge edge11 = edge;
        while (edge11.h().n() == edge11.f27119m.c().n()) {
            Edge edge12 = edge11.f27119m;
            if (edge12.f27117k == -2) {
                break;
            }
            edge11 = edge12;
        }
        if (edge11.f27111e == -3.4E38d && edge11.f27119m.f27117k != -2) {
            Edge edge13 = edge11;
            while (true) {
                edge2 = edge13.f27118l;
                if (edge2.f27111e != -3.4E38d) {
                    break;
                }
                edge13 = edge2;
            }
            if (edge2.h().m() == edge11.f27119m.h().m() || edge13.f27118l.h().m() > edge11.f27119m.h().m()) {
                edge11 = edge13.f27118l;
            }
        }
        Edge edge14 = edge;
        while (edge14 != edge11) {
            edge14.f27120n = edge14.f27119m;
            if (!(edge14.f27111e != -3.4E38d || edge14 == edge || edge14.c().m() == edge14.f27118l.h().m())) {
                edge14.o();
            }
            edge14 = edge14.f27119m;
        }
        if (!(edge14.f27111e != -3.4E38d || edge14 == edge || edge14.c().m() == edge14.f27118l.h().m())) {
            edge14.o();
        }
        return edge11.f27119m;
    }

    private static boolean o(Point.LongPoint longPoint, boolean z) {
        long m2 = longPoint.m();
        if (z) {
            if (m2 > 4611686018427387903L || longPoint.n() > 4611686018427387903L || (-longPoint.m()) > 4611686018427387903L || (-longPoint.n()) > 4611686018427387903L) {
                throw new IllegalStateException("Coordinate outside allowed range");
            }
        } else if (m2 > 1073741823 || longPoint.n() > 1073741823 || (-longPoint.m()) > 1073741823 || (-longPoint.n()) > 1073741823) {
            return o(longPoint, true);
        }
        return z;
    }

    private static Edge p(Edge edge) {
        Edge edge2 = edge.f27119m;
        edge2.f27118l = edge.f27118l;
        Edge edge3 = edge.f27118l;
        edge3.f27119m = edge2;
        edge.f27119m = null;
        return edge3;
    }

    public boolean a(Path path, Clipper.PolyType polyType, boolean z) {
        Edge edge;
        boolean z2;
        if (z || polyType != Clipper.PolyType.CLIP) {
            int size = path.size() - 1;
            if (z) {
                while (size > 0 && ((Point.LongPoint) path.get(size)).equals(path.get(0))) {
                    size--;
                }
            }
            while (size > 0 && ((Point.LongPoint) path.get(size)).equals(path.get(size - 1))) {
                size--;
            }
            if ((z && size < 2) || (!z && size < 1)) {
                return false;
            }
            ArrayList arrayList = new ArrayList(size + 1);
            for (int i2 = 0; i2 <= size; i2++) {
                arrayList.add(new Edge());
            }
            ((Edge) arrayList.get(1)).q(new Point.LongPoint((Point.LongPoint) path.get(1)));
            this.f27073g = o((Point.LongPoint) path.get(0), this.f27073g);
            this.f27073g = o((Point.LongPoint) path.get(size), this.f27073g);
            h((Edge) arrayList.get(0), (Edge) arrayList.get(1), (Edge) arrayList.get(size), (Point.LongPoint) path.get(0));
            int i3 = size - 1;
            h((Edge) arrayList.get(size), (Edge) arrayList.get(0), (Edge) arrayList.get(i3), (Point.LongPoint) path.get(size));
            while (i3 >= 1) {
                this.f27073g = o((Point.LongPoint) path.get(i3), this.f27073g);
                h((Edge) arrayList.get(i3), (Edge) arrayList.get(i3 + 1), (Edge) arrayList.get(i3 - 1), (Point.LongPoint) path.get(i3));
                i3--;
            }
            Edge edge2 = (Edge) arrayList.get(0);
            Edge edge3 = edge2;
            Edge edge4 = edge3;
            while (true) {
                if (!edge2.d().equals(edge2.f27118l.d()) || (!z && edge2.f27118l.equals(edge3))) {
                    Edge edge5 = edge2.f27119m;
                    if (edge5 == edge2.f27118l) {
                        break;
                    } else if (!z || !Point.j(edge5.d(), edge2.d(), edge2.f27118l.d(), this.f27073g) || (k() && Point.d(edge2.f27119m.d(), edge2.d(), edge2.f27118l.d()))) {
                        edge2 = edge2.f27118l;
                        if (edge2 != edge4) {
                            if (!z && edge2.f27118l == edge3) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        if (edge2 == edge3) {
                            edge3 = edge2.f27118l;
                        }
                        edge4 = p(edge2).f27119m;
                    }
                } else {
                    Edge edge6 = edge2.f27118l;
                    if (edge2 == edge6) {
                        break;
                    }
                    if (edge2 == edge3) {
                        edge3 = edge6;
                    }
                    edge4 = p(edge2);
                }
                edge2 = edge4;
            }
            if ((!z && edge2 == edge2.f27118l) || (z && edge2.f27119m == edge2.f27118l)) {
                return false;
            }
            if (!z) {
                this.f27074h = true;
                edge3.f27119m.f27117k = -2;
            }
            Edge edge7 = edge3;
            boolean z3 = true;
            do {
                i(edge7, polyType);
                edge7 = edge7.f27118l;
                if (z3 && edge7.d().n() != edge3.d().n()) {
                    z3 = false;
                    continue;
                }
            } while (edge7 != edge3);
            if (!z3) {
                this.f27072f.add(arrayList);
                if (edge7.f27119m.c().equals(edge7.f27119m.h())) {
                    edge7 = edge7.f27118l;
                }
                Edge edge8 = null;
                while (true) {
                    Edge b2 = edge.b();
                    if (b2 == edge8) {
                        return true;
                    }
                    if (edge8 == null) {
                        edge8 = b2;
                    }
                    LocalMinima localMinima = new LocalMinima();
                    localMinima.f27079d = null;
                    localMinima.f27076a = b2.c().n();
                    double d2 = b2.f27111e;
                    Edge edge9 = b2.f27119m;
                    if (d2 < edge9.f27111e) {
                        localMinima.f27077b = edge9;
                        localMinima.f27078c = b2;
                        z2 = false;
                    } else {
                        localMinima.f27077b = b2;
                        localMinima.f27078c = edge9;
                        z2 = true;
                    }
                    Edge edge10 = localMinima.f27077b;
                    edge10.f27113g = Edge.Side.LEFT;
                    Edge edge11 = localMinima.f27078c;
                    edge11.f27113g = Edge.Side.RIGHT;
                    if (!z) {
                        edge10.f27114h = 0;
                    } else if (edge10.f27118l == edge11) {
                        edge10.f27114h = -1;
                    } else {
                        edge10.f27114h = 1;
                    }
                    edge11.f27114h = -edge10.f27114h;
                    edge = n(edge10, z2);
                    if (edge.f27117k == -2) {
                        edge = n(edge, z2);
                    }
                    Edge n2 = n(localMinima.f27078c, !z2);
                    if (n2.f27117k == -2) {
                        n2 = n(n2, !z2);
                    }
                    if (localMinima.f27077b.f27117k == -2) {
                        localMinima.f27077b = null;
                    } else if (localMinima.f27078c.f27117k == -2) {
                        localMinima.f27078c = null;
                    }
                    j(localMinima);
                    if (!z2) {
                        edge = n2;
                    }
                }
            } else if (z) {
                return false;
            } else {
                edge7.f27119m.f27117k = -2;
                LocalMinima localMinima2 = new LocalMinima();
                localMinima2.f27079d = null;
                localMinima2.f27076a = edge7.c().n();
                localMinima2.f27077b = null;
                localMinima2.f27078c = edge7;
                edge7.f27113g = Edge.Side.RIGHT;
                edge7.f27114h = 0;
                while (true) {
                    if (edge7.c().m() != edge7.f27119m.h().m()) {
                        edge7.o();
                    }
                    Edge edge12 = edge7.f27118l;
                    if (edge12.f27117k == -2) {
                        j(localMinima2);
                        this.f27072f.add(arrayList);
                        return true;
                    }
                    edge7.f27120n = edge12;
                    edge7 = edge12;
                }
            }
        } else {
            throw new IllegalStateException("AddPath: Open paths must be subject.");
        }
    }

    public boolean c(Paths paths, Clipper.PolyType polyType, boolean z) {
        boolean z2 = false;
        for (int i2 = 0; i2 < paths.size(); i2++) {
            if (a((Path) paths.get(i2), polyType, z)) {
                z2 = true;
            }
        }
        return z2;
    }

    public void clear() {
        g();
        this.f27072f.clear();
        this.f27073g = false;
        this.f27074h = false;
    }

    public boolean k() {
        return this.f27075i;
    }

    /* access modifiers changed from: protected */
    public void m() {
        f27069l.entering(ClipperBase.class.getName(), "popLocalMinima");
        LocalMinima localMinima = this.f27071e;
        if (localMinima != null) {
            this.f27071e = localMinima.f27079d;
        }
    }

    /* access modifiers changed from: protected */
    public void q() {
        LocalMinima localMinima = this.f27070d;
        this.f27071e = localMinima;
        if (localMinima != null) {
            while (localMinima != null) {
                Edge edge = localMinima.f27077b;
                if (edge != null) {
                    edge.q(new Point.LongPoint(edge.c()));
                    edge.f27113g = Edge.Side.LEFT;
                    edge.f27117k = -1;
                }
                Edge edge2 = localMinima.f27078c;
                if (edge2 != null) {
                    edge2.q(new Point.LongPoint(edge2.c()));
                    edge2.f27113g = Edge.Side.RIGHT;
                    edge2.f27117k = -1;
                }
                localMinima = localMinima.f27079d;
            }
        }
    }
}
