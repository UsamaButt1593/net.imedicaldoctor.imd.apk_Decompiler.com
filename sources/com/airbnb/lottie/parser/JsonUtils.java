package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class JsonUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f17297a = JsonReader.Options.a("x", "y");

    /* renamed from: com.airbnb.lottie.parser.JsonUtils$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17298a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.airbnb.lottie.parser.moshi.JsonReader$Token[] r0 = com.airbnb.lottie.parser.moshi.JsonReader.Token.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17298a = r0
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f17298a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f17298a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.JsonUtils.AnonymousClass1.<clinit>():void");
        }
    }

    private JsonUtils() {
    }

    private static PointF a(JsonReader jsonReader, float f2) throws IOException {
        jsonReader.c();
        float k2 = (float) jsonReader.k();
        float k3 = (float) jsonReader.k();
        while (jsonReader.s() != JsonReader.Token.END_ARRAY) {
            jsonReader.w();
        }
        jsonReader.e();
        return new PointF(k2 * f2, k3 * f2);
    }

    private static PointF b(JsonReader jsonReader, float f2) throws IOException {
        float k2 = (float) jsonReader.k();
        float k3 = (float) jsonReader.k();
        while (jsonReader.h()) {
            jsonReader.w();
        }
        return new PointF(k2 * f2, k3 * f2);
    }

    private static PointF c(JsonReader jsonReader, float f2) throws IOException {
        jsonReader.d();
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (jsonReader.h()) {
            int u = jsonReader.u(f17297a);
            if (u == 0) {
                f3 = g(jsonReader);
            } else if (u != 1) {
                jsonReader.v();
                jsonReader.w();
            } else {
                f4 = g(jsonReader);
            }
        }
        jsonReader.f();
        return new PointF(f3 * f2, f4 * f2);
    }

    @ColorInt
    static int d(JsonReader jsonReader) throws IOException {
        jsonReader.c();
        int k2 = (int) (jsonReader.k() * 255.0d);
        int k3 = (int) (jsonReader.k() * 255.0d);
        int k4 = (int) (jsonReader.k() * 255.0d);
        while (jsonReader.h()) {
            jsonReader.w();
        }
        jsonReader.e();
        return Color.argb(255, k2, k3, k4);
    }

    static PointF e(JsonReader jsonReader, float f2) throws IOException {
        int i2 = AnonymousClass1.f17298a[jsonReader.s().ordinal()];
        if (i2 == 1) {
            return b(jsonReader, f2);
        }
        if (i2 == 2) {
            return a(jsonReader, f2);
        }
        if (i2 == 3) {
            return c(jsonReader, f2);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.s());
    }

    static List<PointF> f(JsonReader jsonReader, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.c();
        while (jsonReader.s() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            arrayList.add(e(jsonReader, f2));
            jsonReader.e();
        }
        jsonReader.e();
        return arrayList;
    }

    static float g(JsonReader jsonReader) throws IOException {
        JsonReader.Token s = jsonReader.s();
        int i2 = AnonymousClass1.f17298a[s.ordinal()];
        if (i2 == 1) {
            return (float) jsonReader.k();
        }
        if (i2 == 2) {
            jsonReader.c();
            float k2 = (float) jsonReader.k();
            while (jsonReader.h()) {
                jsonReader.w();
            }
            jsonReader.e();
            return k2;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + s);
    }
}
