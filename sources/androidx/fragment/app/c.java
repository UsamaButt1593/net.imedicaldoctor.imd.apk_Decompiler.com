package androidx.fragment.app;

import android.content.Intent;
import androidx.core.util.Consumer;

public final /* synthetic */ class c implements Consumer {
    public final /* synthetic */ FragmentActivity s;

    public /* synthetic */ c(FragmentActivity fragmentActivity) {
        this.s = fragmentActivity;
    }

    public final void accept(Object obj) {
        this.s.p0((Intent) obj);
    }
}
