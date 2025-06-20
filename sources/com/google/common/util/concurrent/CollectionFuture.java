package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {
    @CheckForNull
    private List<Present<V>> j3;

    static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
        ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
            super(immutableCollection, z);
            U();
        }

        /* renamed from: c0 */
        public List<V> b0(List<Present<V>> list) {
            ArrayList u = Lists.u(list.size());
            Iterator<Present<V>> it2 = list.iterator();
            while (it2.hasNext()) {
                Present next = it2.next();
                u.add(next != null ? next.f23156a : null);
            }
            return Collections.unmodifiableList(u);
        }
    }

    private static final class Present<V> {
        @ParametricNullness

        /* renamed from: a  reason: collision with root package name */
        final V f23156a;

        Present(@ParametricNullness V v) {
            this.f23156a = v;
        }
    }

    CollectionFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
        super(immutableCollection, z, true);
        List<Present<V>> emptyList = immutableCollection.isEmpty() ? Collections.emptyList() : Lists.u(immutableCollection.size());
        for (int i2 = 0; i2 < immutableCollection.size(); i2++) {
            emptyList.add((Object) null);
        }
        this.j3 = emptyList;
    }

    /* access modifiers changed from: package-private */
    public final void P(int i2, @ParametricNullness V v) {
        List<Present<V>> list = this.j3;
        if (list != null) {
            list.set(i2, new Present(v));
        }
    }

    /* access modifiers changed from: package-private */
    public final void S() {
        List<Present<V>> list = this.j3;
        if (list != null) {
            B(b0(list));
        }
    }

    /* access modifiers changed from: package-private */
    public void Z(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.Z(releaseResourcesReason);
        this.j3 = null;
    }

    /* access modifiers changed from: package-private */
    public abstract C b0(List<Present<V>> list);
}
