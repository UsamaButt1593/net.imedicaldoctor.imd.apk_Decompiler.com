package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class ShapeFillParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f17321a = JsonReader.Options.a("nm", "c", "o", "fillEnabled", "r", "hd");

    private ShapeFillParser() {
    }

    static ShapeFill a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableColorValue animatableColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        int i2 = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.h()) {
            int u = jsonReader.u(f17321a);
            if (u == 0) {
                str = jsonReader.q();
            } else if (u == 1) {
                animatableColorValue = AnimatableValueParser.c(jsonReader, lottieComposition);
            } else if (u == 2) {
                animatableIntegerValue = AnimatableValueParser.h(jsonReader, lottieComposition);
            } else if (u == 3) {
                z = jsonReader.i();
            } else if (u == 4) {
                i2 = jsonReader.n();
            } else if (u != 5) {
                jsonReader.v();
                jsonReader.w();
            } else {
                z2 = jsonReader.i();
            }
        }
        return new ShapeFill(str, z, i2 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, animatableColorValue, animatableIntegerValue, z2);
    }
}
