package datasqltest;

public class ProfileModel extends ModelTable{
    private String imgSrc;
    private String color;

    public ProfileModel(int id,String name, double price, int quantity,String imgSrc,String color){
        super(id, quantity,price, name);
        this.imgSrc = imgSrc;
        this.color= color;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
