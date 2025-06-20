package androidx.media3.exoplayer.video;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.annotation.FloatRange;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.Executor;

@UnstableApi
public interface VideoSink {

    /* renamed from: a  reason: collision with root package name */
    public static final int f12816a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f12817b = 2;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputType {
    }

    public interface Listener {

        /* renamed from: a  reason: collision with root package name */
        public static final Listener f12818a = new Listener() {
            public void a(VideoSink videoSink) {
            }

            public void b(VideoSink videoSink, VideoSize videoSize) {
            }

            public void c(VideoSink videoSink, VideoSinkException videoSinkException) {
            }

            public void d(VideoSink videoSink) {
            }
        };

        void a(VideoSink videoSink);

        void b(VideoSink videoSink, VideoSize videoSize);

        void c(VideoSink videoSink, VideoSinkException videoSinkException);

        void d(VideoSink videoSink);
    }

    public static final class VideoSinkException extends Exception {
        public final Format s;

        public VideoSinkException(Throwable th, Format format) {
            super(th);
            this.s = format;
        }
    }

    boolean a(Bitmap bitmap, TimestampIterator timestampIterator);

    Surface b();

    boolean c();

    boolean d();

    long e(long j2, boolean z);

    void f(int i2, Format format);

    void flush();

    void g(long j2, long j3) throws VideoSinkException;

    boolean h();

    void i(Listener listener, Executor executor);

    void m(@FloatRange(from = 0.0d, fromInclusive = false) float f2);
}
