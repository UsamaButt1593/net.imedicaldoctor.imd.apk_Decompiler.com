package androidx.media3.extractor.mp4;

import com.google.common.base.Function;

public final /* synthetic */ class b implements Function {
    public final /* synthetic */ FragmentedMp4Extractor s;

    public /* synthetic */ b(FragmentedMp4Extractor fragmentedMp4Extractor) {
        this.s = fragmentedMp4Extractor;
    }

    public final Object apply(Object obj) {
        return this.s.r((Track) obj);
    }
}
