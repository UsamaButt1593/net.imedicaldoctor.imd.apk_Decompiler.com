package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.ArrayList;
import java.util.List;

public class MaskKeyframeAnimation {

    /* renamed from: a  reason: collision with root package name */
    private final List<BaseKeyframeAnimation<ShapeData, Path>> f17053a;

    /* renamed from: b  reason: collision with root package name */
    private final List<BaseKeyframeAnimation<Integer, Integer>> f17054b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Mask> f17055c;

    public MaskKeyframeAnimation(List<Mask> list) {
        this.f17055c = list;
        this.f17053a = new ArrayList(list.size());
        this.f17054b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f17053a.add(list.get(i2).b().a());
            this.f17054b.add(list.get(i2).c().a());
        }
    }

    public List<BaseKeyframeAnimation<ShapeData, Path>> a() {
        return this.f17053a;
    }

    public List<Mask> b() {
        return this.f17055c;
    }

    public List<BaseKeyframeAnimation<Integer, Integer>> c() {
        return this.f17054b;
    }
}
