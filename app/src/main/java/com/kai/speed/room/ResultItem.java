package com.kai.speed.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class ResultItem implements Serializable {
    @PrimaryKey(autoGenerate = true)//主鍵是否自動增長，預設為false
    private long id;
    private String createDate;
    private int index;
    private int seqRdSpeed, seqWrSpeed, ranRdSpeed, ranWrSpeed,
                mixRdSpeed, mixWrSpeed;

    public ResultItem(){
        this.createDate = " ";
        this.index = 0;
        this.mixRdSpeed = this.ranRdSpeed = this.seqRdSpeed = 0;
        this.mixWrSpeed = this.ranWrSpeed = this.seqWrSpeed = 0;

    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getSeqRdSpeed() {
        return seqRdSpeed;
    }

    public void setSeqRdSpeed(int seqRdSpeed) {
        this.seqRdSpeed = seqRdSpeed;
    }

    public int getSeqWrSpeed() {
        return seqWrSpeed;
    }

    public void setSeqWrSpeed(int seqWrSpeed) {
        this.seqWrSpeed = seqWrSpeed;
    }

    public int getRanRdSpeed() {
        return ranRdSpeed;
    }

    public void setRanRdSpeed(int ranRdSpeed) {
        this.ranRdSpeed = ranRdSpeed;
    }

    public int getRanWrSpeed() {
        return ranWrSpeed;
    }

    public void setRanWrSpeed(int ranWrSpeed) {
        this.ranWrSpeed = ranWrSpeed;
    }

    public int getMixRdSpeed() {
        return mixRdSpeed;
    }

    public void setMixRdSpeed(int mixRdSpeed) {
        this.mixRdSpeed = mixRdSpeed;
    }

    public int getMixWrSpeed() {
        return mixWrSpeed;
    }

    public void setMixWrSpeed(int mixWrSpeed) {
        this.mixWrSpeed = mixWrSpeed;
    }
}
