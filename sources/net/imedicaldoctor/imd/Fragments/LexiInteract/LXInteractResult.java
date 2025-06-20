package net.imedicaldoctor.imd.Fragments.LexiInteract;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.NotStickySectionAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import net.imedicaldoctor.imd.iMDActivity;

public class LXInteractResult extends iMDActivity {

    public static class LXInteractResultFragment extends SearchHelperFragment {
        private ArrayList<Bundle> A4;
        private ArrayList<Bundle> B4;
        public NotStickySectionAdapter C4;

        public class HeaderViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public final TextView f29798a;

            public HeaderViewHolder(View view) {
                this.f29798a = (TextView) view.findViewById(R.id.f957header_text);
            }
        }

        public class InteractionViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public final TextView f29800a;

            /* renamed from: b  reason: collision with root package name */
            public final ImageView f29801b;

            /* renamed from: c  reason: collision with root package name */
            public final TextView f29802c;

            public InteractionViewHolder(View view) {
                this.f29802c = (TextView) view.findViewById(R.id.f925drug_two_text);
                this.f29800a = (TextView) view.findViewById(R.id.f924drug_one_text);
                this.f29801b = (ImageView) view.findViewById(R.id.image);
            }
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            CompressHelper compressHelper;
            Bundle bundle2;
            String str;
            View view = this.q4;
            if (view != null) {
                return view;
            }
            this.q4 = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
            W2(bundle);
            S2();
            String str2 = "";
            this.u4.setText(str2);
            this.r4.setTitle((CharSequence) "Interaction Results");
            SearchView searchView = (SearchView) this.q4.findViewById(R.id.f1069search_view);
            this.s4 = searchView;
            if (Build.VERSION.SDK_INT >= 26) {
                searchView.setImportantForAutofill(8);
            }
            this.s4.setVisibility(8);
            this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
            AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
            final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
            appBarLayout.D(false, false);
            appBarLayout.postDelayed(new Runnable() {
                public void run() {
                    relativeLayout.setVisibility(0);
                }
            }, 800);
            this.B4 = y().containsKey("Drugs") ? y().getParcelableArrayList("Drugs") : new ArrayList<>();
            if (bundle == null || !bundle.containsKey("mInteractionSections")) {
                new ArrayList();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Iterator<Bundle> it2 = this.B4.iterator();
                while (it2.hasNext()) {
                    Bundle next = it2.next();
                    arrayList2.add(next.getString("id"));
                    if (next.getString("brand_id").length() > 0) {
                        arrayList.add(next.getString("brand_id"));
                    }
                }
                String join = TextUtils.join(",", arrayList2);
                if (arrayList.size() > 0) {
                    str2 = TextUtils.join(",", arrayList);
                }
                this.k4.m(this.h4, "drop table if exists temp_categories;");
                CompressHelper compressHelper2 = this.k4;
                Bundle bundle3 = this.h4;
                compressHelper2.m(bundle3, "create table temp_categories as select c.id as id, b.generic_id as generic_id, b.name as name, b.id as brand_id from category c,category_generic_xref cgx, brand b where cgx.generic_id = b.generic_id and b.id in (" + str2 + ") and c.id = cgx.category_id union select c.id as id, cgx.generic_id as generic_id, g.name as name, cast(null as integer) as brand_id from category c, category_generic_xref cgx, generic g where cgx.generic_id in (" + join + ") and c.id = cgx.category_id and g.id = cgx.generic_id");
                if (this.B4.size() == 1) {
                    compressHelper = this.k4;
                    bundle2 = this.h4;
                    str = "select m.id as id, m.risk as risk, c1.name as text1, t.generic_id, t.brand_id, c2.name as text2, m.filter                              from temp_categories t         join monograph m on (m.object_id = t.id)         join category c1 on (c1.id = m.object_id)         join category c2 on (c2.id = m.precipitant_id)         where not exists (select mgx.monograph_id from monograph_generic_exception_xref mgx                           where mgx.generic_id = t.generic_id                           and mgx.category_id = t.id                           and mgx.monograph_id = m.id)         and not exists (select mbx.monograph_id from monograph_brand_exception_xref mbx                         where mbx.brand_id = t.brand_id                         and mbx.monograph_id = m.id)         union         select m.id, m.risk as risk, c1.name as text1, t.generic_id, t.brand_id, c2.name as text2, m.filter         from temp_categories t         join monograph m on (m.precipitant_id = t.id)         join category c1 on (c1.id = m.object_id)         join category c2 on (c2.id = m.precipitant_id)         where not exists (select mgx.monograph_id from monograph_generic_exception_xref mgx                           where mgx.generic_id = t.generic_id                           and mgx.category_id = t.id                            and mgx.monograph_id = m.id)          and not exists (select mbx.monograph_id from monograph_brand_exception_xref mbx                          where mbx.brand_id = t.brand_id                          and mbx.monograph_id = m.id)          order by risk desc, text1, text2";
                } else {
                    compressHelper = this.k4;
                    bundle2 = this.h4;
                    str = "select m.id, m.risk as risk, c1.name as text1, c1.generic_id, c1.brand_id, c2.name as text2, c2.generic_id, c2.brand_id, m.filter                            from temp_categories c1                            join temp_categories c2 on (c1.generic_id != c2.generic_id)                            join monograph m on (m.object_id = c1.id and m.precipitant_id = c2.id)                            and not exists (                                            select mgx.monograph_id from monograph_generic_exception_xref mgx                                            where (mgx.generic_id = c1.generic_id and mgx.category_id = c1.id or mgx .generic_id = c2.generic_id and mgx.category_id = c2.id)                                            and mgx.monograph_id = m.id )                            and not exists (                                             select mbx.monograph_id                                            from monograph_brand_exception_xref mbx                                            where mbx.brand_id = c1.brand_id or mbx.brand_id = c2.brand_id and mbx.monograph_id = m.id ) group by m.id                           order by m.risk desc, text1, text2";
                }
                this.A4 = this.k4.r2(compressHelper.V(bundle2, str), "risk");
            } else {
                this.A4 = bundle.getParcelableArrayList("mInteractionSections");
                this.B4 = bundle.getParcelableArrayList("mDrugs");
            }
            AnonymousClass2 r2 = new NotStickySectionAdapter(r(), this.A4, "title", R.layout.f1346list_view_item_ripple_text_full) {
                public void f0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                    RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                    String string = bundle.getString("text1");
                    String string2 = bundle.getString("text2");
                    rippleTextFullViewHolder.I.setText(string);
                    rippleTextFullViewHolder.J.setText(string2);
                    String string3 = bundle.getString("risk");
                    rippleTextFullViewHolder.K.setImageDrawable(LXInteractResultFragment.this.b0().getDrawable(string3.equals("5") ? R.drawable.fb : string3.equals("4") ? R.drawable.G3 : string3.equals(ExifInterface.Z4) ? R.drawable.U2 : string3.equals(ExifInterface.Y4) ? R.drawable.S1 : string3.equals(IcyHeaders.a3) ? R.drawable.B0 : 0));
                    rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            LXInteractResultFragment lXInteractResultFragment = LXInteractResultFragment.this;
                            CompressHelper compressHelper = lXInteractResultFragment.k4;
                            Bundle bundle = lXInteractResultFragment.h4;
                            Bundle s1 = compressHelper.s1(compressHelper.V(bundle, "SELECT                                                   o.name||' / '||p.name as title,                                                   m.risk                as risk,                                                   m.summary             as summary,                                                   s.severity            as severity,                                                   onset.onset           as onset,                                                   r.reliability         as reliability,                                                   m.management          as management,                                                   m.discussion          as discussion,                                                   m.footnotes           as footnotes,                                                    m.dependencies                                                   as dependencies                                                    FROM monograph m                                                    JOIN severity s ON s.id = m.severity_id                                                    JOIN category o ON o.id = m.object_id                                                   JOIN category p ON p.id = m.precipitant_id                                                    JOIN reliability r ON r.id = m.reliability_id                                                   LEFT JOIN onset ON onset.id = m.onset_id                                                   WHERE m.id = " + bundle.getString("id")));
                            LXInteractResultFragment lXInteractResultFragment2 = LXInteractResultFragment.this;
                            CompressHelper compressHelper2 = lXInteractResultFragment2.k4;
                            Bundle bundle2 = lXInteractResultFragment2.h4;
                            ArrayList<Bundle> V = compressHelper2.V(bundle2, "select c.name, c.id, g.name, g.id, mgx.category_id from monograph m join category c on m.object_id = c.id join category_generic_xref cgx on cgx.category_id = c.id join generic g on g.id = cgx.generic_id and not g.combination left join monograph_generic_exception_xref mgx on mgx.monograph_id = m.id and mgx.category_id = c.id and mgx.generic_id = g.id  where m.id = " + bundle.getString("id") + " union select c.name, c.id, g.name, g.id, mgx.category_id  from monograph m join category c on m.precipitant_id = c.id  join category_generic_xref cgx on cgx.category_id = c.id  join generic g on g.id = cgx.generic_id and not g.combination  left join monograph_generic_exception_xref mgx on mgx.monograph_id = m.id and mgx.category_id = c.id and mgx.generic_id = g.id  where m.id = " + bundle.getString("id") + ";");
                            Bundle bundle3 = new Bundle();
                            bundle3.putBundle("monograph", s1);
                            bundle3.putParcelableArrayList("monographMembers", V);
                            bundle3.putBundle("monographItem", bundle);
                            bundle3.putInt("Mode", 1);
                            LXInteractResultFragment lXInteractResultFragment3 = LXInteractResultFragment.this;
                            lXInteractResultFragment3.k4.B1(lXInteractResultFragment3.h4, bundle.getString("id"), (String[]) null, (String) null, bundle3);
                        }
                    });
                }

                public String i0(String str) {
                    if (str.equals("5")) {
                        return "X: Avoid combination";
                    }
                    if (str.equals("4")) {
                        return "D: Consider therapy modification";
                    }
                    if (str.equals(ExifInterface.Z4)) {
                        return "C: Monitor therapy";
                    }
                    if (str.equals(ExifInterface.Y4)) {
                        return "B: No action needed";
                    }
                    return str.equals(IcyHeaders.a3) ? "A: No known interaction" : str;
                }

                public RecyclerView.ViewHolder k0(View view) {
                    return new RippleTextFullViewHolder(view);
                }
            };
            this.C4 = r2;
            r2.f30479i = "No Interactions Found";
            this.w4.setAdapter(r2);
            N2();
            o2(false);
            V2();
            return this.q4;
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new LXInteractResultFragment());
    }
}
