package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zze;
import java.lang.ref.SoftReference;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static SoftReference f19800a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static SoftReference f19801b;

    public static final class IntentActionKeys {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public static final String f19802a = "com.google.firebase.messaging.NOTIFICATION_OPEN";
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public static final String f19803b = "com.google.firebase.messaging.NOTIFICATION_DISMISS";

        private IntentActionKeys() {
        }
    }

    public static final class IntentKeys {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public static final String f19804a = "pending_intent";
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public static final String f19805b = "wrapped_intent";

        private IntentKeys() {
        }
    }

    @WorkerThread
    private final int e(@NonNull Context context, @NonNull Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(IntentKeys.f19804a);
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove(IntentKeys.f19804a);
        } else {
            extras = new Bundle();
        }
        if (Objects.equals(intent.getAction(), IntentActionKeys.f19803b)) {
            c(context, extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Executor a() {
        ExecutorService executorService;
        synchronized (CloudMessagingReceiver.class) {
            try {
                SoftReference softReference = f19800a;
                executorService = softReference != null ? (ExecutorService) softReference.get() : null;
                if (executorService == null) {
                    zze.zza();
                    executorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new NamedThreadFactory("firebase-iid-executor")));
                    f19800a = new SoftReference(executorService);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public abstract int b(@NonNull Context context, @NonNull CloudMessage cloudMessage);

    /* access modifiers changed from: protected */
    @WorkerThread
    public void c(@NonNull Context context, @NonNull Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d(Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        int i2;
        Intent intent2 = intent;
        Context context2 = context;
        BroadcastReceiver.PendingResult pendingResult2 = pendingResult;
        try {
            Parcelable parcelableExtra = intent2.getParcelableExtra(IntentKeys.f19805b);
            Executor executor = null;
            Intent intent3 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent3 != null) {
                i2 = e(context2, intent3);
            } else if (intent.getExtras() == null) {
                i2 = 500;
            } else {
                CloudMessage cloudMessage = new CloudMessage(intent2);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                synchronized (CloudMessagingReceiver.class) {
                    SoftReference softReference = f19801b;
                    if (softReference != null) {
                        executor = (Executor) softReference.get();
                    }
                    if (executor == null) {
                        zze.zza();
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("pscm-ack-executor"));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        executor = Executors.unconfigurableExecutorService(threadPoolExecutor);
                        f19801b = new SoftReference(executor);
                    }
                }
                executor.execute(new zzg(context2, cloudMessage, countDownLatch));
                int b2 = b(context2, cloudMessage);
                try {
                    if (!countDownLatch.await(TimeUnit.SECONDS.toMillis(1), TimeUnit.MILLISECONDS)) {
                        Log.w("CloudMessagingReceiver", "Message ack timed out");
                    }
                } catch (InterruptedException e2) {
                    Log.w("CloudMessagingReceiver", "Message ack failed: ".concat(e2.toString()));
                }
                i2 = b2;
            }
            if (z && pendingResult2 != null) {
                pendingResult2.setResultCode(i2);
            }
            if (pendingResult2 != null) {
                pendingResult.finish();
            }
        } catch (Throwable th) {
            if (pendingResult2 != null) {
                pendingResult.finish();
            }
            throw th;
        }
    }

    public final void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (intent != null) {
            a().execute(new zzh(this, intent, context, isOrderedBroadcast(), goAsync()));
        }
    }
}
