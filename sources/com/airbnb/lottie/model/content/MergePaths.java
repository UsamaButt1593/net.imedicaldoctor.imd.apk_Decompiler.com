package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.MergePathsContent;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Logger;
import com.dd.plist.ASCIIPropertyListParser;

public class MergePaths implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f17180a;

    /* renamed from: b  reason: collision with root package name */
    private final MergePathsMode f17181b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17182c;

    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode a(int i2) {
            if (i2 == 1) {
                return MERGE;
            }
            if (i2 == 2) {
                return ADD;
            }
            if (i2 == 3) {
                return SUBTRACT;
            }
            if (i2 != 4) {
                return i2 != 5 ? MERGE : EXCLUDE_INTERSECTIONS;
            }
            return INTERSECT;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.f17180a = str;
        this.f17181b = mergePathsMode;
        this.f17182c = z;
    }

    @Nullable
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        if (lottieDrawable.r()) {
            return new MergePathsContent(this);
        }
        Logger.e("Animation contains merge paths but they are disabled.");
        return null;
    }

    public MergePathsMode b() {
        return this.f17181b;
    }

    public String c() {
        return this.f17180a;
    }

    public boolean d() {
        return this.f17182c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f17181b + ASCIIPropertyListParser.f18653k;
    }
}
