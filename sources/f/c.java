package f;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class c implements ComponentFactory {
    public final Object a(ComponentContainer componentContainer) {
        return TransportRuntime.f((Context) componentContainer.a(Context.class));
    }
}
