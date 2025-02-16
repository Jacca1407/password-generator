import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.util.Random;

//CheckBox class
class CheckBox extends JCheckBox {
    public CheckBox(String txt){
        setText(txt);
        setForeground(Color.darkGray);
        setBackground(Color.white);
        setMargin(new Insets(10, 30, 10, 30));
        setFont(new Font("Arial", Font.BOLD, 14));
        setFocusPainted(false);
    }
}

//Window class
class Window extends JFrame{
    //Variable declaration
    static JTextField textField;
    CBListener CBListener;
    ButtonListener ButtonListener;
    SliderListener SliderListener;
    static JButton gen;
    JLabel title;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    static JSlider slider;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;

    public Window(){
        //Window personalization
        setTitle("PSW-gen");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1));

        //Look & Feel
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Error");
        }

        //Button personalization
        gen = new JButton("Generate");
        gen.setFont(new Font("Arial", Font.BOLD, 19));
        gen.setForeground(Color.darkGray);
        gen.setBackground(Color.white);
        gen.setMargin(new Insets(10, 20, 10, 20));
        gen.setFocusPainted(false);
        gen.setEnabled(false);

        //Title label
        title = new JLabel("PSW generator");
        title.setFont(new Font("Arial", Font.BOLD, 33));
        title.setBorder(new EmptyBorder(20, 30, 20, 30));

        //Panels and personalization
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel1.setBackground(new Color(238, 238,238));
        panel2.setBackground(new Color(238, 238,238));
        panel3.setBackground(new Color(238, 238,238));

        //Slider personalization
        slider = new JSlider(JSlider.HORIZONTAL, 5, 32, 8);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBorder(new EmptyBorder(10, 30, 20, 30));

        //textField personalization
        textField = new JTextField(32);
        textField.setEditable(false);
        textField.setMargin(new Insets(5, 5, 3, 5));
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setText("Generated Password");

        //Panel components
        panel1.add(title);
        panel2.add(gen);
        panel3.add(textField);

        //Checkbox creation
        cb1 = new CheckBox("Letters");
        cb2 = new CheckBox("Numbers");
        cb3 = new CheckBox("Special characters");

        //Listeners
        CBListener = new CBListener();
        ButtonListener = new ButtonListener();
        SliderListener = new SliderListener();

        //Adding listeners
        cb1.addItemListener(CBListener);
        cb2.addItemListener(CBListener);
        cb3.addItemListener(CBListener);
        gen.addActionListener(ButtonListener);
        slider.addChangeListener(SliderListener);

        //Window components
        add(panel1);
        add(slider);
        add(cb1);
        add(cb2);
        add(cb3);
        add(panel2);
        add(panel3);
    }
}

//Main class
public class Main {
    //Variable declaration
    static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static String numbers = "0123456789";
    static String SpecialChar = "!@#$%^*()-_=+[]{};:.<>?/\\|`~";
    static String total_str = "";
    static String psw = "";
    static Random random = new Random();
    static Window frame;
    static int value = 8;

    //Main method
    public static void main(String[] args) {
        //Creation of the window
        frame = new Window();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    //Password generation method
    public static void PSW_gen(String str1, String str2, String str3){
        //String containing all the characters the user wants to use
        total_str = str1 + str2 + str3;

        //Creates the password by concatenating the empty psw string with random letters from total_str
        for (int i = 1; i <= value; i++) {
            psw += total_str.charAt(random.nextInt(total_str.length()));
        }
        //Sets the text field's text as the password
        Window.textField.setText(psw);
    }
}
