package net.imedicaldoctor.imd.ViewHolders;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.imedicaldoctor.imd.R;

public class ChaptersAdapter extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    public Context f30459d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Bundle> f30460e;

    /* renamed from: f  reason: collision with root package name */
    public String f30461f;

    /* renamed from: g  reason: collision with root package name */
    public int f30462g;

    /* renamed from: h  reason: collision with root package name */
    public String f30463h;

    public ChaptersAdapter(Context context, ArrayList<Bundle> arrayList, String str) {
        this(context, arrayList, str, R.layout.f1342list_view_item_ripple_text);
    }

    public void R(RecyclerView.ViewHolder viewHolder, int i2) {
        ArrayList<Bundle> arrayList = this.f30460e;
        if (arrayList == null || arrayList.size() == 0) {
            ((MessageViewHolder) viewHolder).I.setText(this.f30463h);
        } else {
            e0(viewHolder, this.f30460e.get(i2), i2);
        }
    }

    public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
        ArrayList<Bundle> arrayList = this.f30460e;
        if (arrayList != null && arrayList.size() != 0) {
            return h0(LayoutInflater.from(this.f30459d).inflate(this.f30462g, viewGroup, false));
        }
        return new MessageViewHolder(this.f30459d, LayoutInflater.from(this.f30459d).inflate(R.layout.f1300list_view_item_card_notfound, viewGroup, false));
    }

    public int b() {
        ArrayList<Bundle> arrayList = this.f30460e;
        if (arrayList == null || arrayList.size() == 0) {
            return 1;
        }
        return this.f30460e.size();
    }

    public String d0(String str) {
        return str;
    }

    public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, final int i2) {
        RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
        rippleTextViewHolder.I.setText(d0(bundle.getString(this.f30461f)));
        rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ChaptersAdapter.this.f0(bundle, i2);
            }
        });
    }

    public void f0(Bundle bundle, int i2) {
    }

    public void g0(ArrayList<Bundle> arrayList) {
        this.f30460e = arrayList;
        G();
    }

    public RecyclerView.ViewHolder h0(View view) {
        return new RippleTextViewHolder(view);
    }

    public ChaptersAdapter(Context context, ArrayList<Bundle> arrayList, String str, int i2) {
        this.f30459d = context;
        this.f30460e = arrayList;
        this.f30461f = str;
        this.f30462g = i2;
        this.f30463h = "Nothing";
    }
}
