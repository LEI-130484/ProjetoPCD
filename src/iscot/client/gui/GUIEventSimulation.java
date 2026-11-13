package iscot.client.gui;

import iscot.enums.Areas;
import iscot.enums.AirConditioningMode;
import iscot.events.HighLevelOrderEvents.AreaLightingOrderEvent;
import iscot.events.HighLevelOrderEvents.AreaIrrigationOrderEvent;
import iscot.events.HighLevelOrderEvents.AreaVentilationOrderEvent;
import iscot.events.HighLevelOrderEvents.AreaTemperatureOrderEvent;
import iscot.events.SensorEvents.TemperatureSensorEvent;
import iscot.events.SensorEvents.HumiditySensorEvent;
import iscot.events.SensorEvents.GroundMoistureSensorEvent;
import iscot.events.SensorEvents.LightSensorEvent;

import javax.swing.*;
import java.awt.*;

public class GUIEventSimulation extends JFrame {

    private final LightIcon luzIcon;
    private final ACIcon acIcon;
    private final VentilatorIcon ventiladorIcon;
    private final IrrigationIcon regaIcon;

    public GUIEventSimulation() {
        setTitle("IscoT - Simulação GUI Alargada (Fases 1 a 3)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 4, 15, 15));

        // ==========================================
        // 1. SENSORES (Painéis de Controlo)
        // ==========================================

        // Sensor de Temperatura
        SensorControl sensorTemp = new SensorControl(
                "🌡️", "Sensor Temperatura", "ºC",
                16.0, 30.0, 0.5, 23.0,
                valor -> {
                    TemperatureSensorEvent evento = new TemperatureSensorEvent(Areas.Kitchen, 1, valor);
                    System.out.println("[GUI -> SENSOR EVENT] " + evento);
                }
        );

        // Sensor de Humidade do Ar
        SensorControl sensorHumidadeAr = new SensorControl(
                "💧", "Sensor Humidade Ar", "%",
                0.0, 100.0, 1.0, 50.0,
                valor -> {
                    HumiditySensorEvent evento = new HumiditySensorEvent(Areas.WC, 2, valor);
                    System.out.println("[GUI -> SENSOR EVENT] " + evento);
                }
        );

        // Sensor de Humidade do Solo
        SensorControl sensorSolo = new SensorControl(
                "🌱", "Sensor Humidade Solo", "%",
                0.0, 100.0, 1.0, 30.0,
                    valor -> {
                        GroundMoistureSensorEvent evento = new GroundMoistureSensorEvent(Areas.Garden, 3, valor < 30.0);
                    System.out.println("[GUI -> SENSOR EVENT] " + evento);
                }
        );

        // Sensor de Luz
        SensorControl sensorLuz = new SensorControl(
                "☀️", "Sensor de Luz", "lx",
                0.0, 100.0, 10.0, 20.0,
                valor -> {
                    LightSensorEvent evento = new LightSensorEvent(Areas.LivingRoom, 4, valor);
                    System.out.println("[GUI -> SENSOR EVENT] " + evento);
                }
        );

        // ==========================================
        // 2. ATUADORES (Componentes Visuais + Botões de Simulação)
        // ==========================================

        // A) Atuador de Iluminação (LightIcon)
        luzIcon = new LightIcon();
        JButton btnLuz = new JButton("Ligar/Desligar Luz");
        btnLuz.addActionListener(e -> {
            boolean novoEstado = !luzIcon.isLigada();
            AreaLightingOrderEvent ordem = new AreaLightingOrderEvent(Areas.Kitchen, 101, novoEstado);
            luzIcon.setLigada(novoEstado);
            System.out.println("[GUI -> ACTUATOR ORDER] " + ordem);
            System.out.println("[HISTÓRICO ATUADOR] Luz " + (novoEstado ? "LIGADA" : "DESLIGADA"));
        });
        JPanel painelLuz = criarPainelAtuador("💡 Iluminação", luzIcon, btnLuz);

        // B) Atuador de Ar Condicionado (ACIcon)
        acIcon = new ACIcon();
        JButton btnAC = new JButton("Ligar/Desligar AC");
        btnAC.addActionListener(e -> {
            AirConditioningMode novoModo = (acIcon.getModo() == AirConditioningMode.Desligado)
                    ? AirConditioningMode.Frio
                    : AirConditioningMode.Desligado;

            acIcon.setModo(novoModo);
            acIcon.setTemperatura(23.5);
            AreaTemperatureOrderEvent ordem = new AreaTemperatureOrderEvent(Areas.LivingRoom, 102, 23.5);

            System.out.println("[GUI -> ACTUATOR ORDER] AC Modo: " + novoModo);
            System.out.println("[HISTÓRICO ATUADOR] Ar Condicionado " + novoModo);
        });
        JPanel painelAC = criarPainelAtuador("❄️ Ar Condicionado", acIcon, btnAC);

        // C) Atuador de Ventilação (VentilatorIcon)
        ventiladorIcon = new VentilatorIcon();
        JButton btnVentilador = new JButton("Ligar/Desligar Ventilador");
        btnVentilador.addActionListener(e -> {
            boolean novoEstado = !ventiladorIcon.isLigado();
            ventiladorIcon.setLigado(novoEstado);
            AreaVentilationOrderEvent ordem = new AreaVentilationOrderEvent(Areas.WC, 103, novoEstado);

            System.out.println("[GUI -> ACTUATOR ORDER] " + ordem);
            System.out.println("[HISTÓRICO ATUADOR] Ventilador " + (novoEstado ? "LIGADO" : "DESLIGADO"));
        });
        JPanel painelVentilador = criarPainelAtuador("🌀 Ventilação", ventiladorIcon, btnVentilador);

        // D) Atuador de Rega (IrrigationIcon)
        regaIcon = new IrrigationIcon();
        JButton btnRega = new JButton("Ligar/Desligar Rega");
        btnRega.addActionListener(e -> {
            boolean novoEstado = !regaIcon.isAtiva();
            regaIcon.setAtiva(novoEstado);
            regaIcon.setZona(1);
            regaIcon.setDuracao(15);
            AreaIrrigationOrderEvent ordem = new AreaIrrigationOrderEvent(Areas.Garden, 104, novoEstado);

            System.out.println("[GUI -> ACTUATOR ORDER] " + ordem);
            System.out.println("[HISTÓRICO ATUADOR] Rega " + (novoEstado ? "LIGADA" : "DESLIGADA"));
        });
        JPanel painelRega = criarPainelAtuador("🌿 Rega", regaIcon, btnRega);

        // Adicionar todos os painéis à janela principal
        add(sensorTemp);
        add(sensorHumidadeAr);
        add(sensorSolo);
        add(sensorLuz);

        add(painelLuz);
        add(painelAC);
        add(painelVentilador);
        add(painelRega);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel criarPainelAtuador(String titulo, JComponent icone, JButton botao) {
        JPanel painel = new JPanel(new BorderLayout(5, 5));
        painel.setBorder(BorderFactory.createTitledBorder(titulo));
        painel.add(icone, BorderLayout.CENTER);
        painel.add(botao, BorderLayout.SOUTH);
        return painel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUIEventSimulation().setVisible(true);
        });
    }
}