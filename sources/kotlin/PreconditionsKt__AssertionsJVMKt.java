package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a)\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0002\u0007\n\u0005\b20\u0001¨\u0006\n"}, d2 = {"", "value", "", "a", "(Z)V", "Lkotlin/Function0;", "", "lazyMessage", "b", "(ZLkotlin/jvm/functions/Function0;)V", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/PreconditionsKt")
@SourceDebugExtension({"SMAP\nAssertionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AssertionsJVM.kt\nkotlin/PreconditionsKt__AssertionsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,39:1\n1#2:40\n*E\n"})
class PreconditionsKt__AssertionsJVMKt {
    @InlineOnly
    private static final void a(boolean z) {
    }

    @InlineOnly
    private static final void b(boolean z, Function0<? extends Object> function0) {
        Intrinsics.p(function0, "lazyMessage");
    }
}
