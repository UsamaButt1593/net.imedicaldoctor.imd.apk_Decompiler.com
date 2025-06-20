package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

final class zac implements Comparator<Scope> {
    zac() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((Scope) obj).C().compareTo(((Scope) obj2).C());
    }
}
