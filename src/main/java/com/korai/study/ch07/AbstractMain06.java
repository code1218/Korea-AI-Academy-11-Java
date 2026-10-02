package com.korai.study.ch07;

import java.util.ArrayList;
import java.util.List;

public class AbstractMain06 {
    public static void main(String[] args) {
        List<RemoteControl> remoteControls = List.of(
                new TvRemoteControl(),
                new MonitorRemoteControl(),
                new TvRemoteControl(),
                new MonitorRemoteControl()
        );

        for (int i = 0; i < remoteControls.size(); i++) {
            RemoteControl r = remoteControls.get(i);
            r.powerOn();
        }

        for (RemoteControl r : remoteControls) {
            r.powerOn();
        }

//        RemoteControl r = new RemoteControl(); 추상클래스는 생성할 수 없다.
    }
}

interface Sensor {
    void send();
    void on();
    void off();

    default void send2() {

    }
}

abstract class RemoteControl implements Sensor {
    // 리모컨
    String modelName;

    void showModelName() {
        System.out.println(modelName);
    }

    abstract void powerOn();
}

class TvRemoteControl extends RemoteControl {
    @Override
    void powerOn() {
        System.out.println("TV 회로에 맞게 전원 공급");
    }

    @Override
    public void send() {

    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }
}

class MonitorRemoteControl extends RemoteControl {
    @Override
    void powerOn() {
        System.out.println("모니터 회로에 맞게 전원 공급");
    }

    @Override
    public void send() {

    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }
}






