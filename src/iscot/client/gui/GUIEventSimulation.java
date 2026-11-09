package iscot.client.gui;

import iscot.enums.Areas;
import iscot.events.HighLevelOrderEvents.AreaLightingOrderEvent;
import iscot.events.SensorEvents.TemperatureSensorEvent;

import javax.swing.*;
import java.awt.*;

public class GUIEventSimulation extends JFrame {

    private final LightIcon luzIcon;

    public GUIEventSimulation() {
        setTitle("IscoT - Simulação GUI (Fase 3)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // 1. Instanciar o controlo do Sensor de Temperatura (GUI)
        // O lambda (atualizador) executa quando o utilizador larga o slider
        SensorControl sensorTemp = new SensorControl(
                "🌡️",
                "Sensor Temperatura",
                "ºC",
                10.0,   // Min
                40.0,   // Max
                0.5,    // Passo
                22.0,   // Valor Inicial
                valor -> {
                    // Instanciar o evento criado na Fase 2
                    TemperatureSensorEvent evento = new TemperatureSensorEvent(
                            Areas.LivingRoom,
                            1,
                            valor
                    );

                    // Imprimir na consola como pedido no guião (Fase 3)
                    System.out.println("[GUI -> SENSOR EVENT] " + evento);
                }
        );

        // 2. Instanciar o componente visual do Atuador (Luz)
        luzIcon = new LightIcon();

        // Botão para simular a chegada de uma Ordem de Alto Nível ao Atuador
        JButton btnSimularOrdemLuz = new JButton("Interruptor");
        btnSimularOrdemLuz.addActionListener(e -> {
            // Simula a receção de um HighLevelOrderEvent
            AreaLightingOrderEvent ordem = new AreaLightingOrderEvent(
                    Areas.LivingRoom,
                    101,
                    !luzIcon.isLigada() // Alterna o estado
            );

            // Atualiza o componente gráfico do Atuador
            luzIcon.setLigada(ordem.isTurnOn());

            // Imprime na consola a confirmação da ação
            System.out.println("[GUI -> ACTUATOR ORDER] " + ordem);
            System.out.println("[HISTÓRICO ATUADOR] Luz " + (luzIcon.isLigada() ? "DESLIGADA" : "LIGADA"));
        });

        // Painel para o Atuador
        JPanel painelAtuador = new JPanel(new BorderLayout(5, 5));
        painelAtuador.setBorder(BorderFactory.createTitledBorder("💡 Atuador de Iluminação"));
        painelAtuador.add(luzIcon, BorderLayout.CENTER);
        painelAtuador.add(btnSimularOrdemLuz, BorderLayout.SOUTH);

        // Adicionar à janela
        add(sensorTemp);
        add(painelAtuador);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUIEventSimulation().setVisible(true);
        });
    }
}