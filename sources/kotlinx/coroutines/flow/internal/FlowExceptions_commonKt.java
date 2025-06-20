package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbortFlowException;", "Lkotlinx/coroutines/flow/FlowCollector;", "owner", "", "b", "(Lkotlinx/coroutines/flow/internal/AbortFlowException;Lkotlinx/coroutines/flow/FlowCollector;)V", "", "index", "a", "(I)I", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class FlowExceptions_commonKt {
    @PublishedApi
    public static final int a(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    public static final void b(@NotNull AbortFlowException abortFlowException, @NotNull FlowCollector<?> flowCollector) {
        if (abortFlowException.s != flowCollector) {
            throw abortFlowException;
        }
    }
}
