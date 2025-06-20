package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeDataParser implements ValueParser<ShapeData> {

    /* renamed from: a  reason: collision with root package name */
    public static final ShapeDataParser f17319a = new ShapeDataParser();

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f17320b = JsonReader.Options.a("c", "v", "i", "o");

    private ShapeDataParser() {
    }

    /* renamed from: b */
    public ShapeData a(JsonReader jsonReader, float f2) throws IOException {
        if (jsonReader.s() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
        }
        jsonReader.d();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.h()) {
            int u = jsonReader.u(f17320b);
            if (u == 0) {
                z = jsonReader.i();
            } else if (u == 1) {
                list = JsonUtils.f(jsonReader, f2);
            } else if (u == 2) {
                list2 = JsonUtils.f(jsonReader, f2);
            } else if (u != 3) {
                jsonReader.v();
                jsonReader.w();
            } else {
                list3 = JsonUtils.f(jsonReader, f2);
            }
        }
        jsonReader.f();
        if (jsonReader.s() == JsonReader.Token.END_ARRAY) {
            jsonReader.e();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new ShapeData(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 1; i2 < size; i2++) {
                PointF pointF2 = list.get(i2);
                int i3 = i2 - 1;
                arrayList.add(new CubicCurveData(MiscUtils.a(list.get(i3), list3.get(i3)), MiscUtils.a(pointF2, list2.get(i2)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i4 = size - 1;
                arrayList.add(new CubicCurveData(MiscUtils.a(list.get(i4), list3.get(i4)), MiscUtils.a(pointF3, list2.get(0)), pointF3));
            }
            return new ShapeData(pointF, z, arrayList);
        }
    }
}
