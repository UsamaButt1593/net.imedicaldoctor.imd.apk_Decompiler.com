package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rpc {

    /* renamed from: h  reason: collision with root package name */
    private static int f19809h;

    /* renamed from: i  reason: collision with root package name */
    private static PendingIntent f19810i;

    /* renamed from: j  reason: collision with root package name */
    private static final Executor f19811j = zzy.s;

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f19812k = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* renamed from: a  reason: collision with root package name */
    private final SimpleArrayMap f19813a = new SimpleArrayMap();

    /* renamed from: b  reason: collision with root package name */
    private final Context f19814b;

    /* renamed from: c  reason: collision with root package name */
    private final zzw f19815c;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledExecutorService f19816d;

    /* renamed from: e  reason: collision with root package name */
    private final Messenger f19817e;

    /* renamed from: f  reason: collision with root package name */
    private Messenger f19818f;

    /* renamed from: g  reason: collision with root package name */
    private zzd f19819g;

    public Rpc(@NonNull Context context) {
        this.f19814b = context;
        this.f19815c = new zzw(context);
        this.f19817e = new Messenger(new zzae(this, Looper.getMainLooper()));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f19816d = scheduledThreadPoolExecutor;
    }

    static /* synthetic */ Task e(Bundle bundle) throws Exception {
        return m(bundle) ? Tasks.g(null) : Tasks.g(bundle);
    }

    static /* bridge */ /* synthetic */ void g(Rpc rpc, Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzc());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzd) {
                        rpc.f19819g = (zzd) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        rpc.f19818f = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (Objects.equals(action, "com.google.android.c2dm.intent.REGISTRATION")) {
                    String stringExtra = intent2.getStringExtra("registration_id");
                    if (stringExtra == null) {
                        stringExtra = intent2.getStringExtra("unregistered");
                    }
                    if (stringExtra == null) {
                        String stringExtra2 = intent2.getStringExtra("error");
                        if (stringExtra2 == null) {
                            Log.w("Rpc", "Unexpected response, no error or registration id ".concat(String.valueOf(intent2.getExtras())));
                            return;
                        }
                        if (Log.isLoggable("Rpc", 3)) {
                            Log.d("Rpc", "Received InstanceID error ".concat(stringExtra2));
                        }
                        if (stringExtra2.startsWith("|")) {
                            String[] split = stringExtra2.split("\\|");
                            if (split.length <= 2 || !Objects.equals(split[1], "ID")) {
                                Log.w("Rpc", "Unexpected structured response ".concat(stringExtra2));
                                return;
                            }
                            String str = split[2];
                            String str2 = split[3];
                            if (str2.startsWith(":")) {
                                str2 = str2.substring(1);
                            }
                            rpc.l(str, intent2.putExtra("error", str2).getExtras());
                            return;
                        }
                        synchronized (rpc.f19813a) {
                            int i2 = 0;
                            while (i2 < rpc.f19813a.size()) {
                                try {
                                    rpc.l((String) rpc.f19813a.i(i2), intent2.getExtras());
                                    i2++;
                                } finally {
                                }
                            }
                        }
                        return;
                    }
                    Matcher matcher = f19812k.matcher(stringExtra);
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        if (group != null) {
                            Bundle extras = intent2.getExtras();
                            extras.putString("registration_id", group2);
                            rpc.l(group, extras);
                            return;
                        }
                        return;
                    } else if (Log.isLoggable("Rpc", 3)) {
                        Log.d("Rpc", "Unexpected response string: ".concat(stringExtra));
                        return;
                    } else {
                        return;
                    }
                } else if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Unexpected response action: ".concat(String.valueOf(action)));
                    return;
                } else {
                    return;
                }
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    @AnyThread
    private final Task i(Bundle bundle) {
        String j2 = j();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.f19813a) {
            this.f19813a.put(j2, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        intent.setAction(this.f19815c.b() == 2 ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
        intent.putExtras(bundle);
        k(this.f19814b, intent);
        intent.putExtra("kid", "|ID|" + j2 + "|");
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Sending ".concat(String.valueOf(intent.getExtras())));
        }
        intent.putExtra("google.messenger", this.f19817e);
        if (!(this.f19818f == null && this.f19819g == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.f19818f;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    this.f19819g.b(obtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
            taskCompletionSource.a().f(f19811j, new zzad(this, j2, this.f19816d.schedule(new zzac(taskCompletionSource), 30, TimeUnit.SECONDS)));
            return taskCompletionSource.a();
        }
        if (this.f19815c.b() == 2) {
            this.f19814b.sendBroadcast(intent);
        } else {
            this.f19814b.startService(intent);
        }
        taskCompletionSource.a().f(f19811j, new zzad(this, j2, this.f19816d.schedule(new zzac(taskCompletionSource), 30, TimeUnit.SECONDS)));
        return taskCompletionSource.a();
    }

    private static synchronized String j() {
        String num;
        synchronized (Rpc.class) {
            int i2 = f19809h;
            f19809h = i2 + 1;
            num = Integer.toString(i2);
        }
        return num;
    }

    private static synchronized void k(Context context, Intent intent) {
        synchronized (Rpc.class) {
            try {
                if (f19810i == null) {
                    Intent intent2 = new Intent();
                    intent2.setPackage("com.google.example.invalidpackage");
                    f19810i = PendingIntent.getBroadcast(context, 0, intent2, zza.zza);
                }
                intent.putExtra("app", f19810i);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private final void l(String str, @Nullable Bundle bundle) {
        synchronized (this.f19813a) {
            try {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.f19813a.remove(str);
                if (taskCompletionSource == null) {
                    Log.w("Rpc", "Missing callback for " + str);
                    return;
                }
                taskCompletionSource.c(bundle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean m(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    @NonNull
    public Task<CloudMessage> a() {
        return this.f19815c.a() >= 241100000 ? zzv.b(this.f19814b).d(5, Bundle.EMPTY).n(f19811j, zzab.f19821a) : Tasks.f(new IOException("SERVICE_NOT_AVAILABLE"));
    }

    @NonNull
    public Task<Void> b(@NonNull CloudMessage cloudMessage) {
        if (this.f19815c.a() < 233700000) {
            return Tasks.f(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putString(Constants.MessagePayloadKeys.f24706h, cloudMessage.O());
        Integer c0 = cloudMessage.c0();
        if (c0 != null) {
            bundle.putInt(Constants.MessagePayloadKeys.o, c0.intValue());
        }
        return zzv.b(this.f19814b).c(3, bundle);
    }

    @NonNull
    public Task<Bundle> c(@NonNull Bundle bundle) {
        if (this.f19815c.a() < 12000000) {
            return this.f19815c.b() != 0 ? i(bundle).p(f19811j, new zzz(this, bundle)) : Tasks.f(new IOException("MISSING_INSTANCEID_SERVICE"));
        }
        return zzv.b(this.f19814b).d(1, bundle).n(f19811j, zzaa.f19820a);
    }

    @NonNull
    public Task<Void> d(boolean z) {
        if (this.f19815c.a() < 241100000) {
            return Tasks.f(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("proxy_retention", z);
        return zzv.b(this.f19814b).c(4, bundle);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task f(Bundle bundle, Task task) throws Exception {
        return (task.v() && m((Bundle) task.r())) ? i(bundle).x(f19811j, zzx.f19841a) : task;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void h(String str, ScheduledFuture scheduledFuture, Task task) {
        synchronized (this.f19813a) {
            this.f19813a.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
