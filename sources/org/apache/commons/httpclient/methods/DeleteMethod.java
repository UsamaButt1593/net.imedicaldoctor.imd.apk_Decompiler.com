package org.apache.commons.httpclient.methods;

import org.apache.commons.httpclient.HttpMethodBase;

public class DeleteMethod extends HttpMethodBase {
    public DeleteMethod() {
    }

    public String getName() {
        return "DELETE";
    }

    public DeleteMethod(String str) {
        super(str);
    }
}
