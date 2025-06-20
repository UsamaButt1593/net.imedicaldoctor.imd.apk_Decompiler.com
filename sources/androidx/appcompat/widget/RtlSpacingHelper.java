package androidx.appcompat.widget;

class RtlSpacingHelper {

    /* renamed from: i  reason: collision with root package name */
    public static final int f3239i = Integer.MIN_VALUE;

    /* renamed from: a  reason: collision with root package name */
    private int f3240a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f3241b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f3242c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f3243d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f3244e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f3245f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3246g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3247h = false;

    RtlSpacingHelper() {
    }

    public int a() {
        return this.f3246g ? this.f3240a : this.f3241b;
    }

    public int b() {
        return this.f3240a;
    }

    public int c() {
        return this.f3241b;
    }

    public int d() {
        return this.f3246g ? this.f3241b : this.f3240a;
    }

    public void e(int i2, int i3) {
        this.f3247h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.f3244e = i2;
            this.f3240a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f3245f = i3;
            this.f3241b = i3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r2 != Integer.MIN_VALUE) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        if (r2 != Integer.MIN_VALUE) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.f3246g
            if (r2 != r0) goto L_0x0005
            return
        L_0x0005:
            r1.f3246g = r2
            boolean r0 = r1.f3247h
            if (r0 == 0) goto L_0x002d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == 0) goto L_0x001f
            int r2 = r1.f3243d
            if (r2 == r0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            int r2 = r1.f3244e
        L_0x0016:
            r1.f3240a = r2
            int r2 = r1.f3242c
            if (r2 == r0) goto L_0x0031
        L_0x001c:
            r1.f3241b = r2
            goto L_0x0034
        L_0x001f:
            int r2 = r1.f3242c
            if (r2 == r0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            int r2 = r1.f3244e
        L_0x0026:
            r1.f3240a = r2
            int r2 = r1.f3243d
            if (r2 == r0) goto L_0x0031
            goto L_0x001c
        L_0x002d:
            int r2 = r1.f3244e
            r1.f3240a = r2
        L_0x0031:
            int r2 = r1.f3245f
            goto L_0x001c
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.RtlSpacingHelper.f(boolean):void");
    }

    public void g(int i2, int i3) {
        this.f3242c = i2;
        this.f3243d = i3;
        this.f3247h = true;
        if (this.f3246g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f3240a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f3241b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f3240a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f3241b = i3;
        }
    }
}
