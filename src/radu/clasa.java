package radu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class clasa {
	static ArrayList<masina>masini=new ArrayList<>();
	static JTextArea infoArea,errorArea,removeArea,areaListaMasini;
	static JTextField textAn,textCuloare,textMarca,textPret,textFieldPass,textFieldUser,textRemove;
	static String user="radu";
	static String pass="radu";
	static JFrame frame,frameRemove,frameLista;
	static  JComboBox comboBox;
	
	public static void main(String[]args){
	initPass();
	initializareUI();
	initRemoveWindow();
	initListaMasini();
	masini.add(new masina("opel","rosu",2000,1000));
	masini.add(new masina("dacie","alba",1998,200));
	masini.add(new masina("audi","neagra",2010,11000));
    masini.add(new masina("bmw","albastra",2006,5000));
    masini.add(new masina("vw","galbena",2002,2500));
	
}

	public static void initListaMasini(){

		frameLista=new JFrame("Lista masini");
		frameLista.setLayout(null);
		frameLista.setSize(430,300);
		areaListaMasini=new JTextArea();
		areaListaMasini.setBounds(10,20,350,180);
		JScrollPane scroll=new JScrollPane(areaListaMasini,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(10,20,380,180);
		areaListaMasini.setLineWrap(true);
        areaListaMasini.setWrapStyleWord(true);
        areaListaMasini.setEditable(false);
        areaListaMasini.setVisible(true);
        
		//frameLista.add(areaListaMasini);
		frameLista.add(scroll);
		JButton button=new JButton("iesire");
		 button.setBounds(150,220,100,30);
		    button.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
			
				frameLista.setVisible(false);
					
				}
		    	
		    });
		    
		    JButton ordoneazaDupaPret =new JButton("Ordoneaza dupa pret");
		    ordoneazaDupaPret.setBounds(10,220,170,20);
		    ordoneazaDupaPret.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					
					for(int i=0;i<masini.size()-1;i++){
						for(int j=i+1;j<masini.size();j++){
							if(masini.get(i).getPret()>masini.get(j).getPret()){
								masina m=masini.get(i);
								masini.set(i,masini.get(j));
								masini.set(j,m);
							}
							
						}	
					}
					areaListaMasini.setText("");
					for(int i=0;i<masini.size();i++){
						areaListaMasini.setText(areaListaMasini.getText()+"\n"+"Masina "+masini.get(i).getMarca()
								+" are pretul "+masini.get(i).getPret()+" lei"+" culoarea "+masini.get(i).getCuloare()+
								" si anul "+masini.get(i).getAn()+"\n");
					}
					
				}
		    	
		    });
		    JButton ordoneazaDupaAn=new JButton("Ordineaza dupa an");
		    ordoneazaDupaAn.setBounds(10,250,170,20);
		    ordoneazaDupaAn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					for(int i=0;i<masini.size()-1;i++){
						for(int j=i+1;j<masini.size();j++){
							if(masini.get(i).getAn()>masini.get(j).getAn()){
								masina m=masini.get(i);
								masini.set(i,masini.get(j));
								masini.set(j,m);
							}
							
						}	
					}
					areaListaMasini.setText("");
					for(int i=0;i<masini.size();i++){
						areaListaMasini.setText(areaListaMasini.getText()+"\n"+"Masina "+masini.get(i).getMarca()
								+" are pretul "+masini.get(i).getPret()+" lei"+" culoarea "+masini.get(i).getCuloare()+
								" si anul "+masini.get(i).getAn()+"\n");
					}
				
					
				}
		    	
		    });
		frameLista.add(ordoneazaDupaAn);    
		frameLista.add(ordoneazaDupaPret);
		frameLista.add(button);
		frameLista.setResizable(false);
		Color c= new Color(.6f,.2f,.1f,.5f);
	    frameLista.getContentPane().setBackground(c);
	}
	public static void initRemoveWindow(){
         frameRemove=new JFrame("Stergere");
		frameRemove.setSize(250, 200);
		frameRemove.setLayout(null);
		JLabel numeMasina=new JLabel("Nume masina:");
		numeMasina.setBounds(10,30,100,20);
		textRemove= new JTextField();
		textRemove.setBounds(100, 30, 100, 20);
		JButton button=new JButton("Stergere");
		button.setBounds(60,60,100,20);
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<masini.size();i++){
					if(masini.get(i).getMarca().equals(textRemove.getText())){
						masini.remove(i);
						removeArea.setText("Masina a fost stearsa din baza de date !");
						return;
						
					}
				}
				removeArea.setText("Masina nu a fost gasita ");
			}	
	    });
		removeArea=new JTextArea();
		removeArea.setBounds(10,100,210,30);
		
		frameRemove.add(numeMasina);
		frameRemove.add(textRemove);
		frameRemove.add(button);
		frameRemove.add(removeArea);
		frameRemove.setResizable(false);
		Color c= new Color(.6f,.2f,.1f,.5f);
	    frameRemove.getContentPane().setBackground(c);
	}
	
