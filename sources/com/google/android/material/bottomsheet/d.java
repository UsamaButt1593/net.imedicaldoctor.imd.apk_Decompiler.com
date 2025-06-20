package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;

public final /* synthetic */ class d implements AccessibilityViewCommand {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomSheetDragHandleView f20878a;

    public /* synthetic */ d(BottomSheetDragHandleView bottomSheetDragHandleView) {
        this.f20878a = bottomSheetDragHandleView;
    }

    public final boolean a(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return this.f20878a.j(view, commandArguments);
    }
}
