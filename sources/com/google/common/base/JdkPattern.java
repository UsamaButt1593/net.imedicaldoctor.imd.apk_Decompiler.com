package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
final class JdkPattern extends CommonPattern implements Serializable {
    private static final long X = 0;
    private final Pattern s;

    private static final class JdkMatcher extends CommonMatcher {

        /* renamed from: a  reason: collision with root package name */
        final Matcher f22264a;

        JdkMatcher(Matcher matcher) {
            this.f22264a = (Matcher) Preconditions.E(matcher);
        }

        public int a() {
            return this.f22264a.end();
        }

        public boolean b() {
            return this.f22264a.find();
        }

        public boolean c(int i2) {
            return this.f22264a.find(i2);
        }

        public boolean d() {
            return this.f22264a.matches();
        }

        public String e(String str) {
            return this.f22264a.replaceAll(str);
        }

        public int f() {
            return this.f22264a.start();
        }
    }

    JdkPattern(Pattern pattern) {
        this.s = (Pattern) Preconditions.E(pattern);
    }

    public int b() {
        return this.s.flags();
    }

    public CommonMatcher d(CharSequence charSequence) {
        return new JdkMatcher(this.s.matcher(charSequence));
    }

    public String e() {
        return this.s.pattern();
    }

    public String toString() {
        return this.s.toString();
    }
}
