package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.V0;
import androidx.media3.exoplayer.image.ImageDecoder;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public class ImageRenderer extends BaseRenderer {
    private static final String D3 = "ImageRenderer";
    private static final int E3 = 0;
    private static final int F3 = 2;
    private static final int G3 = 3;
    private static final long H3 = 30000;
    private TileInfo A3;
    private TileInfo B3;
    private int C3;
    private final ImageDecoder.Factory k3;
    private final DecoderInputBuffer l3 = DecoderInputBuffer.v();
    private final ArrayDeque<OutputStreamInfo> m3 = new ArrayDeque<>();
    private boolean n3;
    private boolean o3;
    private OutputStreamInfo p3 = OutputStreamInfo.f11622c;
    private long q3 = C.f9084b;
    private long r3 = C.f9084b;
    private int s3 = 0;
    private int t3 = 1;
    private Format u3;
    private ImageDecoder v3;
    private DecoderInputBuffer w3;
    private ImageOutput x3;
    private Bitmap y3;
    private boolean z3;

    private static final class OutputStreamInfo {

        /* renamed from: c  reason: collision with root package name */
        public static final OutputStreamInfo f11622c = new OutputStreamInfo(C.f9084b, C.f9084b);

        /* renamed from: a  reason: collision with root package name */
        public final long f11623a;

        /* renamed from: b  reason: collision with root package name */
        public final long f11624b;

        public OutputStreamInfo(long j2, long j3) {
            this.f11623a = j2;
            this.f11624b = j3;
        }
    }

    private static class TileInfo {

        /* renamed from: a  reason: collision with root package name */
        private final int f11625a;

        /* renamed from: b  reason: collision with root package name */
        private final long f11626b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap f11627c;

        public TileInfo(int i2, long j2) {
            this.f11625a = i2;
            this.f11626b = j2;
        }

        public long a() {
            return this.f11626b;
        }

        public Bitmap b() {
            return this.f11627c;
        }

        public int c() {
            return this.f11625a;
        }

        public boolean d() {
            return this.f11627c != null;
        }

        public void e(Bitmap bitmap) {
            this.f11627c = bitmap;
        }
    }

    public ImageRenderer(ImageDecoder.Factory factory, ImageOutput imageOutput) {
        super(4);
        this.k3 = factory;
        this.x3 = k0(imageOutput);
    }

    private boolean g0(Format format) {
        int b2 = this.k3.b(format);
        return b2 == V0.c(4) || b2 == V0.c(3);
    }

    private Bitmap h0(int i2) {
        Assertions.k(this.y3);
        int width = this.y3.getWidth() / ((Format) Assertions.k(this.u3)).z3;
        int height = this.y3.getHeight() / ((Format) Assertions.k(this.u3)).A3;
        Format format = this.u3;
        return Bitmap.createBitmap(this.y3, (i2 % format.A3) * width, (i2 / format.z3) * height, width, height);
    }

    private boolean i0(long j2, long j3) throws ImageDecoderException, ExoPlaybackException {
        if (this.y3 != null && this.A3 == null) {
            return false;
        }
        if (this.t3 == 0 && getState() != 2) {
            return false;
        }
        if (this.y3 == null) {
            Assertions.k(this.v3);
            ImageOutputBuffer b2 = this.v3.b();
            if (b2 == null) {
                return false;
            }
            if (((ImageOutputBuffer) Assertions.k(b2)).l()) {
                if (this.s3 == 3) {
                    r0();
                    Assertions.k(this.u3);
                    l0();
                } else {
                    ((ImageOutputBuffer) Assertions.k(b2)).q();
                    if (this.m3.isEmpty()) {
                        this.o3 = true;
                    }
                }
                return false;
            }
            Assertions.l(b2.X2, "Non-EOS buffer came back from the decoder without bitmap.");
            this.y3 = b2.X2;
            ((ImageOutputBuffer) Assertions.k(b2)).q();
        }
        if (!this.z3 || this.y3 == null || this.A3 == null) {
            return false;
        }
        Assertions.k(this.u3);
        Format format = this.u3;
        int i2 = format.z3;
        boolean z = ((i2 == 1 && format.A3 == 1) || i2 == -1 || format.A3 == -1) ? false : true;
        if (!this.A3.d()) {
            TileInfo tileInfo = this.A3;
            tileInfo.e(z ? h0(tileInfo.c()) : (Bitmap) Assertions.k(this.y3));
        }
        if (!q0(j2, j3, (Bitmap) Assertions.k(this.A3.b()), this.A3.a())) {
            return false;
        }
        p0(((TileInfo) Assertions.k(this.A3)).a());
        this.t3 = 3;
        if (!z || ((TileInfo) Assertions.k(this.A3)).c() == (((Format) Assertions.k(this.u3)).A3 * ((Format) Assertions.k(this.u3)).z3) - 1) {
            this.y3 = null;
        }
        this.A3 = this.B3;
        this.B3 = null;
        return true;
    }

    private boolean j0(long j2) throws ImageDecoderException {
        if (this.z3 && this.A3 != null) {
            return false;
        }
        FormatHolder L = L();
        ImageDecoder imageDecoder = this.v3;
        if (imageDecoder == null || this.s3 == 3 || this.n3) {
            return false;
        }
        if (this.w3 == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) imageDecoder.f();
            this.w3 = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.s3 == 2) {
            Assertions.k(this.w3);
            this.w3.p(4);
            ((ImageDecoder) Assertions.k(this.v3)).g(this.w3);
            this.w3 = null;
            this.s3 = 3;
            return false;
        }
        int d0 = d0(L, this.w3, 0);
        if (d0 == -5) {
            this.u3 = (Format) Assertions.k(L.f10226b);
            this.s3 = 2;
            return true;
        } else if (d0 == -4) {
            this.w3.s();
            boolean z = ((ByteBuffer) Assertions.k(this.w3.Z)).remaining() > 0 || ((DecoderInputBuffer) Assertions.k(this.w3)).l();
            if (z) {
                ((DecoderInputBuffer) Assertions.k(this.w3)).h(Integer.MIN_VALUE);
                ((ImageDecoder) Assertions.k(this.v3)).g((DecoderInputBuffer) Assertions.k(this.w3));
                this.C3 = 0;
            }
            o0(j2, (DecoderInputBuffer) Assertions.k(this.w3));
            if (((DecoderInputBuffer) Assertions.k(this.w3)).l()) {
                this.n3 = true;
                this.w3 = null;
                return false;
            }
            this.r3 = Math.max(this.r3, ((DecoderInputBuffer) Assertions.k(this.w3)).Y2);
            if (z) {
                this.w3 = null;
            } else {
                ((DecoderInputBuffer) Assertions.k(this.w3)).g();
            }
            return !this.z3;
        } else if (d0 == -3) {
            return false;
        } else {
            throw new IllegalStateException();
        }
    }

    private static ImageOutput k0(ImageOutput imageOutput) {
        return imageOutput == null ? ImageOutput.f11621a : imageOutput;
    }

    @RequiresNonNull({"inputFormat"})
    @EnsuresNonNull({"decoder"})
    private void l0() throws ExoPlaybackException {
        if (g0(this.u3)) {
            ImageDecoder imageDecoder = this.v3;
            if (imageDecoder != null) {
                imageDecoder.a();
            }
            this.v3 = this.k3.a();
            return;
        }
        throw H(new ImageDecoderException("Provided decoder factory can't create decoder for format."), this.u3, PlaybackException.r3);
    }

    private boolean m0(TileInfo tileInfo) {
        return ((Format) Assertions.k(this.u3)).z3 == -1 || this.u3.A3 == -1 || tileInfo.c() == (((Format) Assertions.k(this.u3)).A3 * this.u3.z3) - 1;
    }

    private void n0(int i2) {
        this.t3 = Math.min(this.t3, i2);
    }

    private void o0(long j2, DecoderInputBuffer decoderInputBuffer) {
        boolean z = true;
        if (decoderInputBuffer.l()) {
            this.z3 = true;
            return;
        }
        TileInfo tileInfo = new TileInfo(this.C3, decoderInputBuffer.Y2);
        this.B3 = tileInfo;
        this.C3++;
        if (!this.z3) {
            long a2 = tileInfo.a();
            boolean z2 = a2 - 30000 <= j2 && j2 <= 30000 + a2;
            TileInfo tileInfo2 = this.A3;
            boolean z4 = tileInfo2 != null && tileInfo2.a() <= j2 && j2 < a2;
            boolean m0 = m0((TileInfo) Assertions.k(this.B3));
            if (!z2 && !z4 && !m0) {
                z = false;
            }
            this.z3 = z;
            if (z4 && !z2) {
                return;
            }
        }
        this.A3 = this.B3;
        this.B3 = null;
    }

    private void p0(long j2) {
        this.q3 = j2;
        while (!this.m3.isEmpty() && j2 >= this.m3.peek().f11623a) {
            this.p3 = this.m3.removeFirst();
        }
    }

    private void r0() {
        this.w3 = null;
        this.s3 = 0;
        this.r3 = C.f9084b;
        ImageDecoder imageDecoder = this.v3;
        if (imageDecoder != null) {
            imageDecoder.a();
            this.v3 = null;
        }
    }

    private void s0(ImageOutput imageOutput) {
        this.x3 = k0(imageOutput);
    }

    private boolean t0() {
        boolean z = getState() == 2;
        int i2 = this.t3;
        if (i2 == 0) {
            return z;
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 == 3) {
            return false;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: protected */
    public void S() {
        this.u3 = null;
        this.p3 = OutputStreamInfo.f11622c;
        this.m3.clear();
        r0();
        this.x3.a();
    }

    /* access modifiers changed from: protected */
    public void T(boolean z, boolean z2) {
        this.t3 = z2 ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void V(long j2, boolean z) throws ExoPlaybackException {
        n0(1);
        this.o3 = false;
        this.n3 = false;
        this.y3 = null;
        this.A3 = null;
        this.B3 = null;
        this.z3 = false;
        this.w3 = null;
        ImageDecoder imageDecoder = this.v3;
        if (imageDecoder != null) {
            imageDecoder.flush();
        }
        this.m3.clear();
    }

    /* access modifiers changed from: protected */
    public void W() {
        r0();
    }

    /* access modifiers changed from: protected */
    public void Y() {
        r0();
        n0(1);
    }

    public int b(Format format) {
        return this.k3.b(format);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r2 >= r5) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b0(androidx.media3.common.Format[] r5, long r6, long r8, androidx.media3.exoplayer.source.MediaSource.MediaPeriodId r10) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r4 = this;
            super.b0(r5, r6, r8, r10)
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r5 = r4.p3
            long r5 = r5.f11624b
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x0036
            java.util.ArrayDeque<androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo> r5 = r4.m3
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0029
            long r5 = r4.r3
            int r7 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x0036
            long r2 = r4.q3
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x0029
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x0029
            goto L_0x0036
        L_0x0029:
            java.util.ArrayDeque<androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo> r5 = r4.m3
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r6 = new androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo
            long r0 = r4.r3
            r6.<init>(r0, r8)
            r5.add(r6)
            goto L_0x003d
        L_0x0036:
            androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo r5 = new androidx.media3.exoplayer.image.ImageRenderer$OutputStreamInfo
            r5.<init>(r0, r8)
            r4.p3 = r5
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.image.ImageRenderer.b0(androidx.media3.common.Format[], long, long, androidx.media3.exoplayer.source.MediaSource$MediaPeriodId):void");
    }

    public boolean c() {
        return this.o3;
    }

    public boolean d() {
        int i2 = this.t3;
        return i2 == 3 || (i2 == 0 && this.z3);
    }

    public void g(long j2, long j3) throws ExoPlaybackException {
        if (!this.o3) {
            if (this.u3 == null) {
                FormatHolder L = L();
                this.l3.g();
                int d0 = d0(L, this.l3, 2);
                if (d0 == -5) {
                    this.u3 = (Format) Assertions.k(L.f10226b);
                    l0();
                } else if (d0 == -4) {
                    Assertions.i(this.l3.l());
                    this.n3 = true;
                    this.o3 = true;
                    return;
                } else {
                    return;
                }
            }
            try {
                TraceUtil.a("drainAndFeedDecoder");
                while (i0(j2, j3)) {
                }
                while (j0(j2)) {
                }
                TraceUtil.c();
            } catch (ImageDecoderException e2) {
                throw H(e2, (Format) null, PlaybackException.p3);
            }
        }
    }

    public String getName() {
        return D3;
    }

    /* access modifiers changed from: protected */
    public boolean q0(long j2, long j3, Bitmap bitmap, long j4) throws ExoPlaybackException {
        long j5 = j4 - j2;
        if (!t0() && j5 >= 30000) {
            return false;
        }
        this.x3.b(j4 - this.p3.f11624b, bitmap);
        return true;
    }

    public void z(int i2, Object obj) throws ExoPlaybackException {
        if (i2 != 15) {
            super.z(i2, obj);
        } else {
            s0(obj instanceof ImageOutput ? (ImageOutput) obj : null);
        }
    }
}
