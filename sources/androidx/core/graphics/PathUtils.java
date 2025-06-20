package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;

public final class PathUtils {

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float[] a(Path path, float f2) {
            return path.approximate(f2);
        }
    }

    private PathUtils() {
    }

    @RequiresApi(26)
    @NonNull
    public static Collection<PathSegment> a(@NonNull Path path) {
        return b(path, 0.5f);
    }

    @RequiresApi(26)
    @NonNull
    public static Collection<PathSegment> b(@NonNull Path path, @FloatRange(from = 0.0d) float f2) {
        float[] a2 = Api26Impl.a(path, f2);
        int length = a2.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 1; i2 < length; i2++) {
            int i3 = i2 * 3;
            int i4 = (i2 - 1) * 3;
            float f3 = a2[i3];
            float f4 = a2[i3 + 1];
            float f5 = a2[i3 + 2];
            float f6 = a2[i4];
            float f7 = a2[i4 + 1];
            float f8 = a2[i4 + 2];
            if (!(f3 == f6 || (f4 == f7 && f5 == f8))) {
                arrayList.add(new PathSegment(new PointF(f7, f8), f6, new PointF(f4, f5), f3));
            }
        }
        return arrayList;
    }
}
