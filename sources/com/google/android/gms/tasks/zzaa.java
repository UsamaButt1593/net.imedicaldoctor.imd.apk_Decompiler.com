package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;

final class zzaa implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Collection f20525a;

    zzaa(Collection collection) {
        this.f20525a = collection;
    }

    public final /* bridge */ /* synthetic */ Object a(@NonNull Task task) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (Task r : this.f20525a) {
            arrayList.add(r.r());
        }
        return arrayList;
    }
}
