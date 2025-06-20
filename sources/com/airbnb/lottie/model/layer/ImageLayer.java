package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

public class ImageLayer extends BaseLayer {
    private final Paint B = new LPaint(3);
    private final Rect C = new Rect();
    private final Rect D = new Rect();
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> E;

    ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    @Nullable
    private Bitmap J() {
        return this.f17250n.x(this.o.k());
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        Bitmap J = J();
        if (J != null) {
            rectF.set(0.0f, 0.0f, ((float) J.getWidth()) * Utils.e(), ((float) J.getHeight()) * Utils.e());
            this.f17249m.mapRect(rectF);
        }
    }

    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.g(t, lottieValueCallback);
        if (t == LottieProperty.C) {
            this.E = lottieValueCallback == null ? null : new ValueCallbackKeyframeAnimation(lottieValueCallback);
        }
    }

    public void t(@NonNull Canvas canvas, Matrix matrix, int i2) {
        Bitmap J = J();
        if (J != null && !J.isRecycled()) {
            float e2 = Utils.e();
            this.B.setAlpha(i2);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.E;
            if (baseKeyframeAnimation != null) {
                this.B.setColorFilter(baseKeyframeAnimation.h());
            }
            canvas.save();
            canvas.concat(matrix);
            this.C.set(0, 0, J.getWidth(), J.getHeight());
            this.D.set(0, 0, (int) (((float) J.getWidth()) * e2), (int) (((float) J.getHeight()) * e2));
            canvas.drawBitmap(J, this.C, this.D, this.B);
            canvas.restore();
        }
    }
}
