package kotlin.io.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nPathRecursiveFunctions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,420:1\n336#1,2:424\n344#1:426\n344#1:427\n338#1,4:428\n336#1,2:432\n344#1:434\n338#1,4:435\n344#1:439\n336#1,6:440\n336#1,2:446\n344#1:448\n338#1,4:449\n1#2:421\n1855#3,2:422\n*S KotlinDebug\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n*L\n352#1:424,2\n361#1:426\n364#1:427\n352#1:428,4\n372#1:432,2\n373#1:434\n372#1:435,4\n384#1:439\n392#1:440,6\n410#1:446,2\n411#1:448\n410#1:449,4\n274#1:422,2\n*E\n"})
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u001a~\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002Q\b\u0002\u0010\n\u001aK\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0001\u0012\u0017\u0012\u00150\u0006j\u0002`\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a»\u0001\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002Q\b\u0002\u0010\n\u001aK\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0001\u0012\u0017\u0012\u00150\u0006j\u0002`\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\f\u001a\u00020\u000b2C\b\u0002\u0010\u0013\u001a=\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00020\u00110\u0002¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0011H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0013\u0010\u0019\u001a\u00020\u0016*\u00020\tH\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0013\u0010\u001c\u001a\u00020\u001b*\u00020\u0000H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001d\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u001e*\u00020\u0000H\u0002¢\u0006\u0004\b\u001f\u0010 \u001a&\u0010%\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020!2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0#H\b¢\u0006\u0004\b%\u0010&\u001a&\u0010'\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u001c2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#H\b¢\u0006\u0004\b'\u0010(\u001a)\u0010*\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00000)2\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b*\u0010+\u001a)\u0010,\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00000)2\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b,\u0010+\u001a5\u00101\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00000)2\u0006\u0010-\u001a\u00020\u00002\u0012\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0.\"\u00020/H\u0002¢\u0006\u0004\b1\u00102\u001a\u001f\u00104\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b4\u00105\u001a\u001f\u00107\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b7\u00105¨\u00068"}, d2 = {"Ljava/nio/file/Path;", "target", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "source", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Lkotlin/io/path/OnErrorResult;", "onError", "", "followLinks", "overwrite", "L", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;ZZ)Ljava/nio/file/Path;", "Lkotlin/io/path/CopyActionContext;", "Lkotlin/io/path/CopyActionResult;", "Lkotlin/ExtensionFunctionType;", "copyAction", "K", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function3;)Ljava/nio/file/Path;", "Ljava/nio/file/FileVisitResult;", "Y", "(Lkotlin/io/path/CopyActionResult;)Ljava/nio/file/FileVisitResult;", "Z", "(Lkotlin/io/path/OnErrorResult;)Ljava/nio/file/FileVisitResult;", "", "R", "(Ljava/nio/file/Path;)V", "", "S", "(Ljava/nio/file/Path;)Ljava/util/List;", "Lkotlin/io/path/ExceptionsCollector;", "collector", "Lkotlin/Function0;", "function", "J", "(Lkotlin/io/path/ExceptionsCollector;Lkotlin/jvm/functions/Function0;)V", "a0", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Ljava/nio/file/SecureDirectoryStream;", "U", "(Ljava/nio/file/SecureDirectoryStream;Ljava/nio/file/Path;Lkotlin/io/path/ExceptionsCollector;)V", "T", "entryName", "", "Ljava/nio/file/LinkOption;", "options", "X", "(Ljava/nio/file/SecureDirectoryStream;Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "entry", "W", "(Ljava/nio/file/Path;Lkotlin/io/path/ExceptionsCollector;)V", "path", "V", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28902a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f28903b;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|5|6|(2:7|8)|9|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0019 */
        static {
            /*
                kotlin.io.path.CopyActionResult[] r0 = kotlin.io.path.CopyActionResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                kotlin.io.path.CopyActionResult r2 = kotlin.io.path.CopyActionResult.CONTINUE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                kotlin.io.path.CopyActionResult r3 = kotlin.io.path.CopyActionResult.TERMINATE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.io.path.CopyActionResult r3 = kotlin.io.path.CopyActionResult.SKIP_SUBTREE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r4 = 3
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f28902a = r0
                kotlin.io.path.OnErrorResult[] r0 = kotlin.io.path.OnErrorResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.io.path.OnErrorResult r3 = kotlin.io.path.OnErrorResult.TERMINATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                kotlin.io.path.OnErrorResult r1 = kotlin.io.path.OnErrorResult.SKIP_SUBTREE     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                f28903b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.WhenMappings.<clinit>():void");
        }
    }

    private static final void J(ExceptionsCollector exceptionsCollector, Function0<Unit> function0) {
        try {
            function0.o();
        } catch (Exception e2) {
            exceptionsCollector.a(e2);
        }
    }

    @SinceKotlin(version = "1.8")
    @NotNull
    @ExperimentalPathApi
    public static final Path K(@NotNull Path path, @NotNull Path path2, @NotNull Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, boolean z, @NotNull Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function32) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        Intrinsics.p(function3, "onError");
        Intrinsics.p(function32, "copyAction");
        LinkOption[] a2 = LinkFollowing.f28888a.a(z);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(a2, a2.length);
        if (Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            boolean z2 = false;
            if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && (z || !Files.isSymbolicLink(path))) {
                boolean z3 = Files.exists(path2, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && !Files.isSymbolicLink(path2);
                if (!z3 || !Files.isSameFile(path, path2)) {
                    if (Intrinsics.g(path.getFileSystem(), path2.getFileSystem())) {
                        if (z3) {
                            z2 = path2.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0]));
                        } else {
                            Path a3 = path2.getParent();
                            if (a3 != null && Files.exists(a3, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && a3.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0]))) {
                                z2 = true;
                            }
                        }
                    }
                    if (z2) {
                        C0525n.a();
                        throw C0502b0.a(path.toString(), path2.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
                    }
                }
            }
            PathsKt__PathUtilsKt.C1(path, 0, z, new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5(function32, path, path2, function3), 1, (Object) null);
            return path2;
        }
        C0504c0.a();
        throw C0500a0.a(path.toString(), path2.toString(), "The source file doesn't exist.");
    }

    @SinceKotlin(version = "1.8")
    @NotNull
    @ExperimentalPathApi
    public static final Path L(@NotNull Path path, @NotNull Path path2, @NotNull Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, boolean z, boolean z2) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        Intrinsics.p(function3, "onError");
        return z2 ? K(path, path2, function3, z, new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2(z)) : N(path, path2, function3, z, (Function3) null, 8, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final FileVisitResult M(Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32, Path path3, BasicFileAttributes basicFileAttributes) {
        try {
            return Y((CopyActionResult) function3.A(DefaultCopyActionContext.f28871a, path3, P(path, path2, path3)));
        } catch (Exception e2) {
            return Q(function32, path, path2, path3, e2);
        }
    }

    public static /* synthetic */ Path N(Path path, Path path2, Function3 function3, boolean z, Function3 function32, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function3 = PathsKt__PathRecursiveFunctionsKt$copyToRecursively$3.X;
        }
        if ((i2 & 8) != 0) {
            function32 = new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$4(z);
        }
        return K(path, path2, function3, z, function32);
    }

    public static /* synthetic */ Path O(Path path, Path path2, Function3 function3, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function3 = PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1.X;
        }
        return L(path, path2, function3, z, z2);
    }

    private static final Path P(Path path, Path path2, Path path3) {
        Path a2 = path2.resolve(PathsKt__PathUtilsKt.q1(path3, path).toString());
        Intrinsics.o(a2, "target.resolve(relativePath.pathString)");
        return a2;
    }

    /* access modifiers changed from: private */
    public static final FileVisitResult Q(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path path, Path path2, Path path3, Exception exc) {
        return Z((OnErrorResult) function3.A(path3, P(path, path2, path3), exc));
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalPathApi
    public static final void R(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        List<Exception> S = S(path);
        if (!S.isEmpty()) {
            FileSystemException a2 = C0523m.a("Failed to delete one or more files. See suppressed exceptions for details.");
            for (Exception a3 : S) {
                ExceptionsKt.a(a2, a3);
            }
            throw a2;
        }
    }

    private static final List<Exception> S(Path path) {
        DirectoryStream directoryStream;
        boolean z = false;
        boolean z2 = true;
        ExceptionsCollector exceptionsCollector = new ExceptionsCollector(0, 1, (DefaultConstructorMarker) null);
        Path a2 = path.getParent();
        if (a2 != null) {
            try {
                directoryStream = Files.newDirectoryStream(a2);
            } catch (Throwable unused) {
                directoryStream = null;
            }
            if (directoryStream != null) {
                try {
                    DirectoryStream a3 = C0506d0.a(directoryStream);
                    if (C0508e0.a(a3)) {
                        exceptionsCollector.g(a2);
                        SecureDirectoryStream a4 = C0510f0.a(a3);
                        Path a5 = path.getFileName();
                        Intrinsics.o(a5, "this.fileName");
                        U(a4, a5, exceptionsCollector);
                    } else {
                        z = true;
                    }
                    Unit unit = Unit.f28779a;
                    CloseableKt.a(directoryStream, (Throwable) null);
                    z2 = z;
                } catch (Throwable th) {
                    CloseableKt.a(directoryStream, th);
                    throw th;
                }
            }
        }
        if (z2) {
            W(path, exceptionsCollector);
        }
        return exceptionsCollector.d();
    }

    private static final void T(SecureDirectoryStream<Path> secureDirectoryStream, Path path, ExceptionsCollector exceptionsCollector) {
        SecureDirectoryStream secureDirectoryStream2;
        try {
            secureDirectoryStream2 = secureDirectoryStream.newDirectoryStream(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        } catch (NoSuchFileException unused) {
            secureDirectoryStream2 = null;
        }
        if (secureDirectoryStream2 != null) {
            try {
                SecureDirectoryStream a2 = C0510f0.a(secureDirectoryStream2);
                Iterator a3 = a2.iterator();
                while (a3.hasNext()) {
                    Path a4 = C0507e.a(a3.next()).getFileName();
                    Intrinsics.o(a4, "entry.fileName");
                    U(a2, a4, exceptionsCollector);
                }
                Unit unit = Unit.f28779a;
                try {
                    CloseableKt.a(secureDirectoryStream2, (Throwable) null);
                } catch (Exception e2) {
                    exceptionsCollector.a(e2);
                }
            } catch (Throwable th) {
                CloseableKt.a(secureDirectoryStream2, th);
                throw th;
            }
        }
    }

    private static final void U(SecureDirectoryStream<Path> secureDirectoryStream, Path path, ExceptionsCollector exceptionsCollector) {
        exceptionsCollector.b(path);
        try {
            if (X(secureDirectoryStream, path, LinkOption.NOFOLLOW_LINKS)) {
                int f2 = exceptionsCollector.f();
                T(secureDirectoryStream, path, exceptionsCollector);
                if (f2 == exceptionsCollector.f()) {
                    try {
                        secureDirectoryStream.deleteDirectory(path);
                    } catch (NoSuchFileException unused) {
                    }
                }
                exceptionsCollector.c(path);
            }
            secureDirectoryStream.deleteFile(path);
            Unit unit = Unit.f28779a;
        } catch (Exception e2) {
            exceptionsCollector.a(e2);
        }
        exceptionsCollector.c(path);
    }

    private static final void V(Path path, ExceptionsCollector exceptionsCollector) {
        DirectoryStream directoryStream;
        try {
            directoryStream = Files.newDirectoryStream(path);
        } catch (NoSuchFileException unused) {
            directoryStream = null;
        }
        if (directoryStream != null) {
            try {
                Iterator a2 = C0506d0.a(directoryStream).iterator();
                while (a2.hasNext()) {
                    Path a3 = C0507e.a(a2.next());
                    Intrinsics.o(a3, "entry");
                    W(a3, exceptionsCollector);
                }
                Unit unit = Unit.f28779a;
                try {
                    CloseableKt.a(directoryStream, (Throwable) null);
                } catch (Exception e2) {
                    exceptionsCollector.a(e2);
                }
            } catch (Throwable th) {
                CloseableKt.a(directoryStream, th);
                throw th;
            }
        }
    }

    private static final void W(Path path, ExceptionsCollector exceptionsCollector) {
        try {
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                int f2 = exceptionsCollector.f();
                V(path, exceptionsCollector);
                if (f2 != exceptionsCollector.f()) {
                    return;
                }
            }
            boolean unused = Files.deleteIfExists(path);
        } catch (Exception e2) {
            exceptionsCollector.a(e2);
        }
    }

    private static final boolean X(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) {
        Boolean bool;
        try {
            bool = Boolean.valueOf(T.a(secureDirectoryStream.getFileAttributeView(path, Q.a(), (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))).readAttributes().isDirectory());
        } catch (NoSuchFileException unused) {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @ExperimentalPathApi
    private static final FileVisitResult Y(CopyActionResult copyActionResult) {
        int i2 = WhenMappings.f28902a[copyActionResult.ordinal()];
        if (i2 == 1) {
            return FileVisitResult.CONTINUE;
        }
        if (i2 == 2) {
            return FileVisitResult.TERMINATE;
        }
        if (i2 == 3) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @ExperimentalPathApi
    private static final FileVisitResult Z(OnErrorResult onErrorResult) {
        int i2 = WhenMappings.f28903b[onErrorResult.ordinal()];
        if (i2 == 1) {
            return FileVisitResult.TERMINATE;
        }
        if (i2 == 2) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final <R> R a0(Function0<? extends R> function0) {
        try {
            return function0.o();
        } catch (NoSuchFileException unused) {
            return null;
        }
    }
}
