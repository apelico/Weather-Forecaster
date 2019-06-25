package org;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CustomLabel extends JLabel{
	public CustomLabel(String text,int fontSize, int x, int y, int width, int height, boolean isBold)
	{
		this.setText(text);
		this.setBounds(x,y,width,height);
		if(isBold)
			setFont(new Font("Monospaced", Font.BOLD, fontSize));
		else
			setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		setHorizontalAlignment(SwingConstants.CENTER);
	}
}
