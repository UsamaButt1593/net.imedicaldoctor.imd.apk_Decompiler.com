package net.imedicaldoctor.imd.Fragments.Elsevier;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.fragment.app.DialogFragment;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Elsevier.ELSViewerActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;

public class ELSSectionsViewer extends DialogFragment {
    /* access modifiers changed from: private */
    public Bundle F4;
    /* access modifiers changed from: private */
    public String G4;
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
        listView.setAdapter(new CursorAdapter(r(), compressHelper.h(compressHelper.V(bundle2, "Select rowid as _id, * from sections where docId = '" + this.G4 + "' And parent = " + this.H4)), 0) {
            public void e(View view, Context context, Cursor cursor) {
                ((TextView) view.getTag()).setText(cursor.getString(cursor.getColumnIndex("sectionName")));
                if (cursor.getString(cursor.getColumnIndex("leaf")).equals("0")) {
                    final String string = cursor.getString(cursor.getColumnIndex("sectionId"));
                    ((ImageView) view.findViewById(R.id.f1016next_icon)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            ELSSectionsViewer eLSSectionsViewer = new ELSSectionsViewer();
                            Bundle bundle = new Bundle();
                            bundle.putBundle("db", ELSSectionsViewer.this.F4);
                            bundle.putString("docId", ELSSectionsViewer.this.G4);
                            bundle.putString("parentId", string);
                            eLSSectionsViewer.i2(bundle);
                            eLSSectionsViewer.Z2(true);
                            eLSSectionsViewer.A2(ELSSectionsViewer.this.l0(), 0);
                            eLSSectionsViewer.e3(ELSSectionsViewer.this.V(), "ELSSectionsViewer");
                            ELSSectionsViewer.this.M2();
                        }
                    });
                }
            }

            public int getItemViewType(int i2) {
                Cursor cursor = (Cursor) getItem(i2);
                return cursor.getString(cursor.getColumnIndex("leaf")).equals(IcyHeaders.a3) ? 0 : 1;
            }

            public int getViewTypeCount() {
                return 2;
            }

            public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(ELSSectionsViewer.this.r()).inflate(cursor.getString(cursor.getColumnIndex("leaf")).equals(IcyHeaders.a3) ? R.layout.f1365list_view_item_simple_text : R.layout.f1366list_view_item_simple_text_arrow, viewGroup, false);
                inflate.setTag(inflate.findViewById(R.id.text));
                return inflate;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                Cursor c2 = ((CursorAdapter) adapterView.getAdapter()).c();
                if (c2.moveToPosition(i2)) {
                    String string = c2.getString(c2.getColumnIndex("sectionhRef"));
                    iMDLogger.j("ElsSectionsViewer", "Goto : " + string);
                    ((ELSViewerActivity.ELSViewerFragment) ELSSectionsViewer.this.l0()).C3(string);
                    ELSSectionsViewer.this.M2();
                }
            }
        });
        builder.setView(inflate);
        return builder.create();
    }
}
