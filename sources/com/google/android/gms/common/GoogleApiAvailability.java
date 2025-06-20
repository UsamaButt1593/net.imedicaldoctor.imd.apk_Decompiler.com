package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.common.C;
import androidx.media3.common.util.k;
import com.google.android.gms.base.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.api.internal.zacc;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class GoogleApiAvailability extends GoogleApiAvailabilityLight {

    /* renamed from: h  reason: collision with root package name */
    public static final int f19868h = GoogleApiAvailabilityLight.f19873a;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public static final String f19869i = "com.google.android.gms";

    /* renamed from: j  reason: collision with root package name */
    private static final Object f19870j = new Object();

    /* renamed from: k  reason: collision with root package name */
    private static final GoogleApiAvailability f19871k = new GoogleApiAvailability();
    @GuardedBy("mLock")

    /* renamed from: g  reason: collision with root package name */
    private String f19872g;

    @NonNull
    public static final Task<Map<ApiKey<?>, String>> M(@NonNull HasApiKey<?> hasApiKey, @NonNull HasApiKey<?>... hasApiKeyArr) {
        Preconditions.s(hasApiKey, "Requested API must not be null.");
        for (HasApiKey<?> s : hasApiKeyArr) {
            Preconditions.s(s, "Requested API must not be null.");
        }
        ArrayList arrayList = new ArrayList(hasApiKeyArr.length + 1);
        arrayList.add(hasApiKey);
        arrayList.addAll(Arrays.asList(hasApiKeyArr));
        return GoogleApiManager.y().B(arrayList);
    }

    @NonNull
    public static GoogleApiAvailability x() {
        return f19871k;
    }

    public boolean A(@NonNull Activity activity, int i2, int i3) {
        return B(activity, i2, i3, (DialogInterface.OnCancelListener) null);
    }

    public boolean B(@NonNull Activity activity, int i2, int i3, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog t = t(activity, i2, i3, onCancelListener);
        if (t == null) {
            return false;
        }
        H(activity, t, GooglePlayServicesUtil.f19879k, onCancelListener);
        return true;
    }

    public void C(@NonNull Context context, int i2) {
        I(context, i2, (String) null, g(context, i2, 0, "n"));
    }

    public void D(@NonNull Context context, @NonNull ConnectionResult connectionResult) {
        I(context, connectionResult.C(), (String) null, w(context, connectionResult));
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final Dialog E(@NonNull Context context, int i2, zag zag, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(zac.d(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c2 = zac.c(context, i2);
        if (c2 != null) {
            builder.setPositiveButton(c2, zag);
        }
        String g2 = zac.g(context, i2);
        if (g2 != null) {
            builder.setTitle(g2);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", new Object[]{Integer.valueOf(i2)}), new IllegalArgumentException());
        return builder.create();
    }

    @NonNull
    public final Dialog F(@NonNull Activity activity, @NonNull DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(zac.d(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        H(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    @Nullable
    public final zabx G(Context context, zabw zabw) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabx zabx = new zabx(zabw);
        context.registerReceiver(zabx, intentFilter);
        zabx.a(context);
        if (n(context, "com.google.android.gms")) {
            return zabx;
        }
        zabw.a();
        zabx.b();
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void H(Activity activity, Dialog dialog, String str, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                SupportErrorDialogFragment.h3(dialog, onCancelListener).e3(((FragmentActivity) activity).k0(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        ErrorDialogFragment.b(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* access modifiers changed from: package-private */
    @TargetApi(20)
    public final void I(Context context, int i2, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        int i3;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", new Object[]{Integer.valueOf(i2), null}), new IllegalArgumentException());
        if (i2 == 18) {
            J(context);
        } else if (pendingIntent != null) {
            String f2 = zac.f(context, i2);
            String e2 = zac.e(context, i2);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) Preconditions.r(context.getSystemService("notification"));
            NotificationCompat.Builder z0 = new NotificationCompat.Builder(context).e0(true).C(true).O(f2).z0(new NotificationCompat.BigTextStyle().A(e2));
            if (DeviceProperties.l(context)) {
                Preconditions.x(PlatformVersion.i());
                z0.t0(context.getApplicationInfo().icon).k0(2);
                if (DeviceProperties.m(context)) {
                    z0.a(R.drawable.f19755a, resources.getString(R.string.o), pendingIntent);
                } else {
                    z0.M(pendingIntent);
                }
            } else {
                z0.t0(17301642).B0(resources.getString(R.string.f19785h)).H0(System.currentTimeMillis()).M(pendingIntent).N(e2);
            }
            if (PlatformVersion.n()) {
                Preconditions.x(PlatformVersion.n());
                synchronized (f19870j) {
                    str2 = this.f19872g;
                }
                if (str2 == null) {
                    str2 = "com.google.android.gms.availability";
                    NotificationChannel a2 = notificationManager.getNotificationChannel(str2);
                    String b2 = zac.b(context);
                    if (a2 == null) {
                        notificationManager.createNotificationChannel(k.a(str2, b2, 4));
                    } else if (!b2.contentEquals(a2.getName())) {
                        a2.setName(b2);
                        notificationManager.createNotificationChannel(a2);
                    }
                }
                z0.G(str2);
            }
            Notification h2 = z0.h();
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                GooglePlayServicesUtilLight.f19889g.set(false);
                i3 = 10436;
            } else {
                i3 = 39789;
            }
            notificationManager.notify(i3, h2);
        } else if (i2 == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void J(Context context) {
        new zac(this, context).sendEmptyMessageDelayed(1, 120000);
    }

    public final boolean K(@NonNull Activity activity, @NonNull LifecycleFragment lifecycleFragment, int i2, int i3, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog E = E(activity, i2, zag.d(lifecycleFragment, e(activity, i2, "d"), 2), onCancelListener);
        if (E == null) {
            return false;
        }
        H(activity, E, GooglePlayServicesUtil.f19879k, onCancelListener);
        return true;
    }

    public final boolean L(@NonNull Context context, @NonNull ConnectionResult connectionResult, int i2) {
        PendingIntent w;
        if (InstantApps.a(context) || (w = w(context, connectionResult)) == null) {
            return false;
        }
        I(context, connectionResult.C(), (String) null, zal.zaa(context, 0, GoogleApiActivity.a(context, w, i2, true), zal.zaa | C.S0));
        return true;
    }

    @ShowFirstParty
    @KeepForSdk
    public int c(@NonNull Context context) {
        return super.c(context);
    }

    @ShowFirstParty
    @KeepForSdk
    @Nullable
    public Intent e(@Nullable Context context, int i2, @Nullable String str) {
        return super.e(context, i2, str);
    }

    @Nullable
    public PendingIntent f(@NonNull Context context, int i2, int i3) {
        return super.f(context, i2, i3);
    }

    @NonNull
    public final String h(int i2) {
        return super.h(i2);
    }

    @HideFirstParty
    public int j(@NonNull Context context) {
        return super.j(context);
    }

    @ShowFirstParty
    @KeepForSdk
    public int k(@NonNull Context context, int i2) {
        return super.k(context, i2);
    }

    public final boolean o(int i2) {
        return super.o(i2);
    }

    @NonNull
    public Task<Void> q(@NonNull GoogleApi<?> googleApi, @NonNull GoogleApi<?>... googleApiArr) {
        return M(googleApi, googleApiArr).w(zab.f20413a);
    }

    @NonNull
    public Task<Void> r(@NonNull HasApiKey<?> hasApiKey, @NonNull HasApiKey<?>... hasApiKeyArr) {
        return M(hasApiKey, hasApiKeyArr).w(zaa.f20412a);
    }

    @Nullable
    public Dialog s(@NonNull Activity activity, int i2, int i3) {
        return t(activity, i2, i3, (DialogInterface.OnCancelListener) null);
    }

    @Nullable
    public Dialog t(@NonNull Activity activity, int i2, int i3, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return E(activity, i2, zag.b(activity, e(activity, i2, "d"), i3), onCancelListener);
    }

    @Nullable
    public Dialog u(@NonNull Fragment fragment, int i2, int i3) {
        return v(fragment, i2, i3, (DialogInterface.OnCancelListener) null);
    }

    @Nullable
    public Dialog v(@NonNull Fragment fragment, int i2, int i3, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return E(fragment.X1(), i2, zag.c(fragment, e(fragment.X1(), i2, "d"), i3), onCancelListener);
    }

    @Nullable
    public PendingIntent w(@NonNull Context context, @NonNull ConnectionResult connectionResult) {
        return connectionResult.N() ? connectionResult.I() : f(context, connectionResult.C(), 0);
    }

    @MainThread
    @NonNull
    public Task<Void> y(@NonNull Activity activity) {
        int i2 = f19868h;
        Preconditions.k("makeGooglePlayServicesAvailable must be called from the main thread");
        int k2 = k(activity, i2);
        if (k2 == 0) {
            return Tasks.g(null);
        }
        zacc u = zacc.u(activity);
        u.t(new ConnectionResult(k2, (PendingIntent) null), 0);
        return u.v();
    }

    @TargetApi(26)
    public void z(@NonNull Context context, @NonNull String str) {
        if (PlatformVersion.n()) {
            Preconditions.r(((NotificationManager) Preconditions.r(context.getSystemService("notification"))).getNotificationChannel(str));
        }
        synchronized (f19870j) {
            this.f19872g = str;
        }
    }
}
