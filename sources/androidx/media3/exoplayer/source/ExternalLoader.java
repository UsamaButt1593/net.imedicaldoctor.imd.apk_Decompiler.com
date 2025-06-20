package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import com.google.common.util.concurrent.ListenableFuture;

@UnstableApi
public interface ExternalLoader {

    public static final class LoadRequest {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f12132a;

        public LoadRequest(Uri uri) {
            this.f12132a = uri;
        }
    }

    ListenableFuture<?> a(LoadRequest loadRequest);
}
