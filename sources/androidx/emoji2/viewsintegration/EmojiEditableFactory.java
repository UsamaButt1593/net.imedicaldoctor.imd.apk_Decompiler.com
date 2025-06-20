package androidx.emoji2.viewsintegration;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.emoji2.text.SpannableBuilder;

final class EmojiEditableFactory extends Editable.Factory {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f7788a = new Object();
    @GuardedBy("INSTANCE_LOCK")

    /* renamed from: b  reason: collision with root package name */
    private static volatile Editable.Factory f7789b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f7790c;

    @SuppressLint({"PrivateApi"})
    private EmojiEditableFactory() {
        try {
            f7790c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, EmojiEditableFactory.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f7789b == null) {
            synchronized (f7788a) {
                try {
                    if (f7789b == null) {
                        f7789b = new EmojiEditableFactory();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f7789b;
    }

    public Editable newEditable(@NonNull CharSequence charSequence) {
        Class<?> cls = f7790c;
        return cls != null ? SpannableBuilder.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
