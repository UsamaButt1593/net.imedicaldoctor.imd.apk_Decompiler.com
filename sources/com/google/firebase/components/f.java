package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

public final /* synthetic */ class f {
    public static Object a(ComponentContainer componentContainer, Qualified qualified) {
        Provider b2 = componentContainer.b(qualified);
        if (b2 == null) {
            return null;
        }
        return b2.get();
    }

    public static Object b(ComponentContainer componentContainer, Class cls) {
        return componentContainer.h(Qualified.b(cls));
    }

    public static Deferred c(ComponentContainer componentContainer, Class cls) {
        return componentContainer.j(Qualified.b(cls));
    }

    public static Provider d(ComponentContainer componentContainer, Class cls) {
        return componentContainer.b(Qualified.b(cls));
    }

    public static Set e(ComponentContainer componentContainer, Qualified qualified) {
        return (Set) componentContainer.g(qualified).get();
    }

    public static Set f(ComponentContainer componentContainer, Class cls) {
        return componentContainer.f(Qualified.b(cls));
    }

    public static Provider g(ComponentContainer componentContainer, Class cls) {
        return componentContainer.g(Qualified.b(cls));
    }
}
