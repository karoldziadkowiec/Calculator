import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator implements ActionListener {
    JFrame frame;
    JPanel panel;
    JTextField textBox;
    Font myFont = new Font("Comic Sans MS", Font.TRUETYPE_FONT, 30);
    JButton[] numberButtons = new JButton[10]; //numbers 0-9
    JButton[] functionButtons = new JButton[9]; // function buttons include: +,-,*,/,.,=,Delete,Clear,(-)
    JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton, negButton;
    double firstNumber = 0, secondNumber = 0, result = 0;
    char operator;

    Calculator() {
        initializeFrame();
        createComponents();
        addComponentsToPanel();
        addComponentsToFrame();
        frame.setVisible(true);
    }

    private void initializeFrame() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.getContentPane().setBackground(new Color(48, 51, 49));
        ImageIcon icon = new ImageIcon("icon.png");
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);
        frame.setLayout(null);
    }

    private void createComponents() {
        textBox = new JTextField();
        textBox.setBounds(30, 25, 320, 60);
        textBox.setBackground(new Color(145, 171, 152));
        textBox.setFont(myFont);
        textBox.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        clrButton = new JButton("C/CE");
        negButton = new JButton("(-)");
        delButton = new JButton("DEL");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = negButton;
        functionButtons[8] = delButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(new Color(237, 234, 232));
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(237, 234, 232));
        }

        clrButton.setBounds(30, 110, 105, 50);
        clrButton.setBackground(new Color(255, 111, 0));
        clrButton.setForeground(Color.WHITE);
        negButton.setBounds(145, 110, 90, 50);
        delButton.setBounds(245, 110, 105, 50);

        panel = new JPanel();
        panel.setBounds(30, 170, 320, 320);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(new Color(62, 66, 63));
    }

    private void addComponentsToPanel() {
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);
        panel.add(addButton);
    }

    private void addComponentsToFrame() {
        frame.add(panel);
        frame.add(textBox);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(delButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textBox.setText(textBox.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textBox.setText(textBox.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            firstNumber = Double.parseDouble(textBox.getText());
            operator = '+';
            textBox.setText("");
        }
        if (e.getSource() == subButton) {
            firstNumber = Double.parseDouble(textBox.getText());
            operator = '-';
            textBox.setText("");
        }
        if (e.getSource() == mulButton) {
            firstNumber = Double.parseDouble(textBox.getText());
            operator = '*';
            textBox.setText("");
        }
        if (e.getSource() == divButton) {
            firstNumber = Double.parseDouble(textBox.getText());
            operator = '/';
            textBox.setText("");
        }
        if (e.getSource() == equButton) {
            secondNumber = Double.parseDouble(textBox.getText());

            switch (operator) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '/':
                    result = firstNumber / secondNumber;
                    break;
            }
            textBox.setText(String.valueOf(result));
            firstNumber = result;
        }
        if (e.getSource() == clrButton) {
            textBox.setText("");
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textBox.getText());
            temp *= -1;
            textBox.setText(String.valueOf(temp));
        }
        if (e.getSource() == delButton) {
            String string = textBox.getText();
            textBox.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textBox.setText(textBox.getText() + string.charAt(i));
            }
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}
