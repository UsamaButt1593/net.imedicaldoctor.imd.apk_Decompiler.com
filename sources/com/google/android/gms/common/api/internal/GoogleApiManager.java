package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.zal;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.internal.base.zaq;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

@ShowFirstParty
@KeepForSdk
public class GoogleApiManager implements Handler.Callback {
    @NonNull
    public static final Status k3 = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */
    public static final Status l3 = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */
    public static final Object m3 = new Object();
    @GuardedBy("lock")
    @Nullable
    private static GoogleApiManager n3;
    /* access modifiers changed from: private */
    public long X = 120000;
    @Nullable
    private TelemetryData X2;
    /* access modifiers changed from: private */
    public long Y = 10000;
    @Nullable
    private TelemetryLoggingClient Y2;
    /* access modifiers changed from: private */
    public boolean Z = false;
    /* access modifiers changed from: private */
    public final Context Z2;
    /* access modifiers changed from: private */
    public final GoogleApiAvailability a3;
    /* access modifiers changed from: private */
    public final zal b3;
    private final AtomicInteger c3 = new AtomicInteger(1);
    private final AtomicInteger d3 = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final Map<ApiKey<?>, zabq<?>> e3 = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    @Nullable
    public zaae f3 = null;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public final Set<ApiKey<?>> g3 = new ArraySet();
    private final Set<ApiKey<?>> h3 = new ArraySet();
    /* access modifiers changed from: private */
    @NotOnlyInitialized
    public final Handler i3;
    /* access modifiers changed from: private */
    public volatile boolean j3 = true;
    /* access modifiers changed from: private */
    public long s = 5000;

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.Z2 = context;
        zaq zaq = new zaq(looper, this);
        this.i3 = zaq;
        this.a3 = googleApiAvailability;
        this.b3 = new zal(googleApiAvailability);
        if (DeviceProperties.a(context)) {
            this.j3 = false;
        }
        zaq.sendMessage(zaq.obtainMessage(6));
    }

    @KeepForSdk
    public static void a() {
        synchronized (m3) {
            try {
                GoogleApiManager googleApiManager = n3;
                if (googleApiManager != null) {
                    googleApiManager.d3.incrementAndGet();
                    Handler handler = googleApiManager.i3;
                    handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public static Status i(ApiKey<?> apiKey, ConnectionResult connectionResult) {
        String b2 = apiKey.b();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 63 + valueOf.length());
        sb.append("API: ");
        sb.append(b2);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(valueOf);
        return new Status(connectionResult, sb.toString());
    }

    @WorkerThread
    private final zabq<?> j(GoogleApi<?> googleApi) {
        ApiKey<?> b2 = googleApi.b();
        zabq<?> zabq = this.e3.get(b2);
        if (zabq == null) {
            zabq = new zabq<>(this, googleApi);
            this.e3.put(b2, zabq);
        }
        if (zabq.P()) {
            this.h3.add(b2);
        }
        zabq.E();
        return zabq;
    }

    @WorkerThread
    private final TelemetryLoggingClient k() {
        if (this.Y2 == null) {
            this.Y2 = TelemetryLogging.a(this.Z2);
        }
        return this.Y2;
    }

    @WorkerThread
    private final void l() {
        TelemetryData telemetryData = this.X2;
        if (telemetryData != null) {
            if (telemetryData.b() > 0 || g()) {
                k().a(telemetryData);
            }
            this.X2 = null;
        }
    }

    private final <T> void m(TaskCompletionSource<T> taskCompletionSource, int i2, GoogleApi googleApi) {
        zacd b2;
        if (i2 != 0 && (b2 = zacd.b(this, i2, googleApi.b())) != null) {
            Task<T> a2 = taskCompletionSource.a();
            Handler handler = this.i3;
            handler.getClass();
            a2.f(new zabk(handler), b2);
        }
    }

    @NonNull
    public static GoogleApiManager y() {
        GoogleApiManager googleApiManager;
        synchronized (m3) {
            Preconditions.s(n3, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = n3;
        }
        return googleApiManager;
    }

    @NonNull
    public static GoogleApiManager z(@NonNull Context context) {
        GoogleApiManager googleApiManager;
        synchronized (m3) {
            try {
                if (n3 == null) {
                    n3 = new GoogleApiManager(context.getApplicationContext(), GmsClientSupervisor.f().getLooper(), GoogleApiAvailability.x());
                }
                googleApiManager = n3;
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleApiManager;
    }

    @NonNull
    public final Task<Map<ApiKey<?>, String>> B(@NonNull Iterable<? extends HasApiKey<?>> iterable) {
        zal zal = new zal(iterable);
        Handler handler = this.i3;
        handler.sendMessage(handler.obtainMessage(2, zal));
        return zal.a();
    }

    @NonNull
    public final Task<Boolean> C(@NonNull GoogleApi<?> googleApi) {
        zaaf zaaf = new zaaf(googleApi.b());
        Handler handler = this.i3;
        handler.sendMessage(handler.obtainMessage(14, zaaf));
        return zaaf.b().a();
    }

    @NonNull
    public final <O extends Api.ApiOptions> Task<Void> D(@NonNull GoogleApi<O> googleApi, @NonNull RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, @NonNull UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod, @NonNull Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        m(taskCompletionSource, registerListenerMethod.e(), googleApi);
        zaf zaf = new zaf(new zaci(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource);
        Handler handler = this.i3;
        handler.sendMessage(handler.obtainMessage(8, new zach(zaf, this.d3.get(), googleApi)));
        return taskCompletionSource.a();
    }

    @NonNull
    public final <O extends Api.ApiOptions> Task<Boolean> E(@NonNull GoogleApi<O> googleApi, @NonNull ListenerHolder.ListenerKey listenerKey, int i2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        m(taskCompletionSource, i2, googleApi);
        zah zah = new zah(listenerKey, taskCompletionSource);
        Handler handler = this.i3;
        handler.sendMessage(handler.obtainMessage(13, new zach(zah, this.d3.get(), googleApi)));
        return taskCompletionSource.a();
    }

    public final <O extends Api.ApiOptions> void J(@NonNull GoogleApi<O> googleApi, int i2, @NonNull BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> apiMethodImpl) {
        zae zae = new zae(i2, apiMethodImpl);
        Handler handler = this.i3;
        handler.sendMessage(handler.obtainMessage(4, new zach(zae, this.d3.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions, ResultT> void K(@NonNull GoogleApi<O> googleApi, int i2, @NonNull TaskApiCall<Api.AnyClient, ResultT> taskApiCall, @NonNull TaskCompletionSource<ResultT> taskCompletionSource, @NonNull StatusExceptionMapper statusExceptionMapper) {
        m(taskCompletionSource, taskApiCall.d(), googleApi);
        zag zag = new zag(i2, taskApiCall, taskCompletionSource, statusExceptionMapper);
        Handler handler = this.i3;
        handler.sendMessage(handler.obtainMessage(4, new zach(zag, this.d3.get(), googleApi)));
    }

    /* access modifiers changed from: package-private */
    public final void L(MethodInvocation methodInvocation, int i2, long j2, int i4) {
        Handler handler = this.i3;
        handler.sendMessage(handler.obtainMessage(18, new zace(methodInvocation, i2, j2, i4)));
    }

    public final void M(@NonNull ConnectionResult connectionResult, int i2) {
        if (!h(connectionResult, i2)) {
            Handler handler = this.i3;
            handler.sendMessage(handler.obtainMessage(5, i2, 0, connectionResult));
        }
    }

    public final void b() {
        Handler handler = this.i3;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void c(@NonNull GoogleApi<?> googleApi) {
        Handler handler = this.i3;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final void d(@NonNull zaae zaae) {
        synchronized (m3) {
            try {
                if (this.f3 != zaae) {
                    this.f3 = zaae;
                    this.g3.clear();
                }
                this.g3.addAll(zaae.u());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(@NonNull zaae zaae) {
        synchronized (m3) {
            try {
                if (this.f3 == zaae) {
                    this.f3 = null;
                    this.g3.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean g() {
        if (this.Z) {
            return false;
        }
        RootTelemetryConfiguration a2 = RootTelemetryConfigManager.b().a();
        if (a2 != null && !a2.I()) {
            return false;
        }
        int a4 = this.b3.a(this.Z2, 203400000);
        return a4 == -1 || a4 == 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean h(ConnectionResult connectionResult, int i2) {
        return this.a3.L(this.Z2, connectionResult, i2);
    }

    @WorkerThread
    public final boolean handleMessage(@NonNull Message message) {
        TaskCompletionSource<Boolean> b2;
        Boolean valueOf;
        int i2 = message.what;
        long j2 = 300000;
        zabq zabq = null;
        switch (i2) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.Y = j2;
                this.i3.removeMessages(12);
                for (ApiKey<?> obtainMessage : this.e3.keySet()) {
                    Handler handler = this.i3;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.Y);
                }
                break;
            case 2:
                zal zal = (zal) message.obj;
                Iterator<ApiKey<?>> it2 = zal.b().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else {
                        ApiKey next = it2.next();
                        zabq zabq2 = this.e3.get(next);
                        if (zabq2 == null) {
                            zal.c(next, new ConnectionResult(13), (String) null);
                            break;
                        } else if (zabq2.O()) {
                            zal.c(next, ConnectionResult.w3, zabq2.u().i());
                        } else {
                            ConnectionResult s2 = zabq2.s();
                            if (s2 != null) {
                                zal.c(next, s2, (String) null);
                            } else {
                                zabq2.J(zal);
                                zabq2.E();
                            }
                        }
                    }
                }
            case 3:
                for (zabq next2 : this.e3.values()) {
                    next2.D();
                    next2.E();
                }
                break;
            case 4:
            case 8:
            case 13:
                zach zach = (zach) message.obj;
                zabq<?> zabq3 = this.e3.get(zach.f20131c.b());
                if (zabq3 == null) {
                    zabq3 = j(zach.f20131c);
                }
                if (zabq3.P() && this.d3.get() != zach.f20130b) {
                    zach.f20129a.a(k3);
                    zabq3.L();
                    break;
                } else {
                    zabq3.F(zach.f20129a);
                    break;
                }
            case 5:
                int i4 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<zabq<?>> it3 = this.e3.values().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        zabq next3 = it3.next();
                        if (next3.q() == i4) {
                            zabq = next3;
                        }
                    }
                }
                if (zabq != null) {
                    if (connectionResult.C() != 13) {
                        zabq.d(i(zabq.f20108n, connectionResult));
                        break;
                    } else {
                        String h2 = this.a3.h(connectionResult.C());
                        String H = connectionResult.H();
                        StringBuilder sb = new StringBuilder(String.valueOf(h2).length() + 69 + String.valueOf(H).length());
                        sb.append("Error resolution was canceled by the user, original error message: ");
                        sb.append(h2);
                        sb.append(": ");
                        sb.append(H);
                        zabq.d(new Status(17, sb.toString()));
                        break;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i4);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (this.Z2.getApplicationContext() instanceof Application) {
                    BackgroundDetector.c((Application) this.Z2.getApplicationContext());
                    BackgroundDetector.b().a(new zabl(this));
                    if (!BackgroundDetector.b().e(true)) {
                        this.Y = 300000;
                        break;
                    }
                }
                break;
            case 7:
                j((GoogleApi) message.obj);
                break;
            case 9:
                if (this.e3.containsKey(message.obj)) {
                    this.e3.get(message.obj).K();
                    break;
                }
                break;
            case 10:
                for (ApiKey<?> remove : this.h3) {
                    zabq remove2 = this.e3.remove(remove);
                    if (remove2 != null) {
                        remove2.L();
                    }
                }
                this.h3.clear();
                break;
            case 11:
                if (this.e3.containsKey(message.obj)) {
                    this.e3.get(message.obj).M();
                    break;
                }
                break;
            case 12:
                if (this.e3.containsKey(message.obj)) {
                    this.e3.get(message.obj).a();
                    break;
                }
                break;
            case 14:
                zaaf zaaf = (zaaf) message.obj;
                ApiKey<?> a2 = zaaf.a();
                if (!this.e3.containsKey(a2)) {
                    b2 = zaaf.b();
                    valueOf = Boolean.FALSE;
                } else {
                    boolean N = this.e3.get(a2).p(false);
                    b2 = zaaf.b();
                    valueOf = Boolean.valueOf(N);
                }
                b2.c(valueOf);
                break;
            case 15:
                zabs zabs = (zabs) message.obj;
                if (this.e3.containsKey(zabs.f20109a)) {
                    zabq.B(this.e3.get(zabs.f20109a), zabs);
                    break;
                }
                break;
            case 16:
                zabs zabs2 = (zabs) message.obj;
                if (this.e3.containsKey(zabs2.f20109a)) {
                    zabq.C(this.e3.get(zabs2.f20109a), zabs2);
                    break;
                }
                break;
            case 17:
                l();
                break;
            case 18:
                zace zace = (zace) message.obj;
                if (zace.f20127c != 0) {
                    TelemetryData telemetryData = this.X2;
                    if (telemetryData != null) {
                        List<MethodInvocation> C = telemetryData.C();
                        if (telemetryData.b() != zace.f20126b || (C != null && C.size() >= zace.f20128d)) {
                            this.i3.removeMessages(17);
                            l();
                        } else {
                            this.X2.H(zace.f20125a);
                        }
                    }
                    if (this.X2 == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(zace.f20125a);
                        this.X2 = new TelemetryData(zace.f20126b, arrayList);
                        Handler handler2 = this.i3;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), zace.f20127c);
                        break;
                    }
                } else {
                    k().a(new TelemetryData(zace.f20126b, Arrays.asList(new MethodInvocation[]{zace.f20125a})));
                    break;
                }
                break;
            case 19:
                this.Z = false;
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }

    public final int n() {
        return this.c3.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final zabq x(ApiKey<?> apiKey) {
        return this.e3.get(apiKey);
    }
}
