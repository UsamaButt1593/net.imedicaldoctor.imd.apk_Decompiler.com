package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "acc", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "b", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext;"}, k = 3, mv = {1, 9, 0})
final class CoroutineContext$plus$1 extends Lambda implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {
    public static final CoroutineContext$plus$1 X = new CoroutineContext$plus$1();

    CoroutineContext$plus$1() {
        super(2);
    }

    @NotNull
    /* renamed from: b */
    public final CoroutineContext d0(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext.Element element) {
        CombinedContext combinedContext;
        Intrinsics.p(coroutineContext, "acc");
        Intrinsics.p(element, "element");
        CoroutineContext f2 = coroutineContext.f(element.getKey());
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.s;
        if (f2 == emptyCoroutineContext) {
            return element;
        }
        ContinuationInterceptor.Key key = ContinuationInterceptor.N2;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) f2.e(key);
        if (continuationInterceptor == null) {
            combinedContext = new CombinedContext(f2, element);
        } else {
            CoroutineContext f3 = f2.f(key);
            if (f3 == emptyCoroutineContext) {
                return new CombinedContext(element, continuationInterceptor);
            }
            combinedContext = new CombinedContext(new CombinedContext(f3, element), continuationInterceptor);
        }
        return combinedContext;
    }
}
