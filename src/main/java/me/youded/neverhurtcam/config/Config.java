package me.youded.neverhurtcam.config;

public class Config {
    public static volatile float hurtfloat = 0.0F;
    public static volatile boolean checked = false;

    public static void setHurtFloat(float val) {
        Config.hurtfloat = val;
    }

    public static void setHurtFloat(String val) {
        if (val != null && !val.isBlank())
            try {
                Config.hurtfloat = Float.parseFloat(val);
            } catch (Exception e) {
            }
    }

    public static void checkProperty() {
        Config.checked = true;
        try {
            if (System.getProperty("neverhurtcam") != null
                    && !System.getProperty("neverhurtcam").isBlank())
                Config.hurtfloat = Float.parseFloat(System.getProperty("neverhurtcam"));
        } catch (Exception e) {
        }
    }
}
