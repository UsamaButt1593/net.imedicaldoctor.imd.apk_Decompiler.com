package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

final class zae implements View.OnClickListener {
    final /* synthetic */ Intent X;
    final /* synthetic */ Context s;

    zae(Context context, Intent intent) {
        this.s = context;
        this.X = intent;
    }

    public final void onClick(View view) {
        try {
            this.s.startActivity(this.X);
        } catch (ActivityNotFoundException e2) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e2);
        }
    }
}
