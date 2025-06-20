package com.airbnb.lottie.value;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativePointValueCallback extends LottieValueCallback<PointF> {

    /* renamed from: d  reason: collision with root package name */
    private final PointF f17379d = new PointF();

    public LottieRelativePointValueCallback() {
    }

    public PointF e(LottieFrameInfo<PointF> lottieFrameInfo) {
        T t = this.f17382c;
        if (t != null) {
            return (PointF) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* renamed from: f */
    public final PointF a(LottieFrameInfo<PointF> lottieFrameInfo) {
        this.f17379d.set(MiscUtils.j(lottieFrameInfo.g().x, lottieFrameInfo.b().x, lottieFrameInfo.c()), MiscUtils.j(lottieFrameInfo.g().y, lottieFrameInfo.b().y, lottieFrameInfo.c()));
        PointF e2 = e(lottieFrameInfo);
        this.f17379d.offset(e2.x, e2.y);
        return this.f17379d;
    }

    public LottieRelativePointValueCallback(@NonNull PointF pointF) {
        super(pointF);
    }
}
