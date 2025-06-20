package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

class PropertyValuesHolderUtils {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static <V> PropertyValuesHolder a(Property<?, V> property, Path path) {
            return PropertyValuesHolder.ofObject(property, (TypeConverter) null, path);
        }
    }

    private PropertyValuesHolderUtils() {
    }

    static PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        return Api21Impl.a(property, path);
    }
}
