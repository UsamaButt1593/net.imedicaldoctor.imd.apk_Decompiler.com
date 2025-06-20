package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    private static final ExtensionRegistryLite f6965a = ExtensionRegistryLite.d();

    private MessageType A(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.m()) {
            return messagetype;
        }
        throw B(messagetype).a().j(messagetype);
    }

    private UninitializedMessageException B(MessageType messagetype) {
        return messagetype instanceof AbstractMessageLite ? ((AbstractMessageLite) messagetype).O() : new UninitializedMessageException((MessageLite) messagetype);
    }

    /* renamed from: C */
    public MessageType l(InputStream inputStream) throws InvalidProtocolBufferException {
        return h(inputStream, f6965a);
    }

    /* renamed from: D */
    public MessageType h(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return A(t(inputStream, extensionRegistryLite));
    }

    /* renamed from: E */
    public MessageType o(ByteString byteString) throws InvalidProtocolBufferException {
        return d(byteString, f6965a);
    }

    /* renamed from: F */
    public MessageType d(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return A(f(byteString, extensionRegistryLite));
    }

    /* renamed from: G */
    public MessageType v(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return z(codedInputStream, f6965a);
    }

    /* renamed from: H */
    public MessageType z(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return A((MessageLite) y(codedInputStream, extensionRegistryLite));
    }

    /* renamed from: I */
    public MessageType i(InputStream inputStream) throws InvalidProtocolBufferException {
        return w(inputStream, f6965a);
    }

    /* renamed from: J */
    public MessageType w(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return A(g(inputStream, extensionRegistryLite));
    }

    /* renamed from: K */
    public MessageType s(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return u(byteBuffer, f6965a);
    }

    /* renamed from: L */
    public MessageType u(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream n2 = CodedInputStream.n(byteBuffer);
        MessageLite messageLite = (MessageLite) y(n2, extensionRegistryLite);
        try {
            n2.a(0);
            return A(messageLite);
        } catch (InvalidProtocolBufferException e2) {
            throw e2.j(messageLite);
        }
    }

    /* renamed from: M */
    public MessageType a(byte[] bArr) throws InvalidProtocolBufferException {
        return c(bArr, f6965a);
    }

    /* renamed from: N */
    public MessageType m(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
        return e(bArr, i2, i3, f6965a);
    }

    /* renamed from: O */
    public MessageType e(byte[] bArr, int i2, int i3, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return A(b(bArr, i2, i3, extensionRegistryLite));
    }

    /* renamed from: P */
    public MessageType c(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return e(bArr, 0, bArr.length, extensionRegistryLite);
    }

    /* renamed from: Q */
    public MessageType r(InputStream inputStream) throws InvalidProtocolBufferException {
        return t(inputStream, f6965a);
    }

    /* renamed from: R */
    public MessageType t(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return g(new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.O(read, inputStream)), extensionRegistryLite);
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2);
        }
    }

    /* renamed from: S */
    public MessageType q(ByteString byteString) throws InvalidProtocolBufferException {
        return f(byteString, f6965a);
    }

    /* renamed from: T */
    public MessageType f(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream R = byteString.R();
        MessageType messagetype = (MessageLite) y(R, extensionRegistryLite);
        try {
            R.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e2) {
            throw e2.j(messagetype);
        }
    }

    /* renamed from: U */
    public MessageType x(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (MessageLite) y(codedInputStream, f6965a);
    }

    /* renamed from: V */
    public MessageType j(InputStream inputStream) throws InvalidProtocolBufferException {
        return g(inputStream, f6965a);
    }

    /* renamed from: W */
    public MessageType g(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream j2 = CodedInputStream.j(inputStream);
        MessageType messagetype = (MessageLite) y(j2, extensionRegistryLite);
        try {
            j2.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e2) {
            throw e2.j(messagetype);
        }
    }

    /* renamed from: X */
    public MessageType p(byte[] bArr) throws InvalidProtocolBufferException {
        return b(bArr, 0, bArr.length, f6965a);
    }

    /* renamed from: Y */
    public MessageType n(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
        return b(bArr, i2, i3, f6965a);
    }

    /* renamed from: Z */
    public MessageType b(byte[] bArr, int i2, int i3, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream q = CodedInputStream.q(bArr, i2, i3);
        MessageType messagetype = (MessageLite) y(q, extensionRegistryLite);
        try {
            q.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e2) {
            throw e2.j(messagetype);
        }
    }

    /* renamed from: a0 */
    public MessageType k(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return b(bArr, 0, bArr.length, extensionRegistryLite);
    }
}
