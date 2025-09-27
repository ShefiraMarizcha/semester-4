

class Container<T> {
    private T content; // Properti nyimpan nilai generik

    // Method buat nyimpan nilai ke content
    public void setContent(T content) {
        this.content = content;
    }

    // Method untuk ngambil atau namngkap nilai dari content
    public T getContent() {
        return content;
    }
}

// untuk menjalankan program
class Main {
    public static void main(String[] args) {
        // Membuat instance Container dengan tipe Integer
        Container<Integer> numberContainer = new Container<>();
        numberContainer.setContent(23);
        int number = numberContainer.getContent();
        System.out.println("Integer value: " + number);

        // Membuat instance Container dengan tipe String
        Container<String> textContainer = new Container<>();
        textContainer.setContent("Hello Semester 4!");
        String message = textContainer.getContent();
        System.out.println("String value: " + message);
    }
}
