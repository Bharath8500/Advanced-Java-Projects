package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductBean implements Serializable{
private String pCode;
private String pName;
private float pPrice;
private float pQty;

public ProductBean() {
	super();
}

public String getpCode() {
	return pCode;
}

public void setpCode(String pCode) {
	this.pCode = pCode;
}

public String getpName() {
	return pName;
}

public void setpName(String pName) {
	this.pName = pName;
}

public float getpPrice() {
	return pPrice;
}

public void setpPrice(float pPrice) {
	this.pPrice = pPrice;
}

public float getpQty() {
	return pQty;
}

public void setpQty(float pQty) {
	this.pQty = pQty;
}

@Override
public String toString() {
	return "ProductBean [pCode=" + pCode + ", pName=" + pName + ", pPrice=" + pPrice + ", pQty=" + pQty + "]";
}

}


