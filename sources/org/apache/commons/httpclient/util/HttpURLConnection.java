package org.apache.commons.httpclient.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpURLConnection extends java.net.HttpURLConnection {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$util$HttpURLConnection;
    private HttpMethod method;
    private URL url;

    static {
        Class cls = class$org$apache$commons$httpclient$util$HttpURLConnection;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.util.HttpURLConnection");
            class$org$apache$commons$httpclient$util$HttpURLConnection = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    protected HttpURLConnection(URL url2) {
        super(url2);
        throw new RuntimeException("An HTTP URL connection can only be constructed from a HttpMethod class");
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public void connect() throws IOException {
        LOG.trace("enter HttpURLConnection.connect()");
        throw new RuntimeException("This class can only be used with alreadyretrieved data");
    }

    public void disconnect() {
        LOG.trace("enter HttpURLConnection.disconnect()");
        throw new RuntimeException("Not implemented yet");
    }

    public boolean getAllowUserInteraction() {
        LOG.trace("enter HttpURLConnection.getAllowUserInteraction()");
        throw new RuntimeException("Not implemented yet");
    }

    public Object getContent() throws IOException {
        LOG.trace("enter HttpURLConnection.getContent()");
        throw new RuntimeException("Not implemented yet");
    }

    public boolean getDefaultUseCaches() {
        LOG.trace("enter HttpURLConnection.getDefaultUseCaches()");
        throw new RuntimeException("Not implemented yet");
    }

    public boolean getDoInput() {
        LOG.trace("enter HttpURLConnection.getDoInput()");
        throw new RuntimeException("Not implemented yet");
    }

    public boolean getDoOutput() {
        LOG.trace("enter HttpURLConnection.getDoOutput()");
        throw new RuntimeException("Not implemented yet");
    }

    public InputStream getErrorStream() {
        LOG.trace("enter HttpURLConnection.getErrorStream()");
        throw new RuntimeException("Not implemented yet");
    }

    public String getHeaderField(int i2) {
        LOG.trace("enter HttpURLConnection.getHeaderField(int)");
        if (i2 == 0) {
            return this.method.getStatusLine().toString();
        }
        Header[] responseHeaders = this.method.getResponseHeaders();
        if (i2 < 0 || i2 > responseHeaders.length) {
            return null;
        }
        return responseHeaders[i2 - 1].getValue();
    }

    public String getHeaderFieldKey(int i2) {
        LOG.trace("enter HttpURLConnection.getHeaderFieldKey(int)");
        if (i2 == 0) {
            return null;
        }
        Header[] responseHeaders = this.method.getResponseHeaders();
        if (i2 < 0 || i2 > responseHeaders.length) {
            return null;
        }
        return responseHeaders[i2 - 1].getName();
    }

    public long getIfModifiedSince() {
        LOG.trace("enter HttpURLConnection.getIfmodifiedSince()");
        throw new RuntimeException("Not implemented yet");
    }

    public InputStream getInputStream() throws IOException {
        LOG.trace("enter HttpURLConnection.getInputStream()");
        return this.method.getResponseBodyAsStream();
    }

    public boolean getInstanceFollowRedirects() {
        LOG.trace("enter HttpURLConnection.getInstanceFollowRedirects()");
        throw new RuntimeException("Not implemented yet");
    }

    public OutputStream getOutputStream() throws IOException {
        LOG.trace("enter HttpURLConnection.getOutputStream()");
        throw new RuntimeException("This class can only be used with alreadyretrieved data");
    }

    public Permission getPermission() throws IOException {
        LOG.trace("enter HttpURLConnection.getPermission()");
        throw new RuntimeException("Not implemented yet");
    }

    public String getRequestMethod() {
        LOG.trace("enter HttpURLConnection.getRequestMethod()");
        return this.method.getName();
    }

    public String getRequestProperty(String str) {
        LOG.trace("enter HttpURLConnection.getRequestProperty()");
        throw new RuntimeException("Not implemented yet");
    }

    public int getResponseCode() throws IOException {
        LOG.trace("enter HttpURLConnection.getResponseCode()");
        return this.method.getStatusCode();
    }

    public String getResponseMessage() throws IOException {
        LOG.trace("enter HttpURLConnection.getResponseMessage()");
        return this.method.getStatusText();
    }

    public URL getURL() {
        LOG.trace("enter HttpURLConnection.getURL()");
        return this.url;
    }

    public boolean getUseCaches() {
        LOG.trace("enter HttpURLConnection.getUseCaches()");
        throw new RuntimeException("Not implemented yet");
    }

    public void setAllowUserInteraction(boolean z) {
        LOG.trace("enter HttpURLConnection.setAllowUserInteraction(boolean)");
        throw new RuntimeException("This class can only be used with alreadyretrieved data");
    }

    public void setDefaultUseCaches(boolean z) {
        LOG.trace("enter HttpURLConnection.setDefaultUseCaches(boolean)");
        throw new RuntimeException("This class can only be used with alreadyretrieved data");
    }

    public void setDoInput(boolean z) {
        LOG.trace("enter HttpURLConnection.setDoInput()");
        throw new RuntimeException("This class can only be used with alreadyretrieved data");
    }

    public void setDoOutput(boolean z) {
        LOG.trace("enter HttpURLConnection.setDoOutput()");
        throw new RuntimeException("This class can only be used with alreadyretrieved data");
    }

    public void setIfModifiedSince(long j2) {
        LOG.trace("enter HttpURLConnection.setIfModifiedSince(long)");
        throw new RuntimeException("This class can only be used with alreadyretrieved data");
    }

    public void setInstanceFollowRedirects(boolean z) {
        LOG.trace("enter HttpURLConnection.setInstanceFollowRedirects(boolean)");
        throw new RuntimeException("This class can only be used with alreadyretrieved data");
    }

    public void setRequestMethod(String str) throws ProtocolException {
        LOG.trace("enter HttpURLConnection.setRequestMethod(String)");
        throw new RuntimeException("This class can only be used with alreadyretrieved data");
    }

    public void setRequestProperty(String str, String str2) {
        LOG.trace("enter HttpURLConnection.setRequestProperty()");
        throw new RuntimeException("This class can only be used with alreadyretrieved data");
    }

    public void setUseCaches(boolean z) {
        LOG.trace("enter HttpURLConnection.setUseCaches(boolean)");
        throw new RuntimeException("This class can only be used with alreadyretrieved data");
    }

    public boolean usingProxy() {
        LOG.trace("enter HttpURLConnection.usingProxy()");
        throw new RuntimeException("Not implemented yet");
    }

    public HttpURLConnection(HttpMethod httpMethod, URL url2) {
        super(url2);
        this.method = httpMethod;
        this.url = url2;
    }

    public Object getContent(Class[] clsArr) throws IOException {
        LOG.trace("enter HttpURLConnection.getContent(Class[])");
        throw new RuntimeException("Not implemented yet");
    }

    public String getHeaderField(String str) {
        LOG.trace("enter HttpURLConnection.getHeaderField(String)");
        Header[] responseHeaders = this.method.getResponseHeaders();
        for (int length = responseHeaders.length - 1; length >= 0; length--) {
            if (responseHeaders[length].getName().equalsIgnoreCase(str)) {
                return responseHeaders[length].getValue();
            }
        }
        return null;
    }
}
