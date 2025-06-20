package androidx.media3.exoplayer.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.V0;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.extractor.metadata.MetadataDecoder;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.dataflow.qual.SideEffectFree;

@UnstableApi
public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    private static final String v3 = "MetadataRenderer";
    private static final int w3 = 0;
    private final MetadataDecoderFactory k3;
    private final MetadataOutput l3;
    @Nullable
    private final Handler m3;
    private final MetadataInputBuffer n3;
    private final boolean o3;
    @Nullable
    private MetadataDecoder p3;
    private boolean q3;
    private boolean r3;
    private long s3;
    @Nullable
    private Metadata t3;
    private long u3;

    public MetadataRenderer(MetadataOutput metadataOutput, @Nullable Looper looper) {
        this(metadataOutput, looper, MetadataDecoderFactory.f11736a);
    }

    private void g0(Metadata metadata, List<Metadata.Entry> list) {
        for (int i2 = 0; i2 < metadata.g(); i2++) {
            Format n2 = metadata.d(i2).n();
            if (n2 == null || !this.k3.b(n2)) {
                list.add(metadata.d(i2));
            } else {
                MetadataDecoder a2 = this.k3.a(n2);
                byte[] bArr = (byte[]) Assertions.g(metadata.d(i2).J());
                this.n3.g();
                this.n3.r(bArr.length);
                ((ByteBuffer) Util.o(this.n3.Z)).put(bArr);
                this.n3.s();
                Metadata a3 = a2.a(this.n3);
                if (a3 != null) {
                    g0(a3, list);
                }
            }
        }
    }

    @SideEffectFree
    private long h0(long j2) {
        boolean z = false;
        Assertions.i(j2 != C.f9084b);
        if (this.u3 != C.f9084b) {
            z = true;
        }
        Assertions.i(z);
        return j2 - this.u3;
    }

    private void i0(Metadata metadata) {
        Handler handler = this.m3;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            j0(metadata);
        }
    }

    private void j0(Metadata metadata) {
        this.l3.q(metadata);
    }

    private boolean k0(long j2) {
        boolean z;
        Metadata metadata = this.t3;
        if (metadata == null || (!this.o3 && metadata.X > h0(j2))) {
            z = false;
        } else {
            i0(this.t3);
            this.t3 = null;
            z = true;
        }
        if (this.q3 && this.t3 == null) {
            this.r3 = true;
        }
        return z;
    }

    private void l0() {
        if (!this.q3 && this.t3 == null) {
            this.n3.g();
            FormatHolder L = L();
            int d0 = d0(L, this.n3, 0);
            if (d0 == -4) {
                if (this.n3.l()) {
                    this.q3 = true;
                } else if (this.n3.Y2 >= N()) {
                    MetadataInputBuffer metadataInputBuffer = this.n3;
                    metadataInputBuffer.f3 = this.s3;
                    metadataInputBuffer.s();
                    Metadata a2 = ((MetadataDecoder) Util.o(this.p3)).a(this.n3);
                    if (a2 != null) {
                        ArrayList arrayList = new ArrayList(a2.g());
                        g0(a2, arrayList);
                        if (!arrayList.isEmpty()) {
                            this.t3 = new Metadata(h0(this.n3.Y2), (List<? extends Metadata.Entry>) arrayList);
                        }
                    }
                }
            } else if (d0 == -5) {
                this.s3 = ((Format) Assertions.g(L.f10226b)).j3;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void S() {
        this.t3 = null;
        this.p3 = null;
        this.u3 = C.f9084b;
    }

    /* access modifiers changed from: protected */
    public void V(long j2, boolean z) {
        this.t3 = null;
        this.q3 = false;
        this.r3 = false;
    }

    public int b(Format format) {
        if (!this.k3.b(format)) {
            return V0.c(0);
        }
        return V0.c(format.B3 == 0 ? 4 : 2);
    }

    /* access modifiers changed from: protected */
    public void b0(Format[] formatArr, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        this.p3 = this.k3.a(formatArr[0]);
        Metadata metadata = this.t3;
        if (metadata != null) {
            this.t3 = metadata.c((metadata.X + this.u3) - j3);
        }
        this.u3 = j3;
    }

    public boolean c() {
        return this.r3;
    }

    public boolean d() {
        return true;
    }

    public void g(long j2, long j3) {
        boolean z = true;
        while (z) {
            l0();
            z = k0(j2);
        }
    }

    public String getName() {
        return v3;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            j0((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    public MetadataRenderer(MetadataOutput metadataOutput, @Nullable Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        this(metadataOutput, looper, metadataDecoderFactory, false);
    }

    public MetadataRenderer(MetadataOutput metadataOutput, @Nullable Looper looper, MetadataDecoderFactory metadataDecoderFactory, boolean z) {
        super(5);
        this.l3 = (MetadataOutput) Assertions.g(metadataOutput);
        this.m3 = looper == null ? null : Util.G(looper, this);
        this.k3 = (MetadataDecoderFactory) Assertions.g(metadataDecoderFactory);
        this.o3 = z;
        this.n3 = new MetadataInputBuffer();
        this.u3 = C.f9084b;
    }
}
