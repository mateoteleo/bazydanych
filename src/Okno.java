import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Okno {

	private JFrame frmMainFrame;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTable tabela;
	private JTextField textField_lastname;
	private JTextField textField_firstname;
	private JTextField textField_title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Okno window = new Okno();
					window.frmMainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Okno() {
		initialize();
	}


	private void initialize() {
		DbEdit baseEditor = new DbEdit();

		frmMainFrame = new JFrame();
		frmMainFrame.setTitle("Biblioteka 2019");
		frmMainFrame.setBounds(100, 100, 1000, 500);
		frmMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmMainFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

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
		spinnerItems.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		addPanel.add(spinnerItems);

		JButton btnDodajDoBazy = new JButton("Dodaj do bazy");
		btnDodajDoBazy.setBackground(SystemColor.textHighlight);
		addPanel.add(btnDodajDoBazy);

		JPanel BooklistPanel = new JPanel();
		booksPanelMaster.add(BooklistPanel, "bookListPanel");
		MyTableModel MyTableModel = new MyTableModel();
		BooklistPanel.setLayout(new BorderLayout(0, 0));
		tabela = new JTable(MyTableModel);

		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tabela.getSelectedRow();
				int selectedBookId = (int) tabela.getValueAt(row, 4);
				String selectedFirstName = (String) tabela.getValueAt(row, 0);
				String selectedLastName = (String) tabela.getValueAt(row, 1);
				String selectedTitle = (String) tabela.getValueAt(row, 2);
				textField_firstname.setText(selectedFirstName);
				textField_lastname.setText(selectedLastName);
				textField_title.setText(selectedTitle);

			}
		});

		tabela.setColumnSelectionAllowed(true);
		tabela.setShowGrid(false);
		tabela.setShowVerticalLines(false);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setFillsViewportHeight(true);
		tabela.setBackground(Color.WHITE);

		JScrollPane panelTabeli = new JScrollPane(tabela);
		BooklistPanel.add(panelTabeli, BorderLayout.WEST);

		JPanel panel = new JPanel();
		BooklistPanel.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		textField_firstname = new JTextField();
		textField_firstname.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField_firstname);
		textField_firstname.setColumns(10);

		textField_lastname = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textField_firstname, 0, SpringLayout.WEST, textField_lastname);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_firstname, -35, SpringLayout.NORTH, textField_lastname);
		sl_panel.putConstraint(SpringLayout.EAST, textField_firstname, 0, SpringLayout.EAST, textField_lastname);
		panel.add(textField_lastname);
		textField_lastname.setColumns(10);

		textField_title = new JTextField();
		sl_panel.putConstraint(SpringLayout.EAST, textField_lastname, 0, SpringLayout.EAST, textField_title);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_title, 163, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField_lastname, 0, SpringLayout.WEST, textField_title);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_lastname, -34, SpringLayout.NORTH, textField_title);
		sl_panel.putConstraint(SpringLayout.WEST, textField_title, 23, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_title, 225, SpringLayout.WEST, panel);
		panel.add(textField_title);
		textField_title.setColumns(10);

		JButton btnZapiszZmiany = new JButton("Zapisz zmiany");
		btnZapiszZmiany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tabela.getSelectedRow();
				int selectedBookId = (int) tabela.getValueAt(row, 4);

				baseEditor.editData(textField_firstname.getText(), textField_lastname.getText(),
						textField_title.getText(), selectedBookId, "books");
				MyTableModel.updateTable();
				MyTableModel.fireTableDataChanged();

			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnZapiszZmiany, 29, SpringLayout.SOUTH, textField_title);
		sl_panel.putConstraint(SpringLayout.WEST, btnZapiszZmiany, 74, SpringLayout.WEST, panel);
		panel.add(btnZapiszZmiany);

		btnDodajDoBazy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				baseEditor.enterData(firstNameData.getText(), lastNameData.getText(), titleData.getText(),
						(Integer) spinnerItems.getValue(), "books");
				MyTableModel.updateTable();
				MyTableModel.fireTableDataChanged();
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
				CardLayout cl = (CardLayout) (booksPanelMaster.getLayout());
				cl.show(booksPanelMaster, "bookListPanel");
			}
		});
		toolBarBooksTools.add(btnBookList);

		JButton btnAddBook = new JButton("Dodaj");
		btnAddBook.setBackground(Color.GRAY);
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) (booksPanelMaster.getLayout());
				cl.show(booksPanelMaster, "addPanel");
			}
		});
		toolBarBooksTools.add(btnAddBook);

		JButton btnLend = new JButton("Wypo\u017Cycz");
		btnLend.setBackground(Color.GRAY);
		btnLend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (booksPanelMaster.getLayout());
				cl.show(booksPanelMaster, "rentPanel");
			}
		});
		toolBarBooksTools.add(btnLend);

		JButton btnDeleteBook = new JButton("Usu\u0144");
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = (int) tabela.getValueAt(tabela.getSelectedRow(), 4);
				baseEditor.deleteData(row, "books");
				MyTableModel.updateTable();
				MyTableModel.fireTableDataChanged();
			}
		});

		btnDeleteBook.setBackground(Color.GRAY);
		toolBarBooksTools.add(btnDeleteBook);

		JButton btnChangeBook = new JButton("Zmie\u0144");
		btnChangeBook.setBackground(Color.GRAY);
		toolBarBooksTools.add(btnChangeBook);

		JButton btnNewButton = new JButton("FIRE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyTableModel.updateTable();
				MyTableModel.fireTableDataChanged();
			}
		});

		toolBarBooksTools.add(btnNewButton);

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
