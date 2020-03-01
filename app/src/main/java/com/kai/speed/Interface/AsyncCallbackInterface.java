package com.kai.speed.Interface;

public interface AsyncCallbackInterface {
    public void SeqWriteTaskCallback(int iteration);
    public void SeqReadTaskCallback(int iteration);
    public void RndWriteTaskCallback(int iteration);
    public void RndReadTaskCallback(int iteration);
}
