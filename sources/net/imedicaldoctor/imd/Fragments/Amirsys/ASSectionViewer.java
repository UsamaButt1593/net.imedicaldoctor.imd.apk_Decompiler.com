package net.imedicaldoctor.imd.Fragments.Amirsys;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.Facts.FTViewerActivityFragment;
import net.imedicaldoctor.imd.Fragments.IranDaru.IDViewerActivity;
import net.imedicaldoctor.imd.Fragments.LWW.LWWViewerFragment;
import net.imedicaldoctor.imd.Fragments.Martindale.MDViewerActivityFragment;
import net.imedicaldoctor.imd.Fragments.Micromedex.MMIVViewerActivityFragment;
import net.imedicaldoctor.imd.Fragments.Micromedex.MMInteractViewerActivityFragment;
import net.imedicaldoctor.imd.Fragments.Micromedex.MMNeoViewerActivityFragment;
import net.imedicaldoctor.imd.Fragments.Micromedex.MMViewerActivityFragment;
import net.imedicaldoctor.imd.Fragments.Statdx.SDDocActivityFragment;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;

public class ASSectionViewer extends DialogFragment {
    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1252fragment_new_section_viewer, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.f1054recycler_view);
        recyclerView.setAdapter(new ChaptersAdapter(r(), y().getParcelableArrayList("Items"), y().getString("TitleProperty"), R.layout.f1342list_view_item_ripple_text) {
            public void f0(Bundle bundle, int i2) {
                ASSectionViewer.this.N2();
                ASSectionViewer.this.g3(bundle);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(r(), 1, false));
        recyclerView.setItemDecoration(new CustomItemDecoration(r()));
        builder.setView(inflate);
        return builder.create();
    }

    public void g3(Bundle bundle) {
        ViewerHelperFragment viewerHelperFragment;
        ViewerHelperFragment viewerHelperFragment2;
        StringBuilder sb;
        ViewerHelperFragment viewerHelperFragment3;
        String str;
        ViewerHelperFragment viewerHelperFragment4;
        String string;
        if (l0() instanceof LWWViewerFragment) {
            ((LWWViewerFragment) l0()).C3(bundle.getString("id"));
            return;
        }
        if (l0() instanceof MMViewerActivityFragment) {
            viewerHelperFragment2 = (MMViewerActivityFragment) l0();
            sb = new StringBuilder();
        } else {
            if (l0() instanceof ASDocActivityFragment) {
                viewerHelperFragment = (ASDocActivityFragment) l0();
            } else {
                if (l0() instanceof FTViewerActivityFragment) {
                    viewerHelperFragment4 = (FTViewerActivityFragment) l0();
                } else {
                    if (l0() instanceof IDViewerActivity.IDViewerFragment) {
                        viewerHelperFragment3 = (IDViewerActivity.IDViewerFragment) l0();
                        str = "fDrugGenericID";
                    } else if (l0() instanceof MDViewerActivityFragment) {
                        viewerHelperFragment4 = (MDViewerActivityFragment) l0();
                    } else if (l0() instanceof MMInteractViewerActivityFragment) {
                        viewerHelperFragment3 = (MMInteractViewerActivityFragment) l0();
                        str = "f" + bundle.getString("sequence");
                    } else if (l0() instanceof MMIVViewerActivityFragment) {
                        viewerHelperFragment2 = (MMIVViewerActivityFragment) l0();
                        sb = new StringBuilder();
                    } else if (l0() instanceof MMNeoViewerActivityFragment) {
                        viewerHelperFragment2 = (MMNeoViewerActivityFragment) l0();
                        sb = new StringBuilder();
                    } else if (l0() instanceof SDDocActivityFragment) {
                        viewerHelperFragment = (SDDocActivityFragment) l0();
                    } else {
                        return;
                    }
                    string = bundle.getString(str);
                    viewerHelperFragment4.C3(string);
                }
                string = bundle.getString("fId");
                viewerHelperFragment4.C3(string);
            }
            string = bundle.getString("fieldId");
            viewerHelperFragment4.C3(string);
        }
        sb.append("f");
        sb.append(bundle.getString("sequence"));
        string = sb.toString();
        viewerHelperFragment4.C3(string);
    }
}
