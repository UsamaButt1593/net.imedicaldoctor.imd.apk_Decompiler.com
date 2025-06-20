package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.annotation.RestrictTo;
import androidx.cursoradapter.widget.CursorFilter;

public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {
    @Deprecated
    public static final int c3 = 1;
    public static final int d3 = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean X;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int X2;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Cursor Y;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected ChangeObserver Y2;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Context Z;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected DataSetObserver Z2;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected CursorFilter a3;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected FilterQueryProvider b3;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean s;

    private class ChangeObserver extends ContentObserver {
        ChangeObserver() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            CursorAdapter.this.k();
        }
    }

    private class MyDataSetObserver extends DataSetObserver {
        MyDataSetObserver() {
        }

        public void onChanged() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.s = true;
            cursorAdapter.notifyDataSetChanged();
        }

        public void onInvalidated() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.s = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public CursorAdapter(Context context, Cursor cursor) {
        g(context, cursor, 1);
    }

    public CharSequence a(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public void b(Cursor cursor) {
        Cursor m2 = m(cursor);
        if (m2 != null) {
            m2.close();
        }
    }

    public Cursor c() {
        return this.Y;
    }

    public Cursor d(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.b3;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.Y;
    }

    public abstract void e(View view, Context context, Cursor cursor);

    public FilterQueryProvider f() {
        return this.b3;
    }

    /* access modifiers changed from: package-private */
    public void g(Context context, Cursor cursor, int i2) {
        MyDataSetObserver myDataSetObserver;
        boolean z = false;
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.X = true;
        } else {
            this.X = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.Y = cursor;
        this.s = z;
        this.Z = context;
        this.X2 = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.Y2 = new ChangeObserver();
            myDataSetObserver = new MyDataSetObserver();
        } else {
            myDataSetObserver = null;
            this.Y2 = null;
        }
        this.Z2 = myDataSetObserver;
        if (z) {
            ChangeObserver changeObserver = this.Y2;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.Z2;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public int getCount() {
        Cursor cursor;
        if (!this.s || (cursor = this.Y) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.s) {
            return null;
        }
        this.Y.moveToPosition(i2);
        if (view == null) {
            view = i(this.Z, this.Y, viewGroup);
        }
        e(view, this.Z, this.Y);
        return view;
    }

    public Filter getFilter() {
        if (this.a3 == null) {
            this.a3 = new CursorFilter(this);
        }
        return this.a3;
    }

    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.s || (cursor = this.Y) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.Y;
    }

    public long getItemId(int i2) {
        Cursor cursor;
        if (!this.s || (cursor = this.Y) == null || !cursor.moveToPosition(i2)) {
            return 0;
        }
        return this.Y.getLong(this.X2);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.s) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.Y.moveToPosition(i2)) {
            if (view == null) {
                view = j(this.Z, this.Y, viewGroup);
            }
            e(view, this.Z, this.Y);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i2);
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void h(Context context, Cursor cursor, boolean z) {
        g(context, cursor, z ? 1 : 2);
    }

    public boolean hasStableIds() {
        return true;
    }

    public View i(Context context, Cursor cursor, ViewGroup viewGroup) {
        return j(context, cursor, viewGroup);
    }

    public abstract View j(Context context, Cursor cursor, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public void k() {
        Cursor cursor;
        if (this.X && (cursor = this.Y) != null && !cursor.isClosed()) {
            this.s = this.Y.requery();
        }
    }

    public void l(FilterQueryProvider filterQueryProvider) {
        this.b3 = filterQueryProvider;
    }

    public Cursor m(Cursor cursor) {
        Cursor cursor2 = this.Y;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            ChangeObserver changeObserver = this.Y2;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            DataSetObserver dataSetObserver = this.Z2;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.Y = cursor;
        if (cursor != null) {
            ChangeObserver changeObserver2 = this.Y2;
            if (changeObserver2 != null) {
                cursor.registerContentObserver(changeObserver2);
            }
            DataSetObserver dataSetObserver2 = this.Z2;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.X2 = cursor.getColumnIndexOrThrow("_id");
            this.s = true;
            notifyDataSetChanged();
        } else {
            this.X2 = -1;
            this.s = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public CursorAdapter(Context context, Cursor cursor, int i2) {
        g(context, cursor, i2);
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        g(context, cursor, z ? 1 : 2);
    }
}
