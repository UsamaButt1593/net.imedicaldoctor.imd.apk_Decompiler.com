package net.imedicaldoctor.imd.ViewHolders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import net.imedicaldoctor.imd.R;

public class StatusAdapter extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    public Context f30486d;

    /* renamed from: e  reason: collision with root package name */
    public String f30487e;

    public StatusAdapter(Context context, String str) {
        this.f30486d = context;
        this.f30487e = str;
    }

    public void R(RecyclerView.ViewHolder viewHolder, int i2) {
        MessageViewHolder messageViewHolder = (MessageViewHolder) viewHolder;
        messageViewHolder.I.setText(this.f30487e);
        messageViewHolder.f15587a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StatusAdapter.this.d0();
            }
        });
    }

    public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
        return new MessageViewHolder(this.f30486d, LayoutInflater.from(this.f30486d).inflate(R.layout.f1301list_view_item_card_status, viewGroup, false));
    }

    public int b() {
        return 1;
    }

    public void d0() {
    }
}
