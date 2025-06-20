package androidx.media3.exoplayer.audio;

import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.dash.DashMediaSource;
import java.lang.reflect.Method;
import net.lingala.zip4j.util.InternalZipConstants;

final class AudioTrackPositionTracker {
    private static final int K = 1;
    private static final int L = 2;
    private static final int M = 3;
    private static final long N = 5000000;
    private static final long O = 5000000;
    private static final long P = 1000000;
    private static final long Q = 5;
    private static final long R = 200;
    private static final int S = 10;
    private static final int T = 30000;
    private static final int U = 500000;
    private long A;
    private long B;
    private long C;
    private long D;
    private boolean E;
    private long F;
    private long G;
    private boolean H;
    private long I;
    private Clock J;

    /* renamed from: a  reason: collision with root package name */
    private final Listener f10811a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f10812b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private AudioTrack f10813c;

    /* renamed from: d  reason: collision with root package name */
    private int f10814d;

    /* renamed from: e  reason: collision with root package name */
    private int f10815e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private AudioTimestampPoller f10816f;

    /* renamed from: g  reason: collision with root package name */
    private int f10817g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10818h;

    /* renamed from: i  reason: collision with root package name */
    private long f10819i;

    /* renamed from: j  reason: collision with root package name */
    private float f10820j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10821k;

    /* renamed from: l  reason: collision with root package name */
    private long f10822l;

    /* renamed from: m  reason: collision with root package name */
    private long f10823m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private Method f10824n;
    private long o;
    private boolean p;
    private boolean q;
    private long r;
    private long s;
    private long t;
    private long u;
    private long v;
    private int w;
    private int x;
    private long y;
    private long z;

    public interface Listener {
        void a(long j2);

        void b(int i2, long j2);

        void c(long j2);

        void d(long j2, long j3, long j4, long j5);

        void e(long j2, long j3, long j4, long j5);
    }

    public AudioTrackPositionTracker(Listener listener) {
        this.f10811a = (Listener) Assertions.g(listener);
        if (Util.f9646a >= 18) {
            try {
                this.f10824n = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f10812b = new long[10];
        this.J = Clock.f9502a;
    }

    private boolean b() {
        return this.f10818h && ((AudioTrack) Assertions.g(this.f10813c)).getPlayState() == 2 && e() == 0;
    }

    private long e() {
        long b2 = this.J.b();
        if (this.y == C.f9084b) {
            if (b2 - this.s >= 5) {
                w(b2);
                this.s = b2;
            }
            return this.t + this.I + (this.u << 32);
        } else if (((AudioTrack) Assertions.g(this.f10813c)).getPlayState() == 2) {
            return this.A;
        } else {
            return Math.min(this.B, this.A + Util.P(Util.A0(Util.I1(b2) - this.y, this.f10820j), this.f10817g));
        }
    }

    private long f() {
        return Util.b2(e(), this.f10817g);
    }

    private void l(long j2) {
        AudioTimestampPoller audioTimestampPoller = (AudioTimestampPoller) Assertions.g(this.f10816f);
        if (audioTimestampPoller.f(j2)) {
            long c2 = audioTimestampPoller.c();
            long b2 = audioTimestampPoller.b();
            long f2 = f();
            if (Math.abs(c2 - j2) > DashMediaSource.N3) {
                this.f10811a.e(b2, c2, j2, f2);
            } else if (Math.abs(Util.b2(b2, this.f10817g) - f2) > DashMediaSource.N3) {
                this.f10811a.d(b2, c2, j2, f2);
            } else {
                audioTimestampPoller.a();
                return;
            }
            audioTimestampPoller.g();
        }
    }

    private void m() {
        long c2 = this.J.c() / 1000;
        if (c2 - this.f10823m >= 30000) {
            long f2 = f();
            if (f2 != 0) {
                this.f10812b[this.w] = Util.G0(f2, this.f10820j) - c2;
                this.w = (this.w + 1) % 10;
                int i2 = this.x;
                if (i2 < 10) {
                    this.x = i2 + 1;
                }
                this.f10823m = c2;
                this.f10822l = 0;
                int i3 = 0;
                while (true) {
                    int i4 = this.x;
                    if (i3 >= i4) {
                        break;
                    }
                    this.f10822l += this.f10812b[i3] / ((long) i4);
                    i3++;
                }
            } else {
                return;
            }
        }
        if (!this.f10818h) {
            l(c2);
            n(c2);
        }
    }

    private void n(long j2) {
        Method method;
        if (this.q && (method = this.f10824n) != null && j2 - this.r >= 500000) {
            try {
                long intValue = (((long) ((Integer) Util.o((Integer) method.invoke(Assertions.g(this.f10813c), (Object[]) null))).intValue()) * 1000) - this.f10819i;
                this.o = intValue;
                long max = Math.max(intValue, 0);
                this.o = max;
                if (max > DashMediaSource.N3) {
                    this.f10811a.c(max);
                    this.o = 0;
                }
            } catch (Exception unused) {
                this.f10824n = null;
            }
            this.r = j2;
        }
    }

    private static boolean o(int i2) {
        return Util.f9646a < 23 && (i2 == 5 || i2 == 6);
    }

    private void r() {
        this.f10822l = 0;
        this.x = 0;
        this.w = 0;
        this.f10823m = 0;
        this.D = 0;
        this.G = 0;
        this.f10821k = false;
    }

    private void w(long j2) {
        AudioTrack audioTrack = (AudioTrack) Assertions.g(this.f10813c);
        int playState = audioTrack.getPlayState();
        if (playState != 1) {
            long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & InternalZipConstants.f30717k;
            if (this.f10818h) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.v = this.t;
                }
                playbackHeadPosition += this.v;
            }
            if (Util.f9646a <= 29) {
                if (playbackHeadPosition != 0 || this.t <= 0 || playState != 3) {
                    this.z = C.f9084b;
                } else if (this.z == C.f9084b) {
                    this.z = j2;
                    return;
                } else {
                    return;
                }
            }
            long j3 = this.t;
            if (j3 > playbackHeadPosition) {
                if (this.H) {
                    this.I += j3;
                    this.H = false;
                } else {
                    this.u++;
                }
            }
            this.t = playbackHeadPosition;
        }
    }

