package androidx.lifecycle;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ ComputableLiveData s;

    public /* synthetic */ a(ComputableLiveData computableLiveData) {
        this.s = computableLiveData;
    }

    public final void run() {
        ComputableLiveData.l(this.s);
    }
}
