package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/ModuleNameRetriever\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "<init>", "()V", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "continuation", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "a", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "b", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Ljava/lang/String;", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "c", "cache", "Cache", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class ModuleNameRetriever {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final ModuleNameRetriever f28806a = new ModuleNameRetriever();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Cache f28807b = new Cache((Method) null, (Method) null, (Method) null);
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static Cache f28808c;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "Ljava/lang/reflect/Method;", "getModuleMethod", "getDescriptorMethod", "nameMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "a", "Ljava/lang/reflect/Method;", "b", "c", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    private static final class Cache {
        @Nullable
        @JvmField

        /* renamed from: a  reason: collision with root package name */
        public final Method f28809a;
        @Nullable
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public final Method f28810b;
        @Nullable
        @JvmField

        /* renamed from: c  reason: collision with root package name */
        public final Method f28811c;

        public Cache(@Nullable Method method, @Nullable Method method2, @Nullable Method method3) {
            this.f28809a = method;
            this.f28810b = method2;
            this.f28811c = method3;
        }
    }

    private ModuleNameRetriever() {
    }

    private final Cache a(BaseContinuationImpl baseContinuationImpl) {
        try {
            Cache cache = new Cache(Class.class.getDeclaredMethod("getModule", (Class[]) null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", (Class[]) null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", (Class[]) null));
            f28808c = cache;
            return cache;
        } catch (Exception unused) {
            Cache cache2 = f28807b;
            f28808c = cache2;
            return cache2;
        }
    }

    @Nullable
    public final String b(@NotNull BaseContinuationImpl baseContinuationImpl) {
        Intrinsics.p(baseContinuationImpl, "continuation");
        Cache cache = f28808c;
        if (cache == null) {
            cache = a(baseContinuationImpl);
        }
        if (cache == f28807b) {
            return null;
        }
        Method method = cache.f28809a;
        Object invoke = method != null ? method.invoke(baseContinuationImpl.getClass(), (Object[]) null) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = cache.f28810b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, (Object[]) null) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = cache.f28811c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, (Object[]) null) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
