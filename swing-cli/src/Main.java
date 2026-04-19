import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Main{
    public static JFrame menu = new JFrame();
    public static JFrame main = new JFrame();
    public static JFrame settings = new JFrame();
    public static JFrame tableView = new JFrame();
    
    public static int sizeX = 1200;
    public static int sizeY = 900;
    public static int buttonSizeX = 100;
    public static int buttonSizeY = 50;

    public static calculator cal = new calculator();

    //settings values
    public static boolean darkmode = false;
    
    public static void main(String[] args){        
        initMenu();
    }

    //button actions
    public static void startClick(){
        System.out.println("Start button click...");
        initMain();
    }
    public static void settingsClick(){
        System.out.println("Settings button click...");
        initSettings();
    }
    public static void exitClick(){
        System.out.println("Exit button click...");
        closeAll();
    }
    public static void enterClick(String type, String name, String amount){
        if(type.equals("bill"))
            cal.addBill(name, amount);
        else
            cal.addIncome(name, amount);
    }
    public static void darkmodeClick(boolean dm){
        darkmode = dm;

        if(darkmode){
            menu.setBackground(Color.DARK_GRAY);
            main.setBackground(Color.DARK_GRAY);
            settings.setBackground(Color.DARK_GRAY);
            tableView.setBackground(Color.DARK_GRAY);
            menu.setForeground(Color.WHITE);
            main.setForeground(Color.WHITE);
            settings.setForeground(Color.WHITE);
            tableView.setForeground(Color.WHITE);
        }
        else{
            menu.setBackground(Color.WHITE);
            main.setBackground(Color.WHITE);
            settings.setBackground(Color.WHITE);
            tableView.setBackground(Color.WHITE);
            menu.setForeground(Color.BLACK);
            main.setForeground(Color.BLACK);
            settings.setForeground(Color.BLACK);
            tableView.setForeground(Color.BLACK);
        }
    }

    //init/close frames
    public static void closeAll(){
        System.out.println("Closing all frames...");
        main.setVisible(false);
        menu.setVisible(false);
        settings.setVisible(false);
    }
    public static void initMain(){
        System.out.println("Opening main...");
        closeAll();

        //buttons
        JButton back = new JButton("Menu");
        back.setBounds(50, 50, buttonSizeX, buttonSizeY);
        main.add(back);

        JButton enterBill = new JButton("Enter");
        JButton enterIncome = new JButton("Enter");

        JButton openTable = new   JButton("Open Table");
        JButton savings = new     JButton("View Savings");
        JButton spending = new    JButton("View Spending");
        JButton totalIncome = new JButton("View Income");
        JButton totalBills = new  JButton("View Bills");

        //text fields
        JTextField typeBill = new JTextField();
        JTextField amountBill = new JTextField();
        JTextField typeIncome = new JTextField();
        JTextField amountIncome = new JTextField();

        //labels
        JLabel pTypeBill = new JLabel("Enter the name of the bill...(no spaces)");
        JLabel pAmountBill = new JLabel("Enter the amount of the bill...(number only)");

        JLabel pTypeIncome = new JLabel("Enter the name of income...(no spaces)");
        JLabel pAmountIncome = new JLabel("Enter the amount of income...(number only)");

        JLabel output = new JLabel("");
        
        //formatting
        typeBill.setBounds(250, 150, 300, 50);
        pTypeBill.setBounds(225, 100, 400, 50);
        amountBill.setBounds(650, 150, 300, 50);
        pAmountBill.setBounds(625, 100, 400, 50);
        enterBill.setBounds(1000, 150, buttonSizeX, buttonSizeY);

        typeIncome.setBounds(250, 275, 300, 50);
        pTypeIncome.setBounds(225, 225, 400, 50);
        amountIncome.setBounds(650, 275, 300, 50);
        pAmountIncome.setBounds(625, 225, 400, 50);
        enterIncome.setBounds(1000, 275, buttonSizeX, buttonSizeY);

        pTypeBill.setFont(new Font("Serif", Font.PLAIN, 18));
        pAmountBill.setFont(new Font("Serif", Font.PLAIN, 18));
        pTypeIncome.setFont(new Font("Serif", Font.PLAIN, 18));
        pAmountIncome.setFont(new Font("Serif", Font.PLAIN, 18));
        output.setFont(new Font("Serif", Font.PLAIN, 24));

        openTable.setBounds(50, 400, buttonSizeX + 20, buttonSizeY);
        savings.setBounds(50 + buttonSizeX + 25, 400, buttonSizeX + 20, buttonSizeY);
        totalIncome.setBounds(50 + (buttonSizeX + 25)*2, 400, buttonSizeX + 20, buttonSizeY);
        totalBills.setBounds(50 + (buttonSizeX + 25)*3, 400, buttonSizeX + 20, buttonSizeY);
        spending.setBounds(50 + (buttonSizeX + 25)*4, 400, buttonSizeX + 30, buttonSizeY);

        output.setBounds(50, 500, sizeX-100, 100);

        main.add(typeBill);
        main.add(amountBill);
        main.add(enterBill);
        main.add(pTypeBill);
        main.add(pAmountBill);
        main.add(typeIncome);
        main.add(pTypeIncome);
        main.add(amountIncome);
        main.add(pAmountIncome);
        main.add(enterIncome);

        main.add(openTable);
        main.add(savings);
        main.add(totalIncome);
        main.add(totalBills);
        main.add(spending);

        main.add(output);

        //button events
        back.addActionListener(e->
            initMenu()                    
        );

        enterBill.addActionListener(e->
            enterClick("bill", typeBill.getText(), amountBill.getText())                           
        );
        enterIncome.addActionListener(e->
            enterClick("income", typeIncome.getText(), amountIncome.getText())                             
        );

        openTable.addActionListener(e->
            initTableView()                           
        );
        savings.addActionListener(e->
            output.setText(cal.getSavings())                         
        );
        totalIncome.addActionListener(e->
            output.setText(cal.getTotalIncome())                         
        );
        totalBills.addActionListener(e->
            output.setText(cal.getTotalBills())                         
        );
        spending.addActionListener(e->
            output.setText(cal.getSpendingMoney())                         
        );

        //frame config
        main.setSize(sizeX, sizeY);
        main.setLayout(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
    public static void initMenu(){
        System.out.println("Opening menu...");
        closeAll();
        
        //buttons
        JButton start = new JButton("Start");
        start.setBounds(sizeX/2 - buttonSizeX, sizeY/2  - 80, buttonSizeX, buttonSizeY);
        menu.add(start);

        JButton settings = new JButton("Settings");
        settings.setBounds(sizeX/2 - buttonSizeX, sizeY/2, buttonSizeX, buttonSizeY);
        menu.add(settings);

        JButton exit = new JButton("Exit");
        exit.setBounds(sizeX/2 - buttonSizeX, sizeY/2 + 80, buttonSizeX, buttonSizeY);
        menu.add(exit);

        //title
        JLabel title = new JLabel("Budget Buddy");
        title.setBounds(75, 50, sizeX - 100, 250);
        title.setFont(new Font("Serif", Font.PLAIN, 150));
        menu.add(title);

        //button events
        start.addActionListener(e->
            startClick()
        );
        settings.addActionListener(e->
            settingsClick()
        );
        exit.addActionListener(e->
            exitClick()
        );

        //frame config
        menu.setSize(sizeX, sizeY);
        menu.setLayout(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
    }
    public static void initSettings(){
        System.out.println("Opening settings...");
        closeAll();

        //check boxes
        JCheckBox darkmodeBox = new JCheckBox("Darkmode", darkmode);
        darkmodeBox.setBounds(sizeX/2, sizeY/2 - 80, 500, 50);
        darkmodeBox.setFont(new Font("Serif", Font.PLAIN, 24));
        settings.add(darkmodeBox);

        //buttons
        JButton back = new JButton("Menu");
        back.setBounds(50, 50, buttonSizeX, buttonSizeY);
        settings.add(back);

        JButton set = new JButton("Set");
        set.setBounds(sizeX/2 - buttonSizeX, sizeY/2, buttonSizeX, buttonSizeY);
        settings.add(set);

        //button events
        back.addActionListener(e->
            initMenu()                    
        );
        set.addActionListener(e->
            darkmodeClick(darkmodeBox.isSelected())
        );
        
        //frame config
        settings.setSize(sizeX, sizeY);
        settings.setLayout(null);
        settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settings.setVisible(true);
    }
    public static void initTableView(){
        System.out.println("Opening table...");

        JTable table = new JTable(cal.getData(), cal.getColumns());
        JScrollPane scrollPane = new JScrollPane(table);

        table.setBounds(0, 0, sizeX, sizeY);
        
        tableView.add(table);
        
        //frame config
        tableView.setSize(sizeX, sizeY);
        tableView.setLayout(null);
        tableView.setVisible(true);
    }

    
    
    
}



class calculator{
    private static String billNames     = "";
    private static String billAmounts   = "";

    private static String incomeNames   = "";
    private static String incomeAmounts = "";

    private static double savings       = 0.0;
    private static double spending      = 0.0;

    private static double totalBills = 0.0;
    private static double totalIncome = 0.0;

    private static int numBills = 0;
    private static int numIncomes = 0;

    //user input methods
    public static void addBill(String name, String num){
        billNames += name + " ";
        billAmounts += num + " ";
        totalBills += Double.valueOf(num);
        numBills++;
    }
    public static void addIncome(String name, String num){
        incomeNames += name + " ";
        incomeAmounts += num + " ";
        totalIncome += Double.valueOf(num);
        numIncomes++;
    }

    //user option returns
    public static String getSavings(){
        String re = "Put $";
        re += String.valueOf(Math.round(((totalIncome - totalBills)*0.1) * 100.0) / 100.0);
        re += " into your savings account each month.";
        return re;
    }
    public static String getTotalIncome(){
        String re = "You make $";
        re += String.valueOf(Math.round(totalIncome * 100.0) / 100.0);
        re += " each month.";
        return re;
    }
    public static String getTotalBills(){
        String re = "You pay $";
        re += String.valueOf(Math.round(totalBills * 100.0) / 100.0);
        re += " each month.";
        return re;
    }
    public static String getSpendingMoney(){
        String re = "You can spend $";
        re += String.valueOf(Math.round(((totalIncome - totalBills) - ((totalIncome - totalBills)*0.1)) * 100.0) / 100.0);
        re += " each month.";
        return re;
    }

    //table helpers
    public static String[] getColumns(){
        String[] re = new String[3];
        re[0] = "Types";
        re[1] = "Names";
        re[2] = "Amounts";
        return re;
    }
    public static Object[][] getData(){
        Object[][] data = new Object[numBills + numIncomes][3];

        Scanner countBillNames = new Scanner(billNames);
        Scanner countBillAmounts = new Scanner(billAmounts);
        for(int i = 0; i < numBills; i++){
            data[i][0] = "BILL";
            data[i][1] = countBillNames.next();
            data[i][2] = countBillAmounts.next();
        }

        Scanner countIncomeNames = new Scanner(incomeNames);
        Scanner countIncomeAmounts = new Scanner(incomeAmounts);
        for(int i = numBills; i < numIncomes + numBills; i++){
            data[i][0] = "INCOME";
            data[i][1] = countIncomeNames.next();
            data[i][2] = countIncomeAmounts.next();
        }
        return data;
    }
}


