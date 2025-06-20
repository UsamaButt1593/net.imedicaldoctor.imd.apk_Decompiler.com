package com.google.firebase.sessions;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSessionLifecycleClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionLifecycleClient.kt\ncom/google/firebase/sessions/SessionLifecycleClient\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n766#2:219\n857#2,2:220\n1963#2,14:222\n*S KotlinDebug\n*F\n+ 1 SessionLifecycleClient.kt\ncom/google/firebase/sessions/SessionLifecycleClient\n*L\n206#1:219\n206#1:220,2\n206#1:222,14\n*E\n"})
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u00010\b\u0000\u0018\u0000 42\u00020\u0001:\u000256B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0019\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\b¢\u0006\u0004\b!\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0,8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00067"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleClient;", "", "Lkotlin/coroutines/CoroutineContext;", "backgroundDispatcher", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "", "messageCode", "", "n", "(I)V", "", "Landroid/os/Message;", "messages", "Lkotlinx/coroutines/Job;", "o", "(Ljava/util/List;)Lkotlinx/coroutines/Job;", "msg", "p", "(Landroid/os/Message;)V", "m", "", "j", "()Ljava/util/List;", "msgCode", "l", "(Ljava/util/List;I)Landroid/os/Message;", "Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;", "sessionLifecycleServiceBinder", "i", "(Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;)V", "k", "()V", "h", "a", "Lkotlin/coroutines/CoroutineContext;", "Landroid/os/Messenger;", "b", "Landroid/os/Messenger;", "service", "", "c", "Z", "serviceBound", "Ljava/util/concurrent/LinkedBlockingDeque;", "d", "Ljava/util/concurrent/LinkedBlockingDeque;", "queuedMessages", "com/google/firebase/sessions/SessionLifecycleClient$serviceConnection$1", "e", "Lcom/google/firebase/sessions/SessionLifecycleClient$serviceConnection$1;", "serviceConnection", "f", "ClientUpdateHandler", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class SessionLifecycleClient {
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f25123f = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public static final String f25124g = "SessionLifecycleClient";

    /* renamed from: h  reason: collision with root package name */
    private static final int f25125h = 20;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineContext f25126a;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public Messenger f25127b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f25128c;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final LinkedBlockingDeque<Message> f25129d = new LinkedBlockingDeque<>(20);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final SessionLifecycleClient$serviceConnection$1 f25130e = new SessionLifecycleClient$serviceConnection$1(this);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleClient$ClientUpdateHandler;", "Landroid/os/Handler;", "Lkotlin/coroutines/CoroutineContext;", "backgroundDispatcher", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "", "sessionId", "", "a", "(Ljava/lang/String;)V", "Landroid/os/Message;", "msg", "handleMessage", "(Landroid/os/Message;)V", "Lkotlin/coroutines/CoroutineContext;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    public static final class ClientUpdateHandler extends Handler {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final CoroutineContext f25131a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClientUpdateHandler(@NotNull CoroutineContext coroutineContext) {
            super(Looper.getMainLooper());
            Intrinsics.p(coroutineContext, "backgroundDispatcher");
            this.f25131a = coroutineContext;
        }

        private final void a(String str) {
            Log.d(SessionLifecycleClient.f25124g, "Session update received: " + str);
            Job unused = BuildersKt__Builders_commonKt.f(CoroutineScopeKt.a(this.f25131a), (CoroutineContext) null, (CoroutineStart) null, new SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1(str, (Continuation<? super SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1>) null), 3, (Object) null);
        }

        public void handleMessage(@NotNull Message message) {
            String str;
            Intrinsics.p(message, NotificationCompat.G0);
            if (message.what == 3) {
                Bundle data = message.getData();
                if (data == null || (str = data.getString(SessionLifecycleService.Z2)) == null) {
                    str = "";
                }
                a(str);
                return;
            }
            Log.w(SessionLifecycleClient.f25124g, "Received unexpected event from the SessionLifecycleService: " + message);
            super.handleMessage(message);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleClient$Companion;", "", "()V", "MAX_QUEUED_MESSAGES", "", "TAG", "", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionLifecycleClient(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.p(coroutineContext, "backgroundDispatcher");
        this.f25126a = coroutineContext;
    }

    /* access modifiers changed from: private */
    public final List<Message> j() {
        ArrayList arrayList = new ArrayList();
        this.f25129d.drainTo(arrayList);
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.os.Message} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Message l(java.util.List<android.os.Message> r7, int r8) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x0009:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x001e
            java.lang.Object r1 = r7.next()
            r2 = r1
            android.os.Message r2 = (android.os.Message) r2
            int r2 = r2.what
            if (r2 != r8) goto L_0x0009
            r0.add(r1)
            goto L_0x0009
        L_0x001e:
            java.util.Iterator r7 = r0.iterator()
            boolean r8 = r7.hasNext()
            if (r8 != 0) goto L_0x002a
            r7 = 0
            goto L_0x0055
        L_0x002a:
            java.lang.Object r8 = r7.next()
            boolean r0 = r7.hasNext()
            if (r0 != 0) goto L_0x0036
        L_0x0034:
            r7 = r8
            goto L_0x0055
        L_0x0036:
            r0 = r8
            android.os.Message r0 = (android.os.Message) r0
            long r0 = r0.getWhen()
        L_0x003d:
            java.lang.Object r2 = r7.next()
            r3 = r2
            android.os.Message r3 = (android.os.Message) r3
            long r3 = r3.getWhen()
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x004e
            r8 = r2
            r0 = r3
        L_0x004e:
            boolean r2 = r7.hasNext()
            if (r2 != 0) goto L_0x003d
            goto L_0x0034
        L_0x0055:
            android.os.Message r7 = (android.os.Message) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionLifecycleClient.l(java.util.List, int):android.os.Message");
    }

    private final void m(Message message) {
        StringBuilder sb;
        if (this.f25129d.offer(message)) {
            sb = new StringBuilder();
            sb.append("Queued message ");
            sb.append(message.what);
            sb.append(". Queue size ");
            sb.append(this.f25129d.size());
        } else {
            sb = new StringBuilder();
            sb.append("Failed to enqueue message ");
            sb.append(message.what);
            sb.append(". Dropping.");
        }
        Log.d(f25124g, sb.toString());
    }

    private final void n(int i2) {
        List<Message> j2 = j();
        Message obtain = Message.obtain((Handler) null, i2, 0, 0);
        Intrinsics.o(obtain, "obtain(null, messageCode, 0, 0)");
        j2.add(obtain);
        o(j2);
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public final Job o(List<Message> list) {
        return BuildersKt__Builders_commonKt.f(CoroutineScopeKt.a(this.f25126a), (CoroutineContext) null, (CoroutineStart) null, new SessionLifecycleClient$sendLifecycleEvents$1(this, list, (Continuation<? super SessionLifecycleClient$sendLifecycleEvents$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void p(Message message) {
        if (this.f25127b != null) {
            try {
                Log.d(f25124g, "Sending lifecycle " + message.what + " to service");
                Messenger messenger = this.f25127b;
                if (messenger != null) {
                    messenger.send(message);
                    return;
                }
                return;
            } catch (RemoteException e2) {
                Log.w(f25124g, "Unable to deliver message: " + message.what, e2);
            }
        }
        m(message);
    }

    public final void h() {
        n(2);
    }

    public final void i(@NotNull SessionLifecycleServiceBinder sessionLifecycleServiceBinder) {
        Intrinsics.p(sessionLifecycleServiceBinder, "sessionLifecycleServiceBinder");
        sessionLifecycleServiceBinder.a(new Messenger(new ClientUpdateHandler(this.f25126a)), this.f25130e);
    }

    public final void k() {
        n(1);
    }
}
