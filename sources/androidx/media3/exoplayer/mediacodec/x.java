package androidx.media3.exoplayer.mediacodec;

import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import java.util.Comparator;

public final /* synthetic */ class x implements Comparator {
    public final /* synthetic */ MediaCodecUtil.ScoreProvider s;

    public /* synthetic */ x(MediaCodecUtil.ScoreProvider scoreProvider) {
        this.s = scoreProvider;
    }

    public final int compare(Object obj, Object obj2) {
        return MediaCodecUtil.P(this.s, obj, obj2);
    }
}
