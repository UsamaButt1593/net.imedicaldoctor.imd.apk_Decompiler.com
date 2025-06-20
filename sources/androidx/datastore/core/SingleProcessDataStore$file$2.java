package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import java.io.File;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "T"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class SingleProcessDataStore$file$2 extends Lambda implements Function0<File> {
    final /* synthetic */ SingleProcessDataStore<T> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$file$2(SingleProcessDataStore<T> singleProcessDataStore) {
        super(0);
        this.X = singleProcessDataStore;
    }

    @NotNull
    /* renamed from: b */
    public final File o() {
        File file = (File) this.X.f6914a.o();
        String absolutePath = file.getAbsolutePath();
        SingleProcessDataStore.Companion companion = SingleProcessDataStore.f6911k;
        synchronized (companion.b()) {
            if (!companion.a().contains(absolutePath)) {
                Set<String> a2 = companion.a();
                Intrinsics.o(absolutePath, "it");
                a2.add(absolutePath);
            } else {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
        }
        return file;
    }
}
