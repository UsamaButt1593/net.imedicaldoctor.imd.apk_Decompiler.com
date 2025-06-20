package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.ExternalLoader;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.google.common.base.Charsets;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

final class ExternallyLoadedMediaPeriod implements MediaPeriod {
    private final ExternalLoader X;
    /* access modifiers changed from: private */
    public final AtomicBoolean X2 = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final TrackGroupArray Y;
    /* access modifiers changed from: private */
    public final AtomicReference<Throwable> Y2 = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final byte[] Z;
    private ListenableFuture<?> Z2;
    private final Uri s;

    private final class SampleStreamImpl implements SampleStream {
        private static final int X2 = 2;
        private static final int Y = 0;
        private static final int Z = 1;
        private int s = 0;

        public SampleStreamImpl() {
        }

        public void b() throws IOException {
            Throwable th = (Throwable) ExternallyLoadedMediaPeriod.this.Y2.get();
            if (th != null) {
                throw new IOException(th);
            }
        }

        public boolean d() {
            return ExternallyLoadedMediaPeriod.this.X2.get();
        }

        public int j(long j2) {
            return 0;
        }

        public int o(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            int i3 = this.s;
            if (i3 == 2) {
                decoderInputBuffer.f(4);
                return -4;
            } else if ((i2 & 2) != 0 || i3 == 0) {
                formatHolder.f10226b = ExternallyLoadedMediaPeriod.this.Y.d(0).d(0);
                this.s = 1;
                return -5;
            } else if (!ExternallyLoadedMediaPeriod.this.X2.get()) {
                return -3;
            } else {
                int length = ExternallyLoadedMediaPeriod.this.Z.length;
                decoderInputBuffer.f(1);
                decoderInputBuffer.Y2 = 0;
                if ((i2 & 4) == 0) {
                    decoderInputBuffer.r(length);
                    decoderInputBuffer.Z.put(ExternallyLoadedMediaPeriod.this.Z, 0, length);
                }
                if ((i2 & 1) == 0) {
                    this.s = 2;
                }
                return -4;
            }
        }
    }

    public ExternallyLoadedMediaPeriod(Uri uri, String str, ExternalLoader externalLoader) {
        this.s = uri;
        Format I = new Format.Builder().k0(str).I();
        this.X = externalLoader;
        this.Y = new TrackGroupArray(new TrackGroup(I));
        this.Z = uri.toString().getBytes(Charsets.f22255c);
    }

    public boolean a(LoadingInfo loadingInfo) {
        return !this.X2.get();
    }

    public boolean c() {
        return !this.X2.get();
    }

    public long e() {
        return this.X2.get() ? Long.MIN_VALUE : 0;
    }

    public long f(long j2, SeekParameters seekParameters) {
        return j2;
    }

    public long g() {
        return this.X2.get() ? Long.MIN_VALUE : 0;
    }

    public void h(long j2) {
    }

    public /* synthetic */ List k(List list) {
        return n.a(this, list);
    }

    public void l() {
    }

    public long m(long j2) {
        return j2;
    }

    public long n(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            if (sampleStreamArr[i2] != null && (exoTrackSelectionArr[i2] == null || !zArr[i2])) {
                sampleStreamArr[i2] = null;
            }
            if (sampleStreamArr[i2] == null && exoTrackSelectionArr[i2] != null) {
                sampleStreamArr[i2] = new SampleStreamImpl();
                zArr2[i2] = true;
            }
        }
        return j2;
    }

    public void o() {
        ListenableFuture<?> listenableFuture = this.Z2;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
        }
    }

    public long q() {
        return C.f9084b;
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        callback.i(this);
        ListenableFuture<?> a2 = this.X.a(new ExternalLoader.LoadRequest(this.s));
        this.Z2 = a2;
        Futures.c(a2, new FutureCallback<Object>() {
            public void a(@Nullable Object obj) {
                ExternallyLoadedMediaPeriod.this.X2.set(true);
            }

            public void b(Throwable th) {
                ExternallyLoadedMediaPeriod.this.Y2.set(th);
            }
        }, MoreExecutors.c());
    }

    public TrackGroupArray s() {
        return this.Y;
    }

    public void t(long j2, boolean z) {
    }
}
