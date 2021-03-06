package com.example.producingwebservice;

import io.spring.guides.gs_producing_web_service.GetMusicRequest;
import io.spring.guides.gs_producing_web_service.GetMusicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class MusicEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private MusicRepository musicRepository;

    @Autowired
    public MusicEndpoint(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMusicRequest")
    @ResponsePayload
    public GetMusicResponse getGroup(@RequestPayload GetMusicRequest request) {
        GetMusicResponse response = new GetMusicResponse();
        response.setMusicGroup(musicRepository.findGroup(request.getName()));

        return response;
    }



}
