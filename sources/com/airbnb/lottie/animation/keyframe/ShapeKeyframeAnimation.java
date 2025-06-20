package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {

    /* renamed from: i  reason: collision with root package name */
    private final ShapeData f17062i = new ShapeData();

    /* renamed from: j  reason: collision with root package name */
    private final Path f17063j = new Path();

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
    }

    /* renamed from: o */
    public Path i(Keyframe<ShapeData> keyframe, float f2) {
        this.f17062i.c((ShapeData) keyframe.f17355b, (ShapeData) keyframe.f17356c, f2);
        MiscUtils.h(this.f17062i, this.f17063j);
        return this.f17063j;
    }
}
