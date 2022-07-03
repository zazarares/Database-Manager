package Model;
/**
 * datatype for storing orders
 * @author Hotupan Rares
 * @version 1.0
 * @since 2022-05-16
 */
public class comanda {
private int id;
private int IDClient;
private int IDProduct;
private int numar_elemente;
public comanda(int id,int IDClient,int IDProduct,int numar_elemente)
{
	this.id=id;
	this.IDClient=IDClient;
	this.IDProduct=IDProduct;
	this.numar_elemente=numar_elemente;
}
public int getID()
{
	return id;
}
public int getIDClient()
{
	return IDClient;
}
public int getIDProduct()
{
	return IDProduct;
}
public int getNumarElemente()
{
	return numar_elemente;
}
public void setIDClient(int ID)
{
	this.IDClient=ID;
}
public void setIDProdus(int ID)
{
	this.IDProduct=ID;
}
public void setNumarElemente(int numar)
{
	this.numar_elemente=numar;
}
}

