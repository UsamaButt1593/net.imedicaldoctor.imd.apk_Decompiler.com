package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/sync/Empty;", "", "locked", "<init>", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class Empty {
    @NotNull
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public final Object f29443a;

    public Empty(@NotNull Object obj) {
        this.f29443a = obj;
    }

    @NotNull
    public String toString() {
        return "Empty[" + this.f29443a + ']';
    }
}
