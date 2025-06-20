package net.imedicaldoctor.imd.ViewHolders;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;

public class ChaptersSectionAdapter extends RecyclerView.Adapter implements StickyRecyclerHeadersAdapter {

    /* renamed from: d  reason: collision with root package name */
    public Context f30464d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Bundle> f30465e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Bundle> f30466f = new CompressHelper(this.f30464d).r2(this.f30465e, this.f30468h);

    /* renamed from: g  reason: collision with root package name */
    public String f30467g;

    /* renamed from: h  reason: collision with root package name */
    public String f30468h;

    public class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View view) {
            super(view);
        }
    }

    public class SectionHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView I;

        public SectionHeaderViewHolder(Context context, View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.text);
        }
    }

    public ChaptersSectionAdapter(Context context, ArrayList<Bundle> arrayList, String str, String str2) {
        this.f30464d = context;
        this.f30465e = arrayList;
        this.f30467g = str;
        this.f30468h = str2;
    }

    public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
        ArrayList<Bundle> arrayList = this.f30465e;
        if (arrayList == null || arrayList.size() == 0) {
            ((MessageViewHolder) viewHolder).I.setText("Search");
            return;
        }
        RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
        final Bundle bundle = this.f30465e.get(i2);
        rippleTextViewHolder.I.setText(bundle.getString(this.f30467g));
        rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ChaptersSectionAdapter.this.f0(bundle, i2);
            }
        });
    }

    public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
        ArrayList<Bundle> arrayList = this.f30465e;
        if (arrayList != null && arrayList.size() != 0) {
            return new RippleTextViewHolder(LayoutInflater.from(this.f30464d).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
        }
        return new MessageViewHolder(this.f30464d, LayoutInflater.from(this.f30464d).inflate(R.layout.f1300list_view_item_card_notfound, viewGroup, false));
    }

    public int b() {
        ArrayList<Bundle> arrayList = this.f30465e;
        if (arrayList == null || arrayList.size() == 0) {
            return 1;
        }
        return this.f30465e.size();
    }

    public int d0(int i2, ArrayList<Bundle> arrayList) {
        ArrayList<Bundle> arrayList2 = this.f30465e;
        if (!(arrayList2 == null || arrayList2.size() == 0)) {
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                i3 += arrayList.get(i4).getParcelableArrayList("items").size();
                if (i2 < i3) {
                    return i4;
                }
            }
        }
        return 0;
    }

    public Bundle e0(int i2, ArrayList<Bundle> arrayList) {
        if (arrayList == null) {
            return null;
        }
        Iterator<Bundle> it2 = arrayList.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            Bundle next = it2.next();
            i3 += next.getParcelableArrayList("items").size();
            if (i2 < i3) {
                Bundle bundle = new Bundle();
                bundle.putBundle("Item", (Bundle) next.getParcelableArrayList("items").get(i2 - (i3 - next.getParcelableArrayList("items").size())));
                bundle.putString("Title", next.getString("title"));
                return bundle;
            }
        }
        return null;
    }

    public void f0(Bundle bundle, int i2) {
    }

    public void g0(ArrayList<Bundle> arrayList) {
        this.f30465e = arrayList;
        this.f30466f = new CompressHelper(this.f30464d).r2(this.f30465e, this.f30468h);
        G();
    }

    public RecyclerView.ViewHolder o(ViewGroup viewGroup) {
        ArrayList<Bundle> arrayList = this.f30465e;
        if (arrayList == null || arrayList.size() == 0) {
            return new EmptyViewHolder(LayoutInflater.from(this.f30464d).inflate(R.layout.f1325list_view_item_header_keeper, viewGroup, false));
        }
        return new SectionHeaderViewHolder(this.f30464d, LayoutInflater.from(this.f30464d).inflate(R.layout.f1360list_view_item_section_header, viewGroup, false));
    }

    public void p(RecyclerView.ViewHolder viewHolder, int i2) {
        ArrayList<Bundle> arrayList = this.f30465e;
        if (arrayList != null && arrayList.size() != 0) {
            ((SectionHeaderViewHolder) viewHolder).I.setText(e0(i2, this.f30466f).getString("Title"));
        }
    }

    public long r(int i2) {
        return (long) d0(i2, this.f30466f);
    }
}
