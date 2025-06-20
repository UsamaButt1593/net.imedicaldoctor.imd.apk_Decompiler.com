package androidx.media3.exoplayer.video;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class VideoFrameReleaseControl {

    /* renamed from: l  reason: collision with root package name */
    public static final int f12771l = 0;

    /* renamed from: m  reason: collision with root package name */
    public static final int f12772m = 1;

    /* renamed from: n  reason: collision with root package name */
    public static final int f12773n = 2;
    public static final int o = 3;
    public static final int p = 4;
    public static final int q = 5;
    private static final long r = 50000;

    /* renamed from: a  reason: collision with root package name */
    private final FrameTimingEvaluator f12774a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoFrameReleaseHelper f12775b;

    /* renamed from: c  reason: collision with root package name */
    private final long f12776c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12777d;

    /* renamed from: e  reason: collision with root package name */
    private int f12778e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f12779f = C.f9084b;

    /* renamed from: g  reason: collision with root package name */
    private long f12780g;

    /* renamed from: h  reason: collision with root package name */
    private long f12781h = C.f9084b;

    /* renamed from: i  reason: collision with root package name */
    private long f12782i = C.f9084b;

    /* renamed from: j  reason: collision with root package name */
    private float f12783j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    private Clock f12784k = Clock.f9502a;

    @UnstableApi
    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FrameReleaseAction {
    }

    public static class FrameReleaseInfo {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public long f12785a = C.f9084b;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public long f12786b = C.f9084b;

        /* access modifiers changed from: private */
        public void h() {
            this.f12785a = C.f9084b;
            this.f12786b = C.f9084b;
        }

        public long f() {
            return this.f12785a;
        }

        public long g() {
            return this.f12786b;
        }
    }

    public interface FrameTimingEvaluator {
        boolean D(long j2, long j3);

        boolean j(long j2, long j3, long j4, boolean z, boolean z2) throws ExoPlaybackException;

        boolean w(long j2, long j3, boolean z);
    }

    public VideoFrameReleaseControl(Context context, FrameTimingEvaluator frameTimingEvaluator, long j2) {
        this.f12774a = frameTimingEvaluator;
        this.f12776c = j2;
        this.f12775b = new VideoFrameReleaseHelper(context);
    }

    private long b(long j2, long j3, long j4) {
        long j5 = (long) (((double) (j4 - j2)) / ((double) this.f12783j));
        return this.f12777d ? j5 - (Util.I1(this.f12784k.b()) - j3) : j5;
    }

    private void f(int i2) {
        this.f12778e = Math.min(this.f12778e, i2);
    }

    private boolean s(long j2, long j3, long j4) {
        if (this.f12782i != C.f9084b) {
            return false;
        }
        int i2 = this.f12778e;
        if (i2 == 0) {
            return this.f12777d;
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 == 2) {
            return j2 >= j4;
        }
        if (i2 == 3) {
            return this.f12777d && this.f12774a.D(j3, Util.I1(this.f12784k.b()) - this.f12780g);
        }
        throw new IllegalStateException();
    }

    public void a() {
        if (this.f12778e == 0) {
            this.f12778e = 1;
        }
    }

    public int c(long j2, long j3, long j4, long j5, boolean z, FrameReleaseInfo frameReleaseInfo) throws ExoPlaybackException {
        long j6 = j2;
        long j7 = j3;
        FrameReleaseInfo frameReleaseInfo2 = frameReleaseInfo;
        frameReleaseInfo.h();
        if (this.f12779f == C.f9084b) {
            this.f12779f = j7;
        }
        if (this.f12781h != j6) {
            this.f12775b.h(j6);
            this.f12781h = j6;
        }
        long unused = frameReleaseInfo2.f12785a = b(j3, j4, j2);
        boolean z2 = false;
        if (s(j3, frameReleaseInfo.f12785a, j5)) {
            return 0;
        }
        if (!this.f12777d || j7 == this.f12779f) {
            return 5;
        }
        long c2 = this.f12784k.c();
        long unused2 = frameReleaseInfo2.f12786b = this.f12775b.b((frameReleaseInfo.f12785a * 1000) + c2);
        long unused3 = frameReleaseInfo2.f12785a = (frameReleaseInfo.f12786b - c2) / 1000;
        if (this.f12782i != C.f9084b) {
            z2 = true;
        }
        if (this.f12774a.j(frameReleaseInfo.f12785a, j3, j4, z, z2)) {
            return 4;
        }
        return this.f12774a.w(frameReleaseInfo.f12785a, j4, z) ? z2 ? 3 : 2 : frameReleaseInfo.f12785a > r ? 5 : 1;
    }

    public boolean d(boolean z) {
        if (z && this.f12778e == 3) {
            this.f12782i = C.f9084b;
            return true;
        } else if (this.f12782i == C.f9084b) {
            return false;
        } else {
            if (this.f12784k.b() < this.f12782i) {
                return true;
            }
            this.f12782i = C.f9084b;
            return false;
        }
    }

    public void e() {
        this.f12782i = this.f12776c > 0 ? this.f12784k.b() + this.f12776c : C.f9084b;
    }

    public void g() {
        f(0);
    }

    public void h(boolean z) {
        this.f12778e = z ? 1 : 0;
    }

    public boolean i() {
        boolean z = this.f12778e != 3;
        this.f12778e = 3;
        this.f12780g = Util.I1(this.f12784k.b());
        return z;
    }

    public void j() {
        f(2);
    }

    public void k() {
        this.f12777d = true;
        this.f12780g = Util.I1(this.f12784k.b());
        this.f12775b.k();
    }

    public void l() {
        this.f12777d = false;
        this.f12782i = C.f9084b;
        this.f12775b.l();
    }

    public void m() {
        this.f12775b.j();
        this.f12781h = C.f9084b;
        this.f12779f = C.f9084b;
        f(1);
        this.f12782i = C.f9084b;
    }

    public void n(int i2) {
        this.f12775b.o(i2);
    }

    public void o(Clock clock) {
        this.f12784k = clock;
    }

    public void p(float f2) {
        this.f12775b.g(f2);
    }

    public void q(@Nullable Surface surface) {
        this.f12775b.m(surface);
        f(1);
    }

    public void r(float f2) {
        this.f12783j = f2;
        this.f12775b.i(f2);
    }
}
