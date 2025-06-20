package kotlin.jvm.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.tool.xml.css.CSS;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,205:1\n1559#2:206\n1590#2,4:207\n1253#2,4:211\n1238#2,4:217\n453#3:215\n403#3:216\n*S KotlinDebug\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n*L\n107#1:206\n107#1:207,4\n155#1:211,4\n163#1:217,4\n163#1:215\n163#1:216\n*E\n"})
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001b\n\u0002\b\u0007\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001]B\u0013\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR \u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8VX\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR \u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u001b8VX\u0004¢\u0006\f\u0012\u0004\b$\u0010 \u001a\u0004\b#\u0010\u001eR(\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u001b8VX\u0004¢\u0006\f\u0012\u0004\b'\u0010 \u001a\u0004\b&\u0010\u001eR\u001c\u0010-\u001a\u0004\u0018\u00010)8VX\u0004¢\u0006\f\u0012\u0004\b,\u0010 \u001a\u0004\b*\u0010+R\u001a\u00101\u001a\u00020\f8VX\u0004¢\u0006\f\u0012\u0004\b0\u0010 \u001a\u0004\b.\u0010/R\u001a\u00102\u001a\u00020\f8VX\u0004¢\u0006\f\u0012\u0004\b3\u0010 \u001a\u0004\b2\u0010/R\u001a\u00106\u001a\u00020\f8VX\u0004¢\u0006\f\u0012\u0004\b5\u0010 \u001a\u0004\b4\u0010/R\u001a\u00109\u001a\u00020\f8VX\u0004¢\u0006\f\u0012\u0004\b8\u0010 \u001a\u0004\b7\u0010/R\u001a\u0010<\u001a\u00020\f8VX\u0004¢\u0006\f\u0012\u0004\b;\u0010 \u001a\u0004\b:\u0010/R\u001a\u0010?\u001a\u00020\f8VX\u0004¢\u0006\f\u0012\u0004\b>\u0010 \u001a\u0004\b=\u0010/R\u001a\u0010B\u001a\u00020\f8VX\u0004¢\u0006\f\u0012\u0004\bA\u0010 \u001a\u0004\b@\u0010/R\u001a\u0010E\u001a\u00020\f8VX\u0004¢\u0006\f\u0012\u0004\bD\u0010 \u001a\u0004\bC\u0010/R\u001a\u0010H\u001a\u00020\f8VX\u0004¢\u0006\f\u0012\u0004\bG\u0010 \u001a\u0004\bF\u0010/R\u0016\u0010J\u001a\u0004\u0018\u00010\u00148VX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u0016R\u0016\u0010L\u001a\u0004\u0018\u00010\u00148VX\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0016R\u001e\u0010Q\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030N0M8VX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR \u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020R0M8VX\u0004¢\u0006\u0006\u001a\u0004\bS\u0010PR\u001e\u0010V\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010M8VX\u0004¢\u0006\u0006\u001a\u0004\bU\u0010PR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020W0\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u001eR\u0016\u0010\\\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[¨\u0006^"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "Ljava/lang/Class;", "jClass", "<init>", "(Ljava/lang/Class;)V", "", "C", "()Ljava/lang/Void;", "value", "", "i0", "(Ljava/lang/Object;)Z", "other", "equals", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "s", "Ljava/lang/Class;", "o", "()Ljava/lang/Class;", "", "Lkotlin/reflect/KTypeParameter;", "h", "()Ljava/util/List;", "G", "()V", "typeParameters", "Lkotlin/reflect/KType;", "M", "F", "supertypes", "D", "E", "sealedSubclasses", "Lkotlin/reflect/KVisibility;", "b", "()Lkotlin/reflect/KVisibility;", "H", "visibility", "d", "()Z", "V", "isFinal", "isOpen", "a0", "i", "O", "isAbstract", "W", "b0", "isSealed", "v0", "T", "isData", "J", "Z", "isInner", "U", "Q", "isCompanion", "y", "X", "isFun", "I", "d0", "isValue", "K", "simpleName", "m", "qualifiedName", "", "Lkotlin/reflect/KCallable;", "l", "()Ljava/util/Collection;", "members", "Lkotlin/reflect/KFunction;", "w", "constructors", "p", "nestedClasses", "", "getAnnotations", "annotations", "P", "()Ljava/lang/Object;", "objectInstance", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    @NotNull
    public static final Companion X = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final HashMap<String, String> X2;
    /* access modifiers changed from: private */
    @NotNull
    public static final Map<Class<? extends Function<?>>, Integer> Y;
    /* access modifiers changed from: private */
    @NotNull
    public static final HashMap<String, String> Y2;
    @NotNull
    private static final HashMap<String, String> Z;
    /* access modifiers changed from: private */
    @NotNull
    public static final Map<String, String> Z2;
    @NotNull
    private final Class<?> s;

    @SourceDebugExtension({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,205:1\n1#2:206\n*E\n"})
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u0004\u0018\u00010\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\t\u0010\bJ#\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\f\u0010\rR,\u0010\u0011\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000f0\u0004\u0012\u0004\u0012\u00020\u00100\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R0\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R0\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012¨\u0006\u001a"}, d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "<init>", "()V", "Ljava/lang/Class;", "jClass", "", "b", "(Ljava/lang/Class;)Ljava/lang/String;", "a", "value", "", "c", "(Ljava/lang/Object;Ljava/lang/Class;)Z", "", "Lkotlin/Function;", "", "FUNCTION_CLASSES", "Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "classFqNames", "Ljava/util/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final String a(@NotNull Class<?> cls) {
            String str;
            Intrinsics.p(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive() && (str = (String) ClassReference.Y2.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                return str2 == null ? "kotlin.Array" : str2;
            }
            String str3 = (String) ClassReference.Y2.get(cls.getName());
            return str3 == null ? cls.getCanonicalName() : str3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x003d, code lost:
            if (r2 == null) goto L_0x0042;
         */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String b(@org.jetbrains.annotations.NotNull java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.Intrinsics.p(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto L_0x000e
                goto L_0x00b1
            L_0x000e:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L_0x0068
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r2 = r8.getEnclosingMethod()
                r3 = 2
                r4 = 36
                java.lang.String r5 = "name"
                if (r2 == 0) goto L_0x0042
                kotlin.jvm.internal.Intrinsics.o(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = r2.getName()
                r6.append(r2)
                r6.append(r4)
                java.lang.String r2 = r6.toString()
                java.lang.String r2 = kotlin.text.StringsKt.n5(r0, r2, r1, r3, r1)
                if (r2 != 0) goto L_0x0040
                goto L_0x0042
            L_0x0040:
                r1 = r2
                goto L_0x00b1
            L_0x0042:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                kotlin.jvm.internal.Intrinsics.o(r0, r5)
                if (r8 == 0) goto L_0x0063
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = r8.getName()
                r2.append(r8)
                r2.append(r4)
                java.lang.String r8 = r2.toString()
                java.lang.String r1 = kotlin.text.StringsKt.n5(r0, r8, r1, r3, r1)
                goto L_0x00b1
            L_0x0063:
                java.lang.String r1 = kotlin.text.StringsKt.m5(r0, r4, r1, r3, r1)
                goto L_0x00b1
            L_0x0068:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto L_0x009c
                java.lang.Class r8 = r8.getComponentType()
                boolean r0 = r8.isPrimitive()
                java.lang.String r2 = "Array"
                if (r0 == 0) goto L_0x0099
                java.util.Map r0 = kotlin.jvm.internal.ClassReference.Z2
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto L_0x0099
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r8)
                r0.append(r2)
                java.lang.String r1 = r0.toString()
            L_0x0099:
                if (r1 != 0) goto L_0x00b1
                goto L_0x0040
            L_0x009c:
                java.util.Map r0 = kotlin.jvm.internal.ClassReference.Z2
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto L_0x00b1
                java.lang.String r1 = r8.getSimpleName()
            L_0x00b1:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.ClassReference.Companion.b(java.lang.Class):java.lang.String");
        }

        public final boolean c(@Nullable Object obj, @NotNull Class<?> cls) {
            Intrinsics.p(cls, "jClass");
            Map u = ClassReference.Y;
            Intrinsics.n(u, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) u.get(cls);
            if (num != null) {
                return TypeIntrinsics.B(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = JvmClassMappingKt.g(JvmClassMappingKt.i(cls));
            }
            return cls.isInstance(obj);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int i2 = 0;
        List L = CollectionsKt.L(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList = new ArrayList(CollectionsKt.Y(L, 10));
        for (Object next : L) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.W();
            }
            arrayList.add(TuplesKt.a((Class) next, Integer.valueOf(i2)));
            i2 = i3;
        }
        Y = MapsKt.B0(arrayList);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(TypedValues.Custom.f3953f, "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put(CSS.Value.f27480i, "kotlin.Double");
        Z = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        X2 = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        Intrinsics.o(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            Intrinsics.o(str, "kotlinName");
            sb.append(StringsKt.q5(str, ClassUtils.PACKAGE_SEPARATOR_CHAR, (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            Pair a2 = TuplesKt.a(sb2, str + ".Companion");
            hashMap3.put(a2.e(), a2.f());
        }
        for (Map.Entry next2 : Y.entrySet()) {
            int intValue = ((Number) next2.getValue()).intValue();
            String name = ((Class) next2.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        Y2 = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.j(hashMap3.size()));
        for (Map.Entry entry : hashMap3.entrySet()) {
            linkedHashMap.put(entry.getKey(), StringsKt.q5((String) entry.getValue(), ClassUtils.PACKAGE_SEPARATOR_CHAR, (String) null, 2, (Object) null));
        }
        Z2 = linkedHashMap;
    }

    public ClassReference(@NotNull Class<?> cls) {
        Intrinsics.p(cls, "jClass");
        this.s = cls;
    }

    private final Void C() {
        throw new KotlinReflectionNotSupportedError();
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void E() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void F() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void G() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void H() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void O() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void Q() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void T() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void V() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void X() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void Z() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void a0() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void b0() {
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void d0() {
    }

    @NotNull
    public List<KClass<? extends Object>> D() {
        C();
        throw new KotlinNothingValueException();
    }

    public boolean I() {
        C();
        throw new KotlinNothingValueException();
    }

    public boolean J() {
        C();
        throw new KotlinNothingValueException();
    }

    @Nullable
    public String K() {
        return X.b(o());
    }

    @NotNull
    public List<KType> M() {
        C();
        throw new KotlinNothingValueException();
    }

    @Nullable
    public Object P() {
        C();
        throw new KotlinNothingValueException();
    }

    public boolean U() {
        C();
        throw new KotlinNothingValueException();
    }

    public boolean W() {
        C();
        throw new KotlinNothingValueException();
    }

    @Nullable
    public KVisibility b() {
        C();
        throw new KotlinNothingValueException();
    }

    public boolean d() {
        C();
        throw new KotlinNothingValueException();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ClassReference) && Intrinsics.g(JvmClassMappingKt.g(this), JvmClassMappingKt.g((KClass) obj));
    }

    @NotNull
    public List<Annotation> getAnnotations() {
        C();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public List<KTypeParameter> h() {
        C();
        throw new KotlinNothingValueException();
    }

    public int hashCode() {
        return JvmClassMappingKt.g(this).hashCode();
    }

    public boolean i() {
        C();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.1")
    public boolean i0(@Nullable Object obj) {
        return X.c(obj, o());
    }

    public boolean isOpen() {
        C();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public Collection<KCallable<?>> l() {
        C();
        throw new KotlinNothingValueException();
    }

    @Nullable
    public String m() {
        return X.a(o());
    }

    @NotNull
    public Class<?> o() {
        return this.s;
    }

    @NotNull
    public Collection<KClass<?>> p() {
        C();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public String toString() {
        return o().toString() + " (Kotlin reflection is not available)";
    }

    public boolean v0() {
        C();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public Collection<KFunction<Object>> w() {
        C();
        throw new KotlinNothingValueException();
    }

    public boolean y() {
        C();
        throw new KotlinNothingValueException();
    }
}
