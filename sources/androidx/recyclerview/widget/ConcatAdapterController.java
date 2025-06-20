package androidx.recyclerview.widget;

import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.ViewTypeStorage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

class ConcatAdapterController implements NestedAdapterWrapper.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final ConcatAdapter f15271a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewTypeStorage f15272b;

    /* renamed from: c  reason: collision with root package name */
    private List<WeakReference<RecyclerView>> f15273c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final IdentityHashMap<RecyclerView.ViewHolder, NestedAdapterWrapper> f15274d = new IdentityHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private List<NestedAdapterWrapper> f15275e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private WrapperAndLocalPosition f15276f = new WrapperAndLocalPosition();
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ConcatAdapter.Config.StableIdMode f15277g;

    /* renamed from: h  reason: collision with root package name */
    private final StableIdStorage f15278h;

    static class WrapperAndLocalPosition {

        /* renamed from: a  reason: collision with root package name */
        NestedAdapterWrapper f15279a;

        /* renamed from: b  reason: collision with root package name */
        int f15280b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15281c;

        WrapperAndLocalPosition() {
        }
    }

    ConcatAdapterController(ConcatAdapter concatAdapter, ConcatAdapter.Config config) {
        StableIdStorage sharedPoolStableIdStorage;
        this.f15271a = concatAdapter;
        this.f15272b = config.f15267a ? new ViewTypeStorage.IsolatedViewTypeStorage() : new ViewTypeStorage.SharedIdRangeViewTypeStorage();
        ConcatAdapter.Config.StableIdMode stableIdMode = config.f15268b;
        this.f15277g = stableIdMode;
        if (stableIdMode == ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            sharedPoolStableIdStorage = new StableIdStorage.NoStableIdStorage();
        } else if (stableIdMode == ConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) {
            sharedPoolStableIdStorage = new StableIdStorage.IsolatedStableIdStorage();
        } else if (stableIdMode == ConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) {
            sharedPoolStableIdStorage = new StableIdStorage.SharedPoolStableIdStorage();
        } else {
            throw new IllegalArgumentException("unknown stable id mode");
        }
        this.f15278h = sharedPoolStableIdStorage;
    }

    private void I(WrapperAndLocalPosition wrapperAndLocalPosition) {
        wrapperAndLocalPosition.f15281c = false;
        wrapperAndLocalPosition.f15279a = null;
        wrapperAndLocalPosition.f15280b = -1;
        this.f15276f = wrapperAndLocalPosition;
    }

    private void j() {
        RecyclerView.Adapter.StateRestorationPolicy l2 = l();
        if (l2 != this.f15271a.D()) {
            this.f15271a.h0(l2);
        }
    }

    private RecyclerView.Adapter.StateRestorationPolicy l() {
        for (NestedAdapterWrapper next : this.f15275e) {
            RecyclerView.Adapter.StateRestorationPolicy D = next.f15471c.D();
            RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT;
            if (D == stateRestorationPolicy) {
                return stateRestorationPolicy;
            }
            if (D == RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY && next.b() == 0) {
                return stateRestorationPolicy;
            }
        }
        return RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
    }

    private int m(NestedAdapterWrapper nestedAdapterWrapper) {
        NestedAdapterWrapper next;
        Iterator<NestedAdapterWrapper> it2 = this.f15275e.iterator();
        int i2 = 0;
        while (it2.hasNext() && (next = it2.next()) != nestedAdapterWrapper) {
            i2 += next.b();
        }
        return i2;
    }

    @NonNull
    private WrapperAndLocalPosition n(int i2) {
        WrapperAndLocalPosition wrapperAndLocalPosition = this.f15276f;
        if (wrapperAndLocalPosition.f15281c) {
            wrapperAndLocalPosition = new WrapperAndLocalPosition();
        } else {
            wrapperAndLocalPosition.f15281c = true;
        }
        Iterator<NestedAdapterWrapper> it2 = this.f15275e.iterator();
        int i3 = i2;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            NestedAdapterWrapper next = it2.next();
            if (next.b() > i3) {
                wrapperAndLocalPosition.f15279a = next;
                wrapperAndLocalPosition.f15280b = i3;
                break;
            }
            i3 -= next.b();
        }
        if (wrapperAndLocalPosition.f15279a != null) {
            return wrapperAndLocalPosition;
        }
        throw new IllegalArgumentException("Cannot find wrapper for " + i2);
    }

    @Nullable
    private NestedAdapterWrapper o(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int y = y(adapter);
        if (y == -1) {
            return null;
        }
        return this.f15275e.get(y);
    }

    @NonNull
    private NestedAdapterWrapper w(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.f15274d.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            return nestedAdapterWrapper;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    private int y(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int size = this.f15275e.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f15275e.get(i2).f15471c == adapter) {
                return i2;
            }
        }
        return -1;
    }

    private boolean z(RecyclerView recyclerView) {
        for (WeakReference<RecyclerView> weakReference : this.f15273c) {
            if (weakReference.get() == recyclerView) {
                return true;
            }
        }
        return false;
    }

    public void A(RecyclerView recyclerView) {
        if (!z(recyclerView)) {
            this.f15273c.add(new WeakReference(recyclerView));
            for (NestedAdapterWrapper nestedAdapterWrapper : this.f15275e) {
                nestedAdapterWrapper.f15471c.Q(recyclerView);
            }
        }
    }

    public void B(RecyclerView.ViewHolder viewHolder, int i2) {
        WrapperAndLocalPosition n2 = n(i2);
        this.f15274d.put(viewHolder, n2.f15279a);
        n2.f15279a.e(viewHolder, n2.f15280b);
        I(n2);
    }

    public RecyclerView.ViewHolder C(ViewGroup viewGroup, int i2) {
        return this.f15272b.a(i2).f(viewGroup, i2);
    }

    public void D(RecyclerView recyclerView) {
        int size = this.f15273c.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            WeakReference weakReference = this.f15273c.get(size);
            if (weakReference.get() == null) {
                this.f15273c.remove(size);
            } else if (weakReference.get() == recyclerView) {
                this.f15273c.remove(size);
                break;
            }
            size--;
        }
        for (NestedAdapterWrapper nestedAdapterWrapper : this.f15275e) {
            nestedAdapterWrapper.f15471c.U(recyclerView);
        }
    }

    public boolean E(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.f15274d.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            boolean V = nestedAdapterWrapper.f15471c.V(viewHolder);
            this.f15274d.remove(viewHolder);
            return V;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    public void F(RecyclerView.ViewHolder viewHolder) {
        w(viewHolder).f15471c.W(viewHolder);
    }

    public void G(RecyclerView.ViewHolder viewHolder) {
        w(viewHolder).f15471c.X(viewHolder);
    }

    public void H(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.f15274d.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            nestedAdapterWrapper.f15471c.Y(viewHolder);
            this.f15274d.remove(viewHolder);
            return;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    /* access modifiers changed from: package-private */
    public boolean J(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int y = y(adapter);
        if (y == -1) {
            return false;
        }
        NestedAdapterWrapper nestedAdapterWrapper = this.f15275e.get(y);
        int m2 = m(nestedAdapterWrapper);
        this.f15275e.remove(y);
        this.f15271a.O(m2, nestedAdapterWrapper.b());
        for (WeakReference<RecyclerView> weakReference : this.f15273c) {
            RecyclerView recyclerView = (RecyclerView) weakReference.get();
            if (recyclerView != null) {
                adapter.U(recyclerView);
            }
        }
        nestedAdapterWrapper.a();
        j();
        return true;
    }

    public void a(NestedAdapterWrapper nestedAdapterWrapper) {
        j();
    }

    public void b(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3, @Nullable Object obj) {
        this.f15271a.M(i2 + m(nestedAdapterWrapper), i3, obj);
    }

    public void c(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3) {
        this.f15271a.L(i2 + m(nestedAdapterWrapper), i3);
    }

    public void d(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3) {
        this.f15271a.N(i2 + m(nestedAdapterWrapper), i3);
    }

    public void e(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3) {
        int m2 = m(nestedAdapterWrapper);
        this.f15271a.K(i2 + m2, i3 + m2);
    }

    public void f(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
        this.f15271a.G();
        j();
    }

    public void g(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i2, int i3) {
        this.f15271a.O(i2 + m(nestedAdapterWrapper), i3);
    }

    /* access modifiers changed from: package-private */
    public boolean h(int i2, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        if (i2 < 0 || i2 > this.f15275e.size()) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + this.f15275e.size() + ". Given:" + i2);
        }
        if (x()) {
            Preconditions.b(adapter.F(), "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
        } else if (adapter.F()) {
            Log.w("ConcatAdapter", "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
        }
        if (o(adapter) != null) {
            return false;
        }
        NestedAdapterWrapper nestedAdapterWrapper = new NestedAdapterWrapper(adapter, this, this.f15272b, this.f15278h.a());
        this.f15275e.add(i2, nestedAdapterWrapper);
        for (WeakReference<RecyclerView> weakReference : this.f15273c) {
            RecyclerView recyclerView = (RecyclerView) weakReference.get();
            if (recyclerView != null) {
                adapter.Q(recyclerView);
            }
        }
        if (nestedAdapterWrapper.b() > 0) {
            this.f15271a.N(m(nestedAdapterWrapper), nestedAdapterWrapper.b());
        }
        j();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean i(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        return h(this.f15275e.size(), adapter);
    }

    public boolean k() {
        for (NestedAdapterWrapper nestedAdapterWrapper : this.f15275e) {
            if (!nestedAdapterWrapper.f15471c.y()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> p(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.f15274d.get(viewHolder);
        if (nestedAdapterWrapper == null) {
            return null;
        }
        return nestedAdapterWrapper.f15471c;
    }

    public List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> q() {
        if (this.f15275e.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f15275e.size());
        for (NestedAdapterWrapper nestedAdapterWrapper : this.f15275e) {
            arrayList.add(nestedAdapterWrapper.f15471c);
        }
        return arrayList;
    }

    public long r(int i2) {
        WrapperAndLocalPosition n2 = n(i2);
        long c2 = n2.f15279a.c(n2.f15280b);
        I(n2);
        return c2;
    }

    public int s(int i2) {
        WrapperAndLocalPosition n2 = n(i2);
        int d2 = n2.f15279a.d(n2.f15280b);
        I(n2);
        return d2;
    }

    public int t(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter, RecyclerView.ViewHolder viewHolder, int i2) {
        NestedAdapterWrapper nestedAdapterWrapper = this.f15274d.get(viewHolder);
        if (nestedAdapterWrapper == null) {
            return -1;
        }
        int m2 = i2 - m(nestedAdapterWrapper);
        int b2 = nestedAdapterWrapper.f15471c.b();
        if (m2 >= 0 && m2 < b2) {
            return nestedAdapterWrapper.f15471c.A(adapter, viewHolder, m2);
        }
        throw new IllegalStateException("Detected inconsistent adapter updates. The local position of the view holder maps to " + m2 + " which is out of bounds for the adapter with size " + b2 + ".Make sure to immediately call notify methods in your adapter when you change the backing dataviewHolder:" + viewHolder + "adapter:" + adapter);
    }

    public int u() {
        int i2 = 0;
        for (NestedAdapterWrapper b2 : this.f15275e) {
            i2 += b2.b();
        }
        return i2;
    }

    public Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> v(int i2) {
        WrapperAndLocalPosition n2 = n(i2);
        Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> pair = new Pair<>(n2.f15279a.f15471c, Integer.valueOf(n2.f15280b));
        I(n2);
        return pair;
    }

    public boolean x() {
        return this.f15277g != ConcatAdapter.Config.StableIdMode.NO_STABLE_IDS;
    }
}
