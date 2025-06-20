package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class VideoFrameProcessingException extends Exception {
    public final long s;

    public VideoFrameProcessingException(String str) {
        this(str, (long) C.f9084b);
    }

    public static VideoFrameProcessingException a(Exception exc) {
        return b(exc, C.f9084b);
    }

    public static VideoFrameProcessingException b(Exception exc, long j2) {
        return exc instanceof VideoFrameProcessingException ? (VideoFrameProcessingException) exc : new VideoFrameProcessingException((Throwable) exc, j2);
    }

    public VideoFrameProcessingException(String str, long j2) {
        super(str);
        this.s = j2;
    }

    public VideoFrameProcessingException(String str, Throwable th) {
        this(str, th, C.f9084b);
    }

    public VideoFrameProcessingException(String str, Throwable th, long j2) {
        super(str, th);
        this.s = j2;
    }

    public VideoFrameProcessingException(Throwable th) {
        this(th, (long) C.f9084b);
    }

    public VideoFrameProcessingException(Throwable th, long j2) {
        super(th);
        this.s = j2;
    }
}
