package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class KeyframesParser {

    /* renamed from: a  reason: collision with root package name */
    static JsonReader.Options f17303a = JsonReader.Options.a("k");

    private KeyframesParser() {
    }

    static <T> List<Keyframe<T>> a(JsonReader jsonReader, LottieComposition lottieComposition, float f2, ValueParser<T> valueParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.s() == JsonReader.Token.STRING) {
            lottieComposition.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.d();
        while (jsonReader.h()) {
            if (jsonReader.u(f17303a) != 0) {
                jsonReader.w();
            } else if (jsonReader.s() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.c();
                if (jsonReader.s() == JsonReader.Token.NUMBER) {
                    arrayList.add(KeyframeParser.b(jsonReader, lottieComposition, f2, valueParser, false));
                } else {
                    while (jsonReader.h()) {
                        arrayList.add(KeyframeParser.b(jsonReader, lottieComposition, f2, valueParser, true));
                    }
                }
                jsonReader.e();
            } else {
                arrayList.add(KeyframeParser.b(jsonReader, lottieComposition, f2, valueParser, false));
            }
        }
        jsonReader.f();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends Keyframe<T>> list) {
        int i2;
        T t;
        int size = list.size();
        int i3 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            Keyframe keyframe = (Keyframe) list.get(i3);
            i3++;
            Keyframe keyframe2 = (Keyframe) list.get(i3);
            keyframe.f17359f = Float.valueOf(keyframe2.f17358e);
            if (keyframe.f17356c == null && (t = keyframe2.f17355b) != null) {
                keyframe.f17356c = t;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).i();
                }
            }
        }
        Keyframe keyframe3 = (Keyframe) list.get(i2);
        if ((keyframe3.f17355b == null || keyframe3.f17356c == null) && list.size() > 1) {
            list.remove(keyframe3);
        }
    }
}
