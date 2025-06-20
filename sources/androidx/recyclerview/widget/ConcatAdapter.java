package androidx.recyclerview.widget;

import android.util.Pair;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: e  reason: collision with root package name */
    static final String f15264e = "ConcatAdapter";

    /* renamed from: d  reason: collision with root package name */
    private final ConcatAdapterController f15265d;

    public static final class Config {
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public static final Config f15266c = new Config(true, StableIdMode.NO_STABLE_IDS);

        /* renamed from: a  reason: collision with root package name */
        public final boolean f15267a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final StableIdMode f15268b;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private boolean f15269a;

            /* renamed from: b  reason: collision with root package name */
            private StableIdMode f15270b;

            public Builder() {
                Config config = Config.f15266c;
                this.f15269a = config.f15267a;
                this.f15270b = config.f15268b;
            }

            @NonNull
            public Config a() {
                return new Config(this.f15269a, this.f15270b);
            }

            @NonNull
            public Builder b(boolean z) {
                this.f15269a = z;
                return this;
            }

            @NonNull
            public Builder c(@NonNull StableIdMode stableIdMode) {
                this.f15270b = stableIdMode;
                return this;
            }
        }

        public enum StableIdMode {
            NO_STABLE_IDS,
            ISOLATED_STABLE_IDS,
            SHARED_STABLE_IDS
        }

        Config(boolean z, @NonNull StableIdMode stableIdMode) {
            this.f15267a = z;
            this.f15268b = stableIdMode;
        }
    }

    public ConcatAdapter(@NonNull Config config, @NonNull List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> list) {
        this.f15265d = new ConcatAdapterController(this, config);
        for (RecyclerView.Adapter e0 : list) {
            e0(e0);
        }
        super.a0(this.f15265d.x());
    }

    public int A(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter, @NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        return this.f15265d.t(adapter, viewHolder, i2);
    }

    public long B(int i2) {
        return this.f15265d.r(i2);
    }

    public int C(int i2) {
        return this.f15265d.s(i2);
    }

    public void Q(@NonNull RecyclerView recyclerView) {
        this.f15265d.A(recyclerView);
    }

    public void R(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        this.f15265d.B(viewHolder, i2);
    }

    @NonNull
    public RecyclerView.ViewHolder T(@NonNull ViewGroup viewGroup, int i2) {
        return this.f15265d.C(viewGroup, i2);
    }

    public void U(@NonNull RecyclerView recyclerView) {
        this.f15265d.D(recyclerView);
    }

    public boolean V(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.f15265d.E(viewHolder);
    }

    public void W(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f15265d.F(viewHolder);
    }

    public void X(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f15265d.G(viewHolder);
    }

    public void Y(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f15265d.H(viewHolder);
    }

    public void a0(boolean z) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    public int b() {
        return this.f15265d.u();
    }

    public void b0(@NonNull RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }

    public boolean d0(int i2, @NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        return this.f15265d.h(i2, adapter);
    }

    public boolean e0(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        return this.f15265d.i(adapter);
    }

    @NonNull
    public List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> f0() {
        return Collections.unmodifiableList(this.f15265d.q());
    }

    @NonNull
    public Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> g0(int i2) {
        return this.f15265d.v(i2);
    }

    /* access modifiers changed from: package-private */
    public void h0(@NonNull RecyclerView.Adapter.StateRestorationPolicy stateRestorationPolicy) {
        super.b0(stateRestorationPolicy);
    }

    public boolean i0(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        return this.f15265d.J(adapter);
    }

    @SafeVarargs
    public ConcatAdapter(@NonNull Config config, @NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... adapterArr) {
        this(config, (List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>>) Arrays.asList(adapterArr));
    }

    public ConcatAdapter(@NonNull List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> list) {
        this(Config.f15266c, list);
    }

    @SafeVarargs
    public ConcatAdapter(@NonNull RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... adapterArr) {
        this(Config.f15266c, adapterArr);
    }
}
