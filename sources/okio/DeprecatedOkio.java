package okio;

import com.itextpdf.text.Annotation;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0019\"\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b&\u0010'J+\u0010(\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0019\"\u00020\u001aH\u0007¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0007¢\u0006\u0004\b,\u0010-¨\u0006."}, d2 = {"Lokio/-DeprecatedOkio;", "", "<init>", "()V", "Ljava/io/File;", "file", "Lokio/Sink;", "a", "(Ljava/io/File;)Lokio/Sink;", "sink", "Lokio/BufferedSink;", "c", "(Lokio/Sink;)Lokio/BufferedSink;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "d", "(Lokio/Source;)Lokio/BufferedSource;", "e", "Ljava/io/OutputStream;", "outputStream", "f", "(Ljava/io/OutputStream;)Lokio/Sink;", "Ljava/nio/file/Path;", "path", "", "Ljava/nio/file/OpenOption;", "options", "h", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "Ljava/net/Socket;", "socket", "g", "(Ljava/net/Socket;)Lokio/Sink;", "i", "(Ljava/io/File;)Lokio/Source;", "Ljava/io/InputStream;", "inputStream", "j", "(Ljava/io/InputStream;)Lokio/Source;", "l", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "k", "(Ljava/net/Socket;)Lokio/Source;", "b", "()Lokio/Sink;", "okio"}, k = 1, mv = {1, 5, 1})
@Deprecated(message = "changed in Okio 2.x")
/* renamed from: okio.-DeprecatedOkio  reason: invalid class name */
public final class DeprecatedOkio {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final DeprecatedOkio f31336a = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.appendingSink()", imports = {"okio.appendingSink"}))
    public final Sink a(@NotNull File file) {
        Intrinsics.p(file, Annotation.k3);
        return Okio.a(file);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "blackholeSink()", imports = {"okio.blackholeSink"}))
    public final Sink b() {
        return Okio.c();
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "sink.buffer()", imports = {"okio.buffer"}))
    public final BufferedSink c(@NotNull Sink sink) {
        Intrinsics.p(sink, "sink");
        return Okio.d(sink);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "source.buffer()", imports = {"okio.buffer"}))
    public final BufferedSource d(@NotNull Source source) {
        Intrinsics.p(source, "source");
        return Okio.e(source);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.sink()", imports = {"okio.sink"}))
    public final Sink e(@NotNull File file) {
        Intrinsics.p(file, Annotation.k3);
        return Okio__JvmOkioKt.q(file, false, 1, (Object) null);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "outputStream.sink()", imports = {"okio.sink"}))
    public final Sink f(@NotNull OutputStream outputStream) {
        Intrinsics.p(outputStream, "outputStream");
        return Okio.p(outputStream);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "socket.sink()", imports = {"okio.sink"}))
    public final Sink g(@NotNull Socket socket) {
        Intrinsics.p(socket, "socket");
        return Okio.q(socket);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "path.sink(*options)", imports = {"okio.sink"}))
    public final Sink h(@NotNull Path path, @NotNull OpenOption... openOptionArr) {
        Intrinsics.p(path, Cookie2.PATH);
        Intrinsics.p(openOptionArr, "options");
        return Okio.r(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.source()", imports = {"okio.source"}))
    public final Source i(@NotNull File file) {
        Intrinsics.p(file, Annotation.k3);
        return Okio.t(file);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputStream.source()", imports = {"okio.source"}))
    public final Source j(@NotNull InputStream inputStream) {
        Intrinsics.p(inputStream, "inputStream");
        return Okio.u(inputStream);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "socket.source()", imports = {"okio.source"}))
    public final Source k(@NotNull Socket socket) {
        Intrinsics.p(socket, "socket");
        return Okio.v(socket);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "path.source(*options)", imports = {"okio.source"}))
    public final Source l(@NotNull Path path, @NotNull OpenOption... openOptionArr) {
        Intrinsics.p(path, Cookie2.PATH);
        Intrinsics.p(openOptionArr, "options");
        return Okio.w(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }
}
