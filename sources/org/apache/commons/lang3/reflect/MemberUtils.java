package org.apache.commons.lang3.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;

abstract class MemberUtils {
    private static final int ACCESS_TEST = 7;
    private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    MemberUtils() {
    }

    static int compareParameterTypes(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        float totalTransformationCost = getTotalTransformationCost(clsArr3, clsArr);
        float totalTransformationCost2 = getTotalTransformationCost(clsArr3, clsArr2);
        if (totalTransformationCost < totalTransformationCost2) {
            return -1;
        }
        return totalTransformationCost2 < totalTransformationCost ? 1 : 0;
    }

    private static float getObjectTransformationCost(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return getPrimitivePromotionCost(cls, cls2);
        }
        float f2 = 0.0f;
        Class<? super Object> cls3 = cls;
        while (true) {
            if (cls3 != null && !cls2.equals(cls3)) {
                if (cls2.isInterface() && ClassUtils.isAssignable(cls3, cls2)) {
                    f2 += 0.25f;
                    break;
                }
                f2 += 1.0f;
                cls3 = cls3.getSuperclass();
            } else {
                break;
            }
        }
        return cls3 == null ? f2 + 1.5f : f2;
    }

    private static float getPrimitivePromotionCost(Class<?> cls, Class<?> cls2) {
        float f2;
        if (!cls.isPrimitive()) {
            cls = ClassUtils.wrapperToPrimitive(cls);
            f2 = 0.1f;
        } else {
            f2 = 0.0f;
        }
        int i2 = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = ORDERED_PRIMITIVE_TYPES;
            if (i2 >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i2]) {
                f2 += 0.1f;
                if (i2 < clsArr.length - 1) {
                    cls = clsArr[i2 + 1];
                }
            }
            i2++;
        }
        return f2;
    }

    private static float getTotalTransformationCost(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f2 = 0.0f;
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            f2 += getObjectTransformationCost(clsArr[i2], clsArr2[i2]);
        }
        return f2;
    }

    static boolean isAccessible(Member member) {
        return member != null && Modifier.isPublic(member.getModifiers()) && !member.isSynthetic();
    }

    static boolean isPackageAccess(int i2) {
        return (i2 & 7) == 0;
    }

    static boolean setAccessibleWorkaround(AccessibleObject accessibleObject) {
        if (accessibleObject != null && !accessibleObject.isAccessible()) {
            Member member = (Member) accessibleObject;
            if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && isPackageAccess(member.getDeclaringClass().getModifiers())) {
                try {
                    accessibleObject.setAccessible(true);
                    return true;
                } catch (SecurityException unused) {
                }
            }
        }
        return false;
    }
}