    public void a() {
        this.H = true;
    }

    public int c(long j2) {
        return this.f10815e - ((int) (j2 - (e() * ((long) this.f10814d))));
    }

    public long d(boolean z2) {
        long j2;
        if (((AudioTrack) Assertions.g(this.f10813c)).getPlayState() == 3) {
            m();
        }
        long c2 = this.J.c() / 1000;
        AudioTimestampPoller audioTimestampPoller = (AudioTimestampPoller) Assertions.g(this.f10816f);
        boolean d2 = audioTimestampPoller.d();
        if (d2) {
            j2 = Util.b2(audioTimestampPoller.b(), this.f10817g) + Util.A0(c2 - audioTimestampPoller.c(), this.f10820j);
        } else {
            j2 = this.x == 0 ? f() : Util.A0(this.f10822l + c2, this.f10820j);
            if (!z2) {
                j2 = Math.max(0, j2 - this.o);
            }
        }
        if (this.E != d2) {
            this.G = this.D;
            this.F = this.C;
        }
        long j3 = c2 - this.G;
        if (j3 < 1000000) {
            long j4 = (j3 * 1000) / 1000000;
            j2 = ((j2 * j4) + ((1000 - j4) * (this.F + Util.A0(j3, this.f10820j)))) / 1000;
        }
        if (!this.f10821k) {
            long j5 = this.C;
            if (j2 > j5) {
                this.f10821k = true;
                this.f10811a.a(this.J.a() - Util.H2(Util.G0(Util.H2(j2 - j5), this.f10820j)));
            }
        }
        this.D = c2;
        this.C = j2;
        this.E = d2;
        return j2;
    }

    public void g(long j2) {
        this.A = e();
        this.y = Util.I1(this.J.b());
        this.B = j2;
    }

    public boolean h(long j2) {
        return j2 > Util.P(d(false), this.f10817g) || b();
    }

    public boolean i() {
        return ((AudioTrack) Assertions.g(this.f10813c)).getPlayState() == 3;
    }

    public boolean j(long j2) {
        return this.z != C.f9084b && j2 > 0 && this.J.b() - this.z >= R;
    }

    public boolean k(long j2) {
        int playState = ((AudioTrack) Assertions.g(this.f10813c)).getPlayState();
        if (this.f10818h) {
            if (playState == 2) {
                this.p = false;
                return false;
            } else if (playState == 1 && e() == 0) {
                return false;
            }
        }
        boolean z2 = this.p;
        boolean h2 = h(j2);
        this.p = h2;
        if (z2 && !h2 && playState != 1) {
            this.f10811a.b(this.f10815e, Util.H2(this.f10819i));
        }
        return true;
    }

    public boolean p() {
        r();
        if (this.y == C.f9084b) {
            ((AudioTimestampPoller) Assertions.g(this.f10816f)).h();
            return true;
        }
        this.A = e();
        return false;
    }

    public void q() {
        r();
        this.f10813c = null;
        this.f10816f = null;
    }

    public void s(AudioTrack audioTrack, boolean z2, int i2, int i3, int i4) {
        this.f10813c = audioTrack;
        this.f10814d = i3;
        this.f10815e = i4;
        this.f10816f = new AudioTimestampPoller(audioTrack);
        this.f10817g = audioTrack.getSampleRate();
        this.f10818h = z2 && o(i2);
        boolean i1 = Util.i1(i2);
        this.q = i1;
        this.f10819i = i1 ? Util.b2((long) (i4 / i3), this.f10817g) : -9223372036854775807L;
        this.t = 0;
        this.u = 0;
        this.H = false;
        this.I = 0;
        this.v = 0;
        this.p = false;
        this.y = C.f9084b;
        this.z = C.f9084b;
        this.r = 0;
        this.o = 0;
        this.f10820j = 1.0f;
    }

    public void t(float f2) {
        this.f10820j = f2;
        AudioTimestampPoller audioTimestampPoller = this.f10816f;
        if (audioTimestampPoller != null) {
            audioTimestampPoller.h();
        }
        r();
    }

    public void u(Clock clock) {
        this.J = clock;
    }

    public void v() {
        if (this.y != C.f9084b) {
            this.y = Util.I1(this.J.b());
        }
        ((AudioTimestampPoller) Assertions.g(this.f10816f)).h();
    }
}
