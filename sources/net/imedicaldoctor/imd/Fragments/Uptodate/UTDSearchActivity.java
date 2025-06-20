package net.imedicaldoctor.imd.Fragments.Uptodate;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.exifinterface.media.ExifInterface;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.itextpdf.tool.xml.html.HTML;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import java.io.File;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.VBHelper;
import net.imedicaldoctor.imd.ViewHolders.ChaptersSectionAdapter;
import net.imedicaldoctor.imd.ViewHolders.UTDSearchAdapter;
import net.imedicaldoctor.imd.iMDActivity;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class UTDSearchActivity extends iMDActivity {

    public static class UTDSearchFragment extends SearchHelperFragment {
        public AsyncTask A4;
        public TabLayout B4;
        public UTDSearchAdapter C4;
        /* access modifiers changed from: private */
        public StickyRecyclerHeadersDecoration D4;

        private boolean n3() {
            return new File(CompressHelper.g1(this.h4, "unidex.en.sqlite")).exists();
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1494search, menu);
            this.s4 = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
            R2();
        }

        public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            ArrayList<Bundle> W;
            View inflate = layoutInflater.inflate(R.layout.f1277fragment_utdsearch, viewGroup, false);
            this.q4 = inflate;
            W2(bundle);
            S2();
            this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
            R2();
            this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
            this.B4 = (TabLayout) this.q4.findViewById(R.id.f1111tabs);
            if (n3()) {
                this.B4.setVisibility(0);
            } else {
                this.B4.setVisibility(8);
            }
            this.B4.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
                public void a(TabLayout.Tab tab) {
                }

                public void b(TabLayout.Tab tab) {
                    if (UTDSearchFragment.this.s4.getQuery().length() > 0) {
                        SearchView searchView = UTDSearchFragment.this.s4;
                        searchView.k0(searchView.getQuery(), true);
                    }
                }

                public void c(TabLayout.Tab tab) {
                }
            });
            String[] strArr = {"All", "Adult", "Pediatric", "Patient"};
            for (int i2 = 0; i2 < 4; i2++) {
                TabLayout.Tab I = this.B4.I();
                I.D(strArr[i2]);
                this.B4.i(I);
            }
            AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
            final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
            if (!y().containsKey("Parent")) {
                appBarLayout.D(true, false);
                relativeLayout.setVisibility(0);
                W = this.k4.W(this.h4, "select 99999 as id, 'Video Index' as title, 0 as parentId, 0 as leaf,'' as section union SELECT * FROM toc where parentId=0", "utdtoc.db");
            } else {
                appBarLayout.D(false, false);
                appBarLayout.postDelayed(new Runnable() {
                    public void run() {
                        relativeLayout.setVisibility(0);
                    }
                }, 800);
                String string = y().getString("Parent");
                if (string.equals("99999")) {
                    W = this.k4.W(this.h4, "SELECT Text as title,URL as id,1 as leaf ,'Video Index' as section  FROM search where search.'table' match 'movie'", "fsearch.db");
                } else {
                    CompressHelper compressHelper = this.k4;
                    Bundle bundle2 = this.h4;
                    W = compressHelper.W(bundle2, "SELECT * FROM toc where parentId=" + string, "utdtoc.db");
                }
            }
            this.n4 = W;
            ArrayList arrayList = new ArrayList();
            ((TextView) this.q4.findViewById(R.id.f1141toolbar_subtext_view)).setText(m3());
            if (this.n4 == null) {
                this.n4 = new ArrayList<>();
                new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme).l("The database is corrupt as the result of low disk space, corrupted download or cleaner apps. please delete uptodate database and download it again from the downloads page").p("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        new AlertDialog.Builder(UTDSearchFragment.this.r(), R.style.f2185alertDialogTheme).l("Are you sure ?").y("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                UTDSearchFragment.this.i3(new File(UTDSearchFragment.this.h4.getString("Path")));
                                LocalBroadcastManager.b(UTDSearchFragment.this.r()).d(new Intent("reload"));
                                UTDSearchFragment.this.k4.Z1(false);
                                UTDSearchFragment.this.k4.Z1(true);
                            }
                        }).p("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        }).I();
                    }
                }).s("More Info", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        UTDSearchFragment.this.o3("http://imedicaldoctor.net/faq#null");
                        UTDSearchFragment.this.k4.W1(false);
                    }
                }).I();
            }
            Iterator<Bundle> it2 = this.n4.iterator();
            while (it2.hasNext()) {
                Bundle next = it2.next();
                if (next.getString(HTML.Tag.V).equals("")) {
                    next.remove(HTML.Tag.V);
                    next.putString(HTML.Tag.V, "Table of Contents");
                }
                arrayList.add(next);
            }
            this.k4.r2(arrayList, HTML.Tag.V);
            this.l4 = new ChaptersSectionAdapter(r(), this.n4, "title", HTML.Tag.V) {
                public void f0(Bundle bundle, int i2) {
                    CompressHelper compressHelper;
                    Bundle bundle2;
                    StringBuilder sb;
                    String str;
                    UTDSearchFragment.this.V2();
                    if (!bundle.getString("leaf").equals(IcyHeaders.a3)) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putBundle("DB", UTDSearchFragment.this.h4);
                        bundle3.putString("Parent", bundle.getString("id"));
                        UTDSearchFragment.this.k4.N(UTDSearchActivity.class, UTDSearchFragment.class, bundle3);
                    } else if (bundle.getString("id").contains("Graphic-")) {
                        new CompressHelper(UTDSearchFragment.this.r()).A1(UTDSearchFragment.this.h4, bundle.getString("id"), (String[]) null, (String) null);
                    } else {
                        String string = bundle.getString("title");
                        UTDSearchFragment uTDSearchFragment = UTDSearchFragment.this;
                        CompressHelper compressHelper2 = uTDSearchFragment.k4;
                        Bundle bundle4 = uTDSearchFragment.h4;
                        Bundle s1 = compressHelper2.s1(compressHelper2.W(bundle4, "Select * from tocmap where tocId=" + bundle.getString("id"), "utdtoc.db"));
                        if (s1 != null) {
                            compressHelper = new CompressHelper(UTDSearchFragment.this.r());
                            bundle2 = UTDSearchFragment.this.h4;
                            sb = new StringBuilder();
                            sb.append("Topic-");
                            str = "topicId";
                        } else {
                            UTDSearchFragment uTDSearchFragment2 = UTDSearchFragment.this;
                            CompressHelper compressHelper3 = uTDSearchFragment2.k4;
                            Bundle bundle5 = uTDSearchFragment2.h4;
                            s1 = compressHelper3.s1(compressHelper3.W(bundle5, "Select * from topic where title='" + string.replace("'", "''") + "'", "unidex.en.sqlite"));
                            if (s1 == null) {
                                CompressHelper.x2(UTDSearchFragment.this.r(), "Sorry, Can't find it. use search to find similar topics", 1);
                                return;
                            }
                            compressHelper = new CompressHelper(UTDSearchFragment.this.r());
                            bundle2 = UTDSearchFragment.this.h4;
                            sb = new StringBuilder();
                            sb.append("Topic-");
                            str = "topic_id";
                        }
                        sb.append(s1.getString(str));
                        compressHelper.A1(bundle2, sb.toString(), (String[]) null, (String) null);
                    }
                }
            };
            this.C4 = new UTDSearchAdapter(r(), this.o4, "title", (String) null) {
                public void d0(Bundle bundle, int i2) {
                    UTDSearchFragment.this.V2();
                    String string = bundle.getString("_id");
                    if (!string.contains("-")) {
                        string = "Topic-" + string;
                    }
                    new CompressHelper(UTDSearchFragment.this.r()).A1(UTDSearchFragment.this.h4, string, (String[]) null, (String) null);
                }
            };
            this.w4.setAdapter(this.l4);
            StickyRecyclerHeadersDecoration stickyRecyclerHeadersDecoration = new StickyRecyclerHeadersDecoration((StickyRecyclerHeadersAdapter) this.l4);
            this.D4 = stickyRecyclerHeadersDecoration;
            this.w4.setItemDecoration(stickyRecyclerHeadersDecoration);
            this.w4.setLayoutManager(new LinearLayoutManager(r()));
            this.w4.setItemAnimator(new DefaultItemAnimator());
            this.w4.setItemDecoration(new CustomItemDecoration(r()));
            this.l4.Z(new RecyclerView.AdapterDataObserver() {
                public void a() {
                    UTDSearchFragment.this.D4.n();
                }
            });
            o2(true);
            return inflate;
        }

        public void X2() {
            this.C4.e0(this.o4);
            this.w4.setAdapter(this.C4);
            this.D4.n();
            this.w4.A1(this.D4);
        }

        public void Z2() {
            this.w4.setItemDecoration(this.D4);
        }

        public ArrayList<Bundle> a3(String str) {
            String replace = str.replace("'", "''");
            int i2 = 0;
            if (n3()) {
                ArrayList<Bundle> W = this.k4.W(this.h4, "SELECT q.qbtype, x.topic_hits hits FROM query q, query_topic x WHERE q.disp = '" + replace + "'  AND x.nqid = q.nqid AND x.pref = '" + l3() + "'", "unidex.en.sqlite");
                if (W == null || W.size() == 0) {
                    ArrayList<Bundle> W2 = this.k4.W(this.h4, "select Text as title, URL as _id from search where search match '" + replace + "'  ORDER BY rank(matchinfo(search)) DESC limit 20", "fcontentsearch.db");
                    if (W2 != null && W2.size() != 0) {
                        return W2;
                    }
                    return this.k4.W(this.h4, "select Text as title, URL as _id from search where search match '" + replace + "'  ORDER BY rank(matchinfo(search)) DESC limit 20", "fsearch.db");
                }
                String f2 = new VBHelper(r()).f(W.get(0).getByteArray("hits"));
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int i3 = 4;
                while (i3 < f2.length()) {
                    int i4 = i3 + 8;
                    int parseInt = Integer.parseInt(f2.substring(i3, i4), 16);
                    arrayList.add(String.valueOf(parseInt));
                    arrayList2.add("WHEN " + parseInt + " THEN " + i2);
                    i2++;
                    i3 = i4;
                }
                String str2 = "order by case topic_id " + TextUtils.join(StringUtils.SPACE, arrayList2) + " end";
                return this.k4.W(this.h4, "SELECT topic_id as _id, title FROM topic WHERE topic_id IN (" + TextUtils.join(",", arrayList) + ") " + str2, "unidex.en.sqlite");
            }
            String[] split = replace.split(StringUtils.SPACE);
            String str3 = "";
            while (i2 < split.length) {
                if (str3.length() == 0) {
                    str3 = "'" + split[i2] + "'";
                } else {
                    str3 = str3 + " , '" + split[i2] + "'";
                }
                i2++;
            }
            return this.k4.W(this.h4, "select topic.topic_id _id, topic.title, sum( prof  ) * count( * ) * min(count(*),2)  weight , count(*) c from kw2topic_xref, topic, kw where kw.pk =kw2topic_xref.kw_fk and topic.topic_id =kw2topic_xref.topic_id and kw in (" + str3 + ") group by topic.topic_id, topic.title order by weight desc, c desc, topic.title asc limit 50", "utdkw.sqlite");
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x006b  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x007a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.ArrayList<android.os.Bundle> g3(java.lang.String r4) {
            /*
                r3 = this;
                int r0 = r4.length()
                r1 = 1
                java.lang.String r2 = "'"
                if (r0 != r1) goto L_0x001e
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "q1='"
            L_0x0010:
                r0.append(r1)
                r0.append(r4)
                r0.append(r2)
            L_0x0019:
                java.lang.String r0 = r0.toString()
                goto L_0x004f
            L_0x001e:
                int r0 = r4.length()
                r1 = 2
                if (r0 != r1) goto L_0x002d
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "q2='"
                goto L_0x0010
            L_0x002d:
                int r0 = r4.length()
                r1 = 3
                if (r0 != r1) goto L_0x003c
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "q3='"
                goto L_0x0010
            L_0x003c:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "q like '"
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = "%'"
                r0.append(r1)
                goto L_0x0019
            L_0x004f:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "select q _id, u as word, case c when 0 then '' else 'c' || c || ' ' end || case c2 when 0 then '' else ' c_' || c2 || ' ' end u2, p, f from qf where "
                r1.append(r2)
                r1.append(r0)
                java.lang.String r0 = " order by f desc, q asc limit 30"
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                boolean r1 = r3.n3()
                if (r1 == 0) goto L_0x007a
                java.lang.String r4 = r3.j3(r4)
                net.imedicaldoctor.imd.Data.CompressHelper r0 = r3.k4
                android.os.Bundle r1 = r3.h4
                java.lang.String r2 = "unidex.en.sqlite"
                java.util.ArrayList r4 = r0.W(r1, r4, r2)
                goto L_0x0084
            L_0x007a:
                net.imedicaldoctor.imd.Data.CompressHelper r4 = r3.k4
                android.os.Bundle r1 = r3.h4
                java.lang.String r2 = "utdqf.sqlite"
                java.util.ArrayList r4 = r4.W(r1, r0, r2)
            L_0x0084:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Uptodate.UTDSearchActivity.UTDSearchFragment.g3(java.lang.String):java.util.ArrayList");
        }

        public void i3(File file) {
            if (file.isDirectory()) {
                for (File i3 : file.listFiles()) {
                    i3(i3);
                }
            }
            file.delete();
        }

        public String j3(String str) {
            StringBuilder sb;
            String str2;
            String replace = str.replace("'", "''");
            if (replace.length() == 1) {
                sb = new StringBuilder();
                str2 = "d1 = '";
            } else if (replace.length() == 2) {
                sb = new StringBuilder();
                str2 = "d2 = '";
            } else if (replace.length() == 3) {
                sb = new StringBuilder();
                str2 = "d3 = '";
            } else {
                sb = new StringBuilder();
                sb.append("disp like '");
                sb.append(replace);
                sb.append("%'");
                String str3 = "SELECT rowid _id,disp as word, IFNULL(engl, disp) AS useq, weight, qbtype, trprov FROM query WHERE hide IS NULL AND " + sb.toString() + " ORDER BY weight DESC, disp ASC LIMIT " + "30";
                iMDLogger.f("Query:", str3);
                return str3;
            }
            sb.append(str2);
            sb.append(replace);
            sb.append("'");
            String str32 = "SELECT rowid _id,disp as word, IFNULL(engl, disp) AS useq, weight, qbtype, trprov FROM query WHERE hide IS NULL AND " + sb.toString() + " ORDER BY weight DESC, disp ASC LIMIT " + "30";
            iMDLogger.f("Query:", str32);
            return str32;
        }

        public void l1() {
            super.l1();
            V2();
        }

        public String l3() {
            int selectedTabPosition = this.B4.getSelectedTabPosition();
            if (selectedTabPosition == 0) {
                return "X";
            }
            if (selectedTabPosition == 1) {
                return ExifInterface.W4;
            }
            if (selectedTabPosition == 2) {
                return "P";
            }
            return selectedTabPosition == 3 ? "I" : "X";
        }

        public String m3() {
            return new SimpleDateFormat("d MMM yyyy").format(new SimpleDateFormat("yyyyMMdd").parse(this.h4.getString("Version"), new ParsePosition(0)));
        }

        public void o3(String str) {
            D2(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1192activity_utdsearch);
        if (bundle == null) {
            UTDSearchFragment uTDSearchFragment = new UTDSearchFragment();
            uTDSearchFragment.i2(getIntent().getExtras());
            k0().u().f(R.id.container, uTDSearchFragment).r();
        }
    }
}
