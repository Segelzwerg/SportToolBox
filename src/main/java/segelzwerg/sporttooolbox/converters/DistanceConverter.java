package segelzwerg.sporttooolbox.converters;

import segelzwerg.sporttooolbox.iunits.distance.Distance;

public interface DistanceConverter {
	Distance convertTo(Distance fromDistance, Distance toDistance);
	Distance convertFrom(Distance fromDistance);
}
