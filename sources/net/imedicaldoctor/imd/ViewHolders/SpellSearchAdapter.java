package net.imedicaldoctor.imd.ViewHolders;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.imedicaldoctor.imd.R;

public class SpellSearchAdapter extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    public Context f30480d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Bundle> f30481e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Bundle> f30482f;

    /* renamed from: g  reason: collision with root package name */
    public String f30483g;

    /* renamed from: h  reason: collision with root package name */
    public String f30484h;

    /* renamed from: i  reason: collision with root package name */
    public int f30485i;

    public SpellSearchAdapter(Context context, ArrayList<Bundle> arrayList, String str, String str2) {
        this(context, arrayList, str, str2, R.layout.f1355list_view_item_search_content_ripple);
    }

    public int C(int i2) {
        if (f0() == 0) {
            return 0;
        }
        ArrayList<Bundle> arrayList = this.f30481e;
        if (arrayList == null || arrayList.size() <= 0) {
            return i2 == 0 ? 3 : 4;
        }
        if (i2 == 0) {
            return 1;
        }
        if (i2 < this.f30481e.size() + 1) {
            return 2;
        }
        return i2 == this.f30481e.size() + 1 ? 3 : 4;
    }

    public void R(RecyclerView.ViewHolder viewHolder, int i2) {
        TextView textView;
        String str;
        if (f0() == 0) {
            MessageViewHolder messageViewHolder = (MessageViewHolder) viewHolder;
            return;
        }
        int F = viewHolder.F();
        if (F == 1) {
            textView = ((SpellHeaderViewHolder) viewHolder).I;
            str = "Matched";
        } else if (F == 2) {
            int i3 = i2 - 1;
            e0(viewHolder, this.f30481e.get(i3), i3);
            return;
        } else if (F == 3) {
            textView = ((SpellHeaderViewHolder) viewHolder).I;
            str = "Did you mean";
        } else if (F == 4) {
            SpellTextViewHolder spellTextViewHolder = (SpellTextViewHolder) viewHolder;
            ArrayList<Bundle> arrayList = this.f30481e;
            int size = i2 - (((arrayList == null || arrayList.size() <= 0) ? 0 : this.f30481e.size() + 1) + 1);
            ArrayList<Bundle> arrayList2 = this.f30482f;
            if (arrayList2 != null && size <= arrayList2.size() - 1) {
                final Bundle bundle = this.f30482f.get(size);
                spellTextViewHolder.I.setText(bundle.getString("word"));
                spellTextViewHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SpellSearchAdapter.this.h0(bundle);
                    }
                });
                return;
            }
            return;
        } else {
            return;
        }
        textView.setText(str);
    }

    public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new MessageViewHolder(this.f30480d, LayoutInflater.from(this.f30480d).inflate(R.layout.f1300list_view_item_card_notfound, viewGroup, false));
        } else if (i2 == 1) {
            return new SpellHeaderViewHolder(LayoutInflater.from(this.f30480d).inflate(R.layout.f1376list_view_item_spell_header, viewGroup, false));
        } else {
            if (i2 == 2) {
                return j0(LayoutInflater.from(this.f30480d).inflate(this.f30485i, viewGroup, false));
            }
            if (i2 == 3) {
                return new SpellHeaderViewHolder(LayoutInflater.from(this.f30480d).inflate(R.layout.f1376list_view_item_spell_header, viewGroup, false));
            }
            if (i2 == 4) {
                return new SpellTextViewHolder(LayoutInflater.from(this.f30480d).inflate(R.layout.f1359list_view_item_search_spell, viewGroup, false));
            }
            return null;
        }
    }

    public int b() {
        int f0 = f0();
        if (f0 == 0) {
            return 1;
        }
        return f0 + 2;
    }

    public String d0(String str) {
        return str;
    }

    public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, final int i2) {
        RippleSearchContentViewHolder rippleSearchContentViewHolder = (RippleSearchContentViewHolder) viewHolder;
        rippleSearchContentViewHolder.I.setText(d0(bundle.getString(this.f30483g)));
        if (this.f30484h == null) {
            rippleSearchContentViewHolder.J.setVisibility(8);
        } else {
            rippleSearchContentViewHolder.J.setVisibility(0);
            rippleSearchContentViewHolder.J.setText(Html.fromHtml(bundle.getString(this.f30484h)));
        }
        rippleSearchContentViewHolder.K.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SpellSearchAdapter.this.g0(bundle, i2);
            }
        });
    }

    public int f0() {
        ArrayList<Bundle> arrayList = this.f30481e;
        int size = arrayList != null ? arrayList.size() : 0;
        ArrayList<Bundle> arrayList2 = this.f30482f;
        return arrayList2 != null ? size + arrayList2.size() : size;
    }

    public void g0(Bundle bundle, int i2) {
    }

    public void h0(Bundle bundle) {
    }

    public void i0(ArrayList<Bundle> arrayList, ArrayList<Bundle> arrayList2) {
        this.f30481e = arrayList;
        this.f30482f = arrayList2;
        G();
    }

    public RecyclerView.ViewHolder j0(View view) {
        return new RippleSearchContentViewHolder(view);
    }

    public SpellSearchAdapter(Context context, ArrayList<Bundle> arrayList, String str, String str2, int i2) {
        this.f30480d = context;
        this.f30481e = arrayList;
        this.f30483g = str;
        this.f30484h = str2;
        this.f30485i = i2;
        this.f30482f = new ArrayList<>();
    }
}
