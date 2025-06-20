package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

class AppCompatEmojiEditTextHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final EditText f3091a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final EmojiEditTextHelper f3092b;

    AppCompatEmojiEditTextHelper(@NonNull EditText editText) {
        this.f3091a = editText;
        this.f3092b = new EmojiEditTextHelper(editText, false);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public KeyListener a(@Nullable KeyListener keyListener) {
        return b(keyListener) ? this.f3092b.b(keyListener) : keyListener;
    }

    /* access modifiers changed from: package-private */
    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f3092b.d();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void d(@Nullable AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = this.f3091a.getContext().obtainStyledAttributes(attributeSet, R.styleable.v0, i2, 0);
        try {
            int i3 = R.styleable.K0;
            boolean z = true;
            if (obtainStyledAttributes.hasValue(i3)) {
                z = obtainStyledAttributes.getBoolean(i3, true);
            }
            obtainStyledAttributes.recycle();
            f(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public InputConnection e(@Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        return this.f3092b.e(inputConnection, editorInfo);
    }

    /* access modifiers changed from: package-private */
    public void f(boolean z) {
        this.f3092b.g(z);
    }
}
