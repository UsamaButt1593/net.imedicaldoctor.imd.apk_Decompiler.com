package androidx.emoji2.text;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class a implements Executor {
    public final /* synthetic */ Handler s;

    public /* synthetic */ a(Handler handler) {
        this.s = handler;
    }

    public final void execute(Runnable runnable) {
        this.s.post(runnable);
    }
}
