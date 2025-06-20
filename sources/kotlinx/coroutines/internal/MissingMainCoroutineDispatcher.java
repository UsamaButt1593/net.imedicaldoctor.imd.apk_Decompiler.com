package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00162\n\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001f\u0010 J#\u0010!\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\n\u0010\u001d\u001a\u00060\u001bj\u0002`\u001cH\u0016¢\u0006\u0004\b!\u0010\"J%\u0010&\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00162\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010)R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "", "cause", "", "errorHint", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "", "s0", "()Ljava/lang/Void;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "T", "(Lkotlin/coroutines/CoroutineContext;)Z", "", "parallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "W", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "", "time", "Q", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeMillis", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/DisposableHandle;", "N", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "r0", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)Ljava/lang/Void;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "x0", "(JLkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Void;", "toString", "()Ljava/lang/String;", "Y", "Ljava/lang/Throwable;", "Z", "Ljava/lang/String;", "i0", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "immediate", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {
    @Nullable
    private final Throwable Y;
    @Nullable
    private final String Z;

    public MissingMainCoroutineDispatcher(@Nullable Throwable th, @Nullable String str) {
        this.Y = th;
        this.Z = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Void s0() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.Y
            if (r0 == 0) goto L_0x0036
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.Z
            if (r1 == 0) goto L_0x0025
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L_0x0027
        L_0x0025:
            java.lang.String r1 = ""
        L_0x0027:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.Y
            r1.<init>(r0, r2)
            throw r1
        L_0x0036:
            kotlinx.coroutines.internal.MainDispatchersKt.e()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.MissingMainCoroutineDispatcher.s0():java.lang.Void");
    }

    @NotNull
    public DisposableHandle N(long j2, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        s0();
        throw new KotlinNothingValueException();
    }

    @Nullable
    public Object Q(long j2, @NotNull Continuation<?> continuation) {
        s0();
        throw new KotlinNothingValueException();
    }

    public boolean T(@NotNull CoroutineContext coroutineContext) {
        s0();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public CoroutineDispatcher W(int i2) {
        s0();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public MainCoroutineDispatcher i0() {
        return this;
    }

    @NotNull
    /* renamed from: r0 */
    public Void R(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        s0();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.Y != null) {
            str = ", cause=" + this.Y;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    @NotNull
    /* renamed from: x0 */
    public Void r(long j2, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        s0();
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MissingMainCoroutineDispatcher(Throwable th, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i2 & 2) != 0 ? null : str);
    }
}
