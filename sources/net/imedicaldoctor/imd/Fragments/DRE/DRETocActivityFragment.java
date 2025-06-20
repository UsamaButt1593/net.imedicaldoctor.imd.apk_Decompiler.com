package net.imedicaldoctor.imd.Fragments.DRE;

import android.os.Bundle;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Martindale.MDListActivity;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;

public class DRETocActivityFragment extends SearchHelperFragment {
    public String A4;
    public String B4 = "";
    public boolean C4;
    public ArrayList<String> D4;
    public String E4;

    /* JADX WARNING: type inference failed for: r9v1, types: [androidx.recyclerview.widget.RecyclerView$Adapter] */
    /* JADX WARNING: type inference failed for: r0v77, types: [net.imedicaldoctor.imd.Fragments.DRE.DRETocActivityFragment$2] */
    /* JADX WARNING: type inference failed for: r0v78, types: [net.imedicaldoctor.imd.Fragments.DRE.DRETocActivityFragment$3] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x02ac A[LOOP:0: B:50:0x02a6->B:52:0x02ac, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View U0(android.view.LayoutInflater r17, android.view.ViewGroup r18, android.os.Bundle r19) {
        /*
            r16 = this;
            r6 = r16
            r0 = 2131558538(0x7f0d008a, float:1.8742395E38)
            r7 = 0
            r1 = r17
            r2 = r18
            android.view.View r0 = r1.inflate(r0, r2, r7)
            r6.q4 = r0
            r0 = r19
            r6.W2(r0)
            android.view.View r0 = r6.q4
            r1 = 2131362540(0x7f0a02ec, float:1.8344863E38)
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.SearchView r0 = (androidx.appcompat.widget.SearchView) r0
            r6.s4 = r0
            r16.O2()
            android.view.View r0 = r6.q4
            r1 = 2131362493(0x7f0a02bd, float:1.8344768E38)
            android.view.View r0 = r0.findViewById(r1)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r6.w4 = r0
            android.view.View r0 = r6.q4
            r1 = 2131361934(0x7f0a008e, float:1.8343634E38)
            android.view.View r0 = r0.findViewById(r1)
            com.google.android.material.appbar.AppBarLayout r0 = (com.google.android.material.appbar.AppBarLayout) r0
            android.view.View r1 = r6.q4
            r2 = 2131361947(0x7f0a009b, float:1.834366E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            android.os.Bundle r2 = r16.y()
            java.lang.String r3 = "0"
            if (r2 == 0) goto L_0x0074
            android.os.Bundle r2 = r16.y()
            java.lang.String r4 = "ParentId"
            boolean r2 = r2.containsKey(r4)
            if (r2 == 0) goto L_0x0074
            android.os.Bundle r2 = r16.y()
            java.lang.String r2 = r2.getString(r4)
            r6.A4 = r2
            android.os.Bundle r2 = r16.y()
            java.lang.String r2 = r2.getString(r4)
            r6.A4 = r2
            r0.D(r7, r7)
            goto L_0x0076
        L_0x0074:
            r6.A4 = r3
        L_0x0076:
            java.lang.String r2 = r6.A4
            boolean r2 = r2.equals(r3)
            r4 = 1
            java.lang.String r5 = "3"
            if (r2 != 0) goto L_0x0095
            java.lang.String r2 = r6.A4
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x008a
            goto L_0x0095
        L_0x008a:
            net.imedicaldoctor.imd.Fragments.DRE.DRETocActivityFragment$1 r2 = new net.imedicaldoctor.imd.Fragments.DRE.DRETocActivityFragment$1
            r2.<init>(r1)
            r8 = 800(0x320, double:3.953E-321)
            r0.postDelayed(r2, r8)
            goto L_0x009b
        L_0x0095:
            r0.D(r4, r7)
            r1.setVisibility(r7)
        L_0x009b:
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            android.os.Bundle r1 = r6.h4
            java.lang.String r2 = "Select CorrPerc from Questions limit 1"
            java.util.ArrayList r0 = r0.V(r1, r2)
            if (r0 != 0) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r4 = 0
        L_0x00a9:
            r6.C4 = r4
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.D4 = r0
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r3)
            java.lang.String r8 = "سوالی پیدا نشد"
            java.lang.String r1 = "2"
            java.lang.String r2 = "1"
            if (r0 == 0) goto L_0x00d2
            java.lang.String r0 = "دروس"
            r6.B4 = r0
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            android.os.Bundle r4 = r6.h4
            java.lang.String r9 = "Select * from Lessons"
            java.util.ArrayList r0 = r0.V(r4, r9)
        L_0x00ce:
            r6.n4 = r0
            goto L_0x027e
        L_0x00d2:
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r2)
            java.lang.String r4 = "SubjectId"
            if (r0 == 0) goto L_0x0107
            java.lang.String r0 = "بخش ها"
            r6.B4 = r0
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            android.os.Bundle r9 = r6.h4
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "select * from divisions where lessonid="
            r10.append(r11)
            android.os.Bundle r11 = r16.y()
            java.lang.String r4 = r11.getString(r4)
            r10.append(r4)
            java.lang.String r4 = " order by name"
            r10.append(r4)
            java.lang.String r4 = r10.toString()
            java.util.ArrayList r0 = r0.V(r9, r4)
            goto L_0x00ce
        L_0x0107:
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r1)
            java.lang.String r9 = " سوال"
            java.lang.String r10 = "select * from questions where lessonId="
            if (r0 == 0) goto L_0x0186
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            android.os.Bundle r11 = r16.y()
            java.lang.String r11 = r11.getString(r4)
            r0.append(r11)
            java.lang.String r11 = " AND divId ="
            r0.append(r11)
            android.os.Bundle r12 = r16.y()
            java.lang.String r13 = "SystemId"
            java.lang.String r12 = r12.getString(r13)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            r6.E4 = r0
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            android.os.Bundle r12 = r6.h4
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r10)
            android.os.Bundle r10 = r16.y()
            java.lang.String r4 = r10.getString(r4)
            r14.append(r4)
            r14.append(r11)
            android.os.Bundle r4 = r16.y()
            java.lang.String r4 = r4.getString(r13)
            r14.append(r4)
            java.lang.String r4 = r14.toString()
            java.util.ArrayList r0 = r0.V(r12, r4)
            r6.n4 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0172:
            java.util.ArrayList<android.os.Bundle> r4 = r6.n4
            int r4 = r4.size()
            r0.append(r4)
            r0.append(r9)
        L_0x017e:
            java.lang.String r0 = r0.toString()
        L_0x0182:
            r6.B4 = r0
            goto L_0x027e
        L_0x0186:
            java.lang.String r0 = r6.A4
            java.lang.String r11 = "4"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x01d2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            android.os.Bundle r10 = r16.y()
            java.lang.String r10 = r10.getString(r4)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r6.E4 = r0
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            android.os.Bundle r10 = r6.h4
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "select * from questions where lessonid="
            r11.append(r12)
            android.os.Bundle r12 = r16.y()
            java.lang.String r4 = r12.getString(r4)
            r11.append(r4)
            java.lang.String r4 = r11.toString()
            java.util.ArrayList r0 = r0.V(r10, r4)
            r6.n4 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x0172
        L_0x01d2:
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x027e
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r9 = "select group_concat(dbAddress) as s from favorites where dbName = '"
            r4.append(r9)
            android.os.Bundle r9 = r6.h4
            java.lang.String r10 = "Name"
            java.lang.String r9 = r9.getString(r10)
            r4.append(r9)
            java.lang.String r9 = "'"
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            java.util.ArrayList r0 = r0.j0(r4)
            if (r0 == 0) goto L_0x0277
            int r4 = r0.size()
            if (r4 != 0) goto L_0x0207
            goto L_0x0277
        L_0x0207:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r9 = "select * from questions where id in ("
            r4.append(r9)
            java.lang.Object r10 = r0.get(r7)
            android.os.Bundle r10 = (android.os.Bundle) r10
            java.lang.String r11 = "s"
            java.lang.String r10 = r10.getString(r11)
            java.lang.String r12 = "question-"
            java.lang.String r13 = ""
            java.lang.String r10 = r10.replace(r12, r13)
            r4.append(r10)
            java.lang.String r10 = ")"
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            r6.E4 = r4
            net.imedicaldoctor.imd.Data.CompressHelper r4 = r6.k4
            android.os.Bundle r14 = r6.h4
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r9)
            java.lang.Object r0 = r0.get(r7)
            android.os.Bundle r0 = (android.os.Bundle) r0
            java.lang.String r0 = r0.getString(r11)
            java.lang.String r0 = r0.replace(r12, r13)
            r15.append(r0)
            r15.append(r10)
            java.lang.String r0 = r15.toString()
            java.util.ArrayList r0 = r4.V(r14, r0)
            r6.n4 = r0
            if (r0 != 0) goto L_0x0262
            r6.B4 = r8
            goto L_0x027e
        L_0x0262:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.ArrayList<android.os.Bundle> r4 = r6.n4
            int r4 = r4.size()
            r0.append(r4)
            java.lang.String r4 = " Questions"
            r0.append(r4)
            goto L_0x017e
        L_0x0277:
            r0 = 0
            r6.n4 = r0
            java.lang.String r0 = "No Questions"
            goto L_0x0182
        L_0x027e:
            r16.S2()
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0291
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x02be
        L_0x0291:
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            android.os.Bundle r1 = r6.h4
            java.lang.String r4 = "Select distinct qid from logs"
            java.util.ArrayList r0 = r0.V(r1, r4)
            if (r0 != 0) goto L_0x02a2
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x02a2:
            java.util.Iterator r0 = r0.iterator()
        L_0x02a6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02be
            java.lang.Object r1 = r0.next()
            android.os.Bundle r1 = (android.os.Bundle) r1
            java.util.ArrayList<java.lang.String> r4 = r6.D4
            java.lang.String r5 = "qid"
            java.lang.String r1 = r1.getString(r5)
            r4.add(r1)
            goto L_0x02a6
        L_0x02be:
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x02e5
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x02cf
            goto L_0x02e5
        L_0x02cf:
            net.imedicaldoctor.imd.Fragments.DRE.DRETocActivityFragment$3 r9 = new net.imedicaldoctor.imd.Fragments.DRE.DRETocActivityFragment$3
            androidx.fragment.app.FragmentActivity r2 = r16.r()
            java.util.ArrayList<android.os.Bundle> r3 = r6.n4
            java.lang.String r4 = "afsd"
            r5 = 2131558641(0x7f0d00f1, float:1.8742604E38)
            r0 = r9
            r1 = r16
            r0.<init>(r2, r3, r4, r5)
        L_0x02e2:
            r6.l4 = r9
            goto L_0x02f9
        L_0x02e5:
            net.imedicaldoctor.imd.Fragments.DRE.DRETocActivityFragment$2 r9 = new net.imedicaldoctor.imd.Fragments.DRE.DRETocActivityFragment$2
            androidx.fragment.app.FragmentActivity r2 = r16.r()
            java.util.ArrayList<android.os.Bundle> r3 = r6.n4
            java.lang.String r4 = "name"
            r5 = 2131558640(0x7f0d00f0, float:1.8742602E38)
            r0 = r9
            r1 = r16
            r0.<init>(r2, r3, r4, r5)
            goto L_0x02e2
        L_0x02f9:
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r6.l4
            net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter r0 = (net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter) r0
            r0.f30463h = r8
            net.imedicaldoctor.imd.Fragments.DRE.DRETocActivityFragment$4 r8 = new net.imedicaldoctor.imd.Fragments.DRE.DRETocActivityFragment$4
            androidx.fragment.app.FragmentActivity r2 = r16.r()
            java.util.ArrayList<android.os.Bundle> r3 = r6.o4
            java.lang.String r4 = "text"
            java.lang.String r5 = "subText"
            r0 = r8
            r1 = r16
            r0.<init>(r2, r3, r4, r5)
            r6.m4 = r8
            androidx.recyclerview.widget.RecyclerView r0 = r6.w4
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r6.l4
            r0.setAdapter(r1)
            r16.N2()
            r6.o2(r7)
            android.view.View r0 = r6.q4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.DRE.DRETocActivityFragment.U0(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void X2() {
        this.m4.f0(this.o4);
        this.w4.setAdapter(this.m4);
    }

    public ArrayList<Bundle> a3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select Text as text,snippet(search) as subText, type, contentId from search where search match '" + str + "' ORDER BY rank(matchinfo(search)) DESC");
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }

    public String h3() {
        return this.B4;
    }

    public void i3(Bundle bundle, int i2) {
        V2();
        if (bundle.getString("docId").equals("0")) {
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("DB", this.h4);
            bundle2.putString("ParentId", bundle.getString("id"));
            this.k4.N(MDListActivity.class, DRETocActivityFragment.class, bundle2);
            return;
        }
        this.k4.A1(this.h4, bundle.getString("docId"), (String[]) null, (String) null);
    }
}
