package View;


import Controller.Controller;
import jakarta.persistence.PersistenceException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gvillaag
 */
public class DeleteBookView extends JFrame {
    BookServiceView prev;
    Controller controller;

    /**
     * Creates new form BasicAbstractUI
     */
    public DeleteBookView(BookServiceView prev, Controller controller) {
        initComponents();
        this.prev = prev;
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        backButton = new JButton();
        deleteButton = new JButton();
        jLabel2 = new JLabel();
        jTextField2 = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        backButton.setText("<----");
        backButton.setToolTipText("");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.setActionCommand("jButton7");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("id");

        jTextField2.setText("");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(backButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 256, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2)
                                        .addComponent(deleteButton, GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                                        .addComponent(jTextField2))
                                .addGap(250, 250, 250))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(backButton)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 447, Short.MAX_VALUE)
                                .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>

    private void backButtonActionPerformed(ActionEvent e){
        this.jTextField2.setText("");
        this.prev.setVisible(true);
        this.setVisible(false);
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        long id = Long.parseLong(jTextField2.getText());
        try{
            controller.deletebook(id);
        }catch(PersistenceException e) {
            JOptionPane.showMessageDialog(this,
                    "Try deleting all the dependencies of this row first",
                    "Couldn't delete",
                    JOptionPane.ERROR_MESSAGE);
        }
        this.prev.setVisible(true);
        this.setVisible(false);
    }



    // Variables declaration - do not modify
    private JButton backButton;
    private JButton deleteButton;
    private JLabel jLabel2;
    private JTextField jTextField2;
    // End of variables declaration
}

