import javax.swing.*;
import java.io.File;

public class FileBrowser {
    public File Browse() {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            return file;
    }
}