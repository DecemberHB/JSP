package dto.shop;

public class ProductDTO {
	private int pno;
	private String pname;
	private int stock;
	private int price;
	private String company;
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public void setPno(String pno) {
		if(pno != null) {
			this.pno = Integer.parseInt(pno);
		}
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setStock(String stock) {
		if (stock != null) {
			this.stock = Integer.parseInt(stock);
		}
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPrice(String price) {
		if (price != null) {
			this.price = Integer.parseInt(price);
		}
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "ProductDTO [pno=" + pno + ", pname=" + pname + ", stock=" + stock + ", price=" + price + ", company="
				+ company + "]";
	}
	
	

}
