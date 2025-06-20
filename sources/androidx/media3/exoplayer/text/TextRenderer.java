package androidx.media3.exoplayer.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.V0;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.checkerframework.dataflow.qual.SideEffectFree;

@UnstableApi
public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    private static final String F3 = "TextRenderer";
    private static final int G3 = 0;
    private static final int H3 = 1;
    private static final int I3 = 2;
    private static final int J3 = 0;
    @Nullable
    private Format A3;
    private long B3;
    private long C3;
    private long D3;
    private boolean E3;
    private final CueDecoder k3;
    private final DecoderInputBuffer l3;
    private CuesResolver m3;
    private final SubtitleDecoderFactory n3;
    private boolean o3;
    private int p3;
    @Nullable
    private SubtitleDecoder q3;
    @Nullable
    private SubtitleInputBuffer r3;
    @Nullable
    private SubtitleOutputBuffer s3;
    @Nullable
    private SubtitleOutputBuffer t3;
    private int u3;
    @Nullable
    private final Handler v3;
    private final TextOutput w3;
    private final FormatHolder x3;
    private boolean y3;
    private boolean z3;

    public TextRenderer(TextOutput textOutput, @Nullable Looper looper) {
        this(textOutput, looper, SubtitleDecoderFactory.f12346a);
    }

    @RequiresNonNull({"streamFormat"})
    private void g0() {
        boolean z = this.E3 || Objects.equals(this.A3.f3, MimeTypes.w0) || Objects.equals(this.A3.f3, MimeTypes.C0) || Objects.equals(this.A3.f3, MimeTypes.x0);
        Assertions.j(z, "Legacy decoding is disabled, can't handle " + this.A3.f3 + " samples (expected " + MimeTypes.O0 + ").");
    }

    private void h0() {
        x0(new CueGroup(ImmutableList.I(), l0(this.C3)));
    }

    @SideEffectFree
    @RequiresNonNull({"subtitle"})
    private long j0(long j2) {
        int a2 = this.s3.a(j2);
        if (a2 == 0 || this.s3.e() == 0) {
            return this.s3.X;
        }
        if (a2 != -1) {
            return this.s3.b(a2 - 1);
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.s3;
        return subtitleOutputBuffer.b(subtitleOutputBuffer.e() - 1);
    }

    private long k0() {
        if (this.u3 == -1) {
            return Long.MAX_VALUE;
        }
        Assertions.g(this.s3);
        if (this.u3 >= this.s3.e()) {
            return Long.MAX_VALUE;
        }
        return this.s3.b(this.u3);
    }

    @SideEffectFree
    private long l0(long j2) {
        boolean z = false;
        Assertions.i(j2 != C.f9084b);
        if (this.B3 != C.f9084b) {
            z = true;
        }
        Assertions.i(z);
        return j2 - this.B3;
    }

    private void m0(SubtitleDecoderException subtitleDecoderException) {
        Log.e(F3, "Subtitle decoding failed. streamFormat=" + this.A3, subtitleDecoderException);
        h0();
        v0();
    }

    private void n0() {
        this.o3 = true;
        this.q3 = this.n3.a((Format) Assertions.g(this.A3));
    }

    private void o0(CueGroup cueGroup) {
        this.w3.s(cueGroup.s);
        this.w3.p(cueGroup);
    }

    @SideEffectFree
    private static boolean p0(Format format) {
        return Objects.equals(format.f3, MimeTypes.O0);
    }

    @RequiresNonNull({"this.cuesResolver"})
    private boolean q0(long j2) {
        if (this.y3 || d0(this.x3, this.l3, 0) != -4) {
            return false;
        }
        if (this.l3.l()) {
            this.y3 = true;
            return false;
        }
        this.l3.s();
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.g(this.l3.Z);
        CuesWithTiming b2 = this.k3.b(this.l3.Y2, byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        this.l3.g();
        return this.m3.c(b2, j2);
    }

    private void r0() {
        this.r3 = null;
        this.u3 = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.s3;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.q();
            this.s3 = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.t3;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.q();
            this.t3 = null;
        }
    }

    private void s0() {
        r0();
        ((SubtitleDecoder) Assertions.g(this.q3)).a();
        this.q3 = null;
        this.p3 = 0;
    }

    @RequiresNonNull({"this.cuesResolver"})
    private void t0(long j2) {
        boolean q0 = q0(j2);
        long a2 = this.m3.a(this.C3);
        int i2 = (a2 > Long.MIN_VALUE ? 1 : (a2 == Long.MIN_VALUE ? 0 : -1));
        if (i2 == 0 && this.y3 && !q0) {
            this.z3 = true;
        }
        if (i2 != 0 && a2 <= j2) {
            q0 = true;
        }
        if (q0) {
            ImmutableList<Cue> b2 = this.m3.b(j2);
            long d2 = this.m3.d(j2);
            x0(new CueGroup(b2, l0(d2)));
            this.m3.e(d2);
        }
        this.C3 = j2;
    }

    private void u0(long j2) {
        boolean z;
        this.C3 = j2;
        if (this.t3 == null) {
            ((SubtitleDecoder) Assertions.g(this.q3)).e(j2);
            try {
                this.t3 = (SubtitleOutputBuffer) ((SubtitleDecoder) Assertions.g(this.q3)).b();
            } catch (SubtitleDecoderException e2) {
                m0(e2);
                return;
            }
        }
        if (getState() == 2) {
            if (this.s3 != null) {
                long k0 = k0();
                z = false;
                while (k0 <= j2) {
                    this.u3++;
                    k0 = k0();
                    z = true;
                }
            } else {
                z = false;
            }
            SubtitleOutputBuffer subtitleOutputBuffer = this.t3;
            if (subtitleOutputBuffer != null) {
                if (subtitleOutputBuffer.l()) {
                    if (!z && k0() == Long.MAX_VALUE) {
                        if (this.p3 == 2) {
                            v0();
                        } else {
                            r0();
                            this.z3 = true;
                        }
                    }
                } else if (subtitleOutputBuffer.X <= j2) {
                    SubtitleOutputBuffer subtitleOutputBuffer2 = this.s3;
                    if (subtitleOutputBuffer2 != null) {
                        subtitleOutputBuffer2.q();
                    }
                    this.u3 = subtitleOutputBuffer.a(j2);
                    this.s3 = subtitleOutputBuffer;
                    this.t3 = null;
                    z = true;
                }
            }
            if (z) {
                Assertions.g(this.s3);
                x0(new CueGroup(this.s3.c(j2), l0(j0(j2))));
            }
            if (this.p3 != 2) {
                while (!this.y3) {
                    try {
                        SubtitleInputBuffer subtitleInputBuffer = this.r3;
                        if (subtitleInputBuffer == null) {
                            subtitleInputBuffer = (SubtitleInputBuffer) ((SubtitleDecoder) Assertions.g(this.q3)).f();
                            if (subtitleInputBuffer != null) {
                                this.r3 = subtitleInputBuffer;
                            } else {
                                return;
                            }
                        }
                        if (this.p3 == 1) {
                            subtitleInputBuffer.p(4);
                            ((SubtitleDecoder) Assertions.g(this.q3)).c(subtitleInputBuffer);
                            this.r3 = null;
                            this.p3 = 2;
                            return;
                        }
                        int d0 = d0(this.x3, subtitleInputBuffer, 0);
                        if (d0 == -4) {
                            if (subtitleInputBuffer.l()) {
                                this.y3 = true;
                                this.o3 = false;
                            } else {
                                Format format = this.x3.f10226b;
                                if (format != null) {
                                    subtitleInputBuffer.f3 = format.j3;
                                    subtitleInputBuffer.s();
                                    this.o3 &= !subtitleInputBuffer.n();
                                } else {
                                    return;
                                }
                            }
                            if (!this.o3) {
                                if (subtitleInputBuffer.Y2 < N()) {
                                    subtitleInputBuffer.f(Integer.MIN_VALUE);
                                }
                                ((SubtitleDecoder) Assertions.g(this.q3)).c(subtitleInputBuffer);
                                this.r3 = null;
                            }
                        } else if (d0 == -3) {
                            return;
                        }
                    } catch (SubtitleDecoderException e3) {
                        m0(e3);
                        return;
                    }
                }
            }
        }
    }

    private void v0() {
        s0();
        n0();
    }

    private void x0(CueGroup cueGroup) {
        Handler handler = this.v3;
        if (handler != null) {
            handler.obtainMessage(0, cueGroup).sendToTarget();
        } else {
            o0(cueGroup);
        }
    }

    /* access modifiers changed from: protected */
    public void S() {
        this.A3 = null;
        this.D3 = C.f9084b;
        h0();
        this.B3 = C.f9084b;
        this.C3 = C.f9084b;
        if (this.q3 != null) {
            s0();
        }
    }

    /* access modifiers changed from: protected */
    public void V(long j2, boolean z) {
        this.C3 = j2;
        CuesResolver cuesResolver = this.m3;
        if (cuesResolver != null) {
            cuesResolver.clear();
        }
        h0();
        this.y3 = false;
        this.z3 = false;
        this.D3 = C.f9084b;
        Format format = this.A3;
        if (format != null && !p0(format)) {
            if (this.p3 != 0) {
                v0();
                return;
            }
            r0();
            ((SubtitleDecoder) Assertions.g(this.q3)).flush();
        }
    }

    public int b(Format format) {
        if (p0(format) || this.n3.b(format)) {
            return V0.c(format.B3 == 0 ? 4 : 2);
        }
        return V0.c(MimeTypes.s(format.f3) ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public void b0(Format[] formatArr, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        this.B3 = j3;
        Format format = formatArr[0];
        this.A3 = format;
        if (!p0(format)) {
            g0();
            if (this.q3 != null) {
                this.p3 = 1;
            } else {
                n0();
            }
        } else {
            this.m3 = this.A3.y3 == 1 ? new MergingCuesResolver() : new ReplacingCuesResolver();
        }
    }

    public boolean c() {
        return this.z3;
    }

    public boolean d() {
        return true;
    }

    public void g(long j2, long j3) {
        if (F()) {
            long j4 = this.D3;
            if (j4 != C.f9084b && j2 >= j4) {
                r0();
                this.z3 = true;
            }
        }
        if (!this.z3) {
            if (p0((Format) Assertions.g(this.A3))) {
                Assertions.g(this.m3);
                t0(j2);
                return;
            }
            g0();
            u0(j2);
        }
    }

    public String getName() {
        return F3;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            o0((CueGroup) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    public void i0(boolean z) {
        this.E3 = z;
    }

    public void w0(long j2) {
        Assertions.i(F());
        this.D3 = j2;
    }

    public TextRenderer(TextOutput textOutput, @Nullable Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        this.w3 = (TextOutput) Assertions.g(textOutput);
        this.v3 = looper == null ? null : Util.G(looper, this);
        this.n3 = subtitleDecoderFactory;
        this.k3 = new CueDecoder();
        this.l3 = new DecoderInputBuffer(1);
        this.x3 = new FormatHolder();
        this.D3 = C.f9084b;
        this.B3 = C.f9084b;
        this.C3 = C.f9084b;
        this.E3 = true;
    }
}
