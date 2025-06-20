package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00028\u0000H$¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000b2\u0006\u0010\n\u001a\u00020\tH$¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0015\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u0013H\b¢\u0006\u0004\b\u0015\u0010\u0016R>\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000b2\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000b8\u0004@BX\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR$\u0010\"\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t8\u0004@BX\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0)8F¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "S", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "g", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "size", "", "j", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "f", "slot", "", "n", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "Lkotlin/Function1;", "block", "k", "(Lkotlin/jvm/functions/Function1;)V", "<set-?>", "s", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "p", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "q", "slots", "X", "I", "o", "()I", "nCollectors", "Y", "nextIndex", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "Z", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "_subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "m", "()Lkotlinx/coroutines/flow/StateFlow;", "subscriptionCount", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {
    /* access modifiers changed from: private */
    public int X;
    private int Y;
    @Nullable
    private SubscriptionCountStateFlow Z;
    /* access modifiers changed from: private */
    @Nullable
    public S[] s;

    protected static /* synthetic */ void q() {
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final S f() {
        S s2;
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            try {
                S[] sArr = this.s;
                if (sArr == null) {
                    sArr = j(2);
                    this.s = sArr;
                } else if (this.X >= sArr.length) {
                    S[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                    Intrinsics.o(copyOf, "copyOf(this, newSize)");
                    this.s = (AbstractSharedFlowSlot[]) copyOf;
                    sArr = (AbstractSharedFlowSlot[]) copyOf;
                }
                int i2 = this.Y;
                do {
                    s2 = sArr[i2];
                    if (s2 == null) {
                        s2 = g();
                        sArr[i2] = s2;
                    }
                    i2++;
                    if (i2 >= sArr.length) {
                        i2 = 0;
                    }
                } while (!s2.a(this));
                this.Y = i2;
                this.X++;
                subscriptionCountStateFlow = this.Z;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.g0(1);
        }
        return s2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract S g();

    /* access modifiers changed from: protected */
    @NotNull
    public abstract S[] j(int i2);

    /* access modifiers changed from: protected */
    public final void k(@NotNull Function1<? super S, Unit> function1) {
        AbstractSharedFlowSlot[] e2;
        if (this.X != 0 && (e2 = this.s) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : e2) {
                if (abstractSharedFlowSlot != null) {
                    function1.f(abstractSharedFlowSlot);
                }
            }
        }
    }

    @NotNull
    public final StateFlow<Integer> m() {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            subscriptionCountStateFlow = this.Z;
            if (subscriptionCountStateFlow == null) {
                subscriptionCountStateFlow = new SubscriptionCountStateFlow(this.X);
                this.Z = subscriptionCountStateFlow;
            }
        }
        return subscriptionCountStateFlow;
    }

    /* access modifiers changed from: protected */
    public final void n(@NotNull S s2) {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        int i2;
        Continuation[] b2;
        synchronized (this) {
            try {
                int i3 = this.X - 1;
                this.X = i3;
                subscriptionCountStateFlow = this.Z;
                if (i3 == 0) {
                    this.Y = 0;
                }
                b2 = s2.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : b2) {
            if (continuation != null) {
                Result.Companion companion = Result.X;
                continuation.w(Result.b(Unit.f28779a));
            }
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.g0(-1);
        }
    }

    /* access modifiers changed from: protected */
    public final int o() {
        return this.X;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final S[] p() {
        return this.s;
    }
}
