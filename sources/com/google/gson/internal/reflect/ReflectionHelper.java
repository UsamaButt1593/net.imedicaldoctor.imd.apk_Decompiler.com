package com.google.gson.internal.reflect;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionHelper {
    private static final RecordHelper RECORD_HELPER;

    private static abstract class RecordHelper {
        private RecordHelper() {
        }

        public abstract Method getAccessor(Class<?> cls, Field field);

        /* access modifiers changed from: package-private */
        public abstract <T> Constructor<T> getCanonicalRecordConstructor(Class<T> cls);

        /* access modifiers changed from: package-private */
        public abstract String[] getRecordComponentNames(Class<?> cls);

        /* access modifiers changed from: package-private */
        public abstract boolean isRecord(Class<?> cls);
    }

    private static class RecordNotSupportedHelper extends RecordHelper {
        private RecordNotSupportedHelper() {
            super();
        }

        public Method getAccessor(Class<?> cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public <T> Constructor<T> getCanonicalRecordConstructor(Class<T> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public String[] getRecordComponentNames(Class<?> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public boolean isRecord(Class<?> cls) {
            return false;
        }
    }

    private static class RecordSupportedHelper extends RecordHelper {
        private final Method getName;
        private final Method getRecordComponents;
        private final Method getType;
        private final Method isRecord;

        private RecordSupportedHelper() throws NoSuchMethodException {
            super();
            Class<Class> cls = Class.class;
            this.isRecord = cls.getMethod("isRecord", (Class[]) null);
            Method method = cls.getMethod("getRecordComponents", (Class[]) null);
            this.getRecordComponents = method;
            Class<?> componentType = method.getReturnType().getComponentType();
            this.getName = componentType.getMethod("getName", (Class[]) null);
            this.getType = componentType.getMethod("getType", (Class[]) null);
        }

        public Method getAccessor(Class<?> cls, Field field) {
            try {
                return cls.getMethod(field.getName(), (Class[]) null);
            } catch (ReflectiveOperationException e2) {
                throw ReflectionHelper.createExceptionForRecordReflectionException(e2);
            }
        }

        public <T> Constructor<T> getCanonicalRecordConstructor(Class<T> cls) {
            try {
                Object[] objArr = (Object[]) this.getRecordComponents.invoke(cls, (Object[]) null);
                Class[] clsArr = new Class[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    clsArr[i2] = (Class) this.getType.invoke(objArr[i2], (Object[]) null);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e2) {
                throw ReflectionHelper.createExceptionForRecordReflectionException(e2);
            }
        }

        /* access modifiers changed from: package-private */
        public String[] getRecordComponentNames(Class<?> cls) {
            try {
                Object[] objArr = (Object[]) this.getRecordComponents.invoke(cls, (Object[]) null);
                String[] strArr = new String[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    strArr[i2] = (String) this.getName.invoke(objArr[i2], (Object[]) null);
                }
                return strArr;
            } catch (ReflectiveOperationException e2) {
                throw ReflectionHelper.createExceptionForRecordReflectionException(e2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isRecord(Class<?> cls) {
            try {
                return ((Boolean) this.isRecord.invoke(cls, (Object[]) null)).booleanValue();
            } catch (ReflectiveOperationException e2) {
                throw ReflectionHelper.createExceptionForRecordReflectionException(e2);
            }
        }
    }

    static {
        RecordHelper recordHelper;
        try {
            recordHelper = new RecordSupportedHelper();
        } catch (NoSuchMethodException unused) {
            recordHelper = new RecordNotSupportedHelper();
        }
        RECORD_HELPER = recordHelper;
    }

    private ReflectionHelper() {
    }

    private static void appendExecutableParameters(AccessibleObject accessibleObject, StringBuilder sb) {
        sb.append(ASCIIPropertyListParser.f18649g);
        Class[] parameterTypes = accessibleObject instanceof Method ? ((Method) accessibleObject).getParameterTypes() : ((Constructor) accessibleObject).getParameterTypes();
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i2].getSimpleName());
        }
        sb.append(ASCIIPropertyListParser.f18650h);
    }

    public static String constructorToString(Constructor<?> constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        appendExecutableParameters(constructor, sb);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static RuntimeException createExceptionForRecordReflectionException(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException createExceptionForUnexpectedIllegalAccess(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String fieldToString(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAccessibleObjectDescription(java.lang.reflect.AccessibleObject r4, boolean r5) {
        /*
            boolean r0 = r4 instanceof java.lang.reflect.Field
            java.lang.String r1 = "'"
            if (r0 == 0) goto L_0x0021
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "field '"
            r0.append(r2)
            java.lang.reflect.Field r4 = (java.lang.reflect.Field) r4
            java.lang.String r4 = fieldToString(r4)
        L_0x0016:
            r0.append(r4)
            r0.append(r1)
        L_0x001c:
            java.lang.String r4 = r0.toString()
            goto L_0x0083
        L_0x0021:
            boolean r0 = r4 instanceof java.lang.reflect.Method
            if (r0 == 0) goto L_0x005c
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = r4.getName()
            r0.<init>(r2)
            appendExecutableParameters(r4, r0)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "method '"
            r2.append(r3)
            java.lang.Class r4 = r4.getDeclaringClass()
            java.lang.String r4 = r4.getName()
            r2.append(r4)
            java.lang.String r4 = "#"
            r2.append(r4)
            r2.append(r0)
            r2.append(r1)
            java.lang.String r4 = r2.toString()
            goto L_0x0083
        L_0x005c:
            boolean r0 = r4 instanceof java.lang.reflect.Constructor
            if (r0 == 0) goto L_0x0071
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "constructor '"
            r0.append(r2)
            java.lang.reflect.Constructor r4 = (java.lang.reflect.Constructor) r4
            java.lang.String r4 = constructorToString(r4)
            goto L_0x0016
        L_0x0071:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "<unknown AccessibleObject> "
            r0.append(r1)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            goto L_0x001c
        L_0x0083:
            if (r5 == 0) goto L_0x00ac
            r5 = 0
            char r0 = r4.charAt(r5)
            boolean r0 = java.lang.Character.isLowerCase(r0)
            if (r0 == 0) goto L_0x00ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r5 = r4.charAt(r5)
            char r5 = java.lang.Character.toUpperCase(r5)
            r0.append(r5)
            r5 = 1
            java.lang.String r4 = r4.substring(r5)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
        L_0x00ac:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.reflect.ReflectionHelper.getAccessibleObjectDescription(java.lang.reflect.AccessibleObject, boolean):java.lang.String");
    }

    public static Method getAccessor(Class<?> cls, Field field) {
        return RECORD_HELPER.getAccessor(cls, field);
    }

    public static <T> Constructor<T> getCanonicalRecordConstructor(Class<T> cls) {
        return RECORD_HELPER.getCanonicalRecordConstructor(cls);
    }

    public static String[] getRecordComponentNames(Class<?> cls) {
        return RECORD_HELPER.getRecordComponentNames(cls);
    }

    public static boolean isRecord(Class<?> cls) {
        return RECORD_HELPER.isRecord(cls);
    }

    public static void makeAccessible(AccessibleObject accessibleObject) throws JsonIOException {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e2) {
            String accessibleObjectDescription = getAccessibleObjectDescription(accessibleObject, false);
            throw new JsonIOException("Failed making " + accessibleObjectDescription + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e2);
        }
    }

    public static String tryMakeAccessible(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e2) {
            return "Failed making constructor '" + constructorToString(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e2.getMessage();
        }
    }
}
