package net.imedicaldoctor.imd.Fragments.Micromedex;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.NotStickySectionAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextImageArrowViewHolder;
import org.apache.commons.lang3.StringUtils;

public class MMIVResultActivityFragment extends ViewerHelperFragment {
    public RecyclerView X4;
    public ArrayList<Bundle> Y4;
    public Bundle Z4;
    public ArrayList<String> a5;
    public NotStickySectionAdapter b5;
    public ArrayList<Bundle> c5;
    public ArrayList<Bundle> d5;
    public ArrayList<Bundle> e5;
    public ArrayList<Bundle> f5;
    public ArrayList<Bundle> g5;
    public ArrayList<Bundle> h5;
    public TabLayout i5;
    public String j5;
    public String k5;
    public NotStickySectionAdapter l5;
    public ChaptersAdapter m5;
    public ChaptersAdapter n5;

    public void I4(String str) {
        TabLayout.Tab I = this.i5.I();
        I.D(str);
        this.i5.i(I);
    }

    public void J4() {
        this.X4.setItemAnimator(new DefaultItemAnimator());
        this.X4.setItemDecoration(new CustomItemDecoration(r()));
        this.X4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
    }

    public int K4(String str) {
        if (str.equals("C")) {
            return R.drawable.f668iv_compat_compatible;
        }
        if (str.equals("I")) {
            return R.drawable.f669iv_compat_incompatible;
        }
        if (str.equals("U")) {
            return R.drawable.f671iv_compat_uncertain;
        }
        if (str.equals("N")) {
            return R.drawable.f670iv_compat_nottested;
        }
        return str.equals(ExifInterface.X4) ? R.drawable.f667iv_compat_cautionvariable : R.drawable.f715placeholder;
    }

