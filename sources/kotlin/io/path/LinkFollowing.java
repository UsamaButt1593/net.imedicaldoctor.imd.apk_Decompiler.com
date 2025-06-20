package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Lkotlin/io/path/LinkFollowing;", "", "<init>", "()V", "", "followLinks", "", "Ljava/nio/file/LinkOption;", "a", "(Z)[Ljava/nio/file/LinkOption;", "", "Ljava/nio/file/FileVisitOption;", "b", "(Z)Ljava/util/Set;", "[Ljava/nio/file/LinkOption;", "nofollowLinkOption", "c", "followLinkOption", "d", "Ljava/util/Set;", "nofollowVisitOption", "e", "followVisitOption", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/LinkFollowing\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,177:1\n26#2:178\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/LinkFollowing\n*L\n142#1:178\n*E\n"})
public final class LinkFollowing {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final LinkFollowing f28888a = new LinkFollowing();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final LinkOption[] f28889b = {LinkOption.NOFOLLOW_LINKS};
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final LinkOption[] f28890c = new LinkOption[0];
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Set<FileVisitOption> f28891d = SetsKt.k();
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Set<FileVisitOption> f28892e = SetsKt.f(FileVisitOption.FOLLOW_LINKS);

    private LinkFollowing() {
    }

    @NotNull
    public final LinkOption[] a(boolean z) {
        return z ? f28890c : f28889b;
    }

    @NotNull
    public final Set<FileVisitOption> b(boolean z) {
        return z ? f28892e : f28891d;
    }
}
