package net.imedicaldoctor.imd.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;

public class RippleTextGotoViewHolder extends RecyclerView.ViewHolder {
    public TextView I;
    public MaterialRippleLayout J;
    public ImageView K;
    public ImageView L;

    public RippleTextGotoViewHolder(View view) {
        super(view);
        this.I = (TextView) view.findViewById(R.id.f1132text_view);
        this.J = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        this.K = (ImageView) view.findViewById(R.id.f986info_button);
        this.L = (ImageView) view.findViewById(R.id.f1016next_icon);
    }
}
