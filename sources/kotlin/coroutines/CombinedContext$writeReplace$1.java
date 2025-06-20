package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "<anonymous parameter 0>", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "b", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"}, k = 3, mv = {1, 9, 0})
final class CombinedContext$writeReplace$1 extends Lambda implements Function2<Unit, CoroutineContext.Element, Unit> {
    final /* synthetic */ CoroutineContext[] X;
    final /* synthetic */ Ref.IntRef Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombinedContext$writeReplace$1(CoroutineContext[] coroutineContextArr, Ref.IntRef intRef) {
        super(2);
        this.X = coroutineContextArr;
        this.Y = intRef;
    }

    public final void b(@NotNull Unit unit, @NotNull CoroutineContext.Element element) {
        Intrinsics.p(unit, "<anonymous parameter 0>");
        Intrinsics.p(element, "element");
        CoroutineContext[] coroutineContextArr = this.X;
        Ref.IntRef intRef = this.Y;
        int i2 = intRef.s;
        intRef.s = i2 + 1;
        coroutineContextArr[i2] = element;
    }

    public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
        b((Unit) obj, (CoroutineContext.Element) obj2);
        return Unit.f28779a;
    }
}
