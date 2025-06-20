package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "count", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "b", "(ILkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0})
final class SafeCollector_commonKt$checkContext$result$1 extends Lambda implements Function2<Integer, CoroutineContext.Element, Integer> {
    final /* synthetic */ SafeCollector<?> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SafeCollector_commonKt$checkContext$result$1(SafeCollector<?> safeCollector) {
        super(2);
        this.X = safeCollector;
    }

    @NotNull
    public final Integer b(int i2, @NotNull CoroutineContext.Element element) {
        CoroutineContext.Key key = element.getKey();
        CoroutineContext.Element e2 = this.X.X2.e(key);
        if (key != Job.P2) {
            return Integer.valueOf(element != e2 ? Integer.MIN_VALUE : i2 + 1);
        }
        Job job = (Job) e2;
        Job b2 = SafeCollector_commonKt.b((Job) element, job);
        if (b2 == job) {
            if (job != null) {
                i2++;
            }
            return Integer.valueOf(i2);
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b2 + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }

    public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
        return b(((Number) obj).intValue(), (CoroutineContext.Element) obj2);
    }
}
