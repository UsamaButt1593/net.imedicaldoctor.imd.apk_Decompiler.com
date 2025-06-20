package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.Arrays;
import java.util.List;

public class ShapeGroup implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f17212a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ContentModel> f17213b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17214c;

    public ShapeGroup(String str, List<ContentModel> list, boolean z) {
        this.f17212a = str;
        this.f17213b = list;
        this.f17214c = z;
    }

    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ContentGroup(lottieDrawable, baseLayer, this);
    }

    public List<ContentModel> b() {
        return this.f17213b;
    }

    public String c() {
        return this.f17212a;
    }

    public boolean d() {
        return this.f17214c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f17212a + "' Shapes: " + Arrays.toString(this.f17213b.toArray()) + ASCIIPropertyListParser.f18653k;
    }
}
