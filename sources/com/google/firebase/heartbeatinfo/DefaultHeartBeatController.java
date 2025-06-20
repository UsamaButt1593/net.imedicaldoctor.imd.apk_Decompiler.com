package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.UserManagerCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HeartBeatInfoStorage> f24380a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f24381b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UserAgentPublisher> f24382c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<HeartBeatConsumer> f24383d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f24384e;

    private DefaultHeartBeatController(Context context, String str, Set<HeartBeatConsumer> set, Provider<UserAgentPublisher> provider, Executor executor) {
        this((Provider<HeartBeatInfoStorage>) new a(context, str), set, executor, provider, context);
    }

    @NonNull
    public static Component<DefaultHeartBeatController> g() {
        Qualified<Executor> a2 = Qualified.a(Background.class, Executor.class);
        return Component.i(DefaultHeartBeatController.class, HeartBeatController.class, HeartBeatInfo.class).b(Dependency.m(Context.class)).b(Dependency.m(FirebaseApp.class)).b(Dependency.q(HeartBeatConsumer.class)).b(Dependency.o(UserAgentPublisher.class)).b(Dependency.l(a2)).f(new c(a2)).d();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ DefaultHeartBeatController h(Qualified qualified, ComponentContainer componentContainer) {
        return new DefaultHeartBeatController((Context) componentContainer.a(Context.class), ((FirebaseApp) componentContainer.a(FirebaseApp.class)).t(), componentContainer.i(HeartBeatConsumer.class), componentContainer.c(UserAgentPublisher.class), (Executor) componentContainer.h(qualified));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String i() throws Exception {
        Base64OutputStream base64OutputStream;
        GZIPOutputStream gZIPOutputStream;
        String byteArrayOutputStream;
        synchronized (this) {
            try {
                HeartBeatInfoStorage heartBeatInfoStorage = this.f24380a.get();
                List<HeartBeatResult> c2 = heartBeatInfoStorage.c();
                heartBeatInfoStorage.b();
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < c2.size(); i2++) {
                    HeartBeatResult heartBeatResult = c2.get(i2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", heartBeatResult.c());
                    jSONObject.put("dates", new JSONArray(heartBeatResult.b()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", ExifInterface.Y4);
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
                gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                gZIPOutputStream.close();
                base64OutputStream.close();
                byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
            } catch (Throwable th) {
                throw th;
            }
        }
        return byteArrayOutputStream;
        throw th;
        throw th;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ HeartBeatInfoStorage j(Context context, String str) {
        return new HeartBeatInfoStorage(context, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void k() throws Exception {
        synchronized (this) {
            this.f24380a.get().m(System.currentTimeMillis(), this.f24382c.get().a());
        }
        return null;
    }

    public Task<String> a() {
        return UserManagerCompat.a(this.f24381b) ^ true ? Tasks.g("") : Tasks.d(this.f24384e, new b(this));
    }

    @NonNull
    public synchronized HeartBeatInfo.HeartBeat b(@NonNull String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HeartBeatInfoStorage heartBeatInfoStorage = this.f24380a.get();
        if (heartBeatInfoStorage.k(currentTimeMillis)) {
            heartBeatInfoStorage.i();
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }

    public Task<Void> l() {
        if (this.f24383d.size() <= 0) {
            return Tasks.g(null);
        }
        return UserManagerCompat.a(this.f24381b) ^ true ? Tasks.g(null) : Tasks.d(this.f24384e, new d(this));
    }

    @VisibleForTesting
    DefaultHeartBeatController(Provider<HeartBeatInfoStorage> provider, Set<HeartBeatConsumer> set, Executor executor, Provider<UserAgentPublisher> provider2, Context context) {
        this.f24380a = provider;
        this.f24383d = set;
        this.f24384e = executor;
        this.f24382c = provider2;
        this.f24381b = context;
    }
}
