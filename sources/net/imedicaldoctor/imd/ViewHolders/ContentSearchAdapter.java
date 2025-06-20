package net.imedicaldoctor.imd.ViewHolders;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.imedicaldoctor.imd.R;

public class ContentSearchAdapter extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    public Context f30469d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Bundle> f30470e;

    /* renamed from: f  reason: collision with root package name */
    public String f30471f;

    /* renamed from: g  reason: collision with root package name */
    public String f30472g;

    /* renamed from: h  reason: collision with root package name */
    public int f30473h;

    public ContentSearchAdapter(Context context, ArrayList<Bundle> arrayList, String str, String str2) {
        this.f30469d = context;
        this.f30470e = arrayList;
        this.f30471f = str;
        this.f30472g = str2;
        this.f30473h = R.layout.f1355list_view_item_search_content_ripple;
    }

    public void R(RecyclerView.ViewHolder viewHolder, int i2) {
        ArrayList<Bundle> arrayList = this.f30470e;
        if (arrayList == null || arrayList.size() == 0) {
            MessageViewHolder messageViewHolder = (MessageViewHolder) viewHolder;
        } else {
            d0(viewHolder, i2, this.f30470e.get(i2));
        }
    }

    public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
        ArrayList<Bundle> arrayList = this.f30470e;
        if (arrayList != null && arrayList.size() != 0) {
            return new RippleSearchContentViewHolder(LayoutInflater.from(this.f30469d).inflate(this.f30473h, viewGroup, false));
        }
        return new MessageViewHolder(this.f30469d, LayoutInflater.from(this.f30469d).inflate(R.layout.f1300list_view_item_card_notfound, viewGroup, false));
    }

    public int b() {
        ArrayList<Bundle> arrayList = this.f30470e;
        if (arrayList == null || arrayList.size() == 0) {
            return 1;
        }
        return this.f30470e.size();
    }

    public void d0(RecyclerView.ViewHolder viewHolder, final int i2, final Bundle bundle) {
        RippleSearchContentViewHolder rippleSearchContentViewHolder = (RippleSearchContentViewHolder) viewHolder;
        rippleSearchContentViewHolder.I.setText(bundle.getString(this.f30471f));
        if (this.f30472g == null) {
            rippleSearchContentViewHolder.J.setVisibility(8);
        } else {
            rippleSearchContentViewHolder.J.setVisibility(0);
            rippleSearchContentViewHolder.J.setText(Html.fromHtml(bundle.getString(this.f30472g)));
        }
        rippleSearchContentViewHolder.K.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ContentSearchAdapter.this.e0(bundle, i2);
            }
        });
    }

    public void e0(Bundle bundle, int i2) {
    }

    public void f0(ArrayList<Bundle> arrayList) {
        this.f30470e = arrayList;
        G();
    }

    public ContentSearchAdapter(Context context, ArrayList<Bundle> arrayList, String str, String str2, int i2) {
        this.f30469d = context;
        this.f30470e = arrayList;
        this.f30471f = str;
        this.f30472g = str2;
        this.f30473h = i2;
    }
}
