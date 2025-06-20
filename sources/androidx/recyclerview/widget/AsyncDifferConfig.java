package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class AsyncDifferConfig<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Executor f15208a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Executor f15209b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final DiffUtil.ItemCallback<T> f15210c;

    public static final class Builder<T> {

        /* renamed from: d  reason: collision with root package name */
        private static final Object f15211d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private static Executor f15212e;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Executor f15213a;

        /* renamed from: b  reason: collision with root package name */
        private Executor f15214b;

        /* renamed from: c  reason: collision with root package name */
        private final DiffUtil.ItemCallback<T> f15215c;

        public Builder(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
            this.f15215c = itemCallback;
        }

        @NonNull
        public AsyncDifferConfig<T> a() {
            if (this.f15214b == null) {
                synchronized (f15211d) {
                    try {
                        if (f15212e == null) {
                            f15212e = Executors.newFixedThreadPool(2);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                this.f15214b = f15212e;
            }
            return new AsyncDifferConfig<>(this.f15213a, this.f15214b, this.f15215c);
        }

        @NonNull
        public Builder<T> b(@Nullable Executor executor) {
            this.f15214b = executor;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder<T> c(@Nullable Executor executor) {
            this.f15213a = executor;
            return this;
        }
    }

    AsyncDifferConfig(@Nullable Executor executor, @NonNull Executor executor2, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this.f15208a = executor;
        this.f15209b = executor2;
        this.f15210c = itemCallback;
    }

    @NonNull
    public Executor a() {
        return this.f15209b;
    }

    @NonNull
    public DiffUtil.ItemCallback<T> b() {
        return this.f15210c;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Executor c() {
        return this.f15208a;
    }
}
