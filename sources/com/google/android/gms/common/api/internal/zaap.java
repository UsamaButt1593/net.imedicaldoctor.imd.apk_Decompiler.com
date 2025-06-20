package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

final class zaap extends zaav {
    private final ArrayList<Api.Client> X;
    final /* synthetic */ zaaw Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaap(zaaw zaaw, ArrayList<Api.Client> arrayList) {
        super(zaaw, (zaau) null);
        this.Y = zaaw;
        this.X = arrayList;
    }

    @WorkerThread
    public final void a() {
        zaaw zaaw = this.Y;
        zaaw.f20062a.y.s = zaaw.y(zaaw);
        ArrayList<Api.Client> arrayList = this.X;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zaaw zaaw2 = this.Y;
            arrayList.get(i2).f(zaaw2.o, zaaw2.f20062a.y.s);
        }
    }
}
