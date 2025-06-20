package androidx.media3.exoplayer.util;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Format;
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
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.C0205a;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.commons.lang3.StringUtils;

public class EventLogger implements AnalyticsListener {
    private static final String q0 = "EventLogger";
    private static final int r0 = 3;
    private static final NumberFormat s0;
    private final String m0;
    private final Timeline.Window n0;
    private final Timeline.Period o0;
    private final long p0;

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        s0 = instance;
        instance.setMinimumFractionDigits(2);
        instance.setMaximumFractionDigits(2);
        instance.setGroupingUsed(false);
    }

    public EventLogger() {
        this(q0);
    }

    private static String D0(int i2) {
        if (i2 == 0) {
            return "REPEAT";
        }
        if (i2 == 1) {
            return "AUTO";
        }
        if (i2 != 2) {
            return i2 != 3 ? "?" : "PLAYLIST_CHANGED";
        }
        return "SEEK";
    }

    private static String E0(int i2) {
        if (i2 == 1) {
            return "USER_REQUEST";
        }
        if (i2 == 2) {
            return "AUDIO_FOCUS_LOSS";
        }
        if (i2 == 3) {
            return "AUDIO_BECOMING_NOISY";
        }
        if (i2 != 4) {
            return i2 != 5 ? "?" : "END_OF_MEDIA_ITEM";
        }
        return "REMOTE";
    }

    private static String F0(int i2) {
        if (i2 != 0) {
            return i2 != 1 ? "?" : "TRANSIENT_AUDIO_FOCUS_LOSS";
        }
        return "NONE";
    }

    private static String G0(int i2) {
        if (i2 == 0) {
            return "OFF";
        }
        if (i2 != 1) {
            return i2 != 2 ? "?" : Rule.ALL;
        }
        return "ONE";
    }

    private static String H0(int i2) {
        if (i2 == 1) {
            return "IDLE";
        }
        if (i2 == 2) {
            return "BUFFERING";
        }
        if (i2 != 3) {
            return i2 != 4 ? "?" : "ENDED";
        }
        return "READY";
    }

    private static String I0(long j2) {
        return j2 == C.f9084b ? "?" : s0.format((double) (((float) j2) / 1000.0f));
    }

    private static String J0(int i2) {
        if (i2 != 0) {
            return i2 != 1 ? "?" : "SOURCE_UPDATE";
        }
        return "PLAYLIST_CHANGED";
    }

    private static String K0(boolean z) {
        return z ? "[X]" : "[ ]";
    }

    private void L0(AnalyticsListener.EventTime eventTime, String str) {
        N0(k0(eventTime, str, (String) null, (Throwable) null));
    }

    private void M0(AnalyticsListener.EventTime eventTime, String str, String str2) {
        N0(k0(eventTime, str, str2, (Throwable) null));
    }

    private static String N(int i2) {
        switch (i2) {
            case 0:
                return "AUTO_TRANSITION";
            case 1:
                return "SEEK";
            case 2:
                return "SEEK_ADJUSTMENT";
            case 3:
                return "SKIP";
            case 4:
                return "REMOVE";
            case 5:
                return "INTERNAL";
            case 6:
                return "SILENCE_SKIP";
            default:
                return "?";
        }
    }

    private void O0(AnalyticsListener.EventTime eventTime, String str, String str2, @Nullable Throwable th) {
        Q0(k0(eventTime, str, str2, th));
    }

    private void P0(AnalyticsListener.EventTime eventTime, String str, @Nullable Throwable th) {
        Q0(k0(eventTime, str, (String) null, th));
    }

    private void R0(AnalyticsListener.EventTime eventTime, String str, Exception exc) {
        O0(eventTime, "internalError", str, exc);
    }

    private void S0(Metadata metadata, String str) {
        for (int i2 = 0; i2 < metadata.g(); i2++) {
            N0(str + metadata.d(i2));
        }
    }

    private static String i(AudioSink.AudioTrackConfig audioTrackConfig) {
        return audioTrackConfig.f10786a + "," + audioTrackConfig.f10788c + "," + audioTrackConfig.f10787b + "," + audioTrackConfig.f10789d + "," + audioTrackConfig.f10790e + "," + audioTrackConfig.f10791f;
    }

    private String k0(AnalyticsListener.EventTime eventTime, String str, @Nullable String str2, @Nullable Throwable th) {
        String str3 = str + " [" + s0(eventTime);
        if (th instanceof PlaybackException) {
            str3 = str3 + ", errorCode=" + ((PlaybackException) th).g();
        }
        if (str2 != null) {
            str3 = str3 + ", " + str2;
        }
        String g2 = Log.g(th);
        if (!TextUtils.isEmpty(g2)) {
            str3 = str3 + "\n  " + g2.replace(StringUtils.LF, "\n  ") + 10;
        }
        return str3 + "]";
    }

    private String s0(AnalyticsListener.EventTime eventTime) {
        String str = "window=" + eventTime.f10508c;
        if (eventTime.f10509d != null) {
            str = str + ", period=" + eventTime.f10507b.g(eventTime.f10509d.f12163a);
            if (eventTime.f10509d.c()) {
                str = (str + ", adGroup=" + eventTime.f10509d.f12164b) + ", ad=" + eventTime.f10509d.f12165c;
            }
        }
        return "eventTime=" + I0(eventTime.f10506a - this.p0) + ", mediaPos=" + I0(eventTime.f10510e) + ", " + str;
    }

    public /* synthetic */ void A(AnalyticsListener.EventTime eventTime, Format format) {
        C0205a.h(this, eventTime, format);
    }

    @UnstableApi
    public void A0(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        O0(eventTime, "audioTrackUnderrun", i2 + ", " + j2 + ", " + j3, (Throwable) null);
    }

    @UnstableApi
    public void B(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        L0(eventTime, "videoDisabled");
    }

    @UnstableApi
    public void B0(AnalyticsListener.EventTime eventTime, int i2) {
        M0(eventTime, "audioSessionId", Integer.toString(i2));
    }

    public /* synthetic */ void C(AnalyticsListener.EventTime eventTime, boolean z, int i2) {
        C0205a.X(this, eventTime, z, i2);
    }

    @UnstableApi
    public void C0(AnalyticsListener.EventTime eventTime, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        M0(eventTime, "audioInputFormat", Format.m(format));
    }

    @UnstableApi
    public void D(AnalyticsListener.EventTime eventTime) {
        L0(eventTime, "drmSessionReleased");
    }

    @UnstableApi
    public void E(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
    }

    public /* synthetic */ void F(AnalyticsListener.EventTime eventTime, Exception exc) {
        C0205a.b(this, eventTime, exc);
    }

    public /* synthetic */ void G(AnalyticsListener.EventTime eventTime, Format format) {
        C0205a.u0(this, eventTime, format);
    }

    public /* synthetic */ void H(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        C0205a.V(this, eventTime, playbackException);
    }

    public /* synthetic */ void I(AnalyticsListener.EventTime eventTime, String str, long j2) {
        C0205a.o0(this, eventTime, str, j2);
    }

    public /* synthetic */ void J(AnalyticsListener.EventTime eventTime) {
        C0205a.f0(this, eventTime);
    }

    @UnstableApi
    public void K(AnalyticsListener.EventTime eventTime) {
        L0(eventTime, "drmKeysRestored");
    }

    @UnstableApi
    public void L(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    @UnstableApi
    public void M(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        Metadata metadata;
        N0("tracks [" + s0(eventTime));
        ImmutableList<Tracks.Group> d2 = tracks.d();
        for (int i2 = 0; i2 < d2.size(); i2++) {
            Tracks.Group group = d2.get(i2);
            N0("  group [");
            for (int i3 = 0; i3 < group.s; i3++) {
                String K0 = K0(group.l(i3));
                String v0 = Util.v0(group.f(i3));
                N0("    " + K0 + " Track:" + i3 + ", " + Format.m(group.e(i3)) + ", supported=" + v0);
            }
            N0("  ]");
        }
        boolean z = false;
        int i4 = 0;
        while (!z && i4 < d2.size()) {
            Tracks.Group group2 = d2.get(i4);
            int i5 = 0;
            while (!z && i5 < group2.s) {
                if (group2.l(i5) && (metadata = group2.e(i5).d3) != null && metadata.g() > 0) {
                    N0("  Metadata [");
                    S0(metadata, "    ");
                    N0("  ]");
                    z = true;
                }
                i5++;
            }
            i4++;
        }
        N0("]");
    }

    /* access modifiers changed from: protected */
    @UnstableApi
    public void N0(String str) {
        Log.b(this.m0, str);
    }

    public /* synthetic */ void O(AnalyticsListener.EventTime eventTime, long j2) {
        C0205a.M(this, eventTime, j2);
    }

    @UnstableApi
    public void P(AnalyticsListener.EventTime eventTime, int i2) {
        M0(eventTime, "repeatMode", G0(i2));
    }

    public /* synthetic */ void Q(AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
        C0205a.r(this, eventTime, cueGroup);
    }

    /* access modifiers changed from: protected */
    @UnstableApi
    public void Q0(String str) {
        Log.d(this.m0, str);
    }

    @UnstableApi
    public void R(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        M0(eventTime, "audioDecoderInitialized", str);
    }

    @UnstableApi
    public void S(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        M0(eventTime, "videoDecoderInitialized", str);
    }

    public /* synthetic */ void T(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        C0205a.k0(this, eventTime, trackSelectionParameters);
    }

    public /* synthetic */ void U(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        C0205a.O(this, eventTime, mediaMetadata);
    }

    @UnstableApi
    public void V(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        M0(eventTime, "audioAttributes", audioAttributes.s + "," + audioAttributes.X + "," + audioAttributes.Y + "," + audioAttributes.Z);
    }

    @UnstableApi
    public void W(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        M0(eventTime, "videoSize", videoSize.s + ", " + videoSize.X);
    }

    public /* synthetic */ void X(AnalyticsListener.EventTime eventTime, long j2) {
        C0205a.e0(this, eventTime, j2);
    }

    @UnstableApi
    public void Y(AnalyticsListener.EventTime eventTime, int i2) {
        int n2 = eventTime.f10507b.n();
        int w = eventTime.f10507b.w();
        N0("timeline [" + s0(eventTime) + ", periodCount=" + n2 + ", windowCount=" + w + ", reason=" + J0(i2));
        for (int i3 = 0; i3 < Math.min(n2, 3); i3++) {
            eventTime.f10507b.k(i3, this.o0);
            N0("  period [" + I0(this.o0.n()) + "]");
        }
        if (n2 > 3) {
            N0("  ...");
        }
        for (int i4 = 0; i4 < Math.min(w, 3); i4++) {
            eventTime.f10507b.u(i4, this.n0);
            N0("  window [" + I0(this.n0.f()) + ", seekable=" + this.n0.a3 + ", dynamic=" + this.n0.b3 + "]");
        }
        if (w > 3) {
            N0("  ...");
        }
        N0("]");
    }

    public /* synthetic */ void Z(AnalyticsListener.EventTime eventTime, long j2, int i2) {
        C0205a.t0(this, eventTime, j2, i2);
    }

    public /* synthetic */ void a(AnalyticsListener.EventTime eventTime, String str, long j2) {
        C0205a.c(this, eventTime, str, j2);
    }

    @UnstableApi
    public void a0(AnalyticsListener.EventTime eventTime, Exception exc) {
        R0(eventTime, "drmSessionManagerError", exc);
    }

    @UnstableApi
    public void b(AnalyticsListener.EventTime eventTime, Object obj, long j2) {
        M0(eventTime, "renderedFirstFrame", String.valueOf(obj));
    }

    @UnstableApi
    public void b0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        L0(eventTime, "audioDisabled");
    }

    @UnstableApi
    public void c(AnalyticsListener.EventTime eventTime, boolean z) {
        M0(eventTime, "loading", Boolean.toString(z));
    }

    @UnstableApi
    public void c0(AnalyticsListener.EventTime eventTime, @Nullable MediaItem mediaItem, int i2) {
        N0("mediaItem [" + s0(eventTime) + ", reason=" + D0(i2) + "]");
    }

    @UnstableApi
    public void d(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        M0(eventTime, "audioTrackInit", i(audioTrackConfig));
    }

    @UnstableApi
    public void d0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        L0(eventTime, "audioEnabled");
    }

    @UnstableApi
    public void e(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        M0(eventTime, "playbackParameters", playbackParameters.toString());
    }

    @UnstableApi
    public void e0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        M0(eventTime, "downstreamFormat", Format.m(mediaLoadData.f12151c));
    }

    @UnstableApi
    public void f(AnalyticsListener.EventTime eventTime, String str) {
        M0(eventTime, "audioDecoderReleased", str);
    }

    public /* synthetic */ void f0(Player player, AnalyticsListener.Events events) {
        C0205a.E(this, player, events);
    }

    @UnstableApi
    public void g(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        M0(eventTime, "audioTrackReleased", i(audioTrackConfig));
    }

    public /* synthetic */ void g0(AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
        C0205a.t(this, eventTime, deviceInfo);
    }

    @UnstableApi
    public void h(AnalyticsListener.EventTime eventTime, String str) {
        M0(eventTime, "videoDecoderReleased", str);
    }

    public /* synthetic */ void h0(AnalyticsListener.EventTime eventTime) {
        C0205a.W(this, eventTime);
    }

    public /* synthetic */ void i0(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        C0205a.Y(this, eventTime, mediaMetadata);
    }

    public /* synthetic */ void j(AnalyticsListener.EventTime eventTime, int i2, boolean z) {
        C0205a.u(this, eventTime, i2, z);
    }

    @UnstableApi
    public void j0(AnalyticsListener.EventTime eventTime, int i2, int i3) {
        M0(eventTime, "surfaceSize", i2 + ", " + i3);
    }

    @UnstableApi
    public void k(AnalyticsListener.EventTime eventTime, int i2) {
        M0(eventTime, "playbackSuppressionReason", F0(i2));
    }

    @UnstableApi
    public void l(AnalyticsListener.EventTime eventTime, boolean z) {
        M0(eventTime, "isPlaying", Boolean.toString(z));
    }

    @UnstableApi
    public void l0(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("reason=");
        sb.append(N(i2));
        sb.append(", PositionInfo:old [");
        sb.append("mediaItem=");
        sb.append(positionInfo.Y);
        sb.append(", period=");
        sb.append(positionInfo.Y2);
        sb.append(", pos=");
        sb.append(positionInfo.Z2);
        if (positionInfo.b3 != -1) {
            sb.append(", contentPos=");
            sb.append(positionInfo.a3);
            sb.append(", adGroup=");
            sb.append(positionInfo.b3);
            sb.append(", ad=");
            sb.append(positionInfo.c3);
        }
        sb.append("], PositionInfo:new [");
        sb.append("mediaItem=");
        sb.append(positionInfo2.Y);
        sb.append(", period=");
        sb.append(positionInfo2.Y2);
        sb.append(", pos=");
        sb.append(positionInfo2.Z2);
        if (positionInfo2.b3 != -1) {
            sb.append(", contentPos=");
            sb.append(positionInfo2.a3);
            sb.append(", adGroup=");
            sb.append(positionInfo2.b3);
            sb.append(", ad=");
            sb.append(positionInfo2.c3);
        }
        sb.append("]");
        M0(eventTime, "positionDiscontinuity", sb.toString());
    }

    @UnstableApi
    public void m(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        N0("metadata [" + s0(eventTime));
        S0(metadata, "  ");
        N0("]");
    }

    @UnstableApi
    public void m0(AnalyticsListener.EventTime eventTime, int i2) {
        M0(eventTime, "drmSessionAcquired", "state=" + i2);
    }

    @UnstableApi
    public void n(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        M0(eventTime, "upstreamDiscarded", Format.m(mediaLoadData.f12151c));
    }

    @UnstableApi
    public void n0(AnalyticsListener.EventTime eventTime) {
        L0(eventTime, "drmKeysLoaded");
    }

    public /* synthetic */ void o(AnalyticsListener.EventTime eventTime, List list) {
        C0205a.s(this, eventTime, list);
    }

    public /* synthetic */ void o0(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        C0205a.p(this, eventTime, commands);
    }

    @UnstableApi
    public void p(AnalyticsListener.EventTime eventTime) {
        L0(eventTime, "drmKeysRemoved");
    }

    public /* synthetic */ void p0(AnalyticsListener.EventTime eventTime, Exception exc) {
        C0205a.n0(this, eventTime, exc);
    }

    @UnstableApi
    public void q(AnalyticsListener.EventTime eventTime, boolean z) {
        M0(eventTime, "skipSilenceEnabled", Boolean.toString(z));
    }

    @UnstableApi
    public void q0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    @UnstableApi
    public void r(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        P0(eventTime, "playerFailed", playbackException);
    }

    @UnstableApi
    public void r0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        L0(eventTime, "videoEnabled");
    }

    public /* synthetic */ void s(AnalyticsListener.EventTime eventTime, int i2, int i3, int i4, float f2) {
        C0205a.w0(this, eventTime, i2, i3, i4, f2);
    }

    public /* synthetic */ void t(AnalyticsListener.EventTime eventTime, boolean z) {
        C0205a.L(this, eventTime, z);
    }

    @UnstableApi
    public void t0(AnalyticsListener.EventTime eventTime, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        M0(eventTime, "videoInputFormat", Format.m(format));
    }

    @UnstableApi
    public void u(AnalyticsListener.EventTime eventTime, int i2, long j2) {
        M0(eventTime, "droppedFrames", Integer.toString(i2));
    }

    public /* synthetic */ void u0(AnalyticsListener.EventTime eventTime, Exception exc) {
        C0205a.l(this, eventTime, exc);
    }

    public /* synthetic */ void v(AnalyticsListener.EventTime eventTime, long j2) {
        C0205a.d0(this, eventTime, j2);
    }

    @UnstableApi
    public void v0(AnalyticsListener.EventTime eventTime, float f2) {
        M0(eventTime, "volume", Float.toString(f2));
    }

    public /* synthetic */ void w(AnalyticsListener.EventTime eventTime, int i2) {
        C0205a.Z(this, eventTime, i2);
    }

    @UnstableApi
    public void w0(AnalyticsListener.EventTime eventTime, boolean z) {
        M0(eventTime, "shuffleModeEnabled", Boolean.toString(z));
    }

    public /* synthetic */ void x(AnalyticsListener.EventTime eventTime) {
        C0205a.z(this, eventTime);
    }

    @UnstableApi
    public void x0(AnalyticsListener.EventTime eventTime, int i2) {
        M0(eventTime, "state", H0(i2));
    }

    @UnstableApi
    public void y(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    @UnstableApi
    public void y0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        R0(eventTime, "loadError", iOException);
    }

    @UnstableApi
    public void z(AnalyticsListener.EventTime eventTime, boolean z, int i2) {
        M0(eventTime, "playWhenReady", z + ", " + E0(i2));
    }

    public /* synthetic */ void z0(AnalyticsListener.EventTime eventTime, long j2) {
        C0205a.j(this, eventTime, j2);
    }

    @UnstableApi
    @Deprecated
    public EventLogger(@Nullable MappingTrackSelector mappingTrackSelector) {
        this(q0);
    }

    @UnstableApi
    @Deprecated
    public EventLogger(@Nullable MappingTrackSelector mappingTrackSelector, String str) {
        this(str);
    }

    public EventLogger(String str) {
        this.m0 = str;
        this.n0 = new Timeline.Window();
        this.o0 = new Timeline.Period();
        this.p0 = SystemClock.elapsedRealtime();
    }
}
