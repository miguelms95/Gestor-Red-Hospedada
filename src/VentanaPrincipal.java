import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txNombreRed;
	private JPasswordField passRed;
	JCheckBox chckbxMostrarPassword;
	JButton btCrearRed;
	JTextArea textAreaCheck;
	JButton btnSalir;
	JButton btComprobarRed;
	JButton btFinalizarRed;
	JButton btIniciarRed;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				txNombreRed.selectAll();
				txNombreRed.grabFocus();
			}
		});
		setTitle("Generador de Red Wifi Local");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 434);
		setMinimumSize(new Dimension(537, 387));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnGenerador = new JMenu("Generador");
		menuBar.add(mnGenerador);
		
		JMenuItem mntmCrearRedLocal = new JMenuItem("Crear red local");
		mntmCrearRedLocal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmCrearRedLocal.setMnemonic('c');
		mnGenerador.add(mntmCrearRedLocal);
		
		JMenuItem mntmIniciarRedLocal = new JMenuItem("Iniciar red local");
		mntmIniciarRedLocal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		mntmIniciarRedLocal.setMnemonic('i');
		mnGenerador.add(mntmIniciarRedLocal);
		
		JMenuItem mntmFinalizarRedLocal = new JMenuItem("Finalizar red local");
		mntmFinalizarRedLocal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mnGenerador.add(mntmFinalizarRedLocal);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setMnemonic('s');
		mnGenerador.add(mntmSalir);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Gestor red local v1.0\nDesarrollado por Miguel Martínez Serrano\nwww.miguelms.es\nTwitter @miguelms_es");
			}
		});
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnCentro = new JPanel();
		contentPane.add(pnCentro, BorderLayout.NORTH);
		pnCentro.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		pnCentro.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{109, 105, 145, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 20, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lbSpace = new JLabel("");
		GridBagConstraints gbc_lbSpace = new GridBagConstraints();
		gbc_lbSpace.insets = new Insets(0, 0, 5, 5);
		gbc_lbSpace.gridx = 1;
		gbc_lbSpace.gridy = 0;
		panel.add(lbSpace, gbc_lbSpace);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la red wifi:");
		lblNombreDeLa.setDisplayedMnemonic('n');
		lblNombreDeLa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNombreDeLa = new GridBagConstraints();
		gbc_lblNombreDeLa.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDeLa.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeLa.gridx = 1;
		gbc_lblNombreDeLa.gridy = 1;
		panel.add(lblNombreDeLa, gbc_lblNombreDeLa);
		
		txNombreRed = new JTextField();
		lblNombreDeLa.setLabelFor(txNombreRed);
		txNombreRed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txNombreRed = new GridBagConstraints();
		gbc_txNombreRed.fill = GridBagConstraints.BOTH;
		gbc_txNombreRed.insets = new Insets(0, 0, 5, 5);
		gbc_txNombreRed.anchor = GridBagConstraints.NORTHWEST;
		gbc_txNombreRed.gridx = 2;
		gbc_txNombreRed.gridy = 1;
		panel.add(txNombreRed, gbc_txNombreRed);
		txNombreRed.setText("miredlocal");
		txNombreRed.setColumns(10);
		
		JLabel lbContrasena = new JLabel("Contrase\u00F1a:");
		lbContrasena.setDisplayedMnemonic('o');
		lbContrasena.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lbContrasena = new GridBagConstraints();
		gbc_lbContrasena.anchor = GridBagConstraints.EAST;
		gbc_lbContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_lbContrasena.gridx = 1;
		gbc_lbContrasena.gridy = 2;
		panel.add(lbContrasena, gbc_lbContrasena);
		
		passRed = new JPasswordField();
		lbContrasena.setLabelFor(passRed);
		passRed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passRed.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				mostrarPassword();
			}
		});
		GridBagConstraints gbc_passRed = new GridBagConstraints();
		gbc_passRed.insets = new Insets(0, 0, 5, 5);
		gbc_passRed.fill = GridBagConstraints.HORIZONTAL;
		gbc_passRed.gridx = 2;
		gbc_passRed.gridy = 2;
		panel.add(passRed, gbc_passRed);
		
		chckbxMostrarPassword = new JCheckBox("Mostrar contrase\u00F1a");
		chckbxMostrarPassword.setMnemonic('m');
		chckbxMostrarPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxMostrarPassword.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				mostrarPassword();
			}
		});
		GridBagConstraints gbc_chckbxMostrarPassword = new GridBagConstraints();
		gbc_chckbxMostrarPassword.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMostrarPassword.gridx = 1;
		gbc_chckbxMostrarPassword.gridy = 3;
		panel.add(chckbxMostrarPassword, gbc_chckbxMostrarPassword);
		
		JPanel pnSouth = new JPanel();
		pnCentro.add(pnSouth, BorderLayout.SOUTH);
		
		btCrearRed = new JButton("Crear red local");
		btCrearRed.setMnemonic('c');
		pnSouth.add(btCrearRed);
		btCrearRed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btIniciarRed = new JButton("Iniciar red local");
		btIniciarRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				execute("start");
			}
		});
		btIniciarRed.setMnemonic('i');
		btIniciarRed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnSouth.add(btIniciarRed);
		
		btFinalizarRed = new JButton("Finalizar red local");
		btFinalizarRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				execute("stop");
				System.err.println("STOP");
			}
		});
		btFinalizarRed.setMnemonic('f');
		pnSouth.add(btFinalizarRed);
		btFinalizarRed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btCrearRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(passRed.getPassword().toString().equals("hola"))
					System.out.println("BIEN");
				execute("create");
			}
		});
		
		JPanel pnTop = new JPanel();
		pnCentro.add(pnTop, BorderLayout.NORTH);
		
		JLabel lbTitulo = new JLabel("Generador de red wifi local");
		lbTitulo.setForeground(Color.DARK_GRAY);
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnTop.add(lbTitulo);
		
		JPanel pnCheck = new JPanel();
		contentPane.add(pnCheck, BorderLayout.CENTER);
		pnCheck.setLayout(new BorderLayout(0, 0));
		
		JPanel pnTxArea = new JPanel();
		pnCheck.add(pnTxArea);
		pnTxArea.setLayout(new BorderLayout(0, 0));
		textAreaCheck = new JTextArea();
		textAreaCheck.setLineWrap(true);
		textAreaCheck.setFont(new Font("Monospaced", Font.BOLD, 13));
		textAreaCheck.setForeground(Color.WHITE);
		textAreaCheck.setBackground(Color.BLACK);
		textAreaCheck.setEditable(false);
		textAreaCheck.setWrapStyleWord(true);
		textAreaCheck.setRows(5);
		
		JScrollPane scrollPane = new JScrollPane();
		pnTxArea.add(scrollPane);
		scrollPane.setViewportView(textAreaCheck);
		
		JPanel panel_2 = new JPanel();
		pnTxArea.add(panel_2, BorderLayout.EAST);
		
		btComprobarRed = new JButton("Comprobar red");
		btComprobarRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				execute("check");
			}
		});
		btComprobarRed.setMnemonic('p');
		btComprobarRed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(btComprobarRed);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		pnCheck.add(panel_1, BorderLayout.SOUTH);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setMnemonic('s');
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalir.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnSalir);
	}

	private void mostrarPassword(){
		if(chckbxMostrarPassword.isSelected()){
			passRed.setEchoChar((char) 0);
		}else{
			passRed.setEchoChar('\u25CF');
		}
	}
	private void execute(String comandoEjecutar){
		
		String comando = "";
		String comandoImprimir = "";
		switch (comandoEjecutar) {
		case "create":
			MessageDigest m = null;
			try {
				m = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String pass = String.valueOf(passRed.getPassword());
			String print = Base64.getEncoder().encodeToString(m.digest(pass.getBytes()));
			comandoImprimir = "netsh wlan set hostednetwork mode=allow ssid="+txNombreRed.getText()+" key="+print.substring(0, 12)+" (encryted) keyUsage=persistent";
			comando = "netsh wlan set hostednetwork mode=allow ssid="+txNombreRed.getText()+" key="+pass+" keyUsage=persistent";
			break;
		case "stop":
			comando = "netsh wlan stop hostednetwork";
			break;
		case "start":
			comando = "netsh wlan start hostednetwork";
			break;
		case "check":
			comando = "netsh wlan show hostednetwork";
			break;
		default:
			break;
		}
		
		if(comandoEjecutar != "create")
			comandoImprimir = comando;
		//String comando = "start chrome";
		StringBuffer output = null;
		
		try {
			output = new StringBuffer();
			Process p = Runtime.getRuntime().exec("cmd /c "+comando);
			p.waitFor();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(),"CP437"));
			String line = "";
			while ((line= reader.readLine())!=null){
				output.append(line + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textAreaCheck.setText(textAreaCheck.getText()+"--> " + comandoImprimir +"\n");
		String respuesta = output.toString();
		byte[] ptext;
		try {
			ptext = respuesta.getBytes("UTF-8");
			textAreaCheck.append(new String(ptext,Charset.forName("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			textAreaCheck.append(e.getStackTrace().toString());
		}
		
	}
}
