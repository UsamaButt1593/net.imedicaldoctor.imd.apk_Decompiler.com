package androidx.media3.extractor.metadata.mp4;

import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import com.google.common.collect.ComparisonChain;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ComparisonChain.n().g(((SlowMotionData.Segment) obj).s, ((SlowMotionData.Segment) obj2).s).g(((SlowMotionData.Segment) obj).X, ((SlowMotionData.Segment) obj2).X).f(((SlowMotionData.Segment) obj).Y, ((SlowMotionData.Segment) obj2).Y).m();
    }
}
