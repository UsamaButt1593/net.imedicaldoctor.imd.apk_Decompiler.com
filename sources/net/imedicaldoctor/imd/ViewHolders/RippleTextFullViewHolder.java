package net.imedicaldoctor.imd.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;

public class RippleTextFullViewHolder extends RecyclerView.ViewHolder {
    public TextView I;
    public TextView J;
    public ImageView K;
    public ImageView L;
    public MaterialRippleLayout M;

    public RippleTextFullViewHolder(View view) {
        super(view);
        this.I = (TextView) view.findViewById(R.id.f1132text_view);
        this.J = (TextView) view.findViewById(R.id.f1089sub_text_view);
        this.M = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        this.K = (ImageView) view.findViewById(R.id.f980image_view);
        this.L = (ImageView) view.findViewById(R.id.f827arrow);
    }
}
