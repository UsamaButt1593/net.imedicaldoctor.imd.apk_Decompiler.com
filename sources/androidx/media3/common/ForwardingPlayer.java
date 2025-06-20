package androidx.media3.common;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import androidx.media3.common.Player;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import java.util.List;

@UnstableApi
public class ForwardingPlayer implements Player {
    private final Player b1;

    private static final class ForwardingListener implements Player.Listener {
        private final Player.Listener X;
        private final ForwardingPlayer s;

        public ForwardingListener(ForwardingPlayer forwardingPlayer, Player.Listener listener) {
            this.s = forwardingPlayer;
            this.X = listener;
        }

        public void D(int i2) {
            this.X.D(i2);
        }

        public void E(boolean z) {
            this.X.H(z);
        }

        public void F(int i2) {
            this.X.F(i2);
        }

        public void H(boolean z) {
            this.X.H(z);
        }

        public void I(Player player, Player.Events events) {
            this.X.I(this.s, events);
        }

        public void K(float f2) {
            this.X.K(f2);
        }

        public void L(int i2) {
            this.X.L(i2);
        }

        public void M(int i2) {
            this.X.M(i2);
        }

        public void N(AudioAttributes audioAttributes) {
            this.X.N(audioAttributes);
        }

        public void S(Timeline timeline, int i2) {
            this.X.S(timeline, i2);
        }

        public void U(boolean z) {
            this.X.U(z);
        }

        public void W(int i2, boolean z) {
            this.X.W(i2, z);
        }

        public void X(boolean z, int i2) {
            this.X.X(z, i2);
        }

        public void Y(long j2) {
            this.X.Y(j2);
        }

        public void Z(MediaMetadata mediaMetadata) {
            this.X.Z(mediaMetadata);
        }

        public void a0(MediaMetadata mediaMetadata) {
            this.X.a0(mediaMetadata);
        }

        public void b0(long j2) {
            this.X.b0(j2);
        }

        public void c(VideoSize videoSize) {
            this.X.c(videoSize);
        }

        public void d0(TrackSelectionParameters trackSelectionParameters) {
            this.X.d0(trackSelectionParameters);
        }

        public void e(boolean z) {
            this.X.e(z);
        }

