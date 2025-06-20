package androidx.core.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Lkotlin/coroutines/Continuation;", "Landroidx/core/util/Consumer;", "a", "(Lkotlin/coroutines/Continuation;)Landroidx/core/util/Consumer;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class AndroidXConsumerKt {
    @NotNull
    public static final <T> Consumer<T> a(@NotNull Continuation<? super T> continuation) {
        return new AndroidXContinuationConsumer(continuation);
    }
}
