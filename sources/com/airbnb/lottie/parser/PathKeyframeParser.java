package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;

class PathKeyframeParser {
    private PathKeyframeParser() {
    }

    static PathKeyframe a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new PathKeyframe(lottieComposition, KeyframeParser.b(jsonReader, lottieComposition, Utils.e(), PathParser.f17313a, jsonReader.s() == JsonReader.Token.BEGIN_OBJECT));
    }
}
