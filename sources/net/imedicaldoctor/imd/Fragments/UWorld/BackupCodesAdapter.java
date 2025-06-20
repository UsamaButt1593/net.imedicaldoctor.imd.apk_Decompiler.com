package net.imedicaldoctor.imd.Fragments.UWorld;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import net.imedicaldoctor.imd.R;

public class BackupCodesAdapter extends ArrayAdapter<Bundle> {
    private final ArrayList<Bundle> X;
    private final Context s;

    public BackupCodesAdapter(Context context, ArrayList<Bundle> arrayList) {
        super(context, R.layout.f1296list_item_backup_code, arrayList);
        this.s = context;
        this.X = arrayList;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        View inflate = ((LayoutInflater) this.s.getSystemService("layout_inflater")).inflate(R.layout.f1296list_item_backup_code, viewGroup, false);
        Bundle bundle = this.X.get(i2);
        String string = bundle.getString(HTML.Tag.g0);
        String string2 = bundle.getString(DublinCoreProperties.f27398d);
        String string3 = bundle.getString("title");
        ((TextView) inflate.findViewById(R.id.f1119textViewCode)).setText(string);
        ((TextView) inflate.findViewById(R.id.f1120textViewDate)).setText(string2);
        ((TextView) inflate.findViewById(R.id.f1121textViewTitle)).setText(string3);
        return inflate;
    }
}
