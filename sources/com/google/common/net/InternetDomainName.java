package com.google.common.net;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.List;
import javax.annotation.CheckForNull;
import org.apache.commons.lang3.ClassUtils;

@GwtCompatible(emulated = true)
@Immutable
@ElementTypesAreNonnullByDefault
public final class InternetDomainName {

    /* renamed from: e  reason: collision with root package name */
    private static final CharMatcher f22907e = CharMatcher.d(".。．｡");

    /* renamed from: f  reason: collision with root package name */
    private static final Splitter f22908f = Splitter.h(ClassUtils.PACKAGE_SEPARATOR_CHAR);

    /* renamed from: g  reason: collision with root package name */
    private static final Joiner f22909g = Joiner.o(ClassUtils.PACKAGE_SEPARATOR_CHAR);

    /* renamed from: h  reason: collision with root package name */
    private static final int f22910h = -1;

    /* renamed from: i  reason: collision with root package name */
    private static final int f22911i = -2;

    /* renamed from: j  reason: collision with root package name */
    private static final int f22912j = 127;

    /* renamed from: k  reason: collision with root package name */
    private static final int f22913k = 253;

    /* renamed from: l  reason: collision with root package name */
    private static final int f22914l = 63;

    /* renamed from: m  reason: collision with root package name */
    private static final CharMatcher f22915m;

    /* renamed from: n  reason: collision with root package name */
    private static final CharMatcher f22916n;
    private static final CharMatcher o;
    private static final CharMatcher p;

    /* renamed from: a  reason: collision with root package name */
    private final String f22917a;

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableList<String> f22918b;
    @LazyInit

    /* renamed from: c  reason: collision with root package name */
    private int f22919c = -2;
    @LazyInit

    /* renamed from: d  reason: collision with root package name */
    private int f22920d = -2;

    static {
        CharMatcher d2 = CharMatcher.d("-_");
        f22915m = d2;
        CharMatcher m2 = CharMatcher.m('0', '9');
        f22916n = m2;
        CharMatcher I = CharMatcher.m('a', 'z').I(CharMatcher.m('A', ASCIIPropertyListParser.D));
        o = I;
        p = m2.I(I).I(d2);
    }

    InternetDomainName(String str) {
        String g2 = Ascii.g(f22907e.N(str, ClassUtils.PACKAGE_SEPARATOR_CHAR));
        boolean z = true;
        g2 = g2.endsWith(".") ? g2.substring(0, g2.length() - 1) : g2;
        Preconditions.u(g2.length() <= f22913k, "Domain name too long: '%s':", g2);
        this.f22917a = g2;
        ImmutableList<String> z2 = ImmutableList.z(f22908f.n(g2));
        this.f22918b = z2;
        Preconditions.u(z2.size() > 127 ? false : z, "Domain has too many parts: '%s'", g2);
        Preconditions.u(y(z2), "Not a valid domain name: '%s'", g2);
    }

    private InternetDomainName a(int i2) {
        Joiner joiner = f22909g;
        ImmutableList<String> immutableList = this.f22918b;
        return d(joiner.k(immutableList.subList(i2, immutableList.size())));
    }

    private int c(Optional<PublicSuffixType> optional) {
        int size = this.f22918b.size();
        for (int i2 = 0; i2 < size; i2++) {
            String k2 = f22909g.k(this.f22918b.subList(i2, size));
            if (i2 > 0 && o(optional, Optional.c(PublicSuffixPatterns.f25189b.get(k2)))) {
                return i2 - 1;
            }
            if (o(optional, Optional.c(PublicSuffixPatterns.f25188a.get(k2)))) {
                return i2;
            }
            if (PublicSuffixPatterns.f25190c.containsKey(k2)) {
                return i2 + 1;
            }
        }
        return -1;
    }

    @CanIgnoreReturnValue
    public static InternetDomainName d(String str) {
        return new InternetDomainName((String) Preconditions.E(str));
    }

    public static boolean n(String str) {
        try {
            d(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    private static boolean o(Optional<PublicSuffixType> optional, Optional<PublicSuffixType> optional2) {
        return optional.e() ? optional.equals(optional2) : optional2.e();
    }

    private int s() {
        int i2 = this.f22919c;
        if (i2 != -2) {
            return i2;
        }
        int c2 = c(Optional.a());
        this.f22919c = c2;
        return c2;
    }

    private int u() {
        int i2 = this.f22920d;
        if (i2 != -2) {
            return i2;
        }
        int c2 = c(Optional.f(PublicSuffixType.REGISTRY));
        this.f22920d = c2;
        return c2;
    }

    private static boolean x(String str, boolean z) {
        if (str.length() >= 1 && str.length() <= 63) {
            if (!p.C(CharMatcher.f().P(str))) {
                return false;
            }
            CharMatcher charMatcher = f22915m;
            if (!charMatcher.B(str.charAt(0)) && !charMatcher.B(str.charAt(str.length() - 1))) {
                return !z || !f22916n.B(str.charAt(0));
            }
        }
        return false;
    }

    private static boolean y(List<String> list) {
        int size = list.size() - 1;
        if (!x(list.get(size), true)) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!x(list.get(i2), false)) {
                return false;
            }
        }
        return true;
    }

    public InternetDomainName b(String str) {
        return d(((String) Preconditions.E(str)) + "." + this.f22917a);
    }

    public boolean e() {
        return this.f22918b.size() > 1;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternetDomainName) {
            return this.f22917a.equals(((InternetDomainName) obj).f22917a);
        }
        return false;
    }

    public boolean f() {
        return s() != -1;
    }

    public boolean g() {
        return u() != -1;
    }

    public boolean h() {
        return s() == 0;
    }

    public int hashCode() {
        return this.f22917a.hashCode();
    }

    public boolean i() {
        return u() == 0;
    }

    public boolean j() {
        return u() == 1;
    }

    public boolean k() {
        return s() == 1;
    }

    public boolean l() {
        return s() > 0;
    }

    public boolean m() {
        return u() > 0;
    }

    public InternetDomainName p() {
        Preconditions.x0(e(), "Domain '%s' has no parent", this.f22917a);
        return a(1);
    }

    public ImmutableList<String> q() {
        return this.f22918b;
    }

    @CheckForNull
    public InternetDomainName r() {
        if (f()) {
            return a(s());
        }
        return null;
    }

    @CheckForNull
    public InternetDomainName t() {
        if (g()) {
            return a(u());
        }
        return null;
    }

    public String toString() {
        return this.f22917a;
    }

    public InternetDomainName v() {
        if (j()) {
            return this;
        }
        Preconditions.x0(m(), "Not under a registry suffix: %s", this.f22917a);
        return a(u() - 1);
    }

    public InternetDomainName w() {
        if (k()) {
            return this;
        }
        Preconditions.x0(l(), "Not under a public suffix: %s", this.f22917a);
        return a(s() - 1);
    }
}
