package com.google.android.material.search;

import androidx.core.view.accessibility.AccessibilityManagerCompat;

/* renamed from: com.google.android.material.search.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0464c implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchBar f21770a;

    public /* synthetic */ C0464c(SearchBar searchBar) {
        this.f21770a = searchBar;
    }

    public final void onTouchExplorationStateChanged(boolean z) {
        this.f21770a.x0(z);
    }
}
