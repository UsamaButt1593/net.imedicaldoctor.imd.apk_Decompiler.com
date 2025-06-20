package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/text/MatchGroup;", "b", "(I)Lkotlin/text/MatchGroup;"}, k = 3, mv = {1, 9, 0})
final class MatcherMatchResult$groups$1$iterator$1 extends Lambda implements Function1<Integer, MatchGroup> {
    final /* synthetic */ MatcherMatchResult$groups$1 X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatcherMatchResult$groups$1$iterator$1(MatcherMatchResult$groups$1 matcherMatchResult$groups$1) {
        super(1);
        this.X = matcherMatchResult$groups$1;
    }

    @Nullable
    public final MatchGroup b(int i2) {
        return this.X.get(i2);
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        return b(((Number) obj).intValue());
    }
}
