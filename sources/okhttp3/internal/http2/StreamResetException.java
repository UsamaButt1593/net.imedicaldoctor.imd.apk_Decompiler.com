package okhttp3.internal.http2;

import java.io.IOException;

public final class StreamResetException extends IOException {
    public final ErrorCode s;

    public StreamResetException(ErrorCode errorCode) {
        super("stream was reset: " + errorCode);
        this.s = errorCode;
    }
}
