package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface ImageOutput {

    /* renamed from: a  reason: collision with root package name */
    public static final ImageOutput f11621a = new ImageOutput() {
        public void a() {
        }

        public void b(long j2, Bitmap bitmap) {
        }
    };

    void a();

    void b(long j2, Bitmap bitmap);
}
