package com.itextpdf.text.pdf.parser.clipper;

import com.itextpdf.text.pdf.parser.clipper.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Path extends ArrayList<Point.LongPoint> {
    private static final long s = -7120161578077546673L;

    static class Join {

        /* renamed from: a  reason: collision with root package name */
        OutPt f27127a;

        /* renamed from: b  reason: collision with root package name */
        OutPt f27128b;

        /* renamed from: c  reason: collision with root package name */
        private Point.LongPoint f27129c;

        Join() {
        }

        public Point.LongPoint a() {
            return this.f27129c;
        }

        public void b(Point.LongPoint longPoint) {
            this.f27129c = longPoint;
        }
    }

    protected static class Maxima {

        /* renamed from: a  reason: collision with root package name */
        protected long f27130a;

        /* renamed from: b  reason: collision with root package name */
        protected Maxima f27131b;

        /* renamed from: c  reason: collision with root package name */
        protected Maxima f27132c;

        protected Maxima() {
        }
    }

    static class OutPt {

        /* renamed from: a  reason: collision with root package name */
        int f27133a;

        /* renamed from: b  reason: collision with root package name */
        protected Point.LongPoint f27134b;

        /* renamed from: c  reason: collision with root package name */
        OutPt f27135c;

        /* renamed from: d  reason: collision with root package name */
        OutPt f27136d;

        OutPt() {
        }

        public static OutRec c(OutRec outRec, OutRec outRec2) {
            if (outRec.f27142f == null) {
                outRec.f27142f = outRec.f27141e.b();
            }
            if (outRec2.f27142f == null) {
                outRec2.f27142f = outRec2.f27141e.b();
            }
            OutPt outPt = outRec.f27142f;
            OutPt outPt2 = outRec2.f27142f;
            if (outPt.e().n() > outPt2.e().n()) {
                return outRec;
            }
            if (outPt.e().n() < outPt2.e().n()) {
                return outRec2;
            }
            if (outPt.e().m() < outPt2.e().m()) {
                return outRec;
            }
            if (outPt.e().m() <= outPt2.e().m() && outPt.f27135c != outPt) {
                return (outPt2.f27135c != outPt2 && !f(outPt, outPt2)) ? outRec2 : outRec;
            }
            return outRec2;
        }

        private static boolean f(OutPt outPt, OutPt outPt2) {
            OutPt outPt3 = outPt.f27136d;
            while (outPt3.e().equals(outPt.e()) && !outPt3.equals(outPt)) {
                outPt3 = outPt3.f27136d;
            }
            double abs = Math.abs(Point.LongPoint.l(outPt.e(), outPt3.e()));
            OutPt outPt4 = outPt.f27135c;
            while (outPt4.e().equals(outPt.e()) && !outPt4.equals(outPt)) {
                outPt4 = outPt4.f27135c;
            }
            double abs2 = Math.abs(Point.LongPoint.l(outPt.e(), outPt4.e()));
            OutPt outPt5 = outPt2.f27136d;
            while (outPt5.e().equals(outPt2.e()) && !outPt5.equals(outPt2)) {
                outPt5 = outPt5.f27136d;
            }
            double abs3 = Math.abs(Point.LongPoint.l(outPt2.e(), outPt5.e()));
            OutPt outPt6 = outPt2.f27135c;
            while (outPt6.e().equals(outPt2.e()) && outPt6.equals(outPt2)) {
                outPt6 = outPt6.f27135c;
            }
            double abs4 = Math.abs(Point.LongPoint.l(outPt2.e(), outPt6.e()));
            return (abs >= abs3 && abs >= abs4) || (abs2 >= abs3 && abs2 >= abs4);
        }

        public OutPt a(boolean z) {
            OutPt outPt = new OutPt();
            outPt.h(new Point.LongPoint(e()));
            outPt.f27133a = this.f27133a;
            if (z) {
                outPt.f27135c = this.f27135c;
                outPt.f27136d = this;
                this.f27135c.f27136d = outPt;
                this.f27135c = outPt;
            } else {
                outPt.f27136d = this.f27136d;
                outPt.f27135c = this;
                this.f27136d.f27135c = outPt;
                this.f27136d = outPt;
            }
            return outPt;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
            if (r3 != null) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
            if (r3 == r0) goto L_0x0086;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x006f, code lost:
            if (f(r0, r3) != false) goto L_0x0072;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0071, code lost:
            r2 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
            r3 = r3.f27135c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
            if (r3.e().equals(r2.e()) != false) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0083, code lost:
            r3 = r3.f27135c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0086, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.itextpdf.text.pdf.parser.clipper.Path.OutPt b() {
            /*
                r9 = this;
                com.itextpdf.text.pdf.parser.clipper.Path$OutPt r0 = r9.f27135c
                r1 = 0
                r2 = r9
                r3 = r1
            L_0x0005:
                if (r0 == r2) goto L_0x0067
                com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r0.e()
                long r4 = r4.n()
                com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r2.e()
                long r6 = r6.n()
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 <= 0) goto L_0x001e
            L_0x001b:
                r2 = r0
                r3 = r1
                goto L_0x0064
            L_0x001e:
                com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r0.e()
                long r4 = r4.n()
                com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r2.e()
                long r6 = r6.n()
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 != 0) goto L_0x0064
                com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r0.e()
                long r4 = r4.m()
                com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r2.e()
                long r6 = r6.m()
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 > 0) goto L_0x0064
                com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r0.e()
                long r4 = r4.m()
                com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r6 = r2.e()
                long r6 = r6.m()
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 >= 0) goto L_0x005b
                goto L_0x001b
            L_0x005b:
                com.itextpdf.text.pdf.parser.clipper.Path$OutPt r4 = r0.f27135c
                if (r4 == r2) goto L_0x0064
                com.itextpdf.text.pdf.parser.clipper.Path$OutPt r4 = r0.f27136d
                if (r4 == r2) goto L_0x0064
                r3 = r0
            L_0x0064:
                com.itextpdf.text.pdf.parser.clipper.Path$OutPt r0 = r0.f27135c
                goto L_0x0005
            L_0x0067:
                if (r3 == 0) goto L_0x0086
            L_0x0069:
                if (r3 == r0) goto L_0x0086
                boolean r1 = f(r0, r3)
                if (r1 != 0) goto L_0x0072
                r2 = r3
            L_0x0072:
                com.itextpdf.text.pdf.parser.clipper.Path$OutPt r1 = r3.f27135c
                r3 = r1
            L_0x0075:
                com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r1 = r3.e()
                com.itextpdf.text.pdf.parser.clipper.Point$LongPoint r4 = r2.e()
                boolean r1 = r1.equals(r4)
                if (r1 != 0) goto L_0x0069
                com.itextpdf.text.pdf.parser.clipper.Path$OutPt r3 = r3.f27135c
                goto L_0x0075
            L_0x0086:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.clipper.Path.OutPt.b():com.itextpdf.text.pdf.parser.clipper.Path$OutPt");
        }

        public int d() {
            int i2 = 0;
            OutPt outPt = this;
            do {
                i2++;
                outPt = outPt.f27135c;
                if (outPt == this) {
                    break;
                }
            } while (outPt != null);
            return i2;
        }

        public Point.LongPoint e() {
            return this.f27134b;
        }

        public void g() {
            OutPt outPt = this;
            while (true) {
                OutPt outPt2 = outPt.f27135c;
                outPt.f27135c = outPt.f27136d;
                outPt.f27136d = outPt2;
                if (outPt2 != this) {
                    outPt = outPt2;
                } else {
                    return;
                }
            }
        }

        public void h(Point.LongPoint longPoint) {
            this.f27134b = longPoint;
        }
    }

    static class OutRec {

        /* renamed from: a  reason: collision with root package name */
        int f27137a;

        /* renamed from: b  reason: collision with root package name */
        boolean f27138b;

        /* renamed from: c  reason: collision with root package name */
        boolean f27139c;

        /* renamed from: d  reason: collision with root package name */
        OutRec f27140d;

        /* renamed from: e  reason: collision with root package name */
        protected OutPt f27141e;

        /* renamed from: f  reason: collision with root package name */
        OutPt f27142f;

        /* renamed from: g  reason: collision with root package name */
        PolyNode f27143g;

        OutRec() {
        }

        public double a() {
            OutPt outPt = this.f27141e;
            double d2 = 0.0d;
            if (outPt == null) {
                return 0.0d;
            }
            do {
                d2 += ((double) (outPt.f27136d.e().m() + outPt.e().m())) * ((double) (outPt.f27136d.e().n() - outPt.e().n()));
                outPt = outPt.f27135c;
            } while (outPt != this.f27141e);
            return d2 * 0.5d;
        }

        public void b() {
            OutRec outRec = this.f27140d;
            if (outRec == null) {
                return;
            }
            if (this.f27138b == outRec.f27138b || outRec.f27141e == null) {
                while (outRec != null && (outRec.f27138b == this.f27138b || outRec.f27141e == null)) {
                    outRec = outRec.f27140d;
                }
                this.f27140d = outRec;
            }
        }

        public OutPt c() {
            return this.f27141e;
        }

        public void d(OutPt outPt) {
            this.f27141e = outPt;
        }
    }

    public Path() {
    }

    private static OutPt h(OutPt outPt) {
        OutPt outPt2 = outPt.f27136d;
        outPt2.f27135c = outPt.f27135c;
        outPt.f27135c.f27136d = outPt2;
        outPt2.f27133a = 0;
        return outPt2;
    }

    public Path b(Point.LongPoint longPoint) {
        Path path = new Path(size());
        for (int i2 = 0; i2 < size(); i2++) {
            path.add(new Point.LongPoint(((Point.LongPoint) get(i2)).m() + longPoint.m(), ((Point.LongPoint) get(i2)).n() + longPoint.n()));
        }
        return path;
    }

    public double c() {
        int size = size();
        if (size < 3) {
            return 0.0d;
        }
        double d2 = 0.0d;
        int i2 = size - 1;
        for (int i3 = 0; i3 < size; i3++) {
            d2 += (((double) ((Point.LongPoint) get(i2)).m()) + ((double) ((Point.LongPoint) get(i3)).m())) * (((double) ((Point.LongPoint) get(i2)).n()) - ((double) ((Point.LongPoint) get(i3)).n()));
            i2 = i3;
        }
        return (-d2) * 0.5d;
    }

    public Path d() {
        return g(1.415d);
    }

    public Path g(double d2) {
        OutPt outPt;
        int size = size();
        if (size == 0) {
            return new Path();
        }
        OutPt[] outPtArr = new OutPt[size];
        for (int i2 = 0; i2 < size; i2++) {
            outPtArr[i2] = new OutPt();
        }
        int i3 = 0;
        while (i3 < size) {
            outPtArr[i3].f27134b = (Point.LongPoint) get(i3);
            OutPt outPt2 = outPtArr[i3];
            i3++;
            OutPt outPt3 = outPtArr[i3 % size];
            outPt2.f27135c = outPt3;
            outPt3.f27136d = outPt2;
            outPt2.f27133a = 0;
        }
        double d3 = d2 * d2;
        OutPt outPt4 = outPtArr[0];
        while (outPt4.f27133a == 0 && outPt4.f27135c != (outPt = outPt4.f27136d)) {
            if (!Point.a(outPt4.f27134b, outPt.f27134b, d3)) {
                if (Point.a(outPt4.f27136d.f27134b, outPt4.f27135c.f27134b, d3)) {
                    h(outPt4.f27135c);
                    outPt4 = h(outPt4);
                    size -= 2;
                } else if (!Point.k(outPt4.f27136d.f27134b, outPt4.f27134b, outPt4.f27135c.f27134b, d3)) {
                    outPt4.f27133a = 1;
                    outPt4 = outPt4.f27135c;
                }
            }
            outPt4 = h(outPt4);
            size--;
        }
        if (size < 3) {
            size = 0;
        }
        Path path = new Path(size);
        for (int i4 = 0; i4 < size; i4++) {
            path.add(outPt4.f27134b);
            outPt4 = outPt4.f27135c;
        }
        return path;
    }

    public int m(Point.LongPoint longPoint) {
        int size = size();
        int i2 = 0;
        if (size < 3) {
            return 0;
        }
        Point.LongPoint longPoint2 = (Point.LongPoint) get(0);
        int i3 = 1;
        int i4 = 0;
        while (i3 <= size) {
            Point.LongPoint longPoint3 = (Point.LongPoint) (i3 == size ? get(i2) : get(i3));
            if (longPoint3.n() == longPoint.n()) {
                if (longPoint3.m() != longPoint.m()) {
                    if (longPoint2.n() == longPoint.n()) {
                        if ((longPoint3.m() > longPoint.m()) == (longPoint2.m() < longPoint.m())) {
                        }
                    }
                }
                return -1;
            }
            if ((longPoint2.n() < longPoint.n()) != (longPoint3.n() < longPoint.n())) {
                if (longPoint2.m() >= longPoint.m()) {
                    if (longPoint3.m() <= longPoint.m()) {
                        int i5 = (((((double) (longPoint2.m() - longPoint.m())) * ((double) (longPoint3.n() - longPoint.n()))) - (((double) (longPoint3.m() - longPoint.m())) * ((double) (longPoint2.n() - longPoint.n())))) > 0.0d ? 1 : (((((double) (longPoint2.m() - longPoint.m())) * ((double) (longPoint3.n() - longPoint.n()))) - (((double) (longPoint3.m() - longPoint.m())) * ((double) (longPoint2.n() - longPoint.n())))) == 0.0d ? 0 : -1));
                        if (i5 == 0) {
                            return -1;
                        }
                        if ((i5 > 0) != (longPoint3.n() > longPoint2.n())) {
                        }
                    }
                } else if (longPoint3.m() <= longPoint.m()) {
                    continue;
                } else {
                    int i6 = (((((double) (longPoint2.m() - longPoint.m())) * ((double) (longPoint3.n() - longPoint.n()))) - (((double) (longPoint3.m() - longPoint.m())) * ((double) (longPoint2.n() - longPoint.n())))) > 0.0d ? 1 : (((((double) (longPoint2.m() - longPoint.m())) * ((double) (longPoint3.n() - longPoint.n()))) - (((double) (longPoint3.m() - longPoint.m())) * ((double) (longPoint2.n() - longPoint.n())))) == 0.0d ? 0 : -1));
                    if (i6 == 0) {
                        return -1;
                    }
                    if ((i6 > 0) != (longPoint3.n() > longPoint2.n())) {
                    }
                }
                i4 = 1 - i4;
            }
            i3++;
            longPoint2 = longPoint3;
            i2 = 0;
        }
        return i4;
    }

    public boolean n() {
        return c() >= 0.0d;
    }

    public void o() {
        Collections.reverse(this);
    }

    public Path(int i2) {
        super(i2);
    }

    public Path(Collection<? extends Point.LongPoint> collection) {
        super(collection);
    }

    public Path(Point.LongPoint[] longPointArr) {
        this();
        for (Point.LongPoint add : longPointArr) {
            add(add);
        }
    }
}
