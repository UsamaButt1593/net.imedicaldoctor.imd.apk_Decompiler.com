package com.prolificinteractive.materialcalendarview;

import android.animation.Animator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;

class TitleChanger {

    /* renamed from: j  reason: collision with root package name */
    public static final int f28136j = 400;

    /* renamed from: k  reason: collision with root package name */
    public static final int f28137k = 20;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final TextView f28138a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private TitleFormatter f28139b = TitleFormatter.f28157b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28140c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final int f28141d;

    /* renamed from: e  reason: collision with root package name */
    private final int f28142e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Interpolator f28143f = new DecelerateInterpolator(2.0f);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f28144g = 0;

    /* renamed from: h  reason: collision with root package name */
    private long f28145h = 0;

    /* renamed from: i  reason: collision with root package name */
    private CalendarDay f28146i = null;

    public TitleChanger(TextView textView) {
        this.f28138a = textView;
        Resources resources = textView.getResources();
        this.f28140c = 400;
        this.f28141d = resources.getInteger(17694720) / 2;
        this.f28142e = (int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics());
    }

    private void g(long j2, CalendarDay calendarDay, boolean z) {
        this.f28138a.animate().cancel();
        h(this.f28138a, 0);
        this.f28138a.setAlpha(1.0f);
        this.f28145h = j2;
        final CharSequence a2 = this.f28139b.a(calendarDay);
        if (!z) {
            this.f28138a.setText(a2);
        } else {
            final int i2 = this.f28142e * (this.f28146i.m(calendarDay) ? 1 : -1);
            ViewPropertyAnimator animate = this.f28138a.animate();
            if (this.f28144g == 1) {
                animate.translationX((float) (i2 * -1));
            } else {
                animate.translationY((float) (i2 * -1));
            }
            animate.alpha(0.0f).setDuration((long) this.f28141d).setInterpolator(this.f28143f).setListener(new AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                    TitleChanger titleChanger = TitleChanger.this;
                    titleChanger.h(titleChanger.f28138a, 0);
                    TitleChanger.this.f28138a.setAlpha(1.0f);
                }

                public void onAnimationEnd(Animator animator) {
                    TitleChanger.this.f28138a.setText(a2);
                    TitleChanger titleChanger = TitleChanger.this;
                    titleChanger.h(titleChanger.f28138a, i2);
                    ViewPropertyAnimator animate = TitleChanger.this.f28138a.animate();
                    if (TitleChanger.this.f28144g == 1) {
                        animate.translationX(0.0f);
                    } else {
                        animate.translationY(0.0f);
                    }
                    animate.alpha(1.0f).setDuration((long) TitleChanger.this.f28141d).setInterpolator(TitleChanger.this.f28143f).setListener(new AnimatorListener()).start();
                }
            }).start();
        }
        this.f28146i = calendarDay;
    }

    /* access modifiers changed from: private */
    public void h(TextView textView, int i2) {
        float f2 = (float) i2;
        if (this.f28144g == 1) {
            textView.setTranslationX(f2);
        } else {
            textView.setTranslationY(f2);
        }
    }

    public void f(CalendarDay calendarDay) {
        long currentTimeMillis = System.currentTimeMillis();
        if (calendarDay != null) {
            if (TextUtils.isEmpty(this.f28138a.getText()) || currentTimeMillis - this.f28145h < ((long) this.f28140c)) {
                g(currentTimeMillis, calendarDay, false);
            }
            if (calendarDay.equals(this.f28146i)) {
                return;
            }
            if (calendarDay.g() != this.f28146i.g() || calendarDay.j() != this.f28146i.j()) {
                g(currentTimeMillis, calendarDay, true);
            }
        }
    }

    public int i() {
        return this.f28144g;
    }

    public void j(int i2) {
        this.f28144g = i2;
    }

    public void k(CalendarDay calendarDay) {
        this.f28146i = calendarDay;
    }

    public void l(@Nullable TitleFormatter titleFormatter) {
        if (titleFormatter == null) {
            titleFormatter = TitleFormatter.f28157b;
        }
        this.f28139b = titleFormatter;
    }
}
