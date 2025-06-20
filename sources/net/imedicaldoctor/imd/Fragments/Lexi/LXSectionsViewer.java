package net.imedicaldoctor.imd.Fragments.Lexi;

import android.app.Dialog;
import android.os.Bundle;
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
import net.imedicaldoctor.imd.Fragments.Epocrate.EPODxViewerActivityFragment;
import net.imedicaldoctor.imd.Fragments.Epocrate.EPOIDViewerActivityFragment;
import net.imedicaldoctor.imd.Fragments.Epocrate.EPORxViewerActivityFragment;
import net.imedicaldoctor.imd.Fragments.Epocrate.EPOTableViewerActivityFragment;
import net.imedicaldoctor.imd.Fragments.Lexi.LXViewer;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;

public class LXSectionsViewer extends DialogFragment {
    /* access modifiers changed from: private */
    public ArrayList<Bundle> F4;

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1233fragment_general_section_viewer, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.f996list_view);
        this.F4 = y().getParcelableArrayList("fields");
        new CompressHelper(r());
        listView.setAdapter(new ArrayAdapter<Bundle>(r(), R.layout.f1365list_view_item_simple_text, R.id.text, this.F4) {
            public View getView(int i2, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i2, view, viewGroup);
                ((TextView) view2.findViewById(R.id.text)).setText(((Bundle) LXSectionsViewer.this.F4.get(i2)).getString("label"));
                return view2;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                ViewerHelperFragment viewerHelperFragment;
                StringBuilder sb;
                String string = ((Bundle) ((ArrayAdapter) adapterView.getAdapter()).getItem(i2)).getString("sequence");
                if (LXSectionsViewer.this.l0().getClass().equals(LXViewer.LXViewerFragment.class)) {
                    ((LXViewer.LXViewerFragment) LXSectionsViewer.this.l0()).C3("f" + string);
                } else if (LXSectionsViewer.this.l0().getClass().equals(EPODxViewerActivityFragment.class)) {
                    ((EPODxViewerActivityFragment) LXSectionsViewer.this.l0()).C3("f" + string);
                } else {
                    if (LXSectionsViewer.this.l0().getClass().equals(EPORxViewerActivityFragment.class)) {
                        viewerHelperFragment = (EPORxViewerActivityFragment) LXSectionsViewer.this.l0();
                        sb = new StringBuilder();
                    } else if (LXSectionsViewer.this.l0().getClass().equals(EPOIDViewerActivityFragment.class)) {
                        viewerHelperFragment = (EPOIDViewerActivityFragment) LXSectionsViewer.this.l0();
                        sb = new StringBuilder();
                    } else if (LXSectionsViewer.this.l0().getClass().equals(EPOTableViewerActivityFragment.class)) {
                        viewerHelperFragment = (EPOTableViewerActivityFragment) LXSectionsViewer.this.l0();
                        sb = new StringBuilder();
                    }
                    sb.append("f");
                    sb.append(string);
                    viewerHelperFragment.C3(sb.toString());
                }
                LXSectionsViewer.this.M2();
            }
        });
        builder.setView(inflate);
        return builder.create();
    }
}
