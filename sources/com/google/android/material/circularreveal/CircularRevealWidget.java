package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.math.MathUtils;

public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {

        /* renamed from: b  reason: collision with root package name */
        public static final TypeEvaluator<RevealInfo> f21005b = new CircularRevealEvaluator();

        /* renamed from: a  reason: collision with root package name */
        private final RevealInfo f21006a = new RevealInfo();

        @NonNull
        /* renamed from: a */
        public RevealInfo evaluate(float f2, @NonNull RevealInfo revealInfo, @NonNull RevealInfo revealInfo2) {
            this.f21006a.b(MathUtils.f(revealInfo.f21010a, revealInfo2.f21010a, f2), MathUtils.f(revealInfo.f21011b, revealInfo2.f21011b, f2), MathUtils.f(revealInfo.f21012c, revealInfo2.f21012c, f2));
            return this.f21006a;
        }
    }

    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<CircularRevealWidget, RevealInfo> f21007a = new CircularRevealProperty("circularReveal");

        private CircularRevealProperty(String str) {
            super(RevealInfo.class, str);
        }

        @Nullable
        /* renamed from: a */
        public RevealInfo get(@NonNull CircularRevealWidget circularRevealWidget) {
            return circularRevealWidget.getRevealInfo();
        }

        /* renamed from: b */
        public void set(@NonNull CircularRevealWidget circularRevealWidget, @Nullable RevealInfo revealInfo) {
            circularRevealWidget.setRevealInfo(revealInfo);
        }
    }

    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<CircularRevealWidget, Integer> f21008a = new CircularRevealScrimColorProperty("circularRevealScrimColor");

        private CircularRevealScrimColorProperty(String str) {
            super(Integer.class, str);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull CircularRevealWidget circularRevealWidget) {
            return Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
        }

        /* renamed from: b */
        public void set(@NonNull CircularRevealWidget circularRevealWidget, @NonNull Integer num) {
            circularRevealWidget.setCircularRevealScrimColor(num.intValue());
        }
    }

    public static class RevealInfo {

        /* renamed from: d  reason: collision with root package name */
        public static final float f21009d = Float.MAX_VALUE;

        /* renamed from: a  reason: collision with root package name */
        public float f21010a;

        /* renamed from: b  reason: collision with root package name */
        public float f21011b;

        /* renamed from: c  reason: collision with root package name */
        public float f21012c;

        private RevealInfo() {
        }

        public boolean a() {
            return this.f21012c == Float.MAX_VALUE;
        }

        public void b(float f2, float f3, float f4) {
            this.f21010a = f2;
            this.f21011b = f3;
            this.f21012c = f4;
        }

        public void c(@NonNull RevealInfo revealInfo) {
            b(revealInfo.f21010a, revealInfo.f21011b, revealInfo.f21012c);
        }

        public RevealInfo(float f2, float f3, float f4) {
            this.f21010a = f2;
            this.f21011b = f3;
            this.f21012c = f4;
        }

        public RevealInfo(@NonNull RevealInfo revealInfo) {
            this(revealInfo.f21010a, revealInfo.f21011b, revealInfo.f21012c);
        }
    }

    void a();

    void b();

    void draw(Canvas canvas);

    @Nullable
    Drawable getCircularRevealOverlayDrawable();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    RevealInfo getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(@ColorInt int i2);

    void setRevealInfo(@Nullable RevealInfo revealInfo);
}
