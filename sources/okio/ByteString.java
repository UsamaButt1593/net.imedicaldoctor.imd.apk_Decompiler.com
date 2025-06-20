package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dd.plist.ASCIIPropertyListParser;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.lingala.zip4j.util.InternalZipConstants;
import okio.internal._ByteStringKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0019\b\u0016\u0018\u0000 J2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001yB\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\r\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001b\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\r\u0010\u001c\u001a\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0000H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0000H\u0016¢\u0006\u0004\b#\u0010\"J\u0017\u0010$\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0000H\u0016¢\u0006\u0004\b$\u0010\"J\u001f\u0010%\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0000H\u0010¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0010H\u0016¢\u0006\u0004\b'\u0010\u0012J\u000f\u0010(\u001a\u00020\u0010H\u0016¢\u0006\u0004\b(\u0010\u0012J\u000f\u0010)\u001a\u00020\u0000H\u0016¢\u0006\u0004\b)\u0010\u0019J\u000f\u0010*\u001a\u00020\u0000H\u0016¢\u0006\u0004\b*\u0010\u0019J#\u0010.\u001a\u00020\u00002\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0017¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020+H\u0010¢\u0006\u0004\b2\u00103J\u0018\u00105\u001a\u0002012\u0006\u00104\u001a\u00020+H\u0002¢\u0006\u0004\b5\u00103J\u000f\u00106\u001a\u00020+H\u0010¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0003H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0003H\u0010¢\u0006\u0004\b:\u00109J\u000f\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\t2\u0006\u0010\r\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J'\u0010E\u001a\u00020\t2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020+H\u0010¢\u0006\u0004\bE\u0010FJ/\u0010J\u001a\u00020I2\u0006\u0010C\u001a\u00020+2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020+2\u0006\u0010D\u001a\u00020+H\u0016¢\u0006\u0004\bJ\u0010KJ/\u0010L\u001a\u00020I2\u0006\u0010C\u001a\u00020+2\u0006\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020+2\u0006\u0010D\u001a\u00020+H\u0016¢\u0006\u0004\bL\u0010MJ3\u0010P\u001a\u00020\t2\b\b\u0002\u0010C\u001a\u00020+2\u0006\u0010N\u001a\u00020\u00032\b\b\u0002\u0010O\u001a\u00020+2\u0006\u0010D\u001a\u00020+H\u0016¢\u0006\u0004\bP\u0010QJ\u0015\u0010S\u001a\u00020I2\u0006\u0010R\u001a\u00020\u0000¢\u0006\u0004\bS\u0010TJ\u0015\u0010U\u001a\u00020I2\u0006\u0010R\u001a\u00020\u0003¢\u0006\u0004\bU\u0010VJ\u0015\u0010X\u001a\u00020I2\u0006\u0010W\u001a\u00020\u0000¢\u0006\u0004\bX\u0010TJ\u0015\u0010Y\u001a\u00020I2\u0006\u0010W\u001a\u00020\u0003¢\u0006\u0004\bY\u0010VJ!\u0010[\u001a\u00020+2\u0006\u0010G\u001a\u00020\u00002\b\b\u0002\u0010Z\u001a\u00020+H\u0007¢\u0006\u0004\b[\u0010\\J!\u0010]\u001a\u00020+2\u0006\u0010G\u001a\u00020\u00032\b\b\u0002\u0010Z\u001a\u00020+H\u0017¢\u0006\u0004\b]\u0010^J!\u0010_\u001a\u00020+2\u0006\u0010G\u001a\u00020\u00002\b\b\u0002\u0010Z\u001a\u00020+H\u0007¢\u0006\u0004\b_\u0010\\J!\u0010`\u001a\u00020+2\u0006\u0010G\u001a\u00020\u00032\b\b\u0002\u0010Z\u001a\u00020+H\u0017¢\u0006\u0004\b`\u0010^J\u001a\u0010b\u001a\u00020I2\b\u0010G\u001a\u0004\u0018\u00010aH\u0002¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020+H\u0016¢\u0006\u0004\bd\u00107J\u0018\u0010e\u001a\u00020+2\u0006\u0010G\u001a\u00020\u0000H\u0002¢\u0006\u0004\be\u0010fJ\u000f\u0010g\u001a\u00020\u0010H\u0016¢\u0006\u0004\bg\u0010\u0012J\u0017\u0010h\u001a\u0002012\u0006\u00104\u001a\u00020+H\u0007¢\u0006\u0004\bh\u00103J\u000f\u0010i\u001a\u00020+H\u0007¢\u0006\u0004\bi\u00107R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0004¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u00109R\"\u0010d\u001a\u00020+8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bj\u00107\"\u0004\bo\u0010pR$\u0010v\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010\u0012\"\u0004\bt\u0010uR\u0011\u0010x\u001a\u00020+8G¢\u0006\u0006\u001a\u0004\bw\u00107¨\u0006z"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "", "data", "<init>", "([B)V", "Ljava/io/ObjectInputStream;", "in", "", "d0", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "out", "L0", "(Ljava/io/ObjectOutputStream;)V", "", "I0", "()Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "r0", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "e", "S", "()Lokio/ByteString;", "i0", "j0", "k0", "algorithm", "l", "(Ljava/lang/String;)Lokio/ByteString;", "key", "y", "(Lokio/ByteString;)Lokio/ByteString;", "z", "A", "x", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "f", "w", "C0", "D0", "", "beginIndex", "endIndex", "A0", "(II)Lokio/ByteString;", "pos", "", "K", "(I)B", "index", "q", "u", "()I", "G0", "()[B", "J", "Ljava/nio/ByteBuffer;", "c", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "J0", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "offset", "byteCount", "K0", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "Z", "(ILokio/ByteString;II)Z", "a0", "(I[BII)Z", "target", "targetOffset", "h", "(I[BII)V", "prefix", "p0", "(Lokio/ByteString;)Z", "q0", "([B)Z", "suffix", "o", "p", "fromIndex", "D", "(Lokio/ByteString;I)I", "F", "([BI)I", "N", "P", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "g", "(Lokio/ByteString;)I", "toString", "a", "b", "s", "[B", "r", "X", "I", "e0", "(I)V", "Y", "Ljava/lang/String;", "v", "h0", "(Ljava/lang/String;)V", "utf8", "m0", "size", "Companion", "okio"}, k = 1, mv = {1, 5, 1})
public class ByteString implements Serializable, Comparable<ByteString> {
    private static final long X2 = 1;
    @NotNull
    @JvmField
    public static final ByteString Y2 = new ByteString(new byte[0]);
    @NotNull
    public static final Companion Z = new Companion((DefaultConstructorMarker) null);
    private transient int X;
    @Nullable
    private transient String Y;
    @NotNull
    private final byte[] s;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00020\u0004\"\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00020\u0007*\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\u00020\u0007*\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\u00020\u0007*\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u0007*\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0007*\u00020\u0012H\u0007¢\u0006\u0004\b\u0019\u0010\u0014J\u0013\u0010\u001a\u001a\u00020\u0007*\u00020\u0012H\u0007¢\u0006\u0004\b\u001a\u0010\u0014J\u001b\u0010\u001c\u001a\u00020\u0007*\u00020\u001b2\u0006\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u001f\u0010\u0014J\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0012H\u0007¢\u0006\u0004\b \u0010\u0014J\u001f\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b!\u0010\u0018J\u0017\u0010\"\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\"\u0010\u0014J\u0017\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000fH\u0007¢\u0006\u0004\b$\u0010\u0011J'\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b&\u0010\u000eJ\u001f\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b(\u0010\u001dR\u0014\u0010)\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002XT¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006."}, d2 = {"Lokio/ByteString$Companion;", "", "<init>", "()V", "", "", "data", "Lokio/ByteString;", "n", "([B)Lokio/ByteString;", "", "offset", "byteCount", "o", "([BII)Lokio/ByteString;", "Ljava/nio/ByteBuffer;", "m", "(Ljava/nio/ByteBuffer;)Lokio/ByteString;", "", "l", "(Ljava/lang/String;)Lokio/ByteString;", "Ljava/nio/charset/Charset;", "charset", "j", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/ByteString;", "h", "i", "Ljava/io/InputStream;", "q", "(Ljava/io/InputStream;I)Lokio/ByteString;", "string", "a", "b", "c", "d", "buffer", "e", "array", "f", "inputstream", "g", "EMPTY", "Lokio/ByteString;", "", "serialVersionUID", "J", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ByteString k(Companion companion, String str, Charset charset, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charset = Charsets.f29053b;
            }
            return companion.j(str, charset);
        }

        public static /* synthetic */ ByteString p(Companion companion, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = bArr.length;
            }
            return companion.o(bArr, i2, i3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @Nullable
        @JvmName(name = "-deprecated_decodeBase64")
        public final ByteString a(@NotNull String str) {
            Intrinsics.p(str, TypedValues.Custom.f3952e);
            return h(str);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @JvmName(name = "-deprecated_decodeHex")
        public final ByteString b(@NotNull String str) {
            Intrinsics.p(str, TypedValues.Custom.f3952e);
            return i(str);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @JvmName(name = "-deprecated_encodeString")
        public final ByteString c(@NotNull String str, @NotNull Charset charset) {
            Intrinsics.p(str, TypedValues.Custom.f3952e);
            Intrinsics.p(charset, "charset");
            return j(str, charset);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @JvmName(name = "-deprecated_encodeUtf8")
        public final ByteString d(@NotNull String str) {
            Intrinsics.p(str, TypedValues.Custom.f3952e);
            return l(str);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        public final ByteString e(@NotNull ByteBuffer byteBuffer) {
            Intrinsics.p(byteBuffer, "buffer");
            return m(byteBuffer);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        public final ByteString f(@NotNull byte[] bArr, int i2, int i3) {
            Intrinsics.p(bArr, "array");
            return o(bArr, i2, i3);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @JvmName(name = "-deprecated_read")
        public final ByteString g(@NotNull InputStream inputStream, int i2) {
            Intrinsics.p(inputStream, "inputstream");
            return q(inputStream, i2);
        }

        @JvmStatic
        @Nullable
        public final ByteString h(@NotNull String str) {
            Intrinsics.p(str, "<this>");
            byte[] a2 = _Base64Kt.a(str);
            if (a2 != null) {
                return new ByteString(a2);
            }
            return null;
        }

        @JvmStatic
        @NotNull
        public final ByteString i(@NotNull String str) {
            Intrinsics.p(str, "<this>");
            int i2 = 0;
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                int i3 = length - 1;
                if (i3 >= 0) {
                    while (true) {
                        int i4 = i2 + 1;
                        int i5 = i2 * 2;
                        bArr[i2] = (byte) ((_ByteStringKt.I(str.charAt(i5)) << 4) + _ByteStringKt.I(str.charAt(i5 + 1)));
                        if (i4 > i3) {
                            break;
                        }
                        i2 = i4;
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(Intrinsics.C("Unexpected hex string: ", str).toString());
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "encodeString")
        public final ByteString j(@NotNull String str, @NotNull Charset charset) {
            Intrinsics.p(str, "<this>");
            Intrinsics.p(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.o(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @JvmStatic
        @NotNull
        public final ByteString l(@NotNull String str) {
            Intrinsics.p(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.a(str));
            byteString.h0(str);
            return byteString;
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "of")
        public final ByteString m(@NotNull ByteBuffer byteBuffer) {
            Intrinsics.p(byteBuffer, "<this>");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        @JvmStatic
        @NotNull
        public final ByteString n(@NotNull byte... bArr) {
            Intrinsics.p(bArr, "data");
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.o(copyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(copyOf);
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "of")
        public final ByteString o(@NotNull byte[] bArr, int i2, int i3) {
            Intrinsics.p(bArr, "<this>");
            _UtilKt.e((long) bArr.length, (long) i2, (long) i3);
            return new ByteString(ArraysKt.f1(bArr, i2, i3 + i2));
        }

        @JvmStatic
        @NotNull
        @JvmName(name = "read")
        public final ByteString q(@NotNull InputStream inputStream, int i2) throws IOException {
            Intrinsics.p(inputStream, "<this>");
            int i3 = 0;
            if (i2 >= 0) {
                byte[] bArr = new byte[i2];
                while (i3 < i2) {
                    int read = inputStream.read(bArr, i3, i2 - i3);
                    if (read != -1) {
                        i3 += read;
                    } else {
                        throw new EOFException();
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Integer.valueOf(i2)).toString());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ByteString(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "data");
        this.s = bArr;
    }

    public static /* synthetic */ ByteString B0(ByteString byteString, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = _UtilKt.f();
            }
            return byteString.A0(i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    public static /* synthetic */ int H(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return byteString.D(byteString2, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int I(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return byteString.F(bArr, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    private final void L0(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.s.length);
        objectOutputStream.write(this.s);
    }

    public static /* synthetic */ int Q(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = _UtilKt.f();
            }
            return byteString.N(byteString2, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* synthetic */ int R(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = _UtilKt.f();
            }
            return byteString.P(bArr, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "of")
    public static final ByteString T(@NotNull ByteBuffer byteBuffer) {
        return Z.m(byteBuffer);
    }

    @JvmStatic
    @NotNull
    public static final ByteString U(@NotNull byte... bArr) {
        return Z.n(bArr);
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "of")
    public static final ByteString W(@NotNull byte[] bArr, int i2, int i3) {
        return Z.o(bArr, i2, i3);
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "read")
    public static final ByteString c0(@NotNull InputStream inputStream, int i2) throws IOException {
        return Z.q(inputStream, i2);
    }

    private final void d0(ObjectInputStream objectInputStream) throws IOException {
        ByteString q = Z.q(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("s");
        declaredField.setAccessible(true);
        declaredField.set(this, q.s);
    }

    public static /* synthetic */ void i(ByteString byteString, int i2, byte[] bArr, int i3, int i4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 1) != 0) {
                i2 = 0;
            }
            if ((i5 & 4) != 0) {
                i3 = 0;
            }
            byteString.h(i2, bArr, i3, i4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
    }

    @JvmStatic
    @Nullable
    public static final ByteString j(@NotNull String str) {
        return Z.h(str);
    }

    @JvmStatic
    @NotNull
    public static final ByteString k(@NotNull String str) {
        return Z.i(str);
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "encodeString")
    public static final ByteString m(@NotNull String str, @NotNull Charset charset) {
        return Z.j(str, charset);
    }

    @JvmStatic
    @NotNull
    public static final ByteString n(@NotNull String str) {
        return Z.l(str);
    }

    @NotNull
    public ByteString A(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "key");
        return x("HmacSHA512", byteString);
    }

    @NotNull
    @JvmOverloads
    public ByteString A0(int i2, int i3) {
        int l2 = _UtilKt.l(this, i3);
        boolean z = false;
        if (i2 >= 0) {
            if (l2 <= r().length) {
                if (l2 - i2 >= 0) {
                    z = true;
                }
                if (z) {
                    return (i2 == 0 && l2 == r().length) ? this : new ByteString(ArraysKt.f1(r(), i2, l2));
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + r().length + ASCIIPropertyListParser.f18650h).toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    @JvmOverloads
    public final int C(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "other");
        return H(this, byteString, 0, 2, (Object) null);
    }

    @NotNull
    public ByteString C0() {
        byte b2;
        int i2 = 0;
        while (i2 < r().length) {
            byte b3 = r()[i2];
            byte b4 = (byte) 65;
            if (b3 < b4 || b3 > (b2 = (byte) 90)) {
                i2++;
            } else {
                byte[] r = r();
                byte[] copyOf = Arrays.copyOf(r, r.length);
                Intrinsics.o(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b3 + 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b5 = copyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i3] = (byte) (b5 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @JvmOverloads
    public final int D(@NotNull ByteString byteString, int i2) {
        Intrinsics.p(byteString, "other");
        return F(byteString.J(), i2);
    }

    @NotNull
    public ByteString D0() {
        byte b2;
        int i2 = 0;
        while (i2 < r().length) {
            byte b3 = r()[i2];
            byte b4 = (byte) 97;
            if (b3 < b4 || b3 > (b2 = (byte) 122)) {
                i2++;
            } else {
                byte[] r = r();
                byte[] copyOf = Arrays.copyOf(r, r.length);
                Intrinsics.o(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b3 - 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b5 = copyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i3] = (byte) (b5 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @JvmOverloads
    public final int E(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "other");
        return I(this, bArr, 0, 2, (Object) null);
    }

    @JvmOverloads
    public int F(@NotNull byte[] bArr, int i2) {
        Intrinsics.p(bArr, "other");
        int length = r().length - bArr.length;
        int max = Math.max(i2, 0);
        if (max <= length) {
            while (true) {
                int i3 = max + 1;
                if (_UtilKt.d(r(), max, bArr, 0, bArr.length)) {
                    return max;
                }
                if (max == length) {
                    break;
                }
                max = i3;
            }
        }
        return -1;
    }

    @NotNull
    public byte[] G0() {
        byte[] r = r();
        byte[] copyOf = Arrays.copyOf(r, r.length);
        Intrinsics.o(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public String I0() {
        String v = v();
        if (v != null) {
            return v;
        }
        String c2 = _JvmPlatformKt.c(J());
        h0(c2);
        return c2;
    }

    @NotNull
    public byte[] J() {
        return r();
    }

    public void J0(@NotNull OutputStream outputStream) throws IOException {
        Intrinsics.p(outputStream, "out");
        outputStream.write(this.s);
    }

    public byte K(int i2) {
        return r()[i2];
    }

    public void K0(@NotNull Buffer buffer, int i2, int i3) {
        Intrinsics.p(buffer, "buffer");
        _ByteStringKt.H(this, buffer, i2, i3);
    }

    @JvmOverloads
    public final int L(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "other");
        return Q(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int N(@NotNull ByteString byteString, int i2) {
        Intrinsics.p(byteString, "other");
        return P(byteString.J(), i2);
    }

    @JvmOverloads
    public final int O(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "other");
        return R(this, bArr, 0, 2, (Object) null);
    }

    @JvmOverloads
    public int P(@NotNull byte[] bArr, int i2) {
        Intrinsics.p(bArr, "other");
        int min = Math.min(_UtilKt.l(this, i2), r().length - bArr.length);
        if (min >= 0) {
            while (true) {
                int i3 = min - 1;
                if (_UtilKt.d(r(), min, bArr, 0, bArr.length)) {
                    return min;
                }
                if (i3 < 0) {
                    break;
                }
                min = i3;
            }
        }
        return -1;
    }

    @NotNull
    public final ByteString S() {
        return l("MD5");
    }

    public boolean Z(int i2, @NotNull ByteString byteString, int i3, int i4) {
        Intrinsics.p(byteString, "other");
        return byteString.a0(i3, r(), i2, i4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    public final byte a(int i2) {
        return q(i2);
    }

    public boolean a0(int i2, @NotNull byte[] bArr, int i3, int i4) {
        Intrinsics.p(bArr, "other");
        return i2 >= 0 && i2 <= r().length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && _UtilKt.d(r(), i2, bArr, i3, i4);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    public final int b() {
        return m0();
    }

    @NotNull
    public ByteBuffer c() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.s).asReadOnlyBuffer();
        Intrinsics.o(asReadOnlyBuffer, "wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @NotNull
    public String e() {
        return _Base64Kt.c(r(), (byte[]) null, 1, (Object) null);
    }

    public final void e0(int i2) {
        this.X = i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.m0() == r().length && byteString.a0(0, r(), 0, r().length);
        }
    }

    @NotNull
    public String f() {
        return _Base64Kt.b(r(), _Base64Kt.f());
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x002a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c A[RETURN, SYNTHETIC] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(@org.jetbrains.annotations.NotNull okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.p(r10, r0)
            int r0 = r9.m0()
            int r1 = r10.m0()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L_0x0013:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L_0x002e
            byte r7 = r9.q(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.q(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L_0x0028
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0028:
            if (r7 >= r8) goto L_0x002c
        L_0x002a:
            r3 = -1
            goto L_0x0034
        L_0x002c:
            r3 = 1
            goto L_0x0034
        L_0x002e:
            if (r0 != r1) goto L_0x0031
            goto L_0x0034
        L_0x0031:
            if (r0 >= r1) goto L_0x002c
            goto L_0x002a
        L_0x0034:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public void h(int i2, @NotNull byte[] bArr, int i3, int i4) {
        Intrinsics.p(bArr, TypedValues.AttributesType.M);
        ArraysKt.v0(r(), bArr, i3, i2, i4 + i2);
    }

    public final void h0(@Nullable String str) {
        this.Y = str;
    }

    public int hashCode() {
        int s2 = s();
        if (s2 != 0) {
            return s2;
        }
        int hashCode = Arrays.hashCode(r());
        e0(hashCode);
        return hashCode;
    }

    @NotNull
    public final ByteString i0() {
        return l("SHA-1");
    }

    @NotNull
    public final ByteString j0() {
        return l("SHA-256");
    }

    @NotNull
    public final ByteString k0() {
        return l("SHA-512");
    }

    @NotNull
    public ByteString l(@NotNull String str) {
        Intrinsics.p(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(r(), 0, m0());
        byte[] digest = instance.digest();
        Intrinsics.o(digest, "digestBytes");
        return new ByteString(digest);
    }

    @JvmName(name = "size")
    public final int m0() {
        return u();
    }

    public final boolean o(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "suffix");
        return Z(m0() - byteString.m0(), byteString, 0, byteString.m0());
    }

    public final boolean p(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "suffix");
        return a0(m0() - bArr.length, bArr, 0, bArr.length);
    }

    public final boolean p0(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "prefix");
        return Z(0, byteString, 0, byteString.m0());
    }

    @JvmName(name = "getByte")
    public final byte q(int i2) {
        return K(i2);
    }

    public final boolean q0(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "prefix");
        return a0(0, bArr, 0, bArr.length);
    }

    @NotNull
    public final byte[] r() {
        return this.s;
    }

    @NotNull
    public String r0(@NotNull Charset charset) {
        Intrinsics.p(charset, "charset");
        return new String(this.s, charset);
    }

    public final int s() {
        return this.X;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        String str;
        if (r().length == 0) {
            str = "[size=0]";
        } else {
            int a2 = _ByteStringKt.c(r(), 64);
            if (a2 != -1) {
                String I0 = I0();
                if (I0 != null) {
                    String substring = I0.substring(0, a2);
                    Intrinsics.o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String i2 = StringsKt.i2(StringsKt.i2(StringsKt.i2(substring, "\\", "\\\\", false, 4, (Object) null), StringUtils.LF, "\\n", false, 4, (Object) null), StringUtils.CR, "\\r", false, 4, (Object) null);
                    if (a2 < I0.length()) {
                        sb = new StringBuilder();
                        sb.append("[size=");
                        sb.append(r().length);
                        sb.append(" text=");
                        sb.append(i2);
                    } else {
                        sb = new StringBuilder();
                        sb.append("[text=");
                        sb.append(i2);
                        sb.append(']');
                        return sb.toString();
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (r().length <= 64) {
                str = "[hex=" + w() + ']';
            } else {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(r().length);
                sb.append(" hex=");
                int l2 = _UtilKt.l(this, 64);
                boolean z = true;
                if (l2 <= r().length) {
                    if (l2 < 0) {
                        z = false;
                    }
                    if (z) {
                        sb.append((l2 == r().length ? this : new ByteString(ArraysKt.f1(r(), 0, l2))).w());
                    } else {
                        throw new IllegalArgumentException("endIndex < beginIndex".toString());
                    }
                } else {
                    throw new IllegalArgumentException(("endIndex > length(" + r().length + ASCIIPropertyListParser.f18650h).toString());
                }
            }
            sb.append("…]");
            return sb.toString();
        }
        return str;
    }

    public int u() {
        return r().length;
    }

    @Nullable
    public final String v() {
        return this.Y;
    }

    @NotNull
    @JvmOverloads
    public final ByteString v0() {
        return B0(this, 0, 0, 3, (Object) null);
    }

    @NotNull
    public String w() {
        char[] cArr = new char[(r().length * 2)];
        byte[] r = r();
        int length = r.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = r[i2];
            i2++;
            int i4 = i3 + 1;
            cArr[i3] = _ByteStringKt.J()[(b2 >> 4) & 15];
            i3 += 2;
            cArr[i4] = _ByteStringKt.J()[b2 & 15];
        }
        return StringsKt.t1(cArr);
    }

    @NotNull
    public ByteString x(@NotNull String str, @NotNull ByteString byteString) {
        Intrinsics.p(str, "algorithm");
        Intrinsics.p(byteString, "key");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.G0(), str));
            byte[] doFinal = instance.doFinal(this.s);
            Intrinsics.o(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @NotNull
    @JvmOverloads
    public final ByteString x0(int i2) {
        return B0(this, i2, 0, 2, (Object) null);
    }

    @NotNull
    public ByteString y(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "key");
        return x(InternalZipConstants.f30712f, byteString);
    }

    @NotNull
    public ByteString z(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "key");
        return x("HmacSHA256", byteString);
    }
}
