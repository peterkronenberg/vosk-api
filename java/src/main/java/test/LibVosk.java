package test;

import com.sun.jna.Native;
import com.sun.jna.Pointer;

public class LibVosk {
    static {
        Native.register("vosk");
    }

    LibVosk() {
        
    }

    LibVosk(LogLevel logLevel) {
        vosk_set_log_level(logLevel.getValue());
    }

    public static native void vosk_set_log_level(int level);

    public static native Pointer vosk_model_new(String path);

    public static native void vosk_model_free(Pointer model);

    public static native Pointer vosk_spk_model_new(String path);

    public static native void vosk_spk_model_free(Pointer model);

    public static native Pointer vosk_recognizer_new(Model model, float sample_rate);

    public static native Pointer vosk_recognizer_new_spk(Pointer model, Pointer spkModel, float sample_rate);

    public static native boolean vosk_recognizer_accept_waveform(Pointer recognizer, byte[] data, int len);

    public static native String vosk_recognizer_result(Pointer recognizer);

    public static native String vosk_recognizer_final_result(Pointer recognizer);

    public static native String vosk_recognizer_partial_result(Pointer recognizer);

    public static native void vosk_recognizer_free(Pointer recognizer);

    public void setLogLevel(LogLevel loglevel) {
        vosk_set_log_level(loglevel.getValue());
    }

}
