package androidx.media3.exoplayer.dash.manifest;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

@UnstableApi
public final class ProgramInformation {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final String f11172a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final String f11173b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final String f11174c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f11175d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final String f11176e;

    public ProgramInformation(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.f11172a = str;
        this.f11173b = str2;
        this.f11174c = str3;
        this.f11175d = str4;
        this.f11176e = str5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgramInformation)) {
            return false;
        }
        ProgramInformation programInformation = (ProgramInformation) obj;
        return Util.g(this.f11172a, programInformation.f11172a) && Util.g(this.f11173b, programInformation.f11173b) && Util.g(this.f11174c, programInformation.f11174c) && Util.g(this.f11175d, programInformation.f11175d) && Util.g(this.f11176e, programInformation.f11176e);
    }

    public int hashCode() {
        String str = this.f11172a;
        int i2 = 0;
        int hashCode = (MetaDo.w + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f11173b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f11174c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f11175d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f11176e;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }
}
