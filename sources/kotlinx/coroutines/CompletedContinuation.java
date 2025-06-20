package kotlinx.coroutines;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\\\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\n2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0015J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJg\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010)R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010*R1\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010+R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010)R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010,R\u0011\u0010/\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Lkotlinx/coroutines/CompletedContinuation;", "", "result", "Lkotlinx/coroutines/CancelHandler;", "cancelHandler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "onCancellation", "idempotentResume", "cancelCause", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuationImpl;", "cont", "i", "(Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Throwable;)V", "a", "()Ljava/lang/Object;", "b", "()Lkotlinx/coroutines/CancelHandler;", "c", "()Lkotlin/jvm/functions/Function1;", "d", "e", "()Ljava/lang/Throwable;", "f", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)Lkotlinx/coroutines/CompletedContinuation;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "Lkotlinx/coroutines/CancelHandler;", "Lkotlin/jvm/functions/Function1;", "Ljava/lang/Throwable;", "h", "()Z", "cancelled", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class CompletedContinuation {
    @Nullable
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public final Object f29158a;
    @Nullable
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public final CancelHandler f29159b;
    @Nullable
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public final Function1<Throwable, Unit> f29160c;
    @Nullable
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public final Object f29161d;
    @Nullable
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f29162e;

    public CompletedContinuation(@Nullable Object obj, @Nullable CancelHandler cancelHandler, @Nullable Function1<? super Throwable, Unit> function1, @Nullable Object obj2, @Nullable Throwable th) {
        this.f29158a = obj;
        this.f29159b = cancelHandler;
        this.f29160c = function1;
        this.f29161d = obj2;
        this.f29162e = th;
    }

    public static /* synthetic */ CompletedContinuation g(CompletedContinuation completedContinuation, Object obj, CancelHandler cancelHandler, Function1<Throwable, Unit> function1, Object obj2, Throwable th, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = completedContinuation.f29158a;
        }
        if ((i2 & 2) != 0) {
            cancelHandler = completedContinuation.f29159b;
        }
        CancelHandler cancelHandler2 = cancelHandler;
        if ((i2 & 4) != 0) {
            function1 = completedContinuation.f29160c;
        }
        Function1<Throwable, Unit> function12 = function1;
        if ((i2 & 8) != 0) {
            obj2 = completedContinuation.f29161d;
        }
        Object obj4 = obj2;
        if ((i2 & 16) != 0) {
            th = completedContinuation.f29162e;
        }
        return completedContinuation.f(obj, cancelHandler2, function12, obj4, th);
    }

    @Nullable
    public final Object a() {
        return this.f29158a;
    }

    @Nullable
    public final CancelHandler b() {
        return this.f29159b;
    }

    @Nullable
    public final Function1<Throwable, Unit> c() {
        return this.f29160c;
    }

    @Nullable
    public final Object d() {
        return this.f29161d;
    }

    @Nullable
    public final Throwable e() {
        return this.f29162e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
        return Intrinsics.g(this.f29158a, completedContinuation.f29158a) && Intrinsics.g(this.f29159b, completedContinuation.f29159b) && Intrinsics.g(this.f29160c, completedContinuation.f29160c) && Intrinsics.g(this.f29161d, completedContinuation.f29161d) && Intrinsics.g(this.f29162e, completedContinuation.f29162e);
    }

    @NotNull
    public final CompletedContinuation f(@Nullable Object obj, @Nullable CancelHandler cancelHandler, @Nullable Function1<? super Throwable, Unit> function1, @Nullable Object obj2, @Nullable Throwable th) {
        return new CompletedContinuation(obj, cancelHandler, function1, obj2, th);
    }

    public final boolean h() {
        return this.f29162e != null;
    }

    public int hashCode() {
        Object obj = this.f29158a;
        int i2 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        CancelHandler cancelHandler = this.f29159b;
        int hashCode2 = (hashCode + (cancelHandler == null ? 0 : cancelHandler.hashCode())) * 31;
        Function1<Throwable, Unit> function1 = this.f29160c;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.f29161d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f29162e;
        if (th != null) {
            i2 = th.hashCode();
        }
        return hashCode4 + i2;
    }

    public final void i(@NotNull CancellableContinuationImpl<?> cancellableContinuationImpl, @NotNull Throwable th) {
        CancelHandler cancelHandler = this.f29159b;
        if (cancelHandler != null) {
            cancellableContinuationImpl.n(cancelHandler, th);
        }
        Function1<Throwable, Unit> function1 = this.f29160c;
        if (function1 != null) {
            cancellableContinuationImpl.q(function1, th);
        }
    }

    @NotNull
    public String toString() {
        return "CompletedContinuation(result=" + this.f29158a + ", cancelHandler=" + this.f29159b + ", onCancellation=" + this.f29160c + ", idempotentResume=" + this.f29161d + ", cancelCause=" + this.f29162e + ASCIIPropertyListParser.f18650h;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i2 & 2) != 0 ? null : cancelHandler, (i2 & 4) != 0 ? null : function1, (i2 & 8) != 0 ? null : obj2, (i2 & 16) != 0 ? null : th);
    }
}
