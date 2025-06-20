package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u00042\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ^\u0010\u0011\u001a\u00020\n\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u00042'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000e¢\u0006\u0002\b\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u00138FX\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/CoroutineStart;", "", "<init>", "(Ljava/lang/String;I)V", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "completion", "", "b", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "c", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "", "e", "()Z", "f", "()V", "isLazy", "s", "X", "Y", "Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29169a = null;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            iArr[CoroutineStart.LAZY.ordinal()] = 4;
            f29169a = iArr;
        }
    }

    @InternalCoroutinesApi
    public final <T> void b(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        int i2 = WhenMappings.f29169a[ordinal()];
        if (i2 == 1) {
            CancellableKt.d(function1, continuation);
        } else if (i2 == 2) {
            ContinuationKt.h(function1, continuation);
        } else if (i2 == 3) {
            UndispatchedKt.a(function1, continuation);
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    @InternalCoroutinesApi
    public final <R, T> void c(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        int i2 = WhenMappings.f29169a[ordinal()];
        if (i2 == 1) {
            CancellableKt.f(function2, r, continuation, (Function1) null, 4, (Object) null);
        } else if (i2 == 2) {
            ContinuationKt.i(function2, r, continuation);
        } else if (i2 == 3) {
            UndispatchedKt.b(function2, r, continuation);
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean e() {
        return this == LAZY;
    }
}
