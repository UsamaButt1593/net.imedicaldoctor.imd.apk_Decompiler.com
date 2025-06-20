package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import java.util.Iterator;
import java.util.Set;

public class DefaultUserAgentPublisher implements UserAgentPublisher {

    /* renamed from: a  reason: collision with root package name */
    private final String f24965a;

    /* renamed from: b  reason: collision with root package name */
    private final GlobalLibraryVersionRegistrar f24966b;

    DefaultUserAgentPublisher(Set<LibraryVersion> set, GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar) {
        this.f24965a = e(set);
        this.f24966b = globalLibraryVersionRegistrar;
    }

    public static Component<UserAgentPublisher> c() {
        return Component.h(UserAgentPublisher.class).b(Dependency.q(LibraryVersion.class)).f(new a()).d();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ UserAgentPublisher d(ComponentContainer componentContainer) {
        return new DefaultUserAgentPublisher(componentContainer.i(LibraryVersion.class), GlobalLibraryVersionRegistrar.a());
    }

    private static String e(Set<LibraryVersion> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<LibraryVersion> it2 = set.iterator();
        while (it2.hasNext()) {
            LibraryVersion next = it2.next();
            sb.append(next.b());
            sb.append('/');
            sb.append(next.c());
            if (it2.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public String a() {
        if (this.f24966b.b().isEmpty()) {
            return this.f24965a;
        }
        return this.f24965a + ' ' + e(this.f24966b.b());
    }
}
