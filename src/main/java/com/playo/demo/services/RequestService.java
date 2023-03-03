package com.playo.demo.services;

import com.playo.demo.dtos.JoinRequestDto;
import com.playo.demo.entities.Activity;
import com.playo.demo.entities.Player;
import com.playo.demo.entities.Request;
import com.playo.demo.repositories.RequestRepository;
import com.playo.demo.utils.enums.RequestStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RequestService {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private RequestRepository requestRepository;

    public RequestStatusEnum addRequest(JoinRequestDto joinRequestDto) throws Exception {
        Player player = this.playerService.getPlayerDetails(joinRequestDto.getPlayerId());
        Activity activity = this.activityService.findById(joinRequestDto.getActivityId());
        Request request = new Request(player, activity);
        this.requestRepository.save(request);

        return request.getStatus();
    }
}
