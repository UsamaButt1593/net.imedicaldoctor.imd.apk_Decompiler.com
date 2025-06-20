package androidx.core.util;

import androidx.annotation.IntRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Landroidx/core/util/Pools;", "", "()V", "Pool", "SimplePool", "SynchronizedPool", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Pools {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/core/util/Pools$Pool;", "", "T", "b", "()Ljava/lang/Object;", "instance", "", "c", "(Ljava/lang/Object;)Z", "core_release"}, k = 1, mv = {1, 8, 0})
    public interface Pool<T> {
        @Nullable
        T b();

        boolean c(@NotNull T t);
    }

    @SourceDebugExtension({"SMAP\nPools.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pools.kt\nandroidx/core/util/Pools$SimplePool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000bR\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/core/util/Pools$SimplePool;", "", "T", "Landroidx/core/util/Pools$Pool;", "", "maxPoolSize", "<init>", "(I)V", "instance", "", "a", "(Ljava/lang/Object;)Z", "b", "()Ljava/lang/Object;", "c", "", "[Ljava/lang/Object;", "pool", "I", "poolSize", "core_release"}, k = 1, mv = {1, 8, 0})
    public static class SimplePool<T> implements Pool<T> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f6312a;

        /* renamed from: b  reason: collision with root package name */
        private int f6313b;

        public SimplePool(@IntRange(from = 1) int i2) {
            if (i2 > 0) {
                this.f6312a = new Object[i2];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0".toString());
        }

        private final boolean a(T t) {
            int i2 = this.f6313b;
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.f6312a[i3] == t) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        public T b() {
            int i2 = this.f6313b;
            if (i2 <= 0) {
                return null;
            }
            int i3 = i2 - 1;
            T t = this.f6312a[i3];
            Intrinsics.n(t, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            this.f6312a[i3] = null;
            this.f6313b--;
            return t;
        }

        public boolean c(@NotNull T t) {
            Intrinsics.p(t, "instance");
            if (!a(t)) {
                int i2 = this.f6313b;
                Object[] objArr = this.f6312a;
                if (i2 >= objArr.length) {
                    return false;
                }
                objArr[i2] = t;
                this.f6313b = i2 + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!".toString());
        }
    }

    @SourceDebugExtension({"SMAP\nPools.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pools.kt\nandroidx/core/util/Pools$SynchronizedPool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/core/util/Pools$SynchronizedPool;", "", "T", "Landroidx/core/util/Pools$SimplePool;", "", "maxPoolSize", "<init>", "(I)V", "b", "()Ljava/lang/Object;", "instance", "", "c", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "lock", "core_release"}, k = 1, mv = {1, 8, 0})
    public static class SynchronizedPool<T> extends SimplePool<T> {
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final Object f6314c = new Object();

        public SynchronizedPool(int i2) {
            super(i2);
        }

        @Nullable
        public T b() {
            T b2;
            synchronized (this.f6314c) {
                b2 = super.b();
            }
            return b2;
        }

        public boolean c(@NotNull T t) {
            boolean c2;
            Intrinsics.p(t, "instance");
            synchronized (this.f6314c) {
                c2 = super.c(t);
            }
            return c2;
        }
    }

    private Pools() {
    }
}
