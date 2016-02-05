/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.Patient;
import Business.Person;
import Business.PersonDirectory;
import Business.VitalSign;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Paint;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarPainter;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Neerajsing Rajput
 */
public class SearchPatientResultJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    Patient patient;
    PersonDirectory personDirectory;
    public DefaultCategoryDataset dataset;

    /**
     * Creates new form SearchPatientResultJPanel
     */
    public SearchPatientResultJPanel(JPanel upc, Patient p, PersonDirectory pd) {
        initComponents();
        userProcessContainer = upc;
        patient = p;
        personDirectory = pd;
        createCharts();
    }

    public void createCharts() {
        dataset = new DefaultCategoryDataset();
        JFreeChart barChart = ChartFactory.createBarChart(
                "Graph for Blood Pressure",
                "Blood Pressure",
                "Timestamp",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        populateTable(barChart);
        ChartFrame frame = new ChartFrame("Blood Pressure", barChart);
        frame.pack();
        frame.setVisible(true);

    }

    public void populateTable(JFreeChart barChart) {
        //Make table Empty
        String checkStatus;
        DefaultTableModel dtm = (DefaultTableModel) tblVitalSigns.getModel();
        int rowCount = tblVitalSigns.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        for (VitalSign vs : patient.getVitalSignHistory().getVitalSignList()) {
            checkStatus = CheckRange(vs, patient);
            vs.setStatus(checkStatus);
            Object row[] = new Object[6];
            row[0] = vs.getHeartRate();
            row[1] = vs.getRespiratoryRate();
            row[2] = vs.getBloodPressure();
            row[3] = vs.getWeightInPounds();
            row[4] = vs;
            row[5] = vs.getStatus();
            dataset.addValue(vs.getBloodPressure(), "Bloodpressure", vs.getDate());
            if (checkStatus.equals("Normal")) {
                CategoryPlot cplot = (CategoryPlot) barChart.getPlot();
                cplot.setBackgroundPaint(SystemColor.inactiveCaption);//change background color
                ((BarRenderer) cplot.getRenderer()).setBarPainter(new StandardBarPainter());
                BarRenderer r = (BarRenderer) barChart.getCategoryPlot().getRenderer();
                r.setSeriesPaint(0, Color.blue);

            } else {
                CategoryPlot cplot = (CategoryPlot) barChart.getPlot();
                cplot.setBackgroundPaint(SystemColor.inactiveCaption);//change background color
                ((BarRenderer) cplot.getRenderer()).setBarPainter(new StandardBarPainter());
                BarRenderer r = (BarRenderer) barChart.getCategoryPlot().getRenderer();
                //BarPainter b=new BarPainter
                r.setSeriesPaint(1, Color.RED);
            }

            dtm.addRow(row);
        }
    }

    public String CheckRange(VitalSign vs, Patient patient) {
        String tempStatus = "";
        String normal = "Normal";
        String abnormal = "Abnormal";
        Person person = new Person();
        for (Person p : personDirectory.getPersonList()) {
            if (p.getPatient() == patient) {
                person = personDirectory.searchPerson(p.getPersonName());
            }
        }
        if (person.getAge() >= 1 && person.getAge() <= 3) {
            if ((vs.getRespiratoryRate() >= 20 && vs.getRespiratoryRate() <= 30) && ((vs.getHeartRate() >= 80) && (vs.getHeartRate() <= 130)) && ((vs.getBloodPressure() >= 80) && (vs.getBloodPressure() <= 110)) && ((vs.getWeightInPounds() >= 22) && (vs.getWeightInPounds() <= 30))) {
                tempStatus = normal;
            } else {
                tempStatus = abnormal;
            }
        } else if (person.getAge() >= 4 && person.getAge() <= 5) {
            if ((vs.getRespiratoryRate() >= 20 && vs.getRespiratoryRate() <= 30) && ((vs.getHeartRate() >= 80) && (vs.getHeartRate() <= 120)) && ((vs.getBloodPressure() >= 80) && (vs.getBloodPressure() <= 110)) && ((vs.getWeightInPounds() >= 31) && (vs.getWeightInPounds() <= 40))) {
                tempStatus = normal;
            } else {
                tempStatus = abnormal;
            }
        } else if (person.getAge() >= 6 && person.getAge() <= 12) {
            if ((vs.getRespiratoryRate() >= 20 && vs.getRespiratoryRate() <= 30) && ((vs.getHeartRate() >= 70) && (vs.getHeartRate() <= 110)) && ((vs.getBloodPressure() >= 80) && (vs.getBloodPressure() <= 120)) && ((vs.getWeightInPounds() >= 41) && (vs.getWeightInPounds() <= 92))) {
                tempStatus = normal;
            } else {
                tempStatus = abnormal;
            }
        } else if (person.getAge() >= 13) {
            if ((vs.getRespiratoryRate() >= 12) && ((vs.getHeartRate() >= 55) && (vs.getHeartRate() <= 110)) && ((vs.getBloodPressure() >= 110) && (vs.getBloodPressure() <= 120)) && (vs.getWeightInPounds() >= 110)) {
                tempStatus = normal;
            } else {
                tempStatus = abnormal;
            }
        }
        return tempStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVitalSigns = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("View Patient vitalsigns");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 11, -1, -1));

        tblVitalSigns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Heart Rate", "Respiratory Rate", "Blood pressure", "Weight", "Timestamp", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblVitalSigns);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 51, 433, 91));

        jButton1.setText("<<back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVitalSigns;
    // End of variables declaration//GEN-END:variables
}
