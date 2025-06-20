package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class Platform {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f22279a = Logger.getLogger(Platform.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final PatternCompiler f22280b = e();

    private static final class JdkPatternCompiler implements PatternCompiler {
        private JdkPatternCompiler() {
        }

        public CommonPattern a(String str) {
            return new JdkPattern(Pattern.compile(str));
        }

        public boolean b() {
            return true;
        }
    }

    private Platform() {
    }

    static CommonPattern a(String str) {
        Preconditions.E(str);
        return f22280b.a(str);
    }

    @CheckForNull
    static String b(@CheckForNull String str) {
        if (j(str)) {
            return null;
        }
        return str;
    }

    static String c(double d2) {
        return String.format(Locale.ROOT, "%.4g", new Object[]{Double.valueOf(d2)});
    }

    static <T extends Enum<T>> Optional<T> d(Class<T> cls, String str) {
        WeakReference weakReference = Enums.a(cls).get(str);
        return weakReference == null ? Optional.a() : Optional.f((Enum) cls.cast(weakReference.get()));
    }

    private static PatternCompiler e() {
        return new JdkPatternCompiler();
    }

    private static void f(ServiceConfigurationError serviceConfigurationError) {
        f22279a.log(Level.WARNING, "Error loading regex compiler, falling back to next option", serviceConfigurationError);
    }

    static String g(@CheckForNull String str) {
        return str == null ? "" : str;
    }

    static boolean h() {
        return f22280b.b();
    }

    static CharMatcher i(CharMatcher charMatcher) {
        return charMatcher.K();
    }

    static boolean j(@CheckForNull String str) {
        return str == null || str.isEmpty();
    }
}
