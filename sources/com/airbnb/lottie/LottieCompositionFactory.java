package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.Okio;
import org.json.JSONObject;

public class LottieCompositionFactory {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, LottieTask<LottieComposition>> f16699a = new HashMap();

    private LottieCompositionFactory() {
    }

    public static LottieTask<LottieComposition> A(final ZipInputStream zipInputStream, @Nullable final String str) {
        return b(str, new Callable<LottieResult<LottieComposition>>() {
            /* renamed from: a */
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.B(zipInputStream, str);
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> B(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return C(zipInputStream, str);
        } finally {
            Utils.c(zipInputStream);
        }
    }

    @WorkerThread
    private static LottieResult<LottieComposition> C(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (!name.contains("__MACOSX")) {
                    if (nextEntry.getName().contains(".json")) {
                        lottieComposition = o(JsonReader.r(Okio.e(Okio.u(zipInputStream))), (String) null, false).b();
                    } else if (name.contains(".png") || name.contains(".webp")) {
                        String[] split = name.split("/");
                        hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                    nextEntry = zipInputStream.getNextEntry();
                }
                zipInputStream.closeEntry();
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                LottieImageAsset d2 = d(lottieComposition, (String) entry.getKey());
                if (d2 != null) {
                    d2.g(Utils.m((Bitmap) entry.getValue(), d2.f(), d2.d()));
                }
            }
            for (Map.Entry next : lottieComposition.i().entrySet()) {
                if (((LottieImageAsset) next.getValue()).a() == null) {
                    return new LottieResult<>((Throwable) new IllegalStateException("There is no image for " + ((LottieImageAsset) next.getValue()).c()));
                }
            }
            if (str != null) {
                LottieCompositionCache.c().d(str, lottieComposition);
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e2) {
            return new LottieResult<>((Throwable) e2);
        }
    }

    private static boolean D(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static String E(Context context, @RawRes int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(D(context) ? "_night_" : "_day_");
        sb.append(i2);
        return sb.toString();
    }

    public static void F(int i2) {
        LottieCompositionCache.c().e(i2);
    }

    private static LottieTask<LottieComposition> b(@Nullable final String str, Callable<LottieResult<LottieComposition>> callable) {
        final LottieComposition b2 = str == null ? null : LottieCompositionCache.c().b(str);
        if (b2 != null) {
            return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() {
                /* renamed from: a */
                public LottieResult<LottieComposition> call() {
                    return new LottieResult<>(LottieComposition.this);
                }
            });
        }
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = f16699a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
        if (str != null) {
            lottieTask.f(new LottieListener<LottieComposition>() {
                /* renamed from: a */
                public void onResult(LottieComposition lottieComposition) {
                    LottieCompositionFactory.f16699a.remove(str);
                }
            });
            lottieTask.e(new LottieListener<Throwable>() {
                /* renamed from: a */
                public void onResult(Throwable th) {
                    LottieCompositionFactory.f16699a.remove(str);
                }
            });
            f16699a.put(str, lottieTask);
        }
        return lottieTask;
    }

    public static void c(Context context) {
        f16699a.clear();
        LottieCompositionCache.c().a();
        new NetworkCache(context).a();
    }

    @Nullable
    private static LottieImageAsset d(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset next : lottieComposition.i().values()) {
            if (next.c().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static LottieTask<LottieComposition> e(Context context, String str) {
        return f(context, str, "asset_" + str);
    }

    public static LottieTask<LottieComposition> f(Context context, final String str, @Nullable final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return b(str2, new Callable<LottieResult<LottieComposition>>() {
            /* renamed from: a */
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.h(applicationContext, str, str2);
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> g(Context context, String str) {
        return h(context, str, "asset_" + str);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> h(Context context, String str, @Nullable String str2) {
        try {
            return str.endsWith(".zip") ? B(new ZipInputStream(context.getAssets().open(str)), str2) : k(context.getAssets().open(str), str2);
        } catch (IOException e2) {
            return new LottieResult<>((Throwable) e2);
        }
    }

    @Deprecated
    public static LottieTask<LottieComposition> i(final JSONObject jSONObject, @Nullable final String str) {
        return b(str, new Callable<LottieResult<LottieComposition>>() {
            /* renamed from: a */
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.r(jSONObject, str);
            }
        });
    }

    public static LottieTask<LottieComposition> j(final InputStream inputStream, @Nullable final String str) {
        return b(str, new Callable<LottieResult<LottieComposition>>() {
            /* renamed from: a */
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.k(inputStream, str);
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> k(InputStream inputStream, @Nullable String str) {
        return l(inputStream, str, true);
    }

    @WorkerThread
    private static LottieResult<LottieComposition> l(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return n(JsonReader.r(Okio.e(Okio.u(inputStream))), str);
        } finally {
            if (z) {
                Utils.c(inputStream);
            }
        }
    }

    public static LottieTask<LottieComposition> m(final JsonReader jsonReader, @Nullable final String str) {
        return b(str, new Callable<LottieResult<LottieComposition>>() {
            /* renamed from: a */
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.n(JsonReader.this, str);
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> n(JsonReader jsonReader, @Nullable String str) {
        return o(jsonReader, str, true);
    }

    private static LottieResult<LottieComposition> o(JsonReader jsonReader, @Nullable String str, boolean z) {
        try {
            LottieComposition a2 = LottieCompositionMoshiParser.a(jsonReader);
            if (str != null) {
                LottieCompositionCache.c().d(str, a2);
            }
            LottieResult<LottieComposition> lottieResult = new LottieResult<>(a2);
            if (z) {
                Utils.c(jsonReader);
            }
            return lottieResult;
        } catch (Exception e2) {
            LottieResult<LottieComposition> lottieResult2 = new LottieResult<>((Throwable) e2);
            if (z) {
                Utils.c(jsonReader);
            }
            return lottieResult2;
        } catch (Throwable th) {
            if (z) {
                Utils.c(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask<LottieComposition> p(final String str, @Nullable final String str2) {
        return b(str2, new Callable<LottieResult<LottieComposition>>() {
            /* renamed from: a */
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.q(str, str2);
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> q(String str, @Nullable String str2) {
        return n(JsonReader.r(Okio.e(Okio.u(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    @WorkerThread
    @Deprecated
    public static LottieResult<LottieComposition> r(JSONObject jSONObject, @Nullable String str) {
        return q(jSONObject.toString(), str);
    }

    public static LottieTask<LottieComposition> s(Context context, @RawRes int i2) {
        return t(context, i2, E(context, i2));
    }

    public static LottieTask<LottieComposition> t(Context context, @RawRes final int i2, @Nullable String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return b(str, new Callable<LottieResult<LottieComposition>>() {
            /* renamed from: a */
            public LottieResult<LottieComposition> call() {
                Context context = (Context) weakReference.get();
                if (context == null) {
                    context = applicationContext;
                }
                return LottieCompositionFactory.u(context, i2);
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> u(Context context, @RawRes int i2) {
        return v(context, i2, E(context, i2));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> v(Context context, @RawRes int i2, @Nullable String str) {
        try {
            return k(context.getResources().openRawResource(i2), str);
        } catch (Resources.NotFoundException e2) {
            return new LottieResult<>((Throwable) e2);
        }
    }

    public static LottieTask<LottieComposition> w(Context context, String str) {
        return x(context, str, "url_" + str);
    }

    public static LottieTask<LottieComposition> x(final Context context, final String str, @Nullable final String str2) {
        return b(str2, new Callable<LottieResult<LottieComposition>>() {
            /* renamed from: a */
            public LottieResult<LottieComposition> call() {
                return NetworkFetcher.e(context, str, str2);
            }
        });
    }

    @WorkerThread
    public static LottieResult<LottieComposition> y(Context context, String str) {
        return z(context, str, str);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> z(Context context, String str, @Nullable String str2) {
        return NetworkFetcher.e(context, str, str2);
    }
}
