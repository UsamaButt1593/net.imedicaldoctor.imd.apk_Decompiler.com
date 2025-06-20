package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;

public class EPOIDListActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;

    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.recyclerview.widget.RecyclerView$Adapter] */
    /* JADX WARNING: type inference failed for: r0v23, types: [net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDListActivityFragment$3] */
    /* JADX WARNING: type inference failed for: r0v24, types: [net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDListActivityFragment$2] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View U0(android.view.LayoutInflater r9, android.view.ViewGroup r10, android.os.Bundle r11) {
        /*
            r8 = this;
            r0 = 2131558538(0x7f0d008a, float:1.8742395E38)
            r6 = 0
            android.view.View r0 = r9.inflate(r0, r10, r6)
            r8.q4 = r0
            r8.W2(r11)
            r8.S2()
            android.view.View r0 = r8.q4
            r1 = 2131362540(0x7f0a02ec, float:1.8344863E38)
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.SearchView r0 = (androidx.appcompat.widget.SearchView) r0
            r8.s4 = r0
            r8.Q2()
            android.view.View r0 = r8.q4
            r1 = 2131362493(0x7f0a02bd, float:1.8344768E38)
            android.view.View r0 = r0.findViewById(r1)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r8.w4 = r0
            android.view.View r0 = r8.q4
            r1 = 2131361934(0x7f0a008e, float:1.8343634E38)
            android.view.View r0 = r0.findViewById(r1)
            com.google.android.material.appbar.AppBarLayout r0 = (com.google.android.material.appbar.AppBarLayout) r0
            android.view.View r1 = r8.q4
            r2 = 2131361947(0x7f0a009b, float:1.834366E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            android.os.Bundle r2 = r8.y()
            r3 = 1
            if (r2 == 0) goto L_0x006e
            android.os.Bundle r2 = r8.y()
            java.lang.String r4 = "ParentId"
            boolean r2 = r2.containsKey(r4)
            if (r2 == 0) goto L_0x006e
            android.os.Bundle r2 = r8.y()
            java.lang.String r2 = r2.getString(r4)
            r8.B4 = r2
            r0.D(r6, r6)
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDListActivityFragment$1 r2 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDListActivityFragment$1
            r2.<init>(r1)
            r4 = 800(0x320, double:3.953E-321)
            r0.postDelayed(r2, r4)
            goto L_0x0077
        L_0x006e:
            r2 = 0
            r8.B4 = r2
            r0.D(r3, r6)
            r1.setVisibility(r6)
        L_0x0077:
            java.lang.String r0 = r8.B4
            if (r0 != 0) goto L_0x009c
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r8.k4
            android.os.Bundle r1 = r8.h4
            java.lang.String r2 = "Select * from id_locations"
            java.util.ArrayList r0 = r0.V(r1, r2)
            r8.n4 = r0
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDListActivityFragment$2 r7 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDListActivityFragment$2
            androidx.fragment.app.FragmentActivity r2 = r8.r()
            java.util.ArrayList<android.os.Bundle> r3 = r8.n4
            java.lang.String r4 = "title"
            r5 = 2131558638(0x7f0d00ee, float:1.8742597E38)
            r0 = r7
            r1 = r8
            r0.<init>(r2, r3, r4, r5)
        L_0x0099:
            r8.l4 = r7
            goto L_0x00f3
        L_0x009c:
            java.lang.String r1 = ",,,,,"
            java.lang.String[] r0 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r0, r1)
            r1 = r0[r6]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r1.intValue()
            int r1 = r1 + r3
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0 = r0[r3]
            net.imedicaldoctor.imd.Data.CompressHelper r2 = r8.k4
            android.os.Bundle r3 = r8.h4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "select * from id_cats_indications inner join id_indications on id_indications.id=id_cats_indications.indicationId where id_indications.source="
            r4.append(r5)
            r4.append(r1)
            java.lang.String r5 = " and id_cats_indications.source="
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = " and catId="
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.util.ArrayList r0 = r2.V(r3, r0)
            r8.n4 = r0
            java.util.ArrayList r3 = r8.j3(r0)
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDListActivityFragment$3 r7 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDListActivityFragment$3
            androidx.fragment.app.FragmentActivity r2 = r8.r()
            java.lang.String r4 = "title"
            r5 = 2131558638(0x7f0d00ee, float:1.8742597E38)
            r0 = r7
            r1 = r8
            r0.<init>(r2, r3, r4, r5)
            goto L_0x0099
        L_0x00f3:
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDListActivityFragment$4 r7 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDListActivityFragment$4
            androidx.fragment.app.FragmentActivity r2 = r8.r()
            java.util.ArrayList<android.os.Bundle> r3 = r8.o4
            java.lang.String r4 = "text"
            r5 = 0
            r0 = r7
            r1 = r8
            r0.<init>(r2, r3, r4, r5)
            r8.A4 = r7
            androidx.recyclerview.widget.RecyclerView r0 = r8.w4
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r8.l4
            r0.setAdapter(r1)
            r8.N2()
            r8.o2(r6)
            android.view.View r0 = r8.q4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDListActivityFragment.U0(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void X2() {
        this.A4.i0(this.o4, this.p4);
        this.w4.setAdapter(this.A4);
    }

    public ArrayList<Bundle> a3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select * from search where search match 'text:" + str + "* AND typeText:ID AND type:1'");
    }

    public void c3() {
        this.t4.setImageDrawable(b0().getDrawable(R.drawable.f658id_tx_icon));
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }

    public String h3() {
        return "Infectious Disease Treatment";
    }

    public void i3(Bundle bundle, int i2) {
        V2();
        String string = bundle.getString("type");
        if (string.equals(ExifInterface.Y4)) {
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("DB", this.h4);
            bundle2.putString("ParentId", bundle.getString("source") + ",,,,," + bundle.getString("id2"));
            this.k4.N(EPOIDListActivity.class, EPOIDListActivityFragment.class, bundle2);
        } else if (string.equals(ExifInterface.Z4)) {
            CompressHelper compressHelper = this.k4;
            Bundle bundle3 = this.h4;
            compressHelper.A1(bundle3, "id-" + bundle.getString("id2"), (String[]) null, (String) null);
        }
    }

    public ArrayList<Bundle> j3(ArrayList<Bundle> arrayList) {
        ArrayList<Bundle> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        Iterator<Bundle> it2 = arrayList.iterator();
        String str = "";
        while (it2.hasNext()) {
            Bundle next = it2.next();
            String string = next.getString("type");
            String string2 = next.getString("title");
            if (string.equals(IcyHeaders.a3)) {
                arrayList3 = new ArrayList();
                str = string2;
            } else if (string.equals("0")) {
                Bundle bundle = new Bundle();
                bundle.putString("title", str);
                bundle.putParcelableArrayList("items", arrayList3);
                arrayList2.add(bundle);
            } else {
                arrayList3.add(next);
            }
        }
        if (arrayList3.size() > 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("title", str);
            bundle2.putParcelableArrayList("items", arrayList3);
            arrayList2.add(bundle2);
        }
        return arrayList2;
    }
}
