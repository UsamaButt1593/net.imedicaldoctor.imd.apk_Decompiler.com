package kotlinx.coroutines;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/Empty;", "Lkotlinx/coroutines/Incomplete;", "", "isActive", "<init>", "(Z)V", "", "toString", "()Ljava/lang/String;", "s", "Z", "b", "()Z", "Lkotlinx/coroutines/NodeList;", "B", "()Lkotlinx/coroutines/NodeList;", "list", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class Empty implements Incomplete {
    private final boolean s;

    public Empty(boolean z) {
        this.s = z;
    }

    @Nullable
    public NodeList B() {
        return null;
    }

    public boolean b() {
        return this.s;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(b() ? "Active" : "New");
        sb.append(ASCIIPropertyListParser.f18653k);
        return sb.toString();
    }
}
