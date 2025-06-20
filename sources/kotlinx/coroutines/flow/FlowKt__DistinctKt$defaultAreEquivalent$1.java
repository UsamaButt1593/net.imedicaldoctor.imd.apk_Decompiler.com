package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "old", "new", "", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0})
final class FlowKt__DistinctKt$defaultAreEquivalent$1 extends Lambda implements Function2<Object, Object, Boolean> {
    public static final FlowKt__DistinctKt$defaultAreEquivalent$1 X = new FlowKt__DistinctKt$defaultAreEquivalent$1();

    FlowKt__DistinctKt$defaultAreEquivalent$1() {
        super(2);
    }

    @NotNull
    /* renamed from: b */
    public final Boolean d0(@Nullable Object obj, @Nullable Object obj2) {
        return Boolean.valueOf(Intrinsics.g(obj, obj2));
    }
}
