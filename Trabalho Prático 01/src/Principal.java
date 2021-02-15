import java.util.Scanner;
import java.text.DecimalFormat;

public class Principal {
	static DecimalFormat decimal = new DecimalFormat("0.0");
	
	// ↓ Função para preencher janeiro de 2020 ↓
	static double[][][] preencheJaneiro2020(double[][][] mes) {
		//Declarações
		
		//Instruções
		mes[2020-2011][0][0]=30;
		mes[2020-2011][0][1]=28;
		mes[2020-2011][0][2]=26;
		mes[2020-2011][0][3]=26;
		mes[2020-2011][0][4]=26.5;
		mes[2020-2011][0][5]=28.5;
		mes[2020-2011][0][6]=28.5;
		mes[2020-2011][0][7]=29;
		mes[2020-2011][0][8]=29;
		mes[2020-2011][0][9]=30;
		mes[2020-2011][0][10]=32;
		mes[2020-2011][0][11]=28;
		mes[2020-2011][0][12]=24.5;
		mes[2020-2011][0][13]=26;
		mes[2020-2011][0][14]=27.5;
		mes[2020-2011][0][15]=30.5;
		mes[2020-2011][0][16]=23;
		mes[2020-2011][0][17]=23;
		mes[2020-2011][0][18]=25;
		mes[2020-2011][0][19]=24;
		mes[2020-2011][0][20]=24.5;
		mes[2020-2011][0][21]=24.5;
		mes[2020-2011][0][22]=24;
		mes[2020-2011][0][23]=24.5;
		mes[2020-2011][0][24]=25;
		mes[2020-2011][0][25]=25;
		mes[2020-2011][0][26]=28;
		mes[2020-2011][0][27]=29.5;
		mes[2020-2011][0][28]=31;
		mes[2020-2011][0][29]=31.5;
		mes[2020-2011][0][30]=29.5;
		
		return mes;
		// Fonte: Site AccuWeather; dados do Rio de Janeiro no mesmo período.
	}
	
	// ↓ Função para imprimir o menu de opções ↓
	static void imprimeMenu() {
		//Declarações
		
		//Instruções
		System.out.println("································");
		System.out.println("1| Entrada de temperaturas");
		System.out.println("2| Temperatura média");
		System.out.println("3| Temperatura mínima");
		System.out.println("4| Temperatura máxima");
		System.out.println("5| Relatório meteorológico");
		System.out.println("6| Encerrar programa");
		System.out.println("································");
	}
	
	// ↓ Função para validar o ano ↓
	static int validaAno(int ano) {
		//Declarações
		
		//Instruções
		Scanner ler = new Scanner(System.in);

		while(ano<2011 || ano > 2020) {
			System.out.println("↓ Digite o ano novamente: ↓");
			System.out.println("**NOTA: Informe um valor entre 2011 e 2020");
	        ano=ler.nextInt();
		}
		
		return ano;
	}

	// ↓ Função para validar o mês ↓
	static int validaMes(int mes) {
		//Declarações
		
		//Instruções
		Scanner ler = new Scanner(System.in);

		while(mes<1 || mes > 12) {
			System.out.println("↓ Digite o mês novamente: ↓");
			System.out.println("**NOTA: O Calendário Gregoriano possui doze meses, numerados de 1 a 12");
	        mes=ler.nextInt();
		}
		
		return mes;
	}
	
	// ↓ Função para verificar se um ano é bissexto ↓
	static boolean verificaBissexto(int ano) {
		//Declarações
		boolean bissexto=false;
		
		//Instruções
		if(ano==2012 || ano==2016 || ano==2020) {
			bissexto=true;
		}
		
		return bissexto;
	}
	
	// ↓ Função para ajustar o valor do contador "i" no "for" ↓
	static int ajustaContador(int mes, boolean bissexto) {
		//Declarações
		int i=0;
		
		//Instruções
		if(mes==4 || mes==6 || mes==9 || mes==11) {			// Como os meses possuem o mesmo tamanho no meu vetor
			i=1;											//  fiz essa função para controlar o valor inicial do
		}													//  contador.
		else {
			if(mes==2 && bissexto) {						// Nos meses com menos de 31 dias o vetor terá um intervalo
				i=2;										//  no começo que não receberá valor (de 1-3 posições, dependendo
			}												//  do mes). Isso não afetará o resultado dos cáulculos, visto que
			else {											//  as posições vazias não serão consideradas
				if(mes==2) {
					i=3;
				}
			}
		}
		
		return i;
	}

