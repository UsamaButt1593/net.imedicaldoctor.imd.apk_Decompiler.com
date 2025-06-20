package androidx.profileinstaller;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int X;
    public final /* synthetic */ Object Y;
    public final /* synthetic */ DeviceProfileWriter s;

    public /* synthetic */ b(DeviceProfileWriter deviceProfileWriter, int i2, Object obj) {
        this.s = deviceProfileWriter;
        this.X = i2;
        this.Y = obj;
    }

    public final void run() {
        this.s.g(this.X, this.Y);
    }
}
