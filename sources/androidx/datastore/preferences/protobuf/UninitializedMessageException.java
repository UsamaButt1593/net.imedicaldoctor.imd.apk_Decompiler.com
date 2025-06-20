package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.List;

public class UninitializedMessageException extends RuntimeException {
    private static final long X = -7466929953374883507L;
    private final List<String> s;

    public UninitializedMessageException(MessageLite messageLite) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.s = null;
    }

    private static String b(List<String> list) {
        StringBuilder sb = new StringBuilder("Message missing required fields: ");
        boolean z = true;
        for (String next : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(next);
        }
        return sb.toString();
    }

    public InvalidProtocolBufferException a() {
        return new InvalidProtocolBufferException(getMessage());
    }

    public List<String> c() {
        return Collections.unmodifiableList(this.s);
    }

    public UninitializedMessageException(List<String> list) {
        super(b(list));
        this.s = list;
    }
}
