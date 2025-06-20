package androidx.datastore.preferences;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferencesProto;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import com.itextpdf.tool.xml.html.HTML;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/datastore/preferences/PreferencesMapCompat;", "", "<init>", "()V", "a", "Companion", "datastore-preferences-proto"}, k = 1, mv = {1, 5, 1})
public final class PreferencesMapCompat {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6951a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/datastore/preferences/PreferencesMapCompat$Companion;", "", "<init>", "()V", "Ljava/io/InputStream;", "input", "Landroidx/datastore/preferences/PreferencesProto$PreferenceMap;", "a", "(Ljava/io/InputStream;)Landroidx/datastore/preferences/PreferencesProto$PreferenceMap;", "datastore-preferences-proto"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final PreferencesProto.PreferenceMap a(@NotNull InputStream inputStream) {
            Intrinsics.p(inputStream, HTML.Tag.q0);
            try {
                PreferencesProto.PreferenceMap Z2 = PreferencesProto.PreferenceMap.Z2(inputStream);
                Intrinsics.o(Z2, "{\n                PreferencesProto.PreferenceMap.parseFrom(input)\n            }");
                return Z2;
            } catch (InvalidProtocolBufferException e2) {
                throw new CorruptionException("Unable to parse preferences proto.", e2);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
