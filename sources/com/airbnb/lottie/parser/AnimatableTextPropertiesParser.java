package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class AnimatableTextPropertiesParser {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f17277a = JsonReader.Options.a("a");

    /* renamed from: b  reason: collision with root package name */
    private static JsonReader.Options f17278b = JsonReader.Options.a("fc", "sc", "sw", "t");

    private AnimatableTextPropertiesParser() {
    }

    public static AnimatableTextProperties a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.d();
        AnimatableTextProperties animatableTextProperties = null;
        while (jsonReader.h()) {
            if (jsonReader.u(f17277a) != 0) {
                jsonReader.v();
                jsonReader.w();
            } else {
                animatableTextProperties = b(jsonReader, lottieComposition);
            }
        }
        jsonReader.f();
        return animatableTextProperties == null ? new AnimatableTextProperties((AnimatableColorValue) null, (AnimatableColorValue) null, (AnimatableFloatValue) null, (AnimatableFloatValue) null) : animatableTextProperties;
    }

    private static AnimatableTextProperties b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.d();
        AnimatableColorValue animatableColorValue = null;
        AnimatableColorValue animatableColorValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonReader.h()) {
            int u = jsonReader.u(f17278b);
            if (u == 0) {
                animatableColorValue = AnimatableValueParser.c(jsonReader, lottieComposition);
            } else if (u == 1) {
                animatableColorValue2 = AnimatableValueParser.c(jsonReader, lottieComposition);
            } else if (u == 2) {
                animatableFloatValue = AnimatableValueParser.e(jsonReader, lottieComposition);
            } else if (u != 3) {
                jsonReader.v();
                jsonReader.w();
            } else {
                animatableFloatValue2 = AnimatableValueParser.e(jsonReader, lottieComposition);
            }
        }
        jsonReader.f();
        return new AnimatableTextProperties(animatableColorValue, animatableColorValue2, animatableFloatValue, animatableFloatValue2);
    }
}
