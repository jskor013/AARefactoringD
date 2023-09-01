import java.util.Date;

public enum STATUS {
    RENTED, RETURNED
}

public class Rental {
	private Video video ;
	private int status ; // 0 for Rented, 1 for Returned
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = RENTED ;
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}

	public int getStatus() {
		return status;
	}

	public void returnVideo() {
		if ( status == STATUS.RETURNED ) {
			this.status = STATUS.RETURNED;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}
	
	public int getDaysRentedLimit() {
		int limit = 0 ;
		int daysRented ;
		if (getStatus() == STATUS.RETURNED) { // returned Video
			daysRented = getDaysRented(Date date, Date rentDate);
		} else { // not yet returned
			daysRented = getDaysRented(Date date, Date rentDate);
		}
		if ( daysRented <= 2) return limit ;

		switch ( video.getVideoType() ) {
			case Video.VHS: limit = 5 ; break ;
			case Video.CD: limit = 3 ; break ;
			case Video.DVD: limit = 2 ; break ;
		}
		return limit ;
	}
	
	public int getDaysRented(Date date, Date rentDate){
		final int hour=60, min=60, second=60, milisecond=1000;
		long diff = new Date().getTime() - rentDate.getTime();
		int daysRented = (int) (diff / (milisecond * second * min * hour)) + 1;
		return daysRented;
	}
	public double calEachCharge(int daysRented) {
		double eachCharge = 0;
		switch (video.getPriceCode()) {
			case Video.REGULAR:
				eachCharge += 2;
				if (daysRented > 2)
					eachCharge += (daysRented - 2) * 1.5;
				break;
			case Video.NEW_RELEASE:
				eachCharge = daysRented * 3;
				break;
		}
		return eachCharge;
	}
	public int calEachPoint(int daysRented) {
		int eachPoint = 0 ;
		eachPoint++;

		if ((getVideo().getPriceCode() == Video.NEW_RELEASE) )
			eachPoint++;

		if ( daysRented > getDaysRentedLimit() )
			eachPoint -= Math.min(eachPoint, getVideo().getLateReturnPointPenalty()) ;
		return eachPoint;
	}
}
