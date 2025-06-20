package androidx.media3.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.L;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
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
import androidx.media3.common.util.RepeatModeUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.ui.TimeBar;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
public class LegacyPlayerControlView extends FrameLayout {
    public static final int Z3 = 5000;
    public static final int a4 = 0;
    public static final int b4 = 200;
    public static final int c4 = 100;
    private static final int d4 = 1000;
    private final String A3;
    private final String B3;
    /* access modifiers changed from: private */
    @Nullable
    public Player C3;
    @Nullable
    private ProgressUpdateListener D3;
    private boolean E3;
    private boolean F3;
    private boolean G3;
    private boolean H3;
    /* access modifiers changed from: private */
    public boolean I3;
    private int J3;
    private int K3;
    /* access modifiers changed from: private */
    public int L3;
    private boolean M3;
    private boolean N3;
    private boolean O3;
    private boolean P3;
    private boolean Q3;
    private long R3;
    private long[] S3;
    private boolean[] T3;
    private long[] U3;
    private boolean[] V3;
    private long W3;
    private final CopyOnWriteArrayList<VisibilityListener> X2;
    private long X3;
    /* access modifiers changed from: private */
    @Nullable
    public final View Y2;
    private long Y3;
    /* access modifiers changed from: private */
    @Nullable
    public final View Z2;
    /* access modifiers changed from: private */
    @Nullable
    public final View a3;
    /* access modifiers changed from: private */
    @Nullable
    public final View b3;
    /* access modifiers changed from: private */
    @Nullable
    public final View c3;
    /* access modifiers changed from: private */
    @Nullable
    public final View d3;
    /* access modifiers changed from: private */
    @Nullable
    public final ImageView e3;
    /* access modifiers changed from: private */
    @Nullable
    public final ImageView f3;
    @Nullable
    private final View g3;
    @Nullable
    private final TextView h3;
    /* access modifiers changed from: private */
    @Nullable
    public final TextView i3;
    @Nullable
    private final TimeBar j3;
    /* access modifiers changed from: private */
    public final StringBuilder k3;
    /* access modifiers changed from: private */
    public final Formatter l3;
    private final Timeline.Period m3;
    private final Timeline.Window n3;
    private final Runnable o3;
    private final Runnable p3;
    private final Drawable q3;
    private final Drawable r3;
    private final ComponentListener s;
    private final Drawable s3;
    private final String t3;
    private final String u3;
    private final String v3;
    private final Drawable w3;
    private final Drawable x3;
    private final float y3;
    private final float z3;

    @RequiresApi(21)
    private static final class Api21 {
        private Api21() {
        }

