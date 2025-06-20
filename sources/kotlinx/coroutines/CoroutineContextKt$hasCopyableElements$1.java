package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "result", "Lkotlin/coroutines/CoroutineContext$Element;", "it", "b", "(ZLkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0})
final class CoroutineContextKt$hasCopyableElements$1 extends Lambda implements Function2<Boolean, CoroutineContext.Element, Boolean> {
    public static final CoroutineContextKt$hasCopyableElements$1 X = new CoroutineContextKt$hasCopyableElements$1();

    CoroutineContextKt$hasCopyableElements$1() {
        super(2);
    }

    @NotNull
    public final Boolean b(boolean z, @NotNull CoroutineContext.Element element) {
        return Boolean.valueOf(z || (element instanceof CopyableThreadContextElement));
    }

    public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
        return b(((Boolean) obj).booleanValue(), (CoroutineContext.Element) obj2);
    }
}
