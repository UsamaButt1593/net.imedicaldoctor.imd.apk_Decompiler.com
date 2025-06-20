package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final /* synthetic */ class u implements Runnable {
    public final /* synthetic */ Location X;
    public final /* synthetic */ Consumer s;

    public /* synthetic */ u(Consumer consumer, Location location) {
        this.s = consumer;
        this.X = location;
    }

    public final void run() {
        this.s.accept(this.X);
    }
}
