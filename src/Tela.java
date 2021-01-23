import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Tela {

    public String textoFinal;
    public URL urlFinal;
    public TextField textField = new TextField();
    public JButton jbutton = new JButton();

    public void getAndClear(TextField textField){

        String texto = textField.getText();
        textField.setText("");
        textoFinal = texto;

        try {
            tryRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void criarTela(String titulo) {
        JFrame frame = new JFrame();
        Rectangle standard = new Rectangle(0, 0, 450, 150);
        frame.setVisible(true);
        frame.setBounds(standard);
        frame.setResizable(false);

        JPanel jPanel = new JPanel();
        jPanel.setBounds(standard);
        jPanel.setLayout(null);


        textField.setBounds(20, 45, 300, 25);


        jbutton.setText("ir");
        jbutton.setBounds(320, 45, 50, 25);

        jPanel.add(jbutton);
        jPanel.add(textField);

        frame.add(jPanel);

    }
    public void pullRequest(){
        textField.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                getAndClear(textField);
                System.out.println(textoFinal);
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    });

        jbutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            getAndClear(textField);
        }
    });

}
    public void tryRequest() throws IOException {

        URL url = new URL(textoFinal);

        URLConnection connection = url.openConnection();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}