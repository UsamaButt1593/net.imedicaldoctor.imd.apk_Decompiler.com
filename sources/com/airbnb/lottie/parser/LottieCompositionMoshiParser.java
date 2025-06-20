package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.itextpdf.tool.xml.css.CSS;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottieCompositionMoshiParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f17307a = JsonReader.Options.a("w", CmcdData.Factory.f12510n, "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b  reason: collision with root package name */
    static JsonReader.Options f17308b = JsonReader.Options.a("id", "layers", "w", CmcdData.Factory.f12510n, "p", "u");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.Options f17309c = JsonReader.Options.a("list");

    /* renamed from: d  reason: collision with root package name */
    private static final JsonReader.Options f17310d = JsonReader.Options.a(CSS.Value.j0, "tm", "dr");

    public static LottieComposition a(JsonReader jsonReader) throws IOException {
        HashMap hashMap;
        ArrayList arrayList;
        JsonReader jsonReader2 = jsonReader;
        float e2 = Utils.e();
        LongSparseArray longSparseArray = new LongSparseArray();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.d();
        int i2 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i3 = 0;
        while (jsonReader.h()) {
            switch (jsonReader2.u(f17307a)) {
                case 0:
                    HashMap hashMap5 = hashMap4;
                    ArrayList arrayList4 = arrayList3;
                    i2 = jsonReader.n();
                    continue;
                case 1:
                    HashMap hashMap6 = hashMap4;
                    ArrayList arrayList5 = arrayList3;
                    i3 = jsonReader.n();
                    continue;
                case 2:
                    HashMap hashMap7 = hashMap4;
                    ArrayList arrayList6 = arrayList3;
                    f2 = (float) jsonReader.k();
                    continue;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f3 = ((float) jsonReader.k()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f4 = (float) jsonReader.k();
                    break;
                case 5:
                    String[] split = jsonReader.q().split("\\.");
                    if (Utils.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        break;
                    } else {
                        lottieComposition.a("Lottie only supports bodymovin >= 4.4.0");
                        continue;
                    }
                case 6:
                    e(jsonReader2, lottieComposition, arrayList2, longSparseArray);
                    continue;
                case 7:
                    b(jsonReader2, lottieComposition, hashMap2, hashMap3);
                    continue;
                case 8:
                    d(jsonReader2, hashMap4);
                    continue;
                case 9:
                    c(jsonReader2, lottieComposition, sparseArrayCompat);
                    continue;
                case 10:
                    f(jsonReader2, lottieComposition, arrayList3);
                    continue;
                default:
                    jsonReader.v();
                    jsonReader.w();
                    continue;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            jsonReader2 = jsonReader;
        }
        ArrayList arrayList7 = arrayList3;
        lottieComposition.u(new Rect(0, 0, (int) (((float) i2) * e2), (int) (((float) i3) * e2)), f2, f3, f4, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return lottieComposition;
    }

    private static void b(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2) throws IOException {
        jsonReader.c();
        while (jsonReader.h()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.d();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i2 = 0;
            int i3 = 0;
            while (jsonReader.h()) {
                int u = jsonReader.u(f17308b);
                if (u == 0) {
                    str = jsonReader.q();
                } else if (u == 1) {
                    jsonReader.c();
                    while (jsonReader.h()) {
                        Layer b2 = LayerParser.b(jsonReader, lottieComposition);
                        longSparseArray.p(b2.b(), b2);
                        arrayList.add(b2);
                    }
                    jsonReader.e();
                } else if (u == 2) {
                    i2 = jsonReader.n();
                } else if (u == 3) {
                    i3 = jsonReader.n();
                } else if (u == 4) {
                    str2 = jsonReader.q();
                } else if (u != 5) {
                    jsonReader.v();
                    jsonReader.w();
                } else {
                    str3 = jsonReader.q();
                }
            }
            jsonReader.f();
            if (str2 != null) {
                LottieImageAsset lottieImageAsset = new LottieImageAsset(i2, i3, str, str2, str3);
                map2.put(lottieImageAsset.e(), lottieImageAsset);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.e();
    }

    private static void c(JsonReader jsonReader, LottieComposition lottieComposition, SparseArrayCompat<FontCharacter> sparseArrayCompat) throws IOException {
        jsonReader.c();
        while (jsonReader.h()) {
            FontCharacter a2 = FontCharacterParser.a(jsonReader, lottieComposition);
            sparseArrayCompat.p(a2.hashCode(), a2);
        }
        jsonReader.e();
    }

    private static void d(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        jsonReader.d();
        while (jsonReader.h()) {
            if (jsonReader.u(f17309c) != 0) {
                jsonReader.v();
                jsonReader.w();
            } else {
                jsonReader.c();
                while (jsonReader.h()) {
                    Font a2 = FontParser.a(jsonReader);
                    map.put(a2.c(), a2);
                }
                jsonReader.e();
            }
        }
        jsonReader.f();
    }

    private static void e(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.c();
        int i2 = 0;
        while (jsonReader.h()) {
            Layer b2 = LayerParser.b(jsonReader, lottieComposition);
            if (b2.d() == Layer.LayerType.IMAGE) {
                i2++;
            }
            list.add(b2);
            longSparseArray.p(b2.b(), b2);
            if (i2 > 4) {
                Logger.e("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.e();
    }

    private static void f(JsonReader jsonReader, LottieComposition lottieComposition, List<Marker> list) throws IOException {
        jsonReader.c();
        while (jsonReader.h()) {
            jsonReader.d();
            float f2 = 0.0f;
            String str = null;
            float f3 = 0.0f;
            while (jsonReader.h()) {
                int u = jsonReader.u(f17310d);
                if (u == 0) {
                    str = jsonReader.q();
                } else if (u == 1) {
                    f2 = (float) jsonReader.k();
                } else if (u != 2) {
                    jsonReader.v();
                    jsonReader.w();
                } else {
                    f3 = (float) jsonReader.k();
                }
            }
            jsonReader.f();
            list.add(new Marker(str, f2, f3));
        }
        jsonReader.e();
    }
}
