package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.value.LottieValueCallback;

public class SolidLayer extends BaseLayer {
    private final RectF B = new RectF();
    private final Paint C;
    private final float[] D;
    private final Path E;
    private final Layer F;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> G;

    SolidLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        LPaint lPaint = new LPaint();
        this.C = lPaint;
        this.D = new float[8];
        this.E = new Path();
        this.F = layer;
        lPaint.setAlpha(0);
        lPaint.setStyle(Paint.Style.FILL);
        lPaint.setColor(layer.m());
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        this.B.set(0.0f, 0.0f, (float) this.F.o(), (float) this.F.n());
        this.f17249m.mapRect(this.B);
        rectF.set(this.B);
    }

    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.g(t, lottieValueCallback);
        if (t == LottieProperty.C) {
            this.G = lottieValueCallback == null ? null : new ValueCallbackKeyframeAnimation(lottieValueCallback);
        }
    }

    public void t(Canvas canvas, Matrix matrix, int i2) {
        int alpha = Color.alpha(this.F.m());
        if (alpha != 0) {
            int intValue = (int) ((((float) i2) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) (this.v.h() == null ? 100 : this.v.h().h().intValue()))) / 100.0f) * 255.0f);
            this.C.setAlpha(intValue);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.G;
            if (baseKeyframeAnimation != null) {
                this.C.setColorFilter(baseKeyframeAnimation.h());
            }
            if (intValue > 0) {
                float[] fArr = this.D;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.F.o();
                float[] fArr2 = this.D;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.F.o();
                this.D[5] = (float) this.F.n();
                float[] fArr3 = this.D;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.F.n();
                matrix.mapPoints(this.D);
                this.E.reset();
                Path path = this.E;
                float[] fArr4 = this.D;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.E;
                float[] fArr5 = this.D;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.E;
                float[] fArr6 = this.D;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.E;
                float[] fArr7 = this.D;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.E;
                float[] fArr8 = this.D;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.E.close();
                canvas.drawPath(this.E, this.C);
            }
        }
    }
}
