package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class DialogCompat {

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static <T> T a(Dialog dialog, int i2) {
            return dialog.requireViewById(i2);
        }
    }

    private DialogCompat() {
    }

    @NonNull
    public static View a(@NonNull Dialog dialog, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) Api28Impl.a(dialog, i2);
        }
        View findViewById = dialog.findViewById(i2);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
    }
}
