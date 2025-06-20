package androidx.media3.exoplayer.source;

import androidx.media3.common.util.UnstableApi;
import java.util.List;

@UnstableApi
public interface CompositeSequenceableLoaderFactory {
    SequenceableLoader a(List<? extends SequenceableLoader> list, List<List<Integer>> list2);

    SequenceableLoader b();

    @Deprecated
    SequenceableLoader c(SequenceableLoader... sequenceableLoaderArr);
}
