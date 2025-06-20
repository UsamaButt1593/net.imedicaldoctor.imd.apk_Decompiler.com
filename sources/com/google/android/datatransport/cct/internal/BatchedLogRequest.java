package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

@AutoValue
@Encodable
public abstract class BatchedLogRequest {
    @NonNull
    public static BatchedLogRequest a(@NonNull List<LogRequest> list) {
        return new AutoValue_BatchedLogRequest(list);
    }

    @NonNull
    public static DataEncoder b() {
        return new JsonDataEncoderBuilder().k(AutoBatchedLogRequestEncoder.f19245b).l(true).j();
    }

    @NonNull
    @Encodable.Field(name = "logRequest")
    public abstract List<LogRequest> c();
}
