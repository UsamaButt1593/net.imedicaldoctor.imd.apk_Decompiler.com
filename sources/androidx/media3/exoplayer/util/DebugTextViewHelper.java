package androidx.media3.exoplayer.util;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Format;
import androidx.media3.common.L;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.ExoPlayer;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class DebugTextViewHelper {

    /* renamed from: e  reason: collision with root package name */
    private static final int f12696e = 1000;

    /* renamed from: a  reason: collision with root package name */
    private final ExoPlayer f12697a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f12698b;

    /* renamed from: c  reason: collision with root package name */
    private final Updater f12699c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12700d;

    private final class Updater implements Player.Listener, Runnable {
        private Updater() {
        }

        public /* synthetic */ void D(int i2) {
            L.s(this, i2);
        }

        public /* synthetic */ void E(boolean z) {
            L.k(this, z);
        }

        public /* synthetic */ void F(int i2) {
            L.x(this, i2);
        }

        public /* synthetic */ void H(boolean z) {
            L.i(this, z);
        }

        public /* synthetic */ void I(Player player, Player.Events events) {
            L.h(this, player, events);
        }

        public /* synthetic */ void K(float f2) {
            L.K(this, f2);
        }

        public /* synthetic */ void L(int i2) {
            L.b(this, i2);
        }

        public void M(int i2) {
            DebugTextViewHelper.this.k();
        }

        public /* synthetic */ void N(AudioAttributes audioAttributes) {
            L.a(this, audioAttributes);
        }

        public /* synthetic */ void S(Timeline timeline, int i2) {
            L.G(this, timeline, i2);
        }

        public /* synthetic */ void U(boolean z) {
            L.D(this, z);
        }

        public /* synthetic */ void W(int i2, boolean z) {
            L.g(this, i2, z);
        }

        public /* synthetic */ void X(boolean z, int i2) {
            L.v(this, z, i2);
        }

        public /* synthetic */ void Y(long j2) {
            L.B(this, j2);
        }

        public /* synthetic */ void Z(MediaMetadata mediaMetadata) {
            L.n(this, mediaMetadata);
        }

        public /* synthetic */ void a0(MediaMetadata mediaMetadata) {
            L.w(this, mediaMetadata);
        }

        public /* synthetic */ void b0(long j2) {
            L.C(this, j2);
        }

        public /* synthetic */ void c(VideoSize videoSize) {
            L.J(this, videoSize);
        }

        public /* synthetic */ void d0(TrackSelectionParameters trackSelectionParameters) {
            L.H(this, trackSelectionParameters);
        }

        public /* synthetic */ void e(boolean z) {
            L.E(this, z);
        }

        public /* synthetic */ void e0() {
            L.z(this);
        }

        public /* synthetic */ void f0(Tracks tracks) {
            L.I(this, tracks);
        }

        public /* synthetic */ void g0(DeviceInfo deviceInfo) {
            L.f(this, deviceInfo);
        }

        public /* synthetic */ void h0(MediaItem mediaItem, int i2) {
            L.m(this, mediaItem, i2);
        }

        public /* synthetic */ void j0(PlaybackException playbackException) {
            L.u(this, playbackException);
        }

        public /* synthetic */ void k(PlaybackParameters playbackParameters) {
            L.q(this, playbackParameters);
        }

        public /* synthetic */ void k0(long j2) {
            L.l(this, j2);
        }

        public void l0(boolean z, int i2) {
            DebugTextViewHelper.this.k();
        }

        public /* synthetic */ void p(CueGroup cueGroup) {
            L.d(this, cueGroup);
        }

        public /* synthetic */ void p0(PlaybackException playbackException) {
            L.t(this, playbackException);
        }

        public /* synthetic */ void q(Metadata metadata) {
            L.o(this, metadata);
        }

        public void run() {
            DebugTextViewHelper.this.k();
        }

        public /* synthetic */ void s(List list) {
            L.e(this, list);
        }

        public /* synthetic */ void s0(int i2, int i3) {
            L.F(this, i2, i3);
        }

        public /* synthetic */ void t0(Player.Commands commands) {
            L.c(this, commands);
        }

        public void u0(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
            DebugTextViewHelper.this.k();
        }

        public /* synthetic */ void x(int i2) {
            L.A(this, i2);
        }

        public /* synthetic */ void y0(boolean z) {
            L.j(this, z);
        }
    }

    public DebugTextViewHelper(ExoPlayer exoPlayer, TextView textView) {
        Assertions.a(exoPlayer.k2() == Looper.getMainLooper());
        this.f12697a = exoPlayer;
        this.f12698b = textView;
        this.f12699c = new Updater();
    }

    private static String b(@Nullable ColorInfo colorInfo) {
        if (colorInfo == null || !colorInfo.l()) {
            return "";
        }
        return " colr:" + colorInfo.p();
    }

    private static String d(DecoderCounters decoderCounters) {
        if (decoderCounters == null) {
            return "";
        }
        decoderCounters.c();
        return " sib:" + decoderCounters.f10101d + " sb:" + decoderCounters.f10103f + " rb:" + decoderCounters.f10102e + " db:" + decoderCounters.f10104g + " mcdb:" + decoderCounters.f10106i + " dk:" + decoderCounters.f10107j;
    }

    private static String e(float f2) {
        if (f2 == -1.0f || f2 == 1.0f) {
            return "";
        }
        return " par:" + String.format(Locale.US, "%.02f", new Object[]{Float.valueOf(f2)});
    }

    private static String g(long j2, int i2) {
        return i2 == 0 ? "N/A" : String.valueOf((long) (((double) j2) / ((double) i2)));
    }

    /* access modifiers changed from: protected */
    @UnstableApi
    public String a() {
        Format o1 = this.f12697a.o1();
        DecoderCounters u2 = this.f12697a.u2();
        if (o1 == null || u2 == null) {
            return "";
        }
        return StringUtils.LF + o1.f3 + "(id:" + o1.s + " hz:" + o1.t3 + " ch:" + o1.s3 + d(u2) + ")";
    }

    /* access modifiers changed from: protected */
    @UnstableApi
    public String c() {
        return f() + h() + a();
    }

    /* access modifiers changed from: protected */
    @UnstableApi
    public String f() {
        int i2 = this.f12697a.i();
        return String.format("playWhenReady:%s playbackState:%s item:%s", new Object[]{Boolean.valueOf(this.f12697a.m0()), i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "unknown" : "ended" : "ready" : "buffering" : "idle", Integer.valueOf(this.f12697a.P1())});
    }

    /* access modifiers changed from: protected */
    @UnstableApi
    public String h() {
        Format B1 = this.f12697a.B1();
        VideoSize z = this.f12697a.z();
        DecoderCounters m1 = this.f12697a.m1();
        if (B1 == null || m1 == null) {
            return "";
        }
        return StringUtils.LF + B1.f3 + "(id:" + B1.s + " r:" + z.s + "x" + z.X + b(B1.r3) + e(z.Z) + d(m1) + " vfpo: " + g(m1.f10108k, m1.f10109l) + ")";
    }

    public final void i() {
        if (!this.f12700d) {
            this.f12700d = true;
            this.f12697a.f2(this.f12699c);
            k();
        }
    }

    public final void j() {
        if (this.f12700d) {
            this.f12700d = false;
            this.f12697a.N1(this.f12699c);
            this.f12698b.removeCallbacks(this.f12699c);
        }
    }

    /* access modifiers changed from: protected */
    @UnstableApi
    @SuppressLint({"SetTextI18n"})
    public final void k() {
        this.f12698b.setText(c());
        this.f12698b.removeCallbacks(this.f12699c);
        this.f12698b.postDelayed(this.f12699c, 1000);
    }
}
