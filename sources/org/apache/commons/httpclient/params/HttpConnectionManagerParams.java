package org.apache.commons.httpclient.params;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.httpclient.HostConfiguration;

public class HttpConnectionManagerParams extends HttpConnectionParams {
    public static final String MAX_HOST_CONNECTIONS = "http.connection-manager.max-per-host";
    public static final String MAX_TOTAL_CONNECTIONS = "http.connection-manager.max-total";

    public int getDefaultMaxConnectionsPerHost() {
        return getMaxConnectionsPerHost(HostConfiguration.ANY_HOST_CONFIGURATION);
    }

    public int getMaxConnectionsPerHost(HostConfiguration hostConfiguration) {
        HostConfiguration hostConfiguration2;
        Map map = (Map) getParameter(MAX_HOST_CONNECTIONS);
        if (map == null) {
            return 2;
        }
        Integer num = (Integer) map.get(hostConfiguration);
        if (num == null && hostConfiguration != (hostConfiguration2 = HostConfiguration.ANY_HOST_CONFIGURATION)) {
            return getMaxConnectionsPerHost(hostConfiguration2);
        }
        if (num == null) {
            return 2;
        }
        return num.intValue();
    }

    public int getMaxTotalConnections() {
        return getIntParameter(MAX_TOTAL_CONNECTIONS, 20);
    }

    public void setDefaultMaxConnectionsPerHost(int i2) {
        setMaxConnectionsPerHost(HostConfiguration.ANY_HOST_CONFIGURATION, i2);
    }

    public void setMaxConnectionsPerHost(HostConfiguration hostConfiguration, int i2) {
        if (i2 > 0) {
            Map map = (Map) getParameter(MAX_HOST_CONNECTIONS);
            HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
            hashMap.put(hostConfiguration, new Integer(i2));
            setParameter(MAX_HOST_CONNECTIONS, hashMap);
            return;
        }
        throw new IllegalArgumentException("maxHostConnections must be greater than 0");
    }

    public void setMaxTotalConnections(int i2) {
        setIntParameter(MAX_TOTAL_CONNECTIONS, i2);
    }
}
