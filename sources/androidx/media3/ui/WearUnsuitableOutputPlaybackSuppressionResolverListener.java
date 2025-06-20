package androidx.media3.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
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
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.List;
import java.util.concurrent.TimeUnit;

@UnstableApi
public final class WearUnsuitableOutputPlaybackSuppressionResolverListener implements Player.Listener {
    private static final String X2 = "com.android.settings.panel.action.MEDIA_OUTPUT";
    private static final String Y2 = "com.android.settings.panel.extra.PACKAGE_NAME";
    private static final String Z2 = "EXTRA_CLOSE_ON_CONNECT";
    private static final String a3 = "EXTRA_CONNECTION_ONLY";
    private static final String b3 = "android.bluetooth.devicepicker.extra.FILTER_TYPE";
    private static final int c3 = 1;
    public static final long d3 = TimeUnit.MINUTES.toMillis(5);
    private final long X;
    private final Clock Y;
    private long Z;
    private final Context s;

    public WearUnsuitableOutputPlaybackSuppressionResolverListener(Context context) {
        this(context, d3);
    }

    @Nullable
    private static ComponentName A(Context context, Intent intent) {
        ApplicationInfo applicationInfo;
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null && (applicationInfo.flags & TsExtractor.J) != 0) {
                return new ComponentName(activityInfo.packageName, activityInfo.name);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0024, code lost:
        r0 = new android.content.Intent("android.settings.BLUETOOTH_SETTINGS").addFlags(268468224).putExtra(Z2, true).putExtra(a3, true).putExtra(b3, 1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void O(android.content.Context r3) {
        /*
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.android.settings.panel.action.MEDIA_OUTPUT"
            r0.<init>(r1)
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            android.content.Intent r0 = r0.addFlags(r1)
            java.lang.String r1 = r3.getPackageName()
            java.lang.String r2 = "com.android.settings.panel.extra.PACKAGE_NAME"
            android.content.Intent r0 = r0.putExtra(r2, r1)
            android.content.ComponentName r1 = A(r3, r0)
            if (r1 == 0) goto L_0x0024
        L_0x001d:
            r0.setComponent(r1)
            r3.startActivity(r0)
            goto L_0x004c
        L_0x0024:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.settings.BLUETOOTH_SETTINGS"
            r0.<init>(r1)
            r1 = 268468224(0x10008000, float:2.5342157E-29)
            android.content.Intent r0 = r0.addFlags(r1)
            java.lang.String r1 = "EXTRA_CLOSE_ON_CONNECT"
            r2 = 1
            android.content.Intent r0 = r0.putExtra(r1, r2)
            java.lang.String r1 = "EXTRA_CONNECTION_ONLY"
            android.content.Intent r0 = r0.putExtra(r1, r2)
            java.lang.String r1 = "android.bluetooth.devicepicker.extra.FILTER_TYPE"
            android.content.Intent r0 = r0.putExtra(r1, r2)
            android.content.ComponentName r1 = A(r3, r0)
            if (r1 == 0) goto L_0x004c
            goto L_0x001d
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.WearUnsuitableOutputPlaybackSuppressionResolverListener.O(android.content.Context):void");
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
        if (Util.r1(this.s)) {
            if ((events.a(6) || events.a(5)) && player.m0() && player.g2() == 3) {
                player.h();
                this.Z = this.Y.b();
                if (events.a(5)) {
                    O(this.s);
                }
            } else if (events.a(6) && player.g2() == 0 && this.Z != C.f9084b && this.Y.b() - this.Z < this.X) {
                this.Z = C.f9084b;
                player.o();
            }
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

    public WearUnsuitableOutputPlaybackSuppressionResolverListener(Context context, @IntRange(from = 0) long j2) {
        this(context, j2, Clock.f9502a);
    }

    @VisibleForTesting
    WearUnsuitableOutputPlaybackSuppressionResolverListener(Context context, @IntRange(from = 0) long j2, Clock clock) {
        Assertions.a(j2 >= 0);
        this.s = context.getApplicationContext();
        this.X = j2;
        this.Y = clock;
        this.Z = C.f9084b;
    }
}
