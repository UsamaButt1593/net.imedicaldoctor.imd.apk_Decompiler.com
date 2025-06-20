package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;

public class EPOMainActivityFragment extends SearchHelperFragment {
    public GridLayoutManager A4;
    public SpellSearchAdapter B4;
    private CustomItemDecoration C4;

    public static class CardViewPlaceHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;
        /* access modifiers changed from: private */
        public final ImageView J;
        /* access modifiers changed from: private */
        public final MaterialRippleLayout K;

        public CardViewPlaceHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1132text_view);
            this.J = (ImageView) view.findViewById(R.id.f980image_view);
            this.K = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        }
    }

    public class CollectionAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        HashMap<String, Integer> f29755d = new HashMap<>();

        public CollectionAdapter() {
        }

        public long B(int i2) {
            return (long) i2;
        }

        public int C(int i2) {
            return i2 < EPOMainActivityFragment.this.n4.size() ? 0 : 1;
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            SwitchCompat j0;
            CompoundButton.OnCheckedChangeListener r6;
            if (viewHolder.F() == 0) {
                final Bundle bundle = EPOMainActivityFragment.this.n4.get(i2);
                CardViewPlaceHolder cardViewPlaceHolder = (CardViewPlaceHolder) viewHolder;
                cardViewPlaceHolder.I.setText(bundle.getString("Title"));
                cardViewPlaceHolder.J.setImageDrawable(EPOMainActivityFragment.this.r().getResources().getDrawable(bundle.getInt("Image")));
                cardViewPlaceHolder.K.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CompressHelper compressHelper;
                        Class cls;
                        Class cls2;
                        String string = bundle.getString("Type");
                        Bundle bundle = new Bundle();
                        bundle.putBundle("DB", EPOMainActivityFragment.this.h4);
                        if (string.equals("dx")) {
                            compressHelper = EPOMainActivityFragment.this.k4;
                            cls = EPODxListActivity.class;
                            cls2 = EPODxListActivityFragment.class;
                        } else if (string.equals("lab")) {
                            compressHelper = EPOMainActivityFragment.this.k4;
                            cls = EPOLabListActivity.class;
                            cls2 = EPOLabListActivityFragment.class;
                        } else if (string.equals("rx")) {
                            compressHelper = EPOMainActivityFragment.this.k4;
                            cls = EPORxListActivity.class;
                            cls2 = EPORxListActivityFragment.class;
                        } else if (string.equals("interact")) {
                            compressHelper = EPOMainActivityFragment.this.k4;
                            cls = EPOInteractActivity.class;
                            cls2 = EPOInteractActivityFragment.class;
                        } else if (string.equals("id")) {
                            compressHelper = EPOMainActivityFragment.this.k4;
                            cls = EPOIDListActivity.class;
                            cls2 = EPOIDListActivityFragment.class;
                        } else if (string.equals("guideline")) {
                            EPOMainActivityFragment.this.k4.P("https://www.epocrates.com/e/guidelines/list/view?cid=ListGuidelines");
                            return;
                        } else if (string.equals("table")) {
                            compressHelper = EPOMainActivityFragment.this.k4;
                            cls = EPOTableListActivity.class;
                            cls2 = EPOTableListActivityFragment.class;
                        } else if (string.equals("pillid")) {
                            compressHelper = EPOMainActivityFragment.this.k4;
                            cls = EPOPillActivity.class;
                            cls2 = EPOPillActivityFragment.class;
                        } else {
                            return;
                        }
                        compressHelper.N(cls, cls2, bundle);
                    }
                });
            } else if (viewHolder.F() == 1) {
                SwitchPlaceHolder switchPlaceHolder = (SwitchPlaceHolder) viewHolder;
                if (i2 - EPOMainActivityFragment.this.n4.size() == 0) {
                    switchPlaceHolder.I.setText("Show Disease Monograph as List");
                    switchPlaceHolder.J.setChecked(EPOMainActivityFragment.this.V1().getSharedPreferences("default_preferences", 0).getBoolean("DiseaseList", false));
                    j0 = switchPlaceHolder.J;
                    r6 = new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            EPOMainActivityFragment.this.V1().getSharedPreferences("default_preferences", 0).edit().putBoolean("DiseaseList", z).commit();
                        }
                    };
                } else {
                    switchPlaceHolder.I.setText("Show Lab Monograph as List");
                    switchPlaceHolder.J.setChecked(EPOMainActivityFragment.this.V1().getSharedPreferences("default_preferences", 0).getBoolean("LabList", true));
                    j0 = switchPlaceHolder.J;
                    r6 = new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            EPOMainActivityFragment.this.V1().getSharedPreferences("default_preferences", 0).edit().putBoolean("LabList", z).commit();
                        }
                    };
                }
                j0.setOnCheckedChangeListener(r6);
            }
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new CardViewPlaceHolder(LayoutInflater.from(EPOMainActivityFragment.this.r()).inflate(R.layout.f1304list_view_item_card_view_epocrate, viewGroup, false));
            }
            if (i2 == 1) {
                return new SwitchPlaceHolder(LayoutInflater.from(EPOMainActivityFragment.this.r()).inflate(R.layout.f1377list_view_item_switch, viewGroup, false));
            }
            return null;
        }

        public int b() {
            return EPOMainActivityFragment.this.n4.size() + 2;
        }
    }

    public static class SwitchPlaceHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;
        /* access modifiers changed from: private */
        public final SwitchCompat J;

        public SwitchPlaceHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1132text_view);
            this.J = (SwitchCompat) view.findViewById(R.id.f1102switch_view);
        }
    }

    private Bundle i3(String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("Title", str);
        bundle.putString("Type", str2);
        bundle.putInt("Image", i2);
        return bundle;
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q4 = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        Q2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        ((RelativeLayout) this.q4.findViewById(R.id.f830background_layout)).setVisibility(0);
        ArrayList<Bundle> arrayList = new ArrayList<>();
        this.n4 = arrayList;
        arrayList.add(i3("Diseases", "dx", R.drawable.f629diseases_icon));
        this.n4.add(i3("Drugs", "rx", R.drawable.f632drugs_icon));
        this.n4.add(i3("Labs", "lab", R.drawable.f672labs_icon));
        this.n4.add(i3("Drug Interactions", "interact", R.drawable.f666interaction_check_icon));
        this.n4.add(i3("Infectious Disease Treatment", "id", R.drawable.f658id_tx_icon));
        this.n4.add(i3("Guidelines", "guideline", R.drawable.f641guidelines_icon));
        this.n4.add(i3("Tables", "table", R.drawable.f761tables_icon));
        this.n4.add(i3("Pill ID", "pillid", R.drawable.f714pill_id_icon));
        CollectionAdapter collectionAdapter = new CollectionAdapter();
        this.l4 = collectionAdapter;
        this.w4.setAdapter(collectionAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(r(), 2);
        this.A4 = gridLayoutManager;
        gridLayoutManager.R3(new GridLayoutManager.SpanSizeLookup() {
            public int f(int i2) {
                RecyclerView.Adapter adapter = EPOMainActivityFragment.this.w4.getAdapter();
                EPOMainActivityFragment ePOMainActivityFragment = EPOMainActivityFragment.this;
                return (adapter != ePOMainActivityFragment.B4 && i2 <= ePOMainActivityFragment.n4.size() - 1) ? 1 : 2;
            }
        });
        this.B4 = new SpellSearchAdapter(r(), this.o4, "text", (String) null, R.layout.f1346list_view_item_ripple_text_full) {
            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                rippleTextFullViewHolder.I.setText(bundle.getString("text"));
                rippleTextFullViewHolder.J.setText(bundle.getString(Annotation.i3));
                int i3 = 0;
                if (bundle.getString(Annotation.i3).length() == 0) {
                    rippleTextFullViewHolder.J.setVisibility(8);
                } else {
                    rippleTextFullViewHolder.J.setVisibility(0);
                }
                String string = bundle.getString("type");
                String string2 = bundle.getString("typeText");
                if (string2.equals("Dx")) {
                    i3 = R.drawable.t9;
                } else if (string2.equals("Rx")) {
                    i3 = string.equals("7") ? R.drawable.p9 : string.equals("6") ? R.drawable.A9 : R.drawable.D9;
                } else if (string2.equals("ID")) {
                    i3 = R.drawable.x9;
                } else if (string2.equals("Lab")) {
                    i3 = R.drawable.z9;
                } else if (string2.equals("Guideline")) {
                    i3 = R.drawable.u9;
                } else if (string2.equals("Table")) {
                    i3 = R.drawable.E9;
                }
                rippleTextFullViewHolder.K.setImageDrawable(EPOMainActivityFragment.this.r().getResources().getDrawable(i3));
                rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CompressHelper compressHelper;
                        Bundle bundle;
                        StringBuilder sb;
                        String str;
                        EPOMainActivityFragment.this.V2();
                        String string = bundle.getString("typeText");
                        String string2 = bundle.getString("contentId");
                        if (string.equals("Dx")) {
                            EPOMainActivityFragment ePOMainActivityFragment = EPOMainActivityFragment.this;
                            compressHelper = ePOMainActivityFragment.k4;
                            bundle = ePOMainActivityFragment.h4;
                            sb = new StringBuilder();
                            str = "dx-";
                        } else if (string.equals("Rx")) {
                            EPOMainActivityFragment ePOMainActivityFragment2 = EPOMainActivityFragment.this;
                            compressHelper = ePOMainActivityFragment2.k4;
                            bundle = ePOMainActivityFragment2.h4;
                            sb = new StringBuilder();
                            str = "rx-";
                        } else if (string.equals("ID")) {
                            EPOMainActivityFragment ePOMainActivityFragment3 = EPOMainActivityFragment.this;
                            compressHelper = ePOMainActivityFragment3.k4;
                            bundle = ePOMainActivityFragment3.h4;
                            sb = new StringBuilder();
                            str = "id-";
                        } else if (string.equals("Lab")) {
                            EPOMainActivityFragment ePOMainActivityFragment4 = EPOMainActivityFragment.this;
                            compressHelper = ePOMainActivityFragment4.k4;
                            bundle = ePOMainActivityFragment4.h4;
                            sb = new StringBuilder();
                            str = "lab-";
                        } else if (string.equals("Guideline")) {
                            EPOMainActivityFragment ePOMainActivityFragment5 = EPOMainActivityFragment.this;
                            compressHelper = ePOMainActivityFragment5.k4;
                            bundle = ePOMainActivityFragment5.h4;
                            sb = new StringBuilder();
                            str = "guideline-";
                        } else if (string.equals("Table")) {
                            EPOMainActivityFragment ePOMainActivityFragment6 = EPOMainActivityFragment.this;
                            compressHelper = ePOMainActivityFragment6.k4;
                            bundle = ePOMainActivityFragment6.h4;
                            sb = new StringBuilder();
                            str = "table-";
                        } else {
                            return;
                        }
                        sb.append(str);
                        sb.append(string2);
                        compressHelper.A1(bundle, sb.toString(), (String[]) null, (String) null);
                    }
                });
            }

            public void h0(Bundle bundle) {
                EPOMainActivityFragment.this.V2();
                EPOMainActivityFragment.this.s4.k0(bundle.getString("word"), true);
            }

            public RecyclerView.ViewHolder j0(View view) {
                return new RippleTextFullViewHolder(view);
            }
        };
        this.C4 = new CustomItemDecoration(r());
        this.w4.setLayoutManager(this.A4);
        this.w4.setItemAnimator(new DefaultItemAnimator());
        return this.q4;
    }

    public void X2() {
        try {
            this.w4.A1(this.C4);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        this.w4.p(this.C4);
        this.B4.i0(this.o4, this.p4);
        this.w4.setAdapter(this.B4);
    }

    public void Z2() {
        try {
            this.w4.A1(this.C4);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    public ArrayList<Bundle> a3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select * from search where search match '(text:" + str + "* OR content:" + str + "*) NOT (type:5)'");
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }
}
