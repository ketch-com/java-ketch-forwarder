package com.ketch.events;

import com.ketch.events.types.Request;
import com.ketch.events.types.ResponseBody;

public interface EventService {
    ResponseBody handle(Request request);
}
