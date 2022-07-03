package BussinessLayer;
import dao.*;
/**
 * finds first available id
 * @author Hotupan Rares
 * @version 1.0
 * @since 2022-05-16
 */
public class IdFinder {
	public static int getNewClientId()
	{
		int t=0;
		while(ClientDAO.findById(t)!=null)
			t++;
		return t;
	}
	public static int getNewProductId()
	{
		int t=0;
		while(ProductDAO.findById(t)!=null)
			t++;
		return t;
	}
	public static int getNewOrderId()
	{
		int t=0;
		while(OrderDAO.findById(t)!=null)
			t++;
		return t;
	}
}
