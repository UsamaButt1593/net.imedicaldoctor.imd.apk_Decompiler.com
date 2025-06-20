package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
public final class LoadingInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f10228a;

    /* renamed from: b  reason: collision with root package name */
    public final float f10229b;

    /* renamed from: c  reason: collision with root package name */
    public final long f10230c;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public long f10231a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public float f10232b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f10233c;

        public Builder() {
            this.f10231a = C.f9084b;
            this.f10232b = -3.4028235E38f;
            this.f10233c = C.f9084b;
        }

        public LoadingInfo d() {
            return new LoadingInfo(this);
        }

        @CanIgnoreReturnValue
        public Builder e(long j2) {
            Assertions.a(j2 >= 0 || j2 == C.f9084b);
            this.f10233c = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder f(long j2) {
            this.f10231a = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder g(float f2) {
            Assertions.a(f2 > 0.0f || f2 == -3.4028235E38f);
            this.f10232b = f2;
            return this;
        }

        private Builder(LoadingInfo loadingInfo) {
            this.f10231a = loadingInfo.f10228a;
            this.f10232b = loadingInfo.f10229b;
            this.f10233c = loadingInfo.f10230c;
        }
    }

    private LoadingInfo(Builder builder) {
        this.f10228a = builder.f10231a;
        this.f10229b = builder.f10232b;
        this.f10230c = builder.f10233c;
    }

    public Builder a() {
        return new Builder();
    }

    public boolean b(long j2) {
        long j3 = this.f10230c;
        return (j3 == C.f9084b || j2 == C.f9084b || j3 < j2) ? false : true;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadingInfo)) {
            return false;
        }
        LoadingInfo loadingInfo = (LoadingInfo) obj;
        return this.f10228a == loadingInfo.f10228a && this.f10229b == loadingInfo.f10229b && this.f10230c == loadingInfo.f10230c;
    }

    public int hashCode() {
        return Objects.b(Long.valueOf(this.f10228a), Float.valueOf(this.f10229b), Long.valueOf(this.f10230c));
    }
}
