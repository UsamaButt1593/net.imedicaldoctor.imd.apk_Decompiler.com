package net.imedicaldoctor.imd.Fragments.NEJM;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.ContentSearchAdapter;
import net.imedicaldoctor.imd.iMDActivity;

public class NEJMTOCActivity extends iMDActivity {

    public static class NEJMTOCFragment extends SearchHelperFragment {
        private static String D4;
        /* access modifiers changed from: private */
        public String A4;
        /* access modifiers changed from: private */
        public String B4;
        /* access modifiers changed from: private */
        public String C4;

        public class NEJMTOCAdapter extends RecyclerView.Adapter {

            /* renamed from: d  reason: collision with root package name */
            public Context f29839d;

            /* renamed from: e  reason: collision with root package name */
            public ArrayList<Bundle> f29840e;

            /* renamed from: f  reason: collision with root package name */
            public String f29841f;

            public NEJMTOCAdapter(Context context, ArrayList<Bundle> arrayList, String str) {
                this.f29839d = context;
                this.f29840e = arrayList;
                this.f29841f = str;
            }

            public int C(int i2) {
                return 1;
            }

            public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
                TextView textView;
                int i3;
                RippleTextSubtitleViewHolder rippleTextSubtitleViewHolder = (RippleTextSubtitleViewHolder) viewHolder;
                final Bundle bundle = this.f29840e.get(i2);
                String string = bundle.getString(this.f29841f);
                if (string.length() == 0) {
                    string = "TOC and Adverts";
                }
                if (!NEJMTOCFragment.this.A4.equals("0")) {
                    rippleTextSubtitleViewHolder.I.setText(string);
                    rippleTextSubtitleViewHolder.J.setVisibility(0);
                    if (bundle.getString("subtitle").length() == 0) {
                        rippleTextSubtitleViewHolder.J.setVisibility(8);
                    } else {
                        rippleTextSubtitleViewHolder.J.setVisibility(0);
                        rippleTextSubtitleViewHolder.J.setText(bundle.getString("subtitle"));
                    }
                } else {
                    rippleTextSubtitleViewHolder.I.setText(string);
                    rippleTextSubtitleViewHolder.J.setText("");
                    rippleTextSubtitleViewHolder.J.setVisibility(8);
                    if (i2 % 2 == 0) {
                        textView = rippleTextSubtitleViewHolder.I;
                        i3 = ViewCompat.y;
                    } else {
                        textView = rippleTextSubtitleViewHolder.I;
                        i3 = -12303292;
                    }
                    textView.setTextColor(i3);
                }
                rippleTextSubtitleViewHolder.K.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        NEJMTOCAdapter.this.d0(bundle, i2);
                    }
                });
            }

            public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                return new RippleTextSubtitleViewHolder(LayoutInflater.from(this.f29839d).inflate(R.layout.f1352list_view_item_ripple_text_subtitle, viewGroup, false));
            }

            public int b() {
                return this.f29840e.size();
            }

            public void d0(Bundle bundle, int i2) {
                Bundle bundle2;
                CompressHelper compressHelper;
                Class<NEJMTOCFragment> cls = NEJMTOCFragment.class;
                Class<NEJMTOCActivity> cls2 = NEJMTOCActivity.class;
                if (NEJMTOCFragment.this.A4.equals("0")) {
                    bundle2 = new Bundle();
                    bundle2.putBundle("DB", NEJMTOCFragment.this.h4);
                    bundle2.putString("ParentId", bundle.getString("title"));
                    compressHelper = new CompressHelper(NEJMTOCFragment.this.r());
                } else if (NEJMTOCFragment.this.A4.equals("Issues")) {
                    bundle2 = new Bundle();
                    bundle2.putBundle("DB", NEJMTOCFragment.this.h4);
                    bundle2.putString("ParentId", bundle.getString("title"));
                    bundle2.putString("Issue", bundle.getString("issueName"));
                    compressHelper = new CompressHelper(NEJMTOCFragment.this.r());
                } else if (NEJMTOCFragment.this.B4 == null || NEJMTOCFragment.this.C4 != null) {
                    NEJMTOCFragment nEJMTOCFragment = NEJMTOCFragment.this;
                    nEJMTOCFragment.k4.A1(nEJMTOCFragment.h4, bundle.getString("pid"), (String[]) null, (String) null);
                    return;
                } else {
                    bundle2 = new Bundle();
                    bundle2.putBundle("DB", NEJMTOCFragment.this.h4);
                    bundle2.putString("ParentId", bundle.getString("title"));
                    bundle2.putString("Issue", NEJMTOCFragment.this.B4);
                    bundle2.putString("IssueSection", bundle.getString("title"));
                    compressHelper = new CompressHelper(NEJMTOCFragment.this.r());
                }
                compressHelper.N(cls2, cls, bundle2);
            }
        }

        public class RippleTextSubtitleViewHolder extends RecyclerView.ViewHolder {
            public TextView I;
            public TextView J;
            public MaterialRippleLayout K;

            public RippleTextSubtitleViewHolder(View view) {
                super(view);
                this.I = (TextView) view.findViewById(R.id.f1132text_view);
                this.J = (TextView) view.findViewById(R.id.f1089sub_text_view);
                this.K = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
            }
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1494search, menu);
            this.s4 = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
            O2();
        }

        public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            CompressHelper compressHelper;
            Bundle bundle2;
            StringBuilder sb;
            String str;
            ArrayList<Bundle> V;
            CompressHelper compressHelper2;
            Bundle bundle3;
            String str2;
            View inflate = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
            this.q4 = inflate;
            W2(bundle);
            S2();
            this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
            O2();
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
            if (y() != null && y().containsKey("Issue")) {
                this.B4 = y().getString("Issue");
            }
            if (y() != null && y().containsKey("IssueSection")) {
                this.C4 = y().getString("IssueSection");
            }
            if (this.A4.equals("0")) {
                ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{"Perspective", "Original Articles", "Review Article", "Images in Clinical Medicine", "Case Records of the Massachusetts General Hospital", "Editorial", "Correspondence", "Corrections", "Clinical Implications of Basic Research", "Editorials", "Special Article", "Clinical Therapeutics", "Clinical Practice", "Clinical Problem-Solving", "Review Articles", "Clinical Decisions", "Health Policy Report", "Correction", "Videos in Clinical Medicine", "Sounding Board", "Health Law, Ethics, and Human Rights", "Special Report", "Medicine and Society", "Special Articles", "Special Reports", "Occasional Notes", "Statistics in Medicine"}));
                Collections.sort(arrayList);
                ArrayList<Bundle> arrayList2 = new ArrayList<>();
                Bundle bundle4 = new Bundle();
                bundle4.putString("title", "Issues");
                arrayList2.add(bundle4);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Bundle bundle5 = new Bundle();
                    bundle5.putString("title", (String) it2.next());
                    arrayList2.add(bundle5);
                }
                this.n4 = arrayList2;
            } else {
                if (this.A4.equals("Issues")) {
                    compressHelper2 = this.k4;
                    bundle3 = this.h4;
                    str2 = "Select subtitle as title,title as subtitle,issueName from issues order by publishedDate desc";
                } else {
                    if (this.B4 == null) {
                        compressHelper = this.k4;
                        bundle2 = this.h4;
                        sb = new StringBuilder();
                        sb.append("Select title,issueTitle as subtitle,pid from contents where sectionName = '");
                        str = this.A4;
                    } else if (this.C4 != null) {
                        compressHelper = this.k4;
                        bundle2 = this.h4;
                        sb = new StringBuilder();
                        sb.append("Select title,issueTitle as subtitle,pid from contents where issueName='");
                        sb.append(this.B4);
                        sb.append("' AND sectionName = '");
                        str = this.C4;
                    } else {
                        compressHelper2 = this.k4;
                        bundle3 = this.h4;
                        str2 = "Select distinct(sectionName) as title,'' as subtitle from contents where issueName='" + this.B4 + "'";
                    }
                    sb.append(str);
                    sb.append("' order by issueDate desc");
                    V = compressHelper.V(bundle2, sb.toString());
                    this.n4 = V;
                }
                V = compressHelper2.V(bundle3, str2);
                this.n4 = V;
            }
            this.l4 = new NEJMTOCAdapter(r(), this.n4, "title");
            this.m4 = new ContentSearchAdapter(r(), this.o4, "text", "subText") {
                public void e0(Bundle bundle, int i2) {
                    NEJMTOCFragment.this.V2();
                    String string = bundle.getString("type");
                    String string2 = bundle.getString("contentId");
                    bundle.getString(HTML.Tag.V);
                    if (string.equals(IcyHeaders.a3)) {
                        new CompressHelper(NEJMTOCFragment.this.r()).A1(NEJMTOCFragment.this.h4, string2, (String[]) null, (String) null);
                    } else if (string.equals("5")) {
                        CompressHelper compressHelper = new CompressHelper(NEJMTOCFragment.this.r());
                        NEJMTOCFragment nEJMTOCFragment = NEJMTOCFragment.this;
                        compressHelper.A1(nEJMTOCFragment.h4, string2, nEJMTOCFragment.T2(bundle.getString("subText")), (String) null);
                    }
                }
            };
            this.w4.setAdapter(this.l4);
            N2();
            o2(false);
            return inflate;
        }

        public ArrayList<Bundle> a3(String str) {
            CompressHelper compressHelper = this.k4;
            Bundle bundle = this.h4;
            return compressHelper.V(bundle, "Select rowid as _id, Text as text,snippet(search) as subText, type, contentId from search where search match '" + str + "' ORDER BY rank(matchinfo(search)) DESC");
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
        a1(bundle, new NEJMTOCFragment());
    }
}
