package com.airbnb.lottie.parser;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;
import java.util.List;

public class AnimatableValueParser {
    private AnimatableValueParser() {
    }

    @Nullable
    private static <T> List<Keyframe<T>> a(JsonReader jsonReader, float f2, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.a(jsonReader, lottieComposition, f2, valueParser);
    }

    @Nullable
    private static <T> List<Keyframe<T>> b(JsonReader jsonReader, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.a(jsonReader, lottieComposition, 1.0f, valueParser);
    }

    static AnimatableColorValue c(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableColorValue(b(jsonReader, lottieComposition, ColorParser.f17282a));
    }

    static AnimatableTextFrame d(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableTextFrame(b(jsonReader, lottieComposition, DocumentDataParser.f17284a));
    }

    public static AnimatableFloatValue e(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return f(jsonReader, lottieComposition, true);
    }

    public static AnimatableFloatValue f(JsonReader jsonReader, LottieComposition lottieComposition, boolean z) throws IOException {
        return new AnimatableFloatValue(a(jsonReader, z ? Utils.e() : 1.0f, lottieComposition, FloatParser.f17286a));
    }

    static AnimatableGradientColorValue g(JsonReader jsonReader, LottieComposition lottieComposition, int i2) throws IOException {
        return new AnimatableGradientColorValue(b(jsonReader, lottieComposition, new GradientColorParser(i2)));
    }

    static AnimatableIntegerValue h(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableIntegerValue(b(jsonReader, lottieComposition, IntegerParser.f17296a));
    }

    static AnimatablePointValue i(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatablePointValue(a(jsonReader, Utils.e(), lottieComposition, PointFParser.f17314a));
    }

    static AnimatableScaleValue j(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableScaleValue((List<Keyframe<ScaleXY>>) b(jsonReader, lottieComposition, ScaleXYParser.f17318a));
    }

    static AnimatableShapeValue k(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableShapeValue(a(jsonReader, Utils.e(), lottieComposition, ShapeDataParser.f17319a));
    }
}
