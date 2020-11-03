package segelzwerg.sporttooolbox.converters;

import segelzwerg.sporttooolbox.iunits.distance.Distance;
import segelzwerg.sporttooolbox.iunits.distance.Kilometer;
import segelzwerg.sporttooolbox.iunits.distance.Miles;
import segelzwerg.sporttooolbox.iunits.distance.Nautical;
import static segelzwerg.sporttooolbox.converters.DistanceConverterService.*;

public class KilometerConverter implements DistanceConverter {

	@Override
	public Distance convertTo(Distance fromDistance, Distance toDistance) {
		if (toDistance instanceof Kilometer) {
			return fromDistance;
		}

		Kilometer kilometer = (Kilometer) fromDistance;
		float kilometerAmount = kilometer.getKilometer();

		if (toDistance instanceof Miles) {
			return new Miles(kilometerAmount * KILOMETER_TO_MILES);
		}
		if (toDistance instanceof Nautical) {
			return new Nautical(kilometerAmount * KILOMETER_TO_NAUTICAL);
		}
		throw new UnsupportedOperationException(UNSUPPORTED_CONVERT_OPERATION);
	}

	@Override
	public Distance convertFrom(Distance distance) {
		if (distance instanceof Kilometer) {
			return distance;
		}
		if (distance instanceof Miles) {
			Miles miles = (Miles) distance;
			float milesAmount = miles.getMiles();
			return new Kilometer(milesAmount * MILES_TO_KM);
		}
		if (distance instanceof Nautical) {
			Nautical nautical = (Nautical) distance;
			double nauticalAmount = nautical.getNautical();
			return new Kilometer(nauticalAmount * NAUTICAL_TO_KM);
		}
		throw new UnsupportedOperationException(UNSUPPORTED_CONVERT_OPERATION);
	}
}
