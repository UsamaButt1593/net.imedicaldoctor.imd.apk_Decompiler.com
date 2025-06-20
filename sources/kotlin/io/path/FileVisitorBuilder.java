package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001JG\u0010\f\u001a\u00020\u000b26\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002H&¢\u0006\u0004\b\f\u0010\rJG\u0010\u000f\u001a\u00020\u000b26\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002H&¢\u0006\u0004\b\u000f\u0010\rJG\u0010\u0012\u001a\u00020\u000b26\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\u0002H&¢\u0006\u0004\b\u0012\u0010\rJI\u0010\u0013\u001a\u00020\u000b28\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\u0002H&¢\u0006\u0004\b\u0013\u0010\r\u0001\u0001\u0014¨\u0006\u0015"}, d2 = {"Lkotlin/io/path/FileVisitorBuilder;", "", "Lkotlin/Function2;", "Ljava/nio/file/Path;", "Lkotlin/ParameterName;", "name", "directory", "Ljava/nio/file/attribute/BasicFileAttributes;", "attributes", "Ljava/nio/file/FileVisitResult;", "function", "", "b", "(Lkotlin/jvm/functions/Function2;)V", "file", "a", "Ljava/io/IOException;", "exception", "d", "c", "Lkotlin/io/path/FileVisitorBuilderImpl;", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0})
@SinceKotlin(version = "1.7")
@ExperimentalPathApi
public interface FileVisitorBuilder {
    void a(@NotNull Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function2);

    void b(@NotNull Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function2);

    void c(@NotNull Function2<? super Path, ? super IOException, ? extends FileVisitResult> function2);

    void d(@NotNull Function2<? super Path, ? super IOException, ? extends FileVisitResult> function2);
}
