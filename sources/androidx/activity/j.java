package androidx.activity;

public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ FullyDrawnReporter s;

    public /* synthetic */ j(FullyDrawnReporter fullyDrawnReporter) {
        this.s = fullyDrawnReporter;
    }

    public final void run() {
        FullyDrawnReporter.i(this.s);
    }
}
