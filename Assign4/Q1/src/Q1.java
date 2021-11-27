import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Q1 {


    public static class Book {

        Book(String name, long isbn, long barcode)
        {
            this.name = name;
            this.isbn = isbn;
            this.barcode = barcode;
        }

        private final String name;
        private final long isbn;
        private final long barcode;

        public String getName()
        {
            return this.name;
        }

        public long getIsbn()
        {
            return this.isbn;
        }

        public long getBarcode()
        {
            return this.barcode;
        }

    }



//    class SortbyIsbn implements Comparator<Book> {
//
//        public int compare(Book a, Book b)
//        {
//            return ((a.isbn - b.isbn) > 0);
//        }
//    }

    static class BookComparator implements Comparator<Book> {

        public int compare(Book a, Book b)
        {
            if(a.getName().compareTo(b.getName())>0)
                return 1;
            else if (a.getName().compareTo(b.getName())<0)
                return -1;
            else {

                if(a.getIsbn() > b.getIsbn())
                    return 1;
                else if(a.getIsbn() < b.getIsbn())
                    return -1;

                else{
                    if(a.getBarcode() > b.getBarcode())
                        return 1;
                    else
                        return -1;
                }

            }

        }
    }

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<ArrayList<Book>> racks = new ArrayList<>();
    public static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args)
    {
        System.out.println("Enter the number of racks");
        int k = sc.nextInt();

        System.out.println("Enter the total number of books (must be divisible by number of racks)");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++)
        {
            String name;
            long barcode, isbn;

            System.out.println("Enter the name of the book");
            name = sc.next();
            System.out.println("Enter the ISBN of the book");
            isbn = sc.nextInt();
            System.out.println("Enter the barcode of the book");
            barcode = sc.nextInt();

            Book b = new Book(name, isbn, barcode);
            books.add(b);
        }

        // sorting the books
        books.sort(new BookComparator());

        int bookNo = 0;
        for(int i =0; i < k; i++) {
            racks.add(new ArrayList<>());
            for (int j = 0; j < n / k; j++) {
                racks.get(i).add(books.get(bookNo));
                bookNo++;
            }
        }


        //printing the final result
        System.out.println("arranged books are:\n");

        for(int i = 0; i < k; i++)
        {
            System.out.println("rack " + (i+1) + " : ");
            for(int j = 0; j < racks.get(i).size(); j++)
            {
                System.out.println("Name : " + racks.get(i).get(j).getName());
                System.out.println("ISBN : " + racks.get(i).get(j).getIsbn());
                System.out.println("Barcode : " + racks.get(i).get(j).getBarcode());
                System.out.println("\n");
            }
            System.out.println("\n\n");
        }

    }
}
