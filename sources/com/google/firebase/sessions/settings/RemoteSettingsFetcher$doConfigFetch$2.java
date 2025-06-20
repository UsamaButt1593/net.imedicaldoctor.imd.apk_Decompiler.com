package com.google.firebase.sessions.settings;

import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nRemoteSettingsFetcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteSettingsFetcher.kt\ncom/google/firebase/sessions/settings/RemoteSettingsFetcher$doConfigFetch$2\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n215#2,2:101\n1#3:103\n*S KotlinDebug\n*F\n+ 1 RemoteSettingsFetcher.kt\ncom/google/firebase/sessions/settings/RemoteSettingsFetcher$doConfigFetch$2\n*L\n53#1:101,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2", f = "RemoteSettingsFetcher.kt", i = {}, l = {68, 70, 73}, m = "invokeSuspend", n = {}, s = {})
final class RemoteSettingsFetcher$doConfigFetch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int X2;
    final /* synthetic */ RemoteSettingsFetcher Y2;
    final /* synthetic */ Map<String, String> Z2;
    final /* synthetic */ Function2<JSONObject, Continuation<? super Unit>, Object> a3;
    final /* synthetic */ Function2<String, Continuation<? super Unit>, Object> b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteSettingsFetcher$doConfigFetch$2(RemoteSettingsFetcher remoteSettingsFetcher, Map<String, String> map, Function2<? super JSONObject, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super RemoteSettingsFetcher$doConfigFetch$2> continuation) {
        super(2, continuation);
        this.Y2 = remoteSettingsFetcher;
        this.Z2 = map;
        this.a3 = function2;
        this.b3 = function22;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            URLConnection openConnection = this.Y2.c().openConnection();
            Intrinsics.n(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setRequestProperty(HttpHeaders.f22880h, "application/json");
            for (Map.Entry next : this.Z2.entrySet()) {
                httpsURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpsURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                while (true) {
                    T readLine = bufferedReader.readLine();
                    objectRef.s = readLine;
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                bufferedReader.close();
                inputStream.close();
                JSONObject jSONObject = new JSONObject(sb.toString());
                Function2<JSONObject, Continuation<? super Unit>, Object> function2 = this.a3;
                this.X2 = 1;
                if (function2.d0(jSONObject, this) == l2) {
                    return l2;
                }
            } else {
                Function2<String, Continuation<? super Unit>, Object> function22 = this.b3;
                String str = "Bad response code: " + responseCode;
                this.X2 = 2;
                if (function22.d0(str, this) == l2) {
                    return l2;
                }
            }
        } else if (i2 == 1 || i2 == 2) {
            try {
                ResultKt.n(obj);
            } catch (Exception e2) {
                Function2<String, Continuation<? super Unit>, Object> function23 = this.b3;
                String message = e2.getMessage();
                if (message == null) {
                    message = e2.toString();
                }
                this.X2 = 3;
                if (function23.d0(message, this) == l2) {
                    return l2;
                }
            }
        } else if (i2 == 3) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RemoteSettingsFetcher$doConfigFetch$2) v(coroutineScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RemoteSettingsFetcher$doConfigFetch$2(this.Y2, this.Z2, this.a3, this.b3, continuation);
    }
}
