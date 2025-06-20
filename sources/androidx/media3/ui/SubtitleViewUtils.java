package androidx.media3.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.LanguageFeatureSpan;
import androidx.media3.common.util.Assertions;
import com.google.common.base.Predicate;

final class SubtitleViewUtils {
    private SubtitleViewUtils() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean c(Object obj) {
        return !(obj instanceof LanguageFeatureSpan);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean d(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    public static void e(Cue.Builder builder) {
        builder.b();
        if (builder.k() instanceof Spanned) {
            if (!(builder.k() instanceof Spannable)) {
                builder.A(SpannableString.valueOf(builder.k()));
            }
            g((Spannable) Assertions.g(builder.k()), new I());
        }
        f(builder);
    }

    public static void f(Cue.Builder builder) {
        builder.C(-3.4028235E38f, Integer.MIN_VALUE);
        if (builder.k() instanceof Spanned) {
            if (!(builder.k() instanceof Spannable)) {
                builder.A(SpannableString.valueOf(builder.k()));
            }
            g((Spannable) Assertions.g(builder.k()), new J());
        }
    }

    private static void g(Spannable spannable, Predicate<Object> predicate) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (predicate.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static float h(int i2, float f2, int i3, int i4) {
        float f3;
        if (f2 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i2 == 0) {
            f3 = (float) i4;
        } else if (i2 == 1) {
            f3 = (float) i3;
        } else if (i2 != 2) {
            return -3.4028235E38f;
        } else {
            return f2;
        }
        return f2 * f3;
    }
}
