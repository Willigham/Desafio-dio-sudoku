package br.com.dio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.dio.service.EventEnum.CLEAR_SPACE;

public class NotifierService {

    private final Map<EventEnum, List<EventListener>> listeners = new HashMap<>(){{
        put(CLEAR_SPACE, new ArrayList<>());
    }};

    public void subscriber(final EventEnum eventType, EventListener listener){
        var selectedListerners = listeners.get(eventType);
        selectedListerners.add(listener);
    }

    public void notify(final EventEnum eventType){
        listeners.get(eventType).forEach(l ->l.update(eventType));
    }
}
