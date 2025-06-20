package androidx.datastore.preferences.protobuf;

import java.util.Map;

public interface StructOrBuilder extends MessageLiteOrBuilder {
    Value E2(String str);

    @Deprecated
    Map<String, Value> b1();

    Value d1(String str, Value value);

    int p();

    Map<String, Value> u0();

    boolean w0(String str);
}
