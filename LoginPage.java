import java.awt.*; // Java library import for GUI components
import javax.swing.*; // Importing Swing library for GUI components

//class declaration
class Login extends JFrame { // Ek class 'Login' define kar rahe hain jo 'JFrame' se inherit kar rahi hai

//instance variable
    JLabel l0, l1, l2; // 3 labels declare kiye hain
    JPasswordField f1; // Ek password field declare kiya hai
    JTextField t0, t1; // 2 text fields declare kiye hain
    JButton b1; // Ek button declare kiya hai

    Container con; // Ek container declare kiya hai jisme saare components rakhenge
    String uname, acc; // 2 strings 'uname' aur 'acc' declare kiye hain user details ke liye
    private String pass; // Ek private string 'pass' password store karne ke liye

    // Constructor jo 'Login' frame ka title set karta hai aur login form banata hai
    Login(String t) {
        super(t); // Frame ka title set kar rahe hain
        //container setup
        con = getContentPane(); // Frame ka container le rahe hain jahan components rakhenge
        con.setLayout(null); // Absolute layout use kar rahe hain manual positioning ke liye

        //Hardcoded Credentials set kar rahe hain comparison ke liye
        uname = "Shubham"; // User name set kar rahe hain
        acc = "6299410557"; // Account number set kar rahe hain
        pass = "629941"; // Password set kar rahe hain

        // User Name Input
        l0 = new JLabel("User Name:"); // User name ka label banate hain
        t0 = new JTextField(12); // User name ke liye text field banate hain
        l0.setBounds(80, 20, 100, 30); // Label ke position aur size set karte hain
        t0.setBounds(180, 20, 130, 30); // Text field ke position aur size set karte hain
        con.add(l0); // Label container mein add karte hain
        con.add(t0); // Text field container mein add karte hain

        // Account Number Input
        l1 = new JLabel("Account No.:"); // Account number ka label banate hain
        t1 = new JTextField(12); // Account number ke liye text field banate hain
        l1.setBounds(80, 60, 100, 30); // Label ke position aur size set karte hain
        t1.setBounds(180, 60, 130, 30); // Text field ke position aur size set karte hain
        con.add(l1); // Label container mein add karte hain
        con.add(t1); // Text field container mein add karte hain

        // Password Input
        l2 = new JLabel("Password:"); // Password ka label banate hain
        f1 = new JPasswordField(12); // Password ke liye password field banate hain
        l2.setBounds(80, 100, 100, 30); // Label ke position aur size set karte hain
        f1.setBounds(180, 100, 130, 30); // Password field ke position aur size set karte hain
        con.add(l2); // Label container mein add karte hain
        con.add(f1); // Password field container mein add karte hain

        // Login Button
        b1 = new JButton("Login"); // Login button banate hain
        b1.setBounds(160, 140, 80, 30); // Button ka position aur size set karte hain
        con.add(b1); // Button ko container mein add karte hain

        // Action Listener button ke liye, jo event handle karta hai jab button press hota hai
        b1.addActionListener(e -> {
            String unameVal = t0.getText(); // Text field se user name ka value lete hain
            String accValues = t1.getText(); // Text field se account number ka value lete hain
            String passValues = new String(f1.getPassword()); // Password field se password ka value lete hain
            if (unameVal.equals(uname) && accValues.equals(acc) && passValues.equals(pass)) { // Credentials check kar rahe hain
                JOptionPane.showMessageDialog(this, "Login successful", "Login", JOptionPane.INFORMATION_MESSAGE); // Success message dikhate hain
                this.dispose(); // Login window band kar dete hain
                BankTrust b = new BankTrust("Bank Management System", unameVal, accValues); // Nayi frame open karte hain agar login sahi hai
                b.setVisible(true); // Nayi frame ko visible kar dete hain
                b.setSize(800, 730); // Frame ka size set karte hain
                b.setResizable(false); // Frame ko resize disable karte hain
                b.con.setBackground(new Color(255, 182, 193)); // Frame ka background color set karte hain
                b.setLocationRelativeTo(b1); // Frame ko button ke relative center mein set karte hain
                b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Frame close operation set karte hain
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials, Please Re-enter account no. and password", "Login Error", JOptionPane.ERROR_MESSAGE); // Error message dikhate hain agar credentials galat hain
            }
        });
    }
}

class LoginPage { // LoginPage class jo main method rakhta hai
    public static void main(String[] args) {
        Login log = new Login("Tanisha Bank of India Login Page"); // 'Login' object banate hain aur frame ka title set karte hain
        log.setVisible(true); // Frame ko visible kar dete hain
        log.setSize(400, 300); // Frame ka size set karte hain
        log.con.setBackground(new Color(255, 127, 127)); // Frame ka background color set karte hain
        log.setResizable(false); // Frame resizing disable karte hain
        log.setLocationRelativeTo(null); // Frame ko screen ke center mein set karte hain
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Frame close hone pe program exit karte hain
    }
}
