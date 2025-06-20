package androidx.media3.exoplayer.source;

import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import java.util.List;

@UnstableApi
public final class DefaultCompositeSequenceableLoaderFactory implements CompositeSequenceableLoaderFactory {
    public SequenceableLoader a(List<? extends SequenceableLoader> list, List<List<Integer>> list2) {
        return new CompositeSequenceableLoader(list, list2);
    }

    public SequenceableLoader b() {
        return new CompositeSequenceableLoader(ImmutableList.I(), ImmutableList.I());
    }

    @Deprecated
    public SequenceableLoader c(SequenceableLoader... sequenceableLoaderArr) {
        return new CompositeSequenceableLoader(sequenceableLoaderArr);
    }
}
