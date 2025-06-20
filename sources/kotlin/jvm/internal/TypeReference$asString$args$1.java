package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KTypeProjection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/reflect/KTypeProjection;", "it", "", "b", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 9, 0})
final class TypeReference$asString$args$1 extends Lambda implements Function1<KTypeProjection, CharSequence> {
    final /* synthetic */ TypeReference X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeReference$asString$args$1(TypeReference typeReference) {
        super(1);
        this.X = typeReference;
    }

    @NotNull
    /* renamed from: b */
    public final CharSequence f(@NotNull KTypeProjection kTypeProjection) {
        Intrinsics.p(kTypeProjection, "it");
        return this.X.f(kTypeProjection);
    }
}
