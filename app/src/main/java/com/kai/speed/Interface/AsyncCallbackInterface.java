package com.kai.speed.Interface;

public interface AsyncCallbackInterface {
    public void SeqWriteTaskCallback(int iteration);
    public void SeqReadTaskCallback();
    public void RndWriteTaskCallback();
    public void RndReadTaskCallback();
}