    public void L4() {
        final ProgressDialog progressDialog = new ProgressDialog(r());
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading");
        progressDialog.show();
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                MMIVResultActivityFragment mMIVResultActivityFragment = MMIVResultActivityFragment.this;
                mMIVResultActivityFragment.g5 = mMIVResultActivityFragment.Q4.V(mMIVResultActivityFragment.D4, "SELECT * from v_multi_ysite_summary");
                MMIVResultActivityFragment mMIVResultActivityFragment2 = MMIVResultActivityFragment.this;
                mMIVResultActivityFragment2.h5 = mMIVResultActivityFragment2.Q4.V(mMIVResultActivityFragment2.D4, "Select * from v_multi_admix_summary");
                observableEmitter.onNext("Completed");
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).d6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                progressDialog.hide();
                MMIVResultActivityFragment mMIVResultActivityFragment = MMIVResultActivityFragment.this;
                mMIVResultActivityFragment.m5.g0(mMIVResultActivityFragment.g5);
                MMIVResultActivityFragment mMIVResultActivityFragment2 = MMIVResultActivityFragment.this;
                mMIVResultActivityFragment2.n5.g0(mMIVResultActivityFragment2.h5);
                MMIVResultActivityFragment mMIVResultActivityFragment3 = MMIVResultActivityFragment.this;
                mMIVResultActivityFragment3.X4.setAdapter(mMIVResultActivityFragment3.m5);
            }
        });
    }

    public void M4() {
        final ProgressDialog progressDialog = new ProgressDialog(r());
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading");
        progressDialog.show();
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                MMIVResultActivityFragment mMIVResultActivityFragment = MMIVResultActivityFragment.this;
                mMIVResultActivityFragment.e5 = mMIVResultActivityFragment.Q4.V(mMIVResultActivityFragment.D4, "SELECT sol.solution_id solution_id, CASE WHEN commSol.display_name IS NULL THEN sol.title ELSE commSol.display_name END title, res.result, CASE WHEN commSol.display_name IS NULL THEN 1 ELSE 0 END grouper, CASE WHEN commSol.sorter IS NULL THEN UPPER(sol.title) ELSE commSol.sorter END sorter, 1 show_view_button FROM iv_drug_solution_idx sol LEFT JOIN lookup_common_solutions commSol ON sol.solution_id = commSol.id, sv_solution_result res, iv_mono_solution_idx msi, iv_mono_agent_int mai WHERE sol.solution_id = res.solution_id AND msi.iv_id = mai.iv_id AND sol.solution_id = mai.agent_id GROUP BY sol.solution_id UNION ALL SELECT id solution_id, display_name title, 'N' result, 0 grouper, sorter sorter, 0 show_view_button FROM lookup_common_solutions WHERE id NOT IN (SELECT solution_id FROM sv_solution_result) ORDER BY grouper, sorter");
                MMIVResultActivityFragment mMIVResultActivityFragment2 = MMIVResultActivityFragment.this;
                mMIVResultActivityFragment2.f5 = mMIVResultActivityFragment2.Q4.r2(mMIVResultActivityFragment2.e5, "grouper");
                MMIVResultActivityFragment mMIVResultActivityFragment3 = MMIVResultActivityFragment.this;
                mMIVResultActivityFragment3.g5 = mMIVResultActivityFragment3.Q4.V(mMIVResultActivityFragment3.D4, "Select * from v_ysite_summary");
                MMIVResultActivityFragment mMIVResultActivityFragment4 = MMIVResultActivityFragment.this;
                mMIVResultActivityFragment4.h5 = mMIVResultActivityFragment4.Q4.V(mMIVResultActivityFragment4.D4, "Select * from v_admix_summary");
                observableEmitter.onNext("Completed");
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).d6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                progressDialog.hide();
                MMIVResultActivityFragment mMIVResultActivityFragment = MMIVResultActivityFragment.this;
                mMIVResultActivityFragment.l5.h0(mMIVResultActivityFragment.f5);
                MMIVResultActivityFragment mMIVResultActivityFragment2 = MMIVResultActivityFragment.this;
                mMIVResultActivityFragment2.m5.g0(mMIVResultActivityFragment2.g5);
                MMIVResultActivityFragment mMIVResultActivityFragment3 = MMIVResultActivityFragment.this;
                mMIVResultActivityFragment3.n5.g0(mMIVResultActivityFragment3.h5);
                MMIVResultActivityFragment mMIVResultActivityFragment4 = MMIVResultActivityFragment.this;
                mMIVResultActivityFragment4.X4.setAdapter(mMIVResultActivityFragment4.l5);
            }
        });
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.C4;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.f1249fragment_new_list_viewer_tab, viewGroup, false);
        this.C4 = inflate;
        r4(inflate, bundle);
        this.X4 = (RecyclerView) this.C4.findViewById(R.id.f1054recycler_view);
        if (y() == null) {
            return this.C4;
        }
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(this.E4.replace("interactresult-", ""), ";;;;;");
        TabLayout tabLayout = (TabLayout) this.C4.findViewById(R.id.f1111tabs);
        this.i5 = tabLayout;
        tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void a(TabLayout.Tab tab) {
            }

            public void b(TabLayout.Tab tab) {
                RecyclerView recyclerView;
                RecyclerView.Adapter adapter;
                String charSequence = tab.n().toString();
                if (charSequence.equals("Solutions")) {
                    MMIVResultActivityFragment mMIVResultActivityFragment = MMIVResultActivityFragment.this;
                    recyclerView = mMIVResultActivityFragment.X4;
                    adapter = mMIVResultActivityFragment.l5;
                } else if (charSequence.equals("Y-Site")) {
                    MMIVResultActivityFragment mMIVResultActivityFragment2 = MMIVResultActivityFragment.this;
                    recyclerView = mMIVResultActivityFragment2.X4;
                    adapter = mMIVResultActivityFragment2.m5;
                } else if (charSequence.equals("Admix")) {
                    MMIVResultActivityFragment mMIVResultActivityFragment3 = MMIVResultActivityFragment.this;
                    recyclerView = mMIVResultActivityFragment3.X4;
                    adapter = mMIVResultActivityFragment3.n5;
                } else {
                    return;
                }
                recyclerView.setAdapter(adapter);
            }

            public void c(TabLayout.Tab tab) {
            }
        });
        if (splitByWholeSeparator.length == 1) {
            I4("Solutions");
            I4("Y-Site");
            I4("Admix");
            String[] splitByWholeSeparator2 = StringUtils.splitByWholeSeparator(splitByWholeSeparator[0], ",,,,,");
            this.j5 = splitByWholeSeparator2[0];
            this.k5 = splitByWholeSeparator2[1];
            this.Q4.m(this.D4, "Update app_state set value=" + splitByWholeSeparator2[0] + ", title='" + splitByWholeSeparator2[1] + "' where key='current_agent_id'");
            this.F4 = splitByWholeSeparator2[1];
            M4();
            AnonymousClass6 r0 = new NotStickySectionAdapter(r(), this.f5, "title", R.layout.f1350list_view_item_ripple_text_image_arrow) {
                public void f0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                    RippleTextImageArrowViewHolder rippleTextImageArrowViewHolder = (RippleTextImageArrowViewHolder) viewHolder;
                    rippleTextImageArrowViewHolder.I.setText(bundle.getString("title"));
                    rippleTextImageArrowViewHolder.J.setImageDrawable(MMIVResultActivityFragment.this.b0().getDrawable(MMIVResultActivityFragment.this.K4(bundle.getString("res.result"))));
                    if (bundle.getString("res.result").equals("N")) {
                        rippleTextImageArrowViewHolder.K.setVisibility(8);
                        rippleTextImageArrowViewHolder.L.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                CompressHelper.x2(MMIVResultActivityFragment.this.r(), "Not Tested", 1);
                            }
                        });
                        return;
                    }
                    rippleTextImageArrowViewHolder.K.setVisibility(0);
                    rippleTextImageArrowViewHolder.L.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            MMIVResultActivityFragment mMIVResultActivityFragment = MMIVResultActivityFragment.this;
                            mMIVResultActivityFragment.Q4.A1(mMIVResultActivityFragment.D4, "doc-solution,,," + MMIVResultActivityFragment.this.j5 + ",,," + MMIVResultActivityFragment.this.k5 + ",,," + bundle.getString("solution_id") + ",,," + bundle.getString("title"), (String[]) null, (String) null);
                        }
                    });
                }

                public String i0(String str) {
                    if (str.equals("0")) {
                        return "Common Solutions";
                    }
                    return str.equals(IcyHeaders.a3) ? "Other Solutions" : "";
                }

                public RecyclerView.ViewHolder k0(View view) {
                    return new RippleTextImageArrowViewHolder(view);
                }
            };
            this.l5 = r0;
            r0.f30479i = "No Drug-Solution Combination Have Been Tested";
            AnonymousClass7 r02 = new ChaptersAdapter(r(), this.g5, "adfs", R.layout.f1350list_view_item_ripple_text_image_arrow) {
                public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                    RippleTextImageArrowViewHolder rippleTextImageArrowViewHolder = (RippleTextImageArrowViewHolder) viewHolder;
                    rippleTextImageArrowViewHolder.I.setText(bundle.getString("title"));
                    rippleTextImageArrowViewHolder.J.setImageDrawable(MMIVResultActivityFragment.this.b0().getDrawable(MMIVResultActivityFragment.this.K4(bundle.getString("result"))));
                    if (bundle.getString("result").equals("N")) {
                        rippleTextImageArrowViewHolder.K.setVisibility(8);
                        rippleTextImageArrowViewHolder.L.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                CompressHelper.x2(MMIVResultActivityFragment.this.r(), "Not Tested", 1);
                            }
                        });
                        return;
                    }
                    rippleTextImageArrowViewHolder.K.setVisibility(0);
                    rippleTextImageArrowViewHolder.L.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            MMIVResultActivityFragment mMIVResultActivityFragment = MMIVResultActivityFragment.this;
                            mMIVResultActivityFragment.Q4.A1(mMIVResultActivityFragment.D4, "doc-ysite,,," + MMIVResultActivityFragment.this.j5 + ",,," + MMIVResultActivityFragment.this.k5 + ",,," + bundle.getString("value_id") + ",,," + bundle.getString("title"), (String[]) null, (String) null);
                        }
                    });
                }

                public RecyclerView.ViewHolder h0(View view) {
                    return new RippleTextImageArrowViewHolder(view);
                }
            };
            this.m5 = r02;
            r02.f30463h = "No Drug-Drug Combination Have Been Tested";
            AnonymousClass8 r03 = new ChaptersAdapter(r(), this.h5, "adfs", R.layout.f1350list_view_item_ripple_text_image_arrow) {
                public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                    RippleTextImageArrowViewHolder rippleTextImageArrowViewHolder = (RippleTextImageArrowViewHolder) viewHolder;
                    rippleTextImageArrowViewHolder.I.setText(bundle.getString("title"));
                    rippleTextImageArrowViewHolder.J.setImageDrawable(MMIVResultActivityFragment.this.b0().getDrawable(MMIVResultActivityFragment.this.K4(bundle.getString("result"))));
                    if (bundle.getString("result").equals("N")) {
                        rippleTextImageArrowViewHolder.K.setVisibility(8);
                        rippleTextImageArrowViewHolder.L.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                CompressHelper.x2(MMIVResultActivityFragment.this.r(), "Not Tested", 1);
                            }
                        });
                        return;
                    }
                    rippleTextImageArrowViewHolder.K.setVisibility(0);
                    rippleTextImageArrowViewHolder.L.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            MMIVResultActivityFragment mMIVResultActivityFragment = MMIVResultActivityFragment.this;
                            mMIVResultActivityFragment.Q4.A1(mMIVResultActivityFragment.D4, "doc-admix,,," + MMIVResultActivityFragment.this.j5 + ",,," + MMIVResultActivityFragment.this.k5 + ",,," + bundle.getString("value_id") + ",,," + bundle.getString("title"), (String[]) null, (String) null);
                        }
                    });
                }

                public RecyclerView.ViewHolder h0(View view) {
                    return new RippleTextImageArrowViewHolder(view);
                }
            };
            this.n5 = r03;
            r03.f30463h = "No Drug-Drug Combination Have Been Tested";
            this.X4.setAdapter(this.l5);
        } else {
            I4("Y-Site");
            I4("Admix");
            this.Q4.m(this.D4, "Delete from selected_agents");
            for (String splitByWholeSeparator3 : splitByWholeSeparator) {
                String[] splitByWholeSeparator4 = StringUtils.splitByWholeSeparator(splitByWholeSeparator3, ",,,,,");
                String str = splitByWholeSeparator4[0];
                String str2 = splitByWholeSeparator4[1];
                String[] splitByWholeSeparator5 = StringUtils.splitByWholeSeparator(splitByWholeSeparator4[2], "-");
                this.Q4.m(this.D4, "Insert into selected_agents values (" + str + "," + splitByWholeSeparator5[0] + ", '" + str2 + "', 0, " + splitByWholeSeparator5[1] + ")");
            }
            this.F4 = "Interaction Result";
            L4();
            AnonymousClass9 r04 = new ChaptersAdapter(r(), this.g5, "title", R.layout.f1348list_view_item_ripple_text_full_interact) {
                public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                    RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                    final String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(bundle.getString("title"), " - ");
                    rippleTextFullViewHolder.I.setText(splitByWholeSeparator[0]);
                    rippleTextFullViewHolder.J.setText(splitByWholeSeparator[1]);
                    rippleTextFullViewHolder.K.setImageDrawable(MMIVResultActivityFragment.this.b0().getDrawable(MMIVResultActivityFragment.this.K4(bundle.getString("result"))));
                    rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            MMIVResultActivityFragment mMIVResultActivityFragment = MMIVResultActivityFragment.this;
                            mMIVResultActivityFragment.Q4.A1(mMIVResultActivityFragment.D4, "doc-ysite,,," + bundle.getString("agent_id") + ",,," + splitByWholeSeparator[0] + ",,," + bundle.getString("drug2_id") + ",,," + splitByWholeSeparator[1], (String[]) null, (String) null);
                        }
                    });
                }

                public RecyclerView.ViewHolder h0(View view) {
                    return new RippleTextFullViewHolder(view);
                }
            };
            this.m5 = r04;
            r04.f30463h = "No Drug-Drug Combination Have Been Tested";
            AnonymousClass10 r05 = new ChaptersAdapter(r(), this.g5, "title", R.layout.f1348list_view_item_ripple_text_full_interact) {
                public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                    RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                    final String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(bundle.getString("title"), " - ");
                    rippleTextFullViewHolder.I.setText(splitByWholeSeparator[0]);
                    rippleTextFullViewHolder.J.setText(splitByWholeSeparator[1]);
                    rippleTextFullViewHolder.K.setImageDrawable(MMIVResultActivityFragment.this.b0().getDrawable(MMIVResultActivityFragment.this.K4(bundle.getString("result"))));
                    rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            MMIVResultActivityFragment mMIVResultActivityFragment = MMIVResultActivityFragment.this;
                            mMIVResultActivityFragment.Q4.A1(mMIVResultActivityFragment.D4, "doc-admix,,," + bundle.getString("agent_id") + ",,," + splitByWholeSeparator[0] + ",,," + bundle.getString("drug2_id") + ",,," + splitByWholeSeparator[1], (String[]) null, (String) null);
                        }
                    });
                }

                public RecyclerView.ViewHolder h0(View view) {
                    return new RippleTextFullViewHolder(view);
                }
            };
            this.n5 = r05;
            r05.f30463h = "No Drug-Drug Combination Have Been Tested";
        }
        J4();
        f3(R.menu.f1414favorite);
        o2(false);
        G3();
        return this.C4;
    }

    public boolean e1(MenuItem menuItem) {
        menuItem.getItemId();
        return super.e1(menuItem);
    }

    public void o4() {
        Bundle v3;
        ArrayList<Bundle> arrayList = this.Y4;
        if (arrayList != null && arrayList.size() != 0 && (v3 = v3(this.Y4)) != null) {
            Glide.G(r()).t("http://www.epocrates.com/pillimages/" + (v3.getString("FILENAME") + ".jpg")).B2(this.M4);
        }
    }
}
