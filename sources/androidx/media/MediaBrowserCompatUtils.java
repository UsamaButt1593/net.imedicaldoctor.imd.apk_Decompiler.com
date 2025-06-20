package androidx.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class MediaBrowserCompatUtils {
    private MediaBrowserCompatUtils() {
    }

    public static boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        return bundle == null ? bundle2.getInt(MediaBrowserCompat.f2202d, -1) == -1 && bundle2.getInt(MediaBrowserCompat.f2203e, -1) == -1 : bundle2 == null ? bundle.getInt(MediaBrowserCompat.f2202d, -1) == -1 && bundle.getInt(MediaBrowserCompat.f2203e, -1) == -1 : bundle.getInt(MediaBrowserCompat.f2202d, -1) == bundle2.getInt(MediaBrowserCompat.f2202d, -1) && bundle.getInt(MediaBrowserCompat.f2203e, -1) == bundle2.getInt(MediaBrowserCompat.f2203e, -1);
    }

    public static boolean b(Bundle bundle, Bundle bundle2) {
        int i2;
        int i3;
        int i4;
        int i5 = bundle == null ? -1 : bundle.getInt(MediaBrowserCompat.f2202d, -1);
        int i6 = bundle2 == null ? -1 : bundle2.getInt(MediaBrowserCompat.f2202d, -1);
        int i7 = bundle == null ? -1 : bundle.getInt(MediaBrowserCompat.f2203e, -1);
        int i8 = bundle2 == null ? -1 : bundle2.getInt(MediaBrowserCompat.f2203e, -1);
        int i9 = Integer.MAX_VALUE;
        if (i5 == -1 || i7 == -1) {
            i2 = Integer.MAX_VALUE;
            i3 = 0;
        } else {
            i3 = i5 * i7;
            i2 = (i7 + i3) - 1;
        }
        if (i6 == -1 || i8 == -1) {
            i4 = 0;
        } else {
            i4 = i6 * i8;
            i9 = (i8 + i4) - 1;
        }
        return i2 >= i4 && i9 >= i3;
    }
}
