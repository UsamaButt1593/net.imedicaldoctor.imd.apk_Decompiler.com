package net.imedicaldoctor.imd.Fragments.Lexi;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDActivity;

public class LXItems extends iMDActivity {

    public static class LXItemsFragment extends SearchHelperFragment {
        /* access modifiers changed from: private */
        public int A4;
        private String B4;
        private String C4;

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1494search, menu);
            this.s4 = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
            O2();
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0101  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0108  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0134  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0139  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View U0(android.view.LayoutInflater r12, android.view.ViewGroup r13, android.os.Bundle r14) {
            /*
                r11 = this;
                r0 = 2131558538(0x7f0d008a, float:1.8742395E38)
                r1 = 0
                android.view.View r12 = r12.inflate(r0, r13, r1)
                r11.q4 = r12
                r11.W2(r14)
                r11.S2()
                android.view.View r13 = r11.q4
                r14 = 2131362540(0x7f0a02ec, float:1.8344863E38)
                android.view.View r13 = r13.findViewById(r14)
                androidx.appcompat.widget.SearchView r13 = (androidx.appcompat.widget.SearchView) r13
                r11.s4 = r13
                r11.O2()
                android.view.View r13 = r11.q4
                r14 = 2131362493(0x7f0a02bd, float:1.8344768E38)
                android.view.View r13 = r13.findViewById(r14)
                androidx.recyclerview.widget.RecyclerView r13 = (androidx.recyclerview.widget.RecyclerView) r13
                r11.w4 = r13
                android.os.Bundle r13 = r11.y()
                r14 = 0
                java.lang.String r0 = "ParentId"
                if (r13 == 0) goto L_0x004b
                android.os.Bundle r13 = r11.y()
                boolean r13 = r13.containsKey(r0)
                if (r13 == 0) goto L_0x004b
                android.os.Bundle r13 = r11.y()
                java.lang.String r13 = r13.getString(r0)
                r11.B4 = r13
                goto L_0x004d
            L_0x004b:
                r11.B4 = r14
            L_0x004d:
                android.os.Bundle r13 = r11.y()
                if (r13 == 0) goto L_0x006a
                android.os.Bundle r13 = r11.y()
                boolean r13 = r13.containsKey(r0)
                if (r13 == 0) goto L_0x006a
                android.os.Bundle r13 = r11.y()
                java.lang.String r0 = "Mode"
                int r13 = r13.getInt(r0)
                r11.A4 = r13
                goto L_0x006c
            L_0x006a:
                r11.A4 = r1
            L_0x006c:
                int r13 = r11.A4
                java.lang.String r0 = ""
                r2 = 2
                java.lang.String r3 = "name"
                r4 = 1
                if (r13 != 0) goto L_0x0083
                net.imedicaldoctor.imd.Data.CompressHelper r13 = r11.k4
                android.os.Bundle r5 = r11.h4
                java.lang.String r6 = "Select id as _id,* from indextype"
            L_0x007c:
                java.util.ArrayList r13 = r13.V(r5, r6)
                r11.n4 = r13
                goto L_0x00e7
            L_0x0083:
                if (r13 != r4) goto L_0x00cd
                net.imedicaldoctor.imd.Data.CompressHelper r13 = r11.k4
                android.os.Bundle r5 = r11.h4
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "select id as _id,* from indexitem where indextype_id="
                r6.append(r7)
                java.lang.String r7 = r11.B4
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                java.util.ArrayList r13 = r13.V(r5, r6)
                r11.n4 = r13
                net.imedicaldoctor.imd.Data.CompressHelper r13 = r11.k4
                android.os.Bundle r5 = r11.h4
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "select name from indexType where id="
                r6.append(r7)
                java.lang.String r7 = r11.B4
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                java.util.ArrayList r5 = r13.V(r5, r6)
                android.os.Bundle r13 = r13.s1(r5)
                if (r13 == 0) goto L_0x00ca
                java.lang.String r13 = r13.getString(r3)
                r11.C4 = r13
                goto L_0x00e7
            L_0x00ca:
                r11.C4 = r0
                goto L_0x00e7
            L_0x00cd:
                if (r13 != r2) goto L_0x00e7
                net.imedicaldoctor.imd.Data.CompressHelper r13 = r11.k4
                android.os.Bundle r5 = r11.h4
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "select id as _id,* from indexitem_document inner join document on (indexitem_document.document_id=document.id) where indexitem_id="
                r6.append(r7)
                java.lang.String r7 = r11.B4
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                goto L_0x007c
            L_0x00e7:
                android.view.View r13 = r11.q4
                r5 = 2131361934(0x7f0a008e, float:1.8343634E38)
                android.view.View r13 = r13.findViewById(r5)
                com.google.android.material.appbar.AppBarLayout r13 = (com.google.android.material.appbar.AppBarLayout) r13
                android.view.View r5 = r11.q4
                r6 = 2131361947(0x7f0a009b, float:1.834366E38)
                android.view.View r5 = r5.findViewById(r6)
                android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
                int r6 = r11.A4
                if (r6 != 0) goto L_0x0108
                r13.D(r4, r1)
                r5.setVisibility(r1)
                goto L_0x0115
            L_0x0108:
                r13.D(r1, r1)
                net.imedicaldoctor.imd.Fragments.Lexi.LXItems$LXItemsFragment$1 r1 = new net.imedicaldoctor.imd.Fragments.Lexi.LXItems$LXItemsFragment$1
                r1.<init>(r5)
                r5 = 800(0x320, double:3.953E-321)
                r13.postDelayed(r1, r5)
            L_0x0115:
                int r13 = r11.A4
                java.lang.String r1 = "title"
                if (r13 == 0) goto L_0x0122
                if (r13 != r4) goto L_0x011e
                goto L_0x0122
            L_0x011e:
                if (r13 != r2) goto L_0x0123
                r0 = r1
                goto L_0x0123
            L_0x0122:
                r0 = r3
            L_0x0123:
                net.imedicaldoctor.imd.Fragments.Lexi.LXItems$LXItemsFragment$2 r13 = new net.imedicaldoctor.imd.Fragments.Lexi.LXItems$LXItemsFragment$2
                androidx.fragment.app.FragmentActivity r5 = r11.r()
                java.util.ArrayList<android.os.Bundle> r6 = r11.n4
                r13.<init>(r5, r6, r0)
                r11.l4 = r13
                int r13 = r11.A4
                if (r13 != 0) goto L_0x0139
                java.lang.String r14 = "type"
            L_0x0136:
                r10 = r14
                r9 = r3
                goto L_0x0143
            L_0x0139:
                if (r13 != r4) goto L_0x013c
                goto L_0x0136
            L_0x013c:
                if (r13 != r2) goto L_0x0141
                r10 = r14
                r9 = r1
                goto L_0x0143
            L_0x0141:
                r9 = r14
                r10 = r9
            L_0x0143:
                net.imedicaldoctor.imd.Fragments.Lexi.LXItems$LXItemsFragment$3 r13 = new net.imedicaldoctor.imd.Fragments.Lexi.LXItems$LXItemsFragment$3
                androidx.fragment.app.FragmentActivity r7 = r11.r()
                java.util.ArrayList<android.os.Bundle> r8 = r11.o4
                r5 = r13
                r6 = r11
                r5.<init>(r7, r8, r9, r10)
                r11.m4 = r13
                androidx.recyclerview.widget.RecyclerView r13 = r11.w4
                androidx.recyclerview.widget.RecyclerView$Adapter r14 = r11.l4
                r13.setAdapter(r14)
                r11.N2()
                r11.o2(r4)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Lexi.LXItems.LXItemsFragment.U0(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
        }

        public ArrayList<Bundle> a3(String str) {
            StringBuilder sb;
            String str2;
            int i2 = this.A4;
            if (i2 == 0) {
                sb = new StringBuilder();
                sb.append("Select rowid as _id,* from search where name match '");
                sb.append(str);
                str2 = "*'";
            } else if (i2 == 1) {
                sb = new StringBuilder();
                sb.append("Select rowid as _id,* from search where search match 'name:");
                sb.append(str);
                sb.append("* AND type:");
                sb.append(this.C4);
                str2 = "'";
            } else if (i2 != 2) {
                return null;
            } else {
                return this.k4.V(this.h4, "select id as _id,* from indexitem_document inner join document on (indexitem_document.document_id=document.id) where indexitem_id=" + this.B4 + " AND title like '" + str + "%'");
            }
            sb.append(str2);
            return this.k4.W(this.h4, sb.toString(), "fsearch.db");
        }

        public ArrayList<Bundle> g3(String str) {
            CompressHelper compressHelper = this.k4;
            Bundle bundle = this.h4;
            return compressHelper.W(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'", "fsearch.db");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new LXItemsFragment());
    }
}
