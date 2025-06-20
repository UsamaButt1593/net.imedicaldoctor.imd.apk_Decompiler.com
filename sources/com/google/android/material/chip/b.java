package com.google.android.material.chip;

import android.widget.CompoundButton;

public final /* synthetic */ class b implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Chip f20990a;

    public /* synthetic */ b(Chip chip) {
        this.f20990a = chip;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f20990a.z(compoundButton, z);
    }
}
