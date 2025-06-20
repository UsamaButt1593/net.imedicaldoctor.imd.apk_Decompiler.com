package net.imedicaldoctor.imd.Fragments.Skyscape;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.MessageViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextViewHolder;
import net.imedicaldoctor.imd.iMDActivity;

public class SSTocActivity extends iMDActivity {

    public static class SSTocFragment extends SearchHelperFragment {
        private String A4;
        private SSTOCSearchChaptersAdapter B4;

        public class RippleInfoTextViewHolder extends RecyclerView.ViewHolder {
            public TextView I;
            public ImageView J;
            public MaterialRippleLayout K;

            public RippleInfoTextViewHolder(View view) {
                super(view);
                this.I = (TextView) view.findViewById(R.id.f1132text_view);
                this.K = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
                this.J = (ImageView) view.findViewById(R.id.f986info_button);
            }
        }

        public class SSTOCChaptersAdapter extends RecyclerView.Adapter {

            /* renamed from: d  reason: collision with root package name */
            public Context f29910d;

            /* renamed from: e  reason: collision with root package name */
            public ArrayList<Bundle> f29911e;

            /* renamed from: f  reason: collision with root package name */
            public String f29912f;

            public SSTOCChaptersAdapter(Context context, ArrayList<Bundle> arrayList, String str) {
                this.f29910d = context;
                this.f29911e = arrayList;
                this.f29912f = str;
            }

            public int C(int i2) {
                Bundle bundle = this.f29911e.get(i2);
                if (bundle.getString("leaf").equals(IcyHeaders.a3)) {
                    return 0;
                }
                return bundle.getString("docId").length() > 0 ? 1 : 2;
            }

