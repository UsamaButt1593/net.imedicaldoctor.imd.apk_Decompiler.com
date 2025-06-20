package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    private final ArrayMap<ApiKey<?>, ConnectionResult> s;

    public AvailabilityException(@NonNull ArrayMap<ApiKey<?>, ConnectionResult> arrayMap) {
        this.s = arrayMap;
    }

    @NonNull
    public ConnectionResult a(@NonNull GoogleApi<? extends Api.ApiOptions> googleApi) {
        ApiKey<? extends Api.ApiOptions> b2 = googleApi.b();
        boolean z = this.s.get(b2) != null;
        String b3 = b2.b();
        StringBuilder sb = new StringBuilder(String.valueOf(b3).length() + 58);
        sb.append("The given API (");
        sb.append(b3);
        sb.append(") was not part of the availability request.");
        Preconditions.b(z, sb.toString());
        return (ConnectionResult) Preconditions.r(this.s.get(b2));
    }

    @NonNull
    public ConnectionResult b(@NonNull HasApiKey<? extends Api.ApiOptions> hasApiKey) {
        ApiKey<? extends Api.ApiOptions> b2 = hasApiKey.b();
        boolean z = this.s.get(b2) != null;
        String b3 = b2.b();
        StringBuilder sb = new StringBuilder(String.valueOf(b3).length() + 58);
        sb.append("The given API (");
        sb.append(b3);
        sb.append(") was not part of the availability request.");
        Preconditions.b(z, sb.toString());
        return (ConnectionResult) Preconditions.r(this.s.get(b2));
    }

    @NonNull
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (ApiKey next : this.s.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) Preconditions.r(this.s.get(next));
            z &= !connectionResult.O();
            String b2 = next.b();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 2 + valueOf.length());
            sb.append(b2);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z ? "None of the queried APIs are available. " : "Some of the queried APIs are unavailable. ");
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
