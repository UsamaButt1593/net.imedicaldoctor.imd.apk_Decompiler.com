package com.google.android.material.datepicker;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ String X;
    public final /* synthetic */ DateFormatTextWatcher s;

    public /* synthetic */ a(DateFormatTextWatcher dateFormatTextWatcher, String str) {
        this.s = dateFormatTextWatcher;
        this.X = str;
    }

    public final void run() {
        this.s.e(this.X);
    }
}
