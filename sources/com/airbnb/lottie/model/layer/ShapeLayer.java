package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.Collections;
import java.util.List;

public class ShapeLayer extends BaseLayer {
    private final ContentGroup B;

    ShapeLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.l(), false));
        this.B = contentGroup;
        contentGroup.b(Collections.emptyList(), Collections.emptyList());
    }

    /* access modifiers changed from: protected */
    public void D(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2) {
        this.B.c(keyPath, i2, list, keyPath2);
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        this.B.d(rectF, this.f17249m, z);
    }

    /* access modifiers changed from: package-private */
    public void t(@NonNull Canvas canvas, Matrix matrix, int i2) {
        this.B.f(canvas, matrix, i2);
    }
}
