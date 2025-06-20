package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import androidx.annotation.NonNull;

public class ResolvableApiException extends ApiException {
    public ResolvableApiException(@NonNull Status status) {
        super(status);
    }

    @NonNull
    public PendingIntent d() {
        return a().H();
    }

    public void e(@NonNull Activity activity, int i2) throws IntentSender.SendIntentException {
        a().S(activity, i2);
    }
}
