package net.imedicaldoctor.imd.Fragments.Dictionary;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
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
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.fragment.app.Fragment;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.itextpdf.tool.xml.html.HTML;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.Lexi.LXItems;
import net.imedicaldoctor.imd.Fragments.Lexi.LXViewer;
import net.imedicaldoctor.imd.Fragments.SearchDialogHelperFragment;
import net.imedicaldoctor.imd.Fragments.Skyscape.SSSearchActivity;
import net.imedicaldoctor.imd.Fragments.Skyscape.SSViewerActivity;
import net.imedicaldoctor.imd.LinearLayoutManagerWithSmoothScroller;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ContentSearchAdapter;
import net.imedicaldoctor.imd.ViewHolders.StatusAdapter;
import net.imedicaldoctor.imd.iMDActivity;
import org.apache.commons.lang3.StringUtils;

public class CDicSearchActivity extends iMDActivity {

    public static class CDicSearchFragment extends SearchDialogHelperFragment {
        private AsyncTask Y4;

        public class ListViewItemContentSearchPlaceHolder {

            /* renamed from: a  reason: collision with root package name */
            public TextView f29696a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f29697b;

            public ListViewItemContentSearchPlaceHolder(View view) {
                this.f29696a = (TextView) view.findViewById(R.id.f1136title_text);
                this.f29697b = (TextView) view.findViewById(R.id.f1098subtitle_text);
            }
        }

