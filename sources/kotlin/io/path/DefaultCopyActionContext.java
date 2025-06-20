package kotlin.io.path;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/io/path/DefaultCopyActionContext;", "Lkotlin/io/path/CopyActionContext;", "<init>", "()V", "Ljava/nio/file/Path;", "target", "", "followLinks", "Lkotlin/io/path/CopyActionResult;", "a", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Z)Lkotlin/io/path/CopyActionResult;", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0})
@ExperimentalPathApi
final class DefaultCopyActionContext implements CopyActionContext {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final DefaultCopyActionContext f28871a = new DefaultCopyActionContext();

    private DefaultCopyActionContext() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0038, code lost:
        if (kotlin.io.path.C0499a.a(r6, (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(new java.nio.file.LinkOption[]{kotlin.io.path.C0501b.a()}, 1)) == false) goto L_0x003a;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.io.path.CopyActionResult a(@org.jetbrains.annotations.NotNull java.nio.file.Path r5, @org.jetbrains.annotations.NotNull java.nio.file.Path r6, boolean r7) {
        /*
            r4 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r5, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.p(r6, r0)
            kotlin.io.path.LinkFollowing r0 = kotlin.io.path.LinkFollowing.f28888a
            java.nio.file.LinkOption[] r7 = r0.a(r7)
            int r0 = r7.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r7, r0)
            java.nio.file.LinkOption[] r0 = (java.nio.file.LinkOption[]) r0
            int r1 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            java.nio.file.LinkOption[] r0 = (java.nio.file.LinkOption[]) r0
            boolean r0 = java.nio.file.Files.isDirectory(r5, r0)
            if (r0 == 0) goto L_0x003a
            r0 = 1
            java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r0]
            r2 = 0
            java.nio.file.LinkOption r3 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r1[r2] = r3
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r0)
            java.nio.file.LinkOption[] r0 = (java.nio.file.LinkOption[]) r0
            boolean r0 = java.nio.file.Files.isDirectory(r6, r0)
            if (r0 != 0) goto L_0x0051
        L_0x003a:
            int r0 = r7.length
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r0)
            java.nio.file.CopyOption[] r7 = (java.nio.file.CopyOption[]) r7
            int r0 = r7.length
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r0)
            java.nio.file.CopyOption[] r7 = (java.nio.file.CopyOption[]) r7
            java.nio.file.Path r5 = java.nio.file.Files.copy(r5, r6, r7)
            java.lang.String r6 = "copy(this, target, *options)"
            kotlin.jvm.internal.Intrinsics.o(r5, r6)
        L_0x0051:
            kotlin.io.path.CopyActionResult r5 = kotlin.io.path.CopyActionResult.CONTINUE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.DefaultCopyActionContext.a(java.nio.file.Path, java.nio.file.Path, boolean):kotlin.io.path.CopyActionResult");
    }
}
