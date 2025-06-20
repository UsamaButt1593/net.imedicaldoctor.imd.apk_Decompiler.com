package kotlin;

import com.itextpdf.tool.xml.css.CSS;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a<\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0007"}, d2 = {"R", "", "lock", "Lkotlin/Function0;", "block", "l", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/StandardKt")
class StandardKt__SynchronizedKt extends StandardKt__StandardKt {
    @InlineOnly
    private static final <R> R l(Object obj, Function0<? extends R> function0) {
        R o;
        Intrinsics.p(obj, "lock");
        Intrinsics.p(function0, CSS.Value.v0);
        synchronized (obj) {
            try {
                o = function0.o();
                InlineMarker.d(1);
            } catch (Throwable th) {
                InlineMarker.d(1);
                InlineMarker.c(1);
                throw th;
            }
        }
        InlineMarker.c(1);
        return o;
    }
}
