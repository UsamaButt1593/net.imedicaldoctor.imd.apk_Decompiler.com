package net.imedicaldoctor.imd.Fragments.LexiInteract;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.fragment.app.DialogFragment;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.LexiInteract.LXIvInteract;
import net.imedicaldoctor.imd.R;
import org.apache.commons.lang3.StringUtils;

public class LXIvInteractDrugList extends DialogFragment {
    /* access modifiers changed from: private */
    public Bundle F4;
    private String G4;

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1232fragment_general_search_section_viewer, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.f996list_view);
        final SearchView searchView = (SearchView) inflate.findViewById(R.id.f1069search_view);
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        searchView.setQueryHint("Search IV Drugs");
        searchView.setIconifiedByDefault(false);
        ((TextView) searchView.findViewById(R.id.search_src_text)).setTextColor(b0().getColor(R.color.f140black));
        this.F4 = y().getBundle("db");
        final String string = y().getString("Drugs");
        final CompressHelper compressHelper = new CompressHelper(r());
        listView.setAdapter(new CursorAdapter(r(), (Cursor) null, 0) {
            public void e(View view, Context context, Cursor cursor) {
                ((TextView) view.getTag()).setText(cursor.getString(cursor.getColumnIndex("name")));
            }

            public int getItemViewType(int i2) {
                return 0;
            }

            public int getViewTypeCount() {
                return 1;
            }

            public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(LXIvInteractDrugList.this.r()).inflate(R.layout.f1365list_view_item_simple_text, viewGroup, false);
                inflate.setTag(inflate.findViewById(R.id.text));
                return inflate;
            }
        });
        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            public boolean a(int i2) {
                Cursor c2 = searchView.getSuggestionsAdapter().c();
                if (c2.moveToPosition(i2)) {
                    Bundle m2 = new CompressHelper(LXIvInteractDrugList.this.r()).m2(c2);
                    if (m2.containsKey("word")) {
                        searchView.k0(m2.getString("word"), false);
                        return false;
                    }
                    ((LXIvInteract.LXIvInteractFragment) LXIvInteractDrugList.this.l0()).p3(m2);
                    LXIvInteractDrugList.this.M2();
                }
                return false;
            }

            public boolean b(int i2) {
                return a(i2);
            }
        });
        searchView.setSuggestionsAdapter(new CursorAdapter(r(), (Cursor) null, 0) {
            public void e(View view, Context context, Cursor cursor) {
                TextView textView = (TextView) view.getTag();
                String str = "word";
                if (cursor.getColumnIndex(str) <= -1) {
                    str = "name";
                }
                textView.setText(cursor.getString(cursor.getColumnIndex(str)));
            }

            public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.f1374list_view_item_spell, viewGroup, false);
                inflate.setTag(inflate.findViewById(R.id.text));
                return inflate;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(final String str) {
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
                        searchView.setTag(str2.trim());
                        AnonymousClass4 r6 = AnonymousClass4.this;
                        ArrayList<Bundle> W = compressHelper.W(LXIvInteractDrugList.this.F4, "Select rowid as _id,rowid,* from search where name match '" + str + "*' AND (NOT generic_id in (" + string + "))", "fsearch.db");
                        if (W != null) {
                            return W;
                        }
                        AnonymousClass4 r62 = AnonymousClass4.this;
                        return compressHelper.V(LXIvInteractDrugList.this.F4, "Select rowid as _id,rowid,word from spell where word match '" + str + "*'");
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        searchView.getSuggestionsAdapter().m(compressHelper.h((ArrayList) obj));
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                return true;
            }

            public boolean b(String str) {
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                Cursor c2 = ((CursorAdapter) adapterView.getAdapter()).c();
                if (c2.moveToPosition(i2)) {
                    ((LXIvInteract.LXIvInteractFragment) LXIvInteractDrugList.this.l0()).p3(new CompressHelper(LXIvInteractDrugList.this.r()).m2(c2));
                    LXIvInteractDrugList.this.M2();
                }
            }
        });
        builder.setView(inflate);
        return builder.create();
    }
}
