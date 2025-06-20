package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiInputConnection extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f7791a;

    /* renamed from: b  reason: collision with root package name */
    private final EmojiCompatDeleteHelper f7792b;

    public static class EmojiCompatDeleteHelper {
        public boolean a(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, boolean z) {
            return EmojiCompat.j(inputConnection, editable, i2, i3, z);
        }

        public void b(@NonNull EditorInfo editorInfo) {
            if (EmojiCompat.q()) {
                EmojiCompat.c().G(editorInfo);
            }
        }
    }

    EmojiInputConnection(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new EmojiCompatDeleteHelper());
    }

    private Editable a() {
        return this.f7791a.getEditableText();
    }

    public boolean deleteSurroundingText(int i2, int i3) {
        return this.f7792b.a(this, a(), i2, i3, false) || super.deleteSurroundingText(i2, i3);
    }

    public boolean deleteSurroundingTextInCodePoints(int i2, int i3) {
        return this.f7792b.a(this, a(), i2, i3, true) || super.deleteSurroundingTextInCodePoints(i2, i3);
    }

    EmojiInputConnection(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull EmojiCompatDeleteHelper emojiCompatDeleteHelper) {
        super(inputConnection, false);
        this.f7791a = textView;
        this.f7792b = emojiCompatDeleteHelper;
        emojiCompatDeleteHelper.b(editorInfo);
    }
}
