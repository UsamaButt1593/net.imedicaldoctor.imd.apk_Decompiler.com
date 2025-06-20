package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

class CursorFilter extends Filter {

    /* renamed from: a  reason: collision with root package name */
    CursorFilterClient f6776a;

    interface CursorFilterClient {
        CharSequence a(Cursor cursor);

        void b(Cursor cursor);

        Cursor c();

        Cursor d(CharSequence charSequence);
    }

    CursorFilter(CursorFilterClient cursorFilterClient) {
        this.f6776a = cursorFilterClient;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f6776a.a((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor d2 = this.f6776a.d(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (d2 != null) {
            filterResults.count = d2.getCount();
        } else {
            filterResults.count = 0;
            d2 = null;
        }
        filterResults.values = d2;
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor c2 = this.f6776a.c();
        Object obj = filterResults.values;
        if (obj != null && obj != c2) {
            this.f6776a.b((Cursor) obj);
        }
    }
}
