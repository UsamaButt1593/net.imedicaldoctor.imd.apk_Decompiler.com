package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;

final class zzab implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Collection f20526a;

    zzab(Collection collection) {
        this.f20526a = collection;
    }

    public final /* bridge */ /* synthetic */ Object a(@NonNull Task task) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f20526a);
        return Tasks.g(arrayList);
    }
}
