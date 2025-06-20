package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;

public class AnimatablePathValueParser {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f17276a = JsonReader.Options.a("k", "x", "y");

    private AnimatablePathValueParser() {
    }

    public static AnimatablePathValue a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.s() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            while (jsonReader.h()) {
                arrayList.add(PathKeyframeParser.a(jsonReader, lottieComposition));
            }
            jsonReader.e();
            KeyframesParser.b(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.e(jsonReader, Utils.e())));
        }
        return new AnimatablePathValue(arrayList);
    }

    static AnimatableValue<PointF, PointF> b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.d();
        AnimatablePathValue animatablePathValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean z = false;
        while (jsonReader.s() != JsonReader.Token.END_OBJECT) {
            int u = jsonReader.u(f17276a);
            if (u != 0) {
                if (u != 1) {
                    if (u != 2) {
                        jsonReader.v();
                        jsonReader.w();
                    } else if (jsonReader.s() != JsonReader.Token.STRING) {
                        animatableFloatValue2 = AnimatableValueParser.e(jsonReader, lottieComposition);
                    }
                } else if (jsonReader.s() != JsonReader.Token.STRING) {
                    animatableFloatValue = AnimatableValueParser.e(jsonReader, lottieComposition);
                }
                jsonReader.w();
                z = true;
            } else {
                animatablePathValue = a(jsonReader, lottieComposition);
            }
        }
        jsonReader.f();
        if (z) {
            lottieComposition.a("Lottie doesn't support expressions.");
        }
        return animatablePathValue != null ? animatablePathValue : new AnimatableSplitDimensionPathValue(animatableFloatValue, animatableFloatValue2);
    }
}
