package net.imedicaldoctor.imd.Fragments.LexiInteract;

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
import net.imedicaldoctor.imd.Fragments.LexiInteract.LXIvInteract;
import net.imedicaldoctor.imd.R;

public class LXIvInteractList extends DialogFragment {
    private Bundle F4;
    /* access modifiers changed from: private */
    public ArrayList<Bundle> G4;
    /* access modifiers changed from: private */
    public String H4;
    /* access modifiers changed from: private */
    public String I4;

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1233fragment_general_section_viewer, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.f996list_view);
        this.F4 = y().getBundle("db");
        this.G4 = y().getParcelableArrayList("items");
        this.H4 = y().getString("titleProperty");
        this.I4 = y().getString("type");
        new CompressHelper(r());
        listView.setAdapter(new ArrayAdapter<Bundle>(r(), R.layout.f1365list_view_item_simple_text, R.id.text, this.G4) {
            public View getView(int i2, View view, ViewGroup viewGroup) {
                if (view == null) {
                    view = LayoutInflater.from(LXIvInteractList.this.r()).inflate(R.layout.f1365list_view_item_simple_text, viewGroup, false);
                    view.setTag(view.findViewById(R.id.text));
                }
                ((TextView) view.getTag()).setText(((Bundle) LXIvInteractList.this.G4.get(i2)).getString(LXIvInteractList.this.H4));
                return view;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                ((LXIvInteract.LXIvInteractFragment) LXIvInteractList.this.l0()).q3((Bundle) LXIvInteractList.this.G4.get(i2), LXIvInteractList.this.I4);
                LXIvInteractList.this.M2();
            }
        });
        builder.setView(inflate);
        return builder.create();
    }
}
