import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Button listener class
class ButtonListener implements ActionListener {
    //Method that's called when the button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        Main.PSW_gen(CBListener.str_after1, CBListener.str_after2, CBListener.str_after3);
        Main.psw = "";
        Main.total_str = "";
    }
}