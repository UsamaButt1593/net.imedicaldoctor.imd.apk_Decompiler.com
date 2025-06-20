package net.imedicaldoctor.imd.Fragments.VisualDDX;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.NotStickySectionAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextArrowViewHolder;
import net.imedicaldoctor.imd.iMDActivity;
import net.imedicaldoctor.imd.iMDLogger;
import org.json.JSONArray;

public class VDDxScenarioActivity extends iMDActivity {

    public static class VDDxScenarioFragment extends SearchHelperFragment {
        private ListAdapter A4;
        private int B4;

        public class DatabaseHeaderViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public final TextView f30040a;

            public DatabaseHeaderViewHolder(View view) {
                this.f30040a = (TextView) view.findViewById(R.id.f957header_text);
            }
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
            this.q4 = inflate;
            W2(bundle);
            S2();
            this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
            Q2();
            this.s4.setVisibility(8);
            this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
            String g1 = CompressHelper.g1(this.h4, "focusAreaList.json");
            final CompressHelper compressHelper = new CompressHelper(r());
            try {
                ArrayList<Bundle> F = compressHelper.F(new JSONArray(CompressHelper.e2(new File(g1))));
                AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
                final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
                if (y() == null || !y().containsKey("Parent")) {
                    appBarLayout.D(true, false);
                    relativeLayout.setVisibility(0);
                    this.B4 = 0;
                } else {
                    this.B4 = y().getInt("Parent");
                    appBarLayout.D(false, false);
                    appBarLayout.postDelayed(new Runnable() {
                        public void run() {
                            relativeLayout.setVisibility(0);
                        }
                    }, 800);
                }
                this.B4--;
                ArrayList arrayList = new ArrayList();
                int i2 = this.B4;
                if (i2 == -1) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("title", "Select A Clinical Scenario");
                    bundle2.putParcelableArrayList("items", F);
                    arrayList.add(bundle2);
                } else {
                    int size = F.get(i2).getParcelableArrayList("children").size();
                    for (int i3 = 0; i3 < size; i3++) {
                        Bundle bundle3 = new Bundle();
                        Bundle bundle4 = (Bundle) F.get(this.B4).getParcelableArrayList("children").get(i3);
                        bundle3.putString("title", bundle4.getString("name"));
                        bundle3.putParcelableArrayList("items", bundle4.getParcelableArrayList("children"));
                        arrayList.add(bundle3);
                    }
                }
                this.l4 = new NotStickySectionAdapter(r(), arrayList, "title", R.layout.f1343list_view_item_ripple_text_arrow) {
                    public void f0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                        MaterialRippleLayout materialRippleLayout;
                        View.OnClickListener r4;
                        RippleTextArrowViewHolder rippleTextArrowViewHolder = (RippleTextArrowViewHolder) viewHolder;
                        rippleTextArrowViewHolder.I.setText(bundle.getString("name"));
                        if (bundle.getString("moduleId").equals("-1")) {
                            rippleTextArrowViewHolder.K.setVisibility(0);
                            materialRippleLayout = rippleTextArrowViewHolder.J;
                            r4 = new View.OnClickListener() {
                                public void onClick(View view) {
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("Parent", bundle.getInt("Index") + 1);
                                    bundle.putBundle("DB", VDDxScenarioFragment.this.h4);
                                    compressHelper.N(VDDxScenarioActivity.class, VDDxScenarioFragment.class, bundle);
                                }
                            };
                        } else {
                            rippleTextArrowViewHolder.K.setVisibility(8);
                            materialRippleLayout = rippleTextArrowViewHolder.J;
                            r4 = new View.OnClickListener() {
                                public void onClick(View view) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBundle("moduleInfo", bundle);
                                    AnonymousClass2 r7 = AnonymousClass2.this;
                                    compressHelper.B1(VDDxScenarioFragment.this.h4, bundle.getString("moduleId"), (String[]) null, (String) null, bundle);
                                }
                            };
                        }
                        materialRippleLayout.setOnClickListener(r4);
                    }

                    public RecyclerView.ViewHolder k0(View view) {
                        return new RippleTextArrowViewHolder(view);
                    }
                };
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f("JSON error", "Error in Parsing " + g1);
            }
            this.w4.setAdapter(this.l4);
            N2();
            o2(false);
            return inflate;
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
                    int size2 = (i2 - (size - next.getParcelableArrayList("items").size())) - 1;
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("Item", (Bundle) next.getParcelableArrayList("items").get(size2));
                    bundle2.putInt("Index", size2);
                    return bundle2;
                }
                i3 = size + 1;
            }
            return null;
        }

        public int j3(ArrayList<Bundle> arrayList) {
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
        a1(bundle, new VDDxScenarioFragment());
    }
}
