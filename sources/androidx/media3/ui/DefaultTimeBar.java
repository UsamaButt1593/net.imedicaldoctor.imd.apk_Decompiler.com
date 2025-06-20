package androidx.media3.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.ui.TimeBar;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

@UnstableApi
public class DefaultTimeBar extends View implements TimeBar {
    public static final int L3 = 4;
    public static final int M3 = 26;
    public static final int N3 = 4;
    public static final int O3 = 12;
    public static final int P3 = 0;
    public static final int Q3 = 16;
    public static final int R3 = -1;
    public static final int S3 = 872415231;
    public static final int T3 = -855638017;
    public static final int U3 = -1;
    public static final int V3 = -1291845888;
    public static final int W3 = 872414976;
    public static final int X3 = 0;
    public static final int Y3 = 1;
    private static final int Z3 = -50;
    private static final int a4 = 3;
    private static final long b4 = 1000;
    private static final int c4 = 20;
    private static final float d4 = 1.0f;
    private static final float e4 = 0.0f;
    private static final String f4 = "android.widget.SeekBar";
    private ValueAnimator A3;
    private float B3;
    private boolean C3;
    private boolean D3;
    private long E3;
    private long F3;
    private long G3;
    private long H3;
    private int I3;
    @Nullable
    private long[] J3;
    @Nullable
    private boolean[] K3;
    private final Rect X2;
    private final Rect Y2;
    private final Rect Z2;
    private final Paint a3;
    private final Paint b3;
    private final Paint c3;
    private final Paint d3;
    private final Paint e3;
    private final Paint f3;
    @Nullable
    private final Drawable g3;
    private final int h3;
    private final int i3;
    private final int j3;
    private final int k3;
    private final int l3;
    private final int m3;
    private final int n3;
    private final int o3;
    private final int p3;
    private final StringBuilder q3;
    private final Formatter r3;
    private final Rect s;
    private final Runnable s3;
    private final CopyOnWriteArraySet<TimeBar.OnScrubListener> t3;
    private final Point u3;
    private final float v3;
    private int w3;
    private long x3;
    private int y3;
    private Rect z3;

    public DefaultTimeBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private void A(long j2) {
        if (this.E3 != j2) {
            this.E3 = j2;
            Iterator<TimeBar.OnScrubListener> it2 = this.t3.iterator();
            while (it2.hasNext()) {
                it2.next().O(this, j2);
            }
        }
    }

    private static int f(float f2, int i2) {
        return (int) ((((float) i2) * f2) + 0.5f);
    }

    private void g(Canvas canvas) {
        if (this.F3 > 0) {
            Rect rect = this.Z2;
            int w = Util.w(rect.right, rect.left, this.X2.right);
            int centerY = this.Z2.centerY();
            Drawable drawable = this.g3;
            if (drawable == null) {
                canvas.drawCircle((float) w, (float) centerY, (float) ((int) ((((float) ((this.D3 || isFocused()) ? this.n3 : isEnabled() ? this.l3 : this.m3)) * this.B3) / 2.0f)), this.f3);
                return;
            }
            int intrinsicWidth = ((int) (((float) drawable.getIntrinsicWidth()) * this.B3)) / 2;
            int intrinsicHeight = ((int) (((float) this.g3.getIntrinsicHeight()) * this.B3)) / 2;
            this.g3.setBounds(w - intrinsicWidth, centerY - intrinsicHeight, w + intrinsicWidth, centerY + intrinsicHeight);
            this.g3.draw(canvas);
        }
    }

    private long getPositionIncrement() {
        long j2 = this.x3;
        if (j2 != C.f9084b) {
            return j2;
        }
        long j4 = this.F3;
        if (j4 == C.f9084b) {
            return 0;
        }
        return j4 / ((long) this.w3);
    }

    private String getProgressText() {
        return Util.K0(this.q3, this.r3, this.G3);
    }

    private long getScrubberPosition() {
        if (this.X2.width() <= 0 || this.F3 == C.f9084b) {
            return 0;
        }
        return (((long) this.Z2.width()) * this.F3) / ((long) this.X2.width());
    }

