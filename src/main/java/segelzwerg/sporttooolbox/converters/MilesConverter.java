package segelzwerg.sporttooolbox.converters;

import segelzwerg.sporttooolbox.iunits.distance.Distance;
import segelzwerg.sporttooolbox.iunits.distance.Kilometer;
import segelzwerg.sporttooolbox.iunits.distance.Miles;
import segelzwerg.sporttooolbox.iunits.distance.Nautical;
import static segelzwerg.sporttooolbox.converters.DistanceConverterService.*;

public class MilesConverter implements DistanceConverter {

	@Override
	public Distance convertTo(Distance fromDistance, Distance toDistance) {
		if (toDistance instanceof Miles) {
			return fromDistance;
		}

		Miles miles = (Miles) fromDistance;
		float milesAmount = miles.getMiles();

		if (toDistance instanceof Kilometer) {
			return new Kilometer(milesAmount * MILES_TO_KM);
		}
		if (toDistance instanceof Nautical) {
			return new Nautical(milesAmount * NAUTICAL_TO_MILES);
		}
		throw new UnsupportedOperationException(UNSUPPORTED_CONVERT_OPERATION);
	}

	@Override
	public Distance convertFrom(Distance distance) {
		if (distance instanceof Miles) {
			return distance;
		}
		if (distance instanceof Kilometer) {
			Kilometer kilometer = (Kilometer) distance;
			float kilometerAmount = kilometer.getKilometer();
			return new Miles(kilometerAmount * MILES_TO_KM);
		}
		if (distance instanceof Nautical) {
			Nautical nautical = (Nautical) distance;
			double nauticalAmount = nautical.getNautical();
			return new Miles(nauticalAmount * MILES_TO_NAUTICAL);
		}
		throw new UnsupportedOperationException(UNSUPPORTED_CONVERT_OPERATION);
	}
}
