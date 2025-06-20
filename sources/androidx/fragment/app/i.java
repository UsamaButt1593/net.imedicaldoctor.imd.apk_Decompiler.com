package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class i implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f8053a;

    public /* synthetic */ i(FragmentManager fragmentManager) {
        this.f8053a = fragmentManager;
    }

    public final Bundle a() {
        return this.f8053a.e1();
    }
}
