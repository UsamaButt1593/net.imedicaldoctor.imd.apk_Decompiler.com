package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aN\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001aG\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001f\b\u0004\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\b\u000bHHø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\r\u0010\u000e\" \u0010\u0015\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\" \u0010\u0019\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0017\u0010\u0012\"\u001a\u0010\u001c\u001a\u00020\u00068\u0002X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u0012\u0004\b\u001b\u0010\u0014\"\u001a\u0010\u001e\u001a\u00020\u00068\u0002X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u0012\u0004\b\u001d\u0010\u0014\"\u001a\u0010\"\u001a\u00020\u001f8\u0002X\u0004¢\u0006\f\n\u0004\b\u0018\u0010 \u0012\u0004\b!\u0010\u0014\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"R", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlin/time/Duration;", "timeout", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "", "k", "(Lkotlinx/coroutines/selects/SelectBuilder;JLkotlin/jvm/functions/Function1;)V", "Lkotlin/ExtensionFunctionType;", "builder", "l", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Ljava/lang/Object;", "f", "()Ljava/lang/Object;", "g", "()V", "NOT_SELECTED", "b", "d", "e", "ALREADY_SELECTED", "c", "j", "UNDECIDED", "h", "RESUMED", "Lkotlinx/coroutines/selects/SeqNumber;", "Lkotlinx/coroutines/selects/SeqNumber;", "i", "selectOpSequenceNumber", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class SelectKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final Object f29437a = new Symbol("NOT_SELECTED");
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Object f29438b = new Symbol("ALREADY_SELECTED");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final Object f29439c = new Symbol("UNDECIDED");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final Object f29440d = new Symbol("RESUMED");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final SeqNumber f29441e = new SeqNumber();

    @NotNull
    public static final Object d() {
        return f29438b;
    }

    public static /* synthetic */ void e() {
    }

    @NotNull
    public static final Object f() {
        return f29437a;
    }

    public static /* synthetic */ void g() {
    }

    private static /* synthetic */ void h() {
    }

    private static /* synthetic */ void i() {
    }

    private static /* synthetic */ void j() {
    }

    @ExperimentalCoroutinesApi
    public static final <R> void k(@NotNull SelectBuilder<? super R> selectBuilder, long j2, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectBuilder.U(DelayKt.e(j2), function1);
    }

    @Nullable
    public static final <R> Object l(@NotNull Function1<? super SelectBuilder<? super R>, Unit> function1, @NotNull Continuation<? super R> continuation) {
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
        try {
            function1.f(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.g1(th);
        }
        Object f1 = selectBuilderImpl.f1();
        if (f1 == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return f1;
    }

    private static final <R> Object m(Function1<? super SelectBuilder<? super R>, Unit> function1, Continuation<? super R> continuation) {
        InlineMarker.e(0);
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
        try {
            function1.f(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.g1(th);
        }
        Object f1 = selectBuilderImpl.f1();
        if (f1 == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        InlineMarker.e(1);
        return f1;
    }
}
