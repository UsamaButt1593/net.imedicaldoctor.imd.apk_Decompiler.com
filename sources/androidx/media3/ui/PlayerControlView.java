package androidx.media3.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Format;
import androidx.media3.common.L;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.RepeatModeUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.ui.TimeBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
public class PlayerControlView extends FrameLayout {
    public static final int s4 = 5000;
    public static final int t4 = 0;
    public static final int u4 = 200;
    public static final int v4 = 100;
    private static final int w4 = 1000;
    private static final float[] x4 = {0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    private static final int y4 = 0;
    private static final int z4 = 1;
    @Nullable
    private final TimeBar A3;
    /* access modifiers changed from: private */
    public final StringBuilder B3;
    /* access modifiers changed from: private */
    public final Formatter C3;
    private final Timeline.Period D3;
    private final Timeline.Window E3;
    private final Runnable F3;
    private final Drawable G3;
    private final Drawable H3;
    private final Drawable I3;
    private final String J3;
    private final String K3;
    private final String L3;
    private final Drawable M3;
    private final Drawable N3;
    private final float O3;
    private final float P3;
    private final String Q3;
    private final String R3;
    /* access modifiers changed from: private */
    public final Drawable S3;
    /* access modifiers changed from: private */
    public final Drawable T3;
    /* access modifiers changed from: private */
    public final String U3;
    /* access modifiers changed from: private */
    public final String V3;
    private final Drawable W3;
    private final Resources X2;
    private final Drawable X3;
    private final ComponentListener Y2;
    private final String Y3;
    private final CopyOnWriteArrayList<VisibilityListener> Z2;
    private final String Z3;
    private final RecyclerView a3;
    /* access modifiers changed from: private */
    @Nullable
    public Player a4;
    /* access modifiers changed from: private */
    public final SettingsAdapter b3;
    @Nullable
    private ProgressUpdateListener b4;
    /* access modifiers changed from: private */
    public final PlaybackSpeedAdapter c3;
    @Nullable
    private OnFullScreenModeChangedListener c4;
    /* access modifiers changed from: private */
    public final TextTrackSelectionAdapter d3;
    private boolean d4;
    /* access modifiers changed from: private */
    public final AudioTrackSelectionAdapter e3;
    private boolean e4;
    private final TrackNameProvider f3;
    private boolean f4;
    /* access modifiers changed from: private */
    public final PopupWindow g3;
    /* access modifiers changed from: private */
    public boolean g4;
    private final int h3;
    private boolean h4;
    /* access modifiers changed from: private */
    @Nullable
    public final View i3;
    /* access modifiers changed from: private */
    public boolean i4;
    /* access modifiers changed from: private */
    @Nullable
    public final View j3;
    private int j4;
    /* access modifiers changed from: private */
    @Nullable
    public final View k3;
    private int k4;
    /* access modifiers changed from: private */
    @Nullable
    public final View l3;
    /* access modifiers changed from: private */
    public int l4;
    /* access modifiers changed from: private */
    @Nullable
    public final View m3;
    private long[] m4;
    @Nullable
    private final TextView n3;
    private boolean[] n4;
    @Nullable
    private final TextView o3;
    private long[] o4;
    /* access modifiers changed from: private */
    @Nullable
    public final ImageView p3;
    private boolean[] p4;
    /* access modifiers changed from: private */
    @Nullable
    public final ImageView q3;
    private long q4;
    @Nullable
    private final View r3;
    /* access modifiers changed from: private */
    public boolean r4;
    /* access modifiers changed from: private */
    public final PlayerControlViewLayoutManager s;
    /* access modifiers changed from: private */
    @Nullable
    public final ImageView s3;
    @Nullable
    private final ImageView t3;
    @Nullable
    private final ImageView u3;
    /* access modifiers changed from: private */
    @Nullable
    public final View v3;
    /* access modifiers changed from: private */
    @Nullable
    public final View w3;
    /* access modifiers changed from: private */
    @Nullable
    public final View x3;
    @Nullable
    private final TextView y3;
    /* access modifiers changed from: private */
    @Nullable
    public final TextView z3;

    private final class AudioTrackSelectionAdapter extends TrackSelectionAdapter {
        private AudioTrackSelectionAdapter() {
            super();
        }

        private boolean m0(TrackSelectionParameters trackSelectionParameters) {
            for (int i2 = 0; i2 < this.f14642d.size(); i2++) {
                if (trackSelectionParameters.t3.containsKey(this.f14642d.get(i2).f14639a.d())) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n0(View view) {
            if (PlayerControlView.this.a4 != null && PlayerControlView.this.a4.R1(29)) {
                ((Player) Util.o(PlayerControlView.this.a4)).X1(PlayerControlView.this.a4.o2().G().G(1).r0(1, false).D());
                PlayerControlView.this.b3.g0(1, PlayerControlView.this.getResources().getString(R.string.I));
                PlayerControlView.this.g3.dismiss();
            }
        }

        public void f0(List<TrackInformation> list) {
            SettingsAdapter w;
            String str;
            Resources resources;
            int i2;
            this.f14642d = list;
            TrackSelectionParameters o2 = ((Player) Assertions.g(PlayerControlView.this.a4)).o2();
            if (list.isEmpty()) {
                w = PlayerControlView.this.b3;
                resources = PlayerControlView.this.getResources();
                i2 = R.string.J;
            } else if (!m0(o2)) {
                w = PlayerControlView.this.b3;
                resources = PlayerControlView.this.getResources();
                i2 = R.string.I;
            } else {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    TrackInformation trackInformation = list.get(i3);
                    if (trackInformation.a()) {
                        w = PlayerControlView.this.b3;
                        str = trackInformation.f14641c;
                        w.g0(1, str);
                    }
                }
                return;
            }
            str = resources.getString(i2);
            w.g0(1, str);
        }

        public void i0(SubSettingViewHolder subSettingViewHolder) {
            subSettingViewHolder.I.setText(R.string.I);
            subSettingViewHolder.J.setVisibility(m0(((Player) Assertions.g(PlayerControlView.this.a4)).o2()) ? 4 : 0);
            subSettingViewHolder.f15587a.setOnClickListener(new C0370j(this));
        }

        public void k0(String str) {
            PlayerControlView.this.b3.g0(1, str);
        }
    }

    private final class ComponentListener implements Player.Listener, TimeBar.OnScrubListener, View.OnClickListener, PopupWindow.OnDismissListener {
        private ComponentListener() {
        }

        public void A(TimeBar timeBar, long j2) {
            boolean unused = PlayerControlView.this.i4 = true;
            if (PlayerControlView.this.z3 != null) {
                PlayerControlView.this.z3.setText(Util.K0(PlayerControlView.this.B3, PlayerControlView.this.C3, j2));
            }
            PlayerControlView.this.s.W();
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
            if (events.b(4, 5, 13)) {
                PlayerControlView.this.w0();
            }
            if (events.b(4, 5, 7, 13)) {
                PlayerControlView.this.y0();
            }
            if (events.b(8, 13)) {
                PlayerControlView.this.z0();
            }
            if (events.b(9, 13)) {
                PlayerControlView.this.D0();
            }
            if (events.b(8, 9, 11, 0, 16, 17, 13)) {
                PlayerControlView.this.v0();
            }
            if (events.b(11, 0, 13)) {
                PlayerControlView.this.E0();
            }
            if (events.b(12, 13)) {
                PlayerControlView.this.x0();
            }
            if (events.b(2, 13)) {
                PlayerControlView.this.F0();
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
            if (PlayerControlView.this.z3 != null) {
                PlayerControlView.this.z3.setText(Util.K0(PlayerControlView.this.B3, PlayerControlView.this.C3, j2));
            }
        }

        public void P(TimeBar timeBar, long j2, boolean z) {
            boolean unused = PlayerControlView.this.i4 = false;
            if (!z && PlayerControlView.this.a4 != null) {
                PlayerControlView playerControlView = PlayerControlView.this;
                playerControlView.m0(playerControlView.a4, j2);
            }
            PlayerControlView.this.s.X();
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
            PlayerControlView playerControlView;
            RecyclerView.Adapter E;
            View D;
            Player j2 = PlayerControlView.this.a4;
            if (j2 != null) {
                PlayerControlView.this.s.X();
                if (PlayerControlView.this.j3 == view) {
                    if (j2.R1(9)) {
                        j2.q2();
                    }
                } else if (PlayerControlView.this.i3 == view) {
                    if (j2.R1(7)) {
                        j2.f1();
                    }
                } else if (PlayerControlView.this.l3 == view) {
                    if (j2.i() != 4 && j2.R1(12)) {
                        j2.s2();
                    }
                } else if (PlayerControlView.this.m3 == view) {
                    if (j2.R1(11)) {
                        j2.v2();
                    }
                } else if (PlayerControlView.this.k3 == view) {
                    Util.W0(j2, PlayerControlView.this.g4);
                } else if (PlayerControlView.this.p3 == view) {
                    if (j2.R1(15)) {
                        j2.p(RepeatModeUtil.a(j2.q(), PlayerControlView.this.l4));
                    }
                } else if (PlayerControlView.this.q3 != view) {
                    if (PlayerControlView.this.v3 == view) {
                        PlayerControlView.this.s.W();
                        playerControlView = PlayerControlView.this;
                        E = playerControlView.b3;
                        D = PlayerControlView.this.v3;
                    } else if (PlayerControlView.this.w3 == view) {
                        PlayerControlView.this.s.W();
                        playerControlView = PlayerControlView.this;
                        E = playerControlView.c3;
                        D = PlayerControlView.this.w3;
                    } else if (PlayerControlView.this.x3 == view) {
                        PlayerControlView.this.s.W();
                        playerControlView = PlayerControlView.this;
                        E = playerControlView.e3;
                        D = PlayerControlView.this.x3;
                    } else if (PlayerControlView.this.s3 == view) {
                        PlayerControlView.this.s.W();
                        playerControlView = PlayerControlView.this;
                        E = playerControlView.d3;
                        D = PlayerControlView.this.s3;
                    } else {
                        return;
                    }
                    playerControlView.V(E, D);
                } else if (j2.R1(14)) {
                    j2.p0(!j2.m2());
                }
            }
        }

        public void onDismiss() {
            if (PlayerControlView.this.r4) {
                PlayerControlView.this.s.X();
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

    @Deprecated
    public interface OnFullScreenModeChangedListener {
        void O(boolean z);
    }

    private final class PlaybackSpeedAdapter extends RecyclerView.Adapter<SubSettingViewHolder> {

        /* renamed from: d  reason: collision with root package name */
        private final String[] f14630d;

        /* renamed from: e  reason: collision with root package name */
        private final float[] f14631e;

        /* renamed from: f  reason: collision with root package name */
        private int f14632f;

        public PlaybackSpeedAdapter(String[] strArr, float[] fArr) {
            this.f14630d = strArr;
            this.f14631e = fArr;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f0(int i2, View view) {
            if (i2 != this.f14632f) {
                PlayerControlView.this.setPlaybackSpeed(this.f14631e[i2]);
            }
            PlayerControlView.this.g3.dismiss();
        }

        public int b() {
            return this.f14630d.length;
        }

        public String e0() {
            return this.f14630d[this.f14632f];
        }

        /* renamed from: g0 */
        public void R(SubSettingViewHolder subSettingViewHolder, int i2) {
            View view;
            String[] strArr = this.f14630d;
            if (i2 < strArr.length) {
                subSettingViewHolder.I.setText(strArr[i2]);
            }
            int i3 = 0;
            if (i2 == this.f14632f) {
                subSettingViewHolder.f15587a.setSelected(true);
                view = subSettingViewHolder.J;
            } else {
                subSettingViewHolder.f15587a.setSelected(false);
                view = subSettingViewHolder.J;
                i3 = 4;
            }
            view.setVisibility(i3);
            subSettingViewHolder.f15587a.setOnClickListener(new C0371k(this, i2));
        }

        /* renamed from: h0 */
        public SubSettingViewHolder T(ViewGroup viewGroup, int i2) {
            return new SubSettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R.layout.f14774j, viewGroup, false));
        }

        public void i0(float f2) {
            int i2 = 0;
            int i3 = 0;
            float f3 = Float.MAX_VALUE;
            while (true) {
                float[] fArr = this.f14631e;
                if (i2 < fArr.length) {
                    float abs = Math.abs(f2 - fArr[i2]);
                    if (abs < f3) {
                        i3 = i2;
                        f3 = abs;
                    }
                    i2++;
                } else {
                    this.f14632f = i3;
                    return;
                }
            }
        }
    }

    public interface ProgressUpdateListener {
        void a(long j2, long j3);
    }

    private final class SettingViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;
        /* access modifiers changed from: private */
        public final TextView J;
        /* access modifiers changed from: private */
        public final ImageView K;

        public SettingViewHolder(View view) {
            super(view);
            if (Util.f9646a < 26) {
                view.setFocusable(true);
            }
            this.I = (TextView) view.findViewById(R.id.q0);
            this.J = (TextView) view.findViewById(R.id.M0);
            this.K = (ImageView) view.findViewById(R.id.p0);
            view.setOnClickListener(new C0372l(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m0(View view) {
            PlayerControlView.this.j0(D());
        }
    }

    private class SettingsAdapter extends RecyclerView.Adapter<SettingViewHolder> {

        /* renamed from: d  reason: collision with root package name */
        private final String[] f14634d;

        /* renamed from: e  reason: collision with root package name */
        private final String[] f14635e;

        /* renamed from: f  reason: collision with root package name */
        private final Drawable[] f14636f;

        public SettingsAdapter(String[] strArr, Drawable[] drawableArr) {
            this.f14634d = strArr;
            this.f14635e = new String[strArr.length];
            this.f14636f = drawableArr;
        }

        private boolean h0(int i2) {
            if (PlayerControlView.this.a4 == null) {
                return false;
            }
            if (i2 == 0) {
                return PlayerControlView.this.a4.R1(13);
            }
            if (i2 != 1) {
                return true;
            }
            return PlayerControlView.this.a4.R1(30) && PlayerControlView.this.a4.R1(29);
        }

        public long B(int i2) {
            return (long) i2;
        }

        public int b() {
            return this.f14634d.length;
        }

        public boolean d0() {
            return h0(1) || h0(0);
        }

        /* renamed from: e0 */
        public void R(SettingViewHolder settingViewHolder, int i2) {
            View view;
            RecyclerView.LayoutParams layoutParams;
            if (h0(i2)) {
                view = settingViewHolder.f15587a;
                layoutParams = new RecyclerView.LayoutParams(-1, -2);
            } else {
                view = settingViewHolder.f15587a;
                layoutParams = new RecyclerView.LayoutParams(0, 0);
            }
            view.setLayoutParams(layoutParams);
            settingViewHolder.I.setText(this.f14634d[i2]);
            if (this.f14635e[i2] == null) {
                settingViewHolder.J.setVisibility(8);
            } else {
                settingViewHolder.J.setText(this.f14635e[i2]);
            }
            Drawable drawable = this.f14636f[i2];
            ImageView l0 = settingViewHolder.K;
            if (drawable == null) {
                l0.setVisibility(8);
            } else {
                l0.setImageDrawable(this.f14636f[i2]);
            }
        }

        /* renamed from: f0 */
        public SettingViewHolder T(ViewGroup viewGroup, int i2) {
            return new SettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R.layout.f14773i, viewGroup, false));
        }

        public void g0(int i2, String str) {
            this.f14635e[i2] = str;
        }
    }

    private static class SubSettingViewHolder extends RecyclerView.ViewHolder {
        public final TextView I;
        public final View J;

        public SubSettingViewHolder(View view) {
            super(view);
            if (Util.f9646a < 26) {
                view.setFocusable(true);
            }
            this.I = (TextView) view.findViewById(R.id.P0);
            this.J = view.findViewById(R.id.d0);
        }
    }

    private final class TextTrackSelectionAdapter extends TrackSelectionAdapter {
        private TextTrackSelectionAdapter() {
            super();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m0(View view) {
            if (PlayerControlView.this.a4 != null && PlayerControlView.this.a4.R1(29)) {
                PlayerControlView.this.a4.X1(PlayerControlView.this.a4.o2().G().G(3).R(-3).D());
                PlayerControlView.this.g3.dismiss();
            }
        }

        public void f0(List<TrackInformation> list) {
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                } else if (list.get(i2).a()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (PlayerControlView.this.s3 != null) {
                ImageView D = PlayerControlView.this.s3;
                PlayerControlView playerControlView = PlayerControlView.this;
                D.setImageDrawable(z ? playerControlView.S3 : playerControlView.T3);
                PlayerControlView.this.s3.setContentDescription(z ? PlayerControlView.this.U3 : PlayerControlView.this.V3);
            }
            this.f14642d = list;
        }

        /* renamed from: h0 */
        public void R(SubSettingViewHolder subSettingViewHolder, int i2) {
            super.R(subSettingViewHolder, i2);
            if (i2 > 0) {
                subSettingViewHolder.J.setVisibility(this.f14642d.get(i2 + -1).a() ? 0 : 4);
            }
        }

        public void i0(SubSettingViewHolder subSettingViewHolder) {
            boolean z;
            subSettingViewHolder.I.setText(R.string.J);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= this.f14642d.size()) {
                    z = true;
                    break;
                } else if (this.f14642d.get(i3).a()) {
                    z = false;
                    break;
                } else {
                    i3++;
                }
            }
            View view = subSettingViewHolder.J;
            if (!z) {
                i2 = 4;
            }
            view.setVisibility(i2);
            subSettingViewHolder.f15587a.setOnClickListener(new C0373m(this));
        }

        public void k0(String str) {
        }
    }

    private static final class TrackInformation {

        /* renamed from: a  reason: collision with root package name */
        public final Tracks.Group f14639a;

        /* renamed from: b  reason: collision with root package name */
        public final int f14640b;

        /* renamed from: c  reason: collision with root package name */
        public final String f14641c;

        public TrackInformation(Tracks tracks, int i2, int i3, String str) {
            this.f14639a = tracks.d().get(i2);
            this.f14640b = i3;
            this.f14641c = str;
        }

        public boolean a() {
            return this.f14639a.l(this.f14640b);
        }
    }

    private abstract class TrackSelectionAdapter extends RecyclerView.Adapter<SubSettingViewHolder> {

        /* renamed from: d  reason: collision with root package name */
        protected List<TrackInformation> f14642d = new ArrayList();

        protected TrackSelectionAdapter() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g0(Player player, TrackGroup trackGroup, TrackInformation trackInformation, View view) {
            if (player.R1(29)) {
                player.X1(player.o2().G().b0(new TrackSelectionOverride(trackGroup, (List<Integer>) ImmutableList.K(Integer.valueOf(trackInformation.f14640b)))).r0(trackInformation.f14639a.g(), false).D());
                k0(trackInformation.f14641c);
                PlayerControlView.this.g3.dismiss();
            }
        }

        public int b() {
            if (this.f14642d.isEmpty()) {
                return 0;
            }
            return this.f14642d.size() + 1;
        }

        /* access modifiers changed from: protected */
        public void e0() {
            this.f14642d = Collections.emptyList();
        }

        public abstract void f0(List<TrackInformation> list);

        /* renamed from: h0 */
        public void R(SubSettingViewHolder subSettingViewHolder, int i2) {
            Player j2 = PlayerControlView.this.a4;
            if (j2 != null) {
                if (i2 == 0) {
                    i0(subSettingViewHolder);
                    return;
                }
                boolean z = true;
                TrackInformation trackInformation = this.f14642d.get(i2 - 1);
                TrackGroup d2 = trackInformation.f14639a.d();
                int i3 = 0;
                if (j2.o2().t3.get(d2) == null || !trackInformation.a()) {
                    z = false;
                }
                subSettingViewHolder.I.setText(trackInformation.f14641c);
                View view = subSettingViewHolder.J;
                if (!z) {
                    i3 = 4;
                }
                view.setVisibility(i3);
                subSettingViewHolder.f15587a.setOnClickListener(new n(this, j2, d2, trackInformation));
            }
        }

        /* access modifiers changed from: protected */
        public abstract void i0(SubSettingViewHolder subSettingViewHolder);

        /* renamed from: j0 */
        public SubSettingViewHolder T(ViewGroup viewGroup, int i2) {
            return new SubSettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R.layout.f14774j, viewGroup, false));
        }

        /* access modifiers changed from: protected */
        public abstract void k0(String str);
    }

    @Deprecated
    public interface VisibilityListener {
        void A(int i2);
    }

    static {
        MediaLibraryInfo.a("media3.ui");
    }

    public PlayerControlView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void A0() {
        Player player = this.a4;
        int A2 = (int) ((player != null ? player.A2() : 5000) / 1000);
        TextView textView = this.o3;
        if (textView != null) {
            textView.setText(String.valueOf(A2));
        }
        View view = this.m3;
        if (view != null) {
            view.setContentDescription(this.X2.getQuantityString(R.plurals.f14780b, A2, new Object[]{Integer.valueOf(A2)}));
        }
    }

    private void B0() {
        r0(this.b3.d0(), this.v3);
    }

    private void C0() {
        this.a3.measure(0, 0);
        this.g3.setWidth(Math.min(this.a3.getMeasuredWidth(), getWidth() - (this.h3 * 2)));
        this.g3.setHeight(Math.min(getHeight() - (this.h3 * 2), this.a3.getMeasuredHeight()));
    }

    /* access modifiers changed from: private */
    public void D0() {
        ImageView imageView;
        ImageView imageView2;
        String str;
        if (f0() && this.e4 && (imageView = this.q3) != null) {
            Player player = this.a4;
            if (!this.s.A(imageView)) {
                r0(false, this.q3);
                return;
            }
            if (player == null || !player.R1(14)) {
                r0(false, this.q3);
                this.q3.setImageDrawable(this.N3);
                imageView2 = this.q3;
                str = this.R3;
            } else {
                r0(true, this.q3);
                this.q3.setImageDrawable(player.m2() ? this.M3 : this.N3);
                imageView2 = this.q3;
                if (player.m2()) {
                    str = this.Q3;
                }
                str = this.R3;
            }
            imageView2.setContentDescription(str);
        }
    }

    /* access modifiers changed from: private */
    public void E0() {
        int i2;
        long j2;
        Timeline.Window window;
        Player player = this.a4;
        if (player != null) {
            boolean z = true;
            this.h4 = this.f4 && T(player, this.E3);
            this.q4 = 0;
            Timeline j22 = player.R1(17) ? player.j2() : Timeline.s;
            if (!j22.x()) {
                int P1 = player.P1();
                boolean z2 = this.h4;
                int i5 = z2 ? 0 : P1;
                int w = z2 ? j22.w() - 1 : P1;
                long j5 = 0;
                i2 = 0;
                while (true) {
                    if (i5 > w) {
                        break;
                    }
                    if (i5 == P1) {
                        this.q4 = Util.H2(j5);
                    }
                    j22.u(i5, this.E3);
                    Timeline.Window window2 = this.E3;
                    if (window2.g3 == C.f9084b) {
                        Assertions.i(this.h4 ^ z);
                        break;
                    }
                    int i6 = window2.h3;
                    while (true) {
                        window = this.E3;
                        if (i6 > window.i3) {
                            break;
                        }
                        j22.k(i6, this.D3);
                        int f2 = this.D3.f();
                        for (int t = this.D3.t(); t < f2; t++) {
                            long i7 = this.D3.i(t);
                            if (i7 == Long.MIN_VALUE) {
                                long j6 = this.D3.Z;
                                if (j6 == C.f9084b) {
                                } else {
                                    i7 = j6;
                                }
                            }
                            long s2 = i7 + this.D3.s();
                            if (s2 >= 0) {
                                long[] jArr = this.m4;
                                if (i2 == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.m4 = Arrays.copyOf(jArr, length);
                                    this.n4 = Arrays.copyOf(this.n4, length);
                                }
                                this.m4[i2] = Util.H2(j5 + s2);
                                this.n4[i2] = this.D3.u(t);
                                i2++;
                            }
                        }
                        i6++;
                    }
                    j5 += window.g3;
                    i5++;
                    z = true;
                }
                j2 = j5;
            } else {
                if (player.R1(16)) {
                    long A0 = player.A0();
                    if (A0 != C.f9084b) {
                        j2 = Util.I1(A0);
                        i2 = 0;
                    }
                }
                j2 = 0;
                i2 = 0;
            }
            long H2 = Util.H2(j2);
            TextView textView = this.y3;
            if (textView != null) {
                textView.setText(Util.K0(this.B3, this.C3, H2));
            }
            TimeBar timeBar = this.A3;
            if (timeBar != null) {
                timeBar.setDuration(H2);
                int length2 = this.o4.length;
                int i8 = i2 + length2;
                long[] jArr2 = this.m4;
                if (i8 > jArr2.length) {
                    this.m4 = Arrays.copyOf(jArr2, i8);
                    this.n4 = Arrays.copyOf(this.n4, i8);
                }
                System.arraycopy(this.o4, 0, this.m4, i2, length2);
                System.arraycopy(this.p4, 0, this.n4, i2, length2);
                this.A3.b(this.m4, this.n4, i8);
            }
            y0();
        }
    }

    /* access modifiers changed from: private */
    public void F0() {
        a0();
        r0(this.d3.b() > 0, this.s3);
        B0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r9 = r9.j2();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean T(androidx.media3.common.Player r9, androidx.media3.common.Timeline.Window r10) {
        /*
            r0 = 17
            boolean r0 = r9.R1(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            androidx.media3.common.Timeline r9 = r9.j2()
            int r0 = r9.w()
            r2 = 1
            if (r0 <= r2) goto L_0x0031
            r3 = 100
            if (r0 <= r3) goto L_0x001a
            goto L_0x0031
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 >= r0) goto L_0x0030
            androidx.media3.common.Timeline$Window r4 = r9.u(r3, r10)
            long r4 = r4.g3
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x002d
            return r1
        L_0x002d:
            int r3 = r3 + 1
            goto L_0x001b
        L_0x0030:
            return r2
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerControlView.T(androidx.media3.common.Player, androidx.media3.common.Timeline$Window):boolean");
    }

    /* access modifiers changed from: private */
    public void V(RecyclerView.Adapter<?> adapter, View view) {
        this.a3.setAdapter(adapter);
        C0();
        this.r4 = false;
        this.g3.dismiss();
        this.r4 = true;
        this.g3.showAsDropDown(view, (getWidth() - this.g3.getWidth()) - this.h3, (-this.g3.getHeight()) - this.h3);
    }

    private ImmutableList<TrackInformation> W(Tracks tracks, int i2) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList<Tracks.Group> d2 = tracks.d();
        for (int i5 = 0; i5 < d2.size(); i5++) {
            Tracks.Group group = d2.get(i5);
            if (group.g() == i2) {
                for (int i6 = 0; i6 < group.s; i6++) {
                    if (group.m(i6)) {
                        Format e2 = group.e(i6);
                        if ((e2.X2 & 2) == 0) {
                            builder.g(new TrackInformation(tracks, i5, i6, this.f3.a(e2)));
                        }
                    }
                }
            }
        }
        return builder.e();
    }

    private static int X(TypedArray typedArray, int i2) {
        return typedArray.getInt(R.styleable.R0, i2);
    }

    private void a0() {
        this.d3.e0();
        this.e3.e0();
        Player player = this.a4;
        if (player != null && player.R1(30) && this.a4.R1(29)) {
            Tracks D1 = this.a4.D1();
            this.e3.f0(W(D1, 1));
            if (this.s.A(this.s3)) {
                this.d3.f0(W(D1, 3));
            } else {
                this.d3.f0(ImmutableList.I());
            }
        }
    }

    private static void b0(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setVisibility(8);
            view.setOnClickListener(onClickListener);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static boolean e0(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 79 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    /* access modifiers changed from: private */
    public void h0(View view) {
        if (this.c4 != null) {
            boolean z = !this.d4;
            this.d4 = z;
            t0(this.t3, z);
            t0(this.u3, this.d4);
            OnFullScreenModeChangedListener onFullScreenModeChangedListener = this.c4;
            if (onFullScreenModeChangedListener != null) {
                onFullScreenModeChangedListener.O(this.d4);
            }
        }
    }

    /* access modifiers changed from: private */
    public void i0(View view, int i2, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12 = i7 - i5;
        int i13 = i11 - i9;
        if (!(i6 - i2 == i10 - i8 && i12 == i13) && this.g3.isShowing()) {
            C0();
            this.g3.update(view, (getWidth() - this.g3.getWidth()) - this.h3, (-this.g3.getHeight()) - this.h3, -1, -1);
        }
    }

    /* access modifiers changed from: private */
    public void j0(int i2) {
        RecyclerView.Adapter adapter;
        if (i2 == 0) {
            adapter = this.c3;
        } else if (i2 == 1) {
            adapter = this.e3;
        } else {
            this.g3.dismiss();
            return;
        }
        V(adapter, (View) Assertions.g(this.v3));
    }

    /* access modifiers changed from: private */
    public void m0(Player player, long j2) {
        if (this.h4) {
            if (player.R1(17) && player.R1(10)) {
                Timeline j22 = player.j2();
                int w = j22.w();
                int i2 = 0;
                while (true) {
                    long f2 = j22.u(i2, this.E3).f();
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
                player.i0(i2, j2);
            }
        } else if (player.R1(5)) {
            player.G(j2);
        }
        y0();
    }

    private boolean o0() {
        Player player = this.a4;
        return player != null && player.R1(1) && (!this.a4.R1(17) || !this.a4.j2().x());
    }

    private void r0(boolean z, @Nullable View view) {
        if (view != null) {
            view.setEnabled(z);
            view.setAlpha(z ? this.O3 : this.P3);
        }
    }

    private void s0() {
        Player player = this.a4;
        int l1 = (int) ((player != null ? player.l1() : C.b2) / 1000);
        TextView textView = this.n3;
        if (textView != null) {
            textView.setText(String.valueOf(l1));
        }
        View view = this.l3;
        if (view != null) {
            view.setContentDescription(this.X2.getQuantityString(R.plurals.f14779a, l1, new Object[]{Integer.valueOf(l1)}));
        }
    }

    /* access modifiers changed from: private */
    public void setPlaybackSpeed(float f2) {
        Player player = this.a4;
        if (player != null && player.R1(13)) {
            Player player2 = this.a4;
            player2.f(player2.r().d(f2));
        }
    }

    private void t0(@Nullable ImageView imageView, boolean z) {
        String str;
        if (imageView != null) {
            if (z) {
                imageView.setImageDrawable(this.W3);
                str = this.Y3;
            } else {
                imageView.setImageDrawable(this.X3);
                str = this.Z3;
            }
            imageView.setContentDescription(str);
        }
    }

    private static void u0(@Nullable View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* access modifiers changed from: private */
    public void v0() {
        boolean z;
        boolean z2;
        boolean z5;
        boolean z6;
        boolean z7;
        if (f0() && this.e4) {
            Player player = this.a4;
            if (player != null) {
                z6 = player.R1((!this.f4 || !T(player, this.E3)) ? 5 : 10);
                z5 = player.R1(7);
                z2 = player.R1(11);
                z = player.R1(12);
                z7 = player.R1(9);
            } else {
                z6 = false;
                z7 = false;
                z5 = false;
                z2 = false;
                z = false;
            }
            if (z2) {
                A0();
            }
            if (z) {
                s0();
            }
            r0(z5, this.i3);
            r0(z2, this.m3);
            r0(z, this.l3);
            r0(z7, this.j3);
            TimeBar timeBar = this.A3;
            if (timeBar != null) {
                timeBar.setEnabled(z6);
            }
        }
    }

    /* access modifiers changed from: private */
    public void w0() {
        if (f0() && this.e4 && this.k3 != null) {
            boolean m2 = Util.m2(this.a4, this.g4);
            int i2 = m2 ? R.drawable.o0 : R.drawable.n0;
            int i5 = m2 ? R.string.f14792l : R.string.f14791k;
            ((ImageView) this.k3).setImageDrawable(Util.r0(getContext(), this.X2, i2));
            this.k3.setContentDescription(this.X2.getString(i5));
            r0(o0(), this.k3);
        }
    }

    /* access modifiers changed from: private */
    public void x0() {
        Player player = this.a4;
        if (player != null) {
            this.c3.i0(player.r().s);
            this.b3.g0(0, this.c3.e0());
            B0();
        }
    }

    /* access modifiers changed from: private */
    public void y0() {
        long j2;
        long j5;
        if (f0() && this.e4) {
            Player player = this.a4;
            if (player == null || !player.R1(16)) {
                j5 = 0;
                j2 = 0;
            } else {
                j5 = this.q4 + player.n1();
                j2 = this.q4 + player.p2();
            }
            TextView textView = this.z3;
            if (textView != null && !this.i4) {
                textView.setText(Util.K0(this.B3, this.C3, j5));
            }
            TimeBar timeBar = this.A3;
            if (timeBar != null) {
                timeBar.setPosition(j5);
                this.A3.setBufferedPosition(j2);
            }
            ProgressUpdateListener progressUpdateListener = this.b4;
            if (progressUpdateListener != null) {
                progressUpdateListener.a(j5, j2);
            }
            removeCallbacks(this.F3);
            int i2 = player == null ? 1 : player.i();
            long j6 = 1000;
            if (player != null && player.J1()) {
                TimeBar timeBar2 = this.A3;
                long min = Math.min(timeBar2 != null ? timeBar2.getPreferredUpdateDelay() : 1000, 1000 - (j5 % 1000));
                float f2 = player.r().s;
                if (f2 > 0.0f) {
                    j6 = (long) (((float) min) / f2);
                }
                postDelayed(this.F3, Util.x(j6, (long) this.k4, 1000));
            } else if (i2 != 4 && i2 != 1) {
                postDelayed(this.F3, 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    public void z0() {
        ImageView imageView;
        ImageView imageView2;
        String str;
        if (f0() && this.e4 && (imageView = this.p3) != null) {
            if (this.l4 == 0) {
                r0(false, imageView);
                return;
            }
            Player player = this.a4;
            if (player == null || !player.R1(15)) {
                r0(false, this.p3);
                this.p3.setImageDrawable(this.G3);
                this.p3.setContentDescription(this.J3);
                return;
            }
            r0(true, this.p3);
            int q = player.q();
            if (q == 0) {
                this.p3.setImageDrawable(this.G3);
                imageView2 = this.p3;
                str = this.J3;
            } else if (q == 1) {
                this.p3.setImageDrawable(this.H3);
                imageView2 = this.p3;
                str = this.K3;
            } else if (q == 2) {
                this.p3.setImageDrawable(this.I3);
                imageView2 = this.p3;
                str = this.L3;
            } else {
                return;
            }
            imageView2.setContentDescription(str);
        }
    }

    @Deprecated
    public void S(VisibilityListener visibilityListener) {
        Assertions.g(visibilityListener);
        this.Z2.add(visibilityListener);
    }

    public boolean U(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.a4;
        if (player == null || !e0(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.i() == 4 || !player.R1(12)) {
                return true;
            }
            player.s2();
            return true;
        } else if (keyCode == 89 && player.R1(11)) {
            player.v2();
            return true;
        } else if (keyEvent.getRepeatCount() != 0) {
            return true;
        } else {
            if (keyCode == 79 || keyCode == 85) {
                Util.W0(player, this.g4);
                return true;
            } else if (keyCode != 87) {
                if (keyCode != 88) {
                    if (keyCode == 126) {
                        Util.U0(player);
                        return true;
                    } else if (keyCode != 127) {
                        return true;
                    } else {
                        Util.T0(player);
                        return true;
                    }
                } else if (!player.R1(7)) {
                    return true;
                } else {
                    player.f1();
                    return true;
                }
            } else if (!player.R1(9)) {
                return true;
            } else {
                player.q2();
                return true;
            }
        }
    }

    public void Y() {
        this.s.C();
    }

    public void Z() {
        this.s.F();
    }

    public boolean c0() {
        return this.s.I();
    }

    public boolean d0() {
        return this.s.J();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return U(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean f0() {
        return getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public void g0() {
        Iterator<VisibilityListener> it2 = this.Z2.iterator();
        while (it2.hasNext()) {
            it2.next().A(getVisibility());
        }
    }

    @Nullable
    public Player getPlayer() {
        return this.a4;
    }

    public int getRepeatToggleModes() {
        return this.l4;
    }

    public boolean getShowShuffleButton() {
        return this.s.A(this.q3);
    }

    public boolean getShowSubtitleButton() {
        return this.s.A(this.s3);
    }

    public int getShowTimeoutMs() {
        return this.j4;
    }

    public boolean getShowVrButton() {
        return this.s.A(this.r3);
    }

    @Deprecated
    public void k0(VisibilityListener visibilityListener) {
        this.Z2.remove(visibilityListener);
    }

    /* access modifiers changed from: package-private */
    public void l0() {
        View view = this.k3;
        if (view != null) {
            view.requestFocus();
        }
    }

    public void n0(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        boolean z = false;
        if (jArr == null) {
            this.o4 = new long[0];
            this.p4 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) Assertions.g(zArr);
            if (jArr.length == zArr2.length) {
                z = true;
            }
            Assertions.a(z);
            this.o4 = jArr;
            this.p4 = zArr2;
        }
        E0();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s.P();
        this.e4 = true;
        if (d0()) {
            this.s.X();
        }
        q0();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s.Q();
        this.e4 = false;
        removeCallbacks(this.F3);
        this.s.W();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i5, int i6, int i7) {
        super.onLayout(z, i2, i5, i6, i7);
        this.s.R(z, i2, i5, i6, i7);
    }

    public void p0() {
        this.s.c0();
    }

    /* access modifiers changed from: package-private */
    public void q0() {
        w0();
        v0();
        z0();
        D0();
        F0();
        x0();
        E0();
    }

    public void setAnimationEnabled(boolean z) {
        this.s.Y(z);
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(@Nullable OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        this.c4 = onFullScreenModeChangedListener;
        boolean z = false;
        u0(this.t3, onFullScreenModeChangedListener != null);
        ImageView imageView = this.u3;
        if (onFullScreenModeChangedListener != null) {
            z = true;
        }
        u0(imageView, z);
    }

    public void setPlayer(@Nullable Player player) {
        boolean z = false;
        Assertions.i(Looper.myLooper() == Looper.getMainLooper());
        if (player == null || player.k2() == Looper.getMainLooper()) {
            z = true;
        }
        Assertions.a(z);
        Player player2 = this.a4;
        if (player2 != player) {
            if (player2 != null) {
                player2.N1(this.Y2);
            }
            this.a4 = player;
            if (player != null) {
                player.f2(this.Y2);
            }
            q0();
        }
    }

    public void setProgressUpdateListener(@Nullable ProgressUpdateListener progressUpdateListener) {
        this.b4 = progressUpdateListener;
    }

    public void setRepeatToggleModes(int i2) {
        this.l4 = i2;
        Player player = this.a4;
        boolean z = false;
        if (player != null && player.R1(15)) {
            int q = this.a4.q();
            if (i2 == 0 && q != 0) {
                this.a4.p(0);
            } else if (i2 == 1 && q == 2) {
                this.a4.p(1);
            } else if (i2 == 2 && q == 1) {
                this.a4.p(2);
            }
        }
        PlayerControlViewLayoutManager playerControlViewLayoutManager = this.s;
        ImageView imageView = this.p3;
        if (i2 != 0) {
            z = true;
        }
        playerControlViewLayoutManager.Z(imageView, z);
        z0();
    }

    public void setShowFastForwardButton(boolean z) {
        this.s.Z(this.l3, z);
        v0();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z) {
        this.f4 = z;
        E0();
    }

    public void setShowNextButton(boolean z) {
        this.s.Z(this.j3, z);
        v0();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z) {
        this.g4 = z;
        w0();
    }

    public void setShowPreviousButton(boolean z) {
        this.s.Z(this.i3, z);
        v0();
    }

    public void setShowRewindButton(boolean z) {
        this.s.Z(this.m3, z);
        v0();
    }

    public void setShowShuffleButton(boolean z) {
        this.s.Z(this.q3, z);
        D0();
    }

    public void setShowSubtitleButton(boolean z) {
        this.s.Z(this.s3, z);
    }

    public void setShowTimeoutMs(int i2) {
        this.j4 = i2;
        if (d0()) {
            this.s.X();
        }
    }

    public void setShowVrButton(boolean z) {
        this.s.Z(this.r3, z);
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.k4 = Util.w(i2, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.r3;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            r0(onClickListener != null, this.r3);
        }
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r9v1, types: [android.view.ViewGroup, androidx.media3.ui.PlayerControlView$1] */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i2);
        boolean z;
        boolean z2;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        ComponentListener componentListener;
        ? r9;
        Context context2 = context;
        AttributeSet attributeSet3 = attributeSet2;
        int i5 = R.layout.f14770f;
        this.g4 = true;
        this.j4 = 5000;
        this.l4 = 0;
        this.k4 = 200;
        if (attributeSet3 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet3, R.styleable.H0, i2, 0);
            try {
                i5 = obtainStyledAttributes.getResourceId(R.styleable.O0, i5);
                this.j4 = obtainStyledAttributes.getInt(R.styleable.d1, this.j4);
                this.l4 = X(obtainStyledAttributes, this.l4);
                boolean z13 = obtainStyledAttributes.getBoolean(R.styleable.a1, true);
                boolean z14 = obtainStyledAttributes.getBoolean(R.styleable.X0, true);
                boolean z15 = obtainStyledAttributes.getBoolean(R.styleable.Z0, true);
                boolean z16 = obtainStyledAttributes.getBoolean(R.styleable.Y0, true);
                boolean z17 = obtainStyledAttributes.getBoolean(R.styleable.b1, false);
                boolean z18 = obtainStyledAttributes.getBoolean(R.styleable.c1, false);
                boolean z19 = obtainStyledAttributes.getBoolean(R.styleable.e1, false);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R.styleable.f1, this.k4));
                boolean z20 = obtainStyledAttributes.getBoolean(R.styleable.K0, true);
                obtainStyledAttributes.recycle();
                z = z18;
                z6 = z15;
                z9 = z19;
                z5 = z16;
                z8 = z13;
                boolean z21 = z17;
                z7 = z14;
                z10 = z20;
                z2 = z21;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z10 = true;
            z9 = false;
            z8 = true;
            z7 = true;
            z6 = true;
            z5 = true;
            z2 = false;
            z = false;
        }
        LayoutInflater.from(context).inflate(i5, this);
        setDescendantFocusability(262144);
        ComponentListener componentListener2 = new ComponentListener();
        this.Y2 = componentListener2;
        this.Z2 = new CopyOnWriteArrayList<>();
        this.D3 = new Timeline.Period();
        this.E3 = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        this.B3 = sb;
        this.C3 = new Formatter(sb, Locale.getDefault());
        this.m4 = new long[0];
        this.n4 = new boolean[0];
        this.o4 = new long[0];
        this.p4 = new boolean[0];
        this.F3 = new C0367g(this);
        this.y3 = (TextView) findViewById(R.id.i0);
        this.z3 = (TextView) findViewById(R.id.B0);
        ImageView imageView = (ImageView) findViewById(R.id.N0);
        this.s3 = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(componentListener2);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.o0);
        this.t3 = imageView2;
        b0(imageView2, new C0368h(this));
        ImageView imageView3 = (ImageView) findViewById(R.id.s0);
        this.u3 = imageView3;
        b0(imageView3, new C0368h(this));
        View findViewById = findViewById(R.id.I0);
        this.v3 = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(componentListener2);
        }
        View findViewById2 = findViewById(R.id.A0);
        this.w3 = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(componentListener2);
        }
        View findViewById3 = findViewById(R.id.Y);
        this.x3 = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(componentListener2);
        }
        int i6 = R.id.D0;
        TimeBar timeBar = (TimeBar) findViewById(i6);
        View findViewById4 = findViewById(R.id.E0);
        if (timeBar != null) {
            this.A3 = timeBar;
            componentListener = componentListener2;
            z12 = z10;
            z11 = z9;
            r9 = 0;
        } else if (findViewById4 != null) {
            DefaultTimeBar defaultTimeBar = r2;
            View view = findViewById4;
            r9 = 0;
            componentListener = componentListener2;
            z12 = z10;
            z11 = z9;
            DefaultTimeBar defaultTimeBar2 = new DefaultTimeBar(context, (AttributeSet) null, 0, attributeSet2, R.style.B);
            defaultTimeBar2.setId(i6);
            defaultTimeBar2.setLayoutParams(view.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            View view2 = view;
            int indexOfChild = viewGroup.indexOfChild(view2);
            viewGroup.removeView(view2);
            viewGroup.addView(defaultTimeBar2, indexOfChild);
            this.A3 = defaultTimeBar2;
        } else {
            componentListener = componentListener2;
            z12 = z10;
            z11 = z9;
            r9 = 0;
            this.A3 = null;
        }
        TimeBar timeBar2 = this.A3;
        ComponentListener componentListener3 = componentListener;
        if (timeBar2 != null) {
            timeBar2.a(componentListener3);
        }
        View findViewById5 = findViewById(R.id.z0);
        this.k3 = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(componentListener3);
        }
        View findViewById6 = findViewById(R.id.C0);
        this.i3 = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(componentListener3);
        }
        View findViewById7 = findViewById(R.id.t0);
        this.j3 = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(componentListener3);
        }
        Typeface j2 = ResourcesCompat.j(context2, R.font.f14746a);
        View findViewById8 = findViewById(R.id.G0);
        TextView textView = findViewById8 == null ? (TextView) findViewById(R.id.H0) : r9;
        this.o3 = textView;
        if (textView != null) {
            textView.setTypeface(j2);
        }
        findViewById8 = findViewById8 == null ? textView : findViewById8;
        this.m3 = findViewById8;
        if (findViewById8 != null) {
            findViewById8.setOnClickListener(componentListener3);
        }
        View findViewById9 = findViewById(R.id.m0);
        TextView textView2 = findViewById9 == null ? (TextView) findViewById(R.id.n0) : r9;
        this.n3 = textView2;
        if (textView2 != null) {
            textView2.setTypeface(j2);
        }
        findViewById9 = findViewById9 == null ? textView2 : findViewById9;
        this.l3 = findViewById9;
        if (findViewById9 != null) {
            findViewById9.setOnClickListener(componentListener3);
        }
        ImageView imageView4 = (ImageView) findViewById(R.id.F0);
        this.p3 = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(componentListener3);
        }
        ImageView imageView5 = (ImageView) findViewById(R.id.K0);
        this.q3 = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(componentListener3);
        }
        Resources resources = context.getResources();
        this.X2 = resources;
        this.O3 = ((float) resources.getInteger(R.integer.f14763c)) / 100.0f;
        this.P3 = ((float) resources.getInteger(R.integer.f14762b)) / 100.0f;
        View findViewById10 = findViewById(R.id.S0);
        this.r3 = findViewById10;
        if (findViewById10 != null) {
            r0(false, findViewById10);
        }
        PlayerControlViewLayoutManager playerControlViewLayoutManager = new PlayerControlViewLayoutManager(this);
        this.s = playerControlViewLayoutManager;
        playerControlViewLayoutManager.Y(z12);
        SettingsAdapter settingsAdapter = new SettingsAdapter(new String[]{resources.getString(R.string.f14793m), resources.getString(R.string.K)}, new Drawable[]{Util.r0(context2, resources, R.drawable.x0), Util.r0(context2, resources, R.drawable.f0)});
        this.b3 = settingsAdapter;
        this.h3 = resources.getDimensionPixelSize(R.dimen.x);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.f14772h, r9);
        this.a3 = recyclerView;
        recyclerView.setAdapter(settingsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow(recyclerView, -2, -2, true);
        this.g3 = popupWindow;
        if (Util.f9646a < 23) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        popupWindow.setOnDismissListener(componentListener3);
        this.r4 = true;
        this.f3 = new DefaultTrackNameProvider(getResources());
        this.S3 = Util.r0(context2, resources, R.drawable.z0);
        this.T3 = Util.r0(context2, resources, R.drawable.y0);
        this.U3 = resources.getString(R.string.f14782b);
        this.V3 = resources.getString(R.string.f14781a);
        this.d3 = new TextTrackSelectionAdapter();
        this.e3 = new AudioTrackSelectionAdapter();
        this.c3 = new PlaybackSpeedAdapter(resources.getStringArray(R.array.f14689a), x4);
        this.W3 = Util.r0(context2, resources, R.drawable.j0);
        this.X3 = Util.r0(context2, resources, R.drawable.i0);
        this.G3 = Util.r0(context2, resources, R.drawable.r0);
        this.H3 = Util.r0(context2, resources, R.drawable.s0);
        this.I3 = Util.r0(context2, resources, R.drawable.q0);
        this.M3 = Util.r0(context2, resources, R.drawable.w0);
        this.N3 = Util.r0(context2, resources, R.drawable.v0);
        this.Y3 = resources.getString(R.string.f14786f);
        this.Z3 = resources.getString(R.string.f14785e);
        this.J3 = resources.getString(R.string.p);
        this.K3 = resources.getString(R.string.q);
        this.L3 = resources.getString(R.string.o);
        this.Q3 = this.X2.getString(R.string.w);
        this.R3 = this.X2.getString(R.string.v);
        this.s.Z((ViewGroup) findViewById(R.id.a0), true);
        this.s.Z(this.l3, z7);
        this.s.Z(this.m3, z8);
        this.s.Z(this.i3, z6);
        this.s.Z(this.j3, z5);
        this.s.Z(this.q3, z2);
        this.s.Z(this.s3, z);
        this.s.Z(this.r3, z11);
        this.s.Z(this.p3, this.l4 != 0);
        addOnLayoutChangeListener(new C0369i(this));
    }
}
