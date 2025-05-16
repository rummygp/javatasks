public enum Type {
    CHILD (0.5),
    ADULT (1.0),
    SENIOR(0.3);

     private final double discount;

     Type(double discount) {
         this.discount = discount;
     }

     public double priceDiscount(double price) {
         return price * discount;
     }
}
