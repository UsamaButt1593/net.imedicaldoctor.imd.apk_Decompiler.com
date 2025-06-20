package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class k implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateHandle f8711a;

    public /* synthetic */ k(SavedStateHandle savedStateHandle) {
        this.f8711a = savedStateHandle;
    }

    public final Bundle a() {
        return SavedStateHandle.p(this.f8711a);
    }
}
