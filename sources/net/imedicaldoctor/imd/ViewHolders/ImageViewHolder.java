package net.imedicaldoctor.imd.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    public ImageView I;
    public MaterialRippleLayout J;

    public ImageViewHolder(View view) {
        super(view);
        this.I = (ImageView) view.findViewById(R.id.f980image_view);
        this.J = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
    }
}
