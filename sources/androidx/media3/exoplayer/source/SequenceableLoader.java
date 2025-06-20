package androidx.media3.exoplayer.source;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;

@UnstableApi
public interface SequenceableLoader {

    public interface Callback<T extends SequenceableLoader> {
        void j(T t);
    }

    boolean a(LoadingInfo loadingInfo);

    boolean c();

    long e();

    long g();

    void h(long j2);
}
