package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public interface Renderer extends PlayerMessage.Target {

    /* renamed from: c  reason: collision with root package name */
    public static final int f10430c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f10431d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f10432e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f10433f = 4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f10434g = 5;

    /* renamed from: h  reason: collision with root package name */
    public static final int f10435h = 6;

    /* renamed from: i  reason: collision with root package name */
    public static final int f10436i = 7;

    /* renamed from: j  reason: collision with root package name */
    public static final int f10437j = 8;

    /* renamed from: k  reason: collision with root package name */
    public static final int f10438k = 9;

    /* renamed from: l  reason: collision with root package name */
    public static final int f10439l = 10;

    /* renamed from: m  reason: collision with root package name */
    public static final int f10440m = 11;

    /* renamed from: n  reason: collision with root package name */
    public static final int f10441n = 12;
    public static final int o = 13;
    public static final int p = 14;
    public static final int q = 15;
    public static final int r = 10000;
    public static final int t = 0;
    public static final int u = 1;
    public static final int v = 2;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessageType {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public interface WakeupListener {
        void a();

        void b();
    }

    void A(Format[] formatArr, SampleStream sampleStream, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException;

    void B() throws IOException;

    long C();

    void E(long j2) throws ExoPlaybackException;

    boolean F();

    @Nullable
    MediaClock G();

    void a();

    boolean c();

    boolean d();

    @Nullable
    SampleStream e();

    void g(long j2, long j3) throws ExoPlaybackException;

    String getName();

    int getState();

    void h();

    int i();

    boolean l();

    void m(Timeline timeline);

    void n(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j2, boolean z, boolean z2, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException;

    void o(int i2, PlayerId playerId, Clock clock);

    void p();

    void q();

    void reset();

    RendererCapabilities s();

    void start() throws ExoPlaybackException;

    void stop();

    void v(float f2, float f3) throws ExoPlaybackException;
}
