package net.imedicaldoctor.imd.Fragments.Uptodate;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.fragment.app.DialogFragment;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Uptodate.UTDGraphicActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;

public class UTDRelatedTopics2Fragment extends DialogFragment {
    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1276fragment_utdrelated_topics2, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.f996list_view);
        r().setFinishOnTouchOutside(true);
        try {
            String string = y().getString("RELATED");
            CompressHelper compressHelper = new CompressHelper(r());
            Bundle bundle2 = y().getBundle("db");
            listView.setAdapter(new CursorAdapter(r(), compressHelper.h(compressHelper.W(bundle2, "select topic_id as _id, title from topic where topic_id in (" + string + ")", "unidex.en.sqlite"))) {
                public void e(View view, Context context, Cursor cursor) {
                    ((TextView) view.findViewById(R.id.f1136title_text)).setText(cursor.getString(cursor.getColumnIndex("title")));
                }

                public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                    UTDRelatedTopics2Fragment.this.r().getLayoutInflater();
                    return LayoutInflater.from(UTDRelatedTopics2Fragment.this.r()).inflate(R.layout.f1338list_view_item_related_topics, viewGroup, false);
                }
            });
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    Cursor c2 = ((CursorAdapter) adapterView.getAdapter()).c();
                    iMDLogger.j("relatedTopicsFragment", "clicked : " + c2.getString(c2.getColumnIndex("title")));
                    ((UTDGraphicActivity.UTDGraphicFragment) UTDRelatedTopics2Fragment.this.l0()).e5(c2.getString(c2.getColumnIndex("_id")));
                    UTDRelatedTopics2Fragment.this.M2();
                }
            });
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            String cls = getClass().toString();
            iMDLogger.f(cls, "Error in parsing related Topics " + e2);
        }
        builder.setView(inflate);
        return builder.create();
    }
}
