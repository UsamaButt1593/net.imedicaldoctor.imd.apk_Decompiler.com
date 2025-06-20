package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;

public final /* synthetic */ class B implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SynchronousMediaCodecAdapter f11675a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodecAdapter.OnFrameRenderedListener f11676b;

    public /* synthetic */ B(SynchronousMediaCodecAdapter synchronousMediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener) {
        this.f11675a = synchronousMediaCodecAdapter;
        this.f11676b = onFrameRenderedListener;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j2, long j3) {
        this.f11675a.r(this.f11676b, mediaCodec, j2, j3);
    }
}
