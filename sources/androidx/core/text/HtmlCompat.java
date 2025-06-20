package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@SuppressLint({"InlinedApi"})
public final class HtmlCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6180a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f6181b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6182c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f6183d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f6184e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f6185f = 8;

    /* renamed from: g  reason: collision with root package name */
    public static final int f6186g = 16;

    /* renamed from: h  reason: collision with root package name */
    public static final int f6187h = 32;

    /* renamed from: i  reason: collision with root package name */
    public static final int f6188i = 256;

    /* renamed from: j  reason: collision with root package name */
    public static final int f6189j = 0;

    /* renamed from: k  reason: collision with root package name */
    public static final int f6190k = 63;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Spanned a(String str, int i2) {
            return Html.fromHtml(str, i2);
        }

        @DoNotInline
        static Spanned b(String str, int i2, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i2, imageGetter, tagHandler);
        }

        @DoNotInline
        static String c(Spanned spanned, int i2) {
            return Html.toHtml(spanned, i2);
        }
    }

    private HtmlCompat() {
    }

    @NonNull
    public static Spanned a(@NonNull String str, int i2) {
        return Build.VERSION.SDK_INT >= 24 ? Api24Impl.a(str, i2) : Html.fromHtml(str);
    }

    @NonNull
    public static Spanned b(@NonNull String str, int i2, @Nullable Html.ImageGetter imageGetter, @Nullable Html.TagHandler tagHandler) {
        return Build.VERSION.SDK_INT >= 24 ? Api24Impl.b(str, i2, imageGetter, tagHandler) : Html.fromHtml(str, imageGetter, tagHandler);
    }

    @NonNull
    public static String c(@NonNull Spanned spanned, int i2) {
        return Build.VERSION.SDK_INT >= 24 ? Api24Impl.c(spanned, i2) : Html.toHtml(spanned);
    }
}
