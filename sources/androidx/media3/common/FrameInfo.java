package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
public class FrameInfo {

    /* renamed from: a  reason: collision with root package name */
    public final ColorInfo f9139a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9140b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9141c;

    /* renamed from: d  reason: collision with root package name */
    public final float f9142d;

    /* renamed from: e  reason: collision with root package name */
    public final long f9143e;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private ColorInfo f9144a;

        /* renamed from: b  reason: collision with root package name */
        private int f9145b;

        /* renamed from: c  reason: collision with root package name */
        private int f9146c;

        /* renamed from: d  reason: collision with root package name */
        private float f9147d;

        /* renamed from: e  reason: collision with root package name */
        private long f9148e;

        public Builder(ColorInfo colorInfo, int i2, int i3) {
            this.f9144a = colorInfo;
            this.f9145b = i2;
            this.f9146c = i3;
            this.f9147d = 1.0f;
        }

        public FrameInfo a() {
            return new FrameInfo(this.f9144a, this.f9145b, this.f9146c, this.f9147d, this.f9148e);
        }

        @CanIgnoreReturnValue
        public Builder b(ColorInfo colorInfo) {
            this.f9144a = colorInfo;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c(int i2) {
            this.f9146c = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d(long j2) {
            this.f9148e = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e(float f2) {
            this.f9147d = f2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder f(int i2) {
            this.f9145b = i2;
            return this;
        }

        public Builder(FrameInfo frameInfo) {
            this.f9144a = frameInfo.f9139a;
            this.f9145b = frameInfo.f9140b;
            this.f9146c = frameInfo.f9141c;
            this.f9147d = frameInfo.f9142d;
            this.f9148e = frameInfo.f9143e;
        }
    }

    private FrameInfo(ColorInfo colorInfo, int i2, int i3, float f2, long j2) {
        boolean z = false;
        boolean z2 = i2 > 0;
        Assertions.b(z2, "width must be positive, but is: " + i2);
        z = i3 > 0 ? true : z;
        Assertions.b(z, "height must be positive, but is: " + i3);
        this.f9139a = colorInfo;
        this.f9140b = i2;
        this.f9141c = i3;
        this.f9142d = f2;
        this.f9143e = j2;
    }
}
