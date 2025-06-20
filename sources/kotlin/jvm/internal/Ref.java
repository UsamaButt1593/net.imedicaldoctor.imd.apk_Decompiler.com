package kotlin.jvm.internal;

import java.io.Serializable;

public class Ref {

    public static final class BooleanRef implements Serializable {
        public boolean s;

        public String toString() {
            return String.valueOf(this.s);
        }
    }

    public static final class ByteRef implements Serializable {
        public byte s;

        public String toString() {
            return String.valueOf(this.s);
        }
    }

    public static final class CharRef implements Serializable {
        public char s;

        public String toString() {
            return String.valueOf(this.s);
        }
    }

    public static final class DoubleRef implements Serializable {
        public double s;

        public String toString() {
            return String.valueOf(this.s);
        }
    }

    public static final class FloatRef implements Serializable {
        public float s;

        public String toString() {
            return String.valueOf(this.s);
        }
    }

    public static final class IntRef implements Serializable {
        public int s;

        public String toString() {
            return String.valueOf(this.s);
        }
    }

    public static final class LongRef implements Serializable {
        public long s;

        public String toString() {
            return String.valueOf(this.s);
        }
    }

    public static final class ObjectRef<T> implements Serializable {
        public T s;

        public String toString() {
            return String.valueOf(this.s);
        }
    }

    public static final class ShortRef implements Serializable {
        public short s;

        public String toString() {
            return String.valueOf(this.s);
        }
    }

    private Ref() {
    }
}
