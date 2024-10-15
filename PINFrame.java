import java.awt.*; // AWT (Abstract Window Toolkit) classes ko import kar rahe hain
import javax.swing.*; // Swing classes (GUI components) ko import kar rahe hain

// PINFrame class banayi jo JFrame (GUI window) inherit kar rahi hai
class PINFrame extends JFrame {
    JLabel l1; // Label banaya jo "ENTER PIN" text dikhaayega
    JPasswordField t1; // Password field banayi jisme user PIN enter karega
    JPanel p1; // Panel banaya taaki components ko ek saath group kar sakein
    JButton b1; // Button banaya taaki user PIN enter kar sake
    Container con; // Container banaya jo frame ka content hold karega

    // Failed attempts track karne ke liye counter banaya
    private int attemptCounter = 0;
    private static final int MAX_ATTEMPTS = 3; // Maximum allowed attempts set kiye

    // Constructor jo frame ka title aur BankTrust object lega
    PINFrame(String t, BankTrust bank) {
        super(t); // Frame ka title set kar rahe hain
        con = getContentPane(); // Frame ka content pane (area) le rahe hain
        con.setLayout(null); // Null layout set kiya taaki custom positioning kar sakein

        p1 = new JPanel(); // Naya JPanel banaya components group karne ke liye
        l1 = new JLabel("ENTER PIN "); // JLabel banaya jo "ENTER PIN" text dikhayega
        t1 = new JPasswordField(4); // 4-digit password field banayi
        p1.add(l1); // Panel me label add kiya
        p1.add(t1); // Panel me password field add kiya
        p1.setBounds(50, 10, 150, 30); // Panel ki position aur size set kiya
        p1.setOpaque(true); // Panel ko opaque banaya
        con.add(p1); // Panel ko container me add kiya

        b1 = new JButton("Enter"); // Button banaya jisme "Enter" text hai
        Dimension d = b1.getPreferredSize(); // Button ka preferred size liya
        b1.setBounds(95, 50, d.width, 20); // Button ka position aur size set kiya
        con.add(b1); // Button ko container me add kiya

        // Button ke action listener ko set kar rahe hain
        b1.addActionListener(e -> {
            if (e.getSource() == b1) { // Agar event button se aaye toh check karenge
                String pinVal = new String(t1.getPassword()); // User se input liya (password) aur string me convert kiya
                if (pinVal.equals("8004")) { // Agar pin correct hai toh
                    this.dispose(); // Frame close karenge
                    bank.showBalance(); // Bank ka balance dikhayenge
                } else {
                    attemptCounter++; // Counter me 1 add karenge agar pin galat hai
                    if (attemptCounter >= MAX_ATTEMPTS) { // Agar attempts maximum se zyada ho gaye
                        JOptionPane.showMessageDialog(this, "Maximum attempts reached. Access denied.", "PinValidation", JOptionPane.ERROR_MESSAGE);
                        this.dispose(); // Frame close kar denge max attempts ke baad
                    } else {
                        // Baaki attempts dikhaayenge
                        JOptionPane.showMessageDialog(this, "Invalid Pin Entered. Attempts left: " + (MAX_ATTEMPTS - attemptCounter), "PinValidation", JOptionPane.ERROR_MESSAGE);
                        t1.setText(""); // Incorrect attempt ke baad password field clear karenge
                    }
                }
            }
        });

        // Default close operation set kar rahe hain aur frame ka size set kar rahe hain
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Frame dispose ho jayega jab close button press karenge
        setSize(250, 120); // Frame ka size set kiya
        setResizable(false); // Frame ko resize nahi kar sakte
        setLocationRelativeTo(null); // Frame ko center me position karenge
    }
}

