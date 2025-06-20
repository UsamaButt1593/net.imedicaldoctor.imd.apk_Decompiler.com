package androidx.core.content.res;

import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int X;
    public final /* synthetic */ ResourcesCompat.FontCallback s;

    public /* synthetic */ b(ResourcesCompat.FontCallback fontCallback, int i2) {
        this.s = fontCallback;
        this.X = i2;
    }

    public final void run() {
        this.s.f(this.X);
    }
}
