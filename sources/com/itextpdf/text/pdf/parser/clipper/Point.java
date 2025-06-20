package com.itextpdf.text.pdf.parser.clipper;

import java.lang.Comparable;
import java.lang.Number;
import java.math.BigInteger;
import java.util.Comparator;

public abstract class Point<T extends Number & Comparable<T>> {

    /* renamed from: d  reason: collision with root package name */
    private static final NumberComparator f27145d = new NumberComparator();

    /* renamed from: a  reason: collision with root package name */
    protected T f27146a;

    /* renamed from: b  reason: collision with root package name */
    protected T f27147b;

    /* renamed from: c  reason: collision with root package name */
    protected T f27148c;

    public static class DoublePoint extends Point<Double> {
        public DoublePoint() {
            this(0.0d, 0.0d);
        }

        public double l() {
            return ((Double) this.f27146a).doubleValue();
        }

        public double m() {
            return ((Double) this.f27147b).doubleValue();
        }

        public double n() {
            return ((Double) this.f27148c).doubleValue();
        }

        public DoublePoint(double d2, double d3) {
            this(d2, d3, 0.0d);
        }

        public DoublePoint(double d2, double d3, double d4) {
            super(Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4));
        }

        public DoublePoint(DoublePoint doublePoint) {
            super(doublePoint);
        }
    }

    public static class LongPoint extends Point<Long> {
        public LongPoint() {
            this(0, 0);
        }

        public static double l(LongPoint longPoint, LongPoint longPoint2) {
            if (longPoint.n() == longPoint2.n()) {
                return -3.4E38d;
            }
            return ((double) (longPoint2.m() - longPoint.m())) / ((double) (longPoint2.n() - longPoint.n()));
        }

        public long m() {
            return ((Long) this.f27146a).longValue();
        }

        public long n() {
            return ((Long) this.f27147b).longValue();
        }

        public long o() {
            return ((Long) this.f27148c).longValue();
        }

        public LongPoint(double d2, double d3) {
            this((long) d2, (long) d3);
        }

        public LongPoint(long j2, long j3) {
            this(j2, j3, 0);
        }

        public LongPoint(long j2, long j3, long j4) {
            super(Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        }

        public LongPoint(LongPoint longPoint) {
            super(longPoint);
        }
    }

    private static class NumberComparator<T extends Number & Comparable<T>> implements Comparator<T> {
        private NumberComparator() {
        }

        /* renamed from: a */
        public int compare(T t, T t2) throws ClassCastException {
            return ((Comparable) t).compareTo(t2);
        }
    }

    protected Point(Point<T> point) {
        this(point.f27146a, point.f27147b, point.f27148c);
    }

    static boolean a(Point<? extends Number> point, Point<? extends Number> point2, double d2) {
        double doubleValue = point.f27146a.doubleValue() - point2.f27146a.doubleValue();
        double doubleValue2 = point.f27147b.doubleValue() - point2.f27147b.doubleValue();
        return (doubleValue * doubleValue) + (doubleValue2 * doubleValue2) <= d2;
    }

    static double b(Point<? extends Number> point, Point<? extends Number> point2, Point<? extends Number> point3) {
        double doubleValue = point2.f27147b.doubleValue() - point3.f27147b.doubleValue();
        double doubleValue2 = point3.f27146a.doubleValue() - point2.f27146a.doubleValue();
        double doubleValue3 = ((point.f27146a.doubleValue() * doubleValue) + (point.f27147b.doubleValue() * doubleValue2)) - ((point2.f27146a.doubleValue() * doubleValue) + (point2.f27147b.doubleValue() * doubleValue2));
        return (doubleValue3 * doubleValue3) / ((doubleValue * doubleValue) + (doubleValue2 * doubleValue2));
    }

    static DoublePoint c(LongPoint longPoint, LongPoint longPoint2) {
        double longValue = (double) (((Long) longPoint2.f27146a).longValue() - ((Long) longPoint.f27146a).longValue());
        double longValue2 = (double) (((Long) longPoint2.f27147b).longValue() - ((Long) longPoint.f27147b).longValue());
        if (longValue == 0.0d && longValue2 == 0.0d) {
            return new DoublePoint();
        }
        double sqrt = 1.0d / Math.sqrt((longValue * longValue) + (longValue2 * longValue2));
        return new DoublePoint(longValue2 * sqrt, -(longValue * sqrt));
    }

    protected static boolean d(LongPoint longPoint, LongPoint longPoint2, LongPoint longPoint3) {
        if (longPoint.equals(longPoint3) || longPoint.equals(longPoint2) || longPoint3.equals(longPoint2)) {
            return false;
        }
        if (longPoint.f27146a != longPoint3.f27146a) {
            return ((((Long) longPoint2.f27146a).longValue() > ((Long) longPoint.f27146a).longValue() ? 1 : (((Long) longPoint2.f27146a).longValue() == ((Long) longPoint.f27146a).longValue() ? 0 : -1)) > 0) == ((((Long) longPoint2.f27146a).longValue() > ((Long) longPoint3.f27146a).longValue() ? 1 : (((Long) longPoint2.f27146a).longValue() == ((Long) longPoint3.f27146a).longValue() ? 0 : -1)) < 0);
        }
        return ((((Long) longPoint2.f27147b).longValue() > ((Long) longPoint.f27147b).longValue() ? 1 : (((Long) longPoint2.f27147b).longValue() == ((Long) longPoint.f27147b).longValue() ? 0 : -1)) > 0) == ((((Long) longPoint2.f27147b).longValue() > ((Long) longPoint3.f27147b).longValue() ? 1 : (((Long) longPoint2.f27147b).longValue() == ((Long) longPoint3.f27147b).longValue() ? 0 : -1)) < 0);
    }

    protected static boolean i(LongPoint longPoint, LongPoint longPoint2, LongPoint longPoint3, LongPoint longPoint4, boolean z) {
        long n2 = longPoint.n() - longPoint2.n();
        if (z) {
            return BigInteger.valueOf(n2).multiply(BigInteger.valueOf(longPoint3.m() - longPoint4.m())).equals(BigInteger.valueOf(longPoint.m() - longPoint2.m()).multiply(BigInteger.valueOf(longPoint3.n() - longPoint4.n())));
        }
        return (n2 * (longPoint3.m() - longPoint4.m())) - ((longPoint.m() - longPoint2.m()) * (longPoint3.n() - longPoint4.n())) == 0;
    }

    protected static boolean j(LongPoint longPoint, LongPoint longPoint2, LongPoint longPoint3, boolean z) {
        long n2 = longPoint.n() - longPoint2.n();
        if (z) {
            return BigInteger.valueOf(n2).multiply(BigInteger.valueOf(longPoint2.m() - longPoint3.m())).equals(BigInteger.valueOf(longPoint.m() - longPoint2.m()).multiply(BigInteger.valueOf(longPoint2.n() - longPoint3.n())));
        }
        return (n2 * (longPoint2.m() - longPoint3.m())) - ((longPoint.m() - longPoint2.m()) * (longPoint2.n() - longPoint3.n())) == 0;
    }

    static boolean k(LongPoint longPoint, LongPoint longPoint2, LongPoint longPoint3, double d2) {
        if (Math.abs(((Long) longPoint.f27146a).longValue() - ((Long) longPoint2.f27146a).longValue()) > Math.abs(((Long) longPoint.f27147b).longValue() - ((Long) longPoint2.f27147b).longValue())) {
            if ((((Long) longPoint.f27146a).longValue() > ((Long) longPoint2.f27146a).longValue()) == (((Long) longPoint.f27146a).longValue() < ((Long) longPoint3.f27146a).longValue())) {
                return b(longPoint, longPoint2, longPoint3) < d2;
            }
            return ((((Long) longPoint2.f27146a).longValue() > ((Long) longPoint.f27146a).longValue() ? 1 : (((Long) longPoint2.f27146a).longValue() == ((Long) longPoint.f27146a).longValue() ? 0 : -1)) > 0) == ((((Long) longPoint2.f27146a).longValue() > ((Long) longPoint3.f27146a).longValue() ? 1 : (((Long) longPoint2.f27146a).longValue() == ((Long) longPoint3.f27146a).longValue() ? 0 : -1)) < 0) ? b(longPoint2, longPoint, longPoint3) < d2 : b(longPoint3, longPoint, longPoint2) < d2;
        }
        if ((((Long) longPoint.f27147b).longValue() > ((Long) longPoint2.f27147b).longValue()) == (((Long) longPoint.f27147b).longValue() < ((Long) longPoint3.f27147b).longValue())) {
            return b(longPoint, longPoint2, longPoint3) < d2;
        }
        return ((((Long) longPoint2.f27147b).longValue() > ((Long) longPoint.f27147b).longValue() ? 1 : (((Long) longPoint2.f27147b).longValue() == ((Long) longPoint.f27147b).longValue() ? 0 : -1)) > 0) == ((((Long) longPoint2.f27147b).longValue() > ((Long) longPoint3.f27147b).longValue() ? 1 : (((Long) longPoint2.f27147b).longValue() == ((Long) longPoint3.f27147b).longValue() ? 0 : -1)) < 0) ? b(longPoint2, longPoint, longPoint3) < d2 : b(longPoint3, longPoint, longPoint2) < d2;
    }

    public void e(Point<T> point) {
        this.f27146a = point.f27146a;
        this.f27147b = point.f27147b;
        this.f27148c = point.f27148c;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        NumberComparator numberComparator = f27145d;
        return numberComparator.compare(this.f27146a, point.f27146a) == 0 && numberComparator.compare(this.f27147b, point.f27147b) == 0;
    }

    public void f(T t) {
        this.f27146a = t;
    }

    public void g(T t) {
        this.f27147b = t;
    }

    public void h(T t) {
        this.f27148c = t;
    }

    public String toString() {
        return "Point [x=" + this.f27146a + ", y=" + this.f27147b + ", z=" + this.f27148c + "]";
    }

    protected Point(T t, T t2, T t3) {
        this.f27146a = t;
        this.f27147b = t2;
        this.f27148c = t3;
    }
}
