package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiTextWatcher implements TextWatcher {
    private final boolean X;
    private int X2 = 0;
    private EmojiCompat.InitCallback Y;
    private boolean Y2;
    private int Z = Integer.MAX_VALUE;
    private final EditText s;

    @RequiresApi(19)
    private static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<EditText> f7804a;

        InitCallbackImpl(EditText editText) {
            this.f7804a = new WeakReference(editText);
        }

        public void b() {
            super.b();
            EmojiTextWatcher.e(this.f7804a.get(), 1);
        }
    }

    EmojiTextWatcher(EditText editText, boolean z) {
        this.s = editText;
        this.X = z;
        this.Y2 = true;
    }

    private EmojiCompat.InitCallback b() {
        if (this.Y == null) {
            this.Y = new InitCallbackImpl(this.s);
        }
        return this.Y;
    }

    static void e(@Nullable EditText editText, int i2) {
        if (i2 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.c().x(editableText);
            EmojiInputFilter.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean i() {
        return !this.Y2 || (!this.X && !EmojiCompat.q());
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.X2;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.Z;
    }

    public boolean d() {
        return this.Y2;
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) {
        this.X2 = i2;
    }

    public void g(boolean z) {
        if (this.Y2 != z) {
            if (this.Y != null) {
                EmojiCompat.c().F(this.Y);
            }
            this.Y2 = z;
            if (z) {
                e(this.s, EmojiCompat.c().i());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h(int i2) {
        this.Z = i2;
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (!this.s.isInEditMode() && !i() && i3 <= i4 && (charSequence instanceof Spannable)) {
            int i5 = EmojiCompat.c().i();
            if (i5 != 0) {
                if (i5 == 1) {
                    EmojiCompat.c().A((Spannable) charSequence, i2, i2 + i4, this.Z, this.X2);
                    return;
                } else if (i5 != 3) {
                    return;
                }
            }
            EmojiCompat.c().B(b());
        }
    }
}
