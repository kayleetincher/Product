import java.util.Objects;
public class Product
{

    private static int IDSeed;
    private String IDNum;
    private String name;
    private String description;
    private double cost;

    public static void setIDseed(int IDseed) {
        Product.IDseed = IDseed;
    }

    public static int getIDseed() {
        return IDseed;
    }

    static private int IDseed = 1;

    public static  void setIDSeed(int IDSeed){Product.IDSeed = IDSeed; }
    public static int getIDSeed(){return IDseed;}


    public Product(String IDNum, String name,String description, double cost)
    {
        this.IDNum = IDNum;
        this.name = name;
        this.description = description;
        this.cost = cost;

    }
    public Product(String name,String description, double cost)
    {
        this.IDNum = this.genIDNum();
        this.name = name;
        this.description = description;
        this.cost = cost;

    }

    public String getIDNum() {
        return IDNum;
    }

    private String genIDNum()
    {
        String newID = "" + IDseed;
        while(newID.length() < 8) {
            newID = "0" + newID;
        }

        IDseed++;
        return newID;
    }
    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Product{" +
                "IDNum='" + IDNum + '\'' +
                ", name='" + name + '\'' +
                ", description ='" + description+ '\'' +
                ", cost =" + cost +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return cost == product.cost && IDNum.equals(product.IDNum) && name.equals(product.name) && description.equals(product.description);
    }

    public String toJSONRecord()
    {
        String retString = "";
        char DQ = '\u0022';  // Assign the double quote char to a variable
        retString =  "{" + DQ + "IDNum" + DQ + ":" + DQ + this.IDNum + DQ + ",";
        retString += DQ + "name" + DQ + ":" + DQ + this.name + DQ + ",";
        retString += " " + DQ + "description"  + DQ + ":" + DQ + this.description + DQ + ",";
        retString += " " + DQ + "cost"  + DQ + ":" + this.cost + "}";

        return retString;
    }

    public String toXMLRecord()
    {
        String retString = "";

        retString = "<Product>" + "<IDNum>" + this.IDNum + "</IDNum>";
        retString += "<name>" + this.name + "</name>";
        retString += "<description>" + this.description + "</description>";
        retString += "<cost>" + this.cost + "</cost></Product>";

        return retString;
    }
    public String toCSVRecord() {
        return  this.IDNum + ", " + this.name + "," + this.description + "," + cost;
    }

}