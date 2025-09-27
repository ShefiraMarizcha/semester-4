public abstract class BangunRuang {
    private final String name;

    public BangunRuang(String name) {
        this.name = name;
    }

    public abstract void inputNilai();

    public void luasPermukaan() {
        System.out.println("Menghitung luas permukaan bangun " + name);
    }

    public void volume() {
        System.out.println("Menghitung volume bangun " + name);
    }
}
