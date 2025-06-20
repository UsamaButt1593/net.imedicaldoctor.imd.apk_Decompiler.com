package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

public class AnimatableTransformParser {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f17279a = JsonReader.Options.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* renamed from: b  reason: collision with root package name */
    private static JsonReader.Options f17280b = JsonReader.Options.a("k");

    private AnimatableTransformParser() {
    }

    private static boolean a(AnimatablePathValue animatablePathValue) {
        return animatablePathValue == null || (animatablePathValue.c() && ((PointF) animatablePathValue.b().get(0).f17355b).equals(0.0f, 0.0f));
    }

    private static boolean b(AnimatableValue<PointF, PointF> animatableValue) {
        return animatableValue == null || (!(animatableValue instanceof AnimatableSplitDimensionPathValue) && animatableValue.c() && ((PointF) animatableValue.b().get(0).f17355b).equals(0.0f, 0.0f));
    }

    private static boolean c(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.c() && ((Float) ((Keyframe) animatableFloatValue.b().get(0)).f17355b).floatValue() == 0.0f);
    }

    private static boolean d(AnimatableScaleValue animatableScaleValue) {
        return animatableScaleValue == null || (animatableScaleValue.c() && ((ScaleXY) ((Keyframe) animatableScaleValue.b().get(0)).f17355b).a(1.0f, 1.0f));
    }

    private static boolean e(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.c() && ((Float) ((Keyframe) animatableFloatValue.b().get(0)).f17355b).floatValue() == 0.0f);
    }

    private static boolean f(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.c() && ((Float) ((Keyframe) animatableFloatValue.b().get(0)).f17355b).floatValue() == 0.0f);
    }

    public static AnimatableTransform g(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        JsonReader jsonReader2 = jsonReader;
        LottieComposition lottieComposition2 = lottieComposition;
        boolean z = false;
        boolean z2 = jsonReader.s() == JsonReader.Token.BEGIN_OBJECT;
        if (z2) {
            jsonReader.d();
        }
        AnimatableFloatValue animatableFloatValue = null;
        AnimatablePathValue animatablePathValue = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatableScaleValue animatableScaleValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        while (jsonReader.h()) {
            switch (jsonReader2.u(f17279a)) {
                case 0:
                    jsonReader.d();
                    while (jsonReader.h()) {
                        if (jsonReader2.u(f17280b) != 0) {
                            jsonReader.v();
                            jsonReader.w();
                        } else {
                            animatablePathValue = AnimatablePathValueParser.a(jsonReader, lottieComposition);
                        }
                    }
                    jsonReader.f();
                    break;
                case 1:
                    animatableValue = AnimatablePathValueParser.b(jsonReader, lottieComposition);
                    break;
                case 2:
                    animatableScaleValue = AnimatableValueParser.j(jsonReader, lottieComposition);
                    break;
                case 3:
                    lottieComposition2.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    animatableIntegerValue = AnimatableValueParser.h(jsonReader, lottieComposition);
                    continue;
                case 6:
                    animatableFloatValue4 = AnimatableValueParser.f(jsonReader2, lottieComposition2, z);
                    continue;
                case 7:
                    animatableFloatValue5 = AnimatableValueParser.f(jsonReader2, lottieComposition2, z);
                    continue;
                case 8:
                    animatableFloatValue2 = AnimatableValueParser.f(jsonReader2, lottieComposition2, z);
                    continue;
                case 9:
                    animatableFloatValue3 = AnimatableValueParser.f(jsonReader2, lottieComposition2, z);
                    continue;
                default:
                    jsonReader.v();
                    jsonReader.w();
                    continue;
            }
            AnimatableFloatValue f2 = AnimatableValueParser.f(jsonReader2, lottieComposition2, z);
            if (f2.b().isEmpty()) {
                Keyframe keyframe = r1;
                Keyframe keyframe2 = new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(lottieComposition.f()));
                f2.b().add(keyframe);
            } else if (((Keyframe) f2.b().get(0)).f17355b == null) {
                f2.b().set(0, new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(lottieComposition.f())));
                animatableFloatValue = f2;
                z = false;
            }
            animatableFloatValue = f2;
            z = false;
        }
        if (z2) {
            jsonReader.f();
        }
        AnimatablePathValue animatablePathValue2 = a(animatablePathValue) ? null : animatablePathValue;
        AnimatableValue<PointF, PointF> animatableValue2 = b(animatableValue) ? null : animatableValue;
        AnimatableFloatValue animatableFloatValue6 = c(animatableFloatValue) ? null : animatableFloatValue;
        if (d(animatableScaleValue)) {
            animatableScaleValue = null;
        }
        return new AnimatableTransform(animatablePathValue2, animatableValue2, animatableScaleValue, animatableFloatValue6, animatableIntegerValue, animatableFloatValue4, animatableFloatValue5, f(animatableFloatValue2) ? null : animatableFloatValue2, e(animatableFloatValue3) ? null : animatableFloatValue3);
    }
}
