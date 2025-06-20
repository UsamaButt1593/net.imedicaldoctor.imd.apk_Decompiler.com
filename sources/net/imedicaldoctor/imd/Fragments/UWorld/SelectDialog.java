package net.imedicaldoctor.imd.Fragments.UWorld;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextCheckViewHolder;

public class SelectDialog extends DialogFragment {
    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1252fragment_new_section_viewer, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.f1054recycler_view);
        ArrayList parcelableArrayList = y().getParcelableArrayList("Items");
        String string = y().getString("TitleProperty");
        final int i2 = y().containsKey("Position") ? y().getInt("Position") : 0;
        recyclerView.setAdapter(new ChaptersAdapter(r(), parcelableArrayList, string, R.layout.f1344list_view_item_ripple_text_check) {
            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, final int i2) {
                ImageView imageView;
                int i3;
                RippleTextCheckViewHolder rippleTextCheckViewHolder = (RippleTextCheckViewHolder) viewHolder;
                if (i2 == i2) {
                    imageView = rippleTextCheckViewHolder.K;
                    i3 = 0;
                } else {
                    imageView = rippleTextCheckViewHolder.K;
                    i3 = 8;
                }
                imageView.setVisibility(i3);
                rippleTextCheckViewHolder.I.setText(bundle.getString(this.f30461f));
                rippleTextCheckViewHolder.J.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SelectDialog.this.N2();
                        SelectDialog.this.g3(bundle, i2);
                    }
                });
            }

            public RecyclerView.ViewHolder h0(View view) {
                return new RippleTextCheckViewHolder(view);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(r(), 1, false));
        recyclerView.p(new CustomItemDecoration(r()));
        builder.setView(inflate);
        return builder.create();
    }

    public void g3(Bundle bundle, int i2) {
        if (l0() instanceof UWMainActivityFragment) {
            ((UWMainActivityFragment) l0()).K3(y().getString("Type"), bundle, i2);
        }
    }
}
