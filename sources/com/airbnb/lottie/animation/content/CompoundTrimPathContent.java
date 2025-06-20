package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CompoundTrimPathContent {

    /* renamed from: a  reason: collision with root package name */
    private List<TrimPathContent> f16937a = new ArrayList();

    /* access modifiers changed from: package-private */
    public void a(TrimPathContent trimPathContent) {
        this.f16937a.add(trimPathContent);
    }

    public void b(Path path) {
        for (int size = this.f16937a.size() - 1; size >= 0; size--) {
            Utils.b(path, this.f16937a.get(size));
        }
    }
}
