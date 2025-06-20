package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int e3;
    private int f3;
    private LayoutInflater g3;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i2, Cursor cursor) {
        super(context, cursor);
        this.f3 = i2;
        this.e3 = i2;
        this.g3 = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View i(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.g3.inflate(this.f3, viewGroup, false);
    }

    public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.g3.inflate(this.e3, viewGroup, false);
    }

    public void n(int i2) {
        this.f3 = i2;
    }

    public void o(int i2) {
        this.e3 = i2;
    }

    public ResourceCursorAdapter(Context context, int i2, Cursor cursor, int i3) {
        super(context, cursor, i3);
        this.f3 = i2;
        this.e3 = i2;
        this.g3 = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Deprecated
    public ResourceCursorAdapter(Context context, int i2, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f3 = i2;
        this.e3 = i2;
        this.g3 = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
