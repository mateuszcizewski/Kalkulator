/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author Mateusz Ciżewski
 */

public class Mavenproject1 {
    
    static int currentOutput = 0;
    static JTextField displayField = new JTextField();
    static String currentValue;
    static String firstNumber = " ";
    static String secondNumber = " ";
    static String operation;
    static int result;
    
    
    private static void addButton(String value, int x, int y, JFrame frame, GridBagConstraints gbc){
        JButton button=new JButton(value);
        gbc.gridy = y;
        gbc.gridx = x;
        frame.add(button, gbc);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                switch(value){
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                    case "0":    
                        currentValue = displayField.getText();
                            if(currentValue.equals("0") || currentValue.equals(" "))
                                {
                                    displayField.setText(value);
                                }
                                else
                                {
                                    currentValue = currentValue + value;
                                    displayField.setText(currentValue);  
                                }
                        break;
                    
                    case "-":
                        if(firstNumber.equals(" "))
                        {
                           firstNumber = displayField.getText();
                           currentValue = " ";
                           displayField.setText(currentValue); 
                           operation = "sub";
                        }else if(!firstNumber.equals(" ") && secondNumber.equals(" "))
                        {
                            //double sub?? Do i just force result and sub again??
                            
                            
                        }
                        
                        break;
                        
                    case "+":
                        if(firstNumber.equals(" "))
                        {
                           firstNumber = displayField.getText();
                           currentValue = " ";
                           displayField.setText(currentValue); 
                           operation = "add";
                        }
                        
                        break;
                        
                    case "/":
                        if(firstNumber.equals(" "))
                        {
                           firstNumber = displayField.getText();
                           currentValue = " ";
                           displayField.setText(currentValue); 
                           operation = "div";
                        }
                        
                        break;
                        
                    case "*":
                        if(firstNumber.equals(" "))
                        {
                           firstNumber = displayField.getText();
                           currentValue = " ";
                           displayField.setText(currentValue); 
                           operation = "mul";
                        }
                        
                        break;
                        
                    case "C":
                        currentValue = "0";
                        displayField.setText(currentValue); 
                        firstNumber = " ";
                        secondNumber = " ";
                        break;
                        
                    case "=":
                        secondNumber = displayField.getText();
                        if( !firstNumber.equals(" ") && !secondNumber.equals(" ") )
                        {
                            switch(operation){
                                case "sub":
                                    result = Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber);
                                    displayField.setText(String.valueOf(result));
                                    firstNumber = " ";
                                    secondNumber = " ";
                                    break;
                                case "add":
                                    result = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
                                    displayField.setText(String.valueOf(result));
                                    firstNumber = " ";
                                    secondNumber = " ";
                                    break;
                                case "div":
                                    result = Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber);
                                    displayField.setText(String.valueOf(result));
                                    firstNumber = " ";
                                    secondNumber = " ";
                                    break;
                                case "mul":
                                    result = Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
                                    displayField.setText(String.valueOf(result));
                                    firstNumber = " ";
                                    secondNumber = " ";
                                    break;
                            }
                        }
                        
                        
                        
                        break;
                }
                
                
                
                
                
            }
        });
    }
    

   
    
    private static void createAndShowGUI() {
        // Tutaj tworzymy i wyświetlamy interfejs użytkownika
        //podstawa okna
        JFrame frame = new JFrame("Kalkulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=0;
        gbc.gridy =0;
        gbc.weightx=1.0;
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridwidth = 4;
        displayField.setEditable(false);
        displayField.setText(String.valueOf(currentOutput));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(displayField, gbc);
        
        
        gbc.gridwidth=1;
        addButton("7", 0, 1, frame, gbc);
        addButton("8", 1, 1, frame, gbc);
        addButton("9", 2, 1, frame, gbc);
        addButton("C", 3, 1, frame, gbc);
        addButton("4", 0, 2, frame, gbc);
        addButton("5", 1, 2, frame, gbc);
        addButton("6", 2, 2, frame, gbc);
        addButton("+", 3, 2, frame, gbc);
        addButton("1", 0, 3, frame, gbc);
        addButton("2", 1, 3, frame, gbc);
        addButton("3", 2, 3, frame, gbc);
        addButton("-", 3, 3, frame, gbc);
        addButton("0", 0, 4, frame, gbc);
        addButton("/", 1, 4, frame, gbc);
        addButton("*", 2, 4, frame, gbc);
        addButton("=", 3, 4, frame, gbc);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
}
