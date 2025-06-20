package com.google.android.material.datepicker;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ long X;
    public final /* synthetic */ DateFormatTextWatcher s;

    public /* synthetic */ b(DateFormatTextWatcher dateFormatTextWatcher, long j2) {
        this.s = dateFormatTextWatcher;
        this.X = j2;
    }

    public final void run() {
        this.s.d(this.X);
    }
}
