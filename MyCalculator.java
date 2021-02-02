import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MyCalculator extends JFrame implements ActionListener {
	//eclipse made me put this on here
	private static final long serialVersionUID = -5350802185288370028L;
	
	// Panels
	JPanel bPanel;
	JPanel tPain;
	JPanel mPanel;
	JPanel wPanel;
	JPanel w2Panel;
	JPanel uPanel;
	JPanel ePanel;

	// text area on the right
	JTextArea l;

	// buttons on the left
	JButton hex;
	JButton dec;
	JButton oct;
	JButton bin;

	// labels on the left
	JLabel hexL;
	JLabel decL;
	JLabel octL;
	JLabel binL;

	// buttons on top of main keypad
	JButton bKey;
	JButton lKey;
	JButton word;
	JButton MS;
	JButton M;
	JButton buttLsh;
	JButton buttRsh;
	JButton buttOr;
	JButton buttXor;
	JButton buttNot;
	JButton buttAnd;

	// buttons on main keypad
	JButton bUp;
	JButton bMod;
	JButton bCE;
	JButton bC;
	JButton backspace;
	// operators
	JButton bDiv;
	JButton bMult;
	JButton bSub;
	JButton bAdd;
	JButton bEq;
	JButton bPM;
	// numbers
	JButton b0;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	JButton bLP;
	JButton bRP;
	JButton bDec;
	JButton buttA;
	JButton buttB;
	JButton buttC;
	JButton buttD;
	JButton buttE;
	JButton buttF;

	// top panels label and button
	JButton menu;
	JLabel prog;

	// segments in calculation
	String s1 = "";
	String s2 = "";
	String s0 = "";

	// CONSTRUCTOR
	public MyCalculator() {
		Font font = new Font("Segoe UI", Font.BOLD, 20);

		// top panel with menu button and Programmer label

		tPain = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		// top menu button
		menu = new JButton("≡");
		menu.setContentAreaFilled(false);
		menu.setBackground(tPain.getBackground());
		menu.setOpaque(false);
		menu.setPreferredSize(new Dimension(50, 50));
		menu.setFont(font);
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 0;

		// adding to top panel
		tPain.add(menu, c);

		// setting font for "programmer" label and aligning
		font = new Font("Segoe UI", Font.BOLD, 18);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.90;
		c.gridx = 1;
		c.gridy = 0;
		prog = new JLabel("PROGRAMMER");
		prog.setAlignmentX(JTextArea.LEFT_ALIGNMENT);
		prog.setFont(font);

		// adding label to panel
		tPain.add(prog, c);

		// adding top panel to window
		add(tPain, BorderLayout.NORTH);

		// MIDDLE PANEL

		mPanel = new JPanel(new BorderLayout());

		// panel where mostly useless buttons are except "word"
		// panel is within the middle panel
		uPanel = new JPanel(new GridBagLayout());
		GridBagConstraints b = new GridBagConstraints();
		uPanel.setPreferredSize(new Dimension(30, 30));

		// constraints for gridbag layout
		b.fill = GridBagConstraints.HORIZONTAL;
		b.weightx = 0.14;
		b.gridx = 0;
		b.gridy = 0;
		bKey = new JButton(":::");
		bKey.setContentAreaFilled(false);
		bKey.setBackground(mPanel.getBackground());
		bKey.setOpaque(false);
		bKey.setForeground(Color.BLUE);
		uPanel.add(bKey, b);

		b.weightx = 0.19;
		b.weighty = 1;
		b.gridx = 1;
		lKey = new JButton("::");
		lKey.setContentAreaFilled(false);
		lKey.setBackground(mPanel.getBackground());
		lKey.setOpaque(false);
		uPanel.add(lKey, b);

		// WORD button
		// functional
		b.weightx = 0.54;
		b.gridx = 2;
		font = new Font("Segoe UI", Font.BOLD, 12);
		word = new JButton("WORD");
		word.addActionListener(this);
		word.setContentAreaFilled(false);
		word.setBackground(mPanel.getBackground());
		word.setOpaque(false);
		word.setFont(font);
		word.setForeground(Color.BLUE);
		uPanel.add(word, b);

		b.weightx = 0.11;
		b.gridx = 3;
		MS = new JButton("MS");
		MS.setContentAreaFilled(false);
		MS.setBackground(mPanel.getBackground());
		MS.setOpaque(false);
		uPanel.add(MS, b);

		b.weightx = 0.19;
		b.gridx = 4;
		M = new JButton("M");
		M.setContentAreaFilled(false);
		M.setBackground(mPanel.getBackground());
		M.setOpaque(false);
		uPanel.add(M, b);

		// adding useless panel to middle panel
		mPanel.add(uPanel, BorderLayout.SOUTH);

		// adding middle panel to window
		add(mPanel, BorderLayout.CENTER);

		// TEXT AREA CODE
		// east panel
		ePanel = new JPanel();

		// main text area!
		l = new JTextArea();
		l.setAlignmentX(SwingConstants.RIGHT);
		font = new Font("Segoe UI", Font.BOLD, 20);
		l.setBackground(ePanel.getBackground());
		l.setText("0");
		l.setPreferredSize(new Dimension(200, 120));
		l.setFont(font);

		// add label to east panel
		ePanel.add(l);

		// adding east panel to middle panel
		mPanel.add(ePanel, BorderLayout.EAST);

		// west panel in middle panel
		// where conversions are
		{
			w2Panel = new JPanel(new BorderLayout());
			wPanel = new JPanel(new GridBagLayout());
			wPanel.setPreferredSize(new Dimension(150, 100));
			GridBagConstraints c1 = new GridBagConstraints();
			c1.fill = GridBagConstraints.HORIZONTAL;

			
			//hexadecimal button
			c1.weightx = 0.5;
			c1.gridy = 2;
			c1.gridx = 0;
			hex = new JButton("HEX");
			hex.addActionListener(this);
			hex.setContentAreaFilled(false);
			hex.setBackground(mPanel.getBackground());
			hex.setOpaque(false);
			wPanel.add(hex, c1);

			//decimal button
			c1.gridy = 3;
			dec = new JButton("DEC");
			dec.addActionListener(this);
			dec.setContentAreaFilled(false);
			dec.setBackground(mPanel.getBackground());
			dec.setForeground(Color.BLUE);
			dec.setOpaque(false);
			wPanel.add(dec, c1);

			//octal button
			c1.gridy = 4;
			oct = new JButton("OCT");
			oct.addActionListener(this);
			oct.setContentAreaFilled(false);
			oct.setBackground(mPanel.getBackground());
			oct.setOpaque(false);
			wPanel.add(oct, c1);

			//binary button
			c1.gridy = 5;
			bin = new JButton("BIN");
			bin.addActionListener(this);
			bin.setContentAreaFilled(false);
			bin.setBackground(mPanel.getBackground());
			bin.setOpaque(false);
			wPanel.add(bin, c1);

			//hexadecimal number label
			c1.gridx = 1;
			c1.gridy = 2;
			hexL = new JLabel("0");
			hexL.setHorizontalAlignment(SwingConstants.RIGHT);
			wPanel.add(hexL, c1);

			//decimal number label
			c1.gridy = 3;
			decL = new JLabel("0");
			decL.setForeground(Color.BLUE);
			decL.setHorizontalAlignment(SwingConstants.RIGHT);
			wPanel.add(decL, c1);

			//octal number label
			c1.gridy = 4;
			octL = new JLabel("0");
			octL.setHorizontalAlignment(SwingConstants.RIGHT);
			wPanel.add(octL, c1);

			//binary number label
			c1.gridy = 5;
			binL = new JLabel("0");
			binL.setHorizontalAlignment(SwingConstants.RIGHT);
			wPanel.add(binL, c1);

			//add panel to arrange w panel on southwestern portion of middle panel
			w2Panel.add(wPanel, BorderLayout.SOUTH);
			
			//adding w2 panel to middle panel
			mPanel.add(w2Panel, BorderLayout.WEST);
		}

		// PANEL B (BUTTONS)
		bPanel = new JPanel();
		bPanel.setPreferredSize(new Dimension(400, 300));

		// CREATE BUTTONS, SET NAME AND COLOR, ADDS ACTION LISTENER

		buttLsh = new JButton("Lsh");
		buttLsh.setContentAreaFilled(false);
		buttLsh.setBackground(mPanel.getBackground());
		buttLsh.setOpaque(false);

		buttRsh = new JButton("Rsh");
		buttRsh.setContentAreaFilled(false);
		buttRsh.setBackground(mPanel.getBackground());
		buttRsh.setOpaque(false);

		buttOr = new JButton("Or");
		buttOr.setContentAreaFilled(false);
		buttOr.setBackground(mPanel.getBackground());
		buttOr.setOpaque(false);

		buttXor = new JButton("Xor");
		buttXor.setContentAreaFilled(false);
		buttXor.setBackground(mPanel.getBackground());
		buttXor.setOpaque(false);

		buttNot = new JButton("Not");
		buttNot.setContentAreaFilled(false);
		buttNot.setBackground(mPanel.getBackground());
		buttNot.setOpaque(false);

		buttAnd = new JButton("And");
		buttAnd.setContentAreaFilled(false);
		buttAnd.setBackground(mPanel.getBackground());
		buttAnd.setOpaque(false);

		font = new Font("Segoe UI", Font.BOLD, 22);
		bUp = new JButton("↑");
		bUp.addActionListener(this);
		bUp.setFont(font);

		bMod = new JButton("Mod");
		bMod.addActionListener(this);

		bCE = new JButton("CE");
		bCE.addActionListener(this);

		bC = new JButton("C");
		bC.addActionListener(this);

		backspace = new JButton("←");
		backspace.addActionListener(this);

		bDiv = new JButton("÷");
		bDiv.addActionListener(this);

		bMult = new JButton("×");
		bMult.addActionListener(this);

		bSub = new JButton("-");
		bSub.addActionListener(this);

		bAdd = new JButton("+");
		bAdd.addActionListener(this);

		bEq = new JButton("=");
		bEq.addActionListener(this);

		bPM = new JButton("±");

		b0 = new JButton("0");
		b0.addActionListener(this);

		b1 = new JButton("1");
		b1.addActionListener(this);

		b2 = new JButton("2");
		b2.addActionListener(this);

		b3 = new JButton("3");
		b3.addActionListener(this);

		b4 = new JButton("4");
		b4.addActionListener(this);

		b5 = new JButton("5");
		b5.addActionListener(this);

		b6 = new JButton("6");
		b6.addActionListener(this);

		b7 = new JButton("7");
		b7.addActionListener(this);

		b8 = new JButton("8");
		b8.addActionListener(this);

		b9 = new JButton("9");
		b9.addActionListener(this);

		bLP = new JButton("(");
		bLP.addActionListener(this);

		bRP = new JButton(")");
		bRP.addActionListener(this);

		bDec = new JButton(".");
		bDec.addActionListener(this);

		buttA = new JButton("A");
		buttA.setForeground(Color.lightGray);
		buttA.addActionListener(this);

		buttB = new JButton("B");
		buttB.setForeground(Color.lightGray);
		buttB.addActionListener(this);

		buttC = new JButton("C");
		buttC.setForeground(Color.lightGray);
		buttC.addActionListener(this);

		buttD = new JButton("D");
		buttD.setForeground(Color.lightGray);
		buttD.addActionListener(this);

		buttE = new JButton("E");
		buttE.setForeground(Color.lightGray);
		buttE.addActionListener(this);

		buttF = new JButton("F");
		buttF.setForeground(Color.lightGray);
		buttF.addActionListener(this);

		bPanel.setLayout(new GridLayout(6, 6, 0, 0));

		// ADD BUTTONS TO PANEL B
		bPanel.add(buttLsh);
		bPanel.add(buttRsh);
		bPanel.add(buttOr);
		bPanel.add(buttXor);
		bPanel.add(buttNot);
		bPanel.add(buttAnd);

		bPanel.add(bUp);
		bPanel.add(bMod);
		bPanel.add(bCE);
		bPanel.add(bC);
		bPanel.add(backspace);
		bPanel.add(bDiv);
		bPanel.add(buttA);
		bPanel.add(buttB);
		bPanel.add(b7);
		bPanel.add(b8);
		bPanel.add(b9);
		bPanel.add(bMult);
		bPanel.add(buttC);
		bPanel.add(buttD);
		bPanel.add(b4);
		bPanel.add(b5);
		bPanel.add(b6);
		bPanel.add(bSub);
		bPanel.add(buttE);
		bPanel.add(buttF);
		bPanel.add(b1);
		bPanel.add(b2);
		bPanel.add(b3);
		bPanel.add(bAdd);
		bPanel.add(bLP);
		bPanel.add(bRP);
		bPanel.add(bPM);
		bPanel.add(b0);
		bPanel.add(bDec);
		bPanel.add(bEq);

		// ADD button PANEL TO WINDOW
		add(bPanel, BorderLayout.SOUTH);

	}

	//if action performed, determine what to do
	public void actionPerformed(ActionEvent e) {
		
		String s = e.getActionCommand();

		// if a number is typed in
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {

			
			// if there is already a first number
			if (!s1.equals("")) {
				
				s2 = s2 + s;
			}
			else {
				s0 = s0 + s;
	
			}

			
			// reset the new text
			l.setText(s0 + " " + s1 + " " + s2);
			
			
		}
		// to clear text
		else if (s.charAt(0) == 'C') {
			s0 = s1 = s2 = "";

			// set the value of text
			l.setText(s0 + " " + s1 + " " + s2);
			hexL.setText("0");
			decL.setText("0");
			octL.setText("0");
			binL.setText("0");

		}

		// EVALUATE :)
		else if (s.charAt(0) == '=') {

			double te = 0;

			// store the value in 1st
			if (s1.equals("+")) {
				te = (Double.parseDouble(s0) + Double.parseDouble(s2));
			} else if (s1.equals("-")) {
				te = (Double.parseDouble(s0) - Double.parseDouble(s2));
			} else if (s1.equals("÷")) {
				te = (Double.parseDouble(s0) / Double.parseDouble(s2));
			} else if (s1.equals("×")) {
				te = (Double.parseDouble(s0) * Double.parseDouble(s2));
			} else if (s1.contentEquals("Mod")) {
				te = (Double.parseDouble(s0) % Double.parseDouble(s2));
			}

			// set the value of text
			l.setText(s0 + " " + s1 + " " + s2 + " = " + te);

			// convert it to string
			s0 = Double.toString(te);

			int res = (int) te;
			decL.setText(Integer.toString(res));
			binL.setText(dec2Bin(res));
			hexL.setText(dec2Hex(res));
			octL.setText(dec2Oct(res));

			//once done evaluating, reset segments
			s1 = s2 = "";
			
		} 
		//to backspace
		else if (s.charAt(0) == '←') {
			String newText = removeLastCharacter(l.getText());
			l.setText(newText);
		} 
		//if word is clicked
		else if (s.charAt(0) == 'W') {
			l.setText("word clicked");
		} 
		//if there was no operand
		else {
			if (s1.equals("") || s2.equals(""))
				s1 = s;
			// else evaluate
			else {
				double te = 0;

				// store the value in 1st
				if (s1.equals("+"))
					te = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					te = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("÷"))
					te = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else if (s1.contentEquals("×"))
					te = (Double.parseDouble(s0) * Double.parseDouble(s2));


				// convert it to string
				s0 = Double.toString(te);

				// place the operator
				s1 = s;

				// make the operand blank
				s2 = " ";
			}

			// set the value of text
			l.setText(s0 + " " + s1 + " " + s2);


		}

	}

	//converts decimal to string
	public String dec2Bin(int value) {
		String result = "";
		return dec2Bin(value, result);
	}

	//converts decimal string to binary
	public String dec2Bin(int value, String result) {
		if (value / 2 == 0) {
			// for last value
			return (value % 2) + result;
		} else {
			return dec2Bin(value / 2, (value % 2) + result);
		}
	}

	//converts decimal to string
	public static String dec2Hex(int value) {
		String result = "";
		return dec2Hex(value, result);
	}

	//converts decimal string to hexadecimal
	public static String dec2Hex(int value, String result) {
		int r = value % 16;

		String remainder = r >= 10 ? String.valueOf((char) ('A' + r % 10)) : String.valueOf(r);

		// reach end of number
		if (value / 16 == 0) {
			return remainder + result;
		}
		// keep calculating
		else {
			return dec2Hex(value / 16, remainder + result);
		}
	}

	//converts decimal to string
	public static String dec2Oct(int value) {
		String result = "";
		return dec2Oct(value, result);
	}

	//converts decimal string to octal
	public static String dec2Oct(int value, String result) {
		if (value / 8 == 0) {
			// for last value
			return (value % 8) + result;
		} else {
			return dec2Oct(value / 8, (value % 8) + result);
		}
	}

	// removes the last character typed
	public static String removeLastCharacter(String str) {
		String result = null;
		if ((str != null) && (str.length() > 0)) {
			result = str.substring(0, str.length() - 1);
		}
		return result;
	}

}
