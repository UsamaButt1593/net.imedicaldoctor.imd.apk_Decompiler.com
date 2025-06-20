package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class AspectRatioFrameLayout extends FrameLayout {
    public static final int a3 = 0;
    public static final int b3 = 1;
    public static final int c3 = 2;
    public static final int d3 = 3;
    public static final int e3 = 4;
    private static final float f3 = 0.01f;
    /* access modifiers changed from: private */
    @Nullable
    public AspectRatioListener X2;
    private float Y2;
    private int Z2;
    private final AspectRatioUpdateDispatcher s;

    public interface AspectRatioListener {
        void a(float f2, float f3, boolean z);
    }

    private final class AspectRatioUpdateDispatcher implements Runnable {
        private float X;
        private boolean Y;
        private boolean Z;
        private float s;

        private AspectRatioUpdateDispatcher() {
        }

        public void a(float f2, float f3, boolean z) {
            this.s = f2;
            this.X = f3;
            this.Y = z;
            if (!this.Z) {
                this.Z = true;
                AspectRatioFrameLayout.this.post(this);
            }
        }

        public void run() {
            this.Z = false;
            if (AspectRatioFrameLayout.this.X2 != null) {
                AspectRatioFrameLayout.this.X2.a(this.s, this.X, this.Y);
            }
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResizeMode {
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public int getResizeMode() {
        return this.Z2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (r4 > 0.0f) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (r4 > 0.0f) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            super.onMeasure(r9, r10)
            float r9 = r8.Y2
            r10 = 0
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 > 0) goto L_0x000b
            return
        L_0x000b:
            int r9 = r8.getMeasuredWidth()
            int r0 = r8.getMeasuredHeight()
            float r1 = (float) r9
            float r2 = (float) r0
            float r3 = r1 / r2
            float r4 = r8.Y2
            float r4 = r4 / r3
            r5 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 - r5
            float r5 = java.lang.Math.abs(r4)
            r6 = 1008981770(0x3c23d70a, float:0.01)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x0031
            androidx.media3.ui.AspectRatioFrameLayout$AspectRatioUpdateDispatcher r9 = r8.s
            float r10 = r8.Y2
            r0 = 0
            r9.a(r10, r3, r0)
            return
        L_0x0031:
            int r5 = r8.Z2
            r6 = 1
            if (r5 == 0) goto L_0x004e
            if (r5 == r6) goto L_0x0049
            r7 = 2
            if (r5 == r7) goto L_0x0043
            r7 = 4
            if (r5 == r7) goto L_0x003f
            goto L_0x0053
        L_0x003f:
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x0049
        L_0x0043:
            float r9 = r8.Y2
            float r2 = r2 * r9
            int r9 = (int) r2
            goto L_0x0053
        L_0x0049:
            float r10 = r8.Y2
            float r1 = r1 / r10
            int r0 = (int) r1
            goto L_0x0053
        L_0x004e:
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x0043
            goto L_0x0049
        L_0x0053:
            androidx.media3.ui.AspectRatioFrameLayout$AspectRatioUpdateDispatcher r10 = r8.s
            float r1 = r8.Y2
            r10.a(r1, r3, r6)
            r10 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r10)
            super.onMeasure(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.AspectRatioFrameLayout.onMeasure(int, int):void");
    }

    public void setAspectRatio(float f2) {
        if (this.Y2 != f2) {
            this.Y2 = f2;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable AspectRatioListener aspectRatioListener) {
        this.X2 = aspectRatioListener;
    }

    public void setResizeMode(int i2) {
        if (this.Z2 != i2) {
            this.Z2 = i2;
            requestLayout();
        }
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Z2 = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.f14809a, 0, 0);
            try {
                this.Z2 = obtainStyledAttributes.getInt(R.styleable.f14810b, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.s = new AspectRatioUpdateDispatcher();
    }
}
