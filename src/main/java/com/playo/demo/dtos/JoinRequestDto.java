package com.playo.demo.dtos;

import javax.validation.constraints.NotNull;

public class JoinRequestDto {
    @NotNull
    private Long activityId;
    @NotNull
    private Long playerId;

    public JoinRequestDto(Long activityId, Long playerId) {
        this.activityId = activityId;
        this.playerId = playerId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public Long getPlayerId() {
        return playerId;
    }
}
