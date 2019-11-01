/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import scraper.Imdb_filmes_ator;

/**
 *
 * @author alex
 */
public class Frm_detalhes extends javax.swing.JFrame {

    public int i;

    /**
     * Creates new form Frm_detalhes
     */
    public Frm_detalhes(String imdb_link) {

        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        Imdb_filmes_ator scrap = new Imdb_filmes_ator(imdb_link);
        lbl_ator.setText(scrap.nome);
        lbl_descricao.setText(scrap.descricao);
        lbl_nascimento.setText(scrap.nascimento);
        lbl_imdb.setText(imdb_link);

        System.out.println(scrap.foto);
        try {
            URL url = new URL(scrap.foto);
            BufferedImage image = ImageIO.read(url);

            Image dimg = image.getScaledInstance(lbl_foto.getWidth(), lbl_foto.getHeight(), Image.SCALE_SMOOTH);

            lbl_foto.setIcon(new javax.swing.ImageIcon(dimg));

        } catch (MalformedURLException ex) {
            System.out.println("Erro:" + ex);
        } catch (IOException ex) {
            System.out.println("Erro:" + ex);
        }

        limpa_tabela(tbl_resultado);
        preenche_tabela(tbl_resultado, scrap);
    }

    private void limpa_tabela(JTable tbl) {
        //model jtable
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        // atualizar tabela
        tbl.validate();
    }

    private void preenche_tabela(JTable tbl, Imdb_filmes_ator scrap) {
        String[] columns = {"FILME", "ANO", "PERSONAGEM", "LINK IMDB"};
        Object[][] rows = new Object[scrap.filmes.size()][4];

        //put data in rows
        i = 0;
        scrap.filmes.forEach((item) -> {
            rows[i] = (new Object[]{item.get(0), item.get(1), item.get(2), item.get(3)});
            i++;
        });

        DefaultTableModel model = new DefaultTableModel(rows, columns) {
            @Override
            public Class<?> getColumnClass(int column) {
                //definir as classes das colunas
                switch (column) {
                    case 0:
                        return Object.class;
//                        return ImageIcon.class;
                    case 1:
                        return Object.class;
                    case 2:
                        return Object.class;
                    case 3:
                        return Object.class;
                    default:
                        return Object.class;
                }
            }

            //bloquear edição
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbl.setModel(model);
//        tbl.getColumnModel().getColumn(0).setMaxWidth(120);
//        tbl.getColumnModel().getColumn(1).setWidth(30);
        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        tbl.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_ator = new javax.swing.JLabel();
        lbl_imdb = new javax.swing.JLabel();
        lbl_foto = new javax.swing.JLabel();
        lbl_nascimento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_resultado = new javax.swing.JTable();
        lbl_descricao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(734, 505));

        lbl_ator.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        lbl_ator.setText("ator_name");

        lbl_imdb.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        lbl_imdb.setText("imdb");

        lbl_foto.setText("photo");

        lbl_nascimento.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        lbl_nascimento.setText("nascimento");

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

        lbl_descricao.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        lbl_descricao.setText("descricao");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_ator)
                            .addComponent(lbl_descricao)
                            .addComponent(lbl_nascimento)
                            .addComponent(lbl_imdb))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_ator)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_descricao)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_nascimento)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_imdb)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_resultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_resultadoMouseClicked


    }//GEN-LAST:event_tbl_resultadoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_ator;
    private javax.swing.JLabel lbl_descricao;
    private javax.swing.JLabel lbl_foto;
    private javax.swing.JLabel lbl_imdb;
    private javax.swing.JLabel lbl_nascimento;
    private javax.swing.JTable tbl_resultado;
    // End of variables declaration//GEN-END:variables
}