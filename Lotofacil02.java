import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Lotofacil02 extends JFrame implements ActionListener {

    public JPanel JJLotofacil = new JPanel();
    public JLabel JLabel = new JLabel();
    private JButton button0a100 = new JButton("Aposta de 0 a 100");
    private JButton buttonAaZ = new JButton("Aposta de a a Z");
    private JButton buttonparouimpar = new JButton("Aposta em par ou impar");
    private JButton buttonsair = new JButton("Sair");


    public Lotofacil02() {

        // Construtor
        this.setTitle("LOTOFÁCIL");
        setTitle("Lotofácil"); // Título da janela
        // Cria um JLabel para o título centralizado
        JLabel titleLabel = new JLabel("Lotofácil", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Consolos", Font.TYPE1_FONT, 20)); // Define a fonte e tamanho do título
        // Adiciona o JLabel ao norte do JFrame para centralizar
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        this.setSize(400, 250);
        JJLotofacil.setLayout(new FlowLayout(FlowLayout.CENTER,100, 10));
        JJLotofacil.setBackground(new Color(255,255,255));
        setResizable(false);

        Dimension buttonSize = new Dimension(200, 30); // Configurar o tamanho dos botões.
        button0a100.setPreferredSize(buttonSize);
        buttonAaZ.setPreferredSize(buttonSize);
        buttonparouimpar.setPreferredSize(buttonSize);
        buttonsair.setPreferredSize(buttonSize);

        button0a100.addActionListener(this);
        JJLotofacil.add(button0a100);

        buttonAaZ.addActionListener(this);
        JJLotofacil.add(buttonAaZ);

        buttonparouimpar.addActionListener(this);
        JJLotofacil.add(buttonparouimpar);

        buttonsair.addActionListener(this);
        JJLotofacil.add(buttonsair);
        button0a100.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {

    }
        });
        this.getContentPane().add(JJLotofacil);
        this.setLocationRelativeTo(null); // Centralizar Janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir Janela

    }
    private void apostarDe0a100() {
        ImageIcon icon = new ImageIcon("Lotofacil.png");
        Object numeroApostado = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:", "Aposta 1", JOptionPane.INFORMATION_MESSAGE, icon, null, "");
        int numeroApostadoInt = Integer.parseInt(numeroApostado.toString());

        if (numeroApostadoInt >= 0 && numeroApostadoInt <= 100) {
            Random random = new Random();
            int numeroSorteado = random.nextInt(101);
            if (numeroApostadoInt == numeroSorteado) {
                JOptionPane.showMessageDialog(null, "Você ganhou R$1.000,00 reais.");
            } else {
                JOptionPane.showMessageDialog(null, "Que pena! O número sorteado foi :  " + numeroSorteado);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
        }
    }
    private void apostarDeAaZ() {
        ImageIcon icon = new ImageIcon("Lotofacil.png");
        Object letraApostada = JOptionPane.showInputDialog(null, "Digite uma letra de A a Z", "Aposta 2", JOptionPane.INFORMATION_MESSAGE, icon, null, "");
        String letraApostadaString = (String)letraApostada;

        if (letraApostadaString.length() == 1 && Character.isLetter(letraApostadaString.charAt(0))) {
            char letraPremiada = 'J'; //E um exemplo de letra premiada.
            char letraApostadaUpper = Character.toUpperCase(letraApostadaString.charAt(0));
            if (letraApostadaUpper == letraPremiada) {
                JOptionPane.showMessageDialog(null, "Você ganhou R$500,00 reais.");
            } else {
                JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraPremiada);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Aposta invalida.");
        }
    }

    private void apostarParouImpar() {
        ImageIcon icon = new ImageIcon("Lotofacil.png");
        Object numeroDigitado = JOptionPane.showInputDialog(null, "Digite um número inteiro", "Aposta 3", JOptionPane.INFORMATION_MESSAGE, icon, null, "");
        int numeroDigitadoInt = Integer.parseInt(numeroDigitado.toString());

        if (numeroDigitadoInt % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00");
        }else{
            JOptionPane.showMessageDialog(null,"Que pena! O número digitado é impar e a premiação foi números pares.");

        }
    }
    public static void main (String [] args) {
        new Lotofacil02();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button0a100) {
            apostarDe0a100();
        } else if (e.getSource() == buttonAaZ) {
            apostarDeAaZ();
        } else if (e.getSource() == buttonparouimpar) {
            apostarParouImpar();
        } else if (e.getSource() == buttonsair) {
            System.exit(0);

        }


    }


}

