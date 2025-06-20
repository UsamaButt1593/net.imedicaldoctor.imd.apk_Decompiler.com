package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.os.Bundle;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;

public class EPORxListActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;
    public Bundle C4;
    public boolean D4;
    public String E4;

    /* JADX WARNING: type inference failed for: r6v1, types: [androidx.recyclerview.widget.RecyclerView$Adapter] */
    /* JADX WARNING: type inference failed for: r0v44, types: [net.imedicaldoctor.imd.Fragments.Epocrate.EPORxListActivityFragment$3] */
    /* JADX WARNING: type inference failed for: r0v45, types: [net.imedicaldoctor.imd.Fragments.Epocrate.EPORxListActivityFragment$2] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFragmentBind(android.view.LayoutInflater r10, android.view.ViewGroup r11, android.os.Bundle r12) {
        /*
            r9 = this;
            r0 = 2131558538(0x7f0d008a, float:1.8742395E38)
            r7 = 0
            android.view.View r0 = r10.inflate(r0, r11, r7)
            r9.q4 = r0
            r9.W2(r12)
            r9.S2()
            android.view.View r0 = r9.q4
            r1 = 2131362540(0x7f0a02ec, float:1.8344863E38)
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.SearchView r0 = (androidx.appcompat.widget.SearchView) r0
            r9.s4 = r0
            r9.Q2()
            android.view.View r0 = r9.q4
            r1 = 2131362493(0x7f0a02bd, float:1.8344768E38)
            android.view.View r0 = r0.findViewById(r1)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r9.w4 = r0
            java.lang.String r0 = "RX.sqlite"
            r9.E4 = r0
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r9.C4 = r0
            android.view.View r0 = r9.q4
            r1 = 2131361934(0x7f0a008e, float:1.8343634E38)
            android.view.View r0 = r0.findViewById(r1)
            com.google.android.material.appbar.AppBarLayout r0 = (com.google.android.material.appbar.AppBarLayout) r0
            android.view.View r1 = r9.q4
            r2 = 2131361947(0x7f0a009b, float:1.834366E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            android.os.Bundle r2 = r9.y()
            r3 = 1
            if (r2 == 0) goto L_0x0090
            android.os.Bundle r2 = r9.y()
            java.lang.String r4 = "ParentId"
            boolean r2 = r2.containsKey(r4)
            if (r2 == 0) goto L_0x0090
            android.os.Bundle r2 = r9.y()
            java.lang.String r2 = r2.getString(r4)
            java.lang.String r5 = "0"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0078
            r0.D(r3, r7)
            r1.setVisibility(r7)
            goto L_0x0085
        L_0x0078:
            r0.D(r7, r7)
            net.imedicaldoctor.imd.Fragments.Epocrate.EPORxListActivityFragment$1 r2 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPORxListActivityFragment$1
            r2.<init>(r1)
            r5 = 800(0x320, double:3.953E-321)
            r0.postDelayed(r2, r5)
        L_0x0085:
            android.os.Bundle r0 = r9.y()
            java.lang.String r0 = r0.getString(r4)
        L_0x008d:
            r9.B4 = r0
            goto L_0x0098
        L_0x0090:
            r0.D(r3, r7)
            r1.setVisibility(r7)
            r0 = 0
            goto L_0x008d
        L_0x0098:
            java.lang.String r0 = r9.B4
            if (r0 != 0) goto L_0x00ac
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r9.k4
            android.os.Bundle r1 = r9.h4
            java.lang.String r2 = "SELECT  DRUG_CLASS.ID ,  DRUG_CLASS.NAME   FROM DRUG_CLASS_HIERARCHY   JOIN DRUG_CLASS ON  DRUG_CLASS_HIERARCHY.PARENT_ID =  ''  AND DRUG_CLASS.ID = DRUG_CLASS_HIERARCHY.CHILD_ID    ORDER BY  DRUG_CLASS.NAME COLLATE NOCASE"
            java.lang.String r3 = r9.E4
            java.util.ArrayList r0 = r0.W(r1, r2, r3)
            r9.n4 = r0
            goto L_0x01a3
        L_0x00ac:
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r9.k4
            android.os.Bundle r1 = r9.h4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "SELECT  DRUG_CLASS.ID ,  DRUG_CLASS.NAME   FROM DRUG_CLASS_HIERARCHY   JOIN DRUG_CLASS ON  DRUG_CLASS_HIERARCHY.PARENT_ID =  "
            r2.append(r4)
            java.lang.String r4 = r9.B4
            r2.append(r4)
            java.lang.String r4 = " AND DRUG_CLASS.ID = DRUG_CLASS_HIERARCHY.CHILD_ID    ORDER BY  DRUG_CLASS.NAME COLLATE NOCASE"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = r9.E4
            java.util.ArrayList r0 = r0.W(r1, r2, r4)
            r9.n4 = r0
            if (r0 == 0) goto L_0x00d8
            int r0 = r0.size()
            if (r0 != 0) goto L_0x01a3
        L_0x00d8:
            r9.D4 = r3
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r9.k4
            android.os.Bundle r1 = r9.h4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "SELECT  DRUG.ID ,  DRUG.CLINICAL_ID ,  DRUG.GENERIC_ID ,  DRUG.NAME ,  DRUG.DRUG_TYPE ,  DRUG.ACTIVE ,  DRUG.ADULT_DSG_ID ,  DRUG.PEDS_DSG_ID ,  DRUG.MFR_STRING_ID ,  DRUG.BBW_ID   FROM DRUG_TO_DRUG_CLASS   JOIN DRUG ON  DRUG_TO_DRUG_CLASS.DRUG_CLASS_ID =  "
            r2.append(r3)
            java.lang.String r3 = r9.B4
            r2.append(r3)
            java.lang.String r3 = "   AND DRUG.ID = DRUG_TO_DRUG_CLASS.DRUG_ID    WHERE ACTIVE = 1 ORDER BY  DRUG.NAME COLLATE NOCASE"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = r9.E4
            java.util.ArrayList r0 = r0.W(r1, r2, r3)
            r9.n4 = r0
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r9.k4
            android.os.Bundle r1 = r9.h4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "SELECT  group_concat(generic_ID) as a  FROM DRUG_TO_DRUG_CLASS   JOIN DRUG ON  DRUG_TO_DRUG_CLASS.DRUG_CLASS_ID =  "
            r2.append(r3)
            java.lang.String r3 = r9.B4
            r2.append(r3)
            java.lang.String r3 = "   AND DRUG.ID = DRUG_TO_DRUG_CLASS.DRUG_ID    WHERE ACTIVE = 1 AND generic_ID<>''   ORDER BY  DRUG.NAME COLLATE NOCASE"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = r9.E4
            java.util.ArrayList r1 = r0.W(r1, r2, r3)
            android.os.Bundle r0 = r0.s1(r1)
            java.lang.String r1 = "a"
            java.lang.String r0 = r0.getString(r1)
            java.util.ArrayList<android.os.Bundle> r2 = r9.n4
            if (r2 == 0) goto L_0x0134
            int r2 = r2.size()
            if (r2 != 0) goto L_0x0156
        L_0x0134:
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r9.k4
            android.os.Bundle r2 = r9.h4
            java.lang.String r3 = "SELECT  DRUG.ID ,  DRUG.CLINICAL_ID ,  DRUG.GENERIC_ID ,  DRUG.NAME ,  DRUG.DRUG_TYPE ,  DRUG.ACTIVE ,  DRUG.ADULT_DSG_ID ,  DRUG.PEDS_DSG_ID ,  DRUG.MFR_STRING_ID ,  DRUG.BBW_ID   FROM DRUG  WHERE DRUG_TYPE=7 order by NAME asc"
            java.lang.String r4 = r9.E4
            java.util.ArrayList r0 = r0.W(r2, r3, r4)
            r9.n4 = r0
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r9.k4
            android.os.Bundle r2 = r9.h4
            java.lang.String r3 = "SELECT  group_concat(generic_ID) as a  FROM DRUG WHERE DRUG_TYPE=7 AND generic_id<>'' ORDER BY NAME COLLATE NOCASE"
            java.lang.String r4 = r9.E4
            java.util.ArrayList r2 = r0.W(r2, r3, r4)
            android.os.Bundle r0 = r0.s1(r2)
            java.lang.String r0 = r0.getString(r1)
        L_0x0156:
            net.imedicaldoctor.imd.Data.CompressHelper r1 = r9.k4
            android.os.Bundle r2 = r9.h4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "SELECT  DRUG.ID ,  DRUG.CLINICAL_ID ,  DRUG.GENERIC_ID ,  DRUG.NAME ,  DRUG.DRUG_TYPE ,  DRUG.ACTIVE ,  DRUG.ADULT_DSG_ID ,  DRUG.PEDS_DSG_ID ,  DRUG.MFR_STRING_ID ,  DRUG.BBW_ID   FROM DRUG   WHERE  ID in ("
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = ")"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r3 = r9.E4
            java.util.ArrayList r0 = r1.W(r2, r0, r3)
            if (r0 != 0) goto L_0x0179
            goto L_0x01a3
        L_0x0179:
            java.util.Iterator r0 = r0.iterator()
        L_0x017d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01a3
            java.lang.Object r1 = r0.next()
            android.os.Bundle r1 = (android.os.Bundle) r1
            java.lang.String r2 = "ID"
            java.lang.String r2 = r1.getString(r2)
            java.lang.String r3 = "NAME"
            java.lang.String r1 = r1.getString(r3)
            android.os.Bundle r3 = r9.C4
            boolean r3 = r3.containsKey(r2)
            if (r3 != 0) goto L_0x017d
            android.os.Bundle r3 = r9.C4
            r3.putString(r2, r1)
            goto L_0x017d
        L_0x01a3:
            boolean r0 = r9.D4
            if (r0 == 0) goto L_0x01bc
            net.imedicaldoctor.imd.Fragments.Epocrate.EPORxListActivityFragment$2 r6 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPORxListActivityFragment$2
            androidx.fragment.app.FragmentActivity r2 = r9.r()
            java.util.ArrayList<android.os.Bundle> r3 = r9.n4
            java.lang.String r4 = "title"
            r5 = 2131558641(0x7f0d00f1, float:1.8742604E38)
            r0 = r6
            r1 = r9
            r0.<init>(r2, r3, r4, r5)
        L_0x01b9:
            r9.l4 = r6
            goto L_0x01cf
        L_0x01bc:
            net.imedicaldoctor.imd.Fragments.Epocrate.EPORxListActivityFragment$3 r6 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPORxListActivityFragment$3
            androidx.fragment.app.FragmentActivity r2 = r9.r()
            java.util.ArrayList<android.os.Bundle> r3 = r9.n4
            java.lang.String r4 = "NAME"
            r5 = 2131558638(0x7f0d00ee, float:1.8742597E38)
            r0 = r6
            r1 = r9
            r0.<init>(r2, r3, r4, r5)
            goto L_0x01b9
        L_0x01cf:
            net.imedicaldoctor.imd.Fragments.Epocrate.EPORxListActivityFragment$4 r8 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPORxListActivityFragment$4
            androidx.fragment.app.FragmentActivity r2 = r9.r()
            java.util.ArrayList<android.os.Bundle> r3 = r9.o4
            r5 = 0
            r6 = 2131558641(0x7f0d00f1, float:1.8742604E38)
            java.lang.String r4 = "text"
            r0 = r8
            r1 = r9
            r0.<init>(r2, r3, r4, r5, r6)
            r9.A4 = r8
            androidx.recyclerview.widget.RecyclerView r0 = r9.w4
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r9.l4
            r0.setAdapter(r1)
            r9.N2()
            r9.o2(r7)
            android.view.View r0 = r9.q4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Epocrate.EPORxListActivityFragment.U0(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void X2() {
        this.A4.i0(this.o4, this.p4);
        this.w4.setAdapter(this.A4);
    }

    public ArrayList<Bundle> a3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select * from search where search match '(text:" + str + "* OR content:" + str + "*) AND typeText:RX NOT (type:5)'");
    }

    public void c3() {
        this.t4.setImageDrawable(b0().getDrawable(R.drawable.f632drugs_icon));
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }

    public String h3() {
        return "Drugs";
    }

    public void i3(Bundle bundle, int i2) {
        V2();
        if (!this.D4) {
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("DB", this.h4);
            bundle2.putString("ParentId", bundle.getString("ID"));
            this.k4.N(EPORxListActivity.class, EPORxListActivityFragment.class, bundle2);
            return;
        }
        CompressHelper compressHelper = this.k4;
        Bundle bundle3 = this.h4;
        compressHelper.A1(bundle3, "rx-" + bundle.getString("ID"), (String[]) null, (String) null);
    }
}
