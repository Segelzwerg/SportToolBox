package segelzwerg.sporttooolbox.converters;

import segelzwerg.sporttooolbox.iunits.distance.Distance;
import segelzwerg.sporttooolbox.iunits.distance.Kilometer;
import segelzwerg.sporttooolbox.iunits.distance.Miles;
import segelzwerg.sporttooolbox.iunits.distance.Nautical;

import java.util.HashMap;
import java.util.Map;

public class DistanceConverterService {

	public static double KILOMETER_TO_METERS = 1000;
	public static double KILOMETER_TO_MILES = 0.621371;
	public static double KILOMETER_TO_NAUTICAL = 0.539957;

	public static double MILES_TO_KM = 1.6093444;
	public static double MILES_TO_NAUTICAL = 0.868976;
	public static double MILES_TO_YARDS = 1760.0;

	public static double NAUTICAL_TO_KM = 1.852;
	public static double NAUTICAL_TO_MILES = 1.15078;
	public static double NAUTICAL_TO_FATHOMS = 1012.685914261;
	public static double FATHOMS_TO_NAUTICAL = 0.000987473;

	public static String UNSUPPORTED_CONVERT_OPERATION = "No convert operations for this instance!";

	public static Map<Class, DistanceConverter> converters = initConverters();

	private static Map<Class, DistanceConverter> initConverters() {
		Map<Class,DistanceConverter> map = new HashMap<>();
		map.put(Kilometer.class, new KilometerConverter());
		map.put(Miles.class, new MilesConverter());
		map.put(Nautical.class, new NauticalConverter());
		return map;
	}

	public static <T extends Distance> T convertTo(Distance fromDistance, Distance toDistance) {
		DistanceConverter distanceConverter = converters.get(fromDistance.getClass());
		return (T) distanceConverter.convertTo(fromDistance, toDistance);
	}

	public static <T extends Distance> T convertFrom(Distance fromDistance, Distance toDistance) {
		DistanceConverter distanceConverter = converters.get(toDistance.getClass());
		return (T) distanceConverter.convertFrom(fromDistance);
	}
}
