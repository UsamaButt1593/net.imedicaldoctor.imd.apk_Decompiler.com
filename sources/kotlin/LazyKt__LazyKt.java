package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a6\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"T", "value", "Lkotlin/Lazy;", "e", "(Ljava/lang/Object;)Lkotlin/Lazy;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "d", "(Lkotlin/Lazy;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/LazyKt")
class LazyKt__LazyKt extends LazyKt__LazyJVMKt {
    @InlineOnly
    private static final <T> T d(Lazy<? extends T> lazy, Object obj, KProperty<?> kProperty) {
        Intrinsics.p(lazy, "<this>");
        Intrinsics.p(kProperty, "property");
        return lazy.getValue();
    }

    @NotNull
    public static final <T> Lazy<T> e(T t) {
        return new InitializedLazyImpl(t);
    }
}
