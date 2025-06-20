package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface MessageLite extends MessageLiteOrBuilder {

    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        Builder A2(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        Builder F2(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        MessageLite M1();

        boolean N0(InputStream inputStream) throws IOException;

        Builder P(MessageLite messageLite);

        Builder Q1(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        Builder Z(ByteString byteString) throws InvalidProtocolBufferException;

        Builder Z0(InputStream inputStream) throws IOException;

        Builder a0(CodedInputStream codedInputStream) throws IOException;

        MessageLite build();

        Builder clear();

        Builder clone();

        boolean k2(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        Builder m0(byte[] bArr) throws InvalidProtocolBufferException;

        Builder p0(byte[] bArr, int i2, int i3, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        Builder t2(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException;

        Builder x2(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;
    }

    Builder E();

    void K(OutputStream outputStream) throws IOException;

    int R0();

    void X(OutputStream outputStream) throws IOException;

    Builder b2();

    void j1(CodedOutputStream codedOutputStream) throws IOException;

    ByteString q0();

    Parser<? extends MessageLite> q2();

    byte[] t();
}
