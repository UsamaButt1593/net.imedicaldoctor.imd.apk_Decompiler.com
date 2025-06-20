package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiKeyListener implements KeyListener {

    /* renamed from: a  reason: collision with root package name */
    private final KeyListener f7797a;

    /* renamed from: b  reason: collision with root package name */
    private final EmojiCompatHandleKeyDownHelper f7798b;

    public static class EmojiCompatHandleKeyDownHelper {
        public boolean a(@NonNull Editable editable, int i2, @NonNull KeyEvent keyEvent) {
            return EmojiCompat.k(editable, i2, keyEvent);
        }
    }

    EmojiKeyListener(KeyListener keyListener) {
        this(keyListener, new EmojiCompatHandleKeyDownHelper());
    }

    public void clearMetaKeyState(View view, Editable editable, int i2) {
        this.f7797a.clearMetaKeyState(view, editable, i2);
    }

    public int getInputType() {
        return this.f7797a.getInputType();
    }

    public boolean onKeyDown(View view, Editable editable, int i2, KeyEvent keyEvent) {
        return this.f7798b.a(editable, i2, keyEvent) || this.f7797a.onKeyDown(view, editable, i2, keyEvent);
    }

    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f7797a.onKeyOther(view, editable, keyEvent);
    }

    public boolean onKeyUp(View view, Editable editable, int i2, KeyEvent keyEvent) {
        return this.f7797a.onKeyUp(view, editable, i2, keyEvent);
    }

    EmojiKeyListener(KeyListener keyListener, EmojiCompatHandleKeyDownHelper emojiCompatHandleKeyDownHelper) {
        this.f7797a = keyListener;
        this.f7798b = emojiCompatHandleKeyDownHelper;
    }
}
