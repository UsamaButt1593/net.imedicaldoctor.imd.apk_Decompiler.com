package kotlin.contracts;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.ContractsDsl;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0005\u001a\u00020\u00022\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "Lkotlin/contracts/ContractBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builder", "a", "(Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class ContractBuilderKt {
    @ExperimentalContracts
    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ContractsDsl
    private static final void a(Function1<? super ContractBuilder, Unit> function1) {
        Intrinsics.p(function1, "builder");
    }
}
