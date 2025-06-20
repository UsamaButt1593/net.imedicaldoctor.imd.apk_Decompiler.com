package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
public final class DataSpec {

    /* renamed from: l  reason: collision with root package name */
    public static final int f9776l = 1;

    /* renamed from: m  reason: collision with root package name */
    public static final int f9777m = 2;

    /* renamed from: n  reason: collision with root package name */
    public static final int f9778n = 4;
    public static final int o = 8;
    public static final int p = 1;
    public static final int q = 2;
    public static final int r = 3;

    /* renamed from: a  reason: collision with root package name */
    public final Uri f9779a;

    /* renamed from: b  reason: collision with root package name */
    public final long f9780b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9781c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f9782d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, String> f9783e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public final long f9784f;

    /* renamed from: g  reason: collision with root package name */
    public final long f9785g;

    /* renamed from: h  reason: collision with root package name */
    public final long f9786h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final String f9787i;

    /* renamed from: j  reason: collision with root package name */
    public final int f9788j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public final Object f9789k;

    public static final class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Uri f9790a;

        /* renamed from: b  reason: collision with root package name */
        private long f9791b;

        /* renamed from: c  reason: collision with root package name */
        private int f9792c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private byte[] f9793d;

        /* renamed from: e  reason: collision with root package name */
        private Map<String, String> f9794e;

        /* renamed from: f  reason: collision with root package name */
        private long f9795f;

        /* renamed from: g  reason: collision with root package name */
        private long f9796g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private String f9797h;

        /* renamed from: i  reason: collision with root package name */
        private int f9798i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private Object f9799j;

        public Builder() {
            this.f9792c = 1;
            this.f9794e = Collections.emptyMap();
            this.f9796g = -1;
        }

        public DataSpec a() {
            Assertions.l(this.f9790a, "The uri must be set.");
            return new DataSpec(this.f9790a, this.f9791b, this.f9792c, this.f9793d, this.f9794e, this.f9795f, this.f9796g, this.f9797h, this.f9798i, this.f9799j);
        }

