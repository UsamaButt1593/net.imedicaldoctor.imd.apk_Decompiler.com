package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.LazyField;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class MessageSetSchema<T> implements Schema<T> {

    /* renamed from: a  reason: collision with root package name */
    private final MessageLite f7218a;

    /* renamed from: b  reason: collision with root package name */
    private final UnknownFieldSchema<?, ?> f7219b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7220c;

    /* renamed from: d  reason: collision with root package name */
    private final ExtensionSchema<?> f7221d;

    private MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite messageLite) {
        this.f7219b = unknownFieldSchema;
        this.f7220c = extensionSchema.e(messageLite);
        this.f7221d = extensionSchema;
        this.f7218a = messageLite;
    }

    private <UT, UB> int k(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t) {
        return unknownFieldSchema.i(unknownFieldSchema.g(t));
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void l(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        UB f2 = unknownFieldSchema.f(t);
        FieldSet<ET> d2 = extensionSchema.d(t);
        do {
            try {
                if (reader.C() == Integer.MAX_VALUE) {
                    unknownFieldSchema.o(t, f2);
                    return;
                }
            } finally {
                unknownFieldSchema.o(t, f2);
            }
        } while (n(reader, extensionRegistryLite, extensionSchema, d2, unknownFieldSchema, f2));
    }

    static <T> MessageSetSchema<T> m(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite messageLite) {
        return new MessageSetSchema<>(unknownFieldSchema, extensionSchema, messageLite);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean n(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema<ET> extensionSchema, FieldSet<ET> fieldSet, UnknownFieldSchema<UT, UB> unknownFieldSchema, UB ub) throws IOException {
        int n2 = reader.n();
        if (n2 == WireFormat.q) {
            Object obj = null;
            ByteString byteString = null;
            int i2 = 0;
            while (reader.C() != Integer.MAX_VALUE) {
                int n3 = reader.n();
                if (n3 == WireFormat.s) {
                    i2 = reader.q();
                    obj = extensionSchema.b(extensionRegistryLite, this.f7218a, i2);
                } else if (n3 == WireFormat.t) {
                    if (obj != null) {
                        extensionSchema.h(reader, obj, extensionRegistryLite, fieldSet);
                    } else {
                        byteString = reader.F();
                    }
                } else if (!reader.K()) {
                    break;
                }
            }
            if (reader.n() == WireFormat.r) {
                if (byteString != null) {
                    if (obj != null) {
                        extensionSchema.i(byteString, obj, extensionRegistryLite, fieldSet);
                    } else {
                        unknownFieldSchema.d(ub, i2, byteString);
                    }
                }
                return true;
            }
            throw InvalidProtocolBufferException.b();
        } else if (WireFormat.b(n2) != 2) {
            return reader.K();
        } else {
            Object b2 = extensionSchema.b(extensionRegistryLite, this.f7218a, WireFormat.a(n2));
            if (b2 == null) {
                return unknownFieldSchema.m(ub, reader);
            }
            extensionSchema.h(reader, b2, extensionRegistryLite, fieldSet);
            return true;
        }
    }

    private <UT, UB> void o(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, Writer writer) throws IOException {
        unknownFieldSchema.s(unknownFieldSchema.g(t), writer);
    }

    public void a(T t, T t2) {
        SchemaUtil.J(this.f7219b, t, t2);
        if (this.f7220c) {
            SchemaUtil.H(this.f7221d, t, t2);
        }
    }

    public void b(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        l(this.f7219b, this.f7221d, t, reader, extensionRegistryLite);
    }

    public void c(T t) {
        this.f7219b.j(t);
        this.f7221d.f(t);
    }

    public final boolean d(T t) {
        return this.f7221d.c(t).E();
    }

    public void e(T t, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> H = this.f7221d.c(t).H();
        while (H.hasNext()) {
            Map.Entry next = H.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) next.getKey();
            if (fieldDescriptorLite.U1() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.M() || fieldDescriptorLite.a2()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            writer.c(fieldDescriptorLite.d(), next instanceof LazyField.LazyEntry ? ((LazyField.LazyEntry) next).a().n() : next.getValue());
        }
        o(this.f7219b, t, writer);
    }

    public boolean f(T t, T t2) {
        if (!this.f7219b.g(t).equals(this.f7219b.g(t2))) {
            return false;
        }
        if (this.f7220c) {
            return this.f7221d.c(t).equals(this.f7221d.c(t2));
        }
        return true;
    }

    public int g(T t) {
        int k2 = k(this.f7219b, t);
        return this.f7220c ? k2 + this.f7221d.c(t).v() : k2;
    }

    public T h() {
        return this.f7218a.b2().M1();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(T r11, byte[] r12, int r13, int r14, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            androidx.datastore.preferences.protobuf.GeneratedMessageLite r0 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite) r0
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r1 = r0.unknownFields
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r2 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.e()
            if (r1 != r2) goto L_0x0011
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r1 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.p()
            r0.unknownFields = r1
        L_0x0011:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage r11 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage) r11
            androidx.datastore.preferences.protobuf.FieldSet r11 = r11.M2()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r13 >= r14) goto L_0x00d7
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r13, r15)
            int r13 = r15.f6976a
            int r3 = androidx.datastore.preferences.protobuf.WireFormat.q
            r5 = 2
            if (r13 == r3) goto L_0x006b
            int r3 = androidx.datastore.preferences.protobuf.WireFormat.b(r13)
            if (r3 != r5) goto L_0x0066
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r2 = r10.f7221d
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r3 = r15.f6979d
            androidx.datastore.preferences.protobuf.MessageLite r5 = r10.f7218a
            int r6 = androidx.datastore.preferences.protobuf.WireFormat.a(r13)
            java.lang.Object r2 = r2.b(r3, r5, r6)
            r8 = r2
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension r8 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension) r8
            if (r8 == 0) goto L_0x005c
            androidx.datastore.preferences.protobuf.Protobuf r13 = androidx.datastore.preferences.protobuf.Protobuf.a()
            androidx.datastore.preferences.protobuf.MessageLite r2 = r8.c()
            java.lang.Class r2 = r2.getClass()
            androidx.datastore.preferences.protobuf.Schema r13 = r13.i(r2)
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r13, r12, r4, r14, r15)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r2 = r8.f7163d
            java.lang.Object r3 = r15.f6978c
            r11.O(r2, r3)
        L_0x005a:
            r2 = r8
            goto L_0x0019
        L_0x005c:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.G(r2, r3, r4, r5, r6, r7)
            goto L_0x005a
        L_0x0066:
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.N(r13, r12, r4, r14, r15)
            goto L_0x0019
        L_0x006b:
            r13 = 0
            r3 = r0
        L_0x006d:
            if (r4 >= r14) goto L_0x00cb
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r4, r15)
            int r6 = r15.f6976a
            int r7 = androidx.datastore.preferences.protobuf.WireFormat.a(r6)
            int r8 = androidx.datastore.preferences.protobuf.WireFormat.b(r6)
            if (r7 == r5) goto L_0x00ac
            r9 = 3
            if (r7 == r9) goto L_0x0083
            goto L_0x00c1
        L_0x0083:
            if (r2 == 0) goto L_0x00a1
            androidx.datastore.preferences.protobuf.Protobuf r6 = androidx.datastore.preferences.protobuf.Protobuf.a()
            androidx.datastore.preferences.protobuf.MessageLite r7 = r2.c()
            java.lang.Class r7 = r7.getClass()
            androidx.datastore.preferences.protobuf.Schema r6 = r6.i(r7)
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r6, r12, r4, r14, r15)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r6 = r2.f7163d
            java.lang.Object r7 = r15.f6978c
            r11.O(r6, r7)
            goto L_0x006d
        L_0x00a1:
            if (r8 != r5) goto L_0x00c1
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.b(r12, r4, r15)
            java.lang.Object r3 = r15.f6978c
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            goto L_0x006d
        L_0x00ac:
            if (r8 != 0) goto L_0x00c1
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r4, r15)
            int r13 = r15.f6976a
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r2 = r10.f7221d
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r6 = r15.f6979d
            androidx.datastore.preferences.protobuf.MessageLite r7 = r10.f7218a
            java.lang.Object r2 = r2.b(r6, r7, r13)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension r2 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension) r2
            goto L_0x006d
        L_0x00c1:
            int r7 = androidx.datastore.preferences.protobuf.WireFormat.r
            if (r6 != r7) goto L_0x00c6
            goto L_0x00cb
        L_0x00c6:
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.N(r6, r12, r4, r14, r15)
            goto L_0x006d
        L_0x00cb:
            if (r3 == 0) goto L_0x00d4
            int r13 = androidx.datastore.preferences.protobuf.WireFormat.c(r13, r5)
            r1.r(r13, r3)
        L_0x00d4:
            r13 = r4
            goto L_0x0019
        L_0x00d7:
            if (r13 != r14) goto L_0x00da
            return
        L_0x00da:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r11 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.h()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSetSchema.i(java.lang.Object, byte[], int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):void");
    }

    public int j(T t) {
        int hashCode = this.f7219b.g(t).hashCode();
        return this.f7220c ? (hashCode * 53) + this.f7221d.c(t).hashCode() : hashCode;
    }
}
