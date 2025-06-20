package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class RepeaterParser {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f17317a = JsonReader.Options.a("nm", "c", "o", "tr", "hd");

    private RepeaterParser() {
    }

    static Repeater a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableTransform animatableTransform = null;
        boolean z = false;
        while (jsonReader.h()) {
            int u = jsonReader.u(f17317a);
            if (u == 0) {
                str = jsonReader.q();
            } else if (u == 1) {
                animatableFloatValue = AnimatableValueParser.f(jsonReader, lottieComposition, false);
            } else if (u == 2) {
                animatableFloatValue2 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
            } else if (u == 3) {
                animatableTransform = AnimatableTransformParser.g(jsonReader, lottieComposition);
            } else if (u != 4) {
                jsonReader.w();
            } else {
                z = jsonReader.i();
            }
        }
        return new Repeater(str, animatableFloatValue, animatableFloatValue2, animatableTransform, z);
    }
}
