package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

public final class ProcessCompat {

    static class Api19Impl {

        /* renamed from: a  reason: collision with root package name */
        private static final Object f6073a = new Object();

        /* renamed from: b  reason: collision with root package name */
        private static Method f6074b;

        /* renamed from: c  reason: collision with root package name */
        private static boolean f6075c;

        private Api19Impl() {
        }

        @SuppressLint({"DiscouragedPrivateApi"})
        static boolean a(int i2) {
            try {
                synchronized (f6073a) {
                    if (!f6075c) {
                        f6075c = true;
                        f6074b = UserHandle.class.getDeclaredMethod("isApp", new Class[]{Integer.TYPE});
                    }
                }
                Method method = f6074b;
                if (method != null) {
                    Boolean bool = (Boolean) method.invoke((Object) null, new Object[]{Integer.valueOf(i2)});
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    throw new NullPointerException();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                while (true) {
                }
                throw th;
            }
            return true;
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean a(int i2) {
            return Process.isApplicationUid(i2);
        }
    }

    private ProcessCompat() {
    }

    public static boolean a(int i2) {
        return Build.VERSION.SDK_INT >= 24 ? Api24Impl.a(i2) : Api19Impl.a(i2);
    }
}
