package org.apache.commons.lang3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.tool.xml.css.CSS;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SerializationUtils {

    static class ClassLoaderAwareObjectInputStream extends ObjectInputStream {
        private static final Map<String, Class<?>> primitiveTypes = new HashMap();
        private final ClassLoader classLoader;

        public ClassLoaderAwareObjectInputStream(InputStream inputStream, ClassLoader classLoader2) throws IOException {
            super(inputStream);
            this.classLoader = classLoader2;
            Map<String, Class<?>> map = primitiveTypes;
            map.put("byte", Byte.TYPE);
            map.put("short", Short.TYPE);
            map.put("int", Integer.TYPE);
            map.put("long", Long.TYPE);
            map.put("float", Float.TYPE);
            map.put(CSS.Value.f27480i, Double.TYPE);
            map.put(TypedValues.Custom.f3953f, Boolean.TYPE);
            map.put("char", Character.TYPE);
            map.put("void", Void.TYPE);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
            return r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
            return java.lang.Class.forName(r3, false, java.lang.Thread.currentThread().getContextClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
            r3 = primitiveTypes.get(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
            if (r3 != null) goto L_0x0024;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Class<?> resolveClass(java.io.ObjectStreamClass r3) throws java.io.IOException, java.lang.ClassNotFoundException {
            /*
                r2 = this;
                java.lang.String r3 = r3.getName()
                r0 = 0
                java.lang.ClassLoader r1 = r2.classLoader     // Catch:{ ClassNotFoundException -> 0x000c }
                java.lang.Class r3 = java.lang.Class.forName(r3, r0, r1)     // Catch:{ ClassNotFoundException -> 0x000c }
                return r3
            L_0x000c:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ ClassNotFoundException -> 0x0019 }
                java.lang.ClassLoader r1 = r1.getContextClassLoader()     // Catch:{ ClassNotFoundException -> 0x0019 }
                java.lang.Class r3 = java.lang.Class.forName(r3, r0, r1)     // Catch:{ ClassNotFoundException -> 0x0019 }
                return r3
            L_0x0019:
                r0 = move-exception
                java.util.Map<java.lang.String, java.lang.Class<?>> r1 = primitiveTypes
                java.lang.Object r3 = r1.get(r3)
                java.lang.Class r3 = (java.lang.Class) r3
                if (r3 == 0) goto L_0x0025
                return r3
            L_0x0025:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.SerializationUtils.ClassLoaderAwareObjectInputStream.resolveClass(java.io.ObjectStreamClass):java.lang.Class");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x004e A[SYNTHETIC, Splitter:B:29:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends java.io.Serializable> T clone(T r4) {
        /*
            java.lang.String r0 = "IOException on closing cloned object data InputStream."
            r1 = 0
            if (r4 != 0) goto L_0x0006
            return r1
        L_0x0006:
            byte[] r2 = serialize(r4)
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            r3.<init>(r2)
            org.apache.commons.lang3.SerializationUtils$ClassLoaderAwareObjectInputStream r2 = new org.apache.commons.lang3.SerializationUtils$ClassLoaderAwareObjectInputStream     // Catch:{ ClassNotFoundException -> 0x003a, IOException -> 0x0038 }
            java.lang.Class r4 = r4.getClass()     // Catch:{ ClassNotFoundException -> 0x003a, IOException -> 0x0038 }
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x003a, IOException -> 0x0038 }
            r2.<init>(r3, r4)     // Catch:{ ClassNotFoundException -> 0x003a, IOException -> 0x0038 }
            java.lang.Object r4 = r2.readObject()     // Catch:{ ClassNotFoundException -> 0x0033, IOException -> 0x0030, all -> 0x002d }
            java.io.Serializable r4 = (java.io.Serializable) r4     // Catch:{ ClassNotFoundException -> 0x0033, IOException -> 0x0030, all -> 0x002d }
            r2.close()     // Catch:{ IOException -> 0x0026 }
            return r4
        L_0x0026:
            r4 = move-exception
            org.apache.commons.lang3.SerializationException r1 = new org.apache.commons.lang3.SerializationException
            r1.<init>(r0, r4)
            throw r1
        L_0x002d:
            r4 = move-exception
            r1 = r2
            goto L_0x004c
        L_0x0030:
            r4 = move-exception
            r1 = r2
            goto L_0x003c
        L_0x0033:
            r4 = move-exception
            r1 = r2
            goto L_0x0044
        L_0x0036:
            r4 = move-exception
            goto L_0x004c
        L_0x0038:
            r4 = move-exception
            goto L_0x003c
        L_0x003a:
            r4 = move-exception
            goto L_0x0044
        L_0x003c:
            org.apache.commons.lang3.SerializationException r2 = new org.apache.commons.lang3.SerializationException     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = "IOException while reading cloned object data"
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0036 }
            throw r2     // Catch:{ all -> 0x0036 }
        L_0x0044:
            org.apache.commons.lang3.SerializationException r2 = new org.apache.commons.lang3.SerializationException     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = "ClassNotFoundException while reading cloned object data"
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0036 }
            throw r2     // Catch:{ all -> 0x0036 }
        L_0x004c:
            if (r1 == 0) goto L_0x0059
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0059
        L_0x0052:
            r4 = move-exception
            org.apache.commons.lang3.SerializationException r1 = new org.apache.commons.lang3.SerializationException
            r1.<init>(r0, r4)
            throw r1
        L_0x0059:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.SerializationUtils.clone(java.io.Serializable):java.io.Serializable");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0038 A[SYNTHETIC, Splitter:B:30:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T deserialize(java.io.InputStream r2) {
        /*
            if (r2 == 0) goto L_0x003c
            r0 = 0
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ ClassCastException -> 0x0022, ClassNotFoundException -> 0x0020, IOException -> 0x001e }
            r1.<init>(r2)     // Catch:{ ClassCastException -> 0x0022, ClassNotFoundException -> 0x0020, IOException -> 0x001e }
            java.lang.Object r2 = r1.readObject()     // Catch:{ ClassCastException -> 0x0019, ClassNotFoundException -> 0x0016, IOException -> 0x0013, all -> 0x0010 }
            r1.close()     // Catch:{ IOException -> 0x000f }
        L_0x000f:
            return r2
        L_0x0010:
            r2 = move-exception
            r0 = r1
            goto L_0x0036
        L_0x0013:
            r2 = move-exception
            r0 = r1
            goto L_0x0024
        L_0x0016:
            r2 = move-exception
            r0 = r1
            goto L_0x002a
        L_0x0019:
            r2 = move-exception
            r0 = r1
            goto L_0x0030
        L_0x001c:
            r2 = move-exception
            goto L_0x0036
        L_0x001e:
            r2 = move-exception
            goto L_0x0024
        L_0x0020:
            r2 = move-exception
            goto L_0x002a
        L_0x0022:
            r2 = move-exception
            goto L_0x0030
        L_0x0024:
            org.apache.commons.lang3.SerializationException r1 = new org.apache.commons.lang3.SerializationException     // Catch:{ all -> 0x001c }
            r1.<init>((java.lang.Throwable) r2)     // Catch:{ all -> 0x001c }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x002a:
            org.apache.commons.lang3.SerializationException r1 = new org.apache.commons.lang3.SerializationException     // Catch:{ all -> 0x001c }
            r1.<init>((java.lang.Throwable) r2)     // Catch:{ all -> 0x001c }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0030:
            org.apache.commons.lang3.SerializationException r1 = new org.apache.commons.lang3.SerializationException     // Catch:{ all -> 0x001c }
            r1.<init>((java.lang.Throwable) r2)     // Catch:{ all -> 0x001c }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ IOException -> 0x003b }
        L_0x003b:
            throw r2
        L_0x003c:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "The InputStream must not be null"
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.SerializationUtils.deserialize(java.io.InputStream):java.lang.Object");
    }

    public static <T extends Serializable> T roundtrip(T t) {
        return (Serializable) deserialize(serialize(t));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0020 A[SYNTHETIC, Splitter:B:19:0x0020] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void serialize(java.io.Serializable r2, java.io.OutputStream r3) {
        /*
            if (r3 == 0) goto L_0x0024
            r0 = 0
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0017 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0017 }
            r1.writeObject(r2)     // Catch:{ IOException -> 0x0012, all -> 0x000f }
            r1.close()     // Catch:{ IOException -> 0x000e }
        L_0x000e:
            return
        L_0x000f:
            r2 = move-exception
            r0 = r1
            goto L_0x001e
        L_0x0012:
            r2 = move-exception
            r0 = r1
            goto L_0x0018
        L_0x0015:
            r2 = move-exception
            goto L_0x001e
        L_0x0017:
            r2 = move-exception
        L_0x0018:
            org.apache.commons.lang3.SerializationException r3 = new org.apache.commons.lang3.SerializationException     // Catch:{ all -> 0x0015 }
            r3.<init>((java.lang.Throwable) r2)     // Catch:{ all -> 0x0015 }
            throw r3     // Catch:{ all -> 0x0015 }
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()     // Catch:{ IOException -> 0x0023 }
        L_0x0023:
            throw r2
        L_0x0024:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "The OutputStream must not be null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.SerializationUtils.serialize(java.io.Serializable, java.io.OutputStream):void");
    }

    public static <T> T deserialize(byte[] bArr) {
        if (bArr != null) {
            return deserialize((InputStream) new ByteArrayInputStream(bArr));
        }
        throw new IllegalArgumentException("The byte[] must not be null");
    }

    public static byte[] serialize(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
