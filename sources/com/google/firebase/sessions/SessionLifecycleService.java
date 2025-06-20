package com.google.firebase.sessions;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.firebase.sessions.SessionGenerator;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0003J\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u0003R\u001a\u0010\u0014\u001a\u00020\u000f8\u0000X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleService;", "Landroid/app/Service;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Landroid/os/Messenger;", "a", "(Landroid/content/Intent;)Landroid/os/Messenger;", "", "onCreate", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "onDestroy", "Landroid/os/HandlerThread;", "s", "Landroid/os/HandlerThread;", "b", "()Landroid/os/HandlerThread;", "handlerThread", "Lcom/google/firebase/sessions/SessionLifecycleService$MessageHandler;", "X", "Lcom/google/firebase/sessions/SessionLifecycleService$MessageHandler;", "messageHandler", "Y", "Landroid/os/Messenger;", "messenger", "Z", "Companion", "MessageHandler", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class SessionLifecycleService extends Service {
    @NotNull
    public static final String X2 = "SessionLifecycleService";
    @NotNull
    public static final String Y2 = "ClientCallbackMessenger";
    @NotNull
    public static final Companion Z = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String Z2 = "SessionUpdateExtra";
    public static final int a3 = 1;
    public static final int b3 = 2;
    public static final int c3 = 3;
    private static final int d3 = 4;
    @Nullable
    private MessageHandler X;
    @Nullable
    private Messenger Y;
    @NotNull
    private final HandlerThread s = new HandlerThread("FirebaseSessions_HandlerThread");

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleService$Companion;", "", "()V", "BACKGROUNDED", "", "CLIENT_BOUND", "CLIENT_CALLBACK_MESSENGER", "", "FOREGROUNDED", "SESSION_UPDATED", "SESSION_UPDATE_EXTRA", "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @SourceDebugExtension({"SMAP\nSessionLifecycleService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionLifecycleService.kt\ncom/google/firebase/sessions/SessionLifecycleService$MessageHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,252:1\n1855#2,2:253\n1#3:255\n*S KotlinDebug\n*F\n+ 1 SessionLifecycleService.kt\ncom/google/firebase/sessions/SessionLifecycleService$MessageHandler\n*L\n145#1:253,2\n*E\n"})
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\nR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010 R$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00100\"j\b\u0012\u0004\u0012\u00020\u0010`#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010$¨\u0006&"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleService$MessageHandler;", "Landroid/os/Handler;", "Landroid/os/Looper;", "looper", "<init>", "(Landroid/os/Looper;)V", "Landroid/os/Message;", "msg", "", "d", "(Landroid/os/Message;)V", "b", "c", "g", "()V", "a", "Landroid/os/Messenger;", "client", "f", "(Landroid/os/Messenger;)V", "", "sessionId", "h", "(Landroid/os/Messenger;Ljava/lang/String;)V", "", "foregroundTimeMs", "", "e", "(J)Z", "handleMessage", "Z", "hasForegrounded", "J", "lastMsgTimeMs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "boundClients", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    public static final class MessageHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private boolean f25132a;

        /* renamed from: b  reason: collision with root package name */
        private long f25133b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<Messenger> f25134c = new ArrayList<>();

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MessageHandler(@NotNull Looper looper) {
            super(looper);
            Intrinsics.p(looper, "looper");
        }

        private final void a() {
            StringBuilder sb = new StringBuilder();
            sb.append("Broadcasting new session: ");
            SessionGenerator.Companion companion = SessionGenerator.f25110f;
            sb.append(companion.a().c());
            Log.d(SessionLifecycleService.X2, sb.toString());
            SessionFirelogPublisher.f25100a.a().a(companion.a().c());
            for (Messenger messenger : new ArrayList(this.f25134c)) {
                Intrinsics.o(messenger, "it");
                f(messenger);
            }
        }

        private final void b(Message message) {
            Log.d(SessionLifecycleService.X2, "Activity backgrounding at " + message.getWhen());
            this.f25133b = message.getWhen();
        }

        private final void c(Message message) {
            this.f25134c.add(message.replyTo);
            Messenger messenger = message.replyTo;
            Intrinsics.o(messenger, "msg.replyTo");
            f(messenger);
            Log.d(SessionLifecycleService.X2, "Client " + message.replyTo + " bound at " + message.getWhen() + ". Clients: " + this.f25134c.size());
        }

        private final void d(Message message) {
            Log.d(SessionLifecycleService.X2, "Activity foregrounding at " + message.getWhen() + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            if (!this.f25132a) {
                Log.d(SessionLifecycleService.X2, "Cold start detected.");
                this.f25132a = true;
            } else {
                if (e(message.getWhen())) {
                    Log.d(SessionLifecycleService.X2, "Session too long in background. Creating new session.");
                }
                this.f25133b = message.getWhen();
            }
            g();
            this.f25133b = message.getWhen();
        }

        private final boolean e(long j2) {
            return j2 - this.f25133b > Duration.L(SessionsSettings.f25172c.c().c());
        }

        private final void f(Messenger messenger) {
            String a2;
            if (this.f25132a) {
                a2 = SessionGenerator.f25110f.a().c().h();
            } else {
                a2 = SessionDatastore.f25079a.a().a();
                Log.d(SessionLifecycleService.X2, "App has not yet foregrounded. Using previously stored session: " + a2);
                if (a2 == null) {
                    return;
                }
            }
            h(messenger, a2);
        }

        private final void g() {
            SessionGenerator.Companion companion = SessionGenerator.f25110f;
            companion.a().a();
            Log.d(SessionLifecycleService.X2, "Generated new session " + companion.a().c().h());
            a();
            SessionDatastore.f25079a.a().b(companion.a().c().h());
        }

        private final void h(Messenger messenger, String str) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString(SessionLifecycleService.Z2, str);
                Message obtain = Message.obtain((Handler) null, 3, 0, 0);
                obtain.setData(bundle);
                messenger.send(obtain);
            } catch (DeadObjectException unused) {
                Log.d(SessionLifecycleService.X2, "Removing dead client from list: " + messenger);
                this.f25134c.remove(messenger);
            } catch (Exception e2) {
                Log.w(SessionLifecycleService.X2, "Unable to push new session to " + messenger + ClassUtils.PACKAGE_SEPARATOR_CHAR, e2);
            }
        }

        public void handleMessage(@NotNull Message message) {
            Intrinsics.p(message, NotificationCompat.G0);
            if (this.f25133b > message.getWhen()) {
                Log.d(SessionLifecycleService.X2, "Ignoring old message from " + message.getWhen() + " which is older than " + this.f25133b + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                d(message);
            } else if (i2 == 2) {
                b(message);
            } else if (i2 != 4) {
                Log.w(SessionLifecycleService.X2, "Received unexpected event from the SessionLifecycleClient: " + message);
                super.handleMessage(message);
            } else {
                c(message);
            }
        }
    }

    private final Messenger a(Intent intent) {
        return (Messenger) (Build.VERSION.SDK_INT >= 33 ? intent.getParcelableExtra(Y2, Messenger.class) : intent.getParcelableExtra(Y2));
    }

    @NotNull
    public final HandlerThread b() {
        return this.s;
    }

    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        if (intent == null) {
            Log.d(X2, "Service bound with null intent. Ignoring.");
            return null;
        }
        Log.d(X2, "Service bound to new client on process " + intent.getAction());
        Messenger a2 = a(intent);
        if (a2 != null) {
            Message obtain = Message.obtain((Handler) null, 4, 0, 0);
            obtain.replyTo = a2;
            MessageHandler messageHandler = this.X;
            if (messageHandler != null) {
                messageHandler.sendMessage(obtain);
            }
        }
        Messenger messenger = this.Y;
        if (messenger != null) {
            return messenger.getBinder();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.s.start();
        Looper looper = this.s.getLooper();
        Intrinsics.o(looper, "handlerThread.looper");
        this.X = new MessageHandler(looper);
        this.Y = new Messenger(this.X);
    }

    public void onDestroy() {
        super.onDestroy();
        this.s.quit();
    }
}