	// ↓ Função para guardar os valores da temperatura inseridos pelo usuário ↓
	static double guardaTemperatura() {
		//Declarações
		double temperatura;
		
		//Instruções
		Scanner ler = new Scanner(System.in);

		System.out.println("Entre com o valor da temperatura:");
        temperatura=ler.nextDouble();
        
		return temperatura;
	}
	
	// ↓ Função para calcular a média das temperaturas do mês ↓
	static void calculaMedia(double[][][] mes, int anoEscolha, int mesEscolha) {
		//Declarações
		int divisor=0;
		double soma=0;
		boolean bissexto;
		
		//Instruções
		bissexto=verificaBissexto(anoEscolha);

		for(int i = ajustaContador(mesEscolha, bissexto); i<31; i++) {
			soma=soma+mes[anoEscolha-2011][mesEscolha-1][i];
			divisor++;
		}
		
		System.out.println("Temperatura média do mês:\n" + decimal.format(soma/divisor) + "ºC");
	}
	
	// ↓ Função para encontrar a menor temperatura do mês ↓
	static void encontraMinima(double[][][] mes, int anoEscolha, int mesEscolha, boolean imprime) {
		//Declarações
		int dia=1;
		double minima;
		boolean bissexto;
		
		//Instruções
		bissexto=verificaBissexto(anoEscolha);

		minima=mes[anoEscolha-2011][mesEscolha-1][ajustaContador(mesEscolha, bissexto)];

		for(int i = ajustaContador(mesEscolha, bissexto) + 1; i<31; i++) {
			if(minima>mes[anoEscolha-2011][mesEscolha-1][i]) {
				minima=mes[anoEscolha-2011][mesEscolha-1][i];
			}
		}
		
		System.out.println("Temperatura mínima do mês:\n" + decimal.format(minima) + "ºC");

		if(imprime) {																	// A variável "imprime" serve para identificar de onde a função
			System.out.println("Ocorreu em:");											// está sendo chamada. Se for da "main" eu preciso imprimir mais
			for(int i = ajustaContador(mesEscolha, bissexto); i<31; i++) {				// essa informação, diferentemente da função "geraRelatorio". Fiz
				if(minima==mes[anoEscolha-2011][mesEscolha-1][i]) {						// isso para poder reaproveitar essa função nos dois casos
					System.out.println(dia + "/" + mesEscolha + "/" + anoEscolha);
				}																		// **O mesmo vale para a função "encontraMaxima"**
				dia++;	// ← Por conta da diferença já mencionada
			}			// no contador "i" eu criei esse contador
		}				// "dia", que conta o dia do mês correto
	}

	// ↓ Função para encontrar a maior temperatura do mês ↓
	static void encontraMaxima(double[][][] mes, int anoEscolha, int mesEscolha, boolean imprime) {
		//Declarações
		int dia=1;
		double maxima;
		boolean bissexto;
		
		//Instruções
		bissexto=verificaBissexto(anoEscolha);

		maxima=mes[anoEscolha-2011][mesEscolha-1][ajustaContador(mesEscolha, bissexto)];
		
		for(int i = ajustaContador(mesEscolha, bissexto) + 1; i<31; i++) {
			if(maxima<mes[anoEscolha-2011][mesEscolha-1][i]) {
				maxima=mes[anoEscolha-2011][mesEscolha-1][i];
			}
		}
		
		System.out.println("Temperatura máxima do mês:\n" + decimal.format(maxima) + "ºC");

		if(imprime) {
			System.out.println("Ocorreu em:");
			for(int i = ajustaContador(mesEscolha, bissexto); i<31; i++) {
				if(maxima==mes[anoEscolha-2011][mesEscolha-1][i]) {
					System.out.println(dia + "/" + mesEscolha + "/" + anoEscolha);
				}
				dia++;
			}
		}		
	}
	
