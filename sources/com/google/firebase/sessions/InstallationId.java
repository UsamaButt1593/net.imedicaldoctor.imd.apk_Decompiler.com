package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\b\u001a\u0004\b\u0007\u0010\n¨\u0006\r"}, d2 = {"Lcom/google/firebase/sessions/InstallationId;", "", "", "fid", "authToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "c", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class InstallationId {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f25066c = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final String f25067d = "InstallationId";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f25068a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f25069b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/InstallationId$Companion;", "", "<init>", "()V", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "firebaseInstallations", "Lcom/google/firebase/sessions/InstallationId;", "a", "(Lcom/google/firebase/installations/FirebaseInstallationsApi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "TAG", "Ljava/lang/String;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0089 A[Catch:{ Exception -> 0x0034 }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(@org.jetbrains.annotations.NotNull com.google.firebase.installations.FirebaseInstallationsApi r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.google.firebase.sessions.InstallationId> r10) {
            /*
                r8 = this;
                boolean r0 = r10 instanceof com.google.firebase.sessions.InstallationId$Companion$create$1
                if (r0 == 0) goto L_0x0013
                r0 = r10
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = (com.google.firebase.sessions.InstallationId$Companion$create$1) r0
                int r1 = r0.Z2
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.Z2 = r1
                goto L_0x0018
            L_0x0013:
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = new com.google.firebase.sessions.InstallationId$Companion$create$1
                r0.<init>(r8, r10)
            L_0x0018:
                java.lang.Object r10 = r0.X2
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
                int r2 = r0.Z2
                java.lang.String r3 = ""
                java.lang.String r4 = "InstallationId"
                r5 = 2
                r6 = 1
                if (r2 == 0) goto L_0x0048
                if (r2 == r6) goto L_0x003e
                if (r2 != r5) goto L_0x0036
                java.lang.Object r9 = r0.Z
                java.lang.String r9 = (java.lang.String) r9
                kotlin.ResultKt.n(r10)     // Catch:{ Exception -> 0x0034 }
                goto L_0x008a
            L_0x0034:
                r10 = move-exception
                goto L_0x0093
            L_0x0036:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L_0x003e:
                java.lang.Object r9 = r0.Z
                com.google.firebase.installations.FirebaseInstallationsApi r9 = (com.google.firebase.installations.FirebaseInstallationsApi) r9
                kotlin.ResultKt.n(r10)     // Catch:{ Exception -> 0x0046 }
                goto L_0x0060
            L_0x0046:
                r10 = move-exception
                goto L_0x006f
            L_0x0048:
                kotlin.ResultKt.n(r10)
                r10 = 0
                com.google.android.gms.tasks.Task r10 = r9.c(r10)     // Catch:{ Exception -> 0x0046 }
                java.lang.String r2 = "firebaseInstallations.getToken(false)"
                kotlin.jvm.internal.Intrinsics.o(r10, r2)     // Catch:{ Exception -> 0x0046 }
                r0.Z = r9     // Catch:{ Exception -> 0x0046 }
                r0.Z2 = r6     // Catch:{ Exception -> 0x0046 }
                java.lang.Object r10 = kotlinx.coroutines.tasks.TasksKt.i(r10, r0)     // Catch:{ Exception -> 0x0046 }
                if (r10 != r1) goto L_0x0060
                return r1
            L_0x0060:
                com.google.firebase.installations.InstallationTokenResult r10 = (com.google.firebase.installations.InstallationTokenResult) r10     // Catch:{ Exception -> 0x0046 }
                java.lang.String r10 = r10.b()     // Catch:{ Exception -> 0x0046 }
                java.lang.String r2 = "{\n          firebaseInst…).await().token\n        }"
                kotlin.jvm.internal.Intrinsics.o(r10, r2)     // Catch:{ Exception -> 0x0046 }
                r7 = r10
                r10 = r9
                r9 = r7
                goto L_0x0076
            L_0x006f:
                java.lang.String r2 = "Error getting authentication token."
                android.util.Log.w(r4, r2, r10)
                r10 = r9
                r9 = r3
            L_0x0076:
                com.google.android.gms.tasks.Task r10 = r10.getId()     // Catch:{ Exception -> 0x0034 }
                java.lang.String r2 = "firebaseInstallations.id"
                kotlin.jvm.internal.Intrinsics.o(r10, r2)     // Catch:{ Exception -> 0x0034 }
                r0.Z = r9     // Catch:{ Exception -> 0x0034 }
                r0.Z2 = r5     // Catch:{ Exception -> 0x0034 }
                java.lang.Object r10 = kotlinx.coroutines.tasks.TasksKt.i(r10, r0)     // Catch:{ Exception -> 0x0034 }
                if (r10 != r1) goto L_0x008a
                return r1
            L_0x008a:
                java.lang.String r0 = "{\n          firebaseInst…ions.id.await()\n        }"
                kotlin.jvm.internal.Intrinsics.o(r10, r0)     // Catch:{ Exception -> 0x0034 }
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0034 }
                r3 = r10
                goto L_0x0098
            L_0x0093:
                java.lang.String r0 = "Error getting Firebase installation id ."
                android.util.Log.w(r4, r0, r10)
            L_0x0098:
                com.google.firebase.sessions.InstallationId r10 = new com.google.firebase.sessions.InstallationId
                r0 = 0
                r10.<init>(r3, r9, r0)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.InstallationId.Companion.a(com.google.firebase.installations.FirebaseInstallationsApi, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private InstallationId(String str, String str2) {
        this.f25068a = str;
        this.f25069b = str2;
    }

    @NotNull
    public final String a() {
        return this.f25069b;
    }

    @NotNull
    public final String b() {
        return this.f25068a;
    }

    public /* synthetic */ InstallationId(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }
}
