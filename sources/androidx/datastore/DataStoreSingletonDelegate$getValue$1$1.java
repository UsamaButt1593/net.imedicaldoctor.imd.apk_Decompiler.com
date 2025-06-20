package androidx.datastore;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "T"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class DataStoreSingletonDelegate$getValue$1$1 extends Lambda implements Function0<File> {
    final /* synthetic */ Context X;
    final /* synthetic */ DataStoreSingletonDelegate<T> Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreSingletonDelegate$getValue$1$1(Context context, DataStoreSingletonDelegate<T> dataStoreSingletonDelegate) {
        super(0);
        this.X = context;
        this.Y = dataStoreSingletonDelegate;
    }

    @NotNull
    /* renamed from: b */
    public final File o() {
        Context context = this.X;
        Intrinsics.o(context, "applicationContext");
        return DataStoreFile.a(context, this.Y.f6894a);
    }
}
