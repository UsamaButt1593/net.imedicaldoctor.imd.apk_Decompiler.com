package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;

public final /* synthetic */ class d implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AsynchronousMediaCodecAdapter f11734a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodecAdapter.OnFrameRenderedListener f11735b;

    public /* synthetic */ d(AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener) {
        this.f11734a = asynchronousMediaCodecAdapter;
        this.f11735b = onFrameRenderedListener;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j2, long j3) {
        this.f11734a.y(this.f11735b, mediaCodec, j2, j3);
    }
}
