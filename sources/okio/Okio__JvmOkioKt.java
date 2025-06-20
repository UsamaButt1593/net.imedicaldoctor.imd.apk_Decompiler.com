package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\u0001*\u00020\b¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\u0005*\u00020\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\u0010\u001a\u00020\u0001*\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0011\u0010\u0012\u001a\u00020\u0001*\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0014\u001a\u00020\u0005*\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u001a\u001a\u00020\u0001*\u00020\u00162\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a'\u0010\u001c\u001a\u00020\u0005*\u00020\u00162\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010!\u001a\u00020 *\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"\u001a\u0019\u0010$\u001a\u00020#*\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b$\u0010%\u001a\u0019\u0010)\u001a\u00020(*\u00020\u00012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b)\u0010*\u001a\u0019\u0010,\u001a\u00020+*\u00020\u00052\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b,\u0010-\u001a\u0019\u00100\u001a\u00020(*\u00020\u00012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101\u001a\u0019\u00102\u001a\u00020+*\u00020\u00052\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b2\u00103\u001a\u0019\u00107\u001a\u000204*\u0002042\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108\u001a\u0011\u0010:\u001a\u000204*\u000209¢\u0006\u0004\b:\u0010;\"\u001c\u0010@\u001a\n =*\u0004\u0018\u00010<0<8\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?\"\u001c\u0010E\u001a\u00020\u000e*\u00060Aj\u0002`B8@X\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006F"}, d2 = {"Ljava/io/OutputStream;", "Lokio/Sink;", "n", "(Ljava/io/OutputStream;)Lokio/Sink;", "Ljava/io/InputStream;", "Lokio/Source;", "s", "(Ljava/io/InputStream;)Lokio/Source;", "Ljava/net/Socket;", "o", "(Ljava/net/Socket;)Lokio/Sink;", "t", "(Ljava/net/Socket;)Lokio/Source;", "Ljava/io/File;", "", "append", "m", "(Ljava/io/File;Z)Lokio/Sink;", "b", "(Ljava/io/File;)Lokio/Sink;", "r", "(Ljava/io/File;)Lokio/Source;", "Ljava/nio/file/Path;", "", "Ljava/nio/file/OpenOption;", "options", "p", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "u", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "Ljavax/crypto/Cipher;", "cipher", "Lokio/CipherSink;", "d", "(Lokio/Sink;Ljavax/crypto/Cipher;)Lokio/CipherSink;", "Lokio/CipherSource;", "e", "(Lokio/Source;Ljavax/crypto/Cipher;)Lokio/CipherSource;", "Ljavax/crypto/Mac;", "mac", "Lokio/HashingSink;", "g", "(Lokio/Sink;Ljavax/crypto/Mac;)Lokio/HashingSink;", "Lokio/HashingSource;", "i", "(Lokio/Source;Ljavax/crypto/Mac;)Lokio/HashingSource;", "Ljava/security/MessageDigest;", "digest", "f", "(Lokio/Sink;Ljava/security/MessageDigest;)Lokio/HashingSink;", "h", "(Lokio/Source;Ljava/security/MessageDigest;)Lokio/HashingSource;", "Lokio/FileSystem;", "Lokio/Path;", "zipPath", "k", "(Lokio/FileSystem;Lokio/Path;)Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "c", "(Ljava/lang/ClassLoader;)Lokio/FileSystem;", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "a", "Ljava/util/logging/Logger;", "logger", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "j", "(Ljava/lang/AssertionError;)Z", "isAndroidGetsocknameError", "okio"}, k = 5, mv = {1, 5, 1}, xs = "okio/Okio")
final /* synthetic */ class Okio__JvmOkioKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f31370a = Logger.getLogger("okio.Okio");

    @NotNull
    public static final Sink b(@NotNull File file) throws FileNotFoundException {
        Intrinsics.p(file, "<this>");
        return Okio.p(new FileOutputStream(file, true));
    }

    @NotNull
    public static final FileSystem c(@NotNull ClassLoader classLoader) {
        Intrinsics.p(classLoader, "<this>");
        return new ResourceFileSystem(classLoader, true);
    }

    @NotNull
    public static final CipherSink d(@NotNull Sink sink, @NotNull Cipher cipher) {
        Intrinsics.p(sink, "<this>");
        Intrinsics.p(cipher, "cipher");
        return new CipherSink(Okio.d(sink), cipher);
    }

    @NotNull
    public static final CipherSource e(@NotNull Source source, @NotNull Cipher cipher) {
        Intrinsics.p(source, "<this>");
        Intrinsics.p(cipher, "cipher");
        return new CipherSource(Okio.e(source), cipher);
    }

    @NotNull
    public static final HashingSink f(@NotNull Sink sink, @NotNull MessageDigest messageDigest) {
        Intrinsics.p(sink, "<this>");
        Intrinsics.p(messageDigest, "digest");
        return new HashingSink(sink, messageDigest);
    }

    @NotNull
    public static final HashingSink g(@NotNull Sink sink, @NotNull Mac mac) {
        Intrinsics.p(sink, "<this>");
        Intrinsics.p(mac, "mac");
        return new HashingSink(sink, mac);
    }

    @NotNull
    public static final HashingSource h(@NotNull Source source, @NotNull MessageDigest messageDigest) {
        Intrinsics.p(source, "<this>");
        Intrinsics.p(messageDigest, "digest");
        return new HashingSource(source, messageDigest);
    }

    @NotNull
    public static final HashingSource i(@NotNull Source source, @NotNull Mac mac) {
        Intrinsics.p(source, "<this>");
        Intrinsics.p(mac, "mac");
        return new HashingSource(source, mac);
    }

    public static final boolean j(@NotNull AssertionError assertionError) {
        Intrinsics.p(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message == null ? false : StringsKt.T2(message, "getsockname failed", false, 2, (Object) null);
    }

    @NotNull
    public static final FileSystem k(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.p(fileSystem, "<this>");
        Intrinsics.p(path, "zipPath");
        return ZipKt.e(path, fileSystem, (Function1) null, 4, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public static final Sink l(@NotNull File file) throws FileNotFoundException {
        Intrinsics.p(file, "<this>");
        return q(file, false, 1, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public static final Sink m(@NotNull File file, boolean z) throws FileNotFoundException {
        Intrinsics.p(file, "<this>");
        return Okio.p(new FileOutputStream(file, z));
    }

    @NotNull
    public static final Sink n(@NotNull OutputStream outputStream) {
        Intrinsics.p(outputStream, "<this>");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    @NotNull
    public static final Sink o(@NotNull Socket socket) throws IOException {
        Intrinsics.p(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.o(outputStream, "getOutputStream()");
        return socketAsyncTimeout.A(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    @NotNull
    @IgnoreJRERequirement
    public static final Sink p(@NotNull Path path, @NotNull OpenOption... openOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(openOptionArr, "options");
        OutputStream a2 = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.o(a2, "newOutputStream(this, *options)");
        return Okio.p(a2);
    }

    public static /* synthetic */ Sink q(File file, boolean z, int i2, Object obj) throws FileNotFoundException {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return Okio.o(file, z);
    }

    @NotNull
    public static final Source r(@NotNull File file) throws FileNotFoundException {
        Intrinsics.p(file, "<this>");
        return new InputStreamSource(new FileInputStream(file), Timeout.f31400e);
    }

    @NotNull
    public static final Source s(@NotNull InputStream inputStream) {
        Intrinsics.p(inputStream, "<this>");
        return new InputStreamSource(inputStream, new Timeout());
    }

    @NotNull
    public static final Source t(@NotNull Socket socket) throws IOException {
        Intrinsics.p(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.o(inputStream, "getInputStream()");
        return socketAsyncTimeout.B(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    @NotNull
    @IgnoreJRERequirement
    public static final Source u(@NotNull Path path, @NotNull OpenOption... openOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(openOptionArr, "options");
        InputStream a2 = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.o(a2, "newInputStream(this, *options)");
        return Okio.u(a2);
    }
}
