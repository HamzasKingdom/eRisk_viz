/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriskgui;

import database.result;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author hamza
 */
public class MainMenu extends javax.swing.JFrame {

    String url = "com.mysql.jdbc.Driver";
    String connectSql = "jdbc:mysql://localhost:3306/aggragateddatasetfeatures";
    String sqlUser = "root";
    String sqlPasswd = "";

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
    }


    private String[] AggregatedOperations() {
        String[] Ops = {"Feature-Feature", "Feature-Class", "Feature-Stat"};
        return Ops;
    }

    private String[] Classify() {
        String[] cla = {"Both", "Negative", "Positive"};
        return cla;
    }

    private String[] RawOperations() {
        String[] Ops = {"Search by date", "Search by user", "Search by term"};
        return Ops;
    }

    private Object[] Features() {

        ArrayList<String> rsa = new ArrayList<>();
        Connection con = null;
        PreparedStatement psm = null;
        ResultSet rs = null;

        try {

            Class.forName(url);

            con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);

            psm = con.prepareStatement("select distinct feature from feature_class order by feature ASC;");
            rs = psm.executeQuery();

            while (rs.next()) {
                rsa.add(rs.getString(1));
            }

            rs.close();
            psm.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error：" + e.getMessage());
        }
        return rsa.toArray();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Datasets = new javax.swing.ButtonGroup();
        Chunks = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jrbRaw = new javax.swing.JRadioButton();
        jrbAggreagated = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlFeatures = new JList(this.Features());
        jcbRawOperations = new JComboBox(RawOperations());
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbAggregatedOperations = new JComboBox(AggregatedOperations());
        jbSubmit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jcbClass = new JComboBox(this.Classify());
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jtText = new javax.swing.JTextField();
        cbChunk1 = new javax.swing.JRadioButton();
        cbChunk2 = new javax.swing.JRadioButton();
        cbTrainingChunk = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        order = new JComboBox(RawOperations());
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("eRisk Graphical Interface");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Choose your dataset");

        jrbRaw.setBackground(new java.awt.Color(204, 204, 255));
        Datasets.add(jrbRaw);
        jrbRaw.setText("Raw");

        jrbAggreagated.setBackground(new java.awt.Color(204, 204, 255));
        Datasets.add(jrbAggreagated);
        jrbAggreagated.setSelected(true);
        jrbAggreagated.setText("Aggregated");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Chunk");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Choose the Feature(s)");

        jlFeatures.setSelectionMode(2);
        jlFeatures.setToolTipText("");
        jScrollPane1.setViewportView(jlFeatures);

        jcbRawOperations.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "uid", "title", "date", "text" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Search Raw data by");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Operation for Aggregated data");

        jbSubmit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbSubmit.setText("Submit");
        jbSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSubmitActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Class");

        jcbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Both", "Depressed", "Not depressed" }));
        jcbClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClassActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        cbChunk1.setBackground(new java.awt.Color(204, 204, 255));
        Chunks.add(cbChunk1);
        cbChunk1.setSelected(true);
        cbChunk1.setText("Chunk1");
        cbChunk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChunk1ActionPerformed(evt);
            }
        });

        cbChunk2.setBackground(new java.awt.Color(204, 204, 255));
        Chunks.add(cbChunk2);
        cbChunk2.setText("Chunk2");

        cbTrainingChunk.setBackground(new java.awt.Color(204, 204, 255));
        Chunks.add(cbTrainingChunk);
        cbTrainingChunk.setText("Training chunk");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Order By");

        order.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "uid", "date" }));

        jLabel9.setBackground(new java.awt.Color(204, 204, 255));
        jLabel9.setText("More info");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(204, 204, 255));
        jLabel10.setText("More info");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jcbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbChunk1)
                    .addComponent(cbChunk2)
                    .addComponent(cbTrainingChunk))
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jcbAggregatedOperations, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jrbAggreagated)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9))
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(64, 64, 64)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jcbRawOperations, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jtText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jrbRaw)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10)))
                                .addContainerGap(159, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbSubmit)
                                .addGap(40, 40, 40))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(295, 295, 295))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbAggreagated)
                            .addComponent(jLabel9))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbAggregatedOperations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbRaw)
                            .addComponent(jLabel10))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbRawOperations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbSubmit)
                        .addGap(28, 28, 28))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(156, 156, 156)
                                        .addComponent(jtText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(cbChunk1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbChunk2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTrainingChunk)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSubmitActionPerformed
        String Table = getChunk();

        String Classify = this.jcbClass.getSelectedItem().toString();
        
        if (this.jrbAggreagated.isSelected()) {
            AggregatedMethod(Table, Classify);
        } else {
            RawMethod(Table, Classify);
        }

    }//GEN-LAST:event_jbSubmitActionPerformed

    private String getChunk() {
        String chunk = "";
        ArrayList<String> chunks = new ArrayList<>();
        
        if (this.cbChunk1.isSelected()) {
            chunks.add("chunk1");
        }
        if (this.cbChunk2.isSelected()) {
            chunks.add("chunk2");
        }
        if (this.cbTrainingChunk.isSelected()) {
            chunks.add("chunk3");
        }
        
        chunk = chunks.get(0);
        for(int i = 1; i < chunks.size(); i++)
            chunk += ", " + chunks.get(i);
        
        return chunk;
    }
    
    private void AggregatedMethod(String Table, String Classify) {
        String Operation = this.jcbAggregatedOperations.getSelectedItem().toString();
        if(Operation.equals("Feature-Feature")) {
            ArrayList<String> Features = new ArrayList<>();
            Features.addAll(this.jlFeatures.getSelectedValuesList());
            if(Features.size() < 2) {
                JOptionPane.showMessageDialog(rootPane, "Please select two features");
                return;
            }
            DisplayFeatFeat(Table, Classify, Features);
        }
        else {
            if(this.jlFeatures.getSelectedValuesList().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Please select one feature");
                return;
            }
            if(Operation.equals("Feature-Class")) {
                DisplayFeatClass(Table, Classify, this.jlFeatures.getSelectedValue());
            }
            else if(Operation.equals("Feature-Stat")) {
                DisplayFeatStat(Table, Classify, this.jlFeatures.getSelectedValue());
            }
        }
    }
    
    private void DisplayFeatFeat(String Table, String Classify, ArrayList<String> Features) {
        ArrayList<Integer> valuesFeat1 = Get10Split(Table, Classify, Features.get(0));
        ArrayList<Integer> valuesFeat2 = Get10Split(Table, Classify, Features.get(1));
        
        LineFeatFeat frame = new LineFeatFeat(Features, valuesFeat1, valuesFeat2);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private ArrayList<Integer> Get10Split(String Table, String Classify, String Feature) {
        Connection con = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        
        ArrayList<Integer> values = new ArrayList<>();

        try {

            Class.forName(url);

            con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
            
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where (" + Feature + " > 0) and (" 
                    + Feature + " < 0.0005);");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where (" + Feature + " > 0.0005) and (" 
                    + Feature + " < 0.001);");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where (" + Feature + " > 0.001) and (" 
                    + Feature + " < 0.002);");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where (" + Feature + " > 0.002) and (" 
                    + Feature + " < 0.005);");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where (" + Feature + " > 0.005) and (" 
                    + Feature + " < 0.01);");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where (" + Feature + " > 0.01) and (" 
                    + Feature + " < 0.02);");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where (" + Feature + " > 0.02) and (" 
                    + Feature + " < 0.03);");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where (" + Feature + " > 0.03) and (" 
                    + Feature + " < 0.04);");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where (" + Feature + " > 0.04) and (" 
                    + Feature + " < 0.05);");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where " + Feature + " > 0.05;");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            

            rs.close();
            psm.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error：" + e.getMessage());
        }
        return values;
    }
    
    private ArrayList<Integer> getCount(String Table, String Classify, String Feature) {
        Connection con = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        String c;
        if(Classify.equals("Depressed"))
            c = "p";
        else
            c = "n";
        ArrayList<Integer> values = new ArrayList<>();
        
        try {
            Class.forName(url);

            con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
            
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where (" + Feature + " > 0) and (" 
                    + Feature + " < 0.0005) and (class = \"" + c + "\");");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where (" + Feature + " > 0.0005) and (" 
                    + Feature + " < 0.002) and (class = \"" + c + "\");");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where (" + Feature + " > 0.002) and (" 
                    + Feature + " < 0.007) and (class = \"" + c + "\");");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where (" + Feature + " > 0.007) and (" 
                    + Feature + " < 0.01) and (class = \"" + c + "\");");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            psm = con.prepareStatement("select count(" + Feature + ") from " + Table + " where " + Feature + " > 0.01 and (class = \"" + c + "\");");
            rs = psm.executeQuery();
            rs.next();
            values.add(rs.getInt(1));
            

            rs.close();
            psm.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error：" + e.getMessage());
        }
        return values;
    }
    private void DisplayFeatStat(String Table, String Classify, String Feature) {
             
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> values2 = new ArrayList<>();

        if(Classify.equals("Both")) {
            values = getCount(Table, "Depressed", Feature);
            values2 = getCount(Table, "Not depressed", Feature);
        }
        else {
            values = getCount(Table, Classify, Feature);
        }
        
        BarFeatStat frame = new BarFeatStat(Feature, Classify, values, values2);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private void DisplayFeatClass(String Table, String Classify, String Feature) {
        
        if(!Classify.equalsIgnoreCase("Both")) {
            JOptionPane.showMessageDialog(rootPane, "This operation can only be applied to both classes");
            return;
        }
            
        Connection con = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        
        double vn = 0, vp = 0;

        try {

            Class.forName(url);

            con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);

            ArrayList<Integer> types = new ArrayList<>();
            for(Integer i = 1; i < 4; i++) {
                if(Table.contains(i.toString()))
                    types.add(i);
            }
            String Type = "";
            if(types.size() < 3) {
                Type = "and ((type = " + types.get(0) + ")";
                for(int i = 1; i < types.size(); i++)
                    Type += " or (type = " + types.get(i) + ")";
                Type += ")";
            }
            
            psm = con.prepareStatement("select class_N from feature_class where feature = \"" + Feature + "\"" + Type + ";");
            rs = psm.executeQuery();
            rs.next();
            vn = rs.getDouble(1)/741.0;
            
            
            psm = con.prepareStatement("select class_P from feature_class where feature = \"" + Feature + "\"" + Type + ";");
            rs = psm.executeQuery();
            rs.next();
            vp = rs.getDouble(1)/79.0;

            rs.close();
            psm.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error：" + e.getMessage());
        }
        
        PieFeatClass frame = new PieFeatClass(Feature, vp, vn);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void RawMethod(String Table, String Classify) {
        String op = this.jcbRawOperations.getSelectedItem().toString();
        String word = this.jtText.getText();
        String chunk = this.getChunk();
        String order = this.order.getSelectedItem().toString();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame result = new result(op, word, chunk, order);
                RefineryUtilities.centerFrameOnScreen(result);
                result.setVisible(true);
            }
        });
    }

    private void jcbClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClassActionPerformed
        if(!this.jcbClass.getSelectedItem().toString().equals("Both"))
            JOptionPane.showMessageDialog(rootPane, "This classification is only available for Aggregated \nOperations 'Feature-Feature' and \n'Feature-Stat'", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jcbClassActionPerformed

    private void cbChunk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChunk1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbChunk1ActionPerformed

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        JOptionPane.showMessageDialog(rootPane, "The aggreagated data is the data that the reasearchers have found to be useful for depression detection, it was extracted from the raw data. \nWhith this data you can make 3 operations:\n\t- Feature-Feature: which allows you to visualize how 2 features affect each other.\n\t- Feature-Class: which allows you to compare a feature according to depressed or non depressed people.\n\t- Feature-Stat: which gives you statistics on the number of people that fall into a certain segment of the feature's frequency.");
    }//GEN-LAST:event_jLabel9MousePressed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        JOptionPane.showMessageDialog(rootPane, "The raw data consists of the totality of the posts that the researchers have used, you can browse through them using the form below.\n\nNote that the format for the date is: yyyy-mm-dd hh:mm:ss (you can search by individual parts, for example: '2016-05' or '00:15')\n\nThe uid means user id, in order to search it you need to input 'subject' followed by the number of the subject (subject3, subject1121)");
    }//GEN-LAST:event_jLabel10MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Chunks;
    private javax.swing.ButtonGroup Datasets;
    private javax.swing.JRadioButton cbChunk1;
    private javax.swing.JRadioButton cbChunk2;
    private javax.swing.JRadioButton cbTrainingChunk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbSubmit;
    private javax.swing.JComboBox<String> jcbAggregatedOperations;
    private javax.swing.JComboBox<String> jcbClass;
    private javax.swing.JComboBox<String> jcbRawOperations;
    private javax.swing.JList<String> jlFeatures;
    private javax.swing.JRadioButton jrbAggreagated;
    private javax.swing.JRadioButton jrbRaw;
    private javax.swing.JTextField jtText;
    private javax.swing.JComboBox<String> order;
    // End of variables declaration//GEN-END:variables
}
