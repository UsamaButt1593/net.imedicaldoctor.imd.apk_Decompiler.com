package net.imedicaldoctor.imd.Fragments;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ String X;
    public final /* synthetic */ ViewerHelperFragment s;

    public /* synthetic */ b(ViewerHelperFragment viewerHelperFragment, String str) {
        this.s = viewerHelperFragment;
        this.X = str;
    }

    public final void run() {
        this.s.L3(this.X);
    }
}
