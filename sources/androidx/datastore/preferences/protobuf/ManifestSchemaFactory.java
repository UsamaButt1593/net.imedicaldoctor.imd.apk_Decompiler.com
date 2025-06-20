package androidx.datastore.preferences.protobuf;

final class ManifestSchemaFactory implements SchemaFactory {

    /* renamed from: b  reason: collision with root package name */
    private static final MessageInfoFactory f7184b = new MessageInfoFactory() {
        public MessageInfo a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        public boolean b(Class<?> cls) {
            return false;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final MessageInfoFactory f7185a;

    private static class CompositeMessageInfoFactory implements MessageInfoFactory {

        /* renamed from: a  reason: collision with root package name */
        private MessageInfoFactory[] f7186a;

        CompositeMessageInfoFactory(MessageInfoFactory... messageInfoFactoryArr) {
            this.f7186a = messageInfoFactoryArr;
        }

        public MessageInfo a(Class<?> cls) {
            for (MessageInfoFactory messageInfoFactory : this.f7186a) {
                if (messageInfoFactory.b(cls)) {
                    return messageInfoFactory.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        public boolean b(Class<?> cls) {
            for (MessageInfoFactory b2 : this.f7186a) {
                if (b2.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public ManifestSchemaFactory() {
        this(b());
    }

    private static MessageInfoFactory b() {
        return new CompositeMessageInfoFactory(GeneratedMessageInfoFactory.c(), c());
    }

    private static MessageInfoFactory c() {
        try {
            return (MessageInfoFactory) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            return f7184b;
        }
    }

    private static boolean d(MessageInfo messageInfo) {
        return messageInfo.f() == ProtoSyntax.PROTO2;
    }

    private static <T> Schema<T> e(Class<T> cls, MessageInfo messageInfo) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            if (d(messageInfo)) {
                return MessageSchema.S(cls, messageInfo, NewInstanceSchemas.b(), ListFieldSchema.b(), SchemaUtil.S(), ExtensionSchemas.b(), MapFieldSchemas.b());
            }
            return MessageSchema.S(cls, messageInfo, NewInstanceSchemas.b(), ListFieldSchema.b(), SchemaUtil.S(), (ExtensionSchema<?>) null, MapFieldSchemas.b());
        } else if (d(messageInfo)) {
            return MessageSchema.S(cls, messageInfo, NewInstanceSchemas.a(), ListFieldSchema.a(), SchemaUtil.K(), ExtensionSchemas.a(), MapFieldSchemas.a());
        } else {
            return MessageSchema.S(cls, messageInfo, NewInstanceSchemas.a(), ListFieldSchema.a(), SchemaUtil.L(), (ExtensionSchema<?>) null, MapFieldSchemas.a());
        }
    }

    public <T> Schema<T> a(Class<T> cls) {
        UnknownFieldSchema<?, ?> K;
        ExtensionSchema<?> a2;
        SchemaUtil.M(cls);
        MessageInfo a3 = this.f7185a.a(cls);
        if (!a3.a()) {
            return e(cls, a3);
        }
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            K = SchemaUtil.S();
            a2 = ExtensionSchemas.b();
        } else {
            K = SchemaUtil.K();
            a2 = ExtensionSchemas.a();
        }
        return MessageSetSchema.m(K, a2, a3.b());
    }

    private ManifestSchemaFactory(MessageInfoFactory messageInfoFactory) {
        this.f7185a = (MessageInfoFactory) Internal.e(messageInfoFactory, "messageInfoFactory");
    }
}
