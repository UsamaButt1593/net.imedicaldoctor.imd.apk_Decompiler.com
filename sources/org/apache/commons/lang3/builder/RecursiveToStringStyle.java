package org.apache.commons.lang3.builder;

import java.util.Collection;
import org.apache.commons.lang3.ClassUtils;

public class RecursiveToStringStyle extends ToStringStyle {
    private static final long serialVersionUID = 1;

    /* access modifiers changed from: protected */
    public boolean accept(Class<?> cls) {
        return true;
    }

    public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
        if (!ClassUtils.isPrimitiveWrapper(obj.getClass())) {
            if (!String.class.equals(obj.getClass()) && accept(obj.getClass())) {
                stringBuffer.append(ReflectionToStringBuilder.toString(obj, this));
                return;
            }
        }
        super.appendDetail(stringBuffer, str, obj);
    }

    /* access modifiers changed from: protected */
    public void appendDetail(StringBuffer stringBuffer, String str, Collection<?> collection) {
        appendClassName(stringBuffer, collection);
        appendIdentityHashCode(stringBuffer, collection);
        appendDetail(stringBuffer, str, collection.toArray());
    }
}
