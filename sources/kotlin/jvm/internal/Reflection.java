package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

public class Reflection {

    /* renamed from: a  reason: collision with root package name */
    private static final ReflectionFactory f28960a;

    /* renamed from: b  reason: collision with root package name */
    static final String f28961b = " (Kotlin reflection is not available)";

    /* renamed from: c  reason: collision with root package name */
    private static final KClass[] f28962c = new KClass[0];

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        f28960a = reflectionFactory;
    }

    @SinceKotlin(version = "1.4")
    public static KType A(Class cls) {
        return f28960a.s(d(cls), Collections.emptyList(), false);
    }

    @SinceKotlin(version = "1.4")
    public static KType B(Class cls, KTypeProjection kTypeProjection) {
        return f28960a.s(d(cls), Collections.singletonList(kTypeProjection), false);
    }

    @SinceKotlin(version = "1.4")
    public static KType C(Class cls, KTypeProjection kTypeProjection, KTypeProjection kTypeProjection2) {
        return f28960a.s(d(cls), Arrays.asList(new KTypeProjection[]{kTypeProjection, kTypeProjection2}), false);
    }

    @SinceKotlin(version = "1.4")
    public static KType D(Class cls, KTypeProjection... kTypeProjectionArr) {
        return f28960a.s(d(cls), ArraysKt.Ky(kTypeProjectionArr), false);
    }

    @SinceKotlin(version = "1.4")
    public static KType E(KClassifier kClassifier) {
        return f28960a.s(kClassifier, Collections.emptyList(), false);
    }

    @SinceKotlin(version = "1.4")
    public static KTypeParameter F(Object obj, String str, KVariance kVariance, boolean z) {
        return f28960a.t(obj, str, kVariance, z);
    }

    public static KClass a(Class cls) {
        return f28960a.a(cls);
    }

    public static KClass b(Class cls, String str) {
        return f28960a.b(cls, str);
    }

    public static KFunction c(FunctionReference functionReference) {
        return f28960a.c(functionReference);
    }

    public static KClass d(Class cls) {
        return f28960a.d(cls);
    }

    public static KClass e(Class cls, String str) {
        return f28960a.e(cls, str);
    }

    public static KClass[] f(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f28962c;
        }
        KClass[] kClassArr = new KClass[length];
        for (int i2 = 0; i2 < length; i2++) {
            kClassArr[i2] = d(clsArr[i2]);
        }
        return kClassArr;
    }

    @SinceKotlin(version = "1.4")
    public static KDeclarationContainer g(Class cls) {
        return f28960a.f(cls, "");
    }

    public static KDeclarationContainer h(Class cls, String str) {
        return f28960a.f(cls, str);
    }

    @SinceKotlin(version = "1.6")
    public static KType i(KType kType) {
        return f28960a.g(kType);
    }

    public static KMutableProperty0 j(MutablePropertyReference0 mutablePropertyReference0) {
        return f28960a.h(mutablePropertyReference0);
    }

    public static KMutableProperty1 k(MutablePropertyReference1 mutablePropertyReference1) {
        return f28960a.i(mutablePropertyReference1);
    }

    public static KMutableProperty2 l(MutablePropertyReference2 mutablePropertyReference2) {
        return f28960a.j(mutablePropertyReference2);
    }

    @SinceKotlin(version = "1.6")
    public static KType m(KType kType) {
        return f28960a.k(kType);
    }

    @SinceKotlin(version = "1.4")
    public static KType n(Class cls) {
        return f28960a.s(d(cls), Collections.emptyList(), true);
    }

    @SinceKotlin(version = "1.4")
    public static KType o(Class cls, KTypeProjection kTypeProjection) {
        return f28960a.s(d(cls), Collections.singletonList(kTypeProjection), true);
    }

    @SinceKotlin(version = "1.4")
    public static KType p(Class cls, KTypeProjection kTypeProjection, KTypeProjection kTypeProjection2) {
        return f28960a.s(d(cls), Arrays.asList(new KTypeProjection[]{kTypeProjection, kTypeProjection2}), true);
    }

    @SinceKotlin(version = "1.4")
    public static KType q(Class cls, KTypeProjection... kTypeProjectionArr) {
        return f28960a.s(d(cls), ArraysKt.Ky(kTypeProjectionArr), true);
    }

    @SinceKotlin(version = "1.4")
    public static KType r(KClassifier kClassifier) {
        return f28960a.s(kClassifier, Collections.emptyList(), true);
    }

    @SinceKotlin(version = "1.6")
    public static KType s(KType kType, KType kType2) {
        return f28960a.l(kType, kType2);
    }

    public static KProperty0 t(PropertyReference0 propertyReference0) {
        return f28960a.m(propertyReference0);
    }

    public static KProperty1 u(PropertyReference1 propertyReference1) {
        return f28960a.n(propertyReference1);
    }

    public static KProperty2 v(PropertyReference2 propertyReference2) {
        return f28960a.o(propertyReference2);
    }

    @SinceKotlin(version = "1.3")
    public static String w(FunctionBase functionBase) {
        return f28960a.p(functionBase);
    }

    @SinceKotlin(version = "1.1")
    public static String x(Lambda lambda) {
        return f28960a.q(lambda);
    }

    @SinceKotlin(version = "1.4")
    public static void y(KTypeParameter kTypeParameter, KType kType) {
        f28960a.r(kTypeParameter, Collections.singletonList(kType));
    }

    @SinceKotlin(version = "1.4")
    public static void z(KTypeParameter kTypeParameter, KType... kTypeArr) {
        f28960a.r(kTypeParameter, ArraysKt.Ky(kTypeArr));
    }
}
