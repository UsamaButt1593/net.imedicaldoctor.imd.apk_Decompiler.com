package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

final class MessageLiteToString {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7199a = "List";

    /* renamed from: b  reason: collision with root package name */
    private static final String f7200b = "OrBuilderList";

    /* renamed from: c  reason: collision with root package name */
    private static final String f7201c = "Map";

    /* renamed from: d  reason: collision with root package name */
    private static final String f7202d = "Bytes";

    MessageLiteToString() {
    }

    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static boolean b(Object obj) {
        Object obj2;
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue() == 0.0f;
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d;
        }
        if (obj instanceof String) {
            obj2 = "";
        } else if (!(obj instanceof ByteString)) {
            return obj instanceof MessageLite ? obj == ((MessageLite) obj).D() : (obj instanceof Enum) && ((Enum) obj).ordinal() == 0;
        } else {
            obj2 = ByteString.X2;
        }
        return obj.equals(obj2);
    }

    static final void c(StringBuilder sb, int i2, String str, Object obj) {
        String a2;
        if (obj instanceof List) {
            for (Object c2 : (List) obj) {
                c(sb, i2, str, c2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry c3 : ((Map) obj).entrySet()) {
                c(sb, i2, str, c3);
            }
        } else {
            sb.append(10);
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                a2 = TextFormatEscaper.e((String) obj);
            } else if (obj instanceof ByteString) {
                sb.append(": \"");
                a2 = TextFormatEscaper.a((ByteString) obj);
            } else {
                if (obj instanceof GeneratedMessageLite) {
                    sb.append(" {");
                    d((GeneratedMessageLite) obj, sb, i2 + 2);
                    sb.append(StringUtils.LF);
                    while (i3 < i2) {
                        sb.append(' ');
                        i3++;
                    }
                } else if (obj instanceof Map.Entry) {
                    sb.append(" {");
                    Map.Entry entry = (Map.Entry) obj;
                    int i5 = i2 + 2;
                    c(sb, i5, "key", entry.getKey());
                    c(sb, i5, "value", entry.getValue());
                    sb.append(StringUtils.LF);
                    while (i3 < i2) {
                        sb.append(' ');
                        i3++;
                    }
                } else {
                    sb.append(": ");
                    sb.append(obj.toString());
                    return;
                }
                sb.append("}");
                return;
            }
            sb.append(a2);
            sb.append('\"');
        }
    }

    private static void d(MessageLite messageLite, StringBuilder sb, int i2) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : messageLite.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String replaceFirst = str.replaceFirst("get", "");
            boolean z = true;
            if (replaceFirst.endsWith(f7199a) && !replaceFirst.endsWith(f7200b) && !replaceFirst.equals(f7199a)) {
                String str2 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 4);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    c(sb, i2, a(str2), GeneratedMessageLite.i1(method2, messageLite, new Object[0]));
                }
            }
            if (replaceFirst.endsWith(f7201c) && !replaceFirst.equals(f7201c)) {
                String str3 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    c(sb, i2, a(str3), GeneratedMessageLite.i1(method3, messageLite, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + replaceFirst)) != null) {
                if (replaceFirst.endsWith(f7202d)) {
                    if (hashMap.containsKey("get" + replaceFirst.substring(0, replaceFirst.length() - 5))) {
                    }
                }
                String str4 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1);
                Method method4 = (Method) hashMap.get("get" + replaceFirst);
                Method method5 = (Method) hashMap.get("has" + replaceFirst);
                if (method4 != null) {
                    Object i1 = GeneratedMessageLite.i1(method4, messageLite, new Object[0]);
                    if (method5 != null) {
                        z = ((Boolean) GeneratedMessageLite.i1(method5, messageLite, new Object[0])).booleanValue();
                    } else if (b(i1)) {
                        z = false;
                    }
                    if (z) {
                        c(sb, i2, a(str4), i1);
                    }
                }
            }
        }
        if (messageLite instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> H = ((GeneratedMessageLite.ExtendableMessage) messageLite).extensions.H();
            while (H.hasNext()) {
                Map.Entry next = H.next();
                c(sb, i2, "[" + ((GeneratedMessageLite.ExtensionDescriptor) next.getKey()).d() + "]", next.getValue());
            }
        }
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) messageLite).unknownFields;
        if (unknownFieldSetLite != null) {
            unknownFieldSetLite.q(sb, i2);
        }
    }

    static String e(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        d(messageLite, sb, 0);
        return sb.toString();
    }
}
