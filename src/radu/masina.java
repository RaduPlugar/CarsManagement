package radu;

public class masina {

	private String marca;
	private String culoare;
	private int an;
	private int pret;
	
    public masina(String m,String c,int a,int p){
    	marca=m;
    	culoare=c;
    	an=a;
    	pret=p;
    }
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCuloare() {
		return culoare;
	}
	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}
	public int getAn() {
		return an;
	}
	public void setAn(int an) {
		this.an = an;
	}
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	
}
