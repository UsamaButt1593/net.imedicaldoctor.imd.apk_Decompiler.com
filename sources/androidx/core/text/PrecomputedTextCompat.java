package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class PrecomputedTextCompat implements Spannable {
    private static final char X2 = '\n';
    private static final Object Y2 = new Object();
    @GuardedBy("sLock")
    @NonNull
    private static Executor Z2;
    @NonNull
    private final Params X;
    @NonNull
    private final int[] Y;
    @Nullable
    private final PrecomputedText Z;
    @NonNull
    private final Spannable s;

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Spannable a(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }

    public static final class Params {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f6194a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f6195b;

        /* renamed from: c  reason: collision with root package name */
        private final int f6196c;

        /* renamed from: d  reason: collision with root package name */
        private final int f6197d;

        /* renamed from: e  reason: collision with root package name */
        final PrecomputedText.Params f6198e;

        public static class Builder {
            @NonNull

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f6199a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f6200b;

            /* renamed from: c  reason: collision with root package name */
            private int f6201c;

            /* renamed from: d  reason: collision with root package name */
            private int f6202d;

            public Builder(@NonNull TextPaint textPaint) {
                this.f6199a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f6201c = 1;
                    this.f6202d = 1;
                } else {
                    this.f6202d = 0;
                    this.f6201c = 0;
                }
                this.f6200b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            @NonNull
            public Params a() {
                return new Params(this.f6199a, this.f6200b, this.f6201c, this.f6202d);
            }

            @RequiresApi(23)
            public Builder b(int i2) {
                this.f6201c = i2;
                return this;
            }

            @RequiresApi(23)
            public Builder c(int i2) {
                this.f6202d = i2;
                return this;
            }

            public Builder d(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
                this.f6200b = textDirectionHeuristic;
                return this;
            }
        }

        @RequiresApi(28)
        public Params(@NonNull PrecomputedText.Params params) {
            this.f6194a = params.getTextPaint();
            this.f6195b = params.getTextDirection();
            this.f6196c = params.getBreakStrategy();
            this.f6197d = params.getHyphenationFrequency();
            this.f6198e = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean a(@NonNull Params params) {
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 >= 23 && (this.f6196c != params.b() || this.f6197d != params.c())) || this.f6194a.getTextSize() != params.e().getTextSize() || this.f6194a.getTextScaleX() != params.e().getTextScaleX() || this.f6194a.getTextSkewX() != params.e().getTextSkewX() || this.f6194a.getLetterSpacing() != params.e().getLetterSpacing() || !TextUtils.equals(this.f6194a.getFontFeatureSettings(), params.e().getFontFeatureSettings()) || this.f6194a.getFlags() != params.e().getFlags()) {
                return false;
            }
            if (i2 >= 24) {
                if (!this.f6194a.getTextLocales().equals(params.e().getTextLocales())) {
                    return false;
                }
            } else if (!this.f6194a.getTextLocale().equals(params.e().getTextLocale())) {
                return false;
            }
            return this.f6194a.getTypeface() == null ? params.e().getTypeface() == null : this.f6194a.getTypeface().equals(params.e().getTypeface());
        }

        @RequiresApi(23)
        public int b() {
            return this.f6196c;
        }

        @RequiresApi(23)
        public int c() {
            return this.f6197d;
        }

        @Nullable
        public TextDirectionHeuristic d() {
            return this.f6195b;
        }

        @NonNull
        public TextPaint e() {
            return this.f6194a;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return a(params) && this.f6195b == params.d();
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return ObjectsCompat.b(Float.valueOf(this.f6194a.getTextSize()), Float.valueOf(this.f6194a.getTextScaleX()), Float.valueOf(this.f6194a.getTextSkewX()), Float.valueOf(this.f6194a.getLetterSpacing()), Integer.valueOf(this.f6194a.getFlags()), this.f6194a.getTextLocales(), this.f6194a.getTypeface(), Boolean.valueOf(this.f6194a.isElegantTextHeight()), this.f6195b, Integer.valueOf(this.f6196c), Integer.valueOf(this.f6197d));
            }
            return ObjectsCompat.b(Float.valueOf(this.f6194a.getTextSize()), Float.valueOf(this.f6194a.getTextScaleX()), Float.valueOf(this.f6194a.getTextSkewX()), Float.valueOf(this.f6194a.getLetterSpacing()), Integer.valueOf(this.f6194a.getFlags()), this.f6194a.getTextLocale(), this.f6194a.getTypeface(), Boolean.valueOf(this.f6194a.isElegantTextHeight()), this.f6195b, Integer.valueOf(this.f6196c), Integer.valueOf(this.f6197d));
        }

        public String toString() {
            StringBuilder sb;
            Object textLocale;
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.f6194a.getTextSize());
            sb2.append(", textScaleX=" + this.f6194a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f6194a.getTextSkewX());
            int i2 = Build.VERSION.SDK_INT;
            sb2.append(", letterSpacing=" + this.f6194a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f6194a.isElegantTextHeight());
            if (i2 >= 24) {
                sb = new StringBuilder();
                sb.append(", textLocale=");
                textLocale = this.f6194a.getTextLocales();
            } else {
                sb = new StringBuilder();
                sb.append(", textLocale=");
                textLocale = this.f6194a.getTextLocale();
            }
            sb.append(textLocale);
            sb2.append(sb.toString());
            sb2.append(", typeface=" + this.f6194a.getTypeface());
            if (i2 >= 26) {
                sb2.append(", variationSettings=" + this.f6194a.getFontVariationSettings());
            }
            sb2.append(", textDir=" + this.f6195b);
            sb2.append(", breakStrategy=" + this.f6196c);
            sb2.append(", hyphenationFrequency=" + this.f6197d);
            sb2.append("}");
            return sb2.toString();
        }

        Params(@NonNull TextPaint textPaint, @NonNull TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            this.f6198e = Build.VERSION.SDK_INT >= 29 ? o.a(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build() : null;
            this.f6194a = textPaint;
            this.f6195b = textDirectionHeuristic;
            this.f6196c = i2;
            this.f6197d = i3;
        }
    }

    private static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        private static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
            private CharSequence X;
            private Params s;

            PrecomputedTextCallback(@NonNull Params params, @NonNull CharSequence charSequence) {
                this.s = params;
                this.X = charSequence;
            }

            /* renamed from: a */
            public PrecomputedTextCompat call() throws Exception {
                return PrecomputedTextCompat.a(this.X, this.s);
            }
        }

        PrecomputedTextFutureTask(@NonNull Params params, @NonNull CharSequence charSequence) {
            super(new PrecomputedTextCallback(params, charSequence));
        }
    }

    @RequiresApi(28)
    private PrecomputedTextCompat(@NonNull PrecomputedText precomputedText, @NonNull Params params) {
        this.s = Api28Impl.a(precomputedText);
        this.X = params;
        this.Y = null;
        this.Z = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    @SuppressLint({"WrongConstant"})
    public static PrecomputedTextCompat a(@NonNull CharSequence charSequence, @NonNull Params params) {
        PrecomputedText.Params params2;
        Preconditions.l(charSequence);
        Preconditions.l(params);
        try {
            Trace.beginSection("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && (params2 = params.f6198e) != null) {
                return new PrecomputedTextCompat(PrecomputedText.create(charSequence, params2), params);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i2 = 0;
            while (i2 < length) {
                int indexOf = TextUtils.indexOf(charSequence, 10, i2, length);
                i2 = indexOf < 0 ? length : indexOf + 1;
                arrayList.add(Integer.valueOf(i2));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                StaticLayout unused = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), params.e(), Integer.MAX_VALUE).setBreakStrategy(params.b()).setHyphenationFrequency(params.c()).setTextDirection(params.d()).build();
            } else {
                new StaticLayout(charSequence, params.e(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            PrecomputedTextCompat precomputedTextCompat = new PrecomputedTextCompat(charSequence, params, iArr);
            Trace.endSection();
            return precomputedTextCompat;
        } finally {
            Trace.endSection();
        }
    }

    @UiThread
    public static Future<PrecomputedTextCompat> g(@NonNull CharSequence charSequence, @NonNull Params params, @Nullable Executor executor) {
        PrecomputedTextFutureTask precomputedTextFutureTask = new PrecomputedTextFutureTask(params, charSequence);
        if (executor == null) {
            synchronized (Y2) {
                try {
                    if (Z2 == null) {
                        Z2 = Executors.newFixedThreadPool(1);
                    }
                    executor = Z2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        executor.execute(precomputedTextFutureTask);
        return precomputedTextFutureTask;
    }

    @IntRange(from = 0)
    public int b() {
        return Build.VERSION.SDK_INT >= 29 ? this.Z.getParagraphCount() : this.Y.length;
    }

    @IntRange(from = 0)
    public int c(@IntRange(from = 0) int i2) {
        Preconditions.g(i2, 0, b(), "paraIndex");
        return Build.VERSION.SDK_INT >= 29 ? this.Z.getParagraphEnd(i2) : this.Y[i2];
    }

    public char charAt(int i2) {
        return this.s.charAt(i2);
    }

    @IntRange(from = 0)
    public int d(@IntRange(from = 0) int i2) {
        Preconditions.g(i2, 0, b(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.Z.getParagraphStart(i2);
        }
        if (i2 == 0) {
            return 0;
        }
        return this.Y[i2 - 1];
    }

    @NonNull
    public Params e() {
        return this.X;
    }

    @RequiresApi(28)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PrecomputedText f() {
        if (i.a(this.s)) {
            return j.a(this.s);
        }
        return null;
    }

    public int getSpanEnd(Object obj) {
        return this.s.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.s.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.s.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? this.Z.getSpans(i2, i3, cls) : this.s.getSpans(i2, i3, cls);
    }

    public int length() {
        return this.s.length();
    }

    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.s.nextSpanTransition(i2, i3, cls);
    }

    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.Z.removeSpan(obj);
        } else {
            this.s.removeSpan(obj);
        }
    }

    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.Z.setSpan(obj, i2, i3, i4);
        } else {
            this.s.setSpan(obj, i2, i3, i4);
        }
    }

    public CharSequence subSequence(int i2, int i3) {
        return this.s.subSequence(i2, i3);
    }

    @NonNull
    public String toString() {
        return this.s.toString();
    }

    private PrecomputedTextCompat(@NonNull CharSequence charSequence, @NonNull Params params, @NonNull int[] iArr) {
        this.s = new SpannableString(charSequence);
        this.X = params;
        this.Y = iArr;
        this.Z = null;
    }
}
