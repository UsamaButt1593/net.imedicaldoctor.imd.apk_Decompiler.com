package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;

public final class HandlerCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6057a = "HandlerCompat";

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }

        public static Handler b(Looper looper, Handler.Callback callback) {
            return Handler.createAsync(looper, callback);
        }

        public static boolean c(Handler handler, Runnable runnable, Object obj, long j2) {
            return handler.postDelayed(runnable, obj, j2);
        }
    }

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        public static boolean a(Handler handler, Runnable runnable) {
            return handler.hasCallbacks(runnable);
        }
    }

    private HandlerCompat() {
    }

    @NonNull
    public static Handler a(@NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.a(looper);
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException e2) {
            Log.w(f6057a, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e2);
            return new Handler(looper);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException(cause);
            }
        }
    }

    @NonNull
    public static Handler b(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.b(looper, callback);
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, callback, Boolean.TRUE});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException e2) {
            Log.w(f6057a, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e2);
            return new Handler(looper, callback);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException(cause);
            }
        }
    }

    public static boolean c(@NonNull Handler handler, @NonNull Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.a(handler, runnable);
        }
        try {
            return ((Boolean) Handler.class.getMethod("hasCallbacks", new Class[]{Runnable.class}).invoke(handler, new Object[]{runnable})).booleanValue();
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException(cause);
            }
        } catch (IllegalAccessException | NoSuchMethodException | NullPointerException e3) {
            throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e3);
        }
    }

    public static boolean d(@NonNull Handler handler, @NonNull Runnable runnable, @Nullable Object obj, long j2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.c(handler, runnable, obj, j2);
        }
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = obj;
        return handler.sendMessageDelayed(obtain, j2);
    }
}
