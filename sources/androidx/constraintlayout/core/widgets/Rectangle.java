package androidx.constraintlayout.core.widgets;

public class Rectangle {

    /* renamed from: a  reason: collision with root package name */
    public int f4233a;

    /* renamed from: b  reason: collision with root package name */
    public int f4234b;

    /* renamed from: c  reason: collision with root package name */
    public int f4235c;

    /* renamed from: d  reason: collision with root package name */
    public int f4236d;

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r3 = r2.f4234b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r3, int r4) {
        /*
            r2 = this;
            int r0 = r2.f4233a
            if (r3 < r0) goto L_0x0014
            int r1 = r2.f4235c
            int r0 = r0 + r1
            if (r3 >= r0) goto L_0x0014
            int r3 = r2.f4234b
            if (r4 < r3) goto L_0x0014
            int r0 = r2.f4236d
            int r3 = r3 + r0
            if (r4 >= r3) goto L_0x0014
            r3 = 1
            goto L_0x0015
        L_0x0014:
            r3 = 0
        L_0x0015:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Rectangle.a(int, int):boolean");
    }

    public int b() {
        return (this.f4233a + this.f4235c) / 2;
    }

    public int c() {
        return (this.f4234b + this.f4236d) / 2;
    }

    /* access modifiers changed from: package-private */
    public void d(int i2, int i3) {
        this.f4233a -= i2;
        this.f4234b -= i3;
        this.f4235c += i2 * 2;
        this.f4236d += i3 * 2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = r3.f4234b;
        r1 = r4.f4234b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(androidx.constraintlayout.core.widgets.Rectangle r4) {
        /*
            r3 = this;
            int r0 = r3.f4233a
            int r1 = r4.f4233a
            if (r0 < r1) goto L_0x0018
            int r2 = r4.f4235c
            int r1 = r1 + r2
            if (r0 >= r1) goto L_0x0018
            int r0 = r3.f4234b
            int r1 = r4.f4234b
            if (r0 < r1) goto L_0x0018
            int r4 = r4.f4236d
            int r1 = r1 + r4
            if (r0 >= r1) goto L_0x0018
            r4 = 1
            goto L_0x0019
        L_0x0018:
            r4 = 0
        L_0x0019:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Rectangle.e(androidx.constraintlayout.core.widgets.Rectangle):boolean");
    }

    public void f(int i2, int i3, int i4, int i5) {
        this.f4233a = i2;
        this.f4234b = i3;
        this.f4235c = i4;
        this.f4236d = i5;
    }
}
