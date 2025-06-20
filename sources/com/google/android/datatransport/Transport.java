package com.google.android.datatransport;

public interface Transport<T> {
    void a(Event<T> event);

    void b(Event<T> event, TransportScheduleCallback transportScheduleCallback);
}
