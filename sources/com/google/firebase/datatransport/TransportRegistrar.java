package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import f.a;
import f.b;
import f.c;
import java.util.Arrays;
import java.util.List;

@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    @NonNull
    public List<Component<?>> getComponents() {
        Class<TransportFactory> cls = TransportFactory.class;
        Class<Context> cls2 = Context.class;
        return Arrays.asList(new Component[]{Component.h(cls).h(LIBRARY_NAME).b(Dependency.m(cls2)).f(new a()).d(), Component.f(Qualified.a(LegacyTransportBackend.class, cls)).b(Dependency.m(cls2)).f(new b()).d(), Component.f(Qualified.a(TransportBackend.class, cls)).b(Dependency.m(cls2)).f(new c()).d(), LibraryVersionComponent.b(LIBRARY_NAME, BuildConfig.f24325d)});
    }
}
