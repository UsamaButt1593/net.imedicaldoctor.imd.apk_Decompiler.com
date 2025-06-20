package androidx.arch.core.executor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ArchTaskExecutor extends TaskExecutor {

    /* renamed from: c  reason: collision with root package name */
    private static volatile ArchTaskExecutor f3371c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f3372d = new a();
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f3373e = new b();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private TaskExecutor f3374a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final TaskExecutor f3375b;

    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.f3375b = defaultTaskExecutor;
        this.f3374a = defaultTaskExecutor;
    }

    @NonNull
    public static Executor g() {
        return f3373e;
    }

    @NonNull
    public static ArchTaskExecutor h() {
        if (f3371c != null) {
            return f3371c;
        }
        synchronized (ArchTaskExecutor.class) {
            try {
                if (f3371c == null) {
                    f3371c = new ArchTaskExecutor();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return f3371c;
    }

    @NonNull
    public static Executor i() {
        return f3372d;
    }

    public void a(@NonNull Runnable runnable) {
        this.f3374a.a(runnable);
    }

    public boolean c() {
        return this.f3374a.c();
    }

    public void d(@NonNull Runnable runnable) {
        this.f3374a.d(runnable);
    }

    public void l(@Nullable TaskExecutor taskExecutor) {
        if (taskExecutor == null) {
            taskExecutor = this.f3375b;
        }
        this.f3374a = taskExecutor;
    }
}
