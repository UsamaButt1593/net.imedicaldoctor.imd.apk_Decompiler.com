package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u001f\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00008À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/KClass;", "", "a", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "qualifiedOrSimpleName", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class KClassesImplKt {
    @Nullable
    public static final String a(@NotNull KClass<?> kClass) {
        Intrinsics.p(kClass, "<this>");
        return kClass.m();
    }
}
