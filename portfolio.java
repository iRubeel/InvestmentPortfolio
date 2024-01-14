
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.io.PrintWriter;
import java.security.Key;

public class portfolio
{
    ArrayList <Investment> investmentList = new ArrayList<Investment>();
    HashMap <String, ArrayList<Integer>> Index = new HashMap <String, ArrayList<Integer>> ();

    /**
     * check if the parameter symbol exists in the investmentlist or not
     * @param symbol
     * @return
     */
    public boolean checkSymbolExits(String symbol)
    {
        boolean checkSymbol = false;

        for( int i = 0 ; i < investmentList.size(); i++ )
            {
                if(symbol.equals(investmentList.get(i).symbol) )
                {
                    checkSymbol = true;
                }
            }
        return checkSymbol;
    } 

    /**
     * validates the parameter price 
     * @param Price
     * @return
     */
    public boolean validatePrice(String Price)
    {
        boolean checkBPrice = true;
        float checkprice = 0;
        try
        {
            if(Price.equals(" "))
            {
                checkBPrice = false; 
            }

            checkprice = Float.parseFloat(Price); /**checks if the string contains any alphabets */

            if(checkprice < 0)/**checks if quantity is negetive or not */
            {
                checkBPrice = false; 
            }
        }
        catch(Exception e)
        {
            checkBPrice = false;
        }

        return checkBPrice;

    }


    /**
     * validates the quantity 
     * @param Quantity
     * @return 
     */
    public boolean validatebuyQuantity(String Quantity)
    {
        boolean checkBQuantity = true;
        int checkquantity = 0;
        try
        {
            if(Quantity.equals(" "))
            {
                checkBQuantity = false; 
            }

            checkquantity = Integer.parseInt(Quantity); /**checks if the string contains any alphabets */

            if(checkquantity < 0)/**checks if quantity is negetive or not */
            {
                checkBQuantity = false; 
            }
        }
        catch(Exception e)
        {
            checkBQuantity = false;
        }
        return checkBQuantity;
    }

    /**
     * validates the parameter name
     * @param name
     * @return true if it is validated and false otherwise
     */
    public boolean validateName(String name)
    {
        boolean checkSName = true;

        if( name.equals(""));
        {
            checkSName = false;
        }

        return checkSName;

    }
    /**
     *  
     * @param symbol validates the string symbol accoring to the requiremnts 
     * @return true if it is validated and false otherwise
     */
    public boolean validateSymbol(String symbol)
    {
        boolean checkSymbol = true;

        if( symbol.equals(""))
        {
            checkSymbol = false;
        }

        return checkSymbol;
    } 

    /**
     * buys the investment according to the parameters
     * @param Type 
     * @param Symbol 
     * @param Name
     * @param Quantity
     * @param Price
     * @return the index at which the new investment is at in the investmentList so i can print the content of the bought investment 
     */
    public int buyInvestment(String Type, String Symbol, String Name, int Quantity, float Price)
    {
        int investmentNumber = 0;
        float newPrice = 0.00f; 
        int newQuantity = 0;
        int UpdatedQuantity = 0;
        
        for( int i = 0 ; i < investmentList.size(); i++ )
        {
            if(Symbol.equals(investmentList.get(i).symbol) ) /**checks if symbol already exists  */
            {
                newQuantity = Quantity;
                UpdatedQuantity = investmentList.get(i).quantity + newQuantity ;
                investmentList.get(i).setQuantity(UpdatedQuantity);
                newPrice = Price;
                investmentList.get(i).setPrice(newPrice);
                investmentList.get(i).calculateBookvalue(newPrice, newQuantity);
                investmentNumber = i;
            }
        }
                if(Type.equals("Stock"))
                {
                    stock newStock = new stock();
                    newStock.setType(Type);
                    newStock.setSymbol(Symbol);
                    newStock.setName(Name);
                    newStock.setQuantity(Quantity);
                    newStock.setPrice(Price);
                    newStock.calculateBookvalue(Price, Quantity);
                    investmentList.add(newStock);
                    investmentNumber = investmentList.size();
                }
                else
                {
                    MutualFund newMutualFund = new MutualFund();
                    newMutualFund.setType(Type);
                    newMutualFund.setSymbol(Symbol);
                    newMutualFund.setName(Name);
                    newMutualFund.setQuantity(Quantity);
                    newMutualFund.setPrice(Price);
                    newMutualFund.calculateBookvalue(Price, Quantity);
                    investmentList.add(newMutualFund);
                    investmentNumber = investmentList.size();
                } 
            
        
         return investmentNumber;
    }
    
