package com.playo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.playo.demo.utils.enums.RequestStatusEnum;
import javax.persistence.*;

import java.util.Objects;

@Entity
public class Request {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private RequestStatusEnum status = RequestStatusEnum.PENDING;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id", nullable = false, updatable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name="activity_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Activity activity;

    protected Request() {}

    public Request(Player player, Activity activity) {
        this.player = player;
        this.activity = activity;
    }

    public Long getId() {
        return id;
    }

    public RequestStatusEnum getStatus() {
        return status;
    }

    public Player getPlayer() {
        return player;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setStatus(RequestStatusEnum status) {
        if(this.status == RequestStatusEnum.PENDING && status != RequestStatusEnum.PENDING) {
            this.status = status;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return Objects.equals(id, request.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
