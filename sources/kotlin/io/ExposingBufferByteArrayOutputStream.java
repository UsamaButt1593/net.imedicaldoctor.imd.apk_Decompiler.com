package kotlin.io;

import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lkotlin/io/ExposingBufferByteArrayOutputStream;", "Ljava/io/ByteArrayOutputStream;", "", "size", "<init>", "(I)V", "", "b", "()[B", "buffer", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class ExposingBufferByteArrayOutputStream extends ByteArrayOutputStream {
    public ExposingBufferByteArrayOutputStream(int i2) {
        super(i2);
    }

    @NotNull
    public final byte[] b() {
        byte[] bArr = this.buf;
        Intrinsics.o(bArr, "buf");
        return bArr;
    }
}
