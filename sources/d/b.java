package d;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ Violation X;
    public final /* synthetic */ String s;

    public /* synthetic */ b(String str, Violation violation) {
        this.s = str;
        this.X = violation;
    }

    public final void run() {
        FragmentStrictMode.g(this.s, this.X);
    }
}
