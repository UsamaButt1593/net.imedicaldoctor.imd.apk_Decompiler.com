package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableContainerCompat extends Drawable implements Drawable.Callback {
    private static final boolean f3 = false;
    private static final String g3 = "DrawableContainerCompat";
    private static final boolean h3 = true;
    private Rect X;
    private int X2 = 255;
    private Drawable Y;
    private boolean Y2;
    private Drawable Z;
    private int Z2 = -1;
    private boolean a3;
    private Runnable b3;
    private long c3;
    private long d3;
    private BlockInvalidateCallback e3;
    private DrawableContainerState s;

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    static class BlockInvalidateCallback implements Drawable.Callback {
        private Drawable.Callback s;

        BlockInvalidateCallback() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.s;
            this.s = null;
            return callback;
        }

        public BlockInvalidateCallback b(Drawable.Callback callback) {
            this.s = callback;
            return this;
        }

        public void invalidateDrawable(@NonNull Drawable drawable) {
        }

        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
            Drawable.Callback callback = this.s;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            Drawable.Callback callback = this.s;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static abstract class DrawableContainerState extends Drawable.ConstantState {
        int A = 0;
        int B = 0;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a  reason: collision with root package name */
        final DrawableContainerCompat f2861a;

        /* renamed from: b  reason: collision with root package name */
        Resources f2862b;

        /* renamed from: c  reason: collision with root package name */
        int f2863c;

        /* renamed from: d  reason: collision with root package name */
        int f2864d;

        /* renamed from: e  reason: collision with root package name */
        int f2865e;

        /* renamed from: f  reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f2866f;

        /* renamed from: g  reason: collision with root package name */
        Drawable[] f2867g;

        /* renamed from: h  reason: collision with root package name */
        int f2868h;

        /* renamed from: i  reason: collision with root package name */
        boolean f2869i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f2870j;

        /* renamed from: k  reason: collision with root package name */
        Rect f2871k;

        /* renamed from: l  reason: collision with root package name */
        boolean f2872l = false;

        /* renamed from: m  reason: collision with root package name */
        boolean f2873m;

        /* renamed from: n  reason: collision with root package name */
        int f2874n;
        int o;
        int p;
        int q;
        boolean r;
        int s;
        boolean t;
        boolean u;
        boolean v;
        boolean w;
        boolean x = true;
        boolean y;
        int z;

        DrawableContainerState(DrawableContainerState drawableContainerState, DrawableContainerCompat drawableContainerCompat, Resources resources) {
            this.f2861a = drawableContainerCompat;
            Rect rect = null;
            this.f2862b = resources != null ? resources : drawableContainerState != null ? drawableContainerState.f2862b : null;
            int g2 = DrawableContainerCompat.g(resources, drawableContainerState != null ? drawableContainerState.f2863c : 0);
            this.f2863c = g2;
            if (drawableContainerState != null) {
                this.f2864d = drawableContainerState.f2864d;
                this.f2865e = drawableContainerState.f2865e;
                this.v = true;
                this.w = true;
                this.f2869i = drawableContainerState.f2869i;
                this.f2872l = drawableContainerState.f2872l;
                this.x = drawableContainerState.x;
                this.y = drawableContainerState.y;
                this.z = drawableContainerState.z;
                this.A = drawableContainerState.A;
                this.B = drawableContainerState.B;
                this.C = drawableContainerState.C;
                this.D = drawableContainerState.D;
                this.E = drawableContainerState.E;
                this.F = drawableContainerState.F;
                this.G = drawableContainerState.G;
                this.H = drawableContainerState.H;
                this.I = drawableContainerState.I;
                if (drawableContainerState.f2863c == g2) {
                    if (drawableContainerState.f2870j) {
                        this.f2871k = drawableContainerState.f2871k != null ? new Rect(drawableContainerState.f2871k) : rect;
                        this.f2870j = true;
                    }
                    if (drawableContainerState.f2873m) {
                        this.f2874n = drawableContainerState.f2874n;
                        this.o = drawableContainerState.o;
                        this.p = drawableContainerState.p;
                        this.q = drawableContainerState.q;
                        this.f2873m = true;
                    }
                }
                if (drawableContainerState.r) {
                    this.s = drawableContainerState.s;
                    this.r = true;
                }
                if (drawableContainerState.t) {
                    this.u = drawableContainerState.u;
                    this.t = true;
                }
                Drawable[] drawableArr = drawableContainerState.f2867g;
                this.f2867g = new Drawable[drawableArr.length];
                this.f2868h = drawableContainerState.f2868h;
                SparseArray<Drawable.ConstantState> sparseArray = drawableContainerState.f2866f;
                this.f2866f = sparseArray != null ? sparseArray.clone() : new SparseArray<>(this.f2868h);
                int i2 = this.f2868h;
                for (int i3 = 0; i3 < i2; i3++) {
                    Drawable drawable = drawableArr[i3];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.f2866f.put(i3, constantState);
                        } else {
                            this.f2867g[i3] = drawableArr[i3];
                        }
                    }
                }
                return;
            }
            this.f2867g = new Drawable[10];
            this.f2868h = 0;
        }

        private void f() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f2866f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f2867g[this.f2866f.keyAt(i2)] = w(this.f2866f.valueAt(i2).newDrawable(this.f2862b));
                }
                this.f2866f = null;
            }
        }

        private Drawable w(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                DrawableCompat.m(drawable, this.z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f2861a);
            return mutate;
        }

        /* access modifiers changed from: package-private */
        public final boolean A(int i2, int i3) {
            int i4 = this.f2868h;
            Drawable[] drawableArr = this.f2867g;
            boolean z2 = false;
            for (int i5 = 0; i5 < i4; i5++) {
                Drawable drawable = drawableArr[i5];
                if (drawable != null) {
                    boolean m2 = Build.VERSION.SDK_INT >= 23 ? DrawableCompat.m(drawable, i2) : false;
                    if (i5 == i3) {
                        z2 = m2;
                    }
                }
            }
            this.z = i2;
            return z2;
        }

        public final void B(boolean z2) {
            this.f2869i = z2;
        }

        /* access modifiers changed from: package-private */
        public final void C(Resources resources) {
            if (resources != null) {
                this.f2862b = resources;
                int g2 = DrawableContainerCompat.g(resources, this.f2863c);
                int i2 = this.f2863c;
                this.f2863c = g2;
                if (i2 != g2) {
                    this.f2873m = false;
                    this.f2870j = false;
                }
            }
        }

        public final int a(Drawable drawable) {
            int i2 = this.f2868h;
            if (i2 >= this.f2867g.length) {
                r(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f2861a);
            this.f2867g[i2] = drawable;
            this.f2868h++;
            this.f2865e = drawable.getChangingConfigurations() | this.f2865e;
            s();
            this.f2871k = null;
            this.f2870j = false;
            this.f2873m = false;
            this.v = false;
            return i2;
        }

        /* access modifiers changed from: package-private */
        @RequiresApi(21)
        public final void b(Resources.Theme theme) {
            if (theme != null) {
                f();
                int i2 = this.f2868h;
                Drawable[] drawableArr = this.f2867g;
                for (int i3 = 0; i3 < i2; i3++) {
                    Drawable drawable = drawableArr[i3];
                    if (drawable != null && DrawableCompat.b(drawable)) {
                        DrawableCompat.a(drawableArr[i3], theme);
                        this.f2865e |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                C(Api21Impl.c(theme));
            }
        }

        public boolean c() {
            if (this.v) {
                return this.w;
            }
            f();
            this.v = true;
            int i2 = this.f2868h;
            Drawable[] drawableArr = this.f2867g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.w = false;
                    return false;
                }
            }
            this.w = true;
            return true;
        }

        @RequiresApi(21)
        public boolean canApplyTheme() {
            int i2 = this.f2868h;
            Drawable[] drawableArr = this.f2867g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f2866f.get(i3);
                    if (constantState != null && Api21Impl.a(constantState)) {
                        return true;
                    }
                } else if (DrawableCompat.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            this.y = false;
        }

        /* access modifiers changed from: protected */
        public void e() {
            this.f2873m = true;
            f();
            int i2 = this.f2868h;
            Drawable[] drawableArr = this.f2867g;
            this.o = -1;
            this.f2874n = -1;
            this.q = 0;
            this.p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f2874n) {
                    this.f2874n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final int g() {
            return this.f2867g.length;
        }

        public int getChangingConfigurations() {
            return this.f2864d | this.f2865e;
        }

        public final Drawable h(int i2) {
            int indexOfKey;
            Drawable drawable = this.f2867g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f2866f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable w2 = w(this.f2866f.valueAt(indexOfKey).newDrawable(this.f2862b));
            this.f2867g[i2] = w2;
            this.f2866f.removeAt(indexOfKey);
            if (this.f2866f.size() == 0) {
                this.f2866f = null;
            }
            return w2;
        }

        public final int i() {
            return this.f2868h;
        }

        public final int j() {
            if (!this.f2873m) {
                e();
            }
            return this.o;
        }

        public final int k() {
            if (!this.f2873m) {
                e();
            }
            return this.q;
        }

        public final int l() {
            if (!this.f2873m) {
                e();
            }
            return this.p;
        }

        public final Rect m() {
            Rect rect = null;
            if (this.f2869i) {
                return null;
            }
            Rect rect2 = this.f2871k;
            if (rect2 != null || this.f2870j) {
                return rect2;
            }
            f();
            Rect rect3 = new Rect();
            int i2 = this.f2868h;
            Drawable[] drawableArr = this.f2867g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i4 = rect3.left;
                    if (i4 > rect.left) {
                        rect.left = i4;
                    }
                    int i5 = rect3.top;
                    if (i5 > rect.top) {
                        rect.top = i5;
                    }
                    int i6 = rect3.right;
                    if (i6 > rect.right) {
                        rect.right = i6;
                    }
                    int i7 = rect3.bottom;
                    if (i7 > rect.bottom) {
                        rect.bottom = i7;
                    }
                }
            }
            this.f2870j = true;
            this.f2871k = rect;
            return rect;
        }

        public final int n() {
            if (!this.f2873m) {
                e();
            }
            return this.f2874n;
        }

        public final int o() {
            return this.A;
        }

        public final int p() {
            return this.B;
        }

        public final int q() {
            if (this.r) {
                return this.s;
            }
            f();
            int i2 = this.f2868h;
            Drawable[] drawableArr = this.f2867g;
            int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i3 = 1; i3 < i2; i3++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
            }
            this.s = opacity;
            this.r = true;
            return opacity;
        }

        public void r(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            Drawable[] drawableArr2 = this.f2867g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i2);
            }
            this.f2867g = drawableArr;
        }

        /* access modifiers changed from: package-private */
        public void s() {
            this.r = false;
            this.t = false;
        }

        public final boolean t() {
            return this.f2872l;
        }

        public final boolean u() {
            if (this.t) {
                return this.u;
            }
            f();
            int i2 = this.f2868h;
            Drawable[] drawableArr = this.f2867g;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                } else if (drawableArr[i3].isStateful()) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            this.u = z2;
            this.t = true;
            return z2;
        }

        /* access modifiers changed from: package-private */
        public void v() {
            int i2 = this.f2868h;
            Drawable[] drawableArr = this.f2867g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable != null) {
                    drawable.mutate();
                }
            }
            this.y = true;
        }

        public final void x(boolean z2) {
            this.f2872l = z2;
        }

        public final void y(int i2) {
            this.A = i2;
        }

        public final void z(int i2) {
            this.B = i2;
        }
    }

    private void e(Drawable drawable) {
        if (this.e3 == null) {
            this.e3 = new BlockInvalidateCallback();
        }
        drawable.setCallback(this.e3.b(drawable.getCallback()));
        try {
            if (this.s.A <= 0 && this.Y2) {
                drawable.setAlpha(this.X2);
            }
            DrawableContainerState drawableContainerState = this.s;
            if (drawableContainerState.E) {
                drawable.setColorFilter(drawableContainerState.D);
            } else {
                if (drawableContainerState.H) {
                    DrawableCompat.o(drawable, drawableContainerState.F);
                }
                DrawableContainerState drawableContainerState2 = this.s;
                if (drawableContainerState2.I) {
                    DrawableCompat.p(drawable, drawableContainerState2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.s.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                DrawableCompat.m(drawable, DrawableCompat.f(this));
            }
            DrawableCompat.j(drawable, this.s.C);
            Rect rect = this.X;
            if (rect != null) {
                DrawableCompat.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            drawable.setCallback(this.e3.a());
        } catch (Throwable th) {
            drawable.setCallback(this.e3.a());
            throw th;
        }
    }

    private boolean f() {
        return isAutoMirrored() && DrawableCompat.f(this) == 1;
    }

    static int g(@Nullable Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.Y2 = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.Y
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L_0x001f
            long r9 = r13.c3
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x0038
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0022
            int r9 = r13.X2
            r3.setAlpha(r9)
        L_0x001f:
            r13.c3 = r6
            goto L_0x0038
        L_0x0022:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r9 = r13.s
            int r9 = r9.A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.X2
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L_0x0039
        L_0x0038:
            r3 = 0
        L_0x0039:
            android.graphics.drawable.Drawable r9 = r13.Z
            if (r9 == 0) goto L_0x004d
            long r10 = r13.d3
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x0063
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0050
            r9.setVisible(r8, r8)
            r0 = 0
            r13.Z = r0
        L_0x004d:
            r13.d3 = r6
            goto L_0x0063
        L_0x0050:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r4 = r13.s
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.X2
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L_0x0064
        L_0x0063:
            r0 = r3
        L_0x0064:
            if (r14 == 0) goto L_0x0070
            if (r0 == 0) goto L_0x0070
            java.lang.Runnable r14 = r13.b3
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.a(boolean):void");
    }

    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        this.s.b(theme);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.s.d();
        this.a3 = false;
    }

    /* access modifiers changed from: package-private */
    public DrawableContainerState c() {
        return this.s;
    }

    @RequiresApi(21)
    public boolean canApplyTheme() {
        return this.s.canApplyTheme();
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.Z2;
    }

    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.Y;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.Z;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public int getAlpha() {
        return this.X2;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.s.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.s.c()) {
            return null;
        }
        this.s.f2864d = getChangingConfigurations();
        return this.s;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.Y;
    }

    public void getHotspotBounds(@NonNull Rect rect) {
        Rect rect2 = this.X;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.s.t()) {
            return this.s.j();
        }
        Drawable drawable = this.Y;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.s.t()) {
            return this.s.n();
        }
        Drawable drawable = this.Y;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.s.t()) {
            return this.s.k();
        }
        Drawable drawable = this.Y;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.s.t()) {
            return this.s.l();
        }
        Drawable drawable = this.Y;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.Y;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.s.q();
    }

    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable = this.Y;
        if (drawable != null) {
            Api21Impl.b(drawable, outline);
        }
    }

    public boolean getPadding(@NonNull Rect rect) {
        boolean z;
        Rect m2 = this.s.m();
        if (m2 != null) {
            rect.set(m2);
            z = (m2.right | ((m2.left | m2.top) | m2.bottom)) != 0;
        } else {
            Drawable drawable = this.Y;
            z = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (f()) {
            int i2 = rect.left;
            rect.left = rect.right;
            rect.right = i2;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h(int r10) {
        /*
            r9 = this;
            int r0 = r9.Z2
            r1 = 0
            if (r10 != r0) goto L_0x0006
            return r1
        L_0x0006:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.s
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r9.Z
            if (r0 == 0) goto L_0x001a
            r0.setVisible(r1, r1)
        L_0x001a:
            android.graphics.drawable.Drawable r0 = r9.Y
            if (r0 == 0) goto L_0x0029
            r9.Z = r0
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.s
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.d3 = r0
            goto L_0x0035
        L_0x0029:
            r9.Z = r4
            r9.d3 = r5
            goto L_0x0035
        L_0x002e:
            android.graphics.drawable.Drawable r0 = r9.Y
            if (r0 == 0) goto L_0x0035
            r0.setVisible(r1, r1)
        L_0x0035:
            if (r10 < 0) goto L_0x0055
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.s
            int r1 = r0.f2868h
            if (r10 >= r1) goto L_0x0055
            android.graphics.drawable.Drawable r0 = r0.h(r10)
            r9.Y = r0
            r9.Z2 = r10
            if (r0 == 0) goto L_0x005a
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r10 = r9.s
            int r10 = r10.A
            if (r10 <= 0) goto L_0x0051
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.c3 = r2
        L_0x0051:
            r9.e(r0)
            goto L_0x005a
        L_0x0055:
            r9.Y = r4
            r10 = -1
            r9.Z2 = r10
        L_0x005a:
            long r0 = r9.c3
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0067
            long r0 = r9.d3
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0079
        L_0x0067:
            java.lang.Runnable r0 = r9.b3
            if (r0 != 0) goto L_0x0073
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$1 r0 = new androidx.appcompat.graphics.drawable.DrawableContainerCompat$1
            r0.<init>()
            r9.b3 = r0
            goto L_0x0076
        L_0x0073:
            r9.unscheduleSelf(r0)
        L_0x0076:
            r9.a(r10)
        L_0x0079:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.h(int):boolean");
    }

    /* access modifiers changed from: package-private */
    public void i(DrawableContainerState drawableContainerState) {
        this.s = drawableContainerState;
        int i2 = this.Z2;
        if (i2 >= 0) {
            Drawable h2 = drawableContainerState.h(i2);
            this.Y = h2;
            if (h2 != null) {
                e(h2);
            }
        }
        this.Z = null;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        DrawableContainerState drawableContainerState = this.s;
        if (drawableContainerState != null) {
            drawableContainerState.s();
        }
        if (drawable == this.Y && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.s.C;
    }

    public boolean isStateful() {
        return this.s.u();
    }

    /* access modifiers changed from: package-private */
    public void j(int i2) {
        h(i2);
    }

    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.Z;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.Z = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.Y;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.Y2) {
                this.Y.setAlpha(this.X2);
            }
        }
        if (this.d3 != 0) {
            this.d3 = 0;
            z = true;
        }
        if (this.c3 != 0) {
            this.c3 = 0;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    public void k(int i2) {
        this.s.A = i2;
    }

    public void l(int i2) {
        this.s.B = i2;
    }

    /* access modifiers changed from: package-private */
    public final void m(Resources resources) {
        this.s.C(resources);
    }

    public Drawable mutate() {
        if (!this.a3 && super.mutate() == this) {
            DrawableContainerState c2 = c();
            c2.v();
            i(c2);
            this.a3 = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.Z;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.Y;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        return this.s.A(i2, d());
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.Z;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.Y;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(@NonNull int[] iArr) {
        Drawable drawable = this.Z;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.Y;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        if (drawable == this.Y && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (!this.Y2 || this.X2 != i2) {
            this.Y2 = true;
            this.X2 = i2;
            Drawable drawable = this.Y;
            if (drawable == null) {
                return;
            }
            if (this.c3 == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z) {
        DrawableContainerState drawableContainerState = this.s;
        if (drawableContainerState.C != z) {
            drawableContainerState.C = z;
            Drawable drawable = this.Y;
            if (drawable != null) {
                DrawableCompat.j(drawable, z);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        DrawableContainerState drawableContainerState = this.s;
        drawableContainerState.E = true;
        if (drawableContainerState.D != colorFilter) {
            drawableContainerState.D = colorFilter;
            Drawable drawable = this.Y;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z) {
        DrawableContainerState drawableContainerState = this.s;
        if (drawableContainerState.x != z) {
            drawableContainerState.x = z;
            Drawable drawable = this.Y;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    public void setHotspot(float f2, float f4) {
        Drawable drawable = this.Y;
        if (drawable != null) {
            DrawableCompat.k(drawable, f2, f4);
        }
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.X;
        if (rect == null) {
            this.X = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.Y;
        if (drawable != null) {
            DrawableCompat.l(drawable, i2, i3, i4, i5);
        }
    }

    public void setTint(@ColorInt int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableContainerState drawableContainerState = this.s;
        drawableContainerState.H = true;
        if (drawableContainerState.F != colorStateList) {
            drawableContainerState.F = colorStateList;
            DrawableCompat.o(this.Y, colorStateList);
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        DrawableContainerState drawableContainerState = this.s;
        drawableContainerState.I = true;
        if (drawableContainerState.G != mode) {
            drawableContainerState.G = mode;
            DrawableCompat.p(this.Y, mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.Z;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.Y;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        if (drawable == this.Y && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
