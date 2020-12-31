package online.bakery;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class Balloon implements BirthdayItems{

    private final int itemId ;
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    String name;
    String material;
    String color;
    BigDecimal cost ;

    public Balloon(String name,BigDecimal cost,String material,String color){
        this.itemId=atomicInteger.incrementAndGet();
        this.name = name;
        this.cost = cost;
        this.material = material;
        this.color = color;
    }

    public String getDescription(){
        String s = name + "\nmaterial : " + material + "\n color : "+color + "\n" + cost + " Tooman" ;
        return s;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name; }

    public BigDecimal getCost() {
        return cost;
    }
    public void setCost(BigDecimal cost) { this.cost = cost; }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {this.color = color; }

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {this.material = material; }
}