package net.imedicaldoctor.imd.Fragments.UWorld;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.R;

public class CheckDialog extends DialogFragment {
    private ArrayList<Integer> F4;
    private RecyclerView G4;
    private TreeViewAdapter H4;
    private ArrayList<TreeItem> I4;
    private ArrayList<TreeItem> J4;
    private Map<String, Boolean> K4;

    private ArrayList<TreeItem> j3(ArrayList<Bundle> arrayList, String str, Set<Integer> set) {
        HashMap hashMap = new HashMap();
        ArrayList<TreeItem> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String string = arrayList.get(i2).getString(str);
            if (string.contains("(")) {
                String trim = string.substring(0, string.lastIndexOf(40)).trim();
                String substring = string.substring(string.lastIndexOf(40) + 1, string.lastIndexOf(41));
                TreeItem treeItem = (TreeItem) hashMap.get(trim);
                if (treeItem == null) {
                    treeItem = new TreeItem(trim, true, -1, false);
                    hashMap.put(trim, treeItem);
                    arrayList2.add(treeItem);
                }
                TreeItem treeItem2 = new TreeItem(substring, false, i2, true);
                if (set.contains(Integer.valueOf(i2))) {
                    treeItem2.f29953d = true;
                    treeItem.f29953d = true;
                }
                treeItem.f29957h.add(treeItem2);
            } else {
                TreeItem treeItem3 = new TreeItem(string, false, i2, false);
                if (set.contains(Integer.valueOf(i2))) {
                    treeItem3.f29953d = true;
                }
                arrayList2.add(treeItem3);
            }
        }
        if (!arrayList2.isEmpty() && arrayList2.get(0).f29950a.startsWith("All")) {
            TreeItem treeItem4 = arrayList2.get(0);
            if (set.isEmpty()) {
                treeItem4.f29953d = true;
                set.add(Integer.valueOf(treeItem4.f29956g));
            } else {
                treeItem4.f29953d = set.contains(Integer.valueOf(treeItem4.f29956g));
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x006a A[EDGE_INSN: B:53:0x006a->B:17:0x006a ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k3(java.lang.String r8) {
        /*
            r7 = this;
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r0 = r7.I4
            r0.clear()
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L_0x0014
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r8 = r7.I4
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r0 = r7.J4
            r8.addAll(r0)
            goto L_0x00ff
        L_0x0014:
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r0 = r7.J4
            java.util.Iterator r0 = r0.iterator()
        L_0x001a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00c9
            java.lang.Object r1 = r0.next()
            net.imedicaldoctor.imd.Fragments.UWorld.TreeItem r1 = (net.imedicaldoctor.imd.Fragments.UWorld.TreeItem) r1
            java.lang.String r2 = r1.f29950a
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r3 = r8.toLowerCase()
            boolean r2 = r2.contains(r3)
            r3 = 1
            if (r2 == 0) goto L_0x003d
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r2 = r7.I4
            r2.add(r1)
            goto L_0x006a
        L_0x003d:
            java.util.List<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r2 = r1.f29957h
            java.util.Iterator r2 = r2.iterator()
        L_0x0043:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x006a
            java.lang.Object r4 = r2.next()
            net.imedicaldoctor.imd.Fragments.UWorld.TreeItem r4 = (net.imedicaldoctor.imd.Fragments.UWorld.TreeItem) r4
            java.lang.String r5 = r4.f29950a
            java.lang.String r5 = r5.toLowerCase()
            java.lang.String r6 = r8.toLowerCase()
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x0063
            boolean r4 = r4.f29953d
            if (r4 == 0) goto L_0x0043
        L_0x0063:
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r2 = r7.I4
            r2.add(r1)
            r1.f29955f = r3
        L_0x006a:
            boolean r2 = r1.f29953d
            if (r2 == 0) goto L_0x007b
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r2 = r7.I4
            boolean r2 = r2.contains(r1)
            if (r2 != 0) goto L_0x007b
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r2 = r7.I4
            r2.add(r1)
        L_0x007b:
            java.util.List<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r2 = r1.f29957h
            java.util.Iterator r2 = r2.iterator()
        L_0x0081:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00a9
            java.lang.Object r4 = r2.next()
            net.imedicaldoctor.imd.Fragments.UWorld.TreeItem r4 = (net.imedicaldoctor.imd.Fragments.UWorld.TreeItem) r4
            boolean r5 = r4.f29953d
            if (r5 == 0) goto L_0x0081
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r5 = r7.I4
            boolean r4 = r5.contains(r4)
            if (r4 != 0) goto L_0x0081
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r4 = r7.I4
            boolean r4 = r4.contains(r1)
            if (r4 != 0) goto L_0x00a6
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r4 = r7.I4
            r4.add(r1)
        L_0x00a6:
            r1.f29955f = r3
            goto L_0x0081
        L_0x00a9:
            boolean r2 = r1.f29951b
            if (r2 == 0) goto L_0x001a
            java.util.Map<java.lang.String, java.lang.Boolean> r2 = r7.K4
            java.lang.String r3 = r1.f29950a
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x001a
            java.util.Map<java.lang.String, java.lang.Boolean> r2 = r7.K4
            java.lang.String r3 = r1.f29950a
            java.lang.Object r2 = r2.get(r3)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r1.f29955f = r2
            goto L_0x001a
        L_0x00c9:
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r8 = r7.J4
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x00ff
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r8 = r7.J4
            r0 = 0
            java.lang.Object r8 = r8.get(r0)
            net.imedicaldoctor.imd.Fragments.UWorld.TreeItem r8 = (net.imedicaldoctor.imd.Fragments.UWorld.TreeItem) r8
            java.lang.String r8 = r8.f29950a
            java.lang.String r1 = "All"
            boolean r8 = r8.startsWith(r1)
            if (r8 == 0) goto L_0x00ff
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r8 = r7.I4
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r1 = r7.J4
            java.lang.Object r1 = r1.get(r0)
            boolean r8 = r8.contains(r1)
            if (r8 != 0) goto L_0x00ff
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r8 = r7.I4
            java.util.ArrayList<net.imedicaldoctor.imd.Fragments.UWorld.TreeItem> r1 = r7.J4
            java.lang.Object r1 = r1.get(r0)
            net.imedicaldoctor.imd.Fragments.UWorld.TreeItem r1 = (net.imedicaldoctor.imd.Fragments.UWorld.TreeItem) r1
            r8.add(r0, r1)
        L_0x00ff:
            net.imedicaldoctor.imd.Fragments.UWorld.TreeViewAdapter r8 = r7.H4
            r8.G()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.UWorld.CheckDialog.k3(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m3(Set set, View view) {
        N2();
        this.F4.clear();
        this.F4.addAll(set);
        if (l0() instanceof UWMainActivityFragment) {
            ((UWMainActivityFragment) l0()).J3(y().getString("Type"), this.F4);
        }
    }

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1245fragment_new_check_viewer, (ViewGroup) null);
        this.G4 = (RecyclerView) inflate.findViewById(R.id.f1054recycler_view);
        SearchView searchView = (SearchView) inflate.findViewById(R.id.f1069search_view);
        ArrayList parcelableArrayList = y().getParcelableArrayList("Items");
        String string = y().getString("TitleProperty");
        this.F4 = y().containsKey("Positions") ? y().getIntegerArrayList("Positions") : new ArrayList<>();
        HashSet hashSet = new HashSet(this.F4);
        this.J4 = j3(parcelableArrayList, string, hashSet);
        this.K4 = new HashMap();
        Iterator<TreeItem> it2 = this.J4.iterator();
        while (it2.hasNext()) {
            TreeItem next = it2.next();
            if (next.f29951b) {
                this.K4.put(next.f29950a, Boolean.valueOf(next.f29955f));
            }
        }
        this.I4 = new ArrayList<>(this.J4);
        TreeViewAdapter treeViewAdapter = new TreeViewAdapter(r(), this.I4, hashSet);
        this.H4 = treeViewAdapter;
        this.G4.setAdapter(treeViewAdapter);
        this.G4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
        this.G4.p(new CustomItemDecoration(r()));
        ((SearchView.SearchAutoComplete) searchView.findViewById(R.id.search_src_text)).setTextColor(ViewCompat.y);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(String str) {
                CheckDialog.this.k3(str);
                return true;
            }

            public boolean b(String str) {
                return false;
            }
        });
        searchView.setOnClickListener(new a(searchView));
        searchView.requestFocus();
        ((Button) inflate.findViewById(R.id.f918done_button)).setOnClickListener(new b(this, hashSet));
        builder.setView(inflate);
        return builder.create();
    }
}
