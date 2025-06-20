package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

class ShapeGroupParser {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f17322a = JsonReader.Options.a("nm", "hd", "it");

    private ShapeGroupParser() {
    }

    static ShapeGroup a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (jsonReader.h()) {
            int u = jsonReader.u(f17322a);
            if (u == 0) {
                str = jsonReader.q();
            } else if (u == 1) {
                z = jsonReader.i();
            } else if (u != 2) {
                jsonReader.w();
            } else {
                jsonReader.c();
                while (jsonReader.h()) {
                    ContentModel a2 = ContentModelParser.a(jsonReader, lottieComposition);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                jsonReader.e();
            }
        }
        return new ShapeGroup(str, arrayList, z);
    }
}
