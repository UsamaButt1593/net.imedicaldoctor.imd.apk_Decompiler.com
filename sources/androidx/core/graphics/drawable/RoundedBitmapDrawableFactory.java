package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.BitmapCompat;
import androidx.core.view.GravityCompat;
import java.io.InputStream;

public final class RoundedBitmapDrawableFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5926a = "RoundedBitmapDrawableFa";

    private static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        /* access modifiers changed from: package-private */
        public void f(int i2, int i3, int i4, Rect rect, Rect rect2) {
            GravityCompat.b(i2, i3, i4, rect, rect2, 0);
        }

        public boolean h() {
            Bitmap bitmap = this.f5913a;
            return bitmap != null && BitmapCompat.c(bitmap);
        }

        public void o(boolean z) {
            Bitmap bitmap = this.f5913a;
            if (bitmap != null) {
                BitmapCompat.d(bitmap, z);
                invalidateSelf();
            }
        }
    }

    private RoundedBitmapDrawableFactory() {
    }

    @NonNull
    public static RoundedBitmapDrawable a(@NonNull Resources resources, @Nullable Bitmap bitmap) {
        return new RoundedBitmapDrawable21(resources, bitmap);
    }

    @NonNull
    public static RoundedBitmapDrawable b(@NonNull Resources resources, @NonNull InputStream inputStream) {
        RoundedBitmapDrawable a2 = a(resources, BitmapFactory.decodeStream(inputStream));
        if (a2.b() == null) {
            Log.w(f5926a, "RoundedBitmapDrawable cannot decode " + inputStream);
        }
        return a2;
    }

    @NonNull
    public static RoundedBitmapDrawable c(@NonNull Resources resources, @NonNull String str) {
        RoundedBitmapDrawable a2 = a(resources, BitmapFactory.decodeFile(str));
        if (a2.b() == null) {
            Log.w(f5926a, "RoundedBitmapDrawable cannot decode " + str);
        }
        return a2;
    }
}
