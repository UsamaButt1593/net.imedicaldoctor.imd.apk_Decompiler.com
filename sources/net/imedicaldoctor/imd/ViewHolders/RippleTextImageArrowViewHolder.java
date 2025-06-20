package net.imedicaldoctor.imd.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;

public class RippleTextImageArrowViewHolder extends RecyclerView.ViewHolder {
    public TextView I;
    public ImageView J;
    public ImageView K;
    public MaterialRippleLayout L;

    public RippleTextImageArrowViewHolder(View view) {
        super(view);
        this.I = (TextView) view.findViewById(R.id.f1132text_view);
        this.L = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        this.J = (ImageView) view.findViewById(R.id.f980image_view);
        this.K = (ImageView) view.findViewById(R.id.f827arrow);
    }
}
