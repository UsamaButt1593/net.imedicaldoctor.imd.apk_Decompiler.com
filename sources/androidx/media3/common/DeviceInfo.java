package androidx.media3.common;

import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class DeviceInfo implements Bundleable {
    public static final int X2 = 0;
    public static final int Y2 = 1;
    public static final DeviceInfo Z2 = new Builder(0).e();
    private static final String a3 = Util.d1(0);
    private static final String b3 = Util.d1(1);
    private static final String c3 = Util.d1(2);
    private static final String d3 = Util.d1(3);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<DeviceInfo> e3 = new C0155k();
    @IntRange(from = 0)
    public final int X;
    @IntRange(from = 0)
    public final int Y;
    @Nullable
    public final String Z;
    public final int s;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f9104a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f9105b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f9106c;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public String f9107d;

        public Builder(int i2) {
            this.f9104a = i2;
        }

        public DeviceInfo e() {
            Assertions.a(this.f9105b <= this.f9106c);
            return new DeviceInfo(this);
        }

        @CanIgnoreReturnValue
        public Builder f(@IntRange(from = 0) int i2) {
            this.f9106c = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder g(@IntRange(from = 0) int i2) {
            this.f9105b = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder h(@Nullable String str) {
            Assertions.a(this.f9104a != 0 || str == null);
            this.f9107d = str;
            return this;
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackType {
    }

    @UnstableApi
    @Deprecated
    public DeviceInfo(int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4) {
        this(new Builder(i2).g(i3).f(i4));
    }

    @UnstableApi
    public static DeviceInfo b(Bundle bundle) {
        int i2 = bundle.getInt(a3, 0);
        int i3 = bundle.getInt(b3, 0);
        int i4 = bundle.getInt(c3, 0);
        return new Builder(i2).g(i3).f(i4).h(bundle.getString(d3)).e();
    }

    @UnstableApi
    public Bundle a() {
        Bundle bundle = new Bundle();
        int i2 = this.s;
        if (i2 != 0) {
            bundle.putInt(a3, i2);
        }
        int i3 = this.X;
        if (i3 != 0) {
            bundle.putInt(b3, i3);
        }
        int i4 = this.Y;
        if (i4 != 0) {
            bundle.putInt(c3, i4);
        }
        String str = this.Z;
        if (str != null) {
            bundle.putString(d3, str);
        }
        return bundle;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return this.s == deviceInfo.s && this.X == deviceInfo.X && this.Y == deviceInfo.Y && Util.g(this.Z, deviceInfo.Z);
    }

    public int hashCode() {
        int i2 = (((((MetaDo.w + this.s) * 31) + this.X) * 31) + this.Y) * 31;
        String str = this.Z;
        return i2 + (str == null ? 0 : str.hashCode());
    }

    private DeviceInfo(Builder builder) {
        this.s = builder.f9104a;
        this.X = builder.f9105b;
        this.Y = builder.f9106c;
        this.Z = builder.f9107d;
    }
}
