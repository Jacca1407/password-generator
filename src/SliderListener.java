import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Slider listener class
public class SliderListener implements ChangeListener {
    //Method that's called when the slider's value changes
    @Override
    public void stateChanged(ChangeEvent e) {
        //Sets the variable value as the sliders value
        Main.value = Window.slider.getValue();
    }
}
