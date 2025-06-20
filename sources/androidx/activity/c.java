package androidx.activity;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class c implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f2459a;

    public /* synthetic */ c(ComponentActivity componentActivity) {
        this.f2459a = componentActivity;
    }

    public final Bundle a() {
        return this.f2459a.c0();
    }
}
