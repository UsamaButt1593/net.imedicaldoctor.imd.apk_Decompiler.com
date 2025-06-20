package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.AbstractMessageLite.Builder;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.MessageLite;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode = 0;

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {

        static final class LimitedInputStream extends FilterInputStream {
            private int s;

            LimitedInputStream(InputStream inputStream, int i2) {
                super(inputStream);
                this.s = i2;
            }

            public int available() throws IOException {
                return Math.min(super.available(), this.s);
            }

            public int read() throws IOException {
                if (this.s <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.s--;
                }
                return read;
            }

            public long skip(long j2) throws IOException {
                long skip = super.skip(Math.min(j2, (long) this.s));
                if (skip >= 0) {
                    this.s = (int) (((long) this.s) - skip);
                }
                return skip;
            }

            public int read(byte[] bArr, int i2, int i3) throws IOException {
                int i4 = this.s;
                if (i4 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i2, Math.min(i3, i4));
                if (read >= 0) {
                    this.s -= read;
                }
                return read;
            }
        }

        @Deprecated
        protected static <T> void G2(Iterable<T> iterable, Collection<? super T> collection) {
            I2(iterable, (List) collection);
        }

        protected static <T> void I2(Iterable<T> iterable, List<? super T> list) {
            Internal.d(iterable);
            if (iterable instanceof LazyStringList) {
                List<?> d1 = ((LazyStringList) iterable).d1();
                LazyStringList lazyStringList = (LazyStringList) list;
                int size = list.size();
                for (Object next : d1) {
                    if (next == null) {
                        String str = "Element at index " + (lazyStringList.size() - size) + " is null.";
                        for (int size2 = lazyStringList.size() - 1; size2 >= size; size2--) {
                            lazyStringList.remove(size2);
                        }
                        throw new NullPointerException(str);
                    } else if (next instanceof ByteString) {
                        lazyStringList.C0((ByteString) next);
                    } else {
                        lazyStringList.add((String) next);
                    }
                }
            } else if (iterable instanceof PrimitiveNonBoxingCollection) {
                list.addAll((Collection) iterable);
            } else {
                J2(iterable, list);
            }
        }

        private static <T> void J2(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T next : iterable) {
                if (next == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(next);
            }
        }

        private String M2(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        protected static UninitializedMessageException b3(MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }

        /* renamed from: L2 */
        public abstract BuilderType clone();

        public boolean N0(InputStream inputStream) throws IOException {
            return k2(inputStream, ExtensionRegistryLite.d());
        }

        /* access modifiers changed from: protected */
        public abstract BuilderType N2(MessageType messagetype);

        /* renamed from: P2 */
        public BuilderType Z(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                CodedInputStream R = byteString.R();
                a0(R);
                R.a(0);
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(M2("ByteString"), e3);
            }
        }

        /* renamed from: Q2 */
        public BuilderType F2(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            try {
                CodedInputStream R = byteString.R();
                Q1(R, extensionRegistryLite);
                R.a(0);
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(M2("ByteString"), e3);
            }
        }

        /* renamed from: S2 */
        public BuilderType a0(CodedInputStream codedInputStream) throws IOException {
            return Q1(codedInputStream, ExtensionRegistryLite.d());
        }

        /* renamed from: T2 */
        public abstract BuilderType Q1(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        /* renamed from: U2 */
        public BuilderType P(MessageLite messageLite) {
            if (D().getClass().isInstance(messageLite)) {
                return N2((AbstractMessageLite) messageLite);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        /* renamed from: V2 */
        public BuilderType Z0(InputStream inputStream) throws IOException {
            CodedInputStream j2 = CodedInputStream.j(inputStream);
            a0(j2);
            j2.a(0);
            return this;
        }

        /* renamed from: W2 */
        public BuilderType A2(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            CodedInputStream j2 = CodedInputStream.j(inputStream);
            Q1(j2, extensionRegistryLite);
            j2.a(0);
            return this;
        }

        /* renamed from: X2 */
        public BuilderType m0(byte[] bArr) throws InvalidProtocolBufferException {
            return t2(bArr, 0, bArr.length);
        }

        /* renamed from: Y2 */
        public BuilderType t2(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
            try {
                CodedInputStream q = CodedInputStream.q(bArr, i2, i3);
                a0(q);
                q.a(0);
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(M2("byte array"), e3);
            }
        }

        /* renamed from: Z2 */
        public BuilderType p0(byte[] bArr, int i2, int i3, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            try {
                CodedInputStream q = CodedInputStream.q(bArr, i2, i3);
                Q1(q, extensionRegistryLite);
                q.a(0);
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(M2("byte array"), e3);
            }
        }

        /* renamed from: a3 */
        public BuilderType x2(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return p0(bArr, 0, bArr.length, extensionRegistryLite);
        }

        public boolean k2(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            A2(new LimitedInputStream(inputStream, CodedInputStream.O(read, inputStream)), extensionRegistryLite);
            return true;
        }
    }

    protected interface InternalOneOfEnum {
        int d();
    }

    protected static void C(ByteString byteString) throws IllegalArgumentException {
        if (!byteString.N()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String N(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    @Deprecated
    protected static <T> void j(Iterable<T> iterable, Collection<? super T> collection) {
        Builder.I2(iterable, (List) collection);
    }

    protected static <T> void k(Iterable<T> iterable, List<? super T> list) {
        Builder.I2(iterable, list);
    }

    /* access modifiers changed from: package-private */
    public int H() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int I(Schema schema) {
        int H = H();
        if (H != -1) {
            return H;
        }
        int g2 = schema.g(this);
        R(g2);
        return g2;
    }

    public void K(OutputStream outputStream) throws IOException {
        CodedOutputStream k1 = CodedOutputStream.k1(outputStream, CodedOutputStream.J0(R0()));
        j1(k1);
        k1.e1();
    }

    /* access modifiers changed from: package-private */
    public UninitializedMessageException O() {
        return new UninitializedMessageException((MessageLite) this);
    }

    /* access modifiers changed from: package-private */
    public void R(int i2) {
        throw new UnsupportedOperationException();
    }

    public void X(OutputStream outputStream) throws IOException {
        int R0 = R0();
        CodedOutputStream k1 = CodedOutputStream.k1(outputStream, CodedOutputStream.J0(CodedOutputStream.L0(R0) + R0));
        k1.Z1(R0);
        j1(k1);
        k1.e1();
    }

    public ByteString q0() {
        try {
            ByteString.CodedBuilder P = ByteString.P(R0());
            j1(P.b());
            return P.a();
        } catch (IOException e2) {
            throw new RuntimeException(N("ByteString"), e2);
        }
    }

    public byte[] t() {
        try {
            byte[] bArr = new byte[R0()];
            CodedOutputStream n1 = CodedOutputStream.n1(bArr);
            j1(n1);
            n1.Z();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(N("byte array"), e2);
        }
    }
}
