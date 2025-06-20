package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialTextInputPicker<S> extends PickerFragment<S> {
    private static final String i4 = "THEME_RES_ID_KEY";
    private static final String j4 = "DATE_SELECTOR_KEY";
    private static final String k4 = "CALENDAR_CONSTRAINTS_KEY";
    @StyleRes
    private int f4;
    @Nullable
    private DateSelector<S> g4;
    @Nullable
    private CalendarConstraints h4;

    @NonNull
    static <T> MaterialTextInputPicker<T> N2(DateSelector<T> dateSelector, @StyleRes int i2, @NonNull CalendarConstraints calendarConstraints) {
        MaterialTextInputPicker<T> materialTextInputPicker = new MaterialTextInputPicker<>();
        Bundle bundle = new Bundle();
        bundle.putInt(i4, i2);
        bundle.putParcelable(j4, dateSelector);
        bundle.putParcelable(k4, calendarConstraints);
        materialTextInputPicker.i2(bundle);
        return materialTextInputPicker;
    }

    @NonNull
    public DateSelector<S> L2() {
        DateSelector<S> dateSelector = this.g4;
        if (dateSelector != null) {
            return dateSelector;
        }
        throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
    }

    public void Q0(@Nullable Bundle bundle) {
        super.Q0(bundle);
        if (bundle == null) {
            bundle = y();
        }
        this.f4 = bundle.getInt(i4);
        this.g4 = (DateSelector) bundle.getParcelable(j4);
        this.h4 = (CalendarConstraints) bundle.getParcelable(k4);
    }

    @NonNull
    public View U0(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.g4.r(layoutInflater.cloneInContext(new ContextThemeWrapper(B(), this.f4)), viewGroup, bundle, this.h4, new OnSelectionChangedListener<S>() {
            public void a() {
                Iterator<OnSelectionChangedListener<S>> it2 = MaterialTextInputPicker.this.e4.iterator();
                while (it2.hasNext()) {
                    it2.next().a();
                }
            }

            public void b(S s) {
                Iterator<OnSelectionChangedListener<S>> it2 = MaterialTextInputPicker.this.e4.iterator();
                while (it2.hasNext()) {
                    it2.next().b(s);
                }
            }
        });
    }

    public void m1(@NonNull Bundle bundle) {
        super.m1(bundle);
        bundle.putInt(i4, this.f4);
        bundle.putParcelable(j4, this.g4);
        bundle.putParcelable(k4, this.h4);
    }
}
