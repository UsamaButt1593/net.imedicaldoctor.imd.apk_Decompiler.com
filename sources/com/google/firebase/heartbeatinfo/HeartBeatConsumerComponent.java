package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.Component;

public class HeartBeatConsumerComponent {
    private HeartBeatConsumerComponent() {
    }

    public static Component<?> a() {
        return Component.p(new HeartBeatConsumer() {
        }, HeartBeatConsumer.class);
    }
}
