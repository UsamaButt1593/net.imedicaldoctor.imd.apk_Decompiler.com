package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {

    /* renamed from: a  reason: collision with root package name */
    final List<Keyframe<V>> f17145a;

    BaseAnimatableValue(V v) {
        this(Collections.singletonList(new Keyframe(v)));
    }

    public List<Keyframe<V>> b() {
        return this.f17145a;
    }

    public boolean c() {
        if (!this.f17145a.isEmpty()) {
            return this.f17145a.size() == 1 && this.f17145a.get(0).h();
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f17145a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f17145a.toArray()));
        }
        return sb.toString();
    }

    BaseAnimatableValue(List<Keyframe<V>> list) {
        this.f17145a = list;
    }
}
