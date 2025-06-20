package androidx.media3.exoplayer.mediacodec;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import java.util.List;

@UnstableApi
public interface MediaCodecSelector {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaCodecSelector f11713a = new s();

    List<MediaCodecInfo> a(String str, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException;
}
