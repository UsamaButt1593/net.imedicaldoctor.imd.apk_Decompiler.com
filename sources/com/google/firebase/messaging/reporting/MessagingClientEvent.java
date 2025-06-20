package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.proto.ProtoEnum;
import com.google.firebase.encoders.proto.Protobuf;

public final class MessagingClientEvent {
    private static final MessagingClientEvent p = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f24921a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24922b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24923c;

    /* renamed from: d  reason: collision with root package name */
    private final MessageType f24924d;

    /* renamed from: e  reason: collision with root package name */
    private final SDKPlatform f24925e;

    /* renamed from: f  reason: collision with root package name */
    private final String f24926f;

    /* renamed from: g  reason: collision with root package name */
    private final String f24927g;

    /* renamed from: h  reason: collision with root package name */
    private final int f24928h;

    /* renamed from: i  reason: collision with root package name */
    private final int f24929i;

    /* renamed from: j  reason: collision with root package name */
    private final String f24930j;

    /* renamed from: k  reason: collision with root package name */
    private final long f24931k;

    /* renamed from: l  reason: collision with root package name */
    private final Event f24932l;

    /* renamed from: m  reason: collision with root package name */
    private final String f24933m;

    /* renamed from: n  reason: collision with root package name */
    private final long f24934n;
    private final String o;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f24935a = 0;

        /* renamed from: b  reason: collision with root package name */
        private String f24936b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f24937c = "";

        /* renamed from: d  reason: collision with root package name */
        private MessageType f24938d = MessageType.UNKNOWN;

        /* renamed from: e  reason: collision with root package name */
        private SDKPlatform f24939e = SDKPlatform.UNKNOWN_OS;

        /* renamed from: f  reason: collision with root package name */
        private String f24940f = "";

        /* renamed from: g  reason: collision with root package name */
        private String f24941g = "";

        /* renamed from: h  reason: collision with root package name */
        private int f24942h = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f24943i = 0;

        /* renamed from: j  reason: collision with root package name */
        private String f24944j = "";

        /* renamed from: k  reason: collision with root package name */
        private long f24945k = 0;

        /* renamed from: l  reason: collision with root package name */
        private Event f24946l = Event.UNKNOWN_EVENT;

        /* renamed from: m  reason: collision with root package name */
        private String f24947m = "";

        /* renamed from: n  reason: collision with root package name */
        private long f24948n = 0;
        private String o = "";

        Builder() {
        }

        public MessagingClientEvent a() {
            return new MessagingClientEvent(this.f24935a, this.f24936b, this.f24937c, this.f24938d, this.f24939e, this.f24940f, this.f24941g, this.f24942h, this.f24943i, this.f24944j, this.f24945k, this.f24946l, this.f24947m, this.f24948n, this.o);
        }

        public Builder b(String str) {
            this.f24947m = str;
            return this;
        }

        public Builder c(long j2) {
            this.f24945k = j2;
            return this;
        }

        public Builder d(long j2) {
            this.f24948n = j2;
            return this;
        }

        public Builder e(String str) {
            this.f24941g = str;
            return this;
        }

        public Builder f(String str) {
            this.o = str;
            return this;
        }

        public Builder g(Event event) {
            this.f24946l = event;
            return this;
        }

        public Builder h(String str) {
            this.f24937c = str;
            return this;
        }

        public Builder i(String str) {
            this.f24936b = str;
            return this;
        }

        public Builder j(MessageType messageType) {
            this.f24938d = messageType;
            return this;
        }

        public Builder k(String str) {
            this.f24940f = str;
            return this;
        }

        public Builder l(int i2) {
            this.f24942h = i2;
            return this;
        }

        public Builder m(long j2) {
            this.f24935a = j2;
            return this;
        }

        public Builder n(SDKPlatform sDKPlatform) {
            this.f24939e = sDKPlatform;
            return this;
        }

        public Builder o(String str) {
            this.f24944j = str;
            return this;
        }

        public Builder p(int i2) {
            this.f24943i = i2;
            return this;
        }
    }

    public enum Event implements ProtoEnum {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);
        
        private final int s;

        private Event(int i2) {
            this.s = i2;
        }

        public int d() {
            return this.s;
        }
    }

    public enum MessageType implements ProtoEnum {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);
        
        private final int s;

        private MessageType(int i2) {
            this.s = i2;
        }

        public int d() {
            return this.s;
        }
    }

    public enum SDKPlatform implements ProtoEnum {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);
        
        private final int s;

        private SDKPlatform(int i2) {
            this.s = i2;
        }

        public int d() {
            return this.s;
        }
    }

    MessagingClientEvent(long j2, String str, String str2, MessageType messageType, SDKPlatform sDKPlatform, String str3, String str4, int i2, int i3, String str5, long j3, Event event, String str6, long j4, String str7) {
        this.f24921a = j2;
        this.f24922b = str;
        this.f24923c = str2;
        this.f24924d = messageType;
        this.f24925e = sDKPlatform;
        this.f24926f = str3;
        this.f24927g = str4;
        this.f24928h = i2;
        this.f24929i = i3;
        this.f24930j = str5;
        this.f24931k = j3;
        this.f24932l = event;
        this.f24933m = str6;
        this.f24934n = j4;
        this.o = str7;
    }

    public static MessagingClientEvent f() {
        return p;
    }

    public static Builder q() {
        return new Builder();
    }

    @Protobuf(tag = 13)
    public String a() {
        return this.f24933m;
    }

    @Protobuf(tag = 11)
    public long b() {
        return this.f24931k;
    }

    @Protobuf(tag = 14)
    public long c() {
        return this.f24934n;
    }

    @Protobuf(tag = 7)
    public String d() {
        return this.f24927g;
    }

    @Protobuf(tag = 15)
    public String e() {
        return this.o;
    }

    @Protobuf(tag = 12)
    public Event g() {
        return this.f24932l;
    }

    @Protobuf(tag = 3)
    public String h() {
        return this.f24923c;
    }

    @Protobuf(tag = 2)
    public String i() {
        return this.f24922b;
    }

    @Protobuf(tag = 4)
    public MessageType j() {
        return this.f24924d;
    }

    @Protobuf(tag = 6)
    public String k() {
        return this.f24926f;
    }

    @Protobuf(tag = 8)
    public int l() {
        return this.f24928h;
    }

    @Protobuf(tag = 1)
    public long m() {
        return this.f24921a;
    }

    @Protobuf(tag = 5)
    public SDKPlatform n() {
        return this.f24925e;
    }

    @Protobuf(tag = 10)
    public String o() {
        return this.f24930j;
    }

    @Protobuf(tag = 9)
    public int p() {
        return this.f24929i;
    }
}
