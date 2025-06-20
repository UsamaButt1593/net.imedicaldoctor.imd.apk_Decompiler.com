package net.imedicaldoctor.imd.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;

public class RippleTextCheckViewHolder extends RecyclerView.ViewHolder {
    public TextView I;
    public MaterialRippleLayout J;
    public ImageView K;

    public RippleTextCheckViewHolder(View view) {
        super(view);
        this.I = (TextView) view.findViewById(R.id.f1132text_view);
        this.J = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        this.K = (ImageView) view.findViewById(R.id.f872check_icon);
    }
}
