package net.imedicaldoctor.imd.Fragments.UWorld;

import android.os.Bundle;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Martindale.MDListActivity;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;

public class UWTocActivityFragment extends SearchHelperFragment {
    public String A4;
    public String B4 = "";
    public ArrayList<String> C4;
    private Boolean D4;
    private Boolean E4;
    public String F4;

    /* JADX WARNING: type inference failed for: r8v3, types: [androidx.recyclerview.widget.RecyclerView$Adapter] */
    /* JADX WARNING: type inference failed for: r0v96, types: [net.imedicaldoctor.imd.Fragments.UWorld.UWTocActivityFragment$2] */
    /* JADX WARNING: type inference failed for: r0v97, types: [net.imedicaldoctor.imd.Fragments.UWorld.UWTocActivityFragment$3] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x02c5 A[LOOP:0: B:56:0x02bf->B:58:0x02c5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFragmentBind(android.view.LayoutInflater r15, android.view.ViewGroup r16, android.os.Bundle r17) {
        /*
            r14 = this;
            r6 = r14
            r0 = 2131558538(0x7f0d008a, float:1.8742395E38)
            r7 = 0
            r1 = r15
            r2 = r16
            android.view.View r0 = r15.inflate(r0, r2, r7)
            r6.q4 = r0
            r0 = r17
            r14.W2(r0)
            android.view.View r0 = r6.q4
            r1 = 2131362540(0x7f0a02ec, float:1.8344863E38)
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.SearchView r0 = (androidx.appcompat.widget.SearchView) r0
            r6.s4 = r0
            r14.O2()
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
            android.os.Bundle r2 = r14.y()
            java.lang.String r3 = "0"
            if (r2 == 0) goto L_0x0072
            android.os.Bundle r2 = r14.y()
            java.lang.String r4 = "ParentId"
            boolean r2 = r2.containsKey(r4)
            if (r2 == 0) goto L_0x0072
            android.os.Bundle r2 = r14.y()
            java.lang.String r2 = r2.getString(r4)
            r6.A4 = r2
            android.os.Bundle r2 = r14.y()
            java.lang.String r2 = r2.getString(r4)
            r6.A4 = r2
            r0.D(r7, r7)
            goto L_0x0074
        L_0x0072:
            r6.A4 = r3
        L_0x0074:
            java.lang.String r2 = r6.A4
            boolean r2 = r2.equals(r3)
            r4 = 1
            java.lang.String r5 = "3"
            if (r2 != 0) goto L_0x0093
            java.lang.String r2 = r6.A4
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0088
            goto L_0x0093
        L_0x0088:
            net.imedicaldoctor.imd.Fragments.UWorld.UWTocActivityFragment$1 r2 = new net.imedicaldoctor.imd.Fragments.UWorld.UWTocActivityFragment$1
            r2.<init>(r1)
            r8 = 800(0x320, double:3.953E-321)
            r0.postDelayed(r2, r8)
            goto L_0x0099
        L_0x0093:
            r0.D(r4, r7)
            r1.setVisibility(r7)
        L_0x0099:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.C4 = r0
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            android.os.Bundle r1 = r6.h4
            java.lang.String r2 = "select count(distinct  subId) as c  from questions"
            java.util.ArrayList r0 = r0.V(r1, r2)
            java.lang.Object r0 = r0.get(r7)
            android.os.Bundle r0 = (android.os.Bundle) r0
            java.lang.String r1 = "c"
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)
            r0 = r0 ^ r4
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.D4 = r0
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            android.os.Bundle r8 = r6.h4
            java.lang.String r9 = "select count(distinct  sysId) as c  from questions"
            java.util.ArrayList r0 = r0.V(r8, r9)
            java.lang.Object r0 = r0.get(r7)
            android.os.Bundle r0 = (android.os.Bundle) r0
            java.lang.String r0 = r0.getString(r1)
            boolean r0 = r0.equals(r2)
            r0 = r0 ^ r4
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.E4 = r0
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r3)
            java.lang.String r1 = "id"
            java.lang.String r4 = "SubjectId"
            if (r0 == 0) goto L_0x0113
            java.lang.Boolean r0 = r6.D4
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0113
            r6.A4 = r2
            android.os.Bundle r0 = r14.y()
            net.imedicaldoctor.imd.Data.CompressHelper r8 = r6.k4
            android.os.Bundle r9 = r6.h4
            java.lang.String r10 = "select id as id from Subjects"
            java.util.ArrayList r8 = r8.V(r9, r10)
            java.lang.Object r8 = r8.get(r7)
            android.os.Bundle r8 = (android.os.Bundle) r8
            java.lang.String r8 = r8.getString(r1)
            r0.putString(r4, r8)
        L_0x0113:
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r2)
            java.lang.String r8 = "SystemId"
            java.lang.String r9 = "2"
            if (r0 == 0) goto L_0x0144
            java.lang.Boolean r0 = r6.E4
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0144
            r6.A4 = r9
            android.os.Bundle r0 = r14.y()
            net.imedicaldoctor.imd.Data.CompressHelper r10 = r6.k4
            android.os.Bundle r11 = r6.h4
            java.lang.String r12 = "select id as id from Systems"
            java.util.ArrayList r10 = r10.V(r11, r12)
            java.lang.Object r10 = r10.get(r7)
            android.os.Bundle r10 = (android.os.Bundle) r10
            java.lang.String r1 = r10.getString(r1)
            r0.putString(r8, r1)
        L_0x0144:
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x015e
            java.lang.String r0 = "Subjects"
            r6.B4 = r0
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            android.os.Bundle r1 = r6.h4
            java.lang.String r4 = "Select id,name as name,count from Subjects"
        L_0x0156:
            java.util.ArrayList r0 = r0.V(r1, r4)
            r6.n4 = r0
            goto L_0x0297
        L_0x015e:
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x018d
            java.lang.String r0 = "Systems"
            r6.B4 = r0
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            android.os.Bundle r1 = r6.h4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "select systems.id,systems.name, subjectssystems.count from systems, subjectssystems where subjectssystems.subId="
            r8.append(r10)
            android.os.Bundle r10 = r14.y()
            java.lang.String r4 = r10.getString(r4)
            r8.append(r4)
            java.lang.String r4 = " AND systems.id=subjectssystems.sysid and subjectssystems.count>0 order by name"
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            goto L_0x0156
        L_0x018d:
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r9)
            java.lang.String r1 = " Questions"
            if (r0 == 0) goto L_0x0213
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = "select * from questions where subId="
            r0.append(r10)
            android.os.Bundle r11 = r14.y()
            java.lang.String r11 = r11.getString(r4)
            r0.append(r11)
            java.lang.String r11 = " AND sysId ="
            r0.append(r11)
            android.os.Bundle r12 = r14.y()
            java.lang.String r12 = r12.getString(r8)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            r6.F4 = r0
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            android.os.Bundle r12 = r6.h4
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r10)
            android.os.Bundle r10 = r14.y()
            java.lang.String r4 = r10.getString(r4)
            r13.append(r4)
            r13.append(r11)
            android.os.Bundle r4 = r14.y()
            java.lang.String r4 = r4.getString(r8)
            r13.append(r4)
            java.lang.String r4 = r13.toString()
            java.util.ArrayList r0 = r0.V(r12, r4)
            r6.n4 = r0
            if (r0 != 0) goto L_0x01fa
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.n4 = r0
        L_0x01fa:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x01ff:
            java.util.ArrayList<android.os.Bundle> r4 = r6.n4
            int r4 = r4.size()
            r0.append(r4)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x020f:
            r6.B4 = r0
            goto L_0x0297
        L_0x0213:
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0297
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "select group_concat(\"'\" || dbAddress || \"'\") as s from favorites where dbName = '"
            r4.append(r8)
            android.os.Bundle r8 = r6.h4
            java.lang.String r10 = "Name"
            java.lang.String r8 = r8.getString(r10)
            r4.append(r8)
            java.lang.String r8 = "' and dbAddress NOT LIKE '%html-%'"
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            java.util.ArrayList r0 = r0.j0(r4)
            if (r0 == 0) goto L_0x0290
            int r4 = r0.size()
            if (r4 != 0) goto L_0x0248
            goto L_0x0290
        L_0x0248:
            java.lang.Object r0 = r0.get(r7)
            android.os.Bundle r0 = (android.os.Bundle) r0
            java.lang.String r4 = "s"
            java.lang.String r0 = r0.getString(r4)
            java.lang.String r4 = "question-"
            java.lang.String r8 = ""
            java.lang.String r0 = r0.replace(r4, r8)
            java.lang.String r4 = "answer-"
            java.lang.String r0 = r0.replace(r4, r8)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "select * from questions where id in ("
            r4.append(r8)
            r4.append(r0)
            java.lang.String r0 = ")"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r6.F4 = r0
            net.imedicaldoctor.imd.Data.CompressHelper r4 = r6.k4
            android.os.Bundle r8 = r6.h4
            java.util.ArrayList r0 = r4.V(r8, r0)
            r6.n4 = r0
            if (r0 != 0) goto L_0x0289
            java.lang.String r0 = "No Question Found"
            goto L_0x020f
        L_0x0289:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x01ff
        L_0x0290:
            r0 = 0
            r6.n4 = r0
            java.lang.String r0 = "No Questions"
            goto L_0x020f
        L_0x0297:
            r14.S2()
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x02aa
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x02d7
        L_0x02aa:
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r6.k4
            android.os.Bundle r1 = r6.h4
            java.lang.String r4 = "Select distinct qid from logs"
            java.util.ArrayList r0 = r0.V(r1, r4)
            if (r0 != 0) goto L_0x02bb
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x02bb:
            java.util.Iterator r0 = r0.iterator()
        L_0x02bf:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02d7
            java.lang.Object r1 = r0.next()
            android.os.Bundle r1 = (android.os.Bundle) r1
            java.util.ArrayList<java.lang.String> r4 = r6.C4
            java.lang.String r5 = "qid"
            java.lang.String r1 = r1.getString(r5)
            r4.add(r1)
            goto L_0x02bf
        L_0x02d7:
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x02fd
            java.lang.String r0 = r6.A4
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x02e8
            goto L_0x02fd
        L_0x02e8:
            net.imedicaldoctor.imd.Fragments.UWorld.UWTocActivityFragment$3 r8 = new net.imedicaldoctor.imd.Fragments.UWorld.UWTocActivityFragment$3
            androidx.fragment.app.FragmentActivity r2 = r14.r()
            java.util.ArrayList<android.os.Bundle> r3 = r6.n4
            java.lang.String r4 = "afsd"
            r5 = 2131558641(0x7f0d00f1, float:1.8742604E38)
            r0 = r8
            r1 = r14
            r0.<init>(r2, r3, r4, r5)
        L_0x02fa:
            r6.l4 = r8
            goto L_0x0310
        L_0x02fd:
            net.imedicaldoctor.imd.Fragments.UWorld.UWTocActivityFragment$2 r8 = new net.imedicaldoctor.imd.Fragments.UWorld.UWTocActivityFragment$2
            androidx.fragment.app.FragmentActivity r2 = r14.r()
            java.util.ArrayList<android.os.Bundle> r3 = r6.n4
            java.lang.String r4 = "name"
            r5 = 2131558640(0x7f0d00f0, float:1.8742602E38)
            r0 = r8
            r1 = r14
            r0.<init>(r2, r3, r4, r5)
            goto L_0x02fa
        L_0x0310:
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r6.l4
            net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter r0 = (net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter) r0
            java.lang.String r1 = "No Questions Found"
            r0.f30463h = r1
            net.imedicaldoctor.imd.Fragments.UWorld.UWTocActivityFragment$4 r8 = new net.imedicaldoctor.imd.Fragments.UWorld.UWTocActivityFragment$4
            androidx.fragment.app.FragmentActivity r2 = r14.r()
            java.util.ArrayList<android.os.Bundle> r3 = r6.o4
            java.lang.String r4 = "text"
            java.lang.String r5 = "subText"
            r0 = r8
            r1 = r14
            r0.<init>(r2, r3, r4, r5)
            r6.m4 = r8
            androidx.recyclerview.widget.RecyclerView r0 = r6.w4
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r6.l4
            r0.setAdapter(r1)
            r14.N2()
            r14.o2(r7)
            android.view.View r0 = r6.q4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.UWorld.UWTocActivityFragment.U0(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
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
            this.k4.N(MDListActivity.class, UWTocActivityFragment.class, bundle2);
            return;
        }
        this.k4.A1(this.h4, bundle.getString("docId"), (String[]) null, (String) null);
    }
}
