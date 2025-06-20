package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

class GradientStrokeParser {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f17293a = JsonReader.Options.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f17294b = JsonReader.Options.a("p", "k");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.Options f17295c = JsonReader.Options.a("n", "v");

    private GradientStrokeParser() {
    }

    static GradientStroke a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str;
        JsonReader jsonReader2 = jsonReader;
        LottieComposition lottieComposition2 = lottieComposition;
        ArrayList arrayList = new ArrayList();
        String str2 = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f2 = 0.0f;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean z = false;
        while (jsonReader.h()) {
            switch (jsonReader2.u(f17293a)) {
                case 0:
                    str2 = jsonReader.q();
                    continue;
                case 1:
                    str = str2;
                    jsonReader.d();
                    int i2 = -1;
                    while (jsonReader.h()) {
                        int u = jsonReader2.u(f17294b);
                        AnimatableGradientColorValue animatableGradientColorValue2 = animatableGradientColorValue;
                        if (u == 0) {
                            i2 = jsonReader.n();
                        } else if (u != 1) {
                            jsonReader.v();
                            jsonReader.w();
                        } else {
                            animatableGradientColorValue = AnimatableValueParser.g(jsonReader2, lottieComposition2, i2);
                        }
                        animatableGradientColorValue = animatableGradientColorValue2;
                    }
                    AnimatableGradientColorValue animatableGradientColorValue3 = animatableGradientColorValue;
                    jsonReader.f();
                    break;
                case 2:
                    String str3 = str2;
                    animatableIntegerValue = AnimatableValueParser.h(jsonReader, lottieComposition);
                    continue;
                case 3:
                    str = str2;
                    gradientType = jsonReader.n() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    String str4 = str2;
                    animatablePointValue = AnimatableValueParser.i(jsonReader, lottieComposition);
                    continue;
                case 5:
                    String str5 = str2;
                    animatablePointValue2 = AnimatableValueParser.i(jsonReader, lottieComposition);
                    continue;
                case 6:
                    String str6 = str2;
                    animatableFloatValue = AnimatableValueParser.e(jsonReader, lottieComposition);
                    continue;
                case 7:
                    str = str2;
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.n() - 1];
                    break;
                case 8:
                    str = str2;
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.n() - 1];
                    break;
                case 9:
                    str = str2;
                    f2 = (float) jsonReader.k();
                    break;
                case 10:
                    z = jsonReader.i();
                    continue;
                case 11:
                    jsonReader.c();
                    while (jsonReader.h()) {
                        jsonReader.d();
                        String str7 = null;
                        AnimatableFloatValue animatableFloatValue3 = null;
                        while (jsonReader.h()) {
                            int u2 = jsonReader2.u(f17295c);
                            AnimatableFloatValue animatableFloatValue4 = animatableFloatValue2;
                            if (u2 != 0) {
                                if (u2 != 1) {
                                    jsonReader.v();
                                    jsonReader.w();
                                } else {
                                    animatableFloatValue3 = AnimatableValueParser.e(jsonReader, lottieComposition);
                                }
                                animatableFloatValue2 = animatableFloatValue4;
                            } else {
                                str7 = jsonReader.q();
                            }
                        }
                        AnimatableFloatValue animatableFloatValue5 = animatableFloatValue2;
                        jsonReader.f();
                        if (str7.equals("o")) {
                            animatableFloatValue2 = animatableFloatValue3;
                        } else {
                            if (str7.equals("d") || str7.equals("g")) {
                                lottieComposition2.w(true);
                                arrayList.add(animatableFloatValue3);
                            }
                            animatableFloatValue2 = animatableFloatValue5;
                        }
                    }
                    AnimatableFloatValue animatableFloatValue6 = animatableFloatValue2;
                    jsonReader.e();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    animatableFloatValue2 = animatableFloatValue6;
                    continue;
                default:
                    jsonReader.v();
                    jsonReader.w();
                    continue;
            }
            str2 = str;
        }
        return new GradientStroke(str2, gradientType, animatableGradientColorValue, animatableIntegerValue, animatablePointValue, animatablePointValue2, animatableFloatValue, lineCapType, lineJoinType, f2, arrayList, animatableFloatValue2, z);
    }
}
