package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;

public final /* synthetic */ class b implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f24969a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LibraryVersionComponent.VersionExtractor f24970b;

    public /* synthetic */ b(String str, LibraryVersionComponent.VersionExtractor versionExtractor) {
        this.f24969a = str;
        this.f24970b = versionExtractor;
    }

    public final Object a(ComponentContainer componentContainer) {
        return LibraryVersion.a(this.f24969a, this.f24970b.a((Context) componentContainer.a(Context.class)));
    }
}
