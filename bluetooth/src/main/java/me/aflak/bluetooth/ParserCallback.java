package me.aflak.bluetooth;

public interface ParserCallback {
    Integer givsLenhgt (int lenght);
//    void lol (Integer intege, setText text);
    void givsRequest (Boolean request);
    void givsChannel (int channel);
    void givsLevelCH (int levelCH);
    void givsRegister (Integer register);
    void givsCorrectAcceptance (Boolean correct_acceptence);
}
