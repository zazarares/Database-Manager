package Model;
/**
 * datatype for storing products
 * @author Hotupan Rares
 * @version 1.0
 * @since 2022-05-16
 */
public class Product {
	int id;
	int stock;
	String name;
	public Product(int id,int stock,String name)
	{
		this.id=id;
		this.stock=stock;
		this.name=name;
	}
	public int getStock()
	{
		return stock;
	}
	public String getName()
	{
		return name;
	}
	public void setStock(int stock)
	{
		this.stock=stock;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public int getID() {
		return id;
	}
	
}
