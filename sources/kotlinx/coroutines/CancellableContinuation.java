package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J%\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\u0006\u0010\u0007JH\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\tH'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0004H'¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\rH'¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u001a\u0010\u001bJ8\u0010\u001e\u001a\u00020\r2'\u0010\u001d\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bj\u0002`\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\u00020\r*\u00020 2\u0006\u0010\u0003\u001a\u00028\u0000H'¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u00020\r*\u00020 2\u0006\u0010\u0011\u001a\u00020\tH'¢\u0006\u0004\b#\u0010$J<\u0010%\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0014\u0010,\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010(¨\u0006-"}, d2 = {"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "value", "", "idempotent", "r", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "onCancellation", "P", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "N", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "u0", "(Ljava/lang/Object;)V", "W", "()V", "", "d", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/CompletionHandler;", "handler", "M", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "S", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "R", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "f0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "b", "()Z", "isActive", "p", "isCompleted", "isCancelled", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface CancellableContinuation<T> extends Continuation<T> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean a(CancellableContinuation cancellableContinuation, Throwable th, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    th = null;
                }
                return cancellableContinuation.d(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ Object b(CancellableContinuation cancellableContinuation, Object obj, Object obj2, int i2, Object obj3) {
            if (obj3 == null) {
                if ((i2 & 2) != 0) {
                    obj2 = null;
                }
                return cancellableContinuation.r(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    void M(@NotNull Function1<? super Throwable, Unit> function1);

    @Nullable
    @InternalCoroutinesApi
    Object N(@NotNull Throwable th);

    @Nullable
    @InternalCoroutinesApi
    Object P(T t, @Nullable Object obj, @Nullable Function1<? super Throwable, Unit> function1);

    @ExperimentalCoroutinesApi
    void R(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th);

    @ExperimentalCoroutinesApi
    void S(@NotNull CoroutineDispatcher coroutineDispatcher, T t);

    @InternalCoroutinesApi
    void W();

    boolean b();

    boolean d(@Nullable Throwable th);

    @ExperimentalCoroutinesApi
    void f0(T t, @Nullable Function1<? super Throwable, Unit> function1);

    boolean isCancelled();

    boolean p();

    @Nullable
    @InternalCoroutinesApi
    Object r(T t, @Nullable Object obj);

    @InternalCoroutinesApi
    void u0(@NotNull Object obj);
}
