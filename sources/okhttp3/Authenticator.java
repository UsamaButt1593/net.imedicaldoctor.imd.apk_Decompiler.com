package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

public interface Authenticator {

    /* renamed from: a  reason: collision with root package name */
    public static final Authenticator f30737a = new Authenticator() {
        public Request a(@Nullable Route route, Response response) {
            return null;
        }
    };

    @Nullable
    Request a(@Nullable Route route, Response response) throws IOException;
}
