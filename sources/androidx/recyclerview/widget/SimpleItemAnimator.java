package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SimpleItemAnimator extends RecyclerView.ItemAnimator {

    /* renamed from: m  reason: collision with root package name */
    private static final boolean f15605m = false;

    /* renamed from: n  reason: collision with root package name */
    private static final String f15606n = "SimpleItemAnimator";

    /* renamed from: l  reason: collision with root package name */
    boolean f15607l = true;

    @SuppressLint({"UnknownNullness"})
    public abstract boolean D(RecyclerView.ViewHolder viewHolder);

    @SuppressLint({"UnknownNullness"})
    public abstract boolean E(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5);

    @SuppressLint({"UnknownNullness"})
    public abstract boolean F(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5);

    @SuppressLint({"UnknownNullness"})
    public abstract boolean G(RecyclerView.ViewHolder viewHolder);

    @SuppressLint({"UnknownNullness"})
    public final void H(RecyclerView.ViewHolder viewHolder) {
        Q(viewHolder);
        h(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void I(RecyclerView.ViewHolder viewHolder) {
        R(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void J(RecyclerView.ViewHolder viewHolder, boolean z) {
        S(viewHolder, z);
        h(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void K(RecyclerView.ViewHolder viewHolder, boolean z) {
        T(viewHolder, z);
    }

    @SuppressLint({"UnknownNullness"})
    public final void L(RecyclerView.ViewHolder viewHolder) {
        U(viewHolder);
        h(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void M(RecyclerView.ViewHolder viewHolder) {
        V(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void N(RecyclerView.ViewHolder viewHolder) {
        W(viewHolder);
        h(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public final void O(RecyclerView.ViewHolder viewHolder) {
        X(viewHolder);
    }

    public boolean P() {
        return this.f15607l;
    }

    @SuppressLint({"UnknownNullness"})
    public void Q(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void R(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void S(RecyclerView.ViewHolder viewHolder, boolean z) {
    }

    @SuppressLint({"UnknownNullness"})
    public void T(RecyclerView.ViewHolder viewHolder, boolean z) {
    }

    @SuppressLint({"UnknownNullness"})
    public void U(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void V(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void W(RecyclerView.ViewHolder viewHolder) {
    }

    @SuppressLint({"UnknownNullness"})
    public void X(RecyclerView.ViewHolder viewHolder) {
    }

    public void Y(boolean z) {
        this.f15607l = z;
    }

    public boolean a(@NonNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i2;
        int i3;
        if (itemHolderInfo == null || ((i2 = itemHolderInfo.f15508a) == (i3 = itemHolderInfo2.f15508a) && itemHolderInfo.f15509b == itemHolderInfo2.f15509b)) {
            return D(viewHolder);
        }
        return F(viewHolder, i2, itemHolderInfo.f15509b, i3, itemHolderInfo2.f15509b);
    }

    public boolean b(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i2;
        int i3;
        int i4 = itemHolderInfo.f15508a;
        int i5 = itemHolderInfo.f15509b;
        if (viewHolder2.e0()) {
            int i6 = itemHolderInfo.f15508a;
            i2 = itemHolderInfo.f15509b;
            i3 = i6;
        } else {
            i3 = itemHolderInfo2.f15508a;
            i2 = itemHolderInfo2.f15509b;
        }
        return E(viewHolder, viewHolder2, i4, i5, i3, i2);
    }

    public boolean c(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i2 = itemHolderInfo.f15508a;
        int i3 = itemHolderInfo.f15509b;
        View view = viewHolder.f15587a;
        int left = itemHolderInfo2 == null ? view.getLeft() : itemHolderInfo2.f15508a;
        int top = itemHolderInfo2 == null ? view.getTop() : itemHolderInfo2.f15509b;
        if (viewHolder.Q() || (i2 == left && i3 == top)) {
            return G(viewHolder);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return F(viewHolder, i2, i3, left, top);
    }

    public boolean d(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i2 = itemHolderInfo.f15508a;
        int i3 = itemHolderInfo2.f15508a;
        if (i2 == i3 && itemHolderInfo.f15509b == itemHolderInfo2.f15509b) {
            L(viewHolder);
            return false;
        }
        return F(viewHolder, i2, itemHolderInfo.f15509b, i3, itemHolderInfo2.f15509b);
    }

    public boolean f(@NonNull RecyclerView.ViewHolder viewHolder) {
        return !this.f15607l || viewHolder.O();
    }
}
