package androidx.media3.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.concurrent.Executor;

@UnstableApi
public interface VideoFrameProcessor {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9361a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9362b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9363c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static final long f9364d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static final long f9365e = -2;

    public interface Factory {
        VideoFrameProcessor a(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo, boolean z, Executor executor, Listener listener) throws VideoFrameProcessingException;
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputType {
    }

    public interface Listener {
        void d(int i2, int i3);

        void e(VideoFrameProcessingException videoFrameProcessingException);

        void f(long j2);

        void g();

        void h(int i2, List<Effect> list, FrameInfo frameInfo);
    }

    void a();

    Surface b();

    void c(@Nullable SurfaceInfo surfaceInfo);

    void d(long j2);

    void e();

    void f(int i2, List<Effect> list, FrameInfo frameInfo);

    void flush();

    boolean g(int i2, long j2);

    boolean h();

    void i(OnInputFrameProcessedListener onInputFrameProcessedListener);

    int j();

    boolean k(Bitmap bitmap, TimestampIterator timestampIterator);
}
