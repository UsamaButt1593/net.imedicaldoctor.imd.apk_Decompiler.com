package net.imedicaldoctor.imd.Fragments.Epocrate;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import org.apache.commons.lang3.StringUtils;

public class EPOPillSelectDialog extends DialogFragment {
    /* access modifiers changed from: private */
    public ArrayList<Bundle> F4;
    /* access modifiers changed from: private */
    public String G4;
    /* access modifiers changed from: private */
    public String H4;
    private RecyclerView I4;

    public class ImageTextCheckViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public ImageView J;
        public ImageView K;
        public MaterialRippleLayout L;

        public ImageTextCheckViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1132text_view);
            this.J = (ImageView) view.findViewById(R.id.f980image_view);
            this.K = (ImageView) view.findViewById(R.id.f872check_icon);
            this.L = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        }
    }

    private class SelectAdapter extends RecyclerView.Adapter {
        private SelectAdapter() {
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            ImageTextCheckViewHolder imageTextCheckViewHolder = (ImageTextCheckViewHolder) viewHolder;
            if (i2 == 0) {
                imageTextCheckViewHolder.J.setVisibility(8);
                if (EPOPillSelectDialog.this.H4.equals("-1")) {
                    imageTextCheckViewHolder.K.setVisibility(0);
                } else {
                    imageTextCheckViewHolder.K.setVisibility(8);
                }
                TextView textView = imageTextCheckViewHolder.I;
                textView.setText("Any " + EPOPillSelectDialog.this.G4);
                imageTextCheckViewHolder.L.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        ((EPOPillActivityFragment) EPOPillSelectDialog.this.l0()).l3(EPOPillSelectDialog.this.G4, (Bundle) null);
                    }
                });
                return;
            }
            final Bundle bundle = (Bundle) EPOPillSelectDialog.this.F4.get(i2 - 1);
            imageTextCheckViewHolder.J.setVisibility(0);
            if (EPOPillSelectDialog.this.H4.equals(bundle.getString("ID"))) {
                imageTextCheckViewHolder.K.setVisibility(0);
            } else {
                imageTextCheckViewHolder.K.setVisibility(8);
            }
            imageTextCheckViewHolder.I.setText(bundle.getString("STRING_TEXT"));
            imageTextCheckViewHolder.J.setImageBitmap(EPOPillSelectDialog.j3(EPOPillSelectDialog.this.r(), "pill" + bundle.getString("STRING_TEXT").replace("-", "").replace("_", "").replace(StringUtils.SPACE, "") + ".png"));
            imageTextCheckViewHolder.L.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ((EPOPillActivityFragment) EPOPillSelectDialog.this.l0()).l3(EPOPillSelectDialog.this.G4, bundle);
                    EPOPillSelectDialog.this.N2();
                }
            });
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            return new ImageTextCheckViewHolder(LayoutInflater.from(EPOPillSelectDialog.this.r()).inflate(R.layout.f1328list_view_item_image_text_check, viewGroup, false));
        }

        public int b() {
            return EPOPillSelectDialog.this.F4.size() + 1;
        }
    }

    public static Bitmap j3(Context context, String str) {
        try {
            return BitmapFactory.decodeStream(context.getAssets().open(str));
        } catch (IOException unused) {
            return null;
        }
    }

    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1252fragment_new_section_viewer, (ViewGroup) null);
        this.I4 = (RecyclerView) inflate.findViewById(R.id.f1054recycler_view);
        this.F4 = y().getParcelableArrayList("Items");
        this.G4 = y().getString("Category");
        this.H4 = y().getString("Selected");
        new CompressHelper(r());
        this.I4.setAdapter(new SelectAdapter());
        this.I4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
        builder.setView(inflate);
        return builder.create();
    }
}
