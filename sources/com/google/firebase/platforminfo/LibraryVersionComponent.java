package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;

public class LibraryVersionComponent {

    public interface VersionExtractor<T> {
        String a(T t);
    }

    private LibraryVersionComponent() {
    }

    public static Component<?> b(String str, String str2) {
        return Component.p(LibraryVersion.a(str, str2), LibraryVersion.class);
    }

    public static Component<?> c(String str, VersionExtractor<Context> versionExtractor) {
        return Component.r(LibraryVersion.class).b(Dependency.m(Context.class)).f(new b(str, versionExtractor)).d();
    }
}
