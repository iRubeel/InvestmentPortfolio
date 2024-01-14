public class MutualFund extends Investment
{   
    /**
     * constructor for MutualFund
     */
    MutualFund()
    {
        super();
    }
    /**
    * @param newPrice is price being passed which is being used to calculate bookvalue for Stock
    * @param newQuantity is the quantity which is being to calculate bookvalue for Stock
    * calculates the bookvalue and changes the bookvalue for MutualFund
    */
    @Override
    public void calculateBookvalue(float newPrice, int newQuantity)
    {
        bookvalue = bookvalue + (newPrice * newQuantity );
    }
    
    /**
     * calculates the payment according to the parameters
     */
    @Override
    public float calculatePayment( float Price, int Quantity)
    {
        float mutualFundFee = 45.00f;
        float payment = 0;

        payment = (Price * Quantity) - mutualFundFee;

        return payment;
    }

    /**
     * calculates the gain according to the parameters 
     */
    @Override
    public float calculateGain(float Price, int Quantity, float BookValue)
    {
        float mutualFundFee = 45.00f;
        float gain = 0;

        gain =  ( Price * Quantity) - mutualFundFee  - BookValue;
            
        return gain;
    }
}
