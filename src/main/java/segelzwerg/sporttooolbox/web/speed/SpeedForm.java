package segelzwerg.sporttooolbox.web.speed;

import lombok.Data;
import segelzwerg.sporttooolbox.IUnits.Pace;
import segelzwerg.sporttooolbox.IUnits.Speed;

@Data
public class SpeedForm {
    private int major;
    private int minor;
    private int hour;
    private int minute;
    private int second;
    private String distanceMajorUnit;
    private String distanceMinorUnit;
    /**
     * represents the result unit
     *
     * @deprecated This is no longer supported. It will be removed.
     * Use {@link SpeedForm#speedUnit} or {@link SpeedForm#paceUnit} instead.
     */
    @Deprecated
    private String resultUnit;
    private Speed speed;
    private String speedUnit;
    private Pace pace;
    private String paceUnit;
}
