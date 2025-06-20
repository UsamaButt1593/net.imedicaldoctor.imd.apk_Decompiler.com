package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "result", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "b", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext;"}, k = 3, mv = {1, 6, 0})
final class CoroutineContextKt$foldCopies$folded$1 extends Lambda implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {
    final /* synthetic */ Ref.ObjectRef<CoroutineContext> X;
    final /* synthetic */ boolean Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineContextKt$foldCopies$folded$1(Ref.ObjectRef<CoroutineContext> objectRef, boolean z) {
        super(2);
        this.X = objectRef;
        this.Y = z;
    }

    @NotNull
    /* renamed from: b */
    public final CoroutineContext d0(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext.Element element) {
        if (!(element instanceof CopyableThreadContextElement)) {
            return coroutineContext.v(element);
        }
        CoroutineContext.Element e2 = ((CoroutineContext) this.X.s).e(element.getKey());
        if (e2 == null) {
            CopyableThreadContextElement copyableThreadContextElement = (CopyableThreadContextElement) element;
            if (this.Y) {
                copyableThreadContextElement = copyableThreadContextElement.a0();
            }
            return coroutineContext.v(copyableThreadContextElement);
        }
        Ref.ObjectRef<CoroutineContext> objectRef = this.X;
        objectRef.s = ((CoroutineContext) objectRef.s).f(element.getKey());
        return coroutineContext.v(((CopyableThreadContextElement) element).u(e2));
    }
}
