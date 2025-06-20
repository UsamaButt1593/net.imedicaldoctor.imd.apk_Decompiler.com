package net.imedicaldoctor.imd.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;

public class settingsList extends DialogFragment {
    /* access modifiers changed from: private */
    public ArrayList<Bundle> F4;
    /* access modifiers changed from: private */
    public String G4;
    /* access modifiers changed from: private */
    public String H4;
    /* access modifiers changed from: private */
    public String I4;

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1233fragment_general_section_viewer, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.f996list_view);
        this.F4 = y().getParcelableArrayList("items");
        this.G4 = y().getString("titleProperty");
        this.H4 = y().getString("type");
        this.I4 = y().getString("selected");
        new CompressHelper(r());
        listView.setAdapter(new ArrayAdapter<Bundle>(r(), R.layout.f1369list_view_item_simple_text_check, R.id.text, this.F4) {
            public View getView(int i2, View view, ViewGroup viewGroup) {
                if (view == null) {
                    view = LayoutInflater.from(settingsList.this.r()).inflate(R.layout.f1369list_view_item_simple_text_check, viewGroup, false);
                    view.setTag(view.findViewById(R.id.text));
                }
                String string = ((Bundle) settingsList.this.F4.get(i2)).getString(settingsList.this.G4);
                ((TextView) view.getTag()).setText(string);
                if (string.equals(settingsList.this.I4)) {
                    view.findViewById(R.id.f872check_icon).setVisibility(0);
                } else {
                    view.findViewById(R.id.f872check_icon).setVisibility(8);
                }
                return view;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                ((accountFragment) settingsList.this.l0()).s3((Bundle) settingsList.this.F4.get(i2), settingsList.this.H4);
                settingsList.this.M2();
            }
        });
        builder.setView(inflate);
        return builder.create();
    }
}
