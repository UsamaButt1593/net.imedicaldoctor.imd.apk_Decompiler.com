package okhttp3.internal.http;

import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {
    @Nullable
    private final String X;
    private final long Y;
    private final BufferedSource Z;

    public RealResponseBody(@Nullable String str, long j2, BufferedSource bufferedSource) {
        this.X = str;
        this.Y = j2;
        this.Z = bufferedSource;
    }

    public long f() {
        return this.Y;
    }

    public MediaType h() {
        String str = this.X;
        if (str != null) {
            return MediaType.d(str);
        }
        return null;
    }

    public BufferedSource q() {
        return this.Z;
    }
}
