

import java.awt.*; // AWT (Abstract Window Toolkit) classes import kar rahe hain
import javax.swing.*; // Swing classes (GUI components) import kar rahe hain
import java.util.List; // List interface import kar rahe hain

// MiniStatementFrame class banayi jo JFrame (GUI window) inherit kar rahi hai
class MiniStatementFrame extends JFrame {
//instance variable
    JTextArea textArea; // TextArea banaya jisme text (transactions) dikhaenge
    JScrollPane scrollPane; // ScrollPane banaya taaki scroll kar sakein agar text zyada ho

    // Constructor banaya jo transactions list lega
    MiniStatementFrame(List<String> transactions) {
        super("Mini Statement"); // Frame ka title set kiya
        //Initializing the JTextArea
        textArea = new JTextArea(); // Nayi JTextArea banayi
        textArea.setEditable(false); // TextArea ko read-only banaya taaki user edit na kar sake


        //checking for empty transactions
        // Agar transactions list khaali hai toh message dikhayenge
        if (transactions.isEmpty()) {
            textArea.setText("No transactions done."); // "No transactions done." message set kiya
        } else {
            StringBuilder sb = new StringBuilder(); // StringBuilder banaya taaki transactions ko ek string me jod sakein
            // Har transaction ko ek-ek karke append karenge

            //appending transactions
            for (String transaction : transactions) {
                sb.append(transaction).append("\n"); // Transaction add kiya aur nayi line start ki
            }
            textArea.setText(sb.toString()); // TextArea me sb ko set kar diya jo poora text hai
        }

        //JscrollPaneInitialization
        //Wrap in JScrollPane: The textArea is wrapped in a JScrollPane, enabling scrolling if the content overflows the visible area.
        scrollPane = new JScrollPane(textArea); // TextArea ko JScrollPane me wrap kiya taaki scroll kar sakein

        //Adding to the frame
        //Add JScrollPane to JFrame: Finally, the scrollPane is added to the frame's content pane in the center using BorderLayout.CENTER, allowing it to expand and occupy the available space.
        getContentPane().add(scrollPane, BorderLayout.CENTER); // JScrollPane ko frame ke center me add kiya
    }
}

