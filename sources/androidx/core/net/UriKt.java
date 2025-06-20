package androidx.core.net;

import android.net.Uri;
import com.itextpdf.text.Annotation;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0004H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0004*\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "Landroid/net/Uri;", "c", "(Ljava/lang/String;)Landroid/net/Uri;", "Ljava/io/File;", "b", "(Ljava/io/File;)Landroid/net/Uri;", "a", "(Landroid/net/Uri;)Ljava/io/File;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nUri.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Uri.kt\nandroidx/core/net/UriKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,46:1\n1#2:47\n*E\n"})
public final class UriKt {
    @NotNull
    public static final File a(@NotNull Uri uri) {
        if (Intrinsics.g(uri.getScheme(), Annotation.k3)) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
    }

    @NotNull
    public static final Uri b(@NotNull File file) {
        return Uri.fromFile(file);
    }

    @NotNull
    public static final Uri c(@NotNull String str) {
        return Uri.parse(str);
    }
}
