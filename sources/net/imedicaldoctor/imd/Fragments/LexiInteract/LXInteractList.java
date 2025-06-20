package net.imedicaldoctor.imd.Fragments.LexiInteract;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.LexiInteract.LXInteractResult;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullDeleteViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;
import net.imedicaldoctor.imd.iMDActivity;

public class LXInteractList extends iMDActivity {

    public static class LXInteractListFragment extends SearchHelperFragment {
        private ArrayAdapter<Bundle> A4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> B4;
        /* access modifiers changed from: private */
        public ArrayList<String> C4;
        public Button D4;
        public SpellSearchAdapter E4;

        private void l3() {
            if (this.B4.size() == 0) {
                f3("Search to add Drugs");
            } else {
                e3();
            }
        }

        public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            ArrayList<String> arrayList;
            View view = this.q4;
            if (view != null) {
                return view;
            }
            this.q4 = layoutInflater.inflate(R.layout.f1227fragment_epointeract, viewGroup, false);
            if (bundle == null || !bundle.containsKey("mDrugs")) {
                this.B4 = new ArrayList<>();
                arrayList = new ArrayList<>();
            } else {
                this.B4 = bundle.getParcelableArrayList("mDrugs");
                arrayList = bundle.getStringArrayList("mIds");
            }
            this.C4 = arrayList;
            W2(bundle);
            S2();
            this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
            Q2();
            this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
            AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
            final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
            appBarLayout.D(false, false);
            appBarLayout.postDelayed(new Runnable() {
                public void run() {
                    relativeLayout.setVisibility(0);
                }
            }, 800);
            Button button = (Button) this.q4.findViewById(R.id.f1060result_button);
            this.D4 = button;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (LXInteractListFragment.this.B4.size() == 0) {
                        CompressHelper.x2(LXInteractListFragment.this.r(), "There is no drug added", 1);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("Drugs", LXInteractListFragment.this.B4);
                    bundle.putBundle("DB", LXInteractListFragment.this.h4);
                    new CompressHelper(LXInteractListFragment.this.r()).N(LXInteractResult.class, LXInteractResult.LXInteractResultFragment.class, bundle);
                }
            });
            AnonymousClass3 r2 = new ChaptersAdapter(r(), this.B4, "name", R.layout.f1347list_view_item_ripple_text_full_delete) {
                public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                    RippleTextFullDeleteViewHolder rippleTextFullDeleteViewHolder = (RippleTextFullDeleteViewHolder) viewHolder;
                    rippleTextFullDeleteViewHolder.I.setText(bundle.getString("name"));
                    rippleTextFullDeleteViewHolder.N.setVisibility(0);
                    rippleTextFullDeleteViewHolder.L.setVisibility(0);
                    final String string = bundle.getString("id");
                    rippleTextFullDeleteViewHolder.M.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            LXInteractListFragment.this.V2();
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(bundle);
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("Drugs", arrayList);
                            bundle.putBundle("DB", LXInteractListFragment.this.h4);
                            new CompressHelper(LXInteractListFragment.this.r()).N(LXInteractResult.class, LXInteractResult.LXInteractResultFragment.class, bundle);
                        }
                    });
                    rippleTextFullDeleteViewHolder.N.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            LXInteractListFragment.this.B4.remove(bundle);
                            LXInteractListFragment.this.C4.remove(string);
                            LXInteractListFragment lXInteractListFragment = LXInteractListFragment.this;
                            ((ChaptersAdapter) lXInteractListFragment.l4).g0(lXInteractListFragment.B4);
                            LXInteractListFragment.this.k3();
                            LXInteractListFragment.this.l4.G();
                            LXInteractListFragment lXInteractListFragment2 = LXInteractListFragment.this;
                            lXInteractListFragment2.w4.setAdapter(lXInteractListFragment2.l4);
                        }
                    });
                }

                public RecyclerView.ViewHolder h0(View view) {
                    RippleTextFullDeleteViewHolder rippleTextFullDeleteViewHolder = new RippleTextFullDeleteViewHolder(view);
                    rippleTextFullDeleteViewHolder.K.setVisibility(8);
                    rippleTextFullDeleteViewHolder.J.setVisibility(8);
                    return rippleTextFullDeleteViewHolder;
                }
            };
            this.l4 = r2;
            r2.f30463h = "Search To Add Drug";
            this.E4 = new SpellSearchAdapter(r(), this.o4, "name", (String) null, R.layout.f1346list_view_item_ripple_text_full) {
                public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                    RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                    rippleTextFullViewHolder.I.setText(bundle.getString("name"));
                    rippleTextFullViewHolder.L.setVisibility(8);
                    final String string = bundle.getString("id");
                    if (LXInteractListFragment.this.C4.contains(string)) {
                        rippleTextFullViewHolder.I.setTextColor(Color.rgb(TsExtractor.L, TsExtractor.L, TsExtractor.L));
                        return;
                    }
                    rippleTextFullViewHolder.I.setTextColor(Color.rgb(0, 0, 0));
                    rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            LXInteractListFragment.this.V2();
                            LXInteractListFragment.this.B4.add(bundle);
                            LXInteractListFragment.this.C4.add(string);
                            LXInteractListFragment.this.s4.k0("", false);
                            LXInteractListFragment lXInteractListFragment = LXInteractListFragment.this;
                            ((ChaptersAdapter) lXInteractListFragment.l4).g0(lXInteractListFragment.B4);
                            LXInteractListFragment.this.l4.G();
                            LXInteractListFragment lXInteractListFragment2 = LXInteractListFragment.this;
                            lXInteractListFragment2.w4.setAdapter(lXInteractListFragment2.l4);
                            LXInteractListFragment.this.k3();
                        }
                    });
                }

                public void h0(Bundle bundle) {
                    LXInteractListFragment.this.V2();
                    LXInteractListFragment.this.s4.k0(bundle.getString("word"), true);
                }

                public RecyclerView.ViewHolder j0(View view) {
                    RippleTextFullViewHolder rippleTextFullViewHolder = new RippleTextFullViewHolder(view);
                    rippleTextFullViewHolder.K.setVisibility(8);
                    rippleTextFullViewHolder.J.setVisibility(8);
                    return rippleTextFullViewHolder;
                }
            };
            this.w4.setAdapter(this.l4);
            N2();
            o2(false);
            return this.q4;
        }

        public void X2() {
            this.E4.i0(this.o4, this.p4);
            this.w4.setAdapter(this.E4);
        }

        public ArrayList<Bundle> a3(String str) {
            CompressHelper compressHelper = this.k4;
            Bundle bundle = this.h4;
            return compressHelper.W(bundle, "Select rowid as _id,* from search where name match '" + str + "*'", "fsearch.db");
        }

        public ArrayList<Bundle> g3(String str) {
            CompressHelper compressHelper = this.k4;
            Bundle bundle = this.h4;
            return compressHelper.W(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'", "fsearch.db");
        }

        public void k3() {
            ArrayList<Bundle> arrayList = this.B4;
            if (arrayList == null || arrayList.size() == 0) {
                this.D4.setEnabled(false);
                this.D4.setBackgroundColor(Color.rgb(100, 100, 100));
                this.D4.setText("Nothing Added");
                return;
            }
            this.D4.setText("Show Interactions");
            this.D4.setEnabled(true);
            this.D4.setBackgroundColor(Color.rgb(64, 140, 83));
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new LXInteractListFragment());
    }
}
