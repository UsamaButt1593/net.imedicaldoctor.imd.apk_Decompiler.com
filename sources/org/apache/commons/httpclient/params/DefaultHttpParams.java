package org.apache.commons.httpclient.params;

import java.io.Serializable;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultHttpParams implements HttpParams, Serializable, Cloneable {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$params$DefaultHttpParams;
    private static HttpParamsFactory httpParamsFactory = new DefaultHttpParamsFactory();
    private HttpParams defaults;
    private HashMap parameters;

    static {
        Class cls = class$org$apache$commons$httpclient$params$DefaultHttpParams;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.params.DefaultHttpParams");
            class$org$apache$commons$httpclient$params$DefaultHttpParams = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public DefaultHttpParams() {
        this(getDefaultParams());
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static HttpParams getDefaultParams() {
        return httpParamsFactory.getDefaultParams();
    }

    public static void setHttpParamsFactory(HttpParamsFactory httpParamsFactory2) {
        if (httpParamsFactory2 != null) {
            httpParamsFactory = httpParamsFactory2;
            return;
        }
        throw new IllegalArgumentException("httpParamsFactory may not be null");
    }

    public void clear() {
        this.parameters = null;
    }

    public Object clone() throws CloneNotSupportedException {
        DefaultHttpParams defaultHttpParams = (DefaultHttpParams) super.clone();
        HashMap hashMap = this.parameters;
        if (hashMap != null) {
            defaultHttpParams.parameters = (HashMap) hashMap.clone();
        }
        defaultHttpParams.setDefaults(this.defaults);
        return defaultHttpParams;
    }

    public boolean getBooleanParameter(String str, boolean z) {
        Object parameter = getParameter(str);
        return parameter == null ? z : ((Boolean) parameter).booleanValue();
    }

    public synchronized HttpParams getDefaults() {
        return this.defaults;
    }

    public double getDoubleParameter(String str, double d2) {
        Object parameter = getParameter(str);
        return parameter == null ? d2 : ((Double) parameter).doubleValue();
    }

    public int getIntParameter(String str, int i2) {
        Object parameter = getParameter(str);
        return parameter == null ? i2 : ((Integer) parameter).intValue();
    }

    public long getLongParameter(String str, long j2) {
        Object parameter = getParameter(str);
        return parameter == null ? j2 : ((Long) parameter).longValue();
    }

    public synchronized Object getParameter(String str) {
        HashMap hashMap = this.parameters;
        Object obj = hashMap != null ? hashMap.get(str) : null;
        if (obj != null) {
            return obj;
        }
        HttpParams httpParams = this.defaults;
        if (httpParams == null) {
            return null;
        }
        return httpParams.getParameter(str);
    }

    public boolean isParameterFalse(String str) {
        return !getBooleanParameter(str, false);
    }

    public boolean isParameterSet(String str) {
        return getParameter(str) != null;
    }

    public boolean isParameterSetLocally(String str) {
        HashMap hashMap = this.parameters;
        return (hashMap == null || hashMap.get(str) == null) ? false : true;
    }

    public boolean isParameterTrue(String str) {
        return getBooleanParameter(str, false);
    }

    public void setBooleanParameter(String str, boolean z) {
        setParameter(str, z ? Boolean.TRUE : Boolean.FALSE);
    }

    public synchronized void setDefaults(HttpParams httpParams) {
        this.defaults = httpParams;
    }

    public void setDoubleParameter(String str, double d2) {
        setParameter(str, new Double(d2));
    }

    public void setIntParameter(String str, int i2) {
        setParameter(str, new Integer(i2));
    }

    public void setLongParameter(String str, long j2) {
        setParameter(str, new Long(j2));
    }

    public synchronized void setParameter(String str, Object obj) {
        try {
            if (this.parameters == null) {
                this.parameters = new HashMap();
            }
            this.parameters.put(str, obj);
            Log log = LOG;
            if (log.isDebugEnabled()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Set parameter ");
                stringBuffer.append(str);
                stringBuffer.append(" = ");
                stringBuffer.append(obj);
                log.debug(stringBuffer.toString());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized void setParameters(String[] strArr, Object obj) {
        for (String parameter : strArr) {
            setParameter(parameter, obj);
        }
    }

    public DefaultHttpParams(HttpParams httpParams) {
        this.parameters = null;
        this.defaults = httpParams;
    }
}
