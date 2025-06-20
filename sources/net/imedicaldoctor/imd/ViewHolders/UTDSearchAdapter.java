package net.imedicaldoctor.imd.ViewHolders;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.imedicaldoctor.imd.R;

public class UTDSearchAdapter extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    public Context f30492d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Bundle> f30493e;

    /* renamed from: f  reason: collision with root package name */
    public String f30494f;

    /* renamed from: g  reason: collision with root package name */
    public String f30495g;

    public UTDSearchAdapter(Context context, ArrayList<Bundle> arrayList, String str, String str2) {
        this.f30492d = context;
        this.f30493e = arrayList;
        this.f30494f = str;
        this.f30495g = str2;
    }

    public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
        ArrayList<Bundle> arrayList = this.f30493e;
        if (arrayList == null || arrayList.size() == 0) {
            MessageViewHolder messageViewHolder = (MessageViewHolder) viewHolder;
            return;
        }
        RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
        final Bundle bundle = this.f30493e.get(i2);
        rippleTextViewHolder.I.setText(bundle.getString(this.f30494f));
        rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UTDSearchAdapter.this.d0(bundle, i2);
            }
        });
    }

    public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
        ArrayList<Bundle> arrayList = this.f30493e;
        if (arrayList != null && arrayList.size() != 0) {
            return new RippleTextViewHolder(LayoutInflater.from(this.f30492d).inflate(R.layout.f1342list_view_item_ripple_text, viewGroup, false));
        }
        return new MessageViewHolder(this.f30492d, LayoutInflater.from(this.f30492d).inflate(R.layout.f1300list_view_item_card_notfound, viewGroup, false));
    }

    public int b() {
        ArrayList<Bundle> arrayList = this.f30493e;
        if (arrayList == null || arrayList.size() == 0) {
            return 1;
        }
        return this.f30493e.size();
    }

    public void d0(Bundle bundle, int i2) {
    }

    public void e0(ArrayList<Bundle> arrayList) {
        this.f30493e = arrayList;
        G();
    }
}
