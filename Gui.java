import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.print.FlavorException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Gui extends JFrame implements ActionListener
{
    public static final int WIDTH = 700;
    public static final int HEIGHT = 600;

    int counter = 0;
    JPanel WelcomePanel = new JPanel();
    JPanel buyPanel = new JPanel();
    JPanel messagePanel = new JPanel();
    JPanel sellPanel = new JPanel();
    JPanel UpdatePanel = new JPanel();
    JPanel gainPanel = new JPanel();
    JPanel searchPanel = new JPanel();
    JPanel buyButtons = new JPanel();
    JPanel sellButtons = new JPanel();
    JPanel updateButtons = new JPanel();
    JPanel searchButtons = new JPanel();

    JButton Reset = new JButton();
    JButton Buys = new JButton();
    JButton Sells = new JButton();
    JButton Prev = new JButton();
    JButton Next = new JButton();
    JButton Saves = new JButton();
    JButton Searches = new JButton();

    JMenuBar Menubar = new JMenuBar();
    JMenu Commands = new JMenu();
    JMenuItem Buy = new JMenuItem();
    JMenuItem Sell = new JMenuItem();
    JMenuItem Update = new JMenuItem();
    JMenuItem getGain = new JMenuItem();
    JMenuItem Search = new JMenuItem();
    JMenuItem Quit = new JMenuItem();

    JTextArea textArea = new JTextArea();

    JComboBox <String> comboBox = new JComboBox <String> ();
    String[] investmentTypes = {"Stock", "MutualFund"};
    String Type;

    JLabel buyOption = new JLabel();
    JLabel sellOption = new JLabel();
    JLabel updateOption = new JLabel();
    JLabel getGainOption = new JLabel();
    JLabel SearchOption = new JLabel();

    JLabel BuySellUpdateOptionMsg = new JLabel();
    JLabel getGainOptionMsg = new JLabel();
    JLabel SearchOptionMsg = new JLabel();

    JTextField symbolField = new JTextField();
    JTextField nameField = new JTextField();
    JTextField quantityField = new JTextField();
    JTextField priceField = new JTextField();
    JTextField totalGain = new JTextField();
    JTextField nameKeywordsField = new JTextField();
    JTextField lowPriceField = new JTextField();
    JTextField highPriceField = new JTextField();
    JTextField gainField = new JTextField();

    portfolio portfolio = new portfolio();

    public Gui()
    {
        super("ePortfolio");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Commands();
        WelcomePanel();
        messagePanel();
        buyPanel();
        
    }
    /**
     * Makes the button for the search panel
     */
    public void searchButtons()
    {
        searchButtons = new JPanel();
        searchButtons.setLayout(new FlowLayout());
        
        JPanel ButtonPos = new JPanel();
        ButtonPos.setLayout(new GridLayout(0,1,20,20));

        Reset = new JButton("Reset");
        ButtonPos.add(Reset);
        Reset.addActionListener(this);

        Searches = new JButton("Search");
        ButtonPos.add(Searches);
        Searches.addActionListener(this);

        searchButtons.add(ButtonPos);
        add(searchButtons,BorderLayout.CENTER);

        searchButtons.setVisible(false);
    }
    /**
     * makes the button for the update panel
     */
    public void updateButtons()
    {
        updateButtons = new JPanel();
        updateButtons.setLayout(new FlowLayout());
        
        JPanel ButtonPos = new JPanel();
        ButtonPos.setLayout(new GridLayout(0,1,20,20));

        Prev = new JButton("Prev");
        ButtonPos.add(Prev);
        Prev.addActionListener(this);

        Next = new JButton("Next");
        ButtonPos.add(Next);
        Next.addActionListener(this);

        Saves = new JButton("Save");
        ButtonPos.add(Saves);
        Saves.addActionListener(this);
        
        updateButtons.add(ButtonPos);
        add(updateButtons,BorderLayout.CENTER);

        updateButtons.setVisible(false);

    }
    /**
     * makes the button for the sell panel
     */
    public void sellButtons()
    {
        sellButtons = new JPanel();
        sellButtons.setLayout(new FlowLayout());
        
        JPanel ButtonPos = new JPanel();
        ButtonPos.setLayout(new GridLayout(0,1,20,20));

        Reset = new JButton("Reset");
        ButtonPos.add(Reset);
        Reset.addActionListener(this);

        Sells = new JButton("Sell");
        ButtonPos.add(Sells);
        Sells.addActionListener(this);
        
        sellButtons.add(ButtonPos);
        add(sellButtons,BorderLayout.CENTER);

        sellButtons.setVisible(false);
    }

        /**
         * makes the button for the buy panel
         */
    public void buyButtons()
    {
        buyButtons = new JPanel();
        buyButtons.setLayout(new FlowLayout());
        
        JPanel ButtonPos = new JPanel();
        ButtonPos.setLayout(new GridLayout(0,1,20,20));

        Reset = new JButton("Reset");
        ButtonPos.add(Reset);
        Reset.addActionListener(this);

        Buys = new JButton("Buy");
        ButtonPos.add(Buys);
        Buys.addActionListener(this);
        
        buyButtons.add(ButtonPos);
        add(buyButtons,BorderLayout.CENTER);

        buyButtons.setVisible(false);
    }
    /**
     * makes the label for menubar
     */
    public void CommandLabels()
    {
        if(counter == 1)
        {
            buyOption = new JLabel();
            sellOption.setText(" ");
            updateOption.setText(" ");
            getGainOption.setText(" ");
            SearchOption.setText(" ");
            buyOption.setText("Buying an Investment");
            
            add(buyOption,BorderLayout.NORTH);

        }
        else if( counter == 2)
        {
            sellOption = new JLabel();
            buyOption.setText(" ");
            updateOption.setText(" ");
            getGainOption.setText(" ");
            SearchOption.setText(" ");
            sellOption.setText("Selling an Investment");
            
            add(sellOption,BorderLayout.NORTH);
        }
        else if(counter == 3 )
        {
            updateOption = new JLabel();
            buyOption.setText(" ");
            sellOption.setText(" ");
            getGainOption.setText(" ");
            SearchOption.setText(" ");
            updateOption.setText("Updating Investments");
            
            add(updateOption,BorderLayout.NORTH);
        }
        else if(counter == 4 )
        {
            getGainOption = new JLabel();
            buyOption.setText(" ");
            sellOption.setText(" ");
            updateOption.setText(" ");
            SearchOption.setText(" ");
            getGainOption.setText("Getting Total Gain");
            
            add(getGainOption,BorderLayout.NORTH);
        }
        else if(counter == 5 )
        {
            SearchOption = new JLabel();
            buyOption.setText(" ");
            sellOption.setText(" ");
            updateOption.setText(" ");
            getGainOption.setText(" ");
            SearchOption.setText("Searching Investments");
            
            add(SearchOption,BorderLayout.NORTH);
        }
    }
    /**
     * makes the command menu options
     */
    public void Commands()
    {
        Menubar = new JMenuBar();
        setJMenuBar(Menubar);

        Commands = new JMenu("Commands");
        Menubar.add(Commands);
        
        Buy = new JMenuItem("Buy");
        Commands.add(Buy);
        Buy.addActionListener(this);

        Sell = new JMenuItem("Sell");
        Commands.add(Sell);
        Sell.addActionListener(this);

        Update = new JMenuItem("Update Price");
        Commands.add(Update);
        Update.addActionListener(this);

        getGain = new JMenuItem("Calculate Gain");
        Commands.add(getGain);
        getGain.addActionListener(this);

        Search = new JMenuItem("Search");
        Commands.add(Search);
        Search.addActionListener(this);

        Quit = new JMenuItem("Quit");
        Commands.add(Quit);
        Quit.addActionListener(this);

    }
    /**
     * makes the welcome panel
     */
    public void WelcomePanel()
    {
        WelcomePanel = new JPanel();
        WelcomePanel.setLayout(new GridLayout(0,1));

        
        JLabel welcomeLabel_1 = new JLabel();
        JLabel welcomeLabel_2 = new JLabel();
        welcomeLabel_1.setText("Welcome to ePortfolio.");
        
        welcomeLabel_2.setText("<html><p>Choose a command from the Commands menu to buy or sell an investment, update prices for all investments, get gain for the portfolio, search for relevant investments, or quit the program. </p></html>");
        
        WelcomePanel.add(welcomeLabel_1);
        WelcomePanel.add(welcomeLabel_2);
        WelcomePanel.setVisible(true);
        add(WelcomePanel);

        WelcomePanel.setVisible(true);
    }
    /**
     * makes the label for the text area 
     */
    public void messagePanelLabels()
    {
        if(counter == 1 || counter == 2 || counter == 3)
        {
            BuySellUpdateOptionMsg = new JLabel();
            getGainOptionMsg.setText(" ");
            SearchOptionMsg.setText(" ");
            BuySellUpdateOptionMsg.setText(" ");
            BuySellUpdateOptionMsg.setText("Messages");
            
            messagePanel.add(BuySellUpdateOptionMsg,BorderLayout.SOUTH);
            
        }
        else if(counter == 4)
        {
            getGainOptionMsg = new JLabel();
            BuySellUpdateOptionMsg.setText(" ");
            SearchOptionMsg.setText(" ");
            getGainOptionMsg.setText(" ");
            getGainOptionMsg.setText("Individual Gains");
            
            messagePanel.add(getGainOptionMsg,BorderLayout.SOUTH);
            
        }
        else if(counter == 5)
        {
            SearchOptionMsg = new JLabel();
            BuySellUpdateOptionMsg.setText(" ");
            getGainOptionMsg.setText(" ");
            getGainOptionMsg.setText(" ");
            SearchOptionMsg.setText("Search Results");
            
            messagePanel.add(SearchOptionMsg,BorderLayout.SOUTH);
            
        }

    }
    /**
     * makes the text area panel
     */
    public void messagePanel()
    {
        messagePanel = new JPanel();

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(550,150));

        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //textArea.setLineWrap(true);
        messagePanel.add(scroll);

        add(messagePanel,BorderLayout.SOUTH);
        messagePanel.setVisible(false); //set to false
    }
    /**
     * makes the buy panel
     */
    public void buyPanel()
    {
        counter = 1;

        buyPanel = new JPanel();
        buyPanel.setLayout(new FlowLayout());
        buyPanel.setBorder(new EmptyBorder(5,5,5,5));

        comboBox = new JComboBox <String> (investmentTypes);
        comboBox.setSelectedIndex(0);
        Type = investmentTypes[0];
        comboBox.addActionListener(this);

        JPanel Labels = new JPanel();
        Labels.setLayout(new GridLayout(0,1,20,20));
        Labels.setBorder(new EmptyBorder(5,5,5,5));

        JPanel textBox = new JPanel();
        textBox.setLayout(new GridLayout(0,1,15,15));
        textBox.setBorder(new EmptyBorder(5,5,5,5));

        JLabel Type = new JLabel();
        Type.setText("Type");
        Labels.add(Type);
        textBox.add(comboBox);
        
        symbolField = new JTextField(10);
        JLabel Symbol = new JLabel();
        Symbol.setText("Symbol");
        Labels.add(Symbol);
        textBox.add(symbolField);

        nameField = new JTextField(15);
        JLabel Name = new JLabel();
        Name.setText("Name");
        Labels.add(Name);
        textBox.add(nameField);

        quantityField = new JTextField(10);
        JLabel Quantity = new JLabel();
        Quantity.setText("Quantity");
        Labels.add(Quantity);
        textBox.add(quantityField);

        priceField = new JTextField(10);
        JLabel Price = new JLabel();
        Price.setText("Price");
        Labels.add(Price);
        textBox.add(priceField);

        buyPanel.add(Labels);
        buyPanel.add(textBox);
        
        add(buyPanel,BorderLayout.WEST);
        buyPanel.setVisible(false);
    }
    /**
     * makes the sell panel
     */
    public void sellPanel()
    {
        counter = 2;
        sellPanel = new JPanel();
        sellPanel.setLayout(new FlowLayout());
        sellPanel.setBorder(new EmptyBorder(5,5,5,5));

        JPanel Labels = new JPanel();
        Labels.setLayout(new GridLayout(0,1,20,20));
        Labels.setBorder(new EmptyBorder(5,5,5,5));

        JPanel textBox = new JPanel();
        textBox.setLayout(new GridLayout(0,1,15,15));
        textBox.setBorder(new EmptyBorder(5,5,5,5));

        symbolField = new JTextField(10);
        JLabel Symbol = new JLabel();
        Symbol.setText("Symbol");
        Labels.add(Symbol);
        textBox.add(symbolField);

        quantityField = new JTextField(10);
        JLabel Quantity = new JLabel();
        Quantity.setText("Quantity");
        Labels.add(Quantity);
        textBox.add(quantityField);

        priceField = new JTextField(10);
        JLabel Price = new JLabel();
        Price.setText("Price");
        Labels.add(Price);
        textBox.add(priceField);

        sellPanel.add(Labels);
        sellPanel.add(textBox);
        
        add(sellPanel,BorderLayout.WEST);
        sellPanel.setVisible(false);
    }
    /**
     * makes the update panel
     */
    public void UpdatePanel()
    {
        counter = 3;
        UpdatePanel = new JPanel();
        UpdatePanel.setLayout(new FlowLayout());
        UpdatePanel.setBorder(new EmptyBorder(5,5,5,5));

        JPanel Labels = new JPanel();
        Labels.setLayout(new GridLayout(0,1,20,20));
        Labels.setBorder(new EmptyBorder(5,5,5,5));

        JPanel textBox = new JPanel();
        textBox.setLayout(new GridLayout(0,1,15,15));
        textBox.setBorder(new EmptyBorder(5,5,5,5));

        symbolField = new JTextField(10);
        JLabel Symbol = new JLabel();
        Symbol.setText("Symbol");
        Labels.add(Symbol);
        textBox.add(symbolField);

        nameField = new JTextField(15);
        JLabel Name = new JLabel();
        Name.setText("Name");
        Labels.add(Name);
        textBox.add(nameField);

        priceField = new JTextField(10);
        JLabel Price = new JLabel();
        Price.setText("Price");
        Labels.add(Price);
        textBox.add(priceField);

        UpdatePanel.add(Labels);
        UpdatePanel.add(textBox);
        
        add(UpdatePanel,BorderLayout.WEST);
        UpdatePanel.setVisible(false);

    }
    /**
     * makes the panel for the get gain
     */
    public void getGain()
    {
        counter = 4;

        gainPanel = new JPanel();
        gainPanel.setLayout(new FlowLayout());
        gainPanel.setBorder(new EmptyBorder(5,5,5,5));

        JPanel Labels = new JPanel();
        Labels.setLayout(new GridLayout(0,1,20,20));
        Labels.setBorder(new EmptyBorder(5,5,5,5));

        JPanel textBox = new JPanel();
        textBox.setLayout(new GridLayout(0,1,15,15));
        textBox.setBorder(new EmptyBorder(5,5,5,5));

        gainField = new JTextField(10);
        gainField.setEditable(false);
        JLabel totalGain = new JLabel();
        totalGain.setText("Total Gain");
        Labels.add(totalGain);
        textBox.add(gainField);

        gainPanel.add(Labels);
        gainPanel.add(textBox);
        
        add(gainPanel,BorderLayout.WEST);
        gainPanel.setVisible(false);

    }
    /**
     * makes the panel for the search
     */
    public void search()
    {
        counter = 5;

        searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.setBorder(new EmptyBorder(5,5,5,5));

        JPanel Labels = new JPanel();
        Labels.setLayout(new GridLayout(0,1,20,20));
        Labels.setBorder(new EmptyBorder(5,5,5,5));

        JPanel textBox = new JPanel();
        textBox.setLayout(new GridLayout(0,1,15,15));
        textBox.setBorder(new EmptyBorder(5,5,5,5));

        symbolField = new JTextField(10);
        JLabel Symbol = new JLabel();
        Symbol.setText("Symbol");
        Labels.add(Symbol);
        textBox.add(symbolField);

        nameKeywordsField = new JTextField(10);
        JLabel nameKeywords = new JLabel();
        nameKeywords.setText("Name Keywords");
        Labels.add(nameKeywords);
        textBox.add(nameKeywordsField);

        lowPriceField = new JTextField(10);
        JLabel lowPrice = new JLabel();
        lowPrice.setText("Low Price");
        Labels.add(lowPrice);
        textBox.add(lowPriceField);

        highPriceField = new JTextField(10);
        JLabel highPrice = new JLabel();
        highPrice.setText("High Price");
        Labels.add(highPrice);
        textBox.add(highPriceField);

        searchPanel.add(Labels);
        searchPanel.add(textBox);
        
        add(searchPanel,BorderLayout.WEST);
        searchPanel.setVisible(false);

    }

    int updateCounter = 0;
    /**
     * actionListeners for each and every button
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == Buy)
        {   
            textArea.setText(null);
            buyPanel();
            buyButtons();
            CommandLabels();
            messagePanelLabels();
            

            buyButtons.setVisible(true);
            buyOption.setVisible(true);
            buyPanel.setVisible(true);
            buyButtons.setVisible(true);
            messagePanel.setVisible(true);
            BuySellUpdateOptionMsg.setVisible(true);

            WelcomePanel.setVisible(false);
            sellPanel.setVisible(false);
            sellButtons.setVisible(false);
            UpdatePanel.setVisible(false);
            updateButtons.setVisible(false);
            gainPanel.setVisible(false);
            searchPanel.setVisible(false);
            searchButtons.setVisible(false);

        }
        else if( e.getSource() == comboBox)
        {
            Type = (String)comboBox.getSelectedItem();
        }
        else if( e.getSource() == Sell)
        {
            textArea.setText(null);
            sellPanel();
            sellButtons();
            CommandLabels();

            sellButtons.setVisible(true);
            sellOption.setVisible(true);
            sellPanel.setVisible(true);
            messagePanel.setVisible(true);
            BuySellUpdateOptionMsg.setVisible(true);
            
            WelcomePanel.setVisible(false);
            buyButtons.setVisible(false);
            buyPanel.setVisible(false);
            updateButtons.setVisible(false);
            UpdatePanel.setVisible(false);
            gainPanel.setVisible(false);
            searchPanel.setVisible(false);
            searchButtons.setVisible(false);
        }
        else if( e.getSource() == Update )
        {
            textArea.setText(null);
            UpdatePanel();
            updateButtons();
            CommandLabels();
            messagePanelLabels();
            

            updateOption.setVisible(true);
            updateButtons.setVisible(true);
            UpdatePanel.setVisible(true);
            WelcomePanel.setVisible(true);
            messagePanel.setVisible(true);
            
            BuySellUpdateOptionMsg.setVisible(true);
            getGainOptionMsg.setVisible(false);
            SearchOptionMsg.setVisible(false);

            WelcomePanel.setVisible(false);
            buyPanel.setVisible(false);
            buyButtons.setVisible(false);
            sellPanel.setVisible(false);
            sellButtons.setVisible(false);
            gainPanel.setVisible(false);
            searchPanel.setVisible(false);
            searchButtons.setVisible(false);

            symbolField.setEditable(false);
            nameField.setEditable(false);

            if(updateCounter == 0)
            {
                Prev.setVisible(false);
                
            }
            if(updateCounter == portfolio.investmentList.size()-1)
            {
                Next.setVisible(false);
            }

            if(portfolio.investmentList.size() == 0)
            {
                textArea.append("No Investments available to update\n");
                Prev.setVisible(false);
                Next.setVisible(false);
               
            }
            else     
            {
                symbolField.setText(portfolio.investmentList.get(0).getSymbol());
                nameField.setText(portfolio.investmentList.get(0).getName());
            }

        }
        else if( e.getSource() == getGain )
        {
            textArea.setText(null);
            getGain();
            CommandLabels();
            messagePanelLabels();

            getGainOption.setVisible(true);
            gainPanel.setVisible(true);
            messagePanel.setVisible(true);
            getGainOptionMsg.setVisible(true);

            SearchOptionMsg.setVisible(false);
            BuySellUpdateOptionMsg.setVisible(false);
            WelcomePanel.setVisible(false);
            buyPanel.setVisible(false);
            buyButtons.setVisible(false);
            sellPanel.setVisible(false);
            sellButtons.setVisible(false);
            UpdatePanel.setVisible(false);
            updateButtons.setVisible(false);
            searchPanel.setVisible(false);
            searchButtons.setVisible(false);

            //the gain for symbolname is this
            float Gain = 0;
            textArea.append(" ");

            for(int i = 0; i< portfolio.investmentList.size(); i++)
            {
                Gain = portfolio.getGain(portfolio.investmentList.get(i).getPrice(), portfolio.investmentList.get(i).getQuantity(), portfolio.investmentList.get(i).getBookvalue(),i);
                textArea.append("The Gain for investment "+ portfolio.investmentList.get(i).getSymbol()+ " is: "+ Gain+"\n");
            }


        }
        else if( e.getSource() == Search )
        {
            textArea.setText(null);
            search();
            CommandLabels();
            searchButtons();
            messagePanelLabels();
            

            searchPanel.setVisible(true);
            messagePanel.setVisible(true);
            SearchOption.setVisible(true);
            searchButtons.setVisible(true);
            
            SearchOptionMsg.setVisible(true);
            BuySellUpdateOptionMsg.setVisible(false);
            getGainOptionMsg.setVisible(false);

            WelcomePanel.setVisible(false);
            buyPanel.setVisible(false);
            buyButtons.setVisible(false);
            sellPanel.setVisible(false);
            sellButtons.setVisible(false);
            UpdatePanel.setVisible(false);
            updateButtons.setVisible(false);
            gainPanel.setVisible(false);

            symbolField.setText(null);
            nameKeywordsField.setText(null);
            lowPriceField.setText(null);
            highPriceField.setText(null);
            
        }
        else if(e.getSource() == Searches)
        {
            textArea.setText(null);

            Boolean checklowPrice = false;
            Boolean checkhighPrice = false;
            
            int s = -1;
            int nk = -1;
            int lp = -1;
            int hp = -1;
            String[] keywordTemp = nameKeywordsField.getText().split("[ ]+"); 

            checklowPrice = portfolio.validatePriceSearch(lowPriceField.getText());
            checkhighPrice = portfolio.validatePriceSearch(highPriceField.getText());

            

            if(! checklowPrice || !checkhighPrice)
            {
                textArea.append("Invalid input for Price, Enter a Positive Number.\n");
               
            }

            if(! lowPriceField.getText().isEmpty())
            {
                lp = 1;
            }
            else if(! highPriceField.getText().isEmpty())
            {
                hp = 1;
            }

            // checklowPrice = lowPriceField.getText().isEmpty();
            // checkhighPrice = highPriceField.getText().isEmpty();
            

            
                
                if(!symbolField.getText().isEmpty())
                {
                    s = 1 ;
                }

                if(! nameKeywordsField.getText().isEmpty())
                {
                    nk = 1;
                }

                if(!lowPriceField.getText().isEmpty())
                {
                    lp = 1;

                }

                if(!highPriceField.getText().isEmpty())
                {
                    hp = 1;
                }

                if( s == -1 && nk == -1 && lp == -1 && hp == -1)
                {
                    textArea.append("Nothing Entered to Search\n");
                }
                System.out.println(s+" "+nk+" "+lp+" "+hp+" ");
                //System.out.println(checkhighPrice);

                if( s == 1 && nk == -1 && lp == -1 && hp == -1)
                {
                    for(int i = 0; i<portfolio.investmentList.size(); i++)
                    {
                        if(symbolField.getText().equalsIgnoreCase(portfolio.investmentList.get(i).getSymbol()))
                        {
                            textArea.append("Match Found!");
                            textArea.append(portfolio.investmentList.get(i).toString());
                        }
                        else
                        {
                            textArea.append("Match NOT Found!");
                        }
                    }
                    
                }  
                if( s == -1 && nk == 1 && lp == -1 && hp == -1)
                {
                    for(int i = 0; i<portfolio.investmentList.size(); i++)
                    {              
                        for(int j = 0; j<keywordTemp.length ; j++ ) 
                        {
                            if(portfolio.investmentList.get(i).getName().contains(keywordTemp[j]))
                            {
                                textArea.append("Match Found!");
                                textArea.append(portfolio.investmentList.get(i).toString());
                            }
                            else
                            {
                                textArea.append("Match NOT Found!");
                            }
                        }
                    }
                } 
                if( s==-1 && nk == -1 && lp == 1 && hp == -1)
                {
                    for(int i = 0; i<portfolio.investmentList.size(); i++)
                    {
                        if(portfolio.investmentList.get(i).getPrice() <= Float.parseFloat(lowPriceField.getText()) ) 
                        {
                            textArea.append("Match Found!");
                            textArea.append(portfolio.investmentList.get(i).toString());
                        }
                        else 
                        {
                            textArea.append("Match NOT Found!");
                        }
                    }
                    
                }
                if( s==-1 && nk == -1 && lp == -1 && hp == 1)
                {
                    for(int i = 0; i<portfolio.investmentList.size(); i++)
                    {
                        if( portfolio.investmentList.get(i).getPrice() >= Float.parseFloat(highPriceField.getText()) ) 
                        {
                            textArea.append("Match Found!");
                            textArea.append(portfolio.investmentList.get(i).toString());
                        }
                        else
                        {
                            textArea.append("Match NOT Found!");
                        }
                    }
                    
                }
                
                if( s==1 && nk == 1 && lp == 1 && hp == 1)
                {
                    Boolean matchindexS = false;
                    Boolean matchindexNK = false;
                    Boolean matchindexLP = false;
                    Boolean matchindexHP = false;

                    for(int i = 0; i<portfolio.investmentList.size(); i++)
                    {
                        if(symbolField.getText().equalsIgnoreCase(portfolio.investmentList.get(i).getSymbol()))
                        {
                            matchindexS = true;
                        }
                        for(int j = 0; j<keywordTemp.length ; j++ ) 
                        {
                            if(portfolio.investmentList.get(i).getName().contains(keywordTemp[j]))
                            {
                                matchindexNK = true;
                            }
                        }

                        if(portfolio.investmentList.get(i).getPrice() >= Float.parseFloat(lowPriceField.getText()) ) 
                        {
                            matchindexLP = true;
                        }
                        if(portfolio.investmentList.get(i).getPrice() <= Float.parseFloat(highPriceField.getText()) ) 
                        {
                            matchindexHP = true;
                        }

                        if(matchindexS && matchindexNK && matchindexLP && matchindexHP )
                        {
                            textArea.append("Match Found!");
                            textArea.append(portfolio.investmentList.get(i).toString());
                        }
                        else    
                        {
                            textArea.append("Match NOT Found!");
                        }
                    }
                }

           

        }
        else if (e.getSource() == Reset)
        {
            textArea.setText(null);
            symbolField.setText(null);
            nameField.setText(null);
            quantityField.setText(null);
            priceField.setText(null);
            nameKeywordsField.setText(null);
            lowPriceField.setText(null);
            highPriceField.setText(null);
        }
        else if (e.getSource() == Buys)
        {
            textArea.setText(" ");
            int investmentNumber = 0; 
            Boolean checkSymbol = false ;
            Boolean checkName = false ;
            Boolean checkQuantity = false ;
            Boolean checkPrice = false ;

            checkSymbol = portfolio.validateSymbol(symbolField.getText());
            checkName = portfolio.validateSymbol(nameField.getText());
            checkQuantity = portfolio.validatebuyQuantity(quantityField.getText());
            checkPrice = portfolio.validatePrice(priceField.getText());
        
            if( checkSymbol && checkName && checkQuantity && checkPrice)
            {
                investmentNumber = portfolio.buyInvestment(Type, symbolField.getText() , nameField.getText() , Integer.parseInt(quantityField.getText()), Float.parseFloat(priceField.getText()));
                textArea.append("Investment Bought!\n"); 
                textArea.append(portfolio.investmentList.get(investmentNumber-1).toString());
            }
            else     
            {
                if(!checkSymbol)
                {
                    textArea.append("Symbol Cannot be Empty\n"); 
                }
                else if(!checkName )
                {
                    textArea.append("Name Cannot be Empty\n"); 
                }
                else if( !checkQuantity)
                {
                    textArea.append("Invalid Input for Quantity\n");
                }
                else if(!checkPrice)
                {
                    textArea.append("Invalid Input for Price\n");
                }
                symbolField.setText(null);
                nameField.setText(null);
                quantityField.setText(null);
                priceField.setText(null);
            }
        }
        else if( e.getSource() == Sells)
        {
            textArea.setText(" ");
            float Payment = 0; 

            Boolean checkQuantity = false ;
            Boolean checkPrice = false ;
            Boolean checkSymbol = false; 
            Boolean checksymbolExists = false;
            
            checksymbolExists = portfolio.checkSymbolExits(symbolField.getText());

            checkSymbol = portfolio.validateSymbol(symbolField.getText());
            checkQuantity = portfolio.validatesellQuantity(quantityField.getText(), symbolField.getText());
            checkPrice = portfolio.validatePrice(priceField.getText());
            
            if( checkQuantity && checkPrice && checkSymbol && checksymbolExists )
            {
                Payment = portfolio.sellInvestment( symbolField.getText(), Integer.parseInt(quantityField.getText()), Float.parseFloat(priceField.getText()));
                
                checksymbolExists = portfolio.checkSymbolExits(symbolField.getText());

                if( !checksymbolExists )
                {
                    textArea.append("Investment fully sold, No quantity Remaining\n");
                    textArea.append("Payment Recieved is: $" + Payment + "\n");
                }
                else    
                {
                    textArea.append("Investment Sold!\n"); 
                    textArea.append("Payment Recieved is: $" + Payment + "\n");
                }
            }
            else if(!checksymbolExists)
            {
                textArea.append("Symbol NOT found to sell\n"); 
            }
            else if(!checkSymbol)
            {
                textArea.append("Symbol Cannot be Empty\n"); 
            }
            else if( !checkQuantity)
            {
                textArea.append("Invalid Input for Quantity\n");
            }
            else if(!checkPrice)
            {
                textArea.append("Invalid Input for Price\n");
            }
        }
        else if(e.getSource() == Next )
        {
            updateCounter++;
            if(updateCounter == portfolio.investmentList.size()-1)
            {
                Next.setVisible(false);
                Prev.setVisible(true);
            }
            else 
            {
                Next.setVisible(true);
                Prev.setVisible(true);
            }

            symbolField.setText(portfolio.investmentList.get(updateCounter).getSymbol());
            nameField.setText(portfolio.investmentList.get(updateCounter).getName());

        }
        else if(e.getSource() == Prev)
        {
            updateCounter--;
            if(updateCounter == 0)
            {
                Prev.setVisible(false);
                Next.setVisible(true);
            }
            else 
            {
                Next.setVisible(true);
                Prev.setVisible(true);
            }

                symbolField.setText(portfolio.investmentList.get(updateCounter).getSymbol());
                nameField.setText(portfolio.investmentList.get(updateCounter).getName());

        }
        else if(e.getSource() == Saves)
        {
            textArea.setText(null);
            Boolean checkPrice = false ;
            checkPrice = portfolio.validatePrice(priceField.getText());

            if(!checkPrice)
            {
                textArea.append("Invalid Input for Price\n");
            }
            else    
            {
                textArea.append(priceField.getText());
                portfolio.investmentList.get(updateCounter).setPrice(Float.parseFloat(priceField.getText()));
                textArea.append("Price Updated for symbol [ "+ portfolio.investmentList.get(updateCounter).getSymbol()+ " ] to "+portfolio.investmentList.get(updateCounter).getPrice()+ "\n" );
                
            }
            priceField.setText(null);

        }
        else if( e.getSource() == Quit)
        {
            System.exit(0);
        }
    }
}

  