package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LayerParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f17304a = JsonReader.Options.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", CmcdConfiguration.q, "w", CmcdData.Factory.f12510n, "ip", "op", "tm", "cl", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f17305b = JsonReader.Options.a("d", "a");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.Options f17306c = JsonReader.Options.a("nm");

    private LayerParser() {
    }

    public static Layer a(LottieComposition lottieComposition) {
        Rect b2 = lottieComposition.b();
        List emptyList = Collections.emptyList();
        Layer.LayerType layerType = Layer.LayerType.PRE_COMP;
        List emptyList2 = Collections.emptyList();
        AnimatableTransform animatableTransform = r4;
        AnimatableTransform animatableTransform2 = new AnimatableTransform();
        return new Layer(emptyList, lottieComposition, "__container", -1, layerType, -1, (String) null, emptyList2, animatableTransform, 0, 0, 0, 0.0f, 0.0f, b2.width(), b2.height(), (AnimatableTextFrame) null, (AnimatableTextProperties) null, Collections.emptyList(), Layer.MatteType.NONE, (AnimatableFloatValue) null, false);
    }

    public static Layer b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        JsonReader jsonReader2 = jsonReader;
        LottieComposition lottieComposition2 = lottieComposition;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.d();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        String str = "UNSET";
        String str2 = null;
        AnimatableTransform animatableTransform = null;
        AnimatableTextFrame animatableTextFrame = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue = null;
        long j2 = 0;
        long j3 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f4 = 1.0f;
        float f5 = 0.0f;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        String str3 = null;
        Layer.LayerType layerType = null;
        while (jsonReader.h()) {
            switch (jsonReader2.u(f17304a)) {
                case 0:
                    str = jsonReader.q();
                    continue;
                case 1:
                    j2 = (long) jsonReader.n();
                    continue;
                case 2:
                    str2 = jsonReader.q();
                    continue;
                case 3:
                    int n2 = jsonReader.n();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (n2 < layerType.ordinal()) {
                        layerType = Layer.LayerType.values()[n2];
                        break;
                    } else {
                        continue;
                    }
                case 4:
                    j3 = (long) jsonReader.n();
                    continue;
                case 5:
                    i2 = (int) (((float) jsonReader.n()) * Utils.e());
                    continue;
                case 6:
                    i3 = (int) (((float) jsonReader.n()) * Utils.e());
                    continue;
                case 7:
                    i4 = Color.parseColor(jsonReader.q());
                    continue;
                case 8:
                    animatableTransform = AnimatableTransformParser.g(jsonReader, lottieComposition);
                    continue;
                case 9:
                    matteType2 = Layer.MatteType.values()[jsonReader.n()];
                    lottieComposition2.t(1);
                    continue;
                case 10:
                    jsonReader.c();
                    while (jsonReader.h()) {
                        arrayList3.add(MaskParser.a(jsonReader, lottieComposition));
                    }
                    lottieComposition2.t(arrayList3.size());
                    break;
                case 11:
                    jsonReader.c();
                    while (jsonReader.h()) {
                        ContentModel a2 = ContentModelParser.a(jsonReader, lottieComposition);
                        if (a2 != null) {
                            arrayList4.add(a2);
                        }
                    }
                    break;
                case 12:
                    jsonReader.d();
                    while (jsonReader.h()) {
                        int u = jsonReader2.u(f17305b);
                        if (u == 0) {
                            animatableTextFrame = AnimatableValueParser.d(jsonReader, lottieComposition);
                        } else if (u != 1) {
                            jsonReader.v();
                            jsonReader.w();
                        } else {
                            jsonReader.c();
                            if (jsonReader.h()) {
                                animatableTextProperties = AnimatableTextPropertiesParser.a(jsonReader, lottieComposition);
                            }
                            while (jsonReader.h()) {
                                jsonReader.w();
                            }
                            jsonReader.e();
                        }
                    }
                    jsonReader.f();
                    continue;
                case 13:
                    jsonReader.c();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.h()) {
                        jsonReader.d();
                        while (jsonReader.h()) {
                            if (jsonReader2.u(f17306c) != 0) {
                                jsonReader.v();
                                jsonReader.w();
                            } else {
                                arrayList5.add(jsonReader.q());
                            }
                        }
                        jsonReader.f();
                    }
                    jsonReader.e();
                    lottieComposition2.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    continue;
                case 14:
                    f4 = (float) jsonReader.k();
                    continue;
                case 15:
                    f5 = (float) jsonReader.k();
                    continue;
                case 16:
                    i5 = (int) (((float) jsonReader.n()) * Utils.e());
                    continue;
                case 17:
                    i6 = (int) (((float) jsonReader.n()) * Utils.e());
                    continue;
                case 18:
                    f2 = (float) jsonReader.k();
                    continue;
                case 19:
                    f3 = (float) jsonReader.k();
                    continue;
                case 20:
                    animatableFloatValue = AnimatableValueParser.f(jsonReader2, lottieComposition2, false);
                    continue;
                case 21:
                    str3 = jsonReader.q();
                    continue;
                case 22:
                    z = jsonReader.i();
                    continue;
                default:
                    jsonReader.v();
                    jsonReader.w();
                    continue;
            }
            jsonReader.e();
        }
        jsonReader.f();
        float f6 = f2 / f4;
        float f7 = f3 / f4;
        ArrayList arrayList6 = new ArrayList();
        if (f6 > 0.0f) {
            Keyframe keyframe = r0;
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            Keyframe keyframe2 = new Keyframe(lottieComposition, valueOf2, valueOf2, (Interpolator) null, 0.0f, Float.valueOf(f6));
            arrayList2.add(keyframe);
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f7 <= 0.0f) {
            f7 = lottieComposition.f();
        }
        LottieComposition lottieComposition3 = lottieComposition;
        arrayList2.add(new Keyframe(lottieComposition3, valueOf, valueOf, (Interpolator) null, f6, Float.valueOf(f7)));
        arrayList2.add(new Keyframe(lottieComposition3, valueOf2, valueOf2, (Interpolator) null, f7, Float.valueOf(Float.MAX_VALUE)));
        if (str.endsWith(".ai") || "ai".equals(str3)) {
            lottieComposition2.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, lottieComposition, str, j2, layerType, j3, str2, arrayList, animatableTransform, i2, i3, i4, f4, f5, i5, i6, animatableTextFrame, animatableTextProperties, arrayList2, matteType2, animatableFloatValue, z);
    }
}
