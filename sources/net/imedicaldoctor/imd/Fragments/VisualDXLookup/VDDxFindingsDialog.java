package net.imedicaldoctor.imd.Fragments.VisualDXLookup;

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
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.VisualDDX.VDDxBuilderActivity;
import net.imedicaldoctor.imd.R;

public class VDDxFindingsDialog extends DialogFragment {
    /* access modifiers changed from: private */
    public Bundle F4;
    private String G4;
    /* access modifiers changed from: private */
    public Bundle H4;
    /* access modifiers changed from: private */
    public ArrayList<String> I4;
    /* access modifiers changed from: private */
    public ArrayList<String> J4;
    /* access modifiers changed from: private */
    public String K4;
    private Bundle L4;

    public Dialog U2(Bundle bundle) {
        String str;
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1233fragment_general_section_viewer, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.f996list_view);
        this.F4 = y().getBundle("db");
        this.L4 = y().getBundle("parent");
        this.H4 = y().getBundle("allFindings");
        this.I4 = y().getStringArrayList("selectedFindings");
        this.J4 = y().getStringArrayList("disabledItems");
        this.K4 = y().getString("moduleId");
        this.G4 = !this.L4.containsKey("id") ? "0" : this.L4.getString("id");
        if (!this.L4.containsKey("leaf") || !this.L4.getString("leaf").equals(IcyHeaders.a3)) {
            str = "SELECT id as _id,id, shortName, longName, children, leaf, ',' || supportedModules || ',' as modules FROM Findings where parentId = " + this.G4 + " and modules like '%," + this.K4 + ",%' order by shortName asc";
        } else {
            str = ("Select -1 as _id, '" + this.L4.getString("id") + "' as id, '" + this.L4.getString("shortName") + "' as shortName, '" + this.L4.getString("longName") + "' as longName, '' as children, '1' as leaf, '' as modules UNION ") + "SELECT id as _id, id, shortName, longName, children, leaf, ',' || supportedModules || ',' as modules FROM Findings where parentId = " + this.G4 + " and modules like '%," + this.K4 + ",%' order by shortName asc";
        }
        final CompressHelper compressHelper = new CompressHelper(r());
        final CompressHelper compressHelper2 = compressHelper;
        final AnonymousClass1 r3 = new CursorAdapter(r(), compressHelper.h(compressHelper.V(this.F4, str)), 0) {
            public void e(View view, Context context, Cursor cursor) {
                TextView textView = (TextView) view.getTag();
                Bundle m2 = compressHelper2.m2(cursor);
                if (m2.getString("children").length() == 0) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.f872check_icon);
                    String string = m2.getString("id");
                    if (VDDxFindingsDialog.this.I4.contains(string)) {
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(4);
                    }
                    if (VDDxFindingsDialog.this.J4.contains(string)) {
                        textView.setTextColor(-7829368);
                        imageView.setVisibility(0);
                    }
                }
                textView.setText(cursor.getString(cursor.getColumnIndex("shortName")));
            }

            public int getItemViewType(int i2) {
                Cursor cursor = (Cursor) getItem(i2);
                return cursor.getString(cursor.getColumnIndex("children")).length() > 0 ? 0 : 1;
            }

            public int getViewTypeCount() {
                return 2;
            }

            public boolean isEnabled(int i2) {
                Bundle m2 = compressHelper2.m2((Cursor) getItem(i2));
                if (m2.getString("children").length() != 0) {
                    return true;
                }
                return !VDDxFindingsDialog.this.J4.contains(m2.getString("id"));
            }

            public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(context).inflate(cursor.getString(cursor.getColumnIndex("children")).length() > 0 ? R.layout.f1366list_view_item_simple_text_arrow : R.layout.f1369list_view_item_simple_text_check, viewGroup, false);
                inflate.setTag(inflate.findViewById(R.id.text));
                return inflate;
            }
        };
        listView.setAdapter(r3);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                Cursor c2 = ((CursorAdapter) adapterView.getAdapter()).c();
                if (c2.moveToPosition(i2)) {
                    Bundle m2 = compressHelper.m2(c2);
                    if (m2.getString("children").length() == 0) {
                        String string = m2.getString("id");
                        if (VDDxFindingsDialog.this.I4.contains(string)) {
                            VDDxFindingsDialog.this.I4.remove(string);
                        } else {
                            VDDxFindingsDialog.this.I4.add(string);
                        }
                        ((VDDxBuilderActivity.VDDXBuilderFragment) VDDxFindingsDialog.this.l0()).J4();
                        r3.notifyDataSetChanged();
                        return;
                    }
                    VDDxFindingsDialog vDDxFindingsDialog = new VDDxFindingsDialog();
                    Bundle bundle = new Bundle();
                    bundle.putBundle("db", VDDxFindingsDialog.this.F4);
                    bundle.putBundle("allFindings", VDDxFindingsDialog.this.H4);
                    bundle.putStringArrayList("selectedFindings", VDDxFindingsDialog.this.I4);
                    bundle.putBundle("parent", m2);
                    bundle.putString("moduleId", VDDxFindingsDialog.this.K4);
                    bundle.putStringArrayList("disabledItems", VDDxFindingsDialog.this.J4);
                    vDDxFindingsDialog.i2(bundle);
                    vDDxFindingsDialog.Z2(true);
                    vDDxFindingsDialog.A2(VDDxFindingsDialog.this.l0(), 0);
                    vDDxFindingsDialog.e3(VDDxFindingsDialog.this.M(), "VDDialogFragment");
                    VDDxFindingsDialog.this.M2();
                }
            }
        });
        builder.setView(inflate);
        return builder.create();
    }
}
