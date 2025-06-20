package androidx.core.location;

import android.location.Location;
import java.util.function.Consumer;

public final /* synthetic */ class s implements Consumer {
    public final /* synthetic */ androidx.core.util.Consumer s;

    public /* synthetic */ s(androidx.core.util.Consumer consumer) {
        this.s = consumer;
    }

    public final void accept(Object obj) {
        this.s.accept((Location) obj);
    }
}
