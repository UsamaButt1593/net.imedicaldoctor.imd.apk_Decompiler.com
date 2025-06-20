package androidx.media3.datasource.cache;

import android.net.Uri;
import androidx.annotation.Nullable;

public final /* synthetic */ class c {
    public static long a(ContentMetadata contentMetadata) {
        return contentMetadata.b(ContentMetadata.f10026c, -1);
    }

    @Nullable
    public static Uri b(ContentMetadata contentMetadata) {
        String a2 = contentMetadata.a(ContentMetadata.f10025b, (String) null);
        if (a2 == null) {
            return null;
        }
        return Uri.parse(a2);
    }
}
