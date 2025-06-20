package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class DecoderReuseEvaluation {

    /* renamed from: f  reason: collision with root package name */
    public static final int f10110f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final int f10111g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f10112h = 2;

    /* renamed from: i  reason: collision with root package name */
    public static final int f10113i = 3;

    /* renamed from: j  reason: collision with root package name */
    public static final int f10114j = 1;

    /* renamed from: k  reason: collision with root package name */
    public static final int f10115k = 2;

    /* renamed from: l  reason: collision with root package name */
    public static final int f10116l = 4;

    /* renamed from: m  reason: collision with root package name */
    public static final int f10117m = 8;

    /* renamed from: n  reason: collision with root package name */
    public static final int f10118n = 16;
    public static final int o = 32;
    public static final int p = 64;
    public static final int q = 128;
    public static final int r = 256;
    public static final int s = 512;
    public static final int t = 1024;
    public static final int u = 2048;
    public static final int v = 4096;
    public static final int w = 8192;
    public static final int x = 16384;
    public static final int y = 32768;

    /* renamed from: a  reason: collision with root package name */
    public final String f10119a;

    /* renamed from: b  reason: collision with root package name */
    public final Format f10120b;

    /* renamed from: c  reason: collision with root package name */
    public final Format f10121c;

    /* renamed from: d  reason: collision with root package name */
    public final int f10122d;

    /* renamed from: e  reason: collision with root package name */
    public final int f10123e;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DecoderDiscardReasons {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DecoderReuseResult {
    }

    public DecoderReuseEvaluation(String str, Format format, Format format2, int i2, int i3) {
        Assertions.a(i2 == 0 || i3 == 0);
        this.f10119a = Assertions.e(str);
        this.f10120b = (Format) Assertions.g(format);
        this.f10121c = (Format) Assertions.g(format2);
        this.f10122d = i2;
        this.f10123e = i3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DecoderReuseEvaluation.class != obj.getClass()) {
            return false;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = (DecoderReuseEvaluation) obj;
        return this.f10122d == decoderReuseEvaluation.f10122d && this.f10123e == decoderReuseEvaluation.f10123e && this.f10119a.equals(decoderReuseEvaluation.f10119a) && this.f10120b.equals(decoderReuseEvaluation.f10120b) && this.f10121c.equals(decoderReuseEvaluation.f10121c);
    }

    public int hashCode() {
        return ((((((((MetaDo.w + this.f10122d) * 31) + this.f10123e) * 31) + this.f10119a.hashCode()) * 31) + this.f10120b.hashCode()) * 31) + this.f10121c.hashCode();
    }
}
