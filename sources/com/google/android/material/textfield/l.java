package com.google.android.material.textfield;

import androidx.core.view.accessibility.AccessibilityManagerCompat;

public final /* synthetic */ class l implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f22066a;

    public /* synthetic */ l(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f22066a = dropdownMenuEndIconDelegate;
    }

    public final void onTouchExplorationStateChanged(boolean z) {
        this.f22066a.L(z);
    }
}
