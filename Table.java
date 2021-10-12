import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Table extends JFrame implements TableModelListener, ActionListener {

    private JTable table;
    private JButton save;

    private String[] cellValue ;
    private int size;


    public Table(String choice, String[] nutrientNames) {


        this.size = nutrientNames.length;
        cellValue = new String[this.size+1];
        cellValue[0] = choice;

        getContentPane().setLayout(null);
        getContentPane().setBounds(0,0, 400, this.size*15);

        JLabel box = new JLabel("Lebensmittel einfügen: ");
        box.setBounds(50,50,400, 50);
        getContentPane().add(box);

        DefaultTableModel tableModel;

        Object[] columnNames = new Object[]{"Name","Menge"};
        Object[][] rowData = new Object[this.size][2];
        for (int i = 0 ; i < nutrientNames.length ; i++) {
           rowData[i][0] = nutrientNames[i];
        }
        rowData[0][1] = choice;

        tableModel = new DefaultTableModel(rowData, columnNames);
        tableModel.addTableModelListener(this);

        table = new JTable(tableModel);

//        JScrollPane scrollPane = new JScrollPane(table);
        table.setBounds(50, 100, 400, (this.size+1)*15);
        getContentPane().add(table);

        save = new JButton("speichern");
        save.setBounds(150, 100+this.size*15+50, 200, 30);
        save.setVisible(true);
        getContentPane().add(save);

        save.addActionListener( this);

        setVisible(true);
        setSize(320, 200);
    }

    public void tableChanged(TableModelEvent e) {
//        DefaultTableModel model = (DefaultTableModel) e.getSource();
        int rows = e.getFirstRow();
        int columns = e.getColumn();

        cellValue[rows] = String.valueOf(table.getValueAt(rows, columns));

        JOptionPane.showMessageDialog(this,
                "Der neue eingetragene Wert für " + "\'" + cellValue[rows] + "\'");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == this.save ){
            (new CSV(cellValue)).addToCSV();
            dispose();
        }
    }


    public String[] getCellValues(){
        return cellValue;
    }

    public void closeTable( Table frm ){
        frm.dispose();
    }

}