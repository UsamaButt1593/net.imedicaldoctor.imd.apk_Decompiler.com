package net.imedicaldoctor.imd.ViewHolders;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.R;

public class StickySectionAdapter extends RecyclerView.Adapter implements StickyRecyclerHeadersAdapter {

    /* renamed from: d  reason: collision with root package name */
    public Context f30488d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Bundle> f30489e;

    /* renamed from: f  reason: collision with root package name */
    public String f30490f;

    /* renamed from: g  reason: collision with root package name */
    public int f30491g;

    public StickySectionAdapter(Context context, ArrayList<Bundle> arrayList, String str) {
        this(context, arrayList, str, R.layout.f1342list_view_item_ripple_text);
    }

    public void R(RecyclerView.ViewHolder viewHolder, int i2) {
        g0(viewHolder, e0(i2, this.f30489e).getBundle("Item"), i2);
    }

    public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
        return l0(LayoutInflater.from(this.f30488d).inflate(this.f30491g, viewGroup, false));
    }

    public int b() {
        return k0(this.f30489e);
    }

    public int d0(int i2, ArrayList<Bundle> arrayList) {
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            i3 += arrayList.get(i4).getParcelableArrayList("items").size();
            if (i2 < i3) {
                return i4;
            }
        }
        return 0;
    }

    public Bundle e0(int i2, ArrayList<Bundle> arrayList) {
        Iterator<Bundle> it2 = arrayList.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            Bundle next = it2.next();
            i3 += next.getParcelableArrayList("items").size();
            if (i2 < i3) {
                int size = i2 - (i3 - next.getParcelableArrayList("items").size());
                Bundle bundle = new Bundle();
                bundle.putBundle("Item", (Bundle) next.getParcelableArrayList("items").get(size));
                bundle.putString("Title", next.getString("title"));
                return bundle;
            }
        }
        return null;
    }

    public String f0(String str) {
        return str;
    }

    public void g0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, final int i2) {
        RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
        rippleTextViewHolder.I.setText(f0(bundle.getString(this.f30490f)));
        rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StickySectionAdapter.this.h0(bundle, i2);
            }
        });
    }

    public void h0(Bundle bundle, int i2) {
    }

    public void i0(ArrayList<Bundle> arrayList) {
        this.f30489e = arrayList;
        G();
    }

    public String j0(String str) {
        return str;
    }

    public int k0(ArrayList<Bundle> arrayList) {
        int i2 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<Bundle> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i2 += it2.next().getParcelableArrayList("items").size();
        }
        return i2;
    }

    public RecyclerView.ViewHolder l0(View view) {
        return new RippleTextViewHolder(view);
    }

    public RecyclerView.ViewHolder o(ViewGroup viewGroup) {
        return new SpellHeaderViewHolder(LayoutInflater.from(this.f30488d).inflate(R.layout.f1376list_view_item_spell_header, viewGroup, false));
    }

    public void p(RecyclerView.ViewHolder viewHolder, int i2) {
        SpellHeaderViewHolder spellHeaderViewHolder = (SpellHeaderViewHolder) viewHolder;
        ArrayList<Bundle> arrayList = this.f30489e;
        if (arrayList != null) {
            spellHeaderViewHolder.I.setText(j0(e0(i2, arrayList).getString("Title")));
        }
    }

    public long r(int i2) {
        return (long) d0(i2, this.f30489e);
    }

    public StickySectionAdapter(Context context, ArrayList<Bundle> arrayList, String str, int i2) {
        this.f30488d = context;
        this.f30489e = arrayList;
        this.f30490f = str;
        this.f30491g = i2;
    }
}
