package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "acc", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "b", "(Ljava/lang/String;Lkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/String;"}, k = 3, mv = {1, 9, 0})
final class CombinedContext$toString$1 extends Lambda implements Function2<String, CoroutineContext.Element, String> {
    public static final CombinedContext$toString$1 X = new CombinedContext$toString$1();

    CombinedContext$toString$1() {
        super(2);
    }

    @NotNull
    /* renamed from: b */
    public final String d0(@NotNull String str, @NotNull CoroutineContext.Element element) {
        Intrinsics.p(str, "acc");
        Intrinsics.p(element, "element");
        if (str.length() == 0) {
            return element.toString();
        }
        return str + ", " + element;
    }
}
