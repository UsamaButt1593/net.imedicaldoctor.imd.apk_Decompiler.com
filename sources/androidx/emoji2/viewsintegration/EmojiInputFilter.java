package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiInputFilter implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f7793a;

    /* renamed from: b  reason: collision with root package name */
    private EmojiCompat.InitCallback f7794b;

    @RequiresApi(19)
    private static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<TextView> f7795a;

        /* renamed from: b  reason: collision with root package name */
        private final Reference<EmojiInputFilter> f7796b;

        InitCallbackImpl(TextView textView, EmojiInputFilter emojiInputFilter) {
            this.f7795a = new WeakReference(textView);
            this.f7796b = new WeakReference(emojiInputFilter);
        }

        private boolean c(@Nullable TextView textView, @Nullable InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        public void b() {
            CharSequence text;
            CharSequence x;
            super.b();
            TextView textView = this.f7795a.get();
            if (c(textView, this.f7796b.get()) && textView.isAttachedToWindow() && (text = textView.getText()) != (x = EmojiCompat.c().x(text))) {
                int selectionStart = Selection.getSelectionStart(x);
                int selectionEnd = Selection.getSelectionEnd(x);
                textView.setText(x);
                if (x instanceof Spannable) {
                    EmojiInputFilter.b((Spannable) x, selectionStart, selectionEnd);
                }
            }
        }
    }

    EmojiInputFilter(@NonNull TextView textView) {
        this.f7793a = textView;
    }

    private EmojiCompat.InitCallback a() {
        if (this.f7794b == null) {
            this.f7794b = new InitCallbackImpl(this.f7793a, this);
        }
        return this.f7794b;
    }

    static void b(Spannable spannable, int i2, int i3) {
        if (i2 >= 0 && i3 >= 0) {
            Selection.setSelection(spannable, i2, i3);
        } else if (i2 >= 0) {
            Selection.setSelection(spannable, i2);
        } else if (i3 >= 0) {
            Selection.setSelection(spannable, i3);
        }
    }

    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        if (this.f7793a.isInEditMode()) {
            return charSequence;
        }
        int i6 = EmojiCompat.c().i();
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 3) {
                    return charSequence;
                }
            } else if ((i5 == 0 && i4 == 0 && spanned.length() == 0 && charSequence == this.f7793a.getText()) || charSequence == null) {
                return charSequence;
            } else {
                if (!(i2 == 0 && i3 == charSequence.length())) {
                    charSequence = charSequence.subSequence(i2, i3);
                }
                return EmojiCompat.c().y(charSequence, 0, charSequence.length());
            }
        }
        EmojiCompat.c().B(a());
        return charSequence;
    }
}
