package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GlobalLibraryVersionRegistrar {

    /* renamed from: b  reason: collision with root package name */
    private static volatile GlobalLibraryVersionRegistrar f24967b;

    /* renamed from: a  reason: collision with root package name */
    private final Set<LibraryVersion> f24968a = new HashSet();

    GlobalLibraryVersionRegistrar() {
    }

    public static GlobalLibraryVersionRegistrar a() {
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = f24967b;
        if (globalLibraryVersionRegistrar == null) {
            synchronized (GlobalLibraryVersionRegistrar.class) {
                try {
                    globalLibraryVersionRegistrar = f24967b;
                    if (globalLibraryVersionRegistrar == null) {
                        globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                        f24967b = globalLibraryVersionRegistrar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return globalLibraryVersionRegistrar;
    }

    /* access modifiers changed from: package-private */
    public Set<LibraryVersion> b() {
        Set<LibraryVersion> unmodifiableSet;
        synchronized (this.f24968a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f24968a);
        }
        return unmodifiableSet;
    }

    public void c(String str, String str2) {
        synchronized (this.f24968a) {
            this.f24968a.add(LibraryVersion.a(str, str2));
        }
    }
}
