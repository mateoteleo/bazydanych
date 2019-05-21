import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.SpinnerNumberModel;

public class Okno {

	private JFrame frmMainFrame;
	private JTable table_1;
	private JTextField textField_lastname;
	private JTextField textField_firstname;
	private JTable tabela;
	private JTextField textField_title;
	private JTextField firstNameData;
	private JTextField lastNameData;
	private JTextField titleData;

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

		JPanel BooklistPanel = new JPanel();
		booksPanelMaster.add(BooklistPanel, "bookListPanel");

		MyTableModel MyTableModel = new MyTableModel();
		BooklistPanel.setLayout(new BorderLayout(0, 0));

		tabela = new JTable(MyTableModel);

		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tabela.getSelectedRow();
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

		JScrollPane panelLeftBooks = new JScrollPane(tabela);
		BooklistPanel.add(panelLeftBooks, BorderLayout.WEST);

		JPanel panelRightBooks = new JPanel();
		BooklistPanel.add(panelRightBooks, BorderLayout.CENTER);
		panelRightBooks.setLayout(new BorderLayout(0, 0));

		JPanel panelMenuBooks = new JPanel();
		panelRightBooks.add(panelMenuBooks, BorderLayout.NORTH);

		JPanel panelCardBooks = new JPanel();
		panelRightBooks.add(panelCardBooks, BorderLayout.CENTER);
		panelCardBooks.setLayout(new CardLayout(0, 0));

		JPanel panelBooksA = new JPanel();
		panelCardBooks.add(panelBooksA, "panelBooksA");
		SpringLayout sl_panelBooksA = new SpringLayout();
		panelBooksA.setLayout(sl_panelBooksA);

		textField_lastname = new JTextField();
		textField_lastname.setHorizontalAlignment(SwingConstants.CENTER);
		panelBooksA.add(textField_lastname);
		textField_lastname.setColumns(10);

		JLabel lblImi = new JLabel("Imi\u0119");
		panelBooksA.add(lblImi);
		lblImi.setHorizontalAlignment(SwingConstants.CENTER);

		textField_firstname = new JTextField();
		sl_panelBooksA.putConstraint(SpringLayout.WEST, textField_firstname, 31, SpringLayout.WEST, panelBooksA);
		sl_panelBooksA.putConstraint(SpringLayout.EAST, textField_firstname, -340, SpringLayout.EAST, panelBooksA);
		sl_panelBooksA.putConstraint(SpringLayout.NORTH, lblImi, 3, SpringLayout.NORTH, textField_firstname);
		sl_panelBooksA.putConstraint(SpringLayout.WEST, lblImi, 6, SpringLayout.EAST, textField_firstname);
		sl_panelBooksA.putConstraint(SpringLayout.WEST, textField_lastname, 0, SpringLayout.WEST, textField_firstname);
		sl_panelBooksA.putConstraint(SpringLayout.EAST, textField_lastname, 0, SpringLayout.EAST, textField_firstname);
		textField_firstname.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panelBooksA.putConstraint(SpringLayout.SOUTH, textField_firstname, -332, SpringLayout.SOUTH, panelBooksA);
		panelBooksA.add(textField_firstname);
		textField_firstname.setColumns(10);

		JLabel lblNazwisko = new JLabel("Nazwisko");
		sl_panelBooksA.putConstraint(SpringLayout.NORTH, lblNazwisko, 3, SpringLayout.NORTH, textField_lastname);
		sl_panelBooksA.putConstraint(SpringLayout.WEST, lblNazwisko, 6, SpringLayout.EAST, textField_lastname);
		panelBooksA.add(lblNazwisko);
		lblNazwisko.setHorizontalAlignment(SwingConstants.CENTER);

		textField_title = new JTextField();
		sl_panelBooksA.putConstraint(SpringLayout.WEST, textField_title, 31, SpringLayout.WEST, panelBooksA);
		sl_panelBooksA.putConstraint(SpringLayout.SOUTH, textField_lastname, -6, SpringLayout.NORTH, textField_title);
		sl_panelBooksA.putConstraint(SpringLayout.NORTH, textField_title, 108, SpringLayout.NORTH, panelBooksA);
		textField_title.setHorizontalAlignment(SwingConstants.CENTER);
		textField_title.setFocusTraversalKeysEnabled(true);
		textField_title.setColumns(10);
		panelBooksA.add(textField_title);

