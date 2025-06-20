package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected int memoizedSerializedSize = -1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.e();

    /* renamed from: androidx.datastore.preferences.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7154a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$JavaType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7154a = r0
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7154a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r1 = androidx.datastore.preferences.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.GeneratedMessageLite.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        protected MessageType X;
        protected boolean Y = false;
        private final MessageType s;

        protected Builder(MessageType messagetype) {
            this.s = messagetype;
            this.X = (GeneratedMessageLite) messagetype.x0(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        private void n3(MessageType messagetype, MessageType messagetype2) {
            Protobuf.a().j(messagetype).a(messagetype, messagetype2);
        }

        /* renamed from: c3 */
        public final MessageType build() {
            MessageType d3 = M1();
            if (d3.m()) {
                return d3;
            }
            throw AbstractMessageLite.Builder.b3(d3);
        }

        /* renamed from: d3 */
        public MessageType M1() {
            if (this.Y) {
                return this.X;
            }
            this.X.n1();
            this.Y = true;
            return this.X;
        }

        /* renamed from: e3 */
        public final BuilderType clear() {
            this.X = (GeneratedMessageLite) this.X.x0(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            return this;
        }

        /* renamed from: f3 */
        public BuilderType clone() {
            BuilderType I1 = D().b2();
            I1.k3(M1());
            return I1;
        }

        /* access modifiers changed from: protected */
        public void g3() {
            if (this.Y) {
                MessageType messagetype = (GeneratedMessageLite) this.X.x0(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                n3(messagetype, this.X);
                this.X = messagetype;
                this.Y = false;
            }
        }

        /* renamed from: h3 */
        public MessageType D() {
            return this.s;
        }

        /* access modifiers changed from: protected */
        /* renamed from: i3 */
        public BuilderType N2(MessageType messagetype) {
            return k3(messagetype);
        }

        /* renamed from: j3 */
        public BuilderType T2(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            g3();
            try {
                Protobuf.a().j(this.X).b(this.X, CodedInputStreamReader.T(codedInputStream), extensionRegistryLite);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }

        public BuilderType k3(MessageType messagetype) {
            g3();
            n3(this.X, messagetype);
            return this;
        }

        /* renamed from: l3 */
        public BuilderType t2(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
            return p0(bArr, i2, i3, ExtensionRegistryLite.d());
        }

        public final boolean m() {
            return GeneratedMessageLite.m1(this.X, false);
        }

        /* renamed from: m3 */
        public BuilderType p0(byte[] bArr, int i2, int i3, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            g3();
            try {
                Protobuf.a().j(this.X).i(this.X, bArr, i2, i2 + i3, new ArrayDecoders.Registers(extensionRegistryLite));
                return this;
            } catch (InvalidProtocolBufferException e2) {
                throw e2;
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.l();
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            }
        }
    }

    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {

        /* renamed from: b  reason: collision with root package name */
        private final T f7155b;

        public DefaultInstanceBasedParser(T t) {
            this.f7155b = t;
        }

        /* renamed from: b0 */
        public T y(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.D2(this.f7155b, codedInputStream, extensionRegistryLite);
        }

        /* renamed from: c0 */
        public T b(byte[] bArr, int i2, int i3, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.G2(this.f7155b, bArr, i2, i3, extensionRegistryLite);
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected ExtendableBuilder(MessageType messagetype) {
            super(messagetype);
        }

        private FieldSet<ExtensionDescriptor> r3() {
            FieldSet<ExtensionDescriptor> fieldSet = ((ExtendableMessage) this.X).extensions;
            if (!fieldSet.D()) {
                return fieldSet;
            }
            FieldSet<ExtensionDescriptor> k2 = fieldSet.clone();
            ((ExtendableMessage) this.X).extensions = k2;
            return k2;
        }

        private void v3(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.h() != D()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> boolean J(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.X).J(extensionLite);
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [androidx.datastore.preferences.protobuf.ExtensionLite, androidx.datastore.preferences.protobuf.ExtensionLite<MessageType, java.util.List<Type>>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <Type> Type U1(androidx.datastore.preferences.protobuf.ExtensionLite<MessageType, java.util.List<Type>> r2, int r3) {
            /*
                r1 = this;
                MessageType r0 = r1.X
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage r0 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage) r0
                java.lang.Object r2 = r0.U1(r2, r3)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableBuilder.U1(androidx.datastore.preferences.protobuf.ExtensionLite, int):java.lang.Object");
        }

        public final <Type> Type c0(ExtensionLite<MessageType, Type> extensionLite) {
            return ((ExtendableMessage) this.X).c0(extensionLite);
        }

        public final <Type> int g0(ExtensionLite<MessageType, List<Type>> extensionLite) {
            return ((ExtendableMessage) this.X).g0(extensionLite);
        }

        /* access modifiers changed from: protected */
        public void g3() {
            if (this.Y) {
                super.g3();
                MessageType messagetype = this.X;
                ((ExtendableMessage) messagetype).extensions = ((ExtendableMessage) messagetype).extensions.clone();
            }
        }

        public final <Type> BuilderType o3(ExtensionLite<MessageType, List<Type>> extensionLite, Type type) {
            GeneratedExtension T = GeneratedMessageLite.d0(extensionLite);
            v3(T);
            g3();
            r3().h(T.f7163d, T.j(type));
            return this;
        }

        /* renamed from: p3 */
        public final MessageType d3() {
            MessageType d3;
            if (this.Y) {
                d3 = this.X;
            } else {
                ((ExtendableMessage) this.X).extensions.I();
                d3 = super.M1();
            }
            return (ExtendableMessage) d3;
        }

        public final <Type> BuilderType q3(ExtensionLite<MessageType, ?> extensionLite) {
            GeneratedExtension T = GeneratedMessageLite.d0(extensionLite);
            v3(T);
            g3();
            r3().j(T.f7163d);
            return this;
        }

        /* access modifiers changed from: package-private */
        public void s3(FieldSet<ExtensionDescriptor> fieldSet) {
            g3();
            ((ExtendableMessage) this.X).extensions = fieldSet;
        }

        public final <Type> BuilderType t3(ExtensionLite<MessageType, List<Type>> extensionLite, int i2, Type type) {
            GeneratedExtension T = GeneratedMessageLite.d0(extensionLite);
            v3(T);
            g3();
            r3().P(T.f7163d, i2, T.j(type));
            return this;
        }

        public final <Type> BuilderType u3(ExtensionLite<MessageType, Type> extensionLite, Type type) {
            GeneratedExtension T = GeneratedMessageLite.d0(extensionLite);
            v3(T);
            g3();
            r3().O(T.f7163d, T.k(type));
            return this;
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions = FieldSet.s();

        protected class ExtensionWriter {

            /* renamed from: a  reason: collision with root package name */
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> f7156a;

            /* renamed from: b  reason: collision with root package name */
            private Map.Entry<ExtensionDescriptor, Object> f7157b;

            /* renamed from: c  reason: collision with root package name */
            private final boolean f7158c;

            private ExtensionWriter(boolean z) {
                Iterator<Map.Entry<ExtensionDescriptor, Object>> H = ExtendableMessage.this.extensions.H();
                this.f7156a = H;
                if (H.hasNext()) {
                    this.f7157b = H.next();
                }
                this.f7158c = z;
            }

            public void a(int i2, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<ExtensionDescriptor, Object> entry = this.f7157b;
                    if (entry != null && entry.getKey().d() < i2) {
                        ExtensionDescriptor key = this.f7157b.getKey();
                        if (!this.f7158c || key.U1() != WireFormat.JavaType.MESSAGE || key.M()) {
                            FieldSet.T(key, this.f7157b.getValue(), codedOutputStream);
                        } else {
                            codedOutputStream.P1(key.d(), (MessageLite) this.f7157b.getValue());
                        }
                        this.f7157b = this.f7156a.hasNext() ? this.f7156a.next() : null;
                    } else {
                        return;
                    }
                }
            }

            /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z, AnonymousClass1 r3) {
                this(z);
            }
        }

        private void L2(CodedInputStream codedInputStream, GeneratedExtension<?, ?> generatedExtension, ExtensionRegistryLite extensionRegistryLite, int i2) throws IOException {
            V2(codedInputStream, extensionRegistryLite, generatedExtension, WireFormat.c(i2, 2), i2);
        }

        private void R2(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, GeneratedExtension<?, ?> generatedExtension) throws IOException {
            MessageLite messageLite = (MessageLite) this.extensions.u(generatedExtension.f7163d);
            MessageLite.Builder E = messageLite != null ? messageLite.E() : null;
            if (E == null) {
                E = generatedExtension.c().b2();
            }
            E.F2(byteString, extensionRegistryLite);
            M2().O(generatedExtension.f7163d, generatedExtension.j(E.build()));
        }

        private <MessageType extends MessageLite> void S2(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i2 = 0;
            ByteString byteString = null;
            GeneratedExtension generatedExtension = null;
            while (true) {
                int Y = codedInputStream.Y();
                if (Y == 0) {
                    break;
                } else if (Y == WireFormat.s) {
                    i2 = codedInputStream.Z();
                    if (i2 != 0) {
                        generatedExtension = extensionRegistryLite.c(messagetype, i2);
                    }
                } else if (Y == WireFormat.t) {
                    if (i2 == 0 || generatedExtension == null) {
                        byteString = codedInputStream.x();
                    } else {
                        L2(codedInputStream, generatedExtension, extensionRegistryLite, i2);
                        byteString = null;
                    }
                } else if (!codedInputStream.g0(Y)) {
                    break;
                }
            }
            codedInputStream.a(WireFormat.r);
            if (byteString != null && i2 != 0) {
                if (generatedExtension != null) {
                    R2(byteString, extensionRegistryLite, generatedExtension);
                } else {
                    o1(i2, byteString);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cf, code lost:
            r9 = (androidx.datastore.preferences.protobuf.MessageLite) r5.extensions.u(r8.f7163d);
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean V2(androidx.datastore.preferences.protobuf.CodedInputStream r6, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r7, androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?> r8, int r9, int r10) throws java.io.IOException {
            /*
                r5 = this;
                int r0 = androidx.datastore.preferences.protobuf.WireFormat.b(r9)
                r1 = 1
                r2 = 0
                if (r8 != 0) goto L_0x000b
            L_0x0008:
                r0 = 1
            L_0x0009:
                r3 = 0
                goto L_0x0035
            L_0x000b:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r8.f7163d
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = r3.V()
                int r3 = androidx.datastore.preferences.protobuf.FieldSet.A(r3, r2)
                if (r0 != r3) goto L_0x0019
                r0 = 0
                goto L_0x0009
            L_0x0019:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r8.f7163d
                boolean r4 = r3.Z
                if (r4 == 0) goto L_0x0008
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = r3.Y
                boolean r3 = r3.c()
                if (r3 == 0) goto L_0x0008
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r8.f7163d
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = r3.V()
                int r3 = androidx.datastore.preferences.protobuf.FieldSet.A(r3, r1)
                if (r0 != r3) goto L_0x0008
                r0 = 0
                r3 = 1
            L_0x0035:
                if (r0 == 0) goto L_0x003c
                boolean r6 = r5.I2(r9, r6)
                return r6
            L_0x003c:
                r5.M2()
                if (r3 == 0) goto L_0x0093
                int r7 = r6.N()
                int r7 = r6.t(r7)
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.f7163d
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = r9.V()
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM
                if (r9 != r10) goto L_0x0076
            L_0x0053:
                int r9 = r6.f()
                if (r9 <= 0) goto L_0x008e
                int r9 = r6.z()
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r8.f7163d
                androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r10 = r10.b1()
                androidx.datastore.preferences.protobuf.Internal$EnumLite r9 = r10.a(r9)
                if (r9 != 0) goto L_0x006a
                return r1
            L_0x006a:
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r10 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r8.f7163d
                java.lang.Object r9 = r8.j(r9)
                r10.h(r0, r9)
                goto L_0x0053
            L_0x0076:
                int r9 = r6.f()
                if (r9 <= 0) goto L_0x008e
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.f7163d
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = r9.V()
                java.lang.Object r9 = androidx.datastore.preferences.protobuf.FieldSet.N(r6, r9, r2)
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r10 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r8.f7163d
                r10.h(r0, r9)
                goto L_0x0076
            L_0x008e:
                r6.s(r7)
                goto L_0x0123
            L_0x0093:
                int[] r9 = androidx.datastore.preferences.protobuf.GeneratedMessageLite.AnonymousClass1.f7154a
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r8.f7163d
                androidx.datastore.preferences.protobuf.WireFormat$JavaType r0 = r0.U1()
                int r0 = r0.ordinal()
                r9 = r9[r0]
                if (r9 == r1) goto L_0x00c7
                r7 = 2
                if (r9 == r7) goto L_0x00b1
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r8.f7163d
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r7 = r7.V()
                java.lang.Object r6 = androidx.datastore.preferences.protobuf.FieldSet.N(r6, r7, r2)
                goto L_0x0104
            L_0x00b1:
                int r6 = r6.z()
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r8.f7163d
                androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r7 = r7.b1()
                androidx.datastore.preferences.protobuf.Internal$EnumLite r7 = r7.a(r6)
                if (r7 != 0) goto L_0x00c5
                r5.q1(r10, r6)
                return r1
            L_0x00c5:
                r6 = r7
                goto L_0x0104
            L_0x00c7:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.f7163d
                boolean r9 = r9.M()
                if (r9 != 0) goto L_0x00e0
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r9 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r8.f7163d
                java.lang.Object r9 = r9.u(r10)
                androidx.datastore.preferences.protobuf.MessageLite r9 = (androidx.datastore.preferences.protobuf.MessageLite) r9
                if (r9 == 0) goto L_0x00e0
                androidx.datastore.preferences.protobuf.MessageLite$Builder r9 = r9.E()
                goto L_0x00e1
            L_0x00e0:
                r9 = 0
            L_0x00e1:
                if (r9 != 0) goto L_0x00eb
                androidx.datastore.preferences.protobuf.MessageLite r9 = r8.c()
                androidx.datastore.preferences.protobuf.MessageLite$Builder r9 = r9.b2()
            L_0x00eb:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r10 = r8.f7163d
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = r10.V()
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP
                if (r10 != r0) goto L_0x00fd
                int r10 = r8.d()
                r6.E(r10, r9, r7)
                goto L_0x0100
            L_0x00fd:
                r6.I(r9, r7)
            L_0x0100:
                androidx.datastore.preferences.protobuf.MessageLite r6 = r9.build()
            L_0x0104:
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r8.f7163d
                boolean r7 = r7.M()
                if (r7 == 0) goto L_0x0118
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r7 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.f7163d
                java.lang.Object r6 = r8.j(r6)
                r7.h(r9, r6)
                goto L_0x0123
            L_0x0118:
                androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r7 = r5.extensions
                androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r8.f7163d
                java.lang.Object r6 = r8.j(r6)
                r7.O(r9, r6)
            L_0x0123:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage.V2(androidx.datastore.preferences.protobuf.CodedInputStream, androidx.datastore.preferences.protobuf.ExtensionRegistryLite, androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension, int, int):boolean");
        }

        private void Y2(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.h() != D()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public /* bridge */ /* synthetic */ MessageLite D() {
            return GeneratedMessageLite.super.D();
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder E() {
            return GeneratedMessageLite.super.E();
        }

        public final <Type> boolean J(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension T = GeneratedMessageLite.d0(extensionLite);
            Y2(T);
            return this.extensions.B(T.f7163d);
        }

        /* access modifiers changed from: package-private */
        public FieldSet<ExtensionDescriptor> M2() {
            if (this.extensions.D()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        /* access modifiers changed from: protected */
        public boolean N2() {
            return this.extensions.E();
        }

        /* access modifiers changed from: protected */
        public int O2() {
            return this.extensions.z();
        }

        /* access modifiers changed from: protected */
        public int P2() {
            return this.extensions.v();
        }

        /* access modifiers changed from: protected */
        public final void Q2(MessageType messagetype) {
            if (this.extensions.D()) {
                this.extensions = this.extensions.clone();
            }
            this.extensions.J(messagetype.extensions);
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter T2() {
            return new ExtensionWriter(this, false, (AnonymousClass1) null);
        }

        public final <Type> Type U1(ExtensionLite<MessageType, List<Type>> extensionLite, int i2) {
            GeneratedExtension T = GeneratedMessageLite.d0(extensionLite);
            Y2(T);
            return T.i(this.extensions.x(T.f7163d, i2));
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType, BuilderType>.ExtensionWriter U2() {
            return new ExtensionWriter(this, true, (AnonymousClass1) null);
        }

        /* access modifiers changed from: protected */
        public <MessageType extends MessageLite> boolean W2(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i2) throws IOException {
            int a2 = WireFormat.a(i2);
            return V2(codedInputStream, extensionRegistryLite, extensionRegistryLite.c(messagetype, a2), i2, a2);
        }

        /* access modifiers changed from: protected */
        public <MessageType extends MessageLite> boolean X2(MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i2) throws IOException {
            if (i2 != WireFormat.q) {
                return WireFormat.b(i2) == 2 ? W2(messagetype, codedInputStream, extensionRegistryLite, i2) : codedInputStream.g0(i2);
            }
            S2(messagetype, codedInputStream, extensionRegistryLite);
            return true;
        }

        public /* bridge */ /* synthetic */ MessageLite.Builder b2() {
            return GeneratedMessageLite.super.b2();
        }

        public final <Type> Type c0(ExtensionLite<MessageType, Type> extensionLite) {
            GeneratedExtension T = GeneratedMessageLite.d0(extensionLite);
            Y2(T);
            Object u = this.extensions.u(T.f7163d);
            return u == null ? T.f7161b : T.g(u);
        }

        public final <Type> int g0(ExtensionLite<MessageType, List<Type>> extensionLite) {
            GeneratedExtension T = GeneratedMessageLite.d0(extensionLite);
            Y2(T);
            return this.extensions.y(T.f7163d);
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> boolean J(ExtensionLite<MessageType, Type> extensionLite);

        <Type> Type U1(ExtensionLite<MessageType, List<Type>> extensionLite, int i2);

        <Type> Type c0(ExtensionLite<MessageType, Type> extensionLite);

        <Type> int g0(ExtensionLite<MessageType, List<Type>> extensionLite);
    }

    static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final int X;
        final boolean X2;
        final WireFormat.FieldType Y;
        final boolean Z;
        final Internal.EnumLiteMap<?> s;

        ExtensionDescriptor(Internal.EnumLiteMap<?> enumLiteMap, int i2, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.s = enumLiteMap;
            this.X = i2;
            this.Y = fieldType;
            this.Z = z;
            this.X2 = z2;
        }

        public boolean M() {
            return this.Z;
        }

        public WireFormat.JavaType U1() {
            return this.Y.a();
        }

        public WireFormat.FieldType V() {
            return this.Y;
        }

        /* renamed from: a */
        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.X - extensionDescriptor.X;
        }

        public boolean a2() {
            return this.X2;
        }

        public Internal.EnumLiteMap<?> b1() {
            return this.s;
        }

        public int d() {
            return this.X;
        }

        public MessageLite.Builder d2(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).k3((GeneratedMessageLite) messageLite);
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        final ContainingType f7160a;

        /* renamed from: b  reason: collision with root package name */
        final Type f7161b;

        /* renamed from: c  reason: collision with root package name */
        final MessageLite f7162c;

        /* renamed from: d  reason: collision with root package name */
        final ExtensionDescriptor f7163d;

        GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (extensionDescriptor.V() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.f7160a = containingtype;
                this.f7161b = type;
                this.f7162c = messageLite;
                this.f7163d = extensionDescriptor;
            }
        }

        public Type a() {
            return this.f7161b;
        }

        public WireFormat.FieldType b() {
            return this.f7163d.V();
        }

        public MessageLite c() {
            return this.f7162c;
        }

        public int d() {
            return this.f7163d.d();
        }

        public boolean f() {
            return this.f7163d.Z;
        }

        /* access modifiers changed from: package-private */
        public Object g(Object obj) {
            if (!this.f7163d.M()) {
                return i(obj);
            }
            if (this.f7163d.U1() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object i2 : (List) obj) {
                arrayList.add(i(i2));
            }
            return arrayList;
        }

        public ContainingType h() {
            return this.f7160a;
        }

        /* access modifiers changed from: package-private */
        public Object i(Object obj) {
            return this.f7163d.U1() == WireFormat.JavaType.ENUM ? this.f7163d.s.a(((Integer) obj).intValue()) : obj;
        }

        /* access modifiers changed from: package-private */
        public Object j(Object obj) {
            return this.f7163d.U1() == WireFormat.JavaType.ENUM ? Integer.valueOf(((Internal.EnumLite) obj).d()) : obj;
        }

        /* access modifiers changed from: package-private */
        public Object k(Object obj) {
            if (!this.f7163d.M()) {
                return j(obj);
            }
            if (this.f7163d.U1() != WireFormat.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object j2 : (List) obj) {
                arrayList.add(j(j2));
            }
            return arrayList;
        }
    }

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    protected static final class SerializedForm implements Serializable {
        private static final long Z = 0;
        private final String X;
        private final byte[] Y;
        private final Class<?> s;

        SerializedForm(MessageLite messageLite) {
            Class<?> cls = messageLite.getClass();
            this.s = cls;
            this.X = cls.getName();
            this.Y = messageLite.t();
        }

        public static SerializedForm a(MessageLite messageLite) {
            return new SerializedForm(messageLite);
        }

        @Deprecated
        private Object c() throws ObjectStreamException {
            try {
                Field declaredField = d().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get((Object) null)).b2().m0(this.Y).M1();
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.X, e2);
            } catch (NoSuchFieldException e3) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.X, e3);
            } catch (SecurityException e4) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.X, e4);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException("Unable to call parsePartialFrom", e5);
            } catch (InvalidProtocolBufferException e6) {
                throw new RuntimeException("Unable to understand proto buffer", e6);
            }
        }

        private Class<?> d() throws ClassNotFoundException {
            Class<?> cls = this.s;
            return cls != null ? cls : Class.forName(this.X);
        }

        /* access modifiers changed from: protected */
        public Object b() throws ObjectStreamException {
            try {
                Field declaredField = d().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get((Object) null)).b2().m0(this.Y).M1();
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.X, e2);
            } catch (NoSuchFieldException unused) {
                return c();
            } catch (SecurityException e3) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.X, e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Unable to call parsePartialFrom", e4);
            } catch (InvalidProtocolBufferException e5) {
                throw new RuntimeException("Unable to understand proto buffer", e5);
            }
        }
    }

    protected static Internal.IntList B1(Internal.IntList intList) {
        int size = intList.size();
        return intList.f(size == 0 ? 10 : size * 2);
    }

    static <T extends GeneratedMessageLite<T, ?>> T D2(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (GeneratedMessageLite) t.x0(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            Schema j2 = Protobuf.a().j(t2);
            j2.b(t2, CodedInputStreamReader.T(codedInputStream), extensionRegistryLite);
            j2.c(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw new InvalidProtocolBufferException(e2.getMessage()).j(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e3.getCause());
            }
            throw e3;
        }
    }

    protected static Internal.LongList E1(Internal.LongList longList) {
        int size = longList.size();
        return longList.f(size == 0 ? 10 : size * 2);
    }

    protected static <E> Internal.ProtobufList<E> G1(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.f(size == 0 ? 10 : size * 2);
    }

    static <T extends GeneratedMessageLite<T, ?>> T G2(T t, byte[] bArr, int i2, int i3, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (GeneratedMessageLite) t.x0(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            Schema j2 = Protobuf.a().j(t2);
            j2.i(t2, bArr, i2, i2 + i3, new ArrayDecoders.Registers(extensionRegistryLite));
            j2.c(t2);
            if (t2.memoizedHashCode == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw new InvalidProtocolBufferException(e2.getMessage()).j(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.l().j(t2);
        }
    }

    private static <T extends GeneratedMessageLite<T, ?>> T H2(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return e0(G2(t, bArr, 0, bArr.length, extensionRegistryLite));
    }

    protected static Internal.BooleanList I0() {
        return BooleanArrayList.h();
    }

    protected static Internal.DoubleList J0() {
        return DoubleArrayList.h();
    }

    protected static Object J1(MessageLite messageLite, String str, Object[] objArr) {
        return new RawMessageInfo(messageLite, str, objArr);
    }

    protected static <T extends GeneratedMessageLite<?, ?>> void J2(Class<T> cls, T t) {
        defaultInstanceMap.put(cls, t);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> K1(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i2, WireFormat.FieldType fieldType, boolean z, Class cls) {
        return new GeneratedExtension(containingtype, Collections.emptyList(), messageLite, new ExtensionDescriptor(enumLiteMap, i2, fieldType, true, z), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> L1(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i2, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension(containingtype, type, messageLite, new ExtensionDescriptor(enumLiteMap, i2, fieldType, false, false), cls);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T N1(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return e0(v2(t, inputStream, ExtensionRegistryLite.d()));
    }

    protected static Internal.FloatList P0() {
        return FloatArrayList.h();
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T P1(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return e0(v2(t, inputStream, extensionRegistryLite));
    }

    protected static Internal.IntList Q0() {
        return IntArrayList.h();
    }

    protected static Internal.LongList T0() {
        return LongArrayList.h();
    }

    protected static <E> Internal.ProtobufList<E> U0() {
        return ProtobufArrayList.d();
    }

    private final void V0() {
        if (this.unknownFields == UnknownFieldSetLite.e()) {
            this.unknownFields = UnknownFieldSetLite.p();
        }
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T V1(T t, ByteString byteString) throws InvalidProtocolBufferException {
        return e0(W1(t, byteString, ExtensionRegistryLite.d()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T W1(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return e0(y2(t, byteString, extensionRegistryLite));
    }

    static <T extends GeneratedMessageLite<?, ?>> T X0(Class<T> cls) {
        T t = (GeneratedMessageLite) defaultInstanceMap.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (GeneratedMessageLite) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = ((GeneratedMessageLite) UnsafeUtil.j(cls)).D();
            if (t != null) {
                defaultInstanceMap.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T X1(T t, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return Y1(t, codedInputStream, ExtensionRegistryLite.d());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T Y1(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return e0(D2(t, codedInputStream, extensionRegistryLite));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T Z1(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return e0(D2(t, CodedInputStream.j(inputStream), ExtensionRegistryLite.d()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T c2(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return e0(D2(t, CodedInputStream.j(inputStream), extensionRegistryLite));
    }

    /* access modifiers changed from: private */
    public static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> d0(ExtensionLite<MessageType, T> extensionLite) {
        if (extensionLite.e()) {
            return (GeneratedExtension) extensionLite;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite<T, ?>> T e0(T t) throws InvalidProtocolBufferException {
        if (t == null || t.m()) {
            return t;
        }
        throw t.O().a().j(t);
    }

    static Method f1(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e2);
        }
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T h2(T t, ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return l2(t, byteBuffer, ExtensionRegistryLite.d());
    }

    static Object i1(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T l2(T t, ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return e0(Y1(t, CodedInputStream.n(byteBuffer), extensionRegistryLite));
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean m1(T t, boolean z) {
        byte byteValue = ((Byte) t.x0(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d2 = Protobuf.a().j(t).d(t);
        if (z) {
            t.A0(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, d2 ? t : null);
        }
        return d2;
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T o2(T t, byte[] bArr) throws InvalidProtocolBufferException {
        return e0(G2(t, bArr, 0, bArr.length, ExtensionRegistryLite.d()));
    }

    protected static Internal.BooleanList s1(Internal.BooleanList booleanList) {
        int size = booleanList.size();
        return booleanList.f(size == 0 ? 10 : size * 2);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T s2(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return e0(G2(t, bArr, 0, bArr.length, extensionRegistryLite));
    }

    protected static Internal.DoubleList v1(Internal.DoubleList doubleList) {
        int size = doubleList.size();
        return doubleList.f(size == 0 ? 10 : size * 2);
    }

    private static <T extends GeneratedMessageLite<T, ?>> T v2(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            CodedInputStream j2 = CodedInputStream.j(new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.O(read, inputStream)));
            T D2 = D2(t, j2, extensionRegistryLite);
            try {
                j2.a(0);
                return D2;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.j(D2);
            }
        } catch (IOException e3) {
            throw new InvalidProtocolBufferException(e3.getMessage());
        }
    }

    protected static Internal.FloatList x1(Internal.FloatList floatList) {
        int size = floatList.size();
        return floatList.f(size == 0 ? 10 : size * 2);
    }

    private static <T extends GeneratedMessageLite<T, ?>> T y2(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream R = byteString.R();
        T D2 = D2(t, R, extensionRegistryLite);
        try {
            R.a(0);
            return D2;
        } catch (InvalidProtocolBufferException e2) {
            throw e2.j(D2);
        }
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T z2(T t, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return D2(t, codedInputStream, ExtensionRegistryLite.d());
    }

    /* access modifiers changed from: protected */
    public Object A0(MethodToInvoke methodToInvoke, Object obj) {
        return B0(methodToInvoke, obj, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object B0(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    public int H() {
        return this.memoizedSerializedSize;
    }

    /* renamed from: I1 */
    public final BuilderType b2() {
        return (Builder) x0(MethodToInvoke.NEW_BUILDER);
    }

    /* access modifiers changed from: protected */
    public boolean I2(int i2, CodedInputStream codedInputStream) throws IOException {
        if (WireFormat.b(i2) == 4) {
            return false;
        }
        V0();
        return this.unknownFields.k(i2, codedInputStream);
    }

    /* renamed from: K2 */
    public final BuilderType E() {
        BuilderType buildertype = (Builder) x0(MethodToInvoke.NEW_BUILDER);
        buildertype.k3(this);
        return buildertype;
    }

    /* access modifiers changed from: package-private */
    public void R(int i2) {
        this.memoizedSerializedSize = i2;
    }

    public int R0() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = Protobuf.a().j(this).g(this);
        }
        return this.memoizedSerializedSize;
    }

    /* access modifiers changed from: package-private */
    public Object W() throws Exception {
        return x0(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    /* renamed from: a1 */
    public final MessageType D() {
        return (GeneratedMessageLite) x0(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!D().getClass().isInstance(obj)) {
            return false;
        }
        return Protobuf.a().j(this).f(this, (GeneratedMessageLite) obj);
    }

    public int hashCode() {
        int i2 = this.memoizedHashCode;
        if (i2 != 0) {
            return i2;
        }
        int j2 = Protobuf.a().j(this).j(this);
        this.memoizedHashCode = j2;
        return j2;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType i0() {
        return (Builder) x0(MethodToInvoke.NEW_BUILDER);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType j0(MessageType messagetype) {
        return i0().k3(messagetype);
    }

    public void j1(CodedOutputStream codedOutputStream) throws IOException {
        Protobuf.a().j(this).e(this, CodedOutputStreamWriter.T(codedOutputStream));
    }

    public final boolean m() {
        return m1(this, true);
    }

    /* access modifiers changed from: protected */
    public void n1() {
        Protobuf.a().j(this).c(this);
    }

    /* access modifiers changed from: protected */
    public void o1(int i2, ByteString byteString) {
        V0();
        this.unknownFields.m(i2, byteString);
    }

    /* access modifiers changed from: protected */
    public final void p1(UnknownFieldSetLite unknownFieldSetLite) {
        this.unknownFields = UnknownFieldSetLite.o(this.unknownFields, unknownFieldSetLite);
    }

    /* access modifiers changed from: protected */
    public void q1(int i2, int i3) {
        V0();
        this.unknownFields.n(i2, i3);
    }

    public final Parser<MessageType> q2() {
        return (Parser) x0(MethodToInvoke.GET_PARSER);
    }

    public String toString() {
        return MessageLiteToString.e(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public Object x0(MethodToInvoke methodToInvoke) {
        return B0(methodToInvoke, (Object) null, (Object) null);
    }
}
