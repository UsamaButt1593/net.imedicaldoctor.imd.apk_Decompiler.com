package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class a implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f8051a;

    public /* synthetic */ a(FragmentActivity fragmentActivity) {
        this.f8051a = fragmentActivity;
    }

    public final Bundle a() {
        return this.f8051a.n0();
    }
}
