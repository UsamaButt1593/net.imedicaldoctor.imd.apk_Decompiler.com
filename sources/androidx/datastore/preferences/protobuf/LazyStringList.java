package androidx.datastore.preferences.protobuf;

import java.util.Collection;
import java.util.List;

public interface LazyStringList extends ProtocolStringList {
    void C0(ByteString byteString);

    void F1(LazyStringList lazyStringList);

    byte[] K0(int i2);

    void L0(int i2, ByteString byteString);

    boolean R0(Collection<byte[]> collection);

    ByteString T1(int i2);

    void Y0(int i2, byte[] bArr);

    List<?> d1();

    LazyStringList e2();

    List<byte[]> h1();

    boolean j1(Collection<? extends ByteString> collection);

    void u(byte[] bArr);

    Object w2(int i2);
}
