package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.firebase.messaging.Constants;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

public class FirebaseMessagingService extends EnhancedIntentService {
    static final String b3 = "com.google.android.c2dm.intent.RECEIVE";
    public static final String c3 = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT";
    static final String d3 = "com.google.firebase.messaging.NEW_TOKEN";
    static final String e3 = "token";
    private static final int f3 = 10;
    private static final Queue<String> g3 = new ArrayDeque(10);
    private Rpc a3;

    private boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue<String> queue = g3;
        if (!queue.contains(str)) {
            if (queue.size() >= 10) {
                queue.remove();
            }
            queue.add(str);
            return false;
        } else if (!Log.isLoggable(Constants.f24670a, 3)) {
            return true;
        } else {
            Log.d(Constants.f24670a, "Received duplicate message: " + str);
            return true;
        }
    }

    private void m(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (NotificationParams.v(extras)) {
            NotificationParams notificationParams = new NotificationParams(extras);
            ExecutorService f2 = FcmExecutors.f();
            try {
                if (!new DisplayNotification(this, notificationParams, f2).a()) {
                    if (MessagingAnalytics.E(intent)) {
                        MessagingAnalytics.w(intent);
                    }
                } else {
                    return;
                }
            } finally {
                f2.shutdown();
            }
        }
        r(new RemoteMessage(extras));
    }

    private String n(Intent intent) {
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.f24706h);
        return stringExtra == null ? intent.getStringExtra(Constants.MessagePayloadKeys.f24704f) : stringExtra;
    }

    private Rpc o(Context context) {
        if (this.a3 == null) {
            this.a3 = new Rpc(context.getApplicationContext());
        }
        return this.a3;
    }

    private void p(Intent intent) {
        if (!l(intent.getStringExtra(Constants.MessagePayloadKeys.f24706h))) {
            v(intent);
        }
        o(this).b(new CloudMessage(intent));
    }

    private void v(Intent intent) {
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.f24702d);
        if (stringExtra == null) {
            stringExtra = Constants.MessageTypes.f24713a;
        }
        char c2 = 65535;
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals(Constants.MessageTypes.f24714b)) {
                    c2 = 0;
                    break;
                }
                break;
            case 102161:
                if (stringExtra.equals(Constants.MessageTypes.f24713a)) {
                    c2 = 1;
                    break;
                }
                break;
            case 814694033:
                if (stringExtra.equals(Constants.MessageTypes.f24716d)) {
                    c2 = 2;
                    break;
                }
                break;
            case 814800675:
                if (stringExtra.equals(Constants.MessageTypes.f24715c)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                q();
                return;
            case 1:
                MessagingAnalytics.y(intent);
                m(intent);
                return;
            case 2:
                u(n(intent), new SendException(intent.getStringExtra("error")));
                return;
            case 3:
                s(intent.getStringExtra(Constants.MessagePayloadKeys.f24706h));
                return;
            default:
                Log.w(Constants.f24670a, "Received message with unknown type: " + stringExtra);
                return;
        }
    }

    @VisibleForTesting
    static void w() {
        g3.clear();
    }

    /* access modifiers changed from: protected */
    public Intent e(Intent intent) {
        return ServiceStarter.b().c();
    }

    public void f(Intent intent) {
        String action = intent.getAction();
        if (b3.equals(action) || c3.equals(action)) {
            p(intent);
        } else if (d3.equals(action)) {
            t(intent.getStringExtra(e3));
        } else {
            Log.d(Constants.f24670a, "Unknown intent action: " + intent.getAction());
        }
    }

    @WorkerThread
    public void q() {
    }

    @WorkerThread
    public void r(@NonNull RemoteMessage remoteMessage) {
    }

    @WorkerThread
    public void s(@NonNull String str) {
    }

    @WorkerThread
    public void t(@NonNull String str) {
    }

    @WorkerThread
    public void u(@NonNull String str, @NonNull Exception exc) {
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void x(Rpc rpc) {
        this.a3 = rpc;
    }
}
