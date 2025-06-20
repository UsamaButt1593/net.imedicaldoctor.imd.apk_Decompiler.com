package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.view.KeyEventDispatcher;

public final /* synthetic */ class r implements KeyEventDispatcher.Component {
    public final /* synthetic */ AppCompatDialog s;

    public /* synthetic */ r(AppCompatDialog appCompatDialog) {
        this.s = appCompatDialog;
    }

    public final boolean B(KeyEvent keyEvent) {
        return this.s.n(keyEvent);
    }
}
