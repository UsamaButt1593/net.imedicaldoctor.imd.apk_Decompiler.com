package com.prolificinteractive.materialcalendarview;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;
import org.threeten.bp.DayOfWeek;

@SuppressLint({"ViewConstructor"})
class WeekDayView extends AppCompatTextView {
    private WeekDayFormatter d3 = WeekDayFormatter.f28158a;
    private DayOfWeek e3;

    public WeekDayView(Context context, DayOfWeek dayOfWeek) {
        super(context);
        setGravity(17);
        setTextAlignment(4);
        v(dayOfWeek);
    }

    public void v(DayOfWeek dayOfWeek) {
        this.e3 = dayOfWeek;
        setText(this.d3.a(dayOfWeek));
    }

    public void w(@Nullable WeekDayFormatter weekDayFormatter) {
        if (weekDayFormatter == null) {
            weekDayFormatter = WeekDayFormatter.f28158a;
        }
        this.d3 = weekDayFormatter;
        v(this.e3);
    }
}
