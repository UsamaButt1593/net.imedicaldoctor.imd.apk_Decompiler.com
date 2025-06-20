package kotlin.io;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u000eR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0010R\u0011\u0010!\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b \u0010\u0015R\u0011\u0010$\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010&\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b%\u0010\u0017¨\u0006'"}, d2 = {"Lkotlin/io/FilePathComponents;", "", "Ljava/io/File;", "root", "", "segments", "<init>", "(Ljava/io/File;Ljava/util/List;)V", "", "beginIndex", "endIndex", "j", "(II)Ljava/io/File;", "a", "()Ljava/io/File;", "b", "()Ljava/util/List;", "c", "(Ljava/io/File;Ljava/util/List;)Lkotlin/io/FilePathComponents;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/io/File;", "e", "Ljava/util/List;", "g", "f", "rootName", "i", "()Z", "isRooted", "h", "size", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class FilePathComponents {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final File f28823a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<File> f28824b;

    public FilePathComponents(@NotNull File file, @NotNull List<? extends File> list) {
        Intrinsics.p(file, "root");
        Intrinsics.p(list, "segments");
        this.f28823a = file;
        this.f28824b = list;
    }

    public static /* synthetic */ FilePathComponents d(FilePathComponents filePathComponents, File file, List<File> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            file = filePathComponents.f28823a;
        }
        if ((i2 & 2) != 0) {
            list = filePathComponents.f28824b;
        }
        return filePathComponents.c(file, list);
    }

    @NotNull
    public final File a() {
        return this.f28823a;
    }

    @NotNull
    public final List<File> b() {
        return this.f28824b;
    }

    @NotNull
    public final FilePathComponents c(@NotNull File file, @NotNull List<? extends File> list) {
        Intrinsics.p(file, "root");
        Intrinsics.p(list, "segments");
        return new FilePathComponents(file, list);
    }

    @NotNull
    public final File e() {
        return this.f28823a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilePathComponents)) {
            return false;
        }
        FilePathComponents filePathComponents = (FilePathComponents) obj;
        return Intrinsics.g(this.f28823a, filePathComponents.f28823a) && Intrinsics.g(this.f28824b, filePathComponents.f28824b);
    }

    @NotNull
    public final String f() {
        String path = this.f28823a.getPath();
        Intrinsics.o(path, "root.path");
        return path;
    }

    @NotNull
    public final List<File> g() {
        return this.f28824b;
    }

    public final int h() {
        return this.f28824b.size();
    }

    public int hashCode() {
        return (this.f28823a.hashCode() * 31) + this.f28824b.hashCode();
    }

    public final boolean i() {
        String path = this.f28823a.getPath();
        Intrinsics.o(path, "root.path");
        return path.length() > 0;
    }

    @NotNull
    public final File j(int i2, int i3) {
        if (i2 < 0 || i2 > i3 || i3 > h()) {
            throw new IllegalArgumentException();
        }
        List<File> subList = this.f28824b.subList(i2, i3);
        String str = File.separator;
        Intrinsics.o(str, "separator");
        return new File(CollectionsKt.j3(subList, str, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }

    @NotNull
    public String toString() {
        return "FilePathComponents(root=" + this.f28823a + ", segments=" + this.f28824b + ASCIIPropertyListParser.f18650h;
    }
}
