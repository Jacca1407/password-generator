import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//CheckBox listener class
public class CBListener implements ItemListener {
    //Variable declaration
    boolean checkb1;
    boolean checkb2;
    boolean checkb3;
    static String str_after1 = "";
    static String str_after2 = "";
    static String str_after3 = "";

    //Method that's called when the slider's value changes
    @Override
    public void itemStateChanged(ItemEvent e) {
        //Sets the string that will be used as arguments for PSW_gen() as the Main.letters/Main.numbers/Main.SpecialChar string when the checkBox and sets them as "" when the checkBox isn't selected
        JCheckBox checkBox = (JCheckBox) e.getSource();
        switch (checkBox.getText()){
            case "Letters":
                checkb1 = checkBox.isSelected();
                if (checkBox.isSelected()){str_after1 = Main.letters;} else {str_after1 = "";};
                break;
            case "Numbers":
                checkb2 = checkBox.isSelected();
                if (checkBox.isSelected()){str_after2 = Main.numbers;} else {str_after2 = "";};
                break;
            case "Special characters":
                checkb3 = checkBox.isSelected();
                if (checkBox.isSelected()){str_after3 = Main.SpecialChar;} else {str_after3 = "";};
                break;
        }
        //Makes the button disabled when no checkBox is selected
        Window.gen.setEnabled(checkb1 || checkb2 || checkb3);
    }
}