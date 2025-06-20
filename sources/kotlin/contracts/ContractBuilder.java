package kotlin.contracts;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.ContractsDsl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalContracts
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/contracts/ContractBuilder;", "", "Lkotlin/contracts/Returns;", "a", "()Lkotlin/contracts/Returns;", "value", "b", "(Ljava/lang/Object;)Lkotlin/contracts/Returns;", "Lkotlin/contracts/ReturnsNotNull;", "c", "()Lkotlin/contracts/ReturnsNotNull;", "R", "Lkotlin/Function;", "lambda", "Lkotlin/contracts/InvocationKind;", "kind", "Lkotlin/contracts/CallsInPlace;", "d", "(Lkotlin/Function;Lkotlin/contracts/InvocationKind;)Lkotlin/contracts/CallsInPlace;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@ContractsDsl
public interface ContractBuilder {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ CallsInPlace a(ContractBuilder contractBuilder, Function function, InvocationKind invocationKind, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    invocationKind = InvocationKind.UNKNOWN;
                }
                return contractBuilder.d(function, invocationKind);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
        }
    }

    @NotNull
    @ContractsDsl
    Returns a();

    @NotNull
    @ContractsDsl
    Returns b(@Nullable Object obj);

    @NotNull
    @ContractsDsl
    ReturnsNotNull c();

    @NotNull
    @ContractsDsl
    <R> CallsInPlace d(@NotNull Function<? extends R> function, @NotNull InvocationKind invocationKind);
}
