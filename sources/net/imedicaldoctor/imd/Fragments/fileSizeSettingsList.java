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

public class fileSizeSettingsList extends DialogFragment {
    /* access modifiers changed from: private */
    public ArrayList<Bundle> F4;
    /* access modifiers changed from: private */
    public String G4;
    /* access modifiers changed from: private */
    public String H4;
    /* access modifiers changed from: private */
    public String I4;

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme);
        View inflate = r().getLayoutInflater().inflate(R.layout.f1233fragment_general_section_viewer, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.f996list_view);
        this.F4 = y().getParcelableArrayList("items");
        this.G4 = y().getString("titleProperty");
        this.H4 = y().getString("type");
        this.I4 = y().getString("selected");
        new CompressHelper(r());
        listView.setAdapter(new ArrayAdapter<Bundle>(r(), R.layout.f1380list_view_item_text_subtitle_check, R.id.text, this.F4) {
            public View getView(int i2, View view, ViewGroup viewGroup) {
                if (view == null) {
                    view = LayoutInflater.from(fileSizeSettingsList.this.r()).inflate(R.layout.f1380list_view_item_text_subtitle_check, viewGroup, false);
                    view.setTag(view.findViewById(R.id.text));
                }
                String string = ((Bundle) fileSizeSettingsList.this.F4.get(i2)).getString(fileSizeSettingsList.this.G4);
                ((TextView) view.findViewById(R.id.f1094subtext)).setText(((Bundle) fileSizeSettingsList.this.F4.get(i2)).getString("Size"));
                ((TextView) view.getTag()).setText(string);
                if (((Bundle) fileSizeSettingsList.this.F4.get(i2)).containsKey("Path")) {
                    string = ((Bundle) fileSizeSettingsList.this.F4.get(i2)).getString("Path");
                }
                if (string.equals(fileSizeSettingsList.this.I4)) {
                    view.findViewById(R.id.f872check_icon).setVisibility(0);
                } else {
                    view.findViewById(R.id.f872check_icon).setVisibility(8);
                }
                return view;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                Bundle bundle = (Bundle) fileSizeSettingsList.this.F4.get(i2);
                if (fileSizeSettingsList.this.l0().getClass() == accountFragment.class) {
                    ((accountFragment) fileSizeSettingsList.this.l0()).s3(bundle, fileSizeSettingsList.this.H4);
                } else {
                    ((downloadFragment) fileSizeSettingsList.this.l0()).V3(bundle, fileSizeSettingsList.this.H4);
                }
                fileSizeSettingsList.this.M2();
            }
        });
        builder.setView(inflate);
        return builder.create();
    }
}
