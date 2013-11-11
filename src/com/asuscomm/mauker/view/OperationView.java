package com.asuscomm.mauker.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import com.asuscomm.mauker.Definitions;
import com.asuscomm.mauker.control.OperationControlInterface;
import com.asuscomm.mauker.model.MusicBoxModelInterface;

public class OperationView implements ActionListener {

	private static final String JUKEBOX_HEADER = "JukeBox! - Versão 1.0";
	private OperationControlInterface control;
	private MusicBoxModelInterface model;
	
	private JFrame mainFrame;
	
	private JPanel mainPanel;
	private JPanel headerPanel;
	private JPanel bodyPanel;
	private JPanel musicPanel;
	private JScrollPane treePanel;
	private JPanel controlPanel;
	private JScrollPane messagePanel;
	private JPanel footerPanel;
	private JPanel moneyHeaderPanel;
	private JPanel coinsPanel;
	private JPanel cashPanel;
	private JPanel moneyPanel;
	private JPanel playPanel;
	
	
	private BoxLayout mainLayout;
	private BoxLayout headerLayout;
	private BoxLayout bodyLayout;
	private BoxLayout controlLayout;
	private BoxLayout footerLayout;
	private BoxLayout moneyHeaderLayout;
	private BoxLayout musicLayout;
	private BoxLayout moneyLayout;
	private GridLayout coinsLayout;
	private GridLayout cashLayout;
	private GridLayout playLayout;

	private JLabel headerLabel;
	private JLabel moneyLabel;
	private JLabel coinsLabel;
	private JLabel cashLabel;
	
	private JTextArea messageArea;
	
	private JButton playButton;
	
	private JButton _25CentsButton;
	private JButton _50CentsButton;
	private JButton _1RealButton;
	
	private JButton _2ReaisButton;
	private JButton _5ReaisButton;
	private JButton _10ReaisButton;
	
	private JTree tree;
	
	private JMenuBar menuBar;
	
	private JMenu file;
	private JMenu help;
	
	private JMenuItem maintenanceMode;
	private JMenuItem aboutJukebox;
	
	private Object[] hierarchy = {"Musicas",
			new Object[] { "Rock",
							"Musica 1",
							"Musica 2",
							"Musica 3",
							"Musica 4",
							"Musica 5"
			}, new Object[] { "Pop",
							"Musica 1",
							"Musica 2",
							"Musica 3",
							"Musica 4",
							"Musica 5"
			   },
			   
			   new Object[] { "House",
							"Musica 1",
							"Musica 2",
							"Musica 3",
							"Musica 4",
							"Musica 5"
			
	},
				new Object[] { "MPB",
						"Musica 1",
						"Musica 2",
						"Musica 3",
						"Musica 4",
						"Musica 5"
	}
};

	
	public OperationView(OperationControlInterface control, MusicBoxModelInterface model){
		this.control = control;
		this.model = model;
	}
	
	public void createView(){
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
		    e.printStackTrace();
		} catch (IllegalAccessException e) {
		    e.printStackTrace();
		}
		
		mainFrame = new JFrame("Jukebox!");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int inset = 50;
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setBounds(inset,inset, screenSize.width/2 - inset*2, 
				screenSize.height/2 - inset*2);
		
		createPanels();
		createLabels();
		createTextArea();
		createButtons();
		createMenu();
		
		// Criando a lista da JTree
		DefaultMutableTreeNode root = processHierarchy(hierarchy);
		tree = new JTree(root);
		
		MouseListener ml = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				final int selRow = tree.getRowForLocation(e.getX(), e.getY());
				
