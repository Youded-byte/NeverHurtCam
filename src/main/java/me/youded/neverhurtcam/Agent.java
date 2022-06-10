package me.youded.neverhurtcam;

import java.lang.instrument.Instrumentation;

import me.youded.neverhurtcam.config.Config;
import me.youded.neverhurtcam.asm.Transformer;

public class Agent {
    public static void premain(String args, Instrumentation inst) {
        Config.checkProperty();
        Config.setHurtFloat(args);
        inst.addTransformer(new Transformer());
    }
}