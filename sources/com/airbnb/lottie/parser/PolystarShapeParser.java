package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.itextpdf.tool.xml.css.CSS;
import java.io.IOException;

class PolystarShapeParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f17315a = JsonReader.Options.a("nm", "sy", CSS.Value.l0, "p", "r", "or", "os", "ir", "is", "hd");

    private PolystarShapeParser() {
    }

    static PolystarShape a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        PolystarShape.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableFloatValue animatableFloatValue6 = null;
        boolean z = false;
        while (jsonReader.h()) {
            switch (jsonReader.u(f17315a)) {
                case 0:
                    str = jsonReader.q();
                    break;
                case 1:
                    type = PolystarShape.Type.a(jsonReader.n());
                    break;
                case 2:
                    animatableFloatValue = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 3:
                    animatableValue = AnimatablePathValueParser.b(jsonReader, lottieComposition);
                    break;
                case 4:
                    animatableFloatValue2 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 5:
                    animatableFloatValue4 = AnimatableValueParser.e(jsonReader, lottieComposition);
                    break;
                case 6:
                    animatableFloatValue6 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 7:
                    animatableFloatValue3 = AnimatableValueParser.e(jsonReader, lottieComposition);
                    break;
                case 8:
                    animatableFloatValue5 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 9:
                    z = jsonReader.i();
                    break;
                default:
                    jsonReader.v();
                    jsonReader.w();
                    break;
            }
        }
        return new PolystarShape(str, type, animatableFloatValue, animatableValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4, animatableFloatValue5, animatableFloatValue6, z);
    }
}