        @DoNotInline
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    private final class ComponentListener implements Player.Listener, TimeBar.OnScrubListener, View.OnClickListener {
        private ComponentListener() {
        }

        public void A(TimeBar timeBar, long j2) {
            boolean unused = LegacyPlayerControlView.this.I3 = true;
            if (LegacyPlayerControlView.this.i3 != null) {
                LegacyPlayerControlView.this.i3.setText(Util.K0(LegacyPlayerControlView.this.k3, LegacyPlayerControlView.this.l3, j2));
            }
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

        public void I(Player player, Player.Events events) {
            if (events.b(4, 5)) {
                LegacyPlayerControlView.this.O();
            }
            if (events.b(4, 5, 7)) {
                LegacyPlayerControlView.this.P();
            }
            if (events.a(8)) {
                LegacyPlayerControlView.this.Q();
            }
            if (events.a(9)) {
                LegacyPlayerControlView.this.R();
            }
            if (events.b(8, 9, 11, 0, 13)) {
                LegacyPlayerControlView.this.N();
            }
            if (events.b(11, 0)) {
                LegacyPlayerControlView.this.S();
            }
        }

        public /* synthetic */ void K(float f2) {
            L.K(this, f2);
        }

        public /* synthetic */ void L(int i2) {
            L.b(this, i2);
        }

        public /* synthetic */ void M(int i2) {
            L.r(this, i2);
        }

        public /* synthetic */ void N(AudioAttributes audioAttributes) {
            L.a(this, audioAttributes);
        }

        public void O(TimeBar timeBar, long j2) {
            if (LegacyPlayerControlView.this.i3 != null) {
                LegacyPlayerControlView.this.i3.setText(Util.K0(LegacyPlayerControlView.this.k3, LegacyPlayerControlView.this.l3, j2));
            }
        }

        public void P(TimeBar timeBar, long j2, boolean z) {
            boolean unused = LegacyPlayerControlView.this.I3 = false;
            if (!z && LegacyPlayerControlView.this.C3 != null) {
                LegacyPlayerControlView legacyPlayerControlView = LegacyPlayerControlView.this;
                legacyPlayerControlView.I(legacyPlayerControlView.C3, j2);
            }
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

        public /* synthetic */ void l0(boolean z, int i2) {
            L.p(this, z, i2);
        }

        public void onClick(View view) {
            Player d2 = LegacyPlayerControlView.this.C3;
            if (d2 != null) {
                if (LegacyPlayerControlView.this.Z2 == view) {
                    d2.q2();
                } else if (LegacyPlayerControlView.this.Y2 == view) {
                    d2.f1();
                } else if (LegacyPlayerControlView.this.c3 == view) {
                    if (d2.i() != 4) {
                        d2.s2();
                    }
                } else if (LegacyPlayerControlView.this.d3 == view) {
                    d2.v2();
                } else if (LegacyPlayerControlView.this.a3 == view) {
                    Util.U0(d2);
                } else if (LegacyPlayerControlView.this.b3 == view) {
                    Util.T0(d2);
                } else if (LegacyPlayerControlView.this.e3 == view) {
                    d2.p(RepeatModeUtil.a(d2.q(), LegacyPlayerControlView.this.L3));
                } else if (LegacyPlayerControlView.this.f3 == view) {
                    d2.p0(!d2.m2());
                }
            }
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

        public /* synthetic */ void s(List list) {
            L.e(this, list);
        }

        public /* synthetic */ void s0(int i2, int i3) {
            L.F(this, i2, i3);
        }

        public /* synthetic */ void t0(Player.Commands commands) {
            L.c(this, commands);
        }

        public /* synthetic */ void u0(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
            L.y(this, positionInfo, positionInfo2, i2);
        }

        public /* synthetic */ void x(int i2) {
            L.A(this, i2);
        }

        public /* synthetic */ void y0(boolean z) {
            L.j(this, z);
        }
    }

    public interface ProgressUpdateListener {
        void a(long j2, long j3);
    }

    public interface VisibilityListener {
        void A(int i2);
    }

    static {
        MediaLibraryInfo.a("media3.ui");
    }

    public LegacyPlayerControlView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void B() {
        removeCallbacks(this.p3);
        if (this.J3 > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i2 = this.J3;
            this.R3 = uptimeMillis + ((long) i2);
            if (this.E3) {
                postDelayed(this.p3, (long) i2);
                return;
            }
            return;
        }
        this.R3 = C.f9084b;
    }

    @SuppressLint({"InlinedApi"})
    private static boolean C(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 79 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    private void F() {
        View view;
        View view2;
        boolean m2 = Util.m2(this.C3, this.G3);
        if (m2 && (view2 = this.a3) != null) {
            view2.sendAccessibilityEvent(8);
        } else if (!m2 && (view = this.b3) != null) {
            view.sendAccessibilityEvent(8);
        }
    }

    private void G() {
        View view;
        View view2;
        boolean m2 = Util.m2(this.C3, this.G3);
        if (m2 && (view2 = this.a3) != null) {
            view2.requestFocus();
        } else if (!m2 && (view = this.b3) != null) {
            view.requestFocus();
        }
    }

    private void H(Player player, int i2, long j2) {
        player.i0(i2, j2);
    }

    /* access modifiers changed from: private */
    public void I(Player player, long j2) {
        int i2;
        Timeline j22 = player.j2();
        if (this.H3 && !j22.x()) {
            int w = j22.w();
            i2 = 0;
            while (true) {
                long f2 = j22.u(i2, this.n3).f();
                if (j2 < f2) {
                    break;
                } else if (i2 == w - 1) {
                    j2 = f2;
                    break;
                } else {
                    j2 -= f2;
                    i2++;
                }
            }
        } else {
            i2 = player.P1();
        }
        H(player, i2, j2);
        P();
    }

    private void L() {
        O();
        N();
        Q();
        R();
        S();
    }

    private void M(boolean z, boolean z2, @Nullable View view) {
        if (view != null) {
            view.setEnabled(z2);
            view.setAlpha(z2 ? this.y3 : this.z3);
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* access modifiers changed from: private */
    public void N() {
        boolean z;
        boolean z2;
        boolean z4;
        boolean z5;
        boolean z6;
        if (D() && this.E3) {
            Player player = this.C3;
            if (player != null) {
                z5 = player.R1(5);
                z4 = player.R1(7);
                z2 = player.R1(11);
                z = player.R1(12);
                z6 = player.R1(9);
            } else {
                z5 = false;
                z6 = false;
                z4 = false;
                z2 = false;
                z = false;
            }
            M(this.O3, z4, this.Y2);
            M(this.M3, z2, this.d3);
            M(this.N3, z, this.c3);
            M(this.P3, z6, this.Z2);
            TimeBar timeBar = this.j3;
            if (timeBar != null) {
                timeBar.setEnabled(z5);
            }
        }
    }

    /* access modifiers changed from: private */
    public void O() {
        boolean z;
        boolean z2;
        if (D() && this.E3) {
            boolean m2 = Util.m2(this.C3, this.G3);
            View view = this.a3;
            int i2 = 8;
            boolean z4 = true;
            if (view != null) {
                z2 = !m2 && view.isFocused();
                z = Util.f9646a < 21 ? z2 : !m2 && Api21.a(this.a3);
                this.a3.setVisibility(m2 ? 0 : 8);
            } else {
                z2 = false;
                z = false;
            }
            View view2 = this.b3;
            if (view2 != null) {
                z2 |= m2 && view2.isFocused();
                if (Util.f9646a < 21) {
                    z4 = z2;
                } else if (!m2 || !Api21.a(this.b3)) {
                    z4 = false;
                }
                z |= z4;
                View view3 = this.b3;
                if (!m2) {
                    i2 = 0;
                }
                view3.setVisibility(i2);
            }
            if (z2) {
                G();
            }
            if (z) {
                F();
            }
        }
    }

    /* access modifiers changed from: private */
    public void P() {
        long j2;
        long j4;
        if (D() && this.E3) {
            Player player = this.C3;
            if (player != null) {
                j4 = this.W3 + player.n1();
                j2 = this.W3 + player.p2();
            } else {
                j4 = 0;
                j2 = 0;
            }
            boolean z = false;
            boolean z2 = j4 != this.X3;
            if (j2 != this.Y3) {
                z = true;
            }
            this.X3 = j4;
            this.Y3 = j2;
            TextView textView = this.i3;
            if (textView != null && !this.I3 && z2) {
                textView.setText(Util.K0(this.k3, this.l3, j4));
            }
            TimeBar timeBar = this.j3;
            if (timeBar != null) {
                timeBar.setPosition(j4);
                this.j3.setBufferedPosition(j2);
            }
            ProgressUpdateListener progressUpdateListener = this.D3;
            if (progressUpdateListener != null && (z2 || z)) {
                progressUpdateListener.a(j4, j2);
            }
            removeCallbacks(this.o3);
            int i2 = player == null ? 1 : player.i();
            long j5 = 1000;
            if (player != null && player.J1()) {
                TimeBar timeBar2 = this.j3;
                long min = Math.min(timeBar2 != null ? timeBar2.getPreferredUpdateDelay() : 1000, 1000 - (j4 % 1000));
                float f2 = player.r().s;
                if (f2 > 0.0f) {
                    j5 = (long) (((float) min) / f2);
                }
                postDelayed(this.o3, Util.x(j5, (long) this.K3, 1000));
            } else if (i2 != 4 && i2 != 1) {
                postDelayed(this.o3, 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    public void Q() {
        ImageView imageView;
        ImageView imageView2;
        String str;
        if (D() && this.E3 && (imageView = this.e3) != null) {
            if (this.L3 == 0) {
                M(false, false, imageView);
                return;
            }
            Player player = this.C3;
            if (player == null) {
                M(true, false, imageView);
                this.e3.setImageDrawable(this.q3);
                this.e3.setContentDescription(this.t3);
                return;
            }
            M(true, true, imageView);
            int q = player.q();
            if (q == 0) {
                this.e3.setImageDrawable(this.q3);
                imageView2 = this.e3;
                str = this.t3;
            } else if (q != 1) {
                if (q == 2) {
                    this.e3.setImageDrawable(this.s3);
                    imageView2 = this.e3;
                    str = this.v3;
                }
                this.e3.setVisibility(0);
            } else {
                this.e3.setImageDrawable(this.r3);
                imageView2 = this.e3;
                str = this.u3;
            }
            imageView2.setContentDescription(str);
            this.e3.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void R() {
        ImageView imageView;
        ImageView imageView2;
        String str;
        if (D() && this.E3 && (imageView = this.f3) != null) {
            Player player = this.C3;
            if (!this.Q3) {
                M(false, false, imageView);
                return;
            }
            if (player == null) {
                M(true, false, imageView);
                this.f3.setImageDrawable(this.x3);
                imageView2 = this.f3;
            } else {
                M(true, true, imageView);
                this.f3.setImageDrawable(player.m2() ? this.w3 : this.x3);
                imageView2 = this.f3;
                if (player.m2()) {
                    str = this.A3;
                    imageView2.setContentDescription(str);
                }
            }
            str = this.B3;
            imageView2.setContentDescription(str);
        }
    }

    /* access modifiers changed from: private */
    public void S() {
        int i2;
        Timeline.Window window;
        Player player = this.C3;
        if (player != null) {
            boolean z = true;
            this.H3 = this.F3 && x(player.j2(), this.n3);
            long j2 = 0;
            this.W3 = 0;
            Timeline j22 = player.j2();
            if (!j22.x()) {
                int P1 = player.P1();
                boolean z2 = this.H3;
                int i4 = z2 ? 0 : P1;
                int w = z2 ? j22.w() - 1 : P1;
                long j4 = 0;
                i2 = 0;
                while (true) {
                    if (i4 > w) {
                        break;
                    }
                    if (i4 == P1) {
                        this.W3 = Util.H2(j4);
                    }
                    j22.u(i4, this.n3);
                    Timeline.Window window2 = this.n3;
                    if (window2.g3 == C.f9084b) {
                        Assertions.i(this.H3 ^ z);
                        break;
                    }
                    int i5 = window2.h3;
                    while (true) {
                        window = this.n3;
                        if (i5 > window.i3) {
                            break;
                        }
                        j22.k(i5, this.m3);
                        int f2 = this.m3.f();
                        for (int t = this.m3.t(); t < f2; t++) {
                            long i6 = this.m3.i(t);
                            if (i6 == Long.MIN_VALUE) {
                                long j5 = this.m3.Z;
                                if (j5 == C.f9084b) {
                                } else {
                                    i6 = j5;
                                }
                            }
                            long s2 = i6 + this.m3.s();
                            if (s2 >= 0) {
                                long[] jArr = this.S3;
                                if (i2 == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.S3 = Arrays.copyOf(jArr, length);
                                    this.T3 = Arrays.copyOf(this.T3, length);
                                }
                                this.S3[i2] = Util.H2(j4 + s2);
                                this.T3[i2] = this.m3.u(t);
                                i2++;
                            }
                        }
                        i5++;
                    }
                    j4 += window.g3;
                    i4++;
                    z = true;
                }
                j2 = j4;
            } else {
                i2 = 0;
            }
            long H2 = Util.H2(j2);
            TextView textView = this.h3;
            if (textView != null) {
                textView.setText(Util.K0(this.k3, this.l3, H2));
            }
            TimeBar timeBar = this.j3;
            if (timeBar != null) {
                timeBar.setDuration(H2);
                int length2 = this.U3.length;
                int i7 = i2 + length2;
                long[] jArr2 = this.S3;
                if (i7 > jArr2.length) {
                    this.S3 = Arrays.copyOf(jArr2, i7);
                    this.T3 = Arrays.copyOf(this.T3, i7);
                }
                System.arraycopy(this.U3, 0, this.S3, i2, length2);
                System.arraycopy(this.V3, 0, this.T3, i2, length2);
                this.j3.b(this.S3, this.T3, i7);
            }
            P();
        }
    }

    private static boolean x(Timeline timeline, Timeline.Window window) {
        if (timeline.w() > 100) {
            return false;
        }
        int w = timeline.w();
        for (int i2 = 0; i2 < w; i2++) {
            if (timeline.u(i2, window).g3 == C.f9084b) {
                return false;
            }
        }
        return true;
    }

    private static int z(TypedArray typedArray, int i2) {
        return typedArray.getInt(R.styleable.s0, i2);
    }

    public void A() {
        if (D()) {
            setVisibility(8);
            Iterator<VisibilityListener> it2 = this.X2.iterator();
            while (it2.hasNext()) {
                it2.next().A(getVisibility());
            }
            removeCallbacks(this.o3);
            removeCallbacks(this.p3);
            this.R3 = C.f9084b;
        }
    }

    public boolean D() {
        return getVisibility() == 0;
    }

    public void E(VisibilityListener visibilityListener) {
        this.X2.remove(visibilityListener);
    }

    public void J(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        boolean z = false;
        if (jArr == null) {
            this.U3 = new long[0];
            this.V3 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) Assertions.g(zArr);
            if (jArr.length == zArr2.length) {
                z = true;
            }
            Assertions.a(z);
            this.U3 = jArr;
            this.V3 = zArr2;
        }
        S();
    }

    public void K() {
        if (!D()) {
            setVisibility(0);
            Iterator<VisibilityListener> it2 = this.X2.iterator();
            while (it2.hasNext()) {
                it2.next().A(getVisibility());
            }
            L();
            G();
            F();
        }
        B();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return y(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.p3);
        } else if (motionEvent.getAction() == 1) {
            B();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public Player getPlayer() {
        return this.C3;
    }

    public int getRepeatToggleModes() {
        return this.L3;
    }

    public boolean getShowShuffleButton() {
        return this.Q3;
    }

    public int getShowTimeoutMs() {
        return this.J3;
    }

    public boolean getShowVrButton() {
        View view = this.g3;
        return view != null && view.getVisibility() == 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.E3 = true;
        long j2 = this.R3;
        if (j2 != C.f9084b) {
            long uptimeMillis = j2 - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                A();
            } else {
                postDelayed(this.p3, uptimeMillis);
            }
        } else if (D()) {
            B();
        }
        L();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.E3 = false;
        removeCallbacks(this.o3);
        removeCallbacks(this.p3);
    }

    public void setPlayer(@Nullable Player player) {
        boolean z = false;
        Assertions.i(Looper.myLooper() == Looper.getMainLooper());
        if (player == null || player.k2() == Looper.getMainLooper()) {
            z = true;
        }
        Assertions.a(z);
        Player player2 = this.C3;
        if (player2 != player) {
            if (player2 != null) {
                player2.N1(this.s);
            }
            this.C3 = player;
            if (player != null) {
                player.f2(this.s);
            }
            L();
        }
    }

    public void setProgressUpdateListener(@Nullable ProgressUpdateListener progressUpdateListener) {
        this.D3 = progressUpdateListener;
    }

    public void setRepeatToggleModes(int i2) {
        this.L3 = i2;
        Player player = this.C3;
        if (player != null) {
            int q = player.q();
            if (i2 == 0 && q != 0) {
                this.C3.p(0);
            } else if (i2 == 1 && q == 2) {
                this.C3.p(1);
            } else if (i2 == 2 && q == 1) {
                this.C3.p(2);
            }
        }
        Q();
    }

    public void setShowFastForwardButton(boolean z) {
        this.N3 = z;
        N();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z) {
        this.F3 = z;
        S();
    }

    public void setShowNextButton(boolean z) {
        this.P3 = z;
        N();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z) {
        this.G3 = z;
        O();
    }

    public void setShowPreviousButton(boolean z) {
        this.O3 = z;
        N();
    }

    public void setShowRewindButton(boolean z) {
        this.M3 = z;
        N();
    }

    public void setShowShuffleButton(boolean z) {
        this.Q3 = z;
        R();
    }

    public void setShowTimeoutMs(int i2) {
        this.J3 = i2;
        if (D()) {
            B();
        }
    }

    public void setShowVrButton(boolean z) {
        View view = this.g3;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.K3 = Util.w(i2, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.g3;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            M(getShowVrButton(), onClickListener != null, this.g3);
        }
    }

    public void w(VisibilityListener visibilityListener) {
        Assertions.g(visibilityListener);
        this.X2.add(visibilityListener);
    }

    public boolean y(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.C3;
        if (player == null || !C(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.i() == 4) {
                return true;
            }
            player.s2();
            return true;
        } else if (keyCode == 89) {
            player.v2();
            return true;
        } else if (keyEvent.getRepeatCount() != 0) {
            return true;
        } else {
            if (keyCode == 79 || keyCode == 85) {
                Util.W0(player, this.G3);
                return true;
            } else if (keyCode == 87) {
                player.q2();
                return true;
            } else if (keyCode == 88) {
                player.f1();
                return true;
            } else if (keyCode == 126) {
                Util.U0(player);
                return true;
            } else if (keyCode != 127) {
                return true;
            } else {
                Util.T0(player);
                return true;
            }
        }
    }

    public LegacyPlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LegacyPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LegacyPlayerControlView(android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9, @androidx.annotation.Nullable android.util.AttributeSet r10) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            int r8 = androidx.media3.ui.R.layout.f14766b
            r0 = 1
            r6.G3 = r0
            r1 = 5000(0x1388, float:7.006E-42)
            r6.J3 = r1
            r1 = 0
            r6.L3 = r1
            r2 = 200(0xc8, float:2.8E-43)
            r6.K3 = r2
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.R3 = r2
            r6.M3 = r0
            r6.N3 = r0
            r6.O3 = r0
            r6.P3 = r0
            r6.Q3 = r1
            if (r10 == 0) goto L_0x008e
            android.content.res.Resources$Theme r0 = r7.getTheme()
            int[] r4 = androidx.media3.ui.R.styleable.j0
            android.content.res.TypedArray r9 = r0.obtainStyledAttributes(r10, r4, r9, r1)
            int r0 = androidx.media3.ui.R.styleable.D0     // Catch:{ all -> 0x0089 }
            int r4 = r6.J3     // Catch:{ all -> 0x0089 }
            int r0 = r9.getInt(r0, r4)     // Catch:{ all -> 0x0089 }
            r6.J3 = r0     // Catch:{ all -> 0x0089 }
            int r0 = androidx.media3.ui.R.styleable.p0     // Catch:{ all -> 0x0089 }
            int r8 = r9.getResourceId(r0, r8)     // Catch:{ all -> 0x0089 }
            int r0 = r6.L3     // Catch:{ all -> 0x0089 }
            int r0 = z(r9, r0)     // Catch:{ all -> 0x0089 }
            r6.L3 = r0     // Catch:{ all -> 0x0089 }
            int r0 = androidx.media3.ui.R.styleable.B0     // Catch:{ all -> 0x0089 }
            boolean r4 = r6.M3     // Catch:{ all -> 0x0089 }
            boolean r0 = r9.getBoolean(r0, r4)     // Catch:{ all -> 0x0089 }
            r6.M3 = r0     // Catch:{ all -> 0x0089 }
            int r0 = androidx.media3.ui.R.styleable.y0     // Catch:{ all -> 0x0089 }
            boolean r4 = r6.N3     // Catch:{ all -> 0x0089 }
            boolean r0 = r9.getBoolean(r0, r4)     // Catch:{ all -> 0x0089 }
            r6.N3 = r0     // Catch:{ all -> 0x0089 }
            int r0 = androidx.media3.ui.R.styleable.A0     // Catch:{ all -> 0x0089 }
            boolean r4 = r6.O3     // Catch:{ all -> 0x0089 }
            boolean r0 = r9.getBoolean(r0, r4)     // Catch:{ all -> 0x0089 }
            r6.O3 = r0     // Catch:{ all -> 0x0089 }
            int r0 = androidx.media3.ui.R.styleable.z0     // Catch:{ all -> 0x0089 }
            boolean r4 = r6.P3     // Catch:{ all -> 0x0089 }
            boolean r0 = r9.getBoolean(r0, r4)     // Catch:{ all -> 0x0089 }
            r6.P3 = r0     // Catch:{ all -> 0x0089 }
            int r0 = androidx.media3.ui.R.styleable.C0     // Catch:{ all -> 0x0089 }
            boolean r4 = r6.Q3     // Catch:{ all -> 0x0089 }
            boolean r0 = r9.getBoolean(r0, r4)     // Catch:{ all -> 0x0089 }
            r6.Q3 = r0     // Catch:{ all -> 0x0089 }
            int r0 = androidx.media3.ui.R.styleable.E0     // Catch:{ all -> 0x0089 }
            int r4 = r6.K3     // Catch:{ all -> 0x0089 }
            int r0 = r9.getInt(r0, r4)     // Catch:{ all -> 0x0089 }
            r6.setTimeBarMinUpdateInterval(r0)     // Catch:{ all -> 0x0089 }
            r9.recycle()
            goto L_0x008e
        L_0x0089:
            r7 = move-exception
            r9.recycle()
            throw r7
        L_0x008e:
            java.util.concurrent.CopyOnWriteArrayList r9 = new java.util.concurrent.CopyOnWriteArrayList
            r9.<init>()
            r6.X2 = r9
            androidx.media3.common.Timeline$Period r9 = new androidx.media3.common.Timeline$Period
            r9.<init>()
            r6.m3 = r9
            androidx.media3.common.Timeline$Window r9 = new androidx.media3.common.Timeline$Window
            r9.<init>()
            r6.n3 = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r6.k3 = r9
            java.util.Formatter r0 = new java.util.Formatter
            java.util.Locale r4 = java.util.Locale.getDefault()
            r0.<init>(r9, r4)
            r6.l3 = r0
            long[] r9 = new long[r1]
            r6.S3 = r9
            boolean[] r9 = new boolean[r1]
            r6.T3 = r9
            long[] r9 = new long[r1]
            r6.U3 = r9
            boolean[] r9 = new boolean[r1]
            r6.V3 = r9
            androidx.media3.ui.LegacyPlayerControlView$ComponentListener r9 = new androidx.media3.ui.LegacyPlayerControlView$ComponentListener
            r0 = 0
            r9.<init>()
            r6.s = r9
            androidx.media3.ui.e r4 = new androidx.media3.ui.e
            r4.<init>(r6)
            r6.o3 = r4
            androidx.media3.ui.f r4 = new androidx.media3.ui.f
            r4.<init>(r6)
            r6.p3 = r4
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r7)
            r4.inflate(r8, r6)
            r8 = 262144(0x40000, float:3.67342E-40)
            r6.setDescendantFocusability(r8)
            int r8 = androidx.media3.ui.R.id.D0
            android.view.View r4 = r6.findViewById(r8)
            androidx.media3.ui.TimeBar r4 = (androidx.media3.ui.TimeBar) r4
            int r5 = androidx.media3.ui.R.id.E0
            android.view.View r5 = r6.findViewById(r5)
            if (r4 == 0) goto L_0x00fa
        L_0x00f7:
            r6.j3 = r4
            goto L_0x011e
        L_0x00fa:
            if (r5 == 0) goto L_0x011c
            androidx.media3.ui.DefaultTimeBar r4 = new androidx.media3.ui.DefaultTimeBar
            r4.<init>(r7, r0, r1, r10)
            r4.setId(r8)
            android.view.ViewGroup$LayoutParams r8 = r5.getLayoutParams()
            r4.setLayoutParams(r8)
            android.view.ViewParent r8 = r5.getParent()
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            int r10 = r8.indexOfChild(r5)
            r8.removeView(r5)
            r8.addView(r4, r10)
            goto L_0x00f7
        L_0x011c:
            r6.j3 = r0
        L_0x011e:
            int r8 = androidx.media3.ui.R.id.i0
            android.view.View r8 = r6.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6.h3 = r8
            int r8 = androidx.media3.ui.R.id.B0
            android.view.View r8 = r6.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6.i3 = r8
            androidx.media3.ui.TimeBar r8 = r6.j3
            if (r8 == 0) goto L_0x0139
            r8.a(r9)
        L_0x0139:
            int r8 = androidx.media3.ui.R.id.y0
            android.view.View r8 = r6.findViewById(r8)
            r6.a3 = r8
            if (r8 == 0) goto L_0x0146
            r8.setOnClickListener(r9)
        L_0x0146:
            int r8 = androidx.media3.ui.R.id.x0
            android.view.View r8 = r6.findViewById(r8)
            r6.b3 = r8
            if (r8 == 0) goto L_0x0153
            r8.setOnClickListener(r9)
        L_0x0153:
            int r8 = androidx.media3.ui.R.id.C0
            android.view.View r8 = r6.findViewById(r8)
            r6.Y2 = r8
            if (r8 == 0) goto L_0x0160
            r8.setOnClickListener(r9)
        L_0x0160:
            int r8 = androidx.media3.ui.R.id.t0
            android.view.View r8 = r6.findViewById(r8)
            r6.Z2 = r8
            if (r8 == 0) goto L_0x016d
            r8.setOnClickListener(r9)
        L_0x016d:
            int r8 = androidx.media3.ui.R.id.G0
            android.view.View r8 = r6.findViewById(r8)
            r6.d3 = r8
            if (r8 == 0) goto L_0x017a
            r8.setOnClickListener(r9)
        L_0x017a:
            int r8 = androidx.media3.ui.R.id.m0
            android.view.View r8 = r6.findViewById(r8)
            r6.c3 = r8
            if (r8 == 0) goto L_0x0187
            r8.setOnClickListener(r9)
        L_0x0187:
            int r8 = androidx.media3.ui.R.id.F0
            android.view.View r8 = r6.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r6.e3 = r8
            if (r8 == 0) goto L_0x0196
            r8.setOnClickListener(r9)
        L_0x0196:
            int r8 = androidx.media3.ui.R.id.K0
            android.view.View r8 = r6.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r6.f3 = r8
            if (r8 == 0) goto L_0x01a5
            r8.setOnClickListener(r9)
        L_0x01a5:
            int r8 = androidx.media3.ui.R.id.S0
            android.view.View r8 = r6.findViewById(r8)
            r6.g3 = r8
            r6.setShowVrButton(r1)
            r6.M(r1, r1, r8)
            android.content.res.Resources r8 = r7.getResources()
            int r9 = androidx.media3.ui.R.integer.f14763c
            int r9 = r8.getInteger(r9)
            float r9 = (float) r9
            r10 = 1120403456(0x42c80000, float:100.0)
            float r9 = r9 / r10
            r6.y3 = r9
            int r9 = androidx.media3.ui.R.integer.f14762b
            int r9 = r8.getInteger(r9)
            float r9 = (float) r9
            float r9 = r9 / r10
            r6.z3 = r9
            int r9 = androidx.media3.ui.R.drawable.Q
            android.graphics.drawable.Drawable r9 = androidx.media3.common.util.Util.r0(r7, r8, r9)
            r6.q3 = r9
            int r9 = androidx.media3.ui.R.drawable.R
            android.graphics.drawable.Drawable r9 = androidx.media3.common.util.Util.r0(r7, r8, r9)
            r6.r3 = r9
            int r9 = androidx.media3.ui.R.drawable.P
            android.graphics.drawable.Drawable r9 = androidx.media3.common.util.Util.r0(r7, r8, r9)
            r6.s3 = r9
            int r9 = androidx.media3.ui.R.drawable.U
            android.graphics.drawable.Drawable r9 = androidx.media3.common.util.Util.r0(r7, r8, r9)
            r6.w3 = r9
            int r9 = androidx.media3.ui.R.drawable.T
            android.graphics.drawable.Drawable r7 = androidx.media3.common.util.Util.r0(r7, r8, r9)
            r6.x3 = r7
            int r7 = androidx.media3.ui.R.string.p
            java.lang.String r7 = r8.getString(r7)
            r6.t3 = r7
            int r7 = androidx.media3.ui.R.string.q
            java.lang.String r7 = r8.getString(r7)
            r6.u3 = r7
            int r7 = androidx.media3.ui.R.string.o
            java.lang.String r7 = r8.getString(r7)
            r6.v3 = r7
            int r7 = androidx.media3.ui.R.string.w
            java.lang.String r7 = r8.getString(r7)
            r6.A3 = r7
            int r7 = androidx.media3.ui.R.string.v
            java.lang.String r7 = r8.getString(r7)
            r6.B3 = r7
            r6.X3 = r2
            r6.Y3 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.LegacyPlayerControlView.<init>(android.content.Context, android.util.AttributeSet, int, android.util.AttributeSet):void");
    }
}
