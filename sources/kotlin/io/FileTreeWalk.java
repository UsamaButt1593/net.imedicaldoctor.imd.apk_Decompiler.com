package kotlin.io;

import com.itextpdf.tool.xml.css.CSS;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0018\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003,-.B\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u00128\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001b\u001a\u00020\u00002\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00002\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\u001d\u0010\u001cJ'\u0010\u001e\u001a\u00020\u00002\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0012¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010(RF\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010*R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010+¨\u0006/"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "Lkotlin/io/FileWalkDirection;", "direction", "Lkotlin/Function1;", "", "onEnter", "", "onLeave", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "onFail", "", "maxDepth", "<init>", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "", "iterator", "()Ljava/util/Iterator;", "function", "j", "(Lkotlin/jvm/functions/Function1;)Lkotlin/io/FileTreeWalk;", "l", "k", "(Lkotlin/jvm/functions/Function2;)Lkotlin/io/FileTreeWalk;", "depth", "i", "(I)Lkotlin/io/FileTreeWalk;", "a", "Ljava/io/File;", "b", "Lkotlin/io/FileWalkDirection;", "c", "Lkotlin/jvm/functions/Function1;", "d", "Lkotlin/jvm/functions/Function2;", "I", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class FileTreeWalk implements Sequence<File> {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final File f28825a;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final FileWalkDirection f28826b;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Function1<File, Boolean> f28827c;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Function1<File, Unit> f28828d;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Function2<File, IOException, Unit> f28829e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final int f28830f;

    @SourceDebugExtension({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$DirectoryState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static abstract class DirectoryState extends WalkState {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DirectoryState(@NotNull File file) {
            super(file);
            Intrinsics.p(file, "rootDir");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0010¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "<init>", "(Lkotlin/io/FileTreeWalk;)V", "root", "Lkotlin/io/FileTreeWalk$DirectoryState;", "e", "(Ljava/io/File;)Lkotlin/io/FileTreeWalk$DirectoryState;", "f", "()Ljava/io/File;", "", "a", "()V", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "Y", "Ljava/util/ArrayDeque;", "state", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    private final class FileTreeWalkIterator extends AbstractIterator<File> {
        @NotNull
        private final ArrayDeque<WalkState> Y;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "Ljava/io/File;", "rootDir", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "b", "()Ljava/io/File;", "", "Z", "rootVisited", "", "c", "[Ljava/io/File;", "fileList", "", "d", "I", "fileIndex", "e", "failed", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
        private final class BottomUpDirectoryState extends DirectoryState {

            /* renamed from: b  reason: collision with root package name */
            private boolean f28831b;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            private File[] f28832c;

            /* renamed from: d  reason: collision with root package name */
            private int f28833d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f28834e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f28835f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public BottomUpDirectoryState(@NotNull FileTreeWalkIterator fileTreeWalkIterator, File file) {
                super(file);
                Intrinsics.p(file, "rootDir");
                this.f28835f = fileTreeWalkIterator;
            }

            @Nullable
            public File b() {
                if (!this.f28834e && this.f28832c == null) {
                    Function1 e2 = FileTreeWalk.this.f28827c;
                    if (e2 != null && !((Boolean) e2.f(a())).booleanValue()) {
                        return null;
                    }
                    File[] listFiles = a().listFiles();
                    this.f28832c = listFiles;
                    if (listFiles == null) {
                        Function2 f2 = FileTreeWalk.this.f28829e;
                        if (f2 != null) {
                            f2.d0(a(), new AccessDeniedException(a(), (File) null, "Cannot list files in a directory", 2, (DefaultConstructorMarker) null));
                        }
                        this.f28834e = true;
                    }
                }
                File[] fileArr = this.f28832c;
                if (fileArr != null) {
                    int i2 = this.f28833d;
                    Intrinsics.m(fileArr);
                    if (i2 < fileArr.length) {
                        File[] fileArr2 = this.f28832c;
                        Intrinsics.m(fileArr2);
                        int i3 = this.f28833d;
                        this.f28833d = i3 + 1;
                        return fileArr2[i3];
                    }
                }
                if (!this.f28831b) {
                    this.f28831b = true;
                    return a();
                }
                Function1 g2 = FileTreeWalk.this.f28828d;
                if (g2 != null) {
                    g2.f(a());
                }
                return null;
            }
        }

        @SourceDebugExtension({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\t¨\u0006\u000b"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "Ljava/io/File;", "rootFile", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "b", "()Ljava/io/File;", "", "Z", "visited", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
        private final class SingleFileState extends WalkState {

            /* renamed from: b  reason: collision with root package name */
            private boolean f28836b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f28837c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SingleFileState(@NotNull FileTreeWalkIterator fileTreeWalkIterator, File file) {
                super(file);
                Intrinsics.p(file, "rootFile");
                this.f28837c = fileTreeWalkIterator;
            }

            @Nullable
            public File b() {
                if (this.f28836b) {
                    return null;
                }
                this.f28836b = true;
                return a();
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "Ljava/io/File;", "rootDir", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "b", "()Ljava/io/File;", "", "Z", "rootVisited", "", "c", "[Ljava/io/File;", "fileList", "", "d", "I", "fileIndex", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
        private final class TopDownDirectoryState extends DirectoryState {

            /* renamed from: b  reason: collision with root package name */
            private boolean f28838b;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            private File[] f28839c;

            /* renamed from: d  reason: collision with root package name */
            private int f28840d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ FileTreeWalkIterator f28841e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public TopDownDirectoryState(@NotNull FileTreeWalkIterator fileTreeWalkIterator, File file) {
                super(file);
                Intrinsics.p(file, "rootDir");
                this.f28841e = fileTreeWalkIterator;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
                if (r0.length == 0) goto L_0x0081;
             */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f28838b
                    r1 = 0
                    if (r0 != 0) goto L_0x0028
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r10.f28841e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = r0.f28827c
                    if (r0 == 0) goto L_0x0020
                    java.io.File r2 = r10.a()
                    java.lang.Object r0 = r0.f(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L_0x0020
                    return r1
                L_0x0020:
                    r0 = 1
                    r10.f28838b = r0
                    java.io.File r0 = r10.a()
                    return r0
                L_0x0028:
                    java.io.File[] r0 = r10.f28839c
                    if (r0 == 0) goto L_0x0047
                    int r2 = r10.f28840d
                    kotlin.jvm.internal.Intrinsics.m(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L_0x0035
                    goto L_0x0047
                L_0x0035:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r10.f28841e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = r0.f28828d
                    if (r0 == 0) goto L_0x0046
                    java.io.File r2 = r10.a()
                    r0.f(r2)
                L_0x0046:
                    return r1
                L_0x0047:
                    java.io.File[] r0 = r10.f28839c
                    if (r0 != 0) goto L_0x0093
                    java.io.File r0 = r10.a()
                    java.io.File[] r0 = r0.listFiles()
                    r10.f28839c = r0
                    if (r0 != 0) goto L_0x0077
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r10.f28841e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function2 r0 = r0.f28829e
                    if (r0 == 0) goto L_0x0077
                    java.io.File r2 = r10.a()
                    kotlin.io.AccessDeniedException r9 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r10.a()
                    r7 = 2
                    r8 = 0
                    r5 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.d0(r2, r9)
                L_0x0077:
                    java.io.File[] r0 = r10.f28839c
                    if (r0 == 0) goto L_0x0081
                    kotlin.jvm.internal.Intrinsics.m(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L_0x0093
                L_0x0081:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r10.f28841e
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = r0.f28828d
                    if (r0 == 0) goto L_0x0092
                    java.io.File r2 = r10.a()
                    r0.f(r2)
                L_0x0092:
                    return r1
                L_0x0093:
                    java.io.File[] r0 = r10.f28839c
                    kotlin.jvm.internal.Intrinsics.m(r0)
                    int r1 = r10.f28840d
                    int r2 = r1 + 1
                    r10.f28840d = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileTreeWalk.FileTreeWalkIterator.TopDownDirectoryState.b():java.io.File");
            }
        }

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f28842a;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    kotlin.io.FileWalkDirection[] r0 = kotlin.io.FileWalkDirection.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    kotlin.io.FileWalkDirection r1 = kotlin.io.FileWalkDirection.TOP_DOWN     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    kotlin.io.FileWalkDirection r1 = kotlin.io.FileWalkDirection.BOTTOM_UP     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    f28842a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileTreeWalk.FileTreeWalkIterator.WhenMappings.<clinit>():void");
            }
        }

        public FileTreeWalkIterator() {
            ArrayDeque<WalkState> arrayDeque = new ArrayDeque<>();
            this.Y = arrayDeque;
            if (FileTreeWalk.this.f28825a.isDirectory()) {
                arrayDeque.push(e(FileTreeWalk.this.f28825a));
            } else if (FileTreeWalk.this.f28825a.isFile()) {
                arrayDeque.push(new SingleFileState(this, FileTreeWalk.this.f28825a));
            } else {
                b();
            }
        }

        private final DirectoryState e(File file) {
            int i2 = WhenMappings.f28842a[FileTreeWalk.this.f28826b.ordinal()];
            if (i2 == 1) {
                return new TopDownDirectoryState(this, file);
            }
            if (i2 == 2) {
                return new BottomUpDirectoryState(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }

        private final File f() {
            File b2;
            while (true) {
                WalkState peek = this.Y.peek();
                if (peek == null) {
                    return null;
                }
                b2 = peek.b();
                if (b2 == null) {
                    this.Y.pop();
                } else if (Intrinsics.g(b2, peek.a()) || !b2.isDirectory() || this.Y.size() >= FileTreeWalk.this.f28830f) {
                    return b2;
                } else {
                    this.Y.push(e(b2));
                }
            }
            return b2;
        }

        /* access modifiers changed from: protected */
        public void a() {
            File f2 = f();
            if (f2 != null) {
                c(f2);
            } else {
                b();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/io/FileTreeWalk$WalkState;", "", "Ljava/io/File;", "root", "<init>", "(Ljava/io/File;)V", "b", "()Ljava/io/File;", "a", "Ljava/io/File;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    private static abstract class WalkState {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final File f28843a;

        public WalkState(@NotNull File file) {
            Intrinsics.p(file, "root");
            this.f28843a = file;
        }

        @NotNull
        public final File a() {
            return this.f28843a;
        }

        @Nullable
        public abstract File b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FileTreeWalk(@NotNull File file, @NotNull FileWalkDirection fileWalkDirection) {
        this(file, fileWalkDirection, (Function1) null, (Function1) null, (Function2) null, 0, 32, (DefaultConstructorMarker) null);
        Intrinsics.p(file, "start");
        Intrinsics.p(fileWalkDirection, CSS.Property.K0);
    }

    @NotNull
    public final FileTreeWalk i(int i2) {
        if (i2 > 0) {
            return new FileTreeWalk(this.f28825a, this.f28826b, this.f28827c, this.f28828d, this.f28829e, i2);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i2 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @NotNull
    public Iterator<File> iterator() {
        return new FileTreeWalkIterator();
    }

    @NotNull
    public final FileTreeWalk j(@NotNull Function1<? super File, Boolean> function1) {
        Intrinsics.p(function1, "function");
        return new FileTreeWalk(this.f28825a, this.f28826b, function1, this.f28828d, this.f28829e, this.f28830f);
    }

    @NotNull
    public final FileTreeWalk k(@NotNull Function2<? super File, ? super IOException, Unit> function2) {
        Intrinsics.p(function2, "function");
        return new FileTreeWalk(this.f28825a, this.f28826b, this.f28827c, this.f28828d, function2, this.f28830f);
    }

    @NotNull
    public final FileTreeWalk l(@NotNull Function1<? super File, Unit> function1) {
        Intrinsics.p(function1, "function");
        return new FileTreeWalk(this.f28825a, this.f28826b, this.f28827c, function1, this.f28829e, this.f28830f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i2 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection);
    }

    private FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1<? super File, Boolean> function1, Function1<? super File, Unit> function12, Function2<? super File, ? super IOException, Unit> function2, int i2) {
        this.f28825a = file;
        this.f28826b = fileWalkDirection;
        this.f28827c = function1;
        this.f28828d = function12;
        this.f28829e = function2;
        this.f28830f = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i3 & 2) != 0 ? FileWalkDirection.TOP_DOWN : fileWalkDirection, function1, function12, function2, (i3 & 32) != 0 ? Integer.MAX_VALUE : i2);
    }
}