        @CanIgnoreReturnValue
        public Builder b(@Nullable Object obj) {
            this.f9799j = obj;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c(int i2) {
            this.f9798i = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d(@Nullable byte[] bArr) {
            this.f9793d = bArr;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e(int i2) {
            this.f9792c = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder f(Map<String, String> map) {
            this.f9794e = map;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder g(@Nullable String str) {
            this.f9797h = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder h(long j2) {
            this.f9796g = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder i(long j2) {
            this.f9795f = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder j(Uri uri) {
            this.f9790a = uri;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder k(String str) {
            this.f9790a = Uri.parse(str);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder l(long j2) {
            this.f9791b = j2;
            return this;
        }

        private Builder(DataSpec dataSpec) {
            this.f9790a = dataSpec.f9779a;
            this.f9791b = dataSpec.f9780b;
            this.f9792c = dataSpec.f9781c;
            this.f9793d = dataSpec.f9782d;
            this.f9794e = dataSpec.f9783e;
            this.f9795f = dataSpec.f9785g;
            this.f9796g = dataSpec.f9786h;
            this.f9797h = dataSpec.f9787i;
            this.f9798i = dataSpec.f9788j;
            this.f9799j = dataSpec.f9789k;
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpMethod {
    }

    static {
        MediaLibraryInfo.a("media3.datasource");
    }

    public DataSpec(Uri uri) {
        this(uri, 0, -1);
    }

    public static String c(int i2) {
        if (i2 == 1) {
            return "GET";
        }
        if (i2 == 2) {
            return "POST";
        }
        if (i2 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public Builder a() {
        return new Builder();
    }

    public final String b() {
        return c(this.f9781c);
    }

    public boolean d(int i2) {
        return (this.f9788j & i2) == i2;
    }

    public DataSpec e(long j2) {
        long j3 = this.f9786h;
        long j4 = -1;
        if (j3 != -1) {
            j4 = j3 - j2;
        }
        return f(j2, j4);
    }

    public DataSpec f(long j2, long j3) {
        if (j2 == 0 && this.f9786h == j3) {
            return this;
        }
        return new DataSpec(this.f9779a, this.f9780b, this.f9781c, this.f9782d, this.f9783e, this.f9785g + j2, j3, this.f9787i, this.f9788j, this.f9789k);
    }

    public DataSpec g(Map<String, String> map) {
        HashMap hashMap = new HashMap(this.f9783e);
        hashMap.putAll(map);
        return new DataSpec(this.f9779a, this.f9780b, this.f9781c, this.f9782d, hashMap, this.f9785g, this.f9786h, this.f9787i, this.f9788j, this.f9789k);
    }

    public DataSpec h(Map<String, String> map) {
        return new DataSpec(this.f9779a, this.f9780b, this.f9781c, this.f9782d, map, this.f9785g, this.f9786h, this.f9787i, this.f9788j, this.f9789k);
    }

    public DataSpec i(Uri uri) {
        return new DataSpec(uri, this.f9780b, this.f9781c, this.f9782d, this.f9783e, this.f9785g, this.f9786h, this.f9787i, this.f9788j, this.f9789k);
    }

    public String toString() {
        return "DataSpec[" + b() + StringUtils.SPACE + this.f9779a + ", " + this.f9785g + ", " + this.f9786h + ", " + this.f9787i + ", " + this.f9788j + "]";
    }

    @Deprecated
    public DataSpec(Uri uri, int i2) {
        this(uri, 0, -1, (String) null, i2);
    }

    @Deprecated
    public DataSpec(Uri uri, int i2, @Nullable byte[] bArr, long j2, long j3, long j4, @Nullable String str, int i3) {
        this(uri, i2, bArr, j2, j3, j4, str, i3, Collections.emptyMap());
    }

    @Deprecated
    public DataSpec(Uri uri, int i2, @Nullable byte[] bArr, long j2, long j3, long j4, @Nullable String str, int i3, Map<String, String> map) {
        this(uri, j2 - j3, i2, bArr, map, j3, j4, str, i3, (Object) null);
    }

    private DataSpec(Uri uri, long j2, int i2, @Nullable byte[] bArr, Map<String, String> map, long j3, long j4, @Nullable String str, int i3, @Nullable Object obj) {
        long j5 = j2;
        byte[] bArr2 = bArr;
        long j6 = j3;
        long j7 = j4;
        long j8 = j5 + j6;
        boolean z = false;
        Assertions.a(j8 >= 0);
        Assertions.a(j6 >= 0);
        Assertions.a((j7 > 0 || j7 == -1) ? true : z);
        this.f9779a = uri;
        this.f9780b = j5;
        this.f9781c = i2;
        this.f9782d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f9783e = Collections.unmodifiableMap(new HashMap(map));
        this.f9785g = j6;
        this.f9784f = j8;
        this.f9786h = j7;
        this.f9787i = str;
        this.f9788j = i3;
        this.f9789k = obj;
    }

    public DataSpec(Uri uri, long j2, long j3) {
        this(uri, 0, 1, (byte[]) null, Collections.emptyMap(), j2, j3, (String) null, 0, (Object) null);
    }

    @Deprecated
    public DataSpec(Uri uri, long j2, long j3, long j4, @Nullable String str, int i2) {
        this(uri, (byte[]) null, j2, j3, j4, str, i2);
    }

    @Deprecated
    public DataSpec(Uri uri, long j2, long j3, @Nullable String str) {
        this(uri, j2, j2, j3, str, 0);
    }

    @Deprecated
    public DataSpec(Uri uri, long j2, long j3, @Nullable String str, int i2) {
        this(uri, j2, j2, j3, str, i2);
    }

    @Deprecated
    public DataSpec(Uri uri, long j2, long j3, @Nullable String str, int i2, Map<String, String> map) {
        this(uri, 1, (byte[]) null, j2, j2, j3, str, i2, map);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DataSpec(Uri uri, @Nullable byte[] bArr, long j2, long j3, long j4, @Nullable String str, int i2) {
        this(uri, bArr != null ? 2 : 1, bArr, j2, j3, j4, str, i2);
    }
}
