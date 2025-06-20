package com.google.firebase.messaging;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import java.util.concurrent.TimeUnit;

public final class Constants {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24670a = "FirebaseMessaging";

    /* renamed from: b  reason: collision with root package name */
    public static final String f24671b = "wake:com.google.firebase.messaging";

    /* renamed from: c  reason: collision with root package name */
    public static final long f24672c = TimeUnit.MINUTES.toMillis(3);

    /* renamed from: d  reason: collision with root package name */
    public static final String f24673d = "error";

    public static final class AnalyticsKeys {

        /* renamed from: a  reason: collision with root package name */
        public static final String f24674a = "google.c.a.";

        /* renamed from: b  reason: collision with root package name */
        public static final String f24675b = "google.c.a.e";

        /* renamed from: c  reason: collision with root package name */
        public static final String f24676c = "google.c.a.c_id";

        /* renamed from: d  reason: collision with root package name */
        public static final String f24677d = "google.c.a.c_l";

        /* renamed from: e  reason: collision with root package name */
        public static final String f24678e = "google.c.a.ts";

        /* renamed from: f  reason: collision with root package name */
        public static final String f24679f = "google.c.a.udt";

        /* renamed from: g  reason: collision with root package name */
        public static final String f24680g = "google.c.a.tc";

        /* renamed from: h  reason: collision with root package name */
        public static final String f24681h = "google.c.a.abt";

        /* renamed from: i  reason: collision with root package name */
        public static final String f24682i = "google.c.a.m_l";

        /* renamed from: j  reason: collision with root package name */
        public static final String f24683j = "google.c.a.m_c";

        private AnalyticsKeys() {
        }
    }

    public static final class FirelogAnalytics {

        /* renamed from: a  reason: collision with root package name */
        public static final String f24684a = "FCM_CLIENT_EVENT_LOGGING";

        private FirelogAnalytics() {
        }
    }

    public static final class MessageNotificationKeys {
        public static final String A = "gcm.n.click_action";
        public static final String B = "gcm.n.link";
        public static final String C = "gcm.n.link_android";
        public static final String D = "gcm.n.android_channel_id";
        public static final String E = "gcm.n.analytics_data";
        public static final String F = "_loc_key";
        public static final String G = "_loc_args";

        /* renamed from: a  reason: collision with root package name */
        public static final String f24685a = "gcm.";

        /* renamed from: b  reason: collision with root package name */
        public static final String f24686b = "gcm.n.";

        /* renamed from: c  reason: collision with root package name */
        public static final String f24687c = "gcm.notification.";

        /* renamed from: d  reason: collision with root package name */
        public static final String f24688d = "gcm.n.e";

        /* renamed from: e  reason: collision with root package name */
        public static final String f24689e = "gcm.n.dnp";

        /* renamed from: f  reason: collision with root package name */
        public static final String f24690f = "gcm.n.noui";

        /* renamed from: g  reason: collision with root package name */
        public static final String f24691g = "gcm.n.title";

        /* renamed from: h  reason: collision with root package name */
        public static final String f24692h = "gcm.n.body";

        /* renamed from: i  reason: collision with root package name */
        public static final String f24693i = "gcm.n.icon";

        /* renamed from: j  reason: collision with root package name */
        public static final String f24694j = "gcm.n.image";

        /* renamed from: k  reason: collision with root package name */
        public static final String f24695k = "gcm.n.tag";

        /* renamed from: l  reason: collision with root package name */
        public static final String f24696l = "gcm.n.color";

        /* renamed from: m  reason: collision with root package name */
        public static final String f24697m = "gcm.n.ticker";

        /* renamed from: n  reason: collision with root package name */
        public static final String f24698n = "gcm.n.local_only";
        public static final String o = "gcm.n.sticky";
        public static final String p = "gcm.n.notification_priority";
        public static final String q = "gcm.n.default_sound";
        public static final String r = "gcm.n.default_vibrate_timings";
        public static final String s = "gcm.n.default_light_settings";
        public static final String t = "gcm.n.notification_count";
        public static final String u = "gcm.n.visibility";
        public static final String v = "gcm.n.vibrate_timings";
        public static final String w = "gcm.n.light_settings";
        public static final String x = "gcm.n.event_time";
        public static final String y = "gcm.n.sound2";
        public static final String z = "gcm.n.sound";

