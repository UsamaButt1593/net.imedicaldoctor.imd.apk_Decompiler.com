package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "entry", "Lokio/internal/ZipEntry;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class ResourceFileSystem$Companion$toJarRoot$zip$1 extends Lambda implements Function1<ZipEntry, Boolean> {
    public static final ResourceFileSystem$Companion$toJarRoot$zip$1 X = new ResourceFileSystem$Companion$toJarRoot$zip$1();

    ResourceFileSystem$Companion$toJarRoot$zip$1() {
        super(1);
    }

    @NotNull
    /* renamed from: b */
    public final Boolean f(@NotNull ZipEntry zipEntry) {
        Intrinsics.p(zipEntry, "entry");
        return Boolean.valueOf(ResourceFileSystem.f31425f.c(zipEntry.a()));
    }
}
