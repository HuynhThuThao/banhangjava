package Model;

public class product {
    private int ID;  // Chuyển ID thành kiểu int
    private String Name;
    private String TypeID;
    private double Price;
    private String Image;
    private boolean Trend;
    private boolean Popular;
    private boolean Saleoff;

    public product() {
    }

    public product(int ID, String Name, String TypeID, double Price, String Image, boolean Trend, boolean Popular, boolean Saleoff) {
        super();
        this.ID = ID;
        this.Name = Name;
        this.TypeID = TypeID;
        this.Price = Price;
        this.Image = Image;
        this.Trend = Trend;
        this.Popular = Popular;
        this.Saleoff = Saleoff;
    }

    // Thêm constructor để tạo đối tượng từ dữ liệu kiểu int ID
    public product(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTypeID() {
        return TypeID;
    }

    public void setTypeID(String typeID) {
        TypeID = typeID;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public boolean isTrend() {
        return Trend;
    }

    public void setTrend(boolean trend) {
        Trend = trend;
    }

    public boolean isPopular() {
        return Popular;
    }

    public void setPopular(boolean popular) {
        Popular = popular;
    }

    public boolean isSaleoff() {
        return Saleoff;
    }

    public void setSaleoff(boolean saleoff) {
        Saleoff = saleoff;
    }

    @Override
    public String toString() {
        return "product [ID=" + ID + ", Name=" + Name + ", TypeID=" + TypeID + ", Price=" + Price + ", Image=" + Image
                + ", Trend=" + Trend + ", Popular=" + Popular + ", Saleoff=" + Saleoff + "]";
    }
}
