package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class ShapeTrimPathParser {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f17326a = JsonReader.Options.a("s", "e", "o", "nm", "m", "hd");

    private ShapeTrimPathParser() {
    }

    static ShapeTrimPath a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        boolean z = false;
        while (jsonReader.h()) {
            int u = jsonReader.u(f17326a);
            if (u == 0) {
                animatableFloatValue = AnimatableValueParser.f(jsonReader, lottieComposition, false);
            } else if (u == 1) {
                animatableFloatValue2 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
            } else if (u == 2) {
                animatableFloatValue3 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
            } else if (u == 3) {
                str = jsonReader.q();
            } else if (u == 4) {
                type = ShapeTrimPath.Type.a(jsonReader.n());
            } else if (u != 5) {
                jsonReader.w();
            } else {
                z = jsonReader.i();
            }
        }
        return new ShapeTrimPath(str, type, animatableFloatValue, animatableFloatValue2, animatableFloatValue3, z);
    }
}
