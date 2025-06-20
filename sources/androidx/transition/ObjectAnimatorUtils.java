package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

class ObjectAnimatorUtils {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static <T, V> ObjectAnimator a(T t, Property<T, V> property, Path path) {
            return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
        }
    }

    private ObjectAnimatorUtils() {
    }

    static <T> ObjectAnimator a(T t, Property<T, PointF> property, Path path) {
        return Api21Impl.a(t, property, path);
    }
}
