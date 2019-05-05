import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.SwingConstants;

public class Okno {

	private JFrame frame;
	private JTable table;

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

		JPanel panel1 = new JPanel();
		tabbedPane.addTab("Dodawanie", null, panel1, null);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

		JLabel lblNewLabel = new JLabel("Autor");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(lblNewLabel);

		JTextPane authorData = new JTextPane();
		panel1.add(authorData);

		JLabel lblNewLabel_1 = new JLabel("Tytu\u0142");
		panel1.add(lblNewLabel_1);

		JTextPane titleData = new JTextPane();
		panel1.add(titleData);

		JLabel lblNewLabel_2 = new JLabel("Egzemplarze");
		panel1.add(lblNewLabel_2);

		JSpinner spinnerItems = new JSpinner();
		panel1.add(spinnerItems);

		JButton btnDodajDoBazy = new JButton("Dodaj do bazy");
		btnDodajDoBazy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				baseEditor.enterData(authorData.getText(), titleData.getText(), (Integer) spinnerItems.getValue());

			}
		});

		panel1.add(btnDodajDoBazy);
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("Wypo\u017Cyczanie", null, panel2, null);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));

		JLabel lblResult = new JLabel("New label");
		panel2.add(lblResult);

		table = new JTable();
		panel2.add(table);
	}

}
