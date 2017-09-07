import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URI;


@SuppressWarnings("serial")
public class URLLabel extends JLabel{
	private String URL;
	
	public URLLabel(String text, String URL) {
		super(text);
		this.URL = URL;
		
		setForeground(Color.BLUE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new URLOpenAdapter());
	}
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.blue);

        Insets insets = getInsets();

        int left = insets.left;
        if (getIcon() != null) {
            left += getIcon().getIconWidth() + getIconTextGap();
        }

        g.drawLine(left, getHeight() - 1 - insets.bottom, 
			(int) getPreferredSize().getWidth()
                - insets.right, getHeight() - 1 - insets.bottom);
    }

    private class URLOpenAdapter extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI(URL));
                } catch (Throwable t) {
                    //
                }
            }
        }
    }
}
