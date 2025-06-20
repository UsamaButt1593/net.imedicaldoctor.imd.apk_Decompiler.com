package androidx.transition;

import androidx.core.os.CancellationSignal;

public final /* synthetic */ class a implements CancellationSignal.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f16136a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Transition f16137b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f16138c;

    public /* synthetic */ a(Runnable runnable, Transition transition, Runnable runnable2) {
        this.f16136a = runnable;
        this.f16137b = transition;
        this.f16138c = runnable2;
    }

    public final void onCancel() {
        FragmentTransitionSupport.E(this.f16136a, this.f16137b, this.f16138c);
    }
}
