/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import com.mysql.cj.protocol.Resultset;
import database.Mysql_database;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
//import java.awt.event.ActionEvent;
//import java.awt.event.ItemEvent;
//import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.imageio.ImageIO;
//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableColumn;
import scraper.Imdb_ator;
//import scraper.Scraper;

/**
 *
 * @author alex
 */
public class Frm_gerencia extends javax.swing.JFrame {

    private int i = 0;
    private Frm_main form;
    private int op;

    /**
     * Creates new form scraper_form
     */
    public Frm_gerencia(Frm_main frm) {
        form = frm;
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_grp_criterio = new javax.swing.ButtonGroup();
        pnl_pesquisa = new javax.swing.JPanel();
        btn_atores = new javax.swing.JButton();
        btn_filmes = new javax.swing.JButton();
        lbl_filtro = new javax.swing.JLabel();
        txt_filtro = new javax.swing.JTextField();
        btn_filtrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_resultado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_pesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa Banco de Dados"));
        pnl_pesquisa.setToolTipText("Search");
        pnl_pesquisa.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        btn_atores.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_atores.setText("Atores");
        btn_atores.setMaximumSize(new java.awt.Dimension(80, 35));
        btn_atores.setMinimumSize(new java.awt.Dimension(80, 35));
        btn_atores.setPreferredSize(new java.awt.Dimension(80, 35));
        btn_atores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atoresActionPerformed(evt);
            }
        });

        btn_filmes.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_filmes.setText("Filmes");
        btn_filmes.setMaximumSize(new java.awt.Dimension(80, 35));
        btn_filmes.setMinimumSize(new java.awt.Dimension(80, 35));
        btn_filmes.setPreferredSize(new java.awt.Dimension(80, 35));
        btn_filmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filmesActionPerformed(evt);
            }
        });

        lbl_filtro.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lbl_filtro.setText("Filtro:");

        txt_filtro.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_filtroKeyPressed(evt);
            }
        });

        btn_filtrar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btn_filtrar.setText("Filtrar");
        btn_filtrar.setMaximumSize(new java.awt.Dimension(80, 35));
        btn_filtrar.setMinimumSize(new java.awt.Dimension(80, 35));
        btn_filtrar.setPreferredSize(new java.awt.Dimension(80, 35));
        btn_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_pesquisaLayout = new javax.swing.GroupLayout(pnl_pesquisa);
        pnl_pesquisa.setLayout(pnl_pesquisaLayout);
        pnl_pesquisaLayout.setHorizontalGroup(
            pnl_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_pesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_atores, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_filmes, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_filtro)
                .addGap(18, 18, 18)
                .addComponent(txt_filtro)
                .addGap(18, 18, 18)
                .addComponent(btn_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_pesquisaLayout.setVerticalGroup(
            pnl_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_pesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_pesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_atores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_filmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_filtro)
                    .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_resultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_resultado.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_resultado.setRowHeight(50);
        tbl_resultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_resultadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_resultado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                    .addComponent(pnl_pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void set_cursor(int opt) {
        Cursor waitCursor = new Cursor(Cursor.WAIT_CURSOR);
        Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
        if (opt == 1) {
            setCursor(waitCursor);
        } else {
            setCursor(normalCursor);
        }
    }

    private void limpa_tabela(JTable tbl) {
        //model jtable
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        // atualizar tabela
        tbl.validate();
    }

    private void preenche_tabela(JTable tbl, ResultSet rs, String[] columns) {
        // tamanho do objeto
        int size = 0;
        if (rs != null) {
            try {
                rs.last();
                size = rs.getRow();
                rs.beforeFirst();
            } catch (SQLException ex) {
                Logger.getLogger(Frm_gerencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Object[][] rows = new Object[size][3];

        //put data in rows
        i = 0;
        try {
            while (rs.next()) {
                rows[i] = (new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Frm_gerencia.class.getName()).log(Level.SEVERE, null, ex);
        };

        // impedir edição da tabela
        DefaultTableModel model = new DefaultTableModel(rows, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        tbl.setModel(model);
//        tbl.getColumnModel().getColumn(0).setMaxWidth(40);
//        tbl.getColumnModel().getColumn(1).setWidth(100);
//        tbl.getColumnModel().getColumn(2).setPreferredWidth(400);
        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tbl.validate();
    }

//    private void nomeia_colunas_tabela(JTable tbl, Object[] nomes) {
//        //model jtable
//        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
//        model.setColumnIdentifiers(nomes);
//        // atualizar tabela
//        tbl.validate();
//    }

    /**/
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        form.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btn_atoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atoresActionPerformed
        btn_filmes.setForeground(Color.white);
        btn_atores.setForeground(Color.green);
        txt_filtro.setBackground(Color.darkGray);
        txt_filtro.setForeground(Color.white);
        txt_filtro.setText("");
        op = 1;

        limpa_tabela(tbl_resultado);
        Mysql_database db = new Mysql_database();
        String query = "SELECT name, description, born_info, imdb_uri FROM actors ORDER BY name";
        String[] columns = {"NOME", "DESCRIÇÃO", "NASCIMENTO", "IMDB"};
        preenche_tabela(tbl_resultado, db.search_sql(query), columns);
    }//GEN-LAST:event_btn_atoresActionPerformed

    private void btn_filmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filmesActionPerformed
        btn_atores.setForeground(Color.white);
        btn_filmes.setForeground(Color.green);
        txt_filtro.setBackground(Color.darkGray);
        txt_filtro.setForeground(Color.white);
        txt_filtro.setText("");
        op = 2;

        limpa_tabela(tbl_resultado);
        Mysql_database db = new Mysql_database();
        String query = "SELECT * FROM movies ORDER BY name";
        String[] columns = {"NOME", "ANO", "PERSONAGEM", "IMDB"};
        preenche_tabela(tbl_resultado, db.search_sql(query), columns);
    }//GEN-LAST:event_btn_filmesActionPerformed


    private void btn_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtrarActionPerformed
        if (txt_filtro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite algo para filtar a pesquisa pelo nome!",
                    "Erro ao filtrar!", JOptionPane.ERROR_MESSAGE);
        } else {
            String query = "";
            txt_filtro.setBackground(Color.yellow);
            txt_filtro.setForeground(Color.black);
            limpa_tabela(tbl_resultado);
            Mysql_database db = new Mysql_database();
            switch (op) {
                case 1:
                    query = "SELECT name, description, born_info, imdb_uri FROM actors WHERE name LIKE \"%" + txt_filtro.getText() + "%\" ORDER BY name";
                    preenche_tabela(tbl_resultado, db.search_sql(query), new String[]{"NOME", "DESCRIÇÃO", "NASCIMENTO", "IMDB"});
                    break;
                case 2:
                    query = "SELECT * FROM movies WHERE name LIKE \"%" + txt_filtro.getText() + "%\" ORDER BY name";
                    preenche_tabela(tbl_resultado, db.search_sql(query), new String[]{"NOME", "ANO", "PERSONAGEM", "IMDB"});
                    break;
            }
        }
    }//GEN-LAST:event_btn_filtrarActionPerformed

    private void tbl_resultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_resultadoMouseClicked

        int row = tbl_resultado.getSelectedRow(); //.rowAtPoint(evt.getPoint());
        int col = tbl_resultado.getSelectedColumn(); //.columnAtPoint(evt.getPoint());
        String id = tbl_resultado.getValueAt(row, 3).toString();
        Mysql_database db = new Mysql_database();

        String table = "", field = "", query = "";

        // qual tabela será alterada:    1- ator     2-filmes
        String[] options = op == 1 ? new String[]{"Nome", "Descrição", "Nascimento", "CANCELAR"} : new String[]{"Nome", "Ano", "Personagem", "CANCELAR"};

        //alterar ou excluir?
        int operation = JOptionPane.showOptionDialog(null, "Operação",
                "Escolha uma opção:",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Alterar?", "Excluir?"},
                new String[]{"Alterar?", "Excluir?"});
        System.out.println("Operação:"+operation);
        System.out.println("ID:"+id);
        
        if(operation==JOptionPane.CLOSED_OPTION){
            return;
        }

        // exluir:
        if (operation == 1) {
            switch (op) {
                case 1:
                    query = "DELETE FROM actors WHERE imdb_uri=\"" + id + "\"";
                    db.update_sql(query);
                    query = "SELECT name, description, born_info, imdb_uri FROM actors ORDER BY name";
                    preenche_tabela(tbl_resultado, db.search_sql(query), new String[]{"NOME", "DESCRIÇÃO", "NASCIMENTO", "IMDB"});
                    break;
                case 2:
                    query = "DELETE FROM movies WHERE imdb_uri=\"" + id + "\"";
                    db.update_sql(query);
                    query = "SELECT * FROM movies ORDER BY name";
                    preenche_tabela(tbl_resultado, db.search_sql(query), new String[]{"NOME", "ANO", "PERSONAGEM", "IMDB"});
                    break;
                default:
                    break;
            }
            // alterar
        } else {
            // opção escolhida
            int option = JOptionPane.showOptionDialog(null, "Escolha um campo para alterar:",
                    "Escolha um campo para alterar",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
            if (op == 1) {
                table = "actors";
                switch (option) {
                    case 0:
                        field = "name";
                        break;
                    case 1:
                        field = "description";
                        break;
                    case 2:
                        field = "born_info";
                        break;
                    default:
                        break;
                }
            } else {
                table = "movies";
                switch (option) {
                    case 0:
                        field = "name";
                        break;
                    case 1:
                        field = "years";
                        break;
                    case 2:
                        field = "characters";
                        break;
                    default:
                        break;
                }
            }

            String new_value = JOptionPane.showInputDialog(null,
                    "Qual o novo valor do campo " + options[option] + "?",
                    tbl_resultado.getValueAt(row, option).toString());

            query = "UPDATE " + table + " SET " + field + " = \"" + new_value + "\" WHERE imdb_uri=\"" + id + "\"";
            switch (op) {
                case 1:
                    db.update_sql(query);
                    query = "SELECT name, description, born_info, imdb_uri FROM actors ORDER BY name";
                    preenche_tabela(tbl_resultado, db.search_sql(query), new String[]{"NOME", "DESCRIÇÃO", "NASCIMENTO", "IMDB"});
                    break;
                case 2:
                    db.update_sql(query);
                    query = "SELECT * FROM movies ORDER BY name";
                    preenche_tabela(tbl_resultado, db.search_sql(query), new String[]{"NOME", "ANO", "PERSONAGEM", "IMDB"});
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_tbl_resultadoMouseClicked

    private void txt_filtroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_filtrar.doClick();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_filtroKeyPressed

//    @param args the command line arguments
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Frm_pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Frm_pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Frm_pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Frm_pesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Frm_lista frm = new Frm_lista();
//                frm.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atores;
    private javax.swing.JButton btn_filmes;
    private javax.swing.JButton btn_filtrar;
    private javax.swing.ButtonGroup btn_grp_criterio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_filtro;
    private javax.swing.JPanel pnl_pesquisa;
    private javax.swing.JTable tbl_resultado;
    private javax.swing.JTextField txt_filtro;
    // End of variables declaration//GEN-END:variables
}
