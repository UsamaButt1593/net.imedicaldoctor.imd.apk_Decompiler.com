package androidx.lifecycle;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ ComputableLiveData s;

    public /* synthetic */ b(ComputableLiveData computableLiveData) {
        this.s = computableLiveData;
    }

    public final void run() {
        ComputableLiveData.k(this.s);
    }
}
