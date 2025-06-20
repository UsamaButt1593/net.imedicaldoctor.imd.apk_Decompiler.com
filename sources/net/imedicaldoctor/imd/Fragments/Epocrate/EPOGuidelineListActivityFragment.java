package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.os.Bundle;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;

public class EPOGuidelineListActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;

    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.recyclerview.widget.RecyclerView$Adapter] */
    /* JADX WARNING: type inference failed for: r0v25, types: [net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineListActivityFragment$3] */
    /* JADX WARNING: type inference failed for: r0v26, types: [net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineListActivityFragment$2] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View U0(android.view.LayoutInflater r10, android.view.ViewGroup r11, android.os.Bundle r12) {
        /*
            r9 = this;
            r0 = 2131558538(0x7f0d008a, float:1.8742395E38)
            r6 = 0
            android.view.View r0 = r10.inflate(r0, r11, r6)
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
            if (r2 == 0) goto L_0x0085
            android.os.Bundle r2 = r9.y()
            java.lang.String r4 = "ParentId"
            boolean r2 = r2.containsKey(r4)
            if (r2 == 0) goto L_0x0085
            android.os.Bundle r2 = r9.y()
            java.lang.String r2 = r2.getString(r4)
            java.lang.String r5 = "0"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x006d
            r0.D(r3, r6)
            r1.setVisibility(r6)
            goto L_0x007a
        L_0x006d:
            r0.D(r6, r6)
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineListActivityFragment$1 r2 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineListActivityFragment$1
            r2.<init>(r1)
            r7 = 800(0x320, double:3.953E-321)
            r0.postDelayed(r2, r7)
        L_0x007a:
            android.os.Bundle r0 = r9.y()
            java.lang.String r0 = r0.getString(r4)
        L_0x0082:
            r9.B4 = r0
            goto L_0x008d
        L_0x0085:
            r0.D(r3, r6)
            r1.setVisibility(r6)
            r0 = 0
            goto L_0x0082
        L_0x008d:
            java.lang.String r0 = r9.B4
            if (r0 != 0) goto L_0x00b2
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r9.k4
            android.os.Bundle r1 = r9.h4
            java.lang.String r2 = "SELECT * FROM gl_cats"
            java.util.ArrayList r0 = r0.V(r1, r2)
            r9.n4 = r0
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineListActivityFragment$2 r7 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineListActivityFragment$2
            androidx.fragment.app.FragmentActivity r2 = r9.r()
            java.util.ArrayList<android.os.Bundle> r3 = r9.n4
            java.lang.String r4 = "title"
            r5 = 2131558638(0x7f0d00ee, float:1.8742597E38)
            r0 = r7
            r1 = r9
            r0.<init>(r2, r3, r4, r5)
        L_0x00af:
            r9.l4 = r7
            goto L_0x00e2
        L_0x00b2:
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r9.k4
            android.os.Bundle r1 = r9.h4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "select * from gl_cats_topics inner join gl_topics on gl_cats_topics.topicId = gl_topics.id where catId="
            r2.append(r3)
            java.lang.String r3 = r9.B4
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.util.ArrayList r0 = r0.V(r1, r2)
            r9.n4 = r0
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineListActivityFragment$3 r7 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineListActivityFragment$3
            androidx.fragment.app.FragmentActivity r2 = r9.r()
            java.util.ArrayList<android.os.Bundle> r3 = r9.n4
            java.lang.String r4 = "title"
            r5 = 2131558641(0x7f0d00f1, float:1.8742604E38)
            r0 = r7
            r1 = r9
            r0.<init>(r2, r3, r4, r5)
            goto L_0x00af
        L_0x00e2:
            net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineListActivityFragment$4 r7 = new net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineListActivityFragment$4
            androidx.fragment.app.FragmentActivity r2 = r9.r()
            java.util.ArrayList<android.os.Bundle> r3 = r9.o4
            java.lang.String r4 = "text"
            r5 = 0
            r0 = r7
            r1 = r9
            r0.<init>(r2, r3, r4, r5)
            r9.A4 = r7
            androidx.recyclerview.widget.RecyclerView r0 = r9.w4
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r9.l4
            r0.setAdapter(r1)
            r9.N2()
            r9.o2(r6)
            android.view.View r0 = r9.q4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Epocrate.EPOGuidelineListActivityFragment.U0(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void X2() {
        this.A4.i0(this.o4, this.p4);
        this.w4.setAdapter(this.A4);
    }

    public ArrayList<Bundle> a3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select * from search where search match 'text:" + str + "* AND typeText:Guideline AND type:1'");
    }

    public void c3() {
        this.t4.setImageDrawable(b0().getDrawable(R.drawable.f641guidelines_icon));
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }

    public String h3() {
        return "Guidelines";
    }
}
