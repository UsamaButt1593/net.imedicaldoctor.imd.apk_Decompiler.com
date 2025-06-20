package androidx.media3.exoplayer.dash;

import androidx.media3.exoplayer.source.chunk.ChunkSampleStream;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;

public final /* synthetic */ class c implements Function {
    public final Object apply(Object obj) {
        return ImmutableList.K(Integer.valueOf(((ChunkSampleStream) obj).s));
    }
}
