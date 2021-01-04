import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tela {

    public void GetAndClear(TextField textField){
        String texto = textField.getText();
        textField.setText("");
        System.out.print(texto);
    }

    public void Tela(){}

    public void criarTela(String titulo){
        JFrame frame = new JFrame();
        Rectangle standard = new Rectangle(0,0,450,150);
        frame.setVisible(true);
        frame.setBounds(standard);
        frame.setResizable(false);
        JPanel jPanel = new JPanel();
        jPanel.setBounds(standard);
        jPanel.setLayout(null);



        TextField textField = new TextField();

        textField.setBounds(20,45,300,25);

        JButton jbutton = new JButton();
        jbutton.setText("ir");
        jbutton.setBounds(320,45,50,25);
        jPanel.add(jbutton);
        jPanel.add(textField);
        frame.add(jPanel);

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                     GetAndClear(textField);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GetAndClear(textField);
            }
        });

    }
}
