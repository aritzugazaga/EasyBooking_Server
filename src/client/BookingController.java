package client;

public class BookingController {
	
	public static BookingController instance;
	
	public static BookingController getInstance() {
		if (instance == null) {
			try {
				instance = new BookingController();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		return instance;
	
	}

}
