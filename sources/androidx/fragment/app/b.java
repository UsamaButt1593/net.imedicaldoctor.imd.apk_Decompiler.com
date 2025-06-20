package androidx.fragment.app;

import android.content.res.Configuration;
import androidx.core.util.Consumer;

public final /* synthetic */ class b implements Consumer {
    public final /* synthetic */ FragmentActivity s;

    public /* synthetic */ b(FragmentActivity fragmentActivity) {
        this.s = fragmentActivity;
    }

    public final void accept(Object obj) {
        this.s.o0((Configuration) obj);
    }
}
