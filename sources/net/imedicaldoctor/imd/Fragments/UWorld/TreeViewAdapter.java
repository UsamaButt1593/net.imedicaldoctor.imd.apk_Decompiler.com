package net.imedicaldoctor.imd.Fragments.UWorld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import net.imedicaldoctor.imd.R;

public class TreeViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: d  reason: collision with root package name */
    private Context f29958d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<TreeItem> f29959e;

    /* renamed from: f  reason: collision with root package name */
    private Set<Integer> f29960f;

    static class ChildViewHolder extends RecyclerView.ViewHolder {
        TextView I;
        CheckBox J;

        ChildViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.title);
            this.J = (CheckBox) view.findViewById(R.id.checkbox);
        }
    }

    static class GroupViewHolder extends RecyclerView.ViewHolder {
        TextView I;
        CheckBox J;
        ImageView K;

        GroupViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.title);
            this.J = (CheckBox) view.findViewById(R.id.checkbox);
            this.K = (ImageView) view.findViewById(R.id.f932expand_collapse_icon);
        }
    }

    public TreeViewAdapter(Context context, ArrayList<TreeItem> arrayList, Set<Integer> set) {
        this.f29958d = context;
        this.f29959e = arrayList;
        this.f29960f = set;
        j0();
    }

    private TreeItem i0(TreeItem treeItem) {
        Iterator<TreeItem> it2 = this.f29959e.iterator();
        while (it2.hasNext()) {
            TreeItem next = it2.next();
            if (next.f29951b && next.f29957h.contains(treeItem)) {
                return next;
            }
        }
        return null;
    }

    private void j0() {
        if (!this.f29959e.isEmpty() && this.f29959e.get(0).f29950a.startsWith("All")) {
            TreeItem treeItem = this.f29959e.get(0);
            if (this.f29960f.isEmpty()) {
                treeItem.f29953d = true;
                this.f29960f.add(Integer.valueOf(treeItem.f29956g));
            } else if (this.f29960f.size() != 1 || !this.f29960f.contains(Integer.valueOf(treeItem.f29956g))) {
                treeItem.f29953d = false;
                this.f29960f.remove(Integer.valueOf(treeItem.f29956g));
            } else {
                treeItem.f29953d = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(TreeItem treeItem, View view) {
        r0(treeItem);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(TreeItem treeItem, View view) {
        if (treeItem.f29957h.isEmpty()) {
            p0(treeItem);
        } else {
            q0(treeItem);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(TreeItem treeItem, View view) {
        q0(treeItem);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(TreeItem treeItem, View view) {
        p0(treeItem);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o0(TreeItem treeItem, View view) {
        p0(treeItem);
    }

    private void p0(TreeItem treeItem) {
        if (treeItem.f29956g != 0 || !treeItem.f29950a.startsWith("All")) {
            boolean z = !treeItem.f29953d;
            treeItem.f29953d = z;
            if (z) {
                this.f29960f.add(Integer.valueOf(treeItem.f29956g));
                if (!this.f29959e.isEmpty() && this.f29959e.get(0).f29950a.startsWith("All")) {
                    TreeItem treeItem2 = this.f29959e.get(0);
                    treeItem2.f29953d = false;
                    this.f29960f.remove(Integer.valueOf(treeItem2.f29956g));
                }
                u0(treeItem);
                G();
                j0();
            }
        } else {
            boolean z2 = !treeItem.f29953d;
            treeItem.f29953d = z2;
            if (z2) {
                this.f29960f.clear();
                this.f29960f.add(Integer.valueOf(treeItem.f29956g));
                Iterator<TreeItem> it2 = this.f29959e.iterator();
                while (it2.hasNext()) {
                    TreeItem next = it2.next();
                    if (next.f29956g != 0) {
                        next.f29953d = false;
                    }
                    if (next.f29951b) {
                        for (TreeItem treeItem3 : next.f29957h) {
                            treeItem3.f29953d = false;
                        }
                    }
                }
                u0(treeItem);
                G();
                j0();
            }
        }
        this.f29960f.remove(Integer.valueOf(treeItem.f29956g));
        u0(treeItem);
        G();
        j0();
    }

    private void q0(TreeItem treeItem) {
        boolean z = !treeItem.f29955f;
        treeItem.f29955f = z;
        if (z) {
            ArrayList<TreeItem> arrayList = this.f29959e;
            arrayList.addAll(arrayList.indexOf(treeItem) + 1, treeItem.f29957h);
        } else {
            this.f29959e.removeAll(treeItem.f29957h);
        }
        G();
    }

    private void r0(TreeItem treeItem) {
        boolean z = !treeItem.f29953d;
        if (treeItem.f29957h.isEmpty()) {
            p0(treeItem);
            return;
        }
        treeItem.f29953d = z;
        treeItem.f29954e = false;
        for (TreeItem next : treeItem.f29957h) {
            next.f29953d = z;
            Set<Integer> set = this.f29960f;
            Integer valueOf = Integer.valueOf(next.f29956g);
            if (z) {
                set.add(valueOf);
            } else {
                set.remove(valueOf);
            }
        }
        G();
        j0();
    }

    private void s0(CheckBox checkBox, TreeItem treeItem) {
        Context context;
        int i2;
        if (treeItem.f29954e) {
            context = this.f29958d;
            i2 = R.drawable.f615checkbox_partial;
        } else if (treeItem.f29953d) {
            context = this.f29958d;
            i2 = R.drawable.f614checkbox_checked;
        } else {
            context = this.f29958d;
            i2 = R.drawable.f616checkbox_unchecked;
        }
        checkBox.setButtonDrawable(ContextCompat.l(context, i2));
    }

    private void t0(TreeItem treeItem) {
        if (treeItem != null && treeItem.f29957h.size() > 0) {
            boolean z = true;
            boolean z2 = true;
            for (TreeItem treeItem2 : treeItem.f29957h) {
                if (treeItem2.f29953d) {
                    z2 = false;
                } else {
                    z = false;
                }
            }
            if (z) {
                treeItem.f29953d = true;
            } else {
                treeItem.f29953d = false;
                if (!z2) {
                    treeItem.f29954e = true;
                    return;
                }
            }
            treeItem.f29954e = false;
        }
    }

    private void u0(TreeItem treeItem) {
        TreeItem i0 = i0(treeItem);
        if (i0 != null) {
            boolean z = true;
            boolean z2 = true;
            for (TreeItem treeItem2 : i0.f29957h) {
                if (treeItem2.f29953d) {
                    z2 = false;
                } else {
                    z = false;
                }
            }
            if (z) {
                i0.f29953d = true;
            } else {
                i0.f29953d = false;
                if (!z2) {
                    i0.f29954e = true;
                    return;
                }
            }
            i0.f29954e = false;
        }
    }

    public int C(int i2) {
        return this.f29959e.get(i2).f29952c ? 1 : 0;
    }

    public void R(RecyclerView.ViewHolder viewHolder, int i2) {
        View view;
        View.OnClickListener gVar;
        TreeItem treeItem = this.f29959e.get(i2);
        if (!treeItem.f29952c) {
            t0(treeItem);
            GroupViewHolder groupViewHolder = (GroupViewHolder) viewHolder;
            groupViewHolder.I.setText(treeItem.f29950a);
            s0(groupViewHolder.J, treeItem);
            groupViewHolder.J.setOnClickListener(new c(this, treeItem));
            groupViewHolder.f15587a.setOnClickListener(new d(this, treeItem));
            groupViewHolder.K.setImageResource(treeItem.f29955f ? R.drawable.f651ic_collapse : R.drawable.f654ic_expand);
            groupViewHolder.K.setVisibility(treeItem.f29951b ? 0 : 8);
            view = groupViewHolder.K;
            gVar = new e(this, treeItem);
        } else {
            ChildViewHolder childViewHolder = (ChildViewHolder) viewHolder;
            childViewHolder.I.setText(treeItem.f29950a);
            s0(childViewHolder.J, treeItem);
            childViewHolder.J.setOnClickListener(new f(this, treeItem));
            view = childViewHolder.f15587a;
            gVar = new g(this, treeItem);
        }
        view.setOnClickListener(gVar);
    }

    public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
        return i2 == 0 ? new GroupViewHolder(LayoutInflater.from(this.f29958d).inflate(R.layout.f1406treeview_group_item, viewGroup, false)) : new ChildViewHolder(LayoutInflater.from(this.f29958d).inflate(R.layout.f1405treeview_child_item, viewGroup, false));
    }

    public int b() {
        return this.f29959e.size();
    }
}
