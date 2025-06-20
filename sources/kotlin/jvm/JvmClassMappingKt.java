package kotlin.jvm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.itextpdf.tool.xml.css.CSS;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u0010\n\u0002\b\u0007\u001a!\u0010\u0004\u001a\u00020\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005\"-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00068G¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\"-\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\t\"+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t\"+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00078G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\";\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068Ç\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0017\u0010\t\"'\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0019*\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\";\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u000e\b\u0000\u0010\u001e*\b\u0012\u0004\u0012\u00028\u00000\u001d*\b\u0012\u0004\u0012\u00028\u00000\u001d8Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"", "T", "", "", "l", "([Ljava/lang/Object;)Z", "Lkotlin/reflect/KClass;", "Ljava/lang/Class;", "e", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "f", "(Lkotlin/reflect/KClass;)V", "java", "h", "javaPrimitiveType", "g", "javaObjectType", "i", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "kotlin", "d", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass", "j", "k", "", "a", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "annotationClass", "", "E", "b", "(Ljava/lang/Enum;)Ljava/lang/Class;", "c", "(Ljava/lang/Enum;)V", "declaringJavaClass", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "JvmClassMappingKt")
public final class JvmClassMappingKt {
    @NotNull
    public static final <T extends Annotation> KClass<? extends T> a(@NotNull T t) {
        Intrinsics.p(t, "<this>");
        Class<? extends Annotation> annotationType = t.annotationType();
        Intrinsics.o(annotationType, "this as java.lang.annota…otation).annotationType()");
        KClass<? extends T> i2 = i(annotationType);
        Intrinsics.n(i2, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return i2;
    }

    private static final <E extends Enum<E>> Class<E> b(Enum<E> enumR) {
        Intrinsics.p(enumR, "<this>");
        Class<E> declaringClass = enumR.getDeclaringClass();
        Intrinsics.o(declaringClass, "this as java.lang.Enum<E>).declaringClass");
        return declaringClass;
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    public static /* synthetic */ void c(Enum enumR) {
    }

    @NotNull
    public static final <T> Class<T> d(@NotNull T t) {
        Intrinsics.p(t, "<this>");
        Class<?> cls = t.getClass();
        Intrinsics.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return cls;
    }

    @NotNull
    @JvmName(name = "getJavaClass")
    public static final <T> Class<T> e(@NotNull KClass<T> kClass) {
        Intrinsics.p(kClass, "<this>");
        Class<?> o = ((ClassBasedDeclarationContainer) kClass).o();
        Intrinsics.n(o, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return o;
    }

    public static /* synthetic */ void f(KClass kClass) {
    }

    @NotNull
    public static final <T> Class<T> g(@NotNull KClass<T> kClass) {
        Intrinsics.p(kClass, "<this>");
        Class o = ((ClassBasedDeclarationContainer) kClass).o();
        if (!o.isPrimitive()) {
            Intrinsics.n(o, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return o;
        }
        String name = o.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals(CSS.Value.f27480i)) {
                    o = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    o = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    o = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    o = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    o = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    o = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals(TypedValues.Custom.f3953f)) {
                    o = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    o = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    o = Short.class;
                    break;
                }
                break;
        }
        Intrinsics.n(o, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return o;
    }

    @Nullable
    public static final <T> Class<T> h(@NotNull KClass<T> kClass) {
        Intrinsics.p(kClass, "<this>");
        Class<?> o = ((ClassBasedDeclarationContainer) kClass).o();
        if (o.isPrimitive()) {
            Intrinsics.n(o, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return o;
        }
        String name = o.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                break;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                break;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                break;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                break;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                break;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                break;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                break;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                break;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                break;
        }
        return null;
    }

    @NotNull
    @JvmName(name = "getKotlinClass")
    public static final <T> KClass<T> i(@NotNull Class<T> cls) {
        Intrinsics.p(cls, "<this>");
        return Reflection.d(cls);
    }

    @NotNull
    @JvmName(name = "getRuntimeClassOfKClassInstance")
    public static final <T> Class<KClass<T>> j(@NotNull KClass<T> kClass) {
        Intrinsics.p(kClass, "<this>");
        Class<?> cls = kClass.getClass();
        Intrinsics.n(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return cls;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void k(KClass kClass) {
    }

    public static final /* synthetic */ boolean l(Object[] objArr) {
        Intrinsics.p(objArr, "<this>");
        Intrinsics.y(4, ExifInterface.d5);
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }
}
