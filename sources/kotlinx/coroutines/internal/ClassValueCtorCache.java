package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001\u000b\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007j\u0002`\b2\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/internal/ClassValueCtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "<init>", "()V", "Ljava/lang/Class;", "", "key", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "a", "(Ljava/lang/Class;)Lkotlin/jvm/functions/Function1;", "kotlinx/coroutines/internal/ClassValueCtorCache$cache$1", "b", "Lkotlinx/coroutines/internal/ClassValueCtorCache$cache$1;", "cache", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@IgnoreJRERequirement
final class ClassValueCtorCache extends CtorCache {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final ClassValueCtorCache f29334a = new ClassValueCtorCache();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final ClassValueCtorCache$cache$1 f29335b = new ClassValueCtorCache$cache$1();

    private ClassValueCtorCache() {
    }

    @NotNull
    public Function1<Throwable, Throwable> a(@NotNull Class<? extends Throwable> cls) {
        return (Function1) f29335b.get(cls);
    }
}
