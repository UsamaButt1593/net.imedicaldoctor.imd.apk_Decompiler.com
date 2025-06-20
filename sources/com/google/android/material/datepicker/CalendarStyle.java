package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;

final class CalendarStyle {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final CalendarItemStyle f21341a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final CalendarItemStyle f21342b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final CalendarItemStyle f21343c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    final CalendarItemStyle f21344d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    final CalendarItemStyle f21345e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    final CalendarItemStyle f21346f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    final CalendarItemStyle f21347g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    final Paint f21348h;

    CalendarStyle(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.g(context, R.attr.Ac, MaterialCalendar.class.getCanonicalName()), R.styleable.Fm);
        this.f21341a = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.Km, 0));
        this.f21347g = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.Im, 0));
        this.f21342b = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.Jm, 0));
        this.f21343c = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.Lm, 0));
        ColorStateList a2 = MaterialResources.a(context, obtainStyledAttributes, R.styleable.Nm);
        this.f21344d = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.Pm, 0));
        this.f21345e = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.Om, 0));
        this.f21346f = CalendarItemStyle.a(context, obtainStyledAttributes.getResourceId(R.styleable.Qm, 0));
        Paint paint = new Paint();
        this.f21348h = paint;
        paint.setColor(a2.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
