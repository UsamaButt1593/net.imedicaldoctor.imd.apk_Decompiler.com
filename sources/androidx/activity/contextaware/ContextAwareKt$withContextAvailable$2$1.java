package androidx.activity.contextaware;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nContextAware.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$1\n*L\n1#1,94:1\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "", "it", "", "b", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 8, 0})
final class ContextAwareKt$withContextAvailable$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ ContextAware X;
    final /* synthetic */ ContextAwareKt$withContextAvailable$2$listener$1 Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextAwareKt$withContextAvailable$2$1(ContextAware contextAware, ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1) {
        super(1);
        this.X = contextAware;
        this.Y = contextAwareKt$withContextAvailable$2$listener$1;
    }

    public final void b(@Nullable Throwable th) {
        this.X.m(this.Y);
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        b((Throwable) obj);
        return Unit.f28779a;
    }
}
