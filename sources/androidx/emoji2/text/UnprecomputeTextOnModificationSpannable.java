package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.text.i;
import java.util.stream.IntStream;

class UnprecomputeTextOnModificationSpannable implements Spannable {
    @NonNull
    private Spannable X;
    private boolean s = false;

    @RequiresApi(24)
    private static class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
        }

        static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    static class PrecomputedTextDetector {
        PrecomputedTextDetector() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }
    }

    @RequiresApi(28)
    static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        PrecomputedTextDetector_28() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(CharSequence charSequence) {
            return i.a(charSequence) || (charSequence instanceof PrecomputedTextCompat);
        }
    }

    UnprecomputeTextOnModificationSpannable(@NonNull Spannable spannable) {
        this.X = spannable;
    }

    private void a() {
        Spannable spannable = this.X;
        if (!this.s && c().a(spannable)) {
            this.X = new SpannableString(spannable);
        }
        this.s = true;
    }

    static PrecomputedTextDetector c() {
        return Build.VERSION.SDK_INT < 28 ? new PrecomputedTextDetector() : new PrecomputedTextDetector_28();
    }

    /* access modifiers changed from: package-private */
    public Spannable b() {
        return this.X;
    }

    public char charAt(int i2) {
        return this.X.charAt(i2);
    }

    @RequiresApi(api = 24)
    @NonNull
    public IntStream chars() {
        return CharSequenceHelper_API24.a(this.X);
    }

    @RequiresApi(api = 24)
    @NonNull
    public IntStream codePoints() {
        return CharSequenceHelper_API24.b(this.X);
    }

    public int getSpanEnd(Object obj) {
        return this.X.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.X.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.X.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        return this.X.getSpans(i2, i3, cls);
    }

    public int length() {
        return this.X.length();
    }

    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.X.nextSpanTransition(i2, i3, cls);
    }

    public void removeSpan(Object obj) {
        a();
        this.X.removeSpan(obj);
    }

    public void setSpan(Object obj, int i2, int i3, int i4) {
        a();
        this.X.setSpan(obj, i2, i3, i4);
    }

    @NonNull
    public CharSequence subSequence(int i2, int i3) {
        return this.X.subSequence(i2, i3);
    }

    @NonNull
    public String toString() {
        return this.X.toString();
    }

    UnprecomputeTextOnModificationSpannable(@NonNull Spanned spanned) {
        this.X = new SpannableString(spanned);
    }

    UnprecomputeTextOnModificationSpannable(@NonNull CharSequence charSequence) {
        this.X = new SpannableString(charSequence);
    }
}
