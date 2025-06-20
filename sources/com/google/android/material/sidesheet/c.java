package com.google.android.material.sidesheet;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;

public final /* synthetic */ class c implements AccessibilityViewCommand {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f21927a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f21928b;

    public /* synthetic */ c(SideSheetBehavior sideSheetBehavior, int i2) {
        this.f21927a = sideSheetBehavior;
        this.f21928b = i2;
    }

    public final boolean a(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return this.f21927a.K0(this.f21928b, view, commandArguments);
    }
}
