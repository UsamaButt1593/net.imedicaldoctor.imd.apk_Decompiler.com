package kotlin.io;

import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\u001a1\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a1\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u0019\u0010\t\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\f\u001a\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\f\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\n\u001a-\u0010\u0015\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016\u001a?\u0010\u001b\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u001a\b\u0002\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001d\u001a\u00020\u0011*\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0019\u0010 \u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b \u0010!\u001a\u0019\u0010\"\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0019\u0010$\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b$\u0010!\u001a\u0019\u0010%\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0000¢\u0006\u0004\b%\u0010#\u001a\u0011\u0010&\u001a\u00020\u0003*\u00020\u0003¢\u0006\u0004\b&\u0010'\u001a\u0013\u0010)\u001a\u00020(*\u00020(H\u0002¢\u0006\u0004\b)\u0010*\u001a\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030+*\b\u0012\u0004\u0012\u00020\u00030+H\u0002¢\u0006\u0004\b,\u0010-\u001a\u0019\u0010/\u001a\u00020\u0003*\u00020\u00032\u0006\u0010.\u001a\u00020\u0003¢\u0006\u0004\b/\u0010\f\u001a\u0019\u00100\u001a\u00020\u0003*\u00020\u00032\u0006\u0010.\u001a\u00020\u0000¢\u0006\u0004\b0\u00101\u001a\u0019\u00102\u001a\u00020\u0003*\u00020\u00032\u0006\u0010.\u001a\u00020\u0003¢\u0006\u0004\b2\u0010\f\u001a\u0019\u00103\u001a\u00020\u0003*\u00020\u00032\u0006\u0010.\u001a\u00020\u0000¢\u0006\u0004\b3\u00101\"\u0015\u00106\u001a\u00020\u0000*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b4\u00105\"\u0015\u00108\u001a\u00020\u0000*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b7\u00105\"\u0015\u0010:\u001a\u00020\u0000*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b9\u00105¨\u0006;"}, d2 = {"", "prefix", "suffix", "Ljava/io/File;", "directory", "R", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;", "T", "base", "n0", "(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;", "e0", "(Ljava/io/File;Ljava/io/File;)Ljava/io/File;", "g0", "f0", "o0", "target", "", "overwrite", "", "bufferSize", "P", "(Ljava/io/File;Ljava/io/File;ZI)Ljava/io/File;", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "onError", "N", "(Ljava/io/File;Ljava/io/File;ZLkotlin/jvm/functions/Function2;)Z", "V", "(Ljava/io/File;)Z", "other", "l0", "(Ljava/io/File;Ljava/io/File;)Z", "m0", "(Ljava/io/File;Ljava/lang/String;)Z", "W", "X", "b0", "(Ljava/io/File;)Ljava/io/File;", "Lkotlin/io/FilePathComponents;", "d0", "(Lkotlin/io/FilePathComponents;)Lkotlin/io/FilePathComponents;", "", "c0", "(Ljava/util/List;)Ljava/util/List;", "relative", "h0", "i0", "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", "j0", "k0", "Y", "(Ljava/io/File;)Ljava/lang/String;", "extension", "Z", "invariantSeparatorsPath", "a0", "nameWithoutExtension", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/io/FilesKt")
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,473:1\n1#2:474\n1284#3,3:475\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n*L\n347#1:475,3\n*E\n"})
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0095, code lost:
        if (r5.delete() == false) goto L_0x0097;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean N(@org.jetbrains.annotations.NotNull java.io.File r11, @org.jetbrains.annotations.NotNull java.io.File r12, boolean r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.io.File, ? super java.io.IOException, ? extends kotlin.io.OnErrorAction> r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r11, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.p(r12, r0)
            java.lang.String r0 = "onError"
            kotlin.jvm.internal.Intrinsics.p(r14, r0)
            boolean r0 = r11.exists()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x002e
            kotlin.io.NoSuchFileException r12 = new kotlin.io.NoSuchFileException
            r7 = 2
            r8 = 0
            r5 = 0
            java.lang.String r6 = "The source file doesn't exist."
            r3 = r12
            r4 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            java.lang.Object r11 = r14.d0(r11, r12)
            kotlin.io.OnErrorAction r12 = kotlin.io.OnErrorAction.TERMINATE
            if (r11 == r12) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r1 = 0
        L_0x002d:
            return r1
        L_0x002e:
            kotlin.io.FileTreeWalk r0 = kotlin.io.FilesKt__FileTreeWalkKt.M(r11)     // Catch:{ TerminateException -> 0x00d7 }
            kotlin.io.FilesKt__UtilsKt$copyRecursively$2 r3 = new kotlin.io.FilesKt__UtilsKt$copyRecursively$2     // Catch:{ TerminateException -> 0x00d7 }
            r3.<init>(r14)     // Catch:{ TerminateException -> 0x00d7 }
            kotlin.io.FileTreeWalk r0 = r0.k(r3)     // Catch:{ TerminateException -> 0x00d7 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ TerminateException -> 0x00d7 }
        L_0x003f:
            boolean r3 = r0.hasNext()     // Catch:{ TerminateException -> 0x00d7 }
            if (r3 == 0) goto L_0x00d6
            java.lang.Object r3 = r0.next()     // Catch:{ TerminateException -> 0x00d7 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ TerminateException -> 0x00d7 }
            boolean r4 = r3.exists()     // Catch:{ TerminateException -> 0x00d7 }
            if (r4 != 0) goto L_0x0066
            kotlin.io.NoSuchFileException r10 = new kotlin.io.NoSuchFileException     // Catch:{ TerminateException -> 0x00d7 }
            java.lang.String r7 = "The source file doesn't exist."
            r8 = 2
            r9 = 0
            r6 = 0
            r4 = r10
            r5 = r3
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ TerminateException -> 0x00d7 }
            java.lang.Object r3 = r14.d0(r3, r10)     // Catch:{ TerminateException -> 0x00d7 }
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch:{ TerminateException -> 0x00d7 }
            if (r3 != r4) goto L_0x003f
            return r2
        L_0x0066:
            java.lang.String r4 = n0(r3, r11)     // Catch:{ TerminateException -> 0x00d7 }
            java.io.File r5 = new java.io.File     // Catch:{ TerminateException -> 0x00d7 }
            r5.<init>(r12, r4)     // Catch:{ TerminateException -> 0x00d7 }
            boolean r4 = r5.exists()     // Catch:{ TerminateException -> 0x00d7 }
            if (r4 == 0) goto L_0x00a7
            boolean r4 = r3.isDirectory()     // Catch:{ TerminateException -> 0x00d7 }
            if (r4 == 0) goto L_0x0081
            boolean r4 = r5.isDirectory()     // Catch:{ TerminateException -> 0x00d7 }
            if (r4 != 0) goto L_0x00a7
        L_0x0081:
            if (r13 != 0) goto L_0x0084
            goto L_0x0097
        L_0x0084:
            boolean r4 = r5.isDirectory()     // Catch:{ TerminateException -> 0x00d7 }
            if (r4 == 0) goto L_0x0091
            boolean r4 = V(r5)     // Catch:{ TerminateException -> 0x00d7 }
            if (r4 != 0) goto L_0x00a7
            goto L_0x0097
        L_0x0091:
            boolean r4 = r5.delete()     // Catch:{ TerminateException -> 0x00d7 }
            if (r4 != 0) goto L_0x00a7
        L_0x0097:
            kotlin.io.FileAlreadyExistsException r4 = new kotlin.io.FileAlreadyExistsException     // Catch:{ TerminateException -> 0x00d7 }
            java.lang.String r6 = "The destination file already exists."
            r4.<init>(r3, r5, r6)     // Catch:{ TerminateException -> 0x00d7 }
            java.lang.Object r3 = r14.d0(r5, r4)     // Catch:{ TerminateException -> 0x00d7 }
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch:{ TerminateException -> 0x00d7 }
            if (r3 != r4) goto L_0x003f
            return r2
        L_0x00a7:
            boolean r4 = r3.isDirectory()     // Catch:{ TerminateException -> 0x00d7 }
            if (r4 == 0) goto L_0x00b1
            r5.mkdirs()     // Catch:{ TerminateException -> 0x00d7 }
            goto L_0x003f
        L_0x00b1:
            r8 = 4
            r9 = 0
            r7 = 0
            r4 = r3
            r6 = r13
            java.io.File r4 = Q(r4, r5, r6, r7, r8, r9)     // Catch:{ TerminateException -> 0x00d7 }
            long r4 = r4.length()     // Catch:{ TerminateException -> 0x00d7 }
            long r6 = r3.length()     // Catch:{ TerminateException -> 0x00d7 }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x003f
            java.io.IOException r4 = new java.io.IOException     // Catch:{ TerminateException -> 0x00d7 }
            java.lang.String r5 = "Source file wasn't copied completely, length of destination file differs."
            r4.<init>(r5)     // Catch:{ TerminateException -> 0x00d7 }
            java.lang.Object r3 = r14.d0(r3, r4)     // Catch:{ TerminateException -> 0x00d7 }
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch:{ TerminateException -> 0x00d7 }
            if (r3 != r4) goto L_0x003f
            return r2
        L_0x00d6:
            return r1
        L_0x00d7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__UtilsKt.N(java.io.File, java.io.File, boolean, kotlin.jvm.functions.Function2):boolean");
    }

    public static /* synthetic */ boolean O(File file, File file2, boolean z, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            function2 = FilesKt__UtilsKt$copyRecursively$1.X;
        }
        return N(file, file2, z, function2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0066, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        kotlin.io.CloseableKt.a(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006a, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x006d, code lost:
        kotlin.io.CloseableKt.a(r8, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0070, code lost:
        throw r7;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.io.File P(@org.jetbrains.annotations.NotNull java.io.File r6, @org.jetbrains.annotations.NotNull java.io.File r7, boolean r8, int r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r6, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.p(r7, r0)
            boolean r0 = r6.exists()
            if (r0 == 0) goto L_0x0071
            boolean r0 = r7.exists()
            if (r0 == 0) goto L_0x002f
            if (r8 == 0) goto L_0x0027
            boolean r8 = r7.delete()
            if (r8 == 0) goto L_0x001f
            goto L_0x002f
        L_0x001f:
            kotlin.io.FileAlreadyExistsException r8 = new kotlin.io.FileAlreadyExistsException
            java.lang.String r9 = "Tried to overwrite the destination, but failed to delete it."
            r8.<init>(r6, r7, r9)
            throw r8
        L_0x0027:
            kotlin.io.FileAlreadyExistsException r8 = new kotlin.io.FileAlreadyExistsException
            java.lang.String r9 = "The destination file already exists."
            r8.<init>(r6, r7, r9)
            throw r8
        L_0x002f:
            boolean r8 = r6.isDirectory()
            if (r8 == 0) goto L_0x0044
            boolean r8 = r7.mkdirs()
            if (r8 == 0) goto L_0x003c
            goto L_0x0061
        L_0x003c:
            kotlin.io.FileSystemException r8 = new kotlin.io.FileSystemException
            java.lang.String r9 = "Failed to create target directory."
            r8.<init>(r6, r7, r9)
            throw r8
        L_0x0044:
            java.io.File r8 = r7.getParentFile()
            if (r8 == 0) goto L_0x004d
            r8.mkdirs()
        L_0x004d:
            java.io.FileInputStream r8 = new java.io.FileInputStream
            r8.<init>(r6)
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x0062 }
            r6.<init>(r7)     // Catch:{ all -> 0x0062 }
            kotlin.io.ByteStreamsKt.k(r8, r6, r9)     // Catch:{ all -> 0x0064 }
            r9 = 0
            kotlin.io.CloseableKt.a(r6, r9)     // Catch:{ all -> 0x0062 }
            kotlin.io.CloseableKt.a(r8, r9)
        L_0x0061:
            return r7
        L_0x0062:
            r6 = move-exception
            goto L_0x006b
        L_0x0064:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r9 = move-exception
            kotlin.io.CloseableKt.a(r6, r7)     // Catch:{ all -> 0x0062 }
            throw r9     // Catch:{ all -> 0x0062 }
        L_0x006b:
            throw r6     // Catch:{ all -> 0x006c }
        L_0x006c:
            r7 = move-exception
            kotlin.io.CloseableKt.a(r8, r6)
            throw r7
        L_0x0071:
            kotlin.io.NoSuchFileException r7 = new kotlin.io.NoSuchFileException
            r4 = 2
            r5 = 0
            r2 = 0
            java.lang.String r3 = "The source file doesn't exist."
            r0 = r7
            r1 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__UtilsKt.P(java.io.File, java.io.File, boolean, int):java.io.File");
    }

    public static /* synthetic */ File Q(File file, File file2, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 8192;
        }
        return P(file, file2, z, i2);
    }

    @NotNull
    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    public static final File R(@NotNull String str, @Nullable String str2, @Nullable File file) {
        Intrinsics.p(str, "prefix");
        File createTempFile = File.createTempFile(str, str2, file);
        createTempFile.delete();
        if (createTempFile.mkdir()) {
            Intrinsics.o(createTempFile, HTML.Attribute.u);
            return createTempFile;
        }
        throw new IOException("Unable to create temporary directory " + createTempFile + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    public static /* synthetic */ File S(String str, String str2, File file, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "tmp";
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            file = null;
        }
        return R(str, str2, file);
    }

    @NotNull
    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    public static final File T(@NotNull String str, @Nullable String str2, @Nullable File file) {
        Intrinsics.p(str, "prefix");
        File createTempFile = File.createTempFile(str, str2, file);
        Intrinsics.o(createTempFile, "createTempFile(prefix, suffix, directory)");
        return createTempFile;
    }

    public static /* synthetic */ File U(String str, String str2, File file, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "tmp";
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            file = null;
        }
        return T(str, str2, file);
    }

    public static final boolean V(@NotNull File file) {
        Intrinsics.p(file, "<this>");
        Iterator it2 = FilesKt__FileTreeWalkKt.L(file).iterator();
        while (true) {
            boolean z = true;
            while (true) {
                if (!it2.hasNext()) {
                    return z;
                }
                File file2 = (File) it2.next();
                if (file2.delete() || !file2.exists()) {
                    if (z) {
                    }
                }
                z = false;
            }
        }
    }

    public static final boolean W(@NotNull File file, @NotNull File file2) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(file2, "other");
        FilePathComponents f2 = FilesKt__FilePathComponentsKt.f(file);
        FilePathComponents f3 = FilesKt__FilePathComponentsKt.f(file2);
        if (f3.i()) {
            return Intrinsics.g(file, file2);
        }
        int h2 = f2.h() - f3.h();
        if (h2 < 0) {
            return false;
        }
        return f2.g().subList(h2, f2.h()).equals(f3.g());
    }

    public static final boolean X(@NotNull File file, @NotNull String str) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(str, "other");
        return W(file, new File(str));
    }

    @NotNull
    public static String Y(@NotNull File file) {
        Intrinsics.p(file, "<this>");
        String name = file.getName();
        Intrinsics.o(name, "name");
        return StringsKt.o5(name, ClassUtils.PACKAGE_SEPARATOR_CHAR, "");
    }

    @NotNull
    public static final String Z(@NotNull File file) {
        Intrinsics.p(file, "<this>");
        char c2 = File.separatorChar;
        String path = file.getPath();
        Intrinsics.o(path, Cookie2.PATH);
        return c2 != '/' ? StringsKt.h2(path, c2, '/', false, 4, (Object) null) : path;
    }

    @NotNull
    public static final String a0(@NotNull File file) {
        Intrinsics.p(file, "<this>");
        String name = file.getName();
        Intrinsics.o(name, "name");
        return StringsKt.z5(name, ".", (String) null, 2, (Object) null);
    }

    @NotNull
    public static final File b0(@NotNull File file) {
        Intrinsics.p(file, "<this>");
        FilePathComponents f2 = FilesKt__FilePathComponentsKt.f(file);
        File e2 = f2.e();
        List<File> c0 = c0(f2.g());
        String str = File.separator;
        Intrinsics.o(str, "separator");
        return i0(e2, CollectionsKt.j3(c0, str, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }

    private static final List<File> c0(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (!Intrinsics.g(name, ".")) {
                if (!Intrinsics.g(name, "..") || arrayList.isEmpty() || Intrinsics.g(((File) CollectionsKt.m3(arrayList)).getName(), "..")) {
                    arrayList.add(file);
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return arrayList;
    }

    private static final FilePathComponents d0(FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.e(), c0(filePathComponents.g()));
    }

    @NotNull
    public static final File e0(@NotNull File file, @NotNull File file2) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(file2, "base");
        return new File(n0(file, file2));
    }

    @Nullable
    public static final File f0(@NotNull File file, @NotNull File file2) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(file2, "base");
        String o0 = o0(file, file2);
        if (o0 != null) {
            return new File(o0);
        }
        return null;
    }

    @NotNull
    public static final File g0(@NotNull File file, @NotNull File file2) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(file2, "base");
        String o0 = o0(file, file2);
        return o0 != null ? new File(o0) : file;
    }

    @NotNull
    public static final File h0(@NotNull File file, @NotNull File file2) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(file2, CSS.Value.X);
        if (FilesKt__FilePathComponentsKt.d(file2)) {
            return file2;
        }
        String file3 = file.toString();
        Intrinsics.o(file3, "this.toString()");
        if (file3.length() != 0) {
            char c2 = File.separatorChar;
            if (!StringsKt.Y2(file3, c2, false, 2, (Object) null)) {
                return new File(file3 + c2 + file2);
            }
        }
        return new File(file3 + file2);
    }

    @NotNull
    public static final File i0(@NotNull File file, @NotNull String str) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(str, CSS.Value.X);
        return h0(file, new File(str));
    }

    @NotNull
    public static final File j0(@NotNull File file, @NotNull File file2) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(file2, CSS.Value.X);
        FilePathComponents f2 = FilesKt__FilePathComponentsKt.f(file);
        return h0(h0(f2.e(), f2.h() == 0 ? new File("..") : f2.j(0, f2.h() - 1)), file2);
    }

    @NotNull
    public static final File k0(@NotNull File file, @NotNull String str) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(str, CSS.Value.X);
        return j0(file, new File(str));
    }

    public static final boolean l0(@NotNull File file, @NotNull File file2) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(file2, "other");
        FilePathComponents f2 = FilesKt__FilePathComponentsKt.f(file);
        FilePathComponents f3 = FilesKt__FilePathComponentsKt.f(file2);
        if (Intrinsics.g(f2.e(), f3.e()) && f2.h() >= f3.h()) {
            return f2.g().subList(0, f3.h()).equals(f3.g());
        }
        return false;
    }

    public static final boolean m0(@NotNull File file, @NotNull String str) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(str, "other");
        return l0(file, new File(str));
    }

    @NotNull
    public static final String n0(@NotNull File file, @NotNull File file2) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(file2, "base");
        String o0 = o0(file, file2);
        if (o0 != null) {
            return o0;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + file2 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    private static final String o0(File file, File file2) {
        FilePathComponents d0 = d0(FilesKt__FilePathComponentsKt.f(file));
        FilePathComponents d02 = d0(FilesKt__FilePathComponentsKt.f(file2));
        if (!Intrinsics.g(d0.e(), d02.e())) {
            return null;
        }
        int h2 = d02.h();
        int h3 = d0.h();
        int min = Math.min(h3, h2);
        int i2 = 0;
        while (i2 < min && Intrinsics.g(d0.g().get(i2), d02.g().get(i2))) {
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = h2 - 1;
        if (i2 <= i3) {
            while (!Intrinsics.g(d02.g().get(i3).getName(), "..")) {
                sb.append("..");
                if (i3 != i2) {
                    sb.append(File.separatorChar);
                }
                if (i3 != i2) {
                    i3--;
                }
            }
            return null;
        }
        if (i2 < h3) {
            if (i2 < h2) {
                sb.append(File.separatorChar);
            }
            List<T> Z1 = CollectionsKt.Z1(d0.g(), i2);
            String str = File.separator;
            Intrinsics.o(str, "separator");
            CollectionsKt.h3(Z1, sb, str, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null);
        }
        return sb.toString();
    }
}
