package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class ShapePathParser {

    /* renamed from: a  reason: collision with root package name */
    static JsonReader.Options f17323a = JsonReader.Options.a("nm", "ind", "ks", "hd");

    private ShapePathParser() {
    }

    static ShapePath a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableShapeValue animatableShapeValue = null;
        int i2 = 0;
        boolean z = false;
        while (jsonReader.h()) {
            int u = jsonReader.u(f17323a);
            if (u == 0) {
                str = jsonReader.q();
            } else if (u == 1) {
                i2 = jsonReader.n();
            } else if (u == 2) {
                animatableShapeValue = AnimatableValueParser.k(jsonReader, lottieComposition);
            } else if (u != 3) {
                jsonReader.w();
            } else {
                z = jsonReader.i();
            }
        }
        return new ShapePath(str, i2, animatableShapeValue, z);
    }
}
