package androidx.media.session;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.media.MediaBrowserServiceCompat;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9038a = "MediaButtonReceiver";

    @RequiresApi(31)
    private static final class Api31 {
        private Api31() {
        }

        @DoNotInline
        public static ForegroundServiceStartNotAllowedException a(IllegalStateException illegalStateException) {
            return b.a(illegalStateException);
        }

        @DoNotInline
        public static boolean b(IllegalStateException illegalStateException) {
            return c.a(illegalStateException);
        }
    }

    private static class MediaButtonConnectionCallback extends MediaBrowserCompat.ConnectionCallback {

        /* renamed from: c  reason: collision with root package name */
        private final Context f9039c;

        /* renamed from: d  reason: collision with root package name */
        private final Intent f9040d;

        /* renamed from: e  reason: collision with root package name */
        private final BroadcastReceiver.PendingResult f9041e;

        /* renamed from: f  reason: collision with root package name */
        private MediaBrowserCompat f9042f;

        MediaButtonConnectionCallback(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f9039c = context;
            this.f9040d = intent;
            this.f9041e = pendingResult;
        }

        private void e() {
            this.f9042f.b();
            this.f9041e.finish();
        }

        public void a() {
            new MediaControllerCompat(this.f9039c, this.f9042f.h()).d((KeyEvent) this.f9040d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            e();
        }

        public void b() {
            e();
        }

        public void c() {
            e();
        }

        /* access modifiers changed from: package-private */
        public void f(MediaBrowserCompat mediaBrowserCompat) {
            this.f9042f = mediaBrowserCompat;
        }
    }

    public static PendingIntent a(Context context, long j2) {
        ComponentName c2 = c(context);
        if (c2 != null) {
            return b(context, c2, j2);
        }
        Log.w(f9038a, "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
        return null;
    }

    public static PendingIntent b(Context context, ComponentName componentName, long j2) {
        String str;
        if (componentName == null) {
            str = "The component name of media button receiver should be provided.";
        } else {
            int B = PlaybackStateCompat.B(j2);
            if (B == 0) {
                str = "Cannot build a media button pending intent with the given action: " + j2;
            } else {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(componentName);
                int i2 = 0;
                intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, B));
                int i3 = Build.VERSION.SDK_INT;
                intent.addFlags(268435456);
                if (i3 >= 31) {
                    i2 = 33554432;
                }
                return PendingIntent.getBroadcast(context, B, intent, i2);
            }
        }
        Log.w(f9038a, str);
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static ComponentName c(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        } else if (queryBroadcastReceivers.size() <= 1) {
            return null;
        } else {
            Log.w(f9038a, "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
            return null;
        }
    }

    private static ComponentName d(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
        }
    }

    public static KeyEvent e(MediaSessionCompat mediaSessionCompat, Intent intent) {
        if (mediaSessionCompat == null || intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            return null;
        }
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        mediaSessionCompat.e().d(keyEvent);
        return keyEvent;
    }

    /* access modifiers changed from: protected */
    @RequiresApi(31)
    public void f(@NonNull Intent intent, @NonNull ForegroundServiceStartNotAllowedException foregroundServiceStartNotAllowedException) {
        Log.e(f9038a, "caught exception when trying to start a foreground service from the background: " + foregroundServiceStartNotAllowedException.getMessage());
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d(f9038a, "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName d2 = d(context, "android.intent.action.MEDIA_BUTTON");
        if (d2 != null) {
            intent.setComponent(d2);
            try {
                ContextCompat.B(context, intent);
            } catch (IllegalStateException e2) {
                if (Build.VERSION.SDK_INT < 31 || !Api31.b(e2)) {
                    throw e2;
                }
                f(intent, Api31.a(e2));
            }
        } else {
            ComponentName d3 = d(context, MediaBrowserServiceCompat.e3);
            if (d3 != null) {
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Context applicationContext = context.getApplicationContext();
                MediaButtonConnectionCallback mediaButtonConnectionCallback = new MediaButtonConnectionCallback(applicationContext, intent, goAsync);
                MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, d3, mediaButtonConnectionCallback, (Bundle) null);
                mediaButtonConnectionCallback.f(mediaBrowserCompat);
                mediaBrowserCompat.a();
                return;
            }
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
    }
}
