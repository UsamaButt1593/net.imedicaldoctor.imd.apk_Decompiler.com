package com.google.firebase.sessions;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleServiceBinderImpl;", "Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;", "Lcom/google/firebase/FirebaseApp;", "firebaseApp", "<init>", "(Lcom/google/firebase/FirebaseApp;)V", "Landroid/content/Context;", "appContext", "Landroid/content/ServiceConnection;", "serviceConnection", "", "b", "(Landroid/content/Context;Landroid/content/ServiceConnection;)Ljava/lang/Object;", "Landroid/os/Messenger;", "callback", "", "a", "(Landroid/os/Messenger;Landroid/content/ServiceConnection;)V", "Lcom/google/firebase/FirebaseApp;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class SessionLifecycleServiceBinderImpl implements SessionLifecycleServiceBinder {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Companion f25135b = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final String f25136c = "LifecycleServiceBinder";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f25137a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleServiceBinderImpl$Companion;", "", "()V", "TAG", "", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionLifecycleServiceBinderImpl(@NotNull FirebaseApp firebaseApp) {
        Intrinsics.p(firebaseApp, "firebaseApp");
        this.f25137a = firebaseApp;
    }

    private final Object b(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
            return Unit.f28779a;
        } catch (IllegalArgumentException e2) {
            return Integer.valueOf(Log.w(f25136c, "Session lifecycle service binding failed.", e2));
        }
    }

    public void a(@NotNull Messenger messenger, @NotNull ServiceConnection serviceConnection) {
        boolean z;
        Intrinsics.p(messenger, "callback");
        Intrinsics.p(serviceConnection, "serviceConnection");
        Context applicationContext = this.f25137a.n().getApplicationContext();
        Intent intent = new Intent(applicationContext, SessionLifecycleService.class);
        Log.d(f25136c, "Binding service to application.");
        intent.setAction(String.valueOf(Process.myPid()));
        intent.putExtra(SessionLifecycleService.Y2, messenger);
        try {
            z = applicationContext.bindService(intent, serviceConnection, 65);
        } catch (SecurityException e2) {
            Log.w(f25136c, "Failed to bind session lifecycle service to application.", e2);
            z = false;
        }
        if (!z) {
            Intrinsics.o(applicationContext, "appContext");
            b(applicationContext, serviceConnection);
            Log.i(f25136c, "Session lifecycle service binding failed.");
        }
    }
}
