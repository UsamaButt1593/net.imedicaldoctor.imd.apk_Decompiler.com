package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

abstract class PickerFragment<S> extends Fragment {
    protected final LinkedHashSet<OnSelectionChangedListener<S>> e4 = new LinkedHashSet<>();

    PickerFragment() {
    }

    /* access modifiers changed from: package-private */
    public boolean J2(OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.e4.add(onSelectionChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void K2() {
        this.e4.clear();
    }

    /* access modifiers changed from: package-private */
    public abstract DateSelector<S> L2();

    /* access modifiers changed from: package-private */
    public boolean M2(OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.e4.remove(onSelectionChangedListener);
    }
}
