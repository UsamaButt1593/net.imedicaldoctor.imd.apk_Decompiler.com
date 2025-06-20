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
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ContentSearchAdapter;
import net.imedicaldoctor.imd.Views.ButtonSmall;
import org.apache.commons.lang3.StringUtils;

public class SearchDialogHelperFragment extends DialogFragment {
    public int F4;
    public String G4;
    public ListView H4;
    public Bundle I4;
    public boolean J4;
    public CompressHelper K4;
    public RecyclerView.Adapter L4;
    public ContentSearchAdapter M4;
    public ArrayList<Bundle> N4;
    public ArrayList<Bundle> O4;
    public ArrayList<Bundle> P4;
    public ImageButton Q4;
    public View R4;
    public Toolbar S4;
    public SearchView T4;
    public ImageView U4;
    public TextView V4;
    public ButtonSmall W4;
    public RecyclerView X4;

    public class ContentSearchViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f29870a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f29871b;

        public ContentSearchViewHolder(View view) {
            this.f29870a = (TextView) view.findViewById(R.id.f1136title_text);
            this.f29871b = (TextView) view.findViewById(R.id.f1098subtitle_text);
        }
    }

    @Nullable
    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.K4 = new CompressHelper(r());
        if (bundle != null && bundle.containsKey("Position")) {
            this.F4 = bundle.getInt("Position");
        }
        if (bundle != null && bundle.containsKey("Query")) {
            this.G4 = bundle.getString("Query");
        }
        this.H4 = (ListView) this.R4.findViewById(R.id.f996list_view);
        this.I4 = (y() == null || !y().containsKey("DB")) ? null : y().getBundle("DB");
        try {
            t3("");
        } catch (Exception unused) {
        }
        LinearLayout linearLayout = (LinearLayout) this.R4.findViewById(R.id.f1087status_layout);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SearchDialogHelperFragment.this.n3();
                }
            });
        }
        return super.U0(layoutInflater, viewGroup, bundle);
    }

    public void g3() {
        this.X4.setItemAnimator(new DefaultItemAnimator());
        this.X4.setItemDecoration(new CustomItemDecoration(r()));
        this.X4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
    }

    public void h3() {
        SearchView searchView = (SearchView) this.R4.findViewById(R.id.f1069search_view);
        this.T4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        this.T4.setIconifiedByDefault(false);
        this.T4.setQueryHint("Search All");
        q3();
        this.T4.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            public boolean a(int i2) {
                Cursor c2 = SearchDialogHelperFragment.this.T4.getSuggestionsAdapter().c();
                if (!c2.moveToPosition(i2)) {
                    return false;
                }
                String string = c2.getString(c2.getColumnIndex("word"));
                if (SearchDialogHelperFragment.this.T4.getTag(1) != null && ((String) SearchDialogHelperFragment.this.T4.getTag(1)).length() > 0) {
                    string = SearchDialogHelperFragment.this.T4.getTag() + StringUtils.SPACE + string;
                }
                SearchDialogHelperFragment.this.T4.k0(string, true);
                return false;
            }

            public boolean b(int i2) {
                Cursor c2 = SearchDialogHelperFragment.this.T4.getSuggestionsAdapter().c();
                if (!c2.moveToPosition(i2)) {
                    return false;
                }
                String string = c2.getString(c2.getColumnIndex("word"));
                if (SearchDialogHelperFragment.this.T4.getTag() != null && ((String) SearchDialogHelperFragment.this.T4.getTag()).length() > 0) {
                    string = SearchDialogHelperFragment.this.T4.getTag() + StringUtils.SPACE + string;
                }
                SearchDialogHelperFragment.this.T4.k0(string, true);
                return false;
            }
        });
        ((ImageView) this.T4.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SearchDialogHelperFragment.this.T4.k0("", false);
                SearchDialogHelperFragment.this.T4.clearFocus();
                SearchDialogHelperFragment searchDialogHelperFragment = SearchDialogHelperFragment.this;
                searchDialogHelperFragment.X4.setAdapter(searchDialogHelperFragment.L4);
                SearchDialogHelperFragment.this.n3();
                SearchDialogHelperFragment.this.r3();
            }
        });
        this.T4.setSuggestionsAdapter(new CursorAdapter(r(), (Cursor) null, 0) {
            public void e(View view, Context context, Cursor cursor) {
                ((TextView) view.getTag()).setText(cursor.getString(cursor.getColumnIndex("word")));
            }

            public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.f1374list_view_item_spell, viewGroup, false);
                inflate.setTag(inflate.findViewById(R.id.text));
                return inflate;
            }
        });
        this.T4.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(final String str) {
                SearchDialogHelperFragment searchDialogHelperFragment = SearchDialogHelperFragment.this;
                if (!searchDialogHelperFragment.J4) {
                    return true;
                }
                searchDialogHelperFragment.G4 = str;
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
                        str2.trim();
                        return SearchDialogHelperFragment.this.y3(str);
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        SearchDialogHelperFragment.this.T4.getSuggestionsAdapter().m(SearchDialogHelperFragment.this.K4.h((ArrayList) obj));
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                return true;
            }

            public boolean b(final String str) {
                new AsyncTask() {
                    /* access modifiers changed from: protected */
                    public Object doInBackground(Object[] objArr) {
                        SearchDialogHelperFragment searchDialogHelperFragment = SearchDialogHelperFragment.this;
                        searchDialogHelperFragment.O4 = searchDialogHelperFragment.s3(str);
                        return null;
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        SearchDialogHelperFragment.this.p3();
                    }

                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                return false;
            }
        });
    }

    public void i3() {
        SearchView searchView = (SearchView) this.R4.findViewById(R.id.f1069search_view);
        this.T4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        this.T4.setIconifiedByDefault(false);
        this.T4.setQueryHint("Search");
        q3();
        ((ImageView) this.T4.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SearchDialogHelperFragment.this.T4.k0("", false);
                SearchDialogHelperFragment.this.T4.clearFocus();
                SearchDialogHelperFragment searchDialogHelperFragment = SearchDialogHelperFragment.this;
                searchDialogHelperFragment.X4.setAdapter(searchDialogHelperFragment.L4);
                SearchDialogHelperFragment.this.n3();
                SearchDialogHelperFragment.this.r3();
            }
        });
        this.T4.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(final String str) {
                SearchDialogHelperFragment searchDialogHelperFragment = SearchDialogHelperFragment.this;
                if (!searchDialogHelperFragment.J4) {
                    return true;
                }
                searchDialogHelperFragment.G4 = str;
                if (str.length() <= 1) {
                    return false;
                }
                new AsyncTask() {
                    /* access modifiers changed from: protected */
                    public Object doInBackground(Object[] objArr) {
                        SearchDialogHelperFragment searchDialogHelperFragment = SearchDialogHelperFragment.this;
                        searchDialogHelperFragment.O4 = searchDialogHelperFragment.s3(str);
                        return null;
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        SearchDialogHelperFragment.this.p3();
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

    public void j3() {
        SearchView searchView = (SearchView) this.R4.findViewById(R.id.f1069search_view);
        this.T4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        this.T4.setIconifiedByDefault(false);
        this.T4.setQueryHint("Search");
        q3();
        ((ImageView) this.T4.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SearchDialogHelperFragment.this.T4.k0("", false);
                SearchDialogHelperFragment.this.T4.clearFocus();
                SearchDialogHelperFragment searchDialogHelperFragment = SearchDialogHelperFragment.this;
                searchDialogHelperFragment.X4.setAdapter(searchDialogHelperFragment.L4);
                SearchDialogHelperFragment.this.n3();
                SearchDialogHelperFragment.this.r3();
            }
        });
        this.T4.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(final String str) {
                SearchDialogHelperFragment searchDialogHelperFragment = SearchDialogHelperFragment.this;
                if (!searchDialogHelperFragment.J4) {
                    return true;
                }
                searchDialogHelperFragment.G4 = str;
                if (str.length() <= 1) {
                    return false;
                }
                new AsyncTask() {
                    /* access modifiers changed from: protected */
                    public Object doInBackground(Object[] objArr) {
                        SearchDialogHelperFragment searchDialogHelperFragment = SearchDialogHelperFragment.this;
                        searchDialogHelperFragment.O4 = searchDialogHelperFragment.s3(str);
                        SearchDialogHelperFragment searchDialogHelperFragment2 = SearchDialogHelperFragment.this;
                        searchDialogHelperFragment2.P4 = searchDialogHelperFragment2.y3(str);
                        return null;
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        SearchDialogHelperFragment.this.p3();
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

    public void k3() {
        Toolbar toolbar = (Toolbar) this.R4.findViewById(R.id.f1139toolbar);
        this.S4 = toolbar;
        if (toolbar != null) {
            this.W4 = (ButtonSmall) this.R4.findViewById(R.id.f829back_button);
            this.S4.setNavigationOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SearchDialogHelperFragment.this.K4.W1(true);
                }
            });
            ButtonSmall buttonSmall = this.W4;
            if (buttonSmall != null) {
                buttonSmall.setDrawableIcon(r().getResources().getDrawable(R.drawable.f537back_icon));
                this.W4.setRippleColor(r().getResources().getColor(R.color.f466toolbar_item_ripple_color));
                this.W4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SearchDialogHelperFragment.this.K4.W1(true);
                    }
                });
                this.W4.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        SearchDialogHelperFragment.this.K4.Z1(true);
                        return true;
                    }
                });
            }
            ImageButton imageButton = (ImageButton) this.R4.findViewById(R.id.f800action_home);
            this.Q4 = imageButton;
            if (imageButton != null) {
                imageButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SearchDialogHelperFragment.this.K4.Z1(true);
                    }
                });
            }
            this.U4 = (ImageView) this.R4.findViewById(R.id.f1140toolbar_image_view);
            TextView textView = (TextView) this.R4.findViewById(R.id.f1142toolbar_text_view);
            this.V4 = textView;
            if (textView != null) {
                this.V4.setTypeface(Typeface.createFromAsset(r().getAssets(), "fonts/HelveticaNeue-Light.otf"));
                this.V4.setText(z3());
            }
            if (this.U4 != null) {
                u3();
            }
            v3();
        }
    }

    public String[] l3(String str) {
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

    public void m1(Bundle bundle) {
        super.m1(bundle);
    }

    public int m3() {
        int identifier = b0().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return b0().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void n3() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) r().getSystemService("input_method");
            if (r().getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(r().getCurrentFocus().getWindowToken(), 0);
            }
            SearchView searchView = this.T4;
            if (searchView != null) {
                searchView.clearFocus();
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    public void o3(Bundle bundle) {
        this.K4 = new CompressHelper(r());
        if (bundle != null && bundle.containsKey("Position")) {
            this.F4 = bundle.getInt("Position");
        }
        if (bundle != null && bundle.containsKey("Query")) {
            this.G4 = bundle.getString("Query");
        }
        this.I4 = (y() == null || !y().containsKey("DB")) ? null : y().getBundle("DB");
    }

    public void p3() {
        this.M4.f0(this.O4);
        this.X4.setAdapter(this.M4);
    }

    public void q3() {
        this.T4.postDelayed(new Runnable() {
            public void run() {
                SearchDialogHelperFragment searchDialogHelperFragment = SearchDialogHelperFragment.this;
                searchDialogHelperFragment.J4 = true;
                searchDialogHelperFragment.T4.k0(searchDialogHelperFragment.G4, false);
                SearchDialogHelperFragment.this.n3();
            }
        }, 10);
        this.J4 = false;
    }

    public void r3() {
    }

    public ArrayList<Bundle> s3(String str) {
        return null;
    }

    public void t3(String str) {
        try {
            ((AppCompatActivity) r()).F0().A0(str);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    public void u3() {
        Glide.F(this).t(CompressHelper.C(this.I4)).a(new RequestOptions().u()).B2(this.U4);
    }

    public void v3() {
        if (V1().getSharedPreferences("default_preferences", 0).getBoolean("HideStatusBar", false)) {
            float dimension = b0().getDimension(R.dimen.f522toolbar_padding);
            Toolbar toolbar = this.S4;
            if (toolbar != null) {
                toolbar.setPadding(0, (int) dimension, 0, 0);
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.R4.findViewById(R.id.f882collapsing_toolbar);
            }
        }
    }

    public void w3() {
        ((ListView) this.R4.findViewById(R.id.f996list_view)).setVisibility(0);
        ((TextView) this.R4.findViewById(R.id.f1086status_label)).setVisibility(8);
        ((LinearLayout) this.R4.findViewById(R.id.f1087status_layout)).setVisibility(8);
    }

    public void x3(String str) {
        TextView textView = (TextView) this.R4.findViewById(R.id.f1086status_label);
        ((ListView) this.R4.findViewById(R.id.f996list_view)).setVisibility(8);
        textView.setVisibility(0);
        ((LinearLayout) this.R4.findViewById(R.id.f1087status_layout)).setVisibility(0);
        textView.setText(str);
    }

    public ArrayList<Bundle> y3(String str) {
        return null;
    }

    public String z3() {
        return this.I4.getString("Title");
    }
}
