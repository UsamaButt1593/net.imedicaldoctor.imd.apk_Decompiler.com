package org.apache.commons.httpclient;

import java.io.IOException;
import java.security.Provider;
import java.security.Security;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpClient {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$HttpClient;
    private HostConfiguration hostConfiguration;
    private HttpConnectionManager httpConnectionManager;
    private HttpClientParams params;
    private HttpState state;

    static {
        Class cls = class$org$apache$commons$httpclient$HttpClient;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.HttpClient");
            class$org$apache$commons$httpclient$HttpClient = cls;
        }
        Log log = LogFactory.getLog(cls);
        LOG = log;
        if (log.isDebugEnabled()) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Java version: ");
                stringBuffer.append(System.getProperty("java.version"));
                log.debug(stringBuffer.toString());
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Java vendor: ");
                stringBuffer2.append(System.getProperty("java.vendor"));
                log.debug(stringBuffer2.toString());
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Java class path: ");
                stringBuffer3.append(System.getProperty("java.class.path"));
                log.debug(stringBuffer3.toString());
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Operating system name: ");
                stringBuffer4.append(System.getProperty("os.name"));
                log.debug(stringBuffer4.toString());
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("Operating system architecture: ");
                stringBuffer5.append(System.getProperty("os.arch"));
                log.debug(stringBuffer5.toString());
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append("Operating system version: ");
                stringBuffer6.append(System.getProperty("os.version"));
                log.debug(stringBuffer6.toString());
                Provider[] providers = Security.getProviders();
                for (Provider provider : providers) {
                    Log log2 = LOG;
                    StringBuffer stringBuffer7 = new StringBuffer();
                    stringBuffer7.append(provider.getName());
                    stringBuffer7.append(StringUtils.SPACE);
                    stringBuffer7.append(provider.getVersion());
                    stringBuffer7.append(": ");
                    stringBuffer7.append(provider.getInfo());
                    log2.debug(stringBuffer7.toString());
                }
            } catch (SecurityException unused) {
            }
        }
    }

    public HttpClient() {
        this(new HttpClientParams());
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public int executeMethod(HostConfiguration hostConfiguration2, HttpMethod httpMethod) throws IOException, HttpException {
        LOG.trace("enter HttpClient.executeMethod(HostConfiguration,HttpMethod)");
        return executeMethod(hostConfiguration2, httpMethod, (HttpState) null);
    }

    public String getHost() {
        return this.hostConfiguration.getHost();
    }

    public synchronized HostConfiguration getHostConfiguration() {
        return this.hostConfiguration;
    }

    public synchronized HttpConnectionManager getHttpConnectionManager() {
        return this.httpConnectionManager;
    }

    public HttpClientParams getParams() {
        return this.params;
    }

    public int getPort() {
        return this.hostConfiguration.getPort();
    }

    public synchronized HttpState getState() {
        return this.state;
    }

    public synchronized boolean isStrictMode() {
        return false;
    }

    public synchronized void setConnectionTimeout(int i2) {
        this.httpConnectionManager.getParams().setConnectionTimeout(i2);
    }

    public synchronized void setHostConfiguration(HostConfiguration hostConfiguration2) {
        this.hostConfiguration = hostConfiguration2;
    }

    public synchronized void setHttpConnectionFactoryTimeout(long j2) {
        this.params.setConnectionManagerTimeout(j2);
    }

    public synchronized void setHttpConnectionManager(HttpConnectionManager httpConnectionManager2) {
        this.httpConnectionManager = httpConnectionManager2;
        if (httpConnectionManager2 != null) {
            httpConnectionManager2.getParams().setDefaults(this.params);
        }
    }

    public void setParams(HttpClientParams httpClientParams) {
        if (httpClientParams != null) {
            this.params = httpClientParams;
            return;
        }
        throw new IllegalArgumentException("Parameters may not be null");
    }

    public synchronized void setState(HttpState httpState) {
        this.state = httpState;
    }

    public synchronized void setStrictMode(boolean z) {
        if (z) {
            try {
                this.params.makeStrict();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        } else {
            this.params.makeLenient();
        }
    }

    public synchronized void setTimeout(int i2) {
        this.params.setSoTimeout(i2);
    }

    public HttpClient(HttpConnectionManager httpConnectionManager2) {
        this(new HttpClientParams(), httpConnectionManager2);
    }

    public int executeMethod(HostConfiguration hostConfiguration2, HttpMethod httpMethod, HttpState httpState) throws IOException, HttpException {
        LOG.trace("enter HttpClient.executeMethod(HostConfiguration,HttpMethod,HttpState)");
        if (httpMethod != null) {
            HostConfiguration hostConfiguration3 = getHostConfiguration();
            if (hostConfiguration2 == null) {
                hostConfiguration2 = hostConfiguration3;
            }
            URI uri = httpMethod.getURI();
            if (hostConfiguration2 == hostConfiguration3 || uri.isAbsoluteURI()) {
                hostConfiguration2 = (HostConfiguration) hostConfiguration2.clone();
                if (uri.isAbsoluteURI()) {
                    hostConfiguration2.setHost(uri);
                }
            }
            HttpConnectionManager httpConnectionManager2 = getHttpConnectionManager();
            HttpClientParams httpClientParams = this.params;
            if (httpState == null) {
                httpState = getState();
            }
            new HttpMethodDirector(httpConnectionManager2, hostConfiguration2, httpClientParams, httpState).executeMethod(httpMethod);
            return httpMethod.getStatusCode();
        }
        throw new IllegalArgumentException("HttpMethod parameter may not be null");
    }

    public HttpClient(HttpClientParams httpClientParams) {
        this.state = new HttpState();
        this.params = null;
        this.hostConfiguration = new HostConfiguration();
        if (httpClientParams != null) {
            this.params = httpClientParams;
            this.httpConnectionManager = null;
            Class connectionManagerClass = httpClientParams.getConnectionManagerClass();
            if (connectionManagerClass != null) {
                try {
                    this.httpConnectionManager = (HttpConnectionManager) connectionManagerClass.newInstance();
                } catch (Exception e2) {
                    LOG.warn("Error instantiating connection manager class, defaulting to SimpleHttpConnectionManager", e2);
                }
            }
            if (this.httpConnectionManager == null) {
                this.httpConnectionManager = new SimpleHttpConnectionManager();
            }
            HttpConnectionManager httpConnectionManager2 = this.httpConnectionManager;
            if (httpConnectionManager2 != null) {
                httpConnectionManager2.getParams().setDefaults(this.params);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Params may not be null");
    }

    public int executeMethod(HttpMethod httpMethod) throws IOException, HttpException {
        LOG.trace("enter HttpClient.executeMethod(HttpMethod)");
        return executeMethod((HostConfiguration) null, httpMethod, (HttpState) null);
    }

    public HttpClient(HttpClientParams httpClientParams, HttpConnectionManager httpConnectionManager2) {
        this.state = new HttpState();
        this.params = null;
        this.hostConfiguration = new HostConfiguration();
        if (httpConnectionManager2 == null) {
            throw new IllegalArgumentException("httpConnectionManager cannot be null");
        } else if (httpClientParams != null) {
            this.params = httpClientParams;
            this.httpConnectionManager = httpConnectionManager2;
            httpConnectionManager2.getParams().setDefaults(this.params);
        } else {
            throw new IllegalArgumentException("Params may not be null");
        }
    }
}
