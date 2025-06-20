package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;

final class AutoValue_AndroidClientInfo extends AndroidClientInfo {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f19295a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19296b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19297c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19298d;

    /* renamed from: e  reason: collision with root package name */
    private final String f19299e;

    /* renamed from: f  reason: collision with root package name */
    private final String f19300f;

    /* renamed from: g  reason: collision with root package name */
    private final String f19301g;

    /* renamed from: h  reason: collision with root package name */
    private final String f19302h;

    /* renamed from: i  reason: collision with root package name */
    private final String f19303i;

    /* renamed from: j  reason: collision with root package name */
    private final String f19304j;

    /* renamed from: k  reason: collision with root package name */
    private final String f19305k;

    /* renamed from: l  reason: collision with root package name */
    private final String f19306l;

    static final class Builder extends AndroidClientInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f19307a;

        /* renamed from: b  reason: collision with root package name */
        private String f19308b;

        /* renamed from: c  reason: collision with root package name */
        private String f19309c;

        /* renamed from: d  reason: collision with root package name */
        private String f19310d;

        /* renamed from: e  reason: collision with root package name */
        private String f19311e;

        /* renamed from: f  reason: collision with root package name */
        private String f19312f;

        /* renamed from: g  reason: collision with root package name */
        private String f19313g;

        /* renamed from: h  reason: collision with root package name */
        private String f19314h;

        /* renamed from: i  reason: collision with root package name */
        private String f19315i;

        /* renamed from: j  reason: collision with root package name */
        private String f19316j;

        /* renamed from: k  reason: collision with root package name */
        private String f19317k;

        /* renamed from: l  reason: collision with root package name */
        private String f19318l;

        Builder() {
        }

        public AndroidClientInfo a() {
            return new AutoValue_AndroidClientInfo(this.f19307a, this.f19308b, this.f19309c, this.f19310d, this.f19311e, this.f19312f, this.f19313g, this.f19314h, this.f19315i, this.f19316j, this.f19317k, this.f19318l);
        }

        public AndroidClientInfo.Builder b(@Nullable String str) {
            this.f19318l = str;
            return this;
        }

        public AndroidClientInfo.Builder c(@Nullable String str) {
            this.f19316j = str;
            return this;
        }

        public AndroidClientInfo.Builder d(@Nullable String str) {
            this.f19310d = str;
            return this;
        }

        public AndroidClientInfo.Builder e(@Nullable String str) {
            this.f19314h = str;
            return this;
        }

        public AndroidClientInfo.Builder f(@Nullable String str) {
            this.f19309c = str;
            return this;
        }

        public AndroidClientInfo.Builder g(@Nullable String str) {
            this.f19315i = str;
            return this;
        }

        public AndroidClientInfo.Builder h(@Nullable String str) {
            this.f19313g = str;
            return this;
        }

        public AndroidClientInfo.Builder i(@Nullable String str) {
            this.f19317k = str;
            return this;
        }

        public AndroidClientInfo.Builder j(@Nullable String str) {
            this.f19308b = str;
            return this;
        }

        public AndroidClientInfo.Builder k(@Nullable String str) {
            this.f19312f = str;
            return this;
        }

        public AndroidClientInfo.Builder l(@Nullable String str) {
            this.f19311e = str;
            return this;
        }

        public AndroidClientInfo.Builder m(@Nullable Integer num) {
            this.f19307a = num;
            return this;
        }
    }

    private AutoValue_AndroidClientInfo(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
        this.f19295a = num;
        this.f19296b = str;
        this.f19297c = str2;
        this.f19298d = str3;
        this.f19299e = str4;
        this.f19300f = str5;
        this.f19301g = str6;
        this.f19302h = str7;
        this.f19303i = str8;
        this.f19304j = str9;
        this.f19305k = str10;
        this.f19306l = str11;
    }

    @Nullable
    public String b() {
        return this.f19306l;
    }

    @Nullable
    public String c() {
        return this.f19304j;
    }

    @Nullable
    public String d() {
        return this.f19298d;
    }

    @Nullable
    public String e() {
        return this.f19302h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidClientInfo)) {
            return false;
        }
        AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
        Integer num = this.f19295a;
        if (num != null ? num.equals(androidClientInfo.m()) : androidClientInfo.m() == null) {
            String str = this.f19296b;
            if (str != null ? str.equals(androidClientInfo.j()) : androidClientInfo.j() == null) {
                String str2 = this.f19297c;
                if (str2 != null ? str2.equals(androidClientInfo.f()) : androidClientInfo.f() == null) {
                    String str3 = this.f19298d;
                    if (str3 != null ? str3.equals(androidClientInfo.d()) : androidClientInfo.d() == null) {
                        String str4 = this.f19299e;
                        if (str4 != null ? str4.equals(androidClientInfo.l()) : androidClientInfo.l() == null) {
                            String str5 = this.f19300f;
                            if (str5 != null ? str5.equals(androidClientInfo.k()) : androidClientInfo.k() == null) {
                                String str6 = this.f19301g;
                                if (str6 != null ? str6.equals(androidClientInfo.h()) : androidClientInfo.h() == null) {
                                    String str7 = this.f19302h;
                                    if (str7 != null ? str7.equals(androidClientInfo.e()) : androidClientInfo.e() == null) {
                                        String str8 = this.f19303i;
                                        if (str8 != null ? str8.equals(androidClientInfo.g()) : androidClientInfo.g() == null) {
                                            String str9 = this.f19304j;
                                            if (str9 != null ? str9.equals(androidClientInfo.c()) : androidClientInfo.c() == null) {
                                                String str10 = this.f19305k;
                                                if (str10 != null ? str10.equals(androidClientInfo.i()) : androidClientInfo.i() == null) {
                                                    String str11 = this.f19306l;
                                                    String b2 = androidClientInfo.b();
                                                    if (str11 == null) {
                                                        if (b2 == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(b2)) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Nullable
    public String f() {
        return this.f19297c;
    }

    @Nullable
    public String g() {
        return this.f19303i;
    }

    @Nullable
    public String h() {
        return this.f19301g;
    }

    public int hashCode() {
        Integer num = this.f19295a;
        int i2 = 0;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f19296b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f19297c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f19298d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f19299e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f19300f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f19301g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f19302h;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f19303i;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f19304j;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f19305k;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f19306l;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        return hashCode11 ^ i2;
    }

    @Nullable
    public String i() {
        return this.f19305k;
    }

    @Nullable
    public String j() {
        return this.f19296b;
    }

    @Nullable
    public String k() {
        return this.f19300f;
    }

    @Nullable
    public String l() {
        return this.f19299e;
    }

    @Nullable
    public Integer m() {
        return this.f19295a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f19295a + ", model=" + this.f19296b + ", hardware=" + this.f19297c + ", device=" + this.f19298d + ", product=" + this.f19299e + ", osBuild=" + this.f19300f + ", manufacturer=" + this.f19301g + ", fingerprint=" + this.f19302h + ", locale=" + this.f19303i + ", country=" + this.f19304j + ", mccMnc=" + this.f19305k + ", applicationBuild=" + this.f19306l + "}";
    }
}
