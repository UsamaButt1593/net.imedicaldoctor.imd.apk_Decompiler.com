package androidx.datastore.preferences;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Ljava/io/File;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class PreferenceDataStoreSingletonDelegate$getValue$1$1 extends Lambda implements Function0<File> {
    final /* synthetic */ Context X;
    final /* synthetic */ PreferenceDataStoreSingletonDelegate Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferenceDataStoreSingletonDelegate$getValue$1$1(Context context, PreferenceDataStoreSingletonDelegate preferenceDataStoreSingletonDelegate) {
        super(0);
        this.X = context;
        this.Y = preferenceDataStoreSingletonDelegate;
    }

    @NotNull
    /* renamed from: b */
    public final File o() {
        Context context = this.X;
        Intrinsics.o(context, "applicationContext");
        return PreferenceDataStoreFile.a(context, this.Y.f6945a);
    }
}
