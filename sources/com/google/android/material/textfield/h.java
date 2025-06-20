package com.google.android.material.textfield;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class h implements View.OnTouchListener {
    public final /* synthetic */ DropdownMenuEndIconDelegate s;

    public /* synthetic */ h(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.s = dropdownMenuEndIconDelegate;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.s.M(view, motionEvent);
    }
}
