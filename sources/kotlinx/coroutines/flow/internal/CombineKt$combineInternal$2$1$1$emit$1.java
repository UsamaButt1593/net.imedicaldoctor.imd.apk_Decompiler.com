package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1", f = "Combine.kt", i = {}, l = {35, 36}, m = "emit", n = {}, s = {})
final class CombineKt$combineInternal$2$1$1$emit$1 extends ContinuationImpl {
    final /* synthetic */ CombineKt$combineInternal$2.AnonymousClass1.AnonymousClass1<T> X2;
    int Y2;
    /* synthetic */ Object Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineInternal$2$1$1$emit$1(CombineKt$combineInternal$2.AnonymousClass1.AnonymousClass1<? super T> r1, Continuation<? super CombineKt$combineInternal$2$1$1$emit$1> continuation) {
        super(continuation);
        this.X2 = r1;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Z = obj;
        this.Y2 |= Integer.MIN_VALUE;
        return this.X2.h(null, this);
    }
}
