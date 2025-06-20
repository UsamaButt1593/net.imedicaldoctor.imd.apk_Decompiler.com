package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    private static final String q3 = "MaterialShapeDrawable";
    private static final float r3 = 0.75f;
    private static final float s3 = 0.25f;
    public static final int t3 = 0;
    public static final int u3 = 1;
    public static final int v3 = 2;
    private static final Paint w3;
    /* access modifiers changed from: private */
    public final ShapePath.ShadowCompatOperation[] X;
    /* access modifiers changed from: private */
    public boolean X2;
    /* access modifiers changed from: private */
    public final ShapePath.ShadowCompatOperation[] Y;
    private final Matrix Y2;
    /* access modifiers changed from: private */
    public final BitSet Z;
    private final Path Z2;
    private final Path a3;
    private final RectF b3;
    private final RectF c3;
    private final Region d3;
    private final Region e3;
    private ShapeAppearanceModel f3;
    private final Paint g3;
    private final Paint h3;
    private final ShadowRenderer i3;
    @NonNull
    private final ShapeAppearancePathProvider.PathListener j3;
    private final ShapeAppearancePathProvider k3;
    @Nullable
    private PorterDuffColorFilter l3;
    @Nullable
    private PorterDuffColorFilter m3;
    private int n3;
    @NonNull
    private final RectF o3;
    private boolean p3;
    private MaterialShapeDrawableState s;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected static class MaterialShapeDrawableState extends Drawable.ConstantState {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        ShapeAppearanceModel f21806a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        ElevationOverlayProvider f21807b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        ColorFilter f21808c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        ColorStateList f21809d = null;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        ColorStateList f21810e = null;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        ColorStateList f21811f = null;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f21812g = null;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        PorterDuff.Mode f21813h = PorterDuff.Mode.SRC_IN;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        Rect f21814i = null;

        /* renamed from: j  reason: collision with root package name */
        float f21815j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        float f21816k = 1.0f;

        /* renamed from: l  reason: collision with root package name */
        float f21817l;

        /* renamed from: m  reason: collision with root package name */
        int f21818m = 255;

        /* renamed from: n  reason: collision with root package name */
        float f21819n = 0.0f;
        float o = 0.0f;
        float p = 0.0f;
        int q = 0;
        int r = 0;
        int s = 0;
        int t = 0;
        boolean u = false;
        Paint.Style v = Paint.Style.FILL_AND_STROKE;

        public MaterialShapeDrawableState(@NonNull MaterialShapeDrawableState materialShapeDrawableState) {
            this.f21806a = materialShapeDrawableState.f21806a;
            this.f21807b = materialShapeDrawableState.f21807b;
            this.f21817l = materialShapeDrawableState.f21817l;
            this.f21808c = materialShapeDrawableState.f21808c;
            this.f21809d = materialShapeDrawableState.f21809d;
            this.f21810e = materialShapeDrawableState.f21810e;
            this.f21813h = materialShapeDrawableState.f21813h;
            this.f21812g = materialShapeDrawableState.f21812g;
            this.f21818m = materialShapeDrawableState.f21818m;
            this.f21815j = materialShapeDrawableState.f21815j;
            this.s = materialShapeDrawableState.s;
            this.q = materialShapeDrawableState.q;
            this.u = materialShapeDrawableState.u;
            this.f21816k = materialShapeDrawableState.f21816k;
            this.f21819n = materialShapeDrawableState.f21819n;
            this.o = materialShapeDrawableState.o;
            this.p = materialShapeDrawableState.p;
            this.r = materialShapeDrawableState.r;
            this.t = materialShapeDrawableState.t;
            this.f21811f = materialShapeDrawableState.f21811f;
            this.v = materialShapeDrawableState.v;
            if (materialShapeDrawableState.f21814i != null) {
                this.f21814i = new Rect(materialShapeDrawableState.f21814i);
            }
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            boolean unused = materialShapeDrawable.X2 = true;
            return materialShapeDrawable;
        }

        public MaterialShapeDrawableState(@NonNull ShapeAppearanceModel shapeAppearanceModel, @Nullable ElevationOverlayProvider elevationOverlayProvider) {
            this.f21806a = shapeAppearanceModel;
            this.f21807b = elevationOverlayProvider;
        }
    }

    static {
        Paint paint = new Paint(1);
        w3 = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    private boolean N0(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.s.f21809d == null || (color2 = this.g3.getColor()) == (colorForState2 = this.s.f21809d.getColorForState(iArr, color2))) {
            z = false;
        } else {
            this.g3.setColor(colorForState2);
            z = true;
        }
        if (this.s.f21810e == null || (color = this.h3.getColor()) == (colorForState = this.s.f21810e.getColorForState(iArr, color))) {
            return z;
        }
        this.h3.setColor(colorForState);
        return true;
    }

    private boolean O0() {
        PorterDuffColorFilter porterDuffColorFilter = this.l3;
        PorterDuffColorFilter porterDuffColorFilter2 = this.m3;
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        this.l3 = k(materialShapeDrawableState.f21812g, materialShapeDrawableState.f21813h, this.g3, true);
        MaterialShapeDrawableState materialShapeDrawableState2 = this.s;
        this.m3 = k(materialShapeDrawableState2.f21811f, materialShapeDrawableState2.f21813h, this.h3, false);
        MaterialShapeDrawableState materialShapeDrawableState3 = this.s;
        if (materialShapeDrawableState3.u) {
            this.i3.e(materialShapeDrawableState3.f21812g.getColorForState(getState(), 0));
        }
        return !ObjectsCompat.a(porterDuffColorFilter, this.l3) || !ObjectsCompat.a(porterDuffColorFilter2, this.m3);
    }

    private float P() {
        if (Z()) {
            return this.h3.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private void P0() {
        float W = W();
        this.s.r = (int) Math.ceil((double) (0.75f * W));
        this.s.s = (int) Math.ceil((double) (W * s3));
        O0();
        b0();
    }

    private boolean X() {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        int i2 = materialShapeDrawableState.q;
        return i2 != 1 && materialShapeDrawableState.r > 0 && (i2 == 2 || k0());
    }

    private boolean Y() {
        Paint.Style style = this.s.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean Z() {
        Paint.Style style = this.s.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.h3.getStrokeWidth() > 0.0f;
    }

    private void b0() {
        super.invalidateSelf();
    }

    @Nullable
    private PorterDuffColorFilter f(@NonNull Paint paint, boolean z) {
        if (!z) {
            return null;
        }
        int color = paint.getColor();
        int l2 = l(color);
        this.n3 = l2;
        if (l2 != color) {
            return new PorterDuffColorFilter(l2, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void g(@NonNull RectF rectF, @NonNull Path path) {
        h(rectF, path);
        if (this.s.f21815j != 1.0f) {
            this.Y2.reset();
            Matrix matrix = this.Y2;
            float f2 = this.s.f21815j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.Y2);
        }
        path.computeBounds(this.o3, true);
    }

    private void h0(@NonNull Canvas canvas) {
        if (X()) {
            canvas.save();
            j0(canvas);
            if (!this.p3) {
                p(canvas);
            } else {
                int width = (int) (this.o3.width() - ((float) getBounds().width()));
                int height = (int) (this.o3.height() - ((float) getBounds().height()));
                if (width < 0 || height < 0) {
                    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                }
                Bitmap createBitmap = Bitmap.createBitmap(((int) this.o3.width()) + (this.s.r * 2) + width, ((int) this.o3.height()) + (this.s.r * 2) + height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f2 = (float) ((getBounds().left - this.s.r) - width);
                float f4 = (float) ((getBounds().top - this.s.r) - height);
                canvas2.translate(-f2, -f4);
                p(canvas2);
                canvas.drawBitmap(createBitmap, f2, f4, (Paint) null);
                createBitmap.recycle();
            }
            canvas.restore();
        }
    }

    private void i() {
        final float f2 = -P();
        ShapeAppearanceModel y = getShapeAppearanceModel().y(new ShapeAppearanceModel.CornerSizeUnaryOperator() {
            @NonNull
            public CornerSize a(@NonNull CornerSize cornerSize) {
                return cornerSize instanceof RelativeCornerSize ? cornerSize : new AdjustedCornerSize(f2, cornerSize);
            }
        });
        this.f3 = y;
        this.k3.d(y, this.s.f21816k, x(), this.a3);
    }

    private static int i0(int i2, int i4) {
        return (i2 * (i4 + (i4 >>> 7))) >>> 8;
    }

    @NonNull
    private PorterDuffColorFilter j(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = l(colorForState);
        }
        this.n3 = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private void j0(@NonNull Canvas canvas) {
        canvas.translate((float) J(), (float) K());
    }

    @NonNull
    private PorterDuffColorFilter k(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z) {
        return (colorStateList == null || mode == null) ? f(paint, z) : j(colorStateList, mode, z);
    }

    @NonNull
    public static MaterialShapeDrawable m(Context context) {
        return n(context, 0.0f);
    }

    @NonNull
    public static MaterialShapeDrawable n(@NonNull Context context, float f2) {
        return o(context, f2, (ColorStateList) null);
    }

    @NonNull
    public static MaterialShapeDrawable o(@NonNull Context context, float f2, @Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(MaterialColors.c(context, R.attr.e4, MaterialShapeDrawable.class.getSimpleName()));
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.a0(context);
        materialShapeDrawable.p0(colorStateList);
        materialShapeDrawable.o0(f2);
        return materialShapeDrawable;
    }

    private void p(@NonNull Canvas canvas) {
        if (this.Z.cardinality() > 0) {
            Log.w(q3, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.s.s != 0) {
            canvas.drawPath(this.Z2, this.i3.d());
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.X[i2].b(this.i3, this.s.r, canvas);
            this.Y[i2].b(this.i3, this.s.r, canvas);
        }
        if (this.p3) {
            int J = J();
            int K = K();
            canvas.translate((float) (-J), (float) (-K));
            canvas.drawPath(this.Z2, w3);
            canvas.translate((float) J, (float) K);
        }
    }

    private void q(@NonNull Canvas canvas) {
        s(canvas, this.g3, this.Z2, this.s.f21806a, w());
    }

    private void s(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull ShapeAppearanceModel shapeAppearanceModel, @NonNull RectF rectF) {
        if (shapeAppearanceModel.u(rectF)) {
            float a2 = shapeAppearanceModel.t().a(rectF) * this.s.f21816k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    @NonNull
    private RectF x() {
        this.c3.set(w());
        float P = P();
        this.c3.inset(P, P);
        return this.c3;
    }

    public float A() {
        return this.s.f21816k;
    }

    @Deprecated
    public void A0(boolean z) {
        y0(z ^ true ? 1 : 0);
    }

    public Paint.Style B() {
        return this.s.v;
    }

    @Deprecated
    public void B0(int i2) {
        this.s.r = i2;
    }

    public float C() {
        return this.s.f21819n;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void C0(int i2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.s != i2) {
            materialShapeDrawableState.s = i2;
            b0();
        }
    }

    @Deprecated
    public void D(int i2, int i4, @NonNull Path path) {
        h(new RectF(0.0f, 0.0f, (float) i2, (float) i4), path);
    }

    @Deprecated
    public void D0(@NonNull ShapePathModel shapePathModel) {
        setShapeAppearanceModel(shapePathModel);
    }

    @ColorInt
    public int E() {
        return this.n3;
    }

    public void E0(float f2, @ColorInt int i2) {
        J0(f2);
        G0(ColorStateList.valueOf(i2));
    }

    public float F() {
        return this.s.f21815j;
    }

    public void F0(float f2, @Nullable ColorStateList colorStateList) {
        J0(f2);
        G0(colorStateList);
    }

    public int G() {
        return this.s.t;
    }

    public void G0(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.f21810e != colorStateList) {
            materialShapeDrawableState.f21810e = colorStateList;
            onStateChange(getState());
        }
    }

    public int H() {
        return this.s.q;
    }

    public void H0(@ColorInt int i2) {
        I0(ColorStateList.valueOf(i2));
    }

    @Deprecated
    public int I() {
        return (int) y();
    }

    public void I0(ColorStateList colorStateList) {
        this.s.f21811f = colorStateList;
        O0();
        b0();
    }

    public int J() {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        return (int) (((double) materialShapeDrawableState.s) * Math.sin(Math.toRadians((double) materialShapeDrawableState.t)));
    }

    public void J0(float f2) {
        this.s.f21817l = f2;
        invalidateSelf();
    }

    public int K() {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        return (int) (((double) materialShapeDrawableState.s) * Math.cos(Math.toRadians((double) materialShapeDrawableState.t)));
    }

    public void K0(float f2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.p != f2) {
            materialShapeDrawableState.p = f2;
            P0();
        }
    }

    public int L() {
        return this.s.r;
    }

    public void L0(boolean z) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.u != z) {
            materialShapeDrawableState.u = z;
            invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int M() {
        return this.s.s;
    }

    public void M0(float f2) {
        K0(f2 - y());
    }

    @Deprecated
    @Nullable
    public ShapePathModel N() {
        ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof ShapePathModel) {
            return (ShapePathModel) shapeAppearanceModel;
        }
        return null;
    }

    @Nullable
    public ColorStateList O() {
        return this.s.f21810e;
    }

    @Nullable
    public ColorStateList Q() {
        return this.s.f21811f;
    }

    public float R() {
        return this.s.f21817l;
    }

    @Nullable
    public ColorStateList S() {
        return this.s.f21812g;
    }

    public float T() {
        return this.s.f21806a.r().a(w());
    }

    public float U() {
        return this.s.f21806a.t().a(w());
    }

    public float V() {
        return this.s.p;
    }

    public float W() {
        return y() + V();
    }

    public void a0(Context context) {
        this.s.f21807b = new ElevationOverlayProvider(context);
        P0();
    }

    public boolean c0() {
        ElevationOverlayProvider elevationOverlayProvider = this.s.f21807b;
        return elevationOverlayProvider != null && elevationOverlayProvider.l();
    }

    public boolean d0() {
        return this.s.f21807b != null;
    }

    public void draw(@NonNull Canvas canvas) {
        this.g3.setColorFilter(this.l3);
        int alpha = this.g3.getAlpha();
        this.g3.setAlpha(i0(alpha, this.s.f21818m));
        this.h3.setColorFilter(this.m3);
        this.h3.setStrokeWidth(this.s.f21817l);
        int alpha2 = this.h3.getAlpha();
        this.h3.setAlpha(i0(alpha2, this.s.f21818m));
        if (this.X2) {
            i();
            g(w(), this.Z2);
            this.X2 = false;
        }
        h0(canvas);
        if (Y()) {
            q(canvas);
        }
        if (Z()) {
            t(canvas);
        }
        this.g3.setAlpha(alpha);
        this.h3.setAlpha(alpha2);
    }

    public boolean e0(int i2, int i4) {
        return getTransparentRegion().contains(i2, i4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean f0() {
        return this.s.f21806a.u(w());
    }

    @Deprecated
    public boolean g0() {
        int i2 = this.s.q;
        return i2 == 0 || i2 == 2;
    }

    public int getAlpha() {
        return this.s.f21818m;
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.s;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.s.q != 2) {
            if (f0()) {
                outline.setRoundRect(getBounds(), T() * this.s.f21816k);
                return;
            }
            g(w(), this.Z2);
            DrawableUtils.l(outline, this.Z2);
        }
    }

    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.s.f21814i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.s.f21806a;
    }

    public Region getTransparentRegion() {
        this.d3.set(getBounds());
        g(w(), this.Z2);
        this.e3.setPath(this.Z2, this.d3);
        this.d3.op(this.e3, Region.Op.DIFFERENCE);
        return this.d3;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void h(@NonNull RectF rectF, @NonNull Path path) {
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.k3;
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        ShapeAppearanceModel shapeAppearanceModel = materialShapeDrawableState.f21806a;
        float f2 = materialShapeDrawableState.f21816k;
        shapeAppearancePathProvider.e(shapeAppearanceModel, f2, rectF, this.j3, path);
    }

    public void invalidateSelf() {
        this.X2 = true;
        super.invalidateSelf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r0 = r1.s.f21810e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r0 = r1.s.f21809d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.s.f21812g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r1.s.f21811f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0039
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r0 = r1.s
            android.content.res.ColorStateList r0 = r0.f21812g
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x0012:
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r0 = r1.s
            android.content.res.ColorStateList r0 = r0.f21811f
            if (r0 == 0) goto L_0x001e
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x001e:
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r0 = r1.s
            android.content.res.ColorStateList r0 = r0.f21810e
            if (r0 == 0) goto L_0x002a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x002a:
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r0 = r1.s
            android.content.res.ColorStateList r0 = r0.f21809d
            if (r0 == 0) goto L_0x0037
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r0 = 0
            goto L_0x003a
        L_0x0039:
            r0 = 1
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.shape.MaterialShapeDrawable.isStateful():boolean");
    }

    public boolean k0() {
        return !f0() && !this.Z2.isConvex() && Build.VERSION.SDK_INT < 29;
    }

    /* access modifiers changed from: protected */
    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int l(@ColorInt int i2) {
        float W = W() + C();
        ElevationOverlayProvider elevationOverlayProvider = this.s.f21807b;
        return elevationOverlayProvider != null ? elevationOverlayProvider.e(i2, W) : i2;
    }

    public void l0(float f2) {
        setShapeAppearanceModel(this.s.f21806a.w(f2));
    }

    public void m0(@NonNull CornerSize cornerSize) {
        setShapeAppearanceModel(this.s.f21806a.x(cornerSize));
    }

    @NonNull
    public Drawable mutate() {
        this.s = new MaterialShapeDrawableState(this.s);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void n0(boolean z) {
        this.k3.n(z);
    }

    public void o0(float f2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.o != f2) {
            materialShapeDrawableState.o = f2;
            P0();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.X2 = true;
        super.onBoundsChange(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z = N0(iArr) || O0();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public void p0(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.f21809d != colorStateList) {
            materialShapeDrawableState.f21809d = colorStateList;
            onStateChange(getState());
        }
    }

    public void q0(float f2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.f21816k != f2) {
            materialShapeDrawableState.f21816k = f2;
            this.X2 = true;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void r(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        s(canvas, paint, path, this.s.f21806a, rectF);
    }

    public void r0(int i2, int i4, int i5, int i6) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.f21814i == null) {
            materialShapeDrawableState.f21814i = new Rect();
        }
        this.s.f21814i.set(i2, i4, i5, i6);
        invalidateSelf();
    }

    public void s0(Paint.Style style) {
        this.s.v = style;
        b0();
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.f21818m != i2) {
            materialShapeDrawableState.f21818m = i2;
            b0();
        }
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.s.f21808c = colorFilter;
        b0();
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.s.f21806a = shapeAppearanceModel;
        invalidateSelf();
    }

    public void setTint(@ColorInt int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.s.f21812g = colorStateList;
        O0();
        b0();
    }

    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.f21813h != mode) {
            materialShapeDrawableState.f21813h = mode;
            O0();
            b0();
        }
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void t(@NonNull Canvas canvas) {
        s(canvas, this.h3, this.a3, this.f3, x());
    }

    public void t0(float f2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.f21819n != f2) {
            materialShapeDrawableState.f21819n = f2;
            P0();
        }
    }

    public float u() {
        return this.s.f21806a.j().a(w());
    }

    public void u0(float f2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.f21815j != f2) {
            materialShapeDrawableState.f21815j = f2;
            invalidateSelf();
        }
    }

    public float v() {
        return this.s.f21806a.l().a(w());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void v0(boolean z) {
        this.p3 = z;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public RectF w() {
        this.b3.set(getBounds());
        return this.b3;
    }

    public void w0(int i2) {
        this.i3.e(i2);
        this.s.u = false;
        b0();
    }

    public void x0(int i2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.t != i2) {
            materialShapeDrawableState.t = i2;
            b0();
        }
    }

    public float y() {
        return this.s.o;
    }

    public void y0(int i2) {
        MaterialShapeDrawableState materialShapeDrawableState = this.s;
        if (materialShapeDrawableState.q != i2) {
            materialShapeDrawableState.q = i2;
            b0();
        }
    }

    @Nullable
    public ColorStateList z() {
        return this.s.f21809d;
    }

    @Deprecated
    public void z0(int i2) {
        o0((float) i2);
    }

    public MaterialShapeDrawable(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i4) {
        this(ShapeAppearanceModel.e(context, attributeSet, i2, i4).m());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected MaterialShapeDrawable(@NonNull MaterialShapeDrawableState materialShapeDrawableState) {
        this.X = new ShapePath.ShadowCompatOperation[4];
        this.Y = new ShapePath.ShadowCompatOperation[4];
        this.Z = new BitSet(8);
        this.Y2 = new Matrix();
        this.Z2 = new Path();
        this.a3 = new Path();
        this.b3 = new RectF();
        this.c3 = new RectF();
        this.d3 = new Region();
        this.e3 = new Region();
        Paint paint = new Paint(1);
        this.g3 = paint;
        Paint paint2 = new Paint(1);
        this.h3 = paint2;
        this.i3 = new ShadowRenderer();
        this.k3 = Looper.getMainLooper().getThread() == Thread.currentThread() ? ShapeAppearancePathProvider.k() : new ShapeAppearancePathProvider();
        this.o3 = new RectF();
        this.p3 = true;
        this.s = materialShapeDrawableState;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        O0();
        N0(getState());
        this.j3 = new ShapeAppearancePathProvider.PathListener() {
            public void a(@NonNull ShapePath shapePath, Matrix matrix, int i2) {
                MaterialShapeDrawable.this.Z.set(i2, shapePath.e());
                MaterialShapeDrawable.this.X[i2] = shapePath.f(matrix);
            }

            public void b(@NonNull ShapePath shapePath, Matrix matrix, int i2) {
                MaterialShapeDrawable.this.Z.set(i2 + 4, shapePath.e());
                MaterialShapeDrawable.this.Y[i2] = shapePath.f(matrix);
            }
        };
    }

    public MaterialShapeDrawable(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this(new MaterialShapeDrawableState(shapeAppearanceModel, (ElevationOverlayProvider) null));
    }

    @Deprecated
    public MaterialShapeDrawable(@NonNull ShapePathModel shapePathModel) {
        this((ShapeAppearanceModel) shapePathModel);
    }
}