        public void e0() {
            this.X.e0();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingListener)) {
                return false;
            }
            ForwardingListener forwardingListener = (ForwardingListener) obj;
            if (!this.s.equals(forwardingListener.s)) {
                return false;
            }
            return this.X.equals(forwardingListener.X);
        }

        public void f0(Tracks tracks) {
            this.X.f0(tracks);
        }

        public void g0(DeviceInfo deviceInfo) {
            this.X.g0(deviceInfo);
        }

        public void h0(@Nullable MediaItem mediaItem, int i2) {
            this.X.h0(mediaItem, i2);
        }

        public int hashCode() {
            return (this.s.hashCode() * 31) + this.X.hashCode();
        }

        public void j0(@Nullable PlaybackException playbackException) {
            this.X.j0(playbackException);
        }

        public void k(PlaybackParameters playbackParameters) {
            this.X.k(playbackParameters);
        }

        public void k0(long j2) {
            this.X.k0(j2);
        }

        public void l0(boolean z, int i2) {
            this.X.l0(z, i2);
        }

        public void p(CueGroup cueGroup) {
            this.X.p(cueGroup);
        }

        public void p0(PlaybackException playbackException) {
            this.X.p0(playbackException);
        }

        public void q(Metadata metadata) {
            this.X.q(metadata);
        }

        public void s(List<Cue> list) {
            this.X.s(list);
        }

        public void s0(int i2, int i3) {
            this.X.s0(i2, i3);
        }

        public void t0(Player.Commands commands) {
            this.X.t0(commands);
        }

        public void u0(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
            this.X.u0(positionInfo, positionInfo2, i2);
        }

        public void x(int i2) {
            this.X.x(i2);
        }

        public void y0(boolean z) {
            this.X.y0(z);
        }
    }

    public ForwardingPlayer(Player player) {
        this.b1 = player;
    }

    public void A(AudioAttributes audioAttributes, boolean z) {
        this.b1.A(audioAttributes, z);
    }

    public long A0() {
        return this.b1.A0();
    }

    public long A2() {
        return this.b1.A2();
    }

    public float B() {
        return this.b1.B();
    }

    public int B0() {
        return this.b1.B0();
    }

    public boolean B2() {
        return this.b1.B2();
    }

    public DeviceInfo C() {
        return this.b1.C();
    }

    @Deprecated
    public boolean C0() {
        return this.b1.C0();
    }

    public void C1(int i2) {
        this.b1.C1(i2);
    }

    @Deprecated
    public void D() {
        this.b1.D();
    }

    public void D0() {
        this.b1.D0();
    }

    public Tracks D1() {
        return this.b1.D1();
    }

    public Player D2() {
        return this.b1;
    }

    public void E(@Nullable SurfaceView surfaceView) {
        this.b1.E(surfaceView);
    }

    public void E0() {
        this.b1.E0();
    }

    public void F(int i2, int i3, List<MediaItem> list) {
        this.b1.F(i2, i3, list);
    }

    public void F0(List<MediaItem> list, boolean z) {
        this.b1.F0(list, z);
    }

    public void F1(MediaItem mediaItem) {
        this.b1.F1(mediaItem);
    }

    public void G(long j2) {
        this.b1.G(j2);
    }

    public void H() {
        this.b1.H();
    }

    public boolean H1() {
        return this.b1.H1();
    }

    public void I(@Nullable SurfaceHolder surfaceHolder) {
        this.b1.I(surfaceHolder);
    }

    public MediaMetadata I1() {
        return this.b1.I1();
    }

    public boolean J1() {
        return this.b1.J1();
    }

    public void K0(int i2, int i3) {
        this.b1.K0(i2, i3);
    }

    public void K1(MediaItem mediaItem, long j2) {
        this.b1.K1(mediaItem, j2);
    }

    public boolean L0() {
        return this.b1.L0();
    }

    public CueGroup M() {
        return this.b1.M();
    }

    public int M1() {
        return this.b1.M1();
    }

    @Deprecated
    public void N(boolean z) {
        this.b1.N(z);
    }

    public void N0(int i2) {
        this.b1.N0(i2);
    }

    public void N1(Player.Listener listener) {
        this.b1.N1(new ForwardingListener(this, listener));
    }

    public void O(@Nullable SurfaceView surfaceView) {
        this.b1.O(surfaceView);
    }

    public int O0() {
        return this.b1.O0();
    }

    public int O1() {
        return this.b1.O1();
    }

    public int P1() {
        return this.b1.P1();
    }

    public long Q() {
        return this.b1.Q();
    }

    @Deprecated
    public void Q0() {
        this.b1.Q0();
    }

    public boolean R() {
        return this.b1.R();
    }

    public boolean R1(int i2) {
        return this.b1.R1(i2);
    }

    @Deprecated
    public boolean S0() {
        return this.b1.S0();
    }

    public Size T0() {
        return this.b1.T0();
    }

    @Deprecated
    public int U1() {
        return this.b1.U1();
    }

    @Deprecated
    public void V() {
        this.b1.V();
    }

    public void V0(MediaMetadata mediaMetadata) {
        this.b1.V0(mediaMetadata);
    }

    public boolean W0() {
        return this.b1.W0();
    }

    @Deprecated
    public void X(int i2) {
        this.b1.X(i2);
    }

    public void X1(TrackSelectionParameters trackSelectionParameters) {
        this.b1.X1(trackSelectionParameters);
    }

    public void Y(@Nullable TextureView textureView) {
        this.b1.Y(textureView);
    }

    public void Y0(int i2) {
        this.b1.Y0(i2);
    }

    public void Z(@Nullable SurfaceHolder surfaceHolder) {
        this.b1.Z(surfaceHolder);
    }

    public int Z0() {
        return this.b1.Z0();
    }

    public void a() {
        this.b1.a();
    }

    @Deprecated
    public boolean a1() {
        return this.b1.a1();
    }

    public void a2(int i2, int i3) {
        this.b1.a2(i2, i3);
    }

    @Deprecated
    public boolean b2() {
        return this.b1.b2();
    }

    public boolean c() {
        return this.b1.c();
    }

    public boolean c0() {
        return this.b1.c0();
    }

    public void c1(int i2, int i3) {
        this.b1.c1(i2, i3);
    }

    public void c2(int i2, int i3, int i4) {
        this.b1.c2(i2, i3, i4);
    }

    public AudioAttributes d() {
        return this.b1.d();
    }

    @Deprecated
    public int d1() {
        return this.b1.d1();
    }

    public long e0() {
        return this.b1.e0();
    }

    public boolean e2() {
        return this.b1.e2();
    }

    public void f(PlaybackParameters playbackParameters) {
        this.b1.f(playbackParameters);
    }

    public void f0(int i2, MediaItem mediaItem) {
        this.b1.f0(i2, mediaItem);
    }

    public void f1() {
        this.b1.f1();
    }

    public void f2(Player.Listener listener) {
        this.b1.f2(new ForwardingListener(this, listener));
    }

    public void g(float f2) {
        this.b1.g(f2);
    }

    @Deprecated
    public boolean g0() {
        return this.b1.g0();
    }

    public int g2() {
        return this.b1.g2();
    }

    public void h() {
        this.b1.h();
    }

    public long h0() {
        return this.b1.h0();
    }

    public void h1(List<MediaItem> list, int i2, long j2) {
        this.b1.h1(list, i2, j2);
    }

    public void h2(List<MediaItem> list) {
        this.b1.h2(list);
    }

    @Deprecated
    public boolean hasNext() {
        return this.b1.hasNext();
    }

    @Deprecated
    public boolean hasPrevious() {
        return this.b1.hasPrevious();
    }

    public int i() {
        return this.b1.i();
    }

    public void i0(int i2, long j2) {
        this.b1.i0(i2, j2);
    }

    public void i1(boolean z) {
        this.b1.i1(z);
    }

    @Nullable
    public PlaybackException j() {
        return this.b1.j();
    }

    public Player.Commands j0() {
        return this.b1.j0();
    }

    public Timeline j2() {
        return this.b1.j2();
    }

    public void k() {
        this.b1.k();
    }

    public void k0(boolean z, int i2) {
        this.b1.k0(z, i2);
    }

    public void k1(int i2) {
        this.b1.k1(i2);
    }

    public Looper k2() {
        return this.b1.k2();
    }

    public long l1() {
        return this.b1.l1();
    }

    public void m(float f2) {
        this.b1.m(f2);
    }

    public boolean m0() {
        return this.b1.m0();
    }

    public boolean m2() {
        return this.b1.m2();
    }

    public void n0() {
        this.b1.n0();
    }

    public long n1() {
        return this.b1.n1();
    }

    @Deprecated
    public void next() {
        this.b1.next();
    }

    public void o() {
        this.b1.o();
    }

    @Nullable
    public MediaItem o0() {
        return this.b1.o0();
    }

    public TrackSelectionParameters o2() {
        return this.b1.o2();
    }

    public void p(int i2) {
        this.b1.p(i2);
    }

    public void p0(boolean z) {
        this.b1.p0(z);
    }

    @Deprecated
    public void p1() {
        this.b1.p1();
    }

    public long p2() {
        return this.b1.p2();
    }

    @Deprecated
    public void previous() {
        this.b1.previous();
    }

    public int q() {
        return this.b1.q();
    }

    public void q1(int i2, List<MediaItem> list) {
        this.b1.q1(i2, list);
    }

    public void q2() {
        this.b1.q2();
    }

    public PlaybackParameters r() {
        return this.b1.r();
    }

    @Deprecated
    public int r1() {
        return this.b1.r1();
    }

    public void s2() {
        this.b1.s2();
    }

    public void stop() {
        this.b1.stop();
    }

    public int t0() {
        return this.b1.t0();
    }

    @Nullable
    public Object t1() {
        return this.b1.t1();
    }

    public int u() {
        return this.b1.u();
    }

    public long u1() {
        return this.b1.u1();
    }

    public void v(@Nullable Surface surface) {
        this.b1.v(surface);
    }

    public MediaItem v0(int i2) {
        return this.b1.v0(i2);
    }

    public void v2() {
        this.b1.v2();
    }

    public void w(@Nullable Surface surface) {
        this.b1.w(surface);
    }

    public long w0() {
        return this.b1.w0();
    }

    public boolean w1() {
        return this.b1.w1();
    }

    public void x(int i2, MediaItem mediaItem) {
        this.b1.x(i2, mediaItem);
    }

    public void x1(MediaItem mediaItem, boolean z) {
        this.b1.x1(mediaItem, z);
    }

    public MediaMetadata x2() {
        return this.b1.x2();
    }

    public void y(@Nullable TextureView textureView) {
        this.b1.y(textureView);
    }

    public int y0() {
        return this.b1.y0();
    }

    public void y1(MediaItem mediaItem) {
        this.b1.y1(mediaItem);
    }

    public void y2(List<MediaItem> list) {
        this.b1.y2(list);
    }

    public VideoSize z() {
        return this.b1.z();
    }

    public void z1() {
        this.b1.z1();
    }

    public long z2() {
        return this.b1.z2();
    }
}
