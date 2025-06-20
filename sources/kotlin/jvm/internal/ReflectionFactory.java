package kotlin.jvm.internal;

import java.util.List;
import kotlin.SinceKotlin;
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

public class ReflectionFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final String f28963a = "kotlin.jvm.functions.";

    public KClass a(Class cls) {
        return new ClassReference(cls);
    }

    public KClass b(Class cls, String str) {
        return new ClassReference(cls);
    }

    public KFunction c(FunctionReference functionReference) {
        return functionReference;
    }

    public KClass d(Class cls) {
        return new ClassReference(cls);
    }

    public KClass e(Class cls, String str) {
        return new ClassReference(cls);
    }

    public KDeclarationContainer f(Class cls, String str) {
        return new PackageReference(cls, str);
    }

    @SinceKotlin(version = "1.6")
    public KType g(KType kType) {
        TypeReference typeReference = (TypeReference) kType;
        return new TypeReference(kType.f0(), kType.c0(), typeReference.C(), typeReference.u() | 2);
    }

    public KMutableProperty0 h(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public KMutableProperty1 i(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public KMutableProperty2 j(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    @SinceKotlin(version = "1.6")
    public KType k(KType kType) {
        TypeReference typeReference = (TypeReference) kType;
        return new TypeReference(kType.f0(), kType.c0(), typeReference.C(), typeReference.u() | 4);
    }

    @SinceKotlin(version = "1.6")
    public KType l(KType kType, KType kType2) {
        return new TypeReference(kType.f0(), kType.c0(), kType2, ((TypeReference) kType).u());
    }

    public KProperty0 m(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public KProperty1 n(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public KProperty2 o(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    @SinceKotlin(version = "1.3")
    public String p(FunctionBase functionBase) {
        String obj = functionBase.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith(f28963a) ? obj.substring(21) : obj;
    }

    @SinceKotlin(version = "1.1")
    public String q(Lambda lambda) {
        return p(lambda);
    }

    @SinceKotlin(version = "1.4")
    public void r(KTypeParameter kTypeParameter, List<KType> list) {
        ((TypeParameterReference) kTypeParameter).c(list);
    }

    @SinceKotlin(version = "1.4")
    public KType s(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        return new TypeReference(kClassifier, list, z);
    }

    @SinceKotlin(version = "1.4")
    public KTypeParameter t(Object obj, String str, KVariance kVariance, boolean z) {
        return new TypeParameterReference(obj, str, kVariance, z);
    }
}
