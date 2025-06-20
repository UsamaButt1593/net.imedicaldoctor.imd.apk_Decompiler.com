package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@AutoValue
public abstract class EventInternal {

    @AutoValue.Builder
    public static abstract class Builder {
        public final Builder a(String str, int i2) {
            e().put(str, String.valueOf(i2));
            return this;
        }

        public final Builder b(String str, long j2) {
            e().put(str, String.valueOf(j2));
            return this;
        }

        public final Builder c(String str, String str2) {
            e().put(str, str2);
            return this;
        }

        public abstract EventInternal d();

        /* access modifiers changed from: protected */
        public abstract Map<String, String> e();

        /* access modifiers changed from: protected */
        public abstract Builder f(Map<String, String> map);

        public abstract Builder g(Integer num);

        public abstract Builder h(EncodedPayload encodedPayload);

        public abstract Builder i(long j2);

        public abstract Builder j(byte[] bArr);

        public abstract Builder k(byte[] bArr);

        public abstract Builder l(Integer num);

        public abstract Builder m(String str);

        public abstract Builder n(String str);

        public abstract Builder o(long j2);
    }

    public static Builder a() {
        return new AutoValue_EventInternal.Builder().f(new HashMap());
    }

    public final String b(String str) {
        String str2 = c().get(str);
        return str2 == null ? "" : str2;
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, String> c();

    @Nullable
    public abstract Integer d();

    public abstract EncodedPayload e();

    public abstract long f();

    @Nullable
    public abstract byte[] g();

    @Nullable
    public abstract byte[] h();

    public final int i(String str) {
        String str2 = c().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final long j(String str) {
        String str2 = c().get(str);
        if (str2 == null) {
            return 0;
        }
        return Long.valueOf(str2).longValue();
    }

    public final Map<String, String> k() {
        return Collections.unmodifiableMap(c());
    }

    public final String l(String str, String str2) {
        String str3 = c().get(str);
        return str3 == null ? str2 : str3;
    }

    @Deprecated
    public byte[] m() {
        return e().a();
    }

    @Nullable
    public abstract Integer n();

    @Nullable
    public abstract String o();

    public abstract String p();

    public abstract long q();

    public Builder r() {
        return new AutoValue_EventInternal.Builder().n(p()).g(d()).l(n()).m(o()).j(g()).k(h()).h(e()).i(f()).o(q()).f(new HashMap(c()));
    }
}
