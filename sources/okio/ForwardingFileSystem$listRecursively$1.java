package okio;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lokio/Path;", "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class ForwardingFileSystem$listRecursively$1 extends Lambda implements Function1<Path, Path> {
    final /* synthetic */ ForwardingFileSystem X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ForwardingFileSystem$listRecursively$1(ForwardingFileSystem forwardingFileSystem) {
        super(1);
        this.X = forwardingFileSystem;
    }

    @NotNull
    /* renamed from: b */
    public final Path f(@NotNull Path path) {
        Intrinsics.p(path, "it");
        return this.X.O(path, "listRecursively");
    }
}
