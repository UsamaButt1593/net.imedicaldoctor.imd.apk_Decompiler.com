package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class CircleShapeParser {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f17281a = JsonReader.Options.a("nm", "p", "s", "hd", "d");

    private CircleShapeParser() {
    }

    static CircleShape a(JsonReader jsonReader, LottieComposition lottieComposition, int i2) throws IOException {
        boolean z = i2 == 3;
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        boolean z2 = false;
        while (jsonReader.h()) {
            int u = jsonReader.u(f17281a);
            if (u == 0) {
                str = jsonReader.q();
            } else if (u == 1) {
                animatableValue = AnimatablePathValueParser.b(jsonReader, lottieComposition);
            } else if (u == 2) {
                animatablePointValue = AnimatableValueParser.i(jsonReader, lottieComposition);
            } else if (u == 3) {
                z2 = jsonReader.i();
            } else if (u != 4) {
                jsonReader.v();
                jsonReader.w();
            } else {
                z = jsonReader.n() == 3;
            }
        }
        return new CircleShape(str, animatableValue, animatablePointValue, z, z2);
    }
}
