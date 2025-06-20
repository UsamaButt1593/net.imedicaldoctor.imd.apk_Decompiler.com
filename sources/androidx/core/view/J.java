package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

public final /* synthetic */ class J implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f6419a;

    public /* synthetic */ J(ViewConfiguration viewConfiguration) {
        this.f6419a = viewConfiguration;
    }

    public final Object get() {
        return Integer.valueOf(this.f6419a.getScaledMaximumFlingVelocity());
    }
}
