package br.com.caelum.camel;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.new Teste01().start();
		main.new Teste02().start();
		main.new Teste03().start();
		main.new Teste04().start();
	}
	
	class Teste01 extends Thread {
		@Override
		public void run() {
			try {
				TesteCamel01.main(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class Teste02 extends Thread {
		@Override
		public void run() {
			try {
				TesteCamel02.main(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class Teste03 extends Thread {
		@Override
		public void run() {
			try {
				TesteCamel03.main(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class Teste04 extends Thread {
		@Override
		public void run() {
			try {
				TesteCamel04.main(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}