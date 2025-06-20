package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class RectangleShapeParser {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f17316a = JsonReader.Options.a("nm", "p", "s", "r", "hd");

    private RectangleShapeParser() {
    }

    static RectangleShape a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        boolean z = false;
        while (jsonReader.h()) {
            int u = jsonReader.u(f17316a);
            if (u == 0) {
                str = jsonReader.q();
            } else if (u == 1) {
                animatableValue = AnimatablePathValueParser.b(jsonReader, lottieComposition);
            } else if (u == 2) {
                animatablePointValue = AnimatableValueParser.i(jsonReader, lottieComposition);
            } else if (u == 3) {
                animatableFloatValue = AnimatableValueParser.e(jsonReader, lottieComposition);
            } else if (u != 4) {
                jsonReader.w();
            } else {
                z = jsonReader.i();
            }
        }
        return new RectangleShape(str, animatableValue, animatablePointValue, animatableFloatValue, z);
    }
}