        private MessageNotificationKeys() {
        }
    }

    public static final class MessagePayloadKeys {

        /* renamed from: a  reason: collision with root package name */
        public static final String f24699a = "google.";

        /* renamed from: b  reason: collision with root package name */
        public static final String f24700b = "from";

        /* renamed from: c  reason: collision with root package name */
        public static final String f24701c = "rawData";

        /* renamed from: d  reason: collision with root package name */
        public static final String f24702d = "message_type";

        /* renamed from: e  reason: collision with root package name */
        public static final String f24703e = "collapse_key";

        /* renamed from: f  reason: collision with root package name */
        public static final String f24704f = "message_id";

        /* renamed from: g  reason: collision with root package name */
        public static final String f24705g = "google.to";

        /* renamed from: h  reason: collision with root package name */
        public static final String f24706h = "google.message_id";

        /* renamed from: i  reason: collision with root package name */
        public static final String f24707i = "google.ttl";

        /* renamed from: j  reason: collision with root package name */
        public static final String f24708j = "google.sent_time";

        /* renamed from: k  reason: collision with root package name */
        public static final String f24709k = "google.original_priority";

        /* renamed from: l  reason: collision with root package name */
        public static final String f24710l = "google.delivered_priority";

        /* renamed from: m  reason: collision with root package name */
        public static final String f24711m = "google.priority";

        /* renamed from: n  reason: collision with root package name */
        public static final String f24712n = "google.priority_reduced";
        public static final String o = "google.product_id";
        public static final String p = "google.c.";
        public static final String q = "google.c.sender.id";

        private MessagePayloadKeys() {
        }

        public static ArrayMap<String, String> a(Bundle bundle) {
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (!next.startsWith(f24699a) && !next.startsWith(MessageNotificationKeys.f24685a) && !next.equals("from") && !next.equals(f24702d) && !next.equals(f24703e)) {
                        arrayMap.put(next, str);
                    }
                }
            }
            return arrayMap;
        }
    }

    public static final class MessageTypes {

        /* renamed from: a  reason: collision with root package name */
        public static final String f24713a = "gcm";

        /* renamed from: b  reason: collision with root package name */
        public static final String f24714b = "deleted_messages";

        /* renamed from: c  reason: collision with root package name */
        public static final String f24715c = "send_event";

        /* renamed from: d  reason: collision with root package name */
        public static final String f24716d = "send_error";

        private MessageTypes() {
        }
    }

    public static final class ScionAnalytics {

        /* renamed from: a  reason: collision with root package name */
        public static final String f24717a = "fcm";

        /* renamed from: b  reason: collision with root package name */
        public static final String f24718b = "source";

        /* renamed from: c  reason: collision with root package name */
        public static final String f24719c = "medium";

        /* renamed from: d  reason: collision with root package name */
        public static final String f24720d = "label";

        /* renamed from: e  reason: collision with root package name */
        public static final String f24721e = "_nt";

        /* renamed from: f  reason: collision with root package name */
        public static final String f24722f = "campaign";

        /* renamed from: g  reason: collision with root package name */
        public static final String f24723g = "_nmn";

        /* renamed from: h  reason: collision with root package name */
        public static final String f24724h = "_nmt";

        /* renamed from: i  reason: collision with root package name */
        public static final String f24725i = "_ndt";

        /* renamed from: j  reason: collision with root package name */
        public static final String f24726j = "message_channel";

        /* renamed from: k  reason: collision with root package name */
        public static final String f24727k = "_nmc";

        /* renamed from: l  reason: collision with root package name */
        public static final String f24728l = "_cmp";

        /* renamed from: m  reason: collision with root package name */
        public static final String f24729m = "_nr";

        /* renamed from: n  reason: collision with root package name */
        public static final String f24730n = "_no";
        public static final String o = "_nd";
        public static final String p = "_nf";
        public static final String q = "_ln";
        static final String r = "_nmid";

        public @interface MessageType {
            public static final String K = "data";
            public static final String L = "display";
        }

        private ScionAnalytics() {
        }
    }

    private Constants() {
    }
}
