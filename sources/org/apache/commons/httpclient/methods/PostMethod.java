package org.apache.commons.httpclient.methods;

import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PostMethod extends EntityEnclosingMethod {
    public static final String FORM_URL_ENCODED_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$methods$PostMethod;
    private Vector params = new Vector();

    static {
        Class cls = class$org$apache$commons$httpclient$methods$PostMethod;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.methods.PostMethod");
            class$org$apache$commons$httpclient$methods$PostMethod = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public PostMethod() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public void addParameter(String str, String str2) throws IllegalArgumentException {
        LOG.trace("enter PostMethod.addParameter(String, String)");
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Arguments to addParameter(String, String) cannot be null");
        }
        super.clearRequestBody();
        this.params.add(new NameValuePair(str, str2));
    }

    public void addParameters(NameValuePair[] nameValuePairArr) {
        Log log = LOG;
        log.trace("enter PostMethod.addParameters(NameValuePair[])");
        if (nameValuePairArr == null) {
            log.warn("Attempt to addParameters(null) ignored");
            return;
        }
        super.clearRequestBody();
        for (NameValuePair add : nameValuePairArr) {
            this.params.add(add);
        }
    }

    /* access modifiers changed from: protected */
    public void clearRequestBody() {
        LOG.trace("enter PostMethod.clearRequestBody()");
        this.params.clear();
        super.clearRequestBody();
    }

    /* access modifiers changed from: protected */
    public RequestEntity generateRequestEntity() {
        return !this.params.isEmpty() ? new ByteArrayRequestEntity(EncodingUtil.getAsciiBytes(EncodingUtil.formUrlEncode(getParameters(), getRequestCharSet())), FORM_URL_ENCODED_CONTENT_TYPE) : super.generateRequestEntity();
    }

    public String getName() {
        return "POST";
    }

    public NameValuePair getParameter(String str) {
        LOG.trace("enter PostMethod.getParameter(String)");
        if (str == null) {
            return null;
        }
        Iterator it2 = this.params.iterator();
        while (it2.hasNext()) {
            NameValuePair nameValuePair = (NameValuePair) it2.next();
            if (str.equals(nameValuePair.getName())) {
                return nameValuePair;
            }
        }
        return null;
    }

    public NameValuePair[] getParameters() {
        LOG.trace("enter PostMethod.getParameters()");
        int size = this.params.size();
        Object[] array = this.params.toArray();
        NameValuePair[] nameValuePairArr = new NameValuePair[size];
        for (int i2 = 0; i2 < size; i2++) {
            nameValuePairArr[i2] = (NameValuePair) array[i2];
        }
        return nameValuePairArr;
    }

    /* access modifiers changed from: protected */
    public boolean hasRequestContent() {
        LOG.trace("enter PostMethod.hasRequestContent()");
        if (!this.params.isEmpty()) {
            return true;
        }
        return super.hasRequestContent();
    }

    public boolean removeParameter(String str) throws IllegalArgumentException {
        LOG.trace("enter PostMethod.removeParameter(String)");
        if (str != null) {
            Iterator it2 = this.params.iterator();
            boolean z = false;
            while (it2.hasNext()) {
                if (str.equals(((NameValuePair) it2.next()).getName())) {
                    it2.remove();
                    z = true;
                }
            }
            return z;
        }
        throw new IllegalArgumentException("Argument passed to removeParameter(String) cannot be null");
    }

    public void setParameter(String str, String str2) {
        LOG.trace("enter PostMethod.setParameter(String, String)");
        removeParameter(str);
        addParameter(str, str2);
    }

    public void setRequestBody(NameValuePair[] nameValuePairArr) throws IllegalArgumentException {
        LOG.trace("enter PostMethod.setRequestBody(NameValuePair[])");
        if (nameValuePairArr != null) {
            clearRequestBody();
            addParameters(nameValuePairArr);
            return;
        }
        throw new IllegalArgumentException("Array of parameters may not be null");
    }

    public PostMethod(String str) {
        super(str);
    }

    public void addParameter(NameValuePair nameValuePair) throws IllegalArgumentException {
        LOG.trace("enter PostMethod.addParameter(NameValuePair)");
        if (nameValuePair != null) {
            addParameter(nameValuePair.getName(), nameValuePair.getValue());
            return;
        }
        throw new IllegalArgumentException("NameValuePair may not be null");
    }

    public boolean removeParameter(String str, String str2) throws IllegalArgumentException {
        LOG.trace("enter PostMethod.removeParameter(String, String)");
        if (str == null) {
            throw new IllegalArgumentException("Parameter name may not be null");
        } else if (str2 != null) {
            Iterator it2 = this.params.iterator();
            while (it2.hasNext()) {
                NameValuePair nameValuePair = (NameValuePair) it2.next();
                if (str.equals(nameValuePair.getName()) && str2.equals(nameValuePair.getValue())) {
                    it2.remove();
                    return true;
                }
            }
            return false;
        } else {
            throw new IllegalArgumentException("Parameter value may not be null");
        }
    }
}
