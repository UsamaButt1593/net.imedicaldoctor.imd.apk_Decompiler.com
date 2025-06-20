package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;

@UnstableApi
public interface AudioSink {

    /* renamed from: a  reason: collision with root package name */
    public static final int f10779a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final int f10780b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f10781c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final long f10782d = Long.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public static final int f10783e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f10784f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f10785g = 2;

    public static final class AudioTrackConfig {

        /* renamed from: a  reason: collision with root package name */
        public final int f10786a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10787b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10788c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f10789d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f10790e;

        /* renamed from: f  reason: collision with root package name */
        public final int f10791f;

        public AudioTrackConfig(int i2, int i3, int i4, boolean z, boolean z2, int i5) {
            this.f10786a = i2;
            this.f10787b = i3;
            this.f10788c = i4;
            this.f10789d = z;
            this.f10790e = z2;
            this.f10791f = i5;
        }
    }

    public static final class ConfigurationException extends Exception {
        public final Format s;

        public ConfigurationException(String str, Format format) {
            super(str);
            this.s = format;
        }

        public ConfigurationException(Throwable th, Format format) {
            super(th);
            this.s = format;
        }
    }

    public static final class InitializationException extends Exception {
        public final boolean X;
        public final Format Y;
        public final int s;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InitializationException(int r4, int r5, int r6, int r7, androidx.media3.common.Format r8, boolean r9, @androidx.annotation.Nullable java.lang.Exception r10) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "AudioTrack init failed "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = " "
                r0.append(r1)
                java.lang.String r2 = "Config("
                r0.append(r2)
                r0.append(r5)
                java.lang.String r5 = ", "
                r0.append(r5)
                r0.append(r6)
                r0.append(r5)
                r0.append(r7)
                java.lang.String r5 = ")"
                r0.append(r5)
                r0.append(r1)
                r0.append(r8)
                if (r9 == 0) goto L_0x0038
                java.lang.String r5 = " (recoverable)"
                goto L_0x003a
            L_0x0038:
                java.lang.String r5 = ""
            L_0x003a:
                r0.append(r5)
                java.lang.String r5 = r0.toString()
                r3.<init>(r5, r10)
                r3.s = r4
                r3.X = r9
                r3.Y = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.AudioSink.InitializationException.<init>(int, int, int, int, androidx.media3.common.Format, boolean, java.lang.Exception):void");
        }
    }

    public interface Listener {
        void a(long j2);

        void b(AudioTrackConfig audioTrackConfig);

        void c();

        void d(AudioTrackConfig audioTrackConfig);

        void e(boolean z);

        void f(Exception exc);

        void g();

        void h(int i2, long j2, long j3);

        void i();

        void j();

        void k();
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffloadMode {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SinkFormatSupport {
    }

    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long X;
        public final long s;

        public UnexpectedDiscontinuityException(long j2, long j3) {
            super("Unexpected audio track timestamp discontinuity: expected " + j3 + ", got " + j2);
            this.s = j2;
            this.X = j3;
        }
    }

    public static final class WriteException extends Exception {
        public final boolean X;
        public final Format Y;
        public final int s;

        public WriteException(int i2, Format format, boolean z) {
            super("AudioTrack write failed: " + i2);
            this.X = z;
            this.s = i2;
            this.Y = format;
        }
    }

    void A(long j2);

    void B();

    void C();

    int D(Format format);

    boolean E(ByteBuffer byteBuffer, long j2, int i2) throws InitializationException, WriteException;

    void a();

    boolean b(Format format);

    boolean c();

    @Nullable
    AudioAttributes d();

    void e(int i2);

    void f(PlaybackParameters playbackParameters);

    void flush();

    void g(float f2);

    void h();

    void i(Clock clock);

    void j(Format format, int i2, @Nullable int[] iArr) throws ConfigurationException;

    void k(AudioAttributes audioAttributes);

    AudioOffloadSupport l(Format format);

    @RequiresApi(23)
    void m(@Nullable AudioDeviceInfo audioDeviceInfo);

    boolean n();

    void o();

    void p() throws WriteException;

    boolean q();

    PlaybackParameters r();

    void reset();

    void s(boolean z);

    void t(AuxEffectInfo auxEffectInfo);

    @RequiresApi(29)
    void u(int i2, int i3);

    void v(Listener listener);

    @RequiresApi(29)
    void w(int i2);

    long x(boolean z);

    void y();

    void z(@Nullable PlayerId playerId);
}
