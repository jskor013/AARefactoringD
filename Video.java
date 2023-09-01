import java.util.Date;

public abstract class Video {
	private String title;

	private int priceCode;
	public static final int REGULAR = 1;
	public static final int NEW_RELEASE = 2;


	private Date registeredDate;
	private boolean rented;

	public Video(String title, int priceCode, Date registeredDate) {
		this.setTitle(title);
		this.setPriceCode(priceCode);
		this.registeredDate = registeredDate;
	}

	abstract public int getVideoType();
	abstract public int getLateReturnPointPenalty();

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

}

public class VHS extends Video {

	public VHS(String title, int priceCode, Date registeredDate) {
		super(title, priceCode, registeredDate);
		// TODO Auto-generated constructor stub
	}

	public int getLateReturnPointPenalty() {
		return 1;
	}
	
	public int getVideoType()
	{
		return 1;
	}
}


public class CD extends Video {

	public CD(String title, int priceCode, Date registeredDate) {
		super(title, priceCode, registeredDate);
		// TODO Auto-generated constructor stub
	}

	public int getLateReturnPointPenalty() {
		return 2;
	}
	
	public int getVideoType()
	{
		return 1;
	}
}


public class DVD extends Video {

	public DVD(String title, int priceCode, Date registeredDate) {
		super(title, priceCode, registeredDate);
		// TODO Auto-generated constructor stub
	}

	public int getLateReturnPointPenalty() {
		return 3;
	}
	
	public int getVideoType()
	{
		return 3;
	}
}
