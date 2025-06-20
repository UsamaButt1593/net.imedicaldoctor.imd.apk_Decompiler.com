package com.google.android.datatransport.cct;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedDestination;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class CCTDestination implements EncodedDestination {

    /* renamed from: c  reason: collision with root package name */
    static final String f19212c = "cct";

    /* renamed from: d  reason: collision with root package name */
    static final String f19213d;

    /* renamed from: e  reason: collision with root package name */
    static final String f19214e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f19215f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f19216g = "1$";

    /* renamed from: h  reason: collision with root package name */
    private static final String f19217h = "\\";

    /* renamed from: i  reason: collision with root package name */
    private static final Set<Encoding> f19218i = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Encoding[]{Encoding.b("proto"), Encoding.b("json")})));

    /* renamed from: j  reason: collision with root package name */
    public static final CCTDestination f19219j;

    /* renamed from: k  reason: collision with root package name */
    public static final CCTDestination f19220k;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f19221a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f19222b;

    static {
        String a2 = StringMerger.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f19213d = a2;
        String a3 = StringMerger.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f19214e = a3;
        String a4 = StringMerger.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f19215f = a4;
        f19219j = new CCTDestination(a2, (String) null);
        f19220k = new CCTDestination(a3, a4);
    }

    public CCTDestination(@NonNull String str, @Nullable String str2) {
        this.f19221a = str;
        this.f19222b = str2;
    }

    @NonNull
    static String c(@NonNull byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }

    @NonNull
    static byte[] d(@NonNull String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    @NonNull
    public static CCTDestination e(@NonNull byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith(f19216g)) {
            String[] split = str.substring(2).split(Pattern.quote(f19217h), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new CCTDestination(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    public Set<Encoding> a() {
        return f19218i;
    }

    @Nullable
    public byte[] b() {
        String str = this.f19222b;
        if (str == null && this.f19221a == null) {
            return null;
        }
        String str2 = this.f19221a;
        if (str == null) {
            str = "";
        }
        return String.format("%s%s%s%s", new Object[]{f19216g, str2, f19217h, str}).getBytes(Charset.forName("UTF-8"));
    }

    @Nullable
    public String f() {
        return this.f19222b;
    }

    @NonNull
    public String g() {
        return this.f19221a;
    }

    @Nullable
    public byte[] getExtras() {
        return b();
    }

    @NonNull
    public String getName() {
        return f19212c;
    }
}