				if (selRow != -1){
					if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2){
						final TreePath path = tree.getPathForLocation(e.getX(), e.getY());
						new Thread(){
							@Override
							public void run(){
								treeItemSelected(selRow, path);
							}
						}.start();
					}
				}
			} // Fim mousePressed()
		};
		
		tree.addMouseListener(ml);
		
		treePanel = new JScrollPane(tree);
		//treePanel.setPreferredSize(new Dimension(screenSize.width/4,screenSize.height/4));
		//musicPanel.add(treePanel);
		
		mainFrame.setJMenuBar(menuBar);
		
		// Organizando os elementos na tela
		headerPanel.add(Box.createHorizontalGlue());
		headerPanel.add(headerLabel);
		headerPanel.add(Box.createHorizontalGlue());
		
		bodyPanel.add(Box.createHorizontalGlue());
		bodyPanel.add(treePanel);
		bodyPanel.add(Box.createHorizontalStrut(10));
		bodyPanel.add(controlPanel);
		bodyPanel.add(Box.createHorizontalGlue());
		
		messagePanel = new JScrollPane(messageArea);
		
		playPanel.add(Box.createHorizontalGlue());
		playPanel.add(playButton);
		playPanel.add(Box.createHorizontalGlue());
		
		controlPanel.add(messagePanel);
		controlPanel.add(Box.createVerticalStrut(10));
		controlPanel.add(playPanel);
		
		moneyHeaderPanel.add(Box.createHorizontalGlue());
		moneyHeaderPanel.add(moneyLabel);
		moneyHeaderPanel.add(Box.createHorizontalGlue());
		
		coinsPanel.add(coinsLabel);
		coinsPanel.add(_25CentsButton);
		coinsPanel.add(_50CentsButton);
		coinsPanel.add(_1RealButton);
		
		cashPanel.add(cashLabel);
		cashPanel.add(_2ReaisButton);
		cashPanel.add(_5ReaisButton);
		cashPanel.add(_10ReaisButton);
		
		moneyPanel.add(moneyHeaderPanel);
		moneyPanel.add(Box.createVerticalStrut(5));
		moneyPanel.add(cashPanel);
		moneyPanel.add(Box.createVerticalStrut(5));
		moneyPanel.add(coinsPanel);
		
		footerPanel.add(Box.createHorizontalGlue());
		footerPanel.add(moneyPanel);
		footerPanel.add(Box.createHorizontalGlue());
		
		mainPanel.add(Box.createVerticalStrut(5));
		mainPanel.add(headerPanel);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(bodyPanel);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(footerPanel);
		mainPanel.add(Box.createVerticalStrut(5));
		
		//mainFrame.setMaximumSize(new Dimension(200,200));
		
		mainFrame.setContentPane(mainPanel);	
	}
	
	public void showGUI(){
		mainFrame.setVisible(true);
	}
	
	private void createPanels(){
		mainPanel = new JPanel();
		headerPanel = new JPanel();
		bodyPanel = new JPanel();
		musicPanel = new JPanel();
		controlPanel = new JPanel();
		footerPanel = new JPanel();
		moneyHeaderPanel = new JPanel();
		coinsPanel = new JPanel();
		cashPanel = new JPanel();
		moneyPanel = new JPanel();
		playPanel = new JPanel();
		
		mainLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		headerLayout = new BoxLayout(headerPanel, BoxLayout.X_AXIS);
		bodyLayout = new BoxLayout(bodyPanel, BoxLayout.X_AXIS);
		musicLayout = new BoxLayout(musicPanel,BoxLayout.X_AXIS);
		controlLayout = new BoxLayout(controlPanel, BoxLayout.Y_AXIS);
		footerLayout = new BoxLayout(footerPanel, BoxLayout.X_AXIS);
		moneyHeaderLayout = new BoxLayout(moneyHeaderPanel, BoxLayout.X_AXIS);
		moneyLayout = new BoxLayout(moneyPanel,BoxLayout.Y_AXIS);
		coinsLayout = new GridLayout(1,0);
		cashLayout = new GridLayout(1,0);
		playLayout = new GridLayout(1,3);
		
		
		mainPanel.setLayout(mainLayout);
		headerPanel.setLayout(headerLayout);
		bodyPanel.setLayout(bodyLayout);
		musicPanel.setLayout(musicLayout);
		controlPanel.setLayout(controlLayout);
		footerPanel.setLayout(footerLayout);
		moneyHeaderPanel.setLayout(moneyHeaderLayout);
		moneyPanel.setLayout(moneyLayout);
		coinsPanel.setLayout(coinsLayout);
		cashPanel.setLayout(cashLayout);
		playPanel.setLayout(playLayout);
		
		playPanel.setMaximumSize(new Dimension(600,35));
		
		coinsPanel.setMaximumSize(new Dimension(800,50));
		cashPanel.setMaximumSize(new Dimension(800,50));
	}
	
	private void createLabels(){
		headerLabel = new JLabel("JukeBox!");
		moneyLabel = new JLabel("Pagamento");
		coinsLabel = new JLabel("Moedas: ");
		cashLabel = new JLabel("Cédulas: ");
		
		headerLabel.setFont(headerLabel.getFont().deriveFont(Font.BOLD,16));
		moneyLabel.setFont(headerLabel.getFont().deriveFont(Font.BOLD,16));
		
		coinsLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/24/coins.png")));
		cashLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/24/cash.png")));
		
		coinsLabel.setFont(headerLabel.getFont().deriveFont(Font.BOLD,12));
		cashLabel.setFont(headerLabel.getFont().deriveFont(Font.BOLD,12));
	}
	
	private void createTextArea(){
		messageArea = new JTextArea(JUKEBOX_HEADER);
		
		messageArea.setEditable(false);
	}
	
	private void createButtons(){
		playButton = new JButton("Play!");
		_25CentsButton = new JButton("25 cents");
		_50CentsButton = new JButton("50 cents");
		_1RealButton = new JButton("1 real");
		_2ReaisButton = new JButton("2 reais");
		_5ReaisButton = new JButton("5 reais");
		_10ReaisButton = new JButton("10 reais");
		
		playButton.setFocusable(false);
		_25CentsButton.setFocusable(false);
		_50CentsButton.setFocusable(false);
		_1RealButton.setFocusable(false);
		_2ReaisButton.setFocusable(false);
		_5ReaisButton.setFocusable(false);
		_10ReaisButton.setFocusable(false);
		
		
		playButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/16/play.png")));
		
		playButton.addActionListener(this);
		_25CentsButton.addActionListener(this);
		_50CentsButton.addActionListener(this);
		_1RealButton.addActionListener(this);
		_2ReaisButton.addActionListener(this);
		_5ReaisButton.addActionListener(this);
		_10ReaisButton.addActionListener(this);
		
		playButton.setEnabled(false);
		
	}
	
	private void createMenu(){
		menuBar = new JMenuBar();
		file = new JMenu("Arquivo");
		help = new JMenu("Ajuda");
		
		maintenanceMode = new JMenuItem("Módulo de Manutenção");
		aboutJukebox = new JMenuItem("Sobre JukeBox!");
		
		maintenanceMode.addActionListener(this);
		aboutJukebox.addActionListener(this);
		
		menuBar.add(file);
		menuBar.add(help);
		
		file.add(maintenanceMode);
		help.add(aboutJukebox);
	}

	
	private void printTotalAmount(){
		messageArea.append("\nTotal inserido: R$");
		messageArea.append(control.getTotalMoney());
		
		playButton.setEnabled(true);
	}
	
	private void doPlay(){
		// TODO
		
		messageArea.setText(JUKEBOX_HEADER);
		
		playButton.setEnabled(false);
	}
	
	/**
	 * processHierarchy() - Metodo que processa um Array de objetos para montar a arvore.
	 * @param hierarchy
	 * @return node
	 */
	private DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
	    DefaultMutableTreeNode node =
	      new DefaultMutableTreeNode(hierarchy[0]);
	    DefaultMutableTreeNode child;
	    for(int i=1; i<hierarchy.length; i++) {
	      Object nodeSpecifier = hierarchy[i];
	      if (nodeSpecifier instanceof Object[])  // No com filho
	        child = processHierarchy((Object[])nodeSpecifier);
	      else
	        child = new DefaultMutableTreeNode(nodeSpecifier); // Folha
	      node.add(child);
	    }
	    return(node);
	  }
	
	/**
	 * treeItemSelected - Metodo que trata as selecoes da arvore, abrindo as 
	 * janelas adequadas dentro do JDesktopPane
	 * @author mauker
	 * @param selRow - A linha selecionada.
	 * @param path - O caminho do item selecionado.
	 */
	private void treeItemSelected (int selRow, TreePath path){
		//System.out.println(selRow);
		//System.out.println(path.getPathComponent(0));
		
		//final String scenario = path.getPathComponent(0).toString();
		String sel = path.getLastPathComponent().toString();
		
		System.out.println(sel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o.equals(playButton)){
			doPlay();
		}
		else if (o.equals(_25CentsButton)){
			control.insertCoin(Definitions._25CENTS);
			printTotalAmount();
		}
		else if (o.equals(_50CentsButton)){
			control.insertCoin(Definitions._50CENTS);
			printTotalAmount();
		}
		else if (o.equals(_1RealButton)){
			control.insertCoin(Definitions._1REAL);
			printTotalAmount();
		}
		else if (o.equals(_2ReaisButton)){
			control.insertCash(Definitions._2REAIS);
			printTotalAmount();
		}
		else if (o.equals(_5ReaisButton)){
			control.insertCash(Definitions._5REAIS);
			printTotalAmount();
		}
		else if (o.equals(_10ReaisButton)){
			control.insertCash(Definitions._10REAIS);
			printTotalAmount();
		}
		else if (o.equals(maintenanceMode)){
			// TODO
		}
		else if (o.equals(aboutJukebox)){
			// TODO
		}
	}
	
}
