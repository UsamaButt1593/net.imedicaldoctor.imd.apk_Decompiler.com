package androidx.media3.exoplayer.dash.manifest;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import com.google.common.base.Objects;

@UnstableApi
public final class BaseUrl {

    /* renamed from: e  reason: collision with root package name */
    public static final int f11124e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static final int f11125f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f11126g = Integer.MIN_VALUE;

    /* renamed from: a  reason: collision with root package name */
    public final String f11127a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11128b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11129c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11130d;

    public BaseUrl(String str) {
        this(str, str, Integer.MIN_VALUE, 1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseUrl)) {
            return false;
        }
        BaseUrl baseUrl = (BaseUrl) obj;
        return this.f11129c == baseUrl.f11129c && this.f11130d == baseUrl.f11130d && Objects.a(this.f11127a, baseUrl.f11127a) && Objects.a(this.f11128b, baseUrl.f11128b);
    }

    public int hashCode() {
        return Objects.b(this.f11127a, this.f11128b, Integer.valueOf(this.f11129c), Integer.valueOf(this.f11130d));
    }

    public BaseUrl(String str, String str2, int i2, int i3) {
        this.f11127a = str;
        this.f11128b = str2;
        this.f11129c = i2;
        this.f11130d = i3;
    }
}
