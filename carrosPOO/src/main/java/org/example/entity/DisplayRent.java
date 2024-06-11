package org.example.entity;

import org.example.dao.RentDAO;
import org.example.model.RentACar;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DisplayRent extends JFrame{

    public DisplayRent() {
        setTitle("Aluguel de Carros");
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        RentDAO rd = new RentDAO();
        List<RentACar> rentCar = rd.getRent();

        String[] columnNames = {"Nome do Carro", "Data de Início", "Data de Devolução", "Valor", "Cor", "Placa"};
        Object[][] data = new Object[rentCar.size()][6];

        for (int i = 0; i < rentCar.size(); i++) {
            RentACar car = rentCar.get(i);
            data[i][0] = car.getNomeCar();
            data[i][1] = car.getDataIni();
            data[i][2] = car.getDevolucao();
            data[i][3] = car.getValor();
            data[i][4] = car.getCor();
            data[i][5] = car.getPlaca();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
