package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

public class Mask {

    /* renamed from: a  reason: collision with root package name */
    private final MaskMode f17176a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableShapeValue f17177b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableIntegerValue f17178c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17179d;

    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, AnimatableShapeValue animatableShapeValue, AnimatableIntegerValue animatableIntegerValue, boolean z) {
        this.f17176a = maskMode;
        this.f17177b = animatableShapeValue;
        this.f17178c = animatableIntegerValue;
        this.f17179d = z;
    }

    public MaskMode a() {
        return this.f17176a;
    }

    public AnimatableShapeValue b() {
        return this.f17177b;
    }

    public AnimatableIntegerValue c() {
        return this.f17178c;
    }

    public boolean d() {
        return this.f17179d;
    }
}
