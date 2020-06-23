import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Color;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class listy extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listy frame = new listy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Tworzenie okna.
	 */
	public listy() {
		setTitle("Listy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Tworzenie pola tekstowego
		textField = new JTextField();
		textField.setBounds(31, 193, 109, 23);
		contentPane.add(textField);
		textField.setColumns(10);
	
		//Tworzenie listy rozwijnej
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(230, 31, 109, 20);
		comboBox.setBackground(Color.WHITE);
		contentPane.add(comboBox);
		
		//Tworzenie paska przesuwania
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 32, 109, 87);
		contentPane.add(scrollPane);
	
		//Tworzenie listy
		final JList list = new JList();
		scrollPane.setViewportView(list);
		
		final DefaultListModel model = new DefaultListModel();
		
		String[] imiona = {"Jan", "Tomasz", "Wojciech", "Michał", "Paweł", "Marian", "Mateusz", "Piotr", "Zdzisław", "Marek"};
		
		for (int i = 0; i < imiona.length; i++)
		{
			model.addElement(imiona[i]);
		}
		
		list.setModel(model);

		//Tworzenie przycisku Dodaj i obsuga zdarzenia kliknięcia
		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				model.addElement(textField.getText());
				list.setModel(model);
			}
		});
		btnNewButton.setBounds(54, 144, 86, 23);
		contentPane.add(btnNewButton);
		
		//Tworzenie przycisku Przepisz i obsuga zdarzenia kliknięcia
		JButton btnNewButton_1 = new JButton("Przepisz");
		btnNewButton_1.setBounds(250, 144, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < list.getModel().getSize(); i++) {
		            Object item = list.getModel().getElementAt(i);
		            comboBox.addItem(item);
		        }
			}
		});
		contentPane.add(btnNewButton_1);
		
		
	}
}
