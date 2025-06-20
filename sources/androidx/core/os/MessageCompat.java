package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class MessageCompat {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6068a = true;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f6069b = true;

    @RequiresApi(22)
    static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        static boolean a(Message message) {
            return message.isAsynchronous();
        }

        @DoNotInline
        static void b(Message message, boolean z) {
            message.setAsynchronous(z);
        }
    }

    private MessageCompat() {
    }

    @SuppressLint({"NewApi"})
    public static boolean a(@NonNull Message message) {
        if (Build.VERSION.SDK_INT >= 22) {
            return Api22Impl.a(message);
        }
        if (f6069b) {
            try {
                return Api22Impl.a(message);
            } catch (NoSuchMethodError unused) {
                f6069b = false;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static void b(@NonNull Message message, boolean z) {
        if (Build.VERSION.SDK_INT >= 22) {
            Api22Impl.b(message, z);
        } else if (f6068a) {
            try {
                Api22Impl.b(message, z);
            } catch (NoSuchMethodError unused) {
                f6068a = false;
            }
        }
    }
}
