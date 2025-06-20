package androidx.datastore.preferences.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public interface Parser<MessageType> {
    MessageType a(byte[] bArr) throws InvalidProtocolBufferException;

    MessageType b(byte[] bArr, int i2, int i3, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType c(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType d(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType e(byte[] bArr, int i2, int i3, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType f(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType g(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType h(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType i(InputStream inputStream) throws InvalidProtocolBufferException;

    MessageType j(InputStream inputStream) throws InvalidProtocolBufferException;

    MessageType k(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType l(InputStream inputStream) throws InvalidProtocolBufferException;

    MessageType m(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException;

    MessageType n(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException;

    MessageType o(ByteString byteString) throws InvalidProtocolBufferException;

    MessageType p(byte[] bArr) throws InvalidProtocolBufferException;

    MessageType q(ByteString byteString) throws InvalidProtocolBufferException;

    MessageType r(InputStream inputStream) throws InvalidProtocolBufferException;

    MessageType s(ByteBuffer byteBuffer) throws InvalidProtocolBufferException;

    MessageType t(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType u(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType v(CodedInputStream codedInputStream) throws InvalidProtocolBufferException;

    MessageType w(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType x(CodedInputStream codedInputStream) throws InvalidProtocolBufferException;

    MessageType y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType z(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;
}
