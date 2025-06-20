package androidx.media3.exoplayer.upstream;

import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableListMultimap;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class CmcdConfiguration {
    public static final String A = "nor";
    public static final String B = "nrr";
    public static final int C = 0;
    public static final int D = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f12445e = 64;

    /* renamed from: f  reason: collision with root package name */
    public static final String f12446f = "CMCD-Object";

    /* renamed from: g  reason: collision with root package name */
    public static final String f12447g = "CMCD-Request";

    /* renamed from: h  reason: collision with root package name */
    public static final String f12448h = "CMCD-Session";

    /* renamed from: i  reason: collision with root package name */
    public static final String f12449i = "CMCD-Status";

    /* renamed from: j  reason: collision with root package name */
    public static final String f12450j = "CMCD";

    /* renamed from: k  reason: collision with root package name */
    public static final String f12451k = "br";

    /* renamed from: l  reason: collision with root package name */
    public static final String f12452l = "bl";

    /* renamed from: m  reason: collision with root package name */
    public static final String f12453m = "cid";

    /* renamed from: n  reason: collision with root package name */
    public static final String f12454n = "sid";
    public static final String o = "rtp";
    public static final String p = "sf";
    public static final String q = "st";
    public static final String r = "v";
    public static final String s = "tb";
    public static final String t = "d";
    public static final String u = "mtp";
    public static final String v = "ot";
    public static final String w = "bs";
    public static final String x = "dl";
    public static final String y = "pr";
    public static final String z = "su";
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final String f12455a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final String f12456b;

    /* renamed from: c  reason: collision with root package name */
    public final RequestConfig f12457c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12458d;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CmcdKey {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DataTransmissionMode {
    }

    public interface Factory {

        /* renamed from: a  reason: collision with root package name */
        public static final Factory f12459a = new c();

        CmcdConfiguration a(MediaItem mediaItem);
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HeaderKey {
    }

    public interface RequestConfig {
        boolean a(String str);

        int b(int i2);

        ImmutableListMultimap<String, String> c();
    }

    public CmcdConfiguration(@Nullable String str, @Nullable String str2, RequestConfig requestConfig) {
        this(str, str2, requestConfig, 0);
    }

    public boolean a() {
        return this.f12457c.a("br");
    }

    public boolean b() {
        return this.f12457c.a(f12452l);
    }

    public boolean c() {
        return this.f12457c.a(w);
    }

    public boolean d() {
        return this.f12457c.a(f12453m);
    }

    public boolean e() {
        return this.f12457c.a("dl");
    }

    public boolean f() {
        return this.f12457c.a(o);
    }

    public boolean g() {
        return this.f12457c.a(u);
    }

    public boolean h() {
        return this.f12457c.a(A);
    }

    public boolean i() {
        return this.f12457c.a(B);
    }

    public boolean j() {
        return this.f12457c.a("d");
    }

    public boolean k() {
        return this.f12457c.a(v);
    }

    public boolean l() {
        return this.f12457c.a(y);
    }

    public boolean m() {
        return this.f12457c.a(f12454n);
    }

    public boolean n() {
        return this.f12457c.a(z);
    }

    public boolean o() {
        return this.f12457c.a(q);
    }

    public boolean p() {
        return this.f12457c.a(p);
    }

    public boolean q() {
        return this.f12457c.a("tb");
    }

    public CmcdConfiguration(@Nullable String str, @Nullable String str2, RequestConfig requestConfig, int i2) {
        boolean z2 = true;
        Assertions.a(str == null || str.length() <= 64);
        if (str2 != null && str2.length() > 64) {
            z2 = false;
        }
        Assertions.a(z2);
        Assertions.g(requestConfig);
        this.f12455a = str;
        this.f12456b = str2;
        this.f12457c = requestConfig;
        this.f12458d = i2;
    }
}
