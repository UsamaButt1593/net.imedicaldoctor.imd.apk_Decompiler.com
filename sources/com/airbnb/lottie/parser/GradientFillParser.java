package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class GradientFillParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f17291a = JsonReader.Options.a("nm", "g", "o", "t", "s", "e", "r", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f17292b = JsonReader.Options.a("p", "k");

    private GradientFillParser() {
    }

    static GradientFill a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        boolean z = false;
        while (jsonReader.h()) {
            switch (jsonReader.u(f17291a)) {
                case 0:
                    str = jsonReader.q();
                    break;
                case 1:
                    jsonReader.d();
                    int i2 = -1;
                    while (jsonReader.h()) {
                        int u = jsonReader.u(f17292b);
                        if (u == 0) {
                            i2 = jsonReader.n();
                        } else if (u != 1) {
                            jsonReader.v();
                            jsonReader.w();
                        } else {
                            animatableGradientColorValue = AnimatableValueParser.g(jsonReader, lottieComposition, i2);
                        }
                    }
                    jsonReader.f();
                    break;
                case 2:
                    animatableIntegerValue = AnimatableValueParser.h(jsonReader, lottieComposition);
                    break;
                case 3:
                    gradientType = jsonReader.n() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    animatablePointValue = AnimatableValueParser.i(jsonReader, lottieComposition);
                    break;
                case 5:
                    animatablePointValue2 = AnimatableValueParser.i(jsonReader, lottieComposition);
                    break;
                case 6:
                    fillType = jsonReader.n() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z = jsonReader.i();
                    break;
                default:
                    jsonReader.v();
                    jsonReader.w();
                    break;
            }
        }
        return new GradientFill(str, gradientType, fillType, animatableGradientColorValue, animatableIntegerValue, animatablePointValue, animatablePointValue2, (AnimatableFloatValue) null, (AnimatableFloatValue) null, z);
    }
}
