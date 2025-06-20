package com.google.firebase.sessions.api;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.dd.plist.ASCIIPropertyListParser;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFirebaseSessionsDependencies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirebaseSessionsDependencies.kt\ncom/google/firebase/sessions/api/FirebaseSessionsDependencies\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,114:1\n442#2:115\n392#2:116\n1238#3,2:117\n1241#3:129\n107#4,10:119\n*S KotlinDebug\n*F\n+ 1 FirebaseSessionsDependencies.kt\ncom/google/firebase/sessions/api/FirebaseSessionsDependencies\n*L\n89#1:115\n89#1:116\n89#1:117,2\n89#1:129\n90#1:119,10\n*E\n"})
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0010H@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0015\u0010\u0003R\u0014\u0010\u0018\u001a\u00020\u00168\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017RT\u0010\u001c\u001aB\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\r0\r \u001a* \u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\r0\r\u0018\u00010\u00100\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies;", "", "<init>", "()V", "Lcom/google/firebase/sessions/api/SessionSubscriber$Name;", "subscriberName", "", "a", "(Lcom/google/firebase/sessions/api/SessionSubscriber$Name;)V", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "subscriber", "e", "(Lcom/google/firebase/sessions/api/SessionSubscriber;)V", "Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies$Dependency;", "b", "(Lcom/google/firebase/sessions/api/SessionSubscriber$Name;)Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies$Dependency;", "", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Lcom/google/firebase/sessions/api/SessionSubscriber$Name;)Lcom/google/firebase/sessions/api/SessionSubscriber;", "f", "", "Ljava/lang/String;", "TAG", "", "kotlin.jvm.PlatformType", "Ljava/util/Map;", "dependencies", "Dependency", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class FirebaseSessionsDependencies {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final FirebaseSessionsDependencies f25140a = new FirebaseSessionsDependencies();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f25141b = "SessionsDependencies";

    /* renamed from: c  reason: collision with root package name */
    private static final Map<SessionSubscriber.Name, Dependency> f25142c = Collections.synchronizedMap(new LinkedHashMap());

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\tR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies$Dependency;", "", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "subscriber", "<init>", "(Lkotlinx/coroutines/sync/Mutex;Lcom/google/firebase/sessions/api/SessionSubscriber;)V", "a", "()Lkotlinx/coroutines/sync/Mutex;", "b", "()Lcom/google/firebase/sessions/api/SessionSubscriber;", "c", "(Lkotlinx/coroutines/sync/Mutex;Lcom/google/firebase/sessions/api/SessionSubscriber;)Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies$Dependency;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/sync/Mutex;", "e", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "f", "g", "(Lcom/google/firebase/sessions/api/SessionSubscriber;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    private static final class Dependency {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Mutex f25143a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private SessionSubscriber f25144b;

        public Dependency(@NotNull Mutex mutex, @Nullable SessionSubscriber sessionSubscriber) {
            Intrinsics.p(mutex, "mutex");
            this.f25143a = mutex;
            this.f25144b = sessionSubscriber;
        }

        public static /* synthetic */ Dependency d(Dependency dependency, Mutex mutex, SessionSubscriber sessionSubscriber, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mutex = dependency.f25143a;
            }
            if ((i2 & 2) != 0) {
                sessionSubscriber = dependency.f25144b;
            }
            return dependency.c(mutex, sessionSubscriber);
        }

        @NotNull
        public final Mutex a() {
            return this.f25143a;
        }

        @Nullable
        public final SessionSubscriber b() {
            return this.f25144b;
        }

        @NotNull
        public final Dependency c(@NotNull Mutex mutex, @Nullable SessionSubscriber sessionSubscriber) {
            Intrinsics.p(mutex, "mutex");
            return new Dependency(mutex, sessionSubscriber);
        }

        @NotNull
        public final Mutex e() {
            return this.f25143a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dependency)) {
                return false;
            }
            Dependency dependency = (Dependency) obj;
            return Intrinsics.g(this.f25143a, dependency.f25143a) && Intrinsics.g(this.f25144b, dependency.f25144b);
        }

        @Nullable
        public final SessionSubscriber f() {
            return this.f25144b;
        }

        public final void g(@Nullable SessionSubscriber sessionSubscriber) {
            this.f25144b = sessionSubscriber;
        }

        public int hashCode() {
            int hashCode = this.f25143a.hashCode() * 31;
            SessionSubscriber sessionSubscriber = this.f25144b;
            return hashCode + (sessionSubscriber == null ? 0 : sessionSubscriber.hashCode());
        }

        @NotNull
        public String toString() {
            return "Dependency(mutex=" + this.f25143a + ", subscriber=" + this.f25144b + ASCIIPropertyListParser.f18650h;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Dependency(Mutex mutex, SessionSubscriber sessionSubscriber, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(mutex, (i2 & 2) != 0 ? null : sessionSubscriber);
        }
    }

    private FirebaseSessionsDependencies() {
    }

    @JvmStatic
    public static final void a(@NotNull SessionSubscriber.Name name) {
        StringBuilder sb;
        String str;
        Intrinsics.p(name, "subscriberName");
        if (name != SessionSubscriber.Name.PERFORMANCE) {
            Map<SessionSubscriber.Name, Dependency> map = f25142c;
            if (map.containsKey(name)) {
                sb = new StringBuilder();
                sb.append("Dependency ");
                sb.append(name);
                str = " already added.";
            } else {
                Intrinsics.o(map, "dependencies");
                map.put(name, new Dependency(MutexKt.a(true), (SessionSubscriber) null, 2, (DefaultConstructorMarker) null));
                sb = new StringBuilder();
                sb.append("Dependency to ");
                sb.append(name);
                str = " added.";
            }
            sb.append(str);
            Log.d(f25141b, sb.toString());
            return;
        }
        throw new IllegalArgumentException("Incompatible versions of Firebase Perf and Firebase Sessions.\nA safe combination would be:\n  firebase-sessions:1.1.0\n  firebase-crashlytics:18.5.0\n  firebase-perf:20.5.0\nFor more information contact Firebase Support.");
    }

    private final Dependency b(SessionSubscriber.Name name) {
        Map<SessionSubscriber.Name, Dependency> map = f25142c;
        Intrinsics.o(map, "dependencies");
        Dependency dependency = map.get(name);
        if (dependency != null) {
            Intrinsics.o(dependency, "dependencies.getOrElse(s…load time.\"\n      )\n    }");
            return dependency;
        }
        throw new IllegalStateException("Cannot get dependency " + name + ". Dependencies should be added at class load time.");
    }

    @JvmStatic
    public static final void e(@NotNull SessionSubscriber sessionSubscriber) {
        Intrinsics.p(sessionSubscriber, "subscriber");
        SessionSubscriber.Name b2 = sessionSubscriber.b();
        Dependency b3 = f25140a.b(b2);
        if (b3.f() != null) {
            Log.d(f25141b, "Subscriber " + b2 + " already registered.");
            return;
        }
        b3.g(sessionSubscriber);
        Log.d(f25141b, "Subscriber " + b2 + " registered.");
        Mutex.DefaultImpls.d(b3.e(), (Object) null, 1, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.google.firebase.sessions.api.SessionSubscriber$Name} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Map<com.google.firebase.sessions.api.SessionSubscriber.Name, ? extends com.google.firebase.sessions.api.SessionSubscriber>> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1 r0 = (com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1) r0
            int r1 = r0.e3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e3 = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1 r0 = new com.google.firebase.sessions.api.FirebaseSessionsDependencies$getRegisteredSubscribers$1
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.c3
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.e3
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r2 = r0.b3
            java.lang.Object r5 = r0.a3
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r0.Z2
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r0.Y2
            com.google.firebase.sessions.api.SessionSubscriber$Name r7 = (com.google.firebase.sessions.api.SessionSubscriber.Name) r7
            java.lang.Object r8 = r0.X2
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.Z
            java.util.Map r9 = (java.util.Map) r9
            kotlin.ResultKt.n(r11)
            goto L_0x00a0
        L_0x0040:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0048:
            kotlin.ResultKt.n(r11)
            java.util.Map<com.google.firebase.sessions.api.SessionSubscriber$Name, com.google.firebase.sessions.api.FirebaseSessionsDependencies$Dependency> r11 = f25142c
            java.lang.String r2 = "dependencies"
            kotlin.jvm.internal.Intrinsics.o(r11, r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r5 = r11.size()
            int r5 = kotlin.collections.MapsKt.j(r5)
            r2.<init>(r5)
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
            r8 = r11
            r5 = r2
        L_0x0069:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x00b3
            java.lang.Object r11 = r8.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r2 = r11.getKey()
            java.lang.Object r6 = r11.getKey()
            r7 = r6
            com.google.firebase.sessions.api.SessionSubscriber$Name r7 = (com.google.firebase.sessions.api.SessionSubscriber.Name) r7
            java.lang.Object r11 = r11.getValue()
            com.google.firebase.sessions.api.FirebaseSessionsDependencies$Dependency r11 = (com.google.firebase.sessions.api.FirebaseSessionsDependencies.Dependency) r11
            kotlinx.coroutines.sync.Mutex r6 = r11.e()
            r0.Z = r5
            r0.X2 = r8
            r0.Y2 = r7
            r0.Z2 = r6
            r0.a3 = r5
            r0.b3 = r2
            r0.e3 = r3
            java.lang.Object r11 = r6.c(r4, r0)
            if (r11 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r9 = r5
        L_0x00a0:
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r11 = f25140a     // Catch:{ all -> 0x00ae }
            com.google.firebase.sessions.api.SessionSubscriber r11 = r11.d(r7)     // Catch:{ all -> 0x00ae }
            r6.d(r4)
            r5.put(r2, r11)
            r5 = r9
            goto L_0x0069
        L_0x00ae:
            r11 = move-exception
            r6.d(r4)
            throw r11
        L_0x00b3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.api.FirebaseSessionsDependencies.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    @VisibleForTesting
    public final SessionSubscriber d(@NotNull SessionSubscriber.Name name) {
        Intrinsics.p(name, "subscriberName");
        SessionSubscriber f2 = b(name).f();
        if (f2 != null) {
            return f2;
        }
        throw new IllegalStateException("Subscriber " + name + " has not been registered.");
    }

    @VisibleForTesting
    public final void f() {
        f25142c.clear();
    }
}
