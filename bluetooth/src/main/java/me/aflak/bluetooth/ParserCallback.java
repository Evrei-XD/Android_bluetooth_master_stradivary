package me.aflak.bluetooth;

public interface ParserCallback {
    void givsLenhgt (Integer lenght);
    void givsRequest (Boolean request);
    void givsChannel (int channel);
    void givsRegister (Integer register);
    void givsCorrectAcceptance (Boolean correct_acceptence);
}