public static void initPass(){
	JFrame frame2=new JFrame();
	frame2.setSize(250, 170);
	frame2.setLayout(null);
	JLabel labelUserName=new JLabel("Username:");
	labelUserName.setBounds(10,20,100,20);
	JLabel labelPassword=new JLabel("Password");
	labelPassword.setBounds(10,50,100,20);
	 textFieldUser =new JTextField();
	textFieldUser.setBounds(100,20,100,20);
   textFieldPass =new JTextField();
	textFieldPass.setBounds(100,50,100,20);
	JButton buttonLogin=new JButton("Login");
	buttonLogin.setBounds(60,100,100,20);
	buttonLogin.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
		
			if(textFieldUser.getText().equals(user)&&textFieldPass.getText().equals(pass)){
				frame.setVisible(true);
			}
					
			
		}	
    });
	frame2.add(labelUserName);
	frame2.add(labelPassword);
	frame2.add(textFieldUser);
	frame2.add(textFieldPass);
	frame2.add(buttonLogin);
	frame2.setVisible(true);
	frame2.setResizable(false);
	Color c= new Color(.6f,.2f,.1f,.5f);
    frame2.getContentPane().setBackground(c);
}
public static void initializareUI(){
     frame=new JFrame();
	frame.setSize(700, 500);
    frame.setLayout(null);
    Color c= new Color(.6f,.2f,.1f,.5f);
    frame.getContentPane().setBackground(c);
    JLabel searchLabel=new JLabel("Cautare");
    searchLabel.setBounds(5, 50, 150, 20);
    
    
    JTextField searchField=new JTextField();
    searchField.setBounds(200, 50,100,20);
    
    String[] s={"marca","pret"};
    comboBox= new JComboBox(s);
    comboBox.setBounds(80,50,100,20);
    comboBox.setSelectedIndex(0);
    
    
    JButton searchButton=new JButton("search");
    searchButton.setBounds(50, 90, 100, 20);
    searchButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			if(comboBox.getSelectedItem().equals("marca")){
		
				String marca=searchField.getText();
				
				for(int i=0;i<masini.size();i++){
					if(masini.get(i).getMarca().equals(marca)){
						infoArea.setText("Masina "+masini.get(i).getMarca()+" are : \n "+"Anul : "+masini.get(i).getAn()+"\n"+
					"Culoare : "+masini.get(i).getCuloare()+"\n"+"Pretul : "+masini.get(i).getPret()+" Lei");
					}
				}
			}else {
				try{
					int pret=Integer.parseInt(searchField.getText());
					for(int i=0;i<masini.size();i++){
						if(masini.get(i).getPret()==pret){
							infoArea.setText("Masina "+masini.get(i).getMarca()+" are : \n "+"Anul : "+masini.get(i).getAn()+"\n"+
									"Culoare : "+masini.get(i).getCuloare()+"\n"+"Pretul : "+masini.get(i).getPret()+" Lei");
						}
					}	
				}catch(Exception ex){
					
				}
				
			}
		
					
			
		}	
    });
    JButton removeButton=new JButton("remove");
    removeButton.setBounds(50, 120, 100, 20);
    removeButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			frameRemove.setVisible(true);
		}	
    });
    errorArea=new JTextArea();
    errorArea.setBounds(300, 335, 350, 20);
    errorArea.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    
     infoArea=new JTextArea();
    infoArea.setBounds(300, 100, 350, 200);
    infoArea.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    
    JLabel infoLabel=new JLabel("Informatii");
    infoLabel.setFont(new Font("Arial",Font.BOLD,15));
    infoLabel.setBounds(455,50,100, 20);
    
    JLabel labelAdaugare=new JLabel("Inregistrari");
    labelAdaugare.setBounds(70, 150, 100, 20);
    
    JLabel labelMarca =new JLabel("Marca");
    labelMarca.setBounds(30, 200, 100, 20);
    
     textMarca=new JTextField();
    textMarca.setBounds(100, 200, 100, 20);
    
    JLabel labelPret=new JLabel("Pret");	
    labelPret.setBounds(30, 250, 100, 20);
    
    textPret=new JTextField();
    textPret.setBounds(100, 250, 100, 20);
    
    JLabel labelCuloare=new JLabel("Culoare");
    labelCuloare.setBounds(30, 300, 100, 20);

     textCuloare=new JTextField();
    textCuloare.setBounds(100, 300, 100, 20);
    
    JLabel labelAn=new JLabel("Anul");
    labelAn.setBounds(30, 350, 100, 20);
    
    textAn= new JTextField();
    textAn.setBounds(100, 350, 100, 20);
    
    JButton addButton=new JButton("Adaugare");
    addButton.setBounds(50, 400, 100, 30);
    addButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String textDat=textAn.getText();
			for(int i=0;i<textDat.length();i++){
				if(Character.isDigit(textDat.charAt(i))){
					
				}else{
					errorArea.setText("Datele introduse sunt gresite");
				return;
				}
			}
			
			textDat=textPret.getText();
			for(int i=0;i<textDat.length();i++){
				if(Character.isDigit(textDat.charAt(i))){
					
				}else{
					errorArea.setText("Pretul nu poate sa contina litere");
				return;
				}
			}
			textDat=textCuloare.getText();
			for(int i=0;i<textDat.length();i++){
				if(Character.isAlphabetic(textDat.charAt(i))){
					
				}else{
					errorArea.setText("Culoarea nu poate sa contine cifre");
				return;
				}
			}
			
			masini.add(new masina(textMarca.getText(),textCuloare.getText(),Integer.parseInt(textAn.getText()),Integer.parseInt(textPret.getText())));
			errorArea.setText("Masina adaugata cu succes");
		
		}
    });
    
    JButton exitButton=new JButton("EXIT");
    exitButton.setBounds(410,400,100,30);
    exitButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			System.exit(1);
			
		}
    	
    });
    
    JButton lista=new JButton("Lista masini");
    lista.setBounds(230,400,150,30);
    lista.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			areaListaMasini.setText("");
		for(int i=0;i<masini.size();i++){
			areaListaMasini.setText(areaListaMasini.getText()+"\n"+"Masina "+masini.get(i).getMarca()
					+" are pretul "+masini.get(i).getPret()+" lei"+" culoarea "+masini.get(i).getCuloare()+
					" si anul "+masini.get(i).getAn()+"\n");
		}
		frameLista.setVisible(true);
			
		}
    	
    });
    
    frame.add(lista);
    frame.add(comboBox);
    frame.add(labelAdaugare);
  //  frame.setVisible(true);
    frame.add(searchLabel);
    frame.add(searchField);
	frame.add(searchButton);
    frame.add(errorArea);
	frame.add(infoArea);
	frame.add(infoLabel);
	frame.add(labelMarca);
	frame.add(textMarca);
    frame.add(labelPret);
    frame.add(textPret);
    frame.add(labelCuloare);
    frame.add(textCuloare);
    frame.add(labelAn);
    frame.add(textAn);
    frame.add(addButton);
    frame.add(exitButton);
    frame.add(removeButton);
    frame.setResizable(false);
    
    
    
}
}