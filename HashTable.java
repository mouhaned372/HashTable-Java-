import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HashTable {
    private int tableSize;
    private List<List<String>> table;
    private int count;

    public HashTable(int size) {
        tableSize = size;
        table = new ArrayList<>();
        for (int i = 0; i < tableSize; i++) {
            table.add(new ArrayList<>());
        }
        count = 0;
    }

    public HashTable() {
        //TODO Auto-generated constructor stub
    }

    private int f(String key) {
        int total = 0;
        for (int i = 0; i < key.length(); i++) {
            total = (total * 31 + key.charAt(i)) % tableSize;
        }
        return total;
    }

    public void add(String x) {
        String[] parts = x.split("\\s+");
        String lastWord = parts[parts.length - 1];
        int index = f(lastWord);
        if ( table.get(index).contains(lastWord)){
            System.out.println("already exist " + lastWord);}
            else {
        table.get(index).add(lastWord);
    
        count++;
        System.out.println("added successfully !! " + lastWord);
    }
}

    public void remove(String x) {
        String[] parts = x.split("\\s+");
        String lastWord = parts[parts.length - 1];
        int index = f(lastWord);
        if (table.get(index).remove(lastWord)) {
            count--;
            System.out.println("removed successfully " + lastWord);
        } else {
            System.out.println("Key " + lastWord + " not found");
        }
    }

    public int getSize() {
        return count;
    }

    public boolean contains(String x) {
        String[] parts = x.split("\\s+");
        String key = parts[parts.length - 1];
        int index = f(key);
        if (table.get(index).contains(key)) {
            System.out.println("Key '" + key + "' found");
            return true;
        } else {
            System.out.println("Key '" + key + "' not found");
            return false;
        }
    }

    public void display() {
        System.out.println("The hash table is: ");
        for (int i = 0; i < tableSize; i++) {
            System.out.println(i + ": " + table.get(i));
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "add":
                    hashTable.add(input);
                    break;
                case "remove":
                    hashTable.remove(input);
                    break;
                case "contains":
                    hashTable.contains(input);
                    break;
                case "size":
                    System.out.println("Current size: " + hashTable.getSize());
                    break;
                case "display":
                    hashTable.display();
                    break;
                case "exit":
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
