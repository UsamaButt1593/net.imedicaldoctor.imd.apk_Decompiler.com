package androidx.media3.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AdOverlayInfo;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.ErrorMessageProvider;
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
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerControlView;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class PlayerView extends FrameLayout implements AdViewProvider {
    @UnstableApi
    public static final int A3 = 1;
    @UnstableApi
    public static final int B3 = 2;
    @UnstableApi
    public static final int C3 = 0;
    @UnstableApi
    public static final int D3 = 1;
    @UnstableApi
    public static final int E3 = 2;
    private static final int F3 = 0;
    private static final int G3 = 1;
    private static final int H3 = 2;
    private static final int I3 = 3;
    private static final int J3 = 4;
    @UnstableApi
    public static final int z3 = 0;
    @Nullable
    private final AspectRatioFrameLayout X2;
    /* access modifiers changed from: private */
    @Nullable
    public final View Y2;
    @Nullable
    private final View Z2;
    private final boolean a3;
    @Nullable
    private final ImageView b3;
    /* access modifiers changed from: private */
    @Nullable
    public final SubtitleView c3;
    @Nullable
    private final View d3;
    @Nullable
    private final TextView e3;
    @Nullable
    private final PlayerControlView f3;
    @Nullable
    private final FrameLayout g3;
    @Nullable
    private final FrameLayout h3;
    /* access modifiers changed from: private */
    @Nullable
    public Player i3;
    private boolean j3;
    /* access modifiers changed from: private */
    @Nullable
    public ControllerVisibilityListener k3;
    @Nullable
    private PlayerControlView.VisibilityListener l3;
    /* access modifiers changed from: private */
    @Nullable
    public FullscreenButtonClickListener m3;
    private int n3;
    @Nullable
    private Drawable o3;
    private int p3;
    private boolean q3;
    @Nullable
    private ErrorMessageProvider<? super PlaybackException> r3;
    private final ComponentListener s;
    @Nullable
    private CharSequence s3;
    private int t3;
    private boolean u3;
    /* access modifiers changed from: private */
    public boolean v3;
    private boolean w3;
    /* access modifiers changed from: private */
    public int x3;
    private boolean y3;

    @RequiresApi(34)
    private static class Api34 {
        private Api34() {
        }

        @DoNotInline
        public static void a(SurfaceView surfaceView) {
            surfaceView.setSurfaceLifecycle(2);
        }
    }

    @UnstableApi
    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ArtworkDisplayMode {
    }

    private final class ComponentListener implements Player.Listener, View.OnLayoutChangeListener, View.OnClickListener, PlayerControlView.VisibilityListener, PlayerControlView.OnFullScreenModeChangedListener {
        @Nullable
        private Object X;
        private final Timeline.Period s = new Timeline.Period();

        public ComponentListener() {
        }

        public void A(int i2) {
            PlayerView.this.P();
            if (PlayerView.this.k3 != null) {
                PlayerView.this.k3.a(i2);
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
            PlayerView.this.O();
            PlayerView.this.R();
            PlayerView.this.Q();
        }

        public /* synthetic */ void N(AudioAttributes audioAttributes) {
            L.a(this, audioAttributes);
        }

        public void O(boolean z) {
            if (PlayerView.this.m3 != null) {
                PlayerView.this.m3.a(z);
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

        public void c(VideoSize videoSize) {
            if (!videoSize.equals(VideoSize.b3) && PlayerView.this.i3 != null && PlayerView.this.i3.i() != 1) {
                PlayerView.this.N();
            }
        }

        public /* synthetic */ void d0(TrackSelectionParameters trackSelectionParameters) {
            L.H(this, trackSelectionParameters);
        }

        public /* synthetic */ void e(boolean z) {
            L.E(this, z);
        }

        public void e0() {
            if (PlayerView.this.Y2 != null) {
                PlayerView.this.Y2.setVisibility(4);
            }
        }

        public void f0(Tracks tracks) {
            Player player = (Player) Assertions.g(PlayerView.this.i3);
            Timeline j2 = player.R1(17) ? player.j2() : Timeline.s;
            if (!j2.x()) {
                if (!player.R1(30) || player.D1().e()) {
                    Object obj = this.X;
                    if (obj != null) {
                        int g2 = j2.g(obj);
                        if (g2 != -1 && player.P1() == j2.k(g2, this.s).Y) {
                            return;
                        }
                    }
                    PlayerView.this.S(false);
                }
                this.X = j2.l(player.B0(), this.s, true).X;
                PlayerView.this.S(false);
            }
            this.X = null;
            PlayerView.this.S(false);
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
            PlayerView.this.O();
            PlayerView.this.Q();
        }

        public void onClick(View view) {
            PlayerView.this.M();
        }

        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            PlayerView.q((TextureView) view, PlayerView.this.x3);
        }

        public void p(CueGroup cueGroup) {
            if (PlayerView.this.c3 != null) {
                PlayerView.this.c3.setCues(cueGroup.s);
            }
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

        public void u0(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
            if (PlayerView.this.z() && PlayerView.this.v3) {
                PlayerView.this.w();
            }
        }

        public /* synthetic */ void x(int i2) {
            L.A(this, i2);
        }

        public /* synthetic */ void y0(boolean z) {
            L.j(this, z);
        }
    }

    public interface ControllerVisibilityListener {
        void a(int i2);
    }

    public interface FullscreenButtonClickListener {
        void a(boolean z);
    }

    @UnstableApi
    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowBuffering {
    }

    public PlayerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void A(boolean z) {
        if ((!z() || !this.v3) && U()) {
            boolean z2 = this.f3.d0() && this.f3.getShowTimeoutMs() <= 0;
            boolean I = I();
            if (z || z2 || I) {
                K(I);
            }
        }
    }

    @RequiresNonNull({"artworkView"})
    private boolean E(Player player) {
        byte[] bArr;
        if (!player.R1(18) || (bArr = player.x2().c3) == null) {
            return false;
        }
        return F(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    @RequiresNonNull({"artworkView"})
    private boolean F(@Nullable Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float f2 = ((float) intrinsicWidth) / ((float) intrinsicHeight);
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                if (this.n3 == 2) {
                    f2 = ((float) getWidth()) / ((float) getHeight());
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                B(this.X2, f2);
                this.b3.setScaleType(scaleType);
                this.b3.setImageDrawable(drawable);
                this.b3.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private static void H(AspectRatioFrameLayout aspectRatioFrameLayout, int i2) {
        aspectRatioFrameLayout.setResizeMode(i2);
    }

    private boolean I() {
        Player player = this.i3;
        if (player == null) {
            return true;
        }
        int i2 = player.i();
        return this.u3 && (!this.i3.R1(17) || !this.i3.j2().x()) && (i2 == 1 || i2 == 4 || !((Player) Assertions.g(this.i3)).m0());
    }

    private void K(boolean z) {
        if (U()) {
            this.f3.setShowTimeoutMs(z ? 0 : this.t3);
            this.f3.p0();
        }
    }

    @UnstableApi
    public static void L(Player player, @Nullable PlayerView playerView, @Nullable PlayerView playerView2) {
        if (playerView != playerView2) {
            if (playerView2 != null) {
                playerView2.setPlayer(player);
            }
            if (playerView != null) {
                playerView.setPlayer((Player) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public void M() {
        if (U() && this.i3 != null) {
            if (!this.f3.d0()) {
                A(true);
            } else if (this.w3) {
                this.f3.Y();
            }
        }
    }

    /* access modifiers changed from: private */
    public void N() {
        Player player = this.i3;
        VideoSize z = player != null ? player.z() : VideoSize.b3;
        int i2 = z.s;
        int i4 = z.X;
        int i5 = z.Y;
        float f2 = 0.0f;
        float f4 = (i4 == 0 || i2 == 0) ? 0.0f : (((float) i2) * z.Z) / ((float) i4);
        View view = this.Z2;
        if (view instanceof TextureView) {
            if (f4 > 0.0f && (i5 == 90 || i5 == 270)) {
                f4 = 1.0f / f4;
            }
            if (this.x3 != 0) {
                view.removeOnLayoutChangeListener(this.s);
            }
            this.x3 = i5;
            if (i5 != 0) {
                this.Z2.addOnLayoutChangeListener(this.s);
            }
            q((TextureView) this.Z2, this.x3);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.X2;
        if (!this.a3) {
            f2 = f4;
        }
        B(aspectRatioFrameLayout, f2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r4.i3.m0() == false) goto L_0x0020;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void O() {
        /*
            r4 = this;
            android.view.View r0 = r4.d3
            if (r0 == 0) goto L_0x002b
            androidx.media3.common.Player r0 = r4.i3
            r1 = 0
            if (r0 == 0) goto L_0x0020
            int r0 = r0.i()
            r2 = 2
            if (r0 != r2) goto L_0x0020
            int r0 = r4.p3
            r3 = 1
            if (r0 == r2) goto L_0x0021
            if (r0 != r3) goto L_0x0020
            androidx.media3.common.Player r0 = r4.i3
            boolean r0 = r0.m0()
            if (r0 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            android.view.View r0 = r4.d3
            if (r3 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = 8
        L_0x0028:
            r0.setVisibility(r1)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.O():void");
    }

    /* access modifiers changed from: private */
    public void P() {
        PlayerControlView playerControlView = this.f3;
        String str = null;
        if (playerControlView != null && this.j3) {
            if (!playerControlView.d0()) {
                setContentDescription(getResources().getString(R.string.u));
                return;
            } else if (this.w3) {
                str = getResources().getString(R.string.f14787g);
            }
        }
        setContentDescription(str);
    }

    /* access modifiers changed from: private */
    public void Q() {
        if (!z() || !this.v3) {
            A(false);
        } else {
            w();
        }
    }

    /* access modifiers changed from: private */
    public void R() {
        ErrorMessageProvider<? super PlaybackException> errorMessageProvider;
        TextView textView = this.e3;
        if (textView != null) {
            CharSequence charSequence = this.s3;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.e3.setVisibility(0);
                return;
            }
            Player player = this.i3;
            PlaybackException j2 = player != null ? player.j() : null;
            if (j2 == null || (errorMessageProvider = this.r3) == null) {
                this.e3.setVisibility(8);
                return;
            }
            this.e3.setText((CharSequence) errorMessageProvider.a(j2).second);
            this.e3.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void S(boolean z) {
        Player player = this.i3;
        if (player != null && player.R1(30) && !player.D1().e()) {
            if (z && !this.q3) {
                r();
            }
            if (player.D1().f(2)) {
                v();
                return;
            }
            r();
            if (!T() || (!E(player) && !F(this.o3))) {
                v();
            }
        } else if (!this.q3) {
            v();
            r();
        }
    }

    @EnsuresNonNullIf(expression = {"artworkView"}, result = true)
    private boolean T() {
        if (this.n3 == 0) {
            return false;
        }
        Assertions.k(this.b3);
        return true;
    }

    @EnsuresNonNullIf(expression = {"controller"}, result = true)
    private boolean U() {
        if (!this.j3) {
            return false;
        }
        Assertions.k(this.f3);
        return true;
    }

    /* access modifiers changed from: private */
    public static void q(TextureView textureView, int i2) {
        Matrix matrix = new Matrix();
        float width = (float) textureView.getWidth();
        float height = (float) textureView.getHeight();
        if (!(width == 0.0f || height == 0.0f || i2 == 0)) {
            float f2 = width / 2.0f;
            float f4 = height / 2.0f;
            matrix.postRotate((float) i2, f2, f4);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f2, f4);
        }
        textureView.setTransform(matrix);
    }

    private void r() {
        View view = this.Y2;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void s(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(Util.r0(context, resources, R.drawable.f14732a));
        imageView.setBackgroundColor(resources.getColor(R.color.f14709f));
    }

    @RequiresApi(23)
    private static void t(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(Util.r0(context, resources, R.drawable.f14732a));
        imageView.setBackgroundColor(resources.getColor(R.color.f14709f, (Resources.Theme) null));
    }

    private void v() {
        ImageView imageView = this.b3;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.b3.setVisibility(4);
        }
    }

    @SuppressLint({"InlinedApi"})
    private boolean y(int i2) {
        return i2 == 19 || i2 == 270 || i2 == 22 || i2 == 271 || i2 == 20 || i2 == 269 || i2 == 21 || i2 == 268 || i2 == 23;
    }

    /* access modifiers changed from: private */
    public boolean z() {
        Player player = this.i3;
        return player != null && player.R1(16) && this.i3.c0() && this.i3.m0();
    }

    /* access modifiers changed from: protected */
    @UnstableApi
    public void B(@Nullable AspectRatioFrameLayout aspectRatioFrameLayout, float f2) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f2);
        }
    }

    public void C() {
        View view = this.Z2;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
        }
    }

    public void D() {
        View view = this.Z2;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onResume();
        }
    }

    @UnstableApi
    public void G(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        Assertions.k(this.f3);
        this.f3.n0(jArr, zArr);
    }

    @UnstableApi
    public void J() {
        K(I());
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Player player = this.i3;
        if (player != null && player.R1(16) && this.i3.c0()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean y = y(keyEvent.getKeyCode());
        if ((!y || !U() || this.f3.d0()) && !u(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            if (y && U()) {
                A(true);
            }
            return false;
        }
        A(true);
        return true;
    }

    public List<AdOverlayInfo> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.h3;
        if (frameLayout != null) {
            arrayList.add(new AdOverlayInfo.Builder(frameLayout, 4).b("Transparent overlay does not impact viewability").a());
        }
        PlayerControlView playerControlView = this.f3;
        if (playerControlView != null) {
            arrayList.add(new AdOverlayInfo.Builder(playerControlView, 1).a());
        }
        return ImmutableList.B(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) Assertions.l(this.g3, "exo_ad_overlay must be present for ad playback");
    }

    @UnstableApi
    public int getArtworkDisplayMode() {
        return this.n3;
    }

    @UnstableApi
    public boolean getControllerAutoShow() {
        return this.u3;
    }

    @UnstableApi
    public boolean getControllerHideOnTouch() {
        return this.w3;
    }

    @UnstableApi
    public int getControllerShowTimeoutMs() {
        return this.t3;
    }

    @UnstableApi
    @Nullable
    public Drawable getDefaultArtwork() {
        return this.o3;
    }

    @UnstableApi
    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.h3;
    }

    @Nullable
    public Player getPlayer() {
        return this.i3;
    }

    @UnstableApi
    public int getResizeMode() {
        Assertions.k(this.X2);
        return this.X2.getResizeMode();
    }

    @UnstableApi
    @Nullable
    public SubtitleView getSubtitleView() {
        return this.c3;
    }

    @UnstableApi
    @Deprecated
    public boolean getUseArtwork() {
        return this.n3 != 0;
    }

    public boolean getUseController() {
        return this.j3;
    }

    @UnstableApi
    @Nullable
    public View getVideoSurfaceView() {
        return this.Z2;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!U() || this.i3 == null) {
            return false;
        }
        A(true);
        return true;
    }

    public boolean performClick() {
        M();
        return super.performClick();
    }

    @UnstableApi
    public void setArtworkDisplayMode(int i2) {
        Assertions.i(i2 == 0 || this.b3 != null);
        if (this.n3 != i2) {
            this.n3 = i2;
            S(false);
        }
    }

    @UnstableApi
    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        Assertions.k(this.X2);
        this.X2.setAspectRatioListener(aspectRatioListener);
    }

    @UnstableApi
    public void setControllerAnimationEnabled(boolean z) {
        Assertions.k(this.f3);
        this.f3.setAnimationEnabled(z);
    }

    @UnstableApi
    public void setControllerAutoShow(boolean z) {
        this.u3 = z;
    }

    @UnstableApi
    public void setControllerHideDuringAds(boolean z) {
        this.v3 = z;
    }

    @UnstableApi
    public void setControllerHideOnTouch(boolean z) {
        Assertions.k(this.f3);
        this.w3 = z;
        P();
    }

    @UnstableApi
    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(@Nullable PlayerControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        Assertions.k(this.f3);
        this.m3 = null;
        this.f3.setOnFullScreenModeChangedListener(onFullScreenModeChangedListener);
    }

    @UnstableApi
    public void setControllerShowTimeoutMs(int i2) {
        Assertions.k(this.f3);
        this.t3 = i2;
        if (this.f3.d0()) {
            J();
        }
    }

    @UnstableApi
    @Deprecated
    public void setControllerVisibilityListener(@Nullable PlayerControlView.VisibilityListener visibilityListener) {
        Assertions.k(this.f3);
        PlayerControlView.VisibilityListener visibilityListener2 = this.l3;
        if (visibilityListener2 != visibilityListener) {
            if (visibilityListener2 != null) {
                this.f3.k0(visibilityListener2);
            }
            this.l3 = visibilityListener;
            if (visibilityListener != null) {
                this.f3.S(visibilityListener);
                setControllerVisibilityListener((ControllerVisibilityListener) null);
            }
        }
    }

    @UnstableApi
    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        Assertions.i(this.e3 != null);
        this.s3 = charSequence;
        R();
    }

    @UnstableApi
    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.o3 != drawable) {
            this.o3 = drawable;
            S(false);
        }
    }

    public void setErrorMessageProvider(@Nullable ErrorMessageProvider<? super PlaybackException> errorMessageProvider) {
        if (this.r3 != errorMessageProvider) {
            this.r3 = errorMessageProvider;
            R();
        }
    }

    public void setFullscreenButtonClickListener(@Nullable FullscreenButtonClickListener fullscreenButtonClickListener) {
        Assertions.k(this.f3);
        this.m3 = fullscreenButtonClickListener;
        this.f3.setOnFullScreenModeChangedListener(this.s);
    }

    @UnstableApi
    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.q3 != z) {
            this.q3 = z;
            S(false);
        }
    }

    public void setPlayer(@Nullable Player player) {
        Assertions.i(Looper.myLooper() == Looper.getMainLooper());
        Assertions.a(player == null || player.k2() == Looper.getMainLooper());
        Player player2 = this.i3;
        if (player2 != player) {
            if (player2 != null) {
                player2.N1(this.s);
                if (player2.R1(27)) {
                    View view = this.Z2;
                    if (view instanceof TextureView) {
                        player2.y((TextureView) view);
                    } else if (view instanceof SurfaceView) {
                        player2.O((SurfaceView) view);
                    }
                }
            }
            SubtitleView subtitleView = this.c3;
            if (subtitleView != null) {
                subtitleView.setCues((List<Cue>) null);
            }
            this.i3 = player;
            if (U()) {
                this.f3.setPlayer(player);
            }
            O();
            R();
            S(true);
            if (player != null) {
                if (player.R1(27)) {
                    View view2 = this.Z2;
                    if (view2 instanceof TextureView) {
                        player.Y((TextureView) view2);
                    } else if (view2 instanceof SurfaceView) {
                        player.E((SurfaceView) view2);
                    }
                    if (!player.R1(30) || player.D1().g(2)) {
                        N();
                    }
                }
                if (this.c3 != null && player.R1(28)) {
                    this.c3.setCues(player.M().s);
                }
                player.f2(this.s);
                A(false);
                return;
            }
            w();
        }
    }

    @UnstableApi
    public void setRepeatToggleModes(int i2) {
        Assertions.k(this.f3);
        this.f3.setRepeatToggleModes(i2);
    }

    @UnstableApi
    public void setResizeMode(int i2) {
        Assertions.k(this.X2);
        this.X2.setResizeMode(i2);
    }

    @UnstableApi
    public void setShowBuffering(int i2) {
        if (this.p3 != i2) {
            this.p3 = i2;
            O();
        }
    }

    @UnstableApi
    public void setShowFastForwardButton(boolean z) {
        Assertions.k(this.f3);
        this.f3.setShowFastForwardButton(z);
    }

    @UnstableApi
    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z) {
        Assertions.k(this.f3);
        this.f3.setShowMultiWindowTimeBar(z);
    }

    @UnstableApi
    public void setShowNextButton(boolean z) {
        Assertions.k(this.f3);
        this.f3.setShowNextButton(z);
    }

    @UnstableApi
    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z) {
        Assertions.k(this.f3);
        this.f3.setShowPlayButtonIfPlaybackIsSuppressed(z);
    }

    @UnstableApi
    public void setShowPreviousButton(boolean z) {
        Assertions.k(this.f3);
        this.f3.setShowPreviousButton(z);
    }

    @UnstableApi
    public void setShowRewindButton(boolean z) {
        Assertions.k(this.f3);
        this.f3.setShowRewindButton(z);
    }

    @UnstableApi
    public void setShowShuffleButton(boolean z) {
        Assertions.k(this.f3);
        this.f3.setShowShuffleButton(z);
    }

    @UnstableApi
    public void setShowSubtitleButton(boolean z) {
        Assertions.k(this.f3);
        this.f3.setShowSubtitleButton(z);
    }

    @UnstableApi
    public void setShowVrButton(boolean z) {
        Assertions.k(this.f3);
        this.f3.setShowVrButton(z);
    }

    @UnstableApi
    public void setShutterBackgroundColor(@ColorInt int i2) {
        View view = this.Y2;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    @UnstableApi
    @Deprecated
    public void setUseArtwork(boolean z) {
        setArtworkDisplayMode(z ^ true ? 1 : 0);
    }

    public void setUseController(boolean z) {
        PlayerControlView playerControlView;
        Player player;
        boolean z2 = true;
        Assertions.i(!z || this.f3 != null);
        if (!z && !hasOnClickListeners()) {
            z2 = false;
        }
        setClickable(z2);
        if (this.j3 != z) {
            this.j3 = z;
            if (U()) {
                playerControlView = this.f3;
                player = this.i3;
            } else {
                PlayerControlView playerControlView2 = this.f3;
                if (playerControlView2 != null) {
                    playerControlView2.Y();
                    playerControlView = this.f3;
                    player = null;
                }
                P();
            }
            playerControlView.setPlayer(player);
            P();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        View view = this.Z2;
        if (view instanceof SurfaceView) {
            view.setVisibility(i2);
        }
    }

    @UnstableApi
    public boolean u(KeyEvent keyEvent) {
        return U() && this.f3.U(keyEvent);
    }

    @UnstableApi
    public void w() {
        PlayerControlView playerControlView = this.f3;
        if (playerControlView != null) {
            playerControlView.Y();
        }
    }

    @UnstableApi
    public boolean x() {
        PlayerControlView playerControlView = this.f3;
        return playerControlView != null && playerControlView.d0();
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setControllerVisibilityListener(@Nullable ControllerVisibilityListener controllerVisibilityListener) {
        this.k3 = controllerVisibilityListener;
        if (controllerVisibilityListener != null) {
            setControllerVisibilityListener((PlayerControlView.VisibilityListener) null);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: android.view.SurfaceView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: android.view.TextureView} */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PlayerView(android.content.Context r21, @androidx.annotation.Nullable android.util.AttributeSet r22, int r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            r3 = 1
            r20.<init>(r21, r22, r23)
            androidx.media3.ui.PlayerView$ComponentListener r4 = new androidx.media3.ui.PlayerView$ComponentListener
            r4.<init>()
            r1.s = r4
            boolean r5 = r20.isInEditMode()
            r6 = 0
            r7 = 0
            if (r5 == 0) goto L_0x004d
            r1.X2 = r6
            r1.Y2 = r6
            r1.Z2 = r6
            r1.a3 = r7
            r1.b3 = r6
            r1.c3 = r6
            r1.d3 = r6
            r1.e3 = r6
            r1.f3 = r6
            r1.g3 = r6
            r1.h3 = r6
            android.widget.ImageView r2 = new android.widget.ImageView
            r2.<init>(r0)
            int r3 = androidx.media3.common.util.Util.f9646a
            r4 = 23
            if (r3 < r4) goto L_0x0042
            android.content.res.Resources r3 = r20.getResources()
            t(r0, r3, r2)
            goto L_0x0049
        L_0x0042:
            android.content.res.Resources r3 = r20.getResources()
            s(r0, r3, r2)
        L_0x0049:
            r1.addView(r2)
            return
        L_0x004d:
            int r5 = androidx.media3.ui.R.layout.f14771g
            r8 = 5000(0x1388, float:7.006E-42)
            if (r2 == 0) goto L_0x00e3
            android.content.res.Resources$Theme r9 = r21.getTheme()
            int[] r10 = androidx.media3.ui.R.styleable.i1
            r11 = r23
            android.content.res.TypedArray r9 = r9.obtainStyledAttributes(r2, r10, r11, r7)
            int r10 = androidx.media3.ui.R.styleable.L1     // Catch:{ all -> 0x00de }
            boolean r11 = r9.hasValue(r10)     // Catch:{ all -> 0x00de }
            int r10 = r9.getColor(r10, r7)     // Catch:{ all -> 0x00de }
            int r12 = androidx.media3.ui.R.styleable.y1     // Catch:{ all -> 0x00de }
            int r5 = r9.getResourceId(r12, r5)     // Catch:{ all -> 0x00de }
            int r12 = androidx.media3.ui.R.styleable.Q1     // Catch:{ all -> 0x00de }
            boolean r12 = r9.getBoolean(r12, r3)     // Catch:{ all -> 0x00de }
            int r13 = androidx.media3.ui.R.styleable.m1     // Catch:{ all -> 0x00de }
            int r13 = r9.getInt(r13, r3)     // Catch:{ all -> 0x00de }
            int r14 = androidx.media3.ui.R.styleable.s1     // Catch:{ all -> 0x00de }
            int r14 = r9.getResourceId(r14, r7)     // Catch:{ all -> 0x00de }
            int r15 = androidx.media3.ui.R.styleable.R1     // Catch:{ all -> 0x00de }
            boolean r15 = r9.getBoolean(r15, r3)     // Catch:{ all -> 0x00de }
            int r6 = androidx.media3.ui.R.styleable.M1     // Catch:{ all -> 0x00de }
            int r6 = r9.getInt(r6, r3)     // Catch:{ all -> 0x00de }
            int r3 = androidx.media3.ui.R.styleable.A1     // Catch:{ all -> 0x00de }
            int r3 = r9.getInt(r3, r7)     // Catch:{ all -> 0x00de }
            int r7 = androidx.media3.ui.R.styleable.J1     // Catch:{ all -> 0x00de }
            int r8 = r9.getInt(r7, r8)     // Catch:{ all -> 0x00de }
            int r7 = androidx.media3.ui.R.styleable.u1     // Catch:{ all -> 0x00de }
            r23 = r3
            r3 = 1
            boolean r7 = r9.getBoolean(r7, r3)     // Catch:{ all -> 0x00de }
            r17 = r5
            int r5 = androidx.media3.ui.R.styleable.n1     // Catch:{ all -> 0x00de }
            boolean r5 = r9.getBoolean(r5, r3)     // Catch:{ all -> 0x00de }
            int r3 = androidx.media3.ui.R.styleable.G1     // Catch:{ all -> 0x00de }
            r18 = r5
            r5 = 0
            int r3 = r9.getInteger(r3, r5)     // Catch:{ all -> 0x00de }
            int r5 = androidx.media3.ui.R.styleable.v1     // Catch:{ all -> 0x00de }
            r19 = r3
            boolean r3 = r1.q3     // Catch:{ all -> 0x00de }
            boolean r3 = r9.getBoolean(r5, r3)     // Catch:{ all -> 0x00de }
            r1.q3 = r3     // Catch:{ all -> 0x00de }
            int r3 = androidx.media3.ui.R.styleable.t1     // Catch:{ all -> 0x00de }
            r5 = 1
            boolean r3 = r9.getBoolean(r3, r5)     // Catch:{ all -> 0x00de }
            r9.recycle()
            r5 = r18
            r9 = r19
            r18 = r3
            r3 = r23
            r23 = r8
            r8 = r17
            r17 = r15
            r15 = r13
            r13 = r11
            r11 = r14
            r14 = r12
            r12 = r10
            r10 = r6
            goto L_0x00f4
        L_0x00de:
            r0 = move-exception
            r9.recycle()
            throw r0
        L_0x00e3:
            r8 = r5
            r23 = 5000(0x1388, float:7.006E-42)
            r3 = 0
            r5 = 1
            r7 = 1
            r9 = 0
            r10 = 1
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 1
            r15 = 1
            r17 = 1
            r18 = 1
        L_0x00f4:
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r21)
            r6.inflate(r8, r1)
            r6 = 262144(0x40000, float:3.67342E-40)
            r1.setDescendantFocusability(r6)
            int r6 = androidx.media3.ui.R.id.e0
            android.view.View r6 = r1.findViewById(r6)
            androidx.media3.ui.AspectRatioFrameLayout r6 = (androidx.media3.ui.AspectRatioFrameLayout) r6
            r1.X2 = r6
            if (r6 == 0) goto L_0x010f
            H(r6, r3)
        L_0x010f:
            int r3 = androidx.media3.ui.R.id.L0
            android.view.View r3 = r1.findViewById(r3)
            r1.Y2 = r3
            if (r3 == 0) goto L_0x011e
            if (r13 == 0) goto L_0x011e
            r3.setBackgroundColor(r12)
        L_0x011e:
            if (r6 == 0) goto L_0x01b0
            if (r10 == 0) goto L_0x01b0
            android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams
            r8 = -1
            r3.<init>(r8, r8)
            r8 = 2
            if (r10 == r8) goto L_0x0193
            r8 = 3
            java.lang.Class<android.content.Context> r12 = android.content.Context.class
            if (r10 == r8) goto L_0x016b
            r8 = 4
            if (r10 == r8) goto L_0x0144
            android.view.SurfaceView r8 = new android.view.SurfaceView
            r8.<init>(r0)
            int r10 = androidx.media3.common.util.Util.f9646a
            r12 = 34
            if (r10 < r12) goto L_0x0141
            androidx.media3.ui.PlayerView.Api34.a(r8)
        L_0x0141:
            r1.Z2 = r8
            goto L_0x0199
        L_0x0144:
            java.lang.String r8 = "androidx.media3.exoplayer.video.VideoDecoderGLSurfaceView"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ Exception -> 0x0162 }
            r10 = 1
            java.lang.Class[] r13 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x0162 }
            r16 = 0
            r13[r16] = r12     // Catch:{ Exception -> 0x0162 }
            java.lang.reflect.Constructor r8 = r8.getConstructor(r13)     // Catch:{ Exception -> 0x0162 }
            java.lang.Object[] r12 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x0162 }
            r12[r16] = r0     // Catch:{ Exception -> 0x0162 }
            java.lang.Object r8 = r8.newInstance(r12)     // Catch:{ Exception -> 0x0162 }
            android.view.View r8 = (android.view.View) r8     // Catch:{ Exception -> 0x0162 }
            r1.Z2 = r8     // Catch:{ Exception -> 0x0162 }
            goto L_0x0199
        L_0x0162:
            r0 = move-exception
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "video_decoder_gl_surface_view requires an ExoPlayer dependency"
            r2.<init>(r3, r0)
            throw r2
        L_0x016b:
            java.lang.String r8 = "androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ Exception -> 0x018a }
            r10 = 1
            java.lang.Class[] r13 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x018a }
            r16 = 0
            r13[r16] = r12     // Catch:{ Exception -> 0x018a }
            java.lang.reflect.Constructor r8 = r8.getConstructor(r13)     // Catch:{ Exception -> 0x018a }
            java.lang.Object[] r12 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x018a }
            r12[r16] = r0     // Catch:{ Exception -> 0x018a }
            java.lang.Object r8 = r8.newInstance(r12)     // Catch:{ Exception -> 0x018a }
            android.view.View r8 = (android.view.View) r8     // Catch:{ Exception -> 0x018a }
            r1.Z2 = r8     // Catch:{ Exception -> 0x018a }
            r8 = 1
            goto L_0x019a
        L_0x018a:
            r0 = move-exception
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "spherical_gl_surface_view requires an ExoPlayer dependency"
            r2.<init>(r3, r0)
            throw r2
        L_0x0193:
            android.view.TextureView r8 = new android.view.TextureView
            r8.<init>(r0)
            goto L_0x0141
        L_0x0199:
            r8 = 0
        L_0x019a:
            android.view.View r10 = r1.Z2
            r10.setLayoutParams(r3)
            android.view.View r3 = r1.Z2
            r3.setOnClickListener(r4)
            android.view.View r3 = r1.Z2
            r10 = 0
            r3.setClickable(r10)
            android.view.View r3 = r1.Z2
            r6.addView(r3, r10)
            goto L_0x01b4
        L_0x01b0:
            r3 = 0
            r1.Z2 = r3
            r8 = 0
        L_0x01b4:
            r1.a3 = r8
            int r3 = androidx.media3.ui.R.id.W
            android.view.View r3 = r1.findViewById(r3)
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r1.g3 = r3
            int r3 = androidx.media3.ui.R.id.w0
            android.view.View r3 = r1.findViewById(r3)
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r1.h3 = r3
            int r3 = androidx.media3.ui.R.id.X
            android.view.View r3 = r1.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r1.b3 = r3
            if (r14 == 0) goto L_0x01db
            if (r15 == 0) goto L_0x01db
            if (r3 == 0) goto L_0x01db
            goto L_0x01dc
        L_0x01db:
            r15 = 0
        L_0x01dc:
            r1.n3 = r15
            if (r11 == 0) goto L_0x01ea
            android.content.Context r3 = r20.getContext()
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.l(r3, r11)
            r1.o3 = r3
        L_0x01ea:
            int r3 = androidx.media3.ui.R.id.O0
            android.view.View r3 = r1.findViewById(r3)
            androidx.media3.ui.SubtitleView r3 = (androidx.media3.ui.SubtitleView) r3
            r1.c3 = r3
            if (r3 == 0) goto L_0x01fc
            r3.e()
            r3.f()
        L_0x01fc:
            int r3 = androidx.media3.ui.R.id.b0
            android.view.View r3 = r1.findViewById(r3)
            r1.d3 = r3
            r6 = 8
            if (r3 == 0) goto L_0x020b
            r3.setVisibility(r6)
        L_0x020b:
            r1.p3 = r9
            int r3 = androidx.media3.ui.R.id.j0
            android.view.View r3 = r1.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r1.e3 = r3
            if (r3 == 0) goto L_0x021c
            r3.setVisibility(r6)
        L_0x021c:
            int r3 = androidx.media3.ui.R.id.f0
            android.view.View r6 = r1.findViewById(r3)
            androidx.media3.ui.PlayerControlView r6 = (androidx.media3.ui.PlayerControlView) r6
            int r8 = androidx.media3.ui.R.id.g0
            android.view.View r8 = r1.findViewById(r8)
            if (r6 == 0) goto L_0x0230
            r1.f3 = r6
            r9 = 0
            goto L_0x025a
        L_0x0230:
            if (r8 == 0) goto L_0x0256
            androidx.media3.ui.PlayerControlView r6 = new androidx.media3.ui.PlayerControlView
            r9 = 0
            r10 = 0
            r6.<init>(r0, r10, r9, r2)
            r1.f3 = r6
            r6.setId(r3)
            android.view.ViewGroup$LayoutParams r0 = r8.getLayoutParams()
            r6.setLayoutParams(r0)
            android.view.ViewParent r0 = r8.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r2 = r0.indexOfChild(r8)
            r0.removeView(r8)
            r0.addView(r6, r2)
            goto L_0x025a
        L_0x0256:
            r9 = 0
            r10 = 0
            r1.f3 = r10
        L_0x025a:
            androidx.media3.ui.PlayerControlView r0 = r1.f3
            if (r0 == 0) goto L_0x0261
            r2 = r23
            goto L_0x0262
        L_0x0261:
            r2 = 0
        L_0x0262:
            r1.t3 = r2
            r1.w3 = r7
            r1.u3 = r5
            r3 = r18
            r1.v3 = r3
            if (r17 == 0) goto L_0x0272
            if (r0 == 0) goto L_0x0272
            r7 = 1
            goto L_0x0273
        L_0x0272:
            r7 = 0
        L_0x0273:
            r1.j3 = r7
            if (r0 == 0) goto L_0x027f
            r0.Z()
            androidx.media3.ui.PlayerControlView r0 = r1.f3
            r0.S(r4)
        L_0x027f:
            if (r17 == 0) goto L_0x0285
            r0 = 1
            r1.setClickable(r0)
        L_0x0285:
            r20.P()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
