
package Formulario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bienvenida extends JFrame implements ActionListener {

    private JTextField usuarioField;
    private JPasswordField contrasenaField;
    private JButton ingresarButton;

    public Bienvenida() {
        setTitle("Bienvenido");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imagenFondo = new ImageIcon("C:\\Users\\HP\\Pictures\\Saved Pictures\\fondo2.jpg");
                g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("BIENVENIDOS");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(120, 50, 300, 30);
        panel.add(titleLabel);

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setForeground(Color.BLACK);
        usuarioLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        usuarioLabel.setBounds(90, 100, 150, 25);
        panel.add(usuarioLabel);

        usuarioField = new JTextField();
        usuarioField.setBounds(90, 130, 175, 30);
        panel.add(usuarioField);

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setForeground(Color.BLACK);
        contrasenaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        contrasenaLabel.setBounds(90, 170, 150, 25);
        panel.add(contrasenaLabel);

        contrasenaField = new JPasswordField();
        contrasenaField.setBounds(90, 200, 175, 30);
        panel.add(contrasenaField);

        ingresarButton = new JButton("Entrar");
        ingresarButton.setBounds(120, 240, 110, 30);
        ingresarButton.addActionListener(this);
        panel.add(ingresarButton);

        JLabel footerLabel = new JLabel("");
        footerLabel.setForeground(Color.PINK);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        footerLabel.setBounds(100, 320, 200, 25);
        panel.add(footerLabel);

        JLabel footerLabel2 = new JLabel("");
        footerLabel2.setForeground(Color.BLACK);
        footerLabel2.setFont(new Font("Arial", Font.BOLD, 15));
        footerLabel2.setBounds(50, 350, 300, 25);
        panel.add(footerLabel2);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ingresarButton) {
            String usuario = usuarioField.getText();
            String contrasena = new String(contrasenaField.getPassword());

            // Verifica si el usuario y contraseña son correctos
            if (usuario.equals("Amanda") && contrasena.equals("1998")) {
  
                dispose();  // Cierra la ventana actual de Bienvenida
                new Crud(); // Abre la ventana Crud
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new Bienvenida();
    }
}

/*JLabel titleLabel = new JLabel("BIENVENIDOS");
...
usuarioField = new JTextField();
contrasenaField = new JPasswordField();
ingresarButton = new JButton("Entrar");
*/