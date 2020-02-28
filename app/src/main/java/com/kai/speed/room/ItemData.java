package com.kai.speed.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class ItemData implements Serializable {
    @PrimaryKey(autoGenerate = true)//主鍵是否自動增長，預設為false
    private long id;
    private String title;
    private int listIdx;
    private int index, timeIndex, comIndex, homeIdx;
    private int dueYear, dueMonth, dueDate, dueHour, dueMinute;
    private int createYear, createMonth, createDate;
    private int reminderType;
    private int progress;
    private String photo;
    private String note;
    private ArrayList<Long> notificationTimeList;
    private boolean complete, isDueSet, isReminderFieldSet, isPhotoSet, isNoteSet, isLongTerm;
    private long createTimestamp; // timestamp of create time

    public ItemData(){
        this.title = " ";
        this.complete = false;
        this.isDueSet = false;
        this.isReminderFieldSet = false;
        this.isPhotoSet = false;
        this.isNoteSet = false;
        this.isLongTerm = false;
        this.progress = 0;
        this.notificationTimeList = new ArrayList<>();
        this.createTimestamp = 0L;
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

    public int getTimeIndex() {  // the order in time list
        return this.timeIndex;
    }
    public void setTimeIndex(int index) {
        this.timeIndex = index;
    }

    public int getComIndex() {  // the order in complete list
        return this.comIndex;
    }
    public void setComIndex(int index) {
        this.comIndex = index;
    }

    public int getHomeIdx() {  // the order in home list
        return this.homeIdx;
    }
    public void setHomeIdx(int index) {
        this.homeIdx = index;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return  this.title;
    }

    public void setPhoto(String photo){
        this.photo = photo;
    }
    public String getPhoto(){
        return this.photo;
    }

    public void setNote(String note){
        this.note = note;
    }
    public String getNote(){
        return this.note;
    }

    public void setListIdx(int listIdx){
        this.listIdx = listIdx;
    }
    public int getListIdx(){
        return this.listIdx;
    }

    public void setDueYear(int year){this.dueYear = year;}
    public int getDueYear(){return this.dueYear;}

    public void setDueMonth(int month){this.dueMonth = month;}
    public int getDueMonth(){return this.dueMonth;}

    public void setDueDate(int date){this.dueDate = date;}
    public int getDueDate(){return this.dueDate;}

    public void setDueHour(int hour){this.dueHour = hour;}
    public int getDueHour(){return this.dueHour;}

    public void setDueMinute(int minute){this.dueMinute = minute;}
    public int getDueMinute(){return this.dueMinute;}

    public void setCreateYear(int year){this.createYear = year;}
    public int getCreateYear(){return this.createYear;}

    public void setCreateMonth(int month){this.createMonth = month;}
    public int getCreateMonth(){return this.createMonth;}

    public void setCreateDate(int date){this.createDate = date;}
    public int getCreateDate(){return this.createDate;}

    public boolean getComplete(){return this.complete;}
    public void setComplete(boolean bool){this.complete = bool;}

    public int getReminderType() {
        return reminderType;
    }

    public void setReminderType(int reminderType) {
        this.reminderType = reminderType;
    }

    public boolean isDueSet() {
        return isDueSet;
    }

    public void setDueSet(boolean dueSet) {
        isDueSet = dueSet;
    }

    public boolean isReminderFieldSet() {
        return isReminderFieldSet;
    }

    public void setReminderFieldSet(boolean reminderFieldSet) {
        isReminderFieldSet = reminderFieldSet;
    }

    public boolean isPhotoSet() {
        return isPhotoSet;
    }

    public void setPhotoSet(boolean photoSet) {
        isPhotoSet = photoSet;
    }

    public boolean isNoteSet() {
        return isNoteSet;
    }

    public void setNoteSet(boolean noteSet) {
        isNoteSet = noteSet;
    }

    public ArrayList<Long>  getNotificationTimeList() { return notificationTimeList; }
    public void setNotificationTimeList(ArrayList<Long> notifyTimes) {
        notificationTimeList = notifyTimes;
    }

    public boolean isLongTerm() {
        return isLongTerm;
    }

    public void setLongTerm(boolean longTerm) {
        isLongTerm = longTerm;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(long timestamp) {
        if (createTimestamp == 0L) {
            createTimestamp = timestamp;
        }
    }
}
