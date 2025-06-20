package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserHandleCompat {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static Method f6082a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static Constructor<UserHandle> f6083b;

    @RequiresApi(24)
    private static class Api24Impl {
        private Api24Impl() {
        }

        @NonNull
        static UserHandle a(int i2) {
            return UserHandle.getUserHandleForUid(i2);
        }
    }

    private UserHandleCompat() {
    }

    private static Method a() throws NoSuchMethodException {
        if (f6082a == null) {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("getUserId", new Class[]{Integer.TYPE});
            f6082a = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return f6082a;
    }

    private static Constructor<UserHandle> b() throws NoSuchMethodException {
        if (f6083b == null) {
            Constructor<UserHandle> declaredConstructor = UserHandle.class.getDeclaredConstructor(new Class[]{Integer.TYPE});
            f6083b = declaredConstructor;
            declaredConstructor.setAccessible(true);
        }
        return f6083b;
    }

    @NonNull
    public static UserHandle c(int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.a(i2);
        }
        try {
            Method a2 = a();
            Object[] objArr = {Integer.valueOf(i2)};
            return b().newInstance(new Object[]{(Integer) a2.invoke((Object) null, objArr)});
        } catch (NoSuchMethodException e2) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e2);
            throw noSuchMethodError;
        } catch (IllegalAccessException e3) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e3);
            throw illegalAccessError;
        } catch (InstantiationException e4) {
            InstantiationError instantiationError = new InstantiationError();
            instantiationError.initCause(e4);
            throw instantiationError;
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }
}
