package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private final Path f17024a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f17025b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17026c;

    /* renamed from: d  reason: collision with root package name */
    private final LottieDrawable f17027d;

    /* renamed from: e  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Path> f17028e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17029f;

    /* renamed from: g  reason: collision with root package name */
    private CompoundTrimPathContent f17030g = new CompoundTrimPathContent();

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapePath shapePath) {
        this.f17025b = shapePath.b();
        this.f17026c = shapePath.d();
        this.f17027d = lottieDrawable;
        BaseKeyframeAnimation<ShapeData, Path> a2 = shapePath.c().a();
        this.f17028e = a2;
        baseLayer.i(a2);
        a2.a(this);
    }

    private void c() {
        this.f17029f = false;
        this.f17027d.invalidateSelf();
    }

    public void a() {
        c();
    }

    public void b(List<Content> list, List<Content> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Content content = list.get(i2);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f17030g.a(trimPathContent);
                    trimPathContent.c(this);
                }
            }
        }
    }

    public String getName() {
        return this.f17025b;
    }

    public Path getPath() {
        if (this.f17029f) {
            return this.f17024a;
        }
        this.f17024a.reset();
        if (!this.f17026c) {
            this.f17024a.set(this.f17028e.h());
            this.f17024a.setFillType(Path.FillType.EVEN_ODD);
            this.f17030g.b(this.f17024a);
        }
        this.f17029f = true;
        return this.f17024a;
    }
}
