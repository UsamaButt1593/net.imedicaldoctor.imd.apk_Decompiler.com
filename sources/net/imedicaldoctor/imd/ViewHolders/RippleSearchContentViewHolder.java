package net.imedicaldoctor.imd.ViewHolders;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;

public class RippleSearchContentViewHolder extends RecyclerView.ViewHolder {
    public TextView I;
    public TextView J;
    public MaterialRippleLayout K;

    public RippleSearchContentViewHolder(View view) {
        super(view);
        this.I = (TextView) view.findViewById(R.id.f1136title_text);
        this.J = (TextView) view.findViewById(R.id.f1098subtitle_text);
        this.K = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
    }
}