    private void h(Canvas canvas) {
        int height = this.X2.height();
        int centerY = this.X2.centerY() - (height / 2);
        int i2 = height + centerY;
        if (this.F3 <= 0) {
            Rect rect = this.X2;
            canvas.drawRect((float) rect.left, (float) centerY, (float) rect.right, (float) i2, this.c3);
            return;
        }
        Rect rect2 = this.Y2;
        int i4 = rect2.left;
        int i5 = rect2.right;
        int max = Math.max(Math.max(this.X2.left, i5), this.Z2.right);
        int i6 = this.X2.right;
        if (max < i6) {
            canvas.drawRect((float) max, (float) centerY, (float) i6, (float) i2, this.c3);
        }
        int max2 = Math.max(i4, this.Z2.right);
        if (i5 > max2) {
            canvas.drawRect((float) max2, (float) centerY, (float) i5, (float) i2, this.b3);
        }
        if (this.Z2.width() > 0) {
            Rect rect3 = this.Z2;
            canvas.drawRect((float) rect3.left, (float) centerY, (float) rect3.right, (float) i2, this.a3);
        }
        if (this.I3 != 0) {
            long[] jArr = (long[]) Assertions.g(this.J3);
            boolean[] zArr = (boolean[]) Assertions.g(this.K3);
            int i7 = this.k3 / 2;
            for (int i8 = 0; i8 < this.I3; i8++) {
                long x = Util.x(jArr[i8], 0, this.F3);
                Rect rect4 = this.X2;
                int min = rect4.left + Math.min(rect4.width() - this.k3, Math.max(0, ((int) ((((long) this.X2.width()) * x) / this.F3)) - i7));
                canvas.drawRect((float) min, (float) centerY, (float) (min + this.k3), (float) i2, zArr[i8] ? this.e3 : this.d3);
            }
        }
    }

