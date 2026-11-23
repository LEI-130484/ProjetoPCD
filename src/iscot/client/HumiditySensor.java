package iscot.client;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.SensorEvents.HumiditySensorEvent;

public class HumiditySensor extends Sensor{

	public HumiditySensor(Areas area) {
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
	 */
	public static void main(String[] args) throws NumberFormatException, InterruptedException, IOException {
		if(args.length!=3) {
			System.err.println("Invalid arguments!");
		}
		else {
			HumiditySensor sensor = new HumiditySensor(Areas.valueOf(args[2]));

			// TODO connect to the server
			sensor.connectToServer();

			// TODO register with the server
			//sensor.registerWithServer();
			

			JFrame janela = new JFrame("Humidade em "+ sensor.getArea());
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			
			// Criar os componentes gráficos
			JPanel painel=new JPanel();
			painel.setLayout(new BorderLayout());
			SensorControl sensorControl= new SensorControl( "☀", "Humidade - "+sensor.getArea(), "%",
				    0, 100, 1, 50,
				    valor -> {
				    	System.out.println("Mudou para: "+valor);
						try {
							sensor.sendEvent(new HumiditySensorEvent(sensor.getArea(), 0, valor));
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
				    });
			painel.add(sensorControl,BorderLayout.CENTER);
			janela.setContentPane(painel);
			janela.setLocation(600, 400);
			janela.setMinimumSize(janela.getSize());
			janela.pack();
			janela.setVisible(true);
			
		}
	}

}
