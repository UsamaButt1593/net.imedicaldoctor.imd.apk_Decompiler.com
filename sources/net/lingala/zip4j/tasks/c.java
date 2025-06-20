package net.lingala.zip4j.tasks;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ Object X;
    public final /* synthetic */ AsyncZipTask s;

    public /* synthetic */ c(AsyncZipTask asyncZipTask, Object obj) {
        this.s = asyncZipTask;
        this.X = obj;
    }

    public final void run() {
        this.s.f(this.X);
    }
}
