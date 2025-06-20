package net.imedicaldoctor.imd.Fragments;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.basusingh.beautifulprogressdialog.BeautifulProgressDialog;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Data.HistoryAdapter;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ContentSearchAdapter;
import net.imedicaldoctor.imd.Views.ButtonSmall;
import org.apache.commons.lang3.StringUtils;

public class SearchHelperFragment extends Fragment {
    public int e4;
    public String f4;
    public ListView g4;
    public Bundle h4;
    public boolean i4;
    public boolean j4;
    public CompressHelper k4;
    public RecyclerView.Adapter l4;
    public ContentSearchAdapter m4;
    public ArrayList<Bundle> n4;
    public ArrayList<Bundle> o4;
    public ArrayList<Bundle> p4;
    public View q4;
    public Toolbar r4;
    public SearchView s4;
    public ImageView t4;
    public TextView u4;
    public ButtonSmall v4;
    public RecyclerView w4;
    public ImageButton x4;
    /* access modifiers changed from: private */
    public DrawerLayout y4;
    public RecyclerView z4;

    public class ContentSearchViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f29895a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f29896b;

        public ContentSearchViewHolder(View view) {
            this.f29895a = (TextView) view.findViewById(R.id.f1136title_text);
            this.f29896b = (TextView) view.findViewById(R.id.f1098subtitle_text);
        }
    }

    public void J2() {
        AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
        final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
        appBarLayout.D(false, false);
        appBarLayout.postDelayed(new Runnable() {
            public void run() {
                relativeLayout.setVisibility(0);
            }
        }, 800);
    }

    public void K2() {
        SearchView searchView = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        this.s4 = searchView;
        searchView.setIconifiedByDefault(false);
        this.s4.setQueryHint("Can't Search in Demo");
        this.s4.setEnabled(false);
    }

    public void L2(final Runnable runnable, final Runnable runnable2) {
        final BeautifulProgressDialog beautifulProgressDialog = new BeautifulProgressDialog(r(), BeautifulProgressDialog.q, (String) null);
        beautifulProgressDialog.p("loading-1.json");
        beautifulProgressDialog.q(true);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(500);
                    SearchHelperFragment.this.q4.post(new Runnable() {
                        public void run() {
                            AnonymousClass8 r0 = AnonymousClass8.this;
                            if (!SearchHelperFragment.this.j4) {
                                beautifulProgressDialog.w();
                            }
                        }
                    });
                } catch (InterruptedException unused) {
                }
            }
        }).start();
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull ObservableEmitter<String> observableEmitter) throws Throwable {
                try {
                    runnable.run();
                    observableEmitter.onNext("asdfadf");
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    e2.printStackTrace();
                    SearchHelperFragment.this.j4 = true;
                    beautifulProgressDialog.a();
                }
            }
        }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).e6(new Consumer<String>() {
            /* renamed from: a */
            public void accept(String str) throws Throwable {
                SearchHelperFragment.this.j4 = true;
                beautifulProgressDialog.a();
                try {
                    runnable2.run();
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                }
            }
        }, new Consumer<Throwable>() {
            /* renamed from: a */
            public void accept(Throwable th) throws Throwable {
                SearchHelperFragment.this.j4 = true;
                beautifulProgressDialog.a();
                th.printStackTrace();
                FirebaseCrashlytics.d().g(th);
                runnable2.run();
            }
        });
    }

    public void N0(Context context) {
        super.N0(context);
    }

    public void N2() {
        this.w4.setItemAnimator(new DefaultItemAnimator());
        this.w4.p(new CustomItemDecoration(B()));
        this.w4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
    }

    public void O2() {
        if (this.h4.containsKey("Demo")) {
            K2();
            return;
        }
        SearchView searchView = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        this.s4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        this.s4.setIconifiedByDefault(false);
        this.s4.setQueryHint("Search All");
        Y2();
        this.s4.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            public boolean a(int i2) {
                Cursor c2 = SearchHelperFragment.this.s4.getSuggestionsAdapter().c();
                if (!c2.moveToPosition(i2)) {
                    return false;
                }
                String string = c2.getString(c2.getColumnIndex("word"));
                if (SearchHelperFragment.this.s4.getTag(1) != null && ((String) SearchHelperFragment.this.s4.getTag(1)).length() > 0) {
                    string = SearchHelperFragment.this.s4.getTag() + StringUtils.SPACE + string;
                }
                SearchHelperFragment.this.s4.k0(string, true);
                return false;
            }

            public boolean b(int i2) {
                Cursor c2 = SearchHelperFragment.this.s4.getSuggestionsAdapter().c();
                if (!c2.moveToPosition(i2)) {
                    return false;
                }
                String string = c2.getString(c2.getColumnIndex("word"));
                if (SearchHelperFragment.this.s4.getTag() != null && ((String) SearchHelperFragment.this.s4.getTag()).length() > 0) {
                    string = SearchHelperFragment.this.s4.getTag() + StringUtils.SPACE + string;
                }
                SearchHelperFragment.this.s4.k0(string, true);
                return false;
            }
        });
        ((ImageView) this.s4.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SearchHelperFragment.this.s4.k0("", false);
                SearchHelperFragment.this.s4.clearFocus();
                SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                searchHelperFragment.w4.setAdapter(searchHelperFragment.l4);
                SearchHelperFragment.this.V2();
                SearchHelperFragment.this.Z2();
            }
        });
        ((SearchView.SearchAutoComplete) this.s4.findViewById(R.id.search_src_text)).setDropDownAnchor(R.id.f1069search_view);
        this.s4.setSuggestionsAdapter(new CursorAdapter(r(), (Cursor) null, 0) {
            public void e(View view, Context context, Cursor cursor) {
                ((TextView) view.getTag()).setText(cursor.getString(cursor.getColumnIndex("word")));
            }

            public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.f1374list_view_item_spell, viewGroup, false);
                inflate.setTag(inflate.findViewById(R.id.text));
                return inflate;
            }
        });
        this.s4.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(final String str) {
                SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                if (!searchHelperFragment.i4) {
                    return true;
                }
                searchHelperFragment.f4 = str;
                if (str.length() <= 1) {
                    return false;
                }
                new AsyncTask() {
                    /* access modifiers changed from: protected */
                    public Object doInBackground(Object[] objArr) {
                        String[] split = str.trim().split(StringUtils.SPACE);
                        String str = split[split.length - 1];
                        String str2 = "";
                        for (int i2 = 0; i2 < split.length - 1; i2++) {
                            str2 = str2 + StringUtils.SPACE + split[i2];
                        }
                        SearchHelperFragment.this.s4.setTag(str2.trim());
                        return SearchHelperFragment.this.g3(str);
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        SearchHelperFragment.this.s4.getSuggestionsAdapter().m(SearchHelperFragment.this.k4.h((ArrayList) obj));
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                return true;
            }

            public boolean b(final String str) {
                new AsyncTask() {
                    /* access modifiers changed from: protected */
                    public Object doInBackground(Object[] objArr) {
                        SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                        searchHelperFragment.o4 = searchHelperFragment.a3(str);
                        return null;
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        SearchHelperFragment.this.X2();
                    }

                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                        try {
                            SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                            CompressHelper compressHelper = searchHelperFragment.k4;
                            String str = searchHelperFragment.f4;
                            compressHelper.I(str, SearchHelperFragment.this.h4.getString("Name") + " --- " + SearchHelperFragment.this.h4.getString("Title"));
                        } catch (Exception e2) {
                            FirebaseCrashlytics.d().g(e2);
                        }
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                return false;
            }
        });
    }

    public void P2() {
        if (this.h4.containsKey("Demo")) {
            K2();
            return;
        }
        SearchView searchView = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        this.s4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        this.s4.setIconifiedByDefault(false);
        this.s4.setQueryHint("Search");
        Y2();
        ((ImageView) this.s4.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SearchHelperFragment.this.s4.k0("", false);
                SearchHelperFragment.this.s4.clearFocus();
                SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                searchHelperFragment.w4.setAdapter(searchHelperFragment.l4);
                SearchHelperFragment.this.V2();
                SearchHelperFragment.this.Z2();
            }
        });
        this.s4.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(final String str) {
                SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                if (!searchHelperFragment.i4) {
                    return true;
                }
                searchHelperFragment.f4 = str;
                if (str.length() <= 1) {
                    return false;
                }
                new AsyncTask() {
                    /* access modifiers changed from: protected */
                    public Object doInBackground(Object[] objArr) {
                        SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                        searchHelperFragment.o4 = searchHelperFragment.a3(str);
                        return null;
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        SearchHelperFragment.this.X2();
                    }

                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                return true;
            }

            public boolean b(String str) {
                return false;
            }
        });
    }

    public void Q2() {
        if (this.h4.containsKey("Demo")) {
            K2();
            return;
        }
        SearchView searchView = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        this.s4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        this.s4.setIconifiedByDefault(false);
        this.s4.setQueryHint("Search");
        this.i4 = true;
        ((ImageView) this.s4.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SearchHelperFragment.this.s4.k0("", false);
                SearchHelperFragment.this.s4.clearFocus();
                SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                searchHelperFragment.w4.setAdapter(searchHelperFragment.l4);
                SearchHelperFragment.this.V2();
                SearchHelperFragment.this.Z2();
            }
        });
        this.s4.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(final String str) {
                SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                if (!searchHelperFragment.i4) {
                    return true;
                }
                searchHelperFragment.f4 = str;
                if (str.length() > 1) {
                    new AsyncTask() {
                        /* access modifiers changed from: protected */
                        public Object doInBackground(Object[] objArr) {
                            SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                            searchHelperFragment.o4 = searchHelperFragment.a3(str);
                            SearchHelperFragment searchHelperFragment2 = SearchHelperFragment.this;
                            searchHelperFragment2.p4 = searchHelperFragment2.g3(str);
                            return null;
                        }

                        /* access modifiers changed from: protected */
                        public void onPostExecute(Object obj) {
                            SearchHelperFragment.this.X2();
                        }

                        /* access modifiers changed from: protected */
                        public void onPreExecute() {
                        }
                    }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                    return true;
                }
                SearchHelperFragment searchHelperFragment2 = SearchHelperFragment.this;
                searchHelperFragment2.w4.setAdapter(searchHelperFragment2.l4);
                return false;
            }

            public boolean b(String str) {
                return false;
            }
        });
    }

    public void R2() {
        if (this.h4.containsKey("Demo")) {
            K2();
            return;
        }
        SearchView searchView = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        this.s4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        this.s4.setIconifiedByDefault(false);
        this.s4.setQueryHint("Search All");
        Y2();
        this.s4.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            public boolean a(int i2) {
                Cursor c2 = SearchHelperFragment.this.s4.getSuggestionsAdapter().c();
                if (!c2.moveToPosition(i2)) {
                    return false;
                }
                String string = c2.getString(c2.getColumnIndex("word"));
                if (SearchHelperFragment.this.s4.getTag(1) != null && ((String) SearchHelperFragment.this.s4.getTag(1)).length() > 0) {
                    string = SearchHelperFragment.this.s4.getTag() + StringUtils.SPACE + string;
                }
                SearchHelperFragment.this.s4.k0(string, true);
                return false;
            }

            public boolean b(int i2) {
                Cursor c2 = SearchHelperFragment.this.s4.getSuggestionsAdapter().c();
                if (!c2.moveToPosition(i2)) {
                    return false;
                }
                String string = c2.getString(c2.getColumnIndex("word"));
                if (SearchHelperFragment.this.s4.getTag() != null && ((String) SearchHelperFragment.this.s4.getTag()).length() > 0) {
                    string = SearchHelperFragment.this.s4.getTag() + StringUtils.SPACE + string;
                }
                SearchHelperFragment.this.s4.k0(string, true);
                return false;
            }
        });
        ((ImageView) this.s4.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SearchHelperFragment.this.s4.k0("", false);
                SearchHelperFragment.this.s4.clearFocus();
                SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                searchHelperFragment.w4.setAdapter(searchHelperFragment.l4);
                SearchHelperFragment.this.V2();
                SearchHelperFragment.this.Z2();
            }
        });
        ((SearchView.SearchAutoComplete) this.s4.findViewById(R.id.search_src_text)).setDropDownAnchor(R.id.f1069search_view);
        this.s4.setSuggestionsAdapter(new CursorAdapter(r(), (Cursor) null, 0) {
            public void e(View view, Context context, Cursor cursor) {
                ((TextView) view.getTag()).setText(cursor.getString(cursor.getColumnIndex("word")));
            }

            public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.f1374list_view_item_spell, viewGroup, false);
                inflate.setTag(inflate.findViewById(R.id.text));
                return inflate;
            }
        });
        this.s4.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(final String str) {
                SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                if (!searchHelperFragment.i4) {
                    return true;
                }
                searchHelperFragment.f4 = str;
                if (str.length() <= 1) {
                    return false;
                }
                new AsyncTask() {
                    /* access modifiers changed from: protected */
                    public Object doInBackground(Object[] objArr) {
                        return SearchHelperFragment.this.g3(str);
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        SearchHelperFragment.this.s4.getSuggestionsAdapter().m(SearchHelperFragment.this.k4.h((ArrayList) obj));
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                return true;
            }

            public boolean b(final String str) {
                new AsyncTask() {
                    /* access modifiers changed from: protected */
                    public Object doInBackground(Object[] objArr) {
                        SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                        searchHelperFragment.o4 = searchHelperFragment.a3(str);
                        return null;
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        SearchHelperFragment.this.X2();
                    }

                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                        try {
                            SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                            CompressHelper compressHelper = searchHelperFragment.k4;
                            String str = searchHelperFragment.f4;
                            compressHelper.I(str, SearchHelperFragment.this.h4.getString("Name") + " --- " + SearchHelperFragment.this.h4.getString("Title"));
                        } catch (Exception e2) {
                            FirebaseCrashlytics.d().g(e2);
                        }
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                return false;
            }
        });
    }

    public void S2() {
        Toolbar toolbar = (Toolbar) this.q4.findViewById(R.id.f1139toolbar);
        this.r4 = toolbar;
        if (toolbar != null) {
            this.v4 = (ButtonSmall) this.q4.findViewById(R.id.f829back_button);
            this.r4.setNavigationOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SearchHelperFragment.this.k4.W1(true);
                }
            });
            if (this.v4 != null) {
                this.v4.setDrawableIcon(r().getResources().getDrawable(R.drawable.f540back_icon_white));
                this.v4.setRippleColor(r().getResources().getColor(R.color.f466toolbar_item_ripple_color));
                this.v4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SearchHelperFragment.this.k4.W1(true);
                    }
                });
                this.v4.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        SearchHelperFragment.this.k4.Z1(true);
                        return true;
                    }
                });
            }
            ImageButton imageButton = (ImageButton) this.q4.findViewById(R.id.f800action_home);
            this.x4 = imageButton;
            if (imageButton != null) {
                imageButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SearchHelperFragment.this.k4.Z1(true);
                    }
                });
            }
            this.t4 = (ImageView) this.q4.findViewById(R.id.f1140toolbar_image_view);
            TextView textView = (TextView) this.q4.findViewById(R.id.f1142toolbar_text_view);
            this.u4 = textView;
            if (textView != null) {
                this.u4.setTypeface(Typeface.createFromAsset(r().getAssets(), "fonts/HelveticaNeue-Light.otf"));
                this.u4.setText(h3());
            }
            if (this.t4 != null) {
                c3();
            }
            d3();
            DrawerLayout drawerLayout = (DrawerLayout) this.q4.findViewById(R.id.f922drawer_layout);
            this.y4 = drawerLayout;
            if (drawerLayout != null) {
                drawerLayout.a(new DrawerLayout.DrawerListener() {
                    public void a(View view) {
                        SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                        searchHelperFragment.z4.setAdapter(new HistoryAdapter(searchHelperFragment.r(), SearchHelperFragment.this.y4));
                    }

                    public void b(View view) {
                    }

                    public void c(int i2) {
                    }

                    public void d(View view, float f2) {
                    }
                });
                RecyclerView recyclerView = (RecyclerView) this.q4.findViewById(R.id.f923drawer_view);
                this.z4 = recyclerView;
                if (recyclerView != null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(r(), 1, false));
                    this.z4.p(new CustomItemDecoration(r()));
                }
            }
            this.q4.postDelayed(new Runnable() {
                public void run() {
                    SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                    if (searchHelperFragment.t4 != null) {
                        searchHelperFragment.c3();
                    }
                }
            }, 1000);
        }
    }

    public String[] T2(String str) {
        ArrayList arrayList = new ArrayList();
        for (String split : str.split("</b>")) {
            String[] split2 = split.split("<b>");
            if (split2.length == 2 && !arrayList.contains(split2[1].toLowerCase()) && !split2[1].equals("...")) {
                arrayList.add(split2[1].toLowerCase());
            }
        }
        if (str.contains("</b> <b>")) {
            for (String split3 : str.replace("</b> <b>", StringUtils.SPACE).split("</b>")) {
                String[] split4 = split3.split("<b>");
                if (split4.length == 2 && !arrayList.contains(split4[1].toLowerCase()) && !split4[1].equals("...") && !arrayList.contains(split4[1].toLowerCase())) {
                    arrayList.add(0, split4[1]);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Nullable
    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k4 = new CompressHelper(r());
        if (bundle != null && bundle.containsKey("Position")) {
            this.e4 = bundle.getInt("Position");
        }
        if (bundle != null && bundle.containsKey("Query")) {
            this.f4 = bundle.getString("Query");
        }
        this.g4 = (ListView) this.q4.findViewById(R.id.f996list_view);
        this.h4 = (y() == null || !y().containsKey("DB")) ? null : y().getBundle("DB");
        try {
            b3("");
        } catch (Exception unused) {
        }
        LinearLayout linearLayout = (LinearLayout) this.q4.findViewById(R.id.f1087status_layout);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SearchHelperFragment.this.V2();
                }
            });
        }
        return super.U0(layoutInflater, viewGroup, bundle);
    }

    public int U2() {
        int identifier = b0().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return b0().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void V2() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) r().getSystemService("input_method");
            if (r().getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(r().getCurrentFocus().getWindowToken(), 0);
            }
            SearchView searchView = this.s4;
            if (searchView != null) {
                searchView.clearFocus();
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    public void W2(Bundle bundle) {
        this.k4 = new CompressHelper(r());
        if (bundle != null && bundle.containsKey("Position")) {
            this.e4 = bundle.getInt("Position");
        }
        if (bundle != null && bundle.containsKey("Query")) {
            this.f4 = bundle.getString("Query");
        }
        this.h4 = (y() == null || !y().containsKey("DB")) ? null : y().getBundle("DB");
    }

    public void X0() {
        super.X0();
    }

    public void X2() {
        this.m4.f0(this.o4);
        this.w4.setAdapter(this.m4);
    }

    public void Y2() {
        this.s4.postDelayed(new Runnable() {
            public void run() {
                SearchHelperFragment searchHelperFragment = SearchHelperFragment.this;
                searchHelperFragment.i4 = true;
                searchHelperFragment.s4.k0(searchHelperFragment.f4, false);
                SearchHelperFragment.this.V2();
            }
        }, 10);
        this.i4 = false;
    }

    public void Z2() {
    }

    public ArrayList<Bundle> a3(String str) {
        return null;
    }

    public void b3(String str) {
        try {
            ((AppCompatActivity) r()).F0().A0(str);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    public void c3() {
        try {
            Glide.F(this).t(CompressHelper.C(this.h4)).a(new RequestOptions().u()).B2(this.t4);
        } catch (Exception unused) {
        }
    }

    public void d3() {
        if (V1().getSharedPreferences("default_preferences", 0).getBoolean("HideStatusBar", false)) {
            float dimension = b0().getDimension(R.dimen.f522toolbar_padding);
            Toolbar toolbar = this.r4;
            if (toolbar != null) {
                toolbar.setPadding(0, (int) dimension, 0, 0);
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.q4.findViewById(R.id.f882collapsing_toolbar);
            }
        }
    }

    public void e3() {
        ((ListView) this.q4.findViewById(R.id.f996list_view)).setVisibility(0);
        ((TextView) this.q4.findViewById(R.id.f1086status_label)).setVisibility(8);
        ((LinearLayout) this.q4.findViewById(R.id.f1087status_layout)).setVisibility(8);
    }

    public void f3(String str) {
        TextView textView = (TextView) this.q4.findViewById(R.id.f1086status_label);
        ((ListView) this.q4.findViewById(R.id.f996list_view)).setVisibility(8);
        textView.setVisibility(0);
        ((LinearLayout) this.q4.findViewById(R.id.f1087status_layout)).setVisibility(0);
        textView.setText(str);
    }

    public ArrayList<Bundle> g3(String str) {
        return null;
    }

    public String h3() {
        return this.k4.b1(this.h4.getString("Title"));
    }

    public void m1(Bundle bundle) {
        super.m1(bundle);
    }
}
