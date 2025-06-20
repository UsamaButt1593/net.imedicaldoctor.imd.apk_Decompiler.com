package kotlin;

import com.itextpdf.tool.xml.css.CSS;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004BM\u00129\u0010\b\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\t\u001a\u00028\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJe\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000429\u0010\f\u001a5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\b\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u001a\u001a\u00028\u0003\"\u0004\b\u0002\u0010\u0017\"\u0004\b\u0003\u0010\u0018*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00192\u0006\u0010\t\u001a\u00028\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00028\u0001¢\u0006\u0004\b\u001c\u0010\u001dRL\u0010 \u001a5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\b\u00078\u0002@\u0002X\u000eø\u0001\u0000¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00108\u0002@\u0002X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010)\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006*"}, d2 = {"Lkotlin/DeepRecursiveScopeImpl;", "T", "R", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Function3;", "", "Lkotlin/ExtensionFunctionType;", "block", "value", "<init>", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;)V", "currentFunction", "cont", "j", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "result", "", "w", "(Ljava/lang/Object;)V", "a", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "U", "S", "Lkotlin/DeepRecursiveFunction;", "c", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "k", "()Ljava/lang/Object;", "s", "Lkotlin/jvm/functions/Function3;", "function", "X", "Ljava/lang/Object;", "Y", "Lkotlin/coroutines/Continuation;", "Z", "Lkotlin/coroutines/CoroutineContext;", "g", "()Lkotlin/coroutines/CoroutineContext;", "context", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class DeepRecursiveScopeImpl<T, R> extends DeepRecursiveScope<T, R> implements Continuation<R> {
    @Nullable
    private Object X;
    /* access modifiers changed from: private */
    @Nullable
    public Continuation<Object> Y = this;
    /* access modifiers changed from: private */
    @NotNull
    public Object Z = DeepRecursiveKt.f28775a;
    /* access modifiers changed from: private */
    @NotNull
    public Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeepRecursiveScopeImpl(@NotNull Function3<? super DeepRecursiveScope<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> function3, T t) {
        super((DefaultConstructorMarker) null);
        Intrinsics.p(function3, CSS.Value.v0);
        this.s = function3;
        this.X = t;
        Intrinsics.n(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    private final Continuation<Object> j(Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function3, Continuation<Object> continuation) {
        return new DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1(EmptyCoroutineContext.s, this, function3, continuation);
    }

    @Nullable
    public Object a(T t, @NotNull Continuation<? super R> continuation) {
        Intrinsics.n(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.Y = continuation;
        this.X = t;
        Object l2 = IntrinsicsKt.l();
        if (l2 == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return l2;
    }

    @Nullable
    public <U, S> Object c(@NotNull DeepRecursiveFunction<U, S> deepRecursiveFunction, U u, @NotNull Continuation<? super S> continuation) {
        Function3<DeepRecursiveScope<U, S>, U, Continuation<? super S>, Object> a2 = deepRecursiveFunction.a();
        Intrinsics.n(a2, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<kotlin.DeepRecursiveScope<*, *>, kotlin.Any?, kotlin.Any?>{ kotlin.DeepRecursiveKt.DeepRecursiveFunctionBlock }");
        Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function3 = this.s;
        if (a2 != function3) {
            this.s = a2;
            Intrinsics.n(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.Y = j(function3, continuation);
        } else {
            Intrinsics.n(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.Y = continuation;
        }
        this.X = u;
        Object l2 = IntrinsicsKt.l();
        if (l2 == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return l2;
    }

    @NotNull
    public CoroutineContext g() {
        return EmptyCoroutineContext.s;
    }

    public final R k() {
        Object obj;
        while (true) {
            R r = this.Z;
            Continuation<Object> continuation = this.Y;
            if (continuation == null) {
                ResultKt.n(r);
                return r;
            }
            if (Result.d(DeepRecursiveKt.f28775a, r)) {
                try {
                    Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function3 = this.s;
                    Object obj2 = this.X;
                    obj = !(function3 instanceof BaseContinuationImpl) ? IntrinsicsKt.k(function3, this, obj2, continuation) : ((Function3) TypeIntrinsics.q(function3, 3)).A(this, obj2, continuation);
                    if (obj != IntrinsicsKt.l()) {
                        Result.Companion companion = Result.X;
                        r = Result.b(obj);
                    }
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.X;
                    obj = ResultKt.a(th);
                }
            } else {
                this.Z = DeepRecursiveKt.f28775a;
            }
            continuation.w(r);
        }
    }

    public void w(@NotNull Object obj) {
        this.Y = null;
        this.Z = obj;
    }
}
