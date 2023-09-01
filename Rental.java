import java.util.Date;

public class Rental { // DATA Class로 운영됨
	private Video video ;
	private int status ; // 0 for Rented, 1 for Returned // enum 처리
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = 0 ;
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	} // dead code

	public int getStatus() {
		return status;
	}

	public void returnVideo() {
		if ( status == 1 ) {
			this.status = 1;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	} // dead code

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	} // dead code

	public int getDaysRentedLimit() { // feature envy
		int limit = 0 ;
		int daysRented ;
		if (getStatus() == 1) { // returned Video
			daysRented = getDiffTime(returnDate.getTime(), rentDate.getTime());	
		} else { // not yet returned
			daysRented = getDiffTime(Date().getTime(), rentDate.getTime());
		}
		if ( daysRented <= 2) return limit ;

		switch ( video.getVideoType() ) {
			case Video.VHS: limit = 5 ; break ;
			case Video.CD: limit = 3 ; break ;
			case Video.DVD: limit = 2 ; break ;
		}
		return limit ;
	}
	
	public daysRented getDaysRented(Date dateA, Data dateB){
		long diff = new Date().getTime() - rentDate.getTime();
		daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
		return daysRented;
	}
}
