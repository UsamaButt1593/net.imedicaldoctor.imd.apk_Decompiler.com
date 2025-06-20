package androidx.media3.common;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

@UnstableApi
public final class AuxEffectInfo {

    /* renamed from: c  reason: collision with root package name */
    public static final int f9073c = 0;

    /* renamed from: a  reason: collision with root package name */
    public final int f9074a;

    /* renamed from: b  reason: collision with root package name */
    public final float f9075b;

    public AuxEffectInfo(int i2, float f2) {
        this.f9074a = i2;
        this.f9075b = f2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuxEffectInfo.class != obj.getClass()) {
            return false;
        }
        AuxEffectInfo auxEffectInfo = (AuxEffectInfo) obj;
        return this.f9074a == auxEffectInfo.f9074a && Float.compare(auxEffectInfo.f9075b, this.f9075b) == 0;
    }

    public int hashCode() {
        return ((MetaDo.w + this.f9074a) * 31) + Float.floatToIntBits(this.f9075b);
    }
}
