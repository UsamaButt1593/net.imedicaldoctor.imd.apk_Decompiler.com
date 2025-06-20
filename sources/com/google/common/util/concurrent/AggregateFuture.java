package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AggregateFuture<InputT, OutputT> extends AggregateFutureState<OutputT> {
    private static final Logger i3 = Logger.getLogger(AggregateFuture.class.getName());
    @CheckForNull
    private ImmutableCollection<? extends ListenableFuture<? extends InputT>> f3;
    private final boolean g3;
    private final boolean h3;

    enum ReleaseResourcesReason {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    AggregateFuture(ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z, boolean z2) {
        super(immutableCollection.size());
        this.f3 = (ImmutableCollection) Preconditions.E(immutableCollection);
        this.g3 = z;
        this.h3 = z2;
    }

    private static boolean O(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    private void Q(int i2, Future<? extends InputT> future) {
        Throwable e2;
        try {
            P(i2, Futures.j(future));
            return;
        } catch (ExecutionException e3) {
            e2 = e3.getCause();
        } catch (Error | RuntimeException e4) {
            e2 = e4;
        }
        T(e2);
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public void W(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        int K = K();
        Preconditions.h0(K >= 0, "Less than 0 remaining futures");
        if (K == 0) {
            Y(immutableCollection);
        }
    }

    private void T(Throwable th) {
        Preconditions.E(th);
        if (this.g3 && !C(th) && O(L(), th)) {
            X(th);
        } else if (th instanceof Error) {
            X(th);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(ListenableFuture listenableFuture, int i2) {
        try {
            if (listenableFuture.isCancelled()) {
                this.f3 = null;
                cancel(false);
            } else {
                Q(i2, listenableFuture);
            }
        } finally {
            W((ImmutableCollection) null);
        }
    }

    private static void X(Throwable th) {
        i3.log(Level.SEVERE, th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    private void Y(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        if (immutableCollection != null) {
            UnmodifiableIterator<? extends Future<? extends InputT>> k2 = immutableCollection.iterator();
            int i2 = 0;
            while (k2.hasNext()) {
                Future future = (Future) k2.next();
                if (!future.isCancelled()) {
                    Q(i2, future);
                }
                i2++;
            }
        }
        J();
        S();
        Z(ReleaseResourcesReason.ALL_INPUT_FUTURES_PROCESSED);
    }

    /* access modifiers changed from: package-private */
    public final void I(Set<Throwable> set) {
        Preconditions.E(set);
        if (!isCancelled()) {
            Throwable a2 = a();
            Objects.requireNonNull(a2);
            O(set, a2);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void P(int i2, @ParametricNullness InputT inputt);

    /* access modifiers changed from: package-private */
    public abstract void S();

    /* access modifiers changed from: package-private */
    public final void U() {
        Objects.requireNonNull(this.f3);
        if (this.f3.isEmpty()) {
            S();
        } else if (this.g3) {
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> k2 = this.f3.iterator();
            int i2 = 0;
            while (k2.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture) k2.next();
                listenableFuture.a0(new k(this, listenableFuture, i2), MoreExecutors.c());
                i2++;
            }
        } else {
            l lVar = new l(this, this.h3 ? this.f3 : null);
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> k3 = this.f3.iterator();
            while (k3.hasNext()) {
                ((ListenableFuture) k3.next()).a0(lVar, MoreExecutors.c());
            }
        }
    }

    /* access modifiers changed from: package-private */
    @ForOverride
    @OverridingMethodsMustInvokeSuper
    public void Z(ReleaseResourcesReason releaseResourcesReason) {
        Preconditions.E(releaseResourcesReason);
        this.f3 = null;
    }

    /* access modifiers changed from: protected */
    public final void m() {
        super.m();
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.f3;
        Z(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (immutableCollection != null)) {
            boolean E = E();
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> k2 = immutableCollection.iterator();
            while (k2.hasNext()) {
                ((Future) k2.next()).cancel(E);
            }
        }
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String y() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.f3;
        if (immutableCollection == null) {
            return super.y();
        }
        return "futures=" + immutableCollection;
    }
}
