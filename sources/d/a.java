package d;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Violation X;
    public final /* synthetic */ FragmentStrictMode.Policy s;

    public /* synthetic */ a(FragmentStrictMode.Policy policy, Violation violation) {
        this.s = policy;
        this.X = violation;
    }

    public final void run() {
        FragmentStrictMode.f(this.s, this.X);
    }
}
