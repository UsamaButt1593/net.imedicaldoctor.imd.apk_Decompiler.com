package com.prolificinteractive.materialcalendarview.format;

import android.text.SpannableStringBuilder;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import org.apache.commons.lang3.StringUtils;

public class MonthArrayTitleFormatter implements TitleFormatter {

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence[] f28155c;

    public MonthArrayTitleFormatter(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            throw new IllegalArgumentException("Label array cannot be null");
        } else if (charSequenceArr.length >= 12) {
            this.f28155c = charSequenceArr;
        } else {
            throw new IllegalArgumentException("Label array is too short");
        }
    }

    public CharSequence a(CalendarDay calendarDay) {
        return new SpannableStringBuilder().append(this.f28155c[calendarDay.g() - 1]).append(StringUtils.SPACE).append(String.valueOf(calendarDay.j()));
    }
}
