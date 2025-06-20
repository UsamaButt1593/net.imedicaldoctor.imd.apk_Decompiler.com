package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0004¢\u0006\u0004\b\u001b\u0010\u0010J\u001e\u0010\u001e\u001a\u00020\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0010J\u0019\u0010\u001f\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001f\u0010\u0010J\u0017\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0011H\u0000¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0016H\u0010¢\u0006\u0004\b#\u0010\u0018JO\u0010+\u001a\u00020\u000e\"\u0004\b\u0001\u0010$2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00028\u00012'\u0010*\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00190(¢\u0006\u0002\b)ø\u0001\u0000¢\u0006\u0004\b+\u0010,R\u001d\u00103\u001a\u00020\u00068\u0006¢\u0006\u0012\n\u0004\b-\u0010.\u0012\u0004\b1\u00102\u001a\u0004\b/\u00100R\u0014\u00105\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b4\u00100R\u0014\u00108\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;ZZ)V", "value", "", "I1", "(Ljava/lang/Object;)V", "", "cause", "handled", "H1", "(Ljava/lang/Throwable;Z)V", "", "B0", "()Ljava/lang/String;", "", "state", "n1", "Lkotlin/Result;", "result", "w", "F1", "exception", "V0", "(Ljava/lang/Throwable;)V", "h1", "R", "Lkotlinx/coroutines/CoroutineStart;", "start", "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "block", "J1", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "X", "Lkotlin/coroutines/CoroutineContext;", "g", "()Lkotlin/coroutines/CoroutineContext;", "G1", "()V", "context", "U", "coroutineContext", "b", "()Z", "isActive", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@InternalCoroutinesApi
public abstract class AbstractCoroutine<T> extends JobSupport implements Job, Continuation<T>, CoroutineScope {
    @NotNull
    private final CoroutineContext X;

    public AbstractCoroutine(@NotNull CoroutineContext coroutineContext, boolean z, boolean z2) {
        super(z2);
        if (z) {
            W0((Job) coroutineContext.e(Job.P2));
        }
        this.X = coroutineContext.v(this);
    }

    public static /* synthetic */ void G1() {
    }

    /* access modifiers changed from: protected */
    @NotNull
    public String B0() {
        return DebugStringsKt.a(this) + " was cancelled";
    }

    /* access modifiers changed from: protected */
    public void F1(@Nullable Object obj) {
        s0(obj);
    }

    /* access modifiers changed from: protected */
    public void H1(@NotNull Throwable th, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void I1(T t) {
    }

    public final <R> void J1(@NotNull CoroutineStart coroutineStart, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        coroutineStart.c(function2, r, this);
    }

    @NotNull
    public CoroutineContext U() {
        return this.X;
    }

    public final void V0(@NotNull Throwable th) {
        CoroutineExceptionHandlerKt.b(this.X, th);
    }

    public boolean b() {
        return super.b();
    }

    @NotNull
    public final CoroutineContext g() {
        return this.X;
    }

    @NotNull
    public String h1() {
        String b2 = CoroutineContextKt.b(this.X);
        if (b2 == null) {
            return super.h1();
        }
        return '\"' + b2 + "\":" + super.h1();
    }

    /* access modifiers changed from: protected */
    public final void n1(@Nullable Object obj) {
        if (obj instanceof CompletedExceptionally) {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            H1(completedExceptionally.f29164a, completedExceptionally.a());
            return;
        }
        I1(obj);
    }

    public final void w(@NotNull Object obj) {
        Object f1 = f1(CompletionStateKt.d(obj, (Function1) null, 1, (Object) null));
        if (f1 != JobSupportKt.f29208b) {
            F1(f1);
        }
    }
}
