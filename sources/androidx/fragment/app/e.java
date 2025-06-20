package androidx.fragment.app;

import android.content.res.Configuration;
import androidx.core.util.Consumer;

public final /* synthetic */ class e implements Consumer {
    public final /* synthetic */ FragmentManager s;

    public /* synthetic */ e(FragmentManager fragmentManager) {
        this.s = fragmentManager;
    }

    public final void accept(Object obj) {
        this.s.f1((Configuration) obj);
    }
}
