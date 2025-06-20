package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "<init>", "()V", "", "m", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/JobSupport;", "Z", "Lkotlinx/coroutines/JobSupport;", "Y0", "()Lkotlinx/coroutines/JobSupport;", "Z0", "(Lkotlinx/coroutines/JobSupport;)V", "job", "", "b", "()Z", "isActive", "Lkotlinx/coroutines/NodeList;", "B", "()Lkotlinx/coroutines/NodeList;", "list", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class JobNode extends CompletionHandlerBase implements DisposableHandle, Incomplete {
    public JobSupport Z;

    @Nullable
    public NodeList B() {
        return null;
    }

    @NotNull
    public final JobSupport Y0() {
        JobSupport jobSupport = this.Z;
        if (jobSupport != null) {
            return jobSupport;
        }
        Intrinsics.S("job");
        return null;
    }

    public final void Z0(@NotNull JobSupport jobSupport) {
        this.Z = jobSupport;
    }

    public boolean b() {
        return true;
    }

    public void m() {
        Y0().s1(this);
    }

    @NotNull
    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this) + "[job@" + DebugStringsKt.b(Y0()) + ']';
    }
}
