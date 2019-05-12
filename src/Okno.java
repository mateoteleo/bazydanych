import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.sql.*;
import java.awt.*;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Okno {

	private JFrame frame;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Okno window = new Okno();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Okno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DbEdit baseEditor = new DbEdit();

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel booksPanel = new JPanel();
		tabbedPane.addTab("Ksi\u0105\u017Cki", null, booksPanel, null);
		booksPanel.setLayout(new BorderLayout(0, 0));
		
	
		
		JPanel booksPanelMaster = new JPanel();
		booksPanelMaster.setLayout(new CardLayout(0, 0));
		booksPanel.add(booksPanelMaster, BorderLayout.CENTER);
				
				
				
				JPanel rentPanel = new JPanel();
				rentPanel.setForeground(Color.WHITE);
				rentPanel.setBorder(new LineBorder(Color.WHITE, 1, true));
				rentPanel.setBackground(Color.BLACK);
				booksPanelMaster.add(rentPanel, "rentPanel");
				
				JPanel addPanel = new JPanel();
				addPanel.setBackground(Color.BLACK);
				addPanel.setForeground(Color.GRAY);
				booksPanelMaster.add(addPanel, "addPanel");
		
				JLabel lblAuthorField = new JLabel("Imi\u0119");
				lblAuthorField.setForeground(Color.WHITE);
				addPanel.add(lblAuthorField);
				lblAuthorField.setVerticalAlignment(SwingConstants.TOP);
				lblAuthorField.setHorizontalAlignment(SwingConstants.CENTER);
				lblAuthorField.setAlignmentX(Component.CENTER_ALIGNMENT);
				
						JTextPane firstNameData = new JTextPane();
						addPanel.add(firstNameData);
								
								JLabel lblLastNameField = new JLabel("Nazwisko");
								lblLastNameField.setVerticalAlignment(SwingConstants.TOP);
								lblLastNameField.setHorizontalAlignment(SwingConstants.CENTER);
								lblLastNameField.setForeground(Color.WHITE);
								lblLastNameField.setAlignmentX(0.5f);
								addPanel.add(lblLastNameField);
								
								JTextPane lastNameData = new JTextPane();
								addPanel.add(lastNameData);
						
								JLabel lblNewLabel_1 = new JLabel("Tytu\u0142");
								lblNewLabel_1.setForeground(Color.WHITE);
								addPanel.add(lblNewLabel_1);
								
										JTextPane titleData = new JTextPane();
										addPanel.add(titleData);
										
												JLabel lblNewLabel_2 = new JLabel("Egzemplarze");
												lblNewLabel_2.setForeground(Color.WHITE);
												addPanel.add(lblNewLabel_2);
												
														JSpinner spinnerItems = new JSpinner();
														addPanel.add(spinnerItems);
														
																JButton btnDodajDoBazy = new JButton("Dodaj do bazy");
																btnDodajDoBazy.setBackground(SystemColor.textHighlight);
																addPanel.add(btnDodajDoBazy);
																
																Vector<Object> columnNames = new Vector<Object>();
														        Vector<Object> data = new Vector<Object>();

														        try
														        {
														            Connection connection = DriverManager.getConnection(
																			"jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
																			"mateusz", "teleg2");

														            //  Read data from a table

														            String sql = "Select * from books";
														            Statement stmt = connection.createStatement();
														            ResultSet rs = stmt.executeQuery( sql );
														            ResultSetMetaData md = rs.getMetaData();
														            int columns = md.getColumnCount();

														            //  Get column names

														            for (int i = 1; i <= columns; i++)
														            {
														                columnNames.addElement( md.getColumnName(i) );
														            }

														            //  Get row data

														            while (rs.next())
														            {
														                Vector<Object> row = new Vector<Object>(columns);

														                for (int i = 1; i <= columns; i++)
														                {
														                    row.addElement( rs.getObject(i) );
														                }

														                data.addElement( row );
														            }

														            rs.close();
														            stmt.close();
														            connection.close();
														        }
														        catch(Exception e)
														        {
														            System.out.println( e );
														        }

														       /* DefaultTableModel model = new DefaultTableModel(data, columnNames)
														        {
														        	@Override
														            public Class getColumnClass(int column)
														            {
														                for (int row = 0; row < getRowCount(); row++)
														                {
														                    Object o = getValueAt(row, column);

														                    if (o != null)
														                    {
														                        return o.getClass();
														                    }
														                }

														                return Object.class;
														            }
														        };

													*/
														      
														    
																
																
																JPanel BooklistPanel = new JPanel();
																booksPanelMaster.add(BooklistPanel, "bookListPanel");
																
																
																
																
																tabela = new JTable(data, columnNames);
																tabela.setColumnSelectionAllowed(true);
																tabela.setShowGrid(false);
																tabela.setShowVerticalLines(false);
																tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
																tabela.setFillsViewportHeight(true);
																tabela.setBackground(Color.WHITE);
															
																BooklistPanel.add(tabela);
																btnDodajDoBazy.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent arg0) {
																		baseEditor.enterData(firstNameData.getText(), lastNameData.getText(), titleData.getText(), (Integer) spinnerItems.getValue(),"books");

																	}
																});
		
		JToolBar toolBarBooksTools = new JToolBar();
		toolBarBooksTools.setRollover(true);
		toolBarBooksTools.setBackground(Color.DARK_GRAY);
		toolBarBooksTools.setForeground(Color.DARK_GRAY);
		toolBarBooksTools.addSeparator();
		booksPanel.add(toolBarBooksTools, BorderLayout.NORTH);
		
		
		JButton btnBookList = new JButton("Spis");
		btnBookList.setBackground(Color.GRAY);
		btnBookList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(booksPanelMaster.getLayout());
		        cl.show(booksPanelMaster, "bookListPanel");
			}
		});
		toolBarBooksTools.add(btnBookList);
		
		JButton btnAddBook = new JButton("Dodaj");
		btnAddBook.setBackground(Color.GRAY);
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(booksPanelMaster.getLayout());
		        cl.show(booksPanelMaster, "addPanel");
			}
		});
		toolBarBooksTools.add(btnAddBook);
		
		JButton btnLend = new JButton("Wypo\u017Cycz");
		btnLend.setBackground(Color.GRAY);
		btnLend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(booksPanelMaster.getLayout());
		        cl.show(booksPanelMaster, "rentPanel");
			}
		});
		toolBarBooksTools.add(btnLend);
		
		JButton btnDeleteBook = new JButton("Usu\u0144");
		btnDeleteBook.setBackground(Color.GRAY);
		toolBarBooksTools.add(btnDeleteBook);
		
		JButton btnChangeBook = new JButton("Zmie\u0144");
		btnChangeBook.setBackground(Color.GRAY);
		toolBarBooksTools.add(btnChangeBook);
		
		
		
		JPanel readersPanel = new JPanel();
		tabbedPane.addTab("Czytelnicy", null, readersPanel, null);
		readersPanel.setLayout(new BorderLayout(0, 0));
		
		table_1 = new JTable();
		readersPanel.add(table_1);
		
		JPanel panel_1 = new JPanel();
		readersPanel.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Usu\u0144");
		panel_1.add(btnNewButton_1);
		
		JButton btnModyfikuj = new JButton("Modyfikuj");
		panel_1.add(btnModyfikuj);
		
		JPanel panel_2 = new JPanel();
		readersPanel.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnAddReader = new JButton("Dodaj");
		panel_2.add(btnAddReader, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 11, 61, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblImi = new JLabel("Imi\u0119");
		lblImi.setHorizontalAlignment(SwingConstants.CENTER);
		lblImi.setBounds(0, 29, 61, 17);
		panel_3.add(lblImi);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 61, 61, 20);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNazwisko = new JLabel("Nazwisko");
		lblNazwisko.setHorizontalAlignment(SwingConstants.CENTER);
		lblNazwisko.setBounds(0, 86, 61, 14);
		panel_3.add(lblNazwisko);
	}
}
