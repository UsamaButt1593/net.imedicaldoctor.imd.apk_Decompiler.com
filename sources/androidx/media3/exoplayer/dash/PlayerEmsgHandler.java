package androidx.media3.exoplayer.dash;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.g;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.emsg.EventMessageDecoder;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@UnstableApi
public final class PlayerEmsgHandler implements Handler.Callback {
    private static final int d3 = 1;
    private final PlayerEmsgCallback X;
    private final TreeMap<Long, Long> X2 = new TreeMap<>();
    /* access modifiers changed from: private */
    public final EventMessageDecoder Y = new EventMessageDecoder();
    private DashManifest Y2;
    /* access modifiers changed from: private */
    public final Handler Z = Util.I(this);
    private long Z2;
    private boolean a3;
    private boolean b3;
    private boolean c3;
    private final Allocator s;

    private static final class ManifestExpiryEventInfo {

        /* renamed from: a  reason: collision with root package name */
        public final long f11013a;

        /* renamed from: b  reason: collision with root package name */
        public final long f11014b;

        public ManifestExpiryEventInfo(long j2, long j3) {
            this.f11013a = j2;
            this.f11014b = j3;
        }
    }

    public interface PlayerEmsgCallback {
        void a();

        void b(long j2);
    }

    public final class PlayerTrackEmsgHandler implements TrackOutput {

        /* renamed from: d  reason: collision with root package name */
        private final SampleQueue f11015d;

        /* renamed from: e  reason: collision with root package name */
        private final FormatHolder f11016e = new FormatHolder();

        /* renamed from: f  reason: collision with root package name */
        private final MetadataInputBuffer f11017f = new MetadataInputBuffer();

        /* renamed from: g  reason: collision with root package name */
        private long f11018g = C.f9084b;

        PlayerTrackEmsgHandler(Allocator allocator) {
            this.f11015d = SampleQueue.m(allocator);
        }

        @Nullable
        private MetadataInputBuffer g() {
            this.f11017f.g();
            if (this.f11015d.V(this.f11016e, this.f11017f, 0, false) != -4) {
                return null;
            }
            this.f11017f.s();
            return this.f11017f;
        }

        private void k(long j2, long j3) {
            PlayerEmsgHandler.this.Z.sendMessage(PlayerEmsgHandler.this.Z.obtainMessage(1, new ManifestExpiryEventInfo(j2, j3)));
        }

        private void l() {
            while (this.f11015d.N(false)) {
                MetadataInputBuffer g2 = g();
                if (g2 != null) {
                    long j2 = g2.Y2;
                    Metadata a2 = PlayerEmsgHandler.this.Y.a(g2);
                    if (a2 != null) {
                        EventMessage eventMessage = (EventMessage) a2.d(0);
                        if (PlayerEmsgHandler.h(eventMessage.s, eventMessage.X)) {
                            m(j2, eventMessage);
                        }
                    }
                }
            }
            this.f11015d.t();
        }

        private void m(long j2, EventMessage eventMessage) {
            long c2 = PlayerEmsgHandler.f(eventMessage);
            if (c2 != C.f9084b) {
                k(j2, c2);
            }
        }

        public void a(ParsableByteArray parsableByteArray, int i2, int i3) {
            this.f11015d.d(parsableByteArray, i2);
        }

        public /* synthetic */ int b(DataReader dataReader, int i2, boolean z) {
            return g.a(this, dataReader, i2, z);
        }

        public int c(DataReader dataReader, int i2, boolean z, int i3) throws IOException {
            return this.f11015d.b(dataReader, i2, z);
        }

        public /* synthetic */ void d(ParsableByteArray parsableByteArray, int i2) {
            g.b(this, parsableByteArray, i2);
        }

        public void e(Format format) {
            this.f11015d.e(format);
        }

        public void f(long j2, int i2, int i3, int i4, @Nullable TrackOutput.CryptoData cryptoData) {
            this.f11015d.f(j2, i2, i3, i4, cryptoData);
            l();
        }

        public boolean h(long j2) {
            return PlayerEmsgHandler.this.j(j2);
        }

        public void i(Chunk chunk) {
            long j2 = this.f11018g;
            if (j2 == C.f9084b || chunk.f12285h > j2) {
                this.f11018g = chunk.f12285h;
            }
            PlayerEmsgHandler.this.m(chunk);
        }

        public boolean j(Chunk chunk) {
            long j2 = this.f11018g;
            return PlayerEmsgHandler.this.n(j2 != C.f9084b && j2 < chunk.f12284g);
        }

        public void n() {
            this.f11015d.W();
        }
    }

    public PlayerEmsgHandler(DashManifest dashManifest, PlayerEmsgCallback playerEmsgCallback, Allocator allocator) {
        this.Y2 = dashManifest;
        this.X = playerEmsgCallback;
        this.s = allocator;
    }

    @Nullable
    private Map.Entry<Long, Long> e(long j2) {
        return this.X2.ceilingEntry(Long.valueOf(j2));
    }

    /* access modifiers changed from: private */
    public static long f(EventMessage eventMessage) {
        try {
            return Util.R1(Util.T(eventMessage.X2));
        } catch (ParserException unused) {
            return C.f9084b;
        }
    }

    private void g(long j2, long j3) {
        Long l2 = this.X2.get(Long.valueOf(j3));
        if (l2 == null || l2.longValue() > j2) {
            this.X2.put(Long.valueOf(j3), Long.valueOf(j2));
        }
    }

    /* access modifiers changed from: private */
    public static boolean h(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && (IcyHeaders.a3.equals(str2) || ExifInterface.Y4.equals(str2) || ExifInterface.Z4.equals(str2));
    }

    private void i() {
        if (this.a3) {
            this.b3 = true;
            this.a3 = false;
            this.X.a();
        }
    }

    private void l() {
        this.X.b(this.Z2);
    }

    private void p() {
        Iterator<Map.Entry<Long, Long>> it2 = this.X2.entrySet().iterator();
        while (it2.hasNext()) {
            if (((Long) it2.next().getKey()).longValue() < this.Y2.f11138h) {
                it2.remove();
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (this.c3) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        ManifestExpiryEventInfo manifestExpiryEventInfo = (ManifestExpiryEventInfo) message.obj;
        g(manifestExpiryEventInfo.f11013a, manifestExpiryEventInfo.f11014b);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean j(long j2) {
        DashManifest dashManifest = this.Y2;
        boolean z = false;
        if (!dashManifest.f11134d) {
            return false;
        }
        if (this.b3) {
            return true;
        }
        Map.Entry<Long, Long> e2 = e(dashManifest.f11138h);
        if (e2 != null && e2.getValue().longValue() < j2) {
            this.Z2 = e2.getKey().longValue();
            l();
            z = true;
        }
        if (z) {
            i();
        }
        return z;
    }

    public PlayerTrackEmsgHandler k() {
        return new PlayerTrackEmsgHandler(this.s);
    }

    /* access modifiers changed from: package-private */
    public void m(Chunk chunk) {
        this.a3 = true;
    }

    /* access modifiers changed from: package-private */
    public boolean n(boolean z) {
        if (!this.Y2.f11134d) {
            return false;
        }
        if (this.b3) {
            return true;
        }
        if (!z) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.c3 = true;
        this.Z.removeCallbacksAndMessages((Object) null);
    }

    public void q(DashManifest dashManifest) {
        this.b3 = false;
        this.Z2 = C.f9084b;
        this.Y2 = dashManifest;
        p();
    }
}
