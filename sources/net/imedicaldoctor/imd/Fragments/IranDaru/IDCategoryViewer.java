package net.imedicaldoctor.imd.Fragments.IranDaru;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.cursoradapter.widget.CursorAdapter;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDActivity;

public class IDCategoryViewer extends iMDActivity {

    public static class IDCategoryViewerFragment extends SearchHelperFragment {
        public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            ArrayList<Bundle> arrayList;
            Bundle bundle2;
            StringBuilder sb;
            String str;
            View inflate = layoutInflater.inflate(R.layout.f1231fragment_general_list, viewGroup, false);
            this.q4 = inflate;
            super.U0(layoutInflater, viewGroup, bundle);
            final CompressHelper compressHelper = new CompressHelper(r());
            String string = y().getString("ID");
            this.h4 = y().getBundle("DB");
            String string2 = y().getString("Category");
            y().getString("Name");
            if (string2.equals("medical")) {
                bundle2 = this.h4;
                sb = new StringBuilder();
                sb.append("Select  tDrugGenerics.fDrugGenericId as _id,tDrugGenerics.fDrugGenericId, fDrugGenericName from tMedicalGroupGenerics,tDrugGenerics where tMedicalGroupGenerics.fMedicalGroupId=");
                sb.append(string);
                str = " AND tDrugGenerics.fDrugGenericId=tMedicalGroupGenerics.fDrugGenericId";
            } else if (string2.equals("pharm")) {
                bundle2 = this.h4;
                sb = new StringBuilder();
                sb.append("Select tDrugGenerics.fDrugGenericId as _id,tDrugGenerics.fDrugGenericId, fDrugGenericName from tPharmGroupGenerics,tDrugGenerics where tPharmGroupGenerics.fPharmGroupId=");
                sb.append(string);
                str = " AND tDrugGenerics.fDrugGenericId=tPharmGroupGenerics.fDrugGenericId";
            } else {
                arrayList = null;
                this.g4.setAdapter(new CursorAdapter(r(), compressHelper.h(arrayList), 0) {
                    public void e(View view, Context context, Cursor cursor) {
                        ((TextView) view.getTag()).setText(cursor.getString(cursor.getColumnIndex("fDrugGenericName")));
                    }

                    public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                        View inflate = LayoutInflater.from(context).inflate(R.layout.f1365list_view_item_simple_text, viewGroup, false);
                        inflate.setTag(inflate.findViewById(R.id.text));
                        return inflate;
                    }
                });
                this.g4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        IDCategoryViewerFragment.this.e4 = i2;
                        Cursor c2 = ((CursorAdapter) adapterView.getAdapter()).c();
                        if (c2.moveToPosition(i2)) {
                            compressHelper.A1(IDCategoryViewerFragment.this.h4, compressHelper.m2(c2).getString("fDrugGenericID"), (String[]) null, (String) null);
                        }
                    }
                });
                e3();
                r().setTitle("Drugs");
                return inflate;
            }
            sb.append(str);
            arrayList = compressHelper.V(bundle2, sb.toString());
            this.g4.setAdapter(new CursorAdapter(r(), compressHelper.h(arrayList), 0) {
                public void e(View view, Context context, Cursor cursor) {
                    ((TextView) view.getTag()).setText(cursor.getString(cursor.getColumnIndex("fDrugGenericName")));
                }

                public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                    View inflate = LayoutInflater.from(context).inflate(R.layout.f1365list_view_item_simple_text, viewGroup, false);
                    inflate.setTag(inflate.findViewById(R.id.text));
                    return inflate;
                }
            });
            this.g4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    IDCategoryViewerFragment.this.e4 = i2;
                    Cursor c2 = ((CursorAdapter) adapterView.getAdapter()).c();
                    if (c2.moveToPosition(i2)) {
                        compressHelper.A1(IDCategoryViewerFragment.this.h4, compressHelper.m2(c2).getString("fDrugGenericID"), (String[]) null, (String) null);
                    }
                }
            });
            e3();
            r().setTitle("Drugs");
            return inflate;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new IDCategoryViewerFragment());
    }
}
