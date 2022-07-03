package BussinessLayer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Model.Client;
import Model.Product;
import Model.comanda;
/**
 * writes bills for orders
 * @author Hotupan Rares
 * @version 1.0
 * @since 2022-05-16
 */
public class BillWriter {
		public static void WriteBill(int index,String c,String p,String x)
		{
			File log=new File("bill"+index);
			try {
				FileWriter fw=new FileWriter(log);
				fw.write("Client:"+x);
				fw.write("Produs:"+p);
				fw.write("Cantitate"+c);
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
