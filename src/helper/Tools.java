package helper;

/**
 *
 * @author thorsten
 */
import entity.Question;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author thorsten
 */
public class Tools {
	/**
	 * Displays an Info-Messagebox
	 * 
	 * @param title
	 * @param text
	 */
	public static void messageBoxInfo(String title, String... text) {
		JOptionPane.showMessageDialog(null, text, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Displays an Error-Messagebox
	 * 
	 * @param title
	 * @param text
	 */
	public static void messageBoxError(String title, String... text) {
		JOptionPane.showMessageDialog(null, text, title, JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Serializes a question
	 * (Unused for now)
	 * 
	 * @param questions
	 * @param filename
	 */
	public void serialize(List<Question> questions, String filename) {
		try {
			ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(filename));
			ous.writeObject(questions);
			ous.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
    }
	
	/**
	 * Deserializes a file
	 * (Unused for now)
	 * 
	 * @param filename
	 * @return
	 */
	public static Object deserialize(String filename) {
		try {
			ObjectInputStream o = new ObjectInputStream(new FileInputStream(filename));
			return o;
		} catch (Exception ex) {
			System.err.println(ex);
			return null;
		}
    }
	
	/**
	 * Centers the frame
	 * 
	 * @param frame
	 */
	public static void centerFrame(JFrame frame) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point center = ge.getCenterPoint();
		Rectangle bounds = ge.getMaximumWindowBounds();
		
		int w = frame.getWidth(),	h = frame.getHeight();
		int x = center.x - w/2,		y = center.y - h/2;
		
		frame.setBounds(x, y, w, h);
		
		if (w == bounds.width && h == bounds.height)
			frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		frame.validate();
	}
}
