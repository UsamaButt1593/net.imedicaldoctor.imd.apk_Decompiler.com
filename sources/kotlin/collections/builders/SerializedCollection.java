package kotlin.collections.builders;

import com.itextpdf.tool.xml.html.HTML;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/SerializedCollection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,432:1\n1#2:433\n*E\n"})
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u001b\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "", "collection", "", "tag", "<init>", "(Ljava/util/Collection;I)V", "()V", "", "a", "()Ljava/lang/Object;", "Ljava/io/ObjectOutput;", "output", "", "writeExternal", "(Ljava/io/ObjectOutput;)V", "Ljava/io/ObjectInput;", "input", "readExternal", "(Ljava/io/ObjectInput;)V", "s", "Ljava/util/Collection;", "X", "I", "Y", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class SerializedCollection implements Externalizable {
    public static final int X2 = 0;
    @NotNull
    public static final Companion Y = new Companion((DefaultConstructorMarker) null);
    public static final int Y2 = 1;
    private static final long Z = 0;
    private final int X;
    @NotNull
    private Collection<?> s;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/collections/builders/SerializedCollection$Companion;", "", "()V", "serialVersionUID", "", "tagList", "", "tagSet", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SerializedCollection() {
        this(CollectionsKt.E(), 0);
    }

    private final Object a() {
        return this.s;
    }

    public void readExternal(@NotNull ObjectInput objectInput) {
        Collection<?> collection;
        Intrinsics.p(objectInput, HTML.Tag.q0);
        byte readByte = objectInput.readByte();
        byte b2 = readByte & 1;
        if ((readByte & -2) == 0) {
            int readInt = objectInput.readInt();
            if (readInt >= 0) {
                int i2 = 0;
                if (b2 == 0) {
                    List j2 = CollectionsKt.j(readInt);
                    while (i2 < readInt) {
                        j2.add(objectInput.readObject());
                        i2++;
                    }
                    collection = CollectionsKt.a(j2);
                } else if (b2 == 1) {
                    Set e2 = SetsKt.e(readInt);
                    while (i2 < readInt) {
                        e2.add(objectInput.readObject());
                        i2++;
                    }
                    collection = SetsKt.a(e2);
                } else {
                    throw new InvalidObjectException("Unsupported collection type tag: " + b2 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                }
                this.s = collection;
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        throw new InvalidObjectException("Unsupported flags value: " + readByte + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    public void writeExternal(@NotNull ObjectOutput objectOutput) {
        Intrinsics.p(objectOutput, HTML.Tag.U);
        objectOutput.writeByte(this.X);
        objectOutput.writeInt(this.s.size());
        for (Object writeObject : this.s) {
            objectOutput.writeObject(writeObject);
        }
    }

    public SerializedCollection(@NotNull Collection<?> collection, int i2) {
        Intrinsics.p(collection, "collection");
        this.s = collection;
        this.X = i2;
    }
}