		JButton button_1 = new JButton("Zapisz");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tabela.getSelectedRow();
				int selectedBookId = (int) tabela.getValueAt(row, 4);

				baseEditor.editData(textField_firstname.getText(), textField_lastname.getText(),
						textField_title.getText(), selectedBookId, "books");
				MyTableModel.updateTable();
				MyTableModel.fireTableDataChanged();
			}
		});
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		panelBooksA.add(button_1);

		JButton button_2 = new JButton("Usu\u0144");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = (int) tabela.getValueAt(tabela.getSelectedRow(), 4);
				baseEditor.deleteData(row, "books");
				MyTableModel.updateTable();
				MyTableModel.fireTableDataChanged();
			}
		});
		sl_panelBooksA.putConstraint(SpringLayout.NORTH, button_2, 17, SpringLayout.SOUTH, textField_title);
		sl_panelBooksA.putConstraint(SpringLayout.WEST, button_2, 127, SpringLayout.WEST, panelBooksA);
		sl_panelBooksA.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, button_2);
		sl_panelBooksA.putConstraint(SpringLayout.EAST, button_1, -21, SpringLayout.WEST, button_2);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		button_2.setBackground(Color.LIGHT_GRAY);
		panelBooksA.add(button_2);

		JLabel label_5 = new JLabel("Tytu\u0142");
		sl_panelBooksA.putConstraint(SpringLayout.WEST, label_5, 191, SpringLayout.WEST, panelBooksA);
		sl_panelBooksA.putConstraint(SpringLayout.EAST, textField_title, -6, SpringLayout.WEST, label_5);
		sl_panelBooksA.putConstraint(SpringLayout.NORTH, label_5, 3, SpringLayout.NORTH, textField_title);
		panelBooksA.add(label_5);

		JLabel lblPanelZmianyusuwaniaKsiki = new JLabel("Panel zmiany/usuwania ksi\u0105\u017Cki");
		sl_panelBooksA.putConstraint(SpringLayout.NORTH, lblPanelZmianyusuwaniaKsiki, 10, SpringLayout.NORTH,
				panelBooksA);
		sl_panelBooksA.putConstraint(SpringLayout.WEST, lblPanelZmianyusuwaniaKsiki, 31, SpringLayout.WEST,
				panelBooksA);
		panelBooksA.add(lblPanelZmianyusuwaniaKsiki);

		JPanel panelBooksB = new JPanel();
		panelCardBooks.add(panelBooksB, "panelBooksB");
		panelBooksB.setForeground(SystemColor.desktop);
		panelBooksB.setBackground(SystemColor.menu);
		SpringLayout sl_panelBooksB = new SpringLayout();
		panelBooksB.setLayout(sl_panelBooksB);

		JLabel label = new JLabel("Imi\u0119");
		sl_panelBooksB.putConstraint(SpringLayout.NORTH, label, 49, SpringLayout.NORTH, panelBooksB);
		sl_panelBooksB.putConstraint(SpringLayout.WEST, label, 158, SpringLayout.WEST, panelBooksB);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(SystemColor.desktop);
		label.setAlignmentX(0.5f);
		panelBooksB.add(label);

		JLabel label_1 = new JLabel("Nazwisko");
		sl_panelBooksB.putConstraint(SpringLayout.NORTH, label_1, 13, SpringLayout.SOUTH, label);
		sl_panelBooksB.putConstraint(SpringLayout.WEST, label_1, 158, SpringLayout.WEST, panelBooksB);
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(SystemColor.desktop);
		label_1.setAlignmentX(0.5f);
		panelBooksB.add(label_1);

		JLabel label_2 = new JLabel("Tytu\u0142");
		sl_panelBooksB.putConstraint(SpringLayout.NORTH, label_2, 12, SpringLayout.SOUTH, label_1);
		sl_panelBooksB.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, label);
		label_2.setForeground(SystemColor.desktop);
		panelBooksB.add(label_2);

		JLabel label_3 = new JLabel("Egzemplarze");
		sl_panelBooksB.putConstraint(SpringLayout.NORTH, label_3, 133, SpringLayout.NORTH, panelBooksB);
		sl_panelBooksB.putConstraint(SpringLayout.SOUTH, label_2, -17, SpringLayout.NORTH, label_3);
		sl_panelBooksB.putConstraint(SpringLayout.WEST, label_3, 158, SpringLayout.WEST, panelBooksB);
		label_3.setForeground(SystemColor.desktop);
		panelBooksB.add(label_3);

		JSpinner spinnerItems = new JSpinner();
		sl_panelBooksB.putConstraint(SpringLayout.WEST, spinnerItems, 108, SpringLayout.WEST, panelBooksB);
		sl_panelBooksB.putConstraint(SpringLayout.EAST, spinnerItems, -6, SpringLayout.WEST, label_3);
		spinnerItems.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		sl_panelBooksB.putConstraint(SpringLayout.NORTH, spinnerItems, -2, SpringLayout.NORTH, label_3);
		panelBooksB.add(spinnerItems);

		JButton button = new JButton("Dodaj do bazy");
		sl_panelBooksB.putConstraint(SpringLayout.WEST, button, 53, SpringLayout.WEST, panelBooksB);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baseEditor.enterData(firstNameData.getText(), lastNameData.getText(), titleData.getText(),
				(Integer) spinnerItems.getValue(), "books");
				MyTableModel.updateTable();
				MyTableModel.fireTableDataChanged();
			}
		});
		sl_panelBooksB.putConstraint(SpringLayout.NORTH, button, 12, SpringLayout.SOUTH, spinnerItems);
		button.setBackground(SystemColor.textHighlight);
		panelBooksB.add(button);
		
		JLabel lblPanelDodawaniaNowej = new JLabel("Panel dodawania nowej ksi\u0105\u017Cki");
		sl_panelBooksB.putConstraint(SpringLayout.WEST, lblPanelDodawaniaNowej, 10, SpringLayout.WEST, panelBooksB);
		sl_panelBooksB.putConstraint(SpringLayout.NORTH, lblPanelDodawaniaNowej, 10, SpringLayout.NORTH, panelBooksB);
		panelBooksB.add(lblPanelDodawaniaNowej);
		
		firstNameData = new JTextField();
		sl_panelBooksB.putConstraint(SpringLayout.NORTH, firstNameData, 22, SpringLayout.SOUTH, lblPanelDodawaniaNowej);
		sl_panelBooksB.putConstraint(SpringLayout.WEST, firstNameData, 10, SpringLayout.WEST, panelBooksB);
		sl_panelBooksB.putConstraint(SpringLayout.EAST, firstNameData, -6, SpringLayout.WEST, label);
		panelBooksB.add(firstNameData);
		firstNameData.setColumns(10);
		
		lastNameData = new JTextField();
		sl_panelBooksB.putConstraint(SpringLayout.NORTH, lastNameData, 6, SpringLayout.SOUTH, firstNameData);
		sl_panelBooksB.putConstraint(SpringLayout.WEST, lastNameData, 10, SpringLayout.WEST, panelBooksB);
		sl_panelBooksB.putConstraint(SpringLayout.EAST, lastNameData, -6, SpringLayout.WEST, label_1);
		panelBooksB.add(lastNameData);
		lastNameData.setColumns(10);
		
		titleData = new JTextField();
		sl_panelBooksB.putConstraint(SpringLayout.NORTH, titleData, -3, SpringLayout.NORTH, label_2);
		sl_panelBooksB.putConstraint(SpringLayout.WEST, titleData, 0, SpringLayout.WEST, lblPanelDodawaniaNowej);
		sl_panelBooksB.putConstraint(SpringLayout.EAST, titleData, -6, SpringLayout.WEST, label_2);
		panelBooksB.add(titleData);
		titleData.setColumns(10);

		JPanel panelBooksC = new JPanel();
		panelCardBooks.add(panelBooksC, "panelBooksC");
		panelBooksC.setForeground(SystemColor.desktop);
		panelBooksC.setBorder(new LineBorder(Color.WHITE, 1, true));
		panelBooksC.setBackground(SystemColor.control);

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

		JButton btnZmien = new JButton("Zmie\u0144/Usu\u0144");
		btnZmien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (panelCardBooks.getLayout());
				cl.show(panelCardBooks, "panelBooksA");
			}
		});
		panelMenuBooks.add(btnZmien);

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (panelCardBooks.getLayout());
				cl.show(panelCardBooks, "panelBooksB");
			}
		});
		panelMenuBooks.add(btnDodaj);

		JButton btnWypozycz = new JButton("Wypo\u017Cycz");
		btnWypozycz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (panelCardBooks.getLayout());
				cl.show(panelCardBooks, "panelBooksC");
			}
		});
		panelMenuBooks.add(btnWypozycz);
	}
}
