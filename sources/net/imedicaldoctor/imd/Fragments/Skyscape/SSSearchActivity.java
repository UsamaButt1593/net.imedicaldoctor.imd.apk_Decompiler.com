package net.imedicaldoctor.imd.Fragments.Skyscape;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.Fragments.Skyscape.SSTocActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.MessageViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleSearchContentViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextViewHolder;
import net.imedicaldoctor.imd.iMDActivity;
import org.apache.commons.lang3.StringUtils;

public class SSSearchActivity extends iMDActivity {

    public static class SSSearchFragment extends SearchHelperFragment {
        /* access modifiers changed from: private */
        public int A4;
        private Bundle B4;
        private SkyscapeContentSearchAdapter C4;
        private String D4;

        public class SkyscapeAdapter extends RecyclerView.Adapter {

            /* renamed from: d  reason: collision with root package name */
            public Context f29900d;

            /* renamed from: e  reason: collision with root package name */
            public ArrayList<Bundle> f29901e;

            public SkyscapeAdapter(Context context, ArrayList<Bundle> arrayList) {
                this.f29900d = context;
                this.f29901e = arrayList;
            }

            public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
                RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
                final Bundle bundle = this.f29901e.get(i2);
                rippleTextViewHolder.I.setText(this.f29901e.get(i2).getString(SSSearchFragment.this.A4 == 0 ? "name" : SSSearchFragment.this.A4 == 1 ? "Name" : SSSearchFragment.this.A4 == 2 ? "title" : ""));
                rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SkyscapeAdapter.this.d0(bundle, i2);
                    }
                });
            }

            public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                return new RippleTextViewHolder(LayoutInflater.from(this.f29900d).inflate(R.layout.f1342list_view_item_ripple_text, viewGroup, false));
            }

            public int b() {
                ArrayList<Bundle> arrayList = this.f29901e;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            }

            public void d0(Bundle bundle, int i2) {
            }
        }

        public class SkyscapeContentSearchAdapter extends RecyclerView.Adapter {

            /* renamed from: d  reason: collision with root package name */
            public Context f29903d;

            /* renamed from: e  reason: collision with root package name */
            public ArrayList<Bundle> f29904e;

            /* renamed from: f  reason: collision with root package name */
            public String f29905f;

            /* renamed from: g  reason: collision with root package name */
            public String f29906g;

            public SkyscapeContentSearchAdapter(Context context, ArrayList<Bundle> arrayList, String str, String str2) {
                this.f29903d = context;
                this.f29904e = arrayList;
                this.f29905f = str;
                this.f29906g = str2;
            }

            public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
                String str;
                String str2;
                ArrayList<Bundle> arrayList = this.f29904e;
                if (arrayList == null || arrayList.size() == 0) {
                    MessageViewHolder messageViewHolder = (MessageViewHolder) viewHolder;
                    return;
                }
                RippleSearchContentViewHolder rippleSearchContentViewHolder = (RippleSearchContentViewHolder) viewHolder;
                final Bundle bundle = this.f29904e.get(i2);
                if (SSSearchFragment.this.A4 == 0) {
                    str2 = bundle.getString("Name");
                    str = bundle.getString("indexType");
                } else {
                    if (SSSearchFragment.this.A4 == 1) {
                        str2 = bundle.getString("Name");
                    } else if (SSSearchFragment.this.A4 == 2) {
                        str2 = bundle.getString("title");
                    } else {
                        str2 = "";
                        str = str2;
                    }
                    str = "";
                }
                rippleSearchContentViewHolder.I.setText(str2);
                if (str.length() > 0) {
                    rippleSearchContentViewHolder.J.setVisibility(0);
                    rippleSearchContentViewHolder.J.setText(str);
                } else {
                    rippleSearchContentViewHolder.J.setVisibility(8);
                }
                rippleSearchContentViewHolder.K.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SkyscapeContentSearchAdapter.this.d0(bundle, i2);
                    }
                });
            }

            public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                ArrayList<Bundle> arrayList = this.f29904e;
                if (arrayList != null && arrayList.size() != 0) {
                    return new RippleSearchContentViewHolder(LayoutInflater.from(this.f29903d).inflate(R.layout.f1355list_view_item_search_content_ripple, viewGroup, false));
                }
                return new MessageViewHolder(this.f29903d, LayoutInflater.from(this.f29903d).inflate(R.layout.f1300list_view_item_card_notfound, viewGroup, false));
            }

            public int b() {
                ArrayList<Bundle> arrayList = this.f29904e;
                if (arrayList == null || arrayList.size() == 0) {
                    return 1;
                }
                return this.f29904e.size();
            }

            public void d0(Bundle bundle, int i2) {
            }

            public void e0(ArrayList<Bundle> arrayList) {
                this.f29904e = arrayList;
                G();
            }
        }

        /* access modifiers changed from: private */
        public Bundle k3(Bundle bundle) {
            String str;
            String str2;
            Bundle bundle2 = new Bundle();
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(bundle.getString("docId"), "|");
            String[] splitByWholeSeparator2 = StringUtils.splitByWholeSeparator(bundle.getString(HTML.Tag.V), "|");
            for (int i2 = 0; i2 < splitByWholeSeparator.length; i2++) {
                if (splitByWholeSeparator2.length > i2) {
                    str = splitByWholeSeparator[i2];
                    str2 = splitByWholeSeparator2[i2];
                } else {
                    str = splitByWholeSeparator[i2];
                    str2 = "";
                }
                bundle2.putString(str, str2);
            }
            return bundle2;
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1494search, menu);
            this.s4 = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
            O2();
        }

        public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            CompressHelper compressHelper;
            Bundle bundle2;
            String str;
            View inflate = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
            this.q4 = inflate;
            W2(bundle);
            S2();
            this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
            O2();
            this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
            this.B4 = (y() == null || !y().containsKey("SelectedItem")) ? null : y().getBundle("SelectedItem");
            if (y() == null || !y().containsKey("Mode")) {
                this.A4 = 0;
            } else {
                this.A4 = y().getInt("Mode");
            }
            ArrayList<Bundle> arrayList = new ArrayList<>();
            int i2 = this.A4;
            if (i2 == 0) {
                arrayList = this.k4.V(this.h4, "select * from indexType");
                ArrayList<Bundle> V = this.k4.V(this.h4, "select * from sqlite_master where name='TOC'");
                if (!(V == null || V.size() == 0)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("id", "-1");
                    bundle3.putString("name", "Table Of Contents");
                    arrayList.add(bundle3);
                }
            } else {
                if (i2 == 1) {
                    compressHelper = this.k4;
                    bundle2 = this.h4;
                    str = "select * from indexes where indexTypeId=" + this.B4.getString("id");
                } else if (i2 == 2) {
                    compressHelper = this.k4;
                    bundle2 = this.h4;
                    str = "select * from document where id in (" + this.B4.getString("docId").replace("|", ",") + ")";
                }
                arrayList = compressHelper.V(bundle2, str);
            }
            AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
            final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
            if (this.A4 == 0) {
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
            this.l4 = new SkyscapeAdapter(r(), arrayList) {
                public void d0(Bundle bundle, int i2) {
                    SSSearchFragment.this.V2();
                    Class<SSSearchFragment> cls = SSSearchFragment.class;
                    Class<SSSearchActivity> cls2 = SSSearchActivity.class;
                    if (SSSearchFragment.this.A4 == 0) {
                        if (bundle.getString("id").equals("-1")) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putBundle("DB", SSSearchFragment.this.h4);
                            SSSearchFragment.this.k4.N(SSTocActivity.class, SSTocActivity.SSTocFragment.class, bundle2);
                            return;
                        }
                        Bundle bundle3 = new Bundle();
                        bundle3.putBundle("SelectedItem", bundle);
                        bundle3.putBundle("DB", SSSearchFragment.this.h4);
                        bundle3.putInt("Mode", 1);
                        SSSearchFragment.this.k4.N(cls2, cls, bundle3);
                    } else if (SSSearchFragment.this.A4 == 1) {
                        if (bundle.getString("docId").contains("|")) {
                            Bundle j3 = SSSearchFragment.this.k3(bundle);
                            Bundle bundle4 = new Bundle();
                            bundle4.putBundle("SelectedItem", bundle);
                            bundle4.putBundle("DB", SSSearchFragment.this.h4);
                            bundle4.putInt("Mode", 2);
                            bundle4.putBundle("GotoSections", j3);
                            SSSearchFragment.this.k4.N(cls2, cls, bundle4);
                            return;
                        }
                        SSSearchFragment sSSearchFragment = SSSearchFragment.this;
                        sSSearchFragment.k4.A1(sSSearchFragment.h4, bundle.getString("docId"), (String[]) null, bundle.getString(HTML.Tag.V));
                    } else if (SSSearchFragment.this.A4 == 2) {
                        SSSearchFragment sSSearchFragment2 = SSSearchFragment.this;
                        sSSearchFragment2.k4.A1(sSSearchFragment2.h4, bundle.getString("id"), (String[]) null, bundle.getString("id"));
                    }
                }
            };
            this.C4 = new SkyscapeContentSearchAdapter(r(), this.o4, "text", "subText") {
                public void d0(Bundle bundle, int i2) {
                    SSSearchFragment.this.V2();
                    if (SSSearchFragment.this.A4 == 0 || SSSearchFragment.this.A4 == 1) {
                        if (bundle.getString("docId").contains("|")) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putBundle("SelectedItem", bundle);
                            bundle2.putBundle("DB", SSSearchFragment.this.h4);
                            bundle2.putInt("Mode", 2);
                            bundle2.putBundle("GotoSections", SSSearchFragment.this.k3(bundle));
                            SSSearchFragment.this.k4.N(SSSearchActivity.class, SSSearchFragment.class, bundle2);
                            return;
                        }
                        SSSearchFragment sSSearchFragment = SSSearchFragment.this;
                        sSSearchFragment.k4.A1(sSSearchFragment.h4, bundle.getString("docId"), (String[]) null, bundle.getString(HTML.Tag.V));
                    } else if (SSSearchFragment.this.A4 == 2) {
                        SSSearchFragment sSSearchFragment2 = SSSearchFragment.this;
                        sSSearchFragment2.k4.A1(sSSearchFragment2.h4, bundle.getString("id"), (String[]) null, bundle.getString("id"));
                    }
                }
            };
            this.w4.setAdapter(this.l4);
            N2();
            o2(true);
            return inflate;
        }

        public void X2() {
            this.C4.e0(this.o4);
            this.w4.setAdapter(this.C4);
        }

        public ArrayList<Bundle> a3(String str) {
            String str2;
            StringBuilder sb;
            String str3;
            int i2 = this.A4;
            if (i2 == 0) {
                sb = new StringBuilder();
                sb.append("Select rowid as _id,Id as docId, indexName as Name,indexType,section  from search where indexName match '");
                sb.append(str);
                str3 = "*'";
            } else if (i2 == 1) {
                sb = new StringBuilder();
                sb.append("Select rowid as _id,Id as docId, indexName as Name,indexType,section from search where search match 'indexName:");
                sb.append(str);
                sb.append("* AND indexType:");
                sb.append(this.B4.getString("name"));
                str3 = "'";
            } else if (i2 == 2) {
                sb = new StringBuilder();
                sb.append("select * from document where id in (");
                sb.append(this.B4.getString("docId").replace("|", ","));
                sb.append(") and lower(title) like '");
                sb.append(str.toLowerCase());
                str3 = "%'";
            } else {
                str2 = "";
                return this.k4.V(this.h4, str2);
            }
            sb.append(str3);
            str2 = sb.toString();
            return this.k4.V(this.h4, str2);
        }

        public ArrayList<Bundle> g3(String str) {
            CompressHelper compressHelper = this.k4;
            Bundle bundle = this.h4;
            return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new SSSearchFragment());
    }
}
