package androidx.fragment.app;

import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.util.Consumer;

public final /* synthetic */ class g implements Consumer {
    public final /* synthetic */ FragmentManager s;

    public /* synthetic */ g(FragmentManager fragmentManager) {
        this.s = fragmentManager;
    }

    public final void accept(Object obj) {
        this.s.h1((MultiWindowModeChangedInfo) obj);
    }
}
