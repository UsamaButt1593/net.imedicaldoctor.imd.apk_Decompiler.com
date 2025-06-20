package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\f\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "", "a", "(C)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class _OneToManyTitlecaseMappingsKt {
    @NotNull
    public static final String a(char c2) {
        String valueOf = String.valueOf(c2);
        Intrinsics.n(valueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = valueOf.toUpperCase(locale);
        Intrinsics.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c2));
        }
        if (c2 == 329) {
            return upperCase;
        }
        char charAt = upperCase.charAt(0);
        Intrinsics.n(upperCase, "null cannot be cast to non-null type java.lang.String");
        String substring = upperCase.substring(1);
        Intrinsics.o(substring, "this as java.lang.String).substring(startIndex)");
        Intrinsics.n(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase(locale);
        Intrinsics.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return charAt + lowerCase;
    }
}
