package kotlin.reflect;

import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/KDeclarationContainer;", "", "", "Lkotlin/reflect/KCallable;", "l", "()Ljava/util/Collection;", "members", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public interface KDeclarationContainer {
    @NotNull
    Collection<KCallable<?>> l();
}
