package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

public abstract class FloatPropertyCompat<T> {

    /* renamed from: a  reason: collision with root package name */
    final String f7551a;

    public FloatPropertyCompat(String str) {
        this.f7551a = str;
    }

    @RequiresApi(24)
    public static <T> FloatPropertyCompat<T> a(final FloatProperty<T> floatProperty) {
        return new FloatPropertyCompat<T>(floatProperty.getName()) {
            public float b(T t) {
                return ((Float) floatProperty.get(t)).floatValue();
            }

            public void c(T t, float f2) {
                floatProperty.setValue(t, f2);
            }
        };
    }

    public abstract float b(T t);

    public abstract void c(T t, float f2);
}
