package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "b", "()Ljava/lang/Long;"}, k = 3, mv = {1, 9, 0})
final class AbstractLongTimeSource$zero$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ AbstractLongTimeSource X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractLongTimeSource$zero$2(AbstractLongTimeSource abstractLongTimeSource) {
        super(0);
        this.X = abstractLongTimeSource;
    }

    @NotNull
    /* renamed from: b */
    public final Long o() {
        return Long.valueOf(this.X.f());
    }
}
