package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Locale;

class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final MaterialCalendar<?> f21390d;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView I;

        ViewHolder(TextView textView) {
            super(textView);
            this.I = textView;
        }
    }

    YearGridAdapter(MaterialCalendar<?> materialCalendar) {
        this.f21390d = materialCalendar;
    }

    @NonNull
    private View.OnClickListener e0(final int i2) {
        return new View.OnClickListener() {
            public void onClick(View view) {
                YearGridAdapter.this.f21390d.f3(YearGridAdapter.this.f21390d.W2().j(Month.b(i2, YearGridAdapter.this.f21390d.Y2().X)));
                YearGridAdapter.this.f21390d.g3(MaterialCalendar.CalendarSelector.DAY);
            }
        };
    }

    public int b() {
        return this.f21390d.W2().C();
    }

    /* access modifiers changed from: package-private */
    public int f0(int i2) {
        return i2 - this.f21390d.W2().z().Y;
    }

    /* access modifiers changed from: package-private */
    public int g0(int i2) {
        return this.f21390d.W2().z().Y + i2;
    }

    /* renamed from: h0 */
    public void R(@NonNull ViewHolder viewHolder, int i2) {
        int g0 = g0(i2);
        viewHolder.I.setText(String.format(Locale.getDefault(), TimeModel.b3, new Object[]{Integer.valueOf(g0)}));
        TextView textView = viewHolder.I;
        textView.setContentDescription(DateStrings.k(textView.getContext(), g0));
        CalendarStyle X2 = this.f21390d.X2();
        Calendar v = UtcDates.v();
        CalendarItemStyle calendarItemStyle = v.get(1) == g0 ? X2.f21346f : X2.f21344d;
        for (Long longValue : this.f21390d.L2().F()) {
            v.setTimeInMillis(longValue.longValue());
            if (v.get(1) == g0) {
                calendarItemStyle = X2.f21345e;
            }
        }
        calendarItemStyle.f(viewHolder.I);
        viewHolder.I.setOnClickListener(e0(g0));
    }

    @NonNull
    /* renamed from: i0 */
    public ViewHolder T(@NonNull ViewGroup viewGroup, int i2) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.D0, viewGroup, false));
    }
}
