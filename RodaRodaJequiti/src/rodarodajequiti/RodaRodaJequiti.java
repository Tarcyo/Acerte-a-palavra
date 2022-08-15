package rodarodajequiti;

import java.util.Random;
import javax.swing.JOptionPane;

public class RodaRodaJequiti {// <-- meu jogo!!!!!!!!!! ;)

	// linhas= topicos; posiÃ§oes= palavras;
	static String[][] banco = { // <--- BANCO DE PALAVRAS;
			{ "abacate", "banana", "maÃ§Ã£", "abacaxi", "pera", "genipapo", "uva", "amora", "framboesa", "laranja",
					"melancia", "morango", "pequi", "cereja", "tangerina", "mamÃ£o", "limÃ£o", "guarana", "caju",
					"goiaba", "coco", "roma", "pessego", "nectarina", "ameixa", "kiwi", "caqui", "carambola", "abobora",
					"azeitona", "oliva", "ameixa", "acerola", "aÃ§ai", "abrico", "ananas", "cambuca", "damasco", "figo",
					"groselha", "jujuba", "jatoba", "jaca", "maracuja", "noz", "pinha" },
			{ "goiania", "caturai", "inhumas", "goianira", "brazabrantes", "novaveneza", "valparaiso", "saopaulo",
					"tocatins", "luziania", "riodejaneiro", "senadorcanedo", "brasilia", "rosilandia", "aracu",
					"uruacu" },
			{ "chapeu", "lapis", "caneta", "lupa", "computador", "geladeira", "fogao", "liquidificador", "garrafa",
					"lata", "mesa", "vazo", "chinelo", "sapato", "tenis", "bone", "ratoeira", "microondas", "oculos" },
			{ "carrro", "carroca", "carroagem", "aviao", "camimhao", "onibus", "cavalo", "barco", "navio", "canoa",
					"helicoptero", "carrodeboi", "pe", "moto", "bicicleta", "motocicleta" },
			{ "papagaio", "urso", "galinha", "lagartixa", "tubarao", "dinossauro", "leao", "onÃ§a", "periquito",
					"salamandra", "peixe", "urubu", "gaviao", "minhoca", "coral", "cobra", "esponja", "gaivota",
					"tucano", "pavao" },
			{ "liliane", "kariton", "silvia", "darlene", "danila", "rogerio", "paulo", "joseronaldo", "ronaldo",
					"nilson", "cleiton", "daniel", "monica", "kemuel", "mariaangelica", "henrique", "weslei", "leticia",
					"marcelo", "adel", "joao" } };

	static String categoria[] = { "Frutas", "Cidades", "Objetos", "Trasportes", "Animais", "Professores" };// <--AS
																											// CATEGORIAS;

	// //
	// <-- variaveis muito impotantes para o cÃ³digo(nÃ£o vale apena entrar em
	// detalhes;
	static String PE[];
	static boolean A = true;
	static Random r = new Random();
	static String topico;
	static String[] PE2;
	static int acertos = 0;
	static int npren = 1312;
	static char ld;
	static String palavra1, palavra2, palavra3;
	static String letrasEscolhidas = "";
	static String[] v;
	static String ld0 = "";
	static int pos = 0;
	static int vidas = 5;

	public static void main(String[] args) {// comeÃ§a a execuÃ§Ã£o;
		EscolheAsPalavras();
		Tela(PE2);
	}

	//
	public static void EscolheAsPalavras() {// <-- SORTEIA AS AS CATEGORIAS PALAVRAS VERIFICANDO SE ELAS JÃ FORAm
											// SORTEADAS;;
		int l = r.nextInt(banco.length);// SORTEIA A CATEGORIA;
		topico = categoria[l];
		PE = new String[3];
		for (int c = 0; c <= 2; c++) {
			String palavra = banco[l][r.nextInt(banco[l].length)];
			while (verifica(palavra)) {// <-- VERIFICAÃ‡ÃƒO
				palavra = banco[l][r.nextInt(banco[l].length)];
			}
			PE[c] = palavra;// <-- PALAVRAS ESCOLHIDA E VERIFICADAS

		}
		clonar();// PEDE PARA CLONAR;

	}

	public static boolean verifica(String palavra) {// <-- VERIFICA SE A UMA PALAVRA JÃ FOI SORTEADA RETORNANDO UM VALOR
													// LÃ“GICO;
		for (int i = 0; i < PE.length; i++) {
			if (palavra.equals(PE[i])) {
				return true;
			}
		}
		return false;
	}

	public static void clonar() {// <--- CRIA UM VETOR ESPELHO DAS PALAVRAS ESCOLHIDAS SUBISTITUINDO TODAS AS
									// LETRAS POR ?;
		PE2 = new String[3];
		for (int i = 0; i < 3; i++) {
			String palavra = PE[i];
			PE2[i] = "";
			for (int k = 0; k < palavra.length(); k++) {
				PE2[i] += "?";
			}
		}
	}

