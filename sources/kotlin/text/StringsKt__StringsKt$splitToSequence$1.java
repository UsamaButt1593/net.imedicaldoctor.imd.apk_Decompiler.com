package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/ranges/IntRange;", "it", "", "b", "(Lkotlin/ranges/IntRange;)Ljava/lang/String;"}, k = 3, mv = {1, 9, 0})
final class StringsKt__StringsKt$splitToSequence$1 extends Lambda implements Function1<IntRange, String> {
    final /* synthetic */ CharSequence X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$splitToSequence$1(CharSequence charSequence) {
        super(1);
        this.X = charSequence;
    }

    @NotNull
    /* renamed from: b */
    public final String f(@NotNull IntRange intRange) {
        Intrinsics.p(intRange, "it");
        return StringsKt__StringsKt.h5(this.X, intRange);
    }
}
