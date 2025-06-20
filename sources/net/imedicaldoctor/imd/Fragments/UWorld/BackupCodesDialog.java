package net.imedicaldoctor.imd.Fragments.UWorld;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import net.imedicaldoctor.imd.R;

public class BackupCodesDialog {

    public interface BackupCodeSelectedListener {
        void a(String str);
    }

    public static void a(Context context, final ArrayList<Bundle> arrayList, final BackupCodeSelectedListener backupCodeSelectedListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.f1209dialog_backup_codes, (ViewGroup) null);
        builder.setView(inflate);
        ListView listView = (ListView) inflate.findViewById(R.id.f994listViewBackupCodes);
        listView.setAdapter(new BackupCodesAdapter(context, arrayList));
        final String[] strArr = {null};
        final AlertDialog create = builder.create();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                BackupCodeSelectedListener backupCodeSelectedListener;
                strArr[0] = ((Bundle) arrayList.get(i2)).getString(HTML.Tag.g0);
                String str = strArr[0];
                if (!(str == null || (backupCodeSelectedListener = backupCodeSelectedListener) == null)) {
                    backupCodeSelectedListener.a(str);
                }
                create.dismiss();
            }
        });
        create.show();
    }
}
