package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class ByteOutput {
    public abstract void T(byte b2) throws IOException;

    public abstract void U(ByteBuffer byteBuffer) throws IOException;

    public abstract void V(byte[] bArr, int i2, int i3) throws IOException;

    public abstract void W(ByteBuffer byteBuffer) throws IOException;

    public abstract void X(byte[] bArr, int i2, int i3) throws IOException;
}
