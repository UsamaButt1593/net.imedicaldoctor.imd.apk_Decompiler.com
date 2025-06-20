package androidx.media3.exoplayer.audio;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
public final class AudioOffloadSupport {

    /* renamed from: d  reason: collision with root package name */
    public static final AudioOffloadSupport f10770d = new Builder().d();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f10771a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f10772b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f10773c;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f10774a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f10775b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f10776c;

        public Builder() {
        }

        public AudioOffloadSupport d() {
            if (this.f10774a || (!this.f10775b && !this.f10776c)) {
                return new AudioOffloadSupport(this);
            }
            throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
        }

        @CanIgnoreReturnValue
        public Builder e(boolean z) {
            this.f10774a = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder f(boolean z) {
            this.f10775b = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder g(boolean z) {
            this.f10776c = z;
            return this;
        }

        public Builder(AudioOffloadSupport audioOffloadSupport) {
            this.f10774a = audioOffloadSupport.f10771a;
            this.f10775b = audioOffloadSupport.f10772b;
            this.f10776c = audioOffloadSupport.f10773c;
        }
    }

    private AudioOffloadSupport(Builder builder) {
        this.f10771a = builder.f10774a;
        this.f10772b = builder.f10775b;
        this.f10773c = builder.f10776c;
    }

    public Builder a() {
        return new Builder(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioOffloadSupport.class != obj.getClass()) {
            return false;
        }
        AudioOffloadSupport audioOffloadSupport = (AudioOffloadSupport) obj;
        return this.f10771a == audioOffloadSupport.f10771a && this.f10772b == audioOffloadSupport.f10772b && this.f10773c == audioOffloadSupport.f10773c;
    }

    public int hashCode() {
        return ((this.f10771a ? 1 : 0) << true) + ((this.f10772b ? 1 : 0) << true) + (this.f10773c ? 1 : 0);
    }
}
