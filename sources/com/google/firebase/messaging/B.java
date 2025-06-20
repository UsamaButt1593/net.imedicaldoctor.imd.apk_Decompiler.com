package com.google.firebase.messaging;

import com.google.android.datatransport.Transformer;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

public final /* synthetic */ class B implements Transformer {
    public final Object apply(Object obj) {
        return ((MessagingClientEventExtension) obj).e();
    }
}
