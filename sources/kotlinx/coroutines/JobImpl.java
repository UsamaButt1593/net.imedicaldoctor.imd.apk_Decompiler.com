package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\n\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u00078\u0010X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0014\u0010\u0014\u001a\u00020\u00078PX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "F1", "()Z", "c", "", "exception", "k", "(Ljava/lang/Throwable;)Z", "X", "Z", "P0", "handlesException", "Q0", "onCancelComplete", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public class JobImpl extends JobSupport implements CompletableJob {
    private final boolean X = F1();

    public JobImpl(@Nullable Job job) {
        super(true);
        W0(job);
    }

    private final boolean F1() {
        JobSupport Y0;
        ChildHandle S0 = S0();
        ChildHandleNode childHandleNode = S0 instanceof ChildHandleNode ? (ChildHandleNode) S0 : null;
        if (!(childHandleNode == null || (Y0 = childHandleNode.Y0()) == null)) {
            while (!Y0.P0()) {
                ChildHandle S02 = Y0.S0();
                ChildHandleNode childHandleNode2 = S02 instanceof ChildHandleNode ? (ChildHandleNode) S02 : null;
                if (childHandleNode2 != null) {
                    Y0 = childHandleNode2.Y0();
                    if (Y0 == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean P0() {
        return this.X;
    }

    public boolean Q0() {
        return true;
    }

    public boolean c() {
        return e1(Unit.f28779a);
    }

    public boolean k(@NotNull Throwable th) {
        return e1(new CompletedExceptionally(th, false, 2, (DefaultConstructorMarker) null));
    }
}
