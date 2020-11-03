package segelzwerg.sporttooolbox.converters;

import segelzwerg.sporttooolbox.iunits.distance.Distance;
import segelzwerg.sporttooolbox.iunits.distance.Kilometer;
import segelzwerg.sporttooolbox.iunits.distance.Miles;
import segelzwerg.sporttooolbox.iunits.distance.Nautical;
import static segelzwerg.sporttooolbox.converters.DistanceConverterService.*;


public class NauticalConverter implements DistanceConverter {

	@Override
	public Distance convertTo(Distance fromDistance, Distance toDistance) {
		if (toDistance instanceof Nautical) {
			return fromDistance;
		}

		Nautical nautical = (Nautical) fromDistance;
		double nauticalAmount = nautical.getNautical();

		if (toDistance instanceof Kilometer) {
			return new Kilometer(nauticalAmount * NAUTICAL_TO_KM);
		}
		if (toDistance instanceof Miles) {
			return new Miles(nauticalAmount * NAUTICAL_TO_MILES);
		}
		throw new UnsupportedOperationException(UNSUPPORTED_CONVERT_OPERATION);
	}

	@Override
	public Distance convertFrom(Distance distance) {
		if (distance instanceof Nautical) {
			return distance;
		}
		if (distance instanceof Kilometer) {
			Kilometer kilometer = (Kilometer) distance;
			float kilometerAmount = kilometer.getKilometer();
			return new Nautical(kilometerAmount * KILOMETER_TO_NAUTICAL);
		}
		if (distance instanceof Miles) {
			Miles miles = (Miles) distance;
			float milesAmount = miles.getMiles();
			return new Nautical(milesAmount * MILES_TO_NAUTICAL);
		}
		throw new UnsupportedOperationException(UNSUPPORTED_CONVERT_OPERATION);
	}
}
