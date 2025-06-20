package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public DocumentData i(Keyframe<DocumentData> keyframe, float f2) {
        return (DocumentData) keyframe.f17355b;
    }
}
