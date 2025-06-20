package net.imedicaldoctor.imd.ViewHolders;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.R;

public class NotStickySectionAdapter extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    public Context f30474d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Bundle> f30475e;

    /* renamed from: f  reason: collision with root package name */
    public String f30476f;

    /* renamed from: g  reason: collision with root package name */
    public int f30477g;

    /* renamed from: h  reason: collision with root package name */
    public int f30478h;

    /* renamed from: i  reason: collision with root package name */
    public String f30479i;

    public static class HeaderCellViewHolder extends RecyclerView.ViewHolder {
        public TextView I;

        public HeaderCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f957header_text);
        }
    }

    public NotStickySectionAdapter(Context context, ArrayList<Bundle> arrayList, String str) {
        this(context, arrayList, str, R.layout.f1342list_view_item_ripple_text);
    }

    public int C(int i2) {
        ArrayList<Bundle> arrayList = this.f30475e;
        if (arrayList == null || arrayList.size() == 0) {
            return 2;
        }
        return d0(i2, this.f30475e).containsKey("Title") ? 1 : 0;
    }

    public void R(RecyclerView.ViewHolder viewHolder, int i2) {
        TextView textView;
        String str;
        int F = viewHolder.F();
        if (F == 0) {
            Bundle d0 = d0(i2, this.f30475e);
            int i3 = d0.containsKey("Index") ? d0.getInt("Index") : -2;
            Bundle bundle = d0.getBundle("Item");
            if (i3 > -2) {
                bundle.putInt("Index", i3);
            }
            f0(viewHolder, bundle, i2);
            return;
        }
        if (F == 1) {
            Bundle d02 = d0(i2, this.f30475e);
            textView = ((HeaderCellViewHolder) viewHolder).I;
            str = i0(d02.getString("Title"));
        } else if (F == 2) {
            textView = ((MessageViewHolder) viewHolder).I;
            str = this.f30479i;
        } else {
            return;
        }
        textView.setText(str);
    }

    public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return k0(LayoutInflater.from(this.f30474d).inflate(this.f30477g, viewGroup, false));
        }
        if (i2 == 1) {
            return new HeaderCellViewHolder(LayoutInflater.from(this.f30474d).inflate(this.f30478h, viewGroup, false));
        }
        if (i2 != 2) {
            return null;
        }
        return new MessageViewHolder(this.f30474d, LayoutInflater.from(this.f30474d).inflate(R.layout.f1300list_view_item_card_notfound, viewGroup, false));
    }

    public int b() {
        ArrayList<Bundle> arrayList = this.f30475e;
        if (arrayList == null || arrayList.size() == 0) {
            return 1;
        }
        return j0(this.f30475e);
    }

    public Bundle d0(int i2, ArrayList<Bundle> arrayList) {
        Iterator<Bundle> it2 = arrayList.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it2.hasNext()) {
            Bundle next = it2.next();
            if (i2 == i3) {
                Bundle bundle = new Bundle();
                bundle.putString("Title", next.getString("title"));
                bundle.putInt("Row", 0);
                bundle.putInt("Section", i4);
                bundle.putInt("Row2", 1);
                bundle.putInt("Section2", i4 - 1);
                return bundle;
            }
            int size = i3 + next.getParcelableArrayList("items").size();
            if (i2 <= size) {
                int size2 = (i2 - (size - next.getParcelableArrayList("items").size())) - 1;
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("Item", (Bundle) next.getParcelableArrayList("items").get(size2));
                bundle2.putInt("Row", size2);
                bundle2.putInt("Index", size2);
                bundle2.putInt("Section", i4);
                return bundle2;
            }
            i3 = size + 1;
            i4++;
        }
        return null;
    }

    public String e0(String str) {
        return str;
    }

    public void f0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, final int i2) {
        RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
        rippleTextViewHolder.I.setText(e0(bundle.getString(this.f30476f)));
        rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NotStickySectionAdapter.this.g0(bundle, i2);
            }
        });
    }

    public void g0(Bundle bundle, int i2) {
    }

    public void h0(ArrayList<Bundle> arrayList) {
        this.f30475e = arrayList;
        G();
    }

    public String i0(String str) {
        return str;
    }

    public int j0(ArrayList<Bundle> arrayList) {
        int i2 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<Bundle> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i2 = i2 + it2.next().getParcelableArrayList("items").size() + 1;
        }
        return i2;
    }

    public RecyclerView.ViewHolder k0(View view) {
        return new RippleTextViewHolder(view);
    }

    public NotStickySectionAdapter(Context context, ArrayList<Bundle> arrayList, String str, int i2) {
        this(context, arrayList, str, i2, R.layout.f1308list_view_item_database_card_header);
    }

    public NotStickySectionAdapter(Context context, ArrayList<Bundle> arrayList, String str, int i2, int i3) {
        this.f30474d = context;
        this.f30475e = arrayList;
        this.f30476f = str;
        this.f30477g = i2;
        this.f30478h = i3;
        this.f30479i = "Nothing";
    }
}
