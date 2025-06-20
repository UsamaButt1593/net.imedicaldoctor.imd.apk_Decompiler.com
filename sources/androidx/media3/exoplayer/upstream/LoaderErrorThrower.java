package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
public interface LoaderErrorThrower {

    public static final class Placeholder implements LoaderErrorThrower {
        public void a(int i2) {
        }

        public void b() {
        }
    }

    void a(int i2) throws IOException;

    void b() throws IOException;
}
