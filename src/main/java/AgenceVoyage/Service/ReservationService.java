package AgenceVoyage.Service;

import AgenceVoyage.Model.Reservation;

import AgenceVoyage.web.dto.ReservationRegistrationDto;

public interface ReservationService {

	Reservation save(ReservationRegistrationDto reservationDto);
	Reservation reserverOmra(ReservationRegistrationDto reservationDto);
	Reservation reserverhotel(ReservationRegistrationDto reservationDto);
	Reservation reserverVoyage(ReservationRegistrationDto reservationRegistrationDto4);
}
