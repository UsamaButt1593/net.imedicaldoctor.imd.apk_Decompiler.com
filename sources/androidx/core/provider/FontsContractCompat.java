package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.Executor;

public class FontsContractCompat {
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

    /* renamed from: a  reason: collision with root package name */
    public static final String f6103a = "font_results";
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

    /* renamed from: b  reason: collision with root package name */
    static final int f6104b = -1;
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

    /* renamed from: c  reason: collision with root package name */
    static final int f6105c = -2;

    public static final class Columns implements BaseColumns {

        /* renamed from: a  reason: collision with root package name */
        public static final String f6106a = "file_id";

        /* renamed from: b  reason: collision with root package name */
        public static final String f6107b = "font_ttc_index";

        /* renamed from: c  reason: collision with root package name */
        public static final String f6108c = "font_variation_settings";

        /* renamed from: d  reason: collision with root package name */
        public static final String f6109d = "font_weight";

        /* renamed from: e  reason: collision with root package name */
        public static final String f6110e = "font_italic";

        /* renamed from: f  reason: collision with root package name */
        public static final String f6111f = "result_code";

        /* renamed from: g  reason: collision with root package name */
        public static final int f6112g = 0;

        /* renamed from: h  reason: collision with root package name */
        public static final int f6113h = 1;

        /* renamed from: i  reason: collision with root package name */
        public static final int f6114i = 2;

        /* renamed from: j  reason: collision with root package name */
        public static final int f6115j = 3;
    }

    public static class FontFamilyResult {

        /* renamed from: c  reason: collision with root package name */
        public static final int f6116c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static final int f6117d = 1;

        /* renamed from: e  reason: collision with root package name */
        public static final int f6118e = 2;

        /* renamed from: a  reason: collision with root package name */
        private final int f6119a;

        /* renamed from: b  reason: collision with root package name */
        private final FontInfo[] f6120b;

        @Deprecated
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontFamilyResult(int i2, @Nullable FontInfo[] fontInfoArr) {
            this.f6119a = i2;
            this.f6120b = fontInfoArr;
        }

        static FontFamilyResult a(int i2, @Nullable FontInfo[] fontInfoArr) {
            return new FontFamilyResult(i2, fontInfoArr);
        }

        public FontInfo[] b() {
            return this.f6120b;
        }

        public int c() {
            return this.f6119a;
        }
    }

    public static class FontInfo {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f6121a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6122b;

        /* renamed from: c  reason: collision with root package name */
        private final int f6123c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f6124d;

        /* renamed from: e  reason: collision with root package name */
        private final int f6125e;

        @Deprecated
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontInfo(@NonNull Uri uri, @IntRange(from = 0) int i2, @IntRange(from = 1, to = 1000) int i3, boolean z, int i4) {
            this.f6121a = (Uri) Preconditions.l(uri);
            this.f6122b = i2;
            this.f6123c = i3;
            this.f6124d = z;
            this.f6125e = i4;
        }

        static FontInfo a(@NonNull Uri uri, @IntRange(from = 0) int i2, @IntRange(from = 1, to = 1000) int i3, boolean z, int i4) {
            return new FontInfo(uri, i2, i3, z, i4);
        }

        public int b() {
            return this.f6125e;
        }

        @IntRange(from = 0)
        public int c() {
            return this.f6122b;
        }

        @NonNull
        public Uri d() {
            return this.f6121a;
        }

        @IntRange(from = 1, to = 1000)
        public int e() {
            return this.f6123c;
        }

        public boolean f() {
            return this.f6124d;
        }
    }

    public static class FontRequestCallback {
        @Deprecated
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

        /* renamed from: a  reason: collision with root package name */
        public static final int f6126a = 0;

        /* renamed from: b  reason: collision with root package name */
        static final int f6127b = 0;

        /* renamed from: c  reason: collision with root package name */
        public static final int f6128c = -1;

        /* renamed from: d  reason: collision with root package name */
        public static final int f6129d = -2;

        /* renamed from: e  reason: collision with root package name */
        public static final int f6130e = -3;

        /* renamed from: f  reason: collision with root package name */
        public static final int f6131f = -4;

        /* renamed from: g  reason: collision with root package name */
        public static final int f6132g = 1;

        /* renamed from: h  reason: collision with root package name */
        public static final int f6133h = 2;

        /* renamed from: i  reason: collision with root package name */
        public static final int f6134i = 3;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Retention(RetentionPolicy.SOURCE)
        public @interface FontRequestFailReason {
        }

        public void a(int i2) {
        }

        public void b(Typeface typeface) {
        }
    }

    private FontsContractCompat() {
    }

    @Nullable
    public static Typeface a(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontInfo[] fontInfoArr) {
        return TypefaceCompat.d(context, cancellationSignal, fontInfoArr, 0);
    }

    @NonNull
    public static FontFamilyResult b(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        return FontProvider.e(context, fontRequest, cancellationSignal);
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface c(Context context, FontRequest fontRequest, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z, int i2, int i3) {
        return f(context, fontRequest, i3, z, i2, ResourcesCompat.FontCallback.e(handler), new TypefaceCompat.ResourcesCallbackAdapter(fontCallback));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    @Deprecated
    public static ProviderInfo d(@NonNull PackageManager packageManager, @NonNull FontRequest fontRequest, @Nullable Resources resources) throws PackageManager.NameNotFoundException {
        return FontProvider.f(packageManager, fontRequest, resources);
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Map<Uri, ByteBuffer> e(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        return TypefaceCompatUtil.h(context, fontInfoArr, cancellationSignal);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface f(@NonNull Context context, @NonNull FontRequest fontRequest, int i2, boolean z, @IntRange(from = 0) int i3, @NonNull Handler handler, @NonNull FontRequestCallback fontRequestCallback) {
        CallbackWithHandler callbackWithHandler = new CallbackWithHandler(fontRequestCallback, handler);
        return z ? FontRequestWorker.e(context, fontRequest, callbackWithHandler, i2, i3) : FontRequestWorker.d(context, fontRequest, i2, (Executor) null, callbackWithHandler);
    }

    public static void g(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        CallbackWithHandler callbackWithHandler = new CallbackWithHandler(fontRequestCallback);
        FontRequestWorker.d(context.getApplicationContext(), fontRequest, 0, RequestExecutor.b(handler), callbackWithHandler);
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void h() {
        FontRequestWorker.f();
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void i() {
        FontRequestWorker.f();
    }
}
