package kotlin.collections.builders;

import com.itextpdf.text.Annotation;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,432:1\n1#2:433\n*E\n"})
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0016\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0000\u0018\u0000 k*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0002lmBO\b\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\b\u0011\u0010\u0012B\t\b\u0016¢\u0006\u0004\b\u0011\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0015J\u000f\u0010\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0001\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u000f\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u0015J\u001b\u0010\u001f\u001a\u00020\r2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0000H\u0002¢\u0006\u0004\b%\u0010&J-\u0010)\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'2\u0006\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\nH\u0002¢\u0006\u0004\b+\u0010,J\u001f\u0010/\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0002¢\u0006\u0004\b/\u0010#J5\u00101\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'2\u0006\u00100\u001a\u00020\rH\u0002¢\u0006\u0004\b1\u00102J\u0013\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\rH\u0016¢\u0006\u0004\b5\u00106J\u0018\u00108\u001a\u00028\u00002\u0006\u00107\u001a\u00020\nH\u0002¢\u0006\u0004\b8\u0010,J \u00109\u001a\u00028\u00002\u0006\u00107\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0000H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0004\b=\u0010<J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0002¢\u0006\u0004\b?\u0010@J\u0015\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000AH\u0016¢\u0006\u0004\bB\u0010CJ\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000A2\u0006\u00107\u001a\u00020\nH\u0016¢\u0006\u0004\bB\u0010DJ\u0017\u0010E\u001a\u00020\r2\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0004\bE\u0010FJ\u001f\u0010E\u001a\u00020\u00192\u0006\u00107\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0004\bE\u0010&J\u001d\u0010G\u001a\u00020\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0004\bG\u0010HJ%\u0010G\u001a\u00020\r2\u0006\u00107\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0004\bG\u0010IJ\u000f\u0010J\u001a\u00020\u0019H\u0016¢\u0006\u0004\bJ\u0010\u0013J\u0017\u0010K\u001a\u00028\u00002\u0006\u00107\u001a\u00020\nH\u0016¢\u0006\u0004\bK\u0010,J\u0017\u0010L\u001a\u00020\r2\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0004\bL\u0010FJ\u001d\u0010M\u001a\u00020\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0004\bM\u0010HJ\u001d\u0010N\u001a\u00020\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0004\bN\u0010HJ%\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\nH\u0016¢\u0006\u0004\bQ\u0010RJ)\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0001\u0010S2\f\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00010\bH\u0016¢\u0006\u0004\bU\u0010VJ\u0017\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\bH\u0016¢\u0006\u0004\bU\u0010WJ\u001a\u0010X\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\bX\u0010FJ\u000f\u0010Y\u001a\u00020\nH\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b\\\u0010]R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010aR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010cR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010eR\u0014\u0010h\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\bg\u00106R\u0014\u0010j\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\bi\u0010Z¨\u0006n"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "array", "", "offset", "length", "", "isReadOnly", "backing", "root", "<init>", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "()V", "initialCapacity", "(I)V", "", "()Ljava/lang/Object;", "minCapacity", "", "q", "n", "r", "", "other", "o", "(Ljava/util/List;)Z", "i", "t", "(II)V", "element", "k", "(ILjava/lang/Object;)V", "", "elements", "j", "(ILjava/util/Collection;I)V", "B", "(I)Ljava/lang/Object;", "rangeOffset", "rangeLength", "C", "retain", "D", "(IILjava/util/Collection;Z)I", "m", "()Ljava/util/List;", "isEmpty", "()Z", "index", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "add", "(Ljava/lang/Object;)Z", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "clear", "c", "remove", "removeAll", "retainAll", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "T", "destination", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "s", "[Ljava/lang/Object;", "X", "I", "Y", "Z", "X2", "Lkotlin/collections/builders/ListBuilder;", "Y2", "z", "isEffectivelyReadOnly", "b", "size", "Z2", "Companion", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
    @NotNull
    private static final Companion Z2 = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final ListBuilder a3;
    /* access modifiers changed from: private */
    public int X;
    @Nullable
    private final ListBuilder<E> X2;
    /* access modifiers changed from: private */
    public int Y;
    @Nullable
    private final ListBuilder<E> Y2;
    private boolean Z;
    /* access modifiers changed from: private */
    @NotNull
    public E[] s;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Companion;", "", "()V", "Empty", "Lkotlin/collections/builders/ListBuilder;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,432:1\n1#2:433\n*E\n"})
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\f\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001d¨\u0006 "}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "Lkotlin/collections/builders/ListBuilder;", "list", "", "index", "<init>", "(Lkotlin/collections/builders/ListBuilder;I)V", "", "hasPrevious", "()Z", "hasNext", "previousIndex", "()I", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "element", "", "set", "(Ljava/lang/Object;)V", "add", "remove", "()V", "s", "Lkotlin/collections/builders/ListBuilder;", "X", "I", "Y", "lastIndex", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private int X;
        private int Y = -1;
        @NotNull
        private final ListBuilder<E> s;

        public Itr(@NotNull ListBuilder<E> listBuilder, int i2) {
            Intrinsics.p(listBuilder, "list");
            this.s = listBuilder;
            this.X = i2;
        }

        public void add(E e2) {
            ListBuilder<E> listBuilder = this.s;
            int i2 = this.X;
            this.X = i2 + 1;
            listBuilder.add(i2, e2);
            this.Y = -1;
        }

        public boolean hasNext() {
            return this.X < this.s.Y;
        }

        public boolean hasPrevious() {
            return this.X > 0;
        }

        public E next() {
            if (this.X < this.s.Y) {
                int i2 = this.X;
                this.X = i2 + 1;
                this.Y = i2;
                return this.s.s[this.s.X + this.Y];
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.X;
        }

        public E previous() {
            int i2 = this.X;
            if (i2 > 0) {
                int i3 = i2 - 1;
                this.X = i3;
                this.Y = i3;
                return this.s.s[this.s.X + this.Y];
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.X - 1;
        }

        public void remove() {
            int i2 = this.Y;
            if (i2 != -1) {
                this.s.remove(i2);
                this.X = this.Y;
                this.Y = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        public void set(E e2) {
            int i2 = this.Y;
            if (i2 != -1) {
                this.s.set(i2, e2);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.Z = true;
        a3 = listBuilder;
    }

    public ListBuilder() {
        this(10);
    }

    private final E B(int i2) {
        ListBuilder<E> listBuilder = this.X2;
        if (listBuilder != null) {
            this.Y--;
            return listBuilder.B(i2);
        }
        E[] eArr = this.s;
        E e2 = eArr[i2];
        ArraysKt.B0(eArr, eArr, i2, i2 + 1, this.X + this.Y);
        ListBuilderKt.f(this.s, (this.X + this.Y) - 1);
        this.Y--;
        return e2;
    }

    private final void C(int i2, int i3) {
        ListBuilder<E> listBuilder = this.X2;
        if (listBuilder != null) {
            listBuilder.C(i2, i3);
        } else {
            E[] eArr = this.s;
            ArraysKt.B0(eArr, eArr, i2, i2 + i3, this.Y);
            E[] eArr2 = this.s;
            int i4 = this.Y;
            ListBuilderKt.g(eArr2, i4 - i3, i4);
        }
        this.Y -= i3;
    }

    private final int D(int i2, int i3, Collection<? extends E> collection, boolean z) {
        ListBuilder<E> listBuilder = this.X2;
        if (listBuilder != null) {
            int D = listBuilder.D(i2, i3, collection, z);
            this.Y -= D;
            return D;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i2 + i4;
            if (collection.contains(this.s[i6]) == z) {
                E[] eArr = this.s;
                i4++;
                eArr[i5 + i2] = eArr[i6];
                i5++;
            } else {
                i4++;
            }
        }
        int i7 = i3 - i5;
        E[] eArr2 = this.s;
        ArraysKt.B0(eArr2, eArr2, i2 + i5, i3 + i2, this.Y);
        E[] eArr3 = this.s;
        int i8 = this.Y;
        ListBuilderKt.g(eArr3, i8 - i7, i8);
        this.Y -= i7;
        return i7;
    }

    private final Object E() {
        if (z()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    private final void j(int i2, Collection<? extends E> collection, int i3) {
        ListBuilder<E> listBuilder = this.X2;
        if (listBuilder != null) {
            listBuilder.j(i2, collection, i3);
            this.s = this.X2.s;
            this.Y += i3;
            return;
        }
        t(i2, i3);
        Iterator<? extends E> it2 = collection.iterator();
        for (int i4 = 0; i4 < i3; i4++) {
            this.s[i2 + i4] = it2.next();
        }
    }

    private final void k(int i2, E e2) {
        ListBuilder<E> listBuilder = this.X2;
        if (listBuilder != null) {
            listBuilder.k(i2, e2);
            this.s = this.X2.s;
            this.Y++;
            return;
        }
        t(i2, 1);
        this.s[i2] = e2;
    }

    private final void n() {
        if (z()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean o(List<?> list) {
        return ListBuilderKt.h(this.s, this.X, this.Y, list);
    }

    private final void q(int i2) {
        if (this.X2 != null) {
            throw new IllegalStateException();
        } else if (i2 >= 0) {
            E[] eArr = this.s;
            if (i2 > eArr.length) {
                this.s = ListBuilderKt.e(this.s, ArrayDeque.Z.a(eArr.length, i2));
            }
        } else {
            throw new OutOfMemoryError();
        }
    }

    private final void r(int i2) {
        q(this.Y + i2);
    }

    private final void t(int i2, int i3) {
        r(i3);
        E[] eArr = this.s;
        ArraysKt.B0(eArr, eArr, i2 + i3, i2, this.X + this.Y);
        this.Y += i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.Y2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean z() {
        /*
            r1 = this;
            boolean r0 = r1.Z
            if (r0 != 0) goto L_0x000f
            kotlin.collections.builders.ListBuilder<E> r0 = r1.Y2
            if (r0 == 0) goto L_0x000d
            boolean r0 = r0.Z
            if (r0 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r0 = 0
            goto L_0x0010
        L_0x000f:
            r0 = 1
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.ListBuilder.z():boolean");
    }

    public void add(int i2, E e2) {
        n();
        AbstractList.s.c(i2, this.Y);
        k(this.X + i2, e2);
    }

    public boolean addAll(int i2, @NotNull Collection<? extends E> collection) {
        Intrinsics.p(collection, "elements");
        n();
        AbstractList.s.c(i2, this.Y);
        int size = collection.size();
        j(this.X + i2, collection, size);
        return size > 0;
    }

    public int b() {
        return this.Y;
    }

    public E c(int i2) {
        n();
        AbstractList.s.b(i2, this.Y);
        return B(this.X + i2);
    }

    public void clear() {
        n();
        C(this.X, this.Y);
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof List) && o((List) obj));
    }

    public E get(int i2) {
        AbstractList.s.b(i2, this.Y);
        return this.s[this.X + i2];
    }

    public int hashCode() {
        return ListBuilderKt.i(this.s, this.X, this.Y);
    }

    public int indexOf(Object obj) {
        for (int i2 = 0; i2 < this.Y; i2++) {
            if (Intrinsics.g(this.s[this.X + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.Y == 0;
    }

    @NotNull
    public Iterator<E> iterator() {
        return new Itr(this, 0);
    }

    public int lastIndexOf(Object obj) {
        for (int i2 = this.Y - 1; i2 >= 0; i2--) {
            if (Intrinsics.g(this.s[this.X + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @NotNull
    public ListIterator<E> listIterator() {
        return new Itr(this, 0);
    }

    @NotNull
    public final List<E> m() {
        if (this.X2 == null) {
            n();
            this.Z = true;
            return this.Y > 0 ? this : a3;
        }
        throw new IllegalStateException();
    }

    public boolean remove(Object obj) {
        n();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.p(collection, "elements");
        n();
        return D(this.X, this.Y, collection, false) > 0;
    }

    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.p(collection, "elements");
        n();
        return D(this.X, this.Y, collection, true) > 0;
    }

    public E set(int i2, E e2) {
        n();
        AbstractList.s.b(i2, this.Y);
        E[] eArr = this.s;
        int i3 = this.X;
        E e3 = eArr[i3 + i2];
        eArr[i3 + i2] = e2;
        return e3;
    }

    @NotNull
    public List<E> subList(int i2, int i3) {
        AbstractList.s.d(i2, i3, this.Y);
        E[] eArr = this.s;
        int i4 = this.X + i2;
        int i5 = i3 - i2;
        boolean z = this.Z;
        ListBuilder<E> listBuilder = this.Y2;
        return new ListBuilder(eArr, i4, i5, z, this, listBuilder == null ? this : listBuilder);
    }

    @NotNull
    public Object[] toArray() {
        E[] eArr = this.s;
        int i2 = this.X;
        return ArraysKt.l1(eArr, i2, this.Y + i2);
    }

    @NotNull
    public String toString() {
        return ListBuilderKt.j(this.s, this.X, this.Y);
    }

    public ListBuilder(int i2) {
        this(ListBuilderKt.d(i2), 0, 0, false, (ListBuilder) null, (ListBuilder) null);
    }

    public boolean add(E e2) {
        n();
        k(this.X + this.Y, e2);
        return true;
    }

    public boolean addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.p(collection, "elements");
        n();
        int size = collection.size();
        j(this.X + this.Y, collection, size);
        return size > 0;
    }

    @NotNull
    public ListIterator<E> listIterator(int i2) {
        AbstractList.s.c(i2, this.Y);
        return new Itr(this, i2);
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        Intrinsics.p(tArr, Annotation.l3);
        int length = tArr.length;
        int i2 = this.Y;
        if (length < i2) {
            E[] eArr = this.s;
            int i3 = this.X;
            T[] copyOfRange = Arrays.copyOfRange(eArr, i3, i2 + i3, tArr.getClass());
            Intrinsics.o(copyOfRange, "copyOfRange(array, offse…h, destination.javaClass)");
            return copyOfRange;
        }
        E[] eArr2 = this.s;
        int i4 = this.X;
        ArraysKt.B0(eArr2, tArr, 0, i4, i2 + i4);
        int length2 = tArr.length;
        int i5 = this.Y;
        if (length2 > i5) {
            tArr[i5] = null;
        }
        return tArr;
    }

    private ListBuilder(E[] eArr, int i2, int i3, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.s = eArr;
        this.X = i2;
        this.Y = i3;
        this.Z = z;
        this.X2 = listBuilder;
        this.Y2 = listBuilder2;
    }
}