    private boolean k(float f2, float f5) {
        return this.s.contains((int) f2, (int) f5);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        x(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(ValueAnimator valueAnimator) {
        this.B3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.s);
    }

    private void n(float f2) {
        Rect rect = this.Z2;
        Rect rect2 = this.X2;
        rect.right = Util.w((int) f2, rect2.left, rect2.right);
    }

    private static int o(float f2, int i2) {
        return (int) (((float) i2) / f2);
    }

    private Point p(MotionEvent motionEvent) {
        this.u3.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.u3;
    }

    private boolean q(long j2) {
        long j4 = this.F3;
        if (j4 <= 0) {
            return false;
        }
        long j5 = this.D3 ? this.E3 : this.G3;
        long x = Util.x(j5 + j2, 0, j4);
        if (x == j5) {
            return false;
        }
        if (!this.D3) {
            w(x);
        } else {
            A(x);
        }
        y();
        return true;
    }

    private boolean r(Drawable drawable) {
        return Util.f9646a >= 23 && s(drawable, getLayoutDirection());
    }

    private static boolean s(Drawable drawable, int i2) {
        return Util.f9646a >= 23 && C0361a.a(drawable, i2);
    }

    @RequiresApi(29)
    private void t(int i2, int i4) {
        Rect rect = this.z3;
        if (rect == null || rect.width() != i2 || this.z3.height() != i4) {
            Rect rect2 = new Rect(0, 0, i2, i4);
            this.z3 = rect2;
            setSystemGestureExclusionRects(Collections.singletonList(rect2));
        }
    }

    private void w(long j2) {
        this.E3 = j2;
        this.D3 = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<TimeBar.OnScrubListener> it2 = this.t3.iterator();
        while (it2.hasNext()) {
            it2.next().A(this, j2);
        }
    }

    private void x(boolean z) {
        removeCallbacks(this.s3);
        this.D3 = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<TimeBar.OnScrubListener> it2 = this.t3.iterator();
        while (it2.hasNext()) {
            it2.next().P(this, this.E3, z);
        }
    }

    private void y() {
        this.Y2.set(this.X2);
        this.Z2.set(this.X2);
        long j2 = this.D3 ? this.E3 : this.G3;
        if (this.F3 > 0) {
            int width = (int) ((((long) this.X2.width()) * this.H3) / this.F3);
            Rect rect = this.Y2;
            Rect rect2 = this.X2;
            rect.right = Math.min(rect2.left + width, rect2.right);
            int width2 = (int) ((((long) this.X2.width()) * j2) / this.F3);
            Rect rect3 = this.Z2;
            Rect rect4 = this.X2;
            rect3.right = Math.min(rect4.left + width2, rect4.right);
        } else {
            Rect rect5 = this.Y2;
            int i2 = this.X2.left;
            rect5.right = i2;
            this.Z2.right = i2;
        }
        invalidate(this.s);
    }

    private void z() {
        Drawable drawable = this.g3;
        if (drawable != null && drawable.isStateful() && this.g3.setState(getDrawableState())) {
            invalidate();
        }
    }

    public void a(TimeBar.OnScrubListener onScrubListener) {
        Assertions.g(onScrubListener);
        this.t3.add(onScrubListener);
    }

    public void b(@Nullable long[] jArr, @Nullable boolean[] zArr, int i2) {
        Assertions.a(i2 == 0 || !(jArr == null || zArr == null));
        this.I3 = i2;
        this.J3 = jArr;
        this.K3 = zArr;
        y();
    }

    public void c(TimeBar.OnScrubListener onScrubListener) {
        this.t3.remove(onScrubListener);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        z();
    }

    public long getPreferredUpdateDelay() {
        int o = o(this.v3, this.X2.width());
        if (o != 0) {
            long j2 = this.F3;
            if (!(j2 == 0 || j2 == C.f9084b)) {
                return j2 / ((long) o);
            }
        }
        return Long.MAX_VALUE;
    }

    public void i(long j2) {
        if (this.A3.isStarted()) {
            this.A3.cancel();
        }
        this.A3.setFloatValues(new float[]{this.B3, 0.0f});
        this.A3.setDuration(j2);
        this.A3.start();
    }

    public void j(boolean z) {
        if (this.A3.isStarted()) {
            this.A3.cancel();
        }
        this.C3 = z;
        this.B3 = 0.0f;
        invalidate(this.s);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.g3;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        h(canvas);
        g(canvas);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, @Nullable Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (this.D3 && !z) {
            x(false);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName(f4);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(f4);
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.F3 > 0) {
            if (Util.f9646a >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                return;
            }
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (q(r0) == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        removeCallbacks(r4.s3);
        postDelayed(r4.s3, 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L_0x0030
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L_0x0027
            switch(r5) {
                case 21: goto L_0x0013;
                case 22: goto L_0x0014;
                case 23: goto L_0x0027;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0030
        L_0x0013:
            long r0 = -r0
        L_0x0014:
            boolean r0 = r4.q(r0)
            if (r0 == 0) goto L_0x0030
            java.lang.Runnable r5 = r4.s3
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.s3
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L_0x0027:
            boolean r0 = r4.D3
            if (r0 == 0) goto L_0x0030
            r5 = 0
            r4.x(r5)
            return r3
        L_0x0030:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i5 - i2;
        int i10 = i6 - i4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i9 - getPaddingRight();
        int i11 = this.C3 ? 0 : this.o3;
        if (this.j3 == 1) {
            i8 = (i10 - getPaddingBottom()) - this.i3;
            int i12 = this.h3;
            i7 = ((i10 - getPaddingBottom()) - i12) - Math.max(i11 - (i12 / 2), 0);
        } else {
            i8 = (i10 - this.i3) / 2;
            i7 = (i10 - this.h3) / 2;
        }
        this.s.set(paddingLeft, i8, paddingRight, this.i3 + i8);
        Rect rect = this.X2;
        Rect rect2 = this.s;
        rect.set(rect2.left + i11, i7, rect2.right - i11, this.h3 + i7);
        if (Util.f9646a >= 29) {
            t(i9, i10);
        }
        y();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode == 0) {
            size = this.i3;
        } else if (mode != 1073741824) {
            size = Math.min(this.i3, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i2), size);
        z();
    }

    public void onRtlPropertiesChanged(int i2) {
        Drawable drawable = this.g3;
        if (drawable != null && s(drawable, i2)) {
            invalidate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r3 != 3) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x006e
            long r2 = r7.F3
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0010
            goto L_0x006e
        L_0x0010:
            android.graphics.Point r0 = r7.p(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L_0x005b
            r5 = 3
            if (r3 == r4) goto L_0x004c
            r6 = 2
            if (r3 == r6) goto L_0x0028
            if (r3 == r5) goto L_0x004c
            goto L_0x006e
        L_0x0028:
            boolean r8 = r7.D3
            if (r8 == 0) goto L_0x006e
            int r8 = r7.p3
            if (r0 >= r8) goto L_0x003a
            int r8 = r7.y3
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
        L_0x0036:
            r7.n(r8)
            goto L_0x003e
        L_0x003a:
            r7.y3 = r2
            float r8 = (float) r2
            goto L_0x0036
        L_0x003e:
            long r0 = r7.getScrubberPosition()
            r7.A(r0)
        L_0x0045:
            r7.y()
            r7.invalidate()
            return r4
        L_0x004c:
            boolean r0 = r7.D3
            if (r0 == 0) goto L_0x006e
            int r8 = r8.getAction()
            if (r8 != r5) goto L_0x0057
            r1 = 1
        L_0x0057:
            r7.x(r1)
            return r4
        L_0x005b:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.k(r8, r0)
            if (r0 == 0) goto L_0x006e
            r7.n(r8)
            long r0 = r7.getScrubberPosition()
            r7.w(r0)
            goto L_0x0045
        L_0x006e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (q(getPositionIncrement()) != false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (q(-getPositionIncrement()) != false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean performAccessibilityAction(int r7, @androidx.annotation.Nullable android.os.Bundle r8) {
        /*
            r6 = this;
            boolean r8 = super.performAccessibilityAction(r7, r8)
            r0 = 1
            if (r8 == 0) goto L_0x0008
            return r0
        L_0x0008:
            long r1 = r6.F3
            r3 = 0
            r8 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0012
            return r8
        L_0x0012:
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r7 != r1) goto L_0x0025
            long r1 = r6.getPositionIncrement()
            long r1 = -r1
            boolean r7 = r6.q(r1)
            if (r7 == 0) goto L_0x0034
        L_0x0021:
            r6.x(r8)
            goto L_0x0034
        L_0x0025:
            r1 = 4096(0x1000, float:5.74E-42)
            if (r7 != r1) goto L_0x0039
            long r1 = r6.getPositionIncrement()
            boolean r7 = r6.q(r1)
            if (r7 == 0) goto L_0x0034
            goto L_0x0021
        L_0x0034:
            r7 = 4
            r6.sendAccessibilityEvent(r7)
            return r0
        L_0x0039:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTimeBar.performAccessibilityAction(int, android.os.Bundle):boolean");
    }

    public void setAdMarkerColor(@ColorInt int i2) {
        this.d3.setColor(i2);
        invalidate(this.s);
    }

    public void setBufferedColor(@ColorInt int i2) {
        this.b3.setColor(i2);
        invalidate(this.s);
    }

    public void setBufferedPosition(long j2) {
        if (this.H3 != j2) {
            this.H3 = j2;
            y();
        }
    }

    public void setDuration(long j2) {
        if (this.F3 != j2) {
            this.F3 = j2;
            if (this.D3 && j2 == C.f9084b) {
                x(true);
            }
            y();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.D3 && !z) {
            x(true);
        }
    }

    public void setKeyCountIncrement(int i2) {
        Assertions.a(i2 > 0);
        this.w3 = i2;
        this.x3 = C.f9084b;
    }

    public void setKeyTimeIncrement(long j2) {
        Assertions.a(j2 > 0);
        this.w3 = -1;
        this.x3 = j2;
    }

    public void setPlayedAdMarkerColor(@ColorInt int i2) {
        this.e3.setColor(i2);
        invalidate(this.s);
    }

    public void setPlayedColor(@ColorInt int i2) {
        this.a3.setColor(i2);
        invalidate(this.s);
    }

    public void setPosition(long j2) {
        if (this.G3 != j2) {
            this.G3 = j2;
            setContentDescription(getProgressText());
            y();
        }
    }

    public void setScrubberColor(@ColorInt int i2) {
        this.f3.setColor(i2);
        invalidate(this.s);
    }

    public void setUnplayedColor(@ColorInt int i2) {
        this.c3.setColor(i2);
        invalidate(this.s);
    }

    public void u() {
        if (this.A3.isStarted()) {
            this.A3.cancel();
        }
        this.C3 = false;
        this.B3 = 1.0f;
        invalidate(this.s);
    }

    public void v(long j2) {
        if (this.A3.isStarted()) {
            this.A3.cancel();
        }
        this.C3 = false;
        this.A3.setFloatValues(new float[]{this.B3, 1.0f});
        this.A3.setDuration(j2);
        this.A3.start();
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i2, @Nullable AttributeSet attributeSet2) {
        this(context, attributeSet, i2, attributeSet2, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i2, @Nullable AttributeSet attributeSet2, int i4) {
        super(context, attributeSet, i2);
        int i5;
        int max;
        AttributeSet attributeSet3 = attributeSet2;
        this.s = new Rect();
        this.X2 = new Rect();
        this.Y2 = new Rect();
        this.Z2 = new Rect();
        Paint paint = new Paint();
        this.a3 = paint;
        Paint paint2 = new Paint();
        this.b3 = paint2;
        Paint paint3 = new Paint();
        this.c3 = paint3;
        Paint paint4 = new Paint();
        this.d3 = paint4;
        Paint paint5 = new Paint();
        this.e3 = paint5;
        Paint paint6 = new Paint();
        this.f3 = paint6;
        paint6.setAntiAlias(true);
        this.t3 = new CopyOnWriteArraySet<>();
        this.u3 = new Point();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.v3 = f2;
        this.p3 = f(f2, Z3);
        int f5 = f(f2, 4);
        int f6 = f(f2, 26);
        int f7 = f(f2, 4);
        int f8 = f(f2, 12);
        int f9 = f(f2, 0);
        int f10 = f(f2, 16);
        if (attributeSet3 != null) {
            Paint paint7 = paint4;
            Paint paint8 = paint5;
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet3, R.styleable.f14820l, i2, i4);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.w);
                this.g3 = drawable;
                if (drawable != null) {
                    r(drawable);
                    f6 = Math.max(drawable.getMinimumHeight(), f6);
                }
                this.h3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.p, f5);
                this.i3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.y, f6);
                this.j3 = obtainStyledAttributes.getInt(R.styleable.o, 0);
                this.k3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.f14822n, f7);
                this.l3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.x, f8);
                this.m3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.u, f9);
                this.n3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.v, f10);
                int i6 = obtainStyledAttributes.getInt(R.styleable.s, -1);
                int i7 = obtainStyledAttributes.getInt(R.styleable.t, -1);
                int i8 = obtainStyledAttributes.getInt(R.styleable.q, T3);
                int i9 = obtainStyledAttributes.getInt(R.styleable.z, S3);
                int i10 = obtainStyledAttributes.getInt(R.styleable.f14821m, V3);
                int i11 = obtainStyledAttributes.getInt(R.styleable.r, W3);
                paint.setColor(i6);
                paint6.setColor(i7);
                paint2.setColor(i8);
                paint3.setColor(i9);
                paint7.setColor(i10);
                paint8.setColor(i11);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.h3 = f5;
            this.i3 = f6;
            this.j3 = 0;
            this.k3 = f7;
            this.l3 = f8;
            this.m3 = f9;
            this.n3 = f10;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(T3);
            paint3.setColor(S3);
            paint4.setColor(V3);
            paint5.setColor(W3);
            this.g3 = null;
        }
        StringBuilder sb = new StringBuilder();
        this.q3 = sb;
        this.r3 = new Formatter(sb, Locale.getDefault());
        this.s3 = new C0363c(this);
        Drawable drawable2 = this.g3;
        if (drawable2 != null) {
            max = drawable2.getMinimumWidth();
            i5 = 1;
        } else {
            i5 = 1;
            max = Math.max(this.m3, Math.max(this.l3, this.n3));
        }
        this.o3 = (max + i5) / 2;
        this.B3 = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.A3 = valueAnimator;
        valueAnimator.addUpdateListener(new C0364d(this));
        this.F3 = C.f9084b;
        this.x3 = C.f9084b;
        this.w3 = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
