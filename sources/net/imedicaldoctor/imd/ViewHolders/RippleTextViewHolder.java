package net.imedicaldoctor.imd.ViewHolders;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;

public class RippleTextViewHolder extends RecyclerView.ViewHolder {
    public TextView I;
    public MaterialRippleLayout J;

    public RippleTextViewHolder(View view) {
        super(view);
        this.I = (TextView) view.findViewById(R.id.f1132text_view);
        this.J = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
    }
}
