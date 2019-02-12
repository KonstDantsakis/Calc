import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Container;


public class Calculator implements ActionListener {

    JFrame guiFrame;
    JPanel buttonPanel;
    JTextField numberCalc;
    int calcOperation = 0;
    int currentCalc;

    public Calculator() {
        guiFrame = new JFrame();

        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Simple Calculator");
        guiFrame.setSize(300, 300);

        guiFrame.setLocationRelativeTo(null);

        numberCalc = new JTextField();
        numberCalc.setHorizontalAlignment(JTextField.RIGHT);
        numberCalc.setEditable(false);

        guiFrame.add(numberCalc, BorderLayout.NORTH);

        buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(6, 3));
        guiFrame.add(buttonPanel, BorderLayout.CENTER);

        // Add the number buttons
        for (int i = 1; i < 10; i++) {
            addButton(buttonPanel, String.valueOf(i));
        }
        addButton(buttonPanel, "");
        addButton(buttonPanel, "0");
        addButton(buttonPanel, "");

        JButton addButton = new JButton("+");
        addButton.setActionCommand("+");

        OperatorAction subAction = new OperatorAction(1);
        addButton.addActionListener(subAction);

        JButton subButton = new JButton("-");
        subButton.setActionCommand("-");

        OperatorAction addAction = new OperatorAction(2);
        subButton.addActionListener(addAction);

        JButton mulButton = new JButton("*");
        mulButton.setActionCommand("*");

        OperatorAction mulAction = new OperatorAction(3);
        mulButton.addActionListener(mulAction);

        JButton divButton = new JButton("/");
        divButton.setActionCommand("/");

        OperatorAction divAction = new OperatorAction(4);
        divButton.addActionListener(divAction);

        JButton equalsButton = new JButton("=");
        equalsButton.setActionCommand("=");
        equalsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                if (!numberCalc.getText().isEmpty()) {
                    int number = Integer.parseInt(numberCalc.getText());
                    if (calcOperation == 1) {
                        int calculate = currentCalc + number;
                        numberCalc.setText(Integer.toString(calculate));
                    } else if (calcOperation == 2) {
                        int calculate = currentCalc - number;
                        numberCalc.setText(Integer.toString(calculate));
                    }
                    else if (calcOperation == 3) {
                        int calculate = currentCalc * number;
                        numberCalc.setText(Integer.toString(calculate));
                    }
                    else if (calcOperation == 4) {
                        int calculate = currentCalc / number;
                        numberCalc.setText(Integer.toString(calculate));
                    }
                }
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        buttonPanel.add(equalsButton);
        guiFrame.setVisible(true);
    }


    private void addButton(Container parent, String name) {
        JButton but = new JButton(name);
        but.setActionCommand(name);
        but.addActionListener(this);
        parent.add(but);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
        numberCalc.setText(action);
    }

    private class OperatorAction implements ActionListener {
        private int operator;


        public OperatorAction(int operation) {
            operator = operation;
        }


        public void actionPerformed(ActionEvent event) {
            currentCalc = Integer.parseInt(numberCalc.getText());
            calcOperation = operator;
        }
    }
}