package com.google.firebase.encoders.proto;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.firebase.encoders.proto.Protobuf;
import java.lang.annotation.Annotation;

public final class AtProtobuf {

    /* renamed from: a  reason: collision with root package name */
    private int f24353a;

    /* renamed from: b  reason: collision with root package name */
    private Protobuf.IntEncoding f24354b = Protobuf.IntEncoding.DEFAULT;

    private static final class ProtobufImpl implements Protobuf {
        private final int Y;
        private final Protobuf.IntEncoding Z;

        ProtobufImpl(int i2, Protobuf.IntEncoding intEncoding) {
            this.Y = i2;
            this.Z = intEncoding;
        }

        public Class<? extends Annotation> annotationType() {
            return Protobuf.class;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            return this.Y == protobuf.tag() && this.Z.equals(protobuf.intEncoding());
        }

        public int hashCode() {
            return (14552422 ^ this.Y) + (this.Z.hashCode() ^ 2041407134);
        }

        public Protobuf.IntEncoding intEncoding() {
            return this.Z;
        }

        public int tag() {
            return this.Y;
        }

        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf" + ASCIIPropertyListParser.f18649g + "tag=" + this.Y + "intEncoding=" + this.Z + ASCIIPropertyListParser.f18650h;
        }
    }

    public static AtProtobuf b() {
        return new AtProtobuf();
    }

    public Protobuf a() {
        return new ProtobufImpl(this.f24353a, this.f24354b);
    }

    public AtProtobuf c(Protobuf.IntEncoding intEncoding) {
        this.f24354b = intEncoding;
        return this;
    }

    public AtProtobuf d(int i2) {
        this.f24353a = i2;
        return this;
    }
}