            public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
                if (viewHolder.F() == 0 || viewHolder.F() == 2) {
                    RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
                    final Bundle bundle = this.f29911e.get(i2);
                    rippleTextViewHolder.I.setText(bundle.getString(this.f29912f));
                    rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            SSTOCChaptersAdapter.this.e0(bundle, i2);
                        }
                    });
                } else if (viewHolder.F() == 1) {
                    RippleInfoTextViewHolder rippleInfoTextViewHolder = (RippleInfoTextViewHolder) viewHolder;
                    final Bundle bundle2 = this.f29911e.get(i2);
                    rippleInfoTextViewHolder.I.setText(bundle2.getString(this.f29912f));
                    rippleInfoTextViewHolder.K.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            SSTOCChaptersAdapter.this.e0(bundle2, i2);
                        }
                    });
                    rippleInfoTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            SSTOCChaptersAdapter.this.d0(bundle2, i2);
                        }
                    });
                }
            }

            public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                if (i2 == 0) {
                    return new RippleTextViewHolder(LayoutInflater.from(this.f29910d).inflate(R.layout.f1342list_view_item_ripple_text, viewGroup, false));
                }
                if (i2 == 1) {
                    return new RippleInfoTextViewHolder(LayoutInflater.from(this.f29910d).inflate(R.layout.f1340list_view_item_ripple_goto_arrow, viewGroup, false));
                } else if (i2 == 2) {
                    return new RippleTextViewHolder(LayoutInflater.from(this.f29910d).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
                } else {
                    return null;
                }
            }

            public int b() {
                return this.f29911e.size();
            }

            public void d0(Bundle bundle, int i2) {
            }

            public void e0(Bundle bundle, int i2) {
            }
        }

        public class SSTOCSearchChaptersAdapter extends RecyclerView.Adapter {

            /* renamed from: d  reason: collision with root package name */
            public Context f29914d;

            /* renamed from: e  reason: collision with root package name */
            public ArrayList<Bundle> f29915e;

            /* renamed from: f  reason: collision with root package name */
            public String f29916f;

            public SSTOCSearchChaptersAdapter(Context context, ArrayList<Bundle> arrayList, String str) {
                this.f29914d = context;
                this.f29915e = arrayList;
                this.f29916f = str;
            }

            public int C(int i2) {
                Bundle bundle = this.f29915e.get(i2);
                if (bundle.getString("leaf").equals(IcyHeaders.a3)) {
                    return 0;
                }
                return bundle.getString("docId").length() > 0 ? 1 : 2;
            }

            public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
                ArrayList<Bundle> arrayList = this.f29915e;
                if (arrayList == null || arrayList.size() == 0) {
                    MessageViewHolder messageViewHolder = (MessageViewHolder) viewHolder;
                } else if (viewHolder.F() == 0 || viewHolder.F() == 2) {
                    RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
                    final Bundle bundle = this.f29915e.get(i2);
                    rippleTextViewHolder.I.setText(bundle.getString(this.f29916f));
                    rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            SSTOCSearchChaptersAdapter.this.e0(bundle, i2);
                        }
                    });
                } else if (viewHolder.F() == 1) {
                    RippleInfoTextViewHolder rippleInfoTextViewHolder = (RippleInfoTextViewHolder) viewHolder;
                    final Bundle bundle2 = this.f29915e.get(i2);
                    rippleInfoTextViewHolder.I.setText(bundle2.getString(this.f29916f));
                    rippleInfoTextViewHolder.K.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            SSTOCSearchChaptersAdapter.this.e0(bundle2, i2);
                        }
                    });
                    rippleInfoTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            SSTOCSearchChaptersAdapter.this.d0(bundle2, i2);
                        }
                    });
                }
            }

            public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                ArrayList<Bundle> arrayList = this.f29915e;
                if (arrayList == null || arrayList.size() == 0) {
                    return new MessageViewHolder(this.f29914d, LayoutInflater.from(this.f29914d).inflate(R.layout.f1300list_view_item_card_notfound, viewGroup, false));
                } else if (i2 == 0) {
                    return new RippleTextViewHolder(LayoutInflater.from(this.f29914d).inflate(R.layout.f1342list_view_item_ripple_text, viewGroup, false));
                } else {
                    if (i2 == 1) {
                        return new RippleInfoTextViewHolder(LayoutInflater.from(this.f29914d).inflate(R.layout.f1340list_view_item_ripple_goto_arrow, viewGroup, false));
                    } else if (i2 == 2) {
                        return new RippleTextViewHolder(LayoutInflater.from(this.f29914d).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
                    } else {
                        return null;
                    }
                }
            }

            public int b() {
                return this.f29915e.size();
            }

            public void d0(Bundle bundle, int i2) {
            }

            public void e0(Bundle bundle, int i2) {
            }

            public void f0(ArrayList<Bundle> arrayList) {
                this.f29915e = arrayList;
                G();
            }
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1494search, menu);
            this.s4 = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
            P2();
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
            this.q4 = inflate;
            W2(bundle);
            S2();
            this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
            P2();
            this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
            AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
            final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
            if (y() == null || !y().containsKey("ParentId")) {
                appBarLayout.D(true, false);
                relativeLayout.setVisibility(0);
                this.A4 = "0";
            } else {
                if (y().getString("ParentId").equals("0")) {
                    appBarLayout.D(true, false);
                    relativeLayout.setVisibility(0);
                } else {
                    appBarLayout.D(false, false);
                    appBarLayout.postDelayed(new Runnable() {
                        public void run() {
                            relativeLayout.setVisibility(0);
                        }
                    }, 800);
                }
                this.A4 = y().getString("ParentId");
            }
            CompressHelper compressHelper = this.k4;
            Bundle bundle2 = this.h4;
            this.n4 = compressHelper.V(bundle2, "Select * from toc where parentId = " + this.A4);
            this.l4 = new SSTOCChaptersAdapter(r(), this.n4, "name") {
                public void d0(Bundle bundle, int i2) {
                    SSTocFragment.this.V2();
                    new CompressHelper(SSTocFragment.this.r()).A1(SSTocFragment.this.h4, bundle.getString("docId"), (String[]) null, (String) null);
                }

                public void e0(Bundle bundle, int i2) {
                    SSTocFragment.this.V2();
                    String string = bundle.getString("leaf");
                    String string2 = bundle.getString("docId");
                    if (string.equals(IcyHeaders.a3)) {
                        new CompressHelper(SSTocFragment.this.r()).A1(SSTocFragment.this.h4, string2, (String[]) null, (String) null);
                        return;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("DB", SSTocFragment.this.h4);
                    bundle2.putString("ParentId", bundle.getString("id"));
                    new CompressHelper(SSTocFragment.this.r()).N(SSTocActivity.class, SSTocFragment.class, bundle2);
                }
            };
            this.B4 = new SSTOCSearchChaptersAdapter(r(), this.o4, "name") {
                public void d0(Bundle bundle, int i2) {
                    SSTocFragment.this.V2();
                    new CompressHelper(SSTocFragment.this.r()).A1(SSTocFragment.this.h4, bundle.getString("docId"), (String[]) null, (String) null);
                }

                public void e0(Bundle bundle, int i2) {
                    SSTocFragment.this.V2();
                    String string = bundle.getString("leaf");
                    String string2 = bundle.getString("docId");
                    if (string.equals(IcyHeaders.a3)) {
                        new CompressHelper(SSTocFragment.this.r()).A1(SSTocFragment.this.h4, string2, (String[]) null, (String) null);
                        return;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("DB", SSTocFragment.this.h4);
                    bundle2.putString("ParentId", bundle.getString("id"));
                    new CompressHelper(SSTocFragment.this.r()).N(SSTocActivity.class, SSTocFragment.class, bundle2);
                }
            };
            this.w4.setAdapter(this.l4);
            N2();
            o2(true);
            return inflate;
        }

        public void X2() {
            this.B4.f0(this.o4);
            this.w4.setAdapter(this.B4);
        }

        public ArrayList<Bundle> a3(String str) {
            CompressHelper compressHelper = this.k4;
            Bundle bundle = this.h4;
            return compressHelper.V(bundle, "Select rowid as _id, Text as text,snippet(search) as subText, type, contentId from search where search match '" + str + "' ORDER BY rank(matchinfo(search)) DESC");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new SSTocFragment());
    }
}