	public static void Tela(String v[]) {// <-- MOSTRA A "TELA" DO JOGO ATRAVÃ‰S DE UM jOPTIONPANE FORMATADO;

		while (A) {
			String s = "";
			for (int i = 0; i < v.length; i++) {
				s += String.format("[%s]", v[i]);
			}
			s += String.format("\n\n");
			String gg = letrasEscolhidas.length() < 15 ? letrasEscolhidas
					: letrasEscolhidas.substring(0, 15) + "\n"
							+ letrasEscolhidas.substring(15, letrasEscolhidas.length());
			ld0 = JOptionPane.showInputDialog("O tÃ³pico Ã©: " + topico + "\n" + s
					+ "\nDigite uma letra, ainda nÃ£o escolhida" + "\n" + "Foi Digitado as letras: " + gg + "\n"
					+ "vocÃª tem" + vidas + " vidas" + "\n" + "falta " + npren + " espaÃ§os para serem preenchidos");
			ld0 = ld0.toLowerCase();
			String ps = ld0;
			char escolheu = ps.charAt(0);
			while (letrasEscolhidas.contains(escolheu + "") || escolheu < 'a' || escolheu > 'z') {
				gg = letrasEscolhidas.length() < 15 ? letrasEscolhidas
						: letrasEscolhidas.substring(0, 15) + "\n"
								+ letrasEscolhidas.substring(15, letrasEscolhidas.length());

				ld0 = JOptionPane
						.showInputDialog("O tÃ³pico Ã©: " + topico + "\n" + s + "\nDigite uma letra, ainda nÃ£o escolhida"
								+ "\n" + "\n" + "Foi Digitado as letras: " + gg + "\n" + "vocÃª tem" + vidas + " vidas"
								+ "\n" + "falta: " + npren + " espaÃ§os para serem prenchidos");

				ld0 = ld0.toLowerCase();
				ps = ld0;
				escolheu = ps.charAt(0);
			}
			letrasEscolhidas += escolheu;
			
			acertos = 0;
			char ld = ld0.charAt(0);
			for (int c = 0; c < PE.length; c++) {// substituiÃ§Ã£o de ? pelo char digitado onde houver no vetor PE;
				String palavra = PE[c];

				for (int c2 = 0; c2 < palavra.length(); c2++) {

					char letra = palavra.charAt(c2);
					if (letra == ld) {// se na posiÃ§Ã£o houver a letra digitada, ela sera colocada na mesma posiÃ§Ã£o no vetor PE2;
						char PassandoParaVetorDeCaracter[] = PE2[c].toCharArray();
						PassandoParaVetorDeCaracter[c2] = letra;
						String PalavraAlxiliar = new String(PassandoParaVetorDeCaracter);
						v[c] = PalavraAlxiliar;
						acertos = acertos + 1;// a variavel acertos indica quantas vezes a palavra digitada apareceu no vetor PE;

					}

				}

			}
			if (acertos == 0) {// se nÃ£o houver aparecido nehuma vez o jogador perde uma vida;
				vidas = vidas - 1;

			}

			if (vidas == 0) {// se vidas chegar a 0; o jogador perde;
				s = "";
				for (int i = 0; i < v.length; i++) {
					s += String.format("[%s]", PE[i]);

				}
				JOptionPane.showInputDialog(
						"PERDEU!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\nAs palavras eram: "
								+ s);
				A = false;

			}

			if (npren <= 3) {// verifica se a quant de espaÃ§os n preenchidos e menor que 3;
				palavra1 = JOptionPane.showInputDialog(s + "ME DIGA A PRIMEIRA PALAVRA");
				palavra2 = JOptionPane.showInputDialog(s + "ME DIGA A SEGUNDA PALAVRA");
				palavra3 = JOptionPane.showInputDialog(s + "ME DIGA A PRIMEIRA PALAVRA");
				if (palavra1.equals(PE[0]) && palavra2.equals(PE[1]) && palavra3.equals(PE[2])) {
					JOptionPane.showInputDialog("VOCÃŠ GANHOU!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
							+ "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					A = false;
				} else {
					s = "";
					for (int i = 0; i < v.length; i++) {
						s += String.format("[%s]", PE[i]);

					}
					JOptionPane.showInputDialog(
							"ERROU!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\nAS palavras eram:" + s);
					A = false;
				}
			}
			npren = 0;
			for (int c = 0; c < v.length; c++) {
				String palavra = v[c];
				char[] a = palavra.toCharArray();
				for (int c2 = 0; c2 < a.length; c2++) {
					if (a[c2] == '?') {
						npren++;
					}
				}

			}
		}
	}
}