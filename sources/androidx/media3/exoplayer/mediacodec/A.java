package androidx.media3.exoplayer.mediacodec;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;

public final /* synthetic */ class A implements MediaCodecUtil.ScoreProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Format f11630a;

    public /* synthetic */ A(Format format) {
        this.f11630a = format;
    }

    public final int a(Object obj) {
        return MediaCodecUtil.O(this.f11630a, (MediaCodecInfo) obj);
    }
}
