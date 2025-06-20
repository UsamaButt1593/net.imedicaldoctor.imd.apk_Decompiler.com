package kotlin.text;

import java.util.Set;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\n\u001a\u00020\u0001*\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "Lkotlin/text/Regex;", "t", "(Ljava/lang/String;)Lkotlin/text/Regex;", "Lkotlin/text/RegexOption;", "option", "v", "(Ljava/lang/String;Lkotlin/text/RegexOption;)Lkotlin/text/Regex;", "", "options", "u", "(Ljava/lang/String;Ljava/util/Set;)Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/text/StringsKt")
class StringsKt__RegexExtensionsKt extends StringsKt__RegexExtensionsJVMKt {
    @InlineOnly
    private static final Regex t(String str) {
        Intrinsics.p(str, "<this>");
        return new Regex(str);
    }

    @InlineOnly
    private static final Regex u(String str, Set<? extends RegexOption> set) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(set, "options");
        return new Regex(str, set);
    }

    @InlineOnly
    private static final Regex v(String str, RegexOption regexOption) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(regexOption, "option");
        return new Regex(str, regexOption);
    }
}
