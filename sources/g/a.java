package g;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.tracing.ComponentMonitor;

public final /* synthetic */ class a implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f28326a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Component f28327b;

    public /* synthetic */ a(String str, Component component) {
        this.f28326a = str;
        this.f28327b = component;
    }

    public final Object a(ComponentContainer componentContainer) {
        return ComponentMonitor.c(this.f28326a, this.f28327b, componentContainer);
    }
}
