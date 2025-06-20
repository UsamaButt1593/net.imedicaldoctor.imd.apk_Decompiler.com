package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00028\u0000H%¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00108\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00178\u0000X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u00178\u0000X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u0018\u0010\u001bR\u001a\u0010!\u001a\u00020\u001e8\u0000X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001f\u0012\u0004\b \u0010\tR\u001a\u0010#\u001a\u00020\u001e8\u0000X\u0004¢\u0006\f\n\u0004\b\"\u0010\u001f\u0012\u0004\b\"\u0010\t¨\u0006$"}, d2 = {"Landroidx/lifecycle/ComputableLiveData;", "T", "", "Ljava/util/concurrent/Executor;", "executor", "<init>", "(Ljava/util/concurrent/Executor;)V", "", "j", "()V", "c", "()Ljava/lang/Object;", "a", "Ljava/util/concurrent/Executor;", "e", "()Ljava/util/concurrent/Executor;", "Landroidx/lifecycle/LiveData;", "b", "Landroidx/lifecycle/LiveData;", "_liveData", "h", "()Landroidx/lifecycle/LiveData;", "liveData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "invalid", "computing", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "i", "refreshRunnable", "g", "invalidationRunnable", "lifecycle-livedata_release"}, k = 1, mv = {1, 8, 0})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ComputableLiveData<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Executor f8508a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final LiveData<T> f8509b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final LiveData<T> f8510c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f8511d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f8512e;
    @NotNull
    @JvmField

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f8513f;
    @NotNull
    @JvmField

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f8514g;

    @JvmOverloads
    public ComputableLiveData() {
        this((Executor) null, 1, (DefaultConstructorMarker) null);
    }

    @VisibleForTesting
    public static /* synthetic */ void g() {
    }

    @VisibleForTesting
    public static /* synthetic */ void i() {
    }

    /* access modifiers changed from: private */
    public static final void k(ComputableLiveData computableLiveData) {
        Intrinsics.p(computableLiveData, "this$0");
        boolean h2 = computableLiveData.h().h();
        if (computableLiveData.f8511d.compareAndSet(false, true) && h2) {
            computableLiveData.f8508a.execute(computableLiveData.f8513f);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x000f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void l(androidx.lifecycle.ComputableLiveData r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.p(r5, r0)
        L_0x0005:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.f8512e
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x0037
            r0 = 0
            r3 = 0
        L_0x0011:
            java.util.concurrent.atomic.AtomicBoolean r4 = r5.f8511d     // Catch:{ all -> 0x001f }
            boolean r4 = r4.compareAndSet(r2, r1)     // Catch:{ all -> 0x001f }
            if (r4 == 0) goto L_0x0021
            java.lang.Object r0 = r5.c()     // Catch:{ all -> 0x001f }
            r3 = 1
            goto L_0x0011
        L_0x001f:
            r0 = move-exception
            goto L_0x0031
        L_0x0021:
            if (r3 == 0) goto L_0x002a
            androidx.lifecycle.LiveData r2 = r5.h()     // Catch:{ all -> 0x001f }
            r2.o(r0)     // Catch:{ all -> 0x001f }
        L_0x002a:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.f8512e
            r0.set(r1)
            r1 = r3
            goto L_0x0037
        L_0x0031:
            java.util.concurrent.atomic.AtomicBoolean r5 = r5.f8512e
            r5.set(r1)
            throw r0
        L_0x0037:
            if (r1 == 0) goto L_0x0041
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.f8511d
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0005
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ComputableLiveData.l(androidx.lifecycle.ComputableLiveData):void");
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public abstract T c();

    @NotNull
    public final AtomicBoolean d() {
        return this.f8512e;
    }

    @NotNull
    public final Executor e() {
        return this.f8508a;
    }

    @NotNull
    public final AtomicBoolean f() {
        return this.f8511d;
    }

    @NotNull
    public LiveData<T> h() {
        return this.f8510c;
    }

    public void j() {
        ArchTaskExecutor.h().b(this.f8514g);
    }

    @JvmOverloads
    public ComputableLiveData(@NotNull Executor executor) {
        Intrinsics.p(executor, "executor");
        this.f8508a = executor;
        ComputableLiveData$_liveData$1 computableLiveData$_liveData$1 = new ComputableLiveData$_liveData$1(this);
        this.f8509b = computableLiveData$_liveData$1;
        this.f8510c = computableLiveData$_liveData$1;
        this.f8511d = new AtomicBoolean(true);
        this.f8512e = new AtomicBoolean(false);
        this.f8513f = new a(this);
        this.f8514g = new b(this);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ComputableLiveData(java.util.concurrent.Executor r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x000d
            java.util.concurrent.Executor r1 = androidx.arch.core.executor.ArchTaskExecutor.g()
            java.lang.String r2 = "getIOThreadExecutor()"
            kotlin.jvm.internal.Intrinsics.o(r1, r2)
        L_0x000d:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ComputableLiveData.<init>(java.util.concurrent.Executor, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
