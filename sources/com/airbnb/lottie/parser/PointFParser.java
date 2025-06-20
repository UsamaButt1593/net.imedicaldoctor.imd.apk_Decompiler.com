package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class PointFParser implements ValueParser<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final PointFParser f17314a = new PointFParser();

    private PointFParser() {
    }

    /* renamed from: b */
    public PointF a(JsonReader jsonReader, float f2) throws IOException {
        JsonReader.Token s = jsonReader.s();
        if (s == JsonReader.Token.BEGIN_ARRAY) {
            return JsonUtils.e(jsonReader, f2);
        }
        if (s == JsonReader.Token.BEGIN_OBJECT) {
            return JsonUtils.e(jsonReader, f2);
        }
        if (s == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.k()) * f2, ((float) jsonReader.k()) * f2);
            while (jsonReader.h()) {
                jsonReader.w();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + s);
    }
}
