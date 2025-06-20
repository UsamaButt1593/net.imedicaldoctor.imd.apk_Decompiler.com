package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/CompletedExceptionally;", "", "", "cause", "", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "b", "()Z", "", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class CompletedExceptionally {

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f29163b = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.class, "_handled");
    @NotNull
    private volatile /* synthetic */ int _handled;
    @NotNull
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f29164a;

    public CompletedExceptionally(@NotNull Throwable th, boolean z) {
        this.f29164a = th;
        this._handled = z ? 1 : 0;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f29163b.compareAndSet(this, 0, 1);
    }

    @NotNull
    public String toString() {
        return DebugStringsKt.a(this) + '[' + this.f29164a + ']';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompletedExceptionally(Throwable th, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i2 & 2) != 0 ? false : z);
    }
}
