package com.google.firebase.tracing;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRegistrarProcessor;
import g.a;
import java.util.ArrayList;
import java.util.List;

public class ComponentMonitor implements ComponentRegistrarProcessor {
    /* access modifiers changed from: private */
    public static /* synthetic */ Object c(String str, Component component, ComponentContainer componentContainer) {
        try {
            FirebaseTrace.b(str);
            return component.k().a(componentContainer);
        } finally {
            FirebaseTrace.a();
        }
    }

    public List<Component<?>> a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (Component next : componentRegistrar.getComponents()) {
            String l2 = next.l();
            if (l2 != null) {
                next = next.E(new a(l2, next));
            }
            arrayList.add(next);
        }
        return arrayList;
    }
}
