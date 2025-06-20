package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/text/MatchResult;", "b", "()Lkotlin/text/MatchResult;"}, k = 3, mv = {1, 9, 0})
final class Regex$findAll$1 extends Lambda implements Function0<MatchResult> {
    final /* synthetic */ Regex X;
    final /* synthetic */ CharSequence Y;
    final /* synthetic */ int Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Regex$findAll$1(Regex regex, CharSequence charSequence, int i2) {
        super(0);
        this.X = regex;
        this.Y = charSequence;
        this.Z = i2;
    }

    @Nullable
    /* renamed from: b */
    public final MatchResult o() {
        return this.X.c(this.Y, this.Z);
    }
}
