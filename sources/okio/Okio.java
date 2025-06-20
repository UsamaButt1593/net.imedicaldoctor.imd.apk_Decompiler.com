package okio;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt"}, k = 4, mv = {1, 5, 1}, xi = 48)
public final class Okio {
    @NotNull
    public static final Sink a(@NotNull File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.b(file);
    }

    @NotNull
    public static final FileSystem b(@NotNull ClassLoader classLoader) {
        return Okio__JvmOkioKt.c(classLoader);
    }

    @NotNull
    @JvmName(name = "blackhole")
    public static final Sink c() {
        return Okio__OkioKt.a();
    }

    @NotNull
    public static final BufferedSink d(@NotNull Sink sink) {
        return Okio__OkioKt.b(sink);
    }

    @NotNull
    public static final BufferedSource e(@NotNull Source source) {
        return Okio__OkioKt.c(source);
    }

    @NotNull
    public static final CipherSink f(@NotNull Sink sink, @NotNull Cipher cipher) {
        return Okio__JvmOkioKt.d(sink, cipher);
    }

    @NotNull
    public static final CipherSource g(@NotNull Source source, @NotNull Cipher cipher) {
        return Okio__JvmOkioKt.e(source, cipher);
    }

    @NotNull
    public static final HashingSink h(@NotNull Sink sink, @NotNull MessageDigest messageDigest) {
        return Okio__JvmOkioKt.f(sink, messageDigest);
    }

    @NotNull
    public static final HashingSink i(@NotNull Sink sink, @NotNull Mac mac) {
        return Okio__JvmOkioKt.g(sink, mac);
    }

    @NotNull
    public static final HashingSource j(@NotNull Source source, @NotNull MessageDigest messageDigest) {
        return Okio__JvmOkioKt.h(source, messageDigest);
    }

    @NotNull
    public static final HashingSource k(@NotNull Source source, @NotNull Mac mac) {
        return Okio__JvmOkioKt.i(source, mac);
    }

    public static final boolean l(@NotNull AssertionError assertionError) {
        return Okio__JvmOkioKt.j(assertionError);
    }

    @NotNull
    public static final FileSystem m(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        return Okio__JvmOkioKt.k(fileSystem, path);
    }

    @NotNull
    @JvmOverloads
    public static final Sink n(@NotNull File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.l(file);
    }

    @NotNull
    @JvmOverloads
    public static final Sink o(@NotNull File file, boolean z) throws FileNotFoundException {
        return Okio__JvmOkioKt.m(file, z);
    }

    @NotNull
    public static final Sink p(@NotNull OutputStream outputStream) {
        return Okio__JvmOkioKt.n(outputStream);
    }

    @NotNull
    public static final Sink q(@NotNull Socket socket) throws IOException {
        return Okio__JvmOkioKt.o(socket);
    }

    @NotNull
    @IgnoreJRERequirement
    public static final Sink r(@NotNull Path path, @NotNull OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.p(path, openOptionArr);
    }

    @NotNull
    public static final Source t(@NotNull File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.r(file);
    }

    @NotNull
    public static final Source u(@NotNull InputStream inputStream) {
        return Okio__JvmOkioKt.s(inputStream);
    }

    @NotNull
    public static final Source v(@NotNull Socket socket) throws IOException {
        return Okio__JvmOkioKt.t(socket);
    }

    @NotNull
    @IgnoreJRERequirement
    public static final Source w(@NotNull Path path, @NotNull OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.u(path, openOptionArr);
    }

    public static final <T extends Closeable, R> R x(T t, @NotNull Function1<? super T, ? extends R> function1) {
        return Okio__OkioKt.d(t, function1);
    }
}
