package net.imedicaldoctor.imd.ViewHolders;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.imedicaldoctor.imd.R;

public class HeaderCellViewHolder extends RecyclerView.ViewHolder {
    public TextView I;

    public HeaderCellViewHolder(View view) {
        super(view);
        this.I = (TextView) view.findViewById(R.id.f957header_text);
    }
}
