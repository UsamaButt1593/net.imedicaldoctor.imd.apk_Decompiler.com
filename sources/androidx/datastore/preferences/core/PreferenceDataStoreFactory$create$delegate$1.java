package androidx.datastore.preferences.core;

import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Ljava/io/File;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class PreferenceDataStoreFactory$create$delegate$1 extends Lambda implements Function0<File> {
    final /* synthetic */ Function0<File> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferenceDataStoreFactory$create$delegate$1(Function0<? extends File> function0) {
        super(0);
        this.X = function0;
    }

    @NotNull
    /* renamed from: b */
    public final File o() {
        File o = this.X.o();
        String Y = FilesKt.Y(o);
        PreferencesSerializer preferencesSerializer = PreferencesSerializer.f6962a;
        if (Intrinsics.g(Y, preferencesSerializer.c())) {
            return o;
        }
        throw new IllegalStateException(("File extension for file: " + o + " does not match required extension for Preferences file: " + preferencesSerializer.c()).toString());
    }
}
