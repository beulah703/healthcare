package spring.orm.model.input;


public class BillInputModel {
    private String name;
    private String cat;
    private int test;
    private int price;
    private String contact;
    private String type;

    public BillInputModel() {
        // Default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	@Override
	public String toString() {
		return "BillInputModel [name=" + name + ", cat=" + cat + ", test=" + test + ", price=" + price + ", contact="
				+ contact + ", type=" + type + "]";
	}
}
