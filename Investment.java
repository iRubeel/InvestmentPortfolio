
public abstract class Investment 
{
    /**
     * instance variable for investment class
     */
    String type;
    String symbol;
    String name;
    int quantity;
    float price;
    float bookvalue;

    /**
     * Class Constructor for Investment
     */
    Investment()
    {
        type = "";
        symbol = "";
        name = "";
        quantity = 0;
        price = 0.00f;
        bookvalue = 0.00f;
    }
    
    /**
     * @param newType sets the investment type 
     */
    public void setType(String newType)
    {
        type = newType;
    }

    /**
     * 
     * @param newSymbol sets the symbol for the investment
     */
    public void setSymbol(String newSymbol)
    {
        symbol = newSymbol; 
    }
    /**
     * 
     * @param newName sets the name for the investment
     */
    public void setName(String newName)
    {
        name = newName;
    }
    /**
     * 
     * @param newQuantity sets the Quantity for the investment
     */
    public void setQuantity(int newQuantity)
    {
        quantity = newQuantity;
    }

    /**
     * 
     * @param newPrice sets the price for the investment
     */
    public void setPrice(float newPrice)
    {
        price = newPrice;
    }
    /**
     * 
     * @param newBookvalue sets the bookvalue for the investment
     */
    public void setBookvalue(float newBookvalue)
    {
        bookvalue = newBookvalue ;
    }

    /**
     * returns the type in the investment
     * @return type 
     */
    public String getType()
    {
        return type; 
    }
    /**
     * returns the symbol in the investment
     * @return symbol 
     */
    public String getSymbol()
    {
        return symbol;
    }
    /**
     * returns the name in the investment
     * @return name
     */
    public String getName()
    {
        return name;
    }
    /**
     * returns the quantity in the investment
     * @return quantity
     */
    public int getQuantity ()
    {
        return quantity;
    }
    /**
     * returns the price in the investment
     * @return price 
     */
    public float getPrice()
    {
        return price;
    }
    /**
     * returns the bookvalue in the investment
     * @return bookvalue
     */
    public float getBookvalue()
    {
        return bookvalue;
    }
    /**
     * 
     * @return a string with all the content in the investment class
     */
    public String toString()
    {
        return "\nType: " + type + "\n" + "Symbol: " + symbol + "\n" + "Name: " + name + "\n" + "Quantity: " + quantity + "\n" + "Price: " + price + "\n" + "BookValue: " + bookvalue+ "\n"; 
    }

    
    /**
     * 
     * @param newQuantity is used to update the bookvalue when selling an investment
     */
    public void sellUpdatesBookvalue(float newQuantity) 
    {
        bookvalue = bookvalue * ( newQuantity / quantity) ; 
    }

    /**
     * This method is being overrided buy the method in the subclass 
     * @param newPrice is the price used to calculate to calculate bookvalue 
     * @param newQuantity is the quantity which is being to calculate bookvalue 
     */

    public abstract void calculateBookvalue(float newPrice, int newQuantity);
    public abstract float calculatePayment(float Price, int Quantity);
    public abstract float calculateGain(float Price, int Quantity, float BookValue);
}