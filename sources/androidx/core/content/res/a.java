package androidx.core.content.res;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Typeface X;
    public final /* synthetic */ ResourcesCompat.FontCallback s;

    public /* synthetic */ a(ResourcesCompat.FontCallback fontCallback, Typeface typeface) {
        this.s = fontCallback;
        this.X = typeface;
    }

    public final void run() {
        this.s.g(this.X);
    }
}
