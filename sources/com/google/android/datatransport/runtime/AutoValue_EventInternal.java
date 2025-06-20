package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Arrays;
import java.util.Map;

final class AutoValue_EventInternal extends EventInternal {

    /* renamed from: a  reason: collision with root package name */
    private final String f19397a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f19398b;

    /* renamed from: c  reason: collision with root package name */
    private final EncodedPayload f19399c;

    /* renamed from: d  reason: collision with root package name */
    private final long f19400d;

    /* renamed from: e  reason: collision with root package name */
    private final long f19401e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f19402f;

    /* renamed from: g  reason: collision with root package name */
    private final Integer f19403g;

    /* renamed from: h  reason: collision with root package name */
    private final String f19404h;

    /* renamed from: i  reason: collision with root package name */
    private final byte[] f19405i;

    /* renamed from: j  reason: collision with root package name */
    private final byte[] f19406j;

    static final class Builder extends EventInternal.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f19407a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f19408b;

        /* renamed from: c  reason: collision with root package name */
        private EncodedPayload f19409c;

        /* renamed from: d  reason: collision with root package name */
        private Long f19410d;

        /* renamed from: e  reason: collision with root package name */
        private Long f19411e;

        /* renamed from: f  reason: collision with root package name */
        private Map<String, String> f19412f;

        /* renamed from: g  reason: collision with root package name */
        private Integer f19413g;

        /* renamed from: h  reason: collision with root package name */
        private String f19414h;

        /* renamed from: i  reason: collision with root package name */
        private byte[] f19415i;

        /* renamed from: j  reason: collision with root package name */
        private byte[] f19416j;

        Builder() {
        }

        public EventInternal d() {
            String str = "";
            if (this.f19407a == null) {
                str = str + " transportName";
            }
            if (this.f19409c == null) {
                str = str + " encodedPayload";
            }
            if (this.f19410d == null) {
                str = str + " eventMillis";
            }
            if (this.f19411e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f19412f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new AutoValue_EventInternal(this.f19407a, this.f19408b, this.f19409c, this.f19410d.longValue(), this.f19411e.longValue(), this.f19412f, this.f19413g, this.f19414h, this.f19415i, this.f19416j);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: protected */
        public Map<String, String> e() {
            Map<String, String> map = this.f19412f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* access modifiers changed from: protected */
        public EventInternal.Builder f(Map<String, String> map) {
            if (map != null) {
                this.f19412f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        public EventInternal.Builder g(Integer num) {
            this.f19408b = num;
            return this;
        }

        public EventInternal.Builder h(EncodedPayload encodedPayload) {
            if (encodedPayload != null) {
                this.f19409c = encodedPayload;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        public EventInternal.Builder i(long j2) {
            this.f19410d = Long.valueOf(j2);
            return this;
        }

        public EventInternal.Builder j(byte[] bArr) {
            this.f19415i = bArr;
            return this;
        }

        public EventInternal.Builder k(byte[] bArr) {
            this.f19416j = bArr;
            return this;
        }

        public EventInternal.Builder l(Integer num) {
            this.f19413g = num;
            return this;
        }

        public EventInternal.Builder m(String str) {
            this.f19414h = str;
            return this;
        }

        public EventInternal.Builder n(String str) {
            if (str != null) {
                this.f19407a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        public EventInternal.Builder o(long j2) {
            this.f19411e = Long.valueOf(j2);
            return this;
        }
    }

    private AutoValue_EventInternal(String str, @Nullable Integer num, EncodedPayload encodedPayload, long j2, long j3, Map<String, String> map, @Nullable Integer num2, @Nullable String str2, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
        this.f19397a = str;
        this.f19398b = num;
        this.f19399c = encodedPayload;
        this.f19400d = j2;
        this.f19401e = j3;
        this.f19402f = map;
        this.f19403g = num2;
        this.f19404h = str2;
        this.f19405i = bArr;
        this.f19406j = bArr2;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> c() {
        return this.f19402f;
    }

    @Nullable
    public Integer d() {
        return this.f19398b;
    }

    public EncodedPayload e() {
        return this.f19399c;
    }

    public boolean equals(Object obj) {
        Integer num;
        Integer num2;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        if (this.f19397a.equals(eventInternal.p()) && ((num = this.f19398b) != null ? num.equals(eventInternal.d()) : eventInternal.d() == null) && this.f19399c.equals(eventInternal.e()) && this.f19400d == eventInternal.f() && this.f19401e == eventInternal.q() && this.f19402f.equals(eventInternal.c()) && ((num2 = this.f19403g) != null ? num2.equals(eventInternal.n()) : eventInternal.n() == null) && ((str = this.f19404h) != null ? str.equals(eventInternal.o()) : eventInternal.o() == null)) {
            boolean z = eventInternal instanceof AutoValue_EventInternal;
            if (Arrays.equals(this.f19405i, z ? ((AutoValue_EventInternal) eventInternal).f19405i : eventInternal.g())) {
                if (Arrays.equals(this.f19406j, z ? ((AutoValue_EventInternal) eventInternal).f19406j : eventInternal.h())) {
                    return true;
                }
            }
        }
        return false;
    }

    public long f() {
        return this.f19400d;
    }

    @Nullable
    public byte[] g() {
        return this.f19405i;
    }

    @Nullable
    public byte[] h() {
        return this.f19406j;
    }

    public int hashCode() {
        int hashCode = (this.f19397a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f19398b;
        int i2 = 0;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j2 = this.f19400d;
        long j3 = this.f19401e;
        int hashCode3 = (((((((((hashCode ^ hashCode2) * 1000003) ^ this.f19399c.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f19402f.hashCode()) * 1000003;
        Integer num2 = this.f19403g;
        int hashCode4 = (hashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.f19404h;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((((hashCode4 ^ i2) * 1000003) ^ Arrays.hashCode(this.f19405i)) * 1000003) ^ Arrays.hashCode(this.f19406j);
    }

    @Nullable
    public Integer n() {
        return this.f19403g;
    }

    @Nullable
    public String o() {
        return this.f19404h;
    }

    public String p() {
        return this.f19397a;
    }

    public long q() {
        return this.f19401e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f19397a + ", code=" + this.f19398b + ", encodedPayload=" + this.f19399c + ", eventMillis=" + this.f19400d + ", uptimeMillis=" + this.f19401e + ", autoMetadata=" + this.f19402f + ", productId=" + this.f19403g + ", pseudonymousId=" + this.f19404h + ", experimentIdsClear=" + Arrays.toString(this.f19405i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f19406j) + "}";
    }
}
