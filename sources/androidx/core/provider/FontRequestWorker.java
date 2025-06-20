package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

class FontRequestWorker {

    /* renamed from: a  reason: collision with root package name */
    static final LruCache<String, Typeface> f6097a = new LruCache<>(16);

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f6098b = RequestExecutor.a("fonts-androidx", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    static final Object f6099c = new Object();
    @GuardedBy("LOCK")

    /* renamed from: d  reason: collision with root package name */
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> f6100d = new SimpleArrayMap<>();

    static final class TypefaceResult {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f6101a;

        /* renamed from: b  reason: collision with root package name */
        final int f6102b;

        TypefaceResult(int i2) {
            this.f6101a = null;
            this.f6102b = i2;
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.f6102b == 0;
        }

        @SuppressLint({"WrongConstant"})
        TypefaceResult(@NonNull Typeface typeface) {
            this.f6101a = typeface;
            this.f6102b = 0;
        }
    }

    private FontRequestWorker() {
    }

    private static String a(@NonNull FontRequest fontRequest, int i2) {
        return fontRequest.d() + "-" + i2;
    }

    @SuppressLint({"WrongConstant"})
    private static int b(@NonNull FontsContractCompat.FontFamilyResult fontFamilyResult) {
        int i2 = 1;
        if (fontFamilyResult.c() != 0) {
            return fontFamilyResult.c() != 1 ? -3 : -2;
        }
        FontsContractCompat.FontInfo[] b2 = fontFamilyResult.b();
        if (!(b2 == null || b2.length == 0)) {
            int length = b2.length;
            i2 = 0;
            int i3 = 0;
            while (i3 < length) {
                int b3 = b2[i3].b();
                if (b3 == 0) {
                    i3++;
                } else if (b3 < 0) {
                    return -3;
                } else {
                    return b3;
                }
            }
        }
        return i2;
    }

    @NonNull
    static TypefaceResult c(@NonNull String str, @NonNull Context context, @NonNull FontRequest fontRequest, int i2) {
        LruCache<String, Typeface> lruCache = f6097a;
        Typeface typeface = lruCache.get(str);
        if (typeface != null) {
            return new TypefaceResult(typeface);
        }
        try {
            FontsContractCompat.FontFamilyResult e2 = FontProvider.e(context, fontRequest, (CancellationSignal) null);
            int b2 = b(e2);
            if (b2 != 0) {
                return new TypefaceResult(b2);
            }
            Typeface d2 = TypefaceCompat.d(context, (CancellationSignal) null, e2.b(), i2);
            if (d2 == null) {
                return new TypefaceResult(-3);
            }
            lruCache.put(str, d2);
            return new TypefaceResult(d2);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(-1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        r9 = new androidx.core.provider.FontRequestWorker.AnonymousClass3();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r8 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        r8 = f6098b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        androidx.core.provider.RequestExecutor.c(r8, r9, new androidx.core.provider.FontRequestWorker.AnonymousClass4());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Typeface d(@androidx.annotation.NonNull final android.content.Context r5, @androidx.annotation.NonNull final androidx.core.provider.FontRequest r6, final int r7, @androidx.annotation.Nullable java.util.concurrent.Executor r8, @androidx.annotation.NonNull final androidx.core.provider.CallbackWithHandler r9) {
        /*
            java.lang.String r0 = a(r6, r7)
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r1 = f6097a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0017
            androidx.core.provider.FontRequestWorker$TypefaceResult r5 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r5.<init>((android.graphics.Typeface) r1)
            r9.b(r5)
            return r1
        L_0x0017:
            androidx.core.provider.FontRequestWorker$2 r1 = new androidx.core.provider.FontRequestWorker$2
            r1.<init>()
            java.lang.Object r9 = f6099c
            monitor-enter(r9)
            androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker$TypefaceResult>>> r2 = f6100d     // Catch:{ all -> 0x002f }
            java.lang.Object r3 = r2.get(r0)     // Catch:{ all -> 0x002f }
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ all -> 0x002f }
            r4 = 0
            if (r3 == 0) goto L_0x0031
            r3.add(r1)     // Catch:{ all -> 0x002f }
            monitor-exit(r9)     // Catch:{ all -> 0x002f }
            return r4
        L_0x002f:
            r5 = move-exception
            goto L_0x004f
        L_0x0031:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x002f }
            r3.<init>()     // Catch:{ all -> 0x002f }
            r3.add(r1)     // Catch:{ all -> 0x002f }
            r2.put(r0, r3)     // Catch:{ all -> 0x002f }
            monitor-exit(r9)     // Catch:{ all -> 0x002f }
            androidx.core.provider.FontRequestWorker$3 r9 = new androidx.core.provider.FontRequestWorker$3
            r9.<init>(r0, r5, r6, r7)
            if (r8 != 0) goto L_0x0046
            java.util.concurrent.ExecutorService r8 = f6098b
        L_0x0046:
            androidx.core.provider.FontRequestWorker$4 r5 = new androidx.core.provider.FontRequestWorker$4
            r5.<init>(r0)
            androidx.core.provider.RequestExecutor.c(r8, r9, r5)
            return r4
        L_0x004f:
            monitor-exit(r9)     // Catch:{ all -> 0x002f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontRequestWorker.d(android.content.Context, androidx.core.provider.FontRequest, int, java.util.concurrent.Executor, androidx.core.provider.CallbackWithHandler):android.graphics.Typeface");
    }

    static Typeface e(@NonNull final Context context, @NonNull final FontRequest fontRequest, @NonNull CallbackWithHandler callbackWithHandler, final int i2, int i3) {
        final String a2 = a(fontRequest, i2);
        Typeface typeface = f6097a.get(a2);
        if (typeface != null) {
            callbackWithHandler.b(new TypefaceResult(typeface));
            return typeface;
        } else if (i3 == -1) {
            TypefaceResult c2 = c(a2, context, fontRequest, i2);
            callbackWithHandler.b(c2);
            return c2.f6101a;
        } else {
            try {
                TypefaceResult typefaceResult = (TypefaceResult) RequestExecutor.d(f6098b, new Callable<TypefaceResult>() {
                    /* renamed from: a */
                    public TypefaceResult call() {
                        return FontRequestWorker.c(a2, context, fontRequest, i2);
                    }
                }, i3);
                callbackWithHandler.b(typefaceResult);
                return typefaceResult.f6101a;
            } catch (InterruptedException unused) {
                callbackWithHandler.b(new TypefaceResult(-3));
                return null;
            }
        }
    }

    static void f() {
        f6097a.evictAll();
    }
}
