package clases;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Interfaz extends Canvas{
	
	private JFrame ventana;
	private JDesktopPane contentPane;
	private JButton btnStart;
	private JButton btnFin;
	private JLabel cajera1;
	private JLabel cajera2;
	private JLabel cajera3;
	
	public Interfaz(){
		initComp();
		initFrame();
		setComp();
		gestionEventos();
	}
	
	public void initFrame(){
		ventana = new JFrame("Simulador de Banco");
		ventana.setSize(800, 600);
		ventana.setContentPane(contentPane);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setVisible(true);
	}
	
	public void initComp(){
		contentPane = new JDesktopPane();
		btnStart = new JButton("Inicio");
		btnFin = new JButton("Finalizar");
		cajera1 = new JLabel();
		cajera2 = new JLabel();
		cajera3 = new JLabel();
	}
	
	public void setComp(){
		btnStart.setBounds(50, 500, 100, 50);
		btnFin.setBounds(650, 500, 100, 50);
		cajera1.setBounds(50, 50, 120, 120);
		cajera2.setBounds(200, 50, 120, 120);
		cajera3.setBounds(350, 50, 120, 120);
		
		cajera1.setIcon(new ImageIcon(Interfaz.class.getResource("/recursos/cajera1.png")));
		cajera2.setIcon(new ImageIcon(Interfaz.class.getResource("/recursos/cajera2.png")));
		cajera3.setIcon(new ImageIcon(Interfaz.class.getResource("/recursos/cajera3.png")));
		contentPane.add(btnFin);
		contentPane.add(btnStart);
		contentPane.add(cajera1);
		contentPane.add(cajera2);
		contentPane.add(cajera3);
	}
	
	public void gestionEventos(){
		btnFin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);				
			}
			
		});
	}
	
	public static void main(String args[]){
		new Interfaz();
	}
}
