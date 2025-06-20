package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
@Deprecated
public interface Bundleable {

    @Deprecated
    public interface Creator<T extends Bundleable> {
        T a(Bundle bundle);
    }

    Bundle a();
}
