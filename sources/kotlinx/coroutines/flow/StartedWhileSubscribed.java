package kotlinx.coroutines.flow;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.firebase.sessions.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "", "stopTimeout", "replayExpiration", "<init>", "(JJ)V", "Lkotlinx/coroutines/flow/StateFlow;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "a", "(Lkotlinx/coroutines/flow/StateFlow;)Lkotlinx/coroutines/flow/Flow;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "b", "J", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class StartedWhileSubscribed implements SharingStarted {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f29317b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final long f29318c;

    public StartedWhileSubscribed(long j2, long j3) {
        this.f29317b = j2;
        this.f29318c = j3;
        if (j2 < 0) {
            throw new IllegalArgumentException(("stopTimeout(" + j2 + " ms) cannot be negative").toString());
        } else if (j3 < 0) {
            throw new IllegalArgumentException(("replayExpiration(" + j3 + " ms) cannot be negative").toString());
        }
    }

    @NotNull
    public Flow<SharingCommand> a(@NotNull StateFlow<Integer> stateFlow) {
        return FlowKt.g0(FlowKt.k0(FlowKt.b2(stateFlow, new StartedWhileSubscribed$command$1(this, (Continuation<? super StartedWhileSubscribed$command$1>) null)), new StartedWhileSubscribed$command$2((Continuation<? super StartedWhileSubscribed$command$2>) null)));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            return this.f29317b == startedWhileSubscribed.f29317b && this.f29318c == startedWhileSubscribed.f29318c;
        }
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return (j.a(this.f29317b) * 31) + j.a(this.f29318c);
    }

    @NotNull
    public String toString() {
        List j2 = CollectionsKt.j(2);
        if (this.f29317b > 0) {
            j2.add("stopTimeout=" + this.f29317b + "ms");
        }
        if (this.f29318c < Long.MAX_VALUE) {
            j2.add("replayExpiration=" + this.f29318c + "ms");
        }
        List a2 = CollectionsKt.a(j2);
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.j3(a2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ASCIIPropertyListParser.f18650h;
    }
}
