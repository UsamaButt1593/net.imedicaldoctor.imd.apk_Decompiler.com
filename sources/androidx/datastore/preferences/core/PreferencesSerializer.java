package androidx.datastore.preferences.core;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import androidx.datastore.preferences.PreferencesMapCompat;
import androidx.datastore.preferences.PreferencesProto;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\u00020\n8\u0006XD¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/datastore/preferences/core/PreferencesSerializer;", "Landroidx/datastore/core/Serializer;", "Landroidx/datastore/preferences/core/Preferences;", "<init>", "()V", "", "value", "Landroidx/datastore/preferences/PreferencesProto$Value;", "d", "(Ljava/lang/Object;)Landroidx/datastore/preferences/PreferencesProto$Value;", "", "name", "Landroidx/datastore/preferences/core/MutablePreferences;", "mutablePreferences", "", "a", "(Ljava/lang/String;Landroidx/datastore/preferences/PreferencesProto$Value;Landroidx/datastore/preferences/core/MutablePreferences;)V", "Ljava/io/InputStream;", "input", "p", "(Ljava/io/InputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "Ljava/io/OutputStream;", "output", "e", "(Landroidx/datastore/preferences/core/Preferences;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "fileExtension", "()Landroidx/datastore/preferences/core/Preferences;", "defaultValue", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
public final class PreferencesSerializer implements Serializer<Preferences> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final PreferencesSerializer f6962a = new PreferencesSerializer();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f6963b = "preferences_pb";

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6964a;

        static {
            int[] iArr = new int[PreferencesProto.Value.ValueCase.values().length];
            iArr[PreferencesProto.Value.ValueCase.BOOLEAN.ordinal()] = 1;
            iArr[PreferencesProto.Value.ValueCase.FLOAT.ordinal()] = 2;
            iArr[PreferencesProto.Value.ValueCase.DOUBLE.ordinal()] = 3;
            iArr[PreferencesProto.Value.ValueCase.INTEGER.ordinal()] = 4;
            iArr[PreferencesProto.Value.ValueCase.LONG.ordinal()] = 5;
            iArr[PreferencesProto.Value.ValueCase.STRING.ordinal()] = 6;
            iArr[PreferencesProto.Value.ValueCase.STRING_SET.ordinal()] = 7;
            iArr[PreferencesProto.Value.ValueCase.VALUE_NOT_SET.ordinal()] = 8;
            f6964a = iArr;
        }
    }

    private PreferencesSerializer() {
    }

    private final void a(String str, PreferencesProto.Value value, MutablePreferences mutablePreferences) {
        Preferences.Key a2;
        Object valueOf;
        PreferencesProto.Value.ValueCase E0 = value.E0();
        switch (E0 == null ? -1 : WhenMappings.f6964a[E0.ordinal()]) {
            case -1:
                throw new CorruptionException("Value case is null.", (Throwable) null, 2, (DefaultConstructorMarker) null);
            case 1:
                a2 = PreferencesKeys.a(str);
                valueOf = Boolean.valueOf(value.n0());
                break;
            case 2:
                a2 = PreferencesKeys.c(str);
                valueOf = Float.valueOf(value.u1());
                break;
            case 3:
                a2 = PreferencesKeys.b(str);
                valueOf = Double.valueOf(value.G());
                break;
            case 4:
                a2 = PreferencesKeys.d(str);
                valueOf = Integer.valueOf(value.y());
                break;
            case 5:
                a2 = PreferencesKeys.e(str);
                valueOf = Long.valueOf(value.Y());
                break;
            case 6:
                a2 = PreferencesKeys.f(str);
                valueOf = value.Q();
                Intrinsics.o(valueOf, "value.string");
                break;
            case 7:
                a2 = PreferencesKeys.g(str);
                List y1 = value.z().y1();
                Intrinsics.o(y1, "value.stringSet.stringsList");
                valueOf = CollectionsKt.X5(y1);
                break;
            case 8:
                throw new CorruptionException("Value not set.", (Throwable) null, 2, (DefaultConstructorMarker) null);
            default:
                throw new NoWhenBranchMatchedException();
        }
        mutablePreferences.o(a2, valueOf);
    }

    private final PreferencesProto.Value d(Object obj) {
        GeneratedMessageLite c3;
        String str;
        if (obj instanceof Boolean) {
            c3 = PreferencesProto.Value.o3().x3(((Boolean) obj).booleanValue()).build();
            str = "newBuilder().setBoolean(value).build()";
        } else if (obj instanceof Float) {
            c3 = PreferencesProto.Value.o3().z3(((Number) obj).floatValue()).build();
            str = "newBuilder().setFloat(value).build()";
        } else if (obj instanceof Double) {
            c3 = PreferencesProto.Value.o3().y3(((Number) obj).doubleValue()).build();
            str = "newBuilder().setDouble(value).build()";
        } else if (obj instanceof Integer) {
            c3 = PreferencesProto.Value.o3().A3(((Number) obj).intValue()).build();
            str = "newBuilder().setInteger(value).build()";
        } else if (obj instanceof Long) {
            c3 = PreferencesProto.Value.o3().B3(((Number) obj).longValue()).build();
            str = "newBuilder().setLong(value).build()";
        } else if (obj instanceof String) {
            c3 = PreferencesProto.Value.o3().C3((String) obj).build();
            str = "newBuilder().setString(value).build()";
        } else if (obj instanceof Set) {
            c3 = PreferencesProto.Value.o3().E3(PreferencesProto.StringSet.X2().o3((Set) obj)).build();
            str = "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()";
        } else {
            throw new IllegalStateException(Intrinsics.C("PreferencesSerializer does not support type: ", obj.getClass().getName()));
        }
        Intrinsics.o(c3, str);
        return (PreferencesProto.Value) c3;
    }

    @NotNull
    /* renamed from: b */
    public Preferences n() {
        return PreferencesFactory.b();
    }

    @NotNull
    public final String c() {
        return f6963b;
    }

    @Nullable
    /* renamed from: e */
    public Object o(@NotNull Preferences preferences, @NotNull OutputStream outputStream, @NotNull Continuation<? super Unit> continuation) throws IOException, CorruptionException {
        Map<Preferences.Key<?>, Object> a2 = preferences.a();
        PreferencesProto.PreferenceMap.Builder R2 = PreferencesProto.PreferenceMap.R2();
        for (Map.Entry next : a2.entrySet()) {
            R2.q3(((Preferences.Key) next.getKey()).a(), d(next.getValue()));
        }
        ((PreferencesProto.PreferenceMap) R2.build()).K(outputStream);
        return Unit.f28779a;
    }

    @Nullable
    public Object p(@NotNull InputStream inputStream, @NotNull Continuation<? super Preferences> continuation) throws IOException, CorruptionException {
        PreferencesProto.PreferenceMap a2 = PreferencesMapCompat.f6951a.a(inputStream);
        MutablePreferences c2 = PreferencesFactory.c(new Preferences.Pair[0]);
        Map<String, PreferencesProto.Value> w2 = a2.w2();
        Intrinsics.o(w2, "preferencesProto.preferencesMap");
        for (Map.Entry next : w2.entrySet()) {
            String str = (String) next.getKey();
            PreferencesProto.Value value = (PreferencesProto.Value) next.getValue();
            PreferencesSerializer preferencesSerializer = f6962a;
            Intrinsics.o(str, "name");
            Intrinsics.o(value, "value");
            preferencesSerializer.a(str, value, c2);
        }
        return c2.e();
    }
}
