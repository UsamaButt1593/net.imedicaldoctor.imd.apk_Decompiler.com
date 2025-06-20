package androidx.appcompat.app;

class TwilightCalculator {

    /* renamed from: d  reason: collision with root package name */
    private static TwilightCalculator f2813d = null;

    /* renamed from: e  reason: collision with root package name */
    public static final int f2814e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f2815f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final float f2816g = 0.017453292f;

    /* renamed from: h  reason: collision with root package name */
    private static final float f2817h = 9.0E-4f;

    /* renamed from: i  reason: collision with root package name */
    private static final float f2818i = -0.10471976f;

    /* renamed from: j  reason: collision with root package name */
    private static final float f2819j = 0.0334196f;

    /* renamed from: k  reason: collision with root package name */
    private static final float f2820k = 3.49066E-4f;

    /* renamed from: l  reason: collision with root package name */
    private static final float f2821l = 5.236E-6f;

    /* renamed from: m  reason: collision with root package name */
    private static final float f2822m = 0.4092797f;

    /* renamed from: n  reason: collision with root package name */
    private static final long f2823n = 946728000000L;

    /* renamed from: a  reason: collision with root package name */
    public long f2824a;

    /* renamed from: b  reason: collision with root package name */
    public long f2825b;

    /* renamed from: c  reason: collision with root package name */
    public int f2826c;

    TwilightCalculator() {
    }

    static TwilightCalculator b() {
        if (f2813d == null) {
            f2813d = new TwilightCalculator();
        }
        return f2813d;
    }

    public void a(long j2, double d2, double d3) {
        float f2 = ((float) (j2 - f2823n)) / 8.64E7f;
        float f3 = (0.01720197f * f2) + 6.24006f;
        double d4 = (double) f3;
        double sin = (Math.sin(d4) * 0.03341960161924362d) + d4 + (Math.sin((double) (2.0f * f3)) * 3.4906598739326E-4d) + (Math.sin((double) (f3 * 3.0f)) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d5 = (-d3) / 360.0d;
        double round = ((double) (((float) Math.round(((double) (f2 - f2817h)) - d5)) + f2817h)) + d5 + (Math.sin(d4) * 0.0053d) + (Math.sin(2.0d * sin) * -0.0069d);
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d6 = 0.01745329238474369d * d2;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d6) * Math.sin(asin))) / (Math.cos(d6) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f2826c = 1;
        } else if (sin2 <= -1.0d) {
            this.f2826c = 0;
        } else {
            double acos = (double) ((float) (Math.acos(sin2) / 6.283185307179586d));
            this.f2824a = Math.round((round + acos) * 8.64E7d) + f2823n;
            long round2 = Math.round((round - acos) * 8.64E7d) + f2823n;
            this.f2825b = round2;
            if (round2 >= j2 || this.f2824a <= j2) {
                this.f2826c = 1;
                return;
            } else {
                this.f2826c = 0;
                return;
            }
        }
        this.f2824a = -1;
        this.f2825b = -1;
    }
}
