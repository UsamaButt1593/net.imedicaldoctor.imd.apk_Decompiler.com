package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "Lkotlinx/coroutines/NodeList;", "list", "<init>", "(Lkotlinx/coroutines/NodeList;)V", "", "toString", "()Ljava/lang/String;", "s", "Lkotlinx/coroutines/NodeList;", "B", "()Lkotlinx/coroutines/NodeList;", "", "b", "()Z", "isActive", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class InactiveNodeList implements Incomplete {
    @NotNull
    private final NodeList s;

    public InactiveNodeList(@NotNull NodeList nodeList) {
        this.s = nodeList;
    }

    @NotNull
    public NodeList B() {
        return this.s;
    }

    public boolean b() {
        return false;
    }

    @NotNull
    public String toString() {
        return super.toString();
    }
}
