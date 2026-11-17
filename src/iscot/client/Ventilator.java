package iscot.client;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.VentilatorIcon;
import iscot.enums.Areas;
import iscot.events.HighLevelOrderEvents.AreaVentilationOrderEvent;

public class Ventilator extends Atuador{

	public Ventilator(Areas area) {
		super(area);
	}

	/**
	 * 
	 * @param server address and port
	 * @param roomName: string
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws NumberFormatException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws NumberFormatException, UnknownHostException, IOException, InterruptedException, ClassNotFoundException {
		if(args.length!=3) {
			System.err.println("Invalid arguments!");
		}
		else {
			Ventilator ventilator = new Ventilator(Areas.valueOf(args[2]));
			// TODO connect to server
			ventilator.connectToServer();

			
			// TODO register with the server
			
			JFrame janela = new JFrame("Ventilador em "+ ventilator.getArea());
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
			
			// Criar os componentes gráficos
			JPanel painel=new JPanel();
			painel.setLayout(new BorderLayout());
			VentilatorIcon ventilatorIcon = new VentilatorIcon();
			painel.add(ventilatorIcon,BorderLayout.CENTER);
			janela.setContentPane(painel);
			janela.setLocation(600, 400);
			janela.setMinimumSize(janela.getSize());
			janela.pack();
			janela.setVisible(true);
			
			Thread.sleep(5000);
			ventilatorIcon.setAtivo(true);

			// TODO: receive and handle messages from server
			AreaVentilationOrderEvent event = (AreaVentilationOrderEvent) ventilator.getEventFromServer();

			ventilatorIcon.setLigado(event.getStartVentilation());
			
		}
	}
}
