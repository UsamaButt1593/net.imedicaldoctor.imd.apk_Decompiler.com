package androidx.media3.exoplayer.dash.manifest;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class Descriptor {

    /* renamed from: a  reason: collision with root package name */
    public final String f11159a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final String f11160b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final String f11161c;

    public Descriptor(String str, @Nullable String str2, @Nullable String str3) {
        this.f11159a = str;
        this.f11160b = str2;
        this.f11161c = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Descriptor.class != obj.getClass()) {
            return false;
        }
        Descriptor descriptor = (Descriptor) obj;
        return Util.g(this.f11159a, descriptor.f11159a) && Util.g(this.f11160b, descriptor.f11160b) && Util.g(this.f11161c, descriptor.f11161c);
    }

    public int hashCode() {
        int hashCode = this.f11159a.hashCode() * 31;
        String str = this.f11160b;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f11161c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }
}
