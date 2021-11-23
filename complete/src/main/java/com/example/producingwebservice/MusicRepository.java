package com.example.producingwebservice;


import javax.annotation.PostConstruct;
import java.util.*;

import io.spring.guides.gs_producing_web_service.MusicGroup;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class MusicRepository {
    private static final Map<String, MusicGroup> musicGroups = new HashMap<>();

    @PostConstruct
    public void initData() {
        MusicGroup firstGroup = new MusicGroup();
        Date date = new Date();
        List<String> mans = new ArrayList<>();
        mans.add("One");
        mans.add("Two");
        mans.add("Three");
        firstGroup.setName("Пурген");
        firstGroup.setAlbum(6);
        firstGroup.setParticipants(mans);
        firstGroup.setBaseDate(date);

        musicGroups.put(firstGroup.getName(), firstGroup);

    }

    public MusicGroup findGroup(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return musicGroups.get(name);
    }
}
