package kotlin.coroutines.jvm.internal;

import com.itextpdf.tool.xml.css.CSS;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a0\u0010\u0005\u001a\u00020\u00022\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "block", "a", "(Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class RunSuspendKt {
    @SinceKotlin(version = "1.3")
    public static final void a(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.p(function1, CSS.Value.v0);
        RunSuspend runSuspend = new RunSuspend();
        ContinuationKt.h(function1, runSuspend);
        runSuspend.a();
    }
}
