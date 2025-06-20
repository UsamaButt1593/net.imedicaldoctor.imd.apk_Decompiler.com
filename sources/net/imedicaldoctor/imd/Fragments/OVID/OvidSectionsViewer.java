package net.imedicaldoctor.imd.Fragments.OVID;

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
import com.itextpdf.tool.xml.html.HTML;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.OVID.OvidViewerActivity;
import net.imedicaldoctor.imd.R;

public class OvidSectionsViewer extends DialogFragment {
    /* access modifiers changed from: private */
    public Bundle F4;
    private String G4;

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1233fragment_general_section_viewer, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.f996list_view);
        this.F4 = y().getBundle("db");
        this.G4 = y().getString("parentId");
        final CompressHelper compressHelper = new CompressHelper(r());
        Bundle bundle2 = this.F4;
        Cursor h2 = compressHelper.h(compressHelper.V(bundle2, "Select id as _id,* from toc where parentId = " + this.G4));
        final CompressHelper compressHelper2 = compressHelper;
        listView.setAdapter(new CursorAdapter(r(), h2, 0) {
            public void e(View view, Context context, Cursor cursor) {
                TextView textView = (TextView) view.getTag();
                final Bundle m2 = compressHelper2.m2(cursor);
                if (!cursor.getString(cursor.getColumnIndex("leaf")).equals(IcyHeaders.a3) && (cursor.getString(cursor.getColumnIndex("xpath")).length() > 0 || cursor.getString(cursor.getColumnIndex(HTML.Tag.V)).length() > 0)) {
                    ((ImageView) view.findViewById(R.id.f986info_button)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            ((OvidViewerActivity.OvidViewerFragment) OvidSectionsViewer.this.l0()).M4(m2);
                            OvidSectionsViewer.this.M2();
                        }
                    });
                }
                textView.setText(cursor.getString(cursor.getColumnIndex("name")));
            }

            public int getItemViewType(int i2) {
                Cursor cursor = (Cursor) getItem(i2);
                if (cursor.getString(cursor.getColumnIndex("leaf")).equals(IcyHeaders.a3)) {
                    return 0;
                }
                return (cursor.getString(cursor.getColumnIndex("xpath")).length() > 0 || cursor.getString(cursor.getColumnIndex(HTML.Tag.V)).length() > 0) ? 1 : 2;
            }

            public int getViewTypeCount() {
                return 3;
            }

            public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(context).inflate(cursor.getString(cursor.getColumnIndex("leaf")).equals(IcyHeaders.a3) ? R.layout.f1365list_view_item_simple_text : (cursor.getString(cursor.getColumnIndex("xpath")).length() > 0 || cursor.getString(cursor.getColumnIndex(HTML.Tag.V)).length() > 0) ? R.layout.f1371list_view_item_simple_text_goto_arrow : R.layout.f1366list_view_item_simple_text_arrow, viewGroup, false);
                inflate.setTag(inflate.findViewById(R.id.text));
                return inflate;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                Cursor c2 = ((CursorAdapter) adapterView.getAdapter()).c();
                if (c2.moveToPosition(i2)) {
                    String string = c2.getString(c2.getColumnIndex("leaf"));
                    c2.getString(c2.getColumnIndex("bookId"));
                    if (string.equals(IcyHeaders.a3)) {
                        ((OvidViewerActivity.OvidViewerFragment) OvidSectionsViewer.this.l0()).M4(compressHelper.m2(c2));
                    } else {
                        OvidSectionsViewer ovidSectionsViewer = new OvidSectionsViewer();
                        Bundle bundle = new Bundle();
                        bundle.putBundle("db", OvidSectionsViewer.this.F4);
                        bundle.putString("parentId", c2.getString(c2.getColumnIndex("id")));
                        ovidSectionsViewer.i2(bundle);
                        ovidSectionsViewer.Z2(true);
                        ovidSectionsViewer.A2(OvidSectionsViewer.this.l0(), 0);
                        ovidSectionsViewer.e3(OvidSectionsViewer.this.M(), "OvidSectionsViewer");
                    }
                    OvidSectionsViewer.this.M2();
                }
            }
        });
        builder.setView(inflate);
        return builder.create();
    }
}
