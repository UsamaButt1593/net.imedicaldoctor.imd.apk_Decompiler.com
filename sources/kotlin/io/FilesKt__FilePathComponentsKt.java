package kotlin.io;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0018\u0010\u000e\u001a\u00020\u0000*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0018\u0010\u0011\u001a\u00020\u0004*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"", "", "b", "(Ljava/lang/String;)I", "Ljava/io/File;", "Lkotlin/io/FilePathComponents;", "f", "(Ljava/io/File;)Lkotlin/io/FilePathComponents;", "beginIndex", "endIndex", "e", "(Ljava/io/File;II)Ljava/io/File;", "c", "(Ljava/io/File;)Ljava/lang/String;", "rootName", "a", "(Ljava/io/File;)Ljava/io/File;", "root", "", "d", "(Ljava/io/File;)Z", "isRooted", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/io/FilesKt")
@SourceDebugExtension({"SMAP\nFilePathComponents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n1549#2:149\n1620#2,3:150\n*S KotlinDebug\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n*L\n133#1:149\n133#1:150,3\n*E\n"})
class FilesKt__FilePathComponentsKt {
    @NotNull
    public static final File a(@NotNull File file) {
        Intrinsics.p(file, "<this>");
        return new File(c(file));
    }

    private static final int b(String str) {
        int o3;
        char c2 = File.separatorChar;
        int o32 = StringsKt.o3(str, c2, 0, false, 4, (Object) null);
        if (o32 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c2 || (o3 = StringsKt.o3(str, c2, 2, false, 4, (Object) null)) < 0) {
                return 1;
            }
            int o33 = StringsKt.o3(str, c2, o3 + 1, false, 4, (Object) null);
            return o33 >= 0 ? o33 + 1 : str.length();
        } else if (o32 > 0 && str.charAt(o32 - 1) == ':') {
            return o32 + 1;
        } else {
            if (o32 != -1 || !StringsKt.Y2(str, ASCIIPropertyListParser.A, false, 2, (Object) null)) {
                return 0;
            }
            return str.length();
        }
    }

    @NotNull
    public static final String c(@NotNull File file) {
        Intrinsics.p(file, "<this>");
        String path = file.getPath();
        Intrinsics.o(path, Cookie2.PATH);
        String path2 = file.getPath();
        Intrinsics.o(path2, Cookie2.PATH);
        String substring = path.substring(0, b(path2));
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean d(@NotNull File file) {
        Intrinsics.p(file, "<this>");
        String path = file.getPath();
        Intrinsics.o(path, Cookie2.PATH);
        return b(path) > 0;
    }

    @NotNull
    public static final File e(@NotNull File file, int i2, int i3) {
        Intrinsics.p(file, "<this>");
        return f(file).j(i2, i3);
    }

    @NotNull
    public static final FilePathComponents f(@NotNull File file) {
        List list;
        Intrinsics.p(file, "<this>");
        String path = file.getPath();
        Intrinsics.o(path, Cookie2.PATH);
        int b2 = b(path);
        String substring = path.substring(0, b2);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = path.substring(b2);
        Intrinsics.o(substring2, "this as java.lang.String).substring(startIndex)");
        if (substring2.length() == 0) {
            list = CollectionsKt.E();
        } else {
            List<String> Q4 = StringsKt.Q4(substring2, new char[]{File.separatorChar}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.Y(Q4, 10));
            for (String file2 : Q4) {
                arrayList.add(new File(file2));
            }
            list = arrayList;
        }
        return new FilePathComponents(new File(substring), list);
    }
}
