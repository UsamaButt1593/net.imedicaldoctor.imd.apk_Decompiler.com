package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(28)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypefaceCompatApi28Impl extends TypefaceCompatApi26Impl {
    private static final String B = "createFromFamiliesWithDefault";
    private static final int C = -1;
    private static final String D = "sans-serif";

    /* access modifiers changed from: protected */
    public Method B(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod(B, new Class[]{Array.newInstance(cls, 1).getClass(), String.class, cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Typeface g(@NonNull Context context, @NonNull Typeface typeface, int i2, boolean z) {
        return Typeface.create(typeface, i2, z);
    }

    /* access modifiers changed from: protected */
    public Typeface p(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f5860m, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.s.invoke((Object) null, new Object[]{newInstance, "sans-serif", -1, -1});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }
}
