package net.imedicaldoctor.imd.Fragments.Skyscape;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.Skyscape.SSViewerActivity;
import net.imedicaldoctor.imd.R;

public class SSSectionsViewer extends DialogFragment {
    /* access modifiers changed from: private */
    public ArrayList<Bundle> F4;
    /* access modifiers changed from: private */
    public String G4;
    /* access modifiers changed from: private */
    public String H4;

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1233fragment_general_section_viewer, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.f996list_view);
        this.F4 = y().getParcelableArrayList("items");
        this.G4 = y().getString("titleProperty");
        this.H4 = y().getString("sectionProperty");
        new CompressHelper(r());
        if (this.F4 == null) {
            Toast.makeText(r(), "No Section Available", 1).show();
            M2();
        } else {
            listView.setAdapter(new ArrayAdapter<Bundle>(r(), R.layout.f1365list_view_item_simple_text, R.id.text, this.F4) {
                public View getView(int i2, View view, ViewGroup viewGroup) {
                    if (view == null) {
                        view = LayoutInflater.from(SSSectionsViewer.this.r()).inflate(R.layout.f1365list_view_item_simple_text, viewGroup, false);
                        view.setTag(view.findViewById(R.id.text));
                    }
                    ((TextView) view.getTag()).setText(((Bundle) SSSectionsViewer.this.F4.get(i2)).getString(SSSectionsViewer.this.G4));
                    return view;
                }
            });
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    ((SSViewerActivity.SSViewerFragment) SSSectionsViewer.this.l0()).C3(((Bundle) SSSectionsViewer.this.F4.get(i2)).getString(SSSectionsViewer.this.H4));
                    SSSectionsViewer.this.M2();
                }
            });
        }
        builder.setView(inflate);
        return builder.create();
    }
}
