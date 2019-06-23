package org;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CustomLabel extends JLabel{
	public CustomLabel(String text,int fontSize, int x, int y, int width, int height)
	{
		this.setText(text);
		this.setBounds(x,y,width,height);
		setFont(new Font("Monospaced", Font.BOLD, fontSize));
		setHorizontalAlignment(SwingConstants.CENTER);
	}
}