    /**
     * validates the quantity to sell and checks with the existing symbol the value of quantity
     * @param Quantity
     * @param Symbol
     * @return
     */
    public boolean validatesellQuantity(String Quantity, String Symbol)
    {
        boolean checkQuantityB = true; 
        int currentQuantity = 0;
        int oldQuantity = 0;
        try
        {
            if(Quantity.equals(" "))
            {
                checkQuantityB = false; 
            }
            currentQuantity = Integer.parseInt(Quantity); /**checks if the string contains any alphabets */

            if(currentQuantity < 0)/**checks if quantity is negetive or not */
            {
                checkQuantityB = false; 
            }

            for( int i = 0 ; i < investmentList.size(); i++ )
            {
                if(Symbol.equals(investmentList.get(i).symbol) )
                {
                    oldQuantity = investmentList.get(i).getQuantity();
                }
            }
            if( currentQuantity > oldQuantity )
            {
                checkQuantityB = false; 
            }
        }
        catch(Exception e)
        {
            checkQuantityB = false;
        }
        return checkQuantityB;
    }
    
    /**
     * Sells investment with symbol and updates the index of hashmap 
     * @param symbol sells the investment with symbol
     */
    public float sellInvestment(String Symbol,int Quantity, float Price)
    {
        float Payment = -2;
        float mutualFundFee = 45.00f;
        int quantityValue = 0; 
        int previousQuantity = 0;
        int newQuantity = 0;
        float priceValue = 0.00f;
        float stockFee = 9.99f;
        

        for( int i = 0 ; i < investmentList.size(); i++ )
        {
            if(Symbol.equals(investmentList.get(i).symbol) )
            {
                quantityValue = Quantity ;
                previousQuantity = investmentList.get(i).getQuantity();
            }

            newQuantity = previousQuantity-quantityValue;
                    
            priceValue = Price ;
            investmentList.get(i).setPrice(priceValue);
            investmentList.get(i).setQuantity(newQuantity);
            investmentList.get(i).sellUpdatesBookvalue(newQuantity);

            if (Symbol.equals(investmentList.get(i).symbol) && investmentList.get(i).getType().equalsIgnoreCase("mutualfund") )
            {

                Payment = investmentList.get(i).calculatePayment( Price, Quantity);
            }
            else if(Symbol.equals(investmentList.get(i).symbol) && investmentList.get(i).getType().equalsIgnoreCase("stock") )
            {

                Payment =  investmentList.get(i).calculatePayment( Price, Quantity);
                
            }

            if(newQuantity == 0) /** removes the investment if the investment quantity is zero */
            {
                investmentList.remove(i);
            }
        }
        return Payment;
    }

   
    /**
     * calculates the gain according to the parameters at the index
     * @param Price
     * @param Quantity
     * @param BookValue
     * @param index
     * @return
     */
    public float getGain(Float Price, int Quantity, float BookValue, int index )
    {
        float totalGain = 0.00f;
        totalGain = investmentList.get(index).calculateGain(Price,Quantity, BookValue);
        return totalGain;
    }
    /**
     * validates price for search
     * @param Price
     * @return
     */
    public boolean validatePriceSearch(String Price)
    {
        boolean checkBPrice = true;
        float checkprice = 0;

        try
        {
            if(Price.isEmpty())
            {
                checkBPrice = true;
                return checkBPrice;
            }
            
            checkprice = Float.parseFloat(Price); /**checks if the string contains any alphabets */
            if(checkprice < 0)/**checks if quantity is negetive or not */
            {
                checkBPrice = false; 
            }


        }
        catch(Exception e)
        {
            checkBPrice = false;
        }
        return checkBPrice;
    }
    

}

