package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

class KeyframeParser {

    /* renamed from: a  reason: collision with root package name */
    private static final float f17299a = 100.0f;

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f17300b = new LinearInterpolator();

    /* renamed from: c  reason: collision with root package name */
    private static SparseArrayCompat<WeakReference<Interpolator>> f17301c;

    /* renamed from: d  reason: collision with root package name */
    static JsonReader.Options f17302d = JsonReader.Options.a("t", "s", "e", "o", "i", CmcdData.Factory.f12510n, TypedValues.TransitionType.f4027d, "ti");

    KeyframeParser() {
    }

    @Nullable
    private static WeakReference<Interpolator> a(int i2) {
        WeakReference<Interpolator> h2;
        synchronized (KeyframeParser.class) {
            h2 = e().h(i2);
        }
        return h2;
    }

    static <T> Keyframe<T> b(JsonReader jsonReader, LottieComposition lottieComposition, float f2, ValueParser<T> valueParser, boolean z) throws IOException {
        return z ? c(lottieComposition, jsonReader, f2, valueParser) : d(jsonReader, f2, valueParser);
    }

    private static <T> Keyframe<T> c(LottieComposition lottieComposition, JsonReader jsonReader, float f2, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        T t;
        Interpolator b2;
        JsonReader jsonReader2 = jsonReader;
        float f3 = f2;
        ValueParser<T> valueParser2 = valueParser;
        jsonReader.d();
        Interpolator interpolator2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        T t2 = null;
        T t3 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z = false;
        float f4 = 0.0f;
        while (jsonReader.h()) {
            switch (jsonReader2.u(f17302d)) {
                case 0:
                    f4 = (float) jsonReader.k();
                    break;
                case 1:
                    t3 = valueParser2.a(jsonReader2, f3);
                    break;
                case 2:
                    t2 = valueParser2.a(jsonReader2, f3);
                    break;
                case 3:
                    pointF = JsonUtils.e(jsonReader, f2);
                    break;
                case 4:
                    pointF2 = JsonUtils.e(jsonReader, f2);
                    break;
                case 5:
                    if (jsonReader.n() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF4 = JsonUtils.e(jsonReader, f2);
                    break;
                case 7:
                    pointF3 = JsonUtils.e(jsonReader, f2);
                    break;
                default:
                    jsonReader.w();
                    break;
            }
        }
        jsonReader.f();
        if (z) {
            interpolator = f17300b;
            t = t3;
        } else {
            if (pointF == null || pointF2 == null) {
                interpolator = f17300b;
            } else {
                float f5 = -f3;
                pointF.x = MiscUtils.b(pointF.x, f5, f3);
                pointF.y = MiscUtils.b(pointF.y, -100.0f, f17299a);
                pointF2.x = MiscUtils.b(pointF2.x, f5, f3);
                float b3 = MiscUtils.b(pointF2.y, -100.0f, f17299a);
                pointF2.y = b3;
                int i2 = Utils.i(pointF.x, pointF.y, pointF2.x, b3);
                WeakReference<Interpolator> a2 = a(i2);
                if (a2 != null) {
                    interpolator2 = a2.get();
                }
                if (a2 == null || interpolator2 == null) {
                    pointF.x /= f3;
                    pointF.y /= f3;
                    float f6 = pointF2.x / f3;
                    pointF2.x = f6;
                    float f7 = pointF2.y / f3;
                    pointF2.y = f7;
                    try {
                        b2 = PathInterpolatorCompat.b(pointF.x, pointF.y, f6, f7);
                    } catch (IllegalArgumentException e2) {
                        b2 = e2.getMessage().equals("The Path cannot loop back on itself.") ? PathInterpolatorCompat.b(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
                    }
                    interpolator2 = b2;
                    try {
                        f(i2, new WeakReference(interpolator2));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
                interpolator = interpolator2;
            }
            t = t2;
        }
        Keyframe keyframe = new Keyframe(lottieComposition, t3, t, interpolator, f4, (Float) null);
        keyframe.f17366m = pointF4;
        keyframe.f17367n = pointF3;
        return keyframe;
    }

    private static <T> Keyframe<T> d(JsonReader jsonReader, float f2, ValueParser<T> valueParser) throws IOException {
        return new Keyframe<>(valueParser.a(jsonReader, f2));
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> e() {
        if (f17301c == null) {
            f17301c = new SparseArrayCompat<>();
        }
        return f17301c;
    }

    private static void f(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            f17301c.p(i2, weakReference);
        }
    }
}
