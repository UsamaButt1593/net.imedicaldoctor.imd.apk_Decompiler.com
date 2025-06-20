package androidx.activity;

import android.window.OnBackInvokedCallback;
import androidx.activity.OnBackPressedDispatcher;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class k implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f2465a;

    public /* synthetic */ k(Function0 function0) {
        this.f2465a = function0;
    }

    public final void onBackInvoked() {
        OnBackPressedDispatcher.Api33Impl.c(this.f2465a);
    }
}
