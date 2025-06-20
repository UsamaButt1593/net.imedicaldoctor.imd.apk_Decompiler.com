package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import com.google.android.material.R;

public class Slider extends BaseSlider<Slider, OnChangeListener, OnSliderTouchListener> {

    public interface OnChangeListener extends BaseOnChangeListener<Slider> {
        /* bridge */ /* synthetic */ void a(@NonNull Object obj, float f2, boolean z);

        void c(@NonNull Slider slider, float f2, boolean z);
    }

    public interface OnSliderTouchListener extends BaseOnSliderTouchListener<Slider> {
        /* bridge */ /* synthetic */ void a(@NonNull Object obj);

        /* bridge */ /* synthetic */ void b(@NonNull Object obj);

        void c(@NonNull Slider slider);

        void e(@NonNull Slider slider);
    }

    public Slider(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public /* bridge */ /* synthetic */ boolean O() {
        return super.O();
    }

    public /* bridge */ /* synthetic */ boolean X() {
        return super.X();
    }

    public /* bridge */ /* synthetic */ boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return super.dispatchHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @NonNull
    public /* bridge */ /* synthetic */ CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    public /* bridge */ /* synthetic */ int getActiveThumbIndex() {
        return super.getActiveThumbIndex();
    }

    public /* bridge */ /* synthetic */ int getFocusedThumbIndex() {
        return super.getFocusedThumbIndex();
    }

    @Px
    public /* bridge */ /* synthetic */ int getHaloRadius() {
        return super.getHaloRadius();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getHaloTintList() {
        return super.getHaloTintList();
    }

    public /* bridge */ /* synthetic */ int getLabelBehavior() {
        return super.getLabelBehavior();
    }

    public /* bridge */ /* synthetic */ float getStepSize() {
        return super.getStepSize();
    }

    public /* bridge */ /* synthetic */ float getThumbElevation() {
        return super.getThumbElevation();
    }

    @Px
    public /* bridge */ /* synthetic */ int getThumbHeight() {
        return super.getThumbHeight();
    }

    @Px
    public /* bridge */ /* synthetic */ int getThumbRadius() {
        return super.getThumbRadius();
    }

    public /* bridge */ /* synthetic */ ColorStateList getThumbStrokeColor() {
        return super.getThumbStrokeColor();
    }

    public /* bridge */ /* synthetic */ float getThumbStrokeWidth() {
        return super.getThumbStrokeWidth();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getThumbTintList() {
        return super.getThumbTintList();
    }

    public /* bridge */ /* synthetic */ int getThumbTrackGapSize() {
        return super.getThumbTrackGapSize();
    }

    @Px
    public /* bridge */ /* synthetic */ int getThumbWidth() {
        return super.getThumbWidth();
    }

    @Px
    public /* bridge */ /* synthetic */ int getTickActiveRadius() {
        return super.getTickActiveRadius();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickActiveTintList() {
        return super.getTickActiveTintList();
    }

    @Px
    public /* bridge */ /* synthetic */ int getTickInactiveRadius() {
        return super.getTickInactiveRadius();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickInactiveTintList() {
        return super.getTickInactiveTintList();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTickTintList() {
        return super.getTickTintList();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackActiveTintList() {
        return super.getTrackActiveTintList();
    }

    @Px
    public /* bridge */ /* synthetic */ int getTrackHeight() {
        return super.getTrackHeight();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackInactiveTintList() {
        return super.getTrackInactiveTintList();
    }

    public /* bridge */ /* synthetic */ int getTrackInsideCornerSize() {
        return super.getTrackInsideCornerSize();
    }

    @Px
    public /* bridge */ /* synthetic */ int getTrackSidePadding() {
        return super.getTrackSidePadding();
    }

    public /* bridge */ /* synthetic */ int getTrackStopIndicatorSize() {
        return super.getTrackStopIndicatorSize();
    }

    @NonNull
    public /* bridge */ /* synthetic */ ColorStateList getTrackTintList() {
        return super.getTrackTintList();
    }

    @Px
    public /* bridge */ /* synthetic */ int getTrackWidth() {
        return super.getTrackWidth();
    }

    public float getValue() {
        return getValues().get(0).floatValue();
    }

    public /* bridge */ /* synthetic */ float getValueFrom() {
        return super.getValueFrom();
    }

    public /* bridge */ /* synthetic */ float getValueTo() {
        return super.getValueTo();
    }

    public /* bridge */ /* synthetic */ void h(@NonNull BaseOnChangeListener baseOnChangeListener) {
        super.h(baseOnChangeListener);
    }

    public /* bridge */ /* synthetic */ void i(@NonNull BaseOnSliderTouchListener baseOnSliderTouchListener) {
        super.i(baseOnSliderTouchListener);
    }

    /* access modifiers changed from: protected */
    public boolean l0() {
        if (getActiveThumbIndex() != -1) {
            return true;
        }
        setActiveThumbIndex(0);
        return true;
    }

    public /* bridge */ /* synthetic */ void o0(@NonNull BaseOnChangeListener baseOnChangeListener) {
        super.o0(baseOnChangeListener);
    }

    public /* bridge */ /* synthetic */ boolean onKeyDown(int i2, @NonNull KeyEvent keyEvent) {
        return super.onKeyDown(i2, keyEvent);
    }

    public /* bridge */ /* synthetic */ boolean onKeyUp(int i2, @NonNull KeyEvent keyEvent) {
        return super.onKeyUp(i2, keyEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void p() {
        super.p();
    }

    public /* bridge */ /* synthetic */ void p0(@NonNull BaseOnSliderTouchListener baseOnSliderTouchListener) {
        super.p0(baseOnSliderTouchListener);
    }

    public /* bridge */ /* synthetic */ void q() {
        super.q();
    }

    public void setCustomThumbDrawable(@DrawableRes int i2) {
        super.setCustomThumbDrawable(i2);
    }

    public /* bridge */ /* synthetic */ void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    public /* bridge */ /* synthetic */ void setFocusedThumbIndex(int i2) {
        super.setFocusedThumbIndex(i2);
    }

    public /* bridge */ /* synthetic */ void setHaloRadius(@Px @IntRange(from = 0) int i2) {
        super.setHaloRadius(i2);
    }

    public /* bridge */ /* synthetic */ void setHaloRadiusResource(@DimenRes int i2) {
        super.setHaloRadiusResource(i2);
    }

    public /* bridge */ /* synthetic */ void setHaloTintList(@NonNull ColorStateList colorStateList) {
        super.setHaloTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setLabelBehavior(int i2) {
        super.setLabelBehavior(i2);
    }

    public /* bridge */ /* synthetic */ void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        super.setLabelFormatter(labelFormatter);
    }

    public /* bridge */ /* synthetic */ void setStepSize(float f2) {
        super.setStepSize(f2);
    }

    public /* bridge */ /* synthetic */ void setThumbElevation(float f2) {
        super.setThumbElevation(f2);
    }

    public /* bridge */ /* synthetic */ void setThumbElevationResource(@DimenRes int i2) {
        super.setThumbElevationResource(i2);
    }

    public /* bridge */ /* synthetic */ void setThumbHeight(@Px @IntRange(from = 0) int i2) {
        super.setThumbHeight(i2);
    }

    public /* bridge */ /* synthetic */ void setThumbHeightResource(@DimenRes int i2) {
        super.setThumbHeightResource(i2);
    }

    public /* bridge */ /* synthetic */ void setThumbRadius(@Px @IntRange(from = 0) int i2) {
        super.setThumbRadius(i2);
    }

    public /* bridge */ /* synthetic */ void setThumbRadiusResource(@DimenRes int i2) {
        super.setThumbRadiusResource(i2);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        super.setThumbStrokeColor(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeColorResource(@ColorRes int i2) {
        super.setThumbStrokeColorResource(i2);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeWidth(float f2) {
        super.setThumbStrokeWidth(f2);
    }

    public /* bridge */ /* synthetic */ void setThumbStrokeWidthResource(@DimenRes int i2) {
        super.setThumbStrokeWidthResource(i2);
    }

    public /* bridge */ /* synthetic */ void setThumbTintList(@NonNull ColorStateList colorStateList) {
        super.setThumbTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setThumbTrackGapSize(@Px int i2) {
        super.setThumbTrackGapSize(i2);
    }

    public /* bridge */ /* synthetic */ void setThumbWidth(@Px @IntRange(from = 0) int i2) {
        super.setThumbWidth(i2);
    }

    public /* bridge */ /* synthetic */ void setThumbWidthResource(@DimenRes int i2) {
        super.setThumbWidthResource(i2);
    }

    public /* bridge */ /* synthetic */ void setTickActiveRadius(@Px @IntRange(from = 0) int i2) {
        super.setTickActiveRadius(i2);
    }

    public /* bridge */ /* synthetic */ void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickActiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickInactiveRadius(@Px @IntRange(from = 0) int i2) {
        super.setTickInactiveRadius(i2);
    }

    public /* bridge */ /* synthetic */ void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTickInactiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickTintList(@NonNull ColorStateList colorStateList) {
        super.setTickTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTickVisible(boolean z) {
        super.setTickVisible(z);
    }

    public /* bridge */ /* synthetic */ void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackActiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTrackHeight(@Px @IntRange(from = 0) int i2) {
        super.setTrackHeight(i2);
    }

    public /* bridge */ /* synthetic */ void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackInactiveTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTrackInsideCornerSize(@Px int i2) {
        super.setTrackInsideCornerSize(i2);
    }

    public /* bridge */ /* synthetic */ void setTrackStopIndicatorSize(@Px int i2) {
        super.setTrackStopIndicatorSize(i2);
    }

    public /* bridge */ /* synthetic */ void setTrackTintList(@NonNull ColorStateList colorStateList) {
        super.setTrackTintList(colorStateList);
    }

    public void setValue(float f2) {
        setValues(Float.valueOf(f2));
    }

    public /* bridge */ /* synthetic */ void setValueFrom(float f2) {
        super.setValueFrom(f2);
    }

    public /* bridge */ /* synthetic */ void setValueTo(float f2) {
        super.setValueTo(f2);
    }

    public Slider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Gg);
    }

    public void setCustomThumbDrawable(@NonNull Drawable drawable) {
        super.setCustomThumbDrawable(drawable);
    }

    public Slider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842788});
        if (obtainStyledAttributes.hasValue(0)) {
            setValue(obtainStyledAttributes.getFloat(0, 0.0f));
        }
        obtainStyledAttributes.recycle();
    }
}
