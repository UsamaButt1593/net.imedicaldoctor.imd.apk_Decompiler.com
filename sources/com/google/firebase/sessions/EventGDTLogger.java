package com.google.firebase.sessions;

import android.util.Log;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/google/firebase/sessions/EventGDTLogger;", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "Lcom/google/firebase/inject/Provider;", "Lcom/google/android/datatransport/TransportFactory;", "transportFactoryProvider", "<init>", "(Lcom/google/firebase/inject/Provider;)V", "Lcom/google/firebase/sessions/SessionEvent;", "value", "", "c", "(Lcom/google/firebase/sessions/SessionEvent;)[B", "sessionEvent", "", "a", "(Lcom/google/firebase/sessions/SessionEvent;)V", "Lcom/google/firebase/inject/Provider;", "b", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class EventGDTLogger implements EventGDTLoggerInterface {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f25057b = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final String f25058c = "EventGDTLogger";
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final String f25059d = "FIREBASE_APPQUALITY_SESSION";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TransportFactory> f25060a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/EventGDTLogger$Companion;", "", "()V", "AQS_LOG_SOURCE", "", "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EventGDTLogger(@NotNull Provider<TransportFactory> provider) {
        Intrinsics.p(provider, "transportFactoryProvider");
        this.f25060a = provider;
    }

    /* access modifiers changed from: private */
    public final byte[] c(SessionEvent sessionEvent) {
        String encode = SessionEvents.f25098a.d().encode(sessionEvent);
        Intrinsics.o(encode, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
        Log.d(f25058c, "Session Event: " + encode);
        byte[] bytes = encode.getBytes(Charsets.f29053b);
        Intrinsics.o(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public void a(@NotNull SessionEvent sessionEvent) {
        Intrinsics.p(sessionEvent, "sessionEvent");
        this.f25060a.get().b(f25059d, SessionEvent.class, Encoding.b("json"), new b(this)).a(Event.j(sessionEvent));
    }
}