        /* access modifiers changed from: private */
        public Bundle C3(Bundle bundle) {
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

        public void B3(final SearchView searchView) {
            searchView.setIconifiedByDefault(false);
            searchView.setQueryHint("Search Dictionary");
            q3();
            searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
                public boolean a(int i2) {
                    Cursor c2 = searchView.getSuggestionsAdapter().c();
                    if (!c2.moveToPosition(i2)) {
                        return false;
                    }
                    String string = c2.getString(c2.getColumnIndex("word"));
                    if (searchView.getTag(1) != null && ((String) searchView.getTag(1)).length() > 0) {
                        string = searchView.getTag() + StringUtils.SPACE + string;
                    }
                    searchView.k0(string, true);
                    return false;
                }

                public boolean b(int i2) {
                    Cursor c2 = searchView.getSuggestionsAdapter().c();
                    if (!c2.moveToPosition(i2)) {
                        return false;
                    }
                    String string = c2.getString(c2.getColumnIndex("word"));
                    if (searchView.getTag() != null && ((String) searchView.getTag()).length() > 0) {
                        string = searchView.getTag() + StringUtils.SPACE + string;
                    }
                    searchView.k0(string, true);
                    return false;
                }
            });
            ((ImageView) searchView.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    searchView.k0("", false);
                    searchView.clearFocus();
                    CDicSearchFragment.this.x3("Search Anything");
                    CDicSearchFragment.this.n3();
                }
            });
            searchView.setSuggestionsAdapter(new CursorAdapter(r(), (Cursor) null, 0) {
                public void e(View view, Context context, Cursor cursor) {
                    ((TextView) view.getTag()).setText(cursor.getString(cursor.getColumnIndex("word")));
                }

                public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                    View inflate = LayoutInflater.from(context).inflate(R.layout.f1374list_view_item_spell, viewGroup, false);
                    inflate.setTag(inflate.findViewById(R.id.text));
                    return inflate;
                }
            });
            final CompressHelper compressHelper = new CompressHelper(r());
            Observable.w1(new ObservableOnSubscribe<String>() {
                public void a(@NonNull final ObservableEmitter<String> observableEmitter) throws Throwable {
                    CDicSearchFragment.this.T4.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                        public boolean a(String str) {
                            CDicSearchFragment cDicSearchFragment = CDicSearchFragment.this;
                            if (!cDicSearchFragment.J4) {
                                return true;
                            }
                            cDicSearchFragment.G4 = str;
                            observableEmitter.onNext(str);
                            return true;
                        }

                        public boolean b(final String str) {
                            AnonymousClass5 r0 = AnonymousClass5.this;
                            CompressHelper compressHelper = compressHelper;
                            Bundle bundle = CDicSearchFragment.this.I4;
                            compressHelper.b0(bundle, "Select rowid as _id,* from search where word match '" + str + "' order by word collate nocase asc", "Search.db").h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<ArrayList<Bundle>>() {
                                /* renamed from: a */
                                public void accept(ArrayList<Bundle> arrayList) throws Throwable {
                                    if (arrayList == null) {
                                        CDicSearchFragment.this.x3("Nothing Found");
                                    } else {
                                        CDicSearchFragment.this.w3();
                                        CDicSearchFragment.this.w3();
                                        final int i2 = 0;
                                        if (arrayList.size() > 0) {
                                            Iterator<Bundle> it2 = arrayList.iterator();
                                            while (it2.hasNext() && !it2.next().getString("word").toLowerCase().startsWith(str.toLowerCase())) {
                                                i2++;
                                            }
                                        }
                                        CDicSearchFragment.this.M4.f0(arrayList);
                                        if (arrayList.size() > 0) {
                                            CDicSearchFragment.this.X4.postDelayed(new Runnable() {
                                                public void run() {
                                                    CDicSearchFragment.this.X4.X1(i2);
                                                }
                                            }, 1000);
                                        }
                                    }
                                    CDicSearchFragment.this.n3();
                                }
                            }, new Consumer<Throwable>() {
                                /* renamed from: a */
                                public void accept(Throwable th) throws Throwable {
                                }
                            });
                            return false;
                        }
                    });
                }
            }).x1(500, TimeUnit.MILLISECONDS).e6(new Consumer<String>() {
                /* renamed from: a */
                public void accept(String str) throws Throwable {
                    if (str.length() > 1) {
                        String[] split = str.trim().split(StringUtils.SPACE);
                        String str2 = split[split.length - 1];
                        String str3 = "";
                        for (int i2 = 0; i2 < split.length - 1; i2++) {
                            str3 = str3 + StringUtils.SPACE + split[i2];
                        }
                        CDicSearchFragment.this.T4.setTag(str3.trim());
                        compressHelper.b0(CDicSearchFragment.this.I4, "Select rowid as _id,word from spell where word match '" + str2 + "*'", "Search.db").h6(Schedulers.e()).s4(AndroidSchedulers.e()).d6(new Consumer<ArrayList<Bundle>>() {
                            /* renamed from: a */
                            public void accept(ArrayList<Bundle> arrayList) throws Throwable {
                                CDicSearchFragment.this.T4.getSuggestionsAdapter().m(compressHelper.h(arrayList));
                            }
                        });
                    }
                }
            }, new Consumer<Throwable>() {
                /* renamed from: a */
                public void accept(Throwable th) throws Throwable {
                }
            });
            String str = this.G4;
            if (str != null && str.length() > 0) {
                this.T4.k0(this.G4, true);
            }
        }

        public void D3(Fragment fragment, String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("DB", bundle);
            bundle2.putString("URL", str);
            bundle2.putString("Dialog", IcyHeaders.a3);
            fragment.i2(bundle2);
            z().u().o("something").M(R.anim.f15from_fade_in, R.anim.f16from_fade_out).C(R.id.f910dic, fragment).r();
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1494search, menu);
            SearchView searchView = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
            this.T4 = searchView;
            B3(searchView);
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.K4 = new CompressHelper(r());
            View inflate = layoutInflater.inflate(y().containsKey("Dialog") ? R.layout.f1217fragment_cdic_dialog : R.layout.f1246fragment_new_list, viewGroup, false);
            this.R4 = inflate;
            o3(bundle);
            k3();
            SearchView searchView = (SearchView) this.R4.findViewById(R.id.f1069search_view);
            this.T4 = searchView;
            B3(searchView);
            this.X4 = (RecyclerView) this.R4.findViewById(R.id.f1054recycler_view);
            RelativeLayout relativeLayout = (RelativeLayout) this.R4.findViewById(R.id.f830background_layout);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            this.M4 = new ContentSearchAdapter(r(), this.O4, "word", "source") {
                public void e0(Bundle bundle, int i2) {
                    Bundle bundle2 = bundle;
                    String string = bundle2.getString("word");
                    String string2 = bundle2.getString("source");
                    String string3 = bundle2.getString("sourceId");
                    String string4 = bundle2.getString("id");
                    String str = string4 + ",,,,," + string;
                    if (string2.equals("Persian")) {
                        if (CDicSearchFragment.this.y().containsKey("Dialog")) {
                            CDicSearchFragment.this.D3(new CDicEPActivity.CDicEPFragment(), "EP-" + str + ",,,,," + string, CDicSearchFragment.this.I4);
                            return;
                        }
                        CDicSearchFragment cDicSearchFragment = CDicSearchFragment.this;
                        cDicSearchFragment.K4.A1(cDicSearchFragment.I4, "EP-" + str + ",,,,," + string, (String[]) null, (String) null);
                    } else if (string3.equals("5") || string3.equals("10") || string3.equals("15")) {
                        new Bundle();
                        String string5 = bundle2.getString(HTML.Tag.V).length() > 0 ? bundle2.getString(HTML.Tag.V) : null;
                        if (CDicSearchFragment.this.y().containsKey("Dialog")) {
                            CDicSearchFragment.this.D3(new CDicEEActivity.CDicEEFragment(), "EE-" + string3 + ",,,,," + string4 + ",,,,," + string, CDicSearchFragment.this.I4);
                            return;
                        }
                        CDicSearchFragment cDicSearchFragment2 = CDicSearchFragment.this;
                        cDicSearchFragment2.K4.A1(cDicSearchFragment2.I4, "EE-" + string3 + ",,,,," + string4 + ",,,,," + string, (String[]) null, string5);
                    } else if (string3.equals("30") || string3.equals("35") || string3.equals("40") || string3.equals("45")) {
                        Bundle i1 = CDicSearchFragment.this.K4.i1(string3.equals("30") ? "K3ZGDATA.db" : string3.equals("35") ? "K2AJDATA.db" : string3.equals("40") ? "K354DATA.db" : string3.equals("45") ? "K2WCDATA.db" : "");
                        if (i1 == null) {
                            CompressHelper.x2(CDicSearchFragment.this.r(), string2 + " Is Not Installed", 1);
                            return;
                        } else if (string4.contains("|")) {
                            Bundle bundle3 = new Bundle();
                            Bundle bundle4 = new Bundle();
                            bundle4.putString("docId", string4);
                            bundle4.putString("name", string);
                            bundle4.putString(HTML.Tag.V, bundle2.getString(HTML.Tag.V));
                            bundle3.putBundle("SelectedItem", bundle4);
                            bundle3.putBundle("DB", i1);
                            bundle3.putInt("Mode", 2);
                            bundle3.putBundle("GotoSections", CDicSearchFragment.this.C3(bundle4));
                            CDicSearchFragment.this.K4.N(SSSearchActivity.class, SSSearchActivity.SSSearchFragment.class, bundle3);
                        } else if (CDicSearchFragment.this.y().containsKey("Dialog")) {
                            CDicSearchFragment.this.D3(new SSViewerActivity.SSViewerFragment(), string4, i1);
                            return;
                        } else {
                            CDicSearchFragment.this.K4.A1(i1, string4, (String[]) null, bundle2.getString(HTML.Tag.V));
                        }
                    } else if (string3.equals("20")) {
                        Bundle i12 = CDicSearchFragment.this.K4.i1("593_lww_abbrev.sqlite");
                        if (i12 == null) {
                            CompressHelper.x2(CDicSearchFragment.this.r(), string2 + " Is Not Installed", 1);
                            return;
                        }
                        CompressHelper compressHelper = CDicSearchFragment.this.K4;
                        Bundle z = compressHelper.z(compressHelper.V(i12, "Select count(*) as c from indexitem_document where indexitem_id=" + string4));
                        if (z == null || z.getString("c").equals(IcyHeaders.a3)) {
                            CompressHelper compressHelper2 = CDicSearchFragment.this.K4;
                            Bundle z2 = compressHelper2.z(compressHelper2.V(i12, "select document_id from indexitem_document where indexitem_id=" + string4));
                            if (CDicSearchFragment.this.y().containsKey("Dialog")) {
                                CDicSearchFragment.this.D3(new LXViewer.LXViewerFragment(), z2.getString("document_id"), i12);
                                return;
                            }
                            CDicSearchFragment.this.K4.A1(i12, z2.getString("document_id"), (String[]) null, (String) null);
                        } else {
                            Bundle bundle5 = new Bundle();
                            bundle5.putString("ParentId", string4);
                            bundle5.putInt("Mode", 2);
                            bundle5.putBundle("DB", i12);
                            CDicSearchFragment.this.K4.N(LXItems.class, LXItems.LXItemsFragment.class, bundle5);
                        }
                    }
                    try {
                        if (CDicSearchFragment.this.y().containsKey("Dialog")) {
                            CDicSearchFragment.this.M2();
                        }
                    } catch (Exception unused) {
                    }
                }
            };
            g3();
            x3("Search Anything");
            if (y().containsKey("Dialog")) {
                this.T4.k0(y().getString("Dialog"), true);
                Q2().getWindow().requestFeature(1);
            }
            o2(false);
            return inflate;
        }

        public void g3() {
            this.X4.setItemAnimator(new DefaultItemAnimator());
            this.X4.setItemDecoration(new CustomItemDecoration(r()));
            this.X4.setLayoutManager(new LinearLayoutManagerWithSmoothScroller(r(), 1, false));
        }

        public void n1() {
            super.n1();
            Dialog Q2 = Q2();
            if (Q2 != null) {
                Q2.getWindow().setLayout(-1, -1);
            }
        }

        public void w3() {
            RecyclerView.Adapter adapter = this.X4.getAdapter();
            ContentSearchAdapter contentSearchAdapter = this.M4;
            if (adapter != contentSearchAdapter) {
                this.X4.setAdapter(contentSearchAdapter);
            }
        }

        public void x3(String str) {
            this.X4.setAdapter(new StatusAdapter(r(), str));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new CDicSearchFragment());
    }
}