	// ↓ Função para gerar o reltório ↓
	static void geraRelatorio(double[][][] mes) {
		//Declarações
		int anoEscolha, mesEscolha, dia=1;
		boolean bissexto, imprime=false;			// ← A variável imprime aqui está definida como falso e não será alterada
		
		//Instruções
		Scanner ler = new Scanner(System.in);

		System.out.println("Informe o ano:");
		anoEscolha=ler.nextInt();
		anoEscolha=validaAno(anoEscolha);

		System.out.println("Informe o número do mês:");
		mesEscolha=ler.nextInt();
		mesEscolha=validaMes(mesEscolha);

		bissexto=verificaBissexto(anoEscolha);
																			// São quatro informações que eu imprimo a partir daqui:
		System.out.println("Média diária das temperaturas: ");				// a média diária, a média mensal, a mínima e a máxima
		for(int i = ajustaContador(mesEscolha, bissexto); i<31; i++) {
			System.out.println(dia + "/" + mesEscolha + "/" + anoEscolha + " = " +decimal.format(mes[anoEscolha-2011][mesEscolha-1][i]) + "ºC");
			
			dia++;
		}
		
		calculaMedia(mes, anoEscolha, mesEscolha);

		encontraMinima(mes, anoEscolha, mesEscolha, imprime);
		
		encontraMaxima(mes, anoEscolha, mesEscolha, imprime);
	}

	// ↓ Função para imprimir a mensagem de fim de execução ↓
	static void finalizaPrograma() {
		//Declarações
		
		//Instruções
		System.out.println("\n"
				+ "  ___ _       ___      ___                     /\\/|    \n"
				+ " | __(_)_ __ |   \\ ___| __|_ _____ __ _  _ __ |/\\/ ___ \n"
				+ " | _|| | '  \\| |) / -_) _|\\ \\ / -_) _| || / _/ _` / _ \\\n"
				+ " |_| |_|_|_|_|___/\\___|___/_\\_\\___\\__|\\_,_\\__\\__,_\\___/\n"
				+ "                                           )_)         \n"
				+ "");
	}

	// ↓ Função principal ↓
	public static void main(String[] args) {
		//Declarações
		double [][][] mes = new double [10][12][31];
		int opcao, anoEscolha, mesEscolha;
		boolean bissexto, imprime=true;				// ← A variável imprime aqui está definida como verdadeiro e não será alterada

		//Instruções
		imprimeMenu();
		mes=preencheJaneiro2020(mes);
		
		Scanner ler = new Scanner(System.in);
        
		System.out.println("Entre com a opção do menu:");
        opcao=ler.nextInt();
        
        while(opcao!=6) {
        	switch(opcao) {
        	case 1:
        		System.out.println("Informe o ano:");
        		anoEscolha=ler.nextInt();
        		anoEscolha=validaAno(anoEscolha);

        		System.out.println("Informe o número do mês:");
        		mesEscolha=ler.nextInt();
        		mesEscolha=validaMes(mesEscolha);
                
        		bissexto=verificaBissexto(anoEscolha);
        		
        		for(int i = ajustaContador(mesEscolha, bissexto); i<31; i++) {
        			mes[anoEscolha-2011][mesEscolha-1][i]=guardaTemperatura();		// Os valores informados no mês poderão ser sobrescritos
        		}
        		
        		break;
        	case 2:
        		System.out.println("Informe o ano:");
        		anoEscolha=ler.nextInt();
        		anoEscolha=validaAno(anoEscolha);

        		System.out.println("Informe o número do mês:");
        		mesEscolha=ler.nextInt();
        		mesEscolha=validaMes(mesEscolha);

        		calculaMedia(mes, anoEscolha, mesEscolha);
        		break;
        	case 3:
        		System.out.println("Informe o ano:");
        		anoEscolha=ler.nextInt();
        		anoEscolha=validaAno(anoEscolha);

        		System.out.println("Informe o número do mês:");
        		mesEscolha=ler.nextInt();
        		mesEscolha=validaMes(mesEscolha);

        		encontraMinima(mes, anoEscolha, mesEscolha, imprime);
        		break;
        	case 4:
        		System.out.println("Informe o ano:");
        		anoEscolha=ler.nextInt();
        		anoEscolha=validaAno(anoEscolha);

        		System.out.println("Informe o número do mês:");
        		mesEscolha=ler.nextInt();
        		mesEscolha=validaMes(mesEscolha);

        		encontraMaxima(mes, anoEscolha, mesEscolha, imprime);
        		break;
        	case 5:
        		geraRelatorio(mes);
        		break;
        	case 6:
        		break;
        	default:
        		System.out.println("Opção inválida");
        		break;
        	}
        	
    		imprimeMenu();

        	System.out.println("Entre com a opção do menu:");
            opcao=ler.nextInt();
        }

		finalizaPrograma();
	}
}
