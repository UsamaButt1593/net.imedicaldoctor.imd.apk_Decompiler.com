package org.apache.commons.lang3.exception;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class DefaultExceptionContext implements ExceptionContext, Serializable {
    private static final long serialVersionUID = 20110706;
    private final List<Pair<String, Object>> contextValues = new ArrayList();

    public DefaultExceptionContext addContextValue(String str, Object obj) {
        this.contextValues.add(new ImmutablePair(str, obj));
        return this;
    }

    public List<Pair<String, Object>> getContextEntries() {
        return this.contextValues;
    }

    public Set<String> getContextLabels() {
        HashSet hashSet = new HashSet();
        for (Pair<String, Object> key : this.contextValues) {
            hashSet.add(key.getKey());
        }
        return hashSet;
    }

    public List<Object> getContextValues(String str) {
        ArrayList arrayList = new ArrayList();
        for (Pair next : this.contextValues) {
            if (StringUtils.equals(str, (CharSequence) next.getKey())) {
                arrayList.add(next.getValue());
            }
        }
        return arrayList;
    }

    public Object getFirstContextValue(String str) {
        for (Pair next : this.contextValues) {
            if (StringUtils.equals(str, (CharSequence) next.getKey())) {
                return next.getValue();
            }
        }
        return null;
    }

    public String getFormattedExceptionMessage(String str) {
        String str2;
        StringBuilder sb = new StringBuilder(256);
        if (str != null) {
            sb.append(str);
        }
        if (this.contextValues.size() > 0) {
            if (sb.length() > 0) {
                sb.append(10);
            }
            sb.append("Exception Context:\n");
            int i2 = 0;
            for (Pair next : this.contextValues) {
                sb.append("\t[");
                i2++;
                sb.append(i2);
                sb.append(ASCIIPropertyListParser.A);
                sb.append((String) next.getKey());
                sb.append("=");
                Object value = next.getValue();
                if (value == null) {
                    str2 = "null";
                } else {
                    try {
                        str2 = value.toString();
                    } catch (Exception e2) {
                        str2 = "Exception thrown on toString(): " + ExceptionUtils.getStackTrace(e2);
                    }
                }
                sb.append(str2);
                sb.append("]\n");
            }
            sb.append("---------------------------------");
        }
        return sb.toString();
    }

    public DefaultExceptionContext setContextValue(String str, Object obj) {
        Iterator<Pair<String, Object>> it2 = this.contextValues.iterator();
        while (it2.hasNext()) {
            if (StringUtils.equals(str, (CharSequence) it2.next().getKey())) {
                it2.remove();
            }
        }
        addContextValue(str, obj);
        return this;
    }
}
