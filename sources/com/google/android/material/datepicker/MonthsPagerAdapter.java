package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;

class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final CalendarConstraints f21380d;

    /* renamed from: e  reason: collision with root package name */
    private final DateSelector<?> f21381e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final DayViewDecorator f21382f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final MaterialCalendar.OnDayClickListener f21383g;

    /* renamed from: h  reason: collision with root package name */
    private final int f21384h;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView I;
        final MaterialCalendarGridView J;

        ViewHolder(@NonNull LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.e3);
            this.I = textView;
            ViewCompat.I1(textView, true);
            this.J = (MaterialCalendarGridView) linearLayout.findViewById(R.id.Z2);
            if (!z) {
                textView.setVisibility(8);
            }
        }
    }

    MonthsPagerAdapter(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, @Nullable DayViewDecorator dayViewDecorator, MaterialCalendar.OnDayClickListener onDayClickListener) {
        Month z = calendarConstraints.z();
        Month l2 = calendarConstraints.l();
        Month t = calendarConstraints.t();
        if (z.compareTo(t) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (t.compareTo(l2) <= 0) {
            this.f21384h = (MonthAdapter.Z2 * MaterialCalendar.Z2(context)) + (MaterialDatePicker.E3(context) ? MaterialCalendar.Z2(context) : 0);
            this.f21380d = calendarConstraints;
            this.f21381e = dateSelector;
            this.f21382f = dayViewDecorator;
            this.f21383g = onDayClickListener;
            a0(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    public long B(int i2) {
        return this.f21380d.z().p(i2).o();
    }

    public int b() {
        return this.f21380d.p();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Month e0(int i2) {
        return this.f21380d.z().p(i2);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public CharSequence f0(int i2) {
        return e0(i2).m();
    }

    /* access modifiers changed from: package-private */
    public int g0(@NonNull Month month) {
        return this.f21380d.z().v(month);
    }

    /* renamed from: h0 */
    public void R(@NonNull ViewHolder viewHolder, int i2) {
        Month p = this.f21380d.z().p(i2);
        viewHolder.I.setText(p.m());
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder.J.findViewById(R.id.Z2);
        if (materialCalendarGridView.getAdapter() == null || !p.equals(materialCalendarGridView.getAdapter().s)) {
            MonthAdapter monthAdapter = new MonthAdapter(p, this.f21381e, this.f21380d, this.f21382f);
            materialCalendarGridView.setNumColumns(p.Z);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().q(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                if (materialCalendarGridView.getAdapter().r(i2)) {
                    MonthsPagerAdapter.this.f21383g.a(materialCalendarGridView.getAdapter().getItem(i2).longValue());
                }
            }
        });
    }

    @NonNull
    /* renamed from: i0 */
    public ViewHolder T(@NonNull ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.z0, viewGroup, false);
        if (!MaterialDatePicker.E3(viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f21384h));
        return new ViewHolder(linearLayout, true);
    }
}
