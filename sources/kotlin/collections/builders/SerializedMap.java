package kotlin.collections.builders;

import com.itextpdf.tool.xml.html.HTML;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "", "map", "<init>", "(Ljava/util/Map;)V", "()V", "", "a", "()Ljava/lang/Object;", "Ljava/io/ObjectOutput;", "output", "", "writeExternal", "(Ljava/io/ObjectOutput;)V", "Ljava/io/ObjectInput;", "input", "readExternal", "(Ljava/io/ObjectInput;)V", "s", "Ljava/util/Map;", "X", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class SerializedMap implements Externalizable {
    @NotNull
    public static final Companion X = new Companion((DefaultConstructorMarker) null);
    private static final long Y = 0;
    @NotNull
    private Map<?, ?> s;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/collections/builders/SerializedMap$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SerializedMap() {
        this(MapsKt.z());
    }

    private final Object a() {
        return this.s;
    }

    public void readExternal(@NotNull ObjectInput objectInput) {
        Intrinsics.p(objectInput, HTML.Tag.q0);
        byte readByte = objectInput.readByte();
        if (readByte == 0) {
            int readInt = objectInput.readInt();
            if (readInt >= 0) {
                Map h2 = MapsKt.h(readInt);
                for (int i2 = 0; i2 < readInt; i2++) {
                    h2.put(objectInput.readObject(), objectInput.readObject());
                }
                this.s = MapsKt.d(h2);
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        throw new InvalidObjectException("Unsupported flags value: " + readByte);
    }

    public void writeExternal(@NotNull ObjectOutput objectOutput) {
        Intrinsics.p(objectOutput, HTML.Tag.U);
        objectOutput.writeByte(0);
        objectOutput.writeInt(this.s.size());
        for (Map.Entry next : this.s.entrySet()) {
            objectOutput.writeObject(next.getKey());
            objectOutput.writeObject(next.getValue());
        }
    }

    public SerializedMap(@NotNull Map<?, ?> map) {
        Intrinsics.p(map, HTML.Tag.t0);
        this.s = map;
    }
}
