package org.apache.commons.httpclient.params;

public interface HttpParams {
    boolean getBooleanParameter(String str, boolean z);

    HttpParams getDefaults();

    double getDoubleParameter(String str, double d2);

    int getIntParameter(String str, int i2);

    long getLongParameter(String str, long j2);

    Object getParameter(String str);

    boolean isParameterFalse(String str);

    boolean isParameterSet(String str);

    boolean isParameterSetLocally(String str);

    boolean isParameterTrue(String str);

    void setBooleanParameter(String str, boolean z);

    void setDefaults(HttpParams httpParams);

    void setDoubleParameter(String str, double d2);

    void setIntParameter(String str, int i2);

    void setLongParameter(String str, long j2);

    void setParameter(String str, Object obj);
}
