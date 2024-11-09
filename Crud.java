
package Formulario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Crud extends JFrame implements ActionListener {

    private JButton ingresarButton;
    private JButton consultarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JButton buscarCodigoButton;
    private JButton buscarNombreButton;
    
    private List<Producto> productos = new ArrayList<>(); // simular base de datos

    public Crud() {
        setTitle("Bienvenido");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Crear la barra de menú y el menú desplegable
        JMenuBar menuBar = new JMenuBar();
        JMenu menuOpciones = new JMenu("Opciones");
        
        // Crear los elementos del menú
        JMenuItem ventaItem = new JMenuItem("Venta");
        JMenuItem reporteriaItem = new JMenuItem("Reportería");
        

        // Agregar los elementos al menú
        menuOpciones.add(ventaItem);
        menuOpciones.add(reporteriaItem);
      

        // Agregar el menú a la barra de menú y la barra de menú al marco
        menuBar.add(menuOpciones);
        setJMenuBar(menuBar);

        // Panel de fondo con imagen
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imagenFondo = new ImageIcon("C:\\Users\\HP\\Downloads\\Fondo De Libreta.jfif");
                g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        // Configuración de componentes de la ventana
        JLabel titleLabel = new JLabel("AMADA ELEGANCIA");
        titleLabel.setForeground(Color.PINK);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(100, 85, 300, 30);
        panel.add(titleLabel);

        ingresarButton = new JButton("Ingresar");
        ingresarButton.setBounds(30, 175, 150, 30);
        ingresarButton.addActionListener(this);
        panel.add(ingresarButton);

        consultarButton = new JButton("Consultar");
        consultarButton.setBounds(205, 175, 150, 30);
        consultarButton.addActionListener(this);
        panel.add(consultarButton);

        actualizarButton = new JButton("Actualizar");
        actualizarButton.setBounds(30, 235, 150, 30);
        actualizarButton.addActionListener(this);
        panel.add(actualizarButton);

        eliminarButton = new JButton("Eliminar");
        eliminarButton.setBounds(205, 235, 150, 30);
        eliminarButton.addActionListener(this);
        panel.add(eliminarButton);

        buscarCodigoButton = new JButton("Buscar código");
        buscarCodigoButton.setBounds(30, 300, 150, 30);
        buscarCodigoButton.addActionListener(this);
        panel.add(buscarCodigoButton);

        buscarNombreButton = new JButton("Buscar nombre");
        buscarNombreButton.setBounds(205, 300, 150, 30);
        buscarNombreButton.addActionListener(this);
        panel.add(buscarNombreButton);

        add(panel);
        setVisible(true);
        }
    private void abrirVentanaIngresar() {
        JFrame ventanaIngresar = new JFrame("Ingresar Producto");
        ventanaIngresar.setSize(400, 500);
        ventanaIngresar.setResizable(false);
        ventanaIngresar.setLayout(null);

        JTextField codigoField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField precioField = new JTextField();
        JTextField cantidadField = new JTextField();
        JTextField fechaField = new JTextField();

        ventanaIngresar.add(crearLabel("Código de producto:", 50, 50));
        ventanaIngresar.add(codigoField);
        ventanaIngresar.add(crearLabel("Nombre del producto:", 50, 100));
        ventanaIngresar.add(nombreField);
        ventanaIngresar.add(crearLabel("Precio:", 50, 150));
        ventanaIngresar.add(precioField);
        ventanaIngresar.add(crearLabel("Cantidad:", 50, 200));
        ventanaIngresar.add(cantidadField);
        ventanaIngresar.add(crearLabel("Fecha de vencimiento:", 50, 250));
        ventanaIngresar.add(fechaField);

        codigoField.setBounds(200, 50, 150, 30);
        nombreField.setBounds(200, 100, 150, 30);
        precioField.setBounds(200, 150, 150, 30);
        cantidadField.setBounds(200, 200, 150, 30);
        fechaField.setBounds(200, 250, 150, 30);

        JButton ingresarProductoButton = new JButton("Ingresar");
        ingresarProductoButton.setBounds(50, 400, 100, 30);
        ingresarProductoButton.addActionListener(e -> {
            Producto producto = new Producto(
                Integer.parseInt(codigoField.getText()),
                nombreField.getText(),
                Double.parseDouble(precioField.getText()),
                Integer.parseInt(cantidadField.getText()),
                fechaField.getText()
            );
            productos.add(producto);
            JOptionPane.showMessageDialog(ventanaIngresar, "Producto ingresado correctamente.");
            codigoField.setText("");
            nombreField.setText("");
            precioField.setText("");
            cantidadField.setText("");
            fechaField.setText("");
        });
        ventanaIngresar.add(ingresarProductoButton);

        ventanaIngresar.add(crearBotonVolver(ventanaIngresar));
        ventanaIngresar.setVisible(true);
    }

    private void abrirVentanaConsulta() {
        JFrame consultaVentana = crearVentanaBase("Consultar Productos");
        JTextArea areaProductos = new JTextArea();
        areaProductos.setBounds(20, 50, 350, 300);
        areaProductos.setEditable(false);

        StringBuilder productosTexto = new StringBuilder();
        for (Producto producto : productos) {
            productosTexto.append(producto.toString()).append("\n");
        }
        areaProductos.setText(productosTexto.toString());
        consultaVentana.add(areaProductos);

        consultaVentana.add(crearBotonVolver(consultaVentana));
        consultaVentana.setVisible(true);
    }

    private void abrirVentanaActualizar() {
        JFrame actualizarVentana = crearVentanaBase("Actualizar Producto");

        JTextField codigoField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField precioField = new JTextField();
        JTextField cantidadField = new JTextField();
        JTextField fechaField = new JTextField();

        actualizarVentana.add(crearLabel("Código de producto:", 50, 50));
        actualizarVentana.add(codigoField);
        actualizarVentana.add(crearLabel("Nombre del producto:", 50, 100));
        actualizarVentana.add(nombreField);
        actualizarVentana.add(crearLabel("Precio:", 50, 150));
        actualizarVentana.add(precioField);
        actualizarVentana.add(crearLabel("Cantidad:", 50, 200));
        actualizarVentana.add(cantidadField);
        actualizarVentana.add(crearLabel("Fecha de vencimiento:", 50, 250));
        actualizarVentana.add(fechaField);

        codigoField.setBounds(200, 50, 150, 30);
        nombreField.setBounds(200, 100, 150, 30);
        precioField.setBounds(200, 150, 150, 30);
        cantidadField.setBounds(200, 200, 150, 30);
        fechaField.setBounds(200, 250, 150, 30);

        JButton actualizarProductoButton = new JButton("Actualizar");
        actualizarProductoButton.setBounds(50, 400, 100, 30);
        actualizarProductoButton.addActionListener(e -> {
            int codigo = Integer.parseInt(codigoField.getText());
            for (Producto producto : productos) {
                if (producto.getCodigo() == codigo) {
                    producto.setNombre(nombreField.getText());
                    producto.setPrecio(Double.parseDouble(precioField.getText()));
                    producto.setCantidad(Integer.parseInt(cantidadField.getText()));
                    producto.setFechaVencimiento(fechaField.getText());
                    JOptionPane.showMessageDialog(actualizarVentana, "Producto actualizado correctamente.");
            codigoField.setText("");
            nombreField.setText("");
            precioField.setText("");
            cantidadField.setText("");
            fechaField.setText("");
                    return;
                }
            }
            JOptionPane.showMessageDialog(actualizarVentana, "Producto no encontrado.");
        });
        actualizarVentana.add(actualizarProductoButton);

        actualizarVentana.add(crearBotonVolver(actualizarVentana));
        actualizarVentana.setVisible(true);
    }

    private void abrirVentanaEliminar() {
        JFrame eliminarVentana = crearVentanaBase("Eliminar Producto");
        JTextField codigoField = new JTextField();
        eliminarVentana.add(crearLabel("Ingrese el código del producto a eliminar:", 50, 100));
        eliminarVentana.add(codigoField);

        codigoField.setBounds(200, 150, 150, 30);

        JButton aceptarButton = new JButton("Eliminar");
        aceptarButton.setBounds(50, 400, 100, 30);
        aceptarButton.addActionListener(e -> {
            int codigo = Integer.parseInt(codigoField.getText());
            productos.removeIf(producto -> producto.getCodigo() == codigo);
            JOptionPane.showMessageDialog(eliminarVentana, "Producto eliminado correctamente.");
            codigoField.setText("");
        });
        eliminarVentana.add(aceptarButton);

        eliminarVentana.add(crearBotonVolver(eliminarVentana));
        eliminarVentana.setVisible(true);
    }

    private void abrirVentanaBuscarCodigo() {
        JFrame buscarCodigoVentana = crearVentanaBase("Buscar Producto por Código");
        JTextField codigoField = new JTextField();
        JTextArea resultadoArea = new JTextArea();
        buscarCodigoVentana.add(crearLabel("Ingrese el código del producto:", 50, 100));
        buscarCodigoVentana.add(codigoField);
        buscarCodigoVentana.add(resultadoArea);

        codigoField.setBounds(200, 150, 150, 30);
        resultadoArea.setBounds(50, 200, 300, 200);
        resultadoArea.setEditable(false);

        JButton aceptarButton = new JButton("Buscar");
        aceptarButton.setBounds(50, 400, 100, 30);
        aceptarButton.addActionListener(e -> {
            int codigo = Integer.parseInt(codigoField.getText());
            for (Producto producto : productos) {
                if (producto.getCodigo() == codigo) {
                    resultadoArea.setText(producto.toString());
                    return;
                }
            }
            resultadoArea.setText("Producto no encontrado.");
        });
        buscarCodigoVentana.add(aceptarButton);

        buscarCodigoVentana.add(crearBotonVolver(buscarCodigoVentana));
        buscarCodigoVentana.setVisible(true);
    }

    private void abrirVentanaBuscarNombre() {
        JFrame buscarNombreVentana = crearVentanaBase("Buscar Producto por Nombre");
        JTextField nombreField = new JTextField();
        JTextArea resultadoArea = new JTextArea();
        buscarNombreVentana.add(crearLabel("Ingrese el nombre del producto:", 50, 100));
        buscarNombreVentana.add(nombreField);
        buscarNombreVentana.add(resultadoArea);

        nombreField.setBounds(200, 150, 150, 30);
        resultadoArea.setBounds(50, 200, 300, 200);
        resultadoArea.setEditable(false);

        JButton aceptarButton = new JButton("Buscar");
        aceptarButton.setBounds(50, 400, 100, 30);
        aceptarButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            for (Producto producto : productos) {
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    resultadoArea.setText(producto.toString());
                    
                  return;
                }
            }
            resultadoArea.setText("Producto no encontrado.");
        });
        buscarNombreVentana.add(aceptarButton);

        buscarNombreVentana.add(crearBotonVolver(buscarNombreVentana));
        buscarNombreVentana.setVisible(true);
    }

    private JLabel crearLabel(String texto, int x, int y) {
        JLabel label = new JLabel(texto);
        label.setBounds(x, y, 200, 30);
        return label;
    }

    private JFrame crearVentanaBase(String titulo) {
        JFrame ventana = new JFrame(titulo);
        ventana.setSize(400, 500);
        ventana.setLayout(null);
        ventana.setResizable(false);
        return ventana;
    }

    private JButton crearBotonVolver(JFrame ventana) {
        JButton volverButton = new JButton("Volver");
        volverButton.setBounds(250, 400, 100, 30);
        volverButton.addActionListener(e -> ventana.dispose());
        return volverButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ingresarButton) {
            abrirVentanaIngresar();
        } else if (e.getSource() == consultarButton) {
            abrirVentanaConsulta();
        } else if (e.getSource() == actualizarButton) {
            abrirVentanaActualizar();
        } else if (e.getSource() == eliminarButton) {
            abrirVentanaEliminar();
        } else if (e.getSource() == buscarCodigoButton) {
            abrirVentanaBuscarCodigo();
        } else if (e.getSource() == buscarNombreButton) {
            abrirVentanaBuscarNombre();
        }
    }
  
    

    public static void main(String[] args) {
        new Crud();
    }
}
class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private String fechaVencimiento;

    public Producto(int codigo, String nombre, double precio, int cantidad, String fechaVencimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio +
               ", Cantidad: " + cantidad + ", Fecha de Vencimiento: " + fechaVencimiento;
    }
}


