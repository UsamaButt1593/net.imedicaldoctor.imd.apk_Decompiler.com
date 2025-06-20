package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.schedulers.ComputationScheduler;
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import io.reactivex.rxjava3.internal.schedulers.NewThreadScheduler;
import io.reactivex.rxjava3.internal.schedulers.SchedulerPoolFactory;
import io.reactivex.rxjava3.internal.schedulers.SingleScheduler;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Executor;

public final class Schedulers {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    static final Scheduler f28526a = RxJavaPlugins.J(new SingleTask());
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    static final Scheduler f28527b = RxJavaPlugins.G(new ComputationTask());
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    static final Scheduler f28528c = RxJavaPlugins.H(new IOTask());
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    static final Scheduler f28529d = TrampolineScheduler.n();
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    static final Scheduler f28530e = RxJavaPlugins.I(new NewThreadTask());

    static final class ComputationHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f28531a = new ComputationScheduler();

        ComputationHolder() {
        }
    }

    static final class ComputationTask implements Supplier<Scheduler> {
        ComputationTask() {
        }

        /* renamed from: a */
        public Scheduler get() {
            return ComputationHolder.f28531a;
        }
    }

    static final class IOTask implements Supplier<Scheduler> {
        IOTask() {
        }

        /* renamed from: a */
        public Scheduler get() {
            return IoHolder.f28532a;
        }
    }

    static final class IoHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f28532a = new IoScheduler();

        IoHolder() {
        }
    }

    static final class NewThreadHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f28533a = new NewThreadScheduler();

        NewThreadHolder() {
        }
    }

    static final class NewThreadTask implements Supplier<Scheduler> {
        NewThreadTask() {
        }

        /* renamed from: a */
        public Scheduler get() {
            return NewThreadHolder.f28533a;
        }
    }

    static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f28534a = new SingleScheduler();

        SingleHolder() {
        }
    }

    static final class SingleTask implements Supplier<Scheduler> {
        SingleTask() {
        }

        /* renamed from: a */
        public Scheduler get() {
            return SingleHolder.f28534a;
        }
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static Scheduler a() {
        return RxJavaPlugins.X(f28527b);
    }

    @NonNull
    public static Scheduler b(@NonNull Executor executor) {
        return new ExecutorScheduler(executor, false, false);
    }

    @NonNull
    public static Scheduler c(@NonNull Executor executor, boolean z) {
        return new ExecutorScheduler(executor, z, false);
    }

    @NonNull
    public static Scheduler d(@NonNull Executor executor, boolean z, boolean z2) {
        return new ExecutorScheduler(executor, z, z2);
    }

    @NonNull
    public static Scheduler e() {
        return RxJavaPlugins.Z(f28528c);
    }

    @NonNull
    public static Scheduler f() {
        return RxJavaPlugins.a0(f28530e);
    }

    public static void g() {
        a().j();
        e().j();
        f().j();
        h().j();
        j().j();
        SchedulerPoolFactory.d();
    }

    @NonNull
    public static Scheduler h() {
        return RxJavaPlugins.c0(f28526a);
    }

    public static void i() {
        a().k();
        e().k();
        f().k();
        h().k();
        j().k();
        SchedulerPoolFactory.e();
    }

    @NonNull
    public static Scheduler j() {
        return f28529d;
    }
}
