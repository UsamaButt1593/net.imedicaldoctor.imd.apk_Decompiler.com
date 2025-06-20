package com.google.android.material.textfield;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

class CutoutDrawable extends MaterialShapeDrawable {
    @NonNull
    CutoutDrawableState x3;

    private static class ImplApi14 extends CutoutDrawable {
        private Paint y3;
        private int z3;

        ImplApi14(@NonNull CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
        }

        private Paint X0() {
            if (this.y3 == null) {
                Paint paint = new Paint(1);
                this.y3 = paint;
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                this.y3.setColor(-1);
                this.y3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            }
            return this.y3;
        }

        private void Y0(@NonNull Canvas canvas) {
            if (!b1(getCallback())) {
                canvas.restoreToCount(this.z3);
            }
        }

        private void Z0(@NonNull Canvas canvas) {
            Drawable.Callback callback = getCallback();
            if (b1(callback)) {
                View view = (View) callback;
                if (view.getLayerType() != 2) {
                    view.setLayerType(2, (Paint) null);
                    return;
                }
                return;
            }
            a1(canvas);
        }

        private void a1(@NonNull Canvas canvas) {
            this.z3 = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
        }

        private boolean b1(Drawable.Callback callback) {
            return callback instanceof View;
        }

        public void draw(@NonNull Canvas canvas) {
            Z0(canvas);
            super.draw(canvas);
            Y0(canvas);
        }

        /* access modifiers changed from: protected */
        public void t(@NonNull Canvas canvas) {
            super.t(canvas);
            canvas.drawRect(this.x3.w, X0());
        }
    }

    @TargetApi(18)
    private static class ImplApi18 extends CutoutDrawable {
        ImplApi18(@NonNull CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
        }

        /* access modifiers changed from: protected */
        public void t(@NonNull Canvas canvas) {
            if (this.x3.w.isEmpty()) {
                super.t(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                boolean unused = canvas.clipOutRect(this.x3.w);
            } else {
                canvas.clipRect(this.x3.w, Region.Op.DIFFERENCE);
            }
            super.t(canvas);
            canvas.restore();
        }
    }

    private CutoutDrawable(@NonNull CutoutDrawableState cutoutDrawableState) {
        super((MaterialShapeDrawable.MaterialShapeDrawableState) cutoutDrawableState);
        this.x3 = cutoutDrawableState;
    }

    static CutoutDrawable R0(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel == null) {
            shapeAppearanceModel = new ShapeAppearanceModel();
        }
        return S0(new CutoutDrawableState(shapeAppearanceModel, new RectF()));
    }

    /* access modifiers changed from: private */
    public static CutoutDrawable S0(@NonNull CutoutDrawableState cutoutDrawableState) {
        return new ImplApi18(cutoutDrawableState);
    }

    /* access modifiers changed from: package-private */
    public boolean T0() {
        return !this.x3.w.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void U0() {
        V0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* access modifiers changed from: package-private */
    public void V0(float f2, float f3, float f4, float f5) {
        if (f2 != this.x3.w.left || f3 != this.x3.w.top || f4 != this.x3.w.right || f5 != this.x3.w.bottom) {
            this.x3.w.set(f2, f3, f4, f5);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void W0(@NonNull RectF rectF) {
        V0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @NonNull
    public Drawable mutate() {
        this.x3 = new CutoutDrawableState(this.x3);
        return this;
    }

    private static final class CutoutDrawableState extends MaterialShapeDrawable.MaterialShapeDrawableState {
        /* access modifiers changed from: private */
        @NonNull
        public final RectF w;

        private CutoutDrawableState(@NonNull ShapeAppearanceModel shapeAppearanceModel, @NonNull RectF rectF) {
            super(shapeAppearanceModel, (ElevationOverlayProvider) null);
            this.w = rectF;
        }

        @NonNull
        public Drawable newDrawable() {
            CutoutDrawable Q0 = CutoutDrawable.S0(this);
            Q0.invalidateSelf();
            return Q0;
        }

        private CutoutDrawableState(@NonNull CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
            this.w = cutoutDrawableState.w;
        }
    }
}
