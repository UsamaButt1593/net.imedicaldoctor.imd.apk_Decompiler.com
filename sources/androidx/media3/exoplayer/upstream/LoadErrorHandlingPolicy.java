package androidx.media3.exoplayer.upstream;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public interface LoadErrorHandlingPolicy {

    /* renamed from: a  reason: collision with root package name */
    public static final int f12557a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f12558b = 2;

    public static final class FallbackOptions {

        /* renamed from: a  reason: collision with root package name */
        public final int f12559a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12560b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12561c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12562d;

        public FallbackOptions(int i2, int i3, int i4, int i5) {
            this.f12559a = i2;
            this.f12560b = i3;
            this.f12561c = i4;
            this.f12562d = i5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:4:0x000b A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(int r4) {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                if (r4 != r1) goto L_0x000d
                int r4 = r3.f12559a
                int r2 = r3.f12560b
                int r4 = r4 - r2
                if (r4 <= r1) goto L_0x0015
            L_0x000b:
                r0 = 1
                goto L_0x0015
            L_0x000d:
                int r4 = r3.f12561c
                int r2 = r3.f12562d
                int r4 = r4 - r2
                if (r4 <= r1) goto L_0x0015
                goto L_0x000b
            L_0x0015:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy.FallbackOptions.a(int):boolean");
        }
    }

    public static final class FallbackSelection {

        /* renamed from: a  reason: collision with root package name */
        public final int f12563a;

        /* renamed from: b  reason: collision with root package name */
        public final long f12564b;

        public FallbackSelection(int i2, long j2) {
            Assertions.a(j2 >= 0);
            this.f12563a = i2;
            this.f12564b = j2;
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FallbackType {
    }

    public static final class LoadErrorInfo {

        /* renamed from: a  reason: collision with root package name */
        public final LoadEventInfo f12565a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaLoadData f12566b;

        /* renamed from: c  reason: collision with root package name */
        public final IOException f12567c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12568d;

        public LoadErrorInfo(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, int i2) {
            this.f12565a = loadEventInfo;
            this.f12566b = mediaLoadData;
            this.f12567c = iOException;
            this.f12568d = i2;
        }
    }

    long a(LoadErrorInfo loadErrorInfo);

    void b(long j2);

    int c(int i2);

    @Nullable
    FallbackSelection d(FallbackOptions fallbackOptions, LoadErrorInfo loadErrorInfo);
}
