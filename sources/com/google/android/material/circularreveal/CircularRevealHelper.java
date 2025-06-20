package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularRevealHelper {

    /* renamed from: k  reason: collision with root package name */
    private static final boolean f20991k = false;

    /* renamed from: l  reason: collision with root package name */
    public static final int f20992l = 0;

    /* renamed from: m  reason: collision with root package name */
    public static final int f20993m = 1;

    /* renamed from: n  reason: collision with root package name */
    public static final int f20994n = 2;
    public static final int o = 2;

    /* renamed from: a  reason: collision with root package name */
    private final Delegate f20995a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final View f20996b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Path f20997c = new Path();
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Paint f20998d = new Paint(7);
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final Paint f20999e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private CircularRevealWidget.RevealInfo f21000f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Drawable f21001g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f21002h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f21003i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f21004j;

    public interface Delegate {
        void c(Canvas canvas);

        boolean d();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    public CircularRevealHelper(Delegate delegate) {
        this.f20995a = delegate;
        View view = (View) delegate;
        this.f20996b = view;
        view.setWillNotDraw(false);
        Paint paint = new Paint(1);
        this.f20999e = paint;
        paint.setColor(0);
    }

    private void d(@NonNull Canvas canvas, int i2, float f2) {
        this.f21002h.setColor(i2);
        this.f21002h.setStrokeWidth(f2);
        CircularRevealWidget.RevealInfo revealInfo = this.f21000f;
        canvas.drawCircle(revealInfo.f21010a, revealInfo.f21011b, revealInfo.f21012c - (f2 / 2.0f), this.f21002h);
    }

    private void e(@NonNull Canvas canvas) {
        this.f20995a.c(canvas);
        if (r()) {
            CircularRevealWidget.RevealInfo revealInfo = this.f21000f;
            canvas.drawCircle(revealInfo.f21010a, revealInfo.f21011b, revealInfo.f21012c, this.f20999e);
        }
        if (p()) {
            d(canvas, ViewCompat.y, 10.0f);
            d(canvas, SupportMenu.f5941c, 5.0f);
        }
        f(canvas);
    }

    private void f(@NonNull Canvas canvas) {
        if (q()) {
            Rect bounds = this.f21001g.getBounds();
            float width = this.f21000f.f21010a - (((float) bounds.width()) / 2.0f);
            float height = this.f21000f.f21011b - (((float) bounds.height()) / 2.0f);
            canvas.translate(width, height);
            this.f21001g.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float i(@NonNull CircularRevealWidget.RevealInfo revealInfo) {
        return MathUtils.b(revealInfo.f21010a, revealInfo.f21011b, 0.0f, 0.0f, (float) this.f20996b.getWidth(), (float) this.f20996b.getHeight());
    }

    private void k() {
        if (o == 1) {
            this.f20997c.rewind();
            CircularRevealWidget.RevealInfo revealInfo = this.f21000f;
            if (revealInfo != null) {
                this.f20997c.addCircle(revealInfo.f21010a, revealInfo.f21011b, revealInfo.f21012c, Path.Direction.CW);
            }
        }
        this.f20996b.invalidate();
    }

    private boolean p() {
        CircularRevealWidget.RevealInfo revealInfo = this.f21000f;
        boolean z = revealInfo == null || revealInfo.a();
        if (o == 0) {
            return !z && this.f21004j;
        }
        return !z;
    }

    private boolean q() {
        return (this.f21003i || this.f21001g == null || this.f21000f == null) ? false : true;
    }

    private boolean r() {
        return !this.f21003i && Color.alpha(this.f20999e.getColor()) != 0;
    }

    public void a() {
        if (o == 0) {
            this.f21003i = true;
            this.f21004j = false;
            this.f20996b.buildDrawingCache();
            Bitmap drawingCache = this.f20996b.getDrawingCache();
            if (!(drawingCache != null || this.f20996b.getWidth() == 0 || this.f20996b.getHeight() == 0)) {
                drawingCache = Bitmap.createBitmap(this.f20996b.getWidth(), this.f20996b.getHeight(), Bitmap.Config.ARGB_8888);
                this.f20996b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f20998d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f21003i = false;
            this.f21004j = true;
        }
    }

    public void b() {
        if (o == 0) {
            this.f21004j = false;
            this.f20996b.destroyDrawingCache();
            this.f20998d.setShader((Shader) null);
            this.f20996b.invalidate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a2, code lost:
        if (r() != false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r() != false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(@androidx.annotation.NonNull android.graphics.Canvas r9) {
        /*
            r8 = this;
            boolean r0 = r8.p()
            if (r0 == 0) goto L_0x0099
            int r0 = o
            if (r0 == 0) goto L_0x0078
            r1 = 1
            if (r0 == r1) goto L_0x004a
            r1 = 2
            if (r0 != r1) goto L_0x0033
            com.google.android.material.circularreveal.CircularRevealHelper$Delegate r0 = r8.f20995a
            r0.c(r9)
            boolean r0 = r8.r()
            if (r0 == 0) goto L_0x00a6
        L_0x001b:
            android.view.View r0 = r8.f20996b
            int r0 = r0.getWidth()
            float r4 = (float) r0
            android.view.View r0 = r8.f20996b
            int r0 = r0.getHeight()
            float r5 = (float) r0
            android.graphics.Paint r6 = r8.f20999e
            r2 = 0
            r3 = 0
            r1 = r9
            r1.drawRect(r2, r3, r4, r5, r6)
            goto L_0x00a6
        L_0x0033:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unsupported strategy "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r9.<init>(r0)
            throw r9
        L_0x004a:
            int r0 = r9.save()
            android.graphics.Path r1 = r8.f20997c
            r9.clipPath(r1)
            com.google.android.material.circularreveal.CircularRevealHelper$Delegate r1 = r8.f20995a
            r1.c(r9)
            boolean r1 = r8.r()
            if (r1 == 0) goto L_0x0074
            android.view.View r1 = r8.f20996b
            int r1 = r1.getWidth()
            float r5 = (float) r1
            android.view.View r1 = r8.f20996b
            int r1 = r1.getHeight()
            float r6 = (float) r1
            android.graphics.Paint r7 = r8.f20999e
            r3 = 0
            r4 = 0
            r2 = r9
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0074:
            r9.restoreToCount(r0)
            goto L_0x00a6
        L_0x0078:
            com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo r0 = r8.f21000f
            float r1 = r0.f21010a
            float r2 = r0.f21011b
            float r0 = r0.f21012c
            android.graphics.Paint r3 = r8.f20998d
            r9.drawCircle(r1, r2, r0, r3)
            boolean r0 = r8.r()
            if (r0 == 0) goto L_0x00a6
            com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo r0 = r8.f21000f
            float r1 = r0.f21010a
            float r2 = r0.f21011b
            float r0 = r0.f21012c
            android.graphics.Paint r3 = r8.f20999e
            r9.drawCircle(r1, r2, r0, r3)
            goto L_0x00a6
        L_0x0099:
            com.google.android.material.circularreveal.CircularRevealHelper$Delegate r0 = r8.f20995a
            r0.c(r9)
            boolean r0 = r8.r()
            if (r0 == 0) goto L_0x00a6
            goto L_0x001b
        L_0x00a6:
            r8.f(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.circularreveal.CircularRevealHelper.c(android.graphics.Canvas):void");
    }

    @Nullable
    public Drawable g() {
        return this.f21001g;
    }

    @ColorInt
    public int h() {
        return this.f20999e.getColor();
    }

    @Nullable
    public CircularRevealWidget.RevealInfo j() {
        CircularRevealWidget.RevealInfo revealInfo = this.f21000f;
        if (revealInfo == null) {
            return null;
        }
        CircularRevealWidget.RevealInfo revealInfo2 = new CircularRevealWidget.RevealInfo(revealInfo);
        if (revealInfo2.a()) {
            revealInfo2.f21012c = i(revealInfo2);
        }
        return revealInfo2;
    }

    public boolean l() {
        return this.f20995a.d() && !p();
    }

    public void m(@Nullable Drawable drawable) {
        this.f21001g = drawable;
        this.f20996b.invalidate();
    }

    public void n(@ColorInt int i2) {
        this.f20999e.setColor(i2);
        this.f20996b.invalidate();
    }

    public void o(@Nullable CircularRevealWidget.RevealInfo revealInfo) {
        if (revealInfo == null) {
            this.f21000f = null;
        } else {
            CircularRevealWidget.RevealInfo revealInfo2 = this.f21000f;
            if (revealInfo2 == null) {
                this.f21000f = new CircularRevealWidget.RevealInfo(revealInfo);
            } else {
                revealInfo2.c(revealInfo);
            }
            if (MathUtils.e(revealInfo.f21012c, i(revealInfo), 1.0E-4f)) {
                this.f21000f.f21012c = Float.MAX_VALUE;
            }
        }
        k();
    }
}
