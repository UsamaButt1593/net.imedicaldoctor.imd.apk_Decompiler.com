package net.imedicaldoctor.imd.Fragments.AccessMedicine;

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
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.AccessMedicine.AMViewerActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;

public class AMSectionsViewer extends DialogFragment {
    private Bundle F4;
    private String G4;
    private String H4;

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1233fragment_general_section_viewer, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.f996list_view);
        this.F4 = y().getBundle("db");
        this.G4 = y().getString("docId");
        this.H4 = y().getString("parentId");
        CompressHelper compressHelper = new CompressHelper(r());
        Bundle bundle2 = this.F4;
        listView.setAdapter(new CursorAdapter(r(), compressHelper.h(compressHelper.V(bundle2, "Select rowid as _id, * from sections where sectionId = " + this.G4)), 0) {
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
                View inflate = LayoutInflater.from(AMSectionsViewer.this.r()).inflate(R.layout.f1365list_view_item_simple_text, viewGroup, false);
                inflate.setTag(inflate.findViewById(R.id.text));
                return inflate;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                Cursor c2 = ((CursorAdapter) adapterView.getAdapter()).c();
                if (c2.moveToPosition(i2)) {
                    String string = c2.getString(c2.getColumnIndex("id"));
                    iMDLogger.j("AMSectionsViewer", "Goto : " + string);
                    ((AMViewerActivity.AMViewerFragment) AMSectionsViewer.this.l0()).C3(string);
                    AMSectionsViewer.this.M2();
                }
            }
        });
        builder.setView(inflate);
        return builder.create();
    }
}
