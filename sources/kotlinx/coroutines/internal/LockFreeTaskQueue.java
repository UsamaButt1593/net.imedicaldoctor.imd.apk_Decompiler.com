package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\b\u0001\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", "E", "", "singleConsumer", "<init>", "(Z)V", "", "b", "()V", "element", "a", "(Ljava/lang/Object;)Z", "g", "()Ljava/lang/Object;", "R", "Lkotlin/Function1;", "transform", "", "f", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "d", "()Z", "e", "isEmpty", "", "c", "()I", "size", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class LockFreeTaskQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f29367a = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
    @NotNull
    private volatile /* synthetic */ Object _cur;

    public LockFreeTaskQueue(boolean z) {
        this._cur = new LockFreeTaskQueueCore(8, z);
    }

    public final boolean a(@NotNull E e2) {
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur;
            int a2 = lockFreeTaskQueueCore.a(e2);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                a.a(f29367a, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.k());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur;
            if (!lockFreeTaskQueueCore.d()) {
                a.a(f29367a, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.k());
            } else {
                return;
            }
        }
    }

    public final int c() {
        return ((LockFreeTaskQueueCore) this._cur).f();
    }

    public final boolean d() {
        return ((LockFreeTaskQueueCore) this._cur).g();
    }

    public final boolean e() {
        return ((LockFreeTaskQueueCore) this._cur).h();
    }

    @NotNull
    public final <R> List<R> f(@NotNull Function1<? super E, ? extends R> function1) {
        return ((LockFreeTaskQueueCore) this._cur).i(function1);
    }

    @Nullable
    public final E g() {
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._cur;
            E l2 = lockFreeTaskQueueCore.l();
            if (l2 != LockFreeTaskQueueCore.t) {
                return l2;
            }
            a.a(f29367a, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.k());
        }
    }
}
