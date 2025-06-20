package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\b\u0010\t\u001a1\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"T", "Lkotlin/Function0;", "initializer", "Lkotlin/Lazy;", "c", "(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;", "Lkotlin/LazyThreadSafetyMode;", "mode", "b", "(Lkotlin/LazyThreadSafetyMode;Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;", "", "lock", "a", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/LazyKt")
class LazyKt__LazyJVMKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28777a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.LazyThreadSafetyMode[] r0 = kotlin.LazyThreadSafetyMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.LazyThreadSafetyMode r1 = kotlin.LazyThreadSafetyMode.SYNCHRONIZED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.LazyThreadSafetyMode r1 = kotlin.LazyThreadSafetyMode.PUBLICATION     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.LazyThreadSafetyMode r1 = kotlin.LazyThreadSafetyMode.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f28777a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.LazyKt__LazyJVMKt.WhenMappings.<clinit>():void");
        }
    }

    @NotNull
    public static final <T> Lazy<T> a(@Nullable Object obj, @NotNull Function0<? extends T> function0) {
        Intrinsics.p(function0, "initializer");
        return new SynchronizedLazyImpl(function0, obj);
    }

    @NotNull
    public static final <T> Lazy<T> b(@NotNull LazyThreadSafetyMode lazyThreadSafetyMode, @NotNull Function0<? extends T> function0) {
        Intrinsics.p(lazyThreadSafetyMode, "mode");
        Intrinsics.p(function0, "initializer");
        int i2 = WhenMappings.f28777a[lazyThreadSafetyMode.ordinal()];
        if (i2 == 1) {
            return new SynchronizedLazyImpl(function0, (Object) null, 2, (DefaultConstructorMarker) null);
        }
        if (i2 == 2) {
            return new SafePublicationLazyImpl(function0);
        }
        if (i2 == 3) {
            return new UnsafeLazyImpl(function0);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static <T> Lazy<T> c(@NotNull Function0<? extends T> function0) {
        Intrinsics.p(function0, "initializer");
        return new SynchronizedLazyImpl(function0, (Object) null, 2, (DefaultConstructorMarker) null);
    }
}
