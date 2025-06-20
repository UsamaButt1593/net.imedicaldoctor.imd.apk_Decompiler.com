package kotlin.reflect;

import com.itextpdf.xmp.XMPConst;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@SourceDebugExtension({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,230:1\n1#2:231\n1549#3:232\n1620#3,3:233\n1549#3:236\n1620#3,3:237\n1549#3:240\n1620#3,3:241\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n*L\n69#1:232\n69#1:233,3\n71#1:236\n71#1:237,3\n77#1:240\n77#1:241,3\n*E\n"})
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\u000b\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"\u001e\u0010\u0015\u001a\u00020\u0003*\u00020\u00008FX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\"\u001e\u0010\u0015\u001a\u00020\u0003*\u00020\t8BX\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lkotlin/reflect/KType;", "", "forceWrapper", "Ljava/lang/reflect/Type;", "c", "(Lkotlin/reflect/KType;Z)Ljava/lang/reflect/Type;", "Ljava/lang/Class;", "jClass", "", "Lkotlin/reflect/KTypeProjection;", "arguments", "e", "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Type;", "type", "", "j", "(Ljava/lang/reflect/Type;)Ljava/lang/String;", "f", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "h", "(Lkotlin/reflect/KType;)V", "javaType", "g", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "i", "(Lkotlin/reflect/KTypeProjection;)V", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class TypesJVMKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28993a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.reflect.KVariance[] r0 = kotlin.reflect.KVariance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.IN     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.INVARIANT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.OUT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f28993a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.TypesJVMKt.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    @ExperimentalStdlibApi
    public static final Type c(KType kType, boolean z) {
        KClassifier f0 = kType.f0();
        if (f0 instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter) f0);
        }
        if (f0 instanceof KClass) {
            KClass kClass = (KClass) f0;
            Class g2 = z ? JvmClassMappingKt.g(kClass) : JvmClassMappingKt.e(kClass);
            List<KTypeProjection> c0 = kType.c0();
            if (c0.isEmpty()) {
                return g2;
            }
            if (!g2.isArray()) {
                return e(g2, c0);
            }
            if (g2.getComponentType().isPrimitive()) {
                return g2;
            }
            KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.h5(c0);
            if (kTypeProjection != null) {
                KVariance a2 = kTypeProjection.a();
                KType b2 = kTypeProjection.b();
                int i2 = a2 == null ? -1 : WhenMappings.f28993a[a2.ordinal()];
                if (i2 == -1 || i2 == 1) {
                    return g2;
                }
                if (i2 == 2 || i2 == 3) {
                    Intrinsics.m(b2);
                    Type d2 = d(b2, false, 1, (Object) null);
                    return d2 instanceof Class ? g2 : new GenericArrayTypeImpl(d2);
                }
                throw new NoWhenBranchMatchedException();
            }
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
    }

    static /* synthetic */ Type d(KType kType, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return c(kType, z);
    }

    @ExperimentalStdlibApi
    private static final Type e(Class<?> cls, List<KTypeProjection> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.Y(list, 10));
            for (KTypeProjection g2 : list) {
                arrayList.add(g(g2));
            }
            return new ParameterizedTypeImpl(cls, (Type) null, arrayList);
        } else if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.Y(list, 10));
            for (KTypeProjection g3 : list) {
                arrayList2.add(g(g3));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        } else {
            int length = cls.getTypeParameters().length;
            Type e2 = e(declaringClass, list.subList(length, list.size()));
            List<KTypeProjection> subList = list.subList(0, length);
            ArrayList arrayList3 = new ArrayList(CollectionsKt.Y(subList, 10));
            for (KTypeProjection g4 : subList) {
                arrayList3.add(g(g4));
            }
            return new ParameterizedTypeImpl(cls, e2, arrayList3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = ((kotlin.jvm.internal.KTypeBase) r3).R();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.reflect.Type f(@org.jetbrains.annotations.NotNull kotlin.reflect.KType r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            boolean r0 = r3 instanceof kotlin.jvm.internal.KTypeBase
            if (r0 == 0) goto L_0x0013
            r0 = r3
            kotlin.jvm.internal.KTypeBase r0 = (kotlin.jvm.internal.KTypeBase) r0
            java.lang.reflect.Type r0 = r0.R()
            if (r0 == 0) goto L_0x0013
            return r0
        L_0x0013:
            r0 = 1
            r1 = 0
            r2 = 0
            java.lang.reflect.Type r3 = d(r3, r2, r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.TypesJVMKt.f(kotlin.reflect.KType):java.lang.reflect.Type");
    }

    private static final Type g(KTypeProjection kTypeProjection) {
        KVariance h2 = kTypeProjection.h();
        if (h2 == null) {
            return WildcardTypeImpl.Y.a();
        }
        KType g2 = kTypeProjection.g();
        Intrinsics.m(g2);
        int i2 = WhenMappings.f28993a[h2.ordinal()];
        if (i2 == 1) {
            return new WildcardTypeImpl((Type) null, c(g2, true));
        }
        if (i2 == 2) {
            return c(g2, true);
        }
        if (i2 == 3) {
            return new WildcardTypeImpl(c(g2, true), (Type) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    @LowPriorityInOverloadResolution
    public static /* synthetic */ void h(KType kType) {
    }

    @ExperimentalStdlibApi
    private static /* synthetic */ void i(KTypeProjection kTypeProjection) {
    }

    /* access modifiers changed from: private */
    public static final String j(Type type) {
        String str;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            Sequence l2 = SequencesKt.l(type, TypesJVMKt$typeToString$unwrap$1.c3);
            str = ((Class) SequencesKt.f1(l2)).getName() + StringsKt.e2(XMPConst.o2, SequencesKt.g0(l2));
        } else {
            str = cls.getName();
        }
        Intrinsics.o(str, "{\n        if (type.isArr…   } else type.name\n    }");
        return str;
    }
}
