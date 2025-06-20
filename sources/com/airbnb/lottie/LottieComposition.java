package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class LottieComposition {

    /* renamed from: a  reason: collision with root package name */
    private final PerformanceTracker f16683a = new PerformanceTracker();

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<String> f16684b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<Layer>> f16685c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, LottieImageAsset> f16686d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Font> f16687e;

    /* renamed from: f  reason: collision with root package name */
    private List<Marker> f16688f;

    /* renamed from: g  reason: collision with root package name */
    private SparseArrayCompat<FontCharacter> f16689g;

    /* renamed from: h  reason: collision with root package name */
    private LongSparseArray<Layer> f16690h;

    /* renamed from: i  reason: collision with root package name */
    private List<Layer> f16691i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f16692j;

    /* renamed from: k  reason: collision with root package name */
    private float f16693k;

    /* renamed from: l  reason: collision with root package name */
    private float f16694l;

    /* renamed from: m  reason: collision with root package name */
    private float f16695m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f16696n;
    private int o = 0;

    @Deprecated
    public static class Factory {

        private static final class ListenerAdapter implements LottieListener<LottieComposition>, Cancellable {

            /* renamed from: a  reason: collision with root package name */
            private final OnCompositionLoadedListener f16697a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f16698b;

            private ListenerAdapter(OnCompositionLoadedListener onCompositionLoadedListener) {
                this.f16698b = false;
                this.f16697a = onCompositionLoadedListener;
            }

            /* renamed from: a */
            public void onResult(LottieComposition lottieComposition) {
                if (!this.f16698b) {
                    this.f16697a.a(lottieComposition);
                }
            }

            public void cancel() {
                this.f16698b = true;
            }
        }

        private Factory() {
        }

        @Deprecated
        public static Cancellable a(Context context, String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.e(context, str).f(listenerAdapter);
            return listenerAdapter;
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static LottieComposition b(Context context, String str) {
            return LottieCompositionFactory.g(context, str).b();
        }

        @Deprecated
        public static Cancellable c(InputStream inputStream, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.j(inputStream, (String) null).f(listenerAdapter);
            return listenerAdapter;
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static LottieComposition d(InputStream inputStream) {
            return LottieCompositionFactory.k(inputStream, (String) null).b();
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static LottieComposition e(InputStream inputStream, boolean z) {
            if (z) {
                Logger.e("Lottie now auto-closes input stream!");
            }
            return LottieCompositionFactory.k(inputStream, (String) null).b();
        }

        @Deprecated
        public static Cancellable f(JsonReader jsonReader, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.m(jsonReader, (String) null).f(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static Cancellable g(String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.p(str, (String) null).f(listenerAdapter);
            return listenerAdapter;
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static LottieComposition h(Resources resources, JSONObject jSONObject) {
            return LottieCompositionFactory.r(jSONObject, (String) null).b();
        }

        @WorkerThread
        @Nullable
        @Deprecated
        public static LottieComposition i(JsonReader jsonReader) throws IOException {
            return LottieCompositionFactory.n(jsonReader, (String) null).b();
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static LottieComposition j(String str) {
            return LottieCompositionFactory.q(str, (String) null).b();
        }

        @Deprecated
        public static Cancellable k(Context context, @RawRes int i2, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.s(context, i2).f(listenerAdapter);
            return listenerAdapter;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        Logger.e(str);
        this.f16684b.add(str);
    }

    public Rect b() {
        return this.f16692j;
    }

    public SparseArrayCompat<FontCharacter> c() {
        return this.f16689g;
    }

    public float d() {
        return (float) ((long) ((e() / this.f16695m) * 1000.0f));
    }

    public float e() {
        return this.f16694l - this.f16693k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float f() {
        return this.f16694l;
    }

    public Map<String, Font> g() {
        return this.f16687e;
    }

    public float h() {
        return this.f16695m;
    }

    public Map<String, LottieImageAsset> i() {
        return this.f16686d;
    }

    public List<Layer> j() {
        return this.f16691i;
    }

    @Nullable
    public Marker k(String str) {
        this.f16688f.size();
        for (int i2 = 0; i2 < this.f16688f.size(); i2++) {
            Marker marker = this.f16688f.get(i2);
            if (marker.a(str)) {
                return marker;
            }
        }
        return null;
    }

    public List<Marker> l() {
        return this.f16688f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int m() {
        return this.o;
    }

    public PerformanceTracker n() {
        return this.f16683a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> o(String str) {
        return this.f16685c.get(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float p() {
        return this.f16693k;
    }

    public ArrayList<String> q() {
        HashSet<String> hashSet = this.f16684b;
        return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean r() {
        return this.f16696n;
    }

    public boolean s() {
        return !this.f16686d.isEmpty();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void t(int i2) {
        this.o += i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer w : this.f16691i) {
            sb.append(w.w("\t"));
        }
        return sb.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void u(Rect rect, float f2, float f3, float f4, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2, SparseArrayCompat<FontCharacter> sparseArrayCompat, Map<String, Font> map3, List<Marker> list2) {
        this.f16692j = rect;
        this.f16693k = f2;
        this.f16694l = f3;
        this.f16695m = f4;
        this.f16691i = list;
        this.f16690h = longSparseArray;
        this.f16685c = map;
        this.f16686d = map2;
        this.f16689g = sparseArrayCompat;
        this.f16687e = map3;
        this.f16688f = list2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer v(long j2) {
        return this.f16690h.h(j2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void w(boolean z) {
        this.f16696n = z;
    }

    public void x(boolean z) {
        this.f16683a.g(z);
    }
}
