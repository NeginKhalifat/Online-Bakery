package online.bakery;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.math.BigDecimal;

public class GiftCard {
    Customer from;
    Customer Owner;
    BigDecimal Price;
    String Note;
    public GiftCard(@NotNull Customer owner, @NotNull BigDecimal price,@Nullable String note,@NotNull Customer from){
        this.Owner=owner;
        this.Price=price;
        this.Note=note;
        this.from=from;
    }

    @Override
    public String toString() {
        return "GiftCard{" +
                "From=" + from +
                ", Owner=" + Owner +
                ", Price=" + Price +
                ", Note='" + Note + '\'' +
                '}';
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public Customer getOwner() {
        return Owner;
    }

    public String getNote() {
        return Note;
    }

    public Customer getFrom() {
        return from;
    }
}
