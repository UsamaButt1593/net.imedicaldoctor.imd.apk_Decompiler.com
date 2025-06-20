package kotlin.collections.builders;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.tool.xml.html.HTML;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,697:1\n1#2:698\n*E\n"})
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u000b\b\u0000\u0018\u0000 \u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005:\f\u0001\u0001\u0001\u0001\u0001\u0001BG\b\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u0013J\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u0011J\u0017\u0010'\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010\u0013J\u0017\u0010\u0001\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0001\u0010\u001dJ\u0017\u0010)\u001a\u00020\f2\u0006\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0004\b)\u0010$J\u0017\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00028\u0001H\u0002¢\u0006\u0004\b+\u0010$J\u0017\u0010-\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\fH\u0002¢\u0006\u0004\b-\u0010\u0013J\u0017\u0010/\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\fH\u0002¢\u0006\u0004\b/\u0010\u0013J\u001f\u00102\u001a\u00020\u001b2\u000e\u00101\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000300H\u0002¢\u0006\u0004\b2\u00103J#\u00106\u001a\u00020\u001b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000104H\u0002¢\u0006\u0004\b6\u00107J)\u0010:\u001a\u00020\u001b2\u0018\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010408H\u0002¢\u0006\u0004\b:\u0010;J\u0019\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u001bH\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00028\u0000H\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u001b2\u0006\u0010*\u001a\u00028\u0001H\u0016¢\u0006\u0004\bB\u0010AJ\u001a\u0010C\u001a\u0004\u0018\u00018\u00012\u0006\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0004\bC\u0010DJ!\u0010E\u001a\u0004\u0018\u00018\u00012\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010*\u001a\u00028\u0001H\u0016¢\u0006\u0004\bE\u0010FJ%\u0010G\u001a\u00020\u00182\u0014\u00109\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0016¢\u0006\u0004\bG\u0010HJ\u0019\u0010I\u001a\u0004\u0018\u00018\u00012\u0006\u0010\"\u001a\u00028\u0000H\u0016¢\u0006\u0004\bI\u0010DJ\u000f\u0010J\u001a\u00020\u0018H\u0016¢\u0006\u0004\bJ\u0010\u0011J\u001a\u0010K\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\bK\u0010AJ\u000f\u0010L\u001a\u00020\fH\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0018H\u0000¢\u0006\u0004\bQ\u0010\u0011J\u0017\u0010R\u001a\u00020\f2\u0006\u0010\"\u001a\u00028\u0000H\u0000¢\u0006\u0004\bR\u0010$J\u0017\u0010S\u001a\u00020\f2\u0006\u0010\"\u001a\u00028\u0000H\u0000¢\u0006\u0004\bS\u0010$J#\u0010T\u001a\u00020\u001b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000104H\u0000¢\u0006\u0004\bT\u00107J\u001b\u0010\u0017\u001a\u00020\u001b2\n\u0010%\u001a\u0006\u0012\u0002\b\u000308H\u0000¢\u0006\u0004\b\u0017\u0010;J#\u0010U\u001a\u00020\u001b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000104H\u0000¢\u0006\u0004\bU\u00107J\u0017\u0010W\u001a\u00020\u001b2\u0006\u0010V\u001a\u00028\u0001H\u0000¢\u0006\u0004\bW\u0010AJ\u001b\u0010Y\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010XH\u0000¢\u0006\u0004\bY\u0010ZJ\u001b\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010[H\u0000¢\u0006\u0004\b\\\u0010]J\u001b\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010^H\u0000¢\u0006\u0004\b_\u0010`R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010aR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010aR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010dR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010:R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bg\u0010:R\u0016\u0010i\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010:R$\u0010m\u001a\u00020\f2\u0006\u0010j\u001a\u00020\f8\u0016@RX\u000e¢\u0006\f\n\u0004\bk\u0010:\u001a\u0004\bl\u0010MR\u001e\u0010q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u001e\u0010u\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bs\u0010tR$\u0010y\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010v8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bw\u0010xR$\u0010|\u001a\u00020\u001b2\u0006\u0010j\u001a\u00020\u001b8\u0000@BX\u000e¢\u0006\f\n\u0004\bz\u0010e\u001a\u0004\b{\u0010?R\u0014\u0010~\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b}\u0010MR\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u000008VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u00018VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000108VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010\u001e\u001a\u00020\f8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010M¨\u0006\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "keysArray", "valuesArray", "", "presenceArray", "hashArray", "", "maxProbeDistance", "length", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "()V", "initialCapacity", "(I)V", "", "U", "()Ljava/lang/Object;", "n", "", "t", "extraCapacity", "", "S", "(I)Z", "capacity", "s", "j", "()[Ljava/lang/Object;", "key", "E", "(Ljava/lang/Object;)I", "m", "newHashSize", "M", "i", "v", "value", "w", "index", "Q", "removedHash", "O", "", "other", "p", "(Ljava/util/Map;)Z", "", "entry", "J", "(Ljava/util/Map$Entry;)Z", "", "from", "I", "(Ljava/util/Collection;)Z", "k", "()Ljava/util/Map;", "isEmpty", "()Z", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "(Ljava/util/Map;)V", "remove", "clear", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "l", "h", "P", "o", "N", "element", "R", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "H", "()Lkotlin/collections/builders/MapBuilder$KeysItr;", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "T", "()Lkotlin/collections/builders/MapBuilder$ValuesItr;", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "u", "()Lkotlin/collections/builders/MapBuilder$EntriesItr;", "[Ljava/lang/Object;", "X", "Y", "[I", "Z", "X2", "Y2", "Z2", "hashShift", "<set-?>", "a3", "C", "size", "Lkotlin/collections/builders/MapBuilderKeys;", "b3", "Lkotlin/collections/builders/MapBuilderKeys;", "keysView", "Lkotlin/collections/builders/MapBuilderValues;", "c3", "Lkotlin/collections/builders/MapBuilderValues;", "valuesView", "Lkotlin/collections/builders/MapBuilderEntries;", "d3", "Lkotlin/collections/builders/MapBuilderEntries;", "entriesView", "e3", "F", "isReadOnly", "A", "hashSize", "", "B", "()Ljava/util/Set;", "keys", "", "D", "()Ljava/util/Collection;", "values", "", "z", "entries", "y", "f3", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    @NotNull
    public static final Companion f3 = new Companion((DefaultConstructorMarker) null);
    private static final int g3 = -1640531527;
    private static final int h3 = 8;
    private static final int i3 = 2;
    private static final int j3 = -1;
    /* access modifiers changed from: private */
    @NotNull
    public static final MapBuilder k3;
    /* access modifiers changed from: private */
    @Nullable
    public V[] X;
    private int X2;
    /* access modifiers changed from: private */
    @NotNull
    public int[] Y;
    /* access modifiers changed from: private */
    public int Y2;
    @NotNull
    private int[] Z;
    private int Z2;
    private int a3;
    @Nullable
    private MapBuilderKeys<K> b3;
    @Nullable
    private MapBuilderValues<V> c3;
    @Nullable
    private MapBuilderEntries<K, V> d3;
    private boolean e3;
    /* access modifiers changed from: private */
    @NotNull
    public K[] s;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0007R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n8\u0000X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", "", "<init>", "()V", "", "capacity", "c", "(I)I", "hashSize", "d", "Lkotlin/collections/builders/MapBuilder;", "", "Empty", "Lkotlin/collections/builders/MapBuilder;", "e", "()Lkotlin/collections/builders/MapBuilder;", "INITIAL_CAPACITY", "I", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        public final int c(int i2) {
            return Integer.highestOneBit(RangesKt.u(i2, 1) * 3);
        }

        /* access modifiers changed from: private */
        public final int d(int i2) {
            return Integer.numberOfLeadingZeros(i2) + 1;
        }

        @NotNull
        public final MapBuilder e() {
            return MapBuilder.k3;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0004B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\u00132\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "g", "()Lkotlin/collections/builders/MapBuilder$EntryRef;", "", "j", "()I", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "", "h", "(Ljava/lang/StringBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EntriesItr(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.p(mapBuilder, HTML.Tag.t0);
        }

        @NotNull
        /* renamed from: g */
        public EntryRef<K, V> next() {
            if (a() < c().Y2) {
                int a2 = a();
                e(a2 + 1);
                f(a2);
                EntryRef<K, V> entryRef = new EntryRef<>(c(), b());
                d();
                return entryRef;
            }
            throw new NoSuchElementException();
        }

        public final void h(@NotNull StringBuilder sb) {
            Intrinsics.p(sb, "sb");
            if (a() < c().Y2) {
                int a2 = a();
                e(a2 + 1);
                f(a2);
                Object obj = c().s[b()];
                if (Intrinsics.g(obj, c())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append(ASCIIPropertyListParser.f18654l);
                Object[] f2 = c().X;
                Intrinsics.m(f2);
                Object obj2 = f2[b()];
                if (Intrinsics.g(obj2, c())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                d();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int j() {
            if (a() < c().Y2) {
                int a2 = a();
                e(a2 + 1);
                f(a2);
                Object obj = c().s[b()];
                int i2 = 0;
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object[] f2 = c().X;
                Intrinsics.m(f2);
                Object obj2 = f2[b()];
                if (obj2 != null) {
                    i2 = obj2.hashCode();
                }
                int i3 = hashCode ^ i2;
                d();
                return i3;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00028\u00032\u0006\u0010\n\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00028\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00028\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001c¨\u0006 "}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "Lkotlin/collections/builders/MapBuilder;", "map", "", "index", "<init>", "(Lkotlin/collections/builders/MapBuilder;I)V", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "s", "Lkotlin/collections/builders/MapBuilder;", "X", "I", "getKey", "()Ljava/lang/Object;", "key", "getValue", "value", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final int X;
        @NotNull
        private final MapBuilder<K, V> s;

        public EntryRef(@NotNull MapBuilder<K, V> mapBuilder, int i2) {
            Intrinsics.p(mapBuilder, HTML.Tag.t0);
            this.s = mapBuilder;
            this.X = i2;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return Intrinsics.g(entry.getKey(), getKey()) && Intrinsics.g(entry.getValue(), getValue());
            }
        }

        public K getKey() {
            return this.s.s[this.X];
        }

        public V getValue() {
            V[] f2 = this.s.X;
            Intrinsics.m(f2);
            return f2[this.X];
        }

        public int hashCode() {
            Object key = getKey();
            int i2 = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            if (value != null) {
                i2 = value.hashCode();
            }
            return hashCode ^ i2;
        }

        public V setValue(V v) {
            this.s.l();
            V[] a2 = this.s.j();
            int i2 = this.X;
            V v2 = a2[i2];
            a2[i2] = v;
            return v2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append(ASCIIPropertyListParser.f18654l);
            sb.append(getValue());
            return sb.toString();
        }
    }

    @SourceDebugExtension({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,697:1\n1#2:698\n*E\n"})
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\nR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00138\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006\u001f"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "", "d", "()V", "", "hasNext", "()Z", "remove", "s", "Lkotlin/collections/builders/MapBuilder;", "c", "()Lkotlin/collections/builders/MapBuilder;", "", "X", "I", "a", "()I", "e", "(I)V", "index", "Y", "b", "f", "lastIndex", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static class Itr<K, V> {
        private int X;
        private int Y = -1;
        @NotNull
        private final MapBuilder<K, V> s;

        public Itr(@NotNull MapBuilder<K, V> mapBuilder) {
            Intrinsics.p(mapBuilder, HTML.Tag.t0);
            this.s = mapBuilder;
            d();
        }

        public final int a() {
            return this.X;
        }

        public final int b() {
            return this.Y;
        }

        @NotNull
        public final MapBuilder<K, V> c() {
            return this.s;
        }

        public final void d() {
            while (this.X < this.s.Y2) {
                int[] e2 = this.s.Y;
                int i2 = this.X;
                if (e2[i2] < 0) {
                    this.X = i2 + 1;
                } else {
                    return;
                }
            }
        }

        public final void e(int i2) {
            this.X = i2;
        }

        public final void f(int i2) {
            this.Y = i2;
        }

        public final boolean hasNext() {
            return this.X < this.s.Y2;
        }

        public final void remove() {
            if (this.Y != -1) {
                this.s.l();
                this.s.Q(this.Y);
                this.Y = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0002H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public KeysItr(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.p(mapBuilder, HTML.Tag.t0);
        }

        public K next() {
            if (a() < c().Y2) {
                int a2 = a();
                e(a2 + 1);
                f(a2);
                K k2 = c().s[b()];
                d();
                return k2;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0003H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ValuesItr(@NotNull MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.p(mapBuilder, HTML.Tag.t0);
        }

        public V next() {
            if (a() < c().Y2) {
                int a2 = a();
                e(a2 + 1);
                f(a2);
                V[] f2 = c().X;
                Intrinsics.m(f2);
                V v = f2[b()];
                d();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.e3 = true;
        k3 = mapBuilder;
    }

    public MapBuilder() {
        this(8);
    }

    private final int A() {
        return this.Z.length;
    }

    private final int E(K k2) {
        return ((k2 != null ? k2.hashCode() : 0) * g3) >>> this.Z2;
    }

    private final boolean I(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        t(collection.size());
        for (Map.Entry J : collection) {
            if (J(J)) {
                z = true;
            }
        }
        return z;
    }

    private final boolean J(Map.Entry<? extends K, ? extends V> entry) {
        int h2 = h(entry.getKey());
        Object[] j2 = j();
        if (h2 >= 0) {
            j2[h2] = entry.getValue();
            return true;
        }
        int i2 = (-h2) - 1;
        if (Intrinsics.g(entry.getValue(), j2[i2])) {
            return false;
        }
        j2[i2] = entry.getValue();
        return true;
    }

    private final boolean K(int i2) {
        int E = E(this.s[i2]);
        int i4 = this.X2;
        while (true) {
            int[] iArr = this.Z;
            if (iArr[E] == 0) {
                iArr[E] = i2 + 1;
                this.Y[i2] = E;
                return true;
            }
            i4--;
            if (i4 < 0) {
                return false;
            }
            E = E == 0 ? A() - 1 : E - 1;
        }
    }

    private final void M(int i2) {
        if (this.Y2 > size()) {
            m();
        }
        int i4 = 0;
        if (i2 != A()) {
            this.Z = new int[i2];
            this.Z2 = f3.d(i2);
        } else {
            ArraysKt.K1(this.Z, 0, 0, A());
        }
        while (i4 < this.Y2) {
            int i5 = i4 + 1;
            if (K(i4)) {
                i4 = i5;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    private final void O(int i2) {
        int B = RangesKt.B(this.X2 * 2, A() / 2);
        int i4 = 0;
        int i5 = i2;
        do {
            i2 = i2 == 0 ? A() - 1 : i2 - 1;
            i4++;
            if (i4 > this.X2) {
                this.Z[i5] = 0;
                return;
            }
            int[] iArr = this.Z;
            int i6 = iArr[i2];
            if (i6 == 0) {
                iArr[i5] = 0;
                return;
            }
            if (i6 < 0) {
                iArr[i5] = -1;
            } else {
                int i7 = i6 - 1;
                if (((E(this.s[i7]) - i2) & (A() - 1)) >= i4) {
                    this.Z[i5] = i6;
                    this.Y[i7] = i5;
                }
                B--;
            }
            i5 = i2;
            i4 = 0;
            B--;
        } while (B >= 0);
        this.Z[i5] = -1;
    }

    /* access modifiers changed from: private */
    public final void Q(int i2) {
        ListBuilderKt.f(this.s, i2);
        O(this.Y[i2]);
        this.Y[i2] = -1;
        this.a3 = size() - 1;
    }

    private final boolean S(int i2) {
        int y = y();
        int i4 = this.Y2;
        int i5 = y - i4;
        int size = i4 - size();
        return i5 < i2 && i5 + size >= i2 && size >= y() / 4;
    }

    private final Object U() {
        if (this.e3) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    /* access modifiers changed from: private */
    public final V[] j() {
        V[] vArr = this.X;
        if (vArr != null) {
            return vArr;
        }
        V[] d2 = ListBuilderKt.d(y());
        this.X = d2;
        return d2;
    }

    private final void m() {
        int i2;
        V[] vArr = this.X;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i2 = this.Y2;
            if (i4 >= i2) {
                break;
            }
            if (this.Y[i4] >= 0) {
                K[] kArr = this.s;
                kArr[i5] = kArr[i4];
                if (vArr != null) {
                    vArr[i5] = vArr[i4];
                }
                i5++;
            }
            i4++;
        }
        ListBuilderKt.g(this.s, i5, i2);
        if (vArr != null) {
            ListBuilderKt.g(vArr, i5, this.Y2);
        }
        this.Y2 = i5;
    }

    private final boolean p(Map<?, ?> map) {
        return size() == map.size() && n(map.entrySet());
    }

    private final void s(int i2) {
        if (i2 < 0) {
            throw new OutOfMemoryError();
        } else if (i2 > y()) {
            int y = (y() * 3) / 2;
            if (i2 <= y) {
                i2 = y;
            }
            this.s = ListBuilderKt.e(this.s, i2);
            V[] vArr = this.X;
            this.X = vArr != null ? ListBuilderKt.e(vArr, i2) : null;
            int[] copyOf = Arrays.copyOf(this.Y, i2);
            Intrinsics.o(copyOf, "copyOf(this, newSize)");
            this.Y = copyOf;
            int a2 = f3.c(i2);
            if (a2 > A()) {
                M(a2);
            }
        }
    }

    private final void t(int i2) {
        if (S(i2)) {
            M(A());
        } else {
            s(this.Y2 + i2);
        }
    }

    private final int v(K k2) {
        int E = E(k2);
        int i2 = this.X2;
        while (true) {
            int i4 = this.Z[E];
            if (i4 == 0) {
                return -1;
            }
            if (i4 > 0) {
                int i5 = i4 - 1;
                if (Intrinsics.g(this.s[i5], k2)) {
                    return i5;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            E = E == 0 ? A() - 1 : E - 1;
        }
    }

    private final int w(V v) {
        int i2 = this.Y2;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.Y[i2] >= 0) {
                V[] vArr = this.X;
                Intrinsics.m(vArr);
                if (Intrinsics.g(vArr[i2], v)) {
                    return i2;
                }
            }
        }
    }

    @NotNull
    public Set<K> B() {
        MapBuilderKeys<K> mapBuilderKeys = this.b3;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys<K> mapBuilderKeys2 = new MapBuilderKeys<>(this);
        this.b3 = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    public int C() {
        return this.a3;
    }

    @NotNull
    public Collection<V> D() {
        MapBuilderValues<V> mapBuilderValues = this.c3;
        if (mapBuilderValues != null) {
            return mapBuilderValues;
        }
        MapBuilderValues<V> mapBuilderValues2 = new MapBuilderValues<>(this);
        this.c3 = mapBuilderValues2;
        return mapBuilderValues2;
    }

    public final boolean F() {
        return this.e3;
    }

    @NotNull
    public final KeysItr<K, V> H() {
        return new KeysItr<>(this);
    }

    public final boolean N(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.p(entry, "entry");
        l();
        int v = v(entry.getKey());
        if (v < 0) {
            return false;
        }
        V[] vArr = this.X;
        Intrinsics.m(vArr);
        if (!Intrinsics.g(vArr[v], entry.getValue())) {
            return false;
        }
        Q(v);
        return true;
    }

    public final int P(K k2) {
        l();
        int v = v(k2);
        if (v < 0) {
            return -1;
        }
        Q(v);
        return v;
    }

    public final boolean R(V v) {
        l();
        int w = w(v);
        if (w < 0) {
            return false;
        }
        Q(w);
        return true;
    }

    @NotNull
    public final ValuesItr<K, V> T() {
        return new ValuesItr<>(this);
    }

    public void clear() {
        l();
        IntIterator n2 = new IntRange(0, this.Y2 - 1).iterator();
        while (n2.hasNext()) {
            int b2 = n2.b();
            int[] iArr = this.Y;
            int i2 = iArr[b2];
            if (i2 >= 0) {
                this.Z[i2] = 0;
                iArr[b2] = -1;
            }
        }
        ListBuilderKt.g(this.s, 0, this.Y2);
        V[] vArr = this.X;
        if (vArr != null) {
            ListBuilderKt.g(vArr, 0, this.Y2);
        }
        this.a3 = 0;
        this.Y2 = 0;
    }

    public boolean containsKey(Object obj) {
        return v(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return w(obj) >= 0;
    }

    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return z();
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof Map) && p((Map) obj));
    }

    @Nullable
    public V get(Object obj) {
        int v = v(obj);
        if (v < 0) {
            return null;
        }
        V[] vArr = this.X;
        Intrinsics.m(vArr);
        return vArr[v];
    }

    public final int h(K k2) {
        l();
        while (true) {
            int E = E(k2);
            int B = RangesKt.B(this.X2 * 2, A() / 2);
            int i2 = 0;
            while (true) {
                int i4 = this.Z[E];
                if (i4 <= 0) {
                    if (this.Y2 >= y()) {
                        t(1);
                    } else {
                        int i5 = this.Y2;
                        int i6 = i5 + 1;
                        this.Y2 = i6;
                        this.s[i5] = k2;
                        this.Y[i5] = E;
                        this.Z[E] = i6;
                        this.a3 = size() + 1;
                        if (i2 > this.X2) {
                            this.X2 = i2;
                        }
                        return i5;
                    }
                } else if (Intrinsics.g(this.s[i4 - 1], k2)) {
                    return -i4;
                } else {
                    i2++;
                    if (i2 > B) {
                        M(A() * 2);
                        break;
                    }
                    E = E == 0 ? A() - 1 : E - 1;
                }
            }
        }
    }

    public int hashCode() {
        EntriesItr u = u();
        int i2 = 0;
        while (u.hasNext()) {
            i2 += u.j();
        }
        return i2;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @NotNull
    public final Map<K, V> k() {
        l();
        this.e3 = true;
        if (size() > 0) {
            return this;
        }
        MapBuilder mapBuilder = k3;
        Intrinsics.n(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    public final /* bridge */ Set<K> keySet() {
        return B();
    }

    public final void l() {
        if (this.e3) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean n(@NotNull Collection<?> collection) {
        Intrinsics.p(collection, "m");
        for (Object next : collection) {
            if (next != null) {
                try {
                    if (!o((Map.Entry) next)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean o(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.p(entry, "entry");
        int v = v(entry.getKey());
        if (v < 0) {
            return false;
        }
        V[] vArr = this.X;
        Intrinsics.m(vArr);
        return Intrinsics.g(vArr[v], entry.getValue());
    }

    @Nullable
    public V put(K k2, V v) {
        l();
        int h2 = h(k2);
        V[] j2 = j();
        if (h2 < 0) {
            int i2 = (-h2) - 1;
            V v2 = j2[i2];
            j2[i2] = v;
            return v2;
        }
        j2[h2] = v;
        return null;
    }

    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "from");
        l();
        I(map.entrySet());
    }

    @Nullable
    public V remove(Object obj) {
        int P = P(obj);
        if (P < 0) {
            return null;
        }
        V[] vArr = this.X;
        Intrinsics.m(vArr);
        V v = vArr[P];
        ListBuilderKt.f(vArr, P);
        return v;
    }

    public final /* bridge */ int size() {
        return C();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        EntriesItr u = u();
        int i2 = 0;
        while (u.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            u.h(sb);
            i2++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.o(sb2, "sb.toString()");
        return sb2;
    }

    @NotNull
    public final EntriesItr<K, V> u() {
        return new EntriesItr<>(this);
    }

    public final /* bridge */ Collection<V> values() {
        return D();
    }

    public final int y() {
        return this.s.length;
    }

    @NotNull
    public Set<Map.Entry<K, V>> z() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.d3;
        if (mapBuilderEntries != null) {
            return mapBuilderEntries;
        }
        MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
        this.d3 = mapBuilderEntries2;
        return mapBuilderEntries2;
    }

    public MapBuilder(int i2) {
        this(ListBuilderKt.d(i2), (V[]) null, new int[i2], new int[f3.c(i2)], 2, 0);
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i2, int i4) {
        this.s = kArr;
        this.X = vArr;
        this.Y = iArr;
        this.Z = iArr2;
        this.X2 = i2;
        this.Y2 = i4;
        this.Z2 = f3.d(A());
    }
}
