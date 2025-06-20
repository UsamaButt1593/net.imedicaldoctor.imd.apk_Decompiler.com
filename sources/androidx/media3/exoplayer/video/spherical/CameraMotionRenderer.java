package androidx.media3.exoplayer.video.spherical;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.V0;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.exoplayer.source.MediaSource;
import java.nio.ByteBuffer;

@UnstableApi
public final class CameraMotionRenderer extends BaseRenderer {
    private static final String p3 = "CameraMotionRenderer";
    private static final int q3 = 100000;
    private final DecoderInputBuffer k3 = new DecoderInputBuffer(1);
    private final ParsableByteArray l3 = new ParsableByteArray();
    private long m3;
    @Nullable
    private CameraMotionListener n3;
    private long o3;

    public CameraMotionRenderer() {
        super(6);
    }

    @Nullable
    private float[] g0(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.l3.W(byteBuffer.array(), byteBuffer.limit());
        this.l3.Y(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i2 = 0; i2 < 3; i2++) {
            fArr[i2] = Float.intBitsToFloat(this.l3.w());
        }
        return fArr;
    }

    private void h0() {
        CameraMotionListener cameraMotionListener = this.n3;
        if (cameraMotionListener != null) {
            cameraMotionListener.f();
        }
    }

    /* access modifiers changed from: protected */
    public void S() {
        h0();
    }

    /* access modifiers changed from: protected */
    public void V(long j2, boolean z) {
        this.o3 = Long.MIN_VALUE;
        h0();
    }

    public int b(Format format) {
        return V0.c(MimeTypes.H0.equals(format.f3) ? 4 : 0);
    }

    /* access modifiers changed from: protected */
    public void b0(Format[] formatArr, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        this.m3 = j3;
    }

    public boolean c() {
        return l();
    }

    public boolean d() {
        return true;
    }

    public void g(long j2, long j3) {
        while (!l() && this.o3 < SilenceSkippingAudioProcessor.A + j2) {
            this.k3.g();
            boolean z = false;
            if (d0(L(), this.k3, 0) == -4 && !this.k3.l()) {
                long j4 = this.k3.Y2;
                this.o3 = j4;
                if (j4 < N()) {
                    z = true;
                }
                if (this.n3 != null && !z) {
                    this.k3.s();
                    float[] g0 = g0((ByteBuffer) Util.o(this.k3.Z));
                    if (g0 != null) {
                        ((CameraMotionListener) Util.o(this.n3)).b(this.o3 - this.m3, g0);
                    }
                }
            } else {
                return;
            }
        }
    }

    public String getName() {
        return p3;
    }

    public void z(int i2, @Nullable Object obj) throws ExoPlaybackException {
        if (i2 == 8) {
            this.n3 = (CameraMotionListener) obj;
        } else {
            super.z(i2, obj);
        }
    }
}
