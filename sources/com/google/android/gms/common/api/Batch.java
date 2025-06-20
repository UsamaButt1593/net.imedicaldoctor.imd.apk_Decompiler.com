package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends BasePendingResult<BatchResult> {
    /* access modifiers changed from: private */
    public int r;
    /* access modifiers changed from: private */
    public boolean s;
    /* access modifiers changed from: private */
    public boolean t;
    /* access modifiers changed from: private */
    public final PendingResult<?>[] u;
    /* access modifiers changed from: private */
    public final Object v = new Object();

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private List<PendingResult<?>> f19926a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private GoogleApiClient f19927b;

        public Builder(@NonNull GoogleApiClient googleApiClient) {
            this.f19927b = googleApiClient;
        }

        @NonNull
        public <R extends Result> BatchResultToken<R> a(@NonNull PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.f19926a.size());
            this.f19926a.add(pendingResult);
            return batchResultToken;
        }

        @NonNull
        public Batch b() {
            return new Batch(this.f19926a, this.f19927b, (zac) null);
        }
    }

    /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, zac zac) {
        super(googleApiClient);
        int size = list.size();
        this.r = size;
        PendingResult<?>[] pendingResultArr = new PendingResult[size];
        this.u = pendingResultArr;
        if (!list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                PendingResult<?> pendingResult = (PendingResult) list.get(i2);
                this.u[i2] = pendingResult;
                pendingResult.c(new zab(this));
            }
            return;
        }
        o(new BatchResult(Status.Y2, pendingResultArr));
    }

    public void f() {
        super.f();
        for (PendingResult<?> f2 : this.u) {
            f2.f();
        }
    }

    @NonNull
    /* renamed from: w */
    public BatchResult k(@NonNull Status status) {
        return new BatchResult(status, this.u);
    }
}
