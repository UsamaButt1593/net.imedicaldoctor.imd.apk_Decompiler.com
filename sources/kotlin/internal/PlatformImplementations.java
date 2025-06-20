package kotlin.internal;

import java.lang.reflect.Method;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "<init>", "()V", "", "cause", "exception", "", "a", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "", "d", "(Ljava/lang/Throwable;)Ljava/util/List;", "Ljava/util/regex/MatchResult;", "matchResult", "", "name", "Lkotlin/text/MatchGroup;", "c", "(Ljava/util/regex/MatchResult;Ljava/lang/String;)Lkotlin/text/MatchGroup;", "Lkotlin/random/Random;", "b", "()Lkotlin/random/Random;", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public class PlatformImplementations {

    @SourceDebugExtension({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations$ReflectThrowable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "<init>", "()V", "Ljava/lang/reflect/Method;", "b", "Ljava/lang/reflect/Method;", "addSuppressed", "c", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    private static final class ReflectThrowable {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final ReflectThrowable f28812a = new ReflectThrowable();
        @Nullable
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public static final Method f28813b;
        @Nullable
        @JvmField

        /* renamed from: c  reason: collision with root package name */
        public static final Method f28814c;

        static {
            Method method;
            Method method2;
            Class<Throwable> cls = Throwable.class;
            Method[] methods = cls.getMethods();
            Intrinsics.o(methods, "throwableMethods");
            int length = methods.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                method = null;
                if (i3 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i3];
                if (Intrinsics.g(method2.getName(), "addSuppressed")) {
                    Class[] parameterTypes = method2.getParameterTypes();
                    Intrinsics.o(parameterTypes, "it.parameterTypes");
                    if (Intrinsics.g(ArraysKt.Bt(parameterTypes), cls)) {
                        break;
                    }
                }
                i3++;
            }
            f28813b = method2;
            int length2 = methods.length;
            while (true) {
                if (i2 >= length2) {
                    break;
                }
                Method method3 = methods[i2];
                if (Intrinsics.g(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i2++;
            }
            f28814c = method;
        }

        private ReflectThrowable() {
        }
    }

    public void a(@NotNull Throwable th, @NotNull Throwable th2) {
        Intrinsics.p(th, "cause");
        Intrinsics.p(th2, "exception");
        Method method = ReflectThrowable.f28813b;
        if (method != null) {
            method.invoke(th, new Object[]{th2});
        }
    }

    @NotNull
    public Random b() {
        return new FallbackThreadLocalRandom();
    }

    @Nullable
    public MatchGroup c(@NotNull MatchResult matchResult, @NotNull String str) {
        Intrinsics.p(matchResult, "matchResult");
        Intrinsics.p(str, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r3 = kotlin.collections.ArraysKt.t((java.lang.Throwable[]) (r3 = r0.invoke(r3, (java.lang.Object[]) null)));
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Throwable> d(@org.jetbrains.annotations.NotNull java.lang.Throwable r3) {
        /*
            r2 = this;
            java.lang.String r0 = "exception"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            java.lang.reflect.Method r0 = kotlin.internal.PlatformImplementations.ReflectThrowable.f28814c
            if (r0 == 0) goto L_0x0018
            r1 = 0
            java.lang.Object r3 = r0.invoke(r3, r1)
            if (r3 == 0) goto L_0x0018
            java.lang.Throwable[] r3 = (java.lang.Throwable[]) r3
            java.util.List r3 = kotlin.collections.ArraysKt.t(r3)
            if (r3 != 0) goto L_0x001c
        L_0x0018:
            java.util.List r3 = kotlin.collections.CollectionsKt.E()
        L_0x001c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementations.d(java.lang.Throwable):java.util.List");
    }
}
