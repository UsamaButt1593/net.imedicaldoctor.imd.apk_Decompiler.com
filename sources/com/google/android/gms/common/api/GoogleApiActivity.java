package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    @VisibleForTesting
    protected int s = 0;

    @NonNull
    public static Intent a(@NonNull Context context, @NonNull PendingIntent pendingIntent, int i2, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra(CloudMessagingReceiver.IntentKeys.f19804a, pendingIntent);
        intent.putExtra("failing_client_id", i2);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    private final void b() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get(CloudMessagingReceiver.IntentKeys.f19804a);
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, (Intent) null, 0, 0, 0);
                this.s = 1;
            } catch (ActivityNotFoundException e2) {
                if (extras.getBoolean("notify_manager", true)) {
                    GoogleApiManager.z(this).M(new ConnectionResult(22, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    String obj = pendingIntent.toString();
                    StringBuilder sb = new StringBuilder(obj.length() + 36);
                    sb.append("Activity not found while launching ");
                    sb.append(obj);
                    sb.append(".");
                    String sb2 = sb.toString();
                    if (Build.FINGERPRINT.contains("generic")) {
                        sb2 = sb2.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                    Log.e("GoogleApiActivity", sb2, e2);
                }
                this.s = 1;
                finish();
            } catch (IntentSender.SendIntentException e3) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e3);
                finish();
            }
        } else {
            GoogleApiAvailability.x().B(this, ((Integer) Preconditions.r(num)).intValue(), 2, this);
            this.s = 1;
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i2, int i3, @NonNull Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.s = 0;
            setResult(i3, intent);
            if (booleanExtra) {
                GoogleApiManager z = GoogleApiManager.z(this);
                if (i3 == -1) {
                    z.b();
                } else if (i3 == 0) {
                    z.M(new ConnectionResult(13, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i2 == 2) {
            this.s = 0;
            setResult(i3, intent);
        }
        finish();
    }

    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        this.s = 0;
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.s = bundle.getInt("resolution");
        }
        if (this.s != 1) {
            b();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt("resolution", this.s);
        super.onSaveInstanceState(bundle);
    }
}
