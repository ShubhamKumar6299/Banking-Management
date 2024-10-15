import java.awt.*;  // AWT ke liye import kar rahe hain (Abstract Window Toolkit)
import javax.swing.*;  // Swing ke liye import kar rahe hain
import java.util.List; // List interface ke liye import
import java.util.ArrayList;// ArrayList class ke liye import

public class BankTrust extends JFrame {     // BankTrust naam ka class jo JFrame se inherit hota hai

    JLabel l1, l2, l3, l4, l5;// JLabel ke liye variables
    JButton b1, b2, b3, b4, b5, b6, b7;// JButton ke liye variables
    JTextField t1, t2;// JTextField ke liye variables
    JPanel p1, p2, p3;// JPanel ke liye variables
    JTextPane textPane;// JTextPane ke liye variable
    Dimension d;// Dimension ke liye variable
    Container con;// Container ke liye variable
    double balance;// Balance ko store karne ke liye variable
    List<String> transactions;// Transactions ke liye List
    final String correctPin = "8004"; // Set the correct PIN

    // Constructor jo GUI ko initialize karta hai

    BankTrust(String t, String uname, String acc) {   //t = tile for jFrame, uname = username, acc = account number
        super(t);// JFrame ka title set kar rahe hain

        balance = 0.00;// Initial balance 0.00 set kar rahe hain
        con = getContentPane();// Container ko get kar rahe hain
        con.setLayout(null);// Layout ko null set kar rahe hain
        
        transactions = new ArrayList<>();// Transactions ko ArrayList initialize kar rahe hain
        p1 = new JPanel();// JPanel banate hain
        l1 = new JLabel("SHUBHAM BANK OF INDIA");// JLabel set kar rahe hain
        l1.setFont(new Font("Eras Bold ITC", Font.BOLD, 40));// Font set kar rahe hain
        d = l1.getPreferredSize();// JLabel ki preferred size le rahe hain
        p1.add(l1);// JLabel ko JPanel p1 mein add kar rahe hain
        p1.setBounds(125, 2, d.width, d.height);// JPanel ki position set kar rahe hain
        p1.setOpaque(false);// JPanel ko transparent kar rahe hain
        con.add(p1);// JPanel ko container mein add kar rahe hain

        p2 = new JPanel();// Dusra JPanel banate hain
        l2 = new JLabel("Welcome: " + uname);// User name display karne ke liye JLabel
        l2.setFont(new Font("Constantia", Font.BOLD, 30));// Font set kar rahe hain
        d = l2.getPreferredSize();// JLabel ki preferred size le rahe hain
        p2.add(l2);// JLabel ko JPanel p2 mein add kar rahe hain
        p2.setBounds(40, 100, d.width, d.height);// JPanel ki position set kar rahe hain
        p2.setOpaque(false); // JPanel ko transparent kar rahe hain
        con.add(p2);// JPanel ko container mein add kar rahe hain

        p3 = new JPanel();// Teesra JPanel banate hain
        l3 = new JLabel("Account No.: " + acc);// Account number display karne ke liye JLabel
        l3.setFont(new Font("Constantia", Font.BOLD, 30)); // Font set kar rahe hain
        d = l3.getPreferredSize();// JLabel ki preferred size le rahe hain
        p3.add(l3);// JLabel ko JPanel p3 mein add kar rahe hain
        p3.setBounds(40, 140, d.width, d.height);// JPanel ki position set kar rahe hain
        p3.setOpaque(false);// JPanel ko transparent kar rahe hain
        con.add(p3);// JPanel ko container mein add kar rahe hain

        b1 = new JButton("Check Balance");// Balance check karne ke liye button banate hain
        d = b1.getPreferredSize(); // Button ki preferred size le rahe hain
        b1.setBounds(580, 135, d.width + 30, 40); // Button ki position set kar rahe hain
        con.add(b1); // Button ko container mein add kar rahe hain ,,This line adds the button (b1) to the main content pane (con) of the JFrame.

        b1.addActionListener(e -> { // Button ke liye action listener add kar rahe hain
                    //e is a parameter representing an instance of the ActionEvent class
            if (verifyPin()) { // Agar PIN verify hota hai
                showBalance(); // Balance show karne wali method call karte hain
            }
        });

        textPane = new JTextPane(); // JTextPane banate hain
        textPane.setEditable(false); // JTextPane ko editable nahi kar rahe hain
        textPane.setOpaque(false); // JTextPane ko transparent kar rahe hain
        textPane.setContentType("text/html"); // Content type HTML set kar rahe hain
        textPane.getCaret().setVisible(false); // Caret ko invisible kar rahe hain

        // Bank safety tips ka HTML content set kar rahe hain
        String InfoText = "<html><body><h1 style=\"font-family: Eras Bold ITC, sans-serif; font-size: 24px;\">Bank Safety Tips:- </h1>" +
                "<ul style=\"font-family: 'Constantia', sans-serif; font-size: 15px;\">" +
                "<li>Do not share your pin, passwords and account number with anyone.</li>" +
                "<li>Beware of frauds, the bank will never ask for your pin, passwords, or account number.</li>" +
                "<li>Always change your pin and passwords frequently.</li>" +
                "<li>24x7 service available.</li>" +
                "<li>For any query, please visit your nearest bank branch.</li>" +
                "</ul></body></html>";

        
        textPane.setText(InfoText); // JTextPane mein text set kar rahe hain
        textPane.setBounds(44, 430, 800, 300); // JTextPane ki position set kar rahe hain
        con.add(textPane); // JTextPane ko container mein add kar rahe hain

        b2 = new JButton("Deposit"); // Deposit karne ke liye button
        d = b2.getPreferredSize(); // Button ki preferred size le rahe hain
        b2.setBounds(280, 200, d.width + 44, 40); // Button ki position set kar rahe hain
        con.add(b2); // Button ko container mein add kar rahe hain

        b3 = new JButton("Withdraw"); // Withdraw karne ke liye button
        d = b3.getPreferredSize(); // Button ki preferred size le rahe hain
        b3.setBounds(280, 260, d.width + 31, 40); // Button ki position set kar rahe hain
        con.add(b3); // Button ko container mein add kar rahe hain

        b4 = new JButton("Mini Statement"); // Mini statement dikhane ke liye button
        d = b4.getPreferredSize(); // Button ki preferred size le rahe hain
        b4.setBounds(280, 320, d.width, 40); // Button ki position set kar rahe hain
        con.add(b4); // Button ko container mein add kar rahe hain

        // Button ke liye action listener add kar rahe hain
        b5 = new JButton("Cancel"); // Cancel karne ke liye button
        d = b5.getPreferredSize(); // Button ki preferred size le rahe hain
        b5.setBounds(280, 380, d.width + 46, 40); // Button ki position set kar rahe hain
        con.add(b5); // Button ko container mein add kar rahe hain

        
        b2.addActionListener(e -> { // Deposit button ke liye action listener
            if (verifyPin()) { // Agar PIN verify hota hai
                showDepositPanel(); // Deposit panel show karne wali method call karte hain
            }
        });

        b3.addActionListener(e -> { // Withdraw button ke liye action listener
            if (verifyPin()) { // Agar PIN verify hota hai
                showWithdrawPanel(); // Withdraw panel show karne wali method call karte hain
            }
        });

        
        b4.addActionListener(e -> { // Mini statement button ke liye action listener
            if (verifyPin()) { // Agar PIN verify hota hai
                MiniStatementFrame miniStatementFrame = new MiniStatementFrame(transactions); // Mini statement frame banate hain
                miniStatementFrame.setVisible(true); // Frame ko visible karte hain
                miniStatementFrame.setSize(400, 300); // Frame ki size set karte hain
                miniStatementFrame.setResizable(false); // Frame ko resize nahi hone dete
                miniStatementFrame.setLocationRelativeTo(b4); // Frame ko button ke relative position pe set karte hain
                miniStatementFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close operation set karte hain
            }
        });

        
        b5.addActionListener(e -> { // Jab button 'b5' pe click hota hai, ye code execute hota hai
        // Remove any deposit or withdrawal panels if they are currently displayed
            for (Component component : con.getComponents()) { // Con ke sabhi components ke liye loop
                if (component instanceof JPanel && component.getBackground() == Color.WHITE) { // Agar component JPanel hai aur background white hai
                con.remove(component); // Us component ko remove karo
                }
            }
            if (t1 != null) t1.setText(""); // Deposit field ko clear karo agar t1 null nahi hai
            if (t2 != null) t2.setText(""); // Withdrawal field ko clear karo agar t2 null nahi hai
            // Message box dikhana jo cancel hone ki confirmation de raha hai
            JOptionPane.showMessageDialog(this, "Canceled. All inputs cleared.", "Cancel", JOptionPane.INFORMATION_MESSAGE);
            this.revalidate(); // Panel ko dobara validate karo
            this.repaint(); // Panel ko dobara repaint karo
        });

      
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Application ko close karne par exit karo
        setSize(900, 800); // Window ka size set karo
        setVisible(true); // Window ko visible karo
    }

    
    private boolean verifyPin() { // PIN verify karne ke liye method
        String pin = JOptionPane.showInputDialog(this, "Enter your PIN:"); // User se PIN lene ka dialog box
        if (pin != null && pin.equals(correctPin)) { // Agar PIN null nahi hai aur sahi hai
            return true; // Sahi PIN hai toh true return karo
        } else {
            // Agar PIN sahi nahi hai, toh error message dikhana
            JOptionPane.showMessageDialog(this, "Incorrect PIN. Access denied.", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Sahi PIN nahi hai toh false return karo
        }
    }

    
    private void showDepositPanel() { // Deposit panel dikhane ka method
        JPanel depositPanel = new JPanel(); // Naya JPanel create karna
        depositPanel.setLayout(new FlowLayout()); // Flow layout set karo
        depositPanel.setBackground(Color.WHITE); // Background color white set karo for visibility
    
        l4 = new JLabel("Enter Amount to Deposit "); // Label for deposit amount
        t1 = new JTextField(10); // TextField for amount input
        b6 = new JButton("Ok"); // Ok button create karna
        depositPanel.add(l4); // Label ko deposit panel mein add karo
        depositPanel.add(t1); // TextField ko deposit panel mein add karo
        depositPanel.add(b6); // Button ko deposit panel mein add karo
    
        depositPanel.setBounds(425, 200, 330, 100); // Panel ka position aur size set karo
        con.add(depositPanel); // Deposit panel ko main container mein add karo
        this.revalidate(); // Panel ko dobara validate karo
        this.repaint(); // Panel ko dobara repaint karo
    
        b6.addActionListener(depositEvent -> { // Jab Ok button pe click hota hai
            try {
                double amount1 = Double.parseDouble(t1.getText()); // Input amount ko double mein convert karo
                if (amount1 <= 0) { // Agar amount zero ya less than zero hai
                    throw new NumberFormatException(); // Exception throw karo
                }
                balance += amount1; // Balance mein amount add karo
                transactions.add("Deposited: Rs." + amount1); // Transaction record karo
                JOptionPane.showMessageDialog(this, "Amount deposited successfully! ", "Deposit", JOptionPane.INFORMATION_MESSAGE); // Success message dikhana
                con.remove(depositPanel); // Deposit panel ko remove karo
            } catch (NumberFormatException ex) { // Agar input invalid hai
                JOptionPane.showMessageDialog(this, "Invalid amount entered. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE); // Error message dikhana
            } finally {
                this.revalidate(); // Panel ko dobara validate karo
                this.repaint(); // Panel ko dobara repaint karo
            }
        });
    }


//WITHDRAWAL PANEL
    private void showWithdrawPanel() { // Withdraw panel dikhane ka method
        JPanel withdrawPanel = new JPanel(); // Naya JPanel create karna
        withdrawPanel.setLayout(new FlowLayout()); // Flow layout set karo
        withdrawPanel.setBackground(Color.WHITE); // Background color white set karo for visibility
    
//adding components to the withdrawal panel
        l5 = new JLabel("Enter Amount to Withdraw"); // Label for withdrawal amount
        t2 = new JTextField(10); // TextField for amount input
        b7 = new JButton("Ok"); // Ok button create karna

        withdrawPanel.add(l5); // Label ko withdraw panel mein add karo
        withdrawPanel.add(t2); // TextField ko withdraw panel mein add karo
        withdrawPanel.add(b7); // Button ko withdraw panel mein add karo
        
  //setting positions and sizes      
        withdrawPanel.setBounds(425, 260, 330, 100); // Panel ka position aur size set karo
        con.add(withdrawPanel); // Withdraw panel ko main container mein add karo
//revalidating and repainting
        this.revalidate(); // Panel ko dobara validate karo
        this.repaint(); // Panel ko dobara repaint karo

        
    b7.addActionListener(withdrawEvent -> { // Jab Ok button pe click hota hai
        try {
            double amount2 = Double.parseDouble(t2.getText()); // Input amount ko double mein convert karo
            if (amount2 <= 0 || amount2 > balance) { // Agar amount zero se kam hai ya balance se zyada hai
                throw new NumberFormatException(); // Exception throw karo
            }
            balance -= amount2; // Balance se amount subtract karo
            transactions.add("Withdrew: Rs." + amount2); // Transaction record karo
            JOptionPane.showMessageDialog(this, "Amount withdrawn successfully! ", "Withdraw", JOptionPane.INFORMATION_MESSAGE); // Success message dikhana
            con.remove(withdrawPanel); // Withdraw panel ko remove karo
        } catch (NumberFormatException ex) { // Agar input invalid hai
            JOptionPane.showMessageDialog(this, "Invalid amount entered. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE); // Error message dikhana
        } finally {
            this.revalidate(); // Panel ko dobara validate karo
            this.repaint(); // Panel ko dobara repaint karo
        }
    });
}

    public void showBalance() {// Balance dikhane ka method
        JOptionPane.showMessageDialog(this, "Current Balance: Rs." + balance, "Balance", JOptionPane.INFORMATION_MESSAGE);// Current balance dikhana
    }

    public static void main(String[] args) {
        new BankTrust("Bank Trust", "John Doe", "1234567890");// Naya BankTrust object create karo
    }
}
