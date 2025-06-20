package com.prolificinteractive.materialcalendarview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.format.DayFormatter;
import java.util.List;

@SuppressLint({"ViewConstructor"})
class DayView extends AppCompatCheckedTextView {
    private CalendarDay a3;
    private int b3 = -7829368;
    private final int c3;
    private Drawable d3 = null;
    private Drawable e3;
    private Drawable f3;
    private DayFormatter g3;
    private DayFormatter h3;
    private boolean i3;
    private boolean j3;
    private boolean k3;
    private int l3;
    private final Rect m3;
    private final Rect n3;

    public DayView(Context context, CalendarDay calendarDay) {
        super(context);
        DayFormatter dayFormatter = DayFormatter.f28154b;
        this.g3 = dayFormatter;
        this.h3 = dayFormatter;
        this.i3 = true;
        this.j3 = true;
        this.k3 = false;
        this.l3 = 4;
        this.m3 = new Rect();
        this.n3 = new Rect();
        this.c3 = getResources().getInteger(17694720);
        p(this.b3);
        setGravity(17);
        setTextAlignment(4);
        l(calendarDay);
    }

    private void c(int i2, int i4) {
        int min = Math.min(i4, i2);
        int abs = Math.abs(i4 - i2) / 2;
        int i5 = Build.VERSION.SDK_INT == 21 ? abs / 2 : abs;
        if (i2 >= i4) {
            this.m3.set(abs, 0, min + abs, i4);
            this.n3.set(i5, 0, min + i5, i4);
            return;
        }
        this.m3.set(0, abs, i2, min + abs);
        this.n3.set(0, i5, i2, min + i5);
    }

    private static Drawable d(int i2, int i4, Rect rect) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.setExitFadeDuration(i4);
        stateListDrawable.addState(new int[]{16842912}, e(i2));
        stateListDrawable.addState(new int[]{16842919}, f(i2, rect));
        stateListDrawable.addState(new int[0], e(0));
        return stateListDrawable;
    }

    private static Drawable e(int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(i2);
        return shapeDrawable;
    }

    @TargetApi(21)
    private static Drawable f(int i2, Rect rect) {
        RippleDrawable rippleDrawable = new RippleDrawable(ColorStateList.valueOf(i2), (Drawable) null, e(-1));
        int i4 = Build.VERSION.SDK_INT;
        if (i4 == 21) {
            rippleDrawable.setBounds(rect);
        }
        if (i4 == 22) {
            int i5 = (rect.left + rect.right) / 2;
            rippleDrawable.setHotspotBounds(i5, rect.top, i5, rect.bottom);
        }
        return rippleDrawable;
    }

    private void j() {
        Drawable drawable = this.e3;
        if (drawable == null) {
            drawable = d(this.b3, this.c3, this.n3);
            this.f3 = drawable;
        }
        setBackgroundDrawable(drawable);
    }

    private void o() {
        int i2 = 0;
        boolean z = true;
        boolean z2 = this.j3 && this.i3 && !this.k3;
        super.setEnabled(this.i3 && !this.k3);
        boolean T = MaterialCalendarView.T(this.l3);
        boolean z3 = MaterialCalendarView.U(this.l3) || T;
        boolean S = MaterialCalendarView.S(this.l3);
        boolean z4 = this.j3;
        if (!z4 && T) {
            z2 = true;
        }
        boolean z5 = this.i3;
        if (!z5 && z3) {
            z2 |= z4;
        }
        if (this.k3 && S) {
            if (!z4 || !z5) {
                z = false;
            }
            z2 |= z;
        }
        if (!z4 && z2) {
            setTextColor(getTextColors().getColorForState(new int[]{-16842910}, -7829368));
        }
        if (!z2) {
            i2 = 4;
        }
        setVisibility(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(DayViewFacade dayViewFacade) {
        this.k3 = dayViewFacade.c();
        o();
        k(dayViewFacade.d());
        q(dayViewFacade.e());
        List<DayViewFacade.Span> f2 = dayViewFacade.f();
        if (!f2.isEmpty()) {
            String i2 = i();
            SpannableString spannableString = new SpannableString(i());
            for (DayViewFacade.Span span : f2) {
                spannableString.setSpan(span.f27971a, 0, i2.length(), 33);
            }
            setText(spannableString);
            return;
        }
        setText(i());
    }

    @NonNull
    public String g() {
        DayFormatter dayFormatter = this.h3;
        if (dayFormatter == null) {
            dayFormatter = this.g3;
        }
        return dayFormatter.a(this.a3);
    }

    public CalendarDay h() {
        return this.a3;
    }

    @NonNull
    public String i() {
        return this.g3.a(this.a3);
    }

    public void k(Drawable drawable) {
        this.d3 = drawable == null ? null : drawable.getConstantState().newDrawable(getResources());
        invalidate();
    }

    public void l(CalendarDay calendarDay) {
        this.a3 = calendarDay;
        setText(i());
    }

    public void m(DayFormatter dayFormatter) {
        DayFormatter dayFormatter2 = this.h3;
        if (dayFormatter2 == this.g3) {
            dayFormatter2 = dayFormatter;
        }
        this.h3 = dayFormatter2;
        if (dayFormatter == null) {
            dayFormatter = DayFormatter.f28154b;
        }
        this.g3 = dayFormatter;
        CharSequence text = getText();
        Object[] spans = text instanceof Spanned ? ((Spanned) text).getSpans(0, text.length(), Object.class) : null;
        SpannableString spannableString = new SpannableString(i());
        if (spans != null) {
            for (Object span : spans) {
                spannableString.setSpan(span, 0, spannableString.length(), 33);
            }
        }
        setText(spannableString);
    }

    public void n(DayFormatter dayFormatter) {
        if (dayFormatter == null) {
            dayFormatter = this.g3;
        }
        this.h3 = dayFormatter;
        setContentDescription(g());
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        Drawable drawable = this.d3;
        if (drawable != null) {
            drawable.setBounds(this.m3);
            this.d3.setState(getDrawableState());
            this.d3.draw(canvas);
        }
        this.f3.setBounds(this.n3);
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        super.onLayout(z, i2, i4, i5, i6);
        c(i5 - i2, i6 - i4);
        j();
    }

    public void p(int i2) {
        this.b3 = i2;
        j();
    }

    public void q(Drawable drawable) {
        this.e3 = drawable == null ? null : drawable.getConstantState().newDrawable(getResources());
        j();
    }

    /* access modifiers changed from: protected */
    public void r(int i2, boolean z, boolean z2) {
        this.l3 = i2;
        this.j3 = z2;
        this.i3 = z;
        o();
    }
}
