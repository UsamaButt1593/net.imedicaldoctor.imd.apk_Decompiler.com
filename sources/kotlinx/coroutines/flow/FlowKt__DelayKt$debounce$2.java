package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "it", "", "b", "(Ljava/lang/Object;)Ljava/lang/Long;"}, k = 3, mv = {1, 6, 0})
final class FlowKt__DelayKt$debounce$2 extends Lambda implements Function1<T, Long> {
    final /* synthetic */ long X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounce$2(long j2) {
        super(1);
        this.X = j2;
    }

    @NotNull
    /* renamed from: b */
    public final Long f(T t) {
        return Long.valueOf(this.X);
    }
}
