package kotlin;

import com.itextpdf.tool.xml.css.CSS;
import kotlin.coroutines.Continuation;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001aO\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001\"\u0004\b\u0000\u0010\u00002\u001e\b\b\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"R", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "a", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class SuspendKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <R> Function1<Continuation<? super R>, Object> a(Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.p(function1, CSS.Value.v0);
        return function1;
    }
}
