package kotlinx.coroutines.sync;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H&¢\u0006\u0004\b\t\u0010\u0005J\u001b\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR(\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00000\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/sync/Mutex;", "", "owner", "", "a", "(Ljava/lang/Object;)Z", "", "c", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "d", "(Ljava/lang/Object;)V", "b", "()Z", "isLocked", "Lkotlinx/coroutines/selects/SelectClause2;", "f", "()Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock$annotations", "()V", "onLock", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface Mutex {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.WARNING, message = "Mutex.onLock deprecated without replacement. For additional details please refer to #2794")
        public static /* synthetic */ void a() {
        }

        public static /* synthetic */ Object b(Mutex mutex, Object obj, Continuation continuation, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 1) != 0) {
                    obj = null;
                }
                return mutex.c(obj, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
        }

        public static /* synthetic */ boolean c(Mutex mutex, Object obj, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 1) != 0) {
                    obj = null;
                }
                return mutex.a(obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }

        public static /* synthetic */ void d(Mutex mutex, Object obj, int i2, Object obj2) {
            if (obj2 == null) {
                if ((i2 & 1) != 0) {
                    obj = null;
                }
                mutex.d(obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
    }

    boolean a(@Nullable Object obj);

    boolean b();

    @Nullable
    Object c(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation);

    void d(@Nullable Object obj);

    boolean e(@NotNull Object obj);

    @NotNull
    SelectClause2<Object, Mutex> f();
}
