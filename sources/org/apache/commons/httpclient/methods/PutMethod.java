package org.apache.commons.httpclient.methods;

public class PutMethod extends EntityEnclosingMethod {
    public PutMethod() {
    }

    public String getName() {
        return "PUT";
    }

    public PutMethod(String str) {
        super(str);
    }
}
