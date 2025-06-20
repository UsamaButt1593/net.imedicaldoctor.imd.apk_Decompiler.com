package com.google.android.material.search;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class v implements View.OnTouchListener {
    public final /* synthetic */ SearchView s;

    public /* synthetic */ v(SearchView searchView) {
        this.s = searchView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.s.K(view, motionEvent);
    }
}
