 public class Order {
        private final String clientName;
        private final String productName;
        private final int quantity;
        private final String region;

        public Order(String clientName, String productName, int quantity, String region) {
            this.clientName = clientName;
            this.productName = productName;
            this.quantity = quantity;
            this.region = region;
        }

        public String getClientName() { return clientName; }
        public String getProductName() { return productName; }
        public int getQuantity() { return quantity; }
        public String getRegion() { return region; }
    }