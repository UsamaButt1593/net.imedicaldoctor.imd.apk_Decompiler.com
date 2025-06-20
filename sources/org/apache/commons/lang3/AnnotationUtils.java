package org.apache.commons.lang3;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AnnotationUtils {
    private static final ToStringStyle TO_STRING_STYLE = new ToStringStyle() {
        private static final long serialVersionUID = 1;

        {
            setDefaultFullDetail(true);
            setArrayContentDetail(true);
            setUseClassName(true);
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
            setContentStart("(");
            setContentEnd(")");
            setFieldSeparator(", ");
            setArrayStart("[");
            setArrayEnd("]");
        }

        /* access modifiers changed from: protected */
        public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
            if (obj instanceof Annotation) {
                obj = AnnotationUtils.toString((Annotation) obj);
            }
            super.appendDetail(stringBuffer, str, obj);
        }

        /* access modifiers changed from: protected */
        public String getShortClassName(Class<?> cls) {
            Class cls2;
            Iterator<Class<?>> it2 = ClassUtils.getAllInterfaces(cls).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    cls2 = null;
                    break;
                }
                cls2 = it2.next();
                if (Annotation.class.isAssignableFrom(cls2)) {
                    break;
                }
            }
            return new StringBuilder(cls2 == null ? "" : cls2.getName()).insert(0, '@').toString();
        }
    };

    private static boolean annotationArrayMemberEquals(Annotation[] annotationArr, Annotation[] annotationArr2) {
        if (annotationArr.length != annotationArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < annotationArr.length; i2++) {
            if (!equals(annotationArr[i2], annotationArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private static boolean arrayMemberEquals(Class<?> cls, Object obj, Object obj2) {
        return cls.isAnnotation() ? annotationArrayMemberEquals((Annotation[]) obj, (Annotation[]) obj2) : cls.equals(Byte.TYPE) ? Arrays.equals((byte[]) obj, (byte[]) obj2) : cls.equals(Short.TYPE) ? Arrays.equals((short[]) obj, (short[]) obj2) : cls.equals(Integer.TYPE) ? Arrays.equals((int[]) obj, (int[]) obj2) : cls.equals(Character.TYPE) ? Arrays.equals((char[]) obj, (char[]) obj2) : cls.equals(Long.TYPE) ? Arrays.equals((long[]) obj, (long[]) obj2) : cls.equals(Float.TYPE) ? Arrays.equals((float[]) obj, (float[]) obj2) : cls.equals(Double.TYPE) ? Arrays.equals((double[]) obj, (double[]) obj2) : cls.equals(Boolean.TYPE) ? Arrays.equals((boolean[]) obj, (boolean[]) obj2) : Arrays.equals((Object[]) obj, (Object[]) obj2);
    }

    private static int arrayMemberHash(Class<?> cls, Object obj) {
        return cls.equals(Byte.TYPE) ? Arrays.hashCode((byte[]) obj) : cls.equals(Short.TYPE) ? Arrays.hashCode((short[]) obj) : cls.equals(Integer.TYPE) ? Arrays.hashCode((int[]) obj) : cls.equals(Character.TYPE) ? Arrays.hashCode((char[]) obj) : cls.equals(Long.TYPE) ? Arrays.hashCode((long[]) obj) : cls.equals(Float.TYPE) ? Arrays.hashCode((float[]) obj) : cls.equals(Double.TYPE) ? Arrays.hashCode((double[]) obj) : cls.equals(Boolean.TYPE) ? Arrays.hashCode((boolean[]) obj) : Arrays.hashCode((Object[]) obj);
    }

    public static boolean equals(Annotation annotation, Annotation annotation2) {
        if (annotation == annotation2) {
            return true;
        }
        if (!(annotation == null || annotation2 == null)) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            Class<? extends Annotation> annotationType2 = annotation2.annotationType();
            Validate.notNull(annotationType, "Annotation %s with null annotationType()", annotation);
            Validate.notNull(annotationType2, "Annotation %s with null annotationType()", annotation2);
            if (!annotationType.equals(annotationType2)) {
                return false;
            }
            try {
                for (Method method : annotationType.getDeclaredMethods()) {
                    if (method.getParameterTypes().length == 0 && isValidAnnotationMemberType(method.getReturnType())) {
                        if (!memberEquals(method.getReturnType(), method.invoke(annotation, (Object[]) null), method.invoke(annotation2, (Object[]) null))) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return false;
    }

    public static int hashCode(Annotation annotation) {
        Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
        int length = declaredMethods.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Method method = declaredMethods[i2];
            try {
                Object invoke = method.invoke(annotation, (Object[]) null);
                if (invoke != null) {
                    i3 += hashMember(method.getName(), invoke);
                    i2++;
                } else {
                    throw new IllegalStateException(String.format("Annotation method %s returned null", new Object[]{method}));
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }
        return i3;
    }

    private static int hashMember(String str, Object obj) {
        return (str.hashCode() * WorkQueueKt.f29430c) ^ (obj.getClass().isArray() ? arrayMemberHash(obj.getClass().getComponentType(), obj) : obj instanceof Annotation ? hashCode((Annotation) obj) : obj.hashCode());
    }

    public static boolean isValidAnnotationMemberType(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        return cls.isPrimitive() || cls.isEnum() || cls.isAnnotation() || String.class.equals(cls) || Class.class.equals(cls);
    }

    private static boolean memberEquals(Class<?> cls, Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return cls.isArray() ? arrayMemberEquals(cls.getComponentType(), obj, obj2) : cls.isAnnotation() ? equals((Annotation) obj, (Annotation) obj2) : obj.equals(obj2);
    }

    public static String toString(Annotation annotation) {
        ToStringBuilder toStringBuilder = new ToStringBuilder(annotation, TO_STRING_STYLE);
        for (Method method : annotation.annotationType().getDeclaredMethods()) {
            if (method.getParameterTypes().length <= 0) {
                try {
                    toStringBuilder.append(method.getName(), method.invoke(annotation, (Object[]) null));
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
        }
        return toStringBuilder.build();
    }
}
