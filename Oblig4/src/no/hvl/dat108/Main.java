package no.hvl.dat108;


public class Main {

	public static void main(String[] args) {
		
		 
		DeltagerDAO d = new DeltagerDAO();
		
		Deltager de = d.hentDeltager(12345678);
		
		System.out.print(de);

	}

}
