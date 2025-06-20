package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* synthetic */ class Regex$findAll$2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
    public static final Regex$findAll$2 c3 = new Regex$findAll$2();

    Regex$findAll$2() {
        super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
    }

    @Nullable
    /* renamed from: D0 */
    public final MatchResult f(@NotNull MatchResult matchResult) {
        Intrinsics.p(matchResult, "p0");
        return matchResult.next();
    }
}
