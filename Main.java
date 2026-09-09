package paq;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Main {

	static Scanner scInt = new Scanner(System.in);
	static Producto productos[] = new Producto[10];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		productos[0] = new Producto("Lejía", 2.5);
		productos[1] = new Producto("Chocolate", 1.25);
		productos[2] = new Producto("Brick de leche", 0.90);
		productos[3] = new Producto("Macarrones", 1.5);
		productos[4] = new Producto("Jamón", 5.75);
		productos[5] = new Producto("Pulpo", 10.5);
		productos[6] = new Producto("Mantequilla", 1.00);
		productos[7] = new Producto("Lomo", 3.5);
		productos[8] = new Producto("Natillas", 2.25);
		productos[9] = new Producto("Caviar", 32.5);

		JFrame frame = new JFrame("Supermercado");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 190);
		frame.setLocationRelativeTo(null);

		JRadioButton botones[] = new JRadioButton[productos.length];
		ButtonGroup grupo = new ButtonGroup();
		JPanel panel = new JPanel(new FlowLayout());

		for (int i = 0; i < botones.length; i++) {

			botones[i] = new JRadioButton(productos[i].getNombre() + " (" + productos[i].getPrecio() + "€)");

			grupo.add(botones[i]);
			panel.add(botones[i]);

		}

		JFrame f2 = new JFrame("Pedidos");

		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setSize(500, 190);
		f2.setLocation(600, 100);

		JLabel pedidos[] = new JLabel[productos.length];
		JPanel panel2 = new JPanel();

		for (int i = 0; i < productos.length; i++) {
			pedidos[i] = new JLabel(productos[i].getNombre() + ": 0");
			panel2.add(pedidos[i]);
		}

		JLabel total = new JLabel("Precio total: ");
		panel2.add(total);

		JLabel cant = new JLabel("Cantidad ");
		JTextField cantidad = new JTextField(5);
		panel.add(cant);
		panel.add(cantidad);

		JButton comprar = new JButton("Comprar");
		JButton devolver = new JButton("Devolver");

		panel.add(comprar);
		panel.add(devolver);

		comprar.addActionListener(e -> {
			int pulsado = -1;
			for (int i = 0; i < productos.length; i++) {
				if (botones[i].isSelected())
					pulsado = i;
			}

			int cantidadActual = productos[pulsado].getCantidad();
			int cantidadASumar = Integer.valueOf(cantidad.getText());

			int cantidadFinal = cantidadActual + cantidadASumar;

			productos[pulsado].setCantidad(cantidadFinal);

			pedidos[pulsado].setText(productos[pulsado].getNombre() + ": " + cantidadFinal);

			double sumaTotal = 0;
			for (int i = 0; i < productos.length; i++) {
				sumaTotal += productos[i].getCantidad() * productos[i].getPrecio();
			}

			total.setText("Precio Total: " + sumaTotal);

		});

		devolver.addActionListener(e -> {

			int pulsado = -1;
			for (int i = 0; i < productos.length; i++) {
				if (botones[i].isSelected()) {
					pulsado = i;
				}
			}

			if (pulsado == -1)
				return;

			int cantidadActual = productos[pulsado].getCantidad();
			int cantidadDevolver = Integer.valueOf(cantidad.getText());

			if (cantidadDevolver > cantidadActual) {
				JOptionPane.showMessageDialog(frame,
						"No es posible devolver " + cantidadDevolver + " unidades, solo quedan " + cantidadActual,
						"Ventana", JOptionPane.PLAIN_MESSAGE);
				return;
			}

			int cantidadFinal = cantidadActual - cantidadDevolver;
			productos[pulsado].setCantidad(cantidadFinal);

			pedidos[pulsado].setText(productos[pulsado].getNombre() + ": " + cantidadFinal);

			double sumaTotal = 0;
			for (int i = 0; i < productos.length; i++) {
				sumaTotal += productos[i].getCantidad() * productos[i].getPrecio();
			}

			total.setText("Precio Total: " + sumaTotal);

		});

		frame.setContentPane(panel);
		f2.setContentPane(panel2);
		frame.setVisible(true);
		f2.setVisible(true);

	}

}
