package androidx.emoji2.viewsintegration;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

public final class EmojiEditTextHelper {

    /* renamed from: a  reason: collision with root package name */
    private final HelperInternal f7783a;

    /* renamed from: b  reason: collision with root package name */
    private int f7784b;

    /* renamed from: c  reason: collision with root package name */
    private int f7785c;

    static class HelperInternal {
        HelperInternal() {
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public KeyListener a(@Nullable KeyListener keyListener) {
            return keyListener;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public InputConnection c(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            return inputConnection;
        }

        /* access modifiers changed from: package-private */
        public void d(int i2) {
        }

        /* access modifiers changed from: package-private */
        public void e(boolean z) {
        }

        /* access modifiers changed from: package-private */
        public void f(int i2) {
        }
    }

    @RequiresApi(19)
    private static class HelperInternal19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final EditText f7786a;

        /* renamed from: b  reason: collision with root package name */
        private final EmojiTextWatcher f7787b;

        HelperInternal19(@NonNull EditText editText, boolean z) {
            this.f7786a = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText, z);
            this.f7787b = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            editText.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        /* access modifiers changed from: package-private */
        public KeyListener a(@Nullable KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new EmojiKeyListener(keyListener);
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f7787b.d();
        }

        /* access modifiers changed from: package-private */
        public InputConnection c(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            return inputConnection instanceof EmojiInputConnection ? inputConnection : new EmojiInputConnection(this.f7786a, inputConnection, editorInfo);
        }

        /* access modifiers changed from: package-private */
        public void d(int i2) {
            this.f7787b.f(i2);
        }

        /* access modifiers changed from: package-private */
        public void e(boolean z) {
            this.f7787b.g(z);
        }

        /* access modifiers changed from: package-private */
        public void f(int i2) {
            this.f7787b.h(i2);
        }
    }

    public EmojiEditTextHelper(@NonNull EditText editText) {
        this(editText, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int a() {
        return this.f7785c;
    }

    @Nullable
    public KeyListener b(@Nullable KeyListener keyListener) {
        return this.f7783a.a(keyListener);
    }

    public int c() {
        return this.f7784b;
    }

    public boolean d() {
        return this.f7783a.b();
    }

    @Nullable
    public InputConnection e(@Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f7783a.c(inputConnection, editorInfo);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void f(int i2) {
        this.f7785c = i2;
        this.f7783a.d(i2);
    }

    public void g(boolean z) {
        this.f7783a.e(z);
    }

    public void h(@IntRange(from = 0) int i2) {
        Preconditions.j(i2, "maxEmojiCount should be greater than 0");
        this.f7784b = i2;
        this.f7783a.f(i2);
    }

    public EmojiEditTextHelper(@NonNull EditText editText, boolean z) {
        this.f7784b = Integer.MAX_VALUE;
        this.f7785c = 0;
        Preconditions.m(editText, "editText cannot be null");
        this.f7783a = new HelperInternal19(editText, z);
    }
}
