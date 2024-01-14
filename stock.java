
public class stock extends Investment
{
    /**
     * constructor for stock
     */
    stock()
    {
        super();
    }
    /**
     * @param newPrice is price being passed which is being used to calculate bookvalue for Stock
     * @param newQuantity is the quantity which is being to calculate bookvalue for Stock
     * calculates the bookvalue and changes the bookvalue for stock
     */
    @Override
    public void calculateBookvalue(float newPrice, int newQuantity)
    {
        bookvalue = bookvalue + (newPrice * newQuantity ) + 9.99f;
    }


    /**
     * calculates the payment according to the parameters
     */
    @Override
    public float calculatePayment( float Price, int Quantity)
    {
        float stockFee = 9.99f;
        float payment = 0;

        payment = (Price * Quantity) - stockFee;

        return payment;
    }
    /**
     * calculates the gain according to the parameters 
     */
    @Override
    public float calculateGain(float Price, int Quantity, float BookValue)
    {
        float stockFee = 9.99f;
        float gain = 0;

        gain =  ( Price * Quantity) - stockFee  - BookValue;
        
        return gain;
    }
}
