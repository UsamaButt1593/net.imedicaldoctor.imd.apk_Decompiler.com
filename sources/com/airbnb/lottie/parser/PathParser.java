package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class PathParser implements ValueParser<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final PathParser f17313a = new PathParser();

    private PathParser() {
    }

    /* renamed from: b */
    public PointF a(JsonReader jsonReader, float f2) throws IOException {
        return JsonUtils.e(jsonReader, f2);
    }
}
