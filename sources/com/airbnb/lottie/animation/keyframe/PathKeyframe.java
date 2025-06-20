package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.value.Keyframe;

public class PathKeyframe extends Keyframe<PointF> {
    @Nullable
    private Path q;
    private final Keyframe<PointF> r;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.f17355b, keyframe.f17356c, keyframe.f17357d, keyframe.f17358e, keyframe.f17359f);
        this.r = keyframe;
        i();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r4.f17355b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i() {
        /*
            r4 = this;
            T r0 = r4.f17356c
            if (r0 == 0) goto L_0x001b
            T r1 = r4.f17355b
            if (r1 == 0) goto L_0x001b
            android.graphics.PointF r1 = (android.graphics.PointF) r1
            r2 = r0
            android.graphics.PointF r2 = (android.graphics.PointF) r2
            float r2 = r2.x
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            float r0 = r0.y
            boolean r0 = r1.equals(r2, r0)
            if (r0 == 0) goto L_0x001b
            r0 = 1
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            T r1 = r4.f17356c
            if (r1 == 0) goto L_0x0034
            if (r0 != 0) goto L_0x0034
            T r0 = r4.f17355b
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            android.graphics.PointF r1 = (android.graphics.PointF) r1
            com.airbnb.lottie.value.Keyframe<android.graphics.PointF> r2 = r4.r
            android.graphics.PointF r3 = r2.f17366m
            android.graphics.PointF r2 = r2.f17367n
            android.graphics.Path r0 = com.airbnb.lottie.utils.Utils.d(r0, r1, r3, r2)
            r4.q = r0
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.keyframe.PathKeyframe.i():void");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Path j() {
        return this.q;
    }
}
