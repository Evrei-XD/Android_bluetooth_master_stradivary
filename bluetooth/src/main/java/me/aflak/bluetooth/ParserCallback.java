package me.aflak.bluetooth;

public interface ParserCallback {
    void givsLenhgt (int lenght);
    void givsRequest (boolean request);
    void givsChannel (char channel);
    void givsRegister (int register);
    void givsCorrectAcceptance (boolean correct_acceptence);
}
