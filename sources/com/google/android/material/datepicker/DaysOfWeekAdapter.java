package com.google.android.material.datepicker;

import android.os.Build;
import android.widget.BaseAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Calendar;

class DaysOfWeekAdapter extends BaseAdapter {
    private static final int X2 = (Build.VERSION.SDK_INT >= 26 ? 4 : 1);
    private static final int Z = 4;
    private final int X;
    private final int Y;
    @NonNull
    private final Calendar s;

    public DaysOfWeekAdapter() {
        Calendar x = UtcDates.x();
        this.s = x;
        this.X = x.getMaximum(7);
        this.Y = x.getFirstDayOfWeek();
    }

    private int b(int i2) {
        int i3 = i2 + this.Y;
        int i4 = this.X;
        return i3 > i4 ? i3 - i4 : i3;
    }

    @Nullable
    /* renamed from: a */
    public Integer getItem(int i2) {
        if (i2 >= this.X) {
            return null;
        }
        return Integer.valueOf(b(i2));
    }

    public int getCount() {
        return this.X;
    }

    public long getItemId(int i2) {
        return 0;
    }

    /* JADX WARNING: type inference failed for: r6v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"WrongConstant"})
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r5, @androidx.annotation.Nullable android.view.View r6, @androidx.annotation.NonNull android.view.ViewGroup r7) {
        /*
            r4 = this;
            r0 = 0
            r1 = r6
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r6 != 0) goto L_0x0017
            android.content.Context r6 = r7.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            int r1 = com.google.android.material.R.layout.v0
            android.view.View r6 = r6.inflate(r1, r7, r0)
            r1 = r6
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x0017:
            java.util.Calendar r6 = r4.s
            int r5 = r4.b(r5)
            r2 = 7
            r6.set(r2, r5)
            android.content.res.Resources r5 = r1.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            java.util.Locale r5 = r5.locale
            java.util.Calendar r6 = r4.s
            int r3 = X2
            java.lang.String r5 = r6.getDisplayName(r2, r3, r5)
            r1.setText(r5)
            android.content.Context r5 = r7.getContext()
            int r6 = com.google.android.material.R.string.m1
            java.lang.String r5 = r5.getString(r6)
            java.util.Calendar r6 = r4.s
            r7 = 2
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r6 = r6.getDisplayName(r2, r7, r3)
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r0] = r6
            java.lang.String r5 = java.lang.String.format(r5, r7)
            r1.setContentDescription(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.DaysOfWeekAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public DaysOfWeekAdapter(int i2) {
        Calendar x = UtcDates.x();
        this.s = x;
        this.X = x.getMaximum(7);
        this.Y = i2;
    }
}
