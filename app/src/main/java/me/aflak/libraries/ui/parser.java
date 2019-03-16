package me.aflak.libraries.ui;

import me.aflak.bluetooth.ParserCallback;

class Parser implements ParserCallback {
    private int integer;

    public Parser (int len){
        integer = len;
    }

    private int SwopByte(int twoByte){
        int test =  twoByte;
//        txtbyteout[0] = (byte) test;
//        txtbyteout[1] = (byte) (test >> 8);
        test = (((byte) test) << 16)+test;
        test = test >> 8;
//        System.out.println("старший байт:"+txtbyteout[0]);
//        System.out.println("младший байт:"+txtbyteout[1]);
        System.out.println("свап в инте байт:"+test);
        return test;
    }

    @Override
    public Integer givsLenhgt(int lenght) {
        Integer integer =  new Integer(lenght);
        System.out.println("принятая длинна:"+integer);
        return integer;
    }

    @Override
    public void givsRequest(Boolean request) {
        Boolean bolean = new Boolean(request);
        System.out.println("приём:"+bolean);
    }

    @Override
    public void givsChannel(int channel) {
        Integer charr = new Integer(channel);
        System.out.println("принятая длинна:"+charr);
    }

    @Override
    public void givsLevelCH(int levelCH) {
        Integer charr = new Integer(levelCH);
        System.out.println("принятый уровень CH:"+charr);
    }

    @Override
    public void givsRegister(Integer register) {
        Integer registr = new Integer(register);
        System.out.println("принятая значение регистра:"+registr);
    }

    @Override
    public void givsCorrectAcceptance(Boolean correct_acceptence) {
        Boolean boleann = new Boolean(correct_acceptence);
        System.out.println("проверка CRC:"+boleann);
    }
}
