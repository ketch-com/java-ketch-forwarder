package com.ketch.events;

import com.ketch.events.types.Request;
import com.ketch.events.types.RequestStatus;
import com.ketch.events.types.ResponseBody;
import org.springframework.stereotype.Component;

@Component
public class SampleEventService implements EventService {
    @Override
    public ResponseBody handle(Request request) {
        return ResponseBody.builder().status(RequestStatus.Completed).build();
    }
}
