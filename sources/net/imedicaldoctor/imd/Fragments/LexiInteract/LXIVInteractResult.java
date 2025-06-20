package net.imedicaldoctor.imd.Fragments.LexiInteract;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.NotStickySectionAdapter;
import net.imedicaldoctor.imd.iMDActivity;

public class LXIVInteractResult extends iMDActivity {

    public static class LXIvInteractResultFragment extends SearchHelperFragment {
        private ArrayList<Bundle> A4;
        private ArrayList<Bundle> B4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> C4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> D4;
        public NotStickySectionAdapter E4;
        /* access modifiers changed from: private */
        public String F4;

        public class HeaderViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public final TextView f29789a;

            public HeaderViewHolder(View view) {
                this.f29789a = (TextView) view.findViewById(R.id.f957header_text);
            }
        }

        public class InteractionViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public final TextView f29791a;

            /* renamed from: b  reason: collision with root package name */
            public final ImageView f29792b;

            /* renamed from: c  reason: collision with root package name */
            public final TextView f29793c;

            public InteractionViewHolder(View view) {
                this.f29793c = (TextView) view.findViewById(R.id.f925drug_two_text);
                this.f29791a = (TextView) view.findViewById(R.id.f924drug_one_text);
                this.f29792b = (ImageView) view.findViewById(R.id.image);
            }
        }

        private void m3() {
            ArrayList<Bundle> arrayList = this.A4;
            if (arrayList == null || arrayList.size() == 0) {
                f3("No Information found");
            } else {
                e3();
            }
            FragmentActivity r = r();
            r.setTitle("Founded " + this.B4.size() + " Interactions");
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x00d8  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x00ff  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View onFragmentBind(android.view.LayoutInflater r9, android.view.ViewGroup r10, android.os.Bundle r11) {
            /*
                r8 = this;
                android.view.View r0 = r8.q4
                if (r0 == 0) goto L_0x0005
                return r0
            L_0x0005:
                r0 = 2131558538(0x7f0d008a, float:1.8742395E38)
                r1 = 0
                android.view.View r9 = r9.inflate(r0, r10, r1)
                r8.q4 = r9
                r8.W2(r11)
                r8.S2()
                android.widget.TextView r9 = r8.u4
                java.lang.String r10 = ""
                r9.setText(r10)
                androidx.appcompat.widget.Toolbar r9 = r8.r4
                java.lang.String r0 = "Interaction Results"
                r9.setTitle((java.lang.CharSequence) r0)
                android.view.View r9 = r8.q4
                r0 = 2131362540(0x7f0a02ec, float:1.8344863E38)
                android.view.View r9 = r9.findViewById(r0)
                androidx.appcompat.widget.SearchView r9 = (androidx.appcompat.widget.SearchView) r9
                r8.s4 = r9
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 26
                r3 = 8
                if (r0 < r2) goto L_0x003b
                r9.setImportantForAutofill(r3)
            L_0x003b:
                androidx.appcompat.widget.SearchView r9 = r8.s4
                r9.setVisibility(r3)
                android.view.View r9 = r8.q4
                r0 = 2131362493(0x7f0a02bd, float:1.8344768E38)
                android.view.View r9 = r9.findViewById(r0)
                androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9
                r8.w4 = r9
                android.view.View r9 = r8.q4
                r0 = 2131361934(0x7f0a008e, float:1.8343634E38)
                android.view.View r9 = r9.findViewById(r0)
                com.google.android.material.appbar.AppBarLayout r9 = (com.google.android.material.appbar.AppBarLayout) r9
                android.view.View r0 = r8.q4
                r2 = 2131361947(0x7f0a009b, float:1.834366E38)
                android.view.View r0 = r0.findViewById(r2)
                android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
                r9.D(r1, r1)
                net.imedicaldoctor.imd.Fragments.LexiInteract.LXIVInteractResult$LXIvInteractResultFragment$1 r2 = new net.imedicaldoctor.imd.Fragments.LexiInteract.LXIVInteractResult$LXIvInteractResultFragment$1
                r2.<init>(r0)
                r3 = 800(0x320, double:3.953E-321)
                r9.postDelayed(r2, r3)
                android.os.Bundle r9 = r8.y()
                java.lang.String r0 = "Drugs"
                boolean r9 = r9.containsKey(r0)
                if (r9 == 0) goto L_0x00b8
                android.os.Bundle r9 = r8.y()
                java.util.ArrayList r9 = r9.getParcelableArrayList(r0)
                r8.B4 = r9
                android.os.Bundle r9 = r8.y()
                java.lang.String r0 = "Sites"
                java.util.ArrayList r9 = r9.getParcelableArrayList(r0)
                r8.C4 = r9
                android.os.Bundle r9 = r8.y()
                java.lang.String r0 = "Solutions"
                java.util.ArrayList r9 = r9.getParcelableArrayList(r0)
                r8.D4 = r9
                android.os.Bundle r9 = r8.y()
                java.lang.String r0 = "Warning"
                boolean r9 = r9.containsKey(r0)
                if (r9 == 0) goto L_0x00b5
                android.os.Bundle r9 = r8.y()
                java.lang.String r9 = r9.getString(r0)
                r8.F4 = r9
                goto L_0x00ce
            L_0x00b5:
                r8.F4 = r10
                goto L_0x00ce
            L_0x00b8:
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                r8.B4 = r9
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                r8.C4 = r9
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                r8.D4 = r9
                goto L_0x00b5
            L_0x00ce:
                if (r11 == 0) goto L_0x00ff
                java.lang.String r9 = "mInteractionSections"
                boolean r10 = r11.containsKey(r9)
                if (r10 == 0) goto L_0x00ff
                java.util.ArrayList r9 = r11.getParcelableArrayList(r9)
                r8.A4 = r9
                java.lang.String r9 = "mDrugs"
                java.util.ArrayList r9 = r11.getParcelableArrayList(r9)
                r8.B4 = r9
                java.lang.String r9 = "mSites"
                java.util.ArrayList r9 = r11.getParcelableArrayList(r9)
                r8.C4 = r9
                java.lang.String r9 = "mSolutions"
                java.util.ArrayList r9 = r11.getParcelableArrayList(r9)
                r8.D4 = r9
                java.lang.String r9 = "mWarning"
                java.lang.String r9 = r11.getString(r9)
                r8.F4 = r9
                goto L_0x0170
            L_0x00ff:
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                java.util.ArrayList<android.os.Bundle> r9 = r8.B4
                java.lang.String r10 = "rowid"
                java.lang.String r9 = net.imedicaldoctor.imd.Data.CompressHelper.I1(r9, r10)
                java.util.ArrayList<android.os.Bundle> r10 = r8.C4
                java.lang.String r11 = "id"
                java.lang.String r10 = net.imedicaldoctor.imd.Data.CompressHelper.I1(r10, r11)
                java.util.ArrayList<android.os.Bundle> r0 = r8.D4
                java.lang.String r11 = net.imedicaldoctor.imd.Data.CompressHelper.I1(r0, r11)
                net.imedicaldoctor.imd.Data.CompressHelper r0 = r8.k4
                android.os.Bundle r2 = r8.h4
                java.lang.String r3 = "drop table if exists temp_generic;"
                r0.m(r2, r3)
                net.imedicaldoctor.imd.Data.CompressHelper r0 = r8.k4
                android.os.Bundle r2 = r8.h4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "create table temp_generic as select i.rowid as rowid, i.generic_id as id, i.name as name from item i where i.rowid in ("
                r3.append(r4)
                r3.append(r9)
                java.lang.String r9 = ")"
                r3.append(r9)
                java.lang.String r9 = r3.toString()
                r0.m(r2, r9)
                net.imedicaldoctor.imd.Data.CompressHelper r9 = r8.k4
                android.os.Bundle r0 = r8.h4
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "select distinct p.document_id, p.level, g1.rowid, g1.name as text1, g1.id, g2.rowid, g2.name as text2, g2.id from temp_generic g1 join temp_generic g2 on g2.id != g1.id join pair p on p.generic1_id = g1.id and p.generic2_id = g2.id join ivsolution iv on p.document_id = iv.document_id left join fieldtypesite f on iv.fieldtype_id = f.fieldtype_id where f.site_id in ("
                r2.append(r3)
                r2.append(r10)
                java.lang.String r10 = ") and iv.solution_id in ("
                r2.append(r10)
                r2.append(r11)
                java.lang.String r10 = ") order by p.level asc, g1.name, g2.name"
                r2.append(r10)
                java.lang.String r10 = r2.toString()
                java.util.ArrayList r9 = r9.V(r0, r10)
                net.imedicaldoctor.imd.Data.CompressHelper r10 = r8.k4
                java.lang.String r11 = "level"
                java.util.ArrayList r9 = r10.r2(r9, r11)
                r8.A4 = r9
            L_0x0170:
                net.imedicaldoctor.imd.Fragments.LexiInteract.LXIVInteractResult$LXIvInteractResultFragment$2 r9 = new net.imedicaldoctor.imd.Fragments.LexiInteract.LXIVInteractResult$LXIvInteractResultFragment$2
                androidx.fragment.app.FragmentActivity r4 = r8.r()
                java.util.ArrayList<android.os.Bundle> r5 = r8.A4
                java.lang.String r6 = "title"
                r7 = 2131558641(0x7f0d00f1, float:1.8742604E38)
                r2 = r9
                r3 = r8
                r2.<init>(r4, r5, r6, r7)
                r8.E4 = r9
                java.lang.String r10 = "No Information Found"
                r9.f30479i = r10
                androidx.recyclerview.widget.RecyclerView r10 = r8.w4
                r10.setAdapter(r9)
                r8.N2()
                r8.o2(r1)
                r8.V2()
                android.view.View r9 = r8.q4
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.LexiInteract.LXIVInteractResult.LXIvInteractResultFragment.U0(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
        }

        public Bundle i3(int i2, ArrayList<Bundle> arrayList) {
            Iterator<Bundle> it2 = arrayList.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                Bundle next = it2.next();
                if (i2 == i3) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Title", next.getString("title"));
                    return bundle;
                }
                int size = i3 + next.getParcelableArrayList("items").size();
                if (i2 <= size) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("Item", (Bundle) next.getParcelableArrayList("items").get((i2 - (size - next.getParcelableArrayList("items").size())) - 1));
                    return bundle2;
                }
                i3 = size + 1;
            }
            return null;
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public int n3(ArrayList<Bundle> arrayList) {
            int i2 = 0;
            if (arrayList == null) {
                return 0;
            }
            Iterator<Bundle> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                i2 = i2 + it2.next().getParcelableArrayList("items").size() + 1;
            }
            return i2;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new LXIvInteractResultFragment());
    }
}
