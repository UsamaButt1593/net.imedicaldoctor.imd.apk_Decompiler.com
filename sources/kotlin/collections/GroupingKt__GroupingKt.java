package kotlin.collections;

import com.itextpdf.text.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\u001a¥\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032b\u0010\f\u001a^\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00018\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00028\u00020\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a¹\u0001\u0010\u0013\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0011*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0010*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0012\u001a\u00028\u00032b\u0010\f\u001a^\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00018\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00028\u00020\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001aÆ\u0001\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000326\u0010\u0016\u001a2\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u00152K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0017H\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aÚ\u0001\u0010\u001a\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0011*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0010*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0012\u001a\u00028\u000326\u0010\u0016\u001a2\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u00152K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0017H\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0001\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u001c\u001a\u00028\u000226\u0010\f\u001a2\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0015H\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0001\u0010\u001f\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0011*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0010*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0012\u001a\u00028\u00032\u0006\u0010\u001c\u001a\u00028\u000226\u0010\f\u001a2\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0015H\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0001\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0000*\u00028\u0000\"\u0004\b\u0002\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00032K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\u0017H\bø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a¦\u0001\u0010$\u001a\u00028\u0003\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0000*\u00028\u0000\"\u0004\b\u0002\u0010\u0001\"\u0016\b\u0003\u0010\u0011*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\u0010*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00032\u0006\u0010\u0012\u001a\u00028\u00032K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\u0017H\bø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001aK\u0010'\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0016\b\u0002\u0010\u0011*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00020&0\u0010*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0012\u001a\u00028\u0002H\u0007¢\u0006\u0004\b'\u0010(\u0002\u0007\n\u0005\b20\u0001¨\u0006)"}, d2 = {"T", "K", "R", "Lkotlin/collections/Grouping;", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "key", "accumulator", "element", "", "first", "operation", "", "c", "(Lkotlin/collections/Grouping;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "", "M", "destination", "d", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "Lkotlin/Function2;", "initialValueSelector", "Lkotlin/Function3;", "g", "(Lkotlin/collections/Grouping;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "i", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "initialValue", "f", "(Lkotlin/collections/Grouping;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "h", "(Lkotlin/collections/Grouping;Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "S", "j", "(Lkotlin/collections/Grouping;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "k", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "", "e", "(Lkotlin/collections/Grouping;Ljava/util/Map;)Ljava/util/Map;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/GroupingKt")
@SourceDebugExtension({"SMAP\nGrouping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n*L\n1#1,291:1\n80#1,6:292\n53#1:298\n80#1,6:299\n80#1,6:305\n53#1:311\n80#1,6:312\n80#1,6:318\n53#1:324\n80#1,6:325\n80#1,6:331\n189#1:337\n80#1,6:338\n*S KotlinDebug\n*F\n+ 1 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n*L\n53#1:292,6\n112#1:298\n112#1:299,6\n143#1:305,6\n164#1:311\n164#1:312,6\n189#1:318,6\n211#1:324\n211#1:325,6\n239#1:331,6\n257#1:337\n257#1:338,6\n*E\n"})
class GroupingKt__GroupingKt extends GroupingKt__GroupingJVMKt {
    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T, K, R> Map<K, R> c(@NotNull Grouping<T, ? extends K> grouping, @NotNull Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> function4) {
        Intrinsics.p(grouping, "<this>");
        Intrinsics.p(function4, Annotation.q3);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> b2 = grouping.b();
        while (b2.hasNext()) {
            T next = b2.next();
            Object a2 = grouping.a(next);
            Object obj = linkedHashMap.get(a2);
            linkedHashMap.put(a2, function4.O(a2, obj, next, Boolean.valueOf(obj == null && !linkedHashMap.containsKey(a2))));
        }
        return linkedHashMap;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M d(@NotNull Grouping<T, ? extends K> grouping, @NotNull M m2, @NotNull Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> function4) {
        Intrinsics.p(grouping, "<this>");
        Intrinsics.p(m2, Annotation.l3);
        Intrinsics.p(function4, Annotation.q3);
        Iterator<T> b2 = grouping.b();
        while (b2.hasNext()) {
            T next = b2.next();
            Object a2 = grouping.a(next);
            Object obj = m2.get(a2);
            m2.put(a2, function4.O(a2, obj, next, Boolean.valueOf(obj == null && !m2.containsKey(a2))));
        }
        return m2;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T, K, M extends Map<? super K, Integer>> M e(@NotNull Grouping<T, ? extends K> grouping, @NotNull M m2) {
        Intrinsics.p(grouping, "<this>");
        Intrinsics.p(m2, Annotation.l3);
        Iterator<T> b2 = grouping.b();
        while (b2.hasNext()) {
            Object a2 = grouping.a(b2.next());
            Object obj = m2.get(a2);
            if (obj == null && !m2.containsKey(a2)) {
                obj = 0;
            }
            m2.put(a2, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return m2;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T, K, R> Map<K, R> f(@NotNull Grouping<T, ? extends K> grouping, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.p(grouping, "<this>");
        Intrinsics.p(function2, Annotation.q3);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> b2 = grouping.b();
        while (b2.hasNext()) {
            T next = b2.next();
            Object a2 = grouping.a(next);
            R r2 = linkedHashMap.get(a2);
            if (r2 == null && !linkedHashMap.containsKey(a2)) {
                r2 = r;
            }
            linkedHashMap.put(a2, function2.d0(r2, next));
        }
        return linkedHashMap;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T, K, R> Map<K, R> g(@NotNull Grouping<T, ? extends K> grouping, @NotNull Function2<? super K, ? super T, ? extends R> function2, @NotNull Function3<? super K, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.p(grouping, "<this>");
        Intrinsics.p(function2, "initialValueSelector");
        Intrinsics.p(function3, Annotation.q3);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> b2 = grouping.b();
        while (b2.hasNext()) {
            T next = b2.next();
            Object a2 = grouping.a(next);
            Object obj = linkedHashMap.get(a2);
            if (obj == null && !linkedHashMap.containsKey(a2)) {
                obj = function2.d0(a2, next);
            }
            linkedHashMap.put(a2, function3.A(a2, obj, next));
        }
        return linkedHashMap;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M h(@NotNull Grouping<T, ? extends K> grouping, @NotNull M m2, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.p(grouping, "<this>");
        Intrinsics.p(m2, Annotation.l3);
        Intrinsics.p(function2, Annotation.q3);
        Iterator<T> b2 = grouping.b();
        while (b2.hasNext()) {
            T next = b2.next();
            Object a2 = grouping.a(next);
            R r2 = m2.get(a2);
            if (r2 == null && !m2.containsKey(a2)) {
                r2 = r;
            }
            m2.put(a2, function2.d0(r2, next));
        }
        return m2;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M i(@NotNull Grouping<T, ? extends K> grouping, @NotNull M m2, @NotNull Function2<? super K, ? super T, ? extends R> function2, @NotNull Function3<? super K, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.p(grouping, "<this>");
        Intrinsics.p(m2, Annotation.l3);
        Intrinsics.p(function2, "initialValueSelector");
        Intrinsics.p(function3, Annotation.q3);
        Iterator<T> b2 = grouping.b();
        while (b2.hasNext()) {
            T next = b2.next();
            Object a2 = grouping.a(next);
            Object obj = m2.get(a2);
            if (obj == null && !m2.containsKey(a2)) {
                obj = function2.d0(a2, next);
            }
            m2.put(a2, function3.A(a2, obj, next));
        }
        return m2;
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [kotlin.jvm.functions.Function3<? super K, ? super S, ? super T, ? extends S>, kotlin.jvm.functions.Function3, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    @kotlin.SinceKotlin(version = "1.1")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, T extends S, K> java.util.Map<K, S> j(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super K, ? super S, ? super T, ? extends S> r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r6, r0)
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.p(r7, r0)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Iterator r1 = r6.b()
        L_0x0013:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x003b
            java.lang.Object r2 = r1.next()
            java.lang.Object r3 = r6.a(r2)
            java.lang.Object r4 = r0.get(r3)
            if (r4 != 0) goto L_0x002f
            boolean r5 = r0.containsKey(r3)
            if (r5 != 0) goto L_0x002f
            r5 = 1
            goto L_0x0030
        L_0x002f:
            r5 = 0
        L_0x0030:
            if (r5 == 0) goto L_0x0033
            goto L_0x0037
        L_0x0033:
            java.lang.Object r2 = r7.A(r3, r4, r2)
        L_0x0037:
            r0.put(r3, r2)
            goto L_0x0013
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.GroupingKt__GroupingKt.j(kotlin.collections.Grouping, kotlin.jvm.functions.Function3):java.util.Map");
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [kotlin.jvm.functions.Function3<? super K, ? super S, ? super T, ? extends S>, kotlin.jvm.functions.Function3, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    @kotlin.SinceKotlin(version = "1.1")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, T extends S, K, M extends java.util.Map<? super K, S>> M k(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> r5, @org.jetbrains.annotations.NotNull M r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super K, ? super S, ? super T, ? extends S> r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r5, r0)
            java.lang.String r0 = "destination"
            kotlin.jvm.internal.Intrinsics.p(r6, r0)
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.p(r7, r0)
            java.util.Iterator r0 = r5.b()
        L_0x0013:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x003b
            java.lang.Object r1 = r0.next()
            java.lang.Object r2 = r5.a(r1)
            java.lang.Object r3 = r6.get(r2)
            if (r3 != 0) goto L_0x002f
            boolean r4 = r6.containsKey(r2)
            if (r4 != 0) goto L_0x002f
            r4 = 1
            goto L_0x0030
        L_0x002f:
            r4 = 0
        L_0x0030:
            if (r4 == 0) goto L_0x0033
            goto L_0x0037
        L_0x0033:
            java.lang.Object r1 = r7.A(r2, r3, r1)
        L_0x0037:
            r6.put(r2, r1)
            goto L_0x0013
        L_0x003b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.GroupingKt__GroupingKt.k(kotlin.collections.Grouping, java.util.Map, kotlin.jvm.functions.Function3):java.util.Map");
    }
}
